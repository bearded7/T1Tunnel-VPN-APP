package coil3.network;

import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.disk.DiskCache;
import coil3.fetch.SourceFetchResult;
import coil3.network.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okio.Buffer;

/* JADX INFO: compiled from: NetworkFetcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$fetchResult$1", f = "NetworkFetcher.kt", i = {0, 1}, l = {76, 87}, m = "invokeSuspend", n = {"response", "response"}, s = {"L$0", "L$0"})
final class NetworkFetcher$fetch$fetchResult$1 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    final /* synthetic */ Ref.ObjectRef<NetworkResponse> $cacheResponse;
    final /* synthetic */ NetworkRequest $networkRequest;
    final /* synthetic */ Ref.ObjectRef<DiskCache.Snapshot> $snapshot;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NetworkFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkFetcher$fetch$fetchResult$1(Ref.ObjectRef<DiskCache.Snapshot> objectRef, NetworkFetcher networkFetcher, Ref.ObjectRef<NetworkResponse> objectRef2, NetworkRequest networkRequest, Continuation<? super NetworkFetcher$fetch$fetchResult$1> continuation) {
        super(2, continuation);
        this.$snapshot = objectRef;
        this.this$0 = networkFetcher;
        this.$cacheResponse = objectRef2;
        this.$networkRequest = networkRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$1 = new NetworkFetcher$fetch$fetchResult$1(this.$snapshot, this.this$0, this.$cacheResponse, this.$networkRequest, continuation);
        networkFetcher$fetch$fetchResult$1.L$0 = obj;
        return networkFetcher$fetch$fetchResult$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
        return ((NetworkFetcher$fetch$fetchResult$1) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e8 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, coil3.network.NetworkResponse] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Ref.ObjectRef<DiskCache.Snapshot> objectRef;
        NetworkResponse networkResponse;
        T t;
        NetworkResponse networkResponse2;
        NetworkHeaders headers;
        Object obj2;
        Buffer buffer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = null;
        if (i != 0) {
            if (i == 1) {
                objectRef = (Ref.ObjectRef) this.L$1;
                networkResponse = (NetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                t = obj;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResponse2 = (NetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            }
            buffer = (Buffer) obj2;
            if (buffer.size() > 0) {
                return null;
            }
            ImageSource imageSource = this.this$0.toImageSource(buffer);
            NetworkFetcher networkFetcher = this.this$0;
            return new SourceFetchResult(imageSource, networkFetcher.getMimeType(networkFetcher.url, networkResponse2.getHeaders().get("Content-Type")), DataSource.NETWORK);
        }
        ResultKt.throwOnFailure(obj);
        NetworkResponse networkResponse3 = (NetworkResponse) this.L$0;
        objectRef = this.$snapshot;
        this.L$0 = networkResponse3;
        this.L$1 = objectRef;
        this.label = 1;
        Object objWriteToDiskCache = this.this$0.writeToDiskCache(objectRef.element, this.$cacheResponse.element, this.$networkRequest, networkResponse3, this);
        if (objWriteToDiskCache != coroutine_suspended) {
            networkResponse = networkResponse3;
            t = objWriteToDiskCache;
        }
        return coroutine_suspended;
        objectRef.element = t;
        if (this.$snapshot.element != null) {
            Ref.ObjectRef<NetworkResponse> objectRef2 = this.$cacheResponse;
            NetworkFetcher networkFetcher2 = this.this$0;
            DiskCache.Snapshot snapshot = this.$snapshot.element;
            Intrinsics.checkNotNull(snapshot);
            objectRef2.element = networkFetcher2.toNetworkResponseOrNull(snapshot);
            NetworkFetcher networkFetcher3 = this.this$0;
            DiskCache.Snapshot snapshot2 = this.$snapshot.element;
            Intrinsics.checkNotNull(snapshot2);
            ImageSource imageSource2 = networkFetcher3.toImageSource(snapshot2);
            NetworkFetcher networkFetcher4 = this.this$0;
            String str2 = networkFetcher4.url;
            NetworkResponse networkResponse4 = this.$cacheResponse.element;
            if (networkResponse4 != null && (headers = networkResponse4.getHeaders()) != null) {
                str = headers.get("Content-Type");
            }
            return new SourceFetchResult(imageSource2, networkFetcher4.getMimeType(str2, str), DataSource.NETWORK);
        }
        this.L$0 = networkResponse;
        this.L$1 = null;
        this.label = 2;
        Object buffer2 = UtilsKt.readBuffer(UtilsKt.requireBody(networkResponse), this);
        if (buffer2 != coroutine_suspended) {
            networkResponse2 = networkResponse;
            obj2 = buffer2;
            buffer = (Buffer) obj2;
            if (buffer.size() > 0) {
                return null;
            }
            ImageSource imageSource3 = this.this$0.toImageSource(buffer);
            NetworkFetcher networkFetcher5 = this.this$0;
            return new SourceFetchResult(imageSource3, networkFetcher5.getMimeType(networkFetcher5.url, networkResponse2.getHeaders().get("Content-Type")), DataSource.NETWORK);
        }
        return coroutine_suspended;
    }
}
