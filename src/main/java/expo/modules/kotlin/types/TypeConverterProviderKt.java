package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.exception.MissingTypeConverter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: TypeConverterProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b\u001a\u001e\u0010\u0004\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\u0007\u001a \u0010\u0004\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0086\b¢\u0006\u0002\u0010\b\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\f\u001a\f\u0010\u000e\u001a\u00020\f*\u0004\u0018\u00010\f¨\u0006\u000f"}, d2 = {"obtainTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "convert", "value", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lkotlin/reflect/KType;", "mergeWith", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "otherProvider", "mergeWithDefault", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TypeConverterProviderKt {
    public static final /* synthetic */ <T> TypeConverter<T> obtainTypeConverter() throws MissingTypeConverter {
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        TypeConverter typeConverterObtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter(null);
        Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.types.TypeConverter<T of expo.modules.kotlin.types.TypeConverterProviderKt.obtainTypeConverter>");
        return typeConverterObtainTypeConverter;
    }

    public static final /* synthetic */ <T> T convert(Dynamic value) {
        Intrinsics.checkNotNullParameter(value, "value");
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) TypeConverter.DefaultImpls.convert$default(typeConverterProviderImpl.obtainTypeConverter(null), value, null, false, 6, null);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final /* synthetic */ <T> T convert(Object obj) {
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) TypeConverter.DefaultImpls.convert$default(typeConverterProviderImpl.obtainTypeConverter(null), obj, null, false, 6, null);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final Object convert(Dynamic value, KType type) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        return TypeConverter.DefaultImpls.convert$default(TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(type), value, null, false, 6, null);
    }

    public static final TypeConverterProvider mergeWith(TypeConverterProvider typeConverterProvider, TypeConverterProvider otherProvider) {
        Intrinsics.checkNotNullParameter(typeConverterProvider, "<this>");
        Intrinsics.checkNotNullParameter(otherProvider, "otherProvider");
        return new MergedTypeConverterProvider(CollectionsKt.listOf((Object[]) new TypeConverterProvider[]{typeConverterProvider, otherProvider}));
    }

    public static final TypeConverterProvider mergeWithDefault(TypeConverterProvider typeConverterProvider) {
        TypeConverterProvider typeConverterProviderMergeWith;
        return (typeConverterProvider == null || (typeConverterProviderMergeWith = mergeWith(typeConverterProvider, TypeConverterProviderImpl.INSTANCE)) == null) ? TypeConverterProviderImpl.INSTANCE : typeConverterProviderMergeWith;
    }
}
