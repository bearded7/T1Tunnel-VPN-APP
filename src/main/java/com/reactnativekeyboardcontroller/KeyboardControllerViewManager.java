package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.KeyboardControllerViewManagerDelegate;
import com.facebook.react.viewmanagers.KeyboardControllerViewManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardControllerViewManagerImpl;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerViewManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0014J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00000\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardControllerViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "Lcom/facebook/react/viewmanagers/KeyboardControllerViewManagerInterface;", "Lcom/facebook/react/views/view/ReactViewGroup;", "<init>", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/KeyboardControllerViewManagerImpl;", "mDelegate", "Lcom/facebook/react/viewmanagers/KeyboardControllerViewManagerDelegate;", "kotlin.jvm.PlatformType", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "invalidate", "", "onAfterUpdateTransaction", "view", "setStatusBarTranslucent", "value", "", "setNavigationBarTranslucent", "setPreserveEdgeToEdge", "setEnabled", "getExportedCustomDirectEventTypeConstants", "", "", "", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardControllerViewManager extends ReactViewManager implements KeyboardControllerViewManagerInterface<ReactViewGroup> {
    private final KeyboardControllerViewManagerImpl manager = new KeyboardControllerViewManagerImpl();
    private final KeyboardControllerViewManagerDelegate<ReactViewGroup, KeyboardControllerViewManager> mDelegate = new KeyboardControllerViewManagerDelegate<>(this);

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        this.manager.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        this.manager.setEdgeToEdge((EdgeToEdgeReactViewGroup) view);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardControllerViewManagerInterface
    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(ReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setStatusBarTranslucent((EdgeToEdgeReactViewGroup) view, value);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardControllerViewManagerInterface
    @ReactProp(name = "navigationBarTranslucent")
    public void setNavigationBarTranslucent(ReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setNavigationBarTranslucent((EdgeToEdgeReactViewGroup) view, value);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardControllerViewManagerInterface
    @ReactProp(name = "preserveEdgeToEdge")
    public void setPreserveEdgeToEdge(ReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setPreserveEdgeToEdge((EdgeToEdgeReactViewGroup) view, value);
    }

    @Override // com.facebook.react.viewmanagers.KeyboardControllerViewManagerInterface
    @ReactProp(name = ViewProps.ENABLED)
    public void setEnabled(ReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setEnabled((EdgeToEdgeReactViewGroup) view, value);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return this.manager.getExportedCustomDirectEventTypeConstants();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ReactViewGroup> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardControllerViewManagerImpl.NAME;
    }
}
