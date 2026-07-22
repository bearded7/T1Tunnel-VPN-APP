package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypedArrayTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/types/TypedArrayTypeConverter;", "Lexpo/modules/kotlin/types/BaseTypeArrayConverter;", "Lexpo/modules/kotlin/typedarray/TypedArray;", "<init>", "()V", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TypedArrayTypeConverter extends BaseTypeArrayConverter<TypedArray> {
    @Override // expo.modules.kotlin.types.BaseTypeArrayConverter, expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return true;
    }

    public TypedArrayTypeConverter() {
        super(new Function1() { // from class: expo.modules.kotlin.types.TypedArrayTypeConverter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TypedArrayTypeConverter._init_$lambda$0((JavaScriptTypedArray) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypedArray _init_$lambda$0(JavaScriptTypedArray it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }
}
