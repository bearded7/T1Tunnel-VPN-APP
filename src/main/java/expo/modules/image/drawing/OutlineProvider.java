package expo.modules.image.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.yoga.YogaConstants;
import expo.modules.image.YogaUtilsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: OutlineProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002/0B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0002J@\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\u0006\u0010!\u001a\u00020\u0010J\u0016\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0007J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0016J\u0016\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.2\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lexpo/modules/image/drawing/OutlineProvider;", "Landroid/view/ViewOutlineProvider;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mLayoutDirection", "", "mBounds", "Landroid/graphics/RectF;", "borderRadiiConfig", "", "getBorderRadiiConfig", "()[F", "mCornerRadii", "mCornerRadiiInvalidated", "", "mConvexPath", "Landroid/graphics/Path;", "mConvexPathInvalidated", "updateCornerRadiiIfNeeded", "", "updateCornerRadius", "outputPosition", "Lexpo/modules/image/drawing/OutlineProvider$CornerRadius;", "inputPosition", "Lexpo/modules/image/drawing/OutlineProvider$BorderRadiusConfig;", "oppositePosition", "startPosition", "endPosition", "isRTL", "isRTLSwap", "updateConvexPathIfNeeded", "hasEqualCorners", "setBorderRadius", "radius", "", ViewProps.POSITION, "updateBoundsAndLayoutDirection", "view", "Landroid/view/View;", "getOutline", "outline", "Landroid/graphics/Outline;", "clipCanvasIfNeeded", "canvas", "Landroid/graphics/Canvas;", "BorderRadiusConfig", "CornerRadius", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OutlineProvider extends ViewOutlineProvider {
    private final float[] borderRadiiConfig;
    private final RectF mBounds;
    private final Context mContext;
    private final Path mConvexPath;
    private boolean mConvexPathInvalidated;
    private final float[] mCornerRadii;
    private boolean mCornerRadiiInvalidated;
    private int mLayoutDirection;

    /* JADX INFO: compiled from: OutlineProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/image/drawing/OutlineProvider$BorderRadiusConfig;", "", "<init>", "(Ljava/lang/String;I)V", Rule.ALL, "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "TOP_START", "TOP_END", "BOTTOM_START", "BOTTOM_END", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum BorderRadiusConfig {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<BorderRadiusConfig> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: OutlineProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/image/drawing/OutlineProvider$CornerRadius;", "", "<init>", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum CornerRadius {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<CornerRadius> getEntries() {
            return $ENTRIES;
        }
    }

    public OutlineProvider(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mBounds = new RectF();
        float[] fArr = new float[9];
        for (int i = 0; i < 9; i++) {
            fArr[i] = Float.NaN;
        }
        this.borderRadiiConfig = fArr;
        this.mCornerRadii = new float[4];
        this.mCornerRadiiInvalidated = true;
        this.mConvexPath = new Path();
        this.mConvexPathInvalidated = true;
        updateCornerRadiiIfNeeded();
    }

    public final float[] getBorderRadiiConfig() {
        return this.borderRadiiConfig;
    }

    private final void updateCornerRadiiIfNeeded() {
        if (this.mCornerRadiiInvalidated) {
            boolean z = this.mLayoutDirection == 1;
            boolean zDoLeftAndRightSwapInRTL = I18nUtil.INSTANCE.getInstance().doLeftAndRightSwapInRTL(this.mContext);
            updateCornerRadius(CornerRadius.TOP_LEFT, BorderRadiusConfig.TOP_LEFT, BorderRadiusConfig.TOP_RIGHT, BorderRadiusConfig.TOP_START, BorderRadiusConfig.TOP_END, z, zDoLeftAndRightSwapInRTL);
            updateCornerRadius(CornerRadius.TOP_RIGHT, BorderRadiusConfig.TOP_RIGHT, BorderRadiusConfig.TOP_LEFT, BorderRadiusConfig.TOP_END, BorderRadiusConfig.TOP_START, z, zDoLeftAndRightSwapInRTL);
            updateCornerRadius(CornerRadius.BOTTOM_LEFT, BorderRadiusConfig.BOTTOM_LEFT, BorderRadiusConfig.BOTTOM_RIGHT, BorderRadiusConfig.BOTTOM_START, BorderRadiusConfig.BOTTOM_END, z, zDoLeftAndRightSwapInRTL);
            updateCornerRadius(CornerRadius.BOTTOM_RIGHT, BorderRadiusConfig.BOTTOM_RIGHT, BorderRadiusConfig.BOTTOM_LEFT, BorderRadiusConfig.BOTTOM_END, BorderRadiusConfig.BOTTOM_START, z, zDoLeftAndRightSwapInRTL);
            this.mCornerRadiiInvalidated = false;
            this.mConvexPathInvalidated = true;
        }
    }

    private final void updateCornerRadius(CornerRadius outputPosition, BorderRadiusConfig inputPosition, BorderRadiusConfig oppositePosition, BorderRadiusConfig startPosition, BorderRadiusConfig endPosition, boolean isRTL, boolean isRTLSwap) {
        float f = this.borderRadiiConfig[inputPosition.ordinal()];
        if (isRTL) {
            if (isRTLSwap) {
                f = this.borderRadiiConfig[oppositePosition.ordinal()];
            }
            if (YogaConstants.isUndefined(f)) {
                f = this.borderRadiiConfig[endPosition.ordinal()];
            }
        } else if (YogaConstants.isUndefined(f)) {
            f = this.borderRadiiConfig[startPosition.ordinal()];
        }
        this.mCornerRadii[outputPosition.ordinal()] = PixelUtil.toPixelFromDIP(YogaUtilsKt.ifYogaUndefinedUse(YogaUtilsKt.ifYogaUndefinedUse(f, this.borderRadiiConfig[BorderRadiusConfig.ALL.ordinal()]), 0.0f));
    }

    private final void updateConvexPathIfNeeded() {
        if (this.mConvexPathInvalidated) {
            this.mConvexPath.reset();
            this.mConvexPath.addRoundRect(this.mBounds, new float[]{this.mCornerRadii[CornerRadius.TOP_LEFT.ordinal()], this.mCornerRadii[CornerRadius.TOP_LEFT.ordinal()], this.mCornerRadii[CornerRadius.TOP_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.TOP_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_RIGHT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_LEFT.ordinal()], this.mCornerRadii[CornerRadius.BOTTOM_LEFT.ordinal()]}, Path.Direction.CW);
            this.mConvexPathInvalidated = false;
        }
    }

    public final boolean hasEqualCorners() {
        updateCornerRadiiIfNeeded();
        float[] fArr = this.mCornerRadii;
        float f = fArr[0];
        for (float f2 : fArr) {
            if (f != f2) {
                return false;
            }
        }
        return true;
    }

    public final boolean setBorderRadius(float radius, int position) {
        if (FloatUtil.floatsEqual(this.borderRadiiConfig[position], radius)) {
            return false;
        }
        this.borderRadiiConfig[position] = radius;
        this.mCornerRadiiInvalidated = true;
        return true;
    }

    private final void updateBoundsAndLayoutDirection(View view) {
        int layoutDirection = view.getLayoutDirection();
        if (this.mLayoutDirection != layoutDirection) {
            this.mLayoutDirection = layoutDirection;
            this.mCornerRadiiInvalidated = true;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        float f = 0;
        if (this.mBounds.left == f && this.mBounds.top == f && this.mBounds.right == width && this.mBounds.bottom == height) {
            return;
        }
        this.mBounds.set(f, f, width, height);
        this.mCornerRadiiInvalidated = true;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        updateBoundsAndLayoutDirection(view);
        updateCornerRadiiIfNeeded();
        if (hasEqualCorners()) {
            float f = this.mCornerRadii[0];
            if (f > 0.0f) {
                outline.setRoundRect(0, 0, (int) this.mBounds.width(), (int) this.mBounds.height(), f);
                return;
            } else {
                outline.setRect(0, 0, (int) this.mBounds.width(), (int) this.mBounds.height());
                return;
            }
        }
        updateConvexPathIfNeeded();
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(this.mConvexPath);
        } else {
            outline.setConvexPath(this.mConvexPath);
        }
    }

    public final void clipCanvasIfNeeded(Canvas canvas, View view) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "view");
        updateBoundsAndLayoutDirection(view);
        updateCornerRadiiIfNeeded();
        if (hasEqualCorners()) {
            return;
        }
        updateConvexPathIfNeeded();
        canvas.clipPath(this.mConvexPath);
    }
}
