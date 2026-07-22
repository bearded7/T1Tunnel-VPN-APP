package expo.modules.kotlin.jni.tests;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: compiled from: RuntimeHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u0082 J\t\u0010\b\u001a\u00020\tH\u0086 J\t\u0010\n\u001a\u00020\u000bH\u0086 J\t\u0010\f\u001a\u00020\rH\u0082 J\b\u0010\u0010\u001a\u00020\rH\u0004J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/jni/tests/RuntimeHolder;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "createRuntime", "", "createCallInvoker", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "release", "", "wasDeallocated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "finalize", "close", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RuntimeHolder implements AutoCloseable {
    private final HybridData mHybridData = initHybrid();
    private AtomicBoolean wasDeallocated = new AtomicBoolean(false);

    private final native HybridData initHybrid();

    private final native void release();

    public final native CallInvokerHolderImpl createCallInvoker();

    public final native long createRuntime();

    protected final void finalize() throws Throwable {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.wasDeallocated.compareAndSet(false, true)) {
            release();
            this.mHybridData.resetNative();
        }
    }
}
