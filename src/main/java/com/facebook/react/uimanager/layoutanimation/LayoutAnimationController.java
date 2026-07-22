package com.facebook.react.uimanager.layoutanimation;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutAnimationController.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J0\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationController;", "", "<init>", "()V", "layoutCreateAnimation", "Lcom/facebook/react/uimanager/layoutanimation/AbstractLayoutAnimation;", "layoutUpdateAnimation", "layoutDeleteAnimation", "layoutHandlers", "Landroid/util/SparseArray;", "Lcom/facebook/react/uimanager/layoutanimation/LayoutHandlingAnimation;", "shouldAnimateLayout", "", "maxAnimationDuration", "", "completionRunnable", "Ljava/lang/Runnable;", "initializeFromConfig", "", "config", "Lcom/facebook/react/bridge/ReadableMap;", "completionCallback", "Lcom/facebook/react/bridge/Callback;", "reset", "viewToAnimate", "Landroid/view/View;", "applyLayoutUpdate", "view", "x", "", "y", "width", "height", "deleteView", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationListener;", "disableUserInteractions", "scheduleCompletionCallback", "delayMillis", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LayoutAnimationController {
    private static final Companion Companion = new Companion(null);
    private Runnable completionRunnable;
    private boolean shouldAnimateLayout;
    private final AbstractLayoutAnimation layoutCreateAnimation = new LayoutCreateAnimation();
    private final AbstractLayoutAnimation layoutUpdateAnimation = new LayoutUpdateAnimation();
    private final AbstractLayoutAnimation layoutDeleteAnimation = new LayoutDeleteAnimation();
    private final SparseArray<LayoutHandlingAnimation> layoutHandlers = new SparseArray<>(0);
    private long maxAnimationDuration = -1;

    public final void initializeFromConfig(ReadableMap config, final Callback completionCallback) {
        if (config == null) {
            reset();
            return;
        }
        this.shouldAnimateLayout = false;
        int i = config.hasKey("duration") ? config.getInt("duration") : 0;
        if (config.hasKey(LayoutAnimationType.INSTANCE.toString(LayoutAnimationType.CREATE))) {
            AbstractLayoutAnimation abstractLayoutAnimation = this.layoutCreateAnimation;
            ReadableMap map = config.getMap(LayoutAnimationType.INSTANCE.toString(LayoutAnimationType.CREATE));
            Intrinsics.checkNotNull(map);
            abstractLayoutAnimation.initializeFromConfig(map, i);
            this.shouldAnimateLayout = true;
        }
        if (config.hasKey(LayoutAnimationType.INSTANCE.toString(LayoutAnimationType.UPDATE))) {
            AbstractLayoutAnimation abstractLayoutAnimation2 = this.layoutUpdateAnimation;
            ReadableMap map2 = config.getMap(LayoutAnimationType.INSTANCE.toString(LayoutAnimationType.UPDATE));
            Intrinsics.checkNotNull(map2);
            abstractLayoutAnimation2.initializeFromConfig(map2, i);
            this.shouldAnimateLayout = true;
        }
        if (config.hasKey(LayoutAnimationType.INSTANCE.toString(LayoutAnimationType.DELETE))) {
            AbstractLayoutAnimation abstractLayoutAnimation3 = this.layoutDeleteAnimation;
            ReadableMap map3 = config.getMap(LayoutAnimationType.INSTANCE.toString(LayoutAnimationType.DELETE));
            Intrinsics.checkNotNull(map3);
            abstractLayoutAnimation3.initializeFromConfig(map3, i);
            this.shouldAnimateLayout = true;
        }
        if (!this.shouldAnimateLayout || completionCallback == null) {
            return;
        }
        this.completionRunnable = new Runnable() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LayoutAnimationController.initializeFromConfig$lambda$0(completionCallback);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeFromConfig$lambda$0(Callback callback) {
        callback.invoke(true);
    }

    public void reset() {
        this.layoutCreateAnimation.reset();
        this.layoutUpdateAnimation.reset();
        this.layoutDeleteAnimation.reset();
        this.completionRunnable = null;
        this.shouldAnimateLayout = false;
        this.maxAnimationDuration = -1L;
        int size = this.layoutHandlers.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            LayoutHandlingAnimation layoutHandlingAnimationValueAt = this.layoutHandlers.valueAt(size);
            Intrinsics.checkNotNull(layoutHandlingAnimationValueAt);
            if (!layoutHandlingAnimationValueAt.isValid()) {
                this.layoutHandlers.removeAt(size);
            }
        }
    }

    public boolean shouldAnimateLayout(View viewToAnimate) {
        if (viewToAnimate == null) {
            return false;
        }
        return (this.shouldAnimateLayout && viewToAnimate.getParent() != null) || this.layoutHandlers.get(viewToAnimate.getId()) != null;
    }

    public void applyLayoutUpdate(View view, int x, int y, int width, int height) {
        Intrinsics.checkNotNullParameter(view, "view");
        UiThreadUtil.assertOnUiThread();
        final int id = view.getId();
        LayoutHandlingAnimation layoutHandlingAnimation = this.layoutHandlers.get(id);
        if (layoutHandlingAnimation != null) {
            if (!layoutHandlingAnimation.isValid()) {
                this.layoutHandlers.remove(id);
            } else {
                layoutHandlingAnimation.onLayoutUpdate(x, y, width, height);
                return;
            }
        }
        Animation animationCreateAnimation = ((view.getWidth() == 0 || view.getHeight() == 0) ? this.layoutCreateAnimation : this.layoutUpdateAnimation).createAnimation(view, x, y, width, height);
        if (animationCreateAnimation instanceof LayoutHandlingAnimation) {
            animationCreateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.applyLayoutUpdate.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    LayoutAnimationController.this.layoutHandlers.put(id, (LayoutHandlingAnimation) animation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    LayoutAnimationController.this.layoutHandlers.remove(id);
                }
            });
        } else {
            view.layout(x, y, x + width, y + height);
        }
        if (animationCreateAnimation != null) {
            long duration = animationCreateAnimation.getDuration();
            if (duration > this.maxAnimationDuration) {
                this.maxAnimationDuration = duration;
                scheduleCompletionCallback(duration);
            }
            view.startAnimation(animationCreateAnimation);
        }
    }

    public void deleteView(View view, final LayoutAnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        UiThreadUtil.assertOnUiThread();
        Animation animationCreateAnimation = this.layoutDeleteAnimation.createAnimation(view, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        if (animationCreateAnimation != null) {
            disableUserInteractions(view);
            animationCreateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.deleteView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation anim) {
                    Intrinsics.checkNotNullParameter(anim, "anim");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation anim) {
                    Intrinsics.checkNotNullParameter(anim, "anim");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation anim) {
                    Intrinsics.checkNotNullParameter(anim, "anim");
                    listener.onAnimationEnd();
                }
            });
            long duration = animationCreateAnimation.getDuration();
            if (duration > this.maxAnimationDuration) {
                scheduleCompletionCallback(duration);
                this.maxAnimationDuration = duration;
            }
            view.startAnimation(animationCreateAnimation);
            return;
        }
        listener.onAnimationEnd();
    }

    private final void disableUserInteractions(View view) {
        view.setClickable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                disableUserInteractions(childAt);
            }
        }
    }

    private final void scheduleCompletionCallback(long delayMillis) {
        if (this.completionRunnable != null) {
            Handler uiThreadHandler = UiThreadUtil.getUiThreadHandler();
            Runnable runnable = this.completionRunnable;
            Intrinsics.checkNotNull(runnable);
            uiThreadHandler.removeCallbacks(runnable);
            Runnable runnable2 = this.completionRunnable;
            Intrinsics.checkNotNull(runnable2);
            uiThreadHandler.postDelayed(runnable2, delayMillis);
        }
    }

    /* JADX INFO: compiled from: LayoutAnimationController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationController$Companion;", "", "<init>", "()V", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("LayoutAnimationController", LegacyArchitectureLogLevel.ERROR);
    }
}
