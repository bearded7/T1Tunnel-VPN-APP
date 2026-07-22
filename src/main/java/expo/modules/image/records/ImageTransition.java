package expo.modules.image.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ImageTransition.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lexpo/modules/image/records/ImageTransition;", "Lexpo/modules/kotlin/records/Record;", "duration", "", "<init>", "(I)V", "getDuration$annotations", "()V", "getDuration", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ImageTransition implements Record {
    private final int duration;

    public ImageTransition() {
        this(0, 1, null);
    }

    public static /* synthetic */ ImageTransition copy$default(ImageTransition imageTransition, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = imageTransition.duration;
        }
        return imageTransition.copy(i);
    }

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    public final ImageTransition copy(int duration) {
        return new ImageTransition(duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImageTransition) && this.duration == ((ImageTransition) other).duration;
    }

    public int hashCode() {
        return Integer.hashCode(this.duration);
    }

    public String toString() {
        return "ImageTransition(duration=" + this.duration + ")";
    }

    public ImageTransition(int i) {
        this.duration = i;
    }

    public /* synthetic */ ImageTransition(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getDuration() {
        return this.duration;
    }
}
