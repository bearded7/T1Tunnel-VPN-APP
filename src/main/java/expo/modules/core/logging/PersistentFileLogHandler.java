package expo.modules.core.logging;

import com.caverock.androidsvg.SVGParser;
import java.io.File;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersistentFileLogHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0002\b\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/core/logging/PersistentFileLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "category", "", "filesDirectory", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/io/File;)V", "persistentFileLog", "Lexpo/modules/core/logging/PersistentFileLog;", "log", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lexpo/modules/core/logging/LogType;", "message", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersistentFileLogHandler extends LogHandler {
    private final PersistentFileLog persistentFileLog;

    public PersistentFileLogHandler(String category, File filesDirectory) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        this.persistentFileLog = new PersistentFileLog(category, filesDirectory);
    }

    @Override // expo.modules.core.logging.LogHandler
    public void log$expo_modules_core_release(LogType type, String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        PersistentFileLog.appendEntry$default(this.persistentFileLog, message, null, 2, null);
        if (cause != null) {
            PersistentFileLog.appendEntry$default(this.persistentFileLog, LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(cause) + "\n" + ExceptionsKt.stackTraceToString(cause), null, 2, null);
        }
    }
}
