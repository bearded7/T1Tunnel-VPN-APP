package expo.modules.image;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageViewWrapperTarget.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0000\u0018\u0000 )2\u00020\u0001:\u0002()B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J \u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006*"}, d2 = {"Lexpo/modules/image/SizeDeterminer;", "", "imageViewHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/image/ExpoImageViewWrapper;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "cbs", "", "Lcom/bumptech/glide/request/target/SizeReadyCallback;", "waitForLayout", "", "getWaitForLayout", "()Z", "setWaitForLayout", "(Z)V", "layoutListener", "Lexpo/modules/image/SizeDeterminer$SizeDeterminerLayoutListener;", "notifyCbs", "", "width", "", "height", "checkCurrentDimens", "getSize", "cb", "removeCallback", "clearCallbacksAndListener", "isViewStateAndSizeValid", "targetHeight", "getTargetHeight", "()I", "targetWidth", "getTargetWidth", "getTargetDimen", "viewSize", "paramSize", "paddingSize", "isDimensionValid", "size", "SizeDeterminerLayoutListener", "Companion", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SizeDeterminer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int PENDING_SIZE = 0;
    private static Integer maxDisplayLength;
    private final List<SizeReadyCallback> cbs;
    private final WeakReference<ExpoImageViewWrapper> imageViewHolder;
    private SizeDeterminerLayoutListener layoutListener;
    private boolean waitForLayout;

    private final boolean isDimensionValid(int size) {
        return size > 0 || size == Integer.MIN_VALUE;
    }

    public SizeDeterminer(WeakReference<ExpoImageViewWrapper> imageViewHolder) {
        Intrinsics.checkNotNullParameter(imageViewHolder, "imageViewHolder");
        this.imageViewHolder = imageViewHolder;
        this.cbs = new ArrayList();
    }

    public final boolean getWaitForLayout() {
        return this.waitForLayout;
    }

    public final void setWaitForLayout(boolean z) {
        this.waitForLayout = z;
    }

    private final void notifyCbs(int width, int height) {
        Iterator it = new ArrayList(this.cbs).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ((SizeReadyCallback) it.next()).onSizeReady(width, height);
        }
    }

    public final void checkCurrentDimens() {
        if (this.cbs.isEmpty()) {
            return;
        }
        int targetWidth = getTargetWidth();
        int targetHeight = getTargetHeight();
        if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
            notifyCbs(targetWidth, targetHeight);
            clearCallbacksAndListener();
        }
    }

    public final void getSize(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        ExpoImageViewWrapper expoImageViewWrapper = this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return;
        }
        int targetWidth = getTargetWidth();
        int targetHeight = getTargetHeight();
        if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
            cb.onSizeReady(targetWidth, targetHeight);
            return;
        }
        if (!this.cbs.contains(cb)) {
            this.cbs.add(cb);
        }
        if (this.layoutListener == null) {
            ViewTreeObserver viewTreeObserver = expoImageViewWrapper.getViewTreeObserver();
            SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
            this.layoutListener = sizeDeterminerLayoutListener;
            viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
        }
    }

    public final void removeCallback(SizeReadyCallback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.cbs.remove(cb);
    }

    public final void clearCallbacksAndListener() {
        ExpoImageViewWrapper expoImageViewWrapper = this.imageViewHolder.get();
        ViewTreeObserver viewTreeObserver = expoImageViewWrapper != null ? expoImageViewWrapper.getViewTreeObserver() : null;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
        }
        this.layoutListener = null;
        this.cbs.clear();
    }

    private final boolean isViewStateAndSizeValid(int width, int height) {
        return isDimensionValid(width) && isDimensionValid(height);
    }

    private final int getTargetHeight() {
        ExpoImageViewWrapper expoImageViewWrapper = this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return Integer.MIN_VALUE;
        }
        int paddingTop = expoImageViewWrapper.getPaddingTop() + expoImageViewWrapper.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = expoImageViewWrapper.getLayoutParams();
        return getTargetDimen(expoImageViewWrapper.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
    }

    private final int getTargetWidth() {
        ExpoImageViewWrapper expoImageViewWrapper = this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return Integer.MIN_VALUE;
        }
        int paddingLeft = expoImageViewWrapper.getPaddingLeft() + expoImageViewWrapper.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = expoImageViewWrapper.getLayoutParams();
        return getTargetDimen(expoImageViewWrapper.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
    }

    private final int getTargetDimen(int viewSize, int paramSize, int paddingSize) {
        ExpoImageViewWrapper expoImageViewWrapper = this.imageViewHolder.get();
        if (expoImageViewWrapper == null) {
            return Integer.MIN_VALUE;
        }
        int i = paramSize - paddingSize;
        if (i > 0) {
            return i;
        }
        if (this.waitForLayout && expoImageViewWrapper.isLayoutRequested()) {
            return 0;
        }
        int i2 = viewSize - paddingSize;
        if (i2 > 0) {
            return i2;
        }
        if (expoImageViewWrapper.isLayoutRequested() || paramSize != -2) {
            return 0;
        }
        Companion companion = INSTANCE;
        Context context = expoImageViewWrapper.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return companion.getMaxDisplayLength(context);
    }

    /* JADX INFO: compiled from: ImageViewWrapperTarget.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/image/SizeDeterminer$SizeDeterminerLayoutListener;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "sizeDeterminer", "Lexpo/modules/image/SizeDeterminer;", "<init>", "(Lexpo/modules/image/SizeDeterminer;)V", "sizeDeterminerRef", "Ljava/lang/ref/WeakReference;", "onPreDraw", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
        private final WeakReference<SizeDeterminer> sizeDeterminerRef;

        public SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
            Intrinsics.checkNotNullParameter(sizeDeterminer, "sizeDeterminer");
            this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
            if (sizeDeterminer == null) {
                return true;
            }
            sizeDeterminer.checkCurrentDimens();
            return true;
        }
    }

    /* JADX INFO: compiled from: ImageViewWrapperTarget.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lexpo/modules/image/SizeDeterminer$Companion;", "", "<init>", "()V", "PENDING_SIZE", "", "maxDisplayLength", "getMaxDisplayLength$annotations", "getMaxDisplayLength", "()Ljava/lang/Integer;", "setMaxDisplayLength", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "context", "Landroid/content/Context;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getMaxDisplayLength$annotations() {
        }

        private Companion() {
        }

        public final Integer getMaxDisplayLength() {
            return SizeDeterminer.maxDisplayLength;
        }

        public final void setMaxDisplayLength(Integer num) {
            SizeDeterminer.maxDisplayLength = num;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getMaxDisplayLength(Context context) {
            if (getMaxDisplayLength() == null) {
                Object systemService = context.getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) systemService)).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                setMaxDisplayLength(Integer.valueOf(Math.max(point.x, point.y)));
            }
            Integer maxDisplayLength = getMaxDisplayLength();
            Intrinsics.checkNotNull(maxDisplayLength);
            return maxDisplayLength.intValue();
        }
    }
}
