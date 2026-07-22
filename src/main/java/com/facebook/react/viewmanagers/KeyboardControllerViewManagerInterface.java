package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyboardControllerViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setEnabled(T t, boolean z);

    void setNavigationBarTranslucent(T t, boolean z);

    void setPreserveEdgeToEdge(T t, boolean z);

    void setStatusBarTranslucent(T t, boolean z);
}
