package expo.modules.imagepicker;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: ImagePickerConstants.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerConstants;", "", "<init>", "()V", "TAG", "", "MAXIMUM_QUALITY", "", "CACHE_DIR_NAME", "EXIF_TAGS", "", "Lkotlin/Pair;", "getEXIF_TAGS", "()Ljava/lang/Iterable;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePickerConstants {
    public static final String CACHE_DIR_NAME = "ImagePicker";
    public static final double MAXIMUM_QUALITY = 1.0d;
    public static final String TAG = "ExponentImagePicker";
    public static final ImagePickerConstants INSTANCE = new ImagePickerConstants();
    private static final Iterable<Pair<String, String>> EXIF_TAGS = new ImagePickerConstants$EXIF_TAGS$1();

    private ImagePickerConstants() {
    }

    public final Iterable<Pair<String, String>> getEXIF_TAGS() {
        return EXIF_TAGS;
    }
}
