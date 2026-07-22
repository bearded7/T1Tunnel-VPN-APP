package com.reactnativekeyboardcontroller;

import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\rH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardControllerModule;", "Lcom/reactnativekeyboardcontroller/NativeKeyboardControllerSpec;", "mReactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "module", "Lcom/reactnativekeyboardcontroller/modules/KeyboardControllerModuleImpl;", "getName", "", "setInputMode", "", "mode", "", "setDefaultMode", "preload", "dismiss", "keepFocus", "", "setFocusTo", "direction", "addListener", "eventName", "removeListeners", "count", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardControllerModule extends NativeKeyboardControllerSpec {
    private final KeyboardControllerModuleImpl module;

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void addListener(String eventName) {
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardControllerModule(ReactApplicationContext mReactContext) {
        super(mReactContext);
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.module = new KeyboardControllerModuleImpl(mReactContext);
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "KeyboardController";
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void setInputMode(double mode) {
        this.module.setInputMode((int) mode);
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void setDefaultMode() {
        this.module.setDefaultMode();
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void preload() {
        this.module.preload();
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void dismiss(boolean keepFocus) {
        this.module.dismiss(keepFocus);
    }

    @Override // com.reactnativekeyboardcontroller.NativeKeyboardControllerSpec
    public void setFocusTo(String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.module.setFocusTo(direction);
    }
}
