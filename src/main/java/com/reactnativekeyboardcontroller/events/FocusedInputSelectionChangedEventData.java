package com.reactnativekeyboardcontroller.events;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: FocusedInputSelectionChangedEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/reactnativekeyboardcontroller/events/FocusedInputSelectionChangedEventData;", "", "target", "", "startX", "", "startY", "endX", "endY", ViewProps.START, ViewProps.END, "<init>", "(IDDDDII)V", "getTarget", "()I", "getStartX", "()D", "getStartY", "getEndX", "getEndY", "getStart", "getEnd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FocusedInputSelectionChangedEventData {
    private final int end;
    private final double endX;
    private final double endY;
    private final int start;
    private final double startX;
    private final double startY;
    private final int target;

    public static /* synthetic */ FocusedInputSelectionChangedEventData copy$default(FocusedInputSelectionChangedEventData focusedInputSelectionChangedEventData, int i, double d, double d2, double d3, double d4, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = focusedInputSelectionChangedEventData.target;
        }
        if ((i4 & 2) != 0) {
            d = focusedInputSelectionChangedEventData.startX;
        }
        if ((i4 & 4) != 0) {
            d2 = focusedInputSelectionChangedEventData.startY;
        }
        if ((i4 & 8) != 0) {
            d3 = focusedInputSelectionChangedEventData.endX;
        }
        if ((i4 & 16) != 0) {
            d4 = focusedInputSelectionChangedEventData.endY;
        }
        if ((i4 & 32) != 0) {
            i2 = focusedInputSelectionChangedEventData.start;
        }
        if ((i4 & 64) != 0) {
            i3 = focusedInputSelectionChangedEventData.end;
        }
        double d5 = d4;
        double d6 = d3;
        double d7 = d2;
        return focusedInputSelectionChangedEventData.copy(i, d, d7, d6, d5, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getStartX() {
        return this.startX;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getStartY() {
        return this.startY;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getEndX() {
        return this.endX;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getEndY() {
        return this.endY;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    public final FocusedInputSelectionChangedEventData copy(int target, double startX, double startY, double endX, double endY, int start, int end) {
        return new FocusedInputSelectionChangedEventData(target, startX, startY, endX, endY, start, end);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FocusedInputSelectionChangedEventData)) {
            return false;
        }
        FocusedInputSelectionChangedEventData focusedInputSelectionChangedEventData = (FocusedInputSelectionChangedEventData) other;
        return this.target == focusedInputSelectionChangedEventData.target && Double.compare(this.startX, focusedInputSelectionChangedEventData.startX) == 0 && Double.compare(this.startY, focusedInputSelectionChangedEventData.startY) == 0 && Double.compare(this.endX, focusedInputSelectionChangedEventData.endX) == 0 && Double.compare(this.endY, focusedInputSelectionChangedEventData.endY) == 0 && this.start == focusedInputSelectionChangedEventData.start && this.end == focusedInputSelectionChangedEventData.end;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.target) * 31) + Double.hashCode(this.startX)) * 31) + Double.hashCode(this.startY)) * 31) + Double.hashCode(this.endX)) * 31) + Double.hashCode(this.endY)) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end);
    }

    public String toString() {
        return "FocusedInputSelectionChangedEventData(target=" + this.target + ", startX=" + this.startX + ", startY=" + this.startY + ", endX=" + this.endX + ", endY=" + this.endY + ", start=" + this.start + ", end=" + this.end + ")";
    }

    public FocusedInputSelectionChangedEventData(int i, double d, double d2, double d3, double d4, int i2, int i3) {
        this.target = i;
        this.startX = d;
        this.startY = d2;
        this.endX = d3;
        this.endY = d4;
        this.start = i2;
        this.end = i3;
    }

    public final int getTarget() {
        return this.target;
    }

    public final double getStartX() {
        return this.startX;
    }

    public final double getStartY() {
        return this.startY;
    }

    public final double getEndX() {
        return this.endX;
    }

    public final double getEndY() {
        return this.endY;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }
}
