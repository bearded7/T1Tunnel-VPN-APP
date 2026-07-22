package expo.modules.imagepicker.exporters;

import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DimensionsExporter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lexpo/modules/imagepicker/exporters/DimensionsExporter;", "", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "isRotatedLandscape", "", "()Z", "isRotatedLandscape$delegate", "Lkotlin/Lazy;", "metadata", "Landroid/graphics/BitmapFactory$Options;", "getMetadata", "()Landroid/graphics/BitmapFactory$Options;", "metadata$delegate", "width", "", "getWidth", "()I", "height", "getHeight", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DimensionsExporter {
    private final File file;

    /* JADX INFO: renamed from: isRotatedLandscape$delegate, reason: from kotlin metadata */
    private final Lazy isRotatedLandscape;

    /* JADX INFO: renamed from: metadata$delegate, reason: from kotlin metadata */
    private final Lazy metadata;

    public DimensionsExporter(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.isRotatedLandscape = LazyKt.lazy(new Function0() { // from class: expo.modules.imagepicker.exporters.DimensionsExporter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DimensionsExporter.isRotatedLandscape_delegate$lambda$0(this.f$0));
            }
        });
        this.metadata = LazyKt.lazy(new Function0() { // from class: expo.modules.imagepicker.exporters.DimensionsExporter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DimensionsExporter.metadata_delegate$lambda$2(this.f$0);
            }
        });
    }

    private final boolean isRotatedLandscape() {
        return ((Boolean) this.isRotatedLandscape.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRotatedLandscape_delegate$lambda$0(DimensionsExporter dimensionsExporter) {
        int attributeInt = new ExifInterface(dimensionsExporter.file.getAbsolutePath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
        return attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7;
    }

    private final BitmapFactory.Options getMetadata() {
        return (BitmapFactory.Options) this.metadata.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BitmapFactory.Options metadata_delegate$lambda$2(DimensionsExporter dimensionsExporter) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(dimensionsExporter.file.getAbsolutePath(), options);
        return options;
    }

    public final int getWidth() {
        return isRotatedLandscape() ? getMetadata().outHeight : getMetadata().outWidth;
    }

    public final int getHeight() {
        return isRotatedLandscape() ? getMetadata().outWidth : getMetadata().outHeight;
    }
}
