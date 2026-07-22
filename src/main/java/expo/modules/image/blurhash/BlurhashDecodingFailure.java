package expo.modules.image.blurhash;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: BlurHashFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashDecodingFailure;", "Lexpo/modules/kotlin/exception/CodedException;", "blurHash", "", "<init>", "(Ljava/lang/String;)V", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlurhashDecodingFailure extends CodedException {
    public BlurhashDecodingFailure(String str) {
        super("Cannot decode provided blurhash '" + str + "'", null, 2, null);
    }
}
