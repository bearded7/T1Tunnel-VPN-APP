package expo.modules.image;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/image/ImageLoadFailed;", "Lexpo/modules/kotlin/exception/CodedException;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageLoadFailed extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoadFailed(Exception exception) {
        super("Failed to load the image: " + exception.getMessage(), null, 2, null);
        Intrinsics.checkNotNullParameter(exception, "exception");
    }
}
