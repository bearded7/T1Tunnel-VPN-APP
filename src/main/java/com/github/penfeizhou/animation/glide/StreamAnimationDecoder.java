package com.github.penfeizhou.animation.glide;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.github.penfeizhou.animation.apng.decode.APNGParser;
import com.github.penfeizhou.animation.avif.decode.AVIFParser;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.decode.GifParser;
import com.github.penfeizhou.animation.io.StreamReader;
import com.github.penfeizhou.animation.webp.decode.WebPParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class StreamAnimationDecoder implements ResourceDecoder<InputStream, FrameSeqDecoder> {
    private final ResourceDecoder<ByteBuffer, FrameSeqDecoder> byteBufferDecoder;

    public StreamAnimationDecoder(ResourceDecoder<ByteBuffer, FrameSeqDecoder> resourceDecoder) {
        this.byteBufferDecoder = resourceDecoder;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream inputStream, Options options) {
        if (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_WEBP_DECODER)).booleanValue() && WebPParser.isAWebP(new StreamReader(inputStream))) {
            return true;
        }
        if (!((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_APNG_DECODER)).booleanValue() && APNGParser.isAPNG(new StreamReader(inputStream))) {
            return true;
        }
        if (((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_GIF_DECODER)).booleanValue() || !GifParser.isGif(new StreamReader(inputStream))) {
            return !((Boolean) options.get(AnimationDecoderOption.DISABLE_ANIMATION_AVIF_DECODER)).booleanValue() && AVIFParser.isAVIF(new StreamReader(inputStream));
        }
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<FrameSeqDecoder> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        byte[] bArrInputStreamToBytes = inputStreamToBytes(inputStream);
        if (bArrInputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(ByteBuffer.wrap(bArrInputStreamToBytes), i, i2, options);
    }

    private static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
