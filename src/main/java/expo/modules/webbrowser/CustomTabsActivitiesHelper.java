package expo.modules.webbrowser;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import expo.modules.kotlin.AppContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTabsActivitiesHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0014J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00142\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Lexpo/modules/kotlin/AppContext;)V", "canResolveIntent", "", "customTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "customTabsResolvingActivities", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCustomTabsResolvingActivities", "()Ljava/util/ArrayList;", "customTabsResolvingServices", "getCustomTabsResolvingServices", "getPreferredCustomTabsResolvingActivity", "packages", "", "defaultCustomTabsResolvingActivity", "getDefaultCustomTabsResolvingActivity", "()Ljava/lang/String;", "startCustomTabs", "", "tabsIntent", "getResolvingActivities", "Landroid/content/pm/ResolveInfo;", "packageManager", "Landroid/content/pm/PackageManager;", "getPackageManager", "()Landroid/content/pm/PackageManager;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "expo-web-browser_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomTabsActivitiesHelper {
    private final AppContext appContext;

    public CustomTabsActivitiesHelper(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    public final boolean canResolveIntent(CustomTabsIntent customTabsIntent) {
        Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
        return !getResolvingActivities(customTabsIntent).isEmpty();
    }

    public final ArrayList<String> getCustomTabsResolvingActivities() {
        List<ResolveInfo> resolvingActivities = getResolvingActivities(CustomTabsActivitiesHelperKt.createDefaultCustomTabsIntent());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<ResolveInfo> it = resolvingActivities.iterator();
        while (it.hasNext()) {
            String packageName = it.next().activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            linkedHashSet.add(packageName);
        }
        return new ArrayList<>(linkedHashSet);
    }

    public final ArrayList<String> getCustomTabsResolvingServices() {
        List<ResolveInfo> listQueryIntentServices = getPackageManager().queryIntentServices(CustomTabsActivitiesHelperKt.createDefaultCustomTabsServiceIntent(), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentServices, "queryIntentServices(...)");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            String packageName = it.next().serviceInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
            linkedHashSet.add(packageName);
        }
        return new ArrayList<>(linkedHashSet);
    }

    public final String getPreferredCustomTabsResolvingActivity(List<String> packages) {
        if (packages == null) {
            packages = getCustomTabsResolvingActivities();
        }
        return CustomTabsClient.getPackageName(getCurrentActivity(), packages);
    }

    public final String getDefaultCustomTabsResolvingActivity() {
        ActivityInfo activityInfo;
        ResolveInfo resolveInfoResolveActivity = getPackageManager().resolveActivity(CustomTabsActivitiesHelperKt.createDefaultCustomTabsIntent().intent, 0);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return null;
        }
        return activityInfo.packageName;
    }

    public final void startCustomTabs(CustomTabsIntent tabsIntent) throws NoUrlProvidedException {
        Intrinsics.checkNotNullParameter(tabsIntent, "tabsIntent");
        Uri data = tabsIntent.intent.getData();
        if (data != null) {
            tabsIntent.launchUrl(getCurrentActivity(), data);
            return;
        }
        throw new NoUrlProvidedException();
    }

    private final List<ResolveInfo> getResolvingActivities(CustomTabsIntent customTabsIntent) {
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(customTabsIntent.intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return listQueryIntentActivities;
    }

    private final PackageManager getPackageManager() throws PackageManagerNotFoundException {
        PackageManager packageManager = getCurrentActivity().getPackageManager();
        if (packageManager != null) {
            return packageManager;
        }
        throw new PackageManagerNotFoundException();
    }

    private final Activity getCurrentActivity() {
        return this.appContext.getThrowingActivity();
    }
}
