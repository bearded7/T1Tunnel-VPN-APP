package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.facebook.hermes.intl.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurhashModelLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J?\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u0002H\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u0002H\u00110\u0017H\u0002¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashModelLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/blurhash/BlurhashModel;", "Landroid/graphics/Bitmap;", "<init>", "()V", "handles", "", "model", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "getPath", ExifInterface.GPS_DIRECTION_TRUE, "uri", "Landroid/net/Uri;", "index", Constants.COLLATION_DEFAULT, "converter", "Lkotlin/Function1;", "", "(Landroid/net/Uri;ILjava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlurhashModelLoader implements ModelLoader<BlurhashModel, Bitmap> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String buildLoadData$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(BlurhashModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Bitmap> buildLoadData(BlurhashModel model, int width, int height, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData<>(new ObjectKey(model), new BlurHashFetcher((String) getPath(model.getUri(), 0, null, new Function1() { // from class: expo.modules.image.blurhash.BlurhashModelLoader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlurhashModelLoader.buildLoadData$lambda$0((String) obj);
            }
        }), model.getWidth(), model.getHeight(), 1.0f));
    }

    private final <T> T getPath(Uri uri, int index, T t, Function1<? super String, ? extends T> converter) {
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        String str = (String) CollectionsKt.getOrNull(pathSegments, index);
        return str == null ? t : converter.invoke(str);
    }
}
