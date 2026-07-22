package com.github.penfeizhou.animation.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.penfeizhou.animation.apng.io.APNGReader;
import com.github.penfeizhou.animation.apng.io.APNGWriter;
import com.github.penfeizhou.animation.decode.Frame;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes2.dex */
public class APNGFrame extends Frame<APNGReader, APNGWriter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final byte blend_op;
    public final byte dispose_op;
    byte[] ihdrData;
    List<Chunk> imageChunks;
    List<Chunk> prefixChunks;
    private static final byte[] sPNGSignatures = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    private static final byte[] sPNGEndChunk = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final ThreadLocal<CRC32> sCRC32 = new ThreadLocal<>();

    private CRC32 getCRC32() {
        ThreadLocal<CRC32> threadLocal = sCRC32;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc33 = new CRC32();
        threadLocal.set(crc33);
        return crc33;
    }

    public APNGFrame(APNGReader aPNGReader, FCTLChunk fCTLChunk) {
        super(aPNGReader);
        this.imageChunks = new ArrayList();
        this.prefixChunks = new ArrayList();
        this.blend_op = fCTLChunk.blend_op;
        this.dispose_op = fCTLChunk.dispose_op;
        this.frameDuration = (fCTLChunk.delay_num * 1000) / (fCTLChunk.delay_den == 0 ? (short) 100 : fCTLChunk.delay_den);
        if (this.frameDuration < 10) {
            this.frameDuration = 100;
        }
        this.frameWidth = fCTLChunk.width;
        this.frameHeight = fCTLChunk.height;
        this.frameX = fCTLChunk.x_offset;
        this.frameY = fCTLChunk.y_offset;
    }

    private int encode(APNGWriter aPNGWriter) throws IOException {
        int i;
        Iterator<Chunk> it = this.prefixChunks.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().length + 12;
        }
        for (Chunk chunk : this.imageChunks) {
            if (chunk instanceof IDATChunk) {
                i = chunk.length + 12;
            } else if (chunk instanceof FDATChunk) {
                i = chunk.length + 8;
            }
            i2 += i;
        }
        int length = i2 + sPNGEndChunk.length;
        aPNGWriter.reset(length);
        aPNGWriter.putBytes(sPNGSignatures);
        aPNGWriter.writeInt(13);
        int iPosition = aPNGWriter.position();
        aPNGWriter.writeFourCC(IHDRChunk.ID);
        aPNGWriter.writeInt(this.frameWidth);
        aPNGWriter.writeInt(this.frameHeight);
        aPNGWriter.putBytes(this.ihdrData);
        CRC32 crc32 = getCRC32();
        crc32.reset();
        crc32.update(aPNGWriter.toByteArray(), iPosition, 17);
        aPNGWriter.writeInt((int) crc32.getValue());
        for (Chunk chunk2 : this.prefixChunks) {
            if (!(chunk2 instanceof IENDChunk)) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk2.offset);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk2.length + 12);
                aPNGWriter.skip(chunk2.length + 12);
            }
        }
        for (Chunk chunk3 : this.imageChunks) {
            if (chunk3 instanceof IDATChunk) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk3.offset);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk3.length + 12);
                aPNGWriter.skip(chunk3.length + 12);
            } else if (chunk3 instanceof FDATChunk) {
                aPNGWriter.writeInt(chunk3.length - 4);
                int iPosition2 = aPNGWriter.position();
                aPNGWriter.writeFourCC(IDATChunk.ID);
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk3.offset + 12);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk3.length - 4);
                aPNGWriter.skip(chunk3.length - 4);
                crc32.reset();
                crc32.update(aPNGWriter.toByteArray(), iPosition2, chunk3.length);
                aPNGWriter.writeInt((int) crc32.getValue());
            }
        }
        aPNGWriter.putBytes(sPNGEndChunk);
        return length;
    }

    @Override // com.github.penfeizhou.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, APNGWriter aPNGWriter) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iEncode = encode(aPNGWriter);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] byteArray = aPNGWriter.toByteArray();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, iEncode, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, iEncode, options2);
            }
            this.srcRect.left = 0;
            this.srcRect.top = 0;
            this.srcRect.right = bitmapDecodeByteArray.getWidth();
            this.srcRect.bottom = bitmapDecodeByteArray.getHeight();
            float f = i;
            this.dstRect.left = (int) (this.frameX / f);
            this.dstRect.top = (int) (this.frameY / f);
            this.dstRect.right = (int) ((this.frameX / f) + bitmapDecodeByteArray.getWidth());
            this.dstRect.bottom = (int) ((this.frameY / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.srcRect, this.dstRect, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
