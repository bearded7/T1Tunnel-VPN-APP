package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.SingleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: PairTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J,\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lexpo/modules/kotlin/types/PairTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Lkotlin/Pair;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "pairType", "Lkotlin/reflect/KType;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "converters", "", "Lexpo/modules/kotlin/types/TypeConverter;", "", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "convertFromAny", "convertFromReadableArray", "jsArray", "Lcom/facebook/react/bridge/ReadableArray;", "convertElement", "array", "index", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PairTypeConverter extends DynamicAwareTypeConverters<Pair<?, ?>> {
    private final List<TypeConverter<? extends Object>> converters;
    private final KType pairType;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public PairTypeConverter(TypeConverterProvider converterProvider, KType pairType) {
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(pairType, "pairType");
        this.pairType = pairType;
        TypeConverter[] typeConverterArr = new TypeConverter[2];
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(pairType.getArguments(), 0);
        KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
        if (type != null) {
            typeConverterArr[0] = converterProvider.obtainTypeConverter(type);
            KTypeProjection kTypeProjection2 = (KTypeProjection) CollectionsKt.getOrNull(pairType.getArguments(), 1);
            KType type2 = kTypeProjection2 != null ? kTypeProjection2.getType() : null;
            if (type2 != null) {
                typeConverterArr[1] = converterProvider.obtainTypeConverter(type2);
                this.converters = CollectionsKt.listOf((Object[]) typeConverterArr);
                return;
            }
            throw new IllegalArgumentException("The pair type should contain the type of the second parameter.".toString());
        }
        throw new IllegalArgumentException("The pair type should contain the type of the first parameter.".toString());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Pair<?, ?> convertFromDynamic(Dynamic value, AppContext context, boolean forceConversion) throws DynamicCastException {
        Intrinsics.checkNotNullParameter(value, "value");
        ReadableArray readableArrayAsArray = value.asArray();
        if (readableArrayAsArray == null) {
            throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
        }
        return convertFromReadableArray(readableArrayAsArray, context, forceConversion);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Pair<?, ?> convertFromAny(Object value, AppContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof ReadableArray) {
            return convertFromReadableArray((ReadableArray) value, context, forceConversion);
        }
        return (Pair) value;
    }

    private final Pair<?, ?> convertFromReadableArray(ReadableArray jsArray, AppContext context, boolean forceConversion) {
        return new Pair<>(convertElement(context, jsArray, 0, forceConversion), convertElement(context, jsArray, 1, forceConversion));
    }

    private final Object convertElement(AppContext context, ReadableArray array, int index, boolean forceConversion) {
        UnexpectedException unexpectedException;
        Dynamic dynamic = array.getDynamic(index);
        try {
            Object objConvert = this.converters.get(index).convert(dynamic, context, forceConversion);
            dynamic.recycle();
            return objConvert;
        } catch (Throwable th) {
            try {
                if (th instanceof CodedException) {
                    unexpectedException = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    String code = ((expo.modules.core.errors.CodedException) th).getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                    unexpectedException = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                KType kType = this.pairType;
                KType type = kType.getArguments().get(index).getType();
                Intrinsics.checkNotNull(type);
                throw new CollectionElementCastException(kType, type, dynamic.getType(), unexpectedException);
            } catch (Throwable th2) {
                dynamic.recycle();
                throw th2;
            }
        }
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(new SingleType(CppType.READABLE_ARRAY, null, 2, null));
    }
}
