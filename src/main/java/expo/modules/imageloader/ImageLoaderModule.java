package expo.modules.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ImageLoaderModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\f\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lexpo/modules/imageloader/ImageLoaderModule;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getExportedInterfaces", "", "Ljava/lang/Class;", "loadImageForDisplayFromURL", "Ljava/util/concurrent/Future;", "Landroid/graphics/Bitmap;", ImagesContract.URL, "", "", "resultListener", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface$ResultListener;", "loadImageForManipulationFromURL", "normalizeAssetsUrl", "expo-image-loader_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageLoaderModule implements InternalModule, ImageLoaderInterface {
    private final Context context;

    public ImageLoaderModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(ImageLoaderInterface.class);
    }

    @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface
    public Future<Bitmap> loadImageForDisplayFromURL(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        loadImageForDisplayFromURL(url, new ImageLoaderInterface.ResultListener() { // from class: expo.modules.imageloader.ImageLoaderModule.loadImageForDisplayFromURL.1
            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
            public void onSuccess(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                simpleSettableFuture.set(bitmap);
            }

            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
            public void onFailure(Throwable cause) {
                simpleSettableFuture.setException(new ExecutionException(cause));
            }
        });
        return simpleSettableFuture;
    }

    @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface
    public void loadImageForDisplayFromURL(String url, final ImageLoaderInterface.ResultListener resultListener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(resultListener, "resultListener");
        Glide.with(this.context).asBitmap().load(url).into(new CustomTarget<Bitmap>() { // from class: expo.modules.imageloader.ImageLoaderModule.loadImageForDisplayFromURL.2
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                resultListener.onSuccess(resource);
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                resultListener.onFailure(new Exception("Loading bitmap failed"));
            }
        });
    }

    @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface
    public Future<Bitmap> loadImageForManipulationFromURL(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        loadImageForManipulationFromURL(url, new ImageLoaderInterface.ResultListener() { // from class: expo.modules.imageloader.ImageLoaderModule.loadImageForManipulationFromURL.1
            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
            public void onSuccess(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                simpleSettableFuture.set(bitmap);
            }

            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
            public void onFailure(Throwable cause) {
                simpleSettableFuture.setException(new ExecutionException(cause));
            }
        });
        return simpleSettableFuture;
    }

    @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface
    public void loadImageForManipulationFromURL(String url, final ImageLoaderInterface.ResultListener resultListener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(resultListener, "resultListener");
        Glide.with(this.context).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).load(normalizeAssetsUrl(url)).into(new CustomTarget<Bitmap>() { // from class: expo.modules.imageloader.ImageLoaderModule.loadImageForManipulationFromURL.2
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                resultListener.onSuccess(resource);
            }

            @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
            public void onLoadFailed(Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                resultListener.onFailure(new Exception("Loading bitmap failed"));
            }
        });
    }

    private final String normalizeAssetsUrl(String url) {
        return StringsKt.startsWith$default(url, "asset:///", false, 2, (Object) null) ? "file:///android_asset/" + CollectionsKt.last(StringsKt.split$default((CharSequence) url, new String[]{"/"}, false, 0, 6, (Object) null)) : url;
    }
}
