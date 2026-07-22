package com.google.common.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str) throws IOException;
}
