package com.reactnativekeyboardcontroller.events;

import kotlin.Metadata;

/* JADX INFO: compiled from: FocusedInputLayoutChangedEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006'"}, d2 = {"Lcom/reactnativekeyboardcontroller/events/FocusedInputLayoutChangedEventData;", "", "x", "", "y", "width", "height", "absoluteX", "absoluteY", "target", "", "parentScrollViewTarget", "<init>", "(DDDDDDII)V", "getX", "()D", "getY", "getWidth", "getHeight", "getAbsoluteX", "getAbsoluteY", "getTarget", "()I", "getParentScrollViewTarget", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FocusedInputLayoutChangedEventData {
    private final double absoluteX;
    private final double absoluteY;
    private final double height;
    private final int parentScrollViewTarget;
    private final int target;
    private final double width;
    private final double x;
    private final double y;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getAbsoluteX() {
        return this.absoluteX;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getAbsoluteY() {
        return this.absoluteY;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getParentScrollViewTarget() {
        return this.parentScrollViewTarget;
    }

    public final FocusedInputLayoutChangedEventData copy(double x, double y, double width, double height, double absoluteX, double absoluteY, int target, int parentScrollViewTarget) {
        return new FocusedInputLayoutChangedEventData(x, y, width, height, absoluteX, absoluteY, target, parentScrollViewTarget);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FocusedInputLayoutChangedEventData)) {
            return false;
        }
        FocusedInputLayoutChangedEventData focusedInputLayoutChangedEventData = (FocusedInputLayoutChangedEventData) other;
        return Double.compare(this.x, focusedInputLayoutChangedEventData.x) == 0 && Double.compare(this.y, focusedInputLayoutChangedEventData.y) == 0 && Double.compare(this.width, focusedInputLayoutChangedEventData.width) == 0 && Double.compare(this.height, focusedInputLayoutChangedEventData.height) == 0 && Double.compare(this.absoluteX, focusedInputLayoutChangedEventData.absoluteX) == 0 && Double.compare(this.absoluteY, focusedInputLayoutChangedEventData.absoluteY) == 0 && this.target == focusedInputLayoutChangedEventData.target && this.parentScrollViewTarget == focusedInputLayoutChangedEventData.parentScrollViewTarget;
    }

    public int hashCode() {
        return (((((((((((((Double.hashCode(this.x) * 31) + Double.hashCode(this.y)) * 31) + Double.hashCode(this.width)) * 31) + Double.hashCode(this.height)) * 31) + Double.hashCode(this.absoluteX)) * 31) + Double.hashCode(this.absoluteY)) * 31) + Integer.hashCode(this.target)) * 31) + Integer.hashCode(this.parentScrollViewTarget);
    }

    public String toString() {
        return "FocusedInputLayoutChangedEventData(x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", absoluteX=" + this.absoluteX + ", absoluteY=" + this.absoluteY + ", target=" + this.target + ", parentScrollViewTarget=" + this.parentScrollViewTarget + ")";
    }

    public FocusedInputLayoutChangedEventData(double d, double d2, double d3, double d4, double d5, double d6, int i, int i2) {
        this.x = d;
        this.y = d2;
        this.width = d3;
        this.height = d4;
        this.absoluteX = d5;
        this.absoluteY = d6;
        this.target = i;
        this.parentScrollViewTarget = i2;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getAbsoluteX() {
        return this.absoluteX;
    }

    public final double getAbsoluteY() {
        return this.absoluteY;
    }

    public final int getTarget() {
        return this.target;
    }

    public final int getParentScrollViewTarget() {
        return this.parentScrollViewTarget;
    }
}
