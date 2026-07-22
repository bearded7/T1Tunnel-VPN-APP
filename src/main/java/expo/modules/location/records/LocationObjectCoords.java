package expo.modules.location.records;

import android.location.Location;
import android.os.BaseBundle;
import android.os.Build;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ'\u0010)\u001a\u0002H*\"\b\b\u0000\u0010**\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H*0-H\u0000¢\u0006\u0004\b.\u0010/R(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R(\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R(\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R(\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R(\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R(\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015¨\u00060"}, d2 = {"Lexpo/modules/location/records/LocationObjectCoords;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "latitude", "", "longitude", "altitude", "accuracy", "altitudeAccuracy", "heading", "speed", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "location", "Landroid/location/Location;", "(Landroid/location/Location;)V", "getLatitude$annotations", "()V", "getLatitude", "()Ljava/lang/Double;", "setLatitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getLongitude$annotations", "getLongitude", "setLongitude", "getAltitude$annotations", "getAltitude", "setAltitude", "getAccuracy$annotations", "getAccuracy", "setAccuracy", "getAltitudeAccuracy$annotations", "getAltitudeAccuracy", "setAltitudeAccuracy", "getHeading$annotations", "getHeading", "setHeading", "getSpeed$annotations", "getSpeed", "setSpeed", "toBundle", "BundleType", "Landroid/os/BaseBundle;", "bundleTypeClass", "Ljava/lang/Class;", "toBundle$expo_location_release", "(Ljava/lang/Class;)Landroid/os/BaseBundle;", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationObjectCoords implements Record, Serializable {
    private Double accuracy;
    private Double altitude;
    private Double altitudeAccuracy;
    private Double heading;
    private Double latitude;
    private Double longitude;
    private Double speed;

    public LocationObjectCoords() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getAltitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getAltitudeAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeading$annotations() {
    }

    @Field
    public static /* synthetic */ void getLatitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getLongitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getSpeed$annotations() {
    }

    public LocationObjectCoords(Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.accuracy = d4;
        this.altitudeAccuracy = d5;
        this.heading = d6;
        this.speed = d7;
    }

    public /* synthetic */ LocationObjectCoords(Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2, (i & 4) != 0 ? null : d3, (i & 8) != 0 ? null : d4, (i & 16) != 0 ? null : d5, (i & 32) != 0 ? null : d6, (i & 64) != 0 ? null : d7);
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(Double d) {
        this.latitude = d;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(Double d) {
        this.longitude = d;
    }

    public final Double getAltitude() {
        return this.altitude;
    }

    public final void setAltitude(Double d) {
        this.altitude = d;
    }

    public final Double getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(Double d) {
        this.accuracy = d;
    }

    public final Double getAltitudeAccuracy() {
        return this.altitudeAccuracy;
    }

    public final void setAltitudeAccuracy(Double d) {
        this.altitudeAccuracy = d;
    }

    public final Double getHeading() {
        return this.heading;
    }

    public final void setHeading(Double d) {
        this.heading = d;
    }

    public final Double getSpeed() {
        return this.speed;
    }

    public final void setSpeed(Double d) {
        this.speed = d;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationObjectCoords(Location location) {
        this(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Double.valueOf(location.getAltitude()), Double.valueOf(location.getAccuracy()), Build.VERSION.SDK_INT >= 26 ? Double.valueOf(location.getVerticalAccuracyMeters()) : null, Double.valueOf(location.getBearing()), Double.valueOf(location.getSpeed()));
        Intrinsics.checkNotNullParameter(location, "location");
    }

    public final <BundleType extends BaseBundle> BundleType toBundle$expo_location_release(Class<BundleType> bundleTypeClass) throws ConversionException {
        Intrinsics.checkNotNullParameter(bundleTypeClass, "bundleTypeClass");
        BundleType persistableBundle = Intrinsics.areEqual(bundleTypeClass, PersistableBundle.class) ? new PersistableBundle() : new Bundle();
        BundleType bundletype = persistableBundle instanceof BaseBundle ? persistableBundle : null;
        if (bundletype == null) {
            throw new ConversionException(LocationObjectCoords.class, bundleTypeClass, "Requested an unsupported bundle type");
        }
        Double d = this.latitude;
        if (d != null) {
            bundletype.putDouble("latitude", d.doubleValue());
        }
        Double d2 = this.longitude;
        if (d2 != null) {
            bundletype.putDouble("longitude", d2.doubleValue());
        }
        Double d3 = this.altitude;
        if (d3 != null) {
            bundletype.putDouble("altitude", d3.doubleValue());
        }
        Double d4 = this.accuracy;
        if (d4 != null) {
            bundletype.putDouble("accuracy", d4.doubleValue());
        }
        Double d5 = this.altitudeAccuracy;
        if (d5 != null) {
            bundletype.putDouble("altitudeAccuracy", d5.doubleValue());
        }
        Double d6 = this.heading;
        if (d6 != null) {
            bundletype.putDouble("heading", d6.doubleValue());
        }
        Double d7 = this.speed;
        if (d7 != null) {
            bundletype.putDouble("speed", d7.doubleValue());
        }
        return bundletype;
    }
}
