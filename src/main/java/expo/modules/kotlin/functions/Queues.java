package expo.modules.kotlin.functions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: BaseAsyncFunctionComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/functions/Queues;", "Lexpo/modules/kotlin/functions/FunctionQueue;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN", "DEFAULT", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum Queues implements FunctionQueue {
    MAIN,
    DEFAULT;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<Queues> getEntries() {
        return $ENTRIES;
    }
}
