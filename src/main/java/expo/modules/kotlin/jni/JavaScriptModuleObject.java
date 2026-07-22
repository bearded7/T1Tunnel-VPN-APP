package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JavaScriptModuleObject.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u000bH\u0082 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086 J\b\u0010\u0014\u001a\u00020\u0011H\u0004J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "Lexpo/modules/kotlin/jni/Destructible;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "name", "", "<init>", "(Lexpo/modules/kotlin/jni/JNIDeallocator;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "isValid", "", "()Z", "decorate", "", "decorator", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "finalize", "deallocate", "toString", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JavaScriptModuleObject implements Destructible {
    private final HybridData mHybridData;
    private final String name;

    private final native HybridData initHybrid();

    public final native void decorate(JSDecoratorsBridgingObject decorator);

    public JavaScriptModuleObject(JNIDeallocator jniDeallocator, String name) {
        Intrinsics.checkNotNullParameter(jniDeallocator, "jniDeallocator");
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.mHybridData = initHybrid();
        jniDeallocator.addReference(this);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    public String toString() {
        return "JavaScriptModuleObject_" + this.name;
    }
}
