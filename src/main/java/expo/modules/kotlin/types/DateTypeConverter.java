package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.SingleType;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DateTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Lexpo/modules/kotlin/types/DateTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Ljava/time/LocalDate;", "<init>", "()V", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "convertFromAny", "", "convertFromLong", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DateTypeConverter extends DynamicAwareTypeConverters<LocalDate> {

    /* JADX INFO: compiled from: DateTypeConverter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public LocalDate convertFromDynamic(Dynamic value, AppContext context, boolean forceConversion) throws UnexpectedException {
        Intrinsics.checkNotNullParameter(value, "value");
        int i = WhenMappings.$EnumSwitchMapping$0[value.getType().ordinal()];
        if (i == 1) {
            LocalDate localDate = LocalDate.parse(value.asString(), DateTimeFormatter.ISO_DATE_TIME);
            Intrinsics.checkNotNullExpressionValue(localDate, "parse(...)");
            return localDate;
        }
        if (i == 2) {
            return convertFromLong((long) value.asDouble());
        }
        throw new UnexpectedException("Unknown argument type: " + value.getType());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public LocalDate convertFromAny(Object value, AppContext context, boolean forceConversion) throws UnexpectedException {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof String) {
            LocalDate localDate = LocalDate.parse((CharSequence) value, DateTimeFormatter.ISO_DATE_TIME);
            Intrinsics.checkNotNullExpressionValue(localDate, "parse(...)");
            return localDate;
        }
        if (value instanceof Long) {
            return convertFromLong(((Number) value).longValue());
        }
        throw new UnexpectedException("Unknown argument type: " + Reflection.getOrCreateKotlinClass(value.getClass()));
    }

    private final LocalDate convertFromLong(long value) {
        LocalDate localDate = Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return localDate;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(new SingleType(CppType.INT, null, 2, null), new SingleType(CppType.STRING, null, 2, null));
    }
}
