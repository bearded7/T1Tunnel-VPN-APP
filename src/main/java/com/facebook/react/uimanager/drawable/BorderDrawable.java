package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BorderColors;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.ColorEdges;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.LogicalEdge;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: BorderDrawable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u0002H\u001b0\u0019\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u0002H\u001bH\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010G\u001a\u00020HH\u0016J\u0010\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020KH\u0014J\u0010\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020-H\u0016J\u0012\u0010N\u001a\u00020H2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020-H\u0017J\u0010\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0016J\u0018\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020/2\u0006\u0010\u0004\u001a\u00020/H\u0002J\u0016\u0010W\u001a\u00020H2\u0006\u0010X\u001a\u00020-2\u0006\u0010Y\u001a\u00020/J\u0018\u0010\u0012\u001a\u00020H2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]J\u0010\u0010!\u001a\u00020H2\b\u0010^\u001a\u0004\u0018\u00010_J\u001d\u0010`\u001a\u00020H2\u0006\u0010X\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010-¢\u0006\u0002\u0010cJ\u000e\u0010d\u001a\u00020-2\u0006\u0010X\u001a\u00020aJ\u0010\u0010e\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010f\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0002JH\u0010g\u001a\u00020-2\u0006\u0010h\u001a\u00020-2\u0006\u0010i\u001a\u00020-2\u0006\u0010j\u001a\u00020-2\u0006\u0010k\u001a\u00020-2\u0006\u0010l\u001a\u00020-2\u0006\u0010m\u001a\u00020-2\u0006\u0010n\u001a\u00020-2\u0006\u0010o\u001a\u00020-H\u0002JX\u0010p\u001a\u00020H2\u0006\u0010S\u001a\u00020T2\u0006\u0010q\u001a\u00020-2\u0006\u0010r\u001a\u00020/2\u0006\u0010s\u001a\u00020/2\u0006\u0010t\u001a\u00020/2\u0006\u0010u\u001a\u00020/2\u0006\u0010v\u001a\u00020/2\u0006\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020/2\u0006\u0010y\u001a\u00020/H\u0002J\b\u0010z\u001a\u00020DH\u0002J\b\u0010{\u001a\u00020/H\u0002J\b\u0010|\u001a\u00020HH\u0002J\u0010\u0010|\u001a\u00020H2\u0006\u0010\u0004\u001a\u00020-H\u0002J\u001a\u0010}\u001a\u0004\u0018\u00010~2\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020/H\u0002Ja\u0010\u007f\u001a\u00020H2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0081\u00012\b\u0010\u0083\u0001\u001a\u00030\u0081\u00012\b\u0010\u0084\u0001\u001a\u00030\u0081\u00012\b\u0010\u0085\u0001\u001a\u00030\u0081\u00012\b\u0010\u0086\u0001\u001a\u00030\u0081\u00012\b\u0010\u0087\u0001\u001a\u00030\u0081\u00012\b\u0010\u0088\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0089\u0001\u001a\u00020?H\u0002J\t\u0010\u008a\u0001\u001a\u00020HH\u0002J\u001a\u0010\u008b\u0001\u001a\u00020-2\u0006\u0010b\u001a\u00020-2\u0007\u0010\u008c\u0001\u001a\u00020-H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R/\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0012\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082D¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010;\u001a\u0004\u0018\u0001012\b\u0010:\u001a\u0004\u0018\u000101@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/facebook/react/uimanager/drawable/BorderDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", ViewProps.BORDER_WIDTH, "Lcom/facebook/react/uimanager/Spacing;", ViewProps.BORDER_RADIUS, "Lcom/facebook/react/uimanager/style/BorderRadiusStyle;", "borderInsets", "Lcom/facebook/react/uimanager/style/BorderInsets;", "borderStyle", "Lcom/facebook/react/uimanager/style/BorderStyle;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/uimanager/Spacing;Lcom/facebook/react/uimanager/style/BorderRadiusStyle;Lcom/facebook/react/uimanager/style/BorderInsets;Lcom/facebook/react/uimanager/style/BorderStyle;)V", "getBorderWidth", "()Lcom/facebook/react/uimanager/Spacing;", "getBorderRadius", "()Lcom/facebook/react/uimanager/style/BorderRadiusStyle;", "setBorderRadius", "(Lcom/facebook/react/uimanager/style/BorderRadiusStyle;)V", "getBorderInsets", "()Lcom/facebook/react/uimanager/style/BorderInsets;", "setBorderInsets", "(Lcom/facebook/react/uimanager/style/BorderInsets;)V", "invalidatingAndPathChange", "Lkotlin/properties/ReadWriteProperty;", "", ExifInterface.GPS_DIRECTION_TRUE, "initialValue", "(Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "<set-?>", "getBorderStyle", "()Lcom/facebook/react/uimanager/style/BorderStyle;", "setBorderStyle", "(Lcom/facebook/react/uimanager/style/BorderStyle;)V", "borderStyle$delegate", "Lkotlin/properties/ReadWriteProperty;", "borderColors", "Lcom/facebook/react/uimanager/style/BorderColors;", "[Ljava/lang/Integer;", "computedBorderColors", "Lcom/facebook/react/uimanager/style/ColorEdges;", "computedBorderRadius", "Lcom/facebook/react/uimanager/style/ComputedBorderRadius;", "borderAlpha", "", "gapBetweenPaths", "", "pathForBorder", "Landroid/graphics/Path;", "borderPaint", "Landroid/graphics/Paint;", "needUpdatePath", "", "pathForSingleBorder", "pathForOutline", "centerDrawPath", "outerClipPathForBorderRadius", "value", "innerClipPathForBorderRadius", "getInnerClipPathForBorderRadius", "()Landroid/graphics/Path;", "innerBottomLeftCorner", "Landroid/graphics/PointF;", "innerBottomRightCorner", "innerTopLeftCorner", "innerTopRightCorner", "innerClipTempRectForBorderRadius", "Landroid/graphics/RectF;", "outerClipTempRectForBorderRadius", "tempRectForCenterDrawPath", "invalidateSelf", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "draw", "canvas", "Landroid/graphics/Canvas;", "getInnerBorderRadius", "computedRadius", "setBorderWidth", ViewProps.POSITION, "width", "property", "Lcom/facebook/react/uimanager/style/BorderRadiusProp;", "radius", "Lcom/facebook/react/uimanager/LengthPercentage;", "style", "", "setBorderColor", "Lcom/facebook/react/uimanager/style/LogicalEdge;", ViewProps.COLOR, "(Lcom/facebook/react/uimanager/style/LogicalEdge;Ljava/lang/Integer;)V", "getBorderColor", "drawRectangularBorders", "drawRoundedBorders", "fastBorderCompatibleColorOrZero", "borderLeft", "borderTop", "borderRight", "borderBottom", "colorLeft", "colorTop", "colorRight", "colorBottom", "drawQuadrilateral", "fillColor", "x1", "y1", "x2", "y2", "x3", "y3", "x4", "y4", "computeBorderInsets", "getFullBorderWidth", "updatePathEffect", "getPathEffect", "Landroid/graphics/PathEffect;", "getEllipseIntersectionWithLine", "ellipseBoundsLeft", "", "ellipseBoundsTop", "ellipseBoundsRight", "ellipseBoundsBottom", "lineStartX", "lineStartY", "lineEndX", "lineEndY", "result", "updatePath", "multiplyColorAlpha", "rawAlpha", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderDrawable extends Drawable {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BorderDrawable.class, "borderStyle", "getBorderStyle()Lcom/facebook/react/uimanager/style/BorderStyle;", 0))};
    private int borderAlpha;
    private Integer[] borderColors;
    private BorderInsets borderInsets;
    private final Paint borderPaint;
    private BorderRadiusStyle borderRadius;

    /* JADX INFO: renamed from: borderStyle$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty borderStyle;
    private final Spacing borderWidth;
    private Path centerDrawPath;
    private ColorEdges computedBorderColors;
    private ComputedBorderRadius computedBorderRadius;
    private final Context context;
    private final float gapBetweenPaths;
    private PointF innerBottomLeftCorner;
    private PointF innerBottomRightCorner;
    private Path innerClipPathForBorderRadius;
    private RectF innerClipTempRectForBorderRadius;
    private PointF innerTopLeftCorner;
    private PointF innerTopRightCorner;
    private boolean needUpdatePath;
    private Path outerClipPathForBorderRadius;
    private RectF outerClipTempRectForBorderRadius;
    private Path pathForBorder;
    private Path pathForOutline;
    private Path pathForSingleBorder;
    private RectF tempRectForCenterDrawPath;

    /* JADX INFO: compiled from: BorderDrawable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            try {
                iArr[BorderStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BorderStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int multiplyColorAlpha(int color, int rawAlpha) {
        if (rawAlpha == 255) {
            return color;
        }
        if (rawAlpha == 0) {
            return color & ViewCompat.MEASURED_SIZE_MASK;
        }
        return (color & ViewCompat.MEASURED_SIZE_MASK) | ((((color >>> 24) * ((rawAlpha + (rawAlpha >> 7)) >> 7)) >> 8) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final Spacing getBorderWidth() {
        return this.borderWidth;
    }

    public final BorderRadiusStyle getBorderRadius() {
        return this.borderRadius;
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public final BorderInsets getBorderInsets() {
        return this.borderInsets;
    }

    public final void setBorderInsets(BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public BorderDrawable(Context context, Spacing spacing, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets, BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderWidth = spacing;
        this.borderRadius = borderRadiusStyle;
        this.borderInsets = borderInsets;
        this.borderStyle = invalidatingAndPathChange(borderStyle);
        this.computedBorderColors = new ColorEdges(0, 0, 0, 0, 15, null);
        this.borderAlpha = 255;
        this.gapBetweenPaths = 0.8f;
        this.borderPaint = new Paint(1);
        this.needUpdatePath = true;
    }

    private final <T> ReadWriteProperty<Object, T> invalidatingAndPathChange(T initialValue) {
        return new ObservableProperty<T>(initialValue) { // from class: com.facebook.react.uimanager.drawable.BorderDrawable.invalidatingAndPathChange.1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, T oldValue, T newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(oldValue, newValue)) {
                    return;
                }
                this.needUpdatePath = true;
                this.invalidateSelf();
            }
        };
    }

    public final BorderStyle getBorderStyle() {
        return (BorderStyle) this.borderStyle.getValue(this, $$delegatedProperties[0]);
    }

    public final void setBorderStyle(BorderStyle borderStyle) {
        this.borderStyle.setValue(this, $$delegatedProperties[0], borderStyle);
    }

    public final Path getInnerClipPathForBorderRadius() {
        return this.innerClipPathForBorderRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.needUpdatePath = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.needUpdatePath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.borderAlpha = alpha;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        if (ComparisonsKt.maxOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 0) {
            return -2;
        }
        return ComparisonsKt.minOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 255 ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ColorEdges colorEdgesM520resolveimpl;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        updatePathEffect();
        Integer[] numArr = this.borderColors;
        if (numArr == null || (colorEdgesM520resolveimpl = BorderColors.m520resolveimpl(numArr, getLayoutDirection(), this.context)) == null) {
            colorEdgesM520resolveimpl = this.computedBorderColors;
        }
        this.computedBorderColors = colorEdgesM520resolveimpl;
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null && borderRadiusStyle.hasRoundedBorders()) {
            drawRoundedBorders(canvas);
        } else {
            drawRectangularBorders(canvas);
        }
    }

    private final float getInnerBorderRadius(float computedRadius, float borderWidth) {
        return RangesKt.coerceAtLeast(computedRadius - borderWidth, 0.0f);
    }

    public final void setBorderWidth(int position, float width) {
        Spacing spacing = this.borderWidth;
        if (FloatUtil.floatsEqual(spacing != null ? Float.valueOf(spacing.getRaw(position)) : null, Float.valueOf(width))) {
            return;
        }
        Spacing spacing2 = this.borderWidth;
        if (spacing2 != null) {
            spacing2.set(position, width);
        }
        if (position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 8) {
            this.needUpdatePath = true;
        }
        invalidateSelf();
    }

    public final void setBorderRadius(BorderRadiusProp property, LengthPercentage radius) {
        Intrinsics.checkNotNullParameter(property, "property");
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (Intrinsics.areEqual(radius, borderRadiusStyle != null ? borderRadiusStyle.get(property) : null)) {
            return;
        }
        BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
        if (borderRadiusStyle2 != null) {
            borderRadiusStyle2.set(property, radius);
        }
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final void setBorderStyle(String style) {
        BorderStyle borderStyleValueOf;
        if (style == null) {
            borderStyleValueOf = null;
        } else {
            String upperCase = style.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            borderStyleValueOf = BorderStyle.valueOf(upperCase);
        }
        setBorderStyle(borderStyleValueOf);
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final void setBorderColor(LogicalEdge position, Integer color) {
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArrM516constructorimpl$default = this.borderColors;
        if (numArrM516constructorimpl$default == null) {
            numArrM516constructorimpl$default = BorderColors.m516constructorimpl$default(null, 1, null);
        }
        this.borderColors = numArrM516constructorimpl$default;
        if (numArrM516constructorimpl$default != null) {
            numArrM516constructorimpl$default[position.ordinal()] = color;
        }
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final int getBorderColor(LogicalEdge position) {
        Integer num;
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArr = this.borderColors;
        return (numArr == null || (num = numArr[position.ordinal()]) == null) ? ViewCompat.MEASURED_STATE_MASK : num.intValue();
    }

    private final void drawRectangularBorders(Canvas canvas) {
        RectF rectFComputeBorderInsets = computeBorderInsets();
        int iRoundToInt = MathKt.roundToInt(rectFComputeBorderInsets.left);
        int iRoundToInt2 = MathKt.roundToInt(rectFComputeBorderInsets.top);
        int iRoundToInt3 = MathKt.roundToInt(rectFComputeBorderInsets.right);
        int iRoundToInt4 = MathKt.roundToInt(rectFComputeBorderInsets.bottom);
        if (iRoundToInt > 0 || iRoundToInt3 > 0 || iRoundToInt2 > 0 || iRoundToInt4 > 0) {
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            int i = bounds.left;
            int i2 = bounds.top;
            int iFastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(iRoundToInt, iRoundToInt2, iRoundToInt3, iRoundToInt4, this.computedBorderColors.getLeft(), this.computedBorderColors.getTop(), this.computedBorderColors.getRight(), this.computedBorderColors.getBottom());
            if (iFastBorderCompatibleColorOrZero != 0) {
                if (Color.alpha(iFastBorderCompatibleColorOrZero) != 0) {
                    int i3 = bounds.right;
                    int i4 = bounds.bottom;
                    this.borderPaint.setColor(multiplyColorAlpha(iFastBorderCompatibleColorOrZero, this.borderAlpha));
                    this.borderPaint.setStyle(Paint.Style.STROKE);
                    Path path = new Path();
                    this.pathForSingleBorder = path;
                    if (iRoundToInt > 0) {
                        path.reset();
                        int iRoundToInt5 = MathKt.roundToInt(rectFComputeBorderInsets.left);
                        updatePathEffect(iRoundToInt5);
                        this.borderPaint.setStrokeWidth(iRoundToInt5);
                        Path path2 = this.pathForSingleBorder;
                        if (path2 != null) {
                            path2.moveTo((iRoundToInt5 / 2) + i, i2);
                        }
                        Path path3 = this.pathForSingleBorder;
                        if (path3 != null) {
                            path3.lineTo((iRoundToInt5 / 2) + i, i4);
                        }
                        Path path4 = this.pathForSingleBorder;
                        if (path4 != null) {
                            canvas.drawPath(path4, this.borderPaint);
                        }
                    }
                    if (iRoundToInt2 > 0) {
                        Path path5 = this.pathForSingleBorder;
                        if (path5 != null) {
                            path5.reset();
                        }
                        int iRoundToInt6 = MathKt.roundToInt(rectFComputeBorderInsets.top);
                        updatePathEffect(iRoundToInt6);
                        this.borderPaint.setStrokeWidth(iRoundToInt6);
                        Path path6 = this.pathForSingleBorder;
                        if (path6 != null) {
                            path6.moveTo(i, (iRoundToInt6 / 2) + i2);
                        }
                        Path path7 = this.pathForSingleBorder;
                        if (path7 != null) {
                            path7.lineTo(i3, (iRoundToInt6 / 2) + i2);
                        }
                        Path path8 = this.pathForSingleBorder;
                        if (path8 != null) {
                            canvas.drawPath(path8, this.borderPaint);
                        }
                    }
                    if (iRoundToInt3 > 0) {
                        Path path9 = this.pathForSingleBorder;
                        if (path9 != null) {
                            path9.reset();
                        }
                        int iRoundToInt7 = MathKt.roundToInt(rectFComputeBorderInsets.right);
                        updatePathEffect(iRoundToInt7);
                        this.borderPaint.setStrokeWidth(iRoundToInt7);
                        Path path10 = this.pathForSingleBorder;
                        if (path10 != null) {
                            path10.moveTo(i3 - (iRoundToInt7 / 2), i2);
                        }
                        Path path11 = this.pathForSingleBorder;
                        if (path11 != null) {
                            path11.lineTo(i3 - (iRoundToInt7 / 2), i4);
                        }
                        Path path12 = this.pathForSingleBorder;
                        if (path12 != null) {
                            canvas.drawPath(path12, this.borderPaint);
                        }
                    }
                    if (iRoundToInt4 > 0) {
                        Path path13 = this.pathForSingleBorder;
                        if (path13 != null) {
                            path13.reset();
                        }
                        int iRoundToInt8 = MathKt.roundToInt(rectFComputeBorderInsets.bottom);
                        updatePathEffect(iRoundToInt8);
                        this.borderPaint.setStrokeWidth(iRoundToInt8);
                        Path path14 = this.pathForSingleBorder;
                        if (path14 != null) {
                            path14.moveTo(i, i4 - (iRoundToInt8 / 2));
                        }
                        Path path15 = this.pathForSingleBorder;
                        if (path15 != null) {
                            path15.lineTo(i3, i4 - (iRoundToInt8 / 2));
                        }
                        Path path16 = this.pathForSingleBorder;
                        if (path16 != null) {
                            canvas.drawPath(path16, this.borderPaint);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.borderPaint.setAntiAlias(false);
            int iWidth = bounds.width();
            int iHeight = bounds.height();
            if (iRoundToInt > 0) {
                float f = i;
                float f2 = i + iRoundToInt;
                int i5 = i2 + iHeight;
                drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f, i2, f2, i2 + iRoundToInt2, f2, i5 - iRoundToInt4, f, i5);
            }
            if (iRoundToInt2 > 0) {
                float f3 = i2;
                float f4 = i + iRoundToInt;
                float f5 = i2 + iRoundToInt2;
                int i6 = i + iWidth;
                drawQuadrilateral(canvas, this.computedBorderColors.getTop(), i, f3, f4, f5, i6 - iRoundToInt3, f5, i6, f3);
            }
            if (iRoundToInt3 > 0) {
                int i7 = i + iWidth;
                float f6 = i7;
                int i8 = i2 + iHeight;
                float f7 = i7 - iRoundToInt3;
                drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f6, i2, f6, i8, f7, i8 - iRoundToInt4, f7, i2 + iRoundToInt2);
            }
            if (iRoundToInt4 > 0) {
                int i9 = i2 + iHeight;
                float f8 = i9;
                int i10 = i + iWidth;
                float f9 = i9 - iRoundToInt4;
                drawQuadrilateral(canvas, this.computedBorderColors.getBottom(), i, f8, i10, f8, i10 - iRoundToInt3, f9, i + iRoundToInt, f9);
            }
            this.borderPaint.setAntiAlias(true);
        }
    }

    private final void drawRoundedBorders(Canvas canvas) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        CornerRadii topLeft;
        CornerRadii pixelFromDIP;
        CornerRadii topLeft2;
        CornerRadii pixelFromDIP2;
        updatePath();
        canvas.save();
        Path path = this.outerClipPathForBorderRadius;
        if (path == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        canvas.clipPath(path);
        RectF rectFComputeBorderInsets = computeBorderInsets();
        float vertical = 0.0f;
        if (rectFComputeBorderInsets.top > 0.0f || rectFComputeBorderInsets.bottom > 0.0f || rectFComputeBorderInsets.left > 0.0f || rectFComputeBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            int borderColor = getBorderColor(LogicalEdge.ALL);
            if (rectFComputeBorderInsets.top != fullBorderWidth || rectFComputeBorderInsets.bottom != fullBorderWidth || rectFComputeBorderInsets.left != fullBorderWidth || rectFComputeBorderInsets.right != fullBorderWidth || this.computedBorderColors.getLeft() != borderColor || this.computedBorderColors.getTop() != borderColor || this.computedBorderColors.getRight() != borderColor || this.computedBorderColors.getBottom() != borderColor) {
                this.borderPaint.setStyle(Paint.Style.FILL);
                if (Build.VERSION.SDK_INT >= 26) {
                    Path path2 = this.innerClipPathForBorderRadius;
                    if (path2 == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    canvas.clipOutPath(path2);
                } else {
                    Path path3 = this.innerClipPathForBorderRadius;
                    if (path3 == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    canvas.clipPath(path3, Region.Op.DIFFERENCE);
                }
                RectF rectF = this.outerClipTempRectForBorderRadius;
                if (rectF == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                float f = rectF.left;
                float f2 = rectF.right;
                float f3 = rectF.top;
                float f4 = rectF.bottom;
                PointF pointF4 = this.innerTopLeftCorner;
                if (pointF4 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                PointF pointF5 = this.innerTopRightCorner;
                if (pointF5 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                PointF pointF6 = this.innerBottomLeftCorner;
                if (pointF6 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                PointF pointF7 = this.innerBottomRightCorner;
                if (pointF7 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                if (rectFComputeBorderInsets.left > 0.0f) {
                    float f5 = f3 - this.gapBetweenPaths;
                    float f6 = pointF4.x;
                    float f7 = pointF4.y - this.gapBetweenPaths;
                    float f8 = pointF6.x;
                    float f9 = pointF6.y;
                    float f10 = this.gapBetweenPaths;
                    float f11 = f9 + f10;
                    float f12 = f10 + f4;
                    pointF2 = pointF6;
                    pointF3 = pointF7;
                    pointF = pointF5;
                    drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f, f5, f6, f7, f8, f11, f, f12);
                } else {
                    pointF = pointF5;
                    pointF2 = pointF6;
                    pointF3 = pointF7;
                }
                if (rectFComputeBorderInsets.top > vertical) {
                    drawQuadrilateral(canvas, this.computedBorderColors.getTop(), f - this.gapBetweenPaths, f3, pointF4.x - this.gapBetweenPaths, pointF4.y, pointF.x + this.gapBetweenPaths, pointF.y, f2 + this.gapBetweenPaths, f3);
                }
                if (rectFComputeBorderInsets.right > vertical) {
                    float f13 = f3 - this.gapBetweenPaths;
                    float f14 = pointF.x;
                    float f15 = pointF.y - this.gapBetweenPaths;
                    float f16 = pointF3.x;
                    float f17 = pointF3.y;
                    float f18 = this.gapBetweenPaths;
                    drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f2, f13, f14, f15, f16, f17 + f18, f2, f4 + f18);
                }
                if (rectFComputeBorderInsets.bottom > 0) {
                    drawQuadrilateral(canvas, this.computedBorderColors.getBottom(), f - this.gapBetweenPaths, f4, pointF2.x - this.gapBetweenPaths, pointF2.y, pointF3.x + this.gapBetweenPaths, pointF3.y, f2 + this.gapBetweenPaths, f4);
                }
            } else if (fullBorderWidth > 0.0f) {
                this.borderPaint.setColor(multiplyColorAlpha(borderColor, this.borderAlpha));
                this.borderPaint.setStyle(Paint.Style.STROKE);
                this.borderPaint.setStrokeWidth(fullBorderWidth);
                ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
                if (computedBorderRadius != null && computedBorderRadius.isUniform()) {
                    RectF rectF2 = this.tempRectForCenterDrawPath;
                    if (rectF2 != null) {
                        ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
                        float horizontal = ((computedBorderRadius2 == null || (topLeft2 = computedBorderRadius2.getTopLeft()) == null || (pixelFromDIP2 = topLeft2.toPixelFromDIP()) == null) ? 0.0f : pixelFromDIP2.getHorizontal()) - (rectFComputeBorderInsets.left * 0.5f);
                        ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
                        if (computedBorderRadius3 != null && (topLeft = computedBorderRadius3.getTopLeft()) != null && (pixelFromDIP = topLeft.toPixelFromDIP()) != null) {
                            vertical = pixelFromDIP.getVertical();
                        }
                        canvas.drawRoundRect(rectF2, horizontal, vertical - (rectFComputeBorderInsets.top * 0.5f), this.borderPaint);
                    }
                } else {
                    Path path4 = this.centerDrawPath;
                    if (path4 == null) {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    canvas.drawPath(path4, this.borderPaint);
                }
            }
        }
        canvas.restore();
    }

    private final int fastBorderCompatibleColorOrZero(int borderLeft, int borderTop, int borderRight, int borderBottom, int colorLeft, int colorTop, int colorRight, int colorBottom) {
        if (Color.alpha(colorLeft) >= 255 && Color.alpha(colorTop) >= 255 && Color.alpha(colorRight) >= 255 && Color.alpha(colorBottom) >= 255) {
            int i = (borderBottom > 0 ? colorBottom : -1) & (borderLeft > 0 ? colorLeft : -1) & (borderTop > 0 ? colorTop : -1) & (borderRight > 0 ? colorRight : -1);
            if (borderLeft <= 0) {
                colorLeft = 0;
            }
            if (borderTop <= 0) {
                colorTop = 0;
            }
            int i2 = colorLeft | colorTop;
            if (borderRight <= 0) {
                colorRight = 0;
            }
            int i3 = i2 | colorRight;
            if (borderBottom <= 0) {
                colorBottom = 0;
            }
            if (i == (i3 | colorBottom)) {
                return i;
            }
        }
        return 0;
    }

    private final void drawQuadrilateral(Canvas canvas, int fillColor, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
        if (fillColor == 0) {
            return;
        }
        if (this.pathForBorder == null) {
            this.pathForBorder = new Path();
        }
        this.borderPaint.setColor(multiplyColorAlpha(fillColor, this.borderAlpha));
        Path path = this.pathForBorder;
        if (path != null) {
            path.reset();
        }
        Path path2 = this.pathForBorder;
        if (path2 != null) {
            path2.moveTo(x1, y1);
        }
        Path path3 = this.pathForBorder;
        if (path3 != null) {
            path3.lineTo(x2, y2);
        }
        Path path4 = this.pathForBorder;
        if (path4 != null) {
            path4.lineTo(x3, y3);
        }
        Path path5 = this.pathForBorder;
        if (path5 != null) {
            path5.lineTo(x4, y4);
        }
        Path path6 = this.pathForBorder;
        if (path6 != null) {
            path6.lineTo(x1, y1);
        }
        Path path7 = this.pathForBorder;
        if (path7 != null) {
            canvas.drawPath(path7, this.borderPaint);
        }
    }

    private final RectF computeBorderInsets() {
        RectF rectFResolve;
        BorderInsets borderInsets = this.borderInsets;
        if (borderInsets != null && (rectFResolve = borderInsets.resolve(getLayoutDirection(), this.context)) != null) {
            return new RectF(Float.isNaN(rectFResolve.left) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.left), Float.isNaN(rectFResolve.top) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.top), Float.isNaN(rectFResolve.right) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.right), Float.isNaN(rectFResolve.bottom) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom));
        }
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    private final float getFullBorderWidth() {
        Spacing spacing = this.borderWidth;
        float raw = spacing != null ? spacing.getRaw(8) : Float.NaN;
        if (Float.isNaN(raw)) {
            return 0.0f;
        }
        return raw;
    }

    private final void updatePathEffect() {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, getFullBorderWidth()) : null);
        }
    }

    private final void updatePathEffect(int borderWidth) {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, borderWidth) : null);
        }
    }

    private final PathEffect getPathEffect(BorderStyle style, float borderWidth) {
        int i = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            float f = borderWidth * 3;
            return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return new DashPathEffect(new float[]{borderWidth, borderWidth, borderWidth, borderWidth}, 0.0f);
    }

    private final void getEllipseIntersectionWithLine(double ellipseBoundsLeft, double ellipseBoundsTop, double ellipseBoundsRight, double ellipseBoundsBottom, double lineStartX, double lineStartY, double lineEndX, double lineEndY, PointF result) {
        double d = 2;
        double d2 = (ellipseBoundsLeft + ellipseBoundsRight) / d;
        double d3 = (ellipseBoundsTop + ellipseBoundsBottom) / d;
        double d4 = lineStartX - d2;
        double d5 = lineStartY - d3;
        double dAbs = Math.abs(ellipseBoundsRight - ellipseBoundsLeft) / d;
        double dAbs2 = Math.abs(ellipseBoundsBottom - ellipseBoundsTop) / d;
        double d6 = ((lineEndY - d3) - d5) / ((lineEndX - d2) - d4);
        double d7 = d5 - (d4 * d6);
        double d8 = dAbs2 * dAbs2;
        double d9 = dAbs * dAbs;
        double d10 = d8 + (d9 * d6 * d6);
        double d11 = d * dAbs * dAbs * d7 * d6;
        double d12 = d * d10;
        double dSqrt = ((-d11) / d12) - Math.sqrt(((-(d9 * ((d7 * d7) - d8))) / d10) + Math.pow(d11 / d12, 2.0d));
        double d13 = (d6 * dSqrt) + d7;
        double d14 = dSqrt + d2;
        double d15 = d13 + d3;
        if (Double.isNaN(d14) || Double.isNaN(d15)) {
            return;
        }
        result.x = (float) d14;
        result.y = (float) d15;
    }

    /* JADX WARN: Code duplicated, block: B:154:0x0304  */
    private final void updatePath() {
        ComputedBorderRadius computedBorderRadiusResolve;
        CornerRadii cornerRadii;
        CornerRadii cornerRadii2;
        CornerRadii cornerRadii3;
        CornerRadii cornerRadii4;
        char c;
        char c2;
        Path path;
        int i;
        RectF rectF;
        RectF rectF2;
        RectF rectF3;
        RectF rectF4;
        Path path2;
        Path path3;
        CornerRadii bottomRight;
        CornerRadii bottomLeft;
        CornerRadii topRight;
        CornerRadii topLeft;
        BorderDrawable borderDrawable = this;
        if (borderDrawable.needUpdatePath) {
            borderDrawable.needUpdatePath = false;
            Path path4 = borderDrawable.innerClipPathForBorderRadius;
            if (path4 == null) {
                path4 = new Path();
            }
            borderDrawable.innerClipPathForBorderRadius = path4;
            Path path5 = borderDrawable.outerClipPathForBorderRadius;
            if (path5 == null) {
                path5 = new Path();
            }
            borderDrawable.outerClipPathForBorderRadius = path5;
            borderDrawable.pathForOutline = new Path();
            RectF rectF5 = borderDrawable.innerClipTempRectForBorderRadius;
            if (rectF5 == null) {
                rectF5 = new RectF();
            }
            borderDrawable.innerClipTempRectForBorderRadius = rectF5;
            RectF rectF6 = borderDrawable.outerClipTempRectForBorderRadius;
            if (rectF6 == null) {
                rectF6 = new RectF();
            }
            borderDrawable.outerClipTempRectForBorderRadius = rectF6;
            RectF rectF7 = borderDrawable.tempRectForCenterDrawPath;
            if (rectF7 == null) {
                rectF7 = new RectF();
            }
            borderDrawable.tempRectForCenterDrawPath = rectF7;
            Path path6 = borderDrawable.innerClipPathForBorderRadius;
            if (path6 != null) {
                path6.reset();
                Unit unit = Unit.INSTANCE;
            }
            Path path7 = borderDrawable.outerClipPathForBorderRadius;
            if (path7 != null) {
                path7.reset();
                Unit unit2 = Unit.INSTANCE;
            }
            RectF rectF8 = borderDrawable.innerClipTempRectForBorderRadius;
            if (rectF8 != null) {
                rectF8.set(borderDrawable.getBounds());
                Unit unit3 = Unit.INSTANCE;
            }
            RectF rectF9 = borderDrawable.outerClipTempRectForBorderRadius;
            if (rectF9 != null) {
                rectF9.set(borderDrawable.getBounds());
                Unit unit4 = Unit.INSTANCE;
            }
            RectF rectF10 = borderDrawable.tempRectForCenterDrawPath;
            if (rectF10 != null) {
                rectF10.set(borderDrawable.getBounds());
                Unit unit5 = Unit.INSTANCE;
            }
            RectF rectFComputeBorderInsets = borderDrawable.computeBorderInsets();
            if (Color.alpha(borderDrawable.computedBorderColors.getLeft()) != 0 || Color.alpha(borderDrawable.computedBorderColors.getTop()) != 0 || Color.alpha(borderDrawable.computedBorderColors.getRight()) != 0 || Color.alpha(borderDrawable.computedBorderColors.getBottom()) != 0) {
                RectF rectF11 = borderDrawable.innerClipTempRectForBorderRadius;
                if (rectF11 != null) {
                    rectF11.top = rectF11 != null ? rectF11.top + rectFComputeBorderInsets.top : 0.0f;
                    Unit unit6 = Unit.INSTANCE;
                }
                RectF rectF12 = borderDrawable.innerClipTempRectForBorderRadius;
                if (rectF12 != null) {
                    rectF12.bottom = rectF12 != null ? rectF12.bottom - rectFComputeBorderInsets.bottom : 0.0f;
                    Unit unit7 = Unit.INSTANCE;
                }
                RectF rectF13 = borderDrawable.innerClipTempRectForBorderRadius;
                if (rectF13 != null) {
                    rectF13.left = rectF13 != null ? rectF13.left + rectFComputeBorderInsets.left : 0.0f;
                    Unit unit8 = Unit.INSTANCE;
                }
                RectF rectF14 = borderDrawable.innerClipTempRectForBorderRadius;
                if (rectF14 != null) {
                    rectF14.right = rectF14 != null ? rectF14.right - rectFComputeBorderInsets.right : 0.0f;
                    Unit unit9 = Unit.INSTANCE;
                }
            }
            RectF rectF15 = borderDrawable.tempRectForCenterDrawPath;
            if (rectF15 != null) {
                rectF15.top = rectF15 != null ? rectF15.top + (rectFComputeBorderInsets.top * 0.5f) : 0.0f;
                Unit unit10 = Unit.INSTANCE;
            }
            RectF rectF16 = borderDrawable.tempRectForCenterDrawPath;
            if (rectF16 != null) {
                rectF16.bottom = rectF16 != null ? rectF16.bottom - (rectFComputeBorderInsets.bottom * 0.5f) : 0.0f;
                Unit unit11 = Unit.INSTANCE;
            }
            RectF rectF17 = borderDrawable.tempRectForCenterDrawPath;
            if (rectF17 != null) {
                rectF17.left = rectF17 != null ? rectF17.left + (rectFComputeBorderInsets.left * 0.5f) : 0.0f;
                Unit unit12 = Unit.INSTANCE;
            }
            RectF rectF18 = borderDrawable.tempRectForCenterDrawPath;
            if (rectF18 != null) {
                rectF18.right = rectF18 != null ? rectF18.right - (rectFComputeBorderInsets.right * 0.5f) : 0.0f;
                Unit unit13 = Unit.INSTANCE;
            }
            BorderRadiusStyle borderRadiusStyle = borderDrawable.borderRadius;
            if (borderRadiusStyle != null) {
                int layoutDirection = borderDrawable.getLayoutDirection();
                Context context = borderDrawable.context;
                RectF rectF19 = borderDrawable.outerClipTempRectForBorderRadius;
                float fPxToDp = rectF19 != null ? PixelUtil.INSTANCE.pxToDp(rectF19.width()) : 0.0f;
                RectF rectF20 = borderDrawable.outerClipTempRectForBorderRadius;
                computedBorderRadiusResolve = borderRadiusStyle.resolve(layoutDirection, context, fPxToDp, rectF20 != null ? PixelUtil.INSTANCE.pxToDp(rectF20.height()) : 0.0f);
            } else {
                computedBorderRadiusResolve = null;
            }
            borderDrawable.computedBorderRadius = computedBorderRadiusResolve;
            if (computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null || (cornerRadii = topLeft.toPixelFromDIP()) == null) {
                cornerRadii = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius = borderDrawable.computedBorderRadius;
            if (computedBorderRadius == null || (topRight = computedBorderRadius.getTopRight()) == null || (cornerRadii2 = topRight.toPixelFromDIP()) == null) {
                cornerRadii2 = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius2 = borderDrawable.computedBorderRadius;
            if (computedBorderRadius2 == null || (bottomLeft = computedBorderRadius2.getBottomLeft()) == null || (cornerRadii3 = bottomLeft.toPixelFromDIP()) == null) {
                cornerRadii3 = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius3 = borderDrawable.computedBorderRadius;
            if (computedBorderRadius3 == null || (bottomRight = computedBorderRadius3.getBottomRight()) == null || (cornerRadii4 = bottomRight.toPixelFromDIP()) == null) {
                cornerRadii4 = new CornerRadii(0.0f, 0.0f);
            }
            float innerBorderRadius = borderDrawable.getInnerBorderRadius(cornerRadii.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius2 = borderDrawable.getInnerBorderRadius(cornerRadii.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius3 = borderDrawable.getInnerBorderRadius(cornerRadii2.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius4 = borderDrawable.getInnerBorderRadius(cornerRadii2.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius5 = borderDrawable.getInnerBorderRadius(cornerRadii4.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius6 = borderDrawable.getInnerBorderRadius(cornerRadii4.getVertical(), rectFComputeBorderInsets.bottom);
            float innerBorderRadius7 = borderDrawable.getInnerBorderRadius(cornerRadii3.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius8 = borderDrawable.getInnerBorderRadius(cornerRadii3.getVertical(), rectFComputeBorderInsets.bottom);
            RectF rectF21 = borderDrawable.innerClipTempRectForBorderRadius;
            if (rectF21 == null || (path3 = borderDrawable.innerClipPathForBorderRadius) == null) {
                c = 7;
            } else {
                c = 7;
                path3.addRoundRect(rectF21, new float[]{innerBorderRadius, innerBorderRadius2, innerBorderRadius3, innerBorderRadius4, innerBorderRadius5, innerBorderRadius6, innerBorderRadius7, innerBorderRadius8}, Path.Direction.CW);
                Unit unit14 = Unit.INSTANCE;
            }
            RectF rectF22 = borderDrawable.outerClipTempRectForBorderRadius;
            if (rectF22 == null || (path2 = borderDrawable.outerClipPathForBorderRadius) == null) {
                c2 = 5;
            } else {
                float horizontal = cornerRadii.getHorizontal();
                float vertical = cornerRadii.getVertical();
                float horizontal2 = cornerRadii2.getHorizontal();
                float vertical2 = cornerRadii2.getVertical();
                float horizontal3 = cornerRadii4.getHorizontal();
                float vertical3 = cornerRadii4.getVertical();
                float horizontal4 = cornerRadii3.getHorizontal();
                float vertical4 = cornerRadii3.getVertical();
                c2 = 5;
                float[] fArr = new float[8];
                fArr[0] = horizontal;
                fArr[1] = vertical;
                fArr[2] = horizontal2;
                fArr[3] = vertical2;
                fArr[4] = horizontal3;
                fArr[5] = vertical3;
                fArr[6] = horizontal4;
                fArr[c] = vertical4;
                path2.addRoundRect(rectF22, fArr, Path.Direction.CW);
                Unit unit15 = Unit.INSTANCE;
            }
            Spacing spacing = borderDrawable.borderWidth;
            float f = spacing != null ? spacing.get(8) / 2.0f : 0.0f;
            Path path8 = borderDrawable.pathForOutline;
            if (path8 != null) {
                RectF rectF23 = new RectF(borderDrawable.getBounds());
                float horizontal5 = cornerRadii.getHorizontal() + f;
                float vertical5 = cornerRadii.getVertical() + f;
                float horizontal6 = cornerRadii2.getHorizontal() + f;
                float vertical6 = cornerRadii2.getVertical() + f;
                float horizontal7 = cornerRadii4.getHorizontal() + f;
                float vertical7 = cornerRadii4.getVertical() + f;
                float horizontal8 = cornerRadii3.getHorizontal() + f;
                float vertical8 = cornerRadii3.getVertical() + f;
                float[] fArr2 = new float[8];
                fArr2[0] = horizontal5;
                fArr2[1] = vertical5;
                fArr2[2] = horizontal6;
                fArr2[3] = vertical6;
                fArr2[4] = horizontal7;
                fArr2[c2] = vertical7;
                fArr2[r13] = horizontal8;
                fArr2[c] = vertical8;
                path8.addRoundRect(rectF23, fArr2, Path.Direction.CW);
                Unit unit16 = Unit.INSTANCE;
            }
            ComputedBorderRadius computedBorderRadius4 = borderDrawable.computedBorderRadius;
            if (computedBorderRadius4 == null || !computedBorderRadius4.isUniform()) {
                Path path9 = borderDrawable.centerDrawPath;
                if (path9 == null) {
                    path9 = new Path();
                }
                borderDrawable.centerDrawPath = path9;
                if (path9 != null) {
                    path9.reset();
                    Unit unit17 = Unit.INSTANCE;
                }
                RectF rectF24 = borderDrawable.tempRectForCenterDrawPath;
                if (rectF24 == null || (path = borderDrawable.centerDrawPath) == null) {
                    i = 2;
                } else {
                    float horizontal9 = cornerRadii.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f);
                    float vertical9 = cornerRadii.getVertical() - (rectFComputeBorderInsets.top * 0.5f);
                    float horizontal10 = cornerRadii2.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f);
                    float vertical10 = cornerRadii2.getVertical() - (rectFComputeBorderInsets.top * 0.5f);
                    float horizontal11 = cornerRadii4.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f);
                    float vertical11 = cornerRadii4.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f);
                    i = 2;
                    float horizontal12 = cornerRadii3.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f);
                    float vertical12 = cornerRadii3.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f);
                    float[] fArr3 = new float[8];
                    fArr3[0] = horizontal9;
                    fArr3[1] = vertical9;
                    fArr3[2] = horizontal10;
                    fArr3[3] = vertical10;
                    fArr3[4] = horizontal11;
                    fArr3[c2] = vertical11;
                    fArr3[r13] = horizontal12;
                    fArr3[c] = vertical12;
                    path.addRoundRect(rectF24, fArr3, Path.Direction.CW);
                    Unit unit18 = Unit.INSTANCE;
                }
            } else {
                i = 2;
            }
            RectF rectF25 = borderDrawable.innerClipTempRectForBorderRadius;
            RectF rectF26 = borderDrawable.outerClipTempRectForBorderRadius;
            if (rectF25 == null || rectF26 == null) {
                return;
            }
            PointF pointF = borderDrawable.innerTopLeftCorner;
            if (pointF == null) {
                pointF = new PointF();
            }
            borderDrawable.innerTopLeftCorner = pointF;
            if (pointF != null) {
                pointF.x = rectF25.left;
                Unit unit19 = Unit.INSTANCE;
            }
            PointF pointF2 = borderDrawable.innerTopLeftCorner;
            if (pointF2 != null) {
                pointF2.y = rectF25.top;
                Unit unit20 = Unit.INSTANCE;
            }
            PointF pointF3 = borderDrawable.innerTopLeftCorner;
            if (pointF3 != null) {
                float f2 = i;
                rectF2 = rectF26;
                rectF = rectF25;
                borderDrawable = this;
                borderDrawable.getEllipseIntersectionWithLine(rectF25.left, rectF25.top, rectF25.left + (innerBorderRadius * f2), rectF25.top + (f2 * innerBorderRadius2), rectF26.left, rectF26.top, rectF25.left, rectF25.top, pointF3);
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            } else {
                rectF = rectF25;
                rectF2 = rectF26;
            }
            PointF pointF4 = borderDrawable.innerBottomLeftCorner;
            if (pointF4 == null) {
                pointF4 = new PointF();
            }
            borderDrawable.innerBottomLeftCorner = pointF4;
            RectF rectF27 = rectF;
            if (pointF4 != null) {
                pointF4.x = rectF27.left;
                Unit unit23 = Unit.INSTANCE;
            }
            PointF pointF5 = borderDrawable.innerBottomLeftCorner;
            if (pointF5 != null) {
                pointF5.y = rectF27.bottom;
                Unit unit24 = Unit.INSTANCE;
            }
            PointF pointF6 = borderDrawable.innerBottomLeftCorner;
            if (pointF6 != null) {
                float f3 = 2;
                RectF rectF28 = rectF2;
                rectF3 = rectF28;
                borderDrawable = this;
                borderDrawable.getEllipseIntersectionWithLine(rectF27.left, rectF27.bottom - (innerBorderRadius8 * f3), rectF27.left + (f3 * innerBorderRadius7), rectF27.bottom, rectF28.left, rectF28.bottom, rectF27.left, rectF27.bottom, pointF6);
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            } else {
                rectF3 = rectF2;
            }
            PointF pointF7 = borderDrawable.innerTopRightCorner;
            if (pointF7 == null) {
                pointF7 = new PointF();
            }
            borderDrawable.innerTopRightCorner = pointF7;
            if (pointF7 != null) {
                pointF7.x = rectF27.right;
                Unit unit27 = Unit.INSTANCE;
            }
            PointF pointF8 = borderDrawable.innerTopRightCorner;
            if (pointF8 != null) {
                pointF8.y = rectF27.top;
                Unit unit28 = Unit.INSTANCE;
            }
            PointF pointF9 = borderDrawable.innerTopRightCorner;
            if (pointF9 != null) {
                float f4 = 2;
                RectF rectF29 = rectF3;
                rectF4 = rectF29;
                borderDrawable = this;
                borderDrawable.getEllipseIntersectionWithLine(rectF27.right - (innerBorderRadius3 * f4), rectF27.top, rectF27.right, rectF27.top + (f4 * innerBorderRadius4), rectF29.right, rectF29.top, rectF27.right, rectF27.top, pointF9);
                Unit unit29 = Unit.INSTANCE;
                Unit unit30 = Unit.INSTANCE;
            } else {
                rectF4 = rectF3;
            }
            PointF pointF10 = borderDrawable.innerBottomRightCorner;
            if (pointF10 == null) {
                pointF10 = new PointF();
            }
            borderDrawable.innerBottomRightCorner = pointF10;
            if (pointF10 != null) {
                pointF10.x = rectF27.right;
                Unit unit31 = Unit.INSTANCE;
            }
            PointF pointF11 = borderDrawable.innerBottomRightCorner;
            if (pointF11 != null) {
                pointF11.y = rectF27.bottom;
                Unit unit32 = Unit.INSTANCE;
            }
            PointF pointF12 = borderDrawable.innerBottomRightCorner;
            if (pointF12 != null) {
                float f5 = 2;
                RectF rectF30 = rectF4;
                getEllipseIntersectionWithLine(rectF27.right - (innerBorderRadius5 * f5), rectF27.bottom - (f5 * innerBorderRadius6), rectF27.right, rectF27.bottom, rectF30.right, rectF30.bottom, rectF27.right, rectF27.bottom, pointF12);
                Unit unit33 = Unit.INSTANCE;
                Unit unit34 = Unit.INSTANCE;
            }
        }
    }
}
