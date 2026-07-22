package expo.modules.location;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationParams.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lexpo/modules/location/LocationParams;", "", "accuracy", "Lexpo/modules/location/LocationAccuracy;", "distance", "", "interval", "", "<init>", "(Lexpo/modules/location/LocationAccuracy;FJ)V", "getAccuracy", "()Lexpo/modules/location/LocationAccuracy;", "getDistance", "()F", "setDistance", "(F)V", "getInterval", "()J", "setInterval", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class LocationParams {
    private final LocationAccuracy accuracy;
    private float distance;
    private long interval;

    public static /* synthetic */ LocationParams copy$default(LocationParams locationParams, LocationAccuracy locationAccuracy, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            locationAccuracy = locationParams.accuracy;
        }
        if ((i & 2) != 0) {
            f = locationParams.distance;
        }
        if ((i & 4) != 0) {
            j = locationParams.interval;
        }
        return locationParams.copy(locationAccuracy, f, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LocationAccuracy getAccuracy() {
        return this.accuracy;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getDistance() {
        return this.distance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    public final LocationParams copy(LocationAccuracy accuracy, float distance, long interval) {
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        return new LocationParams(accuracy, distance, interval);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocationParams)) {
            return false;
        }
        LocationParams locationParams = (LocationParams) other;
        return this.accuracy == locationParams.accuracy && Float.compare(this.distance, locationParams.distance) == 0 && this.interval == locationParams.interval;
    }

    public int hashCode() {
        return (((this.accuracy.hashCode() * 31) + Float.hashCode(this.distance)) * 31) + Long.hashCode(this.interval);
    }

    public String toString() {
        return "LocationParams(accuracy=" + this.accuracy + ", distance=" + this.distance + ", interval=" + this.interval + ")";
    }

    public LocationParams(LocationAccuracy accuracy, float f, long j) {
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        this.accuracy = accuracy;
        this.distance = f;
        this.interval = j;
    }

    public final LocationAccuracy getAccuracy() {
        return this.accuracy;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final void setDistance(float f) {
        this.distance = f;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final void setInterval(long j) {
        this.interval = j;
    }
}
