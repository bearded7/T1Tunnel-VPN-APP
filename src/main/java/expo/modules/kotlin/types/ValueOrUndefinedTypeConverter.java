package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.SingleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: ValueOrUndefinedTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/types/ValueOrUndefinedTypeConverter;", "Lexpo/modules/kotlin/types/TypeConverter;", "Lexpo/modules/kotlin/types/ValueOrUndefined;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "innerType", "Lkotlin/reflect/KType;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "innerTypeConverter", "convert", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ValueOrUndefinedTypeConverter implements TypeConverter<ValueOrUndefined<?>> {
    private final TypeConverter<?> innerTypeConverter;

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public ValueOrUndefinedTypeConverter(TypeConverterProvider converterProvider, KType innerType) {
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(innerType, "innerType");
        KType type = ((KTypeProjection) CollectionsKt.first((List) innerType.getArguments())).getType();
        if (type != null) {
            this.innerTypeConverter = converterProvider.obtainTypeConverter(type);
            return;
        }
        throw new IllegalArgumentException("The ValueOrUndefined type should contain the argument type.".toString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.TypeConverter
    public ValueOrUndefined<?> convert(Object value, AppContext context, boolean forceConversion) {
        if (value instanceof ValueOrUndefined.Undefined) {
            return ValueOrUndefined.Undefined.INSTANCE;
        }
        return new ValueOrUndefined.Value(TypeConverter.DefaultImpls.convert$default(this.innerTypeConverter, value, context, false, 4, null));
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(new SingleType(CppType.VALUE_OR_UNDEFINED, new ExpectedType[]{this.innerTypeConverter.get$cppRequireType()}));
    }
}
