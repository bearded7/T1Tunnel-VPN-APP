package expo.modules.location.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationTaskService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0017J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0003J\u0019\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010#R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lexpo/modules/location/services/LocationTaskService;", "Landroid/app/Service;", "<init>", "()V", "mChannelId", "", "mKillService", "", "mParentContext", "Landroid/content/Context;", "mServiceId", "", "mBinder", "Landroid/os/IBinder;", "onBind", "intent", "Landroid/content/Intent;", "onStartCommand", "flags", "startId", "setParentContext", "", "context", "stop", "onTaskRemoved", "rootIntent", "startForeground", "serviceOptions", "Landroid/os/Bundle;", "buildServiceNotification", "Landroid/app/Notification;", "prepareChannel", "id", "colorStringToInteger", ViewProps.COLOR, "(Ljava/lang/String;)Ljava/lang/Integer;", "ServiceBinder", "Companion", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationTaskService extends Service {
    private static int sServiceId = 481756;
    private final IBinder mBinder;
    private String mChannelId;
    private boolean mKillService;
    private Context mParentContext;
    private final int mServiceId;

    public LocationTaskService() {
        int i = sServiceId;
        sServiceId = i + 1;
        this.mServiceId = i;
        this.mBinder = new ServiceBinder();
    }

    /* JADX INFO: compiled from: LocationTaskService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/location/services/LocationTaskService$ServiceBinder;", "Landroid/os/Binder;", "<init>", "(Lexpo/modules/location/services/LocationTaskService;)V", NotificationCompat.CATEGORY_SERVICE, "Lexpo/modules/location/services/LocationTaskService;", "getService", "()Lexpo/modules/location/services/LocationTaskService;", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ServiceBinder extends Binder {
        public ServiceBinder() {
        }

        /* JADX INFO: renamed from: getService, reason: from getter */
        public final LocationTaskService getThis$0() {
            return LocationTaskService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.mBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return 3;
        }
        this.mChannelId = extras.getString("appId") + ":" + extras.getString("taskName");
        this.mKillService = extras.getBoolean("killService", false);
        return 3;
    }

    public final void setParentContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mParentContext = context;
    }

    public final void stop() {
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        Intrinsics.checkNotNullParameter(rootIntent, "rootIntent");
        if (this.mKillService) {
            super.onTaskRemoved(rootIntent);
            stop();
        }
    }

    public final void startForeground(Bundle serviceOptions) {
        Intrinsics.checkNotNullParameter(serviceOptions, "serviceOptions");
        startForeground(this.mServiceId, buildServiceNotification(serviceOptions));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x004b  */
    private final Notification buildServiceNotification(Bundle serviceOptions) {
        prepareChannel(this.mChannelId);
        LocationTaskService locationTaskService = this;
        Notification.Builder builder = new Notification.Builder(locationTaskService, this.mChannelId);
        String string = serviceOptions.getString("notificationTitle");
        String string2 = serviceOptions.getString("notificationBody");
        Integer numColorStringToInteger = colorStringToInteger(serviceOptions.getString("notificationColor"));
        if (string != null) {
            builder.setContentTitle(string);
        }
        if (string2 != null) {
            builder.setContentText(string2);
        }
        if (numColorStringToInteger != null) {
            numColorStringToInteger.intValue();
            if (builder.setColorized(true).setColor(numColorStringToInteger.intValue()) == null) {
                Intrinsics.checkNotNullExpressionValue(builder.setColorized(false), "setColorized(...)");
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(builder.setColorized(false), "setColorized(...)");
        }
        Context context = this.mParentContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParentContext");
            context = null;
        }
        PackageManager packageManager = context.getPackageManager();
        Context context3 = this.mParentContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParentContext");
        } else {
            context2 = context3;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(context2.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(536870912);
            builder.setContentIntent(PendingIntent.getActivity(locationTaskService, 0, launchIntentForPackage, (Build.VERSION.SDK_INT >= 31 ? 33554432 : 0) | 134217728));
        }
        Notification notificationBuild = builder.setCategory(NotificationCompat.CATEGORY_SERVICE).setSmallIcon(getApplicationInfo().icon).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    private final void prepareChannel(String id) {
        Object systemService = getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            return;
        }
        String string = getApplicationInfo().loadLabel(getPackageManager()).toString();
        if (notificationManager.getNotificationChannel(id) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(id, string, 2);
            notificationChannel.setDescription("Background location notification channel");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private final Integer colorStringToInteger(String color) {
        try {
            return Integer.valueOf(Color.parseColor(color));
        } catch (Exception unused) {
            return null;
        }
    }
}
