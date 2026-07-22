package com.reactnativekeyboardcontroller.modules;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerModuleImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reactnativekeyboardcontroller/modules/KeyboardControllerModuleImpl;", "", "mReactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mDefaultMode", "", "setInputMode", "", "mode", "setDefaultMode", "preload", "dismiss", "keepFocus", "", "setFocusTo", "direction", "", "setSoftInputMode", "getCurrentMode", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardControllerModuleImpl {
    public static final String NAME = "KeyboardController";
    private final int mDefaultMode;
    private final ReactApplicationContext mReactContext;

    public final void preload() {
    }

    public KeyboardControllerModuleImpl(ReactApplicationContext mReactContext) {
        Intrinsics.checkNotNullParameter(mReactContext, "mReactContext");
        this.mReactContext = mReactContext;
        this.mDefaultMode = getCurrentMode();
    }

    public final void setInputMode(int mode) {
        setSoftInputMode(mode);
    }

    public final void setDefaultMode() {
        setSoftInputMode(this.mDefaultMode);
    }

    public final void dismiss(final boolean keepFocus) {
        final Activity currentActivity = this.mReactContext.getCurrentActivity();
        final EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.dismiss$lambda$0(currentActivity, editText, keepFocus);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$0(Activity activity, View view, boolean z) {
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        if (z) {
            return;
        }
        view.clearFocus();
    }

    public final void setFocusTo(String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        if (Intrinsics.areEqual(direction, "current")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    KeyboardControllerModuleImpl.setFocusTo$lambda$1();
                }
            });
            return;
        }
        EditText editText = FocusedInputHolder.INSTANCE.get();
        if (editText != null) {
            ViewHierarchyNavigator.INSTANCE.setFocusTo(direction, editText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFocusTo$lambda$1() {
        FocusedInputHolder.INSTANCE.focus();
    }

    private final void setSoftInputMode(final int mode) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativekeyboardcontroller.modules.KeyboardControllerModuleImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardControllerModuleImpl.setSoftInputMode$lambda$2(this.f$0, mode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSoftInputMode$lambda$2(KeyboardControllerModuleImpl keyboardControllerModuleImpl, int i) {
        Activity currentActivity;
        Window window;
        if (keyboardControllerModuleImpl.getCurrentMode() == i || (currentActivity = keyboardControllerModuleImpl.mReactContext.getCurrentActivity()) == null || (window = currentActivity.getWindow()) == null) {
            return;
        }
        window.setSoftInputMode(i);
    }

    private final int getCurrentMode() {
        Window window;
        WindowManager.LayoutParams attributes;
        Activity currentActivity = this.mReactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return 0;
        }
        return attributes.softInputMode;
    }
}
