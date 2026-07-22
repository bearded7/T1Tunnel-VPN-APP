package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.swmansion.rnscreens.bottomsheet.BottomSheetBehaviorExtKt;
import com.swmansion.rnscreens.bottomsheet.SheetDelegate;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import com.swmansion.rnscreens.events.SheetDetentChangedEvent;
import com.swmansion.rnscreens.ext.FragmentExtKt;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Screen.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 å\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\fà\u0001á\u0001â\u0001ã\u0001ä\u0001å\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010|\u001a\u0004\u0018\u00010\u000bH\u0016J4\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020(2\u0007\u0010\u0080\u0001\u001a\u00020?2\u0007\u0010\u0081\u0001\u001a\u00020?2\u0007\u0010\u0082\u0001\u001a\u00020?2\u0007\u0010\u0083\u0001\u001a\u00020?H\u0016J\u0011\u0010\u0084\u0001\u001a\u00020~2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J\u0019\u0010\u0087\u0001\u001a\u00020~2\u000e\u0010\u001c\u001a\n\u0012\u0005\u0012\u00030\u0089\u00010\u0088\u0001H\u0014J\u0019\u0010\u008a\u0001\u001a\u00020~2\u000e\u0010\u001c\u001a\n\u0012\u0005\u0012\u00030\u0089\u00010\u0088\u0001H\u0014J5\u0010\u008b\u0001\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020(2\u0007\u0010\u008c\u0001\u001a\u00020?2\u0007\u0010\u008d\u0001\u001a\u00020?2\u0007\u0010\u008e\u0001\u001a\u00020?2\u0007\u0010\u008f\u0001\u001a\u00020?H\u0014J\u0018\u0010\u0090\u0001\u001a\u00020~2\u0007\u0010\u0091\u0001\u001a\u00020(H\u0000¢\u0006\u0003\b\u0092\u0001J\t\u0010\u0093\u0001\u001a\u00020~H\u0002J\u001b\u0010\u0094\u0001\u001a\u00020~2\u0007\u0010\u0095\u0001\u001a\u00020?2\u0007\u0010\u0096\u0001\u001a\u00020?H\u0002J$\u0010\u0097\u0001\u001a\u00020~2\u0007\u0010\u0095\u0001\u001a\u00020?2\u0007\u0010\u0096\u0001\u001a\u00020?2\u0007\u0010\u0098\u0001\u001a\u00020?H\u0002J\u0010\u0010 \u0001\u001a\u00020~2\u0007\u0010¡\u0001\u001a\u00020(J\u0007\u0010¢\u0001\u001a\u00020(J\u0013\u0010£\u0001\u001a\u00020(2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u001e\u0010¦\u0001\u001a\u00020~2\u0007\u0010§\u0001\u001a\u00020?2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\u000f\u0010ª\u0001\u001a\u00020~2\u0006\u0010$\u001a\u00020#J\u0011\u0010«\u0001\u001a\u00020~2\b\u0010@\u001a\u0004\u0018\u00010EJ\u0010\u0010¬\u0001\u001a\u00020~2\u0007\u0010\u00ad\u0001\u001a\u00020?J\u0007\u0010Ì\u0001\u001a\u00020~J\u0007\u0010Í\u0001\u001a\u00020~J\u0013\u0010Î\u0001\u001a\u00020~2\b\u0010Ï\u0001\u001a\u00030¥\u0001H\u0002J\u0015\u0010Ð\u0001\u001a\u00020~2\n\u0010Ï\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0002J\u0015\u0010Ñ\u0001\u001a\u00020(2\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0017J\u0012\u0010Ô\u0001\u001a\u00020~2\u0007\u0010Õ\u0001\u001a\u00020?H\u0002J!\u0010Ö\u0001\u001a\u00020~2\u0007\u0010×\u0001\u001a\u00020?2\u0007\u0010Ø\u0001\u001a\u00020(H\u0000¢\u0006\u0003\bÙ\u0001J\t\u0010Ú\u0001\u001a\u00020~H\u0014J\u001b\u0010Û\u0001\u001a\u00020~2\u0007\u0010×\u0001\u001a\u00020?2\u0007\u0010Ø\u0001\u001a\u00020(H\u0002J\u000f\u0010Ü\u0001\u001a\u00020~H\u0000¢\u0006\u0003\bÝ\u0001J\u000f\u0010Þ\u0001\u001a\u00020~H\u0000¢\u0006\u0003\bß\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?2\b\u0010\"\u001a\u0004\u0018\u00010?@BX\u0086\u000e¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010J\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010N\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010O\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010<\"\u0004\bP\u0010>R\u001a\u0010Q\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010<\"\u0004\bR\u0010>R\u000e\u0010S\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010U\u001a\u00020T2\u0006\u0010\"\u001a\u00020T@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010<\"\u0004\b\\\u0010>R \u0010]\u001a\b\u0012\u0004\u0012\u00020_0^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR\u001a\u0010l\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010<\"\u0004\bn\u0010>R\u001a\u0010o\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010W\"\u0004\bq\u0010YR\u001a\u0010r\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010<\"\u0004\bt\u0010>R(\u0010v\u001a\u0004\u0018\u00010u2\b\u0010\"\u001a\u0004\u0018\u00010u@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0014\u0010{\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010<R\u0017\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00018F¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0017\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0086\u00018F¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R,\u0010®\u0001\u001a\u0004\u0018\u00010E2\t\u0010®\u0001\u001a\u0004\u0018\u00010E@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010G\"\u0005\b°\u0001\u0010IR.\u0010²\u0001\u001a\u0004\u0018\u00010(2\t\u0010±\u0001\u001a\u0004\u0018\u00010(@FX\u0086\u000e¢\u0006\u0012\n\u0002\u0010N\u001a\u0005\b²\u0001\u0010K\"\u0005\b³\u0001\u0010MR8\u0010µ\u0001\u001a\u0004\u0018\u00010(2\t\u0010´\u0001\u001a\u0004\u0018\u00010(8\u0006@FX\u0087\u000e¢\u0006\u001a\n\u0002\u0010N\u0012\u0006\b¶\u0001\u0010·\u0001\u001a\u0005\bµ\u0001\u0010K\"\u0005\b¸\u0001\u0010MR9\u0010¹\u0001\u001a\u0004\u0018\u00010?2\t\u0010¹\u0001\u001a\u0004\u0018\u00010?8\u0006@FX\u0087\u000e¢\u0006\u001b\n\u0002\u0010C\u0012\u0006\bº\u0001\u0010·\u0001\u001a\u0005\b»\u0001\u0010B\"\u0006\b¼\u0001\u0010½\u0001R9\u0010¾\u0001\u001a\u0004\u0018\u00010?2\t\u0010¾\u0001\u001a\u0004\u0018\u00010?8\u0006@FX\u0087\u000e¢\u0006\u001b\n\u0002\u0010C\u0012\u0006\b¿\u0001\u0010·\u0001\u001a\u0005\bÀ\u0001\u0010B\"\u0006\bÁ\u0001\u0010½\u0001R8\u0010Ã\u0001\u001a\u0004\u0018\u00010(2\t\u0010Â\u0001\u001a\u0004\u0018\u00010(8\u0006@FX\u0087\u000e¢\u0006\u001a\n\u0002\u0010N\u0012\u0006\bÄ\u0001\u0010·\u0001\u001a\u0005\bÃ\u0001\u0010K\"\u0005\bÅ\u0001\u0010MR.\u0010Ç\u0001\u001a\u0004\u0018\u00010(2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010(@FX\u0086\u000e¢\u0006\u0012\n\u0002\u0010N\u001a\u0005\bÇ\u0001\u0010K\"\u0005\bÈ\u0001\u0010MR\u001d\u0010É\u0001\u001a\u00020(X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010<\"\u0005\bË\u0001\u0010>¨\u0006æ\u0001"}, d2 = {"Lcom/swmansion/rnscreens/Screen;", "Lcom/swmansion/rnscreens/FabricEnabledViewGroup;", "Lcom/swmansion/rnscreens/ScreenContentWrapper$OnLayoutCallback;", "Lcom/swmansion/rnscreens/gamma/common/FragmentProviding;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "sheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "reactEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "getReactEventDispatcher", "()Lcom/facebook/react/uimanager/events/EventDispatcher;", "fragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "getFragmentWrapper", "()Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "setFragmentWrapper", "(Lcom/swmansion/rnscreens/ScreenFragmentWrapper;)V", "container", "Lcom/swmansion/rnscreens/ScreenContainer;", "getContainer", "()Lcom/swmansion/rnscreens/ScreenContainer;", "setContainer", "(Lcom/swmansion/rnscreens/ScreenContainer;)V", "value", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "activityState", "getActivityState", "()Lcom/swmansion/rnscreens/Screen$ActivityState;", "isTransitioning", "", "stackPresentation", "Lcom/swmansion/rnscreens/Screen$StackPresentation;", "getStackPresentation", "()Lcom/swmansion/rnscreens/Screen$StackPresentation;", "setStackPresentation", "(Lcom/swmansion/rnscreens/Screen$StackPresentation;)V", "replaceAnimation", "Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "getReplaceAnimation", "()Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "setReplaceAnimation", "(Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;)V", "stackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "getStackAnimation", "()Lcom/swmansion/rnscreens/Screen$StackAnimation;", "setStackAnimation", "(Lcom/swmansion/rnscreens/Screen$StackAnimation;)V", "isGestureEnabled", "()Z", "setGestureEnabled", "(Z)V", "", "screenOrientation", "getScreenOrientation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "screenId", "", "getScreenId", "()Ljava/lang/String;", "setScreenId", "(Ljava/lang/String;)V", "isStatusBarAnimated", "()Ljava/lang/Boolean;", "setStatusBarAnimated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isBeingRemoved", "setBeingRemoved", "isSheetGrabberVisible", "setSheetGrabberVisible", "shouldUpdateSheetCornerRadius", "", "sheetCornerRadius", "getSheetCornerRadius", "()F", "setSheetCornerRadius", "(F)V", "sheetExpandsWhenScrolledToEdge", "getSheetExpandsWhenScrolledToEdge", "setSheetExpandsWhenScrolledToEdge", "sheetDetents", "", "", "getSheetDetents", "()Ljava/util/List;", "setSheetDetents", "(Ljava/util/List;)V", "sheetLargestUndimmedDetentIndex", "getSheetLargestUndimmedDetentIndex", "()I", "setSheetLargestUndimmedDetentIndex", "(I)V", "sheetInitialDetentIndex", "getSheetInitialDetentIndex", "setSheetInitialDetentIndex", "sheetClosesOnTouchOutside", "getSheetClosesOnTouchOutside", "setSheetClosesOnTouchOutside", "sheetElevation", "getSheetElevation", "setSheetElevation", "shouldTriggerPostponedTransitionAfterLayout", "getShouldTriggerPostponedTransitionAfterLayout", "setShouldTriggerPostponedTransitionAfterLayout", "Lcom/swmansion/rnscreens/ScreenFooter;", "footer", "getFooter", "()Lcom/swmansion/rnscreens/ScreenFooter;", "setFooter", "(Lcom/swmansion/rnscreens/ScreenFooter;)V", "isNativeStackScreen", "getAssociatedFragment", "onContentWrapperLayout", "", "changed", ViewProps.LEFT, ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "registerLayoutCallbackForWrapper", "wrapper", "Lcom/swmansion/rnscreens/ScreenContentWrapper;", "dispatchSaveInstanceState", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchRestoreInstanceState", "onLayout", "l", "t", "r", "b", "onBottomSheetBehaviorDidLayout", "coordinatorLayoutDidChange", "onBottomSheetBehaviorDidLayout$react_native_screens_release", "triggerPostponedEnterTransitionIfNeeded", "updateScreenSizePaper", "width", "height", "dispatchShadowStateUpdate", "offsetY", "headerConfig", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "getHeaderConfig", "()Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "contentWrapper", "getContentWrapper", "()Lcom/swmansion/rnscreens/ScreenContentWrapper;", "setTransitioning", "transitioning", "isTranslucent", "hasWebView", "viewGroup", "Landroid/view/ViewGroup;", "setLayerType", "layerType", "paint", "Landroid/graphics/Paint;", "setActivityState", "setScreenOrientation", "changeAccessibilityMode", "mode", "statusBarStyle", "getStatusBarStyle", "setStatusBarStyle", "statusBarHidden", "isStatusBarHidden", "setStatusBarHidden", "statusBarTranslucent", "isStatusBarTranslucent", "isStatusBarTranslucent$annotations", "()V", "setStatusBarTranslucent", "statusBarColor", "getStatusBarColor$annotations", "getStatusBarColor", "setStatusBarColor", "(Ljava/lang/Integer;)V", "navigationBarColor", "getNavigationBarColor$annotations", "getNavigationBarColor", "setNavigationBarColor", "navigationBarTranslucent", "isNavigationBarTranslucent", "isNavigationBarTranslucent$annotations", "setNavigationBarTranslucent", "navigationBarHidden", "isNavigationBarHidden", "setNavigationBarHidden", "nativeBackButtonDismissalEnabled", "getNativeBackButtonDismissalEnabled", "setNativeBackButtonDismissalEnabled", "startRemovalTransition", "endRemovalTransition", "endTransitionRecursive", "parent", "startTransitionRecursive", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "notifyHeaderHeightChange", "headerHeight", "onSheetDetentChanged", "detentIndex", "isStable", "onSheetDetentChanged$react_native_screens_release", "onAttachedToWindow", "dispatchSheetDetentChanged", "onFinalizePropsUpdate", "onFinalizePropsUpdate$react_native_screens_release", "onSheetCornerRadiusChange", "onSheetCornerRadiusChange$react_native_screens_release", "StackPresentation", "StackAnimation", "ReplaceAnimation", "ActivityState", "WindowTraits", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Screen extends FabricEnabledViewGroup implements ScreenContentWrapper.OnLayoutCallback, FragmentProviding {
    public static final double SHEET_FIT_TO_CONTENTS = -1.0d;
    public static final String TAG = "Screen";
    private ActivityState activityState;
    private ScreenContainer container;
    private ScreenFooter footer;
    private ScreenFragmentWrapper fragmentWrapper;
    private boolean isBeingRemoved;
    private boolean isGestureEnabled;
    private Boolean isNavigationBarHidden;
    private Boolean isNavigationBarTranslucent;
    private boolean isSheetGrabberVisible;
    private Boolean isStatusBarAnimated;
    private Boolean isStatusBarHidden;
    private Boolean isStatusBarTranslucent;
    private boolean isTransitioning;
    private boolean nativeBackButtonDismissalEnabled;
    private Integer navigationBarColor;
    private final ThemedReactContext reactContext;
    private ReplaceAnimation replaceAnimation;
    private String screenId;
    private Integer screenOrientation;
    private boolean sheetClosesOnTouchOutside;
    private float sheetCornerRadius;
    private List<Double> sheetDetents;
    private float sheetElevation;
    private boolean sheetExpandsWhenScrolledToEdge;
    private int sheetInitialDetentIndex;
    private int sheetLargestUndimmedDetentIndex;
    private boolean shouldTriggerPostponedTransitionAfterLayout;
    private boolean shouldUpdateSheetCornerRadius;
    private StackAnimation stackAnimation;
    private StackPresentation stackPresentation;
    private Integer statusBarColor;
    private String statusBarStyle;

    /* JADX INFO: compiled from: Screen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ActivityState;", "", "<init>", "(Ljava/lang/String;I)V", "INACTIVE", "TRANSITIONING_OR_BELOW_TOP", "ON_TOP", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ActivityState {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ActivityState> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: Screen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "", "<init>", "(Ljava/lang/String;I)V", "PUSH", "POP", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ReplaceAnimation {
        PUSH,
        POP;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ReplaceAnimation> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: Screen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackAnimation;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "NONE", "FADE", "SLIDE_FROM_BOTTOM", "SLIDE_FROM_RIGHT", "SLIDE_FROM_LEFT", "FADE_FROM_BOTTOM", "IOS_FROM_RIGHT", "IOS_FROM_LEFT", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_BOTTOM,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT,
        FADE_FROM_BOTTOM,
        IOS_FROM_RIGHT,
        IOS_FROM_LEFT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<StackAnimation> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: Screen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackPresentation;", "", "<init>", "(Ljava/lang/String;I)V", "PUSH", "MODAL", "TRANSPARENT_MODAL", "FORM_SHEET", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL,
        FORM_SHEET;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<StackPresentation> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: Screen.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackPresentation.values().length];
            try {
                iArr[StackPresentation.TRANSPARENT_MODAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackPresentation.FORM_SHEET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: compiled from: Screen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/swmansion/rnscreens/Screen$WindowTraits;", "", "<init>", "(Ljava/lang/String;I)V", "ORIENTATION", "COLOR", "STYLE", "TRANSLUCENT", "HIDDEN", "ANIMATED", "NAVIGATION_BAR_COLOR", "NAVIGATION_BAR_TRANSLUCENT", "NAVIGATION_BAR_HIDDEN", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum WindowTraits {
        ORIENTATION,
        COLOR,
        STYLE,
        TRANSLUCENT,
        HIDDEN,
        ANIMATED,
        NAVIGATION_BAR_COLOR,
        NAVIGATION_BAR_TRANSLUCENT,
        NAVIGATION_BAR_HIDDEN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<WindowTraits> getEntries() {
            return $ENTRIES;
        }
    }

    @Deprecated(message = "For all apps targeting Android SDK 35 or above edge-to-edge is enabled by default. ")
    public static /* synthetic */ void getNavigationBarColor$annotations() {
    }

    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect because edge-to-edge is enabled by default and the status bar is always translucent.")
    public static /* synthetic */ void getStatusBarColor$annotations() {
    }

    @Deprecated(message = "For all apps targeting Android SDK 35 or above edge-to-edge is enabled by default. ")
    public static /* synthetic */ void isNavigationBarTranslucent$annotations() {
    }

    @Deprecated(message = "For apps targeting SDK 35 or above this prop has no effect because edge-to-edge is enabled by default and the status bar is always translucent.")
    public static /* synthetic */ void isStatusBarTranslucent$annotations() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // android.view.View
    public void setLayerType(int layerType, Paint paint) {
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Screen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.stackPresentation = StackPresentation.PUSH;
        this.replaceAnimation = ReplaceAnimation.POP;
        this.stackAnimation = StackAnimation.DEFAULT;
        this.isGestureEnabled = true;
        this.sheetExpandsWhenScrolledToEdge = true;
        this.sheetDetents = CollectionsKt.mutableListOf(Double.valueOf(1.0d));
        this.sheetLargestUndimmedDetentIndex = -1;
        this.sheetClosesOnTouchOutside = true;
        this.sheetElevation = 24.0f;
        setLayoutParams(new WindowManager.LayoutParams(2));
        this.nativeBackButtonDismissalEnabled = true;
    }

    public final Fragment getFragment() {
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.getFragment();
        }
        return null;
    }

    public final BottomSheetBehavior<Screen> getSheetBehavior() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        CoordinatorLayout.Behavior behavior = layoutParams2 != null ? layoutParams2.getBehavior() : null;
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        return null;
    }

    public final EventDispatcher getReactEventDispatcher() {
        return UIManagerHelper.getEventDispatcherForReactTag(this.reactContext, getId());
    }

    public final ScreenFragmentWrapper getFragmentWrapper() {
        return this.fragmentWrapper;
    }

    public final void setFragmentWrapper(ScreenFragmentWrapper screenFragmentWrapper) {
        this.fragmentWrapper = screenFragmentWrapper;
    }

    public final ScreenContainer getContainer() {
        return this.container;
    }

    public final void setContainer(ScreenContainer screenContainer) {
        this.container = screenContainer;
    }

    public final ActivityState getActivityState() {
        return this.activityState;
    }

    public final StackPresentation getStackPresentation() {
        return this.stackPresentation;
    }

    public final void setStackPresentation(StackPresentation stackPresentation) {
        Intrinsics.checkNotNullParameter(stackPresentation, "<set-?>");
        this.stackPresentation = stackPresentation;
    }

    public final ReplaceAnimation getReplaceAnimation() {
        return this.replaceAnimation;
    }

    public final void setReplaceAnimation(ReplaceAnimation replaceAnimation) {
        Intrinsics.checkNotNullParameter(replaceAnimation, "<set-?>");
        this.replaceAnimation = replaceAnimation;
    }

    public final StackAnimation getStackAnimation() {
        return this.stackAnimation;
    }

    public final void setStackAnimation(StackAnimation stackAnimation) {
        Intrinsics.checkNotNullParameter(stackAnimation, "<set-?>");
        this.stackAnimation = stackAnimation;
    }

    /* JADX INFO: renamed from: isGestureEnabled, reason: from getter */
    public final boolean getIsGestureEnabled() {
        return this.isGestureEnabled;
    }

    public final void setGestureEnabled(boolean z) {
        this.isGestureEnabled = z;
    }

    public final Integer getScreenOrientation() {
        return this.screenOrientation;
    }

    public final String getScreenId() {
        return this.screenId;
    }

    public final void setScreenId(String str) {
        this.screenId = str;
    }

    /* JADX INFO: renamed from: isStatusBarAnimated, reason: from getter */
    public final Boolean getIsStatusBarAnimated() {
        return this.isStatusBarAnimated;
    }

    public final void setStatusBarAnimated(Boolean bool) {
        this.isStatusBarAnimated = bool;
    }

    /* JADX INFO: renamed from: isBeingRemoved, reason: from getter */
    public final boolean getIsBeingRemoved() {
        return this.isBeingRemoved;
    }

    public final void setBeingRemoved(boolean z) {
        this.isBeingRemoved = z;
    }

    /* JADX INFO: renamed from: isSheetGrabberVisible, reason: from getter */
    public final boolean getIsSheetGrabberVisible() {
        return this.isSheetGrabberVisible;
    }

    public final void setSheetGrabberVisible(boolean z) {
        this.isSheetGrabberVisible = z;
    }

    public final float getSheetCornerRadius() {
        return this.sheetCornerRadius;
    }

    public final void setSheetCornerRadius(float f) {
        if (this.sheetCornerRadius == f) {
            return;
        }
        this.sheetCornerRadius = f;
        this.shouldUpdateSheetCornerRadius = true;
    }

    public final boolean getSheetExpandsWhenScrolledToEdge() {
        return this.sheetExpandsWhenScrolledToEdge;
    }

    public final void setSheetExpandsWhenScrolledToEdge(boolean z) {
        this.sheetExpandsWhenScrolledToEdge = z;
    }

    public final List<Double> getSheetDetents() {
        return this.sheetDetents;
    }

    public final void setSheetDetents(List<Double> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sheetDetents = list;
    }

    public final int getSheetLargestUndimmedDetentIndex() {
        return this.sheetLargestUndimmedDetentIndex;
    }

    public final void setSheetLargestUndimmedDetentIndex(int i) {
        this.sheetLargestUndimmedDetentIndex = i;
    }

    public final int getSheetInitialDetentIndex() {
        return this.sheetInitialDetentIndex;
    }

    public final void setSheetInitialDetentIndex(int i) {
        this.sheetInitialDetentIndex = i;
    }

    public final boolean getSheetClosesOnTouchOutside() {
        return this.sheetClosesOnTouchOutside;
    }

    public final void setSheetClosesOnTouchOutside(boolean z) {
        this.sheetClosesOnTouchOutside = z;
    }

    public final float getSheetElevation() {
        return this.sheetElevation;
    }

    public final void setSheetElevation(float f) {
        this.sheetElevation = f;
    }

    public final boolean getShouldTriggerPostponedTransitionAfterLayout() {
        return this.shouldTriggerPostponedTransitionAfterLayout;
    }

    public final void setShouldTriggerPostponedTransitionAfterLayout(boolean z) {
        this.shouldTriggerPostponedTransitionAfterLayout = z;
    }

    public final ScreenFooter getFooter() {
        return this.footer;
    }

    public final void setFooter(ScreenFooter screenFooter) {
        BottomSheetBehavior<Screen> sheetBehavior;
        if (screenFooter == null && this.footer != null) {
            BottomSheetBehavior<Screen> sheetBehavior2 = getSheetBehavior();
            if (sheetBehavior2 != null) {
                ScreenFooter screenFooter2 = this.footer;
                Intrinsics.checkNotNull(screenFooter2);
                screenFooter2.unregisterWithSheetBehavior(sheetBehavior2);
            }
        } else if (screenFooter != null && (sheetBehavior = getSheetBehavior()) != null) {
            screenFooter.registerWithSheetBehavior(sheetBehavior);
        }
        this.footer = screenFooter;
    }

    private final boolean isNativeStackScreen() {
        return this.container instanceof ScreenStack;
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getAssociatedFragment() {
        return getFragment();
    }

    @Override // com.swmansion.rnscreens.ScreenContentWrapper.OnLayoutCallback
    public void onContentWrapperLayout(boolean changed, int left, int top, int right, int bottom) {
        BottomSheetBehavior<Screen> sheetBehavior;
        int i = bottom - top;
        if (SheetUtilsKt.usesFormSheetPresentation(this) && SheetUtilsKt.isSheetFitToContents(this) && (sheetBehavior = getSheetBehavior()) != null) {
            BottomSheetBehaviorExtKt.useSingleDetent$default(sheetBehavior, Integer.valueOf(i), false, 2, null);
        }
    }

    public final void registerLayoutCallbackForWrapper(ScreenContentWrapper wrapper) {
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        wrapper.setDelegate$react_native_screens_release(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed && isNativeStackScreen() && !SheetUtilsKt.usesFormSheetPresentation(this)) {
            dispatchShadowStateUpdate(r - l, b - t, t);
            notifyHeaderHeightChange(t);
        }
    }

    public final void onBottomSheetBehaviorDidLayout$react_native_screens_release(boolean coordinatorLayoutDidChange) {
        if (SheetUtilsKt.usesFormSheetPresentation(this) && isNativeStackScreen()) {
            if (coordinatorLayoutDidChange) {
                dispatchShadowStateUpdate(getWidth(), getHeight(), getTop());
            }
            ScreenFooter screenFooter = this.footer;
            if (screenFooter != null) {
                int left = getLeft();
                int top = getTop();
                int right = getRight();
                int bottom = getBottom();
                ScreenContainer screenContainer = this.container;
                Intrinsics.checkNotNull(screenContainer);
                screenFooter.onParentLayout(coordinatorLayoutDidChange, left, top, right, bottom, screenContainer.getHeight());
            }
        }
    }

    private final void triggerPostponedEnterTransitionIfNeeded() {
        if (this.shouldTriggerPostponedTransitionAfterLayout) {
            this.shouldTriggerPostponedTransitionAfterLayout = false;
            Fragment fragment = getFragment();
            if (fragment != null) {
                fragment.startPostponedEnterTransition();
            }
        }
    }

    private final void updateScreenSizePaper(int width, int height) {
        ThemedReactContext themedReactContext = this.reactContext;
        themedReactContext.runOnNativeModulesQueueThread(new GuardedRunnable(width, height, themedReactContext.getExceptionHandler()) { // from class: com.swmansion.rnscreens.Screen.updateScreenSizePaper.1
            final /* synthetic */ int $height;
            final /* synthetic */ int $width;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(jSExceptionHandler);
                Intrinsics.checkNotNull(jSExceptionHandler);
            }

            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                UIManagerModule uIManagerModule = (UIManagerModule) Screen.this.getReactContext().getNativeModule(UIManagerModule.class);
                if (uIManagerModule != null) {
                    uIManagerModule.updateNodeSize(Screen.this.getId(), this.$width, this.$height);
                }
            }
        });
    }

    private final void dispatchShadowStateUpdate(int width, int height, int offsetY) {
        updateScreenSizeFabric(width, height, offsetY);
    }

    public final ScreenStackHeaderConfig getHeaderConfig() {
        View next;
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof ScreenStackHeaderConfig));
        if (next instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) next;
        }
        return null;
    }

    public final ScreenContentWrapper getContentWrapper() {
        View next;
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof ScreenContentWrapper));
        if (next instanceof ScreenContentWrapper) {
            return (ScreenContentWrapper) next;
        }
        return null;
    }

    public final void setTransitioning(boolean transitioning) {
        if (this.isTransitioning == transitioning) {
            return;
        }
        this.isTransitioning = transitioning;
        boolean zHasWebView = hasWebView(this);
        if (!zHasWebView || getLayerType() == 2) {
            super.setLayerType((!transitioning || zHasWebView) ? 0 : 2, null);
        }
    }

    public final boolean isTranslucent() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.stackPresentation.ordinal()];
        return i == 1 || i == 2;
    }

    private final boolean hasWebView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasWebView((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void setActivityState(ActivityState activityState) {
        Intrinsics.checkNotNullParameter(activityState, "activityState");
        ActivityState activityState2 = this.activityState;
        if (activityState == activityState2) {
            return;
        }
        if ((this.container instanceof ScreenStack) && activityState2 != null) {
            Intrinsics.checkNotNull(activityState2);
            if (activityState.compareTo(activityState2) < 0) {
                throw new IllegalStateException("[RNScreens] activityState can only progress in NativeStack");
            }
        }
        this.activityState = activityState;
        ScreenContainer screenContainer = this.container;
        if (screenContainer != null) {
            screenContainer.onChildUpdate();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    public final void setScreenOrientation(String screenOrientation) {
        int i;
        if (screenOrientation == null) {
            this.screenOrientation = null;
            return;
        }
        ScreenWindowTraits.INSTANCE.applyDidSetOrientation$react_native_screens_release();
        switch (screenOrientation) {
            case "portrait_down":
                i = 9;
                break;
            case "all":
                i = 10;
                break;
            case "portrait":
                i = 7;
                break;
            case "landscape":
                i = 6;
                break;
            case "portrait_up":
                i = 1;
                break;
            case "landscape_left":
                i = 8;
                break;
            case "landscape_right":
                i = 0;
                break;
            default:
                i = -1;
                break;
        }
        this.screenOrientation = Integer.valueOf(i);
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setOrientation$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final void changeAccessibilityMode(int mode) {
        CustomToolbar toolbar;
        setImportantForAccessibility(mode);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        if (headerConfig == null || (toolbar = headerConfig.getToolbar()) == null) {
            return;
        }
        toolbar.setImportantForAccessibility(mode);
    }

    public final String getStatusBarStyle() {
        return this.statusBarStyle;
    }

    public final void setStatusBarStyle(String str) {
        if (str != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.statusBarStyle = str;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setStyle$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    /* JADX INFO: renamed from: isStatusBarHidden, reason: from getter */
    public final Boolean getIsStatusBarHidden() {
        return this.isStatusBarHidden;
    }

    public final void setStatusBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.isStatusBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    /* JADX INFO: renamed from: isStatusBarTranslucent, reason: from getter */
    public final Boolean getIsStatusBarTranslucent() {
        return this.isStatusBarTranslucent;
    }

    public final void setStatusBarTranslucent(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.isStatusBarTranslucent = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setTranslucent$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final Integer getStatusBarColor() {
        return this.statusBarColor;
    }

    public final void setStatusBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.statusBarColor = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setColor$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final Integer getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public final void setNavigationBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.navigationBarColor = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarColor$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    /* JADX INFO: renamed from: isNavigationBarTranslucent, reason: from getter */
    public final Boolean getIsNavigationBarTranslucent() {
        return this.isNavigationBarTranslucent;
    }

    public final void setNavigationBarTranslucent(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.isNavigationBarTranslucent = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarTranslucent$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    /* JADX INFO: renamed from: isNavigationBarHidden, reason: from getter */
    public final Boolean getIsNavigationBarHidden() {
        return this.isNavigationBarHidden;
    }

    public final void setNavigationBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.isNavigationBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.nativeBackButtonDismissalEnabled;
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z) {
        this.nativeBackButtonDismissalEnabled = z;
    }

    public final void startRemovalTransition() {
        if (this.isBeingRemoved) {
            return;
        }
        this.isBeingRemoved = true;
        startTransitionRecursive(this);
    }

    public final void endRemovalTransition() {
        if (this.isBeingRemoved) {
            this.isBeingRemoved = false;
            endTransitionRecursive(this);
        }
    }

    private final void endTransitionRecursive(ViewGroup parent) {
        for (View view : ViewGroupKt.getChildren(parent)) {
            parent.endViewTransition(view);
            if (view instanceof ScreenStackHeaderConfig) {
                endTransitionRecursive(((ScreenStackHeaderConfig) view).getToolbar());
            }
            if (view instanceof ViewGroup) {
                endTransitionRecursive((ViewGroup) view);
            }
        }
    }

    private final void startTransitionRecursive(ViewGroup parent) {
        if (parent != null) {
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = parent.getChildAt(i);
                if ((parent instanceof SwipeRefreshLayout) && (childAt instanceof ImageView)) {
                    parent.addView(new View(getContext()), i);
                } else if (childAt != null) {
                    parent.startViewTransition(childAt);
                }
                if (childAt instanceof ScreenStackHeaderConfig) {
                    startTransitionRecursive(((ScreenStackHeaderConfig) childAt).getToolbar());
                }
                if (childAt instanceof ViewGroup) {
                    startTransitionRecursive((ViewGroup) childAt);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (SheetUtilsKt.usesFormSheetPresentation(this)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    private final void notifyHeaderHeightChange(int headerHeight) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderHeightChangeEvent(surfaceId, getId(), headerHeight));
        }
    }

    public final void onSheetDetentChanged$react_native_screens_release(int detentIndex, boolean isStable) {
        dispatchSheetDetentChanged(detentIndex, isStable);
        if (isStable) {
            updateScreenSizeFabric(getWidth(), getHeight(), getTop());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Fragment fragment;
        ScreenStackFragment screenStackFragmentAsScreenStackFragment;
        SheetDelegate sheetDelegate$react_native_screens_release;
        super.onAttachedToWindow();
        if (!SheetUtilsKt.usesFormSheetPresentation(this) || (fragment = getFragment()) == null || (screenStackFragmentAsScreenStackFragment = FragmentExtKt.asScreenStackFragment(fragment)) == null || (sheetDelegate$react_native_screens_release = screenStackFragmentAsScreenStackFragment.getSheetDelegate()) == null) {
            return;
        }
        InsetsObserverProxy.INSTANCE.addOnApplyWindowInsetsListener(sheetDelegate$react_native_screens_release);
    }

    private final void dispatchSheetDetentChanged(int detentIndex, boolean isStable) {
        int surfaceId = UIManagerHelper.getSurfaceId(this.reactContext);
        EventDispatcher reactEventDispatcher = getReactEventDispatcher();
        if (reactEventDispatcher != null) {
            reactEventDispatcher.dispatchEvent(new SheetDetentChangedEvent(surfaceId, getId(), detentIndex, isStable));
        }
    }

    public final void onFinalizePropsUpdate$react_native_screens_release() {
        if (this.shouldUpdateSheetCornerRadius) {
            this.shouldUpdateSheetCornerRadius = false;
            onSheetCornerRadiusChange$react_native_screens_release();
        }
    }

    public final void onSheetCornerRadiusChange$react_native_screens_release() {
        if (this.stackPresentation != StackPresentation.FORM_SHEET || getBackground() == null) {
            return;
        }
        Drawable background = getBackground();
        MaterialShapeDrawable materialShapeDrawable = background instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background : null;
        if (materialShapeDrawable != null) {
            float dIPFromPixel = PixelUtil.toDIPFromPixel(this.sheetCornerRadius);
            ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
            builder.setTopLeftCorner(0, dIPFromPixel);
            builder.setTopRightCorner(0, dIPFromPixel);
            materialShapeDrawable.setShapeAppearanceModel(builder.build());
        }
    }
}
