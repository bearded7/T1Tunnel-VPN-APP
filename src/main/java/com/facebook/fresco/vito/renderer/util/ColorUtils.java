package com.facebook.fresco.vito.renderer.util;

import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/facebook/fresco/vito/renderer/util/ColorUtils;", "", "<init>", "()V", "Companion", "renderer_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ColorUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/fresco/vito/renderer/util/ColorUtils$Companion;", "", "<init>", "()V", "multiplyColorAlpha", "", ViewProps.COLOR, "alpha", "renderer_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int multiplyColorAlpha(int color, int alpha) {
            if (alpha == 0) {
                return color & ViewCompat.MEASURED_SIZE_MASK;
            }
            if (alpha == 255) {
                return color;
            }
            return (color & ViewCompat.MEASURED_SIZE_MASK) | ((((color >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24);
        }

        private Companion() {
        }
    }
}
