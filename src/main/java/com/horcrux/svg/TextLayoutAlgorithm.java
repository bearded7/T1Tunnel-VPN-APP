package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class TextLayoutAlgorithm {
    TextLayoutAlgorithm() {
    }

    class CharacterInformation {
        double advance;
        char character;
        TextView element;
        int index;
        double x = 0.0d;
        double y = 0.0d;
        double rotate = 0.0d;
        boolean hidden = false;
        boolean middle = false;
        boolean resolved = false;
        boolean xSpecified = false;
        boolean ySpecified = false;
        boolean addressable = true;
        boolean anchoredChunk = false;
        boolean rotateSpecified = false;
        boolean firstCharacterInResolvedDescendant = false;

        CharacterInformation(int i, char c) {
            this.index = i;
            this.character = c;
        }
    }

    class LayoutInput {
        boolean horizontal;
        TextView text;

        LayoutInput() {
        }
    }

    private void getSubTreeTypographicCharacterPositions(ArrayList<TextPathView> arrayList, ArrayList<TextView> arrayList2, StringBuilder sb, View view, TextPathView textPathView) {
        int i = 0;
        if (view instanceof TSpanView) {
            TSpanView tSpanView = (TSpanView) view;
            String str = tSpanView.mContent;
            if (str == null) {
                while (i < tSpanView.getChildCount()) {
                    getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, tSpanView.getChildAt(i), textPathView);
                    i++;
                }
                return;
            } else {
                while (i < str.length()) {
                    arrayList2.add(tSpanView);
                    arrayList.add(textPathView);
                    i++;
                }
                sb.append(str);
                return;
            }
        }
        TextPathView textPathView2 = view instanceof TextPathView ? (TextPathView) view : textPathView;
        while (i < textPathView2.getChildCount()) {
            getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, textPathView2.getChildAt(i), textPathView2);
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:152:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.graphics.Canvas, android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.horcrux.svg.TextLayoutAlgorithm$1TextLengthResolver] */
    CharacterInformation[] layoutText(LayoutInput layoutInput) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        double d;
        char c;
        double d2;
        TextView textView = layoutInput.text;
        StringBuilder sb = new StringBuilder();
        ArrayList<TextView> arrayList = new ArrayList<>();
        ArrayList<TextPathView> arrayList2 = new ArrayList<>();
        getSubTreeTypographicCharacterPositions(arrayList2, arrayList, sb, textView, null);
        char[] charArray = sb.toString().toCharArray();
        int length = charArray.length;
        final CharacterInformation[] characterInformationArr = new CharacterInformation[length];
        for (int i2 = 0; i2 < length; i2++) {
            characterInformationArr[i2] = new CharacterInformation(i2, charArray[i2]);
        }
        if (length != 0) {
            PointF[] pointFArr = new PointF[length];
            for (int i3 = 0; i3 < length; i3++) {
                pointFArr[i3] = new PointF(0.0f, 0.0f);
            }
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                characterInformationArr[i4].addressable = true;
                characterInformationArr[i4].middle = false;
                characterInformationArr[i4].anchoredChunk = i4 == 0;
                if (characterInformationArr[i4].addressable && !characterInformationArr[i4].middle) {
                    pointFArr[i4].set(0.0f, 0.0f);
                } else if (i4 > 0) {
                    pointFArr[i4].set(pointFArr[i4 - 1]);
                }
                i4++;
            }
            String[] strArr = new String[length];
            String[] strArr2 = new String[length];
            new C1CharacterPositioningResolver(characterInformationArr, strArr, strArr2, new String[length], new String[length]);
            PointF pointF = new PointF(0.0f, 0.0f);
            for (int i5 = 0; i5 < length; i5++) {
                if (strArr[i5].equals("")) {
                    strArr[i5] = "0";
                }
                if (strArr2[i5].equals("")) {
                    strArr2[i5] = "0";
                }
                pointF.x += Float.parseFloat(strArr[i5]);
                pointF.y += Float.parseFloat(strArr2[i5]);
                characterInformationArr[i5].x = pointFArr[i5].x + pointF.x;
                characterInformationArr[i5].y = pointFArr[i5].y + pointF.y;
            }
            new Object() { // from class: com.horcrux.svg.TextLayoutAlgorithm.1TextLengthResolver
                int global;

                /* JADX INFO: Access modifiers changed from: private */
                public void resolveTextLength(TextView textView2) {
                    Class<?> cls = textView2.getClass();
                    boolean z4 = textView2.mTextLength != null;
                    if (cls == TSpanView.class && z4) {
                        TSpanView tSpanView = (TSpanView) textView2;
                        String str = tSpanView.mContent;
                        int i6 = this.global;
                        int length2 = (str == null ? 0 : str.length()) + i6;
                        double dMax = Double.NEGATIVE_INFINITY;
                        int i7 = i6;
                        double dMin = Double.POSITIVE_INFINITY;
                        while (i7 <= length2) {
                            if (characterInformationArr[i6].addressable) {
                                char c2 = characterInformationArr[i6].character;
                                if (c2 == '\n' || c2 == '\r') {
                                    return;
                                }
                                double d3 = characterInformationArr[i7].x;
                                double d4 = characterInformationArr[i7].advance + d3;
                                dMin = Math.min(dMin, Math.min(d3, d4));
                                dMax = Math.max(dMax, Math.max(d3, d4));
                            }
                            i7++;
                            i6 = i6;
                        }
                        int i8 = i6;
                        if (dMin != Double.POSITIVE_INFINITY) {
                            double d5 = textView2.mTextLength.value - (dMax - dMin);
                            int length3 = 0;
                            int i9 = 0;
                            for (int i10 = 0; i10 < textView2.getChildCount(); i10++) {
                                if (((TextPathView) textView2.getChildAt(i10)).mTextLength == null) {
                                    String str2 = tSpanView.mContent;
                                    length3 += str2 == null ? 0 : str2.length();
                                } else {
                                    characterInformationArr[length3].firstCharacterInResolvedDescendant = true;
                                    i9++;
                                }
                            }
                            double d6 = d5 / ((double) (length3 + (i9 - 1)));
                            double d7 = 0.0d;
                            for (int i11 = i8; i11 <= length2; i11++) {
                                characterInformationArr[i11].x += d7;
                                if (!characterInformationArr[i11].middle && (!characterInformationArr[i11].resolved || characterInformationArr[i11].firstCharacterInResolvedDescendant)) {
                                    d7 += d6;
                                }
                            }
                        }
                    }
                }
            }.resolveTextLength(textView);
            pointF.set(0.0f, 0.0f);
            int i6 = 1;
            while (i6 < length) {
                String str = strArr[i6];
                if (str != null) {
                    pointF.x = (float) (Double.parseDouble(str) - characterInformationArr[i6].x);
                }
                String str2 = strArr2[i6];
                if (str2 != null) {
                    pointF.y = (float) (Double.parseDouble(str2) - characterInformationArr[i6].y);
                }
                characterInformationArr[i6].x += (double) pointF.x;
                characterInformationArr[i6].y += (double) pointF.y;
                if (characterInformationArr[i6].middle && characterInformationArr[i6].anchoredChunk) {
                    characterInformationArr[i6].anchoredChunk = false;
                }
                i6++;
                if (i6 < length) {
                    characterInformationArr[i6].anchoredChunk = true;
                }
            }
            int i7 = 0;
            int i8 = 0;
            double dMin = Double.POSITIVE_INFINITY;
            double dMax = Double.NEGATIVE_INFINITY;
            double d3 = Double.POSITIVE_INFINITY;
            double d4 = Double.NEGATIVE_INFINITY;
            while (i7 < length) {
                if (characterInformationArr[i7].addressable) {
                    if (characterInformationArr[i7].anchoredChunk) {
                        d3 = dMin;
                        d4 = dMax;
                        dMin = Double.POSITIVE_INFINITY;
                        dMax = Double.NEGATIVE_INFINITY;
                    }
                    double d5 = characterInformationArr[i7].x;
                    double d6 = characterInformationArr[i7].advance + d5;
                    dMin = Math.min(dMin, Math.min(d5, d6));
                    dMax = Math.max(dMax, Math.max(d5, d6));
                    if ((i7 > 0 && characterInformationArr[i7].anchoredChunk && d3 != Double.POSITIVE_INFINITY) || i7 == length - 1) {
                        TextProperties.TextAnchor textAnchor = TextProperties.TextAnchor.start;
                        TextProperties.Direction direction = TextProperties.Direction.ltr;
                        int i9 = length - 1;
                        if (i7 == i9) {
                            d3 = dMin;
                            d4 = dMax;
                        }
                        double d7 = characterInformationArr[i8].x;
                        int i10 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
                        if (i10 != 1) {
                            if (i10 == 2) {
                                TextProperties.Direction direction2 = TextProperties.Direction.ltr;
                                d7 -= (d3 + d4) / 2.0d;
                            } else if (i10 == 3) {
                                if (direction == TextProperties.Direction.ltr) {
                                    d7 -= d4;
                                } else {
                                    d7 -= d3;
                                }
                            }
                        } else if (direction == TextProperties.Direction.ltr) {
                            d7 -= d3;
                        } else {
                            d7 -= d4;
                        }
                        int i11 = i7 == i9 ? i7 : i7 - 1;
                        for (int i12 = i8; i12 <= i11; i12++) {
                            characterInformationArr[i12].x += d7;
                        }
                        i8 = i7;
                    }
                }
                i7++;
            }
            int i13 = i8;
            PointF pointF2 = new PointF(0.0f, 0.0f);
            PathMeasure pathMeasure = new PathMeasure();
            ?? r4 = 0;
            Path textPath = null;
            boolean z4 = false;
            int i14 = 0;
            boolean z5 = false;
            while (i14 < length) {
                TextPathView textPathView = arrayList2.get(i14);
                if (textPathView == 0 || !characterInformationArr[i14].addressable) {
                    z = z4;
                    i = i13;
                } else {
                    textPath = textPathView.getTextPath(r4, r4);
                    if (!characterInformationArr[i14].middle) {
                        textPathView.getSide();
                        TextProperties.TextPathSide textPathSide = TextProperties.TextPathSide.right;
                        pathMeasure.setPath(textPath, false);
                        double length2 = pathMeasure.getLength();
                        z = z4;
                        double d8 = textPathView.getStartOffset().value;
                        i = i13;
                        double d9 = characterInformationArr[i14].advance;
                        double d10 = characterInformationArr[i14].x;
                        double d11 = characterInformationArr[i14].y;
                        double d12 = characterInformationArr[i14].rotate;
                        double d13 = d10 + (d9 / 2.0d) + d8;
                        if (!pathMeasure.isClosed() && (d13 < 0.0d || d13 > length2)) {
                            characterInformationArr[i14].hidden = true;
                        }
                        if (pathMeasure.isClosed()) {
                            TextProperties.TextAnchor textAnchor2 = TextProperties.TextAnchor.start;
                            TextProperties.Direction direction3 = TextProperties.Direction.ltr;
                            d = d13;
                            double d14 = characterInformationArr[i].x;
                            int i15 = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor2.ordinal()];
                            if (i15 != 1) {
                                if (i15 != 2) {
                                    if (i15 == 3) {
                                        if (direction3 != TextProperties.Direction.ltr) {
                                            c = 1;
                                            if (d < r12 || d > length2) {
                                                characterInformationArr[i14].hidden = true;
                                            }
                                        } else if (d < (-length2) || d > 0) {
                                            c = 1;
                                            characterInformationArr[i14].hidden = true;
                                        }
                                    }
                                } else if (d < (-length2) / 2.0d || d > length2 / 2.0d) {
                                    c = 1;
                                    characterInformationArr[i14].hidden = true;
                                }
                            } else if (direction3 != TextProperties.Direction.ltr) {
                                c = 1;
                                if (d < (-length2) || d > r12) {
                                    characterInformationArr[i14].hidden = true;
                                }
                            } else if (d < r12 || d > length2) {
                                c = 1;
                                characterInformationArr[i14].hidden = true;
                            }
                            d2 = d % length2;
                            if (!characterInformationArr[i14].hidden) {
                                float[] fArr = new float[2];
                                pathMeasure.getPosTan((float) d2, new float[2], fArr);
                                double dAtan2 = Math.atan2(fArr[c], fArr[0]) * 57.29577951308232d;
                                double d15 = 90.0d + dAtan2;
                                Math.cos(d15);
                                Math.sin(d15);
                                characterInformationArr[i14].rotate += dAtan2;
                            }
                        } else {
                            d = d13;
                        }
                        c = 1;
                        d2 = d % length2;
                        if (!characterInformationArr[i14].hidden) {
                            float[] fArr2 = new float[2];
                            pathMeasure.getPosTan((float) d2, new float[2], fArr2);
                            double dAtan3 = Math.atan2(fArr2[c], fArr2[0]) * 57.29577951308232d;
                            double d16 = 90.0d + dAtan3;
                            Math.cos(d16);
                            Math.sin(d16);
                            characterInformationArr[i14].rotate += dAtan3;
                        }
                    } else {
                        z = z4;
                        i = i13;
                        int i16 = i14 - 1;
                        characterInformationArr[i14].x = characterInformationArr[i16].x;
                        characterInformationArr[i14].y = characterInformationArr[i16].y;
                        characterInformationArr[i14].rotate = characterInformationArr[i16].rotate;
                    }
                    z5 = true;
                }
                if (textPathView == 0 && characterInformationArr[i14].addressable) {
                    if (z5) {
                        pathMeasure.setPath(textPath, false);
                        float[] fArr3 = new float[2];
                        pathMeasure.getPosTan(pathMeasure.getLength(), fArr3, null);
                        pointF2.set(fArr3[0], fArr3[1]);
                        z2 = false;
                        z3 = true;
                    } else {
                        z2 = z5;
                        z3 = z;
                    }
                    if (z3) {
                        if (characterInformationArr[i14].anchoredChunk) {
                            pointF2 = pointF2;
                            z4 = false;
                        } else {
                            characterInformationArr[i14].x += (double) pointF2.x;
                            characterInformationArr[i14].y += (double) pointF2.y;
                        }
                        z5 = z2;
                    }
                    z4 = z3;
                    z5 = z2;
                } else {
                    pointF2 = pointF2;
                    z4 = z;
                }
                i14++;
                pointF2 = pointF2;
                i13 = i;
                r4 = 0;
            }
        }
        return characterInformationArr;
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1CharacterPositioningResolver, reason: invalid class name */
    class C1CharacterPositioningResolver {
        private int global;
        private boolean horizontal;
        private boolean in_text_path;
        private String[] resolve_dx;
        private String[] resolve_dy;
        private String[] resolve_x;
        private String[] resolve_y;
        private CharacterInformation[] result;

        private C1CharacterPositioningResolver(CharacterInformation[] characterInformationArr, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.global = 0;
            this.horizontal = true;
            this.in_text_path = false;
            this.result = characterInformationArr;
            this.resolve_x = strArr;
            this.resolve_y = strArr2;
            this.resolve_dx = strArr3;
            this.resolve_dy = strArr4;
        }

        private void resolveCharacterPositioning(TextView textView) {
            boolean z = true;
            if (textView.getClass() == TextView.class || textView.getClass() == TSpanView.class) {
                int i = this.global;
                String[] strArr = new String[0];
                String[] strArr2 = new String[0];
                String[] strArr3 = new String[0];
                String[] strArr4 = new String[0];
                double[] dArr = new double[0];
                int iMax = !this.in_text_path ? Math.max(0, 0) : 0;
                String str = ((TSpanView) textView).mContent;
                int length = str == null ? 0 : str.length();
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i + i2;
                    if (this.result[i4].addressable) {
                        this.result[i4].anchoredChunk = i3 < iMax ? z : false;
                        if (i3 < 0) {
                            this.resolve_x[i4] = strArr[i3];
                        }
                        boolean z2 = this.in_text_path;
                        if (z2 && !this.horizontal) {
                            this.resolve_x[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_y[i4] = strArr2[i3];
                        }
                        if (z2 && this.horizontal) {
                            this.resolve_y[i] = "";
                        }
                        if (i3 < 0) {
                            this.resolve_dx[i4] = strArr3[i3];
                        }
                        if (i3 < 0) {
                            this.resolve_dy[i4] = strArr4[i3];
                        }
                        if (i3 < 0) {
                            this.result[i4].rotate = dArr[i3];
                        }
                    }
                    i3++;
                    i2++;
                    z = true;
                }
                return;
            }
            if (textView.getClass() == TextPathView.class) {
                this.result[this.global].anchoredChunk = true;
                this.in_text_path = true;
                for (int i5 = 0; i5 < textView.getChildCount(); i5++) {
                    resolveCharacterPositioning((TextView) textView.getChildAt(i5));
                }
                if (textView instanceof TextPathView) {
                    this.in_text_path = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.horcrux.svg.TextLayoutAlgorithm$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor;

        static {
            int[] iArr = new int[TextProperties.TextAnchor.values().length];
            $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = iArr;
            try {
                iArr[TextProperties.TextAnchor.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[TextProperties.TextAnchor.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
