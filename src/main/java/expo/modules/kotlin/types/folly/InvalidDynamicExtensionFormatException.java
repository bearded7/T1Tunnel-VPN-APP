package expo.modules.kotlin.types.folly;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: FollyDynamicExtensionConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/kotlin/types/folly/InvalidDynamicExtensionFormatException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InvalidDynamicExtensionFormatException extends CodedException {
    public InvalidDynamicExtensionFormatException() {
        super("Invalid folly::dynamic extension format", null, 2, null);
    }
}
