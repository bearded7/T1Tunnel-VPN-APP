package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.typedarray.RawTypedArrayHolder;
import expo.modules.kotlin.types.folly.FollyDynamicExtensionConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: ReturnType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0018\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0015\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u001a"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "convertToJS", "value", "PassThroughConverter", "BundleConverter", "ArrayConverter", "IntArrayConverter", "FloatArrayConverter", "DoubleArrayConverter", "BooleanArrayConverter", "ByteArrayConverter", "MapConverter", "EnumConverter", "RecordConverter", "URIConverter", "URLConverter", "AndroidUriConverter", "FileConverter", "PairConverter", "LongConverter", "DurationConverter", "RawTypedArrayHolderConverter", "CollectionConverter", "AnyConverter", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ExperimentalJSTypeConverter<T> {

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$PassThroughConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PassThroughConverter implements ExperimentalJSTypeConverter<Object> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            return value;
        }
    }

    Object convertToJS(Object value);

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$BundleConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Landroid/os/Bundle;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BundleConverter implements ExperimentalJSTypeConverter<Bundle> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Bundle bundle = (Bundle) value;
            if (bundle != null) {
                return JSTypeConverterHelperKt.toJSValue(bundle, JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$ArrayConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ArrayConverter implements ExperimentalJSTypeConverter<Object[]> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Object[] objArr = (Object[]) value;
            if (objArr != null) {
                return JSTypeConverterHelperKt.toJSValue(objArr, JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$IntArrayConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class IntArrayConverter implements ExperimentalJSTypeConverter<int[]> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            int[] iArr = (int[]) value;
            if (iArr != null) {
                return JSTypeConverterHelperKt.toJSValue(iArr, (JSTypeConverter.ContainerProvider) JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$FloatArrayConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FloatArrayConverter implements ExperimentalJSTypeConverter<float[]> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            float[] fArr = (float[]) value;
            if (fArr != null) {
                return JSTypeConverterHelperKt.toJSValue(fArr, (JSTypeConverter.ContainerProvider) JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$DoubleArrayConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DoubleArrayConverter implements ExperimentalJSTypeConverter<double[]> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            double[] dArr = (double[]) value;
            if (dArr != null) {
                return JSTypeConverterHelperKt.toJSValue(dArr, JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$BooleanArrayConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BooleanArrayConverter implements ExperimentalJSTypeConverter<boolean[]> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            boolean[] zArr = (boolean[]) value;
            if (zArr != null) {
                return JSTypeConverterHelperKt.toJSValue(zArr, JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$ByteArrayConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ByteArrayConverter implements ExperimentalJSTypeConverter<byte[]> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            byte[] bArr = (byte[]) value;
            if (bArr != null) {
                return FollyDynamicExtensionConverter.INSTANCE.put(bArr);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$MapConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MapConverter implements ExperimentalJSTypeConverter<Map<?, ?>> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Map map = (Map) value;
            if (map != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(map);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$EnumConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EnumConverter implements ExperimentalJSTypeConverter<Enum<?>> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Enum r1 = (Enum) value;
            if (r1 != null) {
                return JSTypeConverterHelperKt.toJSValue((Enum<?>) r1);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$RecordConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecordConverter implements ExperimentalJSTypeConverter<Record> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Record record = (Record) value;
            if (record != null) {
                return JSTypeConverterHelperKt.toJSValue(record, JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$URIConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Ljava/net/URI;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class URIConverter implements ExperimentalJSTypeConverter<URI> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            URI uri = (URI) value;
            if (uri != null) {
                return JSTypeConverterHelperKt.toJSValue(uri);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$URLConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Ljava/net/URL;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class URLConverter implements ExperimentalJSTypeConverter<URL> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            URL url = (URL) value;
            if (url != null) {
                return JSTypeConverterHelperKt.toJSValue(url);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$AndroidUriConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Landroid/net/Uri;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AndroidUriConverter implements ExperimentalJSTypeConverter<Uri> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Uri uri = (Uri) value;
            if (uri != null) {
                return JSTypeConverterHelperKt.toJSValue(uri);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$FileConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Ljava/io/File;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileConverter implements ExperimentalJSTypeConverter<File> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            File file = (File) value;
            if (file != null) {
                return JSTypeConverterHelperKt.toJSValue(file);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$PairConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Lkotlin/Pair;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PairConverter implements ExperimentalJSTypeConverter<Pair<?, ?>> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Pair pair = (Pair) value;
            if (pair != null) {
                return JSTypeConverterHelperKt.toJSValue((Pair<?, ?>) pair, JSTypeConverter.DefaultContainerProvider.INSTANCE);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$LongConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LongConverter implements ExperimentalJSTypeConverter<Long> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Long l = (Long) value;
            if (l != null) {
                return Double.valueOf(l.longValue());
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$DurationConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Lkotlin/time/Duration;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DurationConverter implements ExperimentalJSTypeConverter<Duration> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Duration duration = (Duration) value;
            if (duration != null) {
                return Double.valueOf(Duration.m2170toDoubleimpl(duration.getRawValue(), DurationUnit.SECONDS));
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$RawTypedArrayHolderConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "Lexpo/modules/kotlin/typedarray/RawTypedArrayHolder;", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RawTypedArrayHolderConverter implements ExperimentalJSTypeConverter<RawTypedArrayHolder> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            RawTypedArrayHolder rawTypedArrayHolder = (RawTypedArrayHolder) value;
            if (rawTypedArrayHolder != null) {
                return rawTypedArrayHolder.getRawArray();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$CollectionConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CollectionConverter implements ExperimentalJSTypeConverter<Collection<?>> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            Collection collection = (Collection) value;
            if (collection != null) {
                return JSTypeConverterHelperKt.toJSValueExperimental(collection);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ReturnType.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter$AnyConverter;", "Lexpo/modules/kotlin/types/ExperimentalJSTypeConverter;", "", "<init>", "()V", "convertToJS", "value", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnyConverter implements ExperimentalJSTypeConverter<Object> {
        @Override // expo.modules.kotlin.types.ExperimentalJSTypeConverter
        public Object convertToJS(Object value) {
            return JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, value, null, true, 2, null);
        }
    }
}
