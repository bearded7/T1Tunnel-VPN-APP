package expo.modules.fetch;

import android.content.Context;
import coil3.network.internal.UtilsKt;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: OkHttpFileUrlInterceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/fetch/OkHttpFileUrlInterceptor;", "Lokhttp3/Interceptor;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Ljava/lang/ref/WeakReference;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "restoreFileUrl", "", ImagesContract.URL, "Lokhttp3/HttpUrl;", "createFileNotFoundResponse", "request", "Lokhttp3/Request;", "createMediaType", "Lokhttp3/MediaType;", "fileName", "createAssetResponseBody", "Lokhttp3/ResponseBody;", "Companion", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OkHttpFileUrlInterceptor implements Interceptor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WeakReference<Context> context;

    public OkHttpFileUrlInterceptor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = new WeakReference<>(context);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws FetchAndroidContextLostException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String strRestoreFileUrl = restoreFileUrl(request.url());
        if (!StringsKt.startsWith$default(strRestoreFileUrl, "file://", false, 2, (Object) null)) {
            return chain.proceed(request);
        }
        if (StringsKt.startsWith$default(strRestoreFileUrl, "file:///android_asset/", false, 2, (Object) null)) {
            String strRemovePrefix = StringsKt.removePrefix(strRestoreFileUrl, (CharSequence) "file:///android_asset/");
            Context context = this.context.get();
            if (context == null) {
                throw new FetchAndroidContextLostException();
            }
            try {
                return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).message("OK").body(createAssetResponseBody(context, strRemovePrefix)).build();
            } catch (IOException unused) {
                return createFileNotFoundResponse(request);
            }
        }
        String strSubstring = strRestoreFileUrl.substring(7);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        File file = new File(strSubstring);
        if (!file.exists()) {
            return createFileNotFoundResponse(request);
        }
        ResponseBody.Companion companion = ResponseBody.INSTANCE;
        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(file));
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).message("OK").body(companion.create(bufferedSourceBuffer, createMediaType(name), file.length())).build();
    }

    private final String restoreFileUrl(HttpUrl url) {
        return StringsKt.replaceFirst$default(url.getUrl(), "http://filesystem.local", "file://", false, 4, (Object) null);
    }

    private final Response createFileNotFoundResponse(Request request) {
        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(404).message("File not found").body(ResponseBody.INSTANCE.create("File not found", MediaType.INSTANCE.get(UtilsKt.MIME_TYPE_TEXT_PLAIN))).build();
    }

    private final MediaType createMediaType(String fileName) {
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(fileName);
        if (strGuessContentTypeFromName == null) {
            strGuessContentTypeFromName = "application/octet-stream";
        }
        MediaType mediaType = MediaType.INSTANCE.parse(strGuessContentTypeFromName);
        return mediaType == null ? MediaType.INSTANCE.get("application/octet-stream") : mediaType;
    }

    public final ResponseBody createAssetResponseBody(Context context, String fileName) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        InputStream inputStreamOpen = context.getAssets().open(fileName);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        return ResponseBody.Companion.create$default(ResponseBody.INSTANCE, Okio.buffer(Okio.source(inputStreamOpen)), createMediaType(fileName), 0L, 2, null);
    }

    /* JADX INFO: compiled from: OkHttpFileUrlInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lexpo/modules/fetch/OkHttpFileUrlInterceptor$Companion;", "", "<init>", "()V", "handleFileUrl", "Ljava/net/URL;", ImagesContract.URL, "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final URL handleFileUrl(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (!Intrinsics.areEqual(url.getProtocol(), "file")) {
                return url;
            }
            return new URL("http://filesystem.local" + url.getPath());
        }
    }
}
