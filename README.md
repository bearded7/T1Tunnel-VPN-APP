# T1Tunnel VPN – Torit‑Inspired, Multi‑Protocol Stealth VPN

* VLESS+Reality (XTLS), WireGuard, OpenVPN UDP/TCP, IKEv2
* 8 tunnel modes (Direct, HTTP Connect, TLS, WS, etc.)
* DNS & HTTP injection, 50 fast servers
* **Encrypted tweak import/export** (AES‑GCM)
* **Encrypted bug‑host/port storage**
* Edge‑triggered tun2socks for zero lag
* Bypasses ISP/OMN firewalls, supports betting sites & torrents

## Build
1. Run `scripts/generate_keys.sh` and update `app/src/main/assets/config.json`
2. Run `scripts/build_xray.sh` to compile libv2ray.so → `app/libs/xray.aar`
3. `./gradlew assembleDebug` → APK at `app/build/outputs/apk/debug/app-debug.apk`
