package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.CameraContractOptions;
import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePickerOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020[R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR$\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR$\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000bR,\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010.\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010/\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR2\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u0004\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010@\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\tR\u001c\u0010J\u001a\u00020K8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010NR\u001c\u0010O\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\tR\u0011\u0010R\u001a\u00020S8F¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006\\"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "<init>", "()V", "allowsEditing", "", "getAllowsEditing$annotations", "getAllowsEditing", "()Z", "setAllowsEditing", "(Z)V", "allowsMultipleSelection", "getAllowsMultipleSelection$annotations", "getAllowsMultipleSelection", "setAllowsMultipleSelection", "quality", "", "getQuality$annotations", "getQuality", "()D", "setQuality", "(D)V", "selectionLimit", "", "getSelectionLimit$annotations", "getSelectionLimit", "()I", "setSelectionLimit", "(I)V", "base64", "getBase64$annotations", "getBase64", "setBase64", "exif", "getExif$annotations", "getExif", "setExif", "mediaTypes", "", "Lexpo/modules/imagepicker/JSMediaTypes;", "getMediaTypes$annotations", "getMediaTypes", "()[Lexpo/modules/imagepicker/JSMediaTypes;", "setMediaTypes", "([Lexpo/modules/imagepicker/JSMediaTypes;)V", "[Lexpo/modules/imagepicker/JSMediaTypes;", "videoMaxDuration", "getVideoMaxDuration", "setVideoMaxDuration", "aspect", "Lkotlin/Pair;", "getAspect$annotations", "getAspect", "()Lkotlin/Pair;", "setAspect", "(Lkotlin/Pair;)V", "shape", "Lexpo/modules/imagepicker/CropShape;", "getShape$annotations", "getShape", "()Lexpo/modules/imagepicker/CropShape;", "setShape", "(Lexpo/modules/imagepicker/CropShape;)V", "cameraType", "Lexpo/modules/imagepicker/CameraType;", "getCameraType$annotations", "getCameraType", "()Lexpo/modules/imagepicker/CameraType;", "setCameraType", "(Lexpo/modules/imagepicker/CameraType;)V", "orderedSelection", "getOrderedSelection$annotations", "getOrderedSelection", "defaultTab", "Lexpo/modules/imagepicker/DefaultTab;", "getDefaultTab$annotations", "getDefaultTab", "()Lexpo/modules/imagepicker/DefaultTab;", "legacy", "getLegacy$annotations", "getLegacy", "nativeMediaTypes", "Lexpo/modules/imagepicker/MediaTypes;", "getNativeMediaTypes", "()Lexpo/modules/imagepicker/MediaTypes;", "toCameraContractOptions", "Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "uri", "", "toImageLibraryContractOptions", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePickerOptions implements Record, Serializable {
    private boolean allowsEditing;
    private boolean allowsMultipleSelection;
    private Pair<Integer, Integer> aspect;
    private boolean base64;
    private boolean exif;
    private final boolean legacy;
    private final boolean orderedSelection;
    private int selectionLimit;
    private int videoMaxDuration;
    private double quality = 1.0d;
    private JSMediaTypes[] mediaTypes = {JSMediaTypes.IMAGES};
    private CropShape shape = CropShape.RECTANGLE;
    private CameraType cameraType = CameraType.BACK;
    private final DefaultTab defaultTab = DefaultTab.PHOTOS;

    @Field
    public static /* synthetic */ void getAllowsEditing$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllowsMultipleSelection$annotations() {
    }

    @Field
    public static /* synthetic */ void getAspect$annotations() {
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getCameraType$annotations() {
    }

    @Field
    public static /* synthetic */ void getDefaultTab$annotations() {
    }

    @Field
    public static /* synthetic */ void getExif$annotations() {
    }

    @Field
    public static /* synthetic */ void getLegacy$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaTypes$annotations() {
    }

    @Field
    public static /* synthetic */ void getOrderedSelection$annotations() {
    }

    @Field
    public static /* synthetic */ void getQuality$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectionLimit$annotations() {
    }

    @Field
    public static /* synthetic */ void getShape$annotations() {
    }

    public final boolean getAllowsEditing() {
        return this.allowsEditing;
    }

    public final void setAllowsEditing(boolean z) {
        this.allowsEditing = z;
    }

    public final boolean getAllowsMultipleSelection() {
        return this.allowsMultipleSelection;
    }

    public final void setAllowsMultipleSelection(boolean z) {
        this.allowsMultipleSelection = z;
    }

    public final double getQuality() {
        return this.quality;
    }

    public final void setQuality(double d) {
        this.quality = d;
    }

    public final int getSelectionLimit() {
        return this.selectionLimit;
    }

    public final void setSelectionLimit(int i) {
        this.selectionLimit = i;
    }

    public final boolean getBase64() {
        return this.base64;
    }

    public final void setBase64(boolean z) {
        this.base64 = z;
    }

    public final boolean getExif() {
        return this.exif;
    }

    public final void setExif(boolean z) {
        this.exif = z;
    }

    public final JSMediaTypes[] getMediaTypes() {
        return this.mediaTypes;
    }

    public final void setMediaTypes(JSMediaTypes[] jSMediaTypesArr) {
        Intrinsics.checkNotNullParameter(jSMediaTypesArr, "<set-?>");
        this.mediaTypes = jSMediaTypesArr;
    }

    public final int getVideoMaxDuration() {
        return this.videoMaxDuration;
    }

    public final void setVideoMaxDuration(int i) {
        this.videoMaxDuration = i;
    }

    public final Pair<Integer, Integer> getAspect() {
        return this.aspect;
    }

    public final void setAspect(Pair<Integer, Integer> pair) {
        this.aspect = pair;
    }

    public final CropShape getShape() {
        return this.shape;
    }

    public final void setShape(CropShape cropShape) {
        Intrinsics.checkNotNullParameter(cropShape, "<set-?>");
        this.shape = cropShape;
    }

    public final CameraType getCameraType() {
        return this.cameraType;
    }

    public final void setCameraType(CameraType cameraType) {
        Intrinsics.checkNotNullParameter(cameraType, "<set-?>");
        this.cameraType = cameraType;
    }

    public final boolean getOrderedSelection() {
        return this.orderedSelection;
    }

    public final DefaultTab getDefaultTab() {
        return this.defaultTab;
    }

    public final boolean getLegacy() {
        return this.legacy;
    }

    public final MediaTypes getNativeMediaTypes() {
        return MediaTypes.INSTANCE.fromJSMediaTypesArray(this.mediaTypes);
    }

    public final CameraContractOptions toCameraContractOptions(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new CameraContractOptions(uri, this);
    }

    public final ImageLibraryContractOptions toImageLibraryContractOptions() {
        return new ImageLibraryContractOptions(this);
    }
}
