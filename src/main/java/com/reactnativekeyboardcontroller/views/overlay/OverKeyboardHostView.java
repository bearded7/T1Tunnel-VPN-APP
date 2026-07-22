package com.reactnativekeyboardcontroller.views.overlay;

import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverKeyboardViewGroup.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J0\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0014J \u0010$\u001a\u00020\u00132\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00160&j\b\u0012\u0004\u0012\u00020\u0016`'H\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020\u0013J\u0006\u0010,\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006-"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/overlay/OverKeyboardHostView;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "dispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "windowManager", "Landroid/view/WindowManager;", "hostView", "Lcom/reactnativekeyboardcontroller/views/overlay/OverKeyboardRootViewGroup;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "onDetachedFromWindow", "", "addView", "child", "Landroid/view/View;", "index", "", "getChildCount", "getChildAt", "removeView", "removeViewAt", "onLayout", "changed", "", "l", "t", "r", "b", "addChildrenForAccessibility", "outChildren", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dispatchPopulateAccessibilityEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/accessibility/AccessibilityEvent;", "show", "hide", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverKeyboardHostView extends ReactViewGroup {
    private final EventDispatcher dispatcher;
    private OverKeyboardRootViewGroup hostView;
    private final ThemedReactContext reactContext;
    private WindowManager windowManager;

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        Intrinsics.checkNotNullParameter(outChildren, "outChildren");
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverKeyboardHostView(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        this.dispatcher = eventDispatcherForReactTag;
        Object systemService = reactContext.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        OverKeyboardRootViewGroup overKeyboardRootViewGroup = new OverKeyboardRootViewGroup(reactContext);
        this.hostView = overKeyboardRootViewGroup;
        overKeyboardRootViewGroup.setEventDispatcher$react_native_keyboard_controller_release(eventDispatcherForReactTag);
    }

    public final StateWrapper getStateWrapper() {
        return this.hostView.getStateWrapper();
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.hostView.setStateWrapper$react_native_keyboard_controller_release(stateWrapper);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hide();
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        UiThreadUtil.assertOnUiThread();
        this.hostView.addView(child, index);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        return this.hostView.getChildCount();
    }

    @Override // android.view.ViewGroup
    public View getChildAt(int index) {
        return this.hostView.getChildAt(index);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View child) {
        UiThreadUtil.assertOnUiThread();
        if (child != null) {
            this.hostView.removeView(child);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int index) {
        UiThreadUtil.assertOnUiThread();
        this.hostView.removeView(getChildAt(index));
    }

    public final void show() {
        this.windowManager.addView(this.hostView, new WindowManager.LayoutParams(-1, -1, 1000, 520, -3));
    }

    public final void hide() {
        if (this.hostView.getIsAttached()) {
            this.windowManager.removeView(this.hostView);
        }
    }
}
