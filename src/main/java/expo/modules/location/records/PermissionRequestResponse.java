package expo.modules.location.records;

import android.os.Bundle;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.location.ConversionException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationResults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fR(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lexpo/modules/location/records/PermissionRequestResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", PermissionsResponse.CAN_ASK_AGAIN_KEY, "", PermissionsResponse.EXPIRES_KEY, "", PermissionsResponse.GRANTED_KEY, "status", "android", "Lexpo/modules/location/records/PermissionDetailsLocationAndroid;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/String;Lexpo/modules/location/records/PermissionDetailsLocationAndroid;)V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getCanAskAgain$annotations", "()V", "getCanAskAgain", "()Ljava/lang/Boolean;", "setCanAskAgain", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getExpires$annotations", "getExpires", "()Ljava/lang/String;", "setExpires", "(Ljava/lang/String;)V", "getGranted$annotations", "getGranted", "()Z", "setGranted", "(Z)V", "getStatus$annotations", "getStatus", "setStatus", "getAndroid$annotations", "getAndroid", "()Lexpo/modules/location/records/PermissionDetailsLocationAndroid;", "setAndroid", "(Lexpo/modules/location/records/PermissionDetailsLocationAndroid;)V", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionRequestResponse implements Record, Serializable {
    private PermissionDetailsLocationAndroid android;
    private Boolean canAskAgain;
    private String expires;
    private boolean granted;
    private String status;

    @Field
    public static /* synthetic */ void getAndroid$annotations() {
    }

    @Field
    public static /* synthetic */ void getCanAskAgain$annotations() {
    }

    @Field
    public static /* synthetic */ void getExpires$annotations() {
    }

    @Field
    public static /* synthetic */ void getGranted$annotations() {
    }

    @Field
    public static /* synthetic */ void getStatus$annotations() {
    }

    public PermissionRequestResponse(Boolean bool, String str, boolean z, String str2, PermissionDetailsLocationAndroid permissionDetailsLocationAndroid) {
        this.canAskAgain = bool;
        this.expires = str;
        this.granted = z;
        this.status = str2;
        this.android = permissionDetailsLocationAndroid;
    }

    public final Boolean getCanAskAgain() {
        return this.canAskAgain;
    }

    public final void setCanAskAgain(Boolean bool) {
        this.canAskAgain = bool;
    }

    public final String getExpires() {
        return this.expires;
    }

    public final void setExpires(String str) {
        this.expires = str;
    }

    public final boolean getGranted() {
        return this.granted;
    }

    public final void setGranted(boolean z) {
        this.granted = z;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final PermissionDetailsLocationAndroid getAndroid() {
        return this.android;
    }

    public final void setAndroid(PermissionDetailsLocationAndroid permissionDetailsLocationAndroid) {
        this.android = permissionDetailsLocationAndroid;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PermissionRequestResponse(Bundle bundle) throws ConversionException {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Boolean boolValueOf = Boolean.valueOf(bundle.getBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY));
        String string = bundle.getString(PermissionsResponse.EXPIRES_KEY);
        if (string == null) {
            throw new ConversionException(Bundle.class, PermissionRequestResponse.class, "value under `expires` key is undefined");
        }
        boolean z = bundle.getBoolean(PermissionsResponse.GRANTED_KEY);
        String string2 = bundle.getString("status");
        if (string2 == null) {
            throw new ConversionException(Bundle.class, PermissionRequestResponse.class, "value under `status` key is undefined");
        }
        Bundle bundle2 = bundle.getBundle("android");
        this(boolValueOf, string, z, string2, bundle2 != null ? new PermissionDetailsLocationAndroid(bundle2) : null);
    }
}
