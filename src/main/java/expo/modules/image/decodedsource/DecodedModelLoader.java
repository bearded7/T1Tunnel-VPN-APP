package expo.modules.image.decodedsource;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecodedModelLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lexpo/modules/image/decodedsource/DecodedModelLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/decodedsource/DecodedModel;", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "handles", "", "model", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DecodedModelLoader implements ModelLoader<DecodedModel, Drawable> {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(DecodedModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Drawable> buildLoadData(DecodedModel model, int width, int height, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DecodedFetcher(model.getDrawable()));
    }
}
