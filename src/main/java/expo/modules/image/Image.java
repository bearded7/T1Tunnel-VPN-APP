package expo.modules.image;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import expo.modules.kotlin.sharedobjects.SharedRef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Image.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lexpo/modules/image/Image;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Landroid/graphics/drawable/Drawable;", "ref", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "nativeRefType", "", "getNativeRefType", "()Ljava/lang/String;", "getAdditionalMemoryPressure", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Image extends SharedRef<Drawable> {
    private final String nativeRefType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Image(Drawable ref) {
        super(ref, null, 2, null);
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.nativeRefType = "image";
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedRef
    public String getNativeRefType() {
        return this.nativeRefType;
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public int getAdditionalMemoryPressure() {
        Drawable ref = getRef();
        if (ref instanceof BitmapDrawable) {
            return ((BitmapDrawable) ref).getBitmap().getAllocationByteCount();
        }
        return ref.getIntrinsicWidth() * ref.getIntrinsicHeight();
    }
}
