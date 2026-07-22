package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.style.BackgroundImageLayer;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
@UnstableReactNativeAPI
public class CSSBackgroundDrawable extends Drawable {
    private static final int ALL_BITS_SET = -1;
    private static final int ALL_BITS_UNSET = 0;
    private static final int DEFAULT_BORDER_ALPHA = 255;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_RGB = 0;
    private Path mBackgroundColorRenderPath;
    private Spacing mBorderAlpha;
    private Spacing mBorderRGB;
    private BorderStyle mBorderStyle;
    private Spacing mBorderWidth;
    private Path mCenterDrawPath;
    private final Context mContext;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private Path mInnerClipPathForBorderRadius;
    private RectF mInnerClipTempRectForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private Path mOuterClipPathForBorderRadius;
    private RectF mOuterClipTempRectForBorderRadius;
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;
    private RectF mTempRectForBorderRadiusOutline;
    private RectF mTempRectForCenterDrawPath;
    private final Path mPathForSingleBorder = new Path();
    private boolean mNeedUpdatePathForBorderRadius = false;
    private final Paint mPaint = new Paint(1);
    private int mColor = 0;
    private List<BackgroundImageLayer> mBackgroundImageLayers = null;
    private int mAlpha = 255;
    private final float mGapBetweenPaths = 0.8f;
    private BorderRadiusStyle mBorderRadius = new BorderRadiusStyle();
    private ComputedBorderRadius mComputedBorderRadius = new ComputedBorderRadius();
    private int mLayoutDirectionOverride = -1;

    private static int colorFromAlphaAndRGBComponents(float f, float f2) {
        return ((((int) f) << 24) & (-16777216)) | (((int) f2) & ViewCompat.MEASURED_SIZE_MASK);
    }

    private static int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = (i4 > 0 ? i8 : -1) & (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        int i10 = i5 | i6;
        if (i3 <= 0) {
            i7 = 0;
        }
        int i11 = i10 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        if (i9 == (i11 | i8)) {
            return i9;
        }
        return 0;
    }

    private static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & ViewCompat.MEASURED_SIZE_MASK;
        }
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.drawable.CSSBackgroundDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$style$BorderStyle;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            $SwitchMap$com$facebook$react$uimanager$style$BorderStyle = iArr;
            try {
                iArr[BorderStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$style$BorderStyle[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$style$BorderStyle[BorderStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PathEffect getPathEffect(BorderStyle borderStyle, float f) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$style$BorderStyle[borderStyle.ordinal()];
        if (i == 2) {
            float f2 = f * 3.0f;
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        }
        if (i != 3) {
            return null;
        }
        return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
    }

    public CSSBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        updatePathEffect();
        if (!hasRoundedBorders()) {
            drawRectangularBackgroundWithBorders(canvas);
        } else {
            drawRoundedBackgroundWithBorders(canvas);
        }
    }

    public boolean hasRoundedBorders() {
        return this.mBorderRadius.hasRoundedBorders();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Deprecated
    public void setLayoutDirectionOverride(int i) {
        if (this.mLayoutDirectionOverride != i) {
            this.mLayoutDirectionOverride = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        int i = this.mLayoutDirectionOverride;
        return i == -1 ? super.getLayoutDirection() : i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int iAlpha = (Color.alpha(this.mColor) * this.mAlpha) >> 8;
        if (iAlpha != 0) {
            return iAlpha != 255 ? -3 : -1;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (hasRoundedBorders()) {
            updatePath();
            outline.setConvexPath((Path) Preconditions.checkNotNull(this.mPathForBorderRadiusOutline));
        } else {
            outline.setRect(getBounds());
        }
    }

    public void setBorderWidth(int i, float f) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing();
        }
        if (FloatUtil.floatsEqual(this.mBorderWidth.getRaw(i), f)) {
            return;
        }
        this.mBorderWidth.set(i, f);
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
            this.mNeedUpdatePathForBorderRadius = true;
        }
        invalidateSelf();
    }

    public void setBorderColor(int i, Integer num) {
        float fIntValue = num == null ? Float.NaN : num.intValue() & ViewCompat.MEASURED_SIZE_MASK;
        float fIntValue2 = num != null ? num.intValue() >>> 24 : Float.NaN;
        setBorderRGB(i, fIntValue);
        setBorderAlpha(i, fIntValue2);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    private void setBorderRGB(int i, float f) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(0.0f);
        }
        if (FloatUtil.floatsEqual(this.mBorderRGB.getRaw(i), f)) {
            return;
        }
        this.mBorderRGB.set(i, f);
        invalidateSelf();
    }

    private void setBorderAlpha(int i, float f) {
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(i), f)) {
            return;
        }
        this.mBorderAlpha.set(i, f);
        invalidateSelf();
    }

    public void setBorderStyle(String str) {
        setBorderStyle(str == null ? null : BorderStyle.valueOf(str.toUpperCase(Locale.US)));
    }

    public void setBorderStyle(BorderStyle borderStyle) {
        if (this.mBorderStyle != borderStyle) {
            this.mBorderStyle = borderStyle;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public BorderStyle getBorderStyle() {
        return this.mBorderStyle;
    }

    @Deprecated(forRemoval = true, since = "0.75.0")
    public void setRadius(float f) {
        Float fValueOf = Float.isNaN(f) ? null : Float.valueOf(f);
        if (fValueOf == null) {
            setBorderRadius(BorderRadiusProp.BORDER_RADIUS, null);
        } else {
            setBorderRadius(BorderRadiusProp.BORDER_RADIUS, new LengthPercentage(fValueOf.floatValue(), LengthPercentageType.POINT));
        }
    }

    @Deprecated(forRemoval = true, since = "0.75.0")
    public void setRadius(float f, int i) {
        Float fValueOf = Float.isNaN(f) ? null : Float.valueOf(f);
        if (fValueOf == null) {
            this.mBorderRadius.set(BorderRadiusProp.values()[i], null);
            invalidateSelf();
        } else {
            setBorderRadius(BorderRadiusProp.values()[i], new LengthPercentage(fValueOf.floatValue(), LengthPercentageType.POINT));
        }
    }

    public void setBorderRadius(BorderRadiusProp borderRadiusProp, LengthPercentage lengthPercentage) {
        if (Objects.equals(lengthPercentage, this.mBorderRadius.get(borderRadiusProp))) {
            return;
        }
        this.mBorderRadius.set(borderRadiusProp, lengthPercentage);
        this.mNeedUpdatePathForBorderRadius = true;
        invalidateSelf();
    }

    public void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.mBorderRadius = borderRadiusStyle;
    }

    public BorderRadiusStyle getBorderRadius() {
        return this.mBorderRadius;
    }

    public float getInnerBorderRadius(float f, float f2) {
        return Math.max(f - f2, 0.0f);
    }

    public void setColor(int i) {
        this.mColor = i;
        invalidateSelf();
    }

    public void setBackgroundImage(List<BackgroundImageLayer> list) {
        this.mBackgroundImageLayers = list;
        invalidateSelf();
    }

    public int getColor() {
        return this.mColor;
    }

    public Path getBorderBoxPath() {
        if (!hasRoundedBorders()) {
            return null;
        }
        updatePath();
        return new Path((Path) Preconditions.checkNotNull(this.mOuterClipPathForBorderRadius));
    }

    public RectF getBorderBoxRect() {
        return new RectF(getBounds());
    }

    public Path getPaddingBoxPath() {
        if (!hasRoundedBorders()) {
            return null;
        }
        updatePath();
        return new Path((Path) Preconditions.checkNotNull(this.mInnerClipPathForBorderRadius));
    }

    public RectF getPaddingBoxRect() {
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        if (directionAwareBorderInsets == null) {
            return new RectF(0.0f, 0.0f, getBounds().width(), getBounds().height());
        }
        return new RectF(directionAwareBorderInsets.left, directionAwareBorderInsets.top, getBounds().width() - directionAwareBorderInsets.right, getBounds().height() - directionAwareBorderInsets.bottom);
    }

    /* JADX WARN: Code duplicated, block: B:84:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:85:0x0207  */
    /* JADX WARN: Code duplicated, block: B:88:0x021f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0242  */
    /* JADX WARN: Code duplicated, block: B:94:0x0265  */
    private void drawRoundedBackgroundWithBorders(Canvas canvas) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        float f5;
        float f6;
        PointF pointF5;
        PointF pointF6;
        PointF pointF7;
        updatePath();
        canvas.save();
        int i3 = this.mColor;
        int alphaComponent = ColorUtils.setAlphaComponent(i3, (Color.alpha(i3) * this.mAlpha) >> 8);
        if (Color.alpha(alphaComponent) != 0) {
            this.mPaint.setColor(alphaComponent);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath((Path) Preconditions.checkNotNull(this.mBackgroundColorRenderPath), this.mPaint);
        }
        List<BackgroundImageLayer> list = this.mBackgroundImageLayers;
        if (list != null && !list.isEmpty()) {
            this.mPaint.setShader(getBackgroundImageShader());
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath((Path) Preconditions.checkNotNull(this.mBackgroundColorRenderPath), this.mPaint);
            this.mPaint.setShader(null);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int borderColor = getBorderColor(0);
        int borderColor2 = getBorderColor(1);
        int borderColor3 = getBorderColor(2);
        int borderColor4 = getBorderColor(3);
        int borderColor5 = getBorderColor(9);
        int borderColor6 = getBorderColor(11);
        int borderColor7 = getBorderColor(10);
        if (isBorderColorDefined(9)) {
            borderColor2 = borderColor5;
            borderColor4 = borderColor2;
        }
        if (!isBorderColorDefined(10)) {
            borderColor7 = borderColor4;
        }
        if (!isBorderColorDefined(11)) {
            borderColor6 = borderColor2;
        }
        if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.right > 0.0f) {
            canvas.clipPath((Path) Preconditions.checkNotNull(this.mOuterClipPathForBorderRadius), Region.Op.INTERSECT);
            float fullBorderWidth = getFullBorderWidth();
            int borderColor8 = getBorderColor(8);
            if (directionAwareBorderInsets.top != fullBorderWidth || directionAwareBorderInsets.bottom != fullBorderWidth || directionAwareBorderInsets.left != fullBorderWidth || directionAwareBorderInsets.right != fullBorderWidth || borderColor != borderColor8 || borderColor6 != borderColor8 || borderColor3 != borderColor8 || borderColor7 != borderColor8) {
                this.mPaint.setStyle(Paint.Style.FILL);
                canvas.clipPath((Path) Preconditions.checkNotNull(this.mInnerClipPathForBorderRadius), Region.Op.DIFFERENCE);
                boolean z = getLayoutDirection() == 1;
                int borderColor9 = getBorderColor(4);
                int borderColor10 = getBorderColor(5);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                    if (isBorderColorDefined(4)) {
                        borderColor = borderColor9;
                    }
                    if (isBorderColorDefined(5)) {
                        borderColor3 = borderColor10;
                    }
                    int i4 = z ? borderColor3 : borderColor;
                    if (z) {
                        borderColor3 = borderColor;
                    }
                    i = i4;
                } else {
                    int i5 = z ? borderColor10 : borderColor9;
                    if (!z) {
                        borderColor9 = borderColor10;
                    }
                    boolean zIsBorderColorDefined = isBorderColorDefined(4);
                    boolean zIsBorderColorDefined2 = isBorderColorDefined(5);
                    boolean z2 = z ? zIsBorderColorDefined2 : zIsBorderColorDefined;
                    if (!z) {
                        zIsBorderColorDefined = zIsBorderColorDefined2;
                    }
                    if (z2) {
                        borderColor = i5;
                    }
                    i = borderColor;
                    if (zIsBorderColorDefined) {
                        i2 = borderColor9;
                    }
                    RectF rectF = (RectF) Preconditions.checkNotNull(this.mOuterClipTempRectForBorderRadius);
                    f = rectF.left;
                    f2 = rectF.right;
                    f3 = rectF.top;
                    f4 = rectF.bottom;
                    pointF = (PointF) Preconditions.checkNotNull(this.mInnerTopLeftCorner);
                    pointF2 = (PointF) Preconditions.checkNotNull(this.mInnerTopRightCorner);
                    pointF3 = (PointF) Preconditions.checkNotNull(this.mInnerBottomLeftCorner);
                    pointF4 = (PointF) Preconditions.checkNotNull(this.mInnerBottomRightCorner);
                    if (directionAwareBorderInsets.left > 0.0f) {
                        f5 = f4;
                        pointF5 = pointF;
                        pointF6 = pointF3;
                        pointF7 = pointF4;
                        drawQuadrilateral(canvas, i, f, f3 - 0.8f, pointF.x, pointF.y - 0.8f, pointF3.x, pointF3.y + 0.8f, f, f4 + 0.8f);
                        f6 = f;
                    } else {
                        f5 = f4;
                        f6 = f;
                        pointF5 = pointF;
                        pointF6 = pointF3;
                        pointF7 = pointF4;
                    }
                    if (directionAwareBorderInsets.top > 0.0f) {
                        drawQuadrilateral(canvas, borderColor6, f6 - 0.8f, f3, pointF5.x - 0.8f, pointF5.y, pointF2.x + 0.8f, pointF2.y, f2 + 0.8f, f3);
                    }
                    if (directionAwareBorderInsets.right > 0.0f) {
                        drawQuadrilateral(canvas, i2, f2, f3 - 0.8f, pointF2.x, pointF2.y - 0.8f, pointF7.x, pointF7.y + 0.8f, f2, f5 + 0.8f);
                    }
                    if (directionAwareBorderInsets.bottom > 0.0f) {
                        drawQuadrilateral(canvas, borderColor7, f6 - 0.8f, f5, pointF6.x - 0.8f, pointF6.y, pointF7.x + 0.8f, pointF7.y, f2 + 0.8f, f5);
                    }
                }
                i2 = borderColor3;
                RectF rectF2 = (RectF) Preconditions.checkNotNull(this.mOuterClipTempRectForBorderRadius);
                f = rectF2.left;
                f2 = rectF2.right;
                f3 = rectF2.top;
                f4 = rectF2.bottom;
                pointF = (PointF) Preconditions.checkNotNull(this.mInnerTopLeftCorner);
                pointF2 = (PointF) Preconditions.checkNotNull(this.mInnerTopRightCorner);
                pointF3 = (PointF) Preconditions.checkNotNull(this.mInnerBottomLeftCorner);
                pointF4 = (PointF) Preconditions.checkNotNull(this.mInnerBottomRightCorner);
                if (directionAwareBorderInsets.left > 0.0f) {
                    f5 = f4;
                    pointF5 = pointF;
                    pointF6 = pointF3;
                    pointF7 = pointF4;
                    drawQuadrilateral(canvas, i, f, f3 - 0.8f, pointF.x, pointF.y - 0.8f, pointF3.x, pointF3.y + 0.8f, f, f4 + 0.8f);
                    f6 = f;
                } else {
                    f5 = f4;
                    f6 = f;
                    pointF5 = pointF;
                    pointF6 = pointF3;
                    pointF7 = pointF4;
                }
                if (directionAwareBorderInsets.top > 0.0f) {
                    drawQuadrilateral(canvas, borderColor6, f6 - 0.8f, f3, pointF5.x - 0.8f, pointF5.y, pointF2.x + 0.8f, pointF2.y, f2 + 0.8f, f3);
                }
                if (directionAwareBorderInsets.right > 0.0f) {
                    drawQuadrilateral(canvas, i2, f2, f3 - 0.8f, pointF2.x, pointF2.y - 0.8f, pointF7.x, pointF7.y + 0.8f, f2, f5 + 0.8f);
                }
                if (directionAwareBorderInsets.bottom > 0.0f) {
                    drawQuadrilateral(canvas, borderColor7, f6 - 0.8f, f5, pointF6.x - 0.8f, pointF6.y, pointF7.x + 0.8f, pointF7.y, f2 + 0.8f, f5);
                }
            } else if (fullBorderWidth > 0.0f) {
                this.mPaint.setColor(multiplyColorAlpha(borderColor8, this.mAlpha));
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(fullBorderWidth);
                canvas.drawPath((Path) Preconditions.checkNotNull(this.mCenterDrawPath), this.mPaint);
            }
        }
        canvas.restore();
    }

    private void updatePath() {
        float f;
        float f2;
        float f3;
        float f4;
        if (this.mNeedUpdatePathForBorderRadius) {
            this.mNeedUpdatePathForBorderRadius = false;
            if (this.mInnerClipPathForBorderRadius == null) {
                this.mInnerClipPathForBorderRadius = new Path();
            }
            if (this.mBackgroundColorRenderPath == null) {
                this.mBackgroundColorRenderPath = new Path();
            }
            if (this.mOuterClipPathForBorderRadius == null) {
                this.mOuterClipPathForBorderRadius = new Path();
            }
            if (this.mPathForBorderRadiusOutline == null) {
                this.mPathForBorderRadiusOutline = new Path();
            }
            if (this.mCenterDrawPath == null) {
                this.mCenterDrawPath = new Path();
            }
            if (this.mInnerClipTempRectForBorderRadius == null) {
                this.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (this.mOuterClipTempRectForBorderRadius == null) {
                this.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (this.mTempRectForBorderRadiusOutline == null) {
                this.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (this.mTempRectForCenterDrawPath == null) {
                this.mTempRectForCenterDrawPath = new RectF();
            }
            this.mInnerClipPathForBorderRadius.reset();
            this.mBackgroundColorRenderPath.reset();
            this.mOuterClipPathForBorderRadius.reset();
            this.mPathForBorderRadiusOutline.reset();
            this.mCenterDrawPath.reset();
            this.mInnerClipTempRectForBorderRadius.set(getBounds());
            this.mOuterClipTempRectForBorderRadius.set(getBounds());
            this.mTempRectForBorderRadiusOutline.set(getBounds());
            this.mTempRectForCenterDrawPath.set(getBounds());
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            int borderColor = getBorderColor(0);
            int borderColor2 = getBorderColor(1);
            int borderColor3 = getBorderColor(2);
            int borderColor4 = getBorderColor(3);
            int borderColor5 = getBorderColor(8);
            int borderColor6 = getBorderColor(9);
            int borderColor7 = getBorderColor(11);
            int borderColor8 = getBorderColor(10);
            if (isBorderColorDefined(9)) {
                borderColor2 = borderColor6;
                borderColor4 = borderColor2;
            }
            if (!isBorderColorDefined(10)) {
                borderColor8 = borderColor4;
            }
            if (!isBorderColorDefined(11)) {
                borderColor7 = borderColor2;
            }
            if (Color.alpha(borderColor) != 0 || Color.alpha(borderColor7) != 0 || Color.alpha(borderColor3) != 0 || Color.alpha(borderColor8) != 0 || Color.alpha(borderColor5) != 0) {
                this.mInnerClipTempRectForBorderRadius.top += directionAwareBorderInsets.top;
                this.mInnerClipTempRectForBorderRadius.bottom -= directionAwareBorderInsets.bottom;
                this.mInnerClipTempRectForBorderRadius.left += directionAwareBorderInsets.left;
                this.mInnerClipTempRectForBorderRadius.right -= directionAwareBorderInsets.right;
            }
            this.mTempRectForCenterDrawPath.top += directionAwareBorderInsets.top * 0.5f;
            this.mTempRectForCenterDrawPath.bottom -= directionAwareBorderInsets.bottom * 0.5f;
            this.mTempRectForCenterDrawPath.left += directionAwareBorderInsets.left * 0.5f;
            this.mTempRectForCenterDrawPath.right -= directionAwareBorderInsets.right * 0.5f;
            ComputedBorderRadius computedBorderRadiusResolve = this.mBorderRadius.resolve(getLayoutDirection(), this.mContext, PixelUtil.toDIPFromPixel(this.mOuterClipTempRectForBorderRadius.width()), PixelUtil.toDIPFromPixel(this.mOuterClipTempRectForBorderRadius.height()));
            this.mComputedBorderRadius = computedBorderRadiusResolve;
            CornerRadii pixelFromDIP = computedBorderRadiusResolve.getTopLeft().toPixelFromDIP();
            CornerRadii pixelFromDIP2 = this.mComputedBorderRadius.getTopRight().toPixelFromDIP();
            CornerRadii pixelFromDIP3 = this.mComputedBorderRadius.getBottomLeft().toPixelFromDIP();
            CornerRadii pixelFromDIP4 = this.mComputedBorderRadius.getBottomRight().toPixelFromDIP();
            float innerBorderRadius = getInnerBorderRadius(pixelFromDIP.getHorizontal(), directionAwareBorderInsets.left);
            float innerBorderRadius2 = getInnerBorderRadius(pixelFromDIP.getVertical(), directionAwareBorderInsets.top);
            float innerBorderRadius3 = getInnerBorderRadius(pixelFromDIP2.getHorizontal(), directionAwareBorderInsets.right);
            float innerBorderRadius4 = getInnerBorderRadius(pixelFromDIP2.getVertical(), directionAwareBorderInsets.top);
            float innerBorderRadius5 = getInnerBorderRadius(pixelFromDIP4.getHorizontal(), directionAwareBorderInsets.right);
            float innerBorderRadius6 = getInnerBorderRadius(pixelFromDIP4.getVertical(), directionAwareBorderInsets.bottom);
            float innerBorderRadius7 = getInnerBorderRadius(pixelFromDIP3.getHorizontal(), directionAwareBorderInsets.left);
            float innerBorderRadius8 = getInnerBorderRadius(pixelFromDIP3.getVertical(), directionAwareBorderInsets.bottom);
            this.mInnerClipPathForBorderRadius.addRoundRect(this.mInnerClipTempRectForBorderRadius, new float[]{innerBorderRadius, innerBorderRadius2, innerBorderRadius3, innerBorderRadius4, innerBorderRadius5, innerBorderRadius6, innerBorderRadius7, innerBorderRadius8}, Path.Direction.CW);
            Path path = this.mBackgroundColorRenderPath;
            if (directionAwareBorderInsets.left > 0.0f) {
                f = this.mInnerClipTempRectForBorderRadius.left - 0.8f;
            } else {
                f = this.mInnerClipTempRectForBorderRadius.left;
            }
            float f5 = f;
            if (directionAwareBorderInsets.top > 0.0f) {
                f2 = this.mInnerClipTempRectForBorderRadius.top - 0.8f;
            } else {
                f2 = this.mInnerClipTempRectForBorderRadius.top;
            }
            float f6 = f2;
            if (directionAwareBorderInsets.right > 0.0f) {
                f3 = this.mInnerClipTempRectForBorderRadius.right + 0.8f;
            } else {
                f3 = this.mInnerClipTempRectForBorderRadius.right;
            }
            float f7 = f3;
            if (directionAwareBorderInsets.bottom > 0.0f) {
                f4 = this.mInnerClipTempRectForBorderRadius.bottom + 0.8f;
            } else {
                f4 = this.mInnerClipTempRectForBorderRadius.bottom;
            }
            path.addRoundRect(f5, f6, f7, f4, new float[]{innerBorderRadius, innerBorderRadius2, innerBorderRadius3, innerBorderRadius4, innerBorderRadius5, innerBorderRadius6, innerBorderRadius7, innerBorderRadius8}, Path.Direction.CW);
            this.mOuterClipPathForBorderRadius.addRoundRect(this.mOuterClipTempRectForBorderRadius, new float[]{pixelFromDIP.getHorizontal(), pixelFromDIP.getVertical(), pixelFromDIP2.getHorizontal(), pixelFromDIP2.getVertical(), pixelFromDIP4.getHorizontal(), pixelFromDIP4.getVertical(), pixelFromDIP3.getHorizontal(), pixelFromDIP3.getVertical()}, Path.Direction.CW);
            Spacing spacing = this.mBorderWidth;
            float f8 = spacing != null ? spacing.get(8) / 2.0f : 0.0f;
            this.mPathForBorderRadiusOutline.addRoundRect(this.mTempRectForBorderRadiusOutline, new float[]{pixelFromDIP.getHorizontal() + f8, pixelFromDIP.getVertical() + f8, pixelFromDIP2.getHorizontal() + f8, pixelFromDIP2.getVertical() + f8, pixelFromDIP4.getHorizontal() + f8, pixelFromDIP4.getVertical() + f8, pixelFromDIP3.getHorizontal() + f8, pixelFromDIP3.getVertical() + f8}, Path.Direction.CW);
            this.mCenterDrawPath.addRoundRect(this.mTempRectForCenterDrawPath, new float[]{pixelFromDIP.getHorizontal() - (directionAwareBorderInsets.left * 0.5f), pixelFromDIP.getVertical() - (directionAwareBorderInsets.top * 0.5f), pixelFromDIP2.getHorizontal() - (directionAwareBorderInsets.right * 0.5f), pixelFromDIP2.getVertical() - (directionAwareBorderInsets.top * 0.5f), pixelFromDIP4.getHorizontal() - (directionAwareBorderInsets.right * 0.5f), pixelFromDIP4.getVertical() - (directionAwareBorderInsets.bottom * 0.5f), pixelFromDIP3.getHorizontal() - (directionAwareBorderInsets.left * 0.5f), pixelFromDIP3.getVertical() - (directionAwareBorderInsets.bottom * 0.5f)}, Path.Direction.CW);
            if (this.mInnerTopLeftCorner == null) {
                this.mInnerTopLeftCorner = new PointF();
            }
            this.mInnerTopLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerTopLeftCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.left + (innerBorderRadius * 2.0f), this.mInnerClipTempRectForBorderRadius.top + (innerBorderRadius2 * 2.0f), this.mOuterClipTempRectForBorderRadius.left, this.mOuterClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopLeftCorner);
            if (this.mInnerBottomLeftCorner == null) {
                this.mInnerBottomLeftCorner = new PointF();
            }
            this.mInnerBottomLeftCorner.x = this.mInnerClipTempRectForBorderRadius.left;
            this.mInnerBottomLeftCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.bottom - (innerBorderRadius8 * 2.0f), this.mInnerClipTempRectForBorderRadius.left + (innerBorderRadius7 * 2.0f), this.mInnerClipTempRectForBorderRadius.bottom, this.mOuterClipTempRectForBorderRadius.left, this.mOuterClipTempRectForBorderRadius.bottom, this.mInnerClipTempRectForBorderRadius.left, this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomLeftCorner);
            if (this.mInnerTopRightCorner == null) {
                this.mInnerTopRightCorner = new PointF();
            }
            this.mInnerTopRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerTopRightCorner.y = this.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.right - (innerBorderRadius3 * 2.0f), this.mInnerClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.top + (innerBorderRadius4 * 2.0f), this.mOuterClipTempRectForBorderRadius.right, this.mOuterClipTempRectForBorderRadius.top, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.top, this.mInnerTopRightCorner);
            if (this.mInnerBottomRightCorner == null) {
                this.mInnerBottomRightCorner = new PointF();
            }
            this.mInnerBottomRightCorner.x = this.mInnerClipTempRectForBorderRadius.right;
            this.mInnerBottomRightCorner.y = this.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine(this.mInnerClipTempRectForBorderRadius.right - (innerBorderRadius5 * 2.0f), this.mInnerClipTempRectForBorderRadius.bottom - (innerBorderRadius6 * 2.0f), this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.bottom, this.mOuterClipTempRectForBorderRadius.right, this.mOuterClipTempRectForBorderRadius.bottom, this.mInnerClipTempRectForBorderRadius.right, this.mInnerClipTempRectForBorderRadius.bottom, this.mInnerBottomRightCorner);
        }
    }

    private static void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        double d9 = (d + d3) / 2.0d;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = d5 - d9;
        double d12 = d6 - d10;
        double dAbs = Math.abs(d3 - d) / 2.0d;
        double dAbs2 = Math.abs(d4 - d2) / 2.0d;
        double d13 = ((d8 - d10) - d12) / ((d7 - d9) - d11);
        double d14 = d12 - (d11 * d13);
        double d15 = dAbs2 * dAbs2;
        double d16 = dAbs * dAbs;
        double d17 = d15 + (d16 * d13 * d13);
        double d18 = dAbs * 2.0d * dAbs * d14 * d13;
        double d19 = (-(d16 * ((d14 * d14) - d15))) / d17;
        double d20 = d17 * 2.0d;
        double dSqrt = ((-d18) / d20) - Math.sqrt(d19 + Math.pow(d18 / d20, 2.0d));
        double d21 = (d13 * dSqrt) + d14;
        double d22 = dSqrt + d9;
        double d23 = d21 + d10;
        if (Double.isNaN(d22) || Double.isNaN(d23)) {
            return;
        }
        pointF.x = (float) d22;
        pointF.y = (float) d23;
    }

    public float getBorderWidthOrDefaultTo(float f, int i) {
        Float borderWidth = getBorderWidth(i);
        return borderWidth == null ? f : borderWidth.floatValue();
    }

    public Float getBorderWidth(int i) {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null) {
            return null;
        }
        float raw = spacing.getRaw(i);
        if (Float.isNaN(raw)) {
            return null;
        }
        return Float.valueOf(raw);
    }

    private void updatePathEffect() {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPaint.setPathEffect(borderStyle != null ? getPathEffect(borderStyle, getFullBorderWidth()) : null);
    }

    private void updatePathEffect(int i) {
        BorderStyle borderStyle = this.mBorderStyle;
        this.mPaint.setPathEffect(borderStyle != null ? getPathEffect(borderStyle, i) : null);
    }

    public float getFullBorderWidth() {
        Spacing spacing = this.mBorderWidth;
        if (spacing == null || Float.isNaN(spacing.getRaw(8))) {
            return 0.0f;
        }
        return this.mBorderWidth.getRaw(8);
    }

    private void drawRectangularBackgroundWithBorders(Canvas canvas) {
        int i;
        CSSBackgroundDrawable cSSBackgroundDrawable;
        this.mPaint.setStyle(Paint.Style.FILL);
        int iMultiplyColorAlpha = multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(iMultiplyColorAlpha) != 0) {
            this.mPaint.setColor(iMultiplyColorAlpha);
            canvas.drawRect(getBounds(), this.mPaint);
        }
        List<BackgroundImageLayer> list = this.mBackgroundImageLayers;
        if (list != null && !list.isEmpty()) {
            this.mPaint.setShader(getBackgroundImageShader());
            canvas.drawRect(getBounds(), this.mPaint);
            this.mPaint.setShader(null);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int iRound = Math.round(directionAwareBorderInsets.left);
        int iRound2 = Math.round(directionAwareBorderInsets.top);
        int iRound3 = Math.round(directionAwareBorderInsets.right);
        int iRound4 = Math.round(directionAwareBorderInsets.bottom);
        if (iRound > 0 || iRound3 > 0 || iRound2 > 0 || iRound4 > 0) {
            Rect bounds = getBounds();
            int borderColor = getBorderColor(0);
            int borderColor2 = getBorderColor(1);
            int borderColor3 = getBorderColor(2);
            int borderColor4 = getBorderColor(3);
            int borderColor5 = getBorderColor(9);
            int borderColor6 = getBorderColor(11);
            int borderColor7 = getBorderColor(10);
            if (isBorderColorDefined(9)) {
                borderColor2 = borderColor5;
                borderColor4 = borderColor2;
            }
            if (isBorderColorDefined(10)) {
                borderColor4 = borderColor7;
            }
            if (isBorderColorDefined(11)) {
                borderColor2 = borderColor6;
            }
            boolean z = getLayoutDirection() == 1;
            int borderColor8 = getBorderColor(4);
            int borderColor9 = getBorderColor(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (isBorderColorDefined(4)) {
                    borderColor = borderColor8;
                }
                if (isBorderColorDefined(5)) {
                    borderColor3 = borderColor9;
                }
                int i2 = z ? borderColor3 : borderColor;
                if (z) {
                    borderColor3 = borderColor;
                }
                i = iRound;
                borderColor = i2;
            } else {
                int i3 = z ? borderColor9 : borderColor8;
                if (!z) {
                    borderColor8 = borderColor9;
                }
                boolean zIsBorderColorDefined = isBorderColorDefined(4);
                i = iRound;
                boolean zIsBorderColorDefined2 = isBorderColorDefined(5);
                boolean z2 = z ? zIsBorderColorDefined2 : zIsBorderColorDefined;
                if (!z) {
                    zIsBorderColorDefined = zIsBorderColorDefined2;
                }
                if (z2) {
                    borderColor = i3;
                }
                if (zIsBorderColorDefined) {
                    borderColor3 = borderColor8;
                }
            }
            int i4 = bounds.left;
            int i5 = bounds.top;
            int iFastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(i, iRound2, iRound3, iRound4, borderColor, borderColor2, borderColor3, borderColor4);
            int i6 = borderColor2;
            int i7 = borderColor3;
            int i8 = borderColor4;
            if (iFastBorderCompatibleColorOrZero != 0) {
                if (Color.alpha(iFastBorderCompatibleColorOrZero) != 0) {
                    int i9 = bounds.right;
                    int i10 = bounds.bottom;
                    this.mPaint.setColor(iFastBorderCompatibleColorOrZero);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    if (i > 0) {
                        this.mPathForSingleBorder.reset();
                        int iRound5 = Math.round(directionAwareBorderInsets.left);
                        updatePathEffect(iRound5);
                        this.mPaint.setStrokeWidth(iRound5);
                        float f = (iRound5 / 2) + i4;
                        this.mPathForSingleBorder.moveTo(f, i5);
                        this.mPathForSingleBorder.lineTo(f, i10);
                        canvas.drawPath(this.mPathForSingleBorder, this.mPaint);
                    }
                    if (iRound2 > 0) {
                        this.mPathForSingleBorder.reset();
                        int iRound6 = Math.round(directionAwareBorderInsets.top);
                        updatePathEffect(iRound6);
                        this.mPaint.setStrokeWidth(iRound6);
                        float f2 = (iRound6 / 2) + i5;
                        this.mPathForSingleBorder.moveTo(i4, f2);
                        this.mPathForSingleBorder.lineTo(i9, f2);
                        canvas.drawPath(this.mPathForSingleBorder, this.mPaint);
                    }
                    if (iRound3 > 0) {
                        this.mPathForSingleBorder.reset();
                        int iRound7 = Math.round(directionAwareBorderInsets.right);
                        updatePathEffect(iRound7);
                        this.mPaint.setStrokeWidth(iRound7);
                        float f3 = i9 - (iRound7 / 2);
                        this.mPathForSingleBorder.moveTo(f3, i5);
                        this.mPathForSingleBorder.lineTo(f3, i10);
                        canvas.drawPath(this.mPathForSingleBorder, this.mPaint);
                    }
                    if (iRound4 > 0) {
                        this.mPathForSingleBorder.reset();
                        int iRound8 = Math.round(directionAwareBorderInsets.bottom);
                        updatePathEffect(iRound8);
                        this.mPaint.setStrokeWidth(iRound8);
                        float f4 = i10 - (iRound8 / 2);
                        this.mPathForSingleBorder.moveTo(i4, f4);
                        this.mPathForSingleBorder.lineTo(i9, f4);
                        canvas.drawPath(this.mPathForSingleBorder, this.mPaint);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mPaint.setAntiAlias(false);
            int iWidth = bounds.width();
            int iHeight = bounds.height();
            if (i > 0) {
                float f5 = i4;
                float f6 = i4 + i;
                int i11 = i5 + iHeight;
                drawQuadrilateral(canvas, borderColor, f5, i5, f6, i5 + iRound2, f6, i11 - iRound4, f5, i11);
            }
            if (iRound2 > 0) {
                float f7 = i5;
                float f8 = i5 + iRound2;
                int i12 = i4 + iWidth;
                drawQuadrilateral(canvas, i6, i4, f7, i4 + i, f8, i12 - iRound3, f8, i12, f7);
            }
            if (iRound3 > 0) {
                int i13 = i4 + iWidth;
                float f9 = i13;
                int i14 = i5 + iHeight;
                float f10 = i13 - iRound3;
                drawQuadrilateral(canvas, i7, f9, i5, f9, i14, f10, i14 - iRound4, f10, i5 + iRound2);
            }
            if (iRound4 > 0) {
                int i15 = i5 + iHeight;
                float f11 = i15;
                int i16 = iWidth + i4;
                float f12 = i15 - iRound4;
                cSSBackgroundDrawable = this;
                cSSBackgroundDrawable.drawQuadrilateral(canvas, i8, i4, f11, i16, f11, i16 - iRound3, f12, i4 + i, f12);
            } else {
                cSSBackgroundDrawable = this;
            }
            cSSBackgroundDrawable.mPaint.setAntiAlias(true);
        }
    }

    private void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i == 0) {
            return;
        }
        if (this.mPathForBorder == null) {
            this.mPathForBorder = new Path();
        }
        this.mPaint.setColor(i);
        this.mPathForBorder.reset();
        this.mPathForBorder.moveTo(f, f2);
        this.mPathForBorder.lineTo(f3, f4);
        this.mPathForBorder.lineTo(f5, f6);
        this.mPathForBorder.lineTo(f7, f8);
        this.mPathForBorder.lineTo(f, f2);
        canvas.drawPath(this.mPathForBorder, this.mPaint);
    }

    private boolean isBorderColorDefined(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = spacing != null ? spacing.get(i) : Float.NaN;
        Spacing spacing2 = this.mBorderAlpha;
        return (Float.isNaN(f) || Float.isNaN(spacing2 != null ? spacing2.get(i) : Float.NaN)) ? false : true;
    }

    public int getBorderColor(int i) {
        Spacing spacing = this.mBorderRGB;
        float f = spacing != null ? spacing.get(i) : 0.0f;
        Spacing spacing2 = this.mBorderAlpha;
        return colorFromAlphaAndRGBComponents(spacing2 != null ? spacing2.get(i) : 255.0f, f);
    }

    public RectF getDirectionAwareBorderInsets() {
        float borderWidthOrDefaultTo = getBorderWidthOrDefaultTo(0.0f, 8);
        float borderWidthOrDefaultTo2 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 1);
        float borderWidthOrDefaultTo3 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 3);
        float borderWidthOrDefaultTo4 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 0);
        float borderWidthOrDefaultTo5 = getBorderWidthOrDefaultTo(borderWidthOrDefaultTo, 2);
        if (this.mBorderWidth != null) {
            boolean z = getLayoutDirection() == 1;
            float raw = this.mBorderWidth.getRaw(4);
            float raw2 = this.mBorderWidth.getRaw(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(this.mContext)) {
                if (!Float.isNaN(raw)) {
                    borderWidthOrDefaultTo4 = raw;
                }
                if (!Float.isNaN(raw2)) {
                    borderWidthOrDefaultTo5 = raw2;
                }
                float f = z ? borderWidthOrDefaultTo5 : borderWidthOrDefaultTo4;
                if (z) {
                    borderWidthOrDefaultTo5 = borderWidthOrDefaultTo4;
                }
                borderWidthOrDefaultTo4 = f;
            } else {
                float f2 = z ? raw2 : raw;
                if (!z) {
                    raw = raw2;
                }
                if (!Float.isNaN(f2)) {
                    borderWidthOrDefaultTo4 = f2;
                }
                if (!Float.isNaN(raw)) {
                    borderWidthOrDefaultTo5 = raw;
                }
            }
        }
        return new RectF(borderWidthOrDefaultTo4, borderWidthOrDefaultTo2, borderWidthOrDefaultTo5, borderWidthOrDefaultTo3);
    }

    private Shader getBackgroundImageShader() {
        List<BackgroundImageLayer> list = this.mBackgroundImageLayers;
        Shader composeShader = null;
        if (list == null) {
            return null;
        }
        Iterator<BackgroundImageLayer> it = list.iterator();
        while (it.hasNext()) {
            Shader shader = it.next().getShader(getBounds());
            if (shader != null) {
                composeShader = composeShader == null ? shader : new ComposeShader(shader, composeShader, PorterDuff.Mode.SRC_OVER);
            }
        }
        return composeShader;
    }
}
