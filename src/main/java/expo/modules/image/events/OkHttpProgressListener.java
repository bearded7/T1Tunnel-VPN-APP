package expo.modules.image.events;

import com.facebook.react.modules.network.ProgressListener;
import expo.modules.image.ExpoImageViewWrapper;
import expo.modules.image.records.ImageProgressEvent;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OkHttpProgressListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/image/events/OkHttpProgressListener;", "Lcom/facebook/react/modules/network/ProgressListener;", "expoImageViewWrapper", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/image/ExpoImageViewWrapper;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "onProgress", "", "bytesWritten", "", "contentLength", "done", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OkHttpProgressListener implements ProgressListener {
    private final WeakReference<ExpoImageViewWrapper> expoImageViewWrapper;

    public OkHttpProgressListener(WeakReference<ExpoImageViewWrapper> expoImageViewWrapper) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, "expoImageViewWrapper");
        this.expoImageViewWrapper = expoImageViewWrapper;
    }

    @Override // com.facebook.react.modules.network.ProgressListener
    public void onProgress(long bytesWritten, long contentLength, boolean done) {
        ExpoImageViewWrapper expoImageViewWrapper;
        ViewEventCallback<ImageProgressEvent> onProgress$expo_image_release;
        if (contentLength <= 0 || done || (expoImageViewWrapper = this.expoImageViewWrapper.get()) == null || (onProgress$expo_image_release = expoImageViewWrapper.getOnProgress$expo_image_release()) == null) {
            return;
        }
        onProgress$expo_image_release.invoke(new ImageProgressEvent((int) bytesWritten, (int) contentLength));
    }
}
