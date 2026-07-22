package com.reactnativekeyboardcontroller.views.overlay;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.extensions.ContextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.log.Logger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverKeyboardViewGroup.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J(\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"H\u0014J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0017J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0018H\u0016J\u001a\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020(H\u0016J\u0018\u00102\u001a\u00020\u001e2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020(H\u0016J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00067"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/overlay/OverKeyboardRootViewGroup;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/reactnativekeyboardcontroller/views/overlay/RootViewCompat;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "jsTouchDispatcher", "Lcom/facebook/react/uimanager/JSTouchDispatcher;", "jsPointerDispatcher", "Lcom/reactnativekeyboardcontroller/views/overlay/JSPointerDispatcherCompat;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getEventDispatcher$react_native_keyboard_controller_release", "()Lcom/facebook/react/uimanager/events/EventDispatcher;", "setEventDispatcher$react_native_keyboard_controller_release", "(Lcom/facebook/react/uimanager/events/EventDispatcher;)V", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper$react_native_keyboard_controller_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_keyboard_controller_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "isAttached", "", "isAttached$react_native_keyboard_controller_release", "()Z", "setAttached$react_native_keyboard_controller_release", "(Z)V", "onAttachedToWindow", "", "onDetachedFromWindow", "onSizeChanged", "width", "", "height", "oldWidth", "oldHeight", "onInterceptTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onTouchEvent", "onInterceptHoverEvent", "onHoverEvent", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onChildStartedNativeGesture", "childView", "Landroid/view/View;", "ev", "onChildEndedNativeGesture", "handleException", "t", "", "stretchTo", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverKeyboardRootViewGroup extends ReactViewGroup implements RootViewCompat {
    private EventDispatcher eventDispatcher;
    private boolean isAttached;
    private JSPointerDispatcherCompat jsPointerDispatcher;
    private final JSTouchDispatcher jsTouchDispatcher;
    private final ThemedReactContext reactContext;
    private StateWrapper stateWrapper;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    @Override // com.reactnativekeyboardcontroller.views.overlay.RootViewCompat, com.facebook.react.uimanager.RootView
    @Deprecated(message = "This method shouldn't be used anymore.", replaceWith = @ReplaceWith(expression = "onChildStartedNativeGesture(View childView, MotionEvent ev)", imports = {}))
    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        RootViewCompat.DefaultImpls.onChildStartedNativeGesture(this, motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverKeyboardRootViewGroup(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        OverKeyboardRootViewGroup overKeyboardRootViewGroup = this;
        this.jsTouchDispatcher = new JSTouchDispatcher(overKeyboardRootViewGroup);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.jsPointerDispatcher = new JSPointerDispatcherCompat(overKeyboardRootViewGroup);
        }
    }

    /* JADX INFO: renamed from: getEventDispatcher$react_native_keyboard_controller_release, reason: from getter */
    public final EventDispatcher getEventDispatcher() {
        return this.eventDispatcher;
    }

    public final void setEventDispatcher$react_native_keyboard_controller_release(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    /* JADX INFO: renamed from: getStateWrapper$react_native_keyboard_controller_release, reason: from getter */
    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper$react_native_keyboard_controller_release(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    /* JADX INFO: renamed from: isAttached$react_native_keyboard_controller_release, reason: from getter */
    public final boolean getIsAttached() {
        return this.isAttached;
    }

    public final void setAttached$react_native_keyboard_controller_release(boolean z) {
        this.isAttached = z;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Point displaySize = ContextKt.getDisplaySize(this.reactContext);
        stretchTo(displaySize.x, displaySize.y);
        this.isAttached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stretchTo(0, 0);
        this.isAttached = false;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        stretchTo(width, height);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            try {
                this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher);
                JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
                if (jSPointerDispatcherCompat != null) {
                    jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, true);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (RuntimeException e) {
                Logger.INSTANCE.w(OverKeyboardViewGroupKt.TAG, "Can not handle touch event", e);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            try {
                this.jsTouchDispatcher.handleTouchEvent(event, eventDispatcher);
                JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
                if (jSPointerDispatcherCompat != null) {
                    jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, false);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (RuntimeException e) {
                Logger.INSTANCE.w(OverKeyboardViewGroupKt.TAG, "Can not handle touch event", e);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        super.onTouchEvent(event);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent event) {
        JSPointerDispatcherCompat jSPointerDispatcherCompat;
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null && (jSPointerDispatcherCompat = this.jsPointerDispatcher) != null) {
            jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, true);
        }
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        JSPointerDispatcherCompat jSPointerDispatcherCompat;
        Intrinsics.checkNotNullParameter(event, "event");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null && (jSPointerDispatcherCompat = this.jsPointerDispatcher) != null) {
            jSPointerDispatcherCompat.handleMotionEventCompat(event, eventDispatcher, false);
        }
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.onChildStartedNativeGesture(ev, eventDispatcher);
            JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
            if (jSPointerDispatcherCompat != null) {
                jSPointerDispatcherCompat.onChildStartedNativeGesture(childView, ev, eventDispatcher);
            }
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildEndedNativeGesture(View childView, MotionEvent ev) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(ev, "ev");
        EventDispatcher eventDispatcher = this.eventDispatcher;
        if (eventDispatcher != null) {
            this.jsTouchDispatcher.onChildEndedNativeGesture(ev, eventDispatcher);
        }
        JSPointerDispatcherCompat jSPointerDispatcherCompat = this.jsPointerDispatcher;
        if (jSPointerDispatcherCompat != null) {
            jSPointerDispatcherCompat.onChildEndedNativeGesture();
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void handleException(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        this.reactContext.getReactApplicationContext().handleException(new RuntimeException(t));
    }

    private final void stretchTo(int width, int height) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("screenWidth", FloatKt.getDp(width));
        writableNativeMap.putDouble("screenHeight", FloatKt.getDp(height));
        StateWrapper stateWrapper = this.stateWrapper;
        if (stateWrapper != null) {
            stateWrapper.updateState(writableNativeMap);
        }
    }
}
