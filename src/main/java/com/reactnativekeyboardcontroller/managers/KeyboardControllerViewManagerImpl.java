package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputTextChangedEvent;
import com.reactnativekeyboardcontroller.events.KeyboardTransitionEvent;
import com.reactnativekeyboardcontroller.listeners.WindowDimensionListener;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerViewManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/reactnativekeyboardcontroller/managers/KeyboardControllerViewManagerImpl;", "", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/reactnativekeyboardcontroller/listeners/WindowDimensionListener;", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "invalidate", "", "setEnabled", "view", ViewProps.ENABLED, "", "setStatusBarTranslucent", "isStatusBarTranslucent", "setNavigationBarTranslucent", "isNavigationBarTranslucent", "setPreserveEdgeToEdge", "isPreservingEdgeToEdge", "setEdgeToEdge", "getExportedCustomDirectEventTypeConstants", "", "", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardControllerViewManagerImpl {
    public static final String NAME = "KeyboardControllerView";
    private WindowDimensionListener listener;

    public final EdgeToEdgeReactViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (this.listener == null) {
            WindowDimensionListener windowDimensionListener = new WindowDimensionListener(reactContext);
            this.listener = windowDimensionListener;
            windowDimensionListener.attachListener();
        }
        return new EdgeToEdgeReactViewGroup(reactContext);
    }

    public final void invalidate() {
        WindowDimensionListener windowDimensionListener = this.listener;
        if (windowDimensionListener != null) {
            windowDimensionListener.detachListener();
        }
        this.listener = null;
    }

    public final void setEnabled(EdgeToEdgeReactViewGroup view, boolean enabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActive(enabled);
    }

    public final void setStatusBarTranslucent(EdgeToEdgeReactViewGroup view, boolean isStatusBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(isStatusBarTranslucent);
    }

    public final void setNavigationBarTranslucent(EdgeToEdgeReactViewGroup view, boolean isNavigationBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarTranslucent(isNavigationBarTranslucent);
    }

    public final void setPreserveEdgeToEdge(EdgeToEdgeReactViewGroup view, boolean isPreservingEdgeToEdge) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreserveEdgeToEdge(isPreservingEdgeToEdge);
    }

    public final void setEdgeToEdge(EdgeToEdgeReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEdgeToEdge();
    }

    public final Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(KeyboardTransitionEvent.INSTANCE.getMove().getValue(), MapBuilder.of("registrationName", "onKeyboardMove"), KeyboardTransitionEvent.INSTANCE.getStart().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveStart"), KeyboardTransitionEvent.INSTANCE.getEnd().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveEnd"), KeyboardTransitionEvent.INSTANCE.getInteractive().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveInteractive"), FocusedInputLayoutChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputLayoutChanged"), FocusedInputTextChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputTextChanged"), FocusedInputSelectionChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputSelectionChanged"));
    }
}
