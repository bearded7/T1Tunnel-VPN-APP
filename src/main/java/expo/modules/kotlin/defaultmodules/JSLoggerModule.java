package expo.modules.kotlin.defaultmodules;

import android.os.Bundle;
import androidx.tracing.Trace;
import com.caverock.androidsvg.SVGParser;
import expo.modules.core.logging.LogHandler;
import expo.modules.core.logging.LogType;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSLoggerModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u000eH\u0002R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "value", "Lexpo/modules/core/logging/Logger;", "logger", "getLogger", "()Lexpo/modules/core/logging/Logger;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "reportWarningToLogBox", "", "warning", "", "reportExceptionToLogBox", "codedException", "Lexpo/modules/kotlin/exception/CodedException;", "createMessageBundle", "Landroid/os/Bundle;", "message", "reportToLogBox", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lexpo/modules/core/logging/LogType;", "JSLogHandler", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSLoggerModule extends Module {
    private Logger logger;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: JSLoggerModule.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0010¢\u0006\u0002\b\u0011R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/JSLoggerModule$JSLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "module", "Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "<init>", "(Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;)V", "moduleReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "log", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lexpo/modules/core/logging/LogType;", "message", "", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class JSLogHandler extends LogHandler {
        private final WeakReference<JSLoggerModule> moduleReference;

        public JSLogHandler(JSLoggerModule module) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.moduleReference = new WeakReference<>(module);
        }

        @Override // expo.modules.core.logging.LogHandler
        public void log$expo_modules_core_release(LogType type, String message, Throwable cause) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(message, "message");
            if (cause != null) {
                message = message + ". " + cause.getMessage();
            }
            JSLoggerModule jSLoggerModule = this.moduleReference.get();
            if (jSLoggerModule != null) {
                jSLoggerModule.reportToLogBox(type, message);
            }
        }
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        JSLoggerModule jSLoggerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (jSLoggerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(jSLoggerModule);
            moduleDefinitionBuilder.Name("ExpoModulesCoreJSLogger");
            moduleDefinitionBuilder.Events("ExpoModulesCoreJSLogger.onNewError", "ExpoModulesCoreJSLogger.onNewWarning", "ExpoModulesCoreJSLogger.onNewDebug", "ExpoModulesCoreJSLogger.onNewInfo", "ExpoModulesCoreJSLogger.onNewTrace");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.kotlin.defaultmodules.JSLoggerModule$definition$lambda$1$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    JSLoggerModule.JSLogHandler jSLogHandler = new JSLoggerModule.JSLogHandler(this.this$0);
                    this.this$0.logger = new Logger(CollectionsKt.listOf(jSLogHandler));
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    @Deprecated(message = "Use appContext.jsLogger.warn(...) instead")
    public final void reportWarningToLogBox(String warning) {
        Intrinsics.checkNotNullParameter(warning, "warning");
        sendEvent("ExpoModulesCoreJSLogger.onNewWarning", createMessageBundle(warning));
    }

    @Deprecated(message = "Use appContext.jsLogger.error(...) instead")
    public final void reportExceptionToLogBox(CodedException codedException) {
        Intrinsics.checkNotNullParameter(codedException, "codedException");
        String message = codedException.getMessage();
        if (message == null) {
            message = codedException.toString();
        }
        sendEvent("ExpoModulesCoreJSLogger.onNewError", createMessageBundle(message));
    }

    private final Bundle createMessageBundle(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportToLogBox(LogType type, String message) {
        String eventName = JSLoggerModuleKt.getEventName(type);
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        Unit unit = Unit.INSTANCE;
        sendEvent(eventName, bundle);
    }
}
