package com.reactnativekeyboardcontroller.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeViewRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusBarManagerCompatModuleImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0007J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/reactnativekeyboardcontroller/modules/statusbar/StatusBarManagerCompatModuleImpl;", "", "mReactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "original", "Lcom/reactnativekeyboardcontroller/modules/statusbar/StatusBarModuleProxy;", "controller", "Landroidx/core/view/WindowInsetsControllerCompat;", "lastActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "setHidden", "", ViewProps.HIDDEN, "", "setColor", ViewProps.COLOR, "", "animated", "setTranslucent", "translucent", "setStyle", "style", "", "getConstants", "", "getController", "isEnabled", "view", "Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeReactViewGroup;", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StatusBarManagerCompatModuleImpl {
    private static final long DEFAULT_ANIMATION_TIME = 300;
    public static final String NAME = "StatusBarManager";
    private WindowInsetsControllerCompat controller;
    private WeakReference<Activity> lastActivity;
    private final ReactApplicationContext mReactContext;
    private StatusBarModuleProxy original;

    public StatusBarManagerCompatModuleImpl(ReactApplicationContext mReactContext) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.mReactContext = mReactContext;
        this.original = new StatusBarModuleProxy(mReactContext);
        this.lastActivity = new WeakReference<>(null);
    }

    public final void setHidden(final boolean hidden) {
        if (!isEnabled()) {
            this.original.setHidden(hidden);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setHidden$lambda$0(hidden, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHidden$lambda$0(boolean z, StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl) {
        if (z) {
            WindowInsetsControllerCompat controller = statusBarManagerCompatModuleImpl.getController();
            if (controller != null) {
                controller.hide(WindowInsetsCompat.Type.statusBars());
                return;
            }
            return;
        }
        WindowInsetsControllerCompat controller2 = statusBarManagerCompatModuleImpl.getController();
        if (controller2 != null) {
            controller2.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    public final void setColor(final int color, final boolean animated) {
        if (!isEnabled()) {
            this.original.setColor(color, animated);
            return;
        }
        final Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (currentActivity == null) {
            Logger.w$default(Logger.INSTANCE, StatusBarManagerCompatModuleImplKt.TAG, "StatusBarManagerCompatModule: Ignored status bar change, current activity is null.", null, 4, null);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setColor$lambda$2(currentActivity, animated, color);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setColor$lambda$2(Activity activity, boolean z, int i) {
        final Window window = activity.getWindow();
        if (z) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(window.getStatusBarColor()), Integer.valueOf(i));
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StatusBarManagerCompatModuleImpl.setColor$lambda$2$lambda$1(window, valueAnimator);
                }
            });
            valueAnimatorOfObject.setDuration(DEFAULT_ANIMATION_TIME).setStartDelay(0L);
            valueAnimatorOfObject.start();
            return;
        }
        window.setStatusBarColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setColor$lambda$2$lambda$1(Window window, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setStatusBarColor(((Integer) animatedValue).intValue());
    }

    public final void setTranslucent(final boolean translucent) {
        if (!isEnabled()) {
            this.original.setTranslucent(translucent);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setTranslucent$lambda$3(this.f$0, translucent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTranslucent$lambda$3(StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl, boolean z) {
        EdgeToEdgeReactViewGroup edgeToEdgeReactViewGroupView = statusBarManagerCompatModuleImpl.view();
        if (edgeToEdgeReactViewGroupView != null) {
            edgeToEdgeReactViewGroupView.forceStatusBarTranslucent(z);
        }
    }

    public final void setStyle(final String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        if (!isEnabled()) {
            this.original.setStyle(style);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarManagerCompatModuleImpl.setStyle$lambda$4(this.f$0, style);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStyle$lambda$4(StatusBarManagerCompatModuleImpl statusBarManagerCompatModuleImpl, String str) {
        WindowInsetsControllerCompat controller = statusBarManagerCompatModuleImpl.getController();
        if (controller != null) {
            controller.setAppearanceLightStatusBars(Intrinsics.areEqual(str, "dark-content"));
        }
    }

    public final Map<String, Object> getConstants() {
        return this.original.getConstants();
    }

    private final WindowInsetsControllerCompat getController() {
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (this.controller == null || !Intrinsics.areEqual(currentActivity, this.lastActivity.get())) {
            if (currentActivity == null) {
                Logger.w$default(Logger.INSTANCE, StatusBarManagerCompatModuleImplKt.TAG, "StatusBarManagerCompatModule: can not get `WindowInsetsControllerCompat` because current activity is null.", null, 4, null);
                return this.controller;
            }
            Window window = currentActivity.getWindow();
            this.lastActivity = new WeakReference<>(currentActivity);
            this.controller = new WindowInsetsControllerCompat(window, window.getDecorView());
        }
        return this.controller;
    }

    private final boolean isEnabled() {
        EdgeToEdgeReactViewGroup edgeToEdgeReactViewGroupView = view();
        if (edgeToEdgeReactViewGroupView != null) {
            return edgeToEdgeReactViewGroupView.getActive();
        }
        return false;
    }

    private final EdgeToEdgeReactViewGroup view() {
        return EdgeToEdgeViewRegistry.INSTANCE.get();
    }
}
