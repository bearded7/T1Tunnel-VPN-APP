package expo.modules.imagepicker;

import android.os.Bundle;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePickerResponse.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\b\u0000\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010(\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010'R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010/R \u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00103\u0012\u0004\b0\u0010\u0016\u001a\u0004\b1\u00102R \u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00103\u0012\u0004\b4\u0010\u0016\u001a\u0004\b5\u00102¨\u00066"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerAsset;", "Lexpo/modules/kotlin/records/Record;", "assetId", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lexpo/modules/imagepicker/MediaType;", "uri", "width", "", "height", "fileName", "fileSize", "", "mimeType", "base64", "exif", "Landroid/os/Bundle;", "duration", ViewProps.ROTATION, "<init>", "(Ljava/lang/String;Lexpo/modules/imagepicker/MediaType;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAssetId$annotations", "()V", "getAssetId", "()Ljava/lang/String;", "getType$annotations", "getType", "()Lexpo/modules/imagepicker/MediaType;", "getUri$annotations", "getUri", "getWidth$annotations", "getWidth", "()I", "getHeight$annotations", "getHeight", "getFileName$annotations", "getFileName", "getFileSize$annotations", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMimeType$annotations", "getMimeType", "getBase64$annotations", "getBase64", "getExif$annotations", "getExif", "()Landroid/os/Bundle;", "getDuration$annotations", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRotation$annotations", "getRotation", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePickerAsset implements Record {
    private final String assetId;
    private final String base64;
    private final Integer duration;
    private final Bundle exif;
    private final String fileName;
    private final Long fileSize;
    private final int height;
    private final String mimeType;
    private final Integer rotation;
    private final MediaType type;
    private final String uri;
    private final int width;

    public ImagePickerAsset() {
        this(null, null, null, 0, 0, null, null, null, null, null, null, null, 4095, null);
    }

    @Field
    public static /* synthetic */ void getAssetId$annotations() {
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getExif$annotations() {
    }

    @Field
    public static /* synthetic */ void getFileName$annotations() {
    }

    @Field
    public static /* synthetic */ void getFileSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @Field
    public static /* synthetic */ void getRotation$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    public ImagePickerAsset(String str, MediaType mediaType, String uri, int i, int i2, String str2, Long l, String str3, String str4, Bundle bundle, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.assetId = str;
        this.type = mediaType;
        this.uri = uri;
        this.width = i;
        this.height = i2;
        this.fileName = str2;
        this.fileSize = l;
        this.mimeType = str3;
        this.base64 = str4;
        this.exif = bundle;
        this.duration = num;
        this.rotation = num2;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public /* synthetic */ ImagePickerAsset(String str, MediaType mediaType, String str2, int i, int i2, String str3, Long l, String str4, String str5, Bundle bundle, Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? MediaType.IMAGE : mediaType, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? i2 : 0, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : l, (i3 & 128) != 0 ? null : str4, (i3 & 256) != 0 ? null : str5, (i3 & 512) != 0 ? null : bundle, (i3 & 1024) != 0 ? null : num, (i3 & 2048) != 0 ? null : num2);
    }

    public final MediaType getType() {
        return this.type;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getBase64() {
        return this.base64;
    }

    public final Bundle getExif() {
        return this.exif;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer getRotation() {
        return this.rotation;
    }
}
