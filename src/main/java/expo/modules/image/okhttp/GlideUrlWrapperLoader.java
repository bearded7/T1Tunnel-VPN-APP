package expo.modules.image.okhttp;

import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.facebook.react.modules.network.ProgressListener;
import com.facebook.react.modules.network.ProgressResponseBody;
import expo.modules.image.events.OkHttpProgressListener;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: GlideUrlWrapperLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWrapperLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/okhttp/GlideUrlWrapper;", "Ljava/io/InputStream;", "commonClient", "Lokhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;)V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "Factory", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideUrlWrapperLoader implements ModelLoader<GlideUrlWrapper, InputStream> {
    private final OkHttpClient commonClient;

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(GlideUrlWrapper model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    public GlideUrlWrapperLoader(OkHttpClient commonClient) {
        Intrinsics.checkNotNullParameter(commonClient, "commonClient");
        this.commonClient = commonClient;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<InputStream> buildLoadData(final GlideUrlWrapper model, int width, int height, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new OkHttpUrlLoader(this.commonClient.newBuilder().addInterceptor(new Interceptor() { // from class: expo.modules.image.okhttp.GlideUrlWrapperLoader$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return GlideUrlWrapperLoader.buildLoadData$lambda$1(model, chain);
            }
        }).build()).buildLoadData(model.getGlideUrl(), width, height, options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response buildLoadData$lambda$1(final GlideUrlWrapper glideUrlWrapper, Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response responseProceed = chain.proceed(chain.request());
        Response.Builder builderNewBuilder = responseProceed.newBuilder();
        ResponseBody responseBodyBody = responseProceed.body();
        if (responseBodyBody == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return builderNewBuilder.body(new ProgressResponseBody(responseBodyBody, new ProgressListener() { // from class: expo.modules.image.okhttp.GlideUrlWrapperLoader$$ExternalSyntheticLambda1
            @Override // com.facebook.react.modules.network.ProgressListener
            public final void onProgress(long j, long j2, boolean z) {
                GlideUrlWrapperLoader.buildLoadData$lambda$1$lambda$0(glideUrlWrapper, j, j2, z);
            }
        })).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildLoadData$lambda$1$lambda$0(GlideUrlWrapper glideUrlWrapper, long j, long j2, boolean z) {
        OkHttpProgressListener progressListener = glideUrlWrapper.getProgressListener();
        if (progressListener != null) {
            progressListener.onProgress(j, j2, z);
        }
    }

    /* JADX INFO: compiled from: GlideUrlWrapperLoader.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWrapperLoader$Factory;", "Lcom/bumptech/glide/load/model/ModelLoaderFactory;", "Lexpo/modules/image/okhttp/GlideUrlWrapper;", "Ljava/io/InputStream;", "commonClient", "Lokhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;)V", "build", "Lcom/bumptech/glide/load/model/ModelLoader;", "multiFactory", "Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;", "teardown", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Factory implements ModelLoaderFactory<GlideUrlWrapper, InputStream> {
        private final OkHttpClient commonClient;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }

        public Factory(OkHttpClient commonClient) {
            Intrinsics.checkNotNullParameter(commonClient, "commonClient");
            this.commonClient = commonClient;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader<GlideUrlWrapper, InputStream> build(MultiModelLoaderFactory multiFactory) {
            Intrinsics.checkNotNullParameter(multiFactory, "multiFactory");
            return new GlideUrlWrapperLoader(this.commonClient);
        }
    }
}
