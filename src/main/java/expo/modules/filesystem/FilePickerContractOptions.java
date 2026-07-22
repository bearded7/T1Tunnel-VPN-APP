package expo.modules.filesystem;

import android.net.Uri;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilePickerContract.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lexpo/modules/filesystem/FilePickerContractOptions;", "Ljava/io/Serializable;", "initialUri", "Landroid/net/Uri;", "mimeType", "", "pickerType", "Lexpo/modules/filesystem/PickerType;", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Lexpo/modules/filesystem/PickerType;)V", "getInitialUri", "()Landroid/net/Uri;", "getMimeType", "()Ljava/lang/String;", "getPickerType", "()Lexpo/modules/filesystem/PickerType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FilePickerContractOptions implements Serializable {
    private final Uri initialUri;
    private final String mimeType;
    private final PickerType pickerType;

    public static /* synthetic */ FilePickerContractOptions copy$default(FilePickerContractOptions filePickerContractOptions, Uri uri, String str, PickerType pickerType, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = filePickerContractOptions.initialUri;
        }
        if ((i & 2) != 0) {
            str = filePickerContractOptions.mimeType;
        }
        if ((i & 4) != 0) {
            pickerType = filePickerContractOptions.pickerType;
        }
        return filePickerContractOptions.copy(uri, str, pickerType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getInitialUri() {
        return this.initialUri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PickerType getPickerType() {
        return this.pickerType;
    }

    public final FilePickerContractOptions copy(Uri initialUri, String mimeType, PickerType pickerType) {
        Intrinsics.checkNotNullParameter(pickerType, "pickerType");
        return new FilePickerContractOptions(initialUri, mimeType, pickerType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilePickerContractOptions)) {
            return false;
        }
        FilePickerContractOptions filePickerContractOptions = (FilePickerContractOptions) other;
        return Intrinsics.areEqual(this.initialUri, filePickerContractOptions.initialUri) && Intrinsics.areEqual(this.mimeType, filePickerContractOptions.mimeType) && this.pickerType == filePickerContractOptions.pickerType;
    }

    public int hashCode() {
        Uri uri = this.initialUri;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        String str = this.mimeType;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.pickerType.hashCode();
    }

    public String toString() {
        return "FilePickerContractOptions(initialUri=" + this.initialUri + ", mimeType=" + this.mimeType + ", pickerType=" + this.pickerType + ")";
    }

    public FilePickerContractOptions(Uri uri, String str, PickerType pickerType) {
        Intrinsics.checkNotNullParameter(pickerType, "pickerType");
        this.initialUri = uri;
        this.mimeType = str;
        this.pickerType = pickerType;
    }

    public /* synthetic */ FilePickerContractOptions(Uri uri, String str, PickerType pickerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : str, (i & 4) != 0 ? PickerType.FILE : pickerType);
    }

    public final Uri getInitialUri() {
        return this.initialUri;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final PickerType getPickerType() {
        return this.pickerType;
    }
}
