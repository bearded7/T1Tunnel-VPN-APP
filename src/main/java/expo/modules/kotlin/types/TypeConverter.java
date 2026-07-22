package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;

/* JADX INFO: compiled from: TypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J/\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverter;", "Type", "", "convert", "value", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;Z)Ljava/lang/Object;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TypeConverter<Type> {
    Type convert(Object value, AppContext context, boolean forceConversion);

    ExpectedType getCppRequiredTypes();

    boolean isTrivial();

    /* JADX INFO: compiled from: TypeConverter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <Type> boolean isTrivial(TypeConverter<Type> typeConverter) {
            return true;
        }

        public static /* synthetic */ Object convert$default(TypeConverter typeConverter, Object obj, AppContext appContext, boolean z, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
            }
            if ((i & 2) != 0) {
                appContext = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return typeConverter.convert(obj, appContext, z);
        }

        public static <Type> ExpectedType getCppRequiredTypes(TypeConverter<Type> typeConverter) {
            return new ExpectedType(CppType.ANY);
        }
    }
}
