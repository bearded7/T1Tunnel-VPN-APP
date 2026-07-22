package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: CodedException.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/exception/InvalidExpectedType;", "Lexpo/modules/kotlin/exception/CodedException;", "forType", "Lkotlin/reflect/KType;", "<init>", "(Lkotlin/reflect/KType;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InvalidExpectedType extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidExpectedType(KType forType) {
        super("Cannot obtain ExpectedType form '" + forType + "'.", null, 2, null);
        Intrinsics.checkNotNullParameter(forType, "forType");
    }
}
