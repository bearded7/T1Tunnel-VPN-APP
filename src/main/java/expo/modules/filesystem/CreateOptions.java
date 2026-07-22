package expo.modules.filesystem;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FileSystemNextRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lexpo/modules/filesystem/CreateOptions;", "Lexpo/modules/kotlin/records/Record;", "intermediates", "", "overwrite", "idempotent", "<init>", "(ZZZ)V", "getIntermediates$annotations", "()V", "getIntermediates", "()Z", "getOverwrite$annotations", "getOverwrite", "getIdempotent$annotations", "getIdempotent", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CreateOptions implements Record {
    private final boolean idempotent;
    private final boolean intermediates;
    private final boolean overwrite;

    public CreateOptions() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ CreateOptions copy$default(CreateOptions createOptions, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = createOptions.intermediates;
        }
        if ((i & 2) != 0) {
            z2 = createOptions.overwrite;
        }
        if ((i & 4) != 0) {
            z3 = createOptions.idempotent;
        }
        return createOptions.copy(z, z2, z3);
    }

    @Field
    public static /* synthetic */ void getIdempotent$annotations() {
    }

    @Field
    public static /* synthetic */ void getIntermediates$annotations() {
    }

    @Field
    public static /* synthetic */ void getOverwrite$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIntermediates() {
        return this.intermediates;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getOverwrite() {
        return this.overwrite;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIdempotent() {
        return this.idempotent;
    }

    public final CreateOptions copy(boolean intermediates, boolean overwrite, boolean idempotent) {
        return new CreateOptions(intermediates, overwrite, idempotent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateOptions)) {
            return false;
        }
        CreateOptions createOptions = (CreateOptions) other;
        return this.intermediates == createOptions.intermediates && this.overwrite == createOptions.overwrite && this.idempotent == createOptions.idempotent;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.intermediates) * 31) + Boolean.hashCode(this.overwrite)) * 31) + Boolean.hashCode(this.idempotent);
    }

    public String toString() {
        return "CreateOptions(intermediates=" + this.intermediates + ", overwrite=" + this.overwrite + ", idempotent=" + this.idempotent + ")";
    }

    public CreateOptions(boolean z, boolean z2, boolean z3) {
        this.intermediates = z;
        this.overwrite = z2;
        this.idempotent = z3;
    }

    public /* synthetic */ CreateOptions(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean getIntermediates() {
        return this.intermediates;
    }

    public final boolean getOverwrite() {
        return this.overwrite;
    }

    public final boolean getIdempotent() {
        return this.idempotent;
    }
}
