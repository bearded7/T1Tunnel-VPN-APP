package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"localizedMessageWithCauseLocalizedMessage", "", "", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LoggerUtilsKt {
    public static final String localizedMessageWithCauseLocalizedMessage(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        String[] strArr = new String[2];
        strArr[0] = th.getLocalizedMessage();
        Throwable cause = th.getCause();
        strArr[1] = cause != null ? localizedMessageWithCauseLocalizedMessage(cause) : null;
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), ": ", null, null, 0, null, null, 62, null);
    }
}
