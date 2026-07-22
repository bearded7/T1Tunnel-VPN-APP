package expo.modules.filesystem.legacy;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* JADX INFO: compiled from: CountingRequestBody.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/filesystem/legacy/CountingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "requestBody", "Lokhttp3/RequestBody;", "progressListener", "Lexpo/modules/filesystem/legacy/CountingRequestListener;", "<init>", "(Lokio/Sink;Lokhttp3/RequestBody;Lexpo/modules/filesystem/legacy/CountingRequestListener;)V", "bytesWritten", "", "write", "", "source", "Lokio/Buffer;", "byteCount", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class CountingSink extends ForwardingSink {
    private long bytesWritten;
    private final CountingRequestListener progressListener;
    private final RequestBody requestBody;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountingSink(Sink sink, RequestBody requestBody, CountingRequestListener progressListener) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.requestBody = requestBody;
        this.progressListener = progressListener;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        super.write(source, byteCount);
        long j = this.bytesWritten + byteCount;
        this.bytesWritten = j;
        this.progressListener.onProgress(j, this.requestBody.contentLength());
    }
}
