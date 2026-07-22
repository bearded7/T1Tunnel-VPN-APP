package expo.modules.kotlin.types;

import com.caverock.androidsvg.SVGParser;
import kotlin.Metadata;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TypeConverterProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverterProvider;", "", "obtainTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TypeConverterProvider {
    TypeConverter<?> obtainTypeConverter(KType type);
}
