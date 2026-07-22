package expo.modules.location.taskConsumers;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import expo.modules.interfaces.taskManager.TaskConsumer;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import expo.modules.location.GeofencingException;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.GeofencingRegionState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GeofencingTaskConsumer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u001c\u0010\u001d\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0016\u0010,\u001a\u00020\u00102\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130.H\u0002J\b\u0010/\u001a\u00020\fH\u0002J\u001a\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010 2\u0006\u00103\u001a\u00020\u0016H\u0002J\u001c\u00104\u001a\u00020\u00132\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0\u001fH\u0002J$\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u00162\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u00020;H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lexpo/modules/location/taskConsumers/GeofencingTaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumerInterface;", "context", "Landroid/content/Context;", "taskManagerUtils", "Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;", "<init>", "(Landroid/content/Context;Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;)V", "mTask", "Lexpo/modules/interfaces/taskManager/TaskInterface;", "mPendingIntent", "Landroid/app/PendingIntent;", "mGeofencingClient", "Lcom/google/android/gms/location/GeofencingClient;", "mGeofencingRequest", "Lcom/google/android/gms/location/GeofencingRequest;", "mGeofencingList", "", "Lcom/google/android/gms/location/Geofence;", "mRegions", "", "", "Landroid/os/PersistableBundle;", "taskType", "didRegister", "", "task", "didUnregister", "setOptions", "options", "", "", "didReceiveBroadcast", "intent", "Landroid/content/Intent;", "didExecuteJob", "", "jobService", "Landroid/app/job/JobService;", "params", "Landroid/app/job/JobParameters;", "startGeofencing", "stopGeofencing", "prepareGeofencingRequest", "geofences", "", "preparePendingIntent", "getParamAsDouble", "", "param", "errorMessage", "geofenceFromRegion", "region", "bundleFromRegion", "identifier", "regionStateForTransitionType", "Lexpo/modules/location/records/GeofencingRegionState;", "transitionType", "", "eventTypeFromTransitionType", "Companion", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeofencingTaskConsumer extends TaskConsumer implements TaskConsumerInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "GeofencingTaskConsumer";
    private GeofencingClient mGeofencingClient;
    private List<Geofence> mGeofencingList;
    private GeofencingRequest mGeofencingRequest;
    private PendingIntent mPendingIntent;
    private Map<String, PersistableBundle> mRegions;
    private TaskInterface mTask;

    private final int eventTypeFromTransitionType(int transitionType) {
        int i = 1;
        if (transitionType != 1) {
            i = 2;
            if (transitionType != 2) {
                return 0;
            }
        }
        return i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeofencingTaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGeofencingList = new ArrayList();
        this.mRegions = new HashMap();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public String taskType() {
        return "geofencing";
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didRegister(TaskInterface task) throws GeofencingException {
        Intrinsics.checkNotNullParameter(task, "task");
        this.mTask = task;
        startGeofencing();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didUnregister() {
        stopGeofencing();
        this.mTask = null;
        this.mPendingIntent = null;
        this.mGeofencingClient = null;
        this.mGeofencingRequest = null;
        this.mGeofencingList.clear();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void setOptions(Map<String, ? extends Object> options) throws GeofencingException {
        Intrinsics.checkNotNullParameter(options, "options");
        super.setOptions(options);
        stopGeofencing();
        startGeofencing();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didReceiveBroadcast(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        GeofencingEvent geofencingEventFromIntent = GeofencingEvent.fromIntent(intent);
        if (geofencingEventFromIntent == null) {
            Log.w(TAG, "Received a null geofencing event. Ignoring");
            return;
        }
        if (geofencingEventFromIntent.hasError()) {
            Error error = new Error(INSTANCE.getErrorString(geofencingEventFromIntent.getErrorCode()));
            TaskInterface taskInterface = this.mTask;
            if (taskInterface != null) {
                taskInterface.execute(null, error);
                return;
            }
            return;
        }
        int geofenceTransition = geofencingEventFromIntent.getGeofenceTransition();
        GeofencingRegionState geofencingRegionStateRegionStateForTransitionType = regionStateForTransitionType(geofenceTransition);
        int iEventTypeFromTransitionType = eventTypeFromTransitionType(geofenceTransition);
        List<Geofence> triggeringGeofences = geofencingEventFromIntent.getTriggeringGeofences();
        if (triggeringGeofences == null) {
            return;
        }
        Iterator<Geofence> it = triggeringGeofences.iterator();
        while (it.hasNext()) {
            PersistableBundle persistableBundle = this.mRegions.get(it.next().getRequestId());
            if (persistableBundle != null) {
                PersistableBundle persistableBundle2 = new PersistableBundle();
                persistableBundle.putInt("state", geofencingRegionStateRegionStateForTransitionType.ordinal());
                persistableBundle2.putInt("eventType", iEventTypeFromTransitionType);
                persistableBundle2.putPersistableBundle("region", persistableBundle);
                getTaskManagerUtils().scheduleJob(getContext().getApplicationContext(), this.mTask, CollectionsKt.listOf(persistableBundle2));
            }
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean didExecuteJob(final JobService jobService, final JobParameters params) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(params, "params");
        TaskInterface taskInterface = this.mTask;
        if (taskInterface == null) {
            return false;
        }
        for (PersistableBundle persistableBundle : getTaskManagerUtils().extractDataFromJobParams(params)) {
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(persistableBundle.getPersistableBundle("region"));
            bundle.putInt("eventType", persistableBundle.getInt("eventType"));
            bundle.putBundle("region", bundle2);
            taskInterface.execute(bundle, null, new TaskExecutionCallback() { // from class: expo.modules.location.taskConsumers.GeofencingTaskConsumer$$ExternalSyntheticLambda0
                @Override // expo.modules.interfaces.taskManager.TaskExecutionCallback
                public final void onFinished(Map map) {
                    jobService.jobFinished(params, false);
                }
            });
        }
        return true;
    }

    private final void startGeofencing() throws GeofencingException {
        Map<String, Object> options;
        GeofencingRequest geofencingRequest;
        Context context = getContext();
        if (context == null) {
            Log.w(TAG, "The context has been abandoned");
            return;
        }
        if (!LocationHelpers.INSTANCE.isAnyProviderAvailable(context)) {
            Log.w(TAG, "There is no location provider available");
            return;
        }
        this.mRegions = new HashMap();
        this.mGeofencingList = new ArrayList();
        TaskInterface taskInterface = this.mTask;
        if (taskInterface == null || (options = taskInterface.getOptions()) == null) {
            throw new GeofencingException("Task is null, can't start geofencing", null, 2, null);
        }
        Object obj = options.get("regions");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<*>");
        ArrayList<HashMap> arrayList = new ArrayList();
        for (Object obj2 : (ArrayList) obj) {
            if (obj2 instanceof HashMap) {
                arrayList.add(obj2);
            }
        }
        for (HashMap map : arrayList) {
            Geofence geofenceGeofenceFromRegion = geofenceFromRegion(map);
            String requestId = geofenceGeofenceFromRegion.getRequestId();
            Intrinsics.checkNotNullExpressionValue(requestId, "getRequestId(...)");
            this.mRegions.put(requestId, bundleFromRegion(requestId, map));
            this.mGeofencingList.add(geofenceGeofenceFromRegion);
        }
        this.mPendingIntent = preparePendingIntent();
        this.mGeofencingRequest = prepareGeofencingRequest(this.mGeofencingList);
        GeofencingClient geofencingClient = LocationServices.getGeofencingClient(getContext());
        this.mGeofencingClient = geofencingClient;
        try {
            PendingIntent pendingIntent = this.mPendingIntent;
            if (pendingIntent == null || (geofencingRequest = this.mGeofencingRequest) == null || geofencingClient == null) {
                return;
            }
            geofencingClient.addGeofences(geofencingRequest, pendingIntent);
        } catch (SecurityException e) {
            Log.w(TAG, "Geofencing request has been rejected.", e);
        }
    }

    private final void stopGeofencing() {
        PendingIntent pendingIntent = this.mPendingIntent;
        if (pendingIntent != null) {
            GeofencingClient geofencingClient = this.mGeofencingClient;
            if (geofencingClient != null) {
                geofencingClient.removeGeofences(pendingIntent);
            }
            pendingIntent.cancel();
        }
    }

    private final GeofencingRequest prepareGeofencingRequest(List<? extends Geofence> geofences) {
        GeofencingRequest geofencingRequestBuild = new GeofencingRequest.Builder().setInitialTrigger(3).addGeofences(geofences).build();
        Intrinsics.checkNotNullExpressionValue(geofencingRequestBuild, "build(...)");
        return geofencingRequestBuild;
    }

    private final PendingIntent preparePendingIntent() {
        PendingIntent pendingIntentCreateTaskIntent = getTaskManagerUtils().createTaskIntent(getContext(), this.mTask);
        Intrinsics.checkNotNullExpressionValue(pendingIntentCreateTaskIntent, "createTaskIntent(...)");
        return pendingIntentCreateTaskIntent;
    }

    private final double getParamAsDouble(Object param, String errorMessage) throws GeofencingException {
        Double doubleOrNull;
        if (param instanceof Double) {
            doubleOrNull = (Double) param;
        } else if (param instanceof Float) {
            doubleOrNull = Double.valueOf(((Number) param).floatValue());
        } else if (param instanceof Integer) {
            doubleOrNull = Double.valueOf(((Number) param).intValue());
        } else if (param instanceof Long) {
            doubleOrNull = Double.valueOf(((Number) param).longValue());
        } else {
            doubleOrNull = param instanceof String ? StringsKt.toDoubleOrNull((String) param) : null;
        }
        if (doubleOrNull != null) {
            return doubleOrNull.doubleValue();
        }
        throw new GeofencingException(errorMessage, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Geofence geofenceFromRegion(Map<String, ? extends Object> region) throws GeofencingException {
        Object obj = region.get("identifier");
        String string = obj instanceof String ? (String) obj : null;
        if (string == null) {
            string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        }
        double paramAsDouble = getParamAsDouble(region.get("radius"), "Region: radius: `" + region.get("radius") + "` can't be cast to Double");
        double paramAsDouble2 = getParamAsDouble(region.get("longitude"), "Region: longitude: `" + region.get("longitude") + "` can't be cast to Double");
        double paramAsDouble3 = getParamAsDouble(region.get("latitude"), "Region: latitude `" + region.get("latitude") + "` can't be cast to Double");
        Object obj2 = region.get("notifyOnEnter");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : 1;
        Object obj3 = region.get("notifyOnExit");
        Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        Geofence geofenceBuild = new Geofence.Builder().setRequestId(string).setCircularRegion(paramAsDouble3, paramAsDouble2, (float) paramAsDouble).setExpirationDuration(-1L).setTransitionTypes((bool2 != null ? bool2.booleanValue() : true ? 2 : 0) | zBooleanValue).build();
        Intrinsics.checkNotNullExpressionValue(geofenceBuild, "build(...)");
        return geofenceBuild;
    }

    private final PersistableBundle bundleFromRegion(String identifier, Map<String, ? extends Object> region) throws GeofencingException {
        PersistableBundle persistableBundle = new PersistableBundle();
        double paramAsDouble = getParamAsDouble(region.get("radius"), "Region: radius: `" + region.get("radius") + "` can't be cast to Double");
        double paramAsDouble2 = getParamAsDouble(region.get("longitude"), "Region: longitude: `" + region.get("longitude") + "` can't be cast to Double");
        double paramAsDouble3 = getParamAsDouble(region.get("latitude"), "Region: latitude: `" + region.get("latitude") + "` can't be cast to Double");
        persistableBundle.putString("identifier", identifier);
        persistableBundle.putDouble("radius", paramAsDouble);
        persistableBundle.putDouble("latitude", paramAsDouble3);
        persistableBundle.putDouble("longitude", paramAsDouble2);
        persistableBundle.putInt("state", GeofencingRegionState.UNKNOWN.ordinal());
        return persistableBundle;
    }

    private final GeofencingRegionState regionStateForTransitionType(int transitionType) {
        if (transitionType != 1) {
            if (transitionType == 2) {
                return GeofencingRegionState.OUTSIDE;
            }
            if (transitionType != 4) {
                return GeofencingRegionState.UNKNOWN;
            }
        }
        return GeofencingRegionState.INSIDE;
    }

    /* JADX INFO: compiled from: GeofencingTaskConsumer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/location/taskConsumers/GeofencingTaskConsumer$Companion;", "", "<init>", "()V", "TAG", "", "getErrorString", "errorCode", "", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getErrorString(int errorCode) {
            switch (errorCode) {
                case 1000:
                    return "Geofencing not available.";
                case 1001:
                    return "Too many geofences.";
                case 1002:
                    return "Too many pending intents.";
                default:
                    return "Unknown geofencing error.";
            }
        }
    }
}
