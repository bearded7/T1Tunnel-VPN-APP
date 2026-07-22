package expo.modules.haptics.arguments;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HapticsImpactType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/haptics/arguments/HapticsImpactType;", "", "<init>", "()V", "types", "", "", "Lexpo/modules/haptics/arguments/HapticsVibrationType;", "fromString", "style", "expo-haptics_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HapticsImpactType {
    public static final HapticsImpactType INSTANCE = new HapticsImpactType();
    private static final Map<String, HapticsVibrationType> types = MapsKt.mapOf(TuplesKt.to("light", new HapticsVibrationType(new long[]{0, 50}, new int[]{0, 30}, new long[]{0, 20})), TuplesKt.to("soft", new HapticsVibrationType(new long[]{0, 50}, new int[]{0, 30}, new long[]{0, 20})), TuplesKt.to("medium", new HapticsVibrationType(new long[]{0, 43}, new int[]{0, 50}, new long[]{0, 43})), TuplesKt.to("rigid", new HapticsVibrationType(new long[]{0, 43}, new int[]{0, 50}, new long[]{0, 43})), TuplesKt.to("heavy", new HapticsVibrationType(new long[]{0, 60}, new int[]{0, 70}, new long[]{0, 61})));

    private HapticsImpactType() {
    }

    public final HapticsVibrationType fromString(String style) throws HapticsInvalidArgumentException {
        Intrinsics.checkNotNullParameter(style, "style");
        HapticsVibrationType hapticsVibrationType = types.get(style);
        if (hapticsVibrationType != null) {
            return hapticsVibrationType;
        }
        throw new HapticsInvalidArgumentException("'style' must be one of ['light', 'medium', 'heavy', 'rigid', 'soft']. Obtained " + style + "'.");
    }
}
