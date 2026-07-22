package com.facebook.soloader;

/* JADX INFO: loaded from: classes2.dex */
public interface SoFileLoader {
    void load(String str, int i);

    void loadBytes(String str, ElfByteChannel elfByteChannel, int i);
}
