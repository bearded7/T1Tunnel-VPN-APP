package com.reactnativekeyboardcontroller;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NativeKeyboardControllerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "KeyboardController";

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void dismiss(boolean z);

    @ReactMethod
    public abstract void preload();

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void setDefaultMode();

    @ReactMethod
    public abstract void setFocusTo(String str);

    @ReactMethod
    public abstract void setInputMode(double d);

    public NativeKeyboardControllerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "KeyboardController";
    }
}
