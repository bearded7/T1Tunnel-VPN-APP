package expo.modules.kotlin.defaultmodules;

import expo.modules.core.logging.LogType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: JSLoggerModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\f\u001a\u00020\u0001*\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f*\u001a\b\u0007\u0010\u0007\"\u00020\b2\u00020\bB\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¨\u0006\u0010"}, d2 = {"moduleName", "", "onNewError", "onNewWarning", "onNewDebug", "onNewInfo", "onNewTrace", "ErrorManagerModule", "Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "Lkotlin/Deprecated;", "message", "Use JSLoggerModule instead", "eventName", "Lexpo/modules/core/logging/LogType;", "getEventName", "(Lexpo/modules/core/logging/LogType;)Ljava/lang/String;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JSLoggerModuleKt {
    private static final String moduleName = "ExpoModulesCoreJSLogger";
    private static final String onNewDebug = "ExpoModulesCoreJSLogger.onNewDebug";
    private static final String onNewError = "ExpoModulesCoreJSLogger.onNewError";
    private static final String onNewInfo = "ExpoModulesCoreJSLogger.onNewInfo";
    private static final String onNewTrace = "ExpoModulesCoreJSLogger.onNewTrace";
    private static final String onNewWarning = "ExpoModulesCoreJSLogger.onNewWarning";

    /* JADX INFO: compiled from: JSLoggerModule.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogType.values().length];
            try {
                iArr[LogType.Trace.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogType.Timer.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogType.Stacktrace.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogType.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogType.Info.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LogType.Warn.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LogType.Error.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LogType.Fatal.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Use JSLoggerModule instead")
    public static /* synthetic */ void ErrorManagerModule$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getEventName(LogType logType) {
        switch (WhenMappings.$EnumSwitchMapping$0[logType.ordinal()]) {
            case 1:
                return onNewTrace;
            case 2:
                return onNewDebug;
            case 3:
                return onNewTrace;
            case 4:
                return onNewDebug;
            case 5:
                return onNewInfo;
            case 6:
                return onNewWarning;
            case 7:
            case 8:
                return onNewError;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
