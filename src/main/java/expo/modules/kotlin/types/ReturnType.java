package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.time.Duration;

/* JADX INFO: compiled from: ReturnType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\n\u001a\u00020\u000b\"\u0006\b\u0000\u0010\f\u0018\u0001H\u0080\b¢\u0006\u0002\b\rR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/ReturnType;", "", "klass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "converter", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "convertToJS", "value", "inheritFrom", "", ExifInterface.GPS_DIRECTION_TRUE, "inheritFrom$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReturnType {
    private final ExperimentalJSTypeConverter<?> converter;
    private final KClass<?> klass;

    public ReturnType(KClass<?> klass) {
        ExperimentalJSTypeConverter.AnyConverter anyConverter;
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
        KClass<?> kClass = this.klass;
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Unit.class))) {
            anyConverter = new ExperimentalJSTypeConverter.PassThroughConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Bundle.class))) {
            anyConverter = new ExperimentalJSTypeConverter.BundleConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(int[].class))) {
            anyConverter = new ExperimentalJSTypeConverter.IntArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(float[].class))) {
            anyConverter = new ExperimentalJSTypeConverter.FloatArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(double[].class))) {
            anyConverter = new ExperimentalJSTypeConverter.DoubleArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(boolean[].class))) {
            anyConverter = new ExperimentalJSTypeConverter.BooleanArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
            anyConverter = new ExperimentalJSTypeConverter.ByteArrayConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(URI.class))) {
            anyConverter = new ExperimentalJSTypeConverter.URIConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(URL.class))) {
            anyConverter = new ExperimentalJSTypeConverter.URLConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Uri.class))) {
            anyConverter = new ExperimentalJSTypeConverter.AndroidUriConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(File.class))) {
            anyConverter = new ExperimentalJSTypeConverter.FileConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
            anyConverter = new ExperimentalJSTypeConverter.PairConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            anyConverter = new ExperimentalJSTypeConverter.LongConverter();
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Duration.class))) {
            anyConverter = new ExperimentalJSTypeConverter.DurationConverter();
        } else {
            anyConverter = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Object.class)) ? new ExperimentalJSTypeConverter.AnyConverter() : null;
        }
        if (anyConverter == null) {
            if (Map.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new ExperimentalJSTypeConverter.MapConverter();
            } else if (Enum.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new ExperimentalJSTypeConverter.EnumConverter();
            } else if (Record.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new ExperimentalJSTypeConverter.RecordConverter();
            } else if (RawTypedArrayHolder.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new ExperimentalJSTypeConverter.RawTypedArrayHolderConverter();
            } else if (Object[].class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new ExperimentalJSTypeConverter.ArrayConverter();
            } else if (Collection.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.klass))) {
                anyConverter = new ExperimentalJSTypeConverter.CollectionConverter();
            } else {
                anyConverter = new ExperimentalJSTypeConverter.PassThroughConverter();
            }
        }
        this.converter = anyConverter;
    }

    public final Object convertToJS(Object value) {
        return this.converter.convertToJS(value);
    }

    public final /* synthetic */ <T> boolean inheritFrom$expo_modules_core_release() {
        Class javaClass = JvmClassMappingKt.getJavaClass(this.klass);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(javaClass);
    }
}
