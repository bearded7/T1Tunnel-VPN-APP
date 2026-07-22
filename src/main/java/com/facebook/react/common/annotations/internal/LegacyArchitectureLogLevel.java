package com.facebook.react.common.annotations.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: LegacyArchitectureLogLevel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/common/annotations/internal/LegacyArchitectureLogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum LegacyArchitectureLogLevel {
    WARNING,
    ERROR;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<LegacyArchitectureLogLevel> getEntries() {
        return $ENTRIES;
    }
}
