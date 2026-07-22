package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ByteProcessor<T> {
    T getResult();

    boolean processBytes(byte[] bArr, int i, int i2) throws IOException;
}
