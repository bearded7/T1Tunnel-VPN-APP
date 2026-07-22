package expo.modules.core.logging;

import android.util.Log;
import com.caverock.androidsvg.SVGParser;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSLogHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lexpo/modules/core/logging/OSLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "category", "", "<init>", "(Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "log", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lexpo/modules/core/logging/LogType;", "message", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSLogHandler extends LogHandler {
    private final String category;

    public final String getCategory() {
        return this.category;
    }

    public OSLogHandler(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.category = category;
    }

    @Override // expo.modules.core.logging.LogHandler
    public void log$expo_modules_core_release(LogType type, String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!OSLogHandlerKt.isAndroid) {
            System.out.println((Object) ("[" + type.getType() + "] " + this.category + "\t" + message));
            if (cause != null) {
                System.out.println((Object) (LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(cause) + "\n" + ExceptionsKt.stackTraceToString(cause)));
                return;
            }
            return;
        }
        int oSLogType = LogType.INSTANCE.toOSLogType(type);
        if (oSLogType == 3) {
            Log.d(this.category, message, cause);
            return;
        }
        if (oSLogType == 4) {
            Log.i(this.category, message, cause);
            return;
        }
        if (oSLogType == 5) {
            Log.w(this.category, message, cause);
        } else if (oSLogType == 6) {
            Log.e(this.category, message, cause);
        } else {
            if (oSLogType != 7) {
                return;
            }
            Log.e(this.category, message, cause);
        }
    }
}
