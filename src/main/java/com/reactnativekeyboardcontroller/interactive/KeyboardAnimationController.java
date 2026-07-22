package com.reactnativekeyboardcontroller.interactive;

import android.os.CancellationSignal;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.DynamicAnimationKt;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: KeyboardAnimationController.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011*\u0001\f\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0017\u0010&\u001a\u00020\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u001dJ\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\nH\u0002J!\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010-R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/reactnativekeyboardcontroller/interactive/KeyboardAnimationController;", "", "<init>", "()V", "insetsAnimationController", "Landroidx/core/view/WindowInsetsAnimationControllerCompat;", "pendingRequestCancellationSignal", "Landroid/os/CancellationSignal;", "pendingRequestOnReady", "Lkotlin/Function1;", "", "animationControlListener", "com/reactnativekeyboardcontroller/interactive/KeyboardAnimationController$animationControlListener$2$1", "getAnimationControlListener", "()Lcom/reactnativekeyboardcontroller/interactive/KeyboardAnimationController$animationControlListener$2$1;", "animationControlListener$delegate", "Lkotlin/Lazy;", "isImeShownAtStart", "", "currentSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "startControlRequest", "view", "Landroid/view/View;", "onRequestReady", "startAndFling", "velocityY", "", "insetBy", "", "dy", "insetTo", "inset", "isInsetAnimationInProgress", "isInsetAnimationFinishing", "isInsetAnimationRequestPending", "cancel", "finish", "animateToFinish", "(Ljava/lang/Float;)V", "getCurrentKeyboardHeight", "controller", "reset", "animateImeToVisibility", ViewProps.VISIBLE, "(ZLjava/lang/Float;)V", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardAnimationController {

    /* JADX INFO: renamed from: animationControlListener$delegate, reason: from kotlin metadata */
    private final Lazy animationControlListener = LazyKt.lazy(new Function0() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return KeyboardAnimationController.animationControlListener_delegate$lambda$0(this.f$0);
        }
    });
    private SpringAnimation currentSpringAnimation;
    private WindowInsetsAnimationControllerCompat insetsAnimationController;
    private boolean isImeShownAtStart;
    private CancellationSignal pendingRequestCancellationSignal;
    private Function1<? super WindowInsetsAnimationControllerCompat, Unit> pendingRequestOnReady;

    private final KeyboardAnimationController$animationControlListener$2$1 getAnimationControlListener() {
        return (KeyboardAnimationController$animationControlListener$2$1) this.animationControlListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$animationControlListener$2$1] */
    public static final KeyboardAnimationController$animationControlListener$2$1 animationControlListener_delegate$lambda$0(final KeyboardAnimationController keyboardAnimationController) {
        return new WindowInsetsAnimationControlListenerCompat() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$animationControlListener$2$1
            @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
            public void onReady(WindowInsetsAnimationControllerCompat controller, int types) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                this.this$0.onRequestReady(controller);
            }

            @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
            public void onFinished(WindowInsetsAnimationControllerCompat controller) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                this.this$0.reset();
            }

            @Override // androidx.core.view.WindowInsetsAnimationControlListenerCompat
            public void onCancelled(WindowInsetsAnimationControllerCompat controller) {
                this.this$0.reset();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startControlRequest$default(KeyboardAnimationController keyboardAnimationController, View view, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        keyboardAnimationController.startControlRequest(view, function1);
    }

    public final void startControlRequest(View view, Function1<? super WindowInsetsAnimationControllerCompat, Unit> onRequestReady) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isInsetAnimationInProgress()) {
            throw new IllegalStateException("Animation in progress. Can not start a new request to controlWindowInsetsAnimation()".toString());
        }
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        boolean z = false;
        if (rootWindowInsets != null && rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
            z = true;
        }
        this.isImeShownAtStart = z;
        this.pendingRequestCancellationSignal = new CancellationSignal();
        this.pendingRequestOnReady = onRequestReady;
        InteractiveKeyboardProvider.INSTANCE.setInteractive(true);
        WindowInsetsControllerCompat windowInsetsController = ViewCompat.getWindowInsetsController(view);
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(WindowInsetsCompat.Type.ime(), -1L, KeyboardAnimationControllerKt.linearInterpolator, this.pendingRequestCancellationSignal, getAnimationControlListener());
        }
    }

    public final void startAndFling(View view, final float velocityY) {
        Intrinsics.checkNotNullParameter(view, "view");
        startControlRequest(view, new Function1() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KeyboardAnimationController.startAndFling$lambda$2(this.f$0, velocityY, (WindowInsetsAnimationControllerCompat) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startAndFling$lambda$2(KeyboardAnimationController keyboardAnimationController, float f, WindowInsetsAnimationControllerCompat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        keyboardAnimationController.animateToFinish(Float.valueOf(f));
        return Unit.INSTANCE;
    }

    public final int insetBy(int dy) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        InteractiveKeyboardProvider.INSTANCE.setInteractive(true);
        return insetTo(windowInsetsAnimationControllerCompat.getCurrentInsets().bottom - dy);
    }

    public final int insetTo(int inset) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        int i = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        boolean z = this.isImeShownAtStart;
        int i3 = z ? i2 : i;
        int i4 = z ? i : i2;
        int iCoerceIn = RangesKt.coerceIn(inset, i, i2);
        int i5 = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom - iCoerceIn;
        windowInsetsAnimationControllerCompat.setInsetsAndAlpha(Insets.of(0, 0, 0, iCoerceIn), 1.0f, (iCoerceIn - i3) / (i4 - i3));
        return i5;
    }

    public final boolean isInsetAnimationInProgress() {
        return this.insetsAnimationController != null;
    }

    public final boolean isInsetAnimationFinishing() {
        return this.currentSpringAnimation != null;
    }

    public final boolean isInsetAnimationRequestPending() {
        return this.pendingRequestCancellationSignal != null;
    }

    public final void cancel() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat != null) {
            windowInsetsAnimationControllerCompat.finish(this.isImeShownAtStart);
        }
        CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        SpringAnimation springAnimation = this.currentSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        reset();
    }

    public final void finish() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
                return;
            }
            return;
        }
        int i = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        int i3 = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        if (i == i2) {
            windowInsetsAnimationControllerCompat.finish(true);
            return;
        }
        if (i == i3) {
            windowInsetsAnimationControllerCompat.finish(false);
        } else if (windowInsetsAnimationControllerCompat.getCurrentFraction() >= 0.15f) {
            windowInsetsAnimationControllerCompat.finish(!this.isImeShownAtStart);
        } else {
            windowInsetsAnimationControllerCompat.finish(this.isImeShownAtStart);
        }
    }

    public static /* synthetic */ void animateToFinish$default(KeyboardAnimationController keyboardAnimationController, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        keyboardAnimationController.animateToFinish(f);
    }

    public final void animateToFinish(Float velocityY) {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            CancellationSignal cancellationSignal = this.pendingRequestCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
                return;
            }
            return;
        }
        InteractiveKeyboardProvider.INSTANCE.setInteractive(false);
        int i = windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
        int i2 = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        int i3 = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        if (velocityY != null) {
            animateImeToVisibility(velocityY.floatValue() < 0.0f, velocityY);
            return;
        }
        if (i == i2) {
            windowInsetsAnimationControllerCompat.finish(true);
            return;
        }
        if (i == i3) {
            windowInsetsAnimationControllerCompat.finish(false);
        } else if (windowInsetsAnimationControllerCompat.getCurrentFraction() >= 0.15f) {
            animateImeToVisibility$default(this, !this.isImeShownAtStart, null, 2, null);
        } else {
            animateImeToVisibility$default(this, this.isImeShownAtStart, null, 2, null);
        }
    }

    public final int getCurrentKeyboardHeight() {
        WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Current WindowInsetsAnimationController is null.This should only be called if isAnimationInProgress() returns true");
        }
        return windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRequestReady(WindowInsetsAnimationControllerCompat controller) {
        this.pendingRequestCancellationSignal = null;
        this.insetsAnimationController = controller;
        Function1<? super WindowInsetsAnimationControllerCompat, Unit> function1 = this.pendingRequestOnReady;
        if (function1 != null) {
            function1.invoke(controller);
        }
        this.pendingRequestOnReady = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reset() {
        this.insetsAnimationController = null;
        this.pendingRequestCancellationSignal = null;
        this.isImeShownAtStart = false;
        SpringAnimation springAnimation = this.currentSpringAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.currentSpringAnimation = null;
        this.pendingRequestOnReady = null;
    }

    static /* synthetic */ void animateImeToVisibility$default(KeyboardAnimationController keyboardAnimationController, boolean z, Float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        keyboardAnimationController.animateImeToVisibility(z, f);
    }

    private final void animateImeToVisibility(boolean visible, Float velocityY) {
        int i;
        final WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = this.insetsAnimationController;
        if (windowInsetsAnimationControllerCompat == null) {
            throw new IllegalStateException("Controller should not be null");
        }
        Function1 function1 = new Function1() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return KeyboardAnimationController.animateImeToVisibility$lambda$3(this.f$0, ((Float) obj).floatValue());
            }
        };
        Function0 function0 = new Function0() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(KeyboardAnimationController.animateImeToVisibility$lambda$4(windowInsetsAnimationControllerCompat));
            }
        };
        if (visible) {
            i = windowInsetsAnimationControllerCompat.getShownStateInsets().bottom;
        } else {
            i = windowInsetsAnimationControllerCompat.getHiddenStateInsets().bottom;
        }
        SpringAnimation springAnimationSpringAnimationOf = DynamicAnimationKt.springAnimationOf(function1, function0, i);
        if (springAnimationSpringAnimationOf.getSpring() == null) {
            springAnimationSpringAnimationOf.setSpring(new SpringForce());
        }
        SpringForce spring = springAnimationSpringAnimationOf.getSpring();
        Intrinsics.checkExpressionValueIsNotNull(spring, "spring");
        spring.setDampingRatio(1.0f);
        spring.setStiffness(1500.0f);
        if (velocityY != null) {
            springAnimationSpringAnimationOf.setStartVelocity(velocityY.floatValue());
        }
        springAnimationSpringAnimationOf.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.reactnativekeyboardcontroller.interactive.KeyboardAnimationController$$ExternalSyntheticLambda2
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
                KeyboardAnimationController.animateImeToVisibility$lambda$7$lambda$6(this.f$0, dynamicAnimation, z, f, f2);
            }
        });
        springAnimationSpringAnimationOf.start();
        this.currentSpringAnimation = springAnimationSpringAnimationOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateImeToVisibility$lambda$3(KeyboardAnimationController keyboardAnimationController, float f) {
        keyboardAnimationController.insetTo(MathKt.roundToInt(f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float animateImeToVisibility$lambda$4(WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat) {
        return windowInsetsAnimationControllerCompat.getCurrentInsets().bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateImeToVisibility$lambda$7$lambda$6(KeyboardAnimationController keyboardAnimationController, DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        if (Intrinsics.areEqual(dynamicAnimation, keyboardAnimationController.currentSpringAnimation)) {
            keyboardAnimationController.currentSpringAnimation = null;
        }
        keyboardAnimationController.finish();
    }
}
