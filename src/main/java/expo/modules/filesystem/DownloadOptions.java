package expo.modules.filesystem;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemNextRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R(\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lexpo/modules/filesystem/DownloadOptions;", "Lexpo/modules/kotlin/records/Record;", "headers", "", "", "idempotent", "", "<init>", "(Ljava/util/Map;Z)V", "getHeaders$annotations", "()V", "getHeaders", "()Ljava/util/Map;", "getIdempotent$annotations", "getIdempotent", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DownloadOptions implements Record {
    private final Map<String, String> headers;
    private final boolean idempotent;

    public DownloadOptions() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DownloadOptions copy$default(DownloadOptions downloadOptions, Map map, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            map = downloadOptions.headers;
        }
        if ((i & 2) != 0) {
            z = downloadOptions.idempotent;
        }
        return downloadOptions.copy(map, z);
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getIdempotent$annotations() {
    }

    public final Map<String, String> component1() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIdempotent() {
        return this.idempotent;
    }

    public final DownloadOptions copy(Map<String, String> headers, boolean idempotent) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new DownloadOptions(headers, idempotent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadOptions)) {
            return false;
        }
        DownloadOptions downloadOptions = (DownloadOptions) other;
        return Intrinsics.areEqual(this.headers, downloadOptions.headers) && this.idempotent == downloadOptions.idempotent;
    }

    public int hashCode() {
        return (this.headers.hashCode() * 31) + Boolean.hashCode(this.idempotent);
    }

    public String toString() {
        return "DownloadOptions(headers=" + this.headers + ", idempotent=" + this.idempotent + ")";
    }

    public DownloadOptions(Map<String, String> headers, boolean z) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
        this.idempotent = z;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public /* synthetic */ DownloadOptions(Map map, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? false : z);
    }

    public final boolean getIdempotent() {
        return this.idempotent;
    }
}
