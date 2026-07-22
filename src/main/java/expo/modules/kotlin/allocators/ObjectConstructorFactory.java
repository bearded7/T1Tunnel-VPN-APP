package expo.modules.kotlin.allocators;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;

/* JADX INFO: compiled from: ObjectConstructorFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bJ$\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0002J(\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0002J\"\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0002¨\u0006\r"}, d2 = {"Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "", "<init>", "()V", "get", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "tryToUseDefaultConstructor", "Ljava/lang/Class;", "tryToUseDefaultKotlinConstructor", "useUnsafeAllocator", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObjectConstructorFactory {
    public final <T> ObjectConstructor<T> get(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ObjectConstructor<T> objectConstructorTryToUseDefaultConstructor = tryToUseDefaultConstructor(JvmClassMappingKt.getJavaClass((KClass) clazz));
        return (objectConstructorTryToUseDefaultConstructor == null && (objectConstructorTryToUseDefaultConstructor = tryToUseDefaultKotlinConstructor(clazz)) == null) ? useUnsafeAllocator(JvmClassMappingKt.getJavaClass((KClass) clazz)) : objectConstructorTryToUseDefaultConstructor;
    }

    private final <T> ObjectConstructor<T> tryToUseDefaultConstructor(Class<T> clazz) {
        try {
            final Constructor<T> declaredConstructor = clazz.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda1
                @Override // expo.modules.kotlin.allocators.ObjectConstructor
                public final Object construct() {
                    return ObjectConstructorFactory.tryToUseDefaultConstructor$lambda$0(declaredConstructor);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultConstructor$lambda$0(Constructor constructor) {
        return constructor.newInstance(new Object[0]);
    }

    private final <T> ObjectConstructor<T> tryToUseDefaultKotlinConstructor(KClass<T> clazz) {
        Iterator<T> it = clazz.getConstructors().iterator();
        boolean z = false;
        T t = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
                break;
            }
            T next = it.next();
            List<KParameter> parameters = ((KFunction) next).getParameters();
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                Iterator<T> it2 = parameters.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((KParameter) it2.next()).isOptional()) {
                        }
                    }
                }
            }
            if (!z) {
                z = true;
                t = next;
            }
            t = null;
            break;
        }
        final KFunction kFunction = (KFunction) t;
        if (kFunction == null) {
            return null;
        }
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda2
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return ObjectConstructorFactory.tryToUseDefaultKotlinConstructor$lambda$2(kFunction);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultKotlinConstructor$lambda$2(KFunction kFunction) {
        return kFunction.callBy(MapsKt.emptyMap());
    }

    private final <T> ObjectConstructor<T> useUnsafeAllocator(Class<T> clazz) {
        final UnsafeAllocator<T> unsafeAllocatorCreateAllocator = UnsafeAllocator.INSTANCE.createAllocator(clazz);
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return unsafeAllocatorCreateAllocator.newInstance();
            }
        };
    }
}
