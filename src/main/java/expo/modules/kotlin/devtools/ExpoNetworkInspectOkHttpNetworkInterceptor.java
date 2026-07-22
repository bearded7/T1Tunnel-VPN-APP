package expo.modules.kotlin.devtools;

import android.util.Log;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ExpoNetworkInspectOkHttpInterceptors.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/devtools/ExpoNetworkInspectOkHttpNetworkInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoNetworkInspectOkHttpNetworkInterceptor implements Interceptor {
    public static final long MAX_BODY_SIZE = 1048576;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String strValueOf;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response responseProceed = chain.proceed(request);
        try {
            RedirectResponse redirectResponse = (RedirectResponse) request.tag(RedirectResponse.class);
            if (redirectResponse == null || (strValueOf = redirectResponse.getRequestId()) == null) {
                strValueOf = String.valueOf(request.hashCode());
            }
            ExpoNetworkInspectOkHttpInterceptorsKt.getDelegate().willSendRequest(strValueOf, request, redirectResponse != null ? redirectResponse.getPriorResponse() : null);
            if (responseProceed.isRedirect()) {
                RedirectResponse redirectResponse2 = (RedirectResponse) responseProceed.request().tag(RedirectResponse.class);
                if (redirectResponse2 != null) {
                    redirectResponse2.setRequestId(strValueOf);
                    redirectResponse2.setPriorResponse(responseProceed);
                    return responseProceed;
                }
            } else {
                ResponseBody responseBodyPeekResponseBody$default = ExpoNetworkInspectOkHttpInterceptorsKt.shouldParseBody(responseProceed) ? ExpoNetworkInspectOkHttpInterceptorsKt.peekResponseBody$default(responseProceed, 0L, 2, null) : null;
                ExpoNetworkInspectOkHttpInterceptorsKt.getDelegate().didReceiveResponse(strValueOf, request, responseProceed, responseBodyPeekResponseBody$default);
                if (responseBodyPeekResponseBody$default != null) {
                    responseBodyPeekResponseBody$default.close();
                }
            }
            return responseProceed;
        } catch (Exception e) {
            Log.e("ExpoNetworkInspector", "Failed to send network request CDP event", e);
            return responseProceed;
        }
    }
}
