package expo.modules.imagepicker.contracts;

import expo.modules.imagepicker.ImagePickerOptions;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraContract.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "Ljava/io/Serializable;", "uri", "", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "<init>", "(Ljava/lang/String;Lexpo/modules/imagepicker/ImagePickerOptions;)V", "getUri", "()Ljava/lang/String;", "getOptions", "()Lexpo/modules/imagepicker/ImagePickerOptions;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CameraContractOptions implements Serializable {
    private final ImagePickerOptions options;
    private final String uri;

    public static /* synthetic */ CameraContractOptions copy$default(CameraContractOptions cameraContractOptions, String str, ImagePickerOptions imagePickerOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cameraContractOptions.uri;
        }
        if ((i & 2) != 0) {
            imagePickerOptions = cameraContractOptions.options;
        }
        return cameraContractOptions.copy(str, imagePickerOptions);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImagePickerOptions getOptions() {
        return this.options;
    }

    public final CameraContractOptions copy(String uri, ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(options, "options");
        return new CameraContractOptions(uri, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraContractOptions)) {
            return false;
        }
        CameraContractOptions cameraContractOptions = (CameraContractOptions) other;
        return Intrinsics.areEqual(this.uri, cameraContractOptions.uri) && Intrinsics.areEqual(this.options, cameraContractOptions.options);
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + this.options.hashCode();
    }

    public String toString() {
        return "CameraContractOptions(uri=" + this.uri + ", options=" + this.options + ")";
    }

    public CameraContractOptions(String uri, ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(options, "options");
        this.uri = uri;
        this.options = options;
    }

    public final String getUri() {
        return this.uri;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }
}
