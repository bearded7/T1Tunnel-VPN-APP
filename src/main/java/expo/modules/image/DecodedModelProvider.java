package expo.modules.image;

import android.graphics.drawable.Drawable;
import expo.modules.image.decodedsource.DecodedModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideModelProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\t\u0010\b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/DecodedModelProvider;", "Lexpo/modules/image/GlideModelProvider;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "getGlideModel", "Lexpo/modules/image/decodedsource/DecodedModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DecodedModelProvider implements GlideModelProvider {
    private final Drawable drawable;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Drawable getDrawable() {
        return this.drawable;
    }

    public static /* synthetic */ DecodedModelProvider copy$default(DecodedModelProvider decodedModelProvider, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = decodedModelProvider.drawable;
        }
        return decodedModelProvider.copy(drawable);
    }

    public final DecodedModelProvider copy(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return new DecodedModelProvider(drawable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DecodedModelProvider) && Intrinsics.areEqual(this.drawable, ((DecodedModelProvider) other).drawable);
    }

    public int hashCode() {
        return this.drawable.hashCode();
    }

    public String toString() {
        return "DecodedModelProvider(drawable=" + this.drawable + ")";
    }

    public DecodedModelProvider(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
    }

    @Override // expo.modules.image.GlideModelProvider
    public DecodedModel getGlideModel() {
        return new DecodedModel(this.drawable);
    }
}
