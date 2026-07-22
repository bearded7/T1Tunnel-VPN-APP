package expo.modules.kotlin.modules;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.NullableTypeConverter;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterComponent;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ModuleConvertersBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u00012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0086\bJ_\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0006\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0001\"\n\b\u0001\u0010\u0010\u0018\u0001*\u00020\u00012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002H\r0\u0012H\u0086\bø\u0001\u0000J\u0006\u0010\u0016\u001a\u00020\u0017R.\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/modules/ModuleConvertersBuilder;", "", "<init>", "()V", "convertersComponent", "", "Lexpo/modules/kotlin/types/TypeConverterComponent;", "getConvertersComponent$annotations", "getConvertersComponent", "()Ljava/util/List;", "setConvertersComponent", "(Ljava/util/List;)V", "TypeConverter", ExifInterface.GPS_DIRECTION_TRUE, "classifier", "Lkotlin/reflect/KClass;", "P0", "body", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "p0", "buildTypeConverterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModuleConvertersBuilder {
    private List<TypeConverterComponent<?>> convertersComponent = new ArrayList();

    public static /* synthetic */ void getConvertersComponent$annotations() {
    }

    public final List<TypeConverterComponent<?>> getConvertersComponent() {
        return this.convertersComponent;
    }

    public final void setConvertersComponent(List<TypeConverterComponent<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.convertersComponent = list;
    }

    public static /* synthetic */ TypeConverterComponent TypeConverter$default(ModuleConvertersBuilder moduleConvertersBuilder, KClass classifier, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            classifier = Reflection.getOrCreateKotlinClass(Object.class);
        }
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1 moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1 = ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        TypeConverterComponent<?> typeConverterComponent = new TypeConverterComponent<>(new LazyKType(orCreateKotlinClass, false, moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1));
        moduleConvertersBuilder.getConvertersComponent().add(typeConverterComponent);
        return typeConverterComponent;
    }

    public final /* synthetic */ <T> TypeConverterComponent<T> TypeConverter(KClass<T> classifier) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1 moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1 = ModuleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        TypeConverterComponent<T> typeConverterComponent = new TypeConverterComponent<>(new LazyKType(orCreateKotlinClass, false, moduleConvertersBuilder$TypeConverter$$inlined$lazyTypeOf$1));
        getConvertersComponent().add(typeConverterComponent);
        return typeConverterComponent;
    }

    public static /* synthetic */ TypeConverterComponent TypeConverter$default(ModuleConvertersBuilder moduleConvertersBuilder, KClass classifier, Function1 body, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            classifier = Reflection.getOrCreateKotlinClass(Object.class);
        }
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1 moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1 = ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        TypeConverterComponent<?> typeConverterComponent = new TypeConverterComponent<>(new LazyKType(orCreateKotlinClass, false, moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1));
        moduleConvertersBuilder.getConvertersComponent().add(typeConverterComponent);
        Map<KType, Function1<Object, ?>> converters = typeConverterComponent.getDesireTypeConverter().getValue().getConverters();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.needClassReification();
        converters.put(null, new ModuleConvertersBuilder$TypeConverter$lambda$1$$inlined$from$1(body));
        return typeConverterComponent;
    }

    public final TypeConverterProvider buildTypeConverterProvider() {
        List<TypeConverterComponent<?>> list = this.convertersComponent;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair<KType, TypeConverter<?>> pairBuild = ((TypeConverterComponent) it.next()).build();
            if (pairBuild != null) {
                arrayList.add(pairBuild);
            }
        }
        final ArrayList arrayList2 = arrayList;
        return new TypeConverterProvider() { // from class: expo.modules.kotlin.modules.ModuleConvertersBuilder.buildTypeConverterProvider.1
            @Override // expo.modules.kotlin.types.TypeConverterProvider
            public TypeConverter<?> obtainTypeConverter(KType type) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(type, "type");
                TypeConverter<?> typeConverterFindNonNullableTypeConverter = findNonNullableTypeConverter(type);
                if (typeConverterFindNonNullableTypeConverter != null) {
                    return type.getIsMarkedNullable() ? new NullableTypeConverter(typeConverterFindNonNullableTypeConverter) : typeConverterFindNonNullableTypeConverter;
                }
                throw new MissingTypeConverter(type);
            }

            private final TypeConverter<?> findNonNullableTypeConverter(KType type) {
                Object next;
                Iterator<T> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    KType kType = (KType) ((Pair) next).component1();
                    if (Intrinsics.areEqual(kType.getClassifier(), type.getClassifier()) && Intrinsics.areEqual(kType.getArguments(), type.getArguments())) {
                        break;
                    }
                }
                Pair pair = (Pair) next;
                if (pair != null) {
                    return (TypeConverter) pair.getSecond();
                }
                return null;
            }
        };
    }

    public final /* synthetic */ <T, P0> TypeConverterComponent<T> TypeConverter(KClass<T> classifier, Function1<? super P0, ? extends T> body) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1 moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1 = ModuleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        TypeConverterComponent<T> typeConverterComponent = new TypeConverterComponent<>(new LazyKType(orCreateKotlinClass, false, moduleConvertersBuilder$TypeConverter$$inlined$TypeConverter$1));
        getConvertersComponent().add(typeConverterComponent);
        Map<KType, Function1<Object, T>> converters = typeConverterComponent.getDesireTypeConverter().getValue().getConverters();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.needClassReification();
        converters.put(null, new ModuleConvertersBuilder$TypeConverter$lambda$1$$inlined$from$1(body));
        return typeConverterComponent;
    }
}
