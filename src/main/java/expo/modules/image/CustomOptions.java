package expo.modules.image;

import com.bumptech.glide.load.Option;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/image/CustomOptions;", "", "<init>", "()V", "tintColor", "Lcom/bumptech/glide/load/Option;", "", "kotlin.jvm.PlatformType", "getTintColor", "()Lcom/bumptech/glide/load/Option;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomOptions {
    public static final CustomOptions INSTANCE = new CustomOptions();
    private static final Option<Integer> tintColor;

    private CustomOptions() {
    }

    static {
        Option<Integer> optionMemory = Option.memory("ExpoTintColor");
        Intrinsics.checkNotNullExpressionValue(optionMemory, "memory(...)");
        tintColor = optionMemory;
    }

    public final Option<Integer> getTintColor() {
        return tintColor;
    }
}
