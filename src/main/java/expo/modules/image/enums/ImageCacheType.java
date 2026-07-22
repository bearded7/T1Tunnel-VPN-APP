package expo.modules.image.enums;

import com.bumptech.glide.load.DataSource;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageCacheType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u001d\b\u0002\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lexpo/modules/image/enums/ImageCacheType;", "", "dataSources", "", "Lcom/bumptech/glide/load/DataSource;", "<init>", "(Ljava/lang/String;I[Lcom/bumptech/glide/load/DataSource;)V", "[Lcom/bumptech/glide/load/DataSource;", "NONE", "DISK", "MEMORY", "Companion", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ImageCacheType {
    NONE(DataSource.LOCAL, DataSource.REMOTE),
    DISK(DataSource.DATA_DISK_CACHE, DataSource.RESOURCE_DISK_CACHE),
    MEMORY(DataSource.MEMORY_CACHE);

    private final DataSource[] dataSources;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ImageCacheType> getEntries() {
        return $ENTRIES;
    }

    ImageCacheType(DataSource... dataSourceArr) {
        this.dataSources = dataSourceArr;
    }

    /* JADX INFO: compiled from: ImageCacheType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/image/enums/ImageCacheType$Companion;", "", "<init>", "()V", "fromNativeValue", "Lexpo/modules/image/enums/ImageCacheType;", "value", "Lcom/bumptech/glide/load/DataSource;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageCacheType fromNativeValue(DataSource value) {
            ImageCacheType next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<ImageCacheType> it = ImageCacheType.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!ArraysKt.contains(next.dataSources, value));
            ImageCacheType imageCacheType = next;
            return imageCacheType == null ? ImageCacheType.NONE : imageCacheType;
        }
    }
}
