package expo.modules.image.records;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import expo.modules.image.DecodedModelProvider;
import expo.modules.image.GlideModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SourceMap.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lexpo/modules/image/records/DecodedSource;", "Lexpo/modules/image/records/Source;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "createGlideModelProvider", "Lexpo/modules/image/GlideModelProvider;", "context", "Landroid/content/Context;", "width", "", "getWidth", "()I", "height", "getHeight", "scale", "", "getScale", "()D", "createGlideOptions", "Lcom/bumptech/glide/request/RequestOptions;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DecodedSource implements Source {
    private final Drawable drawable;
    private final int height;
    private final double scale;
    private final int width;

    public DecodedSource(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
        this.width = drawable.getIntrinsicWidth();
        this.height = drawable.getIntrinsicHeight();
        this.scale = 1.0d;
    }

    @Override // expo.modules.image.records.Source
    public double getPixelCount() {
        return Source.DefaultImpls.getPixelCount(this);
    }

    @Override // expo.modules.image.records.Source
    public boolean usesPlaceholderContentFit() {
        return Source.DefaultImpls.usesPlaceholderContentFit(this);
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Override // expo.modules.image.records.Source
    public GlideModelProvider createGlideModelProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DecodedModelProvider(this.drawable);
    }

    @Override // expo.modules.image.records.Source
    public int getWidth() {
        return this.width;
    }

    @Override // expo.modules.image.records.Source
    public int getHeight() {
        return this.height;
    }

    @Override // expo.modules.image.records.Source
    public double getScale() {
        return this.scale;
    }

    @Override // expo.modules.image.records.Source
    public RequestOptions createGlideOptions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestOptions requestOptionsDiskCacheStrategy = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        Intrinsics.checkNotNullExpressionValue(requestOptionsDiskCacheStrategy, "diskCacheStrategy(...)");
        return requestOptionsDiskCacheStrategy;
    }
}
