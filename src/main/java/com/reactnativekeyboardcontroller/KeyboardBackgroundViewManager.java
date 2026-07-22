package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.viewmanagers.KeyboardBackgroundViewManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.reactnativekeyboardcontroller.managers.KeyboardBackgroundViewManagerImpl;
import com.reactnativekeyboardcontroller.views.background.KeyboardBackgroundViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardBackgroundViewManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardBackgroundViewManager;", "Lcom/facebook/react/views/view/ReactViewManager;", "Lcom/facebook/react/viewmanagers/KeyboardBackgroundViewManagerInterface;", "Lcom/facebook/react/views/view/ReactViewGroup;", "<init>", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/KeyboardBackgroundViewManagerImpl;", "getName", "", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/background/KeyboardBackgroundViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardBackgroundViewManager extends ReactViewManager implements KeyboardBackgroundViewManagerInterface<ReactViewGroup> {
    private final KeyboardBackgroundViewManagerImpl manager = new KeyboardBackgroundViewManagerImpl();

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardBackgroundViewManagerImpl.NAME;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public KeyboardBackgroundViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }
}
