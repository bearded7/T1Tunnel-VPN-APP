package expo.modules.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.canhub.cropper.CropImageOptionsKt;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.location.records.GeocodeResponse;
import expo.modules.location.records.GeofencingOptions;
import expo.modules.location.records.Heading;
import expo.modules.location.records.HeadingEventResponse;
import expo.modules.location.records.LocationLastKnownOptions;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.LocationProviderStatus;
import expo.modules.location.records.LocationResponse;
import expo.modules.location.records.LocationTaskOptions;
import expo.modules.location.records.PermissionDetailsLocationAndroid;
import expo.modules.location.records.PermissionRequestResponse;
import expo.modules.location.records.ReverseGeocodeLocation;
import expo.modules.location.records.ReverseGeocodeResponse;
import expo.modules.location.taskConsumers.GeofencingTaskConsumer;
import expo.modules.location.taskConsumers.LocationTaskConsumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: LocationModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0080\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010-\u001a\u00020.H\u0016J\u000e\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\b\u00102\u001a\u000203H\u0002J\u000e\u00104\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u000e\u00105\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0018\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H\u0082@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020<2\u0006\u00108\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J%\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010\u000b2\u0006\u0010C\u001a\u00020D¢\u0006\u0002\u0010EJ\u0018\u0010F\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0012H\u0002J\u0010\u0010H\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000fH\u0002J\u0010\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020\u000bH\u0002J\b\u0010K\u001a\u00020<H\u0002J\b\u0010L\u001a\u00020<H\u0002J\u001d\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u000207H\u0000¢\u0006\u0002\bPJ\u0010\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u00020!H\u0002J\u0010\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020!H\u0002J\b\u0010U\u001a\u00020<H\u0002J\b\u0010V\u001a\u00020<H\u0002J\b\u0010W\u001a\u00020<H\u0002J\b\u0010X\u001a\u00020<H\u0002J\u0010\u0010Y\u001a\u00020<2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010Z\u001a\u00020<2\u0006\u0010B\u001a\u00020\u000bH\u0002J\b\u0010[\u001a\u00020<H\u0002J\u0010\u0010\\\u001a\u0004\u0018\u00010]H\u0082@¢\u0006\u0002\u00101J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_2\u0006\u0010a\u001a\u00020bH\u0082@¢\u0006\u0002\u0010cJ\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020e0_2\u0006\u0010f\u001a\u00020gH\u0082@¢\u0006\u0002\u0010hJ\b\u0010i\u001a\u00020&H\u0002J\b\u0010j\u001a\u00020&H\u0002J\b\u0010k\u001a\u00020&H\u0002J\b\u0010l\u001a\u00020&H\u0003J\b\u0010m\u001a\u00020&H\u0002J\b\u0010n\u001a\u00020<H\u0016J\b\u0010o\u001a\u00020<H\u0016J\b\u0010p\u001a\u00020<H\u0016J\u0012\u0010q\u001a\u00020<2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u001a\u0010t\u001a\u00020<2\b\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010w\u001a\u00020\u000bH\u0016J,\u0010x\u001a\u00020<2\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000b2\b\u0010|\u001a\u0004\u0018\u00010}H\u0016J\u0012\u0010~\u001a\u00020<2\b\u0010\u007f\u001a\u0004\u0018\u00010}H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*¨\u0006\u0081\u0001"}, d2 = {"Lexpo/modules/location/LocationModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "Landroid/hardware/SensorEventListener;", "Lexpo/modules/core/interfaces/ActivityEventListener;", "<init>", "()V", "mGeofield", "Landroid/hardware/GeomagneticField;", "mLocationCallbacks", "Ljava/util/HashMap;", "", "Lcom/google/android/gms/location/LocationCallback;", "Lkotlin/collections/HashMap;", "mLocationRequests", "Lcom/google/android/gms/location/LocationRequest;", "mPendingLocationRequests", "Ljava/util/ArrayList;", "Lexpo/modules/location/LocationActivityResultListener;", "Lkotlin/collections/ArrayList;", "mContext", "Landroid/content/Context;", "mSensorManager", "Landroid/hardware/SensorManager;", "mUIManager", "Lexpo/modules/core/interfaces/services/UIManager;", "mLocationProvider", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "mGravity", "", "mGeomagnetic", "mHeadingId", "mLastAzimuth", "", "mAccuracy", "mLastUpdate", "", "mGeocoderPaused", "", "mTaskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getMTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "mTaskManager$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getForegroundPermissionsAsync", "Lexpo/modules/location/records/PermissionRequestResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProviderStatus", "Lexpo/modules/location/records/LocationProviderStatus;", "requestBackgroundPermissionsAsync", "getBackgroundPermissionsAsync", "getLastKnownPositionAsync", "Lexpo/modules/location/records/LocationResponse;", "options", "Lexpo/modules/location/records/LocationLastKnownOptions;", "(Lexpo/modules/location/records/LocationLastKnownOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentPositionAsync", "", "Lexpo/modules/location/records/LocationOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "requestLocationUpdates", "locationRequest", "requestId", "callbacks", "Lexpo/modules/location/LocationRequestCallbacks;", "(Lcom/google/android/gms/location/LocationRequest;Ljava/lang/Integer;Lexpo/modules/location/LocationRequestCallbacks;)V", "addPendingLocationRequest", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "resolveUserSettingsForRequest", "executePendingRequests", "resultCode", "startHeadingUpdate", "sendUpdate", "sendLocationResponse", "watchId", "response", "sendLocationResponse$expo_location_release", "calcMagNorth", "azimuth", "calcTrueNorth", "magNorth", "stopHeadingWatch", "destroyHeadingWatch", "startWatching", "stopWatching", "pauseLocationUpdatesForRequest", "removeLocationUpdatesForRequest", "resumeLocationUpdates", "getLastKnownLocation", "Landroid/location/Location;", "geocode", "", "Lexpo/modules/location/records/GeocodeResponse;", "address", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reverseGeocode", "Lexpo/modules/location/records/ReverseGeocodeResponse;", "location", "Lexpo/modules/location/records/ReverseGeocodeLocation;", "(Lexpo/modules/location/records/ReverseGeocodeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMissingForegroundPermissions", "hasForegroundServicePermissions", "isMissingBackgroundPermissions", "shouldAskBackgroundPermissions", "isBackgroundPermissionInManifest", "onHostResume", "onHostPause", "onHostDestroy", "onSensorChanged", NotificationCompat.CATEGORY_EVENT, "Landroid/hardware/SensorEvent;", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", UriUtil.DATA_SCHEME, "Landroid/content/Intent;", "onNewIntent", "intent", "Companion", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocationModule extends Module implements LifecycleEventListener, SensorEventListener, ActivityEventListener {
    public static final int ACCURACY_BALANCED = 3;
    public static final int ACCURACY_BEST_FOR_NAVIGATION = 6;
    public static final int ACCURACY_HIGH = 4;
    public static final int ACCURACY_HIGHEST = 5;
    public static final int ACCURACY_LOW = 2;
    public static final int ACCURACY_LOWEST = 1;
    private static final int CHECK_SETTINGS_REQUEST_CODE = 42;
    public static final double DEGREE_DELTA = 0.0355d;
    public static final int GEOFENCING_EVENT_ENTER = 1;
    public static final int GEOFENCING_EVENT_EXIT = 2;
    private static final String HEADING_EVENT_NAME = "Expo.headingChanged";
    private static final String LOCATION_EVENT_NAME = "Expo.locationChanged";
    public static final float TIME_DELTA = 50.0f;
    private int mAccuracy;
    private Context mContext;
    private boolean mGeocoderPaused;
    private GeomagneticField mGeofield;
    private int mHeadingId;
    private float mLastAzimuth;
    private long mLastUpdate;
    private FusedLocationProviderClient mLocationProvider;
    private SensorManager mSensorManager;
    private UIManager mUIManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "LocationModule";
    private final HashMap<Integer, LocationCallback> mLocationCallbacks = new HashMap<>();
    private final HashMap<Integer, LocationRequest> mLocationRequests = new HashMap<>();
    private ArrayList<LocationActivityResultListener> mPendingLocationRequests = new ArrayList<>();
    private float[] mGravity = new float[9];
    private float[] mGeomagnetic = new float[9];

    /* JADX INFO: renamed from: mTaskManager$delegate, reason: from kotlin metadata */
    private final Lazy mTaskManager = LazyKt.lazy(new Function0() { // from class: expo.modules.location.LocationModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return LocationModule.mTaskManager_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: expo.modules.location.LocationModule$getForegroundPermissionsAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocationModule.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.location.LocationModule", f = "LocationModule.kt", i = {0, 1}, l = {316, 317}, m = "getForegroundPermissionsAsync", n = {"it", "locationPermission"}, s = {"L$0", "L$0"})
    static final class C01711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01711(Continuation<? super C01711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationModule.this.getForegroundPermissionsAsync(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.location.LocationModule$getLastKnownPositionAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocationModule.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.location.LocationModule", f = "LocationModule.kt", i = {0}, l = {385}, m = "getLastKnownPositionAsync", n = {"options"}, s = {"L$0"})
    static final class C01721 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01721(Continuation<? super C01721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationModule.this.getLastKnownPositionAsync(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LocationModule.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.location.LocationModule", f = "LocationModule.kt", i = {}, l = {357, CropImageOptionsKt.DEGREES_360}, m = "requestBackgroundPermissionsAsync", n = {}, s = {})
    static final class C01731 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C01731(Continuation<? super C01731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LocationModule.this.requestBackgroundPermissionsAsync(this);
        }
    }

    @Override // expo.modules.core.interfaces.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskManagerInterface getMTaskManager() {
        return (TaskManagerInterface) this.mTaskManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskManagerInterface mTaskManager_delegate$lambda$0(LocationModule locationModule) throws TaskManagerNotFoundException {
        Object module;
        try {
            module = locationModule.getAppContext().getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        TaskManagerInterface taskManagerInterface = (TaskManagerInterface) module;
        if (taskManagerInterface != null) {
            return taskManagerInterface;
        }
        throw new TaskManagerNotFoundException();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent5;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent8;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent9;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent10;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6;
        LocationModule locationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (locationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(locationModule);
            moduleDefinitionBuilder.Name("ExpoLocation");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws Exceptions.ReactContextLost, SensorManagerUnavailable, MissingUIManagerException {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws Exceptions.ReactContextLost, SensorManagerUnavailable, MissingUIManagerException {
                    Object module;
                    LocationModule locationModule2 = this.this$0;
                    Context reactContext = locationModule2.getAppContext().getReactContext();
                    if (reactContext != null) {
                        locationModule2.mContext = reactContext;
                        LocationModule locationModule3 = this.this$0;
                        try {
                            module = locationModule3.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
                        } catch (Exception unused) {
                            module = null;
                        }
                        UIManager uIManager = (UIManager) module;
                        if (uIManager != null) {
                            locationModule3.mUIManager = uIManager;
                            LocationModule locationModule4 = this.this$0;
                            Context context = locationModule4.mContext;
                            if (context == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                context = null;
                            }
                            locationModule4.mLocationProvider = LocationServices.getFusedLocationProviderClient(context);
                            LocationModule locationModule5 = this.this$0;
                            Context context2 = locationModule5.mContext;
                            if (context2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                                context2 = null;
                            }
                            Object systemService = context2.getSystemService("sensor");
                            SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
                            if (sensorManager != null) {
                                locationModule5.mSensorManager = sensorManager;
                                return;
                            }
                            throw new SensorManagerUnavailable();
                        }
                        throw new MissingUIManagerException();
                    }
                    throw new Exceptions.ReactContextLost();
                }
            }));
            moduleDefinitionBuilder.Events(HEADING_EVENT_NAME, LOCATION_EVENT_NAME);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("requestPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$1(null, this));
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(suspendFunctionComponent);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("getPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction2.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$2(null, this));
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(suspendFunctionComponent2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("requestForegroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent3 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction3.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$3(null, this));
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(suspendFunctionComponent3);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction4 = moduleDefinitionBuilder.AsyncFunction("requestBackgroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent4 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction4.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$4(null, this));
            asyncFunctionBuilderAsyncFunction4.setAsyncFunctionComponent(suspendFunctionComponent4);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction5 = moduleDefinitionBuilder.AsyncFunction("getForegroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent5 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction5.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$5(null, this));
            asyncFunctionBuilderAsyncFunction5.setAsyncFunctionComponent(suspendFunctionComponent5);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction6 = moduleDefinitionBuilder.AsyncFunction("getBackgroundPermissionsAsync");
            SuspendFunctionComponent suspendFunctionComponent6 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction6.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$6(null, this));
            asyncFunctionBuilderAsyncFunction6.setAsyncFunctionComponent(suspendFunctionComponent6);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction7 = moduleDefinitionBuilder.AsyncFunction("getLastKnownPositionAsync");
            String name = asyncFunctionBuilderAsyncFunction7.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction7.getConverters();
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(LocationLastKnownOptions.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationLastKnownOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LocationLastKnownOptions.class);
                    }
                }), converters);
            }
            anyTypeArr[0] = anyType;
            asyncFunctionBuilderAsyncFunction7.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr, new LocationModule$definition$lambda$27$$inlined$Coroutine$8(null, this)));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(LocationOptions.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LocationOptions.class);
                    }
                }), converters2);
            }
            anyTypeArr2[0] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("getCurrentPositionAsync", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    this.this$0.getCurrentPositionAsync((LocationOptions) objArr[0], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("getCurrentPositionAsync", asyncFunctionWithPromiseComponent7);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], LocationProviderStatus> function1 = new Function1<Object[], LocationProviderStatus>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final LocationProviderStatus invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.getProviderStatus();
                }
            };
            if (!Intrinsics.areEqual(LocationProviderStatus.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(LocationProviderStatus.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(LocationProviderStatus.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(LocationProviderStatus.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(LocationProviderStatus.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr3, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr3, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr3, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr3, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr3, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("getProviderStatusAsync", anyTypeArr3, function1);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getProviderStatusAsync", untypedAsyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("watchDeviceHeading", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$2
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.mHeadingId = ((Integer) promise).intValue();
                        this.this$0.startHeadingUpdate();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }), converters3);
                }
                anyTypeArr4[0] = anyType3;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        this.this$0.mHeadingId = ((Number) objArr[0]).intValue();
                        this.this$0.startHeadingUpdate();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("watchDeviceHeading", anyTypeArr4, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("watchDeviceHeading", anyTypeArr4, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("watchDeviceHeading", anyTypeArr4, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("watchDeviceHeading", anyTypeArr4, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("watchDeviceHeading", anyTypeArr4, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("watchDeviceHeading", anyTypeArr4, function2);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("watchDeviceHeading", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder5.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), converters4);
            }
            anyTypeArr5[0] = anyType4;
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(LocationOptions.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LocationOptions.class);
                    }
                }), converters4);
            }
            anyTypeArr5[1] = anyType5;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("watchPositionImplAsync", anyTypeArr5, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$5
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    LocationOptions locationOptions = (LocationOptions) objArr[1];
                    final int iIntValue = ((Number) obj).intValue();
                    if (this.this$0.isMissingForegroundPermissions()) {
                        promise.reject(new LocationUnauthorizedException());
                        return;
                    }
                    final LocationRequest locationRequestPrepareLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareLocationRequest$expo_location_release(locationOptions);
                    boolean mayShowUserSettingsDialog = locationOptions.getMayShowUserSettingsDialog();
                    LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
                    Context context = this.this$0.mContext;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context = null;
                    }
                    if (companion.hasNetworkProviderEnabled(context) || !mayShowUserSettingsDialog) {
                        LocationHelpers.INSTANCE.requestContinuousUpdates(this.this$0, locationRequestPrepareLocationRequest$expo_location_release, iIntValue, promise);
                        return;
                    }
                    LocationModule locationModule2 = this.this$0;
                    final LocationModule locationModule3 = this.this$0;
                    locationModule2.addPendingLocationRequest(locationRequestPrepareLocationRequest$expo_location_release, new LocationActivityResultListener() { // from class: expo.modules.location.LocationModule$definition$1$12$1
                        @Override // expo.modules.location.LocationActivityResultListener
                        public void onResult(int resultCode) {
                            if (resultCode == -1) {
                                LocationHelpers.INSTANCE.requestContinuousUpdates(locationModule3, locationRequestPrepareLocationRequest$expo_location_release, iIntValue, promise);
                            } else {
                                promise.reject(new LocationSettingsUnsatisfiedException());
                            }
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder5.getAsyncFunctions().put("watchPositionImplAsync", asyncFunctionWithPromiseComponent8);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("removeWatchAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$5
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws LocationUnauthorizedException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        int iIntValue = ((Integer) promise).intValue();
                        if (!this.this$0.isMissingForegroundPermissions()) {
                            if (iIntValue == this.this$0.mHeadingId) {
                                this.this$0.destroyHeadingWatch();
                                return;
                            } else {
                                this.this$0.removeLocationUpdatesForRequest(iIntValue);
                                return;
                            }
                        }
                        throw new LocationUnauthorizedException();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws LocationUnauthorizedException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters5 = moduleDefinitionBuilder6.getConverters();
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                if (anyType6 == null) {
                    anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }), converters5);
                }
                anyTypeArr6[0] = anyType6;
                Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$7
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws LocationUnauthorizedException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        int iIntValue = ((Number) objArr[0]).intValue();
                        if (!this.this$0.isMissingForegroundPermissions()) {
                            if (iIntValue == this.this$0.mHeadingId) {
                                this.this$0.destroyHeadingWatch();
                            } else {
                                this.this$0.removeLocationUpdatesForRequest(iIntValue);
                            }
                            return Unit.INSTANCE;
                        }
                        throw new LocationUnauthorizedException();
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("removeWatchAsync", anyTypeArr6, function3);
                                } else {
                                    untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("removeWatchAsync", anyTypeArr6, function3);
                                }
                            } else {
                                untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("removeWatchAsync", anyTypeArr6, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("removeWatchAsync", anyTypeArr6, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("removeWatchAsync", anyTypeArr6, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("removeWatchAsync", anyTypeArr6, function3);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent3;
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("removeWatchAsync", asyncFunctionWithPromiseComponent2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction8 = moduleDefinitionBuilder.AsyncFunction("geocodeAsync");
            String name2 = asyncFunctionBuilderAsyncFunction8.getName();
            TypeConverterProvider converters6 = asyncFunctionBuilderAsyncFunction8.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters6);
            }
            anyTypeArr7[0] = anyType7;
            asyncFunctionBuilderAsyncFunction8.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr7, new LocationModule$definition$lambda$27$$inlined$Coroutine$10(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction9 = moduleDefinitionBuilder.AsyncFunction("reverseGeocodeAsync");
            String name3 = asyncFunctionBuilderAsyncFunction9.getName();
            TypeConverterProvider converters7 = asyncFunctionBuilderAsyncFunction9.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[1];
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReverseGeocodeLocation.class), false));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReverseGeocodeLocation.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ReverseGeocodeLocation.class);
                    }
                }), converters7);
            }
            anyTypeArr8[0] = anyType8;
            asyncFunctionBuilderAsyncFunction9.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, anyTypeArr8, new LocationModule$definition$lambda$27$$inlined$Coroutine$12(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction10 = moduleDefinitionBuilder.AsyncFunction("enableNetworkProviderAsync");
            SuspendFunctionComponent suspendFunctionComponent7 = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction10.getName(), new AnyType[0], new LocationModule$definition$lambda$27$$inlined$Coroutine$13(null, this));
            asyncFunctionBuilderAsyncFunction10.setAsyncFunctionComponent(suspendFunctionComponent7);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr9 = new AnyType[0];
            Function1<Object[], Boolean> function4 = new Function1<Object[], Boolean>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
                    Context context = this.this$0.mContext;
                    if (context == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        context = null;
                    }
                    return Boolean.valueOf(companion.isAnyProviderAvailable(context));
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr9, function4);
                            } else {
                                untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr9, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr9, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr9, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr9, function4);
                }
            } else {
                untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("hasServicesEnabledAsync", anyTypeArr9, function4);
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("hasServicesEnabledAsync", untypedAsyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            TypeConverterProvider converters8 = moduleDefinitionBuilder8.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[2];
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters8);
            }
            anyTypeArr10[0] = anyType9;
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(LocationTaskOptions.class), false));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(LocationTaskOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(LocationTaskOptions.class);
                    }
                }), converters8);
            }
            anyTypeArr10[1] = anyType10;
            Function1<Object[], Unit> function5 = new Function1<Object[], Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws Exception {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    LocationTaskOptions locationTaskOptions = (LocationTaskOptions) objArr[1];
                    String str = (String) obj;
                    boolean z = locationTaskOptions.getForegroundService() != null;
                    if (!this.this$0.isMissingForegroundPermissions()) {
                        if (!z && this.this$0.isMissingBackgroundPermissions()) {
                            throw new LocationBackgroundUnauthorizedException();
                        }
                        if (AppForegroundedSingleton.INSTANCE.isForegrounded() || locationTaskOptions.getForegroundService() == null) {
                            if (this.this$0.hasForegroundServicePermissions()) {
                                this.this$0.getMTaskManager().registerTask(str, LocationTaskConsumer.class, locationTaskOptions.toMutableMap$expo_location_release());
                                return Unit.INSTANCE;
                            }
                            throw new ForegroundServicePermissionsException();
                        }
                        throw new ForegroundServiceStartNotAllowedException();
                    }
                    throw new LocationBackgroundUnauthorizedException();
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent5 = new StringAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr10, function5);
                            } else {
                                untypedAsyncFunctionComponent5 = new UntypedAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr10, function5);
                            }
                        } else {
                            untypedAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr10, function5);
                        }
                    } else {
                        untypedAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr10, function5);
                    }
                } else {
                    untypedAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr10, function5);
                }
            } else {
                untypedAsyncFunctionComponent5 = new IntAsyncFunctionComponent("startLocationUpdatesAsync", anyTypeArr10, function5);
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("startLocationUpdatesAsync", untypedAsyncFunctionComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("stopLocationUpdatesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$12
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getMTaskManager().unregisterTask((String) promise, LocationTaskConsumer.class);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exception {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters9 = moduleDefinitionBuilder9.getConverters();
                AnyType[] anyTypeArr11 = new AnyType[1];
                AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType11 == null) {
                    anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters9);
                }
                anyTypeArr11[0] = anyType11;
                Function1<Object[], Unit> function6 = new Function1<Object[], Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$14
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        this.this$0.getMTaskManager().unregisterTask((String) objArr[0], LocationTaskConsumer.class);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent6 = new StringAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr11, function6);
                                } else {
                                    untypedAsyncFunctionComponent6 = new UntypedAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr11, function6);
                                }
                            } else {
                                untypedAsyncFunctionComponent6 = new FloatAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr11, function6);
                            }
                        } else {
                            untypedAsyncFunctionComponent6 = new DoubleAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr11, function6);
                        }
                    } else {
                        untypedAsyncFunctionComponent6 = new BoolAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr11, function6);
                    }
                } else {
                    untypedAsyncFunctionComponent6 = new IntAsyncFunctionComponent("stopLocationUpdatesAsync", anyTypeArr11, function6);
                }
                asyncFunctionWithPromiseComponent3 = untypedAsyncFunctionComponent6;
            }
            moduleDefinitionBuilder9.getAsyncFunctions().put("stopLocationUpdatesAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("hasStartedLocationUpdatesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$15
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getMTaskManager().taskHasConsumerOfClass((String) promise, LocationTaskConsumer.class);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters10 = moduleDefinitionBuilder10.getConverters();
                AnyType[] anyTypeArr12 = new AnyType[1];
                AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType12 == null) {
                    anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$16
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters10);
                }
                anyTypeArr12[0] = anyType12;
                Function1<Object[], Boolean> function7 = new Function1<Object[], Boolean>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$17
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return Boolean.valueOf(this.this$0.getMTaskManager().taskHasConsumerOfClass((String) objArr[0], LocationTaskConsumer.class));
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    untypedAsyncFunctionComponent7 = new StringAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr12, function7);
                                } else {
                                    untypedAsyncFunctionComponent7 = new UntypedAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr12, function7);
                                }
                            } else {
                                untypedAsyncFunctionComponent7 = new FloatAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr12, function7);
                            }
                        } else {
                            untypedAsyncFunctionComponent7 = new DoubleAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr12, function7);
                        }
                    } else {
                        untypedAsyncFunctionComponent7 = new BoolAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr12, function7);
                    }
                } else {
                    untypedAsyncFunctionComponent7 = new IntAsyncFunctionComponent("hasStartedLocationUpdatesAsync", anyTypeArr12, function7);
                }
                asyncFunctionWithPromiseComponent4 = untypedAsyncFunctionComponent7;
            }
            moduleDefinitionBuilder10.getAsyncFunctions().put("hasStartedLocationUpdatesAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            TypeConverterProvider converters11 = moduleDefinitionBuilder11.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[2];
            AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$18
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters11);
            }
            anyTypeArr13[0] = anyType13;
            AnyType anyType14 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(GeofencingOptions.class), false));
            if (anyType14 == null) {
                anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GeofencingOptions.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$19
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(GeofencingOptions.class);
                    }
                }), converters11);
            }
            anyTypeArr13[1] = anyType14;
            Function1<Object[], Unit> function8 = new Function1<Object[], Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws Exception {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    GeofencingOptions geofencingOptions = (GeofencingOptions) objArr[1];
                    String str = (String) obj;
                    if (!this.this$0.isMissingBackgroundPermissions()) {
                        this.this$0.getMTaskManager().registerTask(str, GeofencingTaskConsumer.class, geofencingOptions.toMap$expo_location_release());
                        return Unit.INSTANCE;
                    }
                    throw new LocationBackgroundUnauthorizedException();
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent8 = new StringAsyncFunctionComponent("startGeofencingAsync", anyTypeArr13, function8);
                            } else {
                                untypedAsyncFunctionComponent8 = new UntypedAsyncFunctionComponent("startGeofencingAsync", anyTypeArr13, function8);
                            }
                        } else {
                            untypedAsyncFunctionComponent8 = new FloatAsyncFunctionComponent("startGeofencingAsync", anyTypeArr13, function8);
                        }
                    } else {
                        untypedAsyncFunctionComponent8 = new DoubleAsyncFunctionComponent("startGeofencingAsync", anyTypeArr13, function8);
                    }
                } else {
                    untypedAsyncFunctionComponent8 = new BoolAsyncFunctionComponent("startGeofencingAsync", anyTypeArr13, function8);
                }
            } else {
                untypedAsyncFunctionComponent8 = new IntAsyncFunctionComponent("startGeofencingAsync", anyTypeArr13, function8);
            }
            moduleDefinitionBuilder11.getAsyncFunctions().put("startGeofencingAsync", untypedAsyncFunctionComponent8);
            ModuleDefinitionBuilder moduleDefinitionBuilder12 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("hasStartedGeofencingAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$21
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws LocationBackgroundUnauthorizedException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        if (!this.this$0.isMissingBackgroundPermissions()) {
                            this.this$0.getMTaskManager().taskHasConsumerOfClass(str, GeofencingTaskConsumer.class);
                            return;
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws LocationBackgroundUnauthorizedException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters12 = moduleDefinitionBuilder12.getConverters();
                AnyType[] anyTypeArr14 = new AnyType[1];
                AnyType anyType15 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType15 == null) {
                    anyType15 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$22
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters12);
                }
                anyTypeArr14[0] = anyType15;
                Function1<Object[], Boolean> function9 = new Function1<Object[], Boolean>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$23
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) throws LocationBackgroundUnauthorizedException {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String str = (String) objArr[0];
                        if (!this.this$0.isMissingBackgroundPermissions()) {
                            return Boolean.valueOf(this.this$0.getMTaskManager().taskHasConsumerOfClass(str, GeofencingTaskConsumer.class));
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    untypedAsyncFunctionComponent9 = new StringAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr14, function9);
                                } else {
                                    untypedAsyncFunctionComponent9 = new UntypedAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr14, function9);
                                }
                            } else {
                                untypedAsyncFunctionComponent9 = new FloatAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr14, function9);
                            }
                        } else {
                            untypedAsyncFunctionComponent9 = new DoubleAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr14, function9);
                        }
                    } else {
                        untypedAsyncFunctionComponent9 = new BoolAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr14, function9);
                    }
                } else {
                    untypedAsyncFunctionComponent9 = new IntAsyncFunctionComponent("hasStartedGeofencingAsync", anyTypeArr14, function9);
                }
                asyncFunctionWithPromiseComponent5 = untypedAsyncFunctionComponent9;
            }
            moduleDefinitionBuilder12.getAsyncFunctions().put("hasStartedGeofencingAsync", asyncFunctionWithPromiseComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder13 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("stopGeofencingAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$24
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        if (!this.this$0.isMissingBackgroundPermissions()) {
                            this.this$0.getMTaskManager().unregisterTask(str, GeofencingTaskConsumer.class);
                            return;
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exception {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters13 = moduleDefinitionBuilder13.getConverters();
                AnyType[] anyTypeArr15 = new AnyType[1];
                AnyType anyType16 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType16 == null) {
                    anyType16 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$25
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters13);
                }
                anyTypeArr15[0] = anyType16;
                Function1<Object[], Unit> function10 = new Function1<Object[], Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$AsyncFunction$26
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String str = (String) objArr[0];
                        if (!this.this$0.isMissingBackgroundPermissions()) {
                            this.this$0.getMTaskManager().unregisterTask(str, GeofencingTaskConsumer.class);
                            return Unit.INSTANCE;
                        }
                        throw new LocationBackgroundUnauthorizedException();
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent10 = new StringAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr15, function10);
                                } else {
                                    untypedAsyncFunctionComponent10 = new UntypedAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr15, function10);
                                }
                            } else {
                                untypedAsyncFunctionComponent10 = new FloatAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr15, function10);
                            }
                        } else {
                            untypedAsyncFunctionComponent10 = new DoubleAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr15, function10);
                        }
                    } else {
                        untypedAsyncFunctionComponent10 = new BoolAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr15, function10);
                    }
                } else {
                    untypedAsyncFunctionComponent10 = new IntAsyncFunctionComponent("stopGeofencingAsync", anyTypeArr15, function10);
                }
                asyncFunctionWithPromiseComponent6 = untypedAsyncFunctionComponent10;
            }
            moduleDefinitionBuilder13.getAsyncFunctions().put("stopGeofencingAsync", asyncFunctionWithPromiseComponent6);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$OnActivityEntersForeground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppForegroundedSingleton.INSTANCE.setForegrounded(true);
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.location.LocationModule$definition$lambda$27$$inlined$OnActivityEntersBackground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppForegroundedSingleton.INSTANCE.setForegrounded(false);
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x0082  */
    /* JADX WARN: Code duplicated, block: B:28:0x0085  */
    /* JADX WARN: Code duplicated, block: B:31:0x008d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getForegroundPermissionsAsync(Continuation<? super PermissionRequestResponse> continuation) throws NoPermissionsModuleException {
        C01711 c01711;
        Permissions permissions;
        PermissionRequestResponse permissionRequestResponse;
        PermissionRequestResponse permissionRequestResponse2;
        String str;
        if (continuation instanceof C01711) {
            c01711 = (C01711) continuation;
            if ((c01711.label & Integer.MIN_VALUE) != 0) {
                c01711.label -= Integer.MIN_VALUE;
            } else {
                c01711 = new C01711(continuation);
            }
        } else {
            c01711 = new C01711(continuation);
        }
        Object permissionsWithPermissionsManager$expo_location_release = c01711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01711.label;
        if (i != 0) {
            if (i == 1) {
                permissions = (Permissions) c01711.L$0;
                ResultKt.throwOnFailure(permissionsWithPermissionsManager$expo_location_release);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                permissionRequestResponse = (PermissionRequestResponse) c01711.L$0;
                ResultKt.throwOnFailure(permissionsWithPermissionsManager$expo_location_release);
            }
            permissionRequestResponse2 = (PermissionRequestResponse) permissionsWithPermissionsManager$expo_location_release;
            if (permissionRequestResponse.getGranted()) {
                str = "none";
            } else {
                str = "coarse";
            }
            if (permissionRequestResponse2.getGranted()) {
                str = "fine";
            }
            permissionRequestResponse.setAndroid(new PermissionDetailsLocationAndroid(str));
            return permissionRequestResponse;
        }
        ResultKt.throwOnFailure(permissionsWithPermissionsManager$expo_location_release);
        permissions = getAppContext().getPermissions();
        if (permissions != null) {
            c01711.L$0 = permissions;
            c01711.label = 1;
            permissionsWithPermissionsManager$expo_location_release = LocationHelpers.INSTANCE.getPermissionsWithPermissionsManager$expo_location_release(permissions, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, c01711);
            if (permissionsWithPermissionsManager$expo_location_release != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        throw new NoPermissionsModuleException();
        PermissionRequestResponse permissionRequestResponse3 = (PermissionRequestResponse) permissionsWithPermissionsManager$expo_location_release;
        c01711.L$0 = permissionRequestResponse3;
        c01711.label = 2;
        Object permissionsWithPermissionsManager$expo_location_release2 = LocationHelpers.INSTANCE.getPermissionsWithPermissionsManager$expo_location_release(permissions, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, c01711);
        if (permissionsWithPermissionsManager$expo_location_release2 != coroutine_suspended) {
            permissionRequestResponse = permissionRequestResponse3;
            permissionsWithPermissionsManager$expo_location_release = permissionsWithPermissionsManager$expo_location_release2;
            permissionRequestResponse2 = (PermissionRequestResponse) permissionsWithPermissionsManager$expo_location_release;
            if (permissionRequestResponse.getGranted()) {
                str = "none";
            } else {
                str = "coarse";
            }
            if (permissionRequestResponse2.getGranted()) {
                str = "fine";
            }
            permissionRequestResponse.setAndroid(new PermissionDetailsLocationAndroid(str));
            return permissionRequestResponse;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocationProviderStatus getProviderStatus() {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
        boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
        boolean zIsLocationEnabled = LocationManagerCompat.isLocationEnabled(locationManager);
        boolean zIsProviderEnabled3 = locationManager.isProviderEnabled("passive");
        LocationProviderStatus locationProviderStatus = new LocationProviderStatus(null, null, null, false, null, 31, null);
        locationProviderStatus.setBackgroundModeEnabled(Boolean.valueOf(zIsLocationEnabled));
        locationProviderStatus.setGpsAvailable(Boolean.valueOf(zIsProviderEnabled));
        locationProviderStatus.setNetworkAvailable(Boolean.valueOf(zIsProviderEnabled2));
        locationProviderStatus.setLocationServicesEnabled(zIsLocationEnabled);
        locationProviderStatus.setPassiveAvailable(Boolean.valueOf(zIsProviderEnabled3));
        return locationProviderStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r8 == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object requestBackgroundPermissionsAsync(kotlin.coroutines.Continuation<? super expo.modules.location.records.PermissionRequestResponse> r8) throws expo.modules.location.NoPermissionsModuleException, expo.modules.location.NoPermissionInManifestException {
        /*
            r7 = this;
            boolean r0 = r8 instanceof expo.modules.location.LocationModule.C01731
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1 r0 = (expo.modules.location.LocationModule.C01731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1 r0 = new expo.modules.location.LocationModule$requestBackgroundPermissionsAsync$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6e
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            return r8
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7.isBackgroundPermissionInManifest()
            if (r8 == 0) goto L7c
            boolean r8 = r7.shouldAskBackgroundPermissions()
            if (r8 != 0) goto L52
            r0.label = r4
            java.lang.Object r8 = r7.getForegroundPermissionsAsync(r0)
            if (r8 != r1) goto L51
            goto L6d
        L51:
            return r8
        L52:
            expo.modules.kotlin.AppContext r8 = r7.getAppContext()
            expo.modules.interfaces.permissions.Permissions r8 = r8.getPermissions()
            if (r8 == 0) goto L76
            expo.modules.location.LocationHelpers$Companion r2 = expo.modules.location.LocationHelpers.INSTANCE
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            r4[r5] = r6
            r0.label = r3
            java.lang.Object r8 = r2.askForPermissionsWithPermissionsManager$expo_location_release(r8, r4, r0)
            if (r8 != r1) goto L6e
        L6d:
            return r1
        L6e:
            android.os.Bundle r8 = (android.os.Bundle) r8
            expo.modules.location.records.PermissionRequestResponse r0 = new expo.modules.location.records.PermissionRequestResponse
            r0.<init>(r8)
            return r0
        L76:
            expo.modules.location.NoPermissionsModuleException r8 = new expo.modules.location.NoPermissionsModuleException
            r8.<init>()
            throw r8
        L7c:
            expo.modules.location.NoPermissionInManifestException r8 = new expo.modules.location.NoPermissionInManifestException
            java.lang.String r0 = "ACCESS_BACKGROUND_LOCATION"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule.requestBackgroundPermissionsAsync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getBackgroundPermissionsAsync(Continuation<? super PermissionRequestResponse> continuation) throws NoPermissionsModuleException, NoPermissionInManifestException {
        if (!isBackgroundPermissionInManifest()) {
            throw new NoPermissionInManifestException("ACCESS_BACKGROUND_LOCATION");
        }
        if (!shouldAskBackgroundPermissions()) {
            return getForegroundPermissionsAsync(continuation);
        }
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return LocationHelpers.INSTANCE.getPermissionsWithPermissionsManager$expo_location_release(permissions, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, continuation);
        }
        throw new NoPermissionsModuleException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLastKnownPositionAsync(LocationLastKnownOptions locationLastKnownOptions, Continuation<? super LocationResponse> continuation) throws Throwable {
        C01721 c01721;
        if (continuation instanceof C01721) {
            c01721 = (C01721) continuation;
            if ((c01721.label & Integer.MIN_VALUE) != 0) {
                c01721.label -= Integer.MIN_VALUE;
            } else {
                c01721 = new C01721(continuation);
            }
        } else {
            c01721 = new C01721(continuation);
        }
        Object lastKnownLocation = c01721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(lastKnownLocation);
            if (isMissingForegroundPermissions()) {
                throw new LocationUnauthorizedException();
            }
            c01721.L$0 = locationLastKnownOptions;
            c01721.label = 1;
            lastKnownLocation = getLastKnownLocation(c01721);
            if (lastKnownLocation == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            locationLastKnownOptions = (LocationLastKnownOptions) c01721.L$0;
            ResultKt.throwOnFailure(lastKnownLocation);
        }
        Location location = (Location) lastKnownLocation;
        if (location != null && LocationHelpers.INSTANCE.isLocationValid$expo_location_release(location, locationLastKnownOptions)) {
            return new LocationResponse(location);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCurrentPositionAsync(LocationOptions options, final Promise promise) {
        LocationRequest locationRequestPrepareLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareLocationRequest$expo_location_release(options);
        final CurrentLocationRequest currentLocationRequestPrepareCurrentLocationRequest$expo_location_release = LocationHelpers.INSTANCE.prepareCurrentLocationRequest$expo_location_release(options);
        boolean mayShowUserSettingsDialog = options.getMayShowUserSettingsDialog();
        if (isMissingForegroundPermissions()) {
            promise.reject(new LocationUnauthorizedException());
            return;
        }
        LocationHelpers.Companion companion = LocationHelpers.INSTANCE;
        Context context = this.mContext;
        FusedLocationProviderClient fusedLocationProviderClient = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        if (companion.hasNetworkProviderEnabled(context) || !mayShowUserSettingsDialog) {
            LocationHelpers.Companion companion2 = LocationHelpers.INSTANCE;
            FusedLocationProviderClient fusedLocationProviderClient2 = this.mLocationProvider;
            if (fusedLocationProviderClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
            } else {
                fusedLocationProviderClient = fusedLocationProviderClient2;
            }
            companion2.requestSingleLocation(fusedLocationProviderClient, currentLocationRequestPrepareCurrentLocationRequest$expo_location_release, promise);
            return;
        }
        addPendingLocationRequest(locationRequestPrepareLocationRequest$expo_location_release, new LocationActivityResultListener() { // from class: expo.modules.location.LocationModule.getCurrentPositionAsync.1
            @Override // expo.modules.location.LocationActivityResultListener
            public void onResult(int resultCode) {
                if (resultCode == -1) {
                    LocationHelpers.Companion companion3 = LocationHelpers.INSTANCE;
                    FusedLocationProviderClient fusedLocationProviderClient3 = LocationModule.this.mLocationProvider;
                    if (fusedLocationProviderClient3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                        fusedLocationProviderClient3 = null;
                    }
                    companion3.requestSingleLocation(fusedLocationProviderClient3, currentLocationRequestPrepareCurrentLocationRequest$expo_location_release, promise);
                    return;
                }
                promise.reject(new LocationSettingsUnsatisfiedException());
            }
        });
    }

    public final void requestLocationUpdates(LocationRequest locationRequest, Integer requestId, final LocationRequestCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
            fusedLocationProviderClient = null;
        }
        LocationCallback locationCallback = new LocationCallback() { // from class: expo.modules.location.LocationModule$requestLocationUpdates$locationCallback$1
            private boolean isLocationAvailable;

            /* JADX INFO: renamed from: isLocationAvailable, reason: from getter */
            public final boolean getIsLocationAvailable() {
                return this.isLocationAvailable;
            }

            public final void setLocationAvailable(boolean z) {
                this.isLocationAvailable = z;
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                Location lastLocation = locationResult.getLastLocation();
                if (lastLocation != null) {
                    callbacks.onLocationChanged(lastLocation);
                } else if (!this.isLocationAvailable) {
                    callbacks.onLocationError(new LocationUnavailableException());
                } else {
                    callbacks.onRequestFailed(new LocationUnknownException());
                }
            }

            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                Intrinsics.checkNotNullParameter(locationAvailability, "locationAvailability");
                this.isLocationAvailable = locationAvailability.isLocationAvailable();
            }
        };
        if (requestId != null) {
            this.mLocationCallbacks.put(requestId, locationCallback);
            this.mLocationRequests.put(requestId, locationRequest);
        }
        try {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
            callbacks.onRequestSuccess();
        } catch (SecurityException e) {
            callbacks.onRequestFailed(new LocationRequestRejectedException(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPendingLocationRequest(LocationRequest locationRequest, LocationActivityResultListener listener) {
        this.mPendingLocationRequests.add(listener);
        if (this.mPendingLocationRequests.size() == 1) {
            resolveUserSettingsForRequest(locationRequest);
        }
    }

    private final void resolveUserSettingsForRequest(LocationRequest locationRequest) {
        LocationSettingsRequest.Builder builderAddLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        Intrinsics.checkNotNullExpressionValue(builderAddLocationRequest, "addLocationRequest(...)");
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        SettingsClient settingsClient = LocationServices.getSettingsClient(context);
        Intrinsics.checkNotNullExpressionValue(settingsClient, "getSettingsClient(...)");
        Task<LocationSettingsResponse> taskCheckLocationSettings = settingsClient.checkLocationSettings(builderAddLocationRequest.build());
        Intrinsics.checkNotNullExpressionValue(taskCheckLocationSettings, "checkLocationSettings(...)");
        final Function1 function1 = new Function1() { // from class: expo.modules.location.LocationModule$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationModule.resolveUserSettingsForRequest$lambda$32(this.f$0, (LocationSettingsResponse) obj);
            }
        };
        taskCheckLocationSettings.addOnSuccessListener(new OnSuccessListener() { // from class: expo.modules.location.LocationModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        });
        taskCheckLocationSettings.addOnFailureListener(new OnFailureListener() { // from class: expo.modules.location.LocationModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationModule.resolveUserSettingsForRequest$lambda$34(this.f$0, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveUserSettingsForRequest$lambda$32(LocationModule locationModule, LocationSettingsResponse locationSettingsResponse) {
        locationModule.executePendingRequests(-1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolveUserSettingsForRequest$lambda$34(LocationModule locationModule, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (((ApiException) e).getStatusCode() == 6) {
            try {
                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                UIManager uIManager = locationModule.mUIManager;
                if (uIManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUIManager");
                    uIManager = null;
                }
                uIManager.registerActivityEventListener(locationModule);
                resolvableApiException.startResolutionForResult(locationModule.getAppContext().getThrowingActivity(), 42);
                return;
            } catch (Throwable unused) {
                locationModule.executePendingRequests(0);
                return;
            }
        }
        locationModule.executePendingRequests(0);
    }

    private final void executePendingRequests(int resultCode) {
        Iterator<LocationActivityResultListener> it = this.mPendingLocationRequests.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            LocationActivityResultListener next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            next.onResult(resultCode);
        }
        this.mPendingLocationRequests.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startHeadingUpdate() {
        Context context = this.mContext;
        SensorManager sensorManager = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context2 = null;
        }
        if (ActivityCompat.checkSelfPermission(context2, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context3 = null;
            }
            if (ActivityCompat.checkSelfPermission(context3, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return;
            }
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
        if (lastKnownLocation == null) {
            lastKnownLocation = locationManager.getLastKnownLocation("network");
        }
        if (lastKnownLocation != null) {
            this.mGeofield = new GeomagneticField((float) lastKnownLocation.getLatitude(), (float) lastKnownLocation.getLongitude(), (float) lastKnownLocation.getAltitude(), System.currentTimeMillis());
        } else {
            LocationRequest locationRequestBuild = new LocationRequest.Builder(100, 0L).setMaxUpdates(1).build();
            Intrinsics.checkNotNullExpressionValue(locationRequestBuild, "build(...)");
            LocationCallback locationCallback = new LocationCallback() { // from class: expo.modules.location.LocationModule$startHeadingUpdate$locationCallback$1
                @Override // com.google.android.gms.location.LocationCallback
                public void onLocationResult(LocationResult locationResult) {
                    Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                    Location lastLocation = locationResult.getLastLocation();
                    if (lastLocation != null) {
                        this.this$0.mGeofield = new GeomagneticField((float) lastLocation.getLatitude(), (float) lastLocation.getLongitude(), (float) lastLocation.getAltitude(), System.currentTimeMillis());
                    }
                }
            };
            FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                fusedLocationProviderClient = null;
            }
            Intrinsics.checkNotNull(fusedLocationProviderClient.requestLocationUpdates(locationRequestBuild, locationCallback, Looper.getMainLooper()));
        }
        SensorManager sensorManager2 = this.mSensorManager;
        if (sensorManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager2 = null;
        }
        LocationModule locationModule = this;
        SensorManager sensorManager3 = this.mSensorManager;
        if (sensorManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager3 = null;
        }
        sensorManager2.registerListener(locationModule, sensorManager3.getDefaultSensor(2), 3);
        SensorManager sensorManager4 = this.mSensorManager;
        if (sensorManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager4 = null;
        }
        SensorManager sensorManager5 = this.mSensorManager;
        if (sensorManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
        } else {
            sensorManager = sensorManager5;
        }
        sensorManager4.registerListener(locationModule, sensorManager.getDefaultSensor(1), 3);
    }

    private final void sendUpdate() {
        float[] fArr = new float[9];
        if (SensorManager.getRotationMatrix(fArr, new float[9], this.mGravity, this.mGeomagnetic)) {
            float[] fArr2 = new float[3];
            SensorManager.getOrientation(fArr, fArr2);
            if (Math.abs(fArr2[0] - this.mLastAzimuth) <= 0.0355d || System.currentTimeMillis() - this.mLastUpdate <= 50.0f) {
                return;
            }
            this.mLastAzimuth = fArr2[0];
            this.mLastUpdate = System.currentTimeMillis();
            float fCalcMagNorth = calcMagNorth(fArr2[0]);
            sendEvent(HEADING_EVENT_NAME, new HeadingEventResponse(Integer.valueOf(this.mHeadingId), new Heading(calcTrueNorth(fCalcMagNorth), fCalcMagNorth, this.mAccuracy)).toBundle$expo_location_release());
        }
    }

    public final void sendLocationResponse$expo_location_release(int watchId, LocationResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle bundleBundleOf = BundleKt.bundleOf();
        bundleBundleOf.putBundle("location", (Bundle) response.toBundle$expo_location_release(Bundle.class));
        bundleBundleOf.putInt("watchId", watchId);
        sendEvent(LOCATION_EVENT_NAME, bundleBundleOf);
    }

    private final float calcMagNorth(float azimuth) {
        float degrees = (float) Math.toDegrees(azimuth);
        float f = CropImageOptionsKt.DEGREES_360;
        return (degrees + f) % f;
    }

    private final float calcTrueNorth(float magNorth) {
        GeomagneticField geomagneticField = this.mGeofield;
        if (isMissingForegroundPermissions()) {
            geomagneticField = null;
        }
        if (geomagneticField == null) {
            return -1.0f;
        }
        return (magNorth + geomagneticField.getDeclination()) % CropImageOptionsKt.DEGREES_360;
    }

    private final void stopHeadingWatch() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            sensorManager = null;
        }
        sensorManager.unregisterListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyHeadingWatch() {
        stopHeadingWatch();
        this.mGravity = new float[9];
        this.mGeomagnetic = new float[9];
        this.mGeofield = null;
        this.mHeadingId = 0;
        this.mLastAzimuth = 0.0f;
        this.mAccuracy = 0;
    }

    private final void startWatching() {
        if (!isMissingForegroundPermissions()) {
            this.mGeocoderPaused = false;
        }
        resumeLocationUpdates();
    }

    private final void stopWatching() {
        if (Geocoder.isPresent() && !isMissingForegroundPermissions()) {
            this.mGeocoderPaused = true;
        }
        for (Integer num : this.mLocationCallbacks.keySet()) {
            Intrinsics.checkNotNullExpressionValue(num, "next(...)");
            pauseLocationUpdatesForRequest(num.intValue());
        }
    }

    private final void pauseLocationUpdatesForRequest(int requestId) {
        LocationCallback locationCallback = this.mLocationCallbacks.get(Integer.valueOf(requestId));
        if (locationCallback != null) {
            FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                fusedLocationProviderClient = null;
            }
            fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeLocationUpdatesForRequest(int requestId) {
        pauseLocationUpdatesForRequest(requestId);
        this.mLocationCallbacks.remove(Integer.valueOf(requestId));
        this.mLocationRequests.remove(Integer.valueOf(requestId));
    }

    private final void resumeLocationUpdates() {
        LocationRequest locationRequest;
        for (Integer num : this.mLocationCallbacks.keySet()) {
            Intrinsics.checkNotNullExpressionValue(num, "next(...)");
            int iIntValue = num.intValue();
            LocationCallback locationCallback = this.mLocationCallbacks.get(Integer.valueOf(iIntValue));
            if (locationCallback == null || (locationRequest = this.mLocationRequests.get(Integer.valueOf(iIntValue))) == null) {
                return;
            }
            try {
                FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
                if (fusedLocationProviderClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                    fusedLocationProviderClient = null;
                }
                Intrinsics.checkNotNull(fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper()));
            } catch (SecurityException e) {
                Integer.valueOf(Log.e(TAG, "Error occurred while resuming location updates: " + e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getLastKnownLocation(Continuation<? super Location> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        try {
            FusedLocationProviderClient fusedLocationProviderClient = this.mLocationProvider;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                fusedLocationProviderClient = null;
            }
            Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
            final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: expo.modules.location.LocationModule$getLastKnownLocation$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Location location) {
                    invoke2(location);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Location location) {
                    Continuation<Location> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m772constructorimpl(location));
                }
            };
            Intrinsics.checkNotNull(lastLocation.addOnSuccessListener(new OnSuccessListener(function1) { // from class: expo.modules.location.LocationModule$sam$com_google_android_gms_tasks_OnSuccessListener$0
                private final /* synthetic */ Function1 function;

                {
                    Intrinsics.checkNotNullParameter(function1, "function");
                    this.function = function1;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final /* synthetic */ void onSuccess(Object obj) {
                    this.function.invoke(obj);
                }
            }).addOnCanceledListener(new OnCanceledListener() { // from class: expo.modules.location.LocationModule$getLastKnownLocation$2$2
                @Override // com.google.android.gms.tasks.OnCanceledListener
                public final void onCanceled() {
                    Continuation<Location> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m772constructorimpl(null));
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.location.LocationModule$getLastKnownLocation$2$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Continuation<Location> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m772constructorimpl(null));
                }
            }));
        } catch (SecurityException unused) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m772constructorimpl(null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object geocode(String str, Continuation<? super List<GeocodeResponse>> continuation) throws Throwable {
        Context context = null;
        if (this.mGeocoderPaused) {
            throw new GeocodeException("Geocoder is not running", null, 2, null);
        }
        if (isMissingForegroundPermissions()) {
            throw new LocationUnauthorizedException();
        }
        if (!Geocoder.isPresent()) {
            throw new NoGeocodeException();
        }
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context2;
        }
        List<Address> fromLocationName = new Geocoder(context, Locale.getDefault()).getFromLocationName(str, 1);
        if (fromLocationName == null) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m772constructorimpl(CollectionsKt.emptyList()));
        } else {
            ArrayList arrayList = new ArrayList();
            for (Address address : fromLocationName) {
                Location location = new Location("gps");
                location.setLatitude(address.getLatitude());
                location.setLongitude(address.getLongitude());
                GeocodeResponse geocodeResponseFrom = GeocodeResponse.INSTANCE.from(location);
                if (geocodeResponseFrom != null) {
                    arrayList.add(geocodeResponseFrom);
                }
            }
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m772constructorimpl(arrayList));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object reverseGeocode(ReverseGeocodeLocation reverseGeocodeLocation, Continuation<? super List<ReverseGeocodeResponse>> continuation) throws Throwable {
        if (this.mGeocoderPaused) {
            throw new GeocodeException("Geocoder is not running", null, 2, null);
        }
        if (isMissingForegroundPermissions()) {
            throw new LocationUnauthorizedException();
        }
        if (!Geocoder.isPresent()) {
            throw new NoGeocodeException();
        }
        Location location = new Location("");
        location.setLatitude(reverseGeocodeLocation.getLatitude());
        location.setLongitude(reverseGeocodeLocation.getLongitude());
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        if (fromLocation == null) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m772constructorimpl(CollectionsKt.emptyList()));
        } else {
            ArrayList arrayList = new ArrayList();
            for (Address address : fromLocation) {
                ReverseGeocodeResponse reverseGeocodeResponse = address != null ? new ReverseGeocodeResponse(address) : null;
                if (reverseGeocodeResponse != null) {
                    arrayList.add(reverseGeocodeResponse);
                }
            }
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m772constructorimpl(arrayList));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingForegroundPermissions() throws Exceptions.AppContextLost {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return (permissions.hasGrantedPermissions("android.permission.ACCESS_FINE_LOCATION") || permissions.hasGrantedPermissions("android.permission.ACCESS_COARSE_LOCATION")) ? false : true;
        }
        throw new Exceptions.AppContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasForegroundServicePermissions() throws Exceptions.AppContextLost {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            if (Build.VERSION.SDK_INT >= 34) {
                return permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE") && permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE_LOCATION");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return permissions.hasGrantedPermissions("android.permission.FOREGROUND_SERVICE");
            }
            return true;
        }
        throw new Exceptions.AppContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingBackgroundPermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return Build.VERSION.SDK_INT >= 29 && !permissions.hasGrantedPermissions("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        return true;
    }

    private final boolean shouldAskBackgroundPermissions() {
        return Build.VERSION.SDK_INT >= 29;
    }

    private final boolean isBackgroundPermissionInManifest() throws NoPermissionsModuleException {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions.isPermissionPresentInManifest("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        throw new NoPermissionsModuleException();
    }

    /* JADX INFO: compiled from: LocationModule.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/location/LocationModule$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$expo_location_release", "()Ljava/lang/String;", "LOCATION_EVENT_NAME", "HEADING_EVENT_NAME", "CHECK_SETTINGS_REQUEST_CODE", "", "ACCURACY_LOWEST", "ACCURACY_LOW", "ACCURACY_BALANCED", "ACCURACY_HIGH", "ACCURACY_HIGHEST", "ACCURACY_BEST_FOR_NAVIGATION", "GEOFENCING_EVENT_ENTER", "GEOFENCING_EVENT_EXIT", "DEGREE_DELTA", "", "TIME_DELTA", "", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_location_release() {
            return LocationModule.TAG;
        }
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        startWatching();
        startHeadingUpdate();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
        stopWatching();
        stopHeadingWatch();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
        stopWatching();
        stopHeadingWatch();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        if (event == null) {
            return;
        }
        if (event.sensor.getType() == 1) {
            float[] values = event.values;
            Intrinsics.checkNotNullExpressionValue(values, "values");
            this.mGravity = values;
        } else if (event.sensor.getType() == 2) {
            float[] values2 = event.values;
            Intrinsics.checkNotNullExpressionValue(values2, "values");
            this.mGeomagnetic = values2;
        }
        sendUpdate();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        this.mAccuracy = accuracy;
    }

    @Override // expo.modules.core.interfaces.ActivityEventListener
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if (requestCode != 42) {
            return;
        }
        executePendingRequests(resultCode);
        UIManager uIManager = this.mUIManager;
        if (uIManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIManager");
            uIManager = null;
        }
        uIManager.unregisterActivityEventListener(this);
    }
}
