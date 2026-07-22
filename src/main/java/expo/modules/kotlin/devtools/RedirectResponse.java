package expo.modules.kotlin.devtools;

import kotlin.Metadata;
import okhttp3.Response;

/* JADX INFO: compiled from: ExpoNetworkInspectOkHttpInterceptors.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/devtools/RedirectResponse;", "", "<init>", "()V", "requestId", "", "getRequestId", "()Ljava/lang/String;", "setRequestId", "(Ljava/lang/String;)V", "priorResponse", "Lokhttp3/Response;", "getPriorResponse", "()Lokhttp3/Response;", "setPriorResponse", "(Lokhttp3/Response;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedirectResponse {
    private Response priorResponse;
    private String requestId;

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final Response getPriorResponse() {
        return this.priorResponse;
    }

    public final void setPriorResponse(Response response) {
        this.priorResponse = response;
    }
}
