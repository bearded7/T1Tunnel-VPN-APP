package com.swmansion.rnscreens;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewProps;
import com.swmansion.rnscreens.utils.EdgeToEdgeDetector;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenWindowTraits.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0002\b\u001aJ)\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0001¢\u0006\u0002\b\u001eJ)\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b J)\u0010!\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0001¢\u0006\u0002\b\"J\u001f\u0010#\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0002\b$J\u001f\u0010%\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0002\b&J\u001f\u0010'\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0002\b(J\u001f\u0010)\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0002\b*J)\u0010+\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b,J\u001a\u0010-\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002J\u001c\u00101\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00102\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u00065"}, d2 = {"Lcom/swmansion/rnscreens/ScreenWindowTraits;", "", "<init>", "()V", "didSetOrientation", "", "didSetStatusBarAppearance", "didSetNavigationBarAppearance", "defaultStatusBarColor", "", "Ljava/lang/Integer;", "windowInsetsListener", "com/swmansion/rnscreens/ScreenWindowTraits$windowInsetsListener$1", "Lcom/swmansion/rnscreens/ScreenWindowTraits$windowInsetsListener$1;", "applyDidSetOrientation", "", "applyDidSetOrientation$react_native_screens_release", "applyDidSetStatusBarAppearance", "applyDidSetStatusBarAppearance$react_native_screens_release", "applyDidSetNavigationBarAppearance", "applyDidSetNavigationBarAppearance$react_native_screens_release", "setOrientation", "screen", "Lcom/swmansion/rnscreens/Screen;", "activity", "Landroid/app/Activity;", "setOrientation$react_native_screens_release", "setColor", "context", "Lcom/facebook/react/bridge/ReactContext;", "setColor$react_native_screens_release", "setStyle", "setStyle$react_native_screens_release", "setTranslucent", "setTranslucent$react_native_screens_release", "setHidden", "setHidden$react_native_screens_release", "setNavigationBarColor", "setNavigationBarColor$react_native_screens_release", "setNavigationBarTranslucent", "setNavigationBarTranslucent$react_native_screens_release", "setNavigationBarHidden", "setNavigationBarHidden$react_native_screens_release", "trySetWindowTraits", "trySetWindowTraits$react_native_screens_release", "findScreenForTrait", "trait", "Lcom/swmansion/rnscreens/Screen$WindowTraits;", "findParentWithTraitSet", "childScreenWithTraitSet", "checkTraitForScreen", "isColorLight", ViewProps.COLOR, "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenWindowTraits {
    private static Integer defaultStatusBarColor;
    private static boolean didSetNavigationBarAppearance;
    private static boolean didSetOrientation;
    private static boolean didSetStatusBarAppearance;
    public static final ScreenWindowTraits INSTANCE = new ScreenWindowTraits();
    private static ScreenWindowTraits$windowInsetsListener$1 windowInsetsListener = new OnApplyWindowInsetsListener() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$windowInsetsListener$1
        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(insets, "insets");
            WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(v, insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "onApplyWindowInsets(...)");
            if (Build.VERSION.SDK_INT >= 30) {
                Insets insets2 = windowInsetsCompatOnApplyWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars());
                Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
                WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setInsets(WindowInsetsCompat.Type.statusBars(), Insets.of(insets2.left, 0, insets2.right, insets2.bottom)).build();
                Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
                return windowInsetsCompatBuild;
            }
            WindowInsetsCompat windowInsetsCompatReplaceSystemWindowInsets = windowInsetsCompatOnApplyWindowInsets.replaceSystemWindowInsets(windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetLeft(), 0, windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetRight(), windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetBottom());
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatReplaceSystemWindowInsets, "replaceSystemWindowInsets(...)");
            return windowInsetsCompatReplaceSystemWindowInsets;
        }
    };

    /* JADX INFO: compiled from: ScreenWindowTraits.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Screen.WindowTraits.values().length];
            try {
                iArr[Screen.WindowTraits.ORIENTATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Screen.WindowTraits.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Screen.WindowTraits.STYLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Screen.WindowTraits.TRANSLUCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Screen.WindowTraits.HIDDEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Screen.WindowTraits.ANIMATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Screen.WindowTraits.NAVIGATION_BAR_COLOR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Screen.WindowTraits.NAVIGATION_BAR_TRANSLUCENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Screen.WindowTraits.NAVIGATION_BAR_HIDDEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ScreenWindowTraits() {
    }

    public final void applyDidSetOrientation$react_native_screens_release() {
        didSetOrientation = true;
    }

    public final void applyDidSetStatusBarAppearance$react_native_screens_release() {
        didSetStatusBarAppearance = true;
    }

    public final void applyDidSetNavigationBarAppearance$react_native_screens_release() {
        didSetNavigationBarAppearance = true;
    }

    public final void setOrientation$react_native_screens_release(Screen screen, Activity activity) {
        Integer screenOrientation;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.ORIENTATION);
        activity.setRequestedOrientation((screenFindScreenForTrait == null || (screenOrientation = screenFindScreenForTrait.getScreenOrientation()) == null) ? -1 : screenOrientation.intValue());
    }

    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect because edge-to-edge is enabled by default and the status bar is always translucent.")
    public final void setColor$react_native_screens_release(Screen screen, Activity activity, ReactContext context) {
        Integer statusBarColor;
        Boolean isStatusBarAnimated;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || context == null) {
            return;
        }
        if (defaultStatusBarColor == null) {
            defaultStatusBarColor = Integer.valueOf(activity.getWindow().getStatusBarColor());
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.COLOR);
        Screen screenFindScreenForTrait2 = findScreenForTrait(screen, Screen.WindowTraits.ANIMATED);
        if (screenFindScreenForTrait == null || (statusBarColor = screenFindScreenForTrait.getStatusBarColor()) == null) {
            statusBarColor = defaultStatusBarColor;
        }
        UiThreadUtil.runOnUiThread(new ScreenWindowTraits$setColor$1(activity, statusBarColor, (screenFindScreenForTrait2 == null || (isStatusBarAnimated = screenFindScreenForTrait2.getIsStatusBarAnimated()) == null) ? false : isStatusBarAnimated.booleanValue(), context.getExceptionHandler()));
    }

    public final void setStyle$react_native_screens_release(Screen screen, final Activity activity, ReactContext context) {
        final String statusBarStyle;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || context == null) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.STYLE);
        if (screenFindScreenForTrait == null || (statusBarStyle = screenFindScreenForTrait.getStatusBarStyle()) == null) {
            statusBarStyle = "light";
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ScreenWindowTraits.setStyle$lambda$0(activity, statusBarStyle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStyle$lambda$0(Activity activity, String str) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        new WindowInsetsControllerCompat(activity.getWindow(), decorView).setAppearanceLightStatusBars(Intrinsics.areEqual(str, "dark"));
    }

    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect because edge-to-edge is enabled by default and the status bar is always translucent.")
    public final void setTranslucent$react_native_screens_release(Screen screen, final Activity activity, ReactContext context) {
        Boolean isStatusBarTranslucent;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || context == null || EdgeToEdgeDetector.INSTANCE.getENABLED()) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.TRANSLUCENT);
        final boolean zBooleanValue = (screenFindScreenForTrait == null || (isStatusBarTranslucent = screenFindScreenForTrait.getIsStatusBarTranslucent()) == null) ? false : isStatusBarTranslucent.booleanValue();
        final JSExceptionHandler exceptionHandler = context.getExceptionHandler();
        UiThreadUtil.runOnUiThread(new GuardedRunnable(activity, zBooleanValue, exceptionHandler) { // from class: com.swmansion.rnscreens.ScreenWindowTraits$setTranslucent$1
            final /* synthetic */ Activity $activity;
            final /* synthetic */ boolean $translucent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(exceptionHandler);
                Intrinsics.checkNotNull(exceptionHandler);
            }

            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                View decorView = this.$activity.getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                if (!this.$translucent) {
                    InsetsObserverProxy.INSTANCE.removeOnApplyWindowInsetsListener(ScreenWindowTraits.windowInsetsListener);
                } else {
                    InsetsObserverProxy.INSTANCE.registerOnView(decorView);
                    InsetsObserverProxy.INSTANCE.addOnApplyWindowInsetsListener(ScreenWindowTraits.windowInsetsListener);
                }
                ViewCompat.requestApplyInsets(decorView);
            }
        });
    }

    public final void setHidden$react_native_screens_release(Screen screen, Activity activity) {
        Boolean isStatusBarHidden;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.HIDDEN);
        final boolean zBooleanValue = (screenFindScreenForTrait == null || (isStatusBarHidden = screenFindScreenForTrait.getIsStatusBarHidden()) == null) ? false : isStatusBarHidden.booleanValue();
        Window window = activity.getWindow();
        final WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ScreenWindowTraits.setHidden$lambda$1(zBooleanValue, windowInsetsControllerCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHidden$lambda$1(boolean z, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        if (z) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
        } else {
            windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    @Deprecated(message = "For all apps targeting Android SDK 35 or above edge-to-edge is enabled by default. ")
    public final void setNavigationBarColor$react_native_screens_release(Screen screen, Activity activity) {
        Integer navigationBarColor;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        final Window window = activity.getWindow();
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.NAVIGATION_BAR_COLOR);
        final int navigationBarColor2 = (screenFindScreenForTrait == null || (navigationBarColor = screenFindScreenForTrait.getNavigationBarColor()) == null) ? window.getNavigationBarColor() : navigationBarColor.intValue();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ScreenWindowTraits.setNavigationBarColor$lambda$2(window, navigationBarColor2);
            }
        });
        window.setNavigationBarColor(navigationBarColor2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigationBarColor$lambda$2(Window window, int i) {
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(INSTANCE.isColorLight(i));
    }

    @Deprecated(message = "For all apps targeting Android SDK 35 or above edge-to-edge is enabled by default. ")
    public final void setNavigationBarTranslucent$react_native_screens_release(Screen screen, Activity activity) {
        Boolean isNavigationBarTranslucent;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || EdgeToEdgeDetector.INSTANCE.getENABLED()) {
            return;
        }
        Window window = activity.getWindow();
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.NAVIGATION_BAR_TRANSLUCENT);
        if (screenFindScreenForTrait == null || (isNavigationBarTranslucent = screenFindScreenForTrait.getIsNavigationBarTranslucent()) == null) {
            return;
        }
        WindowCompat.setDecorFitsSystemWindows(window, !isNavigationBarTranslucent.booleanValue());
    }

    public final void setNavigationBarHidden$react_native_screens_release(Screen screen, Activity activity) {
        Boolean isNavigationBarHidden;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        Screen screenFindScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.NAVIGATION_BAR_HIDDEN);
        if ((screenFindScreenForTrait == null || (isNavigationBarHidden = screenFindScreenForTrait.getIsNavigationBarHidden()) == null) ? false : isNavigationBarHidden.booleanValue()) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
            return;
        }
        new WindowInsetsControllerCompat(window, window.getDecorView()).show(WindowInsetsCompat.Type.navigationBars());
    }

    public final void trySetWindowTraits$react_native_screens_release(Screen screen, Activity activity, ReactContext context) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (didSetOrientation) {
            setOrientation$react_native_screens_release(screen, activity);
        }
        if (didSetStatusBarAppearance) {
            setColor$react_native_screens_release(screen, activity, context);
            setStyle$react_native_screens_release(screen, activity, context);
            setTranslucent$react_native_screens_release(screen, activity, context);
            setHidden$react_native_screens_release(screen, activity);
        }
        if (didSetNavigationBarAppearance) {
            setNavigationBarColor$react_native_screens_release(screen, activity);
            setNavigationBarTranslucent$react_native_screens_release(screen, activity);
            setNavigationBarHidden$react_native_screens_release(screen, activity);
        }
    }

    private final Screen findScreenForTrait(Screen screen, Screen.WindowTraits trait) {
        Screen screenChildScreenWithTraitSet = childScreenWithTraitSet(screen, trait);
        if (screenChildScreenWithTraitSet != null) {
            return screenChildScreenWithTraitSet;
        }
        return checkTraitForScreen(screen, trait) ? screen : findParentWithTraitSet(screen, trait);
    }

    private final Screen findParentWithTraitSet(Screen screen, Screen.WindowTraits trait) {
        for (ScreenContainer container = screen.getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen2 = (Screen) container;
                if (checkTraitForScreen(screen2, trait)) {
                    return screen2;
                }
            }
        }
        return null;
    }

    private final Screen childScreenWithTraitSet(Screen screen, Screen.WindowTraits trait) {
        ScreenFragmentWrapper fragmentWrapper;
        if (screen == null || (fragmentWrapper = screen.getFragmentWrapper()) == null) {
            return null;
        }
        Iterator<ScreenContainer> it = fragmentWrapper.getChildScreenContainers().iterator();
        while (it.hasNext()) {
            Screen topScreen = it.next().getTopScreen();
            ScreenWindowTraits screenWindowTraits = INSTANCE;
            Screen screenChildScreenWithTraitSet = screenWindowTraits.childScreenWithTraitSet(topScreen, trait);
            if (screenChildScreenWithTraitSet != null) {
                return screenChildScreenWithTraitSet;
            }
            if (topScreen != null && screenWindowTraits.checkTraitForScreen(topScreen, trait)) {
                return topScreen;
            }
        }
        return null;
    }

    private final boolean checkTraitForScreen(Screen screen, Screen.WindowTraits trait) {
        switch (WhenMappings.$EnumSwitchMapping$0[trait.ordinal()]) {
            case 1:
                return screen.getScreenOrientation() != null;
            case 2:
                return screen.getStatusBarColor() != null;
            case 3:
                return screen.getStatusBarStyle() != null;
            case 4:
                return screen.getIsStatusBarTranslucent() != null;
            case 5:
                return screen.getIsStatusBarHidden() != null;
            case 6:
                return screen.getIsStatusBarAnimated() != null;
            case 7:
                return screen.getNavigationBarColor() != null;
            case 8:
                return screen.getIsNavigationBarTranslucent() != null;
            case 9:
                return screen.getIsNavigationBarHidden() != null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean isColorLight(int color) {
        return ((double) 1) - ((((((double) Color.red(color)) * 0.299d) + (((double) Color.green(color)) * 0.587d)) + (((double) Color.blue(color)) * 0.114d)) / ((double) 255)) < 0.5d;
    }
}
