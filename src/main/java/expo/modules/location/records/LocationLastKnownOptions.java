package expo.modules.location.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LocationArguments.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u000e\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u000e\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Lexpo/modules/location/records/LocationLastKnownOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "maxAge", "", "requiredAccuracy", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getMaxAge$annotations", "()V", "getMaxAge", "()Ljava/lang/Double;", "setMaxAge", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getRequiredAccuracy$annotations", "getRequiredAccuracy", "setRequiredAccuracy", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationLastKnownOptions implements Record, Serializable {
    private Double maxAge;
    private Double requiredAccuracy;

    public LocationLastKnownOptions() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Field
    public static /* synthetic */ void getMaxAge$annotations() {
    }

    @Field
    public static /* synthetic */ void getRequiredAccuracy$annotations() {
    }

    public LocationLastKnownOptions(Double d, Double d2) {
        this.maxAge = d;
        this.requiredAccuracy = d2;
    }

    public /* synthetic */ LocationLastKnownOptions(Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2);
    }

    public final Double getMaxAge() {
        return this.maxAge;
    }

    public final void setMaxAge(Double d) {
        this.maxAge = d;
    }

    public final Double getRequiredAccuracy() {
        return this.requiredAccuracy;
    }

    public final void setRequiredAccuracy(Double d) {
        this.requiredAccuracy = d;
    }
}
