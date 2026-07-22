package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.KeyboardGestureAreaManagerDelegate;
import com.facebook.react.viewmanagers.KeyboardGestureAreaManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardGestureAreaViewManagerImpl;
import com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardGestureAreaViewManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u001a\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0017J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u001aH\u0017J\u001a\u0010\u001b\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u001aH\u0017J\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00000\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardGestureAreaViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "Lcom/facebook/react/viewmanagers/KeyboardGestureAreaManagerInterface;", "Lcom/facebook/react/views/view/ReactViewGroup;", "<init>", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/KeyboardGestureAreaViewManagerImpl;", "mDelegate", "Lcom/facebook/react/viewmanagers/KeyboardGestureAreaManagerDelegate;", "kotlin.jvm.PlatformType", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/KeyboardGestureAreaReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setOffset", "", "view", "value", "", "setInterpolator", "setShowOnSwipeUp", "", "setEnableSwipeToDismiss", "setTextInputNativeID", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardGestureAreaViewManager extends ReactViewManager implements KeyboardGestureAreaManagerInterface<ReactViewGroup> {
    private final KeyboardGestureAreaViewManagerImpl manager = new KeyboardGestureAreaViewManagerImpl();
    private final KeyboardGestureAreaManagerDelegate<ReactViewGroup, KeyboardGestureAreaViewManager> mDelegate = new KeyboardGestureAreaManagerDelegate<>(this);

    @Override // com.facebook.react.viewmanagers.KeyboardGestureAreaManagerInterface
    @ReactProp(name = "textInputNativeID")
    public void setTextInputNativeID(ReactViewGroup view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ReactViewGroup> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardGestureAreaViewManagerImpl.NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public KeyboardGestureAreaReactViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardGestureAreaManagerInterface
    @ReactProp(name = "offset")
    public void setOffset(ReactViewGroup view, double value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setOffset((KeyboardGestureAreaReactViewGroup) view, value);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardGestureAreaManagerInterface
    @ReactProp(name = "interpolator")
    public void setInterpolator(ReactViewGroup view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        KeyboardGestureAreaViewManagerImpl keyboardGestureAreaViewManagerImpl = this.manager;
        KeyboardGestureAreaReactViewGroup keyboardGestureAreaReactViewGroup = (KeyboardGestureAreaReactViewGroup) view;
        if (value == null) {
            value = "linear";
        }
        keyboardGestureAreaViewManagerImpl.setInterpolator(keyboardGestureAreaReactViewGroup, value);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardGestureAreaManagerInterface
    @ReactProp(name = "showOnSwipeUp")
    public void setShowOnSwipeUp(ReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setScrollKeyboardOnScreenWhenNotVisible((KeyboardGestureAreaReactViewGroup) view, value);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardGestureAreaManagerInterface
    @ReactProp(name = "enableSwipeToDismiss")
    public void setEnableSwipeToDismiss(ReactViewGroup view, boolean value) {
        KeyboardGestureAreaViewManagerImpl keyboardGestureAreaViewManagerImpl = this.manager;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup");
        keyboardGestureAreaViewManagerImpl.setScrollKeyboardOffScreenWhenVisible((KeyboardGestureAreaReactViewGroup) view, value);
    }
}
