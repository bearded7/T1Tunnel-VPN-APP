package expo.modules.location.records;

import android.os.Bundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationResults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lexpo/modules/location/records/PermissionDetailsLocationAndroid;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "accuracy", "", "<init>", "(Ljava/lang/String;)V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getAccuracy$annotations", "()V", "getAccuracy", "()Ljava/lang/String;", "setAccuracy", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionDetailsLocationAndroid implements Record, Serializable {
    private String accuracy;

    @Field
    public static /* synthetic */ void getAccuracy$annotations() {
    }

    public PermissionDetailsLocationAndroid(String accuracy) {
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        this.accuracy = accuracy;
    }

    public final String getAccuracy() {
        return this.accuracy;
    }

    public final void setAccuracy(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accuracy = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PermissionDetailsLocationAndroid(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("accuracy");
        this(string == null ? "none" : string);
    }
}
