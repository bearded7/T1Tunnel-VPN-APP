package com.horcrux.svg;

import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.text.ReactFontManager;
import java.text.Bidi;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class TSpanView extends TextView {
    private static final String FONTS = "fonts/";
    private static final String OTF = ".otf";
    private static final String TTF = ".ttf";
    static final String additionalLigatures = "'hlig', 'cala', ";
    static final String defaultFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', ";
    static final String disableDiscretionaryLigatures = "'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ";
    static final String fontWeightTag = "'wght' ";
    private static final double radToDeg = 57.29577951308232d;
    static final String requiredFontFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk',";
    private static final double tau = 6.283185307179586d;
    private final AssetManager assets;
    private final ArrayList<String> emoji;
    private final ArrayList<Matrix> emojiTransforms;
    private Path mCachedPath;

    @Nullable
    String mContent;
    private TextPathView textPath;

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
        this.emoji = new ArrayList<>();
        this.emojiTransforms = new ArrayList<>();
        this.assets = this.mContext.getResources().getAssets();
    }

    public void setContent(@Nullable String str) {
        this.mContent = str;
        invalidate();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView, android.view.View
    public void invalidate() {
        this.mCachedPath = null;
        super.invalidate();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.VirtualView
    void clearCache() {
        this.mCachedPath = null;
        super.clearCache();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent != null) {
            if (this.mInlineSize != null && this.mInlineSize.value != 0.0d) {
                if (setupFillPaint(paint, this.fillOpacity * f)) {
                    drawWrappedText(canvas, paint);
                }
                if (setupStrokePaint(paint, f * this.strokeOpacity)) {
                    drawWrappedText(canvas, paint);
                    return;
                }
                return;
            }
            int size = this.emoji.size();
            if (size > 0) {
                applyTextPropertiesToPaint(paint, getTextRootGlyphContext().getFont());
                for (int i = 0; i < size; i++) {
                    String str = this.emoji.get(i);
                    Matrix matrix = this.emojiTransforms.get(i);
                    canvas.save();
                    canvas.concat(matrix);
                    canvas.drawText(str, 0.0f, 0.0f, paint);
                    canvas.restore();
                }
            }
            drawPath(canvas, paint, f);
            return;
        }
        clip(canvas, paint);
        drawGroup(canvas, paint, f);
    }

    private void drawWrappedText(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        pushGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        TextPaint textPaint = new TextPaint(paint);
        applyTextPropertiesToPaint(textPaint, font);
        applySpacingAndFeatures(textPaint, font);
        double fontSize = textRootGlyphContext.getFontSize();
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[font.textAnchor.ordinal()];
        if (i == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i != 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout staticLayout = getStaticLayout(textPaint, alignment, true, new SpannableString(this.mContent), (int) PropHelper.fromRelative(this.mInlineSize, canvas.getWidth(), 0.0d, this.mScale, fontSize));
        int lineAscent = staticLayout.getLineAscent(0);
        float fNextX = (float) textRootGlyphContext.nextX(0.0d);
        float fNextY = (float) (textRootGlyphContext.nextY() + ((double) lineAscent));
        popGlyphContext();
        canvas.save();
        canvas.translate(fNextX, fNextY);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private StaticLayout getStaticLayout(TextPaint textPaint, Layout.Alignment alignment, boolean z, SpannableString spannableString, int i) {
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(1).setHyphenationFrequency(1).build();
    }

    public static String visualToLogical(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Bidi bidi = new Bidi(str, -2);
        if (bidi.isLeftToRight()) {
            return str;
        }
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i = 0; i < runCount; i++) {
            bArr[i] = (byte) bidi.getRunLevel(i);
            numArr[i] = Integer.valueOf(i);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < runCount; i2++) {
            int iIntValue = numArr[i2].intValue();
            int runStart = bidi.getRunStart(iIntValue);
            int runLimit = bidi.getRunLimit(iIntValue);
            if ((bArr[iIntValue] & 1) != 0) {
                while (true) {
                    runLimit--;
                    if (runLimit >= runStart) {
                        sb.append(str.charAt(runLimit));
                    }
                }
            } else {
                sb.append((CharSequence) str, runStart, runLimit);
            }
        }
        return sb.toString();
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mCachedPath;
        if (path != null) {
            return path;
        }
        if (this.mContent == null) {
            Path groupPath = getGroupPath(canvas, paint);
            this.mCachedPath = groupPath;
            return groupPath;
        }
        setupTextPath();
        pushGlyphContext();
        this.mCachedPath = getLinePath(visualToLogical(this.mContent), paint, canvas);
        popGlyphContext();
        return this.mCachedPath;
    }

    @Override // com.horcrux.svg.TextView
    double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        String str = this.mContent;
        double subtreeTextChunksTotalAdvance = 0.0d;
        if (str == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    subtreeTextChunksTotalAdvance += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
                }
            }
            this.cachedAdvance = subtreeTextChunksTotalAdvance;
            return subtreeTextChunksTotalAdvance;
        }
        if (str.length() == 0) {
            this.cachedAdvance = 0.0d;
            return 0.0d;
        }
        FontData font = getTextRootGlyphContext().getFont();
        applyTextPropertiesToPaint(paint, font);
        applySpacingAndFeatures(paint, font);
        this.cachedAdvance = paint.measureText(str);
        return this.cachedAdvance;
    }

    private void applySpacingAndFeatures(Paint paint, FontData fontData) {
        double d = fontData.letterSpacing;
        paint.setLetterSpacing((float) (d / (fontData.fontSize * ((double) this.mScale))));
        if (d == 0.0d && fontData.fontVariantLigatures == TextProperties.FontVariantLigatures.normal) {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + fontData.fontFeatureSettings);
        } else {
            paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + fontData.fontFeatureSettings);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            paint.setFontVariationSettings(fontWeightTag + fontData.absoluteFontWeight + fontData.fontVariationSettings);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0280  */
    /* JADX WARN: Code duplicated, block: B:102:0x0297  */
    /* JADX WARN: Code duplicated, block: B:103:0x0299  */
    /* JADX WARN: Code duplicated, block: B:109:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:111:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:112:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:113:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:119:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:121:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:122:0x0307  */
    /* JADX WARN: Code duplicated, block: B:125:0x0324  */
    /* JADX WARN: Code duplicated, block: B:127:0x032e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0335  */
    /* JADX WARN: Code duplicated, block: B:131:0x0341  */
    /* JADX WARN: Code duplicated, block: B:137:0x0373  */
    /* JADX WARN: Code duplicated, block: B:140:0x0380  */
    /* JADX WARN: Code duplicated, block: B:141:0x0382  */
    /* JADX WARN: Code duplicated, block: B:143:0x0385  */
    /* JADX WARN: Code duplicated, block: B:144:0x0388  */
    /* JADX WARN: Code duplicated, block: B:147:0x0390  */
    /* JADX WARN: Code duplicated, block: B:148:0x0395  */
    /* JADX WARN: Code duplicated, block: B:151:0x03b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:183:0x0529  */
    /* JADX WARN: Code duplicated, block: B:192:0x0366 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0085  */
    /* JADX WARN: Code duplicated, block: B:26:0x009a  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:35:0x0102  */
    /* JADX WARN: Code duplicated, block: B:38:0x010e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0111  */
    /* JADX WARN: Code duplicated, block: B:42:0x013b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0141  */
    /* JADX WARN: Code duplicated, block: B:45:0x0143  */
    /* JADX WARN: Code duplicated, block: B:47:0x0154  */
    /* JADX WARN: Code duplicated, block: B:48:0x015d  */
    /* JADX WARN: Code duplicated, block: B:4:0x001b  */
    /* JADX WARN: Code duplicated, block: B:52:0x017f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0199  */
    /* JADX WARN: Code duplicated, block: B:56:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:62:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:65:0x0200  */
    /* JADX WARN: Code duplicated, block: B:66:0x0202  */
    /* JADX WARN: Code duplicated, block: B:67:0x0205  */
    /* JADX WARN: Code duplicated, block: B:68:0x0208  */
    /* JADX WARN: Code duplicated, block: B:69:0x020e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0212  */
    /* JADX WARN: Code duplicated, block: B:72:0x0215 A[PHI: r0
  0x0215: PHI (r0v45 double) = (r0v6 double), (r0v47 double), (r0v48 double), (r0v49 double), (r0v50 double), (r0v51 double) binds: [B:63:0x01fc, B:71:0x0212, B:70:0x0210, B:67:0x0205, B:66:0x0202, B:65:0x0200] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x0217  */
    /* JADX WARN: Code duplicated, block: B:74:0x022b  */
    /* JADX WARN: Code duplicated, block: B:75:0x022e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0233  */
    /* JADX WARN: Code duplicated, block: B:86:0x0254  */
    /* JADX WARN: Code duplicated, block: B:89:0x025d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0260  */
    /* JADX WARN: Code duplicated, block: B:93:0x0269  */
    /* JADX WARN: Code duplicated, block: B:94:0x026c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0275  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private Path getLinePath(String str, Paint paint, Canvas canvas) {
        PathMeasure pathMeasure;
        boolean z;
        double length;
        GlyphContext glyphContext;
        boolean z2;
        ReadableMap readableMap;
        float[] fArr;
        double d;
        TextProperties.TextAnchor textAnchor;
        double subtreeTextChunksTotalAdvance;
        double textAnchorOffset;
        double fontSize;
        byte b;
        TSpanView tSpanView;
        double d2;
        boolean z3;
        GlyphContext glyphContext2;
        double d3;
        boolean z4;
        GlyphPathBag glyphPathBag;
        float[] fArr2;
        boolean[] zArr;
        double d4;
        double d5;
        int i;
        boolean z5;
        double d6;
        double d7;
        double d8;
        double d9;
        double dFromRelative;
        double d10;
        double d11;
        String baselineShift;
        TextProperties.AlignmentBaseline alignmentBaseline;
        byte b2;
        Matrix matrix;
        float[] fArr3;
        float[] fArr4;
        int i2;
        char c;
        String strValueOf;
        boolean z6;
        int i3;
        boolean z7;
        float f;
        int i4;
        int i5;
        double dMeasureText;
        boolean z8;
        double d12;
        double d13;
        double d14;
        Canvas canvas2;
        int i6;
        GlyphPathBag glyphPathBag2;
        Matrix matrix2;
        Paint paint2;
        Path path;
        float f2;
        char c2;
        double d15;
        String str2;
        Path orCreateAndCache;
        int i7;
        int i8;
        int i9;
        ReadableMap map;
        ReadableMap map2;
        int i10;
        ReadableMap map3;
        ReadableMap map4;
        double d16;
        double dFromRelative2;
        boolean z9;
        int i11;
        double absoluteStartOffset;
        double d17;
        double d18;
        double d19;
        Paint paint3 = paint;
        Canvas canvas3 = canvas;
        int length2 = str.length();
        Path path2 = new Path();
        this.emoji.clear();
        this.emojiTransforms.clear();
        if (length2 != 0) {
            boolean z10 = this.textPath != null;
            if (z10) {
                pathMeasure = new PathMeasure(this.textPath.getTextPath(canvas3, paint3), false);
                length = pathMeasure.getLength();
                boolean zIsClosed = pathMeasure.isClosed();
                if (length != 0.0d) {
                    z = zIsClosed;
                }
            } else {
                pathMeasure = null;
                z = false;
                length = 0.0d;
            }
            PathMeasure pathMeasure2 = pathMeasure;
            GlyphContext textRootGlyphContext = getTextRootGlyphContext();
            FontData font = textRootGlyphContext.getFont();
            applyTextPropertiesToPaint(paint3, font);
            GlyphPathBag glyphPathBag3 = new GlyphPathBag(paint3);
            double d20 = 0.0d;
            boolean[] zArr2 = new boolean[length2];
            char[] charArray = str.toCharArray();
            double d21 = font.kerning;
            double d22 = font.wordSpacing;
            double d23 = font.letterSpacing;
            boolean z11 = font.manualKerning;
            if (d23 == 0.0d) {
                glyphContext = textRootGlyphContext;
                z2 = font.fontVariantLigatures == TextProperties.FontVariantLigatures.normal;
                if (z2) {
                    paint3.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + font.fontFeatureSettings);
                } else {
                    paint3.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + font.fontFeatureSettings);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    paint3.setFontVariationSettings(fontWeightTag + font.absoluteFontWeight + font.fontVariationSettings);
                }
                readableMap = font.fontData;
                fArr = new float[length2];
                d = length;
                paint3.getTextWidths(str, fArr);
                textAnchor = font.textAnchor;
                subtreeTextChunksTotalAdvance = getTextAnchorRoot().getSubtreeTextChunksTotalAdvance(paint3);
                textAnchorOffset = getTextAnchorOffset(textAnchor, subtreeTextChunksTotalAdvance);
                fontSize = glyphContext.getFontSize();
                b = -1;
                if (z10) {
                    if (this.textPath.getMidLine() == TextProperties.TextPathMidLine.sharp) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (this.textPath.getSide() == TextProperties.TextPathSide.right) {
                        i11 = -1;
                    } else {
                        i11 = 1;
                    }
                    d2 = subtreeTextChunksTotalAdvance;
                    z3 = z11;
                    glyphContext2 = glyphContext;
                    fArr2 = fArr;
                    z4 = z10;
                    zArr = zArr2;
                    glyphPathBag = glyphPathBag3;
                    absoluteStartOffset = getAbsoluteStartOffset(this.textPath.getStartOffset(), d, fontSize);
                    tSpanView = this;
                    d4 = d;
                    d17 = textAnchorOffset + absoluteStartOffset;
                    d3 = fontSize;
                    if (z) {
                        d18 = d4 / 2.0d;
                        if (textAnchor == TextProperties.TextAnchor.middle) {
                            d19 = -d18;
                        } else {
                            d19 = 0.0d;
                        }
                        double d24 = absoluteStartOffset + d19;
                        d5 = d17;
                        d20 = d24;
                        z5 = z9;
                        d6 = d24 + d4;
                        i = i11;
                    } else {
                        d5 = d17;
                        z5 = z9;
                        i = i11;
                    }
                    d7 = 1.0d;
                    if (tSpanView.mTextLength != null) {
                        dFromRelative2 = PropHelper.fromRelative(tSpanView.mTextLength, canvas3.getWidth(), 0.0d, tSpanView.mScale, d3);
                        if (dFromRelative2 >= 0.0d) {
                            throw new IllegalArgumentException("Negative textLength value");
                        }
                        if (AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[tSpanView.mLengthAdjust.ordinal()] != 2) {
                            d23 += (dFromRelative2 - d2) / ((double) (length2 - 1));
                        } else {
                            d7 = dFromRelative2 / d2;
                        }
                    }
                    double d25 = i;
                    boolean z12 = z5;
                    Paint.FontMetrics fontMetrics = paint3.getFontMetrics();
                    int i12 = i;
                    double d26 = d7 * d25;
                    d8 = fontMetrics.descent;
                    double d27 = d4;
                    d9 = ((double) fontMetrics.leading) + d8;
                    dFromRelative = (-fontMetrics.ascent) + fontMetrics.leading;
                    d10 = -fontMetrics.top;
                    d11 = d10 + d9;
                    baselineShift = tSpanView.getBaselineShift();
                    alignmentBaseline = tSpanView.getAlignmentBaseline();
                    if (alignmentBaseline != null) {
                        switch (alignmentBaseline) {
                            case 2:
                            case 3:
                            case 4:
                            case 6:
                                b2 = 0;
                                dFromRelative = -d8;
                                break;
                            case 5:
                            default:
                                b2 = 0;
                                dFromRelative = 0.0d;
                                break;
                            case 7:
                                Rect rect = new Rect();
                                b2 = 0;
                                paint3.getTextBounds("x", 0, 1, rect);
                                dFromRelative = ((double) rect.height()) / 2.0d;
                                break;
                            case 8:
                                dFromRelative = (dFromRelative - d8) / 2.0d;
                                b2 = 0;
                                break;
                            case 9:
                                d16 = 0.5d;
                                dFromRelative *= d16;
                                b2 = 0;
                                break;
                            case 10:
                                d16 = 0.8d;
                                dFromRelative *= d16;
                                b2 = 0;
                                break;
                            case 11:
                            case 12:
                            case 13:
                                b2 = 0;
                                break;
                            case 14:
                                dFromRelative = d9;
                                b2 = 0;
                                break;
                            case 15:
                                dFromRelative = d11 / 2.0d;
                                b2 = 0;
                                break;
                            case 16:
                                dFromRelative = d10;
                                b2 = 0;
                                break;
                        }
                    } else {
                        b2 = 0;
                        dFromRelative = 0.0d;
                    }
                    if (baselineShift != null && !baselineShift.isEmpty() && (i8 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[alignmentBaseline.ordinal()]) != 14 && i8 != 16) {
                        baselineShift.hashCode();
                        switch (baselineShift.hashCode()) {
                            case -1720785339:
                                if (baselineShift.equals("baseline")) {
                                    b = b2;
                                }
                                break;
                            case 114240:
                                if (baselineShift.equals("sub")) {
                                    b = 1;
                                }
                                break;
                            case 109801339:
                                if (baselineShift.equals("super")) {
                                    b = 2;
                                }
                                break;
                        }
                        switch (b) {
                            case 0:
                                break;
                            case 1:
                                if (readableMap != null && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                                    i9 = readableMap.getInt("unitsPerEm");
                                    map = readableMap.getMap("tables");
                                    if (map.hasKey("os2")) {
                                        dFromRelative = dFromRelative;
                                    } else {
                                        map2 = map.getMap("os2");
                                        if (map2.hasKey("ySubscriptYOffset")) {
                                            dFromRelative = dFromRelative;
                                        } else {
                                            dFromRelative += ((((double) tSpanView.mScale) * d3) * map2.getDouble("ySubscriptYOffset")) / ((double) i9);
                                        }
                                    }
                                }
                                break;
                            case 2:
                                if (readableMap != null && readableMap.hasKey("tables") && readableMap.hasKey("unitsPerEm")) {
                                    i10 = readableMap.getInt("unitsPerEm");
                                    map3 = readableMap.getMap("tables");
                                    if (map3.hasKey("os2")) {
                                        map4 = map3.getMap("os2");
                                        if (map4.hasKey("ySuperscriptYOffset")) {
                                            dFromRelative -= ((((double) tSpanView.mScale) * d3) * map4.getDouble("ySuperscriptYOffset")) / ((double) i10);
                                        }
                                    }
                                }
                                break;
                            default:
                                dFromRelative -= PropHelper.fromRelative(baselineShift, ((double) tSpanView.mScale) * d3, tSpanView.mScale, d3);
                                break;
                        }
                    }
                    double d28 = dFromRelative;
                    Matrix matrix3 = new Matrix();
                    matrix = new Matrix();
                    Matrix matrix4 = new Matrix();
                    fArr3 = new float[9];
                    fArr4 = new float[9];
                    i2 = 0;
                    while (i2 < length2) {
                        c = charArray[i2];
                        strValueOf = String.valueOf(c);
                        z6 = zArr[i2];
                        if (z6) {
                            strValueOf = "";
                            z7 = false;
                            f = 0.0f;
                        } else {
                            i3 = i2;
                            z7 = false;
                            f = 0.0f;
                            while (true) {
                                i4 = i3 + 1;
                                if (i4 >= length2 && fArr2[i4] <= 0.0f) {
                                    strValueOf = strValueOf + charArray[i4];
                                    zArr[i4] = true;
                                    i3 = i4;
                                    z7 = true;
                                }
                            }
                        }
                        i5 = i2;
                        dMeasureText = ((double) paint3.measureText(strValueOf)) * d7;
                        if (!z3) {
                            d21 = (((double) fArr2[i5]) * d7) - dMeasureText;
                        }
                        if (c == ' ') {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            d12 = d22;
                        } else {
                            d12 = 0.0d;
                        }
                        d13 = dMeasureText + d12 + d23;
                        if (z6) {
                            d14 = 0.0d;
                        } else {
                            d14 = d21 + d13;
                        }
                        double dNextX = glyphContext2.nextX(d14);
                        double dNextY = glyphContext2.nextY();
                        double dNextDeltaX = glyphContext2.nextDeltaX();
                        double dNextDeltaY = glyphContext2.nextDeltaY();
                        String str3 = strValueOf;
                        double dNextRotation = glyphContext2.nextRotation();
                        if (!z6 || z8) {
                            fArr4 = fArr4;
                            canvas2 = canvas3;
                            i6 = length2;
                            glyphContext2 = glyphContext2;
                            glyphPathBag2 = glyphPathBag;
                            matrix2 = matrix;
                            this = this;
                            paint2 = paint;
                            fArr3 = fArr3;
                            path = path2;
                        } else {
                            double d29 = dMeasureText * d25;
                            i6 = length2;
                            Path path3 = path2;
                            double d30 = (d5 + ((dNextX + dNextDeltaX) * d25)) - (d13 * d25);
                            if (z4) {
                                double d31 = d30 + d29;
                                double d32 = d29 / 2.0d;
                                double d33 = d30 + d32;
                                if (d33 <= d6 && d33 >= d20) {
                                    if (z12) {
                                        pathMeasure2.getMatrix((float) d33, matrix, 3);
                                        glyphPathBag = glyphPathBag;
                                        matrix2 = matrix;
                                        d15 = d27;
                                        c2 = 2;
                                    } else {
                                        if (d30 < 0.0d) {
                                            float f3 = f;
                                            pathMeasure2.getMatrix(f3, matrix3, 3);
                                            matrix3.preTranslate((float) d30, f3);
                                            i7 = 1;
                                        } else {
                                            i7 = 1;
                                            pathMeasure2.getMatrix((float) d30, matrix3, 1);
                                        }
                                        pathMeasure2.getMatrix((float) d33, matrix, i7);
                                        if (d31 > d27) {
                                            d15 = d27;
                                            pathMeasure2.getMatrix((float) d15, matrix4, 3);
                                            matrix4.preTranslate((float) (d31 - d15), 0.0f);
                                        } else {
                                            d15 = d27;
                                            pathMeasure2.getMatrix((float) d31, matrix4, i7);
                                        }
                                        matrix3.getValues(fArr3);
                                        matrix4.getValues(fArr4);
                                        c2 = 2;
                                        matrix2 = matrix;
                                        matrix2.preRotate((float) (Math.atan2(((double) fArr4[5]) - ((double) fArr3[5]), ((double) fArr4[2]) - ((double) fArr3[2])) * radToDeg * d25));
                                    }
                                    matrix2.preTranslate((float) (-d32), (float) (dNextDeltaY + d28));
                                    d26 = d26;
                                    i12 = i12;
                                    matrix2.preScale((float) d26, i12);
                                    f2 = 0.0f;
                                    matrix2.postTranslate(0.0f, (float) dNextY);
                                } else {
                                    this = this;
                                    canvas2 = canvas;
                                    fArr4 = fArr4;
                                    fArr3 = fArr3;
                                    glyphContext2 = glyphContext2;
                                    glyphPathBag2 = glyphPathBag;
                                    matrix2 = matrix;
                                    path = path3;
                                    paint2 = paint;
                                }
                            } else {
                                fArr4 = fArr4;
                                glyphPathBag = glyphPathBag;
                                matrix2 = matrix;
                                f2 = f;
                                d26 = d26;
                                c2 = 2;
                                d15 = d27;
                                fArr3 = fArr3;
                                i12 = i12;
                                matrix2.setTranslate((float) d30, (float) (dNextY + dNextDeltaY + d28));
                            }
                            matrix2.preRotate((float) dNextRotation);
                            if (z7) {
                                orCreateAndCache = new Path();
                                d27 = d15;
                                paint2 = paint;
                                str2 = str3;
                                paint2.getTextPath(str2, 0, str3.length(), 0.0f, 0.0f, orCreateAndCache);
                                glyphPathBag2 = glyphPathBag;
                            } else {
                                paint2 = paint;
                                str2 = str3;
                                d27 = d15;
                                glyphPathBag2 = glyphPathBag;
                                orCreateAndCache = glyphPathBag2.getOrCreateAndCache(c, str2);
                            }
                            RectF rectF = new RectF();
                            orCreateAndCache.computeBounds(rectF, true);
                            if (rectF.width() == f2) {
                                canvas.save();
                                canvas2 = canvas;
                                canvas2.concat(matrix2);
                                this.emoji.add(str2);
                                this.emojiTransforms.add(new Matrix(matrix2));
                                canvas2.drawText(str2, f2, f2, paint2);
                                canvas2.restore();
                                path = path3;
                            } else {
                                canvas2 = canvas;
                                orCreateAndCache.transform(matrix2);
                                path = path3;
                                path.addPath(orCreateAndCache);
                            }
                        }
                        paint3 = paint2;
                        path2 = path;
                        glyphPathBag = glyphPathBag2;
                        tSpanView = this;
                        fArr3 = fArr3;
                        matrix = matrix2;
                        length2 = i6;
                        glyphContext2 = glyphContext2;
                        fArr4 = fArr4;
                        canvas3 = canvas2;
                        i2 = i5 + 1;
                    }
                } else {
                    tSpanView = this;
                    d2 = subtreeTextChunksTotalAdvance;
                    z3 = z11;
                    glyphContext2 = glyphContext;
                    d3 = fontSize;
                    z4 = z10;
                    glyphPathBag = glyphPathBag3;
                    fArr2 = fArr;
                    zArr = zArr2;
                    d4 = d;
                    d5 = textAnchorOffset;
                    i = 1;
                    z5 = false;
                }
                d6 = d4;
                d7 = 1.0d;
                if (tSpanView.mTextLength != null) {
                    dFromRelative2 = PropHelper.fromRelative(tSpanView.mTextLength, canvas3.getWidth(), 0.0d, tSpanView.mScale, d3);
                    if (dFromRelative2 >= 0.0d) {
                        throw new IllegalArgumentException("Negative textLength value");
                    }
                    if (AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[tSpanView.mLengthAdjust.ordinal()] != 2) {
                        d23 += (dFromRelative2 - d2) / ((double) (length2 - 1));
                    } else {
                        d7 = dFromRelative2 / d2;
                    }
                }
                double d210 = i;
                boolean z13 = z5;
                Paint.FontMetrics fontMetrics2 = paint3.getFontMetrics();
                int i13 = i;
                double d211 = d7 * d210;
                d8 = fontMetrics2.descent;
                double d212 = d4;
                d9 = ((double) fontMetrics2.leading) + d8;
                dFromRelative = (-fontMetrics2.ascent) + fontMetrics2.leading;
                d10 = -fontMetrics2.top;
                d11 = d10 + d9;
                baselineShift = tSpanView.getBaselineShift();
                alignmentBaseline = tSpanView.getAlignmentBaseline();
                if (alignmentBaseline != null) {
                    switch (alignmentBaseline) {
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                            b2 = 0;
                            dFromRelative = -d8;
                            break;
                        case 5:
                        default:
                            b2 = 0;
                            dFromRelative = 0.0d;
                            break;
                        case 7:
                            Rect rect2 = new Rect();
                            b2 = 0;
                            paint3.getTextBounds("x", 0, 1, rect2);
                            dFromRelative = ((double) rect2.height()) / 2.0d;
                            break;
                        case 8:
                            dFromRelative = (dFromRelative - d8) / 2.0d;
                            b2 = 0;
                            break;
                        case 9:
                            d16 = 0.5d;
                            dFromRelative *= d16;
                            b2 = 0;
                            break;
                        case 10:
                            d16 = 0.8d;
                            dFromRelative *= d16;
                            b2 = 0;
                            break;
                        case 11:
                        case 12:
                        case 13:
                            b2 = 0;
                            break;
                        case 14:
                            dFromRelative = d9;
                            b2 = 0;
                            break;
                        case 15:
                            dFromRelative = d11 / 2.0d;
                            b2 = 0;
                            break;
                        case 16:
                            dFromRelative = d10;
                            b2 = 0;
                            break;
                    }
                } else {
                    b2 = 0;
                    dFromRelative = 0.0d;
                }
                if (baselineShift != null) {
                    baselineShift.hashCode();
                    switch (baselineShift.hashCode()) {
                        case -1720785339:
                            if (baselineShift.equals("baseline")) {
                                b = b2;
                            }
                            break;
                        case 114240:
                            if (baselineShift.equals("sub")) {
                                b = 1;
                            }
                            break;
                        case 109801339:
                            if (baselineShift.equals("super")) {
                                b = 2;
                            }
                            break;
                    }
                    switch (b) {
                        case 0:
                            break;
                        case 1:
                            if (readableMap != null) {
                                i9 = readableMap.getInt("unitsPerEm");
                                map = readableMap.getMap("tables");
                                if (map.hasKey("os2")) {
                                    dFromRelative = dFromRelative;
                                } else {
                                    map2 = map.getMap("os2");
                                    if (map2.hasKey("ySubscriptYOffset")) {
                                        dFromRelative = dFromRelative;
                                    } else {
                                        dFromRelative += ((((double) tSpanView.mScale) * d3) * map2.getDouble("ySubscriptYOffset")) / ((double) i9);
                                    }
                                }
                            }
                            break;
                        case 2:
                            if (readableMap != null) {
                                i10 = readableMap.getInt("unitsPerEm");
                                map3 = readableMap.getMap("tables");
                                if (map3.hasKey("os2")) {
                                    map4 = map3.getMap("os2");
                                    if (map4.hasKey("ySuperscriptYOffset")) {
                                        dFromRelative -= ((((double) tSpanView.mScale) * d3) * map4.getDouble("ySuperscriptYOffset")) / ((double) i10);
                                    }
                                }
                            }
                            break;
                        default:
                            dFromRelative -= PropHelper.fromRelative(baselineShift, ((double) tSpanView.mScale) * d3, tSpanView.mScale, d3);
                            break;
                    }
                }
                double d213 = dFromRelative;
                Matrix matrix5 = new Matrix();
                matrix = new Matrix();
                Matrix matrix6 = new Matrix();
                fArr3 = new float[9];
                fArr4 = new float[9];
                i2 = 0;
                while (i2 < length2) {
                    c = charArray[i2];
                    strValueOf = String.valueOf(c);
                    z6 = zArr[i2];
                    if (z6) {
                        strValueOf = "";
                        z7 = false;
                        f = 0.0f;
                    } else {
                        i3 = i2;
                        z7 = false;
                        f = 0.0f;
                        while (true) {
                            i4 = i3 + 1;
                            if (i4 >= length2) {
                            }
                            strValueOf = strValueOf + charArray[i4];
                            zArr[i4] = true;
                            i3 = i4;
                            z7 = true;
                        }
                    }
                    i5 = i2;
                    dMeasureText = ((double) paint3.measureText(strValueOf)) * d7;
                    if (!z3) {
                        d21 = (((double) fArr2[i5]) * d7) - dMeasureText;
                    }
                    if (c == ' ') {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        d12 = d22;
                    } else {
                        d12 = 0.0d;
                    }
                    d13 = dMeasureText + d12 + d23;
                    if (z6) {
                        d14 = 0.0d;
                    } else {
                        d14 = d21 + d13;
                    }
                    double dNextX2 = glyphContext2.nextX(d14);
                    double dNextY2 = glyphContext2.nextY();
                    double dNextDeltaX2 = glyphContext2.nextDeltaX();
                    double dNextDeltaY2 = glyphContext2.nextDeltaY();
                    String str4 = strValueOf;
                    double dNextRotation2 = glyphContext2.nextRotation();
                    if (z6) {
                        fArr4 = fArr4;
                        canvas2 = canvas3;
                        i6 = length2;
                        glyphContext2 = glyphContext2;
                        glyphPathBag2 = glyphPathBag;
                        matrix2 = matrix;
                        this = this;
                        paint2 = paint;
                        fArr3 = fArr3;
                        path = path2;
                    } else {
                        fArr4 = fArr4;
                        canvas2 = canvas3;
                        i6 = length2;
                        glyphContext2 = glyphContext2;
                        glyphPathBag2 = glyphPathBag;
                        matrix2 = matrix;
                        this = this;
                        paint2 = paint;
                        fArr3 = fArr3;
                        path = path2;
                    }
                    paint3 = paint2;
                    path2 = path;
                    glyphPathBag = glyphPathBag2;
                    tSpanView = this;
                    fArr3 = fArr3;
                    matrix = matrix2;
                    length2 = i6;
                    glyphContext2 = glyphContext2;
                    fArr4 = fArr4;
                    canvas3 = canvas2;
                    i2 = i5 + 1;
                }
            } else {
                glyphContext = textRootGlyphContext;
            }
            if (z2) {
                paint3.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + font.fontFeatureSettings);
            } else {
                paint3.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + font.fontFeatureSettings);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                paint3.setFontVariationSettings(fontWeightTag + font.absoluteFontWeight + font.fontVariationSettings);
            }
            readableMap = font.fontData;
            fArr = new float[length2];
            d = length;
            paint3.getTextWidths(str, fArr);
            textAnchor = font.textAnchor;
            subtreeTextChunksTotalAdvance = getTextAnchorRoot().getSubtreeTextChunksTotalAdvance(paint3);
            textAnchorOffset = getTextAnchorOffset(textAnchor, subtreeTextChunksTotalAdvance);
            fontSize = glyphContext.getFontSize();
            b = -1;
            if (z10) {
                if (this.textPath.getMidLine() == TextProperties.TextPathMidLine.sharp) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (this.textPath.getSide() == TextProperties.TextPathSide.right) {
                    i11 = -1;
                } else {
                    i11 = 1;
                }
                d2 = subtreeTextChunksTotalAdvance;
                z3 = z11;
                glyphContext2 = glyphContext;
                fArr2 = fArr;
                z4 = z10;
                zArr = zArr2;
                glyphPathBag = glyphPathBag3;
                absoluteStartOffset = getAbsoluteStartOffset(this.textPath.getStartOffset(), d, fontSize);
                tSpanView = this;
                d4 = d;
                d17 = textAnchorOffset + absoluteStartOffset;
                d3 = fontSize;
                if (z) {
                    d18 = d4 / 2.0d;
                    if (textAnchor == TextProperties.TextAnchor.middle) {
                        d19 = -d18;
                    } else {
                        d19 = 0.0d;
                    }
                    double d214 = absoluteStartOffset + d19;
                    d5 = d17;
                    d20 = d214;
                    z5 = z9;
                    d6 = d214 + d4;
                    i = i11;
                } else {
                    d5 = d17;
                    z5 = z9;
                    i = i11;
                }
                d7 = 1.0d;
                if (tSpanView.mTextLength != null) {
                    dFromRelative2 = PropHelper.fromRelative(tSpanView.mTextLength, canvas3.getWidth(), 0.0d, tSpanView.mScale, d3);
                    if (dFromRelative2 >= 0.0d) {
                        throw new IllegalArgumentException("Negative textLength value");
                    }
                    if (AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[tSpanView.mLengthAdjust.ordinal()] != 2) {
                        d23 += (dFromRelative2 - d2) / ((double) (length2 - 1));
                    } else {
                        d7 = dFromRelative2 / d2;
                    }
                }
                double d215 = i;
                boolean z14 = z5;
                Paint.FontMetrics fontMetrics3 = paint3.getFontMetrics();
                int i14 = i;
                double d216 = d7 * d215;
                d8 = fontMetrics3.descent;
                double d217 = d4;
                d9 = ((double) fontMetrics3.leading) + d8;
                dFromRelative = (-fontMetrics3.ascent) + fontMetrics3.leading;
                d10 = -fontMetrics3.top;
                d11 = d10 + d9;
                baselineShift = tSpanView.getBaselineShift();
                alignmentBaseline = tSpanView.getAlignmentBaseline();
                if (alignmentBaseline != null) {
                    switch (alignmentBaseline) {
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                            b2 = 0;
                            dFromRelative = -d8;
                            break;
                        case 5:
                        default:
                            b2 = 0;
                            dFromRelative = 0.0d;
                            break;
                        case 7:
                            Rect rect3 = new Rect();
                            b2 = 0;
                            paint3.getTextBounds("x", 0, 1, rect3);
                            dFromRelative = ((double) rect3.height()) / 2.0d;
                            break;
                        case 8:
                            dFromRelative = (dFromRelative - d8) / 2.0d;
                            b2 = 0;
                            break;
                        case 9:
                            d16 = 0.5d;
                            dFromRelative *= d16;
                            b2 = 0;
                            break;
                        case 10:
                            d16 = 0.8d;
                            dFromRelative *= d16;
                            b2 = 0;
                            break;
                        case 11:
                        case 12:
                        case 13:
                            b2 = 0;
                            break;
                        case 14:
                            dFromRelative = d9;
                            b2 = 0;
                            break;
                        case 15:
                            dFromRelative = d11 / 2.0d;
                            b2 = 0;
                            break;
                        case 16:
                            dFromRelative = d10;
                            b2 = 0;
                            break;
                    }
                } else {
                    b2 = 0;
                    dFromRelative = 0.0d;
                }
                if (baselineShift != null) {
                    baselineShift.hashCode();
                    switch (baselineShift.hashCode()) {
                        case -1720785339:
                            if (baselineShift.equals("baseline")) {
                                b = b2;
                            }
                            break;
                        case 114240:
                            if (baselineShift.equals("sub")) {
                                b = 1;
                            }
                            break;
                        case 109801339:
                            if (baselineShift.equals("super")) {
                                b = 2;
                            }
                            break;
                    }
                    switch (b) {
                        case 0:
                            break;
                        case 1:
                            if (readableMap != null) {
                                i9 = readableMap.getInt("unitsPerEm");
                                map = readableMap.getMap("tables");
                                if (map.hasKey("os2")) {
                                    dFromRelative = dFromRelative;
                                } else {
                                    map2 = map.getMap("os2");
                                    if (map2.hasKey("ySubscriptYOffset")) {
                                        dFromRelative = dFromRelative;
                                    } else {
                                        dFromRelative += ((((double) tSpanView.mScale) * d3) * map2.getDouble("ySubscriptYOffset")) / ((double) i9);
                                    }
                                }
                            }
                            break;
                        case 2:
                            if (readableMap != null) {
                                i10 = readableMap.getInt("unitsPerEm");
                                map3 = readableMap.getMap("tables");
                                if (map3.hasKey("os2")) {
                                    map4 = map3.getMap("os2");
                                    if (map4.hasKey("ySuperscriptYOffset")) {
                                        dFromRelative -= ((((double) tSpanView.mScale) * d3) * map4.getDouble("ySuperscriptYOffset")) / ((double) i10);
                                    }
                                }
                            }
                            break;
                        default:
                            dFromRelative -= PropHelper.fromRelative(baselineShift, ((double) tSpanView.mScale) * d3, tSpanView.mScale, d3);
                            break;
                    }
                }
                double d218 = dFromRelative;
                Matrix matrix7 = new Matrix();
                matrix = new Matrix();
                Matrix matrix8 = new Matrix();
                fArr3 = new float[9];
                fArr4 = new float[9];
                i2 = 0;
                while (i2 < length2) {
                    c = charArray[i2];
                    strValueOf = String.valueOf(c);
                    z6 = zArr[i2];
                    if (z6) {
                        strValueOf = "";
                        z7 = false;
                        f = 0.0f;
                    } else {
                        i3 = i2;
                        z7 = false;
                        f = 0.0f;
                        while (true) {
                            i4 = i3 + 1;
                            if (i4 >= length2) {
                            }
                            strValueOf = strValueOf + charArray[i4];
                            zArr[i4] = true;
                            i3 = i4;
                            z7 = true;
                        }
                    }
                    i5 = i2;
                    dMeasureText = ((double) paint3.measureText(strValueOf)) * d7;
                    if (!z3) {
                        d21 = (((double) fArr2[i5]) * d7) - dMeasureText;
                    }
                    if (c == ' ') {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        d12 = d22;
                    } else {
                        d12 = 0.0d;
                    }
                    d13 = dMeasureText + d12 + d23;
                    if (z6) {
                        d14 = 0.0d;
                    } else {
                        d14 = d21 + d13;
                    }
                    double dNextX3 = glyphContext2.nextX(d14);
                    double dNextY3 = glyphContext2.nextY();
                    double dNextDeltaX3 = glyphContext2.nextDeltaX();
                    double dNextDeltaY3 = glyphContext2.nextDeltaY();
                    String str5 = strValueOf;
                    double dNextRotation3 = glyphContext2.nextRotation();
                    if (z6) {
                        fArr4 = fArr4;
                        canvas2 = canvas3;
                        i6 = length2;
                        glyphContext2 = glyphContext2;
                        glyphPathBag2 = glyphPathBag;
                        matrix2 = matrix;
                        this = this;
                        paint2 = paint;
                        fArr3 = fArr3;
                        path = path2;
                    } else {
                        fArr4 = fArr4;
                        canvas2 = canvas3;
                        i6 = length2;
                        glyphContext2 = glyphContext2;
                        glyphPathBag2 = glyphPathBag;
                        matrix2 = matrix;
                        this = this;
                        paint2 = paint;
                        fArr3 = fArr3;
                        path = path2;
                    }
                    paint3 = paint2;
                    path2 = path;
                    glyphPathBag = glyphPathBag2;
                    tSpanView = this;
                    fArr3 = fArr3;
                    matrix = matrix2;
                    length2 = i6;
                    glyphContext2 = glyphContext2;
                    fArr4 = fArr4;
                    canvas3 = canvas2;
                    i2 = i5 + 1;
                }
            } else {
                tSpanView = this;
                d2 = subtreeTextChunksTotalAdvance;
                z3 = z11;
                glyphContext2 = glyphContext;
                d3 = fontSize;
                z4 = z10;
                glyphPathBag = glyphPathBag3;
                fArr2 = fArr;
                zArr = zArr2;
                d4 = d;
                d5 = textAnchorOffset;
                i = 1;
                z5 = false;
            }
            d6 = d4;
            d7 = 1.0d;
            if (tSpanView.mTextLength != null) {
                dFromRelative2 = PropHelper.fromRelative(tSpanView.mTextLength, canvas3.getWidth(), 0.0d, tSpanView.mScale, d3);
                if (dFromRelative2 >= 0.0d) {
                    throw new IllegalArgumentException("Negative textLength value");
                }
                if (AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[tSpanView.mLengthAdjust.ordinal()] != 2) {
                    d23 += (dFromRelative2 - d2) / ((double) (length2 - 1));
                } else {
                    d7 = dFromRelative2 / d2;
                }
            }
            double d219 = i;
            boolean z15 = z5;
            Paint.FontMetrics fontMetrics4 = paint3.getFontMetrics();
            int i15 = i;
            double d2110 = d7 * d219;
            d8 = fontMetrics4.descent;
            double d2111 = d4;
            d9 = ((double) fontMetrics4.leading) + d8;
            dFromRelative = (-fontMetrics4.ascent) + fontMetrics4.leading;
            d10 = -fontMetrics4.top;
            d11 = d10 + d9;
            baselineShift = tSpanView.getBaselineShift();
            alignmentBaseline = tSpanView.getAlignmentBaseline();
            if (alignmentBaseline != null) {
                switch (alignmentBaseline) {
                    case textBottom:
                    case afterEdge:
                    case textAfterEdge:
                    case ideographic:
                        b2 = 0;
                        dFromRelative = -d8;
                        break;
                    case alphabetic:
                    default:
                        b2 = 0;
                        dFromRelative = 0.0d;
                        break;
                    case middle:
                        Rect rect4 = new Rect();
                        b2 = 0;
                        paint3.getTextBounds("x", 0, 1, rect4);
                        dFromRelative = ((double) rect4.height()) / 2.0d;
                        break;
                    case central:
                        dFromRelative = (dFromRelative - d8) / 2.0d;
                        b2 = 0;
                        break;
                    case mathematical:
                        d16 = 0.5d;
                        dFromRelative *= d16;
                        b2 = 0;
                        break;
                    case hanging:
                        d16 = 0.8d;
                        dFromRelative *= d16;
                        b2 = 0;
                        break;
                    case textTop:
                    case beforeEdge:
                    case textBeforeEdge:
                        b2 = 0;
                        break;
                    case bottom:
                        dFromRelative = d9;
                        b2 = 0;
                        break;
                    case center:
                        dFromRelative = d11 / 2.0d;
                        b2 = 0;
                        break;
                    case top:
                        dFromRelative = d10;
                        b2 = 0;
                        break;
                }
            } else {
                b2 = 0;
                dFromRelative = 0.0d;
            }
            if (baselineShift != null) {
                baselineShift.hashCode();
                switch (baselineShift.hashCode()) {
                    case -1720785339:
                        if (baselineShift.equals("baseline")) {
                            b = b2;
                        }
                        break;
                    case 114240:
                        if (baselineShift.equals("sub")) {
                            b = 1;
                        }
                        break;
                    case 109801339:
                        if (baselineShift.equals("super")) {
                            b = 2;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        break;
                    case 1:
                        if (readableMap != null) {
                            i9 = readableMap.getInt("unitsPerEm");
                            map = readableMap.getMap("tables");
                            if (map.hasKey("os2")) {
                                dFromRelative = dFromRelative;
                            } else {
                                map2 = map.getMap("os2");
                                if (map2.hasKey("ySubscriptYOffset")) {
                                    dFromRelative = dFromRelative;
                                } else {
                                    dFromRelative += ((((double) tSpanView.mScale) * d3) * map2.getDouble("ySubscriptYOffset")) / ((double) i9);
                                }
                            }
                        }
                        break;
                    case 2:
                        if (readableMap != null) {
                            i10 = readableMap.getInt("unitsPerEm");
                            map3 = readableMap.getMap("tables");
                            if (map3.hasKey("os2")) {
                                map4 = map3.getMap("os2");
                                if (map4.hasKey("ySuperscriptYOffset")) {
                                    dFromRelative -= ((((double) tSpanView.mScale) * d3) * map4.getDouble("ySuperscriptYOffset")) / ((double) i10);
                                }
                            }
                        }
                        break;
                    default:
                        dFromRelative -= PropHelper.fromRelative(baselineShift, ((double) tSpanView.mScale) * d3, tSpanView.mScale, d3);
                        break;
                }
            }
            double d2112 = dFromRelative;
            Matrix matrix9 = new Matrix();
            matrix = new Matrix();
            Matrix matrix10 = new Matrix();
            fArr3 = new float[9];
            fArr4 = new float[9];
            i2 = 0;
            while (i2 < length2) {
                c = charArray[i2];
                strValueOf = String.valueOf(c);
                z6 = zArr[i2];
                if (z6) {
                    strValueOf = "";
                    z7 = false;
                    f = 0.0f;
                } else {
                    i3 = i2;
                    z7 = false;
                    f = 0.0f;
                    while (true) {
                        i4 = i3 + 1;
                        if (i4 >= length2) {
                        }
                        strValueOf = strValueOf + charArray[i4];
                        zArr[i4] = true;
                        i3 = i4;
                        z7 = true;
                    }
                }
                i5 = i2;
                dMeasureText = ((double) paint3.measureText(strValueOf)) * d7;
                if (!z3) {
                    d21 = (((double) fArr2[i5]) * d7) - dMeasureText;
                }
                if (c == ' ') {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    d12 = d22;
                } else {
                    d12 = 0.0d;
                }
                d13 = dMeasureText + d12 + d23;
                if (z6) {
                    d14 = 0.0d;
                } else {
                    d14 = d21 + d13;
                }
                double dNextX4 = glyphContext2.nextX(d14);
                double dNextY4 = glyphContext2.nextY();
                double dNextDeltaX4 = glyphContext2.nextDeltaX();
                double dNextDeltaY4 = glyphContext2.nextDeltaY();
                String str6 = strValueOf;
                double dNextRotation4 = glyphContext2.nextRotation();
                if (z6) {
                    fArr4 = fArr4;
                    canvas2 = canvas3;
                    i6 = length2;
                    glyphContext2 = glyphContext2;
                    glyphPathBag2 = glyphPathBag;
                    matrix2 = matrix;
                    this = this;
                    paint2 = paint;
                    fArr3 = fArr3;
                    path = path2;
                } else {
                    fArr4 = fArr4;
                    canvas2 = canvas3;
                    i6 = length2;
                    glyphContext2 = glyphContext2;
                    glyphPathBag2 = glyphPathBag;
                    matrix2 = matrix;
                    this = this;
                    paint2 = paint;
                    fArr3 = fArr3;
                    path = path2;
                }
                paint3 = paint2;
                path2 = path;
                glyphPathBag = glyphPathBag2;
                tSpanView = this;
                fArr3 = fArr3;
                matrix = matrix2;
                length2 = i6;
                glyphContext2 = glyphContext2;
                fArr4 = fArr4;
                canvas3 = canvas2;
                i2 = i5 + 1;
            }
        }
        return path2;
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TSpanView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust;

        static {
            int[] iArr = new int[TextProperties.AlignmentBaseline.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline = iArr;
            try {
                iArr[TextProperties.AlignmentBaseline.baseline.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textBottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.afterEdge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textAfterEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.alphabetic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.ideographic.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.middle.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.central.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.mathematical.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.hanging.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.beforeEdge.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.textBeforeEdge.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.bottom.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.center.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline[TextProperties.AlignmentBaseline.top.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr2 = new int[TextProperties.TextLengthAdjust.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust = iArr2;
            try {
                iArr2[TextProperties.TextLengthAdjust.spacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust[TextProperties.TextLengthAdjust.spacingAndGlyphs.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr3 = new int[TextProperties.TextAnchor.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr3;
            try {
                iArr3[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private double getAbsoluteStartOffset(SVGLength sVGLength, double d, double d2) {
        return PropHelper.fromRelative(sVGLength, d, 0.0d, this.mScale, d2);
    }

    private double getTextAnchorOffset(TextProperties.TextAnchor textAnchor, double d) {
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
        if (i == 2) {
            return (-d) / 2.0d;
        }
        if (i != 3) {
            return 0.0d;
        }
        return -d;
    }

    private void applyTextPropertiesToPaint(Paint paint, FontData fontData) {
        int i = 0;
        boolean z = fontData.fontWeight == TextProperties.FontWeight.Bold || fontData.absoluteFontWeight >= 550;
        boolean z2 = fontData.fontStyle == TextProperties.FontStyle.italic;
        if (z && z2) {
            i = 3;
        } else if (z) {
            i = 1;
        } else if (z2) {
            i = 2;
        }
        int i2 = fontData.absoluteFontWeight;
        String str = fontData.fontFamily;
        Typeface typeface = null;
        if (str != null && str.length() > 0) {
            String str2 = FONTS + str + OTF;
            String str3 = FONTS + str + TTF;
            if (Build.VERSION.SDK_INT >= 26) {
                Typeface.Builder builder = new Typeface.Builder(this.assets, str2);
                builder.setFontVariationSettings(fontWeightTag + i2 + fontData.fontVariationSettings);
                builder.setWeight(i2);
                builder.setItalic(z2);
                typeface = builder.build();
                if (typeface == null) {
                    Typeface.Builder builder2 = new Typeface.Builder(this.assets, str3);
                    builder2.setFontVariationSettings(fontWeightTag + i2 + fontData.fontVariationSettings);
                    builder2.setWeight(i2);
                    builder2.setItalic(z2);
                    typeface = builder2.build();
                }
            } else {
                try {
                    try {
                        typeface = Typeface.create(Typeface.createFromAsset(this.assets, str2), i);
                    } catch (Exception unused) {
                        typeface = Typeface.create(Typeface.createFromAsset(this.assets, str3), i);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        if (typeface == null) {
            try {
                typeface = ReactFontManager.getInstance().getTypeface(str, i, this.assets);
            } catch (Exception unused3) {
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            typeface = Typeface.create(typeface, i2, z2);
        }
        paint.setLinearText(true);
        paint.setSubpixelText(true);
        paint.setTypeface(typeface);
        paint.setTextSize((float) (fontData.fontSize * ((double) this.mScale)));
        paint.setLetterSpacing(0.0f);
    }

    private void setupTextPath() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass() == TextPathView.class) {
                this.textPath = (TextPathView) parent;
                return;
            } else {
                if (!(parent instanceof TextView)) {
                    return;
                }
            }
        }
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    int hitTest(float[] fArr) {
        if (this.mContent == null) {
            return super.hitTest(fArr);
        }
        if (this.mPath != null && this.mInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int iRound = Math.round(fArr2[0]);
            int iRound2 = Math.round(fArr2[1]);
            initBounds();
            if ((this.mRegion != null && this.mRegion.contains(iRound, iRound2)) || (this.mStrokeRegion != null && this.mStrokeRegion.contains(iRound, iRound2))) {
                if (getClipPath() == null || this.mClipRegion.contains(iRound, iRound2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }
}
