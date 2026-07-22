package expo.modules.kotlin.types;

import com.caverock.androidsvg.SVGParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ArrayTypeConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000¨\u0006\u0006"}, d2 = {"isPrimitiveArray", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lkotlin/reflect/KType;", "clazz", "Ljava/lang/Class;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ArrayTypeConverterKt {
    public static final boolean isPrimitiveArray(KType type, Class<?> clazz) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (Intrinsics.areEqual(clazz, boolean[].class) || Intrinsics.areEqual(clazz, byte[].class) || Intrinsics.areEqual(clazz, char[].class) || Intrinsics.areEqual(clazz, short[].class) || Intrinsics.areEqual(clazz, int[].class) || Intrinsics.areEqual(clazz, long[].class) || Intrinsics.areEqual(clazz, float[].class) || Intrinsics.areEqual(clazz, double[].class)) {
            return type.getArguments().isEmpty();
        }
        return false;
    }
}
