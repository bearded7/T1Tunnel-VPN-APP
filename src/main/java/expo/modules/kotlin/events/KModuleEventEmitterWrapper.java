package expo.modules.kotlin.events;

import android.os.Bundle;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.jni.JNIUtils;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.JSTypeConverterHelperKt;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KModuleEventEmitterWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0016J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/events/KModuleEventEmitterWrapper;", "Lexpo/modules/kotlin/events/KEventEmitterWrapper;", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "legacyEventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/ModuleHolder;Lexpo/modules/core/interfaces/services/EventEmitter;Ljava/lang/ref/WeakReference;)V", "emit", "", "eventName", "", "eventBody", "Landroid/os/Bundle;", "Lcom/facebook/react/bridge/WritableMap;", "Lexpo/modules/kotlin/records/Record;", "", "emitNative", "", "checkIfEventWasExported", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KModuleEventEmitterWrapper extends KEventEmitterWrapper {
    private final ModuleHolder<?> moduleHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModuleEventEmitterWrapper(ModuleHolder<?> moduleHolder, expo.modules.core.interfaces.services.EventEmitter legacyEventEmitter, WeakReference<ReactApplicationContext> reactContextHolder) {
        super(legacyEventEmitter, reactContextHolder);
        Intrinsics.checkNotNullParameter(moduleHolder, "moduleHolder");
        Intrinsics.checkNotNullParameter(legacyEventEmitter, "legacyEventEmitter");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.moduleHolder = moduleHolder;
    }

    @Override // expo.modules.kotlin.events.KEventEmitterWrapper, expo.modules.core.interfaces.services.EventEmitter
    public void emit(String eventName, Bundle eventBody) throws Exception {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        checkIfEventWasExported(eventName);
        emitNative(eventName, eventBody != null ? JSTypeConverterHelperKt.toJSValueExperimental(eventBody) : null);
    }

    @Override // expo.modules.kotlin.events.KEventEmitterWrapper, expo.modules.kotlin.events.EventEmitter
    public void emit(String eventName, WritableMap eventBody) throws Exception {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        checkIfEventWasExported(eventName);
        emitNative(eventName, eventBody != null ? eventBody.toHashMap() : null);
    }

    @Override // expo.modules.kotlin.events.KEventEmitterWrapper, expo.modules.kotlin.events.EventEmitter
    public void emit(String eventName, Record eventBody) throws Exception {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        checkIfEventWasExported(eventName);
        emitNative(eventName, eventBody != null ? JSTypeConverterHelperKt.toJSValueExperimental(eventBody) : null);
    }

    @Override // expo.modules.kotlin.events.KEventEmitterWrapper, expo.modules.kotlin.events.EventEmitter
    public void emit(String eventName, Map<?, ?> eventBody) throws Exception {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        checkIfEventWasExported(eventName);
        emitNative(eventName, eventBody != null ? JSTypeConverterHelperKt.toJSValueExperimental(eventBody) : null);
    }

    private final void emitNative(String eventName, Map<String, ? extends Object> eventBody) throws Exception {
        RuntimeContext runtimeContext = this.moduleHolder.getModule().getRuntimeContext();
        JavaScriptModuleObject safeJSObject = this.moduleHolder.getSafeJSObject();
        if (safeJSObject == null) {
            return;
        }
        try {
            JNIUtils.INSTANCE.emitEvent(safeJSObject, runtimeContext.getJsiContext$expo_modules_core_release(), eventName, eventBody);
        } catch (Exception e) {
            if (safeJSObject.isValid()) {
                throw e;
            }
        }
    }

    private final void checkIfEventWasExported(String eventName) {
        String[] names;
        EventsDefinition eventsDefinition = this.moduleHolder.getDefinition().getEventsDefinition();
        if (eventsDefinition == null || (names = eventsDefinition.getNames()) == null || !ArraysKt.contains(names, eventName)) {
            throw new IllegalArgumentException(("Unsupported event: " + eventName + ".").toString());
        }
    }
}
