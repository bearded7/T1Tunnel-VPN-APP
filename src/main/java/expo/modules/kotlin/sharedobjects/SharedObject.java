package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.jni.JNIUtils;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptWeakObject;
import expo.modules.kotlin.types.JSTypeConverter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedObject.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0003J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J+\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010#\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u001fH\u0017J\b\u0010)\u001a\u00020\u0011H\u0016R\u001c\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObject;", "", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "<init>", "(Lexpo/modules/kotlin/RuntimeContext;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)V", "sharedObjectId", "Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "getSharedObjectId-HSeVr_g$expo_modules_core_release", "()I", "setSharedObjectId-kyJHjyY$expo_modules_core_release", "(I)V", "I", "getSharedObjectId", "", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "getRuntimeContextHolder", "()Ljava/lang/ref/WeakReference;", "setRuntimeContextHolder", "(Ljava/lang/ref/WeakReference;)V", "getRuntimeContext", "()Lexpo/modules/kotlin/RuntimeContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "getJavaScriptObject", "Lexpo/modules/kotlin/jni/JavaScriptWeakObject;", "emit", "", "eventName", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "onStartListeningToEvent", "onStopListeningToEvent", "sharedObjectDidRelease", "deallocate", "getAdditionalMemoryPressure", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SharedObject {
    private WeakReference<RuntimeContext> runtimeContextHolder;
    private int sharedObjectId;

    public SharedObject() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Deprecated(message = "Use sharedObjectDidRelease() instead.", replaceWith = @ReplaceWith(expression = "sharedObjectDidRelease()", imports = {}))
    public void deallocate() {
    }

    public int getAdditionalMemoryPressure() {
        return 0;
    }

    public void onStartListeningToEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public void onStopListeningToEvent(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public SharedObject(RuntimeContext runtimeContext) {
        this.sharedObjectId = SharedObjectId.m729constructorimpl(0);
        this.runtimeContextHolder = UtilsKt.weak(runtimeContext);
    }

    public /* synthetic */ SharedObject(RuntimeContext runtimeContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : runtimeContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedObject(AppContext appContext) {
        this(appContext.getHostingRuntimeContext());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    /* JADX INFO: renamed from: getSharedObjectId-HSeVr_g$expo_modules_core_release, reason: not valid java name */
    public final int m726getSharedObjectIdHSeVr_g$expo_modules_core_release() {
        return this.sharedObjectId;
    }

    /* JADX INFO: renamed from: setSharedObjectId-kyJHjyY$expo_modules_core_release, reason: not valid java name */
    public final void m727setSharedObjectIdkyJHjyY$expo_modules_core_release(int i) {
        this.sharedObjectId = i;
    }

    private final int getSharedObjectId() {
        return this.sharedObjectId;
    }

    public final WeakReference<RuntimeContext> getRuntimeContextHolder() {
        return this.runtimeContextHolder;
    }

    public final void setRuntimeContextHolder(WeakReference<RuntimeContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.runtimeContextHolder = weakReference;
    }

    private final RuntimeContext getRuntimeContext() {
        return this.runtimeContextHolder.get();
    }

    public final AppContext getAppContext() {
        RuntimeContext runtimeContext = getRuntimeContext();
        if (runtimeContext != null) {
            return runtimeContext.getAppContext();
        }
        return null;
    }

    private final JavaScriptWeakObject getJavaScriptObject() {
        int iM729constructorimpl = SharedObjectId.m729constructorimpl(this.sharedObjectId);
        RuntimeContext runtimeContext = getRuntimeContext();
        if (runtimeContext == null) {
            return null;
        }
        return SharedObjectId.m737toWeakJavaScriptObjectNullimpl(iM729constructorimpl, runtimeContext);
    }

    public final void emit(String eventName, Object... args) {
        RuntimeContext runtimeContext;
        JSIContext jsiContext$expo_modules_core_release;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(args, "args");
        JavaScriptWeakObject javaScriptObject = getJavaScriptObject();
        if (javaScriptObject == null || (runtimeContext = getRuntimeContext()) == null || (jsiContext$expo_modules_core_release = runtimeContext.getJsiContext$expo_modules_core_release()) == null) {
            return;
        }
        try {
            JNIUtils.Companion companion = JNIUtils.INSTANCE;
            ArrayList arrayList = new ArrayList(args.length);
            for (Object obj : args) {
                arrayList.add(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, obj, null, false, 6, null));
            }
            companion.emitEvent(javaScriptObject, jsiContext$expo_modules_core_release, eventName, arrayList.toArray(new Object[0]));
        } catch (Throwable th) {
            CoreLoggerKt.getLogger().error("Unable to send event '" + eventName + "' by shared object of type " + getClass().getSimpleName(), th);
        }
    }

    public void sharedObjectDidRelease() {
        deallocate();
    }
}
