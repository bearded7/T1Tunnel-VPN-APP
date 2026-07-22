package expo.modules.image;

import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideModelProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/image/RawModelProvider;", "Lexpo/modules/image/GlideModelProvider;", UriUtil.DATA_SCHEME, "", "<init>", "(Ljava/lang/String;)V", "getGlideModel", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RawModelProvider implements GlideModelProvider {
    private final String data;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final String getData() {
        return this.data;
    }

    public static /* synthetic */ RawModelProvider copy$default(RawModelProvider rawModelProvider, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rawModelProvider.data;
        }
        return rawModelProvider.copy(str);
    }

    public final RawModelProvider copy(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new RawModelProvider(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RawModelProvider) && Intrinsics.areEqual(this.data, ((RawModelProvider) other).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "RawModelProvider(data=" + this.data + ")";
    }

    public RawModelProvider(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // expo.modules.image.GlideModelProvider
    public String getGlideModel() {
        return this.data;
    }
}
