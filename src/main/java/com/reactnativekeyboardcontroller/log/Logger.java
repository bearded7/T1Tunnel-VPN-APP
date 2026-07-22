package com.reactnativekeyboardcontroller.log;

import android.util.Log;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ$\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reactnativekeyboardcontroller/log/Logger;", "", "<init>", "()V", ViewProps.ENABLED, "", ContextChain.TAG_INFRA, "", "tag", "", "message", "throwable", "", "w", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Logger {
    public static final Logger INSTANCE = new Logger();
    private static final boolean enabled = false;

    private Logger() {
    }

    public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.i(str, str2, th);
    }

    public final void i(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (enabled) {
            Log.i(tag, message, throwable);
        }
    }

    public static /* synthetic */ void w$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.w(str, str2, th);
    }

    public final void w(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (enabled) {
            Log.w(tag, message, throwable);
        }
    }
}
