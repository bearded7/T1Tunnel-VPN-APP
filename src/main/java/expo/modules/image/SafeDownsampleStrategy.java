package expo.modules.image;

import android.os.Build;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import expo.modules.image.records.DecodeFormat;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CustomDownsampleStrategy.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lexpo/modules/image/SafeDownsampleStrategy;", "Lexpo/modules/image/CustomDownsampleStrategy;", "decodeFormat", "Lexpo/modules/image/records/DecodeFormat;", "<init>", "(Lexpo/modules/image/records/DecodeFormat;)V", "getScaleFactor", "", "sourceWidth", "", "sourceHeight", "requestedWidth", "requestedHeight", "getSampleSizeRounding", "Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy$SampleSizeRounding;", "maxBitmapSize", "getMaxBitmapSize", "()I", "maxBitmapSize$delegate", "Lkotlin/Lazy;", "equals", "", "other", "", "hashCode", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SafeDownsampleStrategy extends CustomDownsampleStrategy {
    private final DecodeFormat decodeFormat;

    /* JADX INFO: renamed from: maxBitmapSize$delegate, reason: from kotlin metadata */
    private final Lazy maxBitmapSize;

    public SafeDownsampleStrategy(DecodeFormat decodeFormat) {
        Intrinsics.checkNotNullParameter(decodeFormat, "decodeFormat");
        this.decodeFormat = decodeFormat;
        this.maxBitmapSize = LazyKt.lazy(new Function0() { // from class: expo.modules.image.SafeDownsampleStrategy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(SafeDownsampleStrategy.maxBitmapSize_delegate$lambda$0());
            }
        });
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public float getScaleFactor(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
        if (getMaxBitmapSize() <= 0 || sourceWidth * sourceHeight * this.decodeFormat.toBytes() <= getMaxBitmapSize()) {
            return 1.0f;
        }
        return (float) (((double) ((int) Math.floor(Math.sqrt(((double) (getMaxBitmapSize() / this.decodeFormat.toBytes())) / (((double) Math.min(sourceWidth, sourceHeight)) / ((double) Math.max(sourceWidth, sourceHeight))))))) / ((double) Math.max(sourceWidth, sourceHeight)));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
        return DownsampleStrategy.SampleSizeRounding.MEMORY;
    }

    private final int getMaxBitmapSize() {
        return ((Number) this.maxBitmapSize.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxBitmapSize_delegate$lambda$0() {
        if (Build.VERSION.SDK_INT < 29) {
            return -1;
        }
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, "ro.hwui.max_texture_allocation_size", 104857600);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return RangesKt.coerceAtLeast(((Integer) objInvoke).intValue(), 104857600);
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // expo.modules.image.CustomDownsampleStrategy
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SafeDownsampleStrategy) && this.decodeFormat == ((SafeDownsampleStrategy) other).decodeFormat;
    }

    @Override // expo.modules.image.CustomDownsampleStrategy
    public int hashCode() {
        return (super.hashCode() * 31) + this.decodeFormat.hashCode();
    }
}
