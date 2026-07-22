package expo.modules.image.blurhash;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurhashModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashModel;", "", "uri", "Landroid/net/Uri;", "width", "", "height", "<init>", "(Landroid/net/Uri;II)V", "getUri", "()Landroid/net/Uri;", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BlurhashModel {
    private final int height;
    private final Uri uri;
    private final int width;

    public static /* synthetic */ BlurhashModel copy$default(BlurhashModel blurhashModel, Uri uri, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uri = blurhashModel.uri;
        }
        if ((i3 & 2) != 0) {
            i = blurhashModel.width;
        }
        if ((i3 & 4) != 0) {
            i2 = blurhashModel.height;
        }
        return blurhashModel.copy(uri, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final BlurhashModel copy(Uri uri, int width, int height) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new BlurhashModel(uri, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurhashModel)) {
            return false;
        }
        BlurhashModel blurhashModel = (BlurhashModel) other;
        return Intrinsics.areEqual(this.uri, blurhashModel.uri) && this.width == blurhashModel.width && this.height == blurhashModel.height;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "BlurhashModel(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public BlurhashModel(Uri uri, int i, int i2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
