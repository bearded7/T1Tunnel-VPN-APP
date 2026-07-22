package com.swmansion.rnscreens.utils;

import com.facebook.react.views.view.WindowUtilKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: EdgeToEdgeDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/utils/EdgeToEdgeDetector;", "", "<init>", "()V", "ENABLED", "", "getENABLED", "()Z", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgeToEdgeDetector {
    private static final boolean ENABLED;
    public static final EdgeToEdgeDetector INSTANCE = new EdgeToEdgeDetector();

    private EdgeToEdgeDetector() {
    }

    public final boolean getENABLED() {
        return ENABLED;
    }

    static {
        boolean z;
        if (!WindowUtilKt.isEdgeToEdgeFeatureFlagOn()) {
            try {
                Class.forName("com.zoontek.rnedgetoedge.EdgeToEdgePackage");
            } catch (ClassNotFoundException unused) {
                z = false;
            }
        }
        z = true;
        ENABLED = z;
    }
}
