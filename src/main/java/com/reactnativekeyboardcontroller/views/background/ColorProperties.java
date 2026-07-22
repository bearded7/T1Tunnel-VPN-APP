package com.reactnativekeyboardcontroller.views.background;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Skins.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/background/ColorProperties;", "", ViewProps.COLOR, "", "tone", "<init>", "(II)V", "getColor", "()I", "getTone", "blend", "getBlend", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ColorProperties {
    private final int color;
    private final int tone;

    public static /* synthetic */ ColorProperties copy$default(ColorProperties colorProperties, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = colorProperties.color;
        }
        if ((i3 & 2) != 0) {
            i2 = colorProperties.tone;
        }
        return colorProperties.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTone() {
        return this.tone;
    }

    public final ColorProperties copy(int color, int tone) {
        return new ColorProperties(color, tone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorProperties)) {
            return false;
        }
        ColorProperties colorProperties = (ColorProperties) other;
        return this.color == colorProperties.color && this.tone == colorProperties.tone;
    }

    public int hashCode() {
        return (Integer.hashCode(this.color) * 31) + Integer.hashCode(this.tone);
    }

    public String toString() {
        return "ColorProperties(color=" + this.color + ", tone=" + this.tone + ")";
    }

    public ColorProperties(int i, int i2) {
        this.color = i;
        this.tone = i2;
    }

    public /* synthetic */ ColorProperties(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getColor() {
        return this.color;
    }

    public final int getTone() {
        return this.tone;
    }

    public final int getBlend() {
        return SkinsKt.shiftRgbChannels(this.color, this.tone);
    }
}
