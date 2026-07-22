package expo.modules.filesystem;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemNextRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00104\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010$Jf\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R(\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010'\u0012\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010'\u0012\u0004\b(\u0010\u0010\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R(\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010'\u0012\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&¨\u0006="}, d2 = {"Lexpo/modules/filesystem/DirectoryInfo;", "Lexpo/modules/kotlin/records/Record;", "exists", "", "uri", "", "files", "", "md5", "size", "", "modificationTime", "creationTime", "<init>", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getExists$annotations", "()V", "getExists", "()Z", "setExists", "(Z)V", "getUri$annotations", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getFiles$annotations", "getFiles", "()Ljava/util/List;", "setFiles", "(Ljava/util/List;)V", "getMd5$annotations", "getMd5", "setMd5", "getSize$annotations", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getModificationTime$annotations", "getModificationTime", "setModificationTime", "getCreationTime$annotations", "getCreationTime", "setCreationTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lexpo/modules/filesystem/DirectoryInfo;", "equals", "other", "", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DirectoryInfo implements Record {
    private Long creationTime;
    private boolean exists;
    private List<String> files;
    private String md5;
    private Long modificationTime;
    private Long size;
    private String uri;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DirectoryInfo copy$default(DirectoryInfo directoryInfo, boolean z, String str, List list, String str2, Long l, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = directoryInfo.exists;
        }
        if ((i & 2) != 0) {
            str = directoryInfo.uri;
        }
        if ((i & 4) != 0) {
            list = directoryInfo.files;
        }
        if ((i & 8) != 0) {
            str2 = directoryInfo.md5;
        }
        if ((i & 16) != 0) {
            l = directoryInfo.size;
        }
        if ((i & 32) != 0) {
            l2 = directoryInfo.modificationTime;
        }
        if ((i & 64) != 0) {
            l3 = directoryInfo.creationTime;
        }
        Long l4 = l2;
        Long l5 = l3;
        Long l6 = l;
        List list2 = list;
        return directoryInfo.copy(z, str, list2, str2, l6, l4, l5);
    }

    @Field
    public static /* synthetic */ void getCreationTime$annotations() {
    }

    @Field
    public static /* synthetic */ void getExists$annotations() {
    }

    @Field
    public static /* synthetic */ void getFiles$annotations() {
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

    public final List<String> component3() {
        return this.files;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getModificationTime() {
        return this.modificationTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getCreationTime() {
        return this.creationTime;
    }

    public final DirectoryInfo copy(boolean exists, String uri, List<String> files, String md5, Long size, Long modificationTime, Long creationTime) {
        return new DirectoryInfo(exists, uri, files, md5, size, modificationTime, creationTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryInfo)) {
            return false;
        }
        DirectoryInfo directoryInfo = (DirectoryInfo) other;
        return this.exists == directoryInfo.exists && Intrinsics.areEqual(this.uri, directoryInfo.uri) && Intrinsics.areEqual(this.files, directoryInfo.files) && Intrinsics.areEqual(this.md5, directoryInfo.md5) && Intrinsics.areEqual(this.size, directoryInfo.size) && Intrinsics.areEqual(this.modificationTime, directoryInfo.modificationTime) && Intrinsics.areEqual(this.creationTime, directoryInfo.creationTime);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.exists) * 31;
        String str = this.uri;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.files;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.md5;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.size;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.modificationTime;
        int iHashCode6 = (iHashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.creationTime;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "DirectoryInfo(exists=" + this.exists + ", uri=" + this.uri + ", files=" + this.files + ", md5=" + this.md5 + ", size=" + this.size + ", modificationTime=" + this.modificationTime + ", creationTime=" + this.creationTime + ")";
    }

    public DirectoryInfo(boolean z, String str, List<String> list, String str2, Long l, Long l2, Long l3) {
        this.exists = z;
        this.uri = str;
        this.files = list;
        this.md5 = str2;
        this.size = l;
        this.modificationTime = l2;
        this.creationTime = l3;
    }

    public /* synthetic */ DirectoryInfo(boolean z, String str, List list, String str2, Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : l, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : l3);
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

    public final List<String> getFiles() {
        return this.files;
    }

    public final void setFiles(List<String> list) {
        this.files = list;
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
