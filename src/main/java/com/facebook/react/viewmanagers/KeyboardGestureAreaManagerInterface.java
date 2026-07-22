package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyboardGestureAreaManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setEnableSwipeToDismiss(T t, boolean z);

    void setInterpolator(T t, String str);

    void setOffset(T t, double d);

    void setShowOnSwipeUp(T t, boolean z);

    void setTextInputNativeID(T t, String str);
}
