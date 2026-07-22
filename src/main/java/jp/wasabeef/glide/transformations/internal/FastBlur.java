package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class FastBlur {
    public static Bitmap blur(Bitmap sentBitmap, int radius, boolean canReuseInBitmap) {
        int i;
        int i2 = radius;
        Bitmap bitmapCopy = canReuseInBitmap ? sentBitmap : sentBitmap.copy(sentBitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i3 = width * height;
        int[] iArr = new int[i3];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2;
        int i7 = i6 + 1;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[Math.max(width, height)];
        int i8 = (i6 + 2) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr6 = new int[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            iArr6[i12] = i12 / i9;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 3);
        int i13 = i2 + 1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < height) {
            int[] iArr8 = iArr6;
            int i17 = -i2;
            int i18 = i11;
            int i19 = i18;
            int i20 = i19;
            int i21 = i20;
            int i22 = i21;
            int i23 = i22;
            int i24 = i23;
            int i25 = i24;
            int i26 = i25;
            while (i17 <= i2) {
                int[] iArr9 = iArr4;
                Bitmap bitmap = bitmapCopy;
                int i27 = i11;
                int i28 = iArr[i15 + Math.min(i4, Math.max(i17, i27))];
                int[] iArr10 = iArr7[i17 + i2];
                iArr10[i27] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i28 & 255;
                int iAbs = i13 - Math.abs(i17);
                int i29 = iArr10[i27];
                i26 += i29 * iAbs;
                int i30 = iArr10[1];
                i18 += i30 * iAbs;
                int i31 = iArr10[2];
                i19 += iAbs * i31;
                if (i17 > 0) {
                    i23 += i29;
                    i24 += i30;
                    i25 += i31;
                } else {
                    i20 += i29;
                    i21 += i30;
                    i22 += i31;
                }
                i17++;
                iArr4 = iArr9;
                bitmapCopy = bitmap;
                i11 = 0;
            }
            int[] iArr11 = iArr4;
            Bitmap bitmap2 = bitmapCopy;
            int i32 = i2;
            int i33 = 0;
            while (i33 < width) {
                iArr2[i15] = iArr8[i26];
                iArr3[i15] = iArr8[i18];
                iArr11[i15] = iArr8[i19];
                int i34 = i26 - i20;
                int i35 = i18 - i21;
                int i36 = i19 - i22;
                int[] iArr12 = iArr7[((i32 - i2) + i7) % i7];
                int i37 = i20 - iArr12[0];
                int i38 = i21 - iArr12[1];
                int i39 = i22 - iArr12[2];
                if (i14 == 0) {
                    i = i33;
                    iArr5[i] = Math.min(i33 + i2 + 1, i4);
                } else {
                    i = i33;
                }
                int i40 = iArr[i16 + iArr5[i]];
                int i41 = (i40 & 16711680) >> 16;
                iArr12[0] = i41;
                int i42 = (i40 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i42;
                int i43 = i40 & 255;
                iArr12[2] = i43;
                int i44 = i23 + i41;
                int i45 = i24 + i42;
                int i46 = i25 + i43;
                i26 = i34 + i44;
                i18 = i35 + i45;
                i19 = i36 + i46;
                i32 = (i32 + 1) % i7;
                int[] iArr13 = iArr7[i32 % i7];
                int i47 = iArr13[0];
                i20 = i37 + i47;
                int i48 = iArr13[1];
                i21 = i38 + i48;
                int i49 = iArr13[2];
                i22 = i39 + i49;
                i23 = i44 - i47;
                i24 = i45 - i48;
                i25 = i46 - i49;
                i15++;
                i33 = i + 1;
            }
            i16 += width;
            i14++;
            iArr6 = iArr8;
            iArr4 = iArr11;
            bitmapCopy = bitmap2;
            i11 = 0;
        }
        int[] iArr14 = iArr6;
        int[] iArr15 = iArr4;
        Bitmap bitmap3 = bitmapCopy;
        int i50 = 0;
        while (i50 < width) {
            int i51 = -i2;
            int i52 = i50;
            int i53 = i51 * width;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            while (i51 <= i2) {
                int iMax = Math.max(0, i53) + i52;
                int[] iArr16 = iArr7[i51 + radius];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr15[iMax];
                int iAbs2 = i13 - Math.abs(i51);
                i62 += iArr2[iMax] * iAbs2;
                i54 += iArr3[iMax] * iAbs2;
                i55 += iArr15[iMax] * iAbs2;
                if (i51 > 0) {
                    i59 += iArr16[0];
                    i60 += iArr16[1];
                    i61 += iArr16[2];
                } else {
                    i56 += iArr16[0];
                    i57 += iArr16[1];
                    i58 += iArr16[2];
                }
                if (i51 < i5) {
                    i53 += width;
                }
                i51++;
                i2 = radius;
            }
            int i63 = i62;
            int i64 = i52;
            int i65 = radius;
            for (int i66 = 0; i66 < height; i66++) {
                iArr[i64] = (iArr[i64] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i63] << 16) | (iArr14[i54] << 8) | iArr14[i55];
                int i67 = i63 - i56;
                int i68 = i54 - i57;
                int i69 = i55 - i58;
                int[] iArr17 = iArr7[((i65 - radius) + i7) % i7];
                int i70 = i56 - iArr17[0];
                int i71 = i57 - iArr17[1];
                int i72 = i58 - iArr17[2];
                int i73 = i64;
                if (i52 == 0) {
                    iArr5[i66] = Math.min(i66 + i13, i5) * width;
                }
                int i74 = i52 + iArr5[i66];
                int i75 = iArr2[i74];
                iArr17[0] = i75;
                int i76 = iArr3[i74];
                iArr17[1] = i76;
                int i77 = iArr15[i74];
                iArr17[2] = i77;
                int i78 = i59 + i75;
                int i79 = i60 + i76;
                int i80 = i61 + i77;
                i63 = i67 + i78;
                i54 = i68 + i79;
                i55 = i69 + i80;
                i65 = (i65 + 1) % i7;
                int[] iArr18 = iArr7[i65];
                int i81 = iArr18[0];
                i56 = i70 + i81;
                int i82 = iArr18[1];
                i57 = i71 + i82;
                int i83 = iArr18[2];
                i58 = i72 + i83;
                i59 = i78 - i81;
                i60 = i79 - i82;
                i61 = i80 - i83;
                i64 = i73 + width;
            }
            i50 = i52 + 1;
            i2 = radius;
        }
        bitmap3.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap3;
    }
}
