package expo.modules.image;

import com.bumptech.glide.load.model.GlideUrl;
import expo.modules.image.okhttp.GlideUrlWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideModelProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/UrlModelProvider;", "Lexpo/modules/image/GlideModelProvider;", "glideUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "<init>", "(Lcom/bumptech/glide/load/model/GlideUrl;)V", "getGlideModel", "Lexpo/modules/image/okhttp/GlideUrlWrapper;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class UrlModelProvider implements GlideModelProvider {
    private final GlideUrl glideUrl;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final GlideUrl getGlideUrl() {
        return this.glideUrl;
    }

    public static /* synthetic */ UrlModelProvider copy$default(UrlModelProvider urlModelProvider, GlideUrl glideUrl, int i, Object obj) {
        if ((i & 1) != 0) {
            glideUrl = urlModelProvider.glideUrl;
        }
        return urlModelProvider.copy(glideUrl);
    }

    public final UrlModelProvider copy(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        return new UrlModelProvider(glideUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UrlModelProvider) && Intrinsics.areEqual(this.glideUrl, ((UrlModelProvider) other).glideUrl);
    }

    public int hashCode() {
        return this.glideUrl.hashCode();
    }

    public String toString() {
        return "UrlModelProvider(glideUrl=" + this.glideUrl + ")";
    }

    public UrlModelProvider(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        this.glideUrl = glideUrl;
    }

    @Override // expo.modules.image.GlideModelProvider
    public GlideUrlWrapper getGlideModel() {
        return new GlideUrlWrapper(this.glideUrl);
    }
}
