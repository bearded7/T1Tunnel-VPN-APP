package expo.modules.filesystem.legacy;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u001a\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\n\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lexpo/modules/filesystem/legacy/InfoOptionsLegacy;", "Lexpo/modules/kotlin/records/Record;", "md5", "", "<init>", "(Ljava/lang/Boolean;)V", "getMd5$annotations", "()V", "getMd5", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lexpo/modules/filesystem/legacy/InfoOptionsLegacy;", "equals", "other", "", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class InfoOptionsLegacy implements Record {
    private final Boolean md5;

    public static /* synthetic */ InfoOptionsLegacy copy$default(InfoOptionsLegacy infoOptionsLegacy, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = infoOptionsLegacy.md5;
        }
        return infoOptionsLegacy.copy(bool);
    }

    @Field
    public static /* synthetic */ void getMd5$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getMd5() {
        return this.md5;
    }

    public final InfoOptionsLegacy copy(Boolean md5) {
        return new InfoOptionsLegacy(md5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InfoOptionsLegacy) && Intrinsics.areEqual(this.md5, ((InfoOptionsLegacy) other).md5);
    }

    public int hashCode() {
        Boolean bool = this.md5;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "InfoOptionsLegacy(md5=" + this.md5 + ")";
    }

    public InfoOptionsLegacy(Boolean bool) {
        this.md5 = bool;
    }

    public final Boolean getMd5() {
        return this.md5;
    }
}
