package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Typography;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: BlurhashDecoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\f\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ6\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J$\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013H\u0002JC\u0010!\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0%2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010&J \u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J4\u0010*\u001a\u00020+*\u00020\u00072\u0006\u0010(\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002J\u0010\u00100\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0013H\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000602X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashDecoder;", "", "<init>", "()V", "cacheCosinesX", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "cacheCosinesY", "clearCache", "", "decode", "Landroid/graphics/Bitmap;", "blurHash", "", "width", "height", "punch", "", "useCache", "", "decode83", "str", "from", "to", "decodeDc", "", "colorEnc", "decodeAc", "value", "maxAc", "signedPow2", "composeBitmap", "numCompX", "numCompY", "colors", "", "(IIII[[FZ)Landroid/graphics/Bitmap;", "getArrayForCosinesY", "calculate", "getArrayForCosinesX", "getCos", "", "x", "numComp", "y", "size", "linearToSrgb", "charMap", "", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlurhashDecoder {
    public static final BlurhashDecoder INSTANCE = new BlurhashDecoder();
    private static final HashMap<Integer, double[]> cacheCosinesX = new HashMap<>();
    private static final HashMap<Integer, double[]> cacheCosinesY = new HashMap<>();
    private static final Map<Character, Integer> charMap;

    private BlurhashDecoder() {
    }

    static {
        int i = 0;
        List listListOf = CollectionsKt.listOf((Object[]) new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', Character.valueOf(Typography.dollar), '%', '*', '+', ',', '-', Character.valueOf(FilenameUtils.EXTENSION_SEPARATOR), ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~'});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Character.valueOf(((Character) obj).charValue()), Integer.valueOf(i)));
            i = i2;
        }
        charMap = MapsKt.toMap(arrayList);
    }

    public final void clearCache() {
        cacheCosinesX.clear();
        cacheCosinesY.clear();
    }

    public static /* synthetic */ Bitmap decode$default(BlurhashDecoder blurhashDecoder, String str, int i, int i2, float f, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i3 & 16) != 0) {
            z = true;
        }
        return blurhashDecoder.decode(str, i, i2, f2, z);
    }

    public final Bitmap decode(String blurHash, int width, int height, float punch, boolean useCache) {
        float[] fArrDecodeAc;
        if (blurHash == null || blurHash.length() < 6) {
            return null;
        }
        int iDecode83 = decode83(blurHash, 0, 1);
        int i = (iDecode83 % 9) + 1;
        int i2 = (iDecode83 / 9) + 1;
        if (blurHash.length() != (i * 2 * i2) + 4) {
            return null;
        }
        float fDecode83 = (decode83(blurHash, 1, 2) + 1) / 166.0f;
        int i3 = i * i2;
        float[][] fArr = new float[i3][];
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 == 0) {
                BlurhashDecoder blurhashDecoder = INSTANCE;
                fArrDecodeAc = blurhashDecoder.decodeDc(blurhashDecoder.decode83(blurHash, 2, 6));
            } else {
                int i5 = i4 * 2;
                BlurhashDecoder blurhashDecoder2 = INSTANCE;
                fArrDecodeAc = blurhashDecoder2.decodeAc(blurhashDecoder2.decode83(blurHash, i5 + 4, i5 + 6), fDecode83 * punch);
            }
            fArr[i4] = fArrDecodeAc;
        }
        return composeBitmap(width, height, i, i2, fArr, useCache);
    }

    static /* synthetic */ int decode83$default(BlurhashDecoder blurhashDecoder, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return blurhashDecoder.decode83(str, i, i2);
    }

    private final int decode83(String str, int from, int to) {
        int i = 0;
        while (from < to) {
            Integer num = charMap.get(Character.valueOf(str.charAt(from)));
            int iIntValue = num != null ? num.intValue() : -1;
            if (iIntValue != -1) {
                i = (i * 83) + iIntValue;
            }
            from++;
        }
        return i;
    }

    private final float[] decodeDc(int colorEnc) {
        return new float[]{BlurhashHelpers.INSTANCE.srgbToLinear(colorEnc >> 16), BlurhashHelpers.INSTANCE.srgbToLinear((colorEnc >> 8) & 255), BlurhashHelpers.INSTANCE.srgbToLinear(colorEnc & 255)};
    }

    private final float[] decodeAc(int value, float maxAc) {
        return new float[]{signedPow2(((value / 361) - 9) / 9.0f) * maxAc, signedPow2((((value / 19) % 19) - 9) / 9.0f) * maxAc, signedPow2(((value % 19) - 9) / 9.0f) * maxAc};
    }

    private final float signedPow2(float value) {
        return Math.copySign((float) Math.pow(value, 2.0f), value);
    }

    private final Bitmap composeBitmap(int width, int height, int numCompX, int numCompY, float[][] colors, boolean useCache) {
        int i = width;
        int i2 = height;
        int i3 = numCompX;
        int i4 = numCompY;
        int[] iArr = new int[i * i2];
        boolean z = (useCache && cacheCosinesX.containsKey(Integer.valueOf(i * i3))) ? false : true;
        double[] arrayForCosinesX = getArrayForCosinesX(z, i, i3);
        boolean z2 = (useCache && cacheCosinesY.containsKey(Integer.valueOf(i2 * i4))) ? false : true;
        double[] arrayForCosinesY = getArrayForCosinesY(z2, i2, i4);
        int i5 = 0;
        while (i5 < i2) {
            int i6 = 0;
            while (i6 < i) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                int i7 = 0;
                while (i7 < i4) {
                    float f4 = f3;
                    float f5 = f2;
                    float f6 = f;
                    int i8 = 0;
                    while (i8 < i3) {
                        double cos = getCos(arrayForCosinesX, z, i8, i3, i6, i);
                        int i9 = i2;
                        int i10 = i4;
                        double[] dArr = arrayForCosinesX;
                        double[] dArr2 = arrayForCosinesY;
                        int i11 = i8;
                        int i12 = i7;
                        boolean z3 = z;
                        boolean z4 = z2;
                        int i13 = i6;
                        int i14 = i5;
                        float cos2 = (float) (cos * getCos(dArr2, z4, i12, i10, i14, i9));
                        float[] fArr = colors[(i12 * numCompX) + i11];
                        f6 += fArr[0] * cos2;
                        f4 += fArr[1] * cos2;
                        f5 += fArr[2] * cos2;
                        int i15 = i11 + 1;
                        i2 = i9;
                        i = i;
                        arrayForCosinesY = dArr2;
                        i5 = i14;
                        z = z3;
                        i6 = i13;
                        i3 = numCompX;
                        z2 = z4;
                        i7 = i12;
                        i8 = i15;
                        arrayForCosinesX = dArr;
                        i4 = numCompY;
                    }
                    i2 = i2;
                    i = i;
                    f = f6;
                    z = z;
                    i6 = i6;
                    f2 = f5;
                    f3 = f4;
                    i3 = numCompX;
                    z2 = z2;
                    i7++;
                    arrayForCosinesX = arrayForCosinesX;
                    i4 = numCompY;
                }
                int i16 = i2;
                int i17 = i;
                double[] dArr3 = arrayForCosinesX;
                boolean z5 = z2;
                int i18 = i6;
                iArr[(i17 * i5) + i18] = Color.rgb(linearToSrgb(f), linearToSrgb(f3), linearToSrgb(f2));
                int i19 = i18 + 1;
                i2 = i16;
                i = i17;
                z2 = z5;
                z = z;
                i3 = numCompX;
                i6 = i19;
                arrayForCosinesX = dArr3;
                i4 = numCompY;
            }
            i5++;
            i2 = i2;
            i = i;
            arrayForCosinesX = arrayForCosinesX;
            i3 = numCompX;
            i4 = numCompY;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    private final double[] getArrayForCosinesY(boolean calculate, int height, int numCompY) {
        if (calculate) {
            int i = height * numCompY;
            double[] dArr = new double[i];
            cacheCosinesY.put(Integer.valueOf(i), dArr);
            return dArr;
        }
        double[] dArr2 = cacheCosinesY.get(Integer.valueOf(height * numCompY));
        Intrinsics.checkNotNull(dArr2);
        return dArr2;
    }

    private final double[] getArrayForCosinesX(boolean calculate, int width, int numCompX) {
        if (calculate) {
            int i = width * numCompX;
            double[] dArr = new double[i];
            cacheCosinesX.put(Integer.valueOf(i), dArr);
            return dArr;
        }
        double[] dArr2 = cacheCosinesX.get(Integer.valueOf(width * numCompX));
        Intrinsics.checkNotNull(dArr2);
        return dArr2;
    }

    private final double getCos(double[] dArr, boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            dArr[(i2 * i3) + i] = Math.cos(((((double) i3) * 3.141592653589793d) * ((double) i)) / ((double) i4));
        }
        return dArr[i + (i2 * i3)];
    }

    private final int linearToSrgb(float value) {
        float fPow;
        float f;
        float fCoerceIn = RangesKt.coerceIn(value, 0.0f, 1.0f);
        if (fCoerceIn <= 0.0031308f) {
            fPow = fCoerceIn * 12.92f;
            f = 255.0f;
        } else {
            fPow = (((float) Math.pow(fCoerceIn, 0.41666666f)) * 1.055f) - 0.055f;
            f = 255;
        }
        return (int) ((fPow * f) + 0.5f);
    }
}
