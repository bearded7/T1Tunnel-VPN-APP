package expo.modules.filesystem;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemNextRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJT\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR(\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001f¨\u00065"}, d2 = {"Lexpo/modules/filesystem/FileInfo;", "Lexpo/modules/kotlin/records/Record;", "exists", "", "uri", "", "md5", "size", "", "modificationTime", "creationTime", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getExists$annotations", "()V", "getExists", "()Z", "setExists", "(Z)V", "getUri$annotations", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getMd5$annotations", "getMd5", "setMd5", "getSize$annotations", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getModificationTime$annotations", "getModificationTime", "setModificationTime", "getCreationTime$annotations", "getCreationTime", "setCreationTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lexpo/modules/filesystem/FileInfo;", "equals", "other", "", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FileInfo implements Record {
    private Long creationTime;
    private boolean exists;
    private String md5;
    private Long modificationTime;
    private Long size;
    private String uri;

    public static /* synthetic */ FileInfo copy$default(FileInfo fileInfo, boolean z, String str, String str2, Long l, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileInfo.exists;
        }
        if ((i & 2) != 0) {
            str = fileInfo.uri;
        }
        if ((i & 4) != 0) {
            str2 = fileInfo.md5;
        }
        if ((i & 8) != 0) {
            l = fileInfo.size;
        }
        if ((i & 16) != 0) {
            l2 = fileInfo.modificationTime;
        }
        if ((i & 32) != 0) {
            l3 = fileInfo.creationTime;
        }
        Long l4 = l2;
        Long l5 = l3;
        return fileInfo.copy(z, str, str2, l, l4, l5);
    }

    @Field
    public static /* synthetic */ void getCreationTime$annotations() {
    }

    @Field
    public static /* synthetic */ void getExists$annotations() {
    }

    @Field
    public static /* synthetic */ void getMd5$annotations() {
    }

    @Field
    public static /* synthetic */ void getModificationTime$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getExists() {
        return this.exists;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getModificationTime() {
        return this.modificationTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getCreationTime() {
        return this.creationTime;
    }

    public final FileInfo copy(boolean exists, String uri, String md5, Long size, Long modificationTime, Long creationTime) {
        return new FileInfo(exists, uri, md5, size, modificationTime, creationTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) other;
        return this.exists == fileInfo.exists && Intrinsics.areEqual(this.uri, fileInfo.uri) && Intrinsics.areEqual(this.md5, fileInfo.md5) && Intrinsics.areEqual(this.size, fileInfo.size) && Intrinsics.areEqual(this.modificationTime, fileInfo.modificationTime) && Intrinsics.areEqual(this.creationTime, fileInfo.creationTime);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.exists) * 31;
        String str = this.uri;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.md5;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.size;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.modificationTime;
        int iHashCode5 = (iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.creationTime;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "FileInfo(exists=" + this.exists + ", uri=" + this.uri + ", md5=" + this.md5 + ", size=" + this.size + ", modificationTime=" + this.modificationTime + ", creationTime=" + this.creationTime + ")";
    }

    public FileInfo(boolean z, String str, String str2, Long l, Long l2, Long l3) {
        this.exists = z;
        this.uri = str;
        this.md5 = str2;
        this.size = l;
        this.modificationTime = l2;
        this.creationTime = l3;
    }

    public /* synthetic */ FileInfo(boolean z, String str, String str2, Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3);
    }

    public final boolean getExists() {
        return this.exists;
    }

    public final void setExists(boolean z) {
        this.exists = z;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String str) {
        this.uri = str;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final Long getSize() {
        return this.size;
    }

    public final void setSize(Long l) {
        this.size = l;
    }

    public final Long getModificationTime() {
        return this.modificationTime;
    }

    public final void setModificationTime(Long l) {
        this.modificationTime = l;
    }

    public final Long getCreationTime() {
        return this.creationTime;
    }

    public final void setCreationTime(Long l) {
        this.creationTime = l;
    }
}
