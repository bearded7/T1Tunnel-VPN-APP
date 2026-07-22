package expo.modules.image.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: DecodeFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lexpo/modules/image/records/DecodeFormat;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ARGB_8888", "RGB_565", "toGlideFormat", "Lcom/bumptech/glide/load/DecodeFormat;", "toBytes", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum DecodeFormat implements Enumerable {
    ARGB_8888("argb"),
    RGB_565("rgb");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: DecodeFormat.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DecodeFormat.values().length];
            try {
                iArr[DecodeFormat.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DecodeFormat.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<DecodeFormat> getEntries() {
        return $ENTRIES;
    }

    DecodeFormat(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final com.bumptech.glide.load.DecodeFormat toGlideFormat() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565;
    }

    public final int toBytes() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
