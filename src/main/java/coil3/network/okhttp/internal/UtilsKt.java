package coil3.network.okhttp.internal;

import coil3.network.NetworkClientKt;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkRequest;
import coil3.network.NetworkRequestBody;
import coil3.network.NetworkResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"toRequest", "Lokhttp3/Request;", "Lcoil3/network/NetworkRequest;", "(Lcoil3/network/NetworkRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readByteString", "Lokio/ByteString;", "Lcoil3/network/NetworkRequestBody;", "(Lcoil3/network/NetworkRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toNetworkResponse", "Lcoil3/network/NetworkResponse;", "Lokhttp3/Response;", "toHeaders", "Lokhttp3/Headers;", "Lcoil3/network/NetworkHeaders;", "toNetworkHeaders", "coil-network-okhttp"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class UtilsKt {

    /* JADX INFO: renamed from: coil3.network.okhttp.internal.UtilsKt$readByteString$1, reason: invalid class name */
    /* JADX INFO: compiled from: utils.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.network.okhttp.internal.UtilsKt", f = "utils.kt", i = {0}, l = {39}, m = "readByteString", n = {"buffer"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.readByteString(null, this);
        }
    }

    /* JADX INFO: renamed from: coil3.network.okhttp.internal.UtilsKt$toRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: utils.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.network.okhttp.internal.UtilsKt", f = "utils.kt", i = {0, 0}, l = {32}, m = "toRequest", n = {"$this$toRequest", "request"}, s = {"L$0", "L$1"})
    static final class C00821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00821(Continuation<? super C00821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.toRequest(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object toRequest(NetworkRequest networkRequest, Continuation<? super Request> continuation) {
        C00821 c00821;
        Request.Builder builder;
        String str;
        Request.Builder builder2;
        Request.Builder builder3;
        NetworkRequest networkRequest2;
        String str2;
        if (continuation instanceof C00821) {
            c00821 = (C00821) continuation;
            if ((c00821.label & Integer.MIN_VALUE) != 0) {
                c00821.label -= Integer.MIN_VALUE;
            } else {
                c00821 = new C00821(continuation);
            }
        } else {
            c00821 = new C00821(continuation);
        }
        Object obj = c00821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00821.label;
        RequestBody requestBodyCreate$default = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            builder = new Request.Builder();
            builder.url(networkRequest.getUrl());
            String method = networkRequest.getMethod();
            NetworkRequestBody body = networkRequest.getBody();
            if (body != null) {
                c00821.L$0 = networkRequest;
                c00821.L$1 = builder;
                c00821.L$2 = builder;
                c00821.L$3 = method;
                c00821.label = 1;
                Object byteString = readByteString(body, c00821);
                if (byteString == coroutine_suspended) {
                    return coroutine_suspended;
                }
                builder3 = builder;
                obj = byteString;
                networkRequest2 = networkRequest;
                str2 = method;
                builder2 = builder3;
            } else {
                str = method;
                builder2 = builder;
            }
            String str3 = str;
            networkRequest2 = networkRequest;
            str2 = str3;
            builder3 = builder;
            builder3.method(str2, requestBodyCreate$default);
            builder2.headers(toHeaders(networkRequest2.getHeaders()));
            return builder2.build();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str2 = (String) c00821.L$3;
        builder3 = (Request.Builder) c00821.L$2;
        builder2 = (Request.Builder) c00821.L$1;
        networkRequest2 = (NetworkRequest) c00821.L$0;
        ResultKt.throwOnFailure(obj);
        ByteString byteString2 = (ByteString) obj;
        if (byteString2 != null) {
            requestBodyCreate$default = RequestBody.Companion.create$default(RequestBody.INSTANCE, byteString2, (MediaType) null, 1, (Object) null);
        } else {
            NetworkRequest networkRequest3 = networkRequest2;
            str = str2;
            networkRequest = networkRequest3;
            builder = builder3;
            String str4 = str;
            networkRequest2 = networkRequest;
            str2 = str4;
            builder3 = builder;
        }
        builder3.method(str2, requestBodyCreate$default);
        builder2.headers(toHeaders(networkRequest2.getHeaders()));
        return builder2.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object readByteString(NetworkRequestBody networkRequestBody, Continuation<? super ByteString> continuation) {
        AnonymousClass1 anonymousClass1;
        Buffer buffer;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Buffer buffer2 = new Buffer();
            anonymousClass1.L$0 = buffer2;
            anonymousClass1.label = 1;
            if (networkRequestBody.writeTo(buffer2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            buffer = buffer2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            buffer = (Buffer) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return buffer.readByteString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkResponse toNetworkResponse(Response response) {
        BufferedSource source;
        int iCode = response.code();
        long jSentRequestAtMillis = response.sentRequestAtMillis();
        long jReceivedResponseAtMillis = response.receivedResponseAtMillis();
        NetworkHeaders networkHeaders = toNetworkHeaders(response.headers());
        ResponseBody responseBodyBody = response.body();
        return new NetworkResponse(iCode, jSentRequestAtMillis, jReceivedResponseAtMillis, networkHeaders, (responseBodyBody == null || (source = responseBodyBody.getSource()) == null) ? null : NetworkClientKt.NetworkResponseBody(source), response);
    }

    private static final Headers toHeaders(NetworkHeaders networkHeaders) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : networkHeaders.asMap().entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                builder.addUnsafeNonAscii(key, it.next());
            }
        }
        return builder.build();
    }

    private static final NetworkHeaders toNetworkHeaders(Headers headers) {
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        for (Pair<? extends String, ? extends String> pair : headers) {
            builder.add(pair.component1(), pair.component2());
        }
        return builder.build();
    }
}
