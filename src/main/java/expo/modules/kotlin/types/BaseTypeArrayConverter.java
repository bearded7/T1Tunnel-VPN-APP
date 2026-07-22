package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.TypedArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypedArrayTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B*\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0013\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u001aR,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lexpo/modules/kotlin/types/BaseTypeArrayConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/typedarray/TypedArray;", "Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "typedArrayWrapper", "Lkotlin/Function1;", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "Lkotlin/ParameterName;", "name", "rawArray", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getTypedArrayWrapper", "()Lkotlin/jvm/functions/Function1;", "convertNonNullable", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;Z)Lexpo/modules/kotlin/typedarray/TypedArray;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "wrapJavaScriptTypedArray", "(Lexpo/modules/kotlin/jni/JavaScriptTypedArray;)Lexpo/modules/kotlin/typedarray/TypedArray;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseTypeArrayConverter<T extends TypedArray> extends NonNullableTypeConverter<T> {
    private final Function1<JavaScriptTypedArray, T> typedArrayWrapper;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public final Function1<JavaScriptTypedArray, T> getTypedArrayWrapper() {
        return this.typedArrayWrapper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseTypeArrayConverter(Function1<? super JavaScriptTypedArray, ? extends T> typedArrayWrapper) {
        Intrinsics.checkNotNullParameter(typedArrayWrapper, "typedArrayWrapper");
        this.typedArrayWrapper = typedArrayWrapper;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public T convertNonNullable(Object value, AppContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (T) wrapJavaScriptTypedArray((JavaScriptTypedArray) value);
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.TYPED_ARRAY);
    }

    public final T wrapJavaScriptTypedArray(JavaScriptTypedArray value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.typedArrayWrapper.invoke(value);
    }
}
