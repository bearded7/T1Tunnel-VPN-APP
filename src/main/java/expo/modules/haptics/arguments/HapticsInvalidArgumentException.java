package expo.modules.haptics.arguments;

import expo.modules.core.errors.CodedException;
import kotlin.Metadata;

/* JADX INFO: compiled from: HapticsExceptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/haptics/arguments/HapticsInvalidArgumentException;", "Lexpo/modules/core/errors/CodedException;", "message", "", "<init>", "(Ljava/lang/String;)V", "getCode", "expo-haptics_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HapticsInvalidArgumentException extends CodedException {
    public HapticsInvalidArgumentException(String str) {
        super(str);
    }

    @Override // expo.modules.core.errors.CodedException, expo.modules.core.interfaces.CodedThrowable
    public String getCode() {
        return "E_HAPTICS_INVALID_ARGUMENT";
    }
}
