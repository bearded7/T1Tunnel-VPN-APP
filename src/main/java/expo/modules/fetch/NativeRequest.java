package expo.modules.fetch;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.net.URL;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: NativeRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/fetch/NativeRequest;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "appContext", "Lexpo/modules/kotlin/AppContext;", "response", "Lexpo/modules/fetch/NativeResponse;", "<init>", "(Lexpo/modules/kotlin/AppContext;Lexpo/modules/fetch/NativeResponse;)V", "getResponse$expo_release", "()Lexpo/modules/fetch/NativeResponse;", "requestHolder", "Lexpo/modules/fetch/RequestHolder;", "task", "Lokhttp3/Call;", ViewProps.START, "", "client", "Lokhttp3/OkHttpClient;", ImagesContract.URL, "Ljava/net/URL;", "requestInit", "Lexpo/modules/fetch/NativeRequestInit;", "requestBody", "", "cancel", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeRequest extends SharedObject {
    private final RequestHolder requestHolder;
    private final NativeResponse response;
    private Call task;

    /* JADX INFO: renamed from: getResponse$expo_release, reason: from getter */
    public final NativeResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeRequest(AppContext appContext, NativeResponse response) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(response, "response");
        this.response = response;
        this.requestHolder = new RequestHolder(null);
    }

    public final void start(OkHttpClient client, URL url, NativeRequestInit requestInit, byte[] requestBody) {
        RequestBody requestBodyCreate$default;
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestInit, "requestInit");
        OkHttpClient.Builder builderNewBuilder = client.newBuilder();
        if (requestInit.getCredentials() != NativeRequestCredentials.INCLUDE) {
            builderNewBuilder.cookieJar(CookieJar.NO_COOKIES);
        }
        if (requestInit.getRedirect() != NativeRequestRedirect.FOLLOW) {
            builderNewBuilder.followRedirects(false);
            builderNewBuilder.followSslRedirects(false);
        }
        OkHttpClient okHttpClientBuild = builderNewBuilder.build();
        this.response.setRedirectMode(requestInit.getRedirect());
        Headers headers = RequestUtilsKt.toHeaders(requestInit.getHeaders());
        String str = headers.get("Content-Type");
        MediaType mediaType = str != null ? MediaType.INSTANCE.parse(str) : null;
        if (requestBody == null || (requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.INSTANCE, requestBody, mediaType, 0, 0, 6, (Object) null)) == null) {
            requestBodyCreate$default = ArraysKt.contains(NativeRequestKt.getMETHODS_REQUIRING_BODY(), requestInit.getMethod()) ? RequestBody.Companion.create$default(RequestBody.INSTANCE, new byte[]{0}, mediaType, 0, 0, 6, (Object) null) : null;
        }
        Request requestBuild = new Request.Builder().headers(headers).method(requestInit.getMethod(), requestBodyCreate$default).url(OkHttpFileUrlInterceptor.INSTANCE.handleFileUrl(url)).build();
        this.requestHolder.setRequest(requestBuild);
        Call callNewCall = okHttpClientBuild.newCall(requestBuild);
        this.task = callNewCall;
        if (callNewCall != null) {
            callNewCall.enqueue(this.response);
        }
        this.response.onStarted();
    }

    public final void cancel() {
        Call call = this.task;
        if (call == null) {
            return;
        }
        call.cancel();
        this.response.emitRequestCanceled();
    }
}
