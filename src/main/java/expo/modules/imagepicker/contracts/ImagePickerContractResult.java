package expo.modules.imagepicker.contracts;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import expo.modules.imagepicker.MediaType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContractsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "", "<init>", "()V", "Success", "Cancelled", "Error", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Cancelled;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Error;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ImagePickerContractResult {
    public /* synthetic */ ImagePickerContractResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ContractsUtils.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tR)\u0010\u0002\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", UriUtil.DATA_SCHEME, "", "Lkotlin/Pair;", "Lexpo/modules/imagepicker/MediaType;", "Landroid/net/Uri;", "Lexpo/modules/imagepicker/contracts/MediaList;", "<init>", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Success extends ImagePickerContractResult {
        private final List<Pair<MediaType, Uri>> data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Success(List<? extends Pair<? extends MediaType, ? extends Uri>> data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public final List<Pair<MediaType, Uri>> getData() {
            return this.data;
        }
    }

    private ImagePickerContractResult() {
    }

    /* JADX INFO: compiled from: ContractsUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Cancelled;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "<init>", "()V", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Cancelled extends ImagePickerContractResult {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ContractsUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Error;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "<init>", "()V", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Error extends ImagePickerContractResult {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }
}
