package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import com.github.penfeizhou.animation.webp.io.WebPWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class StillFrame extends Frame<WebPReader, WebPWriter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public StillFrame(WebPReader webPReader, int i, int i2) {
        super(webPReader);
        this.frameWidth = i;
        this.frameHeight = i2;
    }

    @Override // com.github.penfeizhou.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, WebPWriter webPWriter) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((WebPReader) this.reader).toInputStream(), null, options);
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = i;
            options2.inMutable = true;
            bitmapDecodeStream = BitmapFactory.decodeStream(((WebPReader) this.reader).toInputStream(), null, options2);
        }
        try {
            paint.setXfermode(null);
            canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
            return bitmapDecodeStream;
        } catch (IOException e3) {
            e = e3;
            bitmap2 = bitmapDecodeStream;
            e.printStackTrace();
            return bitmap2;
        }
    }
}
