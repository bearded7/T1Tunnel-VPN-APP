package expo.modules.kotlin.devtools;

import kotlin.Metadata;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ExpoNetworkInspectOkHttpInterceptors.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J*\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/devtools/ExpoNetworkInspectOkHttpInterceptorsDelegate;", "", "willSendRequest", "", "requestId", "", "request", "Lokhttp3/Request;", "redirectResponse", "Lokhttp3/Response;", "didReceiveResponse", "response", "body", "Lokhttp3/ResponseBody;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ExpoNetworkInspectOkHttpInterceptorsDelegate {
    void didReceiveResponse(String requestId, Request request, Response response, ResponseBody body);

    void willSendRequest(String requestId, Request request, Response redirectResponse);
}
