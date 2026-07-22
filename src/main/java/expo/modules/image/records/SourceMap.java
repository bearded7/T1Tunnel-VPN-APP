package expo.modules.image.records;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.facebook.common.util.UriUtil;
import expo.modules.image.BlurhashModelProvider;
import expo.modules.image.GlideModelProvider;
import expo.modules.image.RawModelProvider;
import expo.modules.image.ResourceIdHelper;
import expo.modules.image.ThumbhashModelProvider;
import expo.modules.image.UriModelProvider;
import expo.modules.image.UrlModelProvider;
import expo.modules.image.okhttp.GlideUrlWithCustomCacheKey;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SourceMap.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010-\u001a\u00020.H\u0016J\b\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010!2\u0006\u0010-\u001a\u00020.H\u0002J\u001a\u00106\u001a\u0004\u0018\u00010!2\u0006\u00107\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003JW\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010?\u001a\u00020#2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0006HÖ\u0001J\t\u0010C\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00068\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR*\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lexpo/modules/image/records/SourceMap;", "Lexpo/modules/image/records/Source;", "Lexpo/modules/kotlin/records/Record;", "uri", "", "width", "", "height", "scale", "", "headers", "", "cacheKey", "<init>", "(Ljava/lang/String;IIDLjava/util/Map;Ljava/lang/String;)V", "getUri$annotations", "()V", "getUri", "()Ljava/lang/String;", "getWidth$annotations", "getWidth", "()I", "getHeight$annotations", "getHeight", "getScale$annotations", "getScale", "()D", "getHeaders$annotations", "getHeaders", "()Ljava/util/Map;", "getCacheKey$annotations", "getCacheKey", "parsedUri", "Landroid/net/Uri;", "isDataUrl", "", "isContentUrl", "isResourceUri", "isLocalResourceUri", "isLocalFileUri", "isBlurhash", "isThumbhash", "usesPlaceholderContentFit", "parseUri", "", "context", "Landroid/content/Context;", "createGlideModelProvider", "Lexpo/modules/image/GlideModelProvider;", "createGlideOptions", "Lcom/bumptech/glide/request/RequestOptions;", "getCustomHeaders", "Lcom/bumptech/glide/load/model/Headers;", "computeUri", "computeLocalUri", "stringUri", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SourceMap implements Source, Record {
    private final String cacheKey;
    private final Map<String, String> headers;
    private final int height;
    private Uri parsedUri;
    private final double scale;
    private final String uri;
    private final int width;

    public SourceMap() {
        this(null, 0, 0, 0.0d, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SourceMap copy$default(SourceMap sourceMap, String str, int i, int i2, double d, Map map, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sourceMap.uri;
        }
        if ((i3 & 2) != 0) {
            i = sourceMap.width;
        }
        if ((i3 & 4) != 0) {
            i2 = sourceMap.height;
        }
        if ((i3 & 8) != 0) {
            d = sourceMap.scale;
        }
        if ((i3 & 16) != 0) {
            map = sourceMap.headers;
        }
        if ((i3 & 32) != 0) {
            str2 = sourceMap.cacheKey;
        }
        double d2 = d;
        int i4 = i2;
        return sourceMap.copy(str, i, i4, d2, map, str2);
    }

    @Field
    public static /* synthetic */ void getCacheKey$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getScale$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUri() {
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getScale() {
        return this.scale;
    }

    public final Map<String, String> component5() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final SourceMap copy(String uri, int width, int height, double scale, Map<String, String> headers, String cacheKey) {
        return new SourceMap(uri, width, height, scale, headers, cacheKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceMap)) {
            return false;
        }
        SourceMap sourceMap = (SourceMap) other;
        return Intrinsics.areEqual(this.uri, sourceMap.uri) && this.width == sourceMap.width && this.height == sourceMap.height && Double.compare(this.scale, sourceMap.scale) == 0 && Intrinsics.areEqual(this.headers, sourceMap.headers) && Intrinsics.areEqual(this.cacheKey, sourceMap.cacheKey);
    }

    public int hashCode() {
        String str = this.uri;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Double.hashCode(this.scale)) * 31;
        Map<String, String> map = this.headers;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.cacheKey;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SourceMap(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ", scale=" + this.scale + ", headers=" + this.headers + ", cacheKey=" + this.cacheKey + ")";
    }

    public SourceMap(String str, int i, int i2, double d, Map<String, String> map, String str2) {
        this.uri = str;
        this.width = i;
        this.height = i2;
        this.scale = d;
        this.headers = map;
        this.cacheKey = str2;
    }

    public /* synthetic */ SourceMap(String str, int i, int i2, double d, Map map, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? 1.0d : d, (i3 & 16) != 0 ? null : map, (i3 & 32) != 0 ? null : str2);
    }

    @Override // expo.modules.image.records.Source
    public double getPixelCount() {
        return Source.DefaultImpls.getPixelCount(this);
    }

    public final String getUri() {
        return this.uri;
    }

    @Override // expo.modules.image.records.Source
    public int getWidth() {
        return this.width;
    }

    @Override // expo.modules.image.records.Source
    public int getHeight() {
        return this.height;
    }

    @Override // expo.modules.image.records.Source
    public double getScale() {
        return this.scale;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    private final boolean isDataUrl() {
        String scheme;
        Uri uri = this.parsedUri;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, UriUtil.DATA_SCHEME, false, 2, (Object) null);
    }

    private final boolean isContentUrl() {
        String scheme;
        Uri uri = this.parsedUri;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, UriUtil.LOCAL_CONTENT_SCHEME, false, 2, (Object) null);
    }

    private final boolean isResourceUri() {
        String scheme;
        Uri uri = this.parsedUri;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, UriUtil.QUALIFIED_RESOURCE_SCHEME, false, 2, (Object) null);
    }

    private final boolean isLocalResourceUri() {
        String scheme;
        Uri uri = this.parsedUri;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, UriUtil.LOCAL_RESOURCE_SCHEME, false, 2, (Object) null);
    }

    private final boolean isLocalFileUri() {
        String scheme;
        Uri uri = this.parsedUri;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "file", false, 2, (Object) null);
    }

    private final boolean isBlurhash() {
        String scheme;
        Uri uri = this.parsedUri;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "blurhash", false, 2, (Object) null);
    }

    private final boolean isThumbhash() {
        String scheme;
        Uri uri = this.parsedUri;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return StringsKt.startsWith$default(scheme, "thumbhash", false, 2, (Object) null);
    }

    @Override // expo.modules.image.records.Source
    public boolean usesPlaceholderContentFit() {
        return (isBlurhash() || isThumbhash()) ? false : true;
    }

    private final void parseUri(Context context) {
        if (this.parsedUri == null) {
            this.parsedUri = computeUri(context);
        }
    }

    @Override // expo.modules.image.records.Source
    public GlideModelProvider createGlideModelProvider(Context context) {
        GlideUrlWithCustomCacheKey glideUrlWithCustomCacheKey;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = this.uri;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        parseUri(context);
        if (isContentUrl() || isDataUrl()) {
            return new RawModelProvider(this.uri);
        }
        if (isBlurhash()) {
            Uri uri = this.parsedUri;
            Intrinsics.checkNotNull(uri);
            return new BlurhashModelProvider(uri, getWidth(), getHeight());
        }
        if (isThumbhash()) {
            Uri uri2 = this.parsedUri;
            Intrinsics.checkNotNull(uri2);
            return new ThumbhashModelProvider(uri2);
        }
        if (isResourceUri()) {
            Uri uri3 = this.parsedUri;
            Intrinsics.checkNotNull(uri3);
            return new UriModelProvider(uri3);
        }
        if (isLocalResourceUri()) {
            Uri uri4 = this.parsedUri;
            Intrinsics.checkNotNull(uri4);
            String string = uri4.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Uri uri5 = Uri.parse(StringsKt.replace$default(string, "res:/", "android.resource://" + context.getPackageName() + "/", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(uri5, "parse(...)");
            return new UriModelProvider(uri5);
        }
        if (isLocalFileUri()) {
            Uri uri6 = this.parsedUri;
            Intrinsics.checkNotNull(uri6);
            String string2 = uri6.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            return new RawModelProvider(string2);
        }
        if (this.cacheKey == null) {
            glideUrlWithCustomCacheKey = new GlideUrl(this.uri, getCustomHeaders());
        } else {
            glideUrlWithCustomCacheKey = new GlideUrlWithCustomCacheKey(this.uri, getCustomHeaders(), this.cacheKey);
        }
        return new UrlModelProvider(glideUrlWithCustomCacheKey);
    }

    @Override // expo.modules.image.records.Source
    public RequestOptions createGlideOptions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        parseUri(context);
        RequestOptions requestOptions = new RequestOptions();
        if ((getWidth() == 0 || getHeight() == 0) ? false : true) {
            RequestOptions requestOptionsOverride = requestOptions.override((int) (((double) getWidth()) * getScale()), (int) (((double) getHeight()) * getScale()));
            Intrinsics.checkNotNullExpressionValue(requestOptionsOverride, "override(...)");
            requestOptions = requestOptionsOverride;
        }
        if (!isResourceUri()) {
            return requestOptions;
        }
        RequestOptions requestOptionsApply = requestOptions.apply(RequestOptions.signatureOf(ApplicationVersionSignature.obtain(context)));
        Intrinsics.checkNotNullExpressionValue(requestOptionsApply, "apply(...)");
        return requestOptionsApply;
    }

    private final Headers getCustomHeaders() {
        if (this.headers == null) {
            Headers DEFAULT = LazyHeaders.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            return DEFAULT;
        }
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        LazyHeaders lazyHeadersBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(lazyHeadersBuild, "build(...)");
        return lazyHeadersBuild;
    }

    private final Uri computeUri(Context context) {
        String str = this.uri;
        if (str == null) {
            return null;
        }
        try {
            Uri uri = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            return uri.getScheme() == null ? computeLocalUri(str, context) : uri;
        } catch (Exception unused) {
            return computeLocalUri(str, context);
        }
    }

    private final Uri computeLocalUri(String stringUri, Context context) {
        return ResourceIdHelper.INSTANCE.getResourceUri(context, stringUri);
    }
}
