package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationArguments.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB\u001f\b\u0016\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0004\b\n\u0010\u0010R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001c\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010'\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006("}, d2 = {"Lexpo/modules/location/records/LocationOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "accuracy", "", "distanceInterval", "mayShowUserSettingsDialog", "", "timeInterval", "", "<init>", "(ILjava/lang/Integer;ZLjava/lang/Long;)V", "map", "", "", "", "(Ljava/util/Map;)V", "getAccuracy$annotations", "()V", "getAccuracy", "()I", "setAccuracy", "(I)V", "getDistanceInterval$annotations", "getDistanceInterval", "()Ljava/lang/Integer;", "setDistanceInterval", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMayShowUserSettingsDialog$annotations", "getMayShowUserSettingsDialog", "()Z", "setMayShowUserSettingsDialog", "(Z)V", "getTimeInterval$annotations", "getTimeInterval", "()Ljava/lang/Long;", "setTimeInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LocationOptions implements Record, Serializable {
    private int accuracy;
    private Integer distanceInterval;
    private boolean mayShowUserSettingsDialog;
    private Long timeInterval;

    public LocationOptions() {
        this(0, null, false, null, 15, null);
    }

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getDistanceInterval$annotations() {
    }

    @Field
    public static /* synthetic */ void getMayShowUserSettingsDialog$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeInterval$annotations() {
    }

    public LocationOptions(int i, Integer num, boolean z, Long l) {
        this.accuracy = i;
        this.distanceInterval = num;
        this.mayShowUserSettingsDialog = z;
        this.timeInterval = l;
    }

    public /* synthetic */ LocationOptions(int i, Integer num, boolean z, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : l);
    }

    public final int getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(int i) {
        this.accuracy = i;
    }

    public final Integer getDistanceInterval() {
        return this.distanceInterval;
    }

    public final void setDistanceInterval(Integer num) {
        this.distanceInterval = num;
    }

    public final boolean getMayShowUserSettingsDialog() {
        return this.mayShowUserSettingsDialog;
    }

    public final void setMayShowUserSettingsDialog(boolean z) {
        this.mayShowUserSettingsDialog = z;
    }

    public final Long getTimeInterval() {
        return this.timeInterval;
    }

    public final void setTimeInterval(Long l) {
        this.timeInterval = l;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LocationOptions(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Object obj = map.get("accuracy");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 3;
        Object obj2 = map.get("distanceInterval");
        Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
        Object obj3 = map.get("mayShowUserSettingsDialog");
        Boolean bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
        Object obj4 = map.get("timeInterval");
        this(iIntValue, num2, zBooleanValue, obj4 instanceof Long ? (Long) obj4 : null);
    }
}
