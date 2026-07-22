package com.horcrux.svg;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
class ViewBox {
    private static final int MOS_MEET = 0;
    private static final int MOS_NONE = 2;
    private static final int MOS_SLICE = 1;

    ViewBox() {
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0085  */
    /* JADX WARN: Code duplicated, block: B:24:0x0094  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:30:0x00af  */
    static Matrix getTransform(RectF rectF, RectF rectF2, String str, int i) {
        double d;
        double d2 = rectF.left;
        double d3 = rectF.top;
        double dWidth = rectF.width();
        double dHeight = rectF.height();
        double d4 = rectF2.left;
        double d5 = rectF2.top;
        double dWidth2 = rectF2.width();
        double dHeight2 = rectF2.height();
        double dMax = dWidth2 / dWidth;
        double d6 = dHeight2 / dHeight;
        double d7 = d4 - (d2 * dMax);
        double d8 = d5 - (d3 * d6);
        if (i == 2) {
            dMax = Math.min(dMax, d6);
            if (dMax > 1.0d) {
                d7 -= ((dWidth2 / dMax) - dWidth) / 2.0d;
                d = (dHeight2 / dMax) - dHeight;
            } else {
                d7 -= (dWidth2 - (dWidth * dMax)) / 2.0d;
                d = dHeight2 - (dHeight * dMax);
            }
            d8 -= d / 2.0d;
            d6 = dMax;
        } else {
            if (!str.equals("none") && i == 0) {
                dMax = Math.min(dMax, d6);
            } else if (!str.equals("none") && i == 1) {
                dMax = Math.max(dMax, d6);
            } else {
                if (str.contains("xMid")) {
                    d7 += (dWidth2 - (dWidth * dMax)) / 2.0d;
                }
                if (str.contains("xMax")) {
                    d7 += dWidth2 - (dWidth * dMax);
                }
                if (str.contains("YMid")) {
                    d8 += (dHeight2 - (dHeight * d6)) / 2.0d;
                }
                if (str.contains("YMax")) {
                    d8 += dHeight2 - (dHeight * d6);
                }
            }
            d6 = dMax;
            if (str.contains("xMid")) {
                d7 += (dWidth2 - (dWidth * dMax)) / 2.0d;
            }
            if (str.contains("xMax")) {
                d7 += dWidth2 - (dWidth * dMax);
            }
            if (str.contains("YMid")) {
                d8 += (dHeight2 - (dHeight * d6)) / 2.0d;
            }
            if (str.contains("YMax")) {
                d8 += dHeight2 - (dHeight * d6);
            }
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) d7, (float) d8);
        matrix.preScale((float) dMax, (float) d6);
        return matrix;
    }
}
