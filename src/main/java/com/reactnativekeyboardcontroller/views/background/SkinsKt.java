package com.reactnativekeyboardcontroller.views.background;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativekeyboardcontroller.R;
import com.reactnativekeyboardcontroller.extensions.ContextKt;
import com.reactnativekeyboardcontroller.log.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Skins.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003\u001a\u001c\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\f\u0010\u0010\u001a\u00020\u0003*\u00020\u0011H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\")\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"TAG", "", "MAX_RGB_VALUE", "", "imeColorMap", "", "Lkotlin/Pair;", "getImeColorMap", "()Ljava/util/Map;", "getColorProperties", "Lcom/reactnativekeyboardcontroller/views/background/ColorProperties;", "Landroid/content/Context;", "styleResId", "shiftRgbChannels", ViewProps.COLOR, "shift", "getInputMethodColor", "Lcom/facebook/react/uimanager/ThemedReactContext;", "react-native-keyboard-controller_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SkinsKt {
    private static final int MAX_RGB_VALUE = 255;
    private static final String TAG = "Skins";
    private static final Map<String, Pair<Integer, Integer>> imeColorMap = MapsKt.mapOf(TuplesKt.to(ImePackages.AOSP, TuplesKt.to(Integer.valueOf(R.style.aosp_light), Integer.valueOf(R.style.aosp_light))), TuplesKt.to(ImePackages.GBOARD, TuplesKt.to(Integer.valueOf(R.style.gboard_light), Integer.valueOf(R.style.gboard_dark))), TuplesKt.to(ImePackages.SWIFT_KEY, TuplesKt.to(Integer.valueOf(R.style.swiftkey_light), Integer.valueOf(R.style.swiftkey_dark))), TuplesKt.to(ImePackages.GBOARD_TTS, TuplesKt.to(Integer.valueOf(R.style.gboard_tts_light), Integer.valueOf(R.style.gboard_tts_dark))), TuplesKt.to(ImePackages.GOOGLE_TTS, TuplesKt.to(Integer.valueOf(R.style.gboard_tts_light), Integer.valueOf(R.style.gboard_tts_dark))), TuplesKt.to(ImePackages.YANDEX, TuplesKt.to(Integer.valueOf(R.style.yandex_light), Integer.valueOf(R.style.yandex_dark))), TuplesKt.to(ImePackages.SAMSUNG, TuplesKt.to(Integer.valueOf(R.style.samsung_light), Integer.valueOf(R.style.samsung_dark))));

    public static final Map<String, Pair<Integer, Integer>> getImeColorMap() {
        return imeColorMap;
    }

    public static final ColorProperties getColorProperties(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.ColorProperties);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return new ColorProperties(typedArrayObtainStyledAttributes.getColor(R.styleable.ColorProperties_color, ViewCompat.MEASURED_STATE_MASK), typedArrayObtainStyledAttributes.getInt(R.styleable.ColorProperties_tone, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ int shiftRgbChannels$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 4;
        }
        return shiftRgbChannels(i, i2);
    }

    public static final int shiftRgbChannels(int i, int i2) {
        return Color.argb(Color.alpha(i), RangesKt.coerceIn(Color.red(i) + i2, 0, 255), RangesKt.coerceIn(Color.green(i) + i2, 0, 255), RangesKt.coerceIn(Color.blue(i) + i2, 0, 255));
    }

    public static final int getInputMethodColor(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "<this>");
        ThemedReactContext themedReactContext2 = themedReactContext;
        String strCurrentImePackage = ContextKt.currentImePackage(themedReactContext2);
        boolean zIsSystemDarkMode = ContextKt.isSystemDarkMode(themedReactContext2);
        Logger.i$default(Logger.INSTANCE, TAG, "Current IME: " + strCurrentImePackage, null, 4, null);
        Pair<Integer, Integer> pair = imeColorMap.get(strCurrentImePackage);
        if (pair == null) {
            pair = TuplesKt.to(Integer.valueOf(R.style.gboard_light), Integer.valueOf(R.style.gboard_dark));
        }
        int iIntValue = pair.component1().intValue();
        int iIntValue2 = pair.component2().intValue();
        if (zIsSystemDarkMode && Build.VERSION.SDK_INT > 29) {
            iIntValue = iIntValue2;
        }
        return getColorProperties(themedReactContext2, iIntValue).getBlend();
    }
}
