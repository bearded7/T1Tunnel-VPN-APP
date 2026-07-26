# Gson uses reflection to (de)serialize the Map<String, Any> tweaks payload in
# TweakManager/MainActivity - without keep rules R8 can strip/rename the fields
# it relies on and break import/export in release builds.
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keep class com.t1tunnel.servers.Server { *; }
-keep class com.t1tunnel.base.ProtocolConfig { *; }

# JNI: keep the native bridge so R8 doesn't rename methods that libtun2socks.so calls into
-keep class com.t1tunnel.Tun2Socks { *; }

# gomobile-generated Xray bindings - keep everything since native/reflection code calls in
-keep class com.t1tunnel.xray.** { *; }

# WireGuard's tunnel library also uses JNI internally
-keep class com.wireguard.** { *; }

# ics-openvpn AIDL interop (OpenVpnBridge binds to the installed companion app's service;
# Parcelable.CREATOR lookup happens by reflection and the generated Stub/Proxy classes are
# invoked across process boundaries by name)
-keep class de.blinkt.openvpn.api.** { *; }
