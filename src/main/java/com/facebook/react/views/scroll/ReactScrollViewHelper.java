package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReactScrollViewHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\tabcdefghiB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u001e\u001a\u00020\u001f\"\u000e\b\u0000\u0010 *\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0002\u0010'J%\u0010(\u001a\u00020\u001f\"\u000e\b\u0000\u0010 *\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H H\u0007¢\u0006\u0002\u0010)J5\u0010*\u001a\u00020\u001f\"\u000e\b\u0000\u0010 *\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0002\u0010'J5\u0010+\u001a\u00020\u001f\"\u000e\b\u0000\u0010 *\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010,J%\u0010-\u001a\u00020\u001f\"\u000e\b\u0000\u0010 *\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H H\u0007¢\u0006\u0002\u0010)J-\u0010\u001e\u001a\u00020\u001f\"\u000e\b\u0000\u0010 *\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010.\u001a\u00020/H\u0002¢\u0006\u0002\u00100J=\u0010\u001e\u001a\u00020\u001f\"\u000e\b\u0000\u0010 *\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"H\u0007J\u0010\u00103\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"H\u0007J\u0012\u00104\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u00108\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0019H\u0007J\u0010\u0010=\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0019H\u0007J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001bH\u0007J\u0010\u0010?\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001bH\u0007JA\u0010@\u001a\u00020\u001f\"\u001a\b\u0000\u0010 *\u0004\u0018\u00010A*\u0004\u0018\u00010B*\u0004\u0018\u00010C*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010,JC\u0010F\u001a\u00020\u0012\"\u0014\b\u0000\u0010 *\u0004\u0018\u00010A*\u0004\u0018\u00010B*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010JJ1\u0010K\u001a\u00020\u001f\"\u001a\b\u0000\u0010 *\u0004\u0018\u00010A*\u0004\u0018\u00010B*\u0004\u0018\u00010C*\u00020\"2\u0006\u0010#\u001a\u0002H H\u0007¢\u0006\u0002\u0010)J9\u0010K\u001a\u00020\u001f\"\u0014\b\u0000\u0010 *\u0004\u0018\u00010B*\u0004\u0018\u00010C*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0012¢\u0006\u0002\u0010,J+\u0010N\u001a\u00020\u001f\"\u0014\b\u0000\u0010 *\u0004\u0018\u00010B*\u0004\u0018\u00010C*\u00020\"2\u0006\u0010#\u001a\u0002H H\u0007¢\u0006\u0002\u0010)JG\u0010O\u001a\u00020\u001f\" \b\u0000\u0010 *\u0004\u0018\u00010A*\u0004\u0018\u00010!*\u0004\u0018\u00010B*\u0004\u0018\u00010C*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0002\u0010'J/\u0010P\u001a\u00020\u001f\"\u001a\b\u0000\u0010 *\u0004\u0018\u00010A*\u0004\u0018\u00010B*\u0004\u0018\u00010C*\u00020\"2\u0006\u0010#\u001a\u0002H ¢\u0006\u0002\u0010)J+\u0010Q\u001a\u00020\u001f\"\u0014\b\u0000\u0010 *\u0004\u0018\u00010A*\u0004\u0018\u00010!*\u00020\"2\u0006\u0010#\u001a\u0002H H\u0007¢\u0006\u0002\u0010)JK\u0010R\u001a\u00020S\"\u0014\b\u0000\u0010 *\u0004\u0018\u00010A*\u0004\u0018\u00010B*\u00020\"2\u0006\u0010#\u001a\u0002H 2\u0006\u0010T\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010XJ\"\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010[\u001a\u00020\"2\u0006\u0010\\\u001a\u00020Z2\u0006\u0010]\u001a\u00020\u0012H\u0007J \u0010^\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020\u0012H\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "DEBUG_MODE", "", "CONTENT_OFFSET_LEFT", "CONTENT_OFFSET_TOP", "SCROLL_AWAY_PADDING_TOP", "MOMENTUM_DELAY", "", "OVER_SCROLL_ALWAYS", "AUTO", "OVER_SCROLL_NEVER", "SNAP_ALIGNMENT_DISABLED", "", "SNAP_ALIGNMENT_START", "SNAP_ALIGNMENT_CENTER", "SNAP_ALIGNMENT_END", "scrollListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ScrollListener;", "layoutChangeListeners", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$LayoutChangeListener;", "SMOOTH_SCROLL_DURATION", "smoothScrollDurationInitialized", "emitScrollEvent", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollEventThrottle;", "Landroid/view/ViewGroup;", "scrollView", "xVelocity", "", "yVelocity", "(Landroid/view/ViewGroup;FF)V", "emitScrollBeginDragEvent", "(Landroid/view/ViewGroup;)V", "emitScrollEndDragEvent", "emitScrollMomentumBeginEvent", "(Landroid/view/ViewGroup;II)V", "emitScrollMomentumEndEvent", "scrollEventType", "Lcom/facebook/react/views/scroll/ScrollEventType;", "(Landroid/view/ViewGroup;Lcom/facebook/react/views/scroll/ScrollEventType;)V", "(Landroid/view/ViewGroup;Lcom/facebook/react/views/scroll/ScrollEventType;FF)V", "emitLayoutEvent", "emitLayoutChangeEvent", "parseOverScrollMode", "jsOverScrollMode", "parseSnapToAlignment", "alignment", "getDefaultScrollAnimationDuration", "context", "Landroid/content/Context;", "addScrollListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeScrollListener", "addLayoutChangeListener", "removeLayoutChangeListener", "smoothScrollTo", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasFlingAnimator;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollState;", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasStateWrapper;", "x", "y", "getNextFlingStartValue", "currentValue", "postAnimationValue", "velocity", "(Landroid/view/ViewGroup;III)I", "updateFabricScrollState", "scrollX", "scrollY", "forceUpdateState", "updateStateOnScrollChanged", "registerFlingAnimator", "dispatchMomentumEndOnAnimationEnd", "predictFinalScrollPosition", "Landroid/graphics/Point;", "velocityX", "velocityY", "maximumOffsetX", "maximumOffsetY", "(Landroid/view/ViewGroup;IIII)Landroid/graphics/Point;", "findNextFocusableView", "Landroid/view/View;", "host", "focused", "direction", "resolveAbsoluteDirection", "horizontal", ViewProps.LAYOUT_DIRECTION, "ScrollListener", "LayoutChangeListener", "HasStateWrapper", "OverScrollerDurationGetter", "ReactScrollViewScrollState", "HasScrollState", "HasFlingAnimator", "HasScrollEventThrottle", "HasSmoothScroll", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactScrollViewHelper {
    public static final String AUTO = "auto";
    private static final String CONTENT_OFFSET_LEFT = "contentOffsetLeft";
    private static final String CONTENT_OFFSET_TOP = "contentOffsetTop";
    private static final boolean DEBUG_MODE = false;
    public static final long MOMENTUM_DELAY = 20;
    public static final String OVER_SCROLL_ALWAYS = "always";
    public static final String OVER_SCROLL_NEVER = "never";
    private static final String SCROLL_AWAY_PADDING_TOP = "scrollAwayPaddingTop";
    public static final int SNAP_ALIGNMENT_CENTER = 2;
    public static final int SNAP_ALIGNMENT_DISABLED = 0;
    public static final int SNAP_ALIGNMENT_END = 3;
    public static final int SNAP_ALIGNMENT_START = 1;
    private static boolean smoothScrollDurationInitialized;
    public static final ReactScrollViewHelper INSTANCE = new ReactScrollViewHelper();
    private static final String TAG = "ReactScrollView";
    private static final CopyOnWriteArrayList<WeakReference<ScrollListener>> scrollListeners = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<WeakReference<LayoutChangeListener>> layoutChangeListeners = new CopyOnWriteArrayList<>();
    private static int SMOOTH_SCROLL_DURATION = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasFlingAnimator;", "", "startFlingAnimator", "", ViewProps.START, "", ViewProps.END, "getFlingAnimator", "Landroid/animation/ValueAnimator;", "getFlingExtrapolatedDistance", "velocity", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HasFlingAnimator {
        ValueAnimator getFlingAnimator();

        int getFlingExtrapolatedDistance(int velocity);

        void startFlingAnimator(int start, int end);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollEventThrottle;", "", "scrollEventThrottle", "", "getScrollEventThrottle", "()I", "setScrollEventThrottle", "(I)V", "lastScrollDispatchTime", "", "getLastScrollDispatchTime", "()J", "setLastScrollDispatchTime", "(J)V", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HasScrollEventThrottle {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j);

        void setScrollEventThrottle(int i);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasScrollState;", "", "reactScrollViewScrollState", "Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "getReactScrollViewScrollState", "()Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HasScrollState {
        ReactScrollViewScrollState getReactScrollViewScrollState();
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasSmoothScroll;", "", "reactSmoothScrollTo", "", "x", "", "y", "scrollToPreservingMomentum", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HasSmoothScroll {
        void reactSmoothScrollTo(int x, int y);

        void scrollToPreservingMomentum(int x, int y);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$HasStateWrapper;", "", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface HasStateWrapper {
        StateWrapper getStateWrapper();
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$LayoutChangeListener;", "", "onLayoutChange", "", "scrollView", "Landroid/view/ViewGroup;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface LayoutChangeListener {
        void onLayoutChange(ViewGroup scrollView);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ScrollListener;", "", "onScroll", "", "scrollView", "Landroid/view/ViewGroup;", "scrollEventType", "Lcom/facebook/react/views/scroll/ScrollEventType;", "xVelocity", "", "yVelocity", "onLayout", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ScrollListener {
        void onLayout(ViewGroup scrollView);

        void onScroll(ViewGroup scrollView, ScrollEventType scrollEventType, float xVelocity, float yVelocity);
    }

    @JvmStatic
    public static final int resolveAbsoluteDirection(int direction, boolean horizontal, int layoutDirection) {
        boolean z = layoutDirection == 1;
        if (direction != 1 && direction != 2) {
            return direction;
        }
        if (horizontal) {
            return (direction == 2) != z ? 66 : 17;
        }
        return direction == 2 ? 130 : 33;
    }

    private ReactScrollViewHelper() {
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T scrollView, float xVelocity, float yVelocity) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.SCROLL, xVelocity, yVelocity);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollBeginDragEvent(T scrollView) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.BEGIN_DRAG);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEndDragEvent(T scrollView, float xVelocity, float yVelocity) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.END_DRAG, xVelocity, yVelocity);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumBeginEvent(T scrollView, int xVelocity, int yVelocity) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.MOMENTUM_BEGIN, xVelocity, yVelocity);
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumEndEvent(T scrollView) {
        INSTANCE.emitScrollEvent(scrollView, ScrollEventType.MOMENTUM_END);
    }

    private final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T scrollView, ScrollEventType scrollEventType) {
        emitScrollEvent(scrollView, scrollEventType, 0.0f, 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T scrollView, ScrollEventType scrollEventType, float xVelocity, float yVelocity) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (scrollEventType == ScrollEventType.SCROLL) {
            T t = scrollView;
            if (t.getScrollEventThrottle() >= Math.max(17L, jCurrentTimeMillis - t.getLastScrollDispatchTime())) {
                return;
            }
        }
        View childAt = scrollView.getChildAt(0);
        if (childAt == null) {
            return;
        }
        Iterator it = CollectionsKt.toList(scrollListeners).iterator();
        while (it.hasNext()) {
            ScrollListener scrollListener = (ScrollListener) ((WeakReference) it.next()).get();
            if (scrollListener != null) {
                scrollListener.onScroll(scrollView, scrollEventType, xVelocity, yVelocity);
            }
        }
        View view = (View) scrollView;
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(ScrollEvent.INSTANCE.obtain(surfaceId, view.getId(), scrollEventType, view.getScrollX(), view.getScrollY(), xVelocity, yVelocity, childAt.getWidth(), childAt.getHeight(), view.getWidth(), view.getHeight()));
            if (scrollEventType == ScrollEventType.SCROLL) {
                scrollView.setLastScrollDispatchTime(jCurrentTimeMillis);
            }
        }
    }

    @JvmStatic
    public static final void emitLayoutEvent(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator<WeakReference<ScrollListener>> it = scrollListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ScrollListener scrollListener = it.next().get();
            if (scrollListener != null) {
                scrollListener.onLayout(scrollView);
            }
        }
    }

    @JvmStatic
    public static final void emitLayoutChangeEvent(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator<WeakReference<LayoutChangeListener>> it = layoutChangeListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            LayoutChangeListener layoutChangeListener = it.next().get();
            if (layoutChangeListener != null) {
                layoutChangeListener.onLayoutChange(scrollView);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (r3.equals("auto") != false) goto L25;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int parseOverScrollMode(java.lang.String r3) {
        /*
            r0 = 1
            if (r3 == 0) goto L4a
            int r1 = r3.hashCode()
            r2 = -1414557169(0xffffffffabaf920f, float:-1.2475037E-12)
            if (r1 == r2) goto L2b
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 == r2) goto L22
            r2 = 104712844(0x63dca8c, float:3.5695757E-35)
            if (r1 == r2) goto L17
            goto L33
        L17:
            java.lang.String r1 = "never"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L20
            goto L33
        L20:
            r3 = 2
            return r3
        L22:
            java.lang.String r1 = "auto"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L33
            goto L4a
        L2b:
            java.lang.String r1 = "always"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L48
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "wrong overScrollMode: "
            r1.<init>(r2)
            java.lang.StringBuilder r3 = r1.append(r3)
            java.lang.String r3 = r3.toString()
            java.lang.String r1 = "ReactNative"
            com.facebook.common.logging.FLog.w(r1, r3)
            return r0
        L48:
            r3 = 0
            return r3
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollViewHelper.parseOverScrollMode(java.lang.String):int");
    }

    @JvmStatic
    public static final int parseSnapToAlignment(String alignment) {
        if (alignment == null) {
            return 0;
        }
        if (StringsKt.equals(ViewProps.START, alignment, true)) {
            return 1;
        }
        if (StringsKt.equals("center", alignment, true)) {
            return 2;
        }
        if (Intrinsics.areEqual(ViewProps.END, alignment)) {
            return 3;
        }
        FLog.w(ReactConstants.TAG, "wrong snap alignment value: " + alignment);
        return 0;
    }

    @JvmStatic
    public static final int getDefaultScrollAnimationDuration(Context context) {
        if (!smoothScrollDurationInitialized) {
            smoothScrollDurationInitialized = true;
            try {
                SMOOTH_SCROLL_DURATION = new OverScrollerDurationGetter(context).getScrollAnimationDuration();
            } catch (Throwable unused) {
            }
        }
        return SMOOTH_SCROLL_DURATION;
    }

    @JvmStatic
    public static final void addScrollListener(ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        scrollListeners.add(new WeakReference<>(listener));
    }

    @JvmStatic
    public static final void removeScrollListener(final ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<WeakReference<ScrollListener>> copyOnWriteArrayList = scrollListeners;
        final Function1 function1 = new Function1() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ReactScrollViewHelper.removeScrollListener$lambda$0(listener, (WeakReference) obj));
            }
        };
        copyOnWriteArrayList.removeIf(new Predicate() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ReactScrollViewHelper.removeScrollListener$lambda$1(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeScrollListener$lambda$0(ScrollListener scrollListener, WeakReference weakReference) {
        return weakReference.get() == null || Intrinsics.areEqual(weakReference.get(), scrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeScrollListener$lambda$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    @JvmStatic
    public static final void addLayoutChangeListener(LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        layoutChangeListeners.add(new WeakReference<>(listener));
    }

    @JvmStatic
    public static final void removeLayoutChangeListener(final LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<WeakReference<LayoutChangeListener>> copyOnWriteArrayList = layoutChangeListeners;
        final Function1 function1 = new Function1() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ReactScrollViewHelper.removeLayoutChangeListener$lambda$2(listener, (WeakReference) obj));
            }
        };
        copyOnWriteArrayList.removeIf(new Predicate() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ReactScrollViewHelper.removeLayoutChangeListener$lambda$3(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeLayoutChangeListener$lambda$2(LayoutChangeListener layoutChangeListener, WeakReference weakReference) {
        return weakReference.get() == null || Intrinsics.areEqual(weakReference.get(), layoutChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeLayoutChangeListener$lambda$3(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState & HasStateWrapper> void smoothScrollTo(T scrollView, int x, int y) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollTo[%d] x %d y %d", Integer.valueOf(((View) scrollView).getId()), Integer.valueOf(x), Integer.valueOf(y));
        }
        T t = scrollView;
        ValueAnimator flingAnimator = t.getFlingAnimator();
        if (flingAnimator.getListeners() == null || flingAnimator.getListeners().size() == 0) {
            INSTANCE.registerFlingAnimator(scrollView);
        }
        scrollView.getReactScrollViewScrollState().setFinalAnimatedPositionScroll(x, y);
        View view = (View) scrollView;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        if (scrollX != x) {
            t.startFlingAnimator(scrollX, x);
        }
        if (scrollY != y) {
            t.startFlingAnimator(scrollY, y);
        }
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState> int getNextFlingStartValue(T scrollView, int currentValue, int postAnimationValue, int velocity) {
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.getReactScrollViewScrollState();
        return (!reactScrollViewScrollState.getIsFinished() || (reactScrollViewScrollState.getIsCanceled() && ((velocity != 0 ? velocity / Math.abs(velocity) : 0) * (postAnimationValue - currentValue) > 0))) ? postAnimationValue : currentValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState & HasStateWrapper> void updateFabricScrollState(T scrollView) {
        View view = (View) scrollView;
        INSTANCE.updateFabricScrollState(scrollView, view.getScrollX(), view.getScrollY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends ViewGroup & HasScrollState & HasStateWrapper> void updateFabricScrollState(T scrollView, int scrollX, int scrollY) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(((View) scrollView).getId()), Integer.valueOf(scrollX), Integer.valueOf(scrollY));
        }
        if (ViewUtil.getUIManagerType(((View) scrollView).getId()) == 1 || scrollView.getStateWrapper() == null) {
            return;
        }
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.getReactScrollViewScrollState();
        if (reactScrollViewScrollState.getLastStateUpdateScroll().equals(scrollX, scrollY)) {
            return;
        }
        reactScrollViewScrollState.setLastStateUpdateScroll(scrollX, scrollY);
        forceUpdateState(scrollView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasScrollState & HasStateWrapper> void forceUpdateState(T scrollView) {
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.getReactScrollViewScrollState();
        int scrollAwayPaddingTop = reactScrollViewScrollState.getScrollAwayPaddingTop();
        Point lastStateUpdateScroll = reactScrollViewScrollState.getLastStateUpdateScroll();
        int i = lastStateUpdateScroll.x;
        int i2 = lastStateUpdateScroll.y;
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(((View) scrollView).getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        StateWrapper stateWrapper = scrollView.getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble(CONTENT_OFFSET_LEFT, PixelUtil.toDIPFromPixel(i));
            writableNativeMap.putDouble(CONTENT_OFFSET_TOP, PixelUtil.toDIPFromPixel(i2));
            writableNativeMap.putDouble(SCROLL_AWAY_PADDING_TOP, PixelUtil.toDIPFromPixel(scrollAwayPaddingTop));
            stateWrapper.updateState(writableNativeMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle & HasScrollState & HasStateWrapper> void updateStateOnScrollChanged(T scrollView, float xVelocity, float yVelocity) {
        View view = (View) scrollView;
        INSTANCE.updateFabricScrollState(scrollView, view.getScrollX(), view.getScrollY());
        emitScrollEvent(scrollView, xVelocity, yVelocity);
    }

    public final <T extends ViewGroup & HasFlingAnimator & HasScrollState & HasStateWrapper> void registerFlingAnimator(final T scrollView) {
        scrollView.getFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.registerFlingAnimator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) scrollView).getReactScrollViewScrollState();
                reactScrollViewScrollState.setCanceled(false);
                reactScrollViewScrollState.setFinished(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) scrollView).getReactScrollViewScrollState().setFinished(true);
                ReactScrollViewHelper.updateFabricScrollState(scrollView);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) scrollView).getReactScrollViewScrollState().setCanceled(true);
            }
        });
    }

    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollEventThrottle> void dispatchMomentumEndOnAnimationEnd(final T scrollView) {
        scrollView.getFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.dispatchMomentumEndOnAnimationEnd.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(scrollView);
                animator.removeListener(this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(scrollView);
                animator.removeListener(this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T extends ViewGroup & HasFlingAnimator & HasScrollState> Point predictFinalScrollPosition(T scrollView, int velocityX, int velocityY, int maximumOffsetX, int maximumOffsetY) {
        ReactScrollViewScrollState reactScrollViewScrollState = scrollView.getReactScrollViewScrollState();
        View view = (View) scrollView;
        OverScroller overScroller = new OverScroller(view.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.getDecelerationRate());
        int width = (view.getWidth() - view.getPaddingStart()) - view.getPaddingEnd();
        int height = (view.getHeight() - view.getPaddingBottom()) - view.getPaddingTop();
        Point finalAnimatedPositionScroll = reactScrollViewScrollState.getFinalAnimatedPositionScroll();
        overScroller.fling(getNextFlingStartValue(scrollView, view.getScrollX(), finalAnimatedPositionScroll.x, velocityX), getNextFlingStartValue(scrollView, view.getScrollY(), finalAnimatedPositionScroll.y, velocityY), velocityX, velocityY, 0, maximumOffsetX, 0, maximumOffsetY, width / 2, height / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final View findNextFocusableView(ViewGroup host, View focused, int direction) {
        FabricUIManager fabricUIManager;
        Integer numFindNextFocusableElement;
        int iIntValue;
        int[] relativeAncestorList;
        Set<Integer> mutableSet;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(focused, "focused");
        if (!(host instanceof ReactClippingViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = host;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        UIManager uIManager = UIManagerHelper.getUIManager((ReactContext) context, 2);
        if (uIManager == null || (numFindNextFocusableElement = (fabricUIManager = (FabricUIManager) uIManager).findNextFocusableElement(viewGroup.getId(), focused.getId(), direction)) == null || (relativeAncestorList = fabricUIManager.getRelativeAncestorList(host.getChildAt(0).getId(), (iIntValue = numFindNextFocusableElement.intValue()))) == null || (mutableSet = ArraysKt.toMutableSet(relativeAncestorList)) == null) {
            return null;
        }
        mutableSet.add(Integer.valueOf(iIntValue));
        ((ReactClippingViewGroup) host).updateClippingRect(mutableSet);
        return host.findViewById(iIntValue);
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$OverScrollerDurationGetter;", "Landroid/widget/OverScroller;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "currentScrollAnimationDuration", "", "scrollAnimationDuration", "getScrollAnimationDuration", "()I", "startScroll", "", "startX", "startY", "dx", "dy", "duration", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class OverScrollerDurationGetter extends OverScroller {
        private int currentScrollAnimationDuration;

        public OverScrollerDurationGetter(Context context) {
            super(context);
            this.currentScrollAnimationDuration = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        }

        public final int getScrollAnimationDuration() {
            super.startScroll(0, 0, 0, 0);
            return this.currentScrollAnimationDuration;
        }

        @Override // android.widget.OverScroller
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            this.currentScrollAnimationDuration = duration;
        }
    }

    /* JADX INFO: compiled from: ReactScrollViewHelper.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tJ\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/facebook/react/views/scroll/ReactScrollViewHelper$ReactScrollViewScrollState;", "", "<init>", "()V", "finalAnimatedPositionScroll", "Landroid/graphics/Point;", "getFinalAnimatedPositionScroll", "()Landroid/graphics/Point;", ReactScrollViewHelper.SCROLL_AWAY_PADDING_TOP, "", "getScrollAwayPaddingTop", "()I", "setScrollAwayPaddingTop", "(I)V", "lastStateUpdateScroll", "getLastStateUpdateScroll", "isCanceled", "", "()Z", "setCanceled", "(Z)V", "isFinished", "setFinished", "decelerationRate", "", "getDecelerationRate", "()F", "setDecelerationRate", "(F)V", "setFinalAnimatedPositionScroll", "finalAnimatedPositionScrollX", "finalAnimatedPositionScrollY", "setLastStateUpdateScroll", "lastStateUpdateScrollX", "lastStateUpdateScrollY", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReactScrollViewScrollState {
        private boolean isCanceled;
        private int scrollAwayPaddingTop;
        private final Point finalAnimatedPositionScroll = new Point();
        private final Point lastStateUpdateScroll = new Point(-1, -1);
        private boolean isFinished = true;
        private float decelerationRate = 0.985f;

        public final Point getFinalAnimatedPositionScroll() {
            return this.finalAnimatedPositionScroll;
        }

        public final int getScrollAwayPaddingTop() {
            return this.scrollAwayPaddingTop;
        }

        public final void setScrollAwayPaddingTop(int i) {
            this.scrollAwayPaddingTop = i;
        }

        public final Point getLastStateUpdateScroll() {
            return this.lastStateUpdateScroll;
        }

        /* JADX INFO: renamed from: isCanceled, reason: from getter */
        public final boolean getIsCanceled() {
            return this.isCanceled;
        }

        public final void setCanceled(boolean z) {
            this.isCanceled = z;
        }

        /* JADX INFO: renamed from: isFinished, reason: from getter */
        public final boolean getIsFinished() {
            return this.isFinished;
        }

        public final void setFinished(boolean z) {
            this.isFinished = z;
        }

        public final float getDecelerationRate() {
            return this.decelerationRate;
        }

        public final void setDecelerationRate(float f) {
            this.decelerationRate = f;
        }

        public final ReactScrollViewScrollState setFinalAnimatedPositionScroll(int finalAnimatedPositionScrollX, int finalAnimatedPositionScrollY) {
            this.finalAnimatedPositionScroll.set(finalAnimatedPositionScrollX, finalAnimatedPositionScrollY);
            return this;
        }

        public final ReactScrollViewScrollState setLastStateUpdateScroll(int lastStateUpdateScrollX, int lastStateUpdateScrollY) {
            this.lastStateUpdateScroll.set(lastStateUpdateScrollX, lastStateUpdateScrollY);
            return this;
        }
    }
}
