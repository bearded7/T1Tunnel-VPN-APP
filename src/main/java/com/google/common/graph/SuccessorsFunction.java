package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
public interface SuccessorsFunction<N> {
    Iterable<? extends N> successors(N n);
}
