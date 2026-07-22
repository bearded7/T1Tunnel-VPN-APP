package expo.modules.image.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: events.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lexpo/modules/image/records/ImageProgressEvent;", "Lexpo/modules/kotlin/records/Record;", "loaded", "", "total", "<init>", "(II)V", "getLoaded$annotations", "()V", "getLoaded", "()I", "getTotal$annotations", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ImageProgressEvent implements Record {
    private final int loaded;
    private final int total;

    public static /* synthetic */ ImageProgressEvent copy$default(ImageProgressEvent imageProgressEvent, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imageProgressEvent.loaded;
        }
        if ((i3 & 2) != 0) {
            i2 = imageProgressEvent.total;
        }
        return imageProgressEvent.copy(i, i2);
    }

    @Field
    public static /* synthetic */ void getLoaded$annotations() {
    }

    @Field
    public static /* synthetic */ void getTotal$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLoaded() {
        return this.loaded;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final ImageProgressEvent copy(int loaded, int total) {
        return new ImageProgressEvent(loaded, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageProgressEvent)) {
            return false;
        }
        ImageProgressEvent imageProgressEvent = (ImageProgressEvent) other;
        return this.loaded == imageProgressEvent.loaded && this.total == imageProgressEvent.total;
    }

    public int hashCode() {
        return (Integer.hashCode(this.loaded) * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        return "ImageProgressEvent(loaded=" + this.loaded + ", total=" + this.total + ")";
    }

    public ImageProgressEvent(int i, int i2) {
        this.loaded = i;
        this.total = i2;
    }

    public final int getLoaded() {
        return this.loaded;
    }

    public final int getTotal() {
        return this.total;
    }
}
