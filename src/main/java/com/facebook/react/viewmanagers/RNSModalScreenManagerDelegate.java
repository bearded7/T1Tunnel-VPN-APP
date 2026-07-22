package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSModalScreenManagerInterface;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
public class RNSModalScreenManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSModalScreenManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSModalScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        byte b;
        str.hashCode();
        switch (str) {
            case "homeIndicatorHidden":
                b = 0;
                break;
            case "gestureEnabled":
                b = 1;
                break;
            case "hideKeyboardOnSwipe":
                b = 2;
                break;
            case "sheetCornerRadius":
                b = 3;
                break;
            case "navigationBarHidden":
                b = 4;
                break;
            case "statusBarTranslucent":
                b = 5;
                break;
            case "stackPresentation":
                b = 6;
                break;
            case "activityState":
                b = 7;
                break;
            case "statusBarColor":
                b = 8;
                break;
            case "statusBarStyle":
                b = 9;
                break;
            case "fullScreenSwipeShadowEnabled":
                b = 10;
                break;
            case "stackAnimation":
                b = Ascii.VT;
                break;
            case "navigationBarColor":
                b = Ascii.FF;
                break;
            case "screenId":
                b = Ascii.CR;
                break;
            case "sheetInitialDetent":
                b = Ascii.SO;
                break;
            case "sheetAllowedDetents":
                b = Ascii.SI;
                break;
            case "replaceAnimation":
                b = Ascii.DLE;
                break;
            case "preventNativeDismiss":
                b = 17;
                break;
            case "statusBarHidden":
                b = Ascii.DC2;
                break;
            case "fullScreenSwipeEnabled":
                b = 19;
                break;
            case "gestureResponseDistance":
                b = Ascii.DC4;
                break;
            case "screenOrientation":
                b = Ascii.NAK;
                break;
            case "sheetLargestUndimmedDetent":
                b = Ascii.SYN;
                break;
            case "transitionDuration":
                b = Ascii.ETB;
                break;
            case "swipeDirection":
                b = 24;
                break;
            case "customAnimationOnSwipe":
                b = Ascii.EM;
                break;
            case "navigationBarTranslucent":
                b = Ascii.SUB;
                break;
            case "sheetElevation":
                b = Ascii.ESC;
                break;
            case "sheetGrabberVisible":
                b = Ascii.FS;
                break;
            case "statusBarAnimation":
                b = Ascii.GS;
                break;
            case "nativeBackButtonDismissalEnabled":
                b = Ascii.RS;
                break;
            case "sheetExpandsWhenScrolledToEdge":
                b = Ascii.US;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ((RNSModalScreenManagerInterface) this.mViewManager).setHomeIndicatorHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSModalScreenManagerInterface) this.mViewManager).setGestureEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 2:
                ((RNSModalScreenManagerInterface) this.mViewManager).setHideKeyboardOnSwipe(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 3:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetCornerRadius(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 4:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNavigationBarHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 5:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarTranslucent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStackPresentation(t, (String) obj);
                break;
            case 7:
                ((RNSModalScreenManagerInterface) this.mViewManager).setActivityState(t, obj != null ? ((Double) obj).floatValue() : -1.0f);
                break;
            case 8:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 9:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarStyle(t, obj != null ? (String) obj : null);
                break;
            case 10:
                ((RNSModalScreenManagerInterface) this.mViewManager).setFullScreenSwipeShadowEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 11:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStackAnimation(t, (String) obj);
                break;
            case 12:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNavigationBarColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case 13:
                ((RNSModalScreenManagerInterface) this.mViewManager).setScreenId(t, obj == null ? "" : (String) obj);
                break;
            case 14:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetInitialDetent(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 15:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetAllowedDetents(t, (ReadableArray) obj);
                break;
            case 16:
                ((RNSModalScreenManagerInterface) this.mViewManager).setReplaceAnimation(t, (String) obj);
                break;
            case 17:
                ((RNSModalScreenManagerInterface) this.mViewManager).setPreventNativeDismiss(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 18:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 19:
                ((RNSModalScreenManagerInterface) this.mViewManager).setFullScreenSwipeEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 20:
                ((RNSModalScreenManagerInterface) this.mViewManager).setGestureResponseDistance(t, (ReadableMap) obj);
                break;
            case 21:
                ((RNSModalScreenManagerInterface) this.mViewManager).setScreenOrientation(t, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetLargestUndimmedDetent(t, obj != null ? ((Double) obj).intValue() : -1);
                break;
            case 23:
                ((RNSModalScreenManagerInterface) this.mViewManager).setTransitionDuration(t, obj == null ? 500 : ((Double) obj).intValue());
                break;
            case 24:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSwipeDirection(t, (String) obj);
                break;
            case 25:
                ((RNSModalScreenManagerInterface) this.mViewManager).setCustomAnimationOnSwipe(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 26:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNavigationBarTranslucent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 27:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetElevation(t, obj != null ? ((Double) obj).intValue() : 24);
                break;
            case 28:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetGrabberVisible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNSModalScreenManagerInterface) this.mViewManager).setStatusBarAnimation(t, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSModalScreenManagerInterface) this.mViewManager).setNativeBackButtonDismissalEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_WIDTH_DEFAULT /* 31 */:
                ((RNSModalScreenManagerInterface) this.mViewManager).setSheetExpandsWhenScrolledToEdge(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
