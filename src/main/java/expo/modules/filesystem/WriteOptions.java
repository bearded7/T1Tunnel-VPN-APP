package expo.modules.filesystem;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemNextRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lexpo/modules/filesystem/WriteOptions;", "Lexpo/modules/kotlin/records/Record;", "encoding", "Lexpo/modules/filesystem/EncodingType;", "<init>", "(Lexpo/modules/filesystem/EncodingType;)V", "getEncoding$annotations", "()V", "getEncoding", "()Lexpo/modules/filesystem/EncodingType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class WriteOptions implements Record {
    private final EncodingType encoding;

    public WriteOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WriteOptions copy$default(WriteOptions writeOptions, EncodingType encodingType, int i, Object obj) {
        if ((i & 1) != 0) {
            encodingType = writeOptions.encoding;
        }
        return writeOptions.copy(encodingType);
    }

    @Field
    public static /* synthetic */ void getEncoding$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EncodingType getEncoding() {
        return this.encoding;
    }

    public final WriteOptions copy(EncodingType encoding) {
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        return new WriteOptions(encoding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WriteOptions) && this.encoding == ((WriteOptions) other).encoding;
    }

    public int hashCode() {
        return this.encoding.hashCode();
    }

    public String toString() {
        return "WriteOptions(encoding=" + this.encoding + ")";
    }

    public WriteOptions(EncodingType encoding) {
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        this.encoding = encoding;
    }

    public final EncodingType getEncoding() {
        return this.encoding;
    }

    public /* synthetic */ WriteOptions(EncodingType encodingType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EncodingType.UTF8 : encodingType);
    }
}
