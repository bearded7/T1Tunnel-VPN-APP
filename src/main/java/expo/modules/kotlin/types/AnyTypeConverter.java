package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.exception.NullArgumentException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AnyTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/types/AnyTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "<init>", "()V", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "convertFromAny", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnyTypeConverter extends DynamicAwareTypeConverters<Object> {

    /* JADX INFO: compiled from: AnyTypeConverter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object convertFromAny(Object value, AppContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object convertFromDynamic(Dynamic value, AppContext context, boolean forceConversion) throws NullArgumentException, DynamicCastException {
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.getType().ordinal()]) {
            case 1:
                return Boolean.valueOf(value.asBoolean());
            case 2:
                return Double.valueOf(value.asDouble());
            case 3:
                String strAsString = value.asString();
                if (strAsString != null) {
                    return strAsString;
                }
                throw new DynamicCastException(Reflection.getOrCreateKotlinClass(String.class));
            case 4:
                ReadableMap readableMapAsMap = value.asMap();
                if (readableMapAsMap != null) {
                    return readableMapAsMap.toHashMap();
                }
                throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableMap.class));
            case 5:
                ReadableArray readableArrayAsArray = value.asArray();
                if (readableArrayAsArray != null) {
                    return readableArrayAsArray.toArrayList();
                }
                throw new DynamicCastException(Reflection.getOrCreateKotlinClass(ReadableArray.class));
            case 6:
                throw new NullArgumentException();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.ANY);
    }
}
