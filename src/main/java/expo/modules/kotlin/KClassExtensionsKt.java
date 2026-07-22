package expo.modules.kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: KClassExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0007\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00042\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\"-\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"fastPrimaryConstructor", "Lkotlin/reflect/KFunction;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KClass;", "getFastPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "fastIsSupperClassOf", "", "jClass", "Ljava/lang/Class;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KClassExtensionsKt {
    public static final <T> KFunction<T> getFastPrimaryConstructor(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KFunction<T> kFunction = (KFunction) CollectionsKt.singleOrNull(kClass.getConstructors());
        return kFunction == null ? KClasses.getPrimaryConstructor(kClass) : kFunction;
    }

    public static final boolean fastIsSupperClassOf(KClass<?> kClass, Class<?> jClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return JvmClassMappingKt.getJavaObjectType(kClass).isAssignableFrom(jClass) || JvmClassMappingKt.getJavaClass((KClass) kClass).isAssignableFrom(jClass);
    }
}
