package expo.modules.kotlin.exception;

import kotlin.Metadata;

/* JADX INFO: compiled from: CodedException.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/kotlin/exception/MethodNotFoundException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MethodNotFoundException extends CodedException {
    public MethodNotFoundException() {
        super("Method does not exist.", null, 2, null);
    }
}
