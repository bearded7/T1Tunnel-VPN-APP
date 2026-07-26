#ifndef TUN2SOCKS_H
#define TUN2SOCKS_H
#include <stdint.h>
uint16_t csum(uint16_t *addr, int len);
uint32_t csum_partial(const void *buf, int len, uint32_t sum);
uint16_t csum_final(uint32_t sum);
void dns_injector_handle(const uint8_t *packet, int len, int tun_fd);
#endif
