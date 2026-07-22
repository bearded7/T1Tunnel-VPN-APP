package expo.modules;

import android.app.Application;
import android.content.res.Configuration;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import expo.modules.core.interfaces.Package;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplicationLifecycleDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\tH\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/ApplicationLifecycleDispatcher;", "", "<init>", "()V", "listeners", "", "Lexpo/modules/core/interfaces/ApplicationLifecycleListener;", "getCachedListeners", "application", "Landroid/app/Application;", "onApplicationCreate", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplicationLifecycleDispatcher {
    public static final ApplicationLifecycleDispatcher INSTANCE = new ApplicationLifecycleDispatcher();
    private static List<? extends ApplicationLifecycleListener> listeners;

    private ApplicationLifecycleDispatcher() {
    }

    private final List<ApplicationLifecycleListener> getCachedListeners(Application application) {
        List list = listeners;
        if (list != null) {
            return list;
        }
        List<Package> packageList = ExpoModulesPackage.INSTANCE.getPackageList();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = packageList.iterator();
        while (it.hasNext()) {
            List<? extends ApplicationLifecycleListener> listCreateApplicationLifecycleListeners = ((Package) it.next()).createApplicationLifecycleListeners(application);
            Intrinsics.checkNotNullExpressionValue(listCreateApplicationLifecycleListeners, "createApplicationLifecycleListeners(...)");
            CollectionsKt.addAll(arrayList, listCreateApplicationLifecycleListeners);
        }
        ArrayList arrayList2 = arrayList;
        listeners = arrayList2;
        return arrayList2;
    }

    @JvmStatic
    public static final void onApplicationCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Iterator<T> it = INSTANCE.getCachedListeners(application).iterator();
        while (it.hasNext()) {
            ((ApplicationLifecycleListener) it.next()).onCreate(application);
        }
    }

    @JvmStatic
    public static final void onConfigurationChanged(Application application, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Iterator<T> it = INSTANCE.getCachedListeners(application).iterator();
        while (it.hasNext()) {
            ((ApplicationLifecycleListener) it.next()).onConfigurationChanged(newConfig);
        }
    }
}
