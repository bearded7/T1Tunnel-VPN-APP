package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbhashDecoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder;", "", "<init>", "()V", "thumbHashToRGBA", "Lexpo/modules/image/thumbhash/ThumbhashDecoder$Image;", "hash", "", "thumbHashToBitmap", "Landroid/graphics/Bitmap;", "thumbHashToAverageRGBA", "Lexpo/modules/image/thumbhash/ThumbhashDecoder$RGBA;", "thumbHashToApproximateAspectRatio", "", "Image", "RGBA", "Channel", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbhashDecoder {
    public static final ThumbhashDecoder INSTANCE = new ThumbhashDecoder();

    private ThumbhashDecoder() {
    }

    public final Image thumbHashToRGBA(byte[] hash) {
        int i;
        Channel channel;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(hash, "hash");
        int i5 = (hash[0] & 255) | ((hash[1] & 255) << 8) | ((hash[2] & 255) << 16);
        int i6 = (hash[3] & 255) | ((hash[4] & 255) << 8);
        float f = (i5 & 63) / 63.0f;
        float f2 = 1.0f;
        float f3 = (((i5 >> 6) & 63) / 31.5f) - 1.0f;
        float f4 = (((i5 >> 12) & 63) / 31.5f) - 1.0f;
        float f5 = ((i5 >> 18) & 31) / 31.0f;
        boolean z = (i5 >> 23) != 0;
        float f6 = ((i6 >> 3) & 63) / 63.0f;
        float f7 = ((i6 >> 9) & 63) / 63.0f;
        boolean z2 = (i6 >> 15) != 0;
        int i7 = 7;
        if (z2) {
            i = z ? 5 : 7;
        } else {
            i = i6 & 7;
        }
        int iMax = Math.max(3, i);
        if (z2) {
            i7 = 7 & i6;
        } else if (z) {
            i7 = 5;
        }
        int iMax2 = Math.max(3, i7);
        float f8 = z ? (hash[5] & Ascii.SI) / 15.0f : 1.0f;
        float f9 = ((hash[5] >> 4) & 15) / 15.0f;
        int i8 = z ? 6 : 5;
        Channel channel2 = new Channel(iMax, iMax2);
        Channel channel3 = new Channel(3, 3);
        boolean z3 = z;
        Channel channel4 = new Channel(3, 3);
        int iDecode = channel4.decode(hash, i8, channel3.decode(hash, i8, channel2.decode(hash, i8, 0, f5), f6 * 1.25f), f7 * 1.25f);
        float[] ac = null;
        if (z3) {
            channel = new Channel(5, 5);
            channel.decode(hash, i8, iDecode, f9);
        } else {
            channel = null;
        }
        float[] ac2 = channel2.getAc();
        float[] ac3 = channel3.getAc();
        float[] ac4 = channel4.getAc();
        if (z3) {
            Intrinsics.checkNotNull(channel);
            ac = channel.getAc();
        }
        float fThumbHashToApproximateAspectRatio = thumbHashToApproximateAspectRatio(hash);
        int iRound = Math.round(fThumbHashToApproximateAspectRatio > f2 ? 32.0f : fThumbHashToApproximateAspectRatio * 32.0f);
        int iRound2 = Math.round(fThumbHashToApproximateAspectRatio > f2 ? 32.0f / fThumbHashToApproximateAspectRatio : 32.0f);
        byte[] bArr = new byte[iRound * iRound2 * 4];
        int iMax3 = Math.max(iMax, z3 ? 5 : 3);
        int iMax4 = Math.max(iMax2, z3 ? 5 : 3);
        float[] fArr = new float[iMax3];
        float[] fArr2 = new float[iMax4];
        int i9 = 0;
        int i10 = 0;
        while (i9 < iRound2) {
            float[] fArr3 = ac4;
            int i11 = 0;
            while (i11 < iRound) {
                float[] fArr4 = ac2;
                int i12 = 0;
                while (i12 < iMax3) {
                    fArr[i12] = (float) Math.cos((3.141592653589793d / ((double) iRound)) * ((double) (i11 + 0.5f)) * ((double) i12));
                    i12++;
                    f = f;
                    iMax = iMax;
                }
                int i13 = iMax;
                float f10 = f;
                int i14 = 0;
                while (i14 < iMax4) {
                    fArr2[i14] = (float) Math.cos((3.141592653589793d / ((double) iRound2)) * ((double) (i9 + 0.5f)) * ((double) i14));
                    i14++;
                    i11 = i11;
                    i9 = i9;
                }
                int i15 = i9;
                int i16 = i11;
                float f11 = f10;
                int i17 = 0;
                int i18 = 0;
                while (i17 < iMax2) {
                    float f12 = fArr2[i17] * 2.0f;
                    int i19 = i17 > 0 ? 0 : 1;
                    int i20 = i17;
                    while (true) {
                        i4 = i18;
                        if (i19 * iMax2 < i13 * (iMax2 - i20)) {
                            f11 += fArr4[i4] * fArr[i19] * f12;
                            i19++;
                            i18 = i4 + 1;
                        }
                    }
                    i17 = i20 + 1;
                    i18 = i4;
                }
                float f13 = f3;
                float f14 = f4;
                int i21 = 0;
                int i22 = 0;
                while (i21 < 3) {
                    float f15 = fArr2[i21] * 2.0f;
                    int i23 = i21 > 0 ? 0 : 1;
                    while (true) {
                        i3 = i21;
                        if (i23 < 3 - i3) {
                            float f16 = fArr[i23] * f15;
                            f13 += ac3[i22] * f16;
                            f14 += fArr3[i22] * f16;
                            i23++;
                            i22++;
                            i21 = i3;
                        }
                    }
                    i21 = i3 + 1;
                }
                float f17 = f8;
                if (z3) {
                    int i24 = 0;
                    int i25 = 0;
                    while (i24 < 5) {
                        float f18 = fArr2[i24] * 2.0f;
                        int i26 = i24 > 0 ? 0 : 1;
                        while (true) {
                            i2 = i24;
                            if (i26 < 5 - i2) {
                                Intrinsics.checkNotNull(ac);
                                f17 += ac[i25] * fArr[i26] * f18;
                                i26++;
                                i25++;
                                i24 = i2;
                            }
                        }
                        i24 = i2 + 1;
                    }
                }
                float f19 = f11 - (f13 * 0.6666667f);
                float f20 = (((f11 * 3.0f) - f19) + f14) / 2.0f;
                bArr[i10] = (byte) Math.max(0, Math.round(Math.min(f2, f20) * 255.0f));
                bArr[i10 + 1] = (byte) Math.max(0, Math.round(Math.min(1.0f, f20 - f14) * 255.0f));
                bArr[i10 + 2] = (byte) Math.max(0, Math.round(Math.min(1.0f, f19) * 255.0f));
                bArr[i10 + 3] = (byte) Math.max(0, Math.round(Math.min(1.0f, f17) * 255.0f));
                i11 = i16 + 1;
                i10 += 4;
                f2 = 1.0f;
                ac2 = fArr4;
                f = f10;
                iMax = i13;
                i9 = i15;
            }
            i9++;
            ac4 = fArr3;
            ac2 = ac2;
            f = f;
        }
        return new Image(iRound, iRound2, bArr);
    }

    public final Bitmap thumbHashToBitmap(byte[] hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Image imageThumbHashToRGBA = thumbHashToRGBA(hash);
        int[] iArr = new int[imageThumbHashToRGBA.getWidth() * imageThumbHashToRGBA.getHeight()];
        byte[] rgba = imageThumbHashToRGBA.getRgba();
        ArrayList arrayList = new ArrayList(rgba.length);
        int i = 0;
        for (byte b : rgba) {
            arrayList.add(Integer.valueOf(UByte.m790constructorimpl(b) & 255));
        }
        ArrayList arrayList2 = arrayList;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, arrayList2.size() - 1, 4);
        if (progressionLastElement >= 0) {
            while (true) {
                iArr[i / 4] = Color.argb(((Number) arrayList2.get(i + 3)).intValue(), ((Number) arrayList2.get(i)).intValue(), ((Number) arrayList2.get(i + 1)).intValue(), ((Number) arrayList2.get(i + 2)).intValue());
                if (i == progressionLastElement) {
                    break;
                }
                i += 4;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, imageThumbHashToRGBA.getWidth(), imageThumbHashToRGBA.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public final RGBA thumbHashToAverageRGBA(byte[] hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        int i = (hash[0] & 255) | ((hash[1] & 255) << 8) | ((hash[2] & 255) << 16);
        float f = (i & 63) / 63.0f;
        float f2 = (((i >> 6) & 63) / 31.5f) - 1.0f;
        float f3 = (((i >> 12) & 63) / 31.5f) - 1.0f;
        float f4 = (i >> 23) != 0 ? (hash[5] & Ascii.SI) / 15.0f : 1.0f;
        float f5 = f - (f2 * 0.6666667f);
        float f6 = (((f * 3.0f) - f5) + f3) / 2.0f;
        return new RGBA(Math.max(0.0f, Math.min(1.0f, f6)), Math.max(0.0f, Math.min(1.0f, f6 - f3)), Math.max(0.0f, Math.min(1.0f, f5)), f4);
    }

    public final float thumbHashToApproximateAspectRatio(byte[] hash) {
        int i;
        Intrinsics.checkNotNullParameter(hash, "hash");
        byte b = hash[3];
        boolean z = (hash[2] & 128) != 0;
        boolean z2 = (hash[4] & 128) != 0;
        int i2 = 5;
        if (z2) {
            i = z ? 5 : 7;
        } else {
            i = b & 7;
        }
        if (z2) {
            i2 = b & 7;
        } else if (!z) {
            i2 = 7;
        }
        return i / i2;
    }

    /* JADX INFO: compiled from: ThumbhashDecoder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$Image;", "", "width", "", "height", "rgba", "", "<init>", "(II[B)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getRgba", "()[B", "setRgba", "([B)V", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Image {
        private int height;
        private byte[] rgba;
        private int width;

        public Image(int i, int i2, byte[] rgba) {
            Intrinsics.checkNotNullParameter(rgba, "rgba");
            this.width = i;
            this.height = i2;
            this.rgba = rgba;
        }

        public final int getHeight() {
            return this.height;
        }

        public final byte[] getRgba() {
            return this.rgba;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setHeight(int i) {
            this.height = i;
        }

        public final void setRgba(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.rgba = bArr;
        }

        public final void setWidth(int i) {
            this.width = i;
        }
    }

    /* JADX INFO: compiled from: ThumbhashDecoder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$RGBA;", "", "r", "", "g", "b", "a", "<init>", "(FFFF)V", "getR", "()F", "setR", "(F)V", "getG", "setG", "getB", "setB", "getA", "setA", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RGBA {
        private float a;
        private float b;
        private float g;
        private float r;

        public RGBA(float f, float f2, float f3, float f4) {
            this.r = f;
            this.g = f2;
            this.b = f3;
            this.a = f4;
        }

        public final float getA() {
            return this.a;
        }

        public final float getB() {
            return this.b;
        }

        public final float getG() {
            return this.g;
        }

        public final float getR() {
            return this.r;
        }

        public final void setA(float f) {
            this.a = f;
        }

        public final void setB(float f) {
            this.b = f;
        }

        public final void setG(float f) {
            this.g = f;
        }

        public final void setR(float f) {
            this.r = f;
        }
    }

    /* JADX INFO: compiled from: ThumbhashDecoder.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecoder$Channel;", "", "nx", "", "ny", "<init>", "(II)V", "ac", "", "getAc", "()[F", "setAc", "([F)V", "decode", "hash", "", ViewProps.START, "index", "scale", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Channel {
        private float[] ac;

        public Channel(int i, int i2) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                for (int i5 = i3 > 0 ? 0 : 1; i5 * i2 < (i2 - i3) * i; i5++) {
                    i4++;
                }
                i3++;
            }
            this.ac = new float[i4];
        }

        public final float[] getAc() {
            return this.ac;
        }

        public final void setAc(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.ac = fArr;
        }

        public final int decode(byte[] hash, int start, int index, float scale) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            int length = this.ac.length;
            for (int i = 0; i < length; i++) {
                this.ac[i] = ((((hash[(index >> 1) + start] >> ((index & 1) << 2)) & 15) / 7.5f) - 1.0f) * scale;
                index++;
            }
            return index;
        }
    }
}
