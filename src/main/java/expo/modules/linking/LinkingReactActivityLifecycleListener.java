package expo.modules.linking;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LinkingReactActivityLifecycleListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lexpo/modules/linking/LinkingReactActivityLifecycleListener;", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "<init>", "()V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "", "intent", "Landroid/content/Intent;", "onReceiveURL", ImagesContract.URL, "Landroid/net/Uri;", "expo-linking_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkingReactActivityLifecycleListener implements ReactActivityLifecycleListener {
    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        onReceiveURL((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getData());
    }

    @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
    public boolean onNewIntent(Intent intent) {
        onReceiveURL(intent != null ? intent.getData() : null);
        return true;
    }

    private final void onReceiveURL(Uri url) {
        if (url == null) {
            return;
        }
        ExpoLinkingModule.INSTANCE.setInitialURL(url);
        Iterator<T> it = ExpoLinkingModule.INSTANCE.getOnURLReceivedObservers().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(url);
        }
    }
}
