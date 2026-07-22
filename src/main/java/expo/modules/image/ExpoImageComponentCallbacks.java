package expo.modules.image;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import expo.modules.image.blurhash.BlurhashDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoImageComponentCallbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lexpo/modules/image/ExpoImageComponentCallbacks;", "Landroid/content/ComponentCallbacks2;", "<init>", "()V", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "onTrimMemory", "level", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoImageComponentCallbacks implements ComponentCallbacks2 {
    public static final ExpoImageComponentCallbacks INSTANCE = new ExpoImageComponentCallbacks();

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    private ExpoImageComponentCallbacks() {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        BlurhashDecoder.INSTANCE.clearCache();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        if (level == 15) {
            onLowMemory();
        }
    }
}
