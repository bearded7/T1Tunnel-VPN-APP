package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.KeyboardGestureAreaManagerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class KeyboardGestureAreaManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & KeyboardGestureAreaManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public KeyboardGestureAreaManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "showOnSwipeUp":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setShowOnSwipeUp(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "offset":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setOffset(t, obj == null ? 0.0d : ((Double) obj).doubleValue());
                break;
            case "textInputNativeID":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setTextInputNativeID(t, obj == null ? null : (String) obj);
                break;
            case "enableSwipeToDismiss":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setEnableSwipeToDismiss(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "interpolator":
                ((KeyboardGestureAreaManagerInterface) this.mViewManager).setInterpolator(t, (String) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
