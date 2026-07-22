package expo.modules.font;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontLoaderModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/font/FileNotFoundException;", "Lexpo/modules/kotlin/exception/CodedException;", "uri", "", "<init>", "(Ljava/lang/String;)V", "expo-font_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FileNotFoundException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileNotFoundException(String uri) {
        super("File '" + uri + "' doesn't exist", null, 2, null);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }
}
