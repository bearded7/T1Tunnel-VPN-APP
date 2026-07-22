package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardGestureAreaViewManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0015"}, d2 = {"Lcom/reactnativekeyboardcontroller/managers/KeyboardGestureAreaViewManagerImpl;", "", "<init>", "()V", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/KeyboardGestureAreaReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setOffset", "", "view", "offset", "", "setInterpolator", "interpolator", "", "setScrollKeyboardOffScreenWhenVisible", "value", "", "setScrollKeyboardOnScreenWhenNotVisible", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardGestureAreaViewManagerImpl {
    public static final String NAME = "KeyboardGestureArea";

    public final KeyboardGestureAreaReactViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new KeyboardGestureAreaReactViewGroup(reactContext);
    }

    public final void setOffset(KeyboardGestureAreaReactViewGroup view, double offset) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOffset(offset);
    }

    public final void setInterpolator(KeyboardGestureAreaReactViewGroup view, String interpolator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        view.setInterpolator(interpolator);
    }

    public final void setScrollKeyboardOffScreenWhenVisible(KeyboardGestureAreaReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOffScreenWhenVisible(value);
    }

    public final void setScrollKeyboardOnScreenWhenNotVisible(KeyboardGestureAreaReactViewGroup view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOnScreenWhenNotVisible(value);
    }
}
