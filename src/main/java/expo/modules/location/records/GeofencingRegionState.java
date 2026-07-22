package expo.modules.location.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: LocationArguments.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/location/records/GeofencingRegionState;", "Lexpo/modules/kotlin/types/Enumerable;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INSIDE", "OUTSIDE", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum GeofencingRegionState implements Enumerable {
    UNKNOWN,
    INSIDE,
    OUTSIDE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<GeofencingRegionState> getEntries() {
        return $ENTRIES;
    }
}
