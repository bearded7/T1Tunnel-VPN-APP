# T1Tunnel VPN – Torit‑Inspired, Multi‑Protocol Stealth VPN

* VLESS+Reality (XTLS), WireGuard, OpenVPN UDP/TCP, IKEv2
* 8 tunnel modes (Direct, HTTP Connect, TLS, WS, etc.)
* DNS & HTTP injection, 50 fast servers
* **Encrypted tweak import/export** (AES‑GCM)
* **Encrypted bug‑host/port storage**
* Edge‑triggered tun2socks for zero lag
* Bypasses ISP/OMN firewalls, supports betting sites & torrents

## Build (local / Android Studio)

Requirements: Android Studio (Iguana+) with SDK 34 + NDK 26.1.10909125 + CMake 3.22.1
installed via SDK Manager, and Go 1.21+ on your `PATH` for the native Xray build.

1. (Optional) Run `scripts/generate_keys.sh` to generate fresh VLESS+Reality keys into
   `keys/` and update `app/src/main/assets/config.json` with them.
2. Run `scripts/build_xray.sh` — this installs `gomobile`, pulls the `xray-core`
   dependency, and compiles the native Xray engine into `app/libs/xray.aar`
   (arm64-v8a, armeabi-v7a, x86_64). **This step must succeed before Gradle sync**,
   since `app/build.gradle` depends on that AAR file existing.
3. Open the project root in Android Studio and let it sync, or from the command line:
   `./gradlew assembleDebug` → APK at `app/build/outputs/apk/debug/app-debug.apk`

### How each protocol actually tunnels
- **VLESS+Reality** (all 8 tunnel modes): `XrayConfigBuilder` generates a real xray-core JSON
  config per selected mode (Direct/HTTP Connect/Raw TCP/TLS/WS/WS Secure/WS CDN/WS Secure CDN
  → the corresponding Xray `streamSettings`), writes it to `filesDir`, and hands it to the
  native Xray engine built by `scripts/build_xray.sh`. `VlessRealityService` establishes the
  local tun and starts/stops the engine. Fill in a server's `vlessUuid`/`realityPublicKey`/
  `realityShortId` in `ServerManager.kt` (from `keys/reality.env`) before connecting.
- **WireGuard**: `WireGuardService` uses the real `com.wireguard.android:tunnel` library's
  `GoBackend` directly (it manages its own tun device, so this doesn't go through tun2socks).
  Fill in `wgPrivateKey`/`wgServerPublicKey`/(`wgPresharedKey`)/`wgAddress` on the `Server`.
- **OpenVPN UDP/TCP**: driven through the installed **OpenVPN for Android** app's documented
  external-control AIDL API (`OpenVpnBridge.kt`), since `de.blinkt.openvpn:core` isn't a real
  published Maven artifact - ics-openvpn ships as a full app, not an embeddable library. The
  bridge builds/pushes a profile and starts it in the companion app. Requires that app
  installed; first run needs the user to grant this app permission in its Settings.
- **IKEv2**: driven through the official **strongSwan VPN Client** app's documented `.sswan`
  profile import + Intent-based start/stop (`StrongSwanBridge.kt`), for the same reason -
  strongSwan's Android engine isn't a Maven library either. Requires that app installed; the
  first connection needs one tap inside strongSwan to accept the imported profile.

### Known gap: the native tun2socks layer is a minimal stub, not production-grade
`app/src/main/cpp/tun2socks.c` currently opens a raw socket per new TCP flow and relays bytes,
but doesn't do a real SOCKS5 handshake or full IP/TCP packet reassembly - see the comment at
the top of that file. It's fine for basic local testing of the VLESS path, but for anything
you'd actually rely on, swap it for a maintained userspace stack built for this exact purpose,
e.g. [hev-socks5-tunnel](https://github.com/heiher/hev-socks5-tunnel) or go-tun2socks - both
compile to a `.so` you link the same way. This only affects VLESS+Reality; WireGuard and the
OpenVPN/IKEv2 companion-app paths don't route through it at all.

### Other notes
- The debug build type signs with the standard Android debug keystore
  (`~/.android/debug.keystore`, auto-created by Android Studio on first run).

## Build (CI)
See `.github/workflows/build.yml` — pushes/PRs to `main` build a debug APK on
GitHub-hosted runners (which already have the Android SDK preinstalled) and upload
it as a workflow artifact. A `build-release` job is included but disabled by default;
flip its `if: false` to `true` once you've added `RELEASE_KEYSTORE_BASE64`,
`RELEASE_KEYSTORE_PASSWORD`, `RELEASE_KEY_ALIAS`, and `RELEASE_KEY_PASSWORD` as
repo secrets.
