package com.facebook.react.uimanager.layoutanimation;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedPropertyType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/AnimatedPropertyType;", "", "<init>", "(Ljava/lang/String;I)V", "OPACITY", "SCALE_X", "SCALE_Y", "SCALE_XY", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AnimatedPropertyType {
    OPACITY,
    SCALE_X,
    SCALE_Y,
    SCALE_XY;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final AnimatedPropertyType fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<AnimatedPropertyType> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: AnimatedPropertyType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/AnimatedPropertyType$Companion;", "", "<init>", "()V", "fromString", "Lcom/facebook/react/uimanager/layoutanimation/AnimatedPropertyType;", "name", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        public final AnimatedPropertyType fromString(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            switch (name.hashCode()) {
                case -1267206133:
                    if (name.equals(ViewProps.OPACITY)) {
                        return AnimatedPropertyType.OPACITY;
                    }
                    break;
                case -908189618:
                    if (name.equals(ViewProps.SCALE_X)) {
                        return AnimatedPropertyType.SCALE_X;
                    }
                    break;
                case -908189617:
                    if (name.equals(ViewProps.SCALE_Y)) {
                        return AnimatedPropertyType.SCALE_Y;
                    }
                    break;
                case 1910893003:
                    if (name.equals("scaleXY")) {
                        return AnimatedPropertyType.SCALE_XY;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported animated property: " + name);
        }
    }
}
