package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurhashHelpers.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashHelpers;", "", "<init>", "()V", "srgbToLinear", "", "colorEnc", "", "linearTosRGB", "value", "signPow", "exp", "getBitsPerPixel", "bitmap", "Landroid/graphics/Bitmap;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlurhashHelpers {
    public static final BlurhashHelpers INSTANCE = new BlurhashHelpers();

    /* JADX INFO: compiled from: BlurhashHelpers.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Bitmap.Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BlurhashHelpers() {
    }

    public final float srgbToLinear(int colorEnc) {
        float f = colorEnc / 255.0f;
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4f);
    }

    public final int linearTosRGB(float value) {
        double d;
        double dMax = Math.max(0.0f, Math.min(1.0f, value));
        if (dMax <= 0.0031308d) {
            d = 12.92d;
        } else {
            dMax = ((double) ((float) Math.pow(dMax, 0.41666666f))) - 0.055d;
            d = 1.055d;
        }
        return (int) ((dMax * d * ((double) 255)) + 0.5d);
    }

    public final float signPow(float value, float exp) {
        return ((float) Math.pow(Math.abs(value), exp)) * Math.signum(value);
    }

    public final int getBitsPerPixel(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap.Config config = bitmap.getConfig();
        int i = config == null ? -1 : WhenMappings.$EnumSwitchMapping$0[config.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 16;
        }
        if (i != 3) {
            return i != 4 ? 0 : 16;
        }
        return 8;
    }
}
