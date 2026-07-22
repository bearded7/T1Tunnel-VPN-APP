package com.canhub.cropper;

import android.net.Uri;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CropImageContractOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "\n  This ActivityResultContract is deprecated.\n  Please either roll your own ActivityResultContract with the desired behavior or copy paste this.\n")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/canhub/cropper/CropImageContractOptions;", "", "uri", "Landroid/net/Uri;", "cropImageOptions", "Lcom/canhub/cropper/CropImageOptions;", "<init>", "(Landroid/net/Uri;Lcom/canhub/cropper/CropImageOptions;)V", "getUri", "()Landroid/net/Uri;", "getCropImageOptions", "()Lcom/canhub/cropper/CropImageOptions;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class CropImageContractOptions {
    private final CropImageOptions cropImageOptions;
    private final Uri uri;

    public static /* synthetic */ CropImageContractOptions copy$default(CropImageContractOptions cropImageContractOptions, Uri uri, CropImageOptions cropImageOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = cropImageContractOptions.uri;
        }
        if ((i & 2) != 0) {
            cropImageOptions = cropImageContractOptions.cropImageOptions;
        }
        return cropImageContractOptions.copy(uri, cropImageOptions);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CropImageOptions getCropImageOptions() {
        return this.cropImageOptions;
    }

    public final CropImageContractOptions copy(Uri uri, CropImageOptions cropImageOptions) {
        Intrinsics.checkNotNullParameter(cropImageOptions, "cropImageOptions");
        return new CropImageContractOptions(uri, cropImageOptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropImageContractOptions)) {
            return false;
        }
        CropImageContractOptions cropImageContractOptions = (CropImageContractOptions) other;
        return Intrinsics.areEqual(this.uri, cropImageContractOptions.uri) && Intrinsics.areEqual(this.cropImageOptions, cropImageContractOptions.cropImageOptions);
    }

    public int hashCode() {
        Uri uri = this.uri;
        return ((uri == null ? 0 : uri.hashCode()) * 31) + this.cropImageOptions.hashCode();
    }

    public String toString() {
        return "CropImageContractOptions(uri=" + this.uri + ", cropImageOptions=" + this.cropImageOptions + ")";
    }

    public CropImageContractOptions(Uri uri, CropImageOptions cropImageOptions) {
        Intrinsics.checkNotNullParameter(cropImageOptions, "cropImageOptions");
        this.uri = uri;
        this.cropImageOptions = cropImageOptions;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final CropImageOptions getCropImageOptions() {
        return this.cropImageOptions;
    }
}
