package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.OverKeyboardViewManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class OverKeyboardViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & OverKeyboardViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public OverKeyboardViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        if (str.equals(ViewProps.VISIBLE)) {
            ((OverKeyboardViewManagerInterface) this.mViewManager).setVisible(t, obj == null ? false : ((Boolean) obj).booleanValue());
        } else {
            super.kotlinCompat$setProperty(t, str, obj);
        }
    }
}
