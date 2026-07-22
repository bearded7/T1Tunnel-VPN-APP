package expo.modules.filesystem.legacy;

import kotlin.Metadata;

/* JADX INFO: compiled from: CountingRequestBody.kt */
/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lexpo/modules/filesystem/legacy/CountingRequestListener;", "", "onProgress", "", "bytesWritten", "", "contentLength", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CountingRequestListener {
    void onProgress(long bytesWritten, long contentLength);
}
