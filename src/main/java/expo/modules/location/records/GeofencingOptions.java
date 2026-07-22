package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationArguments.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0000¢\u0006\u0002\b\u0011R*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007¨\u0006\u0012"}, d2 = {"Lexpo/modules/location/records/GeofencingOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "regions", "", "Lexpo/modules/location/records/Region;", "<init>", "(Ljava/util/List;)V", "getRegions$annotations", "()V", "getRegions", "()Ljava/util/List;", "setRegions", "toMap", "", "", "", "toMap$expo_location_release", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeofencingOptions implements Record, Serializable {
    private List<Region> regions;

    @Field
    public static /* synthetic */ void getRegions$annotations() {
    }

    public GeofencingOptions(List<Region> regions) {
        Intrinsics.checkNotNullParameter(regions, "regions");
        this.regions = regions;
    }

    public final List<Region> getRegions() {
        return this.regions;
    }

    public final void setRegions(List<Region> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.regions = list;
    }

    public final Map<String, Object> toMap$expo_location_release() {
        List<Region> list = this.regions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Region) it.next()).toMap$expo_location_release());
        }
        return MapsKt.mapOf(TuplesKt.to("regions", arrayList));
    }
}
