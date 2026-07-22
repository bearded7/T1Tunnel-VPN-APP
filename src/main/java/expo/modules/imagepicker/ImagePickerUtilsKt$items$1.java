package expo.modules.imagepicker;

import android.content.ClipData;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: ImagePickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0002\u0000\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"expo/modules/imagepicker/ImagePickerUtilsKt$items$1", "", "Landroid/content/ClipData$Item;", "iterator", "expo/modules/imagepicker/ImagePickerUtilsKt$items$1$iterator$1", "()Lexpo/modules/imagepicker/ImagePickerUtilsKt$items$1$iterator$1;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePickerUtilsKt$items$1 implements Iterable<ClipData.Item>, KMappedMarker {
    final /* synthetic */ ClipData $this_items;

    ImagePickerUtilsKt$items$1(ClipData clipData) {
        this.$this_items = clipData;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<ClipData.Item> iterator2() {
        return new ImagePickerUtilsKt$items$1$iterator$1(this.$this_items);
    }
}
