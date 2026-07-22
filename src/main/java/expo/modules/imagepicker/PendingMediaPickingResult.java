package expo.modules.imagepicker;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImagePickerModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\tHÆ\u0003J5\u0010\u0012\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R)\u0010\u0002\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lexpo/modules/imagepicker/PendingMediaPickingResult;", "", UriUtil.DATA_SCHEME, "", "Lkotlin/Pair;", "Lexpo/modules/imagepicker/MediaType;", "Landroid/net/Uri;", "Lexpo/modules/imagepicker/contracts/MediaList;", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "<init>", "(Ljava/util/List;Lexpo/modules/imagepicker/ImagePickerOptions;)V", "getData", "()Ljava/util/List;", "getOptions", "()Lexpo/modules/imagepicker/ImagePickerOptions;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PendingMediaPickingResult {
    private final List<Pair<MediaType, Uri>> data;
    private final ImagePickerOptions options;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendingMediaPickingResult copy$default(PendingMediaPickingResult pendingMediaPickingResult, List list, ImagePickerOptions imagePickerOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pendingMediaPickingResult.data;
        }
        if ((i & 2) != 0) {
            imagePickerOptions = pendingMediaPickingResult.options;
        }
        return pendingMediaPickingResult.copy(list, imagePickerOptions);
    }

    public final List<Pair<MediaType, Uri>> component1() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImagePickerOptions getOptions() {
        return this.options;
    }

    public final PendingMediaPickingResult copy(List<? extends Pair<? extends MediaType, ? extends Uri>> data, ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(options, "options");
        return new PendingMediaPickingResult(data, options);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingMediaPickingResult)) {
            return false;
        }
        PendingMediaPickingResult pendingMediaPickingResult = (PendingMediaPickingResult) other;
        return Intrinsics.areEqual(this.data, pendingMediaPickingResult.data) && Intrinsics.areEqual(this.options, pendingMediaPickingResult.options);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.options.hashCode();
    }

    public String toString() {
        return "PendingMediaPickingResult(data=" + this.data + ", options=" + this.options + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PendingMediaPickingResult(List<? extends Pair<? extends MediaType, ? extends Uri>> data, ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(options, "options");
        this.data = data;
        this.options = options;
    }

    public final List<Pair<MediaType, Uri>> getData() {
        return this.data;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }
}
