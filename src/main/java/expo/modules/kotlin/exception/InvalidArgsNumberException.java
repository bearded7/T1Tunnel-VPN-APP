package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CodedException.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/exception/InvalidArgsNumberException;", "Lexpo/modules/kotlin/exception/CodedException;", "received", "", "expected", "required", "<init>", "(III)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InvalidArgsNumberException extends CodedException {
    public /* synthetic */ InvalidArgsNumberException(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? i2 : i3);
    }

    public InvalidArgsNumberException(int i, int i2, int i3) {
        super(i3 < i2 ? "Received " + i + " arguments, but " + i2 + " was expected and at least " + i3 + " is required" : "Received " + i + " arguments, but " + i2 + " was expected", null, 2, null);
    }
}
