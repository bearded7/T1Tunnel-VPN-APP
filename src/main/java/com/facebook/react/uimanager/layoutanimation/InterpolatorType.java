package com.facebook.react.uimanager.layoutanimation;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterpolatorType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;", "", "<init>", "(Ljava/lang/String;I)V", "LINEAR", "EASE_IN", "EASE_OUT", "EASE_IN_EASE_OUT", "SPRING", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum InterpolatorType {
    LINEAR,
    EASE_IN,
    EASE_OUT,
    EASE_IN_EASE_OUT,
    SPRING;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final InterpolatorType fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<InterpolatorType> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: InterpolatorType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType$Companion;", "", "<init>", "()V", "fromString", "Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;", "name", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        public final InterpolatorType fromString(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            String lowerCase = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1965056864:
                    if (lowerCase.equals("easeout")) {
                        return InterpolatorType.EASE_OUT;
                    }
                    break;
                case -1310315117:
                    if (lowerCase.equals("easein")) {
                        return InterpolatorType.EASE_IN;
                    }
                    break;
                case -1102672091:
                    if (lowerCase.equals("linear")) {
                        return InterpolatorType.LINEAR;
                    }
                    break;
                case -895679987:
                    if (lowerCase.equals("spring")) {
                        return InterpolatorType.SPRING;
                    }
                    break;
                case 1164546989:
                    if (lowerCase.equals("easeineaseout")) {
                        return InterpolatorType.EASE_IN_EASE_OUT;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported interpolation type : " + name);
        }
    }
}
