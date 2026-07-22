package expo.modules.image.thumbhash;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: ThumbhashFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecodingFailure;", "Lexpo/modules/kotlin/exception/CodedException;", "thumbhash", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/String;Ljava/lang/Exception;)V", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThumbhashDecodingFailure extends CodedException {
    public ThumbhashDecodingFailure(String str, Exception exc) {
        super("Cannot decode provided thumbhash '" + str + "' " + exc, null, 2, null);
    }
}
