package com.github.penfeizhou.animation.avif.io;

import com.github.penfeizhou.animation.io.FilterReader;
import com.github.penfeizhou.animation.io.Reader;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class AVIFReader extends FilterReader {
    private ByteBuffer cachedBuffer;

    public AVIFReader(Reader reader) {
        super(reader);
        this.cachedBuffer = null;
    }

    public ByteBuffer toDirectByteBuffer() throws IOException {
        if (this.cachedBuffer == null) {
            int iAvailable = available();
            byte[] bArr = new byte[iAvailable];
            read(bArr, 0, iAvailable);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iAvailable);
            this.cachedBuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.put(bArr);
        }
        this.cachedBuffer.flip();
        return this.cachedBuffer;
    }
}
