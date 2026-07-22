package expo.modules.location;

import kotlin.Metadata;

/* JADX INFO: compiled from: LocationHelpers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/location/AppForegroundedSingleton;", "", "<init>", "()V", "isForegrounded", "", "()Z", "setForegrounded", "(Z)V", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppForegroundedSingleton {
    public static final AppForegroundedSingleton INSTANCE = new AppForegroundedSingleton();
    private static boolean isForegrounded;

    private AppForegroundedSingleton() {
    }

    public final boolean isForegrounded() {
        return isForegrounded;
    }

    public final void setForegrounded(boolean z) {
        isForegrounded = z;
    }
}
