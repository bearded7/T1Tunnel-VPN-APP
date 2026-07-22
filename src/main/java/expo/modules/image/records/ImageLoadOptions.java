package expo.modules.image.records;

import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImageLoadOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lexpo/modules/image/records/ImageLoadOptions;", "Lexpo/modules/kotlin/records/Record;", ViewProps.MAX_WIDTH, "", ViewProps.MAX_HEIGHT, "<init>", "(II)V", "getMaxWidth$annotations", "()V", "getMaxWidth", "()I", "getMaxHeight$annotations", "getMaxHeight", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ImageLoadOptions implements Record {
    private final int maxHeight;
    private final int maxWidth;

    /* JADX WARN: Illegal instructions before constructor call */
    public ImageLoadOptions() {
        int i = 0;
        this(i, i, 3, null);
    }

    public static /* synthetic */ ImageLoadOptions copy$default(ImageLoadOptions imageLoadOptions, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imageLoadOptions.maxWidth;
        }
        if ((i3 & 2) != 0) {
            i2 = imageLoadOptions.maxHeight;
        }
        return imageLoadOptions.copy(i, i2);
    }

    @Field
    public static /* synthetic */ void getMaxHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final ImageLoadOptions copy(int maxWidth, int maxHeight) {
        return new ImageLoadOptions(maxWidth, maxHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageLoadOptions)) {
            return false;
        }
        ImageLoadOptions imageLoadOptions = (ImageLoadOptions) other;
        return this.maxWidth == imageLoadOptions.maxWidth && this.maxHeight == imageLoadOptions.maxHeight;
    }

    public int hashCode() {
        return (Integer.hashCode(this.maxWidth) * 31) + Integer.hashCode(this.maxHeight);
    }

    public String toString() {
        return "ImageLoadOptions(maxWidth=" + this.maxWidth + ", maxHeight=" + this.maxHeight + ")";
    }

    public ImageLoadOptions(int i, int i2) {
        this.maxWidth = i;
        this.maxHeight = i2;
    }

    public /* synthetic */ ImageLoadOptions(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Integer.MIN_VALUE : i, (i3 & 2) != 0 ? Integer.MIN_VALUE : i2);
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }
}
