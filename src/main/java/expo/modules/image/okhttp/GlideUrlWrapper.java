package expo.modules.image.okhttp;

import com.bumptech.glide.load.model.GlideUrl;
import expo.modules.image.events.OkHttpProgressListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoImageOkHttpClientGlideModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWrapper;", "", "glideUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "<init>", "(Lcom/bumptech/glide/load/model/GlideUrl;)V", "getGlideUrl", "()Lcom/bumptech/glide/load/model/GlideUrl;", "progressListener", "Lexpo/modules/image/events/OkHttpProgressListener;", "getProgressListener", "()Lexpo/modules/image/events/OkHttpProgressListener;", "setProgressListener", "(Lexpo/modules/image/events/OkHttpProgressListener;)V", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class GlideUrlWrapper {
    private final GlideUrl glideUrl;
    private OkHttpProgressListener progressListener;

    public static /* synthetic */ GlideUrlWrapper copy$default(GlideUrlWrapper glideUrlWrapper, GlideUrl glideUrl, int i, Object obj) {
        if ((i & 1) != 0) {
            glideUrl = glideUrlWrapper.glideUrl;
        }
        return glideUrlWrapper.copy(glideUrl);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GlideUrl getGlideUrl() {
        return this.glideUrl;
    }

    public final GlideUrlWrapper copy(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        return new GlideUrlWrapper(glideUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GlideUrlWrapper) && Intrinsics.areEqual(this.glideUrl, ((GlideUrlWrapper) other).glideUrl);
    }

    public int hashCode() {
        return this.glideUrl.hashCode();
    }

    public GlideUrlWrapper(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        this.glideUrl = glideUrl;
    }

    public final GlideUrl getGlideUrl() {
        return this.glideUrl;
    }

    public final OkHttpProgressListener getProgressListener() {
        return this.progressListener;
    }

    public final void setProgressListener(OkHttpProgressListener okHttpProgressListener) {
        this.progressListener = okHttpProgressListener;
    }

    public String toString() {
        String string = this.glideUrl.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
