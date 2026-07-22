package com.facebook.react.bridge;

import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: BridgeSoLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007R \u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/bridge/BridgeSoLoader;", "", "<init>", "()V", "staticInit", "", "value", "", "initialized", "isInitialized", "()Z", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BridgeSoLoader {
    public static final BridgeSoLoader INSTANCE = new BridgeSoLoader();
    private static boolean initialized;

    private BridgeSoLoader() {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture$default("BridgeSoLoader", null, 2, null);
    }

    @JvmStatic
    public static final synchronized void staticInit() {
        if (initialized) {
            return;
        }
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
        SoLoader.loadLibrary("reactnativejni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
        initialized = true;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return initialized;
    }
}
