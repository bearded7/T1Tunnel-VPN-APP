package expo.modules.kotlin.jni;

import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.types.ValueOrUndefined;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FLOAT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: CppType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lexpo/modules/kotlin/jni/CppType;", "", "clazz", "Lkotlin/reflect/KClass;", "value", "", "<init>", "(Ljava/lang/String;ILkotlin/reflect/KClass;I)V", "getClazz", "()Lkotlin/reflect/KClass;", "getValue", "()I", "NONE", "DOUBLE", "INT", "LONG", "FLOAT", "BOOLEAN", "STRING", "JS_OBJECT", "JS_VALUE", "READABLE_ARRAY", "READABLE_MAP", "UINT8_TYPED_ARRAY", "TYPED_ARRAY", "PRIMITIVE_ARRAY", "ARRAY", "LIST", "MAP", "VIEW_TAG", "SHARED_OBJECT_ID", "JS_FUNCTION", ThreadConfined.ANY, "NULLABLE", "VALUE_OR_UNDEFINED", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CppType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CppType[] $VALUES;
    public static final CppType ANY;
    public static final CppType FLOAT;
    public static final CppType TYPED_ARRAY;
    private final KClass<?> clazz;
    private final int value;
    public static final CppType NONE = new CppType("NONE", 0, Reflection.getOrCreateKotlinClass(Void.class), 0);
    public static final CppType DOUBLE = new CppType("DOUBLE", 1, Reflection.getOrCreateKotlinClass(Double.TYPE), 0, 2, null);
    public static final CppType INT = new CppType("INT", 2, Reflection.getOrCreateKotlinClass(Integer.TYPE), 0, 2, null);
    public static final CppType LONG = new CppType("LONG", 3, Reflection.getOrCreateKotlinClass(Long.TYPE), 0, 2, null);
    public static final CppType BOOLEAN = new CppType("BOOLEAN", 5, Reflection.getOrCreateKotlinClass(Boolean.TYPE), 0, 2, null);
    public static final CppType STRING = new CppType("STRING", 6, Reflection.getOrCreateKotlinClass(String.class), 0, 2, null);
    public static final CppType JS_OBJECT = new CppType("JS_OBJECT", 7, Reflection.getOrCreateKotlinClass(JavaScriptObject.class), 0, 2, null);
    public static final CppType JS_VALUE = new CppType("JS_VALUE", 8, Reflection.getOrCreateKotlinClass(JavaScriptValue.class), 0, 2, null);
    public static final CppType READABLE_ARRAY = new CppType("READABLE_ARRAY", 9, Reflection.getOrCreateKotlinClass(ReadableArray.class), 0, 2, null);
    public static final CppType READABLE_MAP = new CppType("READABLE_MAP", 10, Reflection.getOrCreateKotlinClass(ReadableMap.class), 0, 2, null);
    public static final CppType UINT8_TYPED_ARRAY = new CppType("UINT8_TYPED_ARRAY", 11, Reflection.getOrCreateKotlinClass(byte[].class), 0, 2, null);
    public static final CppType PRIMITIVE_ARRAY = new CppType("PRIMITIVE_ARRAY", 13, Reflection.getOrCreateKotlinClass(Object[].class), 0, 2, null);
    public static final CppType ARRAY = new CppType("ARRAY", 14, Reflection.getOrCreateKotlinClass(Object[].class), 0, 2, null);
    public static final CppType LIST = new CppType("LIST", 15, Reflection.getOrCreateKotlinClass(List.class), 0, 2, null);
    public static final CppType MAP = new CppType("MAP", 16, Reflection.getOrCreateKotlinClass(Map.class), 0, 2, null);
    public static final CppType VIEW_TAG = new CppType("VIEW_TAG", 17, Reflection.getOrCreateKotlinClass(Integer.TYPE), 0, 2, null);
    public static final CppType SHARED_OBJECT_ID = new CppType("SHARED_OBJECT_ID", 18, Reflection.getOrCreateKotlinClass(Integer.TYPE), 0, 2, null);
    public static final CppType JS_FUNCTION = new CppType("JS_FUNCTION", 19, Reflection.getOrCreateKotlinClass(JavaScriptFunction.class), 0, 2, null);
    public static final CppType NULLABLE = new CppType("NULLABLE", 21, Reflection.getOrCreateKotlinClass(Object.class), 0, 2, null);
    public static final CppType VALUE_OR_UNDEFINED = new CppType("VALUE_OR_UNDEFINED", 22, Reflection.getOrCreateKotlinClass(ValueOrUndefined.class), 0, 2, null);

    private static final /* synthetic */ CppType[] $values() {
        return new CppType[]{NONE, DOUBLE, INT, LONG, FLOAT, BOOLEAN, STRING, JS_OBJECT, JS_VALUE, READABLE_ARRAY, READABLE_MAP, UINT8_TYPED_ARRAY, TYPED_ARRAY, PRIMITIVE_ARRAY, ARRAY, LIST, MAP, VIEW_TAG, SHARED_OBJECT_ID, JS_FUNCTION, ANY, NULLABLE, VALUE_OR_UNDEFINED};
    }

    public static EnumEntries<CppType> getEntries() {
        return $ENTRIES;
    }

    private CppType(String str, int i, KClass kClass, int i2) {
        super(str, i);
        this.clazz = kClass;
        this.value = i2;
    }

    /* synthetic */ CppType(String str, int i, KClass kClass, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, kClass, (i3 & 2) != 0 ? CppTypeKt.nextValue() : i2);
    }

    public final KClass<?> getClazz() {
        return this.clazz;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        FLOAT = new CppType("FLOAT", 4, Reflection.getOrCreateKotlinClass(Float.TYPE), 0, 2, defaultConstructorMarker);
        TYPED_ARRAY = new CppType("TYPED_ARRAY", 12, Reflection.getOrCreateKotlinClass(TypedArray.class), 0, 2, defaultConstructorMarker);
        ANY = new CppType(ThreadConfined.ANY, 20, Reflection.getOrCreateKotlinClass(Object.class), 0, 2, defaultConstructorMarker);
        CppType[] cppTypeArr$values = $values();
        $VALUES = cppTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(cppTypeArr$values);
    }

    public static CppType valueOf(String str) {
        return (CppType) Enum.valueOf(CppType.class, str);
    }

    public static CppType[] values() {
        return (CppType[]) $VALUES.clone();
    }
}
