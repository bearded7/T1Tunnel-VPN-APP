package com.reactnativekeyboardcontroller.listeners;

import kotlin.Metadata;

/* JADX INFO: compiled from: WindowDimensionListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/reactnativekeyboardcontroller/listeners/Dimensions;", "", "width", "", "height", "<init>", "(DD)V", "getWidth", "()D", "getHeight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Dimensions {
    private final double height;
    private final double width;

    public static /* synthetic */ Dimensions copy$default(Dimensions dimensions, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = dimensions.width;
        }
        if ((i & 2) != 0) {
            d2 = dimensions.height;
        }
        return dimensions.copy(d, d2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    public final Dimensions copy(double width, double height) {
        return new Dimensions(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Dimensions)) {
            return false;
        }
        Dimensions dimensions = (Dimensions) other;
        return Double.compare(this.width, dimensions.width) == 0 && Double.compare(this.height, dimensions.height) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.width) * 31) + Double.hashCode(this.height);
    }

    public String toString() {
        return "Dimensions(width=" + this.width + ", height=" + this.height + ")";
    }

    public Dimensions(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }
}
