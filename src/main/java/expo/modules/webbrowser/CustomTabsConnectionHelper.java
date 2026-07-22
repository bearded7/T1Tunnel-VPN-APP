package expo.modules.webbrowser;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import expo.modules.core.interfaces.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTabsConnectionHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lexpo/modules/webbrowser/CustomTabsConnectionHelper;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "currentPackageName", "", "clientActions", "Lexpo/modules/webbrowser/DeferredClientActionsQueue;", "Landroidx/browser/customtabs/CustomTabsClient;", "sessionActions", "Landroidx/browser/customtabs/CustomTabsSession;", "destroy", "", "warmUp", "packageName", "mayInitWithUrl", "uri", "Landroid/net/Uri;", "coolDown", "", "onBindingDied", "componentName", "Landroid/content/ComponentName;", "onCustomTabsServiceConnected", "client", "onServiceDisconnected", "ensureSession", "ensureConnection", "isConnectionStarted", "clearConnection", "expo-web-browser_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomTabsConnectionHelper extends CustomTabsServiceConnection {
    private final DeferredClientActionsQueue<CustomTabsClient> clientActions;
    private final Context context;
    private String currentPackageName;
    private final DeferredClientActionsQueue<CustomTabsSession> sessionActions;

    public CustomTabsConnectionHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.clientActions = new DeferredClientActionsQueue<>();
        this.sessionActions = new DeferredClientActionsQueue<>();
    }

    public final void destroy() {
        clearConnection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmUp$lambda$0(CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.warmup(0L);
    }

    public final void warmUp(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.clientActions.executeOrQueueAction(new Consumer() { // from class: expo.modules.webbrowser.CustomTabsConnectionHelper$$ExternalSyntheticLambda0
            @Override // expo.modules.core.interfaces.Consumer
            public final void apply(Object obj) {
                CustomTabsConnectionHelper.warmUp$lambda$0((CustomTabsClient) obj);
            }
        });
        ensureConnection(packageName);
    }

    public final void mayInitWithUrl(String packageName, final Uri uri) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.sessionActions.executeOrQueueAction(new Consumer() { // from class: expo.modules.webbrowser.CustomTabsConnectionHelper$$ExternalSyntheticLambda2
            @Override // expo.modules.core.interfaces.Consumer
            public final void apply(Object obj) {
                CustomTabsConnectionHelper.mayInitWithUrl$lambda$1(uri, (CustomTabsSession) obj);
            }
        });
        ensureConnection(packageName);
        ensureSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mayInitWithUrl$lambda$1(Uri uri, CustomTabsSession customTabsSession) {
        if (customTabsSession != null) {
            customTabsSession.mayLaunchUrl(uri, null, null);
        }
    }

    public final boolean coolDown(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (!isConnectionStarted(packageName)) {
            return false;
        }
        clearConnection();
        return true;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        if (isConnectionStarted(packageName)) {
            clearConnection();
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(client, "client");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        if (isConnectionStarted(packageName)) {
            this.clientActions.setClient(client);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        if (isConnectionStarted(packageName)) {
            clearConnection();
        }
    }

    private final void ensureSession() {
        if (this.sessionActions.hasClient()) {
            return;
        }
        this.clientActions.executeOrQueueAction(new Consumer() { // from class: expo.modules.webbrowser.CustomTabsConnectionHelper$$ExternalSyntheticLambda1
            @Override // expo.modules.core.interfaces.Consumer
            public final void apply(Object obj) {
                CustomTabsConnectionHelper.ensureSession$lambda$2(this.f$0, (CustomTabsClient) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureSession$lambda$2(CustomTabsConnectionHelper customTabsConnectionHelper, CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        customTabsConnectionHelper.sessionActions.setClient(client.newSession(null));
    }

    private final void ensureConnection(String packageName) {
        String str = this.currentPackageName;
        if (str != null && !Intrinsics.areEqual(str, packageName)) {
            clearConnection();
        }
        if (isConnectionStarted(packageName)) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(this.context, packageName, this);
        this.currentPackageName = packageName;
    }

    private final boolean isConnectionStarted(String packageName) {
        return Intrinsics.areEqual(packageName, this.currentPackageName);
    }

    private final void clearConnection() {
        if (this.currentPackageName != null) {
            this.context.unbindService(this);
        }
        this.currentPackageName = null;
        this.clientActions.clear();
        this.sessionActions.clear();
    }
}
