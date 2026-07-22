package com.reactnativekeyboardcontroller.views;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController;
import com.reactnativekeyboardcontroller.interactive.interpolators.Interpolator;
import com.reactnativekeyboardcontroller.interactive.interpolators.LinearInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: KeyboardGestureAreaReactViewGroup.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\u0018\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\fH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/KeyboardGestureAreaReactViewGroup;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "isHandling", "", "lastTouchX", "", "lastTouchY", "lastWindowY", "", "keyboardHeight", "offset", "interpolator", "Lcom/reactnativekeyboardcontroller/interactive/interpolators/Interpolator;", "scrollKeyboardOnScreenWhenNotVisible", "scrollKeyboardOffScreenWhenVisible", "bounds", "Landroid/graphics/Rect;", "controller", "Lcom/reactnativekeyboardcontroller/interactive/KeyboardAnimationController;", "velocityTracker", "Landroid/view/VelocityTracker;", "dispatchTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setOffset", "", "", "setInterpolator", "", "setScrollKeyboardOnScreenWhenNotVisible", "scrollImeOnScreenWhenNotVisible", "setScrollKeyboardOffScreenWhenVisible", "scrollImeOffScreenWhenVisible", "onActionDown", "onActionMove", "onActionUp", "onActionCancel", "reset", "shouldStartRequest", "dy", "imeVisible", "getWindowHeight", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardGestureAreaReactViewGroup extends ReactViewGroup {
    private static final int VELOCITY_UNITS = 500;
    private final Rect bounds;
    private final KeyboardAnimationController controller;
    private Interpolator interpolator;
    private boolean isHandling;
    private int keyboardHeight;
    private float lastTouchX;
    private float lastTouchY;
    private int lastWindowY;
    private int offset;
    private final ThemedReactContext reactContext;
    private boolean scrollKeyboardOffScreenWhenVisible;
    private boolean scrollKeyboardOnScreenWhenNotVisible;
    private VelocityTracker velocityTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardGestureAreaReactViewGroup(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.interpolator = new LinearInterpolator();
        this.scrollKeyboardOffScreenWhenVisible = true;
        this.bounds = new Rect();
        this.controller = new KeyboardAnimationController();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            onActionDown(event);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            onActionMove(event);
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            onActionUp(event);
        } else if (numValueOf != null && numValueOf.intValue() == 3) {
            onActionCancel();
        }
        return super.dispatchTouchEvent(event);
    }

    public final void setOffset(double offset) {
        this.offset = (int) FloatKt.getPx((float) offset);
    }

    public final void setInterpolator(String interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        LinearInterpolator linearInterpolator = KeyboardGestureAreaReactViewGroupKt.getInterpolators().get(interpolator);
        if (linearInterpolator == null) {
            linearInterpolator = new LinearInterpolator();
        }
        this.interpolator = linearInterpolator;
    }

    public final void setScrollKeyboardOnScreenWhenNotVisible(boolean scrollImeOnScreenWhenNotVisible) {
        this.scrollKeyboardOnScreenWhenNotVisible = scrollImeOnScreenWhenNotVisible;
    }

    public final void setScrollKeyboardOffScreenWhenVisible(boolean scrollImeOffScreenWhenVisible) {
        this.scrollKeyboardOffScreenWhenVisible = scrollImeOffScreenWhenVisible;
    }

    private final void onActionDown(MotionEvent event) {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        this.lastTouchX = event.getX();
        this.lastTouchY = event.getY();
        ViewKt.copyBoundsInWindow(this, this.bounds);
        this.lastWindowY = this.bounds.top;
    }

    private final void onActionMove(MotionEvent event) {
        KeyboardGestureAreaReactViewGroup keyboardGestureAreaReactViewGroup = this;
        ViewKt.copyBoundsInWindow(keyboardGestureAreaReactViewGroup, this.bounds);
        int i = this.bounds.top - this.lastWindowY;
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        motionEventObtain.offsetLocation(0.0f, i);
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEventObtain);
        }
        float x = motionEventObtain.getX() - this.lastTouchX;
        float y = motionEventObtain.getY() - this.lastTouchY;
        if (!this.isHandling) {
            this.isHandling = Math.abs(y) > Math.abs(x) && Math.abs(y) >= ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
        }
        if (this.isHandling) {
            if (this.controller.isInsetAnimationInProgress()) {
                if (this.keyboardHeight == 0) {
                    this.keyboardHeight = this.controller.getCurrentKeyboardHeight();
                }
                int iInterpolate = this.interpolator.interpolate(MathKt.roundToInt(y), getWindowHeight() - ((int) event.getRawY()), this.controller.getCurrentKeyboardHeight(), this.offset);
                if (iInterpolate != 0) {
                    this.controller.insetBy(iInterpolate);
                }
            } else if (!this.controller.isInsetAnimationRequestPending()) {
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(keyboardGestureAreaReactViewGroup);
                if (shouldStartRequest(y, rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime()))) {
                    KeyboardAnimationController.startControlRequest$default(this.controller, keyboardGestureAreaReactViewGroup, null, 2, null);
                }
            }
            this.lastTouchY = event.getY();
            this.lastTouchX = event.getX();
            this.lastWindowY = this.bounds.top;
        }
    }

    private final void onActionUp(MotionEvent event) {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.computeCurrentVelocity(VELOCITY_UNITS);
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        this.controller.animateToFinish((this.controller.isInsetAnimationInProgress() && this.keyboardHeight == this.controller.getCurrentKeyboardHeight()) ? null : velocityTracker3 != null ? Float.valueOf(velocityTracker3.getYVelocity()) : null);
        reset();
    }

    private final void onActionCancel() {
        this.controller.cancel();
        reset();
    }

    private final void reset() {
        this.isHandling = false;
        this.lastTouchX = 0.0f;
        this.lastTouchY = 0.0f;
        this.lastWindowY = 0;
        this.keyboardHeight = 0;
        this.bounds.setEmpty();
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
    }

    private final boolean shouldStartRequest(float dy, boolean imeVisible) {
        if (dy < 0.0f) {
            return !imeVisible && this.scrollKeyboardOnScreenWhenNotVisible;
        }
        return dy > 0.0f && imeVisible && this.scrollKeyboardOffScreenWhenVisible;
    }

    private final int getWindowHeight() {
        Rect bounds;
        WindowManager windowManager;
        Activity currentActivity = this.reactContext.getCurrentActivity();
        WindowMetrics currentWindowMetrics = (currentActivity == null || (windowManager = currentActivity.getWindowManager()) == null) ? null : windowManager.getCurrentWindowMetrics();
        if (currentWindowMetrics == null || (bounds = currentWindowMetrics.getBounds()) == null) {
            return 0;
        }
        return bounds.height();
    }
}
