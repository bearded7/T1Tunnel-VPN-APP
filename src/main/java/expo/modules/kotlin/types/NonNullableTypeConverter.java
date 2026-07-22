package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.NullArgumentException;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;

/* JADX INFO: compiled from: TypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0006\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ'\u0010\r\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "Type", "", "Lexpo/modules/kotlin/types/TypeConverter;", "<init>", "()V", "convert", "value", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;Z)Ljava/lang/Object;", "convertNonNullable", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NonNullableTypeConverter<Type> implements TypeConverter<Type> {
    public abstract Type convertNonNullable(Object value, AppContext context, boolean forceConversion);

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return TypeConverter.DefaultImpls.getCppRequiredTypes(this);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return TypeConverter.DefaultImpls.isTrivial(this);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public Type convert(Object value, AppContext context, boolean forceConversion) throws NullArgumentException {
        if (value != null) {
            return convertNonNullable(value, context, forceConversion);
        }
        throw new NullArgumentException();
    }
}
