package com.facebook.react.views.text;

import android.text.Layout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreparedLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/views/text/PreparedLayout;", "", "layout", "Landroid/text/Layout;", "maximumNumberOfLines", "", "verticalOffset", "", "<init>", "(Landroid/text/Layout;IF)V", "getLayout", "()Landroid/text/Layout;", "getMaximumNumberOfLines", "()I", "getVerticalOffset", "()F", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreparedLayout {
    private final Layout layout;
    private final int maximumNumberOfLines;
    private final float verticalOffset;

    public PreparedLayout(Layout layout, int i, float f) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
        this.maximumNumberOfLines = i;
        this.verticalOffset = f;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final int getMaximumNumberOfLines() {
        return this.maximumNumberOfLines;
    }

    public final float getVerticalOffset() {
        return this.verticalOffset;
    }
}
