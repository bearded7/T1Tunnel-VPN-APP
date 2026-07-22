package expo.modules.fetch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ResponseState.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/fetch/ResponseState;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", "INITIALIZED", "STARTED", "RESPONSE_RECEIVED", "BODY_COMPLETED", "BODY_STREAMING_STARTED", "BODY_STREAMING_CANCELED", "ERROR_RECEIVED", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ResponseState {
    INITIALIZED(0),
    STARTED(1),
    RESPONSE_RECEIVED(2),
    BODY_COMPLETED(3),
    BODY_STREAMING_STARTED(4),
    BODY_STREAMING_CANCELED(5),
    ERROR_RECEIVED(6);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int intValue;

    public static EnumEntries<ResponseState> getEntries() {
        return $ENTRIES;
    }

    ResponseState(int i) {
        this.intValue = i;
    }

    public final int getIntValue() {
        return this.intValue;
    }
}
