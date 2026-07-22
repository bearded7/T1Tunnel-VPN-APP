package expo.modules.location.records;

import android.os.Bundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LocationResults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017R(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lexpo/modules/location/records/HeadingEventResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "watchId", "", "heading", "Lexpo/modules/location/records/Heading;", "<init>", "(Ljava/lang/Integer;Lexpo/modules/location/records/Heading;)V", "getWatchId$annotations", "()V", "getWatchId", "()Ljava/lang/Integer;", "setWatchId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeading$annotations", "getHeading", "()Lexpo/modules/location/records/Heading;", "setHeading", "(Lexpo/modules/location/records/Heading;)V", "toBundle", "Landroid/os/Bundle;", "toBundle$expo_location_release", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadingEventResponse implements Record, Serializable {
    private Heading heading;
    private Integer watchId;

    public HeadingEventResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Field
    public static /* synthetic */ void getHeading$annotations() {
    }

    @Field
    public static /* synthetic */ void getWatchId$annotations() {
    }

    public HeadingEventResponse(Integer num, Heading heading) {
        this.watchId = num;
        this.heading = heading;
    }

    public /* synthetic */ HeadingEventResponse(Integer num, Heading heading, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : heading);
    }

    public final Integer getWatchId() {
        return this.watchId;
    }

    public final void setWatchId(Integer num) {
        this.watchId = num;
    }

    public final Heading getHeading() {
        return this.heading;
    }

    public final void setHeading(Heading heading) {
        this.heading = heading;
    }

    public final Bundle toBundle$expo_location_release() {
        Bundle bundle = new Bundle();
        Integer num = this.watchId;
        if (num != null) {
            bundle.putInt("watchId", num.intValue());
        }
        Heading heading = this.heading;
        if (heading != null) {
            bundle.putBundle("heading", heading.toBundle$expo_location_release());
        }
        return bundle;
    }
}
