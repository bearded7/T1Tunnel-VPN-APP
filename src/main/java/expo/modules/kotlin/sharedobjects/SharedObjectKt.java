package expo.modules.kotlin.sharedobjects;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: SharedObject.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002¨\u0006\u0003"}, d2 = {"isSharedObjectClass", "", "Lkotlin/reflect/KClass;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SharedObjectKt {
    public static final boolean isSharedObjectClass(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return SharedObject.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass) kClass));
    }
}
