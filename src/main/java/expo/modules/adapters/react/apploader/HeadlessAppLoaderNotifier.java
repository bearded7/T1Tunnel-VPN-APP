package expo.modules.adapters.react.apploader;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeadlessAppLoaderNotifier.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lexpo/modules/adapters/react/apploader/HeadlessAppLoaderNotifier;", "", "<init>", "()V", "listeners", "", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/adapters/react/apploader/HeadlessAppLoaderListener;", "getListeners", "()Ljava/util/Set;", "registerListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "notifyAppLoaded", "appScopeKey", "", "notifyAppDestroyed", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadlessAppLoaderNotifier {
    public static final HeadlessAppLoaderNotifier INSTANCE = new HeadlessAppLoaderNotifier();
    private static final Set<WeakReference<HeadlessAppLoaderListener>> listeners = new LinkedHashSet();

    private HeadlessAppLoaderNotifier() {
    }

    public final Set<WeakReference<HeadlessAppLoaderListener>> getListeners() {
        return listeners;
    }

    public final void registerListener(HeadlessAppLoaderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(new WeakReference<>(listener));
    }

    public final void notifyAppLoaded(String appScopeKey) {
        if (appScopeKey != null) {
            Iterator<T> it = listeners.iterator();
            while (it.hasNext()) {
                HeadlessAppLoaderListener headlessAppLoaderListener = (HeadlessAppLoaderListener) ((WeakReference) it.next()).get();
                if (headlessAppLoaderListener != null) {
                    headlessAppLoaderListener.appLoaded(appScopeKey);
                }
            }
        }
    }

    public final void notifyAppDestroyed(String appScopeKey) {
        if (appScopeKey != null) {
            Iterator<T> it = listeners.iterator();
            while (it.hasNext()) {
                HeadlessAppLoaderListener headlessAppLoaderListener = (HeadlessAppLoaderListener) ((WeakReference) it.next()).get();
                if (headlessAppLoaderListener != null) {
                    headlessAppLoaderListener.appDestroyed(appScopeKey);
                }
            }
        }
    }
}
