package expo.modules.webbrowser;

import android.content.Intent;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTabsActivitiesHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u0002H\u00040\u0003j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00040\tH\u0082\b\u001a\b\u0010\n\u001a\u00020\u000bH\u0002\u001a\b\u0010\f\u001a\u00020\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"DUMMY_URL", "", "mapToDistinctArrayList", "Ljava/util/ArrayList;", "R", "Lkotlin/collections/ArrayList;", ExifInterface.GPS_DIRECTION_TRUE, "", "mapper", "Lkotlin/Function1;", "createDefaultCustomTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "createDefaultCustomTabsServiceIntent", "Landroid/content/Intent;", "expo-web-browser_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CustomTabsActivitiesHelperKt {
    private static final String DUMMY_URL = "https://expo.dev";

    private static final <T, R> ArrayList<R> mapToDistinctArrayList(Collection<? extends T> collection, Function1<? super T, ? extends R> function1) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(function1.invoke(it.next()));
        }
        return new ArrayList<>(linkedHashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomTabsIntent createDefaultCustomTabsIntent() {
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        customTabsIntentBuild.intent.setData(Uri.parse(DUMMY_URL));
        return customTabsIntentBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Intent createDefaultCustomTabsServiceIntent() {
        Intent intent = new Intent();
        intent.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        return intent;
    }
}
