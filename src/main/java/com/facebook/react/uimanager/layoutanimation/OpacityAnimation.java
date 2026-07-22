package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpacityAnimation.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation;", "Landroid/view/animation/Animation;", "view", "Landroid/view/View;", "startOpacity", "", "endOpacity", "<init>", "(Landroid/view/View;FF)V", "viewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "deltaOpacity", "applyTransformation", "", "interpolatedTime", "t", "Landroid/view/animation/Transformation;", "willChangeBounds", "", "OpacityAnimationListener", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpacityAnimation extends Animation {
    private final float deltaOpacity;
    private final float startOpacity;
    private final WeakReference<View> viewRef;

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return false;
    }

    public OpacityAnimation(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.startOpacity = f;
        this.viewRef = new WeakReference<>(view);
        this.deltaOpacity = f2 - f;
        setAnimationListener(new OpacityAnimationListener(view));
        LegacyArchitectureLogger.assertLegacyArchitecture("OpacityAnimation", LegacyArchitectureLogLevel.ERROR);
    }

    /* JADX INFO: compiled from: OpacityAnimation.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/OpacityAnimation$OpacityAnimationListener;", "Landroid/view/animation/Animation$AnimationListener;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "viewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "layerTypeChanged", "", "onAnimationStart", "", "animation", "Landroid/view/animation/Animation;", "onAnimationEnd", "onAnimationRepeat", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpacityAnimationListener implements Animation.AnimationListener {
        private boolean layerTypeChanged;
        private final WeakReference<View> viewRef;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        public OpacityAnimationListener(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.viewRef = new WeakReference<>(view);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            View view = this.viewRef.get();
            if (view != null && view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.layerTypeChanged = true;
                view.setLayerType(2, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            View view = this.viewRef.get();
            if (view == null || !this.layerTypeChanged) {
                return;
            }
            view.setLayerType(0, null);
        }
    }

    @Override // android.view.animation.Animation
    @VisibleForTesting
    public void applyTransformation(float interpolatedTime, Transformation t) {
        Intrinsics.checkNotNullParameter(t, "t");
        View view = this.viewRef.get();
        if (view != null) {
            view.setAlpha(this.startOpacity + (this.deltaOpacity * interpolatedTime));
        }
    }
}
