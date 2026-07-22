package expo.modules.core.utilities;

import android.os.Build;
import androidx.core.os.EnvironmentCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EmulatorUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/core/utilities/EmulatorUtilities;", "", "<init>", "()V", "isRunningOnEmulator", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmulatorUtilities {
    public static final EmulatorUtilities INSTANCE = new EmulatorUtilities();

    private EmulatorUtilities() {
    }

    public final boolean isRunningOnEmulator() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
            return true;
        }
        String FINGERPRINT2 = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
        if (StringsKt.startsWith$default(FINGERPRINT2, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
            return true;
        }
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        if (StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
            return true;
        }
        String MODEL2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = MODEL2.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "droid4x", false, 2, (Object) null)) {
            return true;
        }
        String MODEL3 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
        if (StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "Emulator", false, 2, (Object) null)) {
            return true;
        }
        String MODEL4 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL4, "MODEL");
        if (StringsKt.contains$default((CharSequence) MODEL4, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
            return true;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        if (StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
            return true;
        }
        String HARDWARE = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
        if (StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "goldfish", false, 2, (Object) null)) {
            return true;
        }
        String HARDWARE2 = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE2, "HARDWARE");
        if (StringsKt.contains$default((CharSequence) HARDWARE2, (CharSequence) "ranchu", false, 2, (Object) null)) {
            return true;
        }
        String HARDWARE3 = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE3, "HARDWARE");
        if (StringsKt.contains$default((CharSequence) HARDWARE3, (CharSequence) "vbox86", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "sdk", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT2 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT2, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT2, (CharSequence) "google_sdk", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT3 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT3, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT3, (CharSequence) "sdk_google", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT4 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT4, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT4, (CharSequence) "sdk_x86", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT5 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT5, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT5, (CharSequence) "vbox86p", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT6 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT6, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT6, (CharSequence) "emulator", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT7 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT7, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT7, (CharSequence) "simulator", false, 2, (Object) null)) {
            return true;
        }
        String BOARD = Build.BOARD;
        Intrinsics.checkNotNullExpressionValue(BOARD, "BOARD");
        Locale ROOT2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
        String lowerCase2 = BOARD.toLowerCase(ROOT2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "nox", false, 2, (Object) null)) {
            return true;
        }
        String BOOTLOADER = Build.BOOTLOADER;
        Intrinsics.checkNotNullExpressionValue(BOOTLOADER, "BOOTLOADER");
        Locale ROOT3 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT3, "ROOT");
        String lowerCase3 = BOOTLOADER.toLowerCase(ROOT3);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "nox", false, 2, (Object) null)) {
            return true;
        }
        String HARDWARE4 = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE4, "HARDWARE");
        Locale ROOT4 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT4, "ROOT");
        String lowerCase4 = HARDWARE4.toLowerCase(ROOT4);
        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "nox", false, 2, (Object) null)) {
            return true;
        }
        String PRODUCT8 = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT8, "PRODUCT");
        Locale ROOT5 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT5, "ROOT");
        String lowerCase5 = PRODUCT8.toLowerCase(ROOT5);
        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "nox", false, 2, (Object) null)) {
            return true;
        }
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            if (StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
