package expo.modules.fetch;

import androidx.browser.trusted.sharing.ShareTarget;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"METHODS_REQUIRING_BODY", "", "", "getMETHODS_REQUIRING_BODY", "()[Ljava/lang/String;", "[Ljava/lang/String;", "expo_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NativeRequestKt {
    private static final String[] METHODS_REQUIRING_BODY = {ShareTarget.METHOD_POST, "PUT", "PATCH"};

    public static final String[] getMETHODS_REQUIRING_BODY() {
        return METHODS_REQUIRING_BODY;
    }
}
