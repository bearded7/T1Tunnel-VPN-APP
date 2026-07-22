package expo.modules.haptics.arguments;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HapticsVibrationType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lexpo/modules/haptics/arguments/HapticsVibrationType;", "", "timings", "", "amplitudes", "", "oldSDKPattern", "<init>", "([J[I[J)V", "getTimings", "()[J", "getAmplitudes", "()[I", "getOldSDKPattern", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", "toString", "", "expo-haptics_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HapticsVibrationType {
    private final int[] amplitudes;
    private final long[] oldSDKPattern;
    private final long[] timings;

    public static /* synthetic */ HapticsVibrationType copy$default(HapticsVibrationType hapticsVibrationType, long[] jArr, int[] iArr, long[] jArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            jArr = hapticsVibrationType.timings;
        }
        if ((i & 2) != 0) {
            iArr = hapticsVibrationType.amplitudes;
        }
        if ((i & 4) != 0) {
            jArr2 = hapticsVibrationType.oldSDKPattern;
        }
        return hapticsVibrationType.copy(jArr, iArr, jArr2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long[] getTimings() {
        return this.timings;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int[] getAmplitudes() {
        return this.amplitudes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long[] getOldSDKPattern() {
        return this.oldSDKPattern;
    }

    public final HapticsVibrationType copy(long[] timings, int[] amplitudes, long[] oldSDKPattern) {
        Intrinsics.checkNotNullParameter(timings, "timings");
        Intrinsics.checkNotNullParameter(amplitudes, "amplitudes");
        Intrinsics.checkNotNullParameter(oldSDKPattern, "oldSDKPattern");
        return new HapticsVibrationType(timings, amplitudes, oldSDKPattern);
    }

    public String toString() {
        return "HapticsVibrationType(timings=" + Arrays.toString(this.timings) + ", amplitudes=" + Arrays.toString(this.amplitudes) + ", oldSDKPattern=" + Arrays.toString(this.oldSDKPattern) + ")";
    }

    public HapticsVibrationType(long[] timings, int[] amplitudes, long[] oldSDKPattern) {
        Intrinsics.checkNotNullParameter(timings, "timings");
        Intrinsics.checkNotNullParameter(amplitudes, "amplitudes");
        Intrinsics.checkNotNullParameter(oldSDKPattern, "oldSDKPattern");
        this.timings = timings;
        this.amplitudes = amplitudes;
        this.oldSDKPattern = oldSDKPattern;
    }

    public final long[] getTimings() {
        return this.timings;
    }

    public final int[] getAmplitudes() {
        return this.amplitudes;
    }

    public final long[] getOldSDKPattern() {
        return this.oldSDKPattern;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type expo.modules.haptics.arguments.HapticsVibrationType");
        HapticsVibrationType hapticsVibrationType = (HapticsVibrationType) other;
        return Arrays.equals(this.timings, hapticsVibrationType.timings) && Arrays.equals(this.amplitudes, hapticsVibrationType.amplitudes) && Arrays.equals(this.oldSDKPattern, hapticsVibrationType.oldSDKPattern);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.timings) * 31) + Arrays.hashCode(this.amplitudes)) * 31) + Arrays.hashCode(this.oldSDKPattern);
    }
}
