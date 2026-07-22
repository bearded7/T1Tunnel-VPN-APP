package expo.modules.kotlin.sharedobjects;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: SharedRef.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001a\u000e\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0005¨\u0006\u0006"}, d2 = {"cast", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "RefType", "isSharedRefClass", "", "Lkotlin/reflect/KClass;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SharedRefKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <RefType> SharedRef<RefType> cast(SharedRef<?> sharedRef) {
        Intrinsics.checkNotNullParameter(sharedRef, "<this>");
        Object ref = sharedRef.getRef();
        Intrinsics.reifiedOperationMarker(3, "RefType");
        if (ref instanceof Object) {
            return sharedRef;
        }
        return null;
    }

    public static final boolean isSharedRefClass(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return SharedRef.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass) kClass));
    }
}
