package expo.modules.kotlin.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: EventName.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/events/EventName;", "", "<init>", "(Ljava/lang/String;I)V", "MODULE_CREATE", "MODULE_DESTROY", "ACTIVITY_ENTERS_FOREGROUND", "ACTIVITY_ENTERS_BACKGROUND", "ACTIVITY_DESTROYS", "ON_NEW_INTENT", "ON_ACTIVITY_RESULT", "ON_USER_LEAVES_ACTIVITY", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum EventName {
    MODULE_CREATE,
    MODULE_DESTROY,
    ACTIVITY_ENTERS_FOREGROUND,
    ACTIVITY_ENTERS_BACKGROUND,
    ACTIVITY_DESTROYS,
    ON_NEW_INTENT,
    ON_ACTIVITY_RESULT,
    ON_USER_LEAVES_ACTIVITY;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<EventName> getEntries() {
        return $ENTRIES;
    }
}
