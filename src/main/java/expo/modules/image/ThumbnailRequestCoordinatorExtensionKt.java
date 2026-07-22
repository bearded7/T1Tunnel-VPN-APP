package expo.modules.image;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbnailRequestCoordinatorExtension.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a!\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"getPrivateFullRequest", "Lcom/bumptech/glide/request/Request;", "Lcom/bumptech/glide/request/ThumbnailRequestCoordinator;", "getPrivateField", ExifInterface.GPS_DIRECTION_TRUE, "name", "", "(Lcom/bumptech/glide/request/ThumbnailRequestCoordinator;Ljava/lang/String;)Ljava/lang/Object;", "expo-image_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ThumbnailRequestCoordinatorExtensionKt {
    public static final Request getPrivateFullRequest(ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        Intrinsics.checkNotNullParameter(thumbnailRequestCoordinator, "<this>");
        return (Request) getPrivateField(thumbnailRequestCoordinator, "full");
    }

    private static final <T> T getPrivateField(ThumbnailRequestCoordinator thumbnailRequestCoordinator, String str) {
        try {
            Field declaredField = thumbnailRequestCoordinator.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return (T) declaredField.get(thumbnailRequestCoordinator);
        } catch (Throwable th) {
            Log.e("ExpoImage", "Couldn't receive the `" + str + "` field", th);
            return null;
        }
    }
}
