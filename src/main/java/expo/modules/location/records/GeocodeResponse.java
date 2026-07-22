package expo.modules.location.records;

import android.location.Location;
import android.util.Log;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.location.LocationModule;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationResults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001a\b\u0000\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R(\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001f\u0012\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lexpo/modules/location/records/GeocodeResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "latitude", "", "longitude", "accuracy", "", "altitude", "<init>", "(DDLjava/lang/Float;Ljava/lang/Double;)V", "getLatitude$annotations", "()V", "getLatitude", "()D", "setLatitude", "(D)V", "getLongitude$annotations", "getLongitude", "setLongitude", "getAccuracy$annotations", "getAccuracy", "()Ljava/lang/Float;", "setAccuracy", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getAltitude$annotations", "getAltitude", "()Ljava/lang/Double;", "setAltitude", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "Companion", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeocodeResponse implements Record, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Float accuracy;
    private Double altitude;
    private double latitude;
    private double longitude;

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    @Field
    public static /* synthetic */ void getAltitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getLatitude$annotations() {
    }

    @Field
    public static /* synthetic */ void getLongitude$annotations() {
    }

    public GeocodeResponse(double d, double d2, Float f, Double d3) {
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = f;
        this.altitude = d3;
    }

    public /* synthetic */ GeocodeResponse(double d, double d2, Float f, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, (i & 4) != 0 ? null : f, (i & 8) != 0 ? null : d3);
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(double d) {
        this.longitude = d;
    }

    public final Float getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(Float f) {
        this.accuracy = f;
    }

    public final Double getAltitude() {
        return this.altitude;
    }

    public final void setAltitude(Double d) {
        this.altitude = d;
    }

    /* JADX INFO: compiled from: LocationResults.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/location/records/GeocodeResponse$Companion;", "", "<init>", "()V", "from", "Lexpo/modules/location/records/GeocodeResponse;", "location", "Landroid/location/Location;", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GeocodeResponse from(Location location) {
            Intrinsics.checkNotNullParameter(location, "location");
            try {
                return new GeocodeResponse(location.getLatitude(), location.getLongitude(), Float.valueOf(location.getAccuracy()), Double.valueOf(location.getAltitude()));
            } catch (Exception e) {
                if (!(e instanceof IllegalAccessException) && !(e instanceof InstantiationException)) {
                    return null;
                }
                Log.e(LocationModule.INSTANCE.getTAG$expo_location_release(), "Unexpected exception was thrown when converting location to coords bundle: ", e);
                return null;
            }
        }
    }
}
