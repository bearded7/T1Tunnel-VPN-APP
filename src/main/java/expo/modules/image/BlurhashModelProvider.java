package expo.modules.image;

import android.net.Uri;
import expo.modules.image.blurhash.BlurhashModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideModelProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0005HÂ\u0003J\t\u0010\r\u001a\u00020\u0005HÂ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/image/BlurhashModelProvider;", "Lexpo/modules/image/GlideModelProvider;", "uri", "Landroid/net/Uri;", "width", "", "height", "<init>", "(Landroid/net/Uri;II)V", "getGlideModel", "Lexpo/modules/image/blurhash/BlurhashModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class BlurhashModelProvider implements GlideModelProvider {
    private final int height;
    private final Uri uri;
    private final int width;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getHeight() {
        return this.height;
    }

    public static /* synthetic */ BlurhashModelProvider copy$default(BlurhashModelProvider blurhashModelProvider, Uri uri, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uri = blurhashModelProvider.uri;
        }
        if ((i3 & 2) != 0) {
            i = blurhashModelProvider.width;
        }
        if ((i3 & 4) != 0) {
            i2 = blurhashModelProvider.height;
        }
        return blurhashModelProvider.copy(uri, i, i2);
    }

    public final BlurhashModelProvider copy(Uri uri, int width, int height) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new BlurhashModelProvider(uri, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurhashModelProvider)) {
            return false;
        }
        BlurhashModelProvider blurhashModelProvider = (BlurhashModelProvider) other;
        return Intrinsics.areEqual(this.uri, blurhashModelProvider.uri) && this.width == blurhashModelProvider.width && this.height == blurhashModelProvider.height;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "BlurhashModelProvider(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public BlurhashModelProvider(Uri uri, int i, int i2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    @Override // expo.modules.image.GlideModelProvider
    public BlurhashModel getGlideModel() {
        return new BlurhashModel(this.uri, this.width, this.height);
    }
}
