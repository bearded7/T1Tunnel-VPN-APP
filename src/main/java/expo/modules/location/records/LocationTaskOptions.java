package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LocationArguments.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001dH\u0000¢\u0006\u0002\b R(\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR(\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0010\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lexpo/modules/location/records/LocationTaskOptions;", "Lexpo/modules/location/records/LocationOptions;", "deferredUpdatesDistance", "", "deferredUpdatesInterval", "deferredUpdatesTimeout", "foregroundService", "Lexpo/modules/location/records/LocationTaskServiceOptions;", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/location/records/LocationTaskServiceOptions;)V", "getDeferredUpdatesDistance$annotations", "()V", "getDeferredUpdatesDistance", "()Ljava/lang/Float;", "setDeferredUpdatesDistance", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getDeferredUpdatesInterval$annotations", "getDeferredUpdatesInterval", "setDeferredUpdatesInterval", "getDeferredUpdatesTimeout$annotations", "getDeferredUpdatesTimeout", "setDeferredUpdatesTimeout", "getForegroundService$annotations", "getForegroundService", "()Lexpo/modules/location/records/LocationTaskServiceOptions;", "setForegroundService", "(Lexpo/modules/location/records/LocationTaskServiceOptions;)V", "toMutableMap", "", "", "", "toMutableMap$expo_location_release", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationTaskOptions extends LocationOptions {
    private Float deferredUpdatesDistance;
    private Float deferredUpdatesInterval;
    private Float deferredUpdatesTimeout;
    private LocationTaskServiceOptions foregroundService;

    public LocationTaskOptions() {
        this(null, null, null, null, 15, null);
    }

    @Field
    public static /* synthetic */ void getDeferredUpdatesDistance$annotations() {
    }

    @Field
    public static /* synthetic */ void getDeferredUpdatesInterval$annotations() {
    }

    @Field
    public static /* synthetic */ void getDeferredUpdatesTimeout$annotations() {
    }

    @Field
    public static /* synthetic */ void getForegroundService$annotations() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LocationTaskOptions(Float f, Float f2, Float f3, LocationTaskServiceOptions locationTaskServiceOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = i & 1;
        Float fValueOf = Float.valueOf(0.0f);
        this(i2 != 0 ? fValueOf : f, (i & 2) != 0 ? fValueOf : f2, (i & 4) != 0 ? null : f3, (i & 8) != 0 ? null : locationTaskServiceOptions);
    }

    public final Float getDeferredUpdatesDistance() {
        return this.deferredUpdatesDistance;
    }

    public final void setDeferredUpdatesDistance(Float f) {
        this.deferredUpdatesDistance = f;
    }

    public final Float getDeferredUpdatesInterval() {
        return this.deferredUpdatesInterval;
    }

    public final void setDeferredUpdatesInterval(Float f) {
        this.deferredUpdatesInterval = f;
    }

    public final Float getDeferredUpdatesTimeout() {
        return this.deferredUpdatesTimeout;
    }

    public final void setDeferredUpdatesTimeout(Float f) {
        this.deferredUpdatesTimeout = f;
    }

    public final LocationTaskServiceOptions getForegroundService() {
        return this.foregroundService;
    }

    public final void setForegroundService(LocationTaskServiceOptions locationTaskServiceOptions) {
        this.foregroundService = locationTaskServiceOptions;
    }

    public LocationTaskOptions(Float f, Float f2, Float f3, LocationTaskServiceOptions locationTaskServiceOptions) {
        super(0, null, false, null, 15, null);
        this.deferredUpdatesDistance = f;
        this.deferredUpdatesInterval = f2;
        this.deferredUpdatesTimeout = f3;
        this.foregroundService = locationTaskServiceOptions;
    }

    public final Map<String, Object> toMutableMap$expo_location_release() {
        Map<String, Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("accuracy", Integer.valueOf(getAccuracy())), TuplesKt.to("distanceInterval", getDistanceInterval()), TuplesKt.to("mayShowUserSettingsDialog", Boolean.valueOf(getMayShowUserSettingsDialog())), TuplesKt.to("timeInterval", getTimeInterval()), TuplesKt.to("deferredUpdatesDistance", this.deferredUpdatesDistance), TuplesKt.to("deferredUpdatesInterval", this.deferredUpdatesInterval), TuplesKt.to("deferredUpdatesTimeout", this.deferredUpdatesTimeout));
        LocationTaskServiceOptions locationTaskServiceOptions = this.foregroundService;
        if (locationTaskServiceOptions != null) {
            mapMutableMapOf.put("foregroundService", locationTaskServiceOptions.toMutableMap$expo_location_release());
        }
        return mapMutableMapOf;
    }
}
