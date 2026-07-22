package com.reactnativekeyboardcontroller.views;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgeToEdgeReactViewGroup.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeViewRegistry;", "", "<init>", "()V", "lastCreatedView", "Ljava/lang/ref/WeakReference;", "Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeReactViewGroup;", "register", "", "view", "get", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EdgeToEdgeViewRegistry {
    public static final EdgeToEdgeViewRegistry INSTANCE = new EdgeToEdgeViewRegistry();
    private static WeakReference<EdgeToEdgeReactViewGroup> lastCreatedView;

    private EdgeToEdgeViewRegistry() {
    }

    public final void register(EdgeToEdgeReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        lastCreatedView = new WeakReference<>(view);
    }

    public final EdgeToEdgeReactViewGroup get() {
        WeakReference<EdgeToEdgeReactViewGroup> weakReference = lastCreatedView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
