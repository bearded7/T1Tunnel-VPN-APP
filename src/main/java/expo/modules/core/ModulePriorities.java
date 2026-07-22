package expo.modules.core;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: ModulePriorities.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/core/ModulePriorities;", "", "<init>", "()V", "get", "", "packageName", "", "SUPPORTED_MODULES", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModulePriorities {
    public static final ModulePriorities INSTANCE = new ModulePriorities();
    private static final Map<String, Integer> SUPPORTED_MODULES = MapsKt.mapOf(TuplesKt.to("host.exp.exponent.experience.splashscreen.legacy.SplashScreenPackage", 11), TuplesKt.to("expo.modules.updates.UpdatesPackage", 10));

    private ModulePriorities() {
    }

    public final int get(String packageName) {
        Integer num;
        if (packageName == null || (num = SUPPORTED_MODULES.get(packageName)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
