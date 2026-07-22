package coil3.network;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.fetch.SourceFetchResult;
import coil3.network.internal.SingleParameterLazy;
import coil3.network.internal.SingleParameterLazyKt;
import coil3.network.internal.UtilsKt;
import coil3.network.internal.Utils_androidKt;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import com.canhub.cropper.CropImage;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import okio.Buffer;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

/* JADX INFO: compiled from: NetworkFetcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00016BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J4\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J@\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00020\u001b2\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0082@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010)\u001a\u0004\u0018\u00010\u0019*\u00020\u0015H\u0002J\f\u0010*\u001a\u00020+*\u00020\u0015H\u0002J\u0012\u0010*\u001a\u00020+*\u00020,H\u0082@¢\u0006\u0002\u0010-J\f\u0010*\u001a\u00020+*\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcoil3/network/NetworkFetcher;", "Lcoil3/fetch/Fetcher;", ImagesContract.URL, "", "options", "Lcoil3/request/Options;", "networkClient", "Lkotlin/Lazy;", "Lcoil3/network/NetworkClient;", "diskCache", "Lcoil3/disk/DiskCache;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Ljava/lang/String;Lcoil3/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Lkotlin/Lazy;Lcoil3/network/ConnectivityChecker;)V", "fetch", "Lcoil3/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromDiskCache", "Lcoil3/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil3/network/NetworkResponse;", "networkRequest", "Lcoil3/network/NetworkRequest;", "networkResponse", "(Lcoil3/disk/DiskCache$Snapshot;Lcoil3/network/NetworkResponse;Lcoil3/network/NetworkRequest;Lcoil3/network/NetworkResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newRequest", "executeNetworkRequest", ExifInterface.GPS_DIRECTION_TRUE, "request", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "toNetworkResponseOrNull", "toImageSource", "Lcoil3/decode/ImageSource;", "Lcoil3/network/NetworkResponseBody;", "(Lcoil3/network/NetworkResponseBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokio/Buffer;", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "Factory", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NetworkFetcher implements Fetcher {
    private final Lazy<CacheStrategy> cacheStrategy;
    private final ConnectivityChecker connectivityChecker;
    private final Lazy<DiskCache> diskCache;
    private final Lazy<NetworkClient> networkClient;
    private final Options options;
    private final String url;

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$fetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkFetcher.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0, 0, 1, 1, 2}, l = {LockFreeTaskQueueCore.CLOSED_SHIFT, 74, 102}, m = "fetch", n = {"this", "snapshot", "cacheResponse", "this", "snapshot", "snapshot"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.fetch(this);
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$toImageSource$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetworkFetcher.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0}, l = {244}, m = "toImageSource", n = {"this", "buffer"}, s = {"L$0", "L$1"})
    static final class C00801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00801(Continuation<? super C00801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.toImageSource(null, this);
        }
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$writeToDiskCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetworkFetcher.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.network.NetworkFetcher", f = "NetworkFetcher.kt", i = {0, 0, 0, 1, 1, 1}, l = {138, 153}, m = "writeToDiskCache", n = {"this", "snapshot", "networkResponse", "networkResponse", "modifiedNetworkResponse", "editor"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C00811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00811(Continuation<? super C00811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NetworkFetcher.this.writeToDiskCache(null, null, null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkFetcher(String str, Options options, Lazy<? extends NetworkClient> lazy, Lazy<? extends DiskCache> lazy2, Lazy<? extends CacheStrategy> lazy3, ConnectivityChecker connectivityChecker) {
        this.url = str;
        this.options = options;
        this.networkClient = lazy;
        this.diskCache = lazy2;
        this.cacheStrategy = lazy3;
        this.connectivityChecker = connectivityChecker;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0143  */
    /* JADX WARN: Code duplicated, block: B:63:0x0149 A[Catch: Exception -> 0x004f, TRY_LEAVE, TryCatch #0 {Exception -> 0x004f, blocks: (B:21:0x004a, B:61:0x0145, B:63:0x0149), top: B:78:0x004a }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0161  */
    /* JADX WARN: Code duplicated, block: B:76:0x0172  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:83:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, coil3.disk.DiskCache$Snapshot] */
    /* JADX WARN: Type inference failed for: r7v8, types: [T, coil3.network.NetworkResponse] */
    @Override // coil3.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> continuation) throws Exception {
        AnonymousClass1 anonymousClass1;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        NetworkFetcher networkFetcher;
        Ref.ObjectRef objectRef3;
        CacheStrategy.ReadResult readResult;
        Ref.ObjectRef objectRef4;
        NetworkFetcher networkFetcher2;
        Exception exc;
        NetworkRequest request;
        Ref.ObjectRef objectRef5;
        NetworkFetcher networkFetcher3;
        SourceFetchResult sourceFetchResult;
        DiskCache.Snapshot snapshot;
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
        Object objExecuteNetworkRequest = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objExecuteNetworkRequest);
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            objectRef6.element = readFromDiskCache();
            try {
                objectRef2 = new Ref.ObjectRef();
                if (objectRef6.element != 0) {
                    Long size = getFileSystem().metadata(((DiskCache.Snapshot) objectRef6.element).getMetadata()).getSize();
                    if (size != null && size.longValue() == 0) {
                        return new SourceFetchResult(toImageSource((DiskCache.Snapshot) objectRef6.element), getMimeType(this.url, null), DataSource.DISK);
                    }
                    objectRef2.element = toNetworkResponseOrNull((DiskCache.Snapshot) objectRef6.element);
                    if (objectRef2.element != 0) {
                        CacheStrategy value = this.cacheStrategy.getValue();
                        NetworkResponse networkResponse = (NetworkResponse) objectRef2.element;
                        NetworkRequest networkRequestNewRequest = newRequest();
                        Options options = this.options;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = objectRef6;
                        anonymousClass1.L$2 = objectRef2;
                        anonymousClass1.label = 1;
                        Object obj = value.read(networkResponse, networkRequestNewRequest, options, anonymousClass1);
                        if (obj != coroutine_suspended) {
                            objectRef4 = objectRef6;
                            objExecuteNetworkRequest = obj;
                            networkFetcher2 = this;
                        }
                    }
                    return coroutine_suspended;
                }
                networkFetcher = this;
                objectRef3 = objectRef6;
                readResult = null;
                Ref.ObjectRef objectRef7 = objectRef2;
                if (readResult != null) {
                    try {
                        request = readResult.getRequest();
                        if (request == null) {
                        }
                        NetworkRequest networkRequest = request;
                        NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$1 = new NetworkFetcher$fetch$fetchResult$1(objectRef3, networkFetcher, objectRef7, networkRequest, null);
                        anonymousClass1.L$0 = networkFetcher;
                        anonymousClass1.L$1 = objectRef3;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.label = 2;
                        objExecuteNetworkRequest = networkFetcher.executeNetworkRequest(networkRequest, networkFetcher$fetch$fetchResult$1, anonymousClass1);
                        if (objExecuteNetworkRequest != coroutine_suspended) {
                            objectRef5 = objectRef3;
                            networkFetcher3 = networkFetcher;
                            sourceFetchResult = (SourceFetchResult) objExecuteNetworkRequest;
                            if (sourceFetchResult != null) {
                                return sourceFetchResult;
                            }
                            NetworkRequest networkRequestNewRequest2 = networkFetcher3.newRequest();
                            C00792 c00792 = networkFetcher3.new C00792(null);
                            anonymousClass1.L$0 = objectRef5;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 3;
                            objExecuteNetworkRequest = networkFetcher3.executeNetworkRequest(networkRequestNewRequest2, c00792, anonymousClass1);
                            if (objExecuteNetworkRequest != coroutine_suspended) {
                                objectRef = objectRef5;
                                return (SourceFetchResult) objExecuteNetworkRequest;
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e) {
                        exc = e;
                        objectRef = objectRef3;
                        snapshot = (DiskCache.Snapshot) objectRef.element;
                        if (snapshot == null) {
                            throw exc;
                        }
                        UtilsKt.closeQuietly(snapshot);
                        throw exc;
                    }
                }
                request = networkFetcher.newRequest();
                NetworkRequest networkRequest2 = request;
                NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$2 = new NetworkFetcher$fetch$fetchResult$1(objectRef3, networkFetcher, objectRef7, networkRequest2, null);
                anonymousClass1.L$0 = networkFetcher;
                anonymousClass1.L$1 = objectRef3;
                anonymousClass1.L$2 = null;
                anonymousClass1.label = 2;
                objExecuteNetworkRequest = networkFetcher.executeNetworkRequest(networkRequest2, networkFetcher$fetch$fetchResult$2, anonymousClass1);
                if (objExecuteNetworkRequest != coroutine_suspended) {
                    objectRef5 = objectRef3;
                    networkFetcher3 = networkFetcher;
                    sourceFetchResult = (SourceFetchResult) objExecuteNetworkRequest;
                    if (sourceFetchResult != null) {
                        return sourceFetchResult;
                    }
                    NetworkRequest networkRequestNewRequest3 = networkFetcher3.newRequest();
                    C00792 c00793 = networkFetcher3.new C00792(null);
                    anonymousClass1.L$0 = objectRef5;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 3;
                    objExecuteNetworkRequest = networkFetcher3.executeNetworkRequest(networkRequestNewRequest3, c00793, anonymousClass1);
                    if (objExecuteNetworkRequest != coroutine_suspended) {
                        objectRef = objectRef5;
                        return (SourceFetchResult) objExecuteNetworkRequest;
                    }
                }
                return coroutine_suspended;
            } catch (Exception e2) {
                e = e2;
                objectRef = objectRef6;
                exc = e;
                snapshot = (DiskCache.Snapshot) objectRef.element;
                if (snapshot == null) {
                    throw exc;
                }
                UtilsKt.closeQuietly(snapshot);
                throw exc;
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objExecuteNetworkRequest);
                    return (SourceFetchResult) objExecuteNetworkRequest;
                } catch (Exception e3) {
                    e = e3;
                    exc = e;
                    snapshot = (DiskCache.Snapshot) objectRef.element;
                    if (snapshot == null) {
                        throw exc;
                    }
                    UtilsKt.closeQuietly(snapshot);
                    throw exc;
                }
            }
            objectRef5 = (Ref.ObjectRef) anonymousClass1.L$1;
            networkFetcher3 = (NetworkFetcher) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(objExecuteNetworkRequest);
                sourceFetchResult = (SourceFetchResult) objExecuteNetworkRequest;
                if (sourceFetchResult != null) {
                    return sourceFetchResult;
                }
                NetworkRequest networkRequestNewRequest4 = networkFetcher3.newRequest();
                C00792 c00794 = networkFetcher3.new C00792(null);
                anonymousClass1.L$0 = objectRef5;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 3;
                objExecuteNetworkRequest = networkFetcher3.executeNetworkRequest(networkRequestNewRequest4, c00794, anonymousClass1);
                if (objExecuteNetworkRequest != coroutine_suspended) {
                    objectRef = objectRef5;
                    return (SourceFetchResult) objExecuteNetworkRequest;
                }
                return coroutine_suspended;
            } catch (Exception e4) {
                exc = e4;
                objectRef = objectRef5;
                snapshot = (DiskCache.Snapshot) objectRef.element;
                if (snapshot == null) {
                    throw exc;
                }
                UtilsKt.closeQuietly(snapshot);
                throw exc;
            }
        }
        objectRef2 = (Ref.ObjectRef) anonymousClass1.L$2;
        objectRef4 = (Ref.ObjectRef) anonymousClass1.L$1;
        networkFetcher2 = (NetworkFetcher) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(objExecuteNetworkRequest);
        } catch (Exception e5) {
            exc = e5;
            objectRef = objectRef4;
            snapshot = (DiskCache.Snapshot) objectRef.element;
            if (snapshot == null) {
                throw exc;
            }
            UtilsKt.closeQuietly(snapshot);
            throw exc;
        }
        readResult = (CacheStrategy.ReadResult) objExecuteNetworkRequest;
        if (readResult.getResponse() != null) {
            return new SourceFetchResult(networkFetcher2.toImageSource((DiskCache.Snapshot) objectRef4.element), networkFetcher2.getMimeType(networkFetcher2.url, readResult.getResponse().getHeaders().get("Content-Type")), DataSource.DISK);
        }
        objectRef3 = objectRef4;
        networkFetcher = networkFetcher2;
        Ref.ObjectRef objectRef8 = objectRef2;
        if (readResult != null) {
            request = readResult.getRequest();
            if (request == null) {
            }
            NetworkRequest networkRequest3 = request;
            NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$3 = new NetworkFetcher$fetch$fetchResult$1(objectRef3, networkFetcher, objectRef8, networkRequest3, null);
            anonymousClass1.L$0 = networkFetcher;
            anonymousClass1.L$1 = objectRef3;
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 2;
            objExecuteNetworkRequest = networkFetcher.executeNetworkRequest(networkRequest3, networkFetcher$fetch$fetchResult$3, anonymousClass1);
            if (objExecuteNetworkRequest != coroutine_suspended) {
                objectRef5 = objectRef3;
                networkFetcher3 = networkFetcher;
                sourceFetchResult = (SourceFetchResult) objExecuteNetworkRequest;
                if (sourceFetchResult != null) {
                    return sourceFetchResult;
                }
                NetworkRequest networkRequestNewRequest5 = networkFetcher3.newRequest();
                C00792 c00795 = networkFetcher3.new C00792(null);
                anonymousClass1.L$0 = objectRef5;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 3;
                objExecuteNetworkRequest = networkFetcher3.executeNetworkRequest(networkRequestNewRequest5, c00795, anonymousClass1);
                if (objExecuteNetworkRequest != coroutine_suspended) {
                    objectRef = objectRef5;
                    return (SourceFetchResult) objExecuteNetworkRequest;
                }
            }
            return coroutine_suspended;
        }
        request = networkFetcher.newRequest();
        NetworkRequest networkRequest4 = request;
        NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$4 = new NetworkFetcher$fetch$fetchResult$1(objectRef3, networkFetcher, objectRef8, networkRequest4, null);
        anonymousClass1.L$0 = networkFetcher;
        anonymousClass1.L$1 = objectRef3;
        anonymousClass1.L$2 = null;
        anonymousClass1.label = 2;
        objExecuteNetworkRequest = networkFetcher.executeNetworkRequest(networkRequest4, networkFetcher$fetch$fetchResult$4, anonymousClass1);
        if (objExecuteNetworkRequest != coroutine_suspended) {
            objectRef5 = objectRef3;
            networkFetcher3 = networkFetcher;
            sourceFetchResult = (SourceFetchResult) objExecuteNetworkRequest;
            if (sourceFetchResult != null) {
                return sourceFetchResult;
            }
            NetworkRequest networkRequestNewRequest6 = networkFetcher3.newRequest();
            C00792 c00796 = networkFetcher3.new C00792(null);
            anonymousClass1.L$0 = objectRef5;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            objExecuteNetworkRequest = networkFetcher3.executeNetworkRequest(networkRequestNewRequest6, c00796, anonymousClass1);
            if (objExecuteNetworkRequest != coroutine_suspended) {
                objectRef = objectRef5;
                return (SourceFetchResult) objExecuteNetworkRequest;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$fetch$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NetworkFetcher.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$2", f = "NetworkFetcher.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
    static final class C00792 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C00792(Continuation<? super C00792> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00792 c00792 = NetworkFetcher.this.new C00792(continuation);
            c00792.L$0 = obj;
            return c00792;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NetworkResponse networkResponse, Continuation<? super SourceFetchResult> continuation) {
            return ((C00792) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NetworkResponse networkResponse;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NetworkResponse networkResponse2 = (NetworkResponse) this.L$0;
                this.L$0 = networkResponse2;
                this.label = 1;
                Object imageSource = NetworkFetcher.this.toImageSource(UtilsKt.requireBody(networkResponse2), this);
                if (imageSource == coroutine_suspended) {
                    return coroutine_suspended;
                }
                networkResponse = networkResponse2;
                obj = imageSource;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResponse = (NetworkResponse) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            NetworkFetcher networkFetcher = NetworkFetcher.this;
            return new SourceFetchResult((ImageSource) obj, networkFetcher.getMimeType(networkFetcher.url, networkResponse.getHeaders().get("Content-Type")), DataSource.NETWORK);
        }
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:68:0x0120  */
    /* JADX WARN: Code duplicated, block: B:71:0x012b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0109, code lost:
    
        if (r0.writeTo(r14, r3, r7) == r1) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeToDiskCache(coil3.disk.DiskCache.Snapshot r12, coil3.network.NetworkResponse r13, coil3.network.NetworkRequest r14, coil3.network.NetworkResponse r15, kotlin.coroutines.Continuation<? super coil3.disk.DiskCache.Snapshot> r16) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.writeToDiskCache(coil3.disk.DiskCache$Snapshot, coil3.network.NetworkResponse, coil3.network.NetworkRequest, coil3.network.NetworkResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final NetworkRequest newRequest() {
        NetworkHeaders.Builder builderNewBuilder = ImageRequestsKt.getHttpHeaders(this.options).newBuilder();
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean z = this.options.getNetworkCachePolicy().getReadEnabled() && this.connectivityChecker.isOnline();
        if (!z && readEnabled) {
            builderNewBuilder.set("Cache-Control", "only-if-cached, max-stale=2147483647");
        } else if (!z || readEnabled) {
            if (!z && !readEnabled) {
                builderNewBuilder.set("Cache-Control", "no-cache, only-if-cached");
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            builderNewBuilder.set("Cache-Control", "no-cache");
        } else {
            builderNewBuilder.set("Cache-Control", "no-cache, no-store");
        }
        return new NetworkRequest(this.url, ImageRequestsKt.getHttpMethod(this.options), builderNewBuilder.build(), ImageRequestsKt.getHttpBody(this.options));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object executeNetworkRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.options.getNetworkCachePolicy().getReadEnabled()) {
            Utils_androidKt.assertNotOnMainThread();
        }
        return this.networkClient.getValue().executeRequest(networkRequest, new AnonymousClass2(function2, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: coil3.network.NetworkFetcher$executeNetworkRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkFetcher.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "coil3.network.NetworkFetcher$executeNetworkRequest$2", f = "NetworkFetcher.kt", i = {}, l = {CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<NetworkResponse, Continuation<? super T>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(NetworkResponse networkResponse, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(networkResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            NetworkResponse networkResponse = (NetworkResponse) this.L$0;
            int code = networkResponse.getCode();
            if ((200 > code || code >= 300) && networkResponse.getCode() != 304) {
                throw new HttpException(networkResponse);
            }
            Function2<NetworkResponse, Continuation<? super T>, Object> function2 = this.$block;
            this.label = 1;
            Object objInvoke = function2.invoke(networkResponse, this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    public final String getMimeType(String url, String contentType) {
        String mimeTypeFromUrl;
        if ((contentType == null || StringsKt.startsWith$default(contentType, UtilsKt.MIME_TYPE_TEXT_PLAIN, false, 2, (Object) null)) && (mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(url)) != null) {
            return mimeTypeFromUrl;
        }
        if (contentType != null) {
            return StringsKt.substringBefore$default(contentType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NetworkResponse toNetworkResponseOrNull(DiskCache.Snapshot snapshot) throws Throwable {
        Throwable th;
        NetworkResponse from;
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                from = CacheNetworkResponse.INSTANCE.readFrom(bufferedSourceBuffer);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                th = null;
            } catch (Throwable th3) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                from = null;
            }
            if (th == null) {
                return from;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSourceKt.ImageSource$default(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object toImageSource(NetworkResponseBody networkResponseBody, Continuation<? super ImageSource> continuation) {
        C00801 c00801;
        NetworkFetcher networkFetcher;
        Buffer buffer;
        if (continuation instanceof C00801) {
            c00801 = (C00801) continuation;
            if ((c00801.label & Integer.MIN_VALUE) != 0) {
                c00801.label -= Integer.MIN_VALUE;
            } else {
                c00801 = new C00801(continuation);
            }
        } else {
            c00801 = new C00801(continuation);
        }
        Object obj = c00801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c00801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Buffer buffer2 = new Buffer();
            c00801.L$0 = this;
            c00801.L$1 = buffer2;
            c00801.label = 1;
            if (networkResponseBody.writeTo(buffer2, c00801) == coroutine_suspended) {
                return coroutine_suspended;
            }
            networkFetcher = this;
            buffer = buffer2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            buffer = (Buffer) c00801.L$1;
            networkFetcher = (NetworkFetcher) c00801.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return networkFetcher.toImageSource(buffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSource toImageSource(Buffer buffer) {
        return ImageSourceKt.ImageSource$default(buffer, getFileSystem(), null, 4, null);
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        FileSystem fileSystem;
        DiskCache value = this.diskCache.getValue();
        return (value == null || (fileSystem = value.getFileSystem()) == null) ? this.options.getFileSystem() : fileSystem;
    }

    /* JADX INFO: compiled from: NetworkFetcher.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcoil3/network/NetworkFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "networkClient", "Lkotlin/Function0;", "Lcoil3/network/NetworkClient;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "Lcoil3/network/ConnectivityChecker;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "networkClientLazy", "Lkotlin/Lazy;", "cacheStrategyLazy", "connectivityCheckerLazy", "Lcoil3/network/internal/SingleParameterLazy;", "create", "Lcoil3/fetch/Fetcher;", UriUtil.DATA_SCHEME, "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "isApplicable", "", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<CacheStrategy> cacheStrategyLazy;
        private final SingleParameterLazy<Context, ConnectivityChecker> connectivityCheckerLazy;
        private final Lazy<NetworkClient> networkClientLazy;

        public Factory(Function0<? extends NetworkClient> function0, Function0<? extends CacheStrategy> function1, Function1<? super Context, ? extends ConnectivityChecker> function2) {
            this.networkClientLazy = LazyKt.lazy(function0);
            this.cacheStrategyLazy = LazyKt.lazy(function1);
            this.connectivityCheckerLazy = SingleParameterLazyKt.singleParameterLazy(function2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: renamed from: coil3.network.NetworkFetcher$Factory$2, reason: invalid class name */
        /* JADX INFO: compiled from: NetworkFetcher.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Context, ConnectivityChecker> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            AnonymousClass2() {
                super(1, ConnectivityCheckerKt.class, "ConnectivityChecker", "ConnectivityChecker(Landroid/content/Context;)Lcoil3/network/ConnectivityChecker;", 1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ConnectivityChecker invoke(Context context) {
                return ConnectivityCheckerKt.ConnectivityChecker(context);
            }
        }

        public /* synthetic */ Factory(Function0 function0, Function0 function1, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, (i & 2) != 0 ? new Function0() { // from class: coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CacheStrategy.DEFAULT;
                }
            } : function1, (i & 4) != 0 ? AnonymousClass2.INSTANCE : anonymousClass2);
        }

        @Override // coil3.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, final ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new NetworkFetcher(data.getData(), options, this.networkClientLazy, LazyKt.lazy(new Function0() { // from class: coil3.network.NetworkFetcher$Factory$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return imageLoader.getDiskCache();
                    }
                }), this.cacheStrategyLazy, this.connectivityCheckerLazy.get(options.getContext()));
            }
            return null;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), UriUtil.HTTP_SCHEME) || Intrinsics.areEqual(data.getScheme(), UriUtil.HTTPS_SCHEME);
        }
    }
}
