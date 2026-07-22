package expo.modules.location.records;

import android.location.Location;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.PersistableBundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.location.ConversionException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationResults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ'\u0010 \u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0000¢\u0006\u0004\b%\u0010&R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lexpo/modules/location/records/LocationResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "coords", "Lexpo/modules/location/records/LocationObjectCoords;", "timestamp", "", "mocked", "", "<init>", "(Lexpo/modules/location/records/LocationObjectCoords;Ljava/lang/Double;Ljava/lang/Boolean;)V", "location", "Landroid/location/Location;", "(Landroid/location/Location;)V", "getCoords$annotations", "()V", "getCoords", "()Lexpo/modules/location/records/LocationObjectCoords;", "setCoords", "(Lexpo/modules/location/records/LocationObjectCoords;)V", "getTimestamp$annotations", "getTimestamp", "()Ljava/lang/Double;", "setTimestamp", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMocked$annotations", "getMocked", "()Ljava/lang/Boolean;", "setMocked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "toBundle", "BundleType", "Landroid/os/BaseBundle;", "bundleTypeClass", "Ljava/lang/Class;", "toBundle$expo_location_release", "(Ljava/lang/Class;)Landroid/os/BaseBundle;", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationResponse implements Record, Serializable {
    private LocationObjectCoords coords;
    private Boolean mocked;
    private Double timestamp;

    public LocationResponse() {
        this(null, null, null, 7, null);
    }

    @Field
    public static /* synthetic */ void getCoords$annotations() {
    }

    @Field
    public static /* synthetic */ void getMocked$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimestamp$annotations() {
    }

    public LocationResponse(LocationObjectCoords locationObjectCoords, Double d, Boolean bool) {
        this.coords = locationObjectCoords;
        this.timestamp = d;
        this.mocked = bool;
    }

    public /* synthetic */ LocationResponse(LocationObjectCoords locationObjectCoords, Double d, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : locationObjectCoords, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : bool);
    }

    public final LocationObjectCoords getCoords() {
        return this.coords;
    }

    public final void setCoords(LocationObjectCoords locationObjectCoords) {
        this.coords = locationObjectCoords;
    }

    public final Double getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(Double d) {
        this.timestamp = d;
    }

    public final Boolean getMocked() {
        return this.mocked;
    }

    public final void setMocked(Boolean bool) {
        this.mocked = bool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationResponse(Location location) {
        this(new LocationObjectCoords(location), Double.valueOf(location.getTime()), Boolean.valueOf(location.isFromMockProvider()));
        Intrinsics.checkNotNullParameter(location, "location");
    }

    public final <BundleType extends BaseBundle> BundleType toBundle$expo_location_release(Class<BundleType> bundleTypeClass) throws ConversionException {
        Intrinsics.checkNotNullParameter(bundleTypeClass, "bundleTypeClass");
        BundleType persistableBundle = Intrinsics.areEqual(bundleTypeClass, PersistableBundle.class) ? new PersistableBundle() : new Bundle();
        BundleType bundletype = persistableBundle instanceof BaseBundle ? persistableBundle : null;
        if (bundletype == null) {
            throw new ConversionException(LocationResponse.class, bundleTypeClass, "Unsupported bundleTypeClass");
        }
        Double d = this.timestamp;
        if (d != null) {
            bundletype.putDouble("timestamp", d.doubleValue());
        }
        Boolean bool = this.mocked;
        if (bool != null) {
            bundletype.putBoolean("mocked", bool.booleanValue());
        }
        if (bundletype instanceof PersistableBundle) {
            PersistableBundle persistableBundle2 = (PersistableBundle) bundletype;
            LocationObjectCoords locationObjectCoords = this.coords;
            persistableBundle2.putPersistableBundle("coords", locationObjectCoords != null ? (PersistableBundle) locationObjectCoords.toBundle$expo_location_release(PersistableBundle.class) : null);
            return bundletype;
        }
        if (bundletype instanceof Bundle) {
            Bundle bundle = (Bundle) bundletype;
            LocationObjectCoords locationObjectCoords2 = this.coords;
            bundle.putBundle("coords", locationObjectCoords2 != null ? (Bundle) locationObjectCoords2.toBundle$expo_location_release(Bundle.class) : null);
        }
        return bundletype;
    }
}
