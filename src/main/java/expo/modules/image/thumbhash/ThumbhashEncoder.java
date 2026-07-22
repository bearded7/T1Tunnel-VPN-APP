package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbhashEncoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashEncoder;", "", "<init>", "()V", "encode", "", "bitmap", "Landroid/graphics/Bitmap;", "resizeKeepingAspectRatio", "maxSize", "", "Channel", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbhashEncoder {
    public static final ThumbhashEncoder INSTANCE = new ThumbhashEncoder();

    private ThumbhashEncoder() {
    }

    public final byte[] encode(Bitmap bitmap) {
        int length;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap bitmapResizeKeepingAspectRatio = resizeKeepingAspectRatio(bitmap, 100);
        int width = bitmapResizeKeepingAspectRatio.getWidth();
        int height = bitmapResizeKeepingAspectRatio.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmapResizeKeepingAspectRatio.getPixels(iArr, 0, width, 0, 0, width, height);
        float f = 0.0f;
        float fRed = 0.0f;
        float fGreen = 0.0f;
        float fBlue = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            float fAlpha = Color.alpha(iArr[i2]) / 255.0f;
            float f2 = fAlpha / 255.0f;
            fRed += Color.red(iArr[i2]) * f2;
            fGreen += Color.green(iArr[i2]) * f2;
            fBlue += f2 * Color.blue(iArr[i2]);
            f += fAlpha;
        }
        if (f > 0.0f) {
            fRed /= f;
            fGreen /= f;
            fBlue /= f;
        }
        boolean z = f < ((float) i);
        int i3 = z ? 5 : 7;
        int iMax = Math.max(1, Math.round((i3 * width) / Math.max(width, height)));
        int iMax2 = Math.max(1, Math.round((i3 * height) / Math.max(width, height)));
        float[] fArr = new float[i];
        float[] fArr2 = new float[i];
        float[] fArr3 = new float[i];
        float[] fArr4 = new float[i];
        int i4 = 0;
        while (i4 < i) {
            int i5 = i;
            float fAlpha2 = (Color.alpha(iArr[i4]) & 255) / 255.0f;
            float f3 = 1.0f - fAlpha2;
            float f4 = fAlpha2 / 255.0f;
            float fRed2 = (fRed * f3) + (Color.red(iArr[i4]) * f4);
            float fGreen2 = (fGreen * f3) + (Color.green(iArr[i4]) * f4);
            float fBlue2 = (f3 * fBlue) + (f4 * Color.blue(iArr[i4]));
            float f5 = fRed2 + fGreen2;
            fArr[i4] = (f5 + fBlue2) / 3.0f;
            fArr2[i4] = (f5 / 2.0f) - fBlue2;
            fArr3[i4] = fRed2 - fGreen2;
            fArr4[i4] = fAlpha2;
            i4++;
            i = i5;
        }
        Channel channelEncode = new Channel(Math.max(3, iMax), Math.max(3, iMax2)).encode(width, height, fArr);
        Channel channelEncode2 = new Channel(3, 3).encode(width, height, fArr2);
        Channel channelEncode3 = new Channel(3, 3).encode(width, height, fArr3);
        Channel channelEncode4 = z ? new Channel(5, 5).encode(width, height, fArr4) : null;
        boolean z2 = width > height;
        int iRound = Math.round(channelEncode.getDc() * 63.0f) | (Math.round((channelEncode2.getDc() * 31.5f) + 31.5f) << 6) | (Math.round((channelEncode3.getDc() * 31.5f) + 31.5f) << 12) | (Math.round(channelEncode.getScale() * 31.0f) << 18) | (z ? 8388608 : 0);
        if (z2) {
            iMax = iMax2;
        }
        int iRound2 = (z2 ? 32768 : 0) | (Math.round(channelEncode3.getScale() * 63.0f) << 9) | (Math.round(channelEncode2.getScale() * 63.0f) << 3) | iMax;
        int i6 = z ? 6 : 5;
        int length2 = channelEncode.getAc().length + channelEncode2.getAc().length + channelEncode3.getAc().length;
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            length = channelEncode4.getAc().length;
        } else {
            length = 0;
        }
        byte[] bArr = new byte[(((length2 + length) + 1) / 2) + i6];
        bArr[0] = (byte) iRound;
        bArr[1] = (byte) (iRound >> 8);
        bArr[2] = (byte) (iRound >> 16);
        bArr[3] = (byte) iRound2;
        bArr[4] = (byte) (iRound2 >> 8);
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            bArr[5] = (byte) (Math.round(channelEncode4.getDc() * 15.0f) | (Math.round(channelEncode4.getScale() * 15.0f) << 4));
        }
        int iWriteTo = channelEncode3.writeTo(bArr, i6, channelEncode2.writeTo(bArr, i6, channelEncode.writeTo(bArr, i6, 0)));
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            channelEncode4.writeTo(bArr, i6, iWriteTo);
        }
        return bArr;
    }

    private final Bitmap resizeKeepingAspectRatio(Bitmap bitmap, int maxSize) {
        int i;
        float width = bitmap.getWidth() / bitmap.getHeight();
        if (width > 1.0f) {
            i = (int) (maxSize / width);
        } else {
            int i2 = (int) (maxSize * width);
            i = maxSize;
            maxSize = i2;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, maxSize, i, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    /* JADX INFO: compiled from: ThumbhashEncoder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0014J\u001e\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006%"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashEncoder$Channel;", "", "nx", "", "ny", "<init>", "(II)V", "getNx", "()I", "setNx", "(I)V", "getNy", "setNy", "dc", "", "getDc", "()F", "setDc", "(F)V", "ac", "", "getAc", "()[F", "setAc", "([F)V", "scale", "getScale", "setScale", "encode", "w", "h", "channel", "writeTo", "hash", "", ViewProps.START, "index", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Channel {
        private float[] ac;
        private float dc;
        private int nx;
        private int ny;
        private float scale;

        public Channel(int i, int i2) {
            this.nx = i;
            this.ny = i2;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i3 > 0 ? 0 : 1;
                while (true) {
                    int i6 = this.ny;
                    if (i5 * i6 < this.nx * (i6 - i3)) {
                        i4++;
                        i5++;
                    }
                }
                i3++;
            }
            this.ac = new float[i4];
        }

        public final int getNx() {
            return this.nx;
        }

        public final int getNy() {
            return this.ny;
        }

        public final void setNx(int i) {
            this.nx = i;
        }

        public final void setNy(int i) {
            this.ny = i;
        }

        public final float getDc() {
            return this.dc;
        }

        public final void setDc(float f) {
            this.dc = f;
        }

        public final float[] getAc() {
            return this.ac;
        }

        public final void setAc(float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.ac = fArr;
        }

        public final float getScale() {
            return this.scale;
        }

        public final void setScale(float f) {
            this.scale = f;
        }

        public final Channel encode(int w, int h, float[] channel) {
            double d;
            Intrinsics.checkNotNullParameter(channel, "channel");
            float[] fArr = new float[w];
            int i = this.ny;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = 0;
                while (true) {
                    int i5 = this.ny;
                    if (i4 * i5 < this.nx * (i5 - i3)) {
                        int i6 = 0;
                        while (true) {
                            d = 3.141592653589793d;
                            if (i6 >= w) {
                                break;
                            }
                            fArr[i6] = (float) Math.cos((3.141592653589793d / ((double) w)) * ((double) i4) * ((double) (i6 + 0.5f)));
                            i6++;
                        }
                        int i7 = 0;
                        float f = 0.0f;
                        while (i7 < h) {
                            double d2 = d;
                            float fCos = (float) Math.cos((d2 / ((double) h)) * ((double) i3) * ((double) (i7 + 0.5f)));
                            for (int i8 = 0; i8 < w; i8++) {
                                f += channel[(i7 * w) + i8] * fArr[i8] * fCos;
                            }
                            i7++;
                            h = h;
                            d = d2;
                        }
                        float f2 = f / (w * h);
                        if (i4 > 0 || i3 > 0) {
                            this.ac[i2] = f2;
                            this.scale = Math.max(this.scale, Math.abs(f2));
                            i2++;
                        } else {
                            this.dc = f2;
                        }
                        i4++;
                        h = h;
                    }
                }
            }
            if (this.scale > 0.0f) {
                int length = this.ac.length;
                for (int i9 = 0; i9 < length; i9++) {
                    float[] fArr2 = this.ac;
                    fArr2[i9] = ((0.5f / this.scale) * fArr2[i9]) + 0.5f;
                }
            }
            return this;
        }

        public final int writeTo(byte[] hash, int start, int index) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            for (float f : this.ac) {
                int i = (index >> 1) + start;
                hash[i] = (byte) ((Math.round(f * 15.0f) << ((index & 1) << 2)) | hash[i]);
                index++;
            }
            return index;
        }
    }
}
