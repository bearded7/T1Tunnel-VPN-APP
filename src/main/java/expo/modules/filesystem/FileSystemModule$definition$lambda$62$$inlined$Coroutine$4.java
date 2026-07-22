package expo.modules.filesystem;

import android.webkit.URLUtil;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$7"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$4", f = "FileSystemModule.kt", i = {0, 0, 0, 0, 0, 0}, l = {283}, m = "invokeSuspend", n = {"options", "to", ImagesContract.URL, "client", "$this$await$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class FileSystemModule$definition$lambda$62$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    public FileSystemModule$definition$lambda$62$$inlined$Coroutine$4(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        FileSystemModule$definition$lambda$62$$inlined$Coroutine$4 fileSystemModule$definition$lambda$62$$inlined$Coroutine$4 = new FileSystemModule$definition$lambda$62$$inlined$Coroutine$4(continuation);
        fileSystemModule$definition$lambda$62$$inlined$Coroutine$4.L$0 = objArr;
        return fileSystemModule$definition$lambda$62$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        URI uri;
        FileSystemPath fileSystemPath;
        DownloadOptions downloadOptions;
        Map<String, String> headers;
        File javaFile;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            FileSystemModule$definition$lambda$62$$inlined$Coroutine$4 fileSystemModule$definition$lambda$62$$inlined$Coroutine$4 = this;
            DownloadOptions downloadOptions2 = (DownloadOptions) objArr[2];
            FileSystemPath fileSystemPath2 = (FileSystemPath) obj3;
            URI uri2 = (URI) obj2;
            fileSystemPath2.validatePermission(Permission.WRITE);
            Request.Builder builder = new Request.Builder();
            URL url = uri2.toURL();
            Intrinsics.checkNotNullExpressionValue(url, "toURL(...)");
            Request.Builder builderUrl = builder.url(url);
            if (downloadOptions2 != null && (headers = downloadOptions2.getHeaders()) != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    builderUrl.addHeader(entry.getKey(), entry.getValue());
                }
            }
            Request requestBuild = builderUrl.build();
            OkHttpClient okHttpClient = new OkHttpClient();
            this.L$0 = downloadOptions2;
            this.L$1 = fileSystemPath2;
            this.L$2 = uri2;
            this.L$3 = okHttpClient;
            this.L$4 = requestBuild;
            this.L$5 = this;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(fileSystemModule$definition$lambda$62$$inlined$Coroutine$4), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            okHttpClient.newCall(requestBuild).enqueue(new Callback() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$8$$inlined$await$1
                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m772constructorimpl(response));
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException e) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    if (cancellableContinuationImpl2.isCancelled()) {
                        return;
                    }
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m772constructorimpl(ResultKt.createFailure(e)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(fileSystemModule$definition$lambda$62$$inlined$Coroutine$4);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
            uri = uri2;
            fileSystemPath = fileSystemPath2;
            downloadOptions = downloadOptions2;
            obj = result;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uri = (URI) this.L$2;
            fileSystemPath = (FileSystemPath) this.L$1;
            downloadOptions = (DownloadOptions) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Response response = (Response) obj;
        if (!response.isSuccessful()) {
            throw new UnableToDownloadException("response has status: " + response.code());
        }
        String strGuessFileName = URLUtil.guessFileName(uri.toString(), response.headers().get("content-disposition"), response.headers().get("content-type"));
        if (fileSystemPath instanceof FileSystemDirectory) {
            javaFile = new File(fileSystemPath.getJavaFile(), strGuessFileName);
        } else {
            javaFile = fileSystemPath.getJavaFile();
        }
        if ((downloadOptions == null || !downloadOptions.getIdempotent()) && javaFile.exists()) {
            throw new DestinationAlreadyExistsException();
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            throw new UnableToDownloadException("response body is null");
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        try {
            InputStream inputStream = inputStreamByteStream;
            FileOutputStream fileOutputStream = new FileOutputStream(javaFile);
            try {
                ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(inputStreamByteStream, null);
                return javaFile.toURI();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStreamByteStream, th3);
                throw th4;
            }
        }
    }
}
