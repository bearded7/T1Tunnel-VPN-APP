package expo.modules.imagepicker.contracts;

import expo.modules.imagepicker.ImagePickerOptions;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLibraryContract.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "Ljava/io/Serializable;", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "<init>", "(Lexpo/modules/imagepicker/ImagePickerOptions;)V", "getOptions", "()Lexpo/modules/imagepicker/ImagePickerOptions;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ImageLibraryContractOptions implements Serializable {
    private final ImagePickerOptions options;

    public static /* synthetic */ ImageLibraryContractOptions copy$default(ImageLibraryContractOptions imageLibraryContractOptions, ImagePickerOptions imagePickerOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            imagePickerOptions = imageLibraryContractOptions.options;
        }
        return imageLibraryContractOptions.copy(imagePickerOptions);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ImagePickerOptions getOptions() {
        return this.options;
    }

    public final ImageLibraryContractOptions copy(ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return new ImageLibraryContractOptions(options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImageLibraryContractOptions) && Intrinsics.areEqual(this.options, ((ImageLibraryContractOptions) other).options);
    }

    public int hashCode() {
        return this.options.hashCode();
    }

    public String toString() {
        return "ImageLibraryContractOptions(options=" + this.options + ")";
    }

    public ImageLibraryContractOptions(ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }
}
