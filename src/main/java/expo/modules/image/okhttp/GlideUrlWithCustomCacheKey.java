package expo.modules.image.okhttp;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoImageOkHttpClientGlideModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWithCustomCacheKey;", "Lcom/bumptech/glide/load/model/GlideUrl;", "uri", "", "headers", "Lcom/bumptech/glide/load/model/Headers;", "cacheKey", "<init>", "(Ljava/lang/String;Lcom/bumptech/glide/load/model/Headers;Ljava/lang/String;)V", "hashCode", "", "getBaseCacheKey", "getCacheKey", "equals", "", "other", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideUrlWithCustomCacheKey extends GlideUrl {
    private final String cacheKey;
    private int hashCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlideUrlWithCustomCacheKey(String str, Headers headers, String cacheKey) {
        super(str, headers);
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.cacheKey = cacheKey;
    }

    private final String getBaseCacheKey() {
        String cacheKey = super.getCacheKey();
        Intrinsics.checkNotNullExpressionValue(cacheKey, "getCacheKey(...)");
        return cacheKey;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl, com.bumptech.glide.load.Key
    public boolean equals(Object other) {
        if (other instanceof GlideUrlWithCustomCacheKey) {
            GlideUrlWithCustomCacheKey glideUrlWithCustomCacheKey = (GlideUrlWithCustomCacheKey) other;
            return Intrinsics.areEqual(getBaseCacheKey(), glideUrlWithCustomCacheKey.getBaseCacheKey()) && getHeaders().equals(glideUrlWithCustomCacheKey.getHeaders());
        }
        if (other instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) other;
            if (Intrinsics.areEqual(getBaseCacheKey(), glideUrl.getCacheKey()) && getHeaders().equals(glideUrl.getHeaders())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl, com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = getBaseCacheKey().hashCode();
            this.hashCode = iHashCode;
            this.hashCode = (iHashCode * 31) + getHeaders().hashCode();
        }
        return this.hashCode;
    }
}
