package com.github.penfeizhou.animation.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Writer {
    void close() throws IOException;

    int position();

    void putByte(byte b);

    void putBytes(byte[] bArr);

    void reset(int i);

    void skip(int i);

    byte[] toByteArray();
}
