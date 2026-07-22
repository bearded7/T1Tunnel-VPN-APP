package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.OverKeyboardViewManagerDelegate;
import com.facebook.react.viewmanagers.OverKeyboardViewManagerInterface;
import com.reactnativekeyboardcontroller.managers.OverKeyboardViewManagerImpl;
import com.reactnativekeyboardcontroller.views.overlay.OverKeyboardHostShadowNode;
import com.reactnativekeyboardcontroller.views.overlay.OverKeyboardHostView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverKeyboardViewManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0015H\u0016J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00000\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/reactnativekeyboardcontroller/OverKeyboardViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativekeyboardcontroller/views/overlay/OverKeyboardHostView;", "Lcom/facebook/react/viewmanagers/OverKeyboardViewManagerInterface;", "<init>", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/OverKeyboardViewManagerImpl;", "mDelegate", "Lcom/facebook/react/viewmanagers/OverKeyboardViewManagerDelegate;", "kotlin.jvm.PlatformType", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "createShadowNodeInstance", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "getShadowNodeClass", "Ljava/lang/Class;", "updateState", "", "view", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "setVisible", "", "value", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverKeyboardViewManager extends ViewGroupManager<OverKeyboardHostView> implements OverKeyboardViewManagerInterface<OverKeyboardHostView> {
    private final OverKeyboardViewManagerDelegate<OverKeyboardHostView, OverKeyboardViewManager> mDelegate;
    private final OverKeyboardViewManagerImpl manager;

    public OverKeyboardViewManager() {
        super(null, 1, null);
        this.manager = new OverKeyboardViewManagerImpl();
        this.mDelegate = new OverKeyboardViewManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<OverKeyboardHostView> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return OverKeyboardViewManagerImpl.NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public OverKeyboardHostView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new OverKeyboardHostShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return OverKeyboardHostShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(OverKeyboardHostView view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        view.setStateWrapper(stateWrapper);
        return null;
    }

    @Override // com.facebook.react.viewmanagers.OverKeyboardViewManagerInterface
    @ReactProp(name = ViewProps.VISIBLE)
    public void setVisible(OverKeyboardHostView view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.manager.setVisible(view, value);
    }
}
