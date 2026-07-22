package com.github.penfeizhou.animation.loader;

import com.github.penfeizhou.animation.io.Reader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Loader {
    Reader obtain() throws IOException;
}
