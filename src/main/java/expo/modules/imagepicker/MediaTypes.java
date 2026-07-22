package expo.modules.imagepicker;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: compiled from: ImagePickerOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lexpo/modules/imagepicker/MediaTypes;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGES", "VIDEOS", Rule.ALL, "toFileExtension", "toCameraIntentAction", "Companion", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum MediaTypes implements Enumerable {
    IMAGES("Images"),
    VIDEOS("Videos"),
    ALL("All");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ImagePickerOptions.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaTypes.values().length];
            try {
                iArr[MediaTypes.VIDEOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<MediaTypes> getEntries() {
        return $ENTRIES;
    }

    MediaTypes(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final String toFileExtension() {
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] == 1) {
            return ".mp4";
        }
        return ".jpeg";
    }

    public final String toCameraIntentAction() {
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] == 1) {
            return "android.media.action.VIDEO_CAPTURE";
        }
        return "android.media.action.IMAGE_CAPTURE";
    }

    /* JADX INFO: compiled from: ImagePickerOptions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/imagepicker/MediaTypes$Companion;", "", "<init>", "()V", "fromJSMediaTypesArray", "Lexpo/modules/imagepicker/MediaTypes;", "mediaTypes", "", "Lexpo/modules/imagepicker/JSMediaTypes;", "([Lexpo/modules/imagepicker/JSMediaTypes;)Lexpo/modules/imagepicker/MediaTypes;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaTypes fromJSMediaTypesArray(JSMediaTypes[] mediaTypes) {
            Intrinsics.checkNotNullParameter(mediaTypes, "mediaTypes");
            if (!ArraysKt.contains(mediaTypes, JSMediaTypes.VIDEOS)) {
                return MediaTypes.IMAGES;
            }
            if (ArraysKt.contains(mediaTypes, JSMediaTypes.VIDEOS) && !ArraysKt.contains(mediaTypes, JSMediaTypes.IMAGES)) {
                return MediaTypes.VIDEOS;
            }
            return MediaTypes.ALL;
        }
    }
}
