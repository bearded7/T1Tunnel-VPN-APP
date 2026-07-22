package com.reactnativekeyboardcontroller;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewProps;
import com.reactnativekeyboardcontroller.modules.statusbar.StatusBarManagerCompatModuleImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusBarManagerCompatModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reactnativekeyboardcontroller/StatusBarManagerCompatModule;", "Lcom/reactnativekeyboardcontroller/NativeStatusBarManagerCompatSpec;", "mReactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "module", "Lcom/reactnativekeyboardcontroller/modules/statusbar/StatusBarManagerCompatModuleImpl;", "getName", "", "getConstants", "", "", "setHidden", "", ViewProps.HIDDEN, "", "setColor", ViewProps.COLOR, "", "animated", "setTranslucent", "translucent", "setStyle", "style", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StatusBarManagerCompatModule extends NativeStatusBarManagerCompatSpec {
    private final StatusBarManagerCompatModuleImpl module;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusBarManagerCompatModule(ReactApplicationContext mReactContext) {
        super(mReactContext);
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.module = new StatusBarManagerCompatModuleImpl(mReactContext);
    }

    @Override // com.reactnativekeyboardcontroller.NativeStatusBarManagerCompatSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "StatusBarManager";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.module.getConstants();
    }

    @Override // com.reactnativekeyboardcontroller.NativeStatusBarManagerCompatSpec
    public void setHidden(boolean hidden) {
        this.module.setHidden(hidden);
    }

    @Override // com.reactnativekeyboardcontroller.NativeStatusBarManagerCompatSpec
    public void setColor(double color, boolean animated) {
        this.module.setColor((int) color, animated);
    }

    @Override // com.reactnativekeyboardcontroller.NativeStatusBarManagerCompatSpec
    public void setTranslucent(boolean translucent) {
        this.module.setTranslucent(translucent);
    }

    @Override // com.reactnativekeyboardcontroller.NativeStatusBarManagerCompatSpec
    public void setStyle(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.module.setStyle(style);
    }
}
