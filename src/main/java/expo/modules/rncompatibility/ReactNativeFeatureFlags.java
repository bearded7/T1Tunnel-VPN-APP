package expo.modules.rncompatibility;

import kotlin.Metadata;

/* JADX INFO: compiled from: ReactNativeFeatureFlags.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/rncompatibility/ReactNativeFeatureFlags;", "", "<init>", "()V", "enableBridgelessArchitecture", "", "getEnableBridgelessArchitecture", "()Z", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeFeatureFlags {
    public static final ReactNativeFeatureFlags INSTANCE = new ReactNativeFeatureFlags();
    private static final boolean enableBridgelessArchitecture = com.facebook.react.internal.featureflags.ReactNativeFeatureFlags.enableBridgelessArchitecture();

    private ReactNativeFeatureFlags() {
    }

    public final boolean getEnableBridgelessArchitecture() {
        return enableBridgelessArchitecture;
    }
}
