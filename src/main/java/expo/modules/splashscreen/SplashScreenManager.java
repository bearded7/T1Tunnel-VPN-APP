package expo.modules.splashscreen;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.window.SplashScreenView;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.splashscreen.SplashScreenViewProvider;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplashScreenManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenManager;", "", "<init>", "()V", "keepSplashScreenOnScreen", "", "preventAutoHideCalled", "getPreventAutoHideCalled", "()Z", "setPreventAutoHideCalled", "(Z)V", "splashScreen", "Landroidx/core/splashscreen/SplashScreen;", "contentAppearedListener", "Lcom/facebook/react/bridge/ReactMarker$MarkerListener;", "configureSplashScreen", "", "options", "Lexpo/modules/splashscreen/SplashScreenOptions;", "registerOnActivity", "activity", "Landroid/app/Activity;", "hide", "setSplashScreenOptions", "unregisterContentAppearedListener", "expo-splash-screen_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SplashScreenManager {
    private static boolean preventAutoHideCalled;
    private static SplashScreen splashScreen;
    public static final SplashScreenManager INSTANCE = new SplashScreenManager();
    private static boolean keepSplashScreenOnScreen = true;
    private static final ReactMarker.MarkerListener contentAppearedListener = new ReactMarker.MarkerListener() { // from class: expo.modules.splashscreen.SplashScreenManager$$ExternalSyntheticLambda1
        @Override // com.facebook.react.bridge.ReactMarker.MarkerListener
        public final void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
            SplashScreenManager.contentAppearedListener$lambda$0(reactMarkerConstants, str, i);
        }
    };

    private SplashScreenManager() {
    }

    public final boolean getPreventAutoHideCalled() {
        return preventAutoHideCalled;
    }

    public final void setPreventAutoHideCalled(boolean z) {
        preventAutoHideCalled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentAppearedListener$lambda$0(ReactMarkerConstants name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name == ReactMarkerConstants.CONTENT_APPEARED) {
            SplashScreenManager splashScreenManager = INSTANCE;
            if (preventAutoHideCalled) {
                return;
            }
            splashScreenManager.hide();
        }
    }

    static /* synthetic */ void configureSplashScreen$default(SplashScreenManager splashScreenManager, SplashScreenOptions splashScreenOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            splashScreenOptions = new SplashScreenOptions();
        }
        splashScreenManager.configureSplashScreen(splashScreenOptions);
    }

    private final void configureSplashScreen(SplashScreenOptions options) {
        if (splashScreen == null) {
            return;
        }
        final long duration = options.getDuration();
        SplashScreen splashScreen2 = splashScreen;
        if (splashScreen2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashScreen");
            splashScreen2 = null;
        }
        splashScreen2.setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() { // from class: expo.modules.splashscreen.SplashScreenManager$$ExternalSyntheticLambda0
            @Override // androidx.core.splashscreen.SplashScreen.OnExitAnimationListener
            public final void onSplashScreenExit(SplashScreenViewProvider splashScreenViewProvider) {
                SplashScreenManager.configureSplashScreen$lambda$2(duration, splashScreenViewProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureSplashScreen$lambda$2(long j, final SplashScreenViewProvider splashScreenViewProvider) {
        Intrinsics.checkNotNullParameter(splashScreenViewProvider, "splashScreenViewProvider");
        final View view = splashScreenViewProvider.getView();
        view.animate().setDuration(j).alpha(0.0f).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: expo.modules.splashscreen.SplashScreenManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SplashScreenManager.configureSplashScreen$lambda$2$lambda$1(splashScreenViewProvider, view);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureSplashScreen$lambda$2$lambda$1(SplashScreenViewProvider splashScreenViewProvider, View view) {
        if (Build.VERSION.SDK_INT < 31) {
            splashScreenViewProvider.remove();
        } else {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.window.SplashScreenView");
            ((SplashScreenView) view).remove();
        }
    }

    public final void registerOnActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        splashScreen = SplashScreen.INSTANCE.installSplashScreen(activity);
        ReactMarker.addListener(contentAppearedListener);
        final View viewFindViewById = activity.findViewById(android.R.id.content);
        viewFindViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: expo.modules.splashscreen.SplashScreenManager.registerOnActivity.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (SplashScreenManager.keepSplashScreenOnScreen) {
                    return false;
                }
                viewFindViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        configureSplashScreen$default(this, null, 1, null);
    }

    public final void hide() {
        keepSplashScreenOnScreen = false;
    }

    public final void setSplashScreenOptions(SplashScreenOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        configureSplashScreen(options);
    }

    public final void unregisterContentAppearedListener() {
        ReactMarker.removeListener(contentAppearedListener);
    }
}
