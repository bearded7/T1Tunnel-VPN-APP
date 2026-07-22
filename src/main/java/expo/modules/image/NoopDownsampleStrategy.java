package expo.modules.image;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import kotlin.Metadata;

/* JADX INFO: compiled from: CustomDownsampleStrategy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lexpo/modules/image/NoopDownsampleStrategy;", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;", "<init>", "()V", "getScaleFactor", "", "sourceWidth", "", "sourceHeight", "requestedWidth", "requestedHeight", "getSampleSizeRounding", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy$SampleSizeRounding;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopDownsampleStrategy extends DownsampleStrategy {
    public static final NoopDownsampleStrategy INSTANCE = new NoopDownsampleStrategy();

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public float getScaleFactor(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
        return 1.0f;
    }

    private NoopDownsampleStrategy() {
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }
}
