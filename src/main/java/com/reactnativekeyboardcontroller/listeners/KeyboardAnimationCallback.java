package com.reactnativekeyboardcontroller.listeners;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.events.KeyboardTransitionEvent;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import com.reactnativekeyboardcontroller.extensions.WindowInsetsAnimationCompatKt;
import com.reactnativekeyboardcontroller.interactive.InteractiveKeyboardProvider;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: KeyboardAnimationCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020,H\u0016J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u000200H\u0016J\u001e\u00103\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\f\u00104\u001a\b\u0012\u0004\u0012\u00020 05H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00101\u001a\u00020 H\u0016J#\u00108\u001a\u0002072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010;J\u0006\u0010<\u001a\u000207J\u0010\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010?\u001a\u00020\u0017H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u00109\u001a\u00020\u0017H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010#\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallback;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Lcom/reactnativekeyboardcontroller/listeners/Suspendable;", "eventPropagationView", "Lcom/facebook/react/views/view/ReactViewGroup;", "view", "Landroid/view/View;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "config", "Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;", "<init>", "(Lcom/facebook/react/views/view/ReactViewGroup;Landroid/view/View;Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;)V", "getEventPropagationView", "()Lcom/facebook/react/views/view/ReactViewGroup;", "getView", "()Landroid/view/View;", "getContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "surfaceId", "", "persistentKeyboardHeight", "", "prevKeyboardHeight", "isKeyboardVisible", "", "isTransitioning", "duration", "viewTagFocused", "animationsToSkip", "Ljava/util/HashSet;", "Landroidx/core/view/WindowInsetsAnimationCompat;", "Lkotlin/collections/HashSet;", "isKeyboardInteractive", "()Z", "isSuspended", "setSuspended", "(Z)V", "focusListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "layoutObserver", "Lcom/reactnativekeyboardcontroller/listeners/FocusedInputObserver;", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "insets", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "animation", "bounds", "onProgress", "runningAnimations", "", "onEnd", "", "syncKeyboardPosition", "height", "isVisible", "(Ljava/lang/Double;Ljava/lang/Boolean;)V", "destroy", "onKeyboardResized", "keyboardHeight", "getCurrentKeyboardHeight", "getEventParams", "Lcom/facebook/react/bridge/WritableMap;", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardAnimationCallback extends WindowInsetsAnimationCompat.Callback implements OnApplyWindowInsetsListener, Suspendable {
    private HashSet<WindowInsetsAnimationCompat> animationsToSkip;
    private final KeyboardAnimationCallbackConfig config;
    private final ThemedReactContext context;
    private int duration;
    private final ReactViewGroup eventPropagationView;
    private final ViewTreeObserver.OnGlobalFocusChangeListener focusListener;
    private boolean isKeyboardVisible;
    private boolean isSuspended;
    private boolean isTransitioning;
    private FocusedInputObserver layoutObserver;
    private double persistentKeyboardHeight;
    private double prevKeyboardHeight;
    private final int surfaceId;
    private final View view;
    private int viewTagFocused;

    @Override // com.reactnativekeyboardcontroller.listeners.Suspendable
    public void suspend(boolean z) {
        Suspendable.DefaultImpls.suspend(this, z);
    }

    public final ReactViewGroup getEventPropagationView() {
        return this.eventPropagationView;
    }

    public final View getView() {
        return this.view;
    }

    public final ThemedReactContext getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardAnimationCallback(ReactViewGroup eventPropagationView, View view, ThemedReactContext themedReactContext, KeyboardAnimationCallbackConfig config) {
        super(config.getDispatchMode());
        Intrinsics.checkNotNullParameter(eventPropagationView, "eventPropagationView");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        this.eventPropagationView = eventPropagationView;
        this.view = view;
        this.context = themedReactContext;
        this.config = config;
        this.surfaceId = UIManagerHelper.getSurfaceId(eventPropagationView);
        this.viewTagFocused = -1;
        this.animationsToSkip = new HashSet<>();
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                KeyboardAnimationCallback.focusListener$lambda$0(this.f$0, view2, view3);
            }
        };
        this.focusListener = onGlobalFocusChangeListener;
        if ((config.getDeferredInsetTypes() & config.getPersistentInsetTypes()) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values".toString());
        }
        this.layoutObserver = new FocusedInputObserver(view, eventPropagationView, themedReactContext);
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    private final boolean isKeyboardInteractive() {
        return this.duration == -1;
    }

    @Override // com.reactnativekeyboardcontroller.listeners.Suspendable
    /* JADX INFO: renamed from: isSuspended, reason: from getter */
    public boolean getIsSuspended() {
        return this.isSuspended;
    }

    @Override // com.reactnativekeyboardcontroller.listeners.Suspendable
    public void setSuspended(boolean z) {
        this.isSuspended = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void focusListener$lambda$0(KeyboardAnimationCallback keyboardAnimationCallback, View view, View view2) {
        if (view2 instanceof EditText) {
            keyboardAnimationCallback.viewTagFocused = ((EditText) view2).getId();
            if (!keyboardAnimationCallback.isKeyboardVisible || view == null) {
                return;
            }
            ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), KeyboardTransitionEvent.INSTANCE.getStart(), keyboardAnimationCallback.persistentKeyboardHeight, 1.0d, 0, keyboardAnimationCallback.viewTagFocused));
            ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), KeyboardTransitionEvent.INSTANCE.getEnd(), keyboardAnimationCallback.persistentKeyboardHeight, 1.0d, 0, keyboardAnimationCallback.viewTagFocused));
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::keyboardWillShow", keyboardAnimationCallback.getEventParams(keyboardAnimationCallback.persistentKeyboardHeight));
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::keyboardDidShow", keyboardAnimationCallback.getEventParams(keyboardAnimationCallback.persistentKeyboardHeight));
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        double currentKeyboardHeight = getCurrentKeyboardHeight();
        boolean z = (this.isKeyboardVisible && isKeyboardVisible()) && !(this.isTransitioning || InteractiveKeyboardProvider.INSTANCE.isInteractive());
        boolean z2 = this.persistentKeyboardHeight == currentKeyboardHeight;
        if (z && !z2 && !KeyboardAnimationCallbackKt.isResizeHandledInCallbackMethods) {
            Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "onApplyWindowInsets: " + this.persistentKeyboardHeight + " -> " + currentKeyboardHeight, null, 4, null);
            FocusedInputObserver focusedInputObserver = this.layoutObserver;
            if (focusedInputObserver != null) {
                focusedInputObserver.syncUpLayout();
            }
            onKeyboardResized(currentKeyboardHeight);
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (!WindowInsetsAnimationCompatKt.isKeyboardAnimation(animation) || getIsSuspended()) {
            return bounds;
        }
        this.isTransitioning = true;
        this.isKeyboardVisible = isKeyboardVisible();
        this.duration = (int) animation.getDurationMillis();
        double currentKeyboardHeight = getCurrentKeyboardHeight();
        if (this.isKeyboardVisible) {
            this.persistentKeyboardHeight = currentKeyboardHeight;
        }
        FocusedInputObserver focusedInputObserver = this.layoutObserver;
        if (focusedInputObserver != null) {
            focusedInputObserver.syncUpLayout();
        }
        boolean z = (currentKeyboardHeight == 0.0d || this.prevKeyboardHeight == currentKeyboardHeight) ? false : true;
        boolean z2 = this.isKeyboardVisible && this.prevKeyboardHeight != 0.0d;
        if (z && z2 && KeyboardAnimationCallbackKt.isResizeHandledInCallbackMethods) {
            onKeyboardResized(currentKeyboardHeight);
            this.animationsToSkip.add(animation);
            return bounds;
        }
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::".concat(!this.isKeyboardVisible ? "keyboardWillHide" : "keyboardWillShow"), getEventParams(currentKeyboardHeight));
        Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "HEIGHT:: " + currentKeyboardHeight + " TAG:: " + this.viewTagFocused, null, 4, null);
        ThemedReactContext themedReactContext = this.context;
        int id = this.eventPropagationView.getId();
        double d = 0.0d;
        int i = this.surfaceId;
        int id2 = this.eventPropagationView.getId();
        KeyboardTransitionEvent.Companion.EventName start = KeyboardTransitionEvent.INSTANCE.getStart();
        if (this.isKeyboardVisible) {
            d = 1.0d;
        }
        ThemedReactContextKt.dispatchEvent(themedReactContext, id, new KeyboardTransitionEvent(i, id2, start, currentKeyboardHeight, d, this.duration, this.viewTagFocused));
        WindowInsetsAnimationCompat.BoundsCompat boundsCompatOnStart = super.onStart(animation, bounds);
        Intrinsics.checkNotNullExpressionValue(boundsCompatOnStart, "onStart(...)");
        return boundsCompatOnStart;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
        Object next;
        KeyboardTransitionEvent.Companion.EventName move;
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        Iterator<T> it = runningAnimations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) next;
            if (WindowInsetsAnimationCompatKt.isKeyboardAnimation(windowInsetsAnimationCompat) && !this.animationsToSkip.contains(windowInsetsAnimationCompat)) {
                break;
            }
        }
        boolean z = next == null;
        if (!getIsSuspended() && !z) {
            Insets insets2 = insets.getInsets(this.config.getDeferredInsetTypes());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            Insets NONE = insets.getInsets(this.config.getPersistentInsetTypes());
            Intrinsics.checkNotNullExpressionValue(NONE, "getInsets(...)");
            if (this.config.getHasTranslucentNavigationBar()) {
                NONE = Insets.NONE;
                Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            }
            Insets insetsMax = Insets.max(Insets.subtract(insets2, NONE), Insets.NONE);
            Intrinsics.checkNotNullExpressionValue(insetsMax, "let(...)");
            float f = insetsMax.bottom - insetsMax.top;
            double dp = FloatKt.getDp(f);
            double d = 0.0d;
            try {
                double dAbs = Math.abs(dp / this.persistentKeyboardHeight);
                if (!Double.isNaN(dAbs) && !Double.isInfinite(dAbs)) {
                    d = dAbs;
                }
            } catch (ArithmeticException e) {
                Logger.w$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "Caught arithmetic exception during `progress` calculation: " + e, null, 4, null);
            }
            double d2 = d;
            Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "DiffY: " + f + " " + dp + " " + d2 + " " + InteractiveKeyboardProvider.INSTANCE.isInteractive() + " " + this.viewTagFocused, null, 4, null);
            if (InteractiveKeyboardProvider.INSTANCE.isInteractive()) {
                move = KeyboardTransitionEvent.INSTANCE.getInteractive();
            } else {
                move = KeyboardTransitionEvent.INSTANCE.getMove();
            }
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), move, dp, d2, this.duration, this.viewTagFocused));
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(final WindowInsetsAnimationCompat animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onEnd(animation);
        if (!WindowInsetsAnimationCompatKt.isKeyboardAnimation(animation) || getIsSuspended()) {
            return;
        }
        this.isTransitioning = false;
        this.duration = (int) animation.getDurationMillis();
        Runnable runnable = new Runnable() { // from class: com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardAnimationCallback.onEnd$lambda$5(this.f$0, animation);
            }
        };
        if (isKeyboardInteractive()) {
            this.view.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEnd$lambda$5(KeyboardAnimationCallback keyboardAnimationCallback, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        double currentKeyboardHeight = keyboardAnimationCallback.getCurrentKeyboardHeight();
        keyboardAnimationCallback.isKeyboardVisible = keyboardAnimationCallback.isKeyboardVisible();
        keyboardAnimationCallback.prevKeyboardHeight = currentKeyboardHeight;
        if (keyboardAnimationCallback.animationsToSkip.contains(windowInsetsAnimationCompat)) {
            keyboardAnimationCallback.duration = 0;
            keyboardAnimationCallback.animationsToSkip.remove(windowInsetsAnimationCompat);
        } else {
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::".concat(!keyboardAnimationCallback.isKeyboardVisible ? "keyboardDidHide" : "keyboardDidShow"), keyboardAnimationCallback.getEventParams(currentKeyboardHeight));
            ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), KeyboardTransitionEvent.INSTANCE.getEnd(), currentKeyboardHeight, !keyboardAnimationCallback.isKeyboardVisible ? 0.0d : 1.0d, keyboardAnimationCallback.duration, keyboardAnimationCallback.viewTagFocused));
            keyboardAnimationCallback.duration = 0;
            ThemedReactContextKt.keepShadowNodesInSync(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId());
        }
    }

    public static /* synthetic */ void syncKeyboardPosition$default(KeyboardAnimationCallback keyboardAnimationCallback, Double d, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            d = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        keyboardAnimationCallback.syncKeyboardPosition(d, bool);
    }

    public final void syncKeyboardPosition(Double height, Boolean isVisible) {
        double dDoubleValue = height != null ? height.doubleValue() : getCurrentKeyboardHeight();
        boolean zBooleanValue = isVisible != null ? isVisible.booleanValue() : isKeyboardVisible();
        this.isKeyboardVisible = zBooleanValue;
        this.prevKeyboardHeight = dDoubleValue;
        this.isTransitioning = false;
        this.duration = 0;
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::".concat(!zBooleanValue ? "keyboardDidHide" : "keyboardDidShow"), getEventParams(dDoubleValue));
        Iterator it = CollectionsKt.listOf((Object[]) new KeyboardTransitionEvent.Companion.EventName[]{KeyboardTransitionEvent.INSTANCE.getMove(), KeyboardTransitionEvent.INSTANCE.getEnd()}).iterator();
        while (it.hasNext()) {
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), (KeyboardTransitionEvent.Companion.EventName) it.next(), dDoubleValue, !this.isKeyboardVisible ? 0.0d : 1.0d, this.duration, this.viewTagFocused));
        }
    }

    public final void destroy() {
        this.view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.focusListener);
        FocusedInputObserver focusedInputObserver = this.layoutObserver;
        if (focusedInputObserver != null) {
            focusedInputObserver.destroy();
        }
    }

    private final void onKeyboardResized(double keyboardHeight) {
        this.duration = 0;
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::keyboardWillShow", getEventParams(keyboardHeight));
        Iterator it = CollectionsKt.listOf((Object[]) new KeyboardTransitionEvent.Companion.EventName[]{KeyboardTransitionEvent.INSTANCE.getStart(), KeyboardTransitionEvent.INSTANCE.getMove(), KeyboardTransitionEvent.INSTANCE.getEnd()}).iterator();
        while (it.hasNext()) {
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), (KeyboardTransitionEvent.Companion.EventName) it.next(), keyboardHeight, 1.0d, 0, this.viewTagFocused));
        }
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::keyboardDidShow", getEventParams(keyboardHeight));
        ThemedReactContextKt.keepShadowNodesInSync(this.context, this.eventPropagationView.getId());
        this.persistentKeyboardHeight = keyboardHeight;
    }

    private final boolean isKeyboardVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        if (rootWindowInsets != null) {
            return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        }
        return false;
    }

    private final double getCurrentKeyboardHeight() {
        Insets insets;
        Insets insets2;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        int i = 0;
        int i2 = (rootWindowInsets == null || (insets2 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime())) == null) ? 0 : insets2.bottom;
        if (!this.config.getHasTranslucentNavigationBar() && rootWindowInsets != null && (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) != null) {
            i = insets.bottom;
        }
        return RangesKt.coerceAtLeast(FloatKt.getDp(i2 - i), 0.0d);
    }

    private final WritableMap getEventParams(double height) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        writableMapCreateMap.putDouble("height", height);
        writableMapCreateMap.putInt("duration", this.duration);
        writableMapCreateMap.putDouble("timestamp", System.currentTimeMillis());
        writableMapCreateMap.putInt("target", this.viewTagFocused);
        EditText editText = FocusedInputHolder.INSTANCE.get();
        writableMapCreateMap.putString(SVGParser.XML_STYLESHEET_ATTR_TYPE, editText != null ? EditTextKt.getKeyboardType(editText) : null);
        writableMapCreateMap.putString("appearance", ThemedReactContextKt.getAppearance(this.context));
        return writableMapCreateMap;
    }
}
