package expo.modules.kotlin.jni;

import androidx.core.os.EnvironmentCompat;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PromiseAlreadySettledException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromiseImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\u001e\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0017H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0018H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0019H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001aH\u0016J$\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0017\u0010 \u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\"H\u0082\bJ$\u0010#\u001a\u00020\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "callback", "Lexpo/modules/kotlin/jni/JavaCallback;", "<init>", "(Lexpo/modules/kotlin/jni/JavaCallback;)V", "getCallback$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "value", "", "wasSettled", "getWasSettled$expo_modules_core_release", "()Z", "appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "fullFunctionName", "", "resolve", "", "", "result", "", "", "", "", "", "reject", "code", "message", "cause", "", "checkIfWasSettled", "body", "Lkotlin/Function0;", "decorateWithDebugInformation", "moduleName", "functionName", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromiseImpl implements Promise {
    private WeakReference<AppContext> appContextHolder;
    private final JavaCallback callback;
    private String fullFunctionName;
    private boolean wasSettled;

    @Override // expo.modules.kotlin.Promise
    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    public PromiseImpl(JavaCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: renamed from: getCallback$expo_modules_core_release, reason: from getter */
    public final JavaCallback getCallback() {
        return this.callback;
    }

    /* JADX INFO: renamed from: getWasSettled$expo_modules_core_release, reason: from getter */
    public final boolean getWasSettled() {
        return this.wasSettled;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Collection<? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.callback.invoke(result);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Map<String, ? extends Object> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.callback.invoke(result);
    }

    private final void checkIfWasSettled(Function0<Unit> body) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (weakReference == null || (appContext = weakReference.get()) == null) {
                throw promiseAlreadySettledException;
            }
            appContext.getErrorManager();
            throw promiseAlreadySettledException;
        }
        body.invoke();
        this.wasSettled = true;
    }

    public final void decorateWithDebugInformation(WeakReference<AppContext> appContextHolder, String moduleName, String functionName) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.appContextHolder = appContextHolder;
        this.fullFunctionName = moduleName + "." + functionName;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(value);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke();
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float result) throws PromiseAlreadySettledException {
        AppContext appContext;
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(String result) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(result, "result");
        if (!this.wasSettled) {
            this.callback.invoke(result);
            this.wasSettled = true;
            return;
        }
        String str = this.fullFunctionName;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) throws PromiseAlreadySettledException {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(code, "code");
        boolean z = this.wasSettled;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        if (!z) {
            JavaCallback javaCallback = this.callback;
            if (message == null) {
                message = cause != null ? cause.getMessage() : null;
                if (message == null) {
                    message = EnvironmentCompat.MEDIA_UNKNOWN;
                }
            }
            javaCallback.invoke(code, message);
            this.wasSettled = true;
            return;
        }
        String str2 = this.fullFunctionName;
        if (str2 != null) {
            str = str2;
        }
        PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference == null || (appContext = weakReference.get()) == null) {
            throw promiseAlreadySettledException;
        }
        appContext.getErrorManager();
        throw promiseAlreadySettledException;
    }
}
