#include <jni.h>
#include <android/log.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <netinet/tcp.h>
#include <netinet/udp.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <sys/epoll.h>
#include <stdio.h>
#include "tun2socks.h"

#define TAG "tun2socks"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__)
#define MAX_EVENTS 64
#define BUFFER_SIZE 65535

static volatile int running = 0;
static int tun_fd = -1;
static int epoll_fd = -1;
static int mtu = 1350;

/* checksum utilities */
uint16_t csum(uint16_t *addr, int len) {
    uint32_t sum = 0;
    while (len > 1) { sum += *addr++; len -= 2; }
    if (len == 1) sum += *(uint8_t*)addr;
    sum = (sum >> 16) + (sum & 0xFFFF);
    sum += (sum >> 16);
    return (uint16_t)~sum;
}

uint32_t csum_partial(const void *buf, int len, uint32_t sum) {
    const uint16_t *p = (const uint16_t *)buf;
    while (len > 1) { sum += *p++; len -= 2; }
    if (len == 1) sum += *(uint8_t*)p;
    return sum;
}

uint16_t csum_final(uint32_t sum) {
    sum = (sum >> 16) + (sum & 0xFFFF);
    sum += (sum >> 16);
    return (uint16_t)~sum;
}

static int socks5_connect_nonblock(const char *host, int port) {
    int fd = socket(AF_INET, SOCK_STREAM | SOCK_NONBLOCK, 0);
    if (fd < 0) return -1;
    struct sockaddr_in saddr = {0};
    saddr.sin_family = AF_INET;
    saddr.sin_port = htons(port);
    inet_aton(host, &saddr.sin_addr);
    connect(fd, (struct sockaddr*)&saddr, sizeof(saddr));
    return fd;
}

static void relay_data(int src_fd, int dst_fd) {
    char buf[BUFFER_SIZE];
    ssize_t n = read(src_fd, buf, sizeof(buf));
    if (n <= 0) return;
    write(dst_fd, buf, n);
}

static void *tun_loop(void *arg) {
    struct epoll_event ev, events[MAX_EVENTS];
    epoll_fd = epoll_create1(EPOLL_CLOEXEC);
    ev.events = EPOLLIN | EPOLLET;
    ev.data.fd = tun_fd;
    epoll_ctl(epoll_fd, EPOLL_CTL_ADD, tun_fd, &ev);

    while (running) {
        int nfds = epoll_wait(epoll_fd, events, MAX_EVENTS, 500);
        for (int i = 0; i < nfds; i++) {
            int fd = events[i].data.fd;
            if (fd == tun_fd) {
                uint8_t buf[BUFFER_SIZE];
                while (1) {
                    ssize_t len = read(tun_fd, buf, sizeof(buf));
                    if (len <= 0) {
                        if (errno == EAGAIN || errno == EWOULDBLOCK) break;
                        LOGE("tun read error"); break;
                    }
                    struct ip *iph = (struct ip *)buf;
                    if (iph->ip_v != 4) continue;
                    if (iph->ip_p == IPPROTO_UDP) {
                        struct udphdr *udph = (struct udphdr *)(buf + (iph->ip_hl << 2));
                        if (ntohs(udph->uh_dport) == 53) {
                            dns_injector_handle(buf, len, tun_fd);
                        }
                    } else if (iph->ip_p == IPPROTO_TCP) {
                        struct tcphdr *tcph = (struct tcphdr *)(buf + (iph->ip_hl << 2));
                        if (tcph->th_flags & TH_SYN) {
                            int out_fd = socks5_connect_nonblock("127.0.0.1", 10808);
                            if (out_fd >= 0) {
                                ev.events = EPOLLIN | EPOLLOUT | EPOLLET;
                                ev.data.fd = out_fd;
                                epoll_ctl(epoll_fd, EPOLL_CTL_ADD, out_fd, &ev);
                            }
                        }
                    }
                }
            } else {
                if (events[i].events & EPOLLIN) {
                    relay_data(fd, tun_fd);
                }
                if (events[i].events & (EPOLLERR | EPOLLHUP)) {
                    epoll_ctl(epoll_fd, EPOLL_CTL_DEL, fd, NULL);
                    close(fd);
                }
            }
        }
    }
    close(epoll_fd);
    return NULL;
}

JNIEXPORT void JNICALL
Java_com_t1tunnel_Tun2Socks_start(JNIEnv *env, jclass cls, jint vpnFd,
                                  jstring proxyUrl, jint mtu_val) {
    if (running) return;
    tun_fd = dup(vpnFd);
    int flags = fcntl(tun_fd, F_GETFL, 0);
    fcntl(tun_fd, F_SETFL, flags | O_NONBLOCK);
    mtu = mtu_val;
    running = 1;
    pthread_t t;
    pthread_create(&t, NULL, tun_loop, NULL);
    LOGD("tun2socks started (edge-triggered)");
}

JNIEXPORT void JNICALL
Java_com_t1tunnel_Tun2Socks_stop(JNIEnv *env, jclass cls) {
    running = 0;
    if (tun_fd >= 0) { close(tun_fd); tun_fd = -1; }
    LOGD("tun2socks stopped");
}
