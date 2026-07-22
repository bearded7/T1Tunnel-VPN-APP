package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.overlay.OverKeyboardHostView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverKeyboardViewManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/reactnativekeyboardcontroller/managers/OverKeyboardViewManagerImpl;", "", "<init>", "()V", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/overlay/OverKeyboardHostView;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setVisible", "", "view", "value", "", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OverKeyboardViewManagerImpl {
    public static final String NAME = "OverKeyboardView";

    public final OverKeyboardHostView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new OverKeyboardHostView(reactContext);
    }

    public final void setVisible(OverKeyboardHostView view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value) {
            view.show();
        } else {
            view.hide();
        }
    }
}
