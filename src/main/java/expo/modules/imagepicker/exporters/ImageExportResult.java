package expo.modules.imagepicker.exporters;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.util.UriUtil;
import expo.modules.imagepicker.FailedToReadFileException;
import expo.modules.imagepicker.ImagePickerConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: compiled from: ImageExporter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lexpo/modules/imagepicker/exporters/ImageExportResult;", "", "width", "", "height", "imageFile", "Ljava/io/File;", "<init>", "(IILjava/io/File;)V", "getWidth", "()I", "getHeight", UriUtil.DATA_SCHEME, "Ljava/io/ByteArrayOutputStream;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exif", "Landroid/os/Bundle;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ImageExportResult {
    private final int height;
    private final File imageFile;
    private final int width;

    public Object data(ContentResolver contentResolver, Continuation<? super ByteArrayOutputStream> continuation) {
        return data$suspendImpl(this, contentResolver, continuation);
    }

    public Object exif(ContentResolver contentResolver, Continuation<? super Bundle> continuation) {
        return exif$suspendImpl(this, contentResolver, continuation);
    }

    public ImageExportResult(int i, int i2, File imageFile) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        this.width = i;
        this.height = i2;
        this.imageFile = imageFile;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    static /* synthetic */ Object data$suspendImpl(final ImageExportResult imageExportResult, final ContentResolver contentResolver, Continuation<? super ByteArrayOutputStream> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.exporters.ImageExportResult$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImageExportResult.data$lambda$2(contentResolver, imageExportResult);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteArrayOutputStream data$lambda$2(ContentResolver contentResolver, ImageExportResult imageExportResult) throws FailedToReadFileException, FileNotFoundException {
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(Uri.fromFile(imageExportResult.imageFile));
        if (inputStreamOpenInputStream != null) {
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                InputStream inputStream2 = inputStream;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    ByteStreamsKt.copyTo$default(inputStream2, byteArrayOutputStream2, 0, 2, null);
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    CloseableKt.closeFinally(inputStream, null);
                    return byteArrayOutputStream2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(byteArrayOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStream, th3);
                    throw th4;
                }
            }
        }
        throw new FailedToReadFileException(imageExportResult.imageFile, null, 2, null);
    }

    static /* synthetic */ Object exif$suspendImpl(final ImageExportResult imageExportResult, final ContentResolver contentResolver, Continuation<? super Bundle> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.exporters.ImageExportResult$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImageExportResult.exif$lambda$8(contentResolver, imageExportResult);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle exif$lambda$8(ContentResolver contentResolver, ImageExportResult imageExportResult) throws FailedToReadFileException, FileNotFoundException {
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(Uri.fromFile(imageExportResult.imageFile));
        if (inputStreamOpenInputStream != null) {
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                Bundle bundle = new Bundle();
                ExifInterface exifInterface = new ExifInterface(inputStream);
                Iterable<Pair<String, String>> exif_tags = ImagePickerConstants.INSTANCE.getEXIF_TAGS();
                ArrayList<Pair> arrayList = new ArrayList();
                for (Pair<String, String> pair : exif_tags) {
                    if (exifInterface.getAttribute(pair.component2()) != null) {
                        arrayList.add(pair);
                    }
                }
                for (Pair pair2 : arrayList) {
                    String str = (String) pair2.component1();
                    String str2 = (String) pair2.component2();
                    int iHashCode = str.hashCode();
                    if (iHashCode != -1325958191) {
                        if (iHashCode != -891985903) {
                            if (iHashCode == 104431 && str.equals("int")) {
                                bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                            }
                        } else if (str.equals("string")) {
                            bundle.putString(str2, exifInterface.getAttribute(str2));
                        }
                    } else if (str.equals("double")) {
                        bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, 0.0d));
                    }
                }
                double[] latLong = exifInterface.getLatLong();
                if (latLong != null) {
                    bundle.putDouble(ExifInterface.TAG_GPS_LATITUDE, latLong[0]);
                    bundle.putDouble(ExifInterface.TAG_GPS_LONGITUDE, latLong[1]);
                    bundle.putDouble(ExifInterface.TAG_GPS_ALTITUDE, exifInterface.getAltitude(0.0d));
                }
                CloseableKt.closeFinally(inputStream, null);
                return bundle;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
        throw new FailedToReadFileException(imageExportResult.imageFile, null, 2, null);
    }
}
