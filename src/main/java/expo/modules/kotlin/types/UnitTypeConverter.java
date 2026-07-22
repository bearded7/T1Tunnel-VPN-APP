package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnitTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/UnitTypeConverter;", "Lexpo/modules/kotlin/types/NonNullableTypeConverter;", "", "<init>", "()V", "convertNonNullable", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnitTypeConverter extends NonNullableTypeConverter<Unit> {
    /* JADX INFO: renamed from: convertNonNullable, reason: avoid collision after fix types in other method */
    public void convertNonNullable2(Object value, AppContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public /* bridge */ /* synthetic */ Unit convertNonNullable(Object obj, AppContext appContext, boolean z) {
        convertNonNullable2(obj, appContext, z);
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.ANY);
    }
}
