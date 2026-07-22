package expo.modules.kotlin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.core.errors.ContextDestroyedException;
import expo.modules.core.errors.ModuleNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.logging.Logger;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.interfaces.filesystem.AppDirectoriesModuleInterface;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.font.FontManagerInterface;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.activityresult.ActivityResultsManager;
import expo.modules.kotlin.activityresult.DefaultAppContextActivityResultCaller;
import expo.modules.kotlin.defaultmodules.AppDirectoriesModule;
import expo.modules.kotlin.defaultmodules.FilePermissionModule;
import expo.modules.kotlin.defaultmodules.JSLoggerModule;
import expo.modules.kotlin.defaultmodules.NativeModulesProxyModule;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.KEventEmitterWrapper;
import expo.modules.kotlin.events.KModuleEventEmitterWrapper;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: compiled from: AppContext.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200J\u0018\u00102\u001a\u0004\u0018\u0001H3\"\u0006\b\u0000\u00103\u0018\u0001H\u0086\b¢\u0006\u0002\u00104J\u0010\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010h\u001a\u00020iJ\r\u0010{\u001a\u000200H\u0000¢\u0006\u0002\b|J\r\u0010}\u001a\u000200H\u0000¢\u0006\u0002\b~J\u000e\u0010\u007f\u001a\u000200H\u0000¢\u0006\u0003\b\u0080\u0001J\u000f\u0010\u0081\u0001\u001a\u000200H\u0000¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u000200H\u0000¢\u0006\u0003\b\u0084\u0001J9\u0010\u0085\u0001\u001a\u0002002\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\b\u0010\u008a\u0001\u001a\u00030\u0089\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0000¢\u0006\u0003\b\u008d\u0001J\u001b\u0010\u008e\u0001\u001a\u0002002\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0000¢\u0006\u0003\b\u0090\u0001J(\u0010\u0091\u0001\u001a\u0005\u0018\u0001H\u0092\u0001\"\n\b\u0000\u0010\u0092\u0001*\u00030\u0093\u00012\b\u0010\u0094\u0001\u001a\u00030\u0089\u0001H\u0007¢\u0006\u0003\u0010\u0095\u0001J\u001f\u0010\u0096\u0001\u001a\u0002002\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u0002000\u0098\u0001H\u0000¢\u0006\u0003\b\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u000200H\u0000¢\u0006\u0003\b\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u0002002\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u00010>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010A\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0011\u0010E\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bF\u0010DR\u0013\u0010G\u001a\u0004\u0018\u00010H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010L8F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0013\u0010O\u001a\u0004\u0018\u00010P8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0013\u0010S\u001a\u0004\u0018\u00010T8F¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0013\u0010W\u001a\u0004\u0018\u00010X8F¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0013\u0010[\u001a\u0004\u0018\u00010\\8F¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0013\u0010_\u001a\u0004\u0018\u00010`8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0011\u0010c\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0016\u0010j\u001a\u0004\u0018\u00010g8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR)\u0010m\u001a\n\u0018\u00010nj\u0004\u0018\u0001`o8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bt\u0010u\u0012\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001d\u0010v\u001a\u0004\u0018\u00010w8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bz\u0010u\u001a\u0004\bx\u0010yR\u001a\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0087\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001R\u0015\u0010¢\u0001\u001a\u00030\u0087\u00018F¢\u0006\b\u001a\u0006\b£\u0001\u0010¡\u0001¨\u0006¤\u0001"}, d2 = {"Lexpo/modules/kotlin/AppContext;", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "getLegacyModuleRegistry", "()Lexpo/modules/core/ModuleRegistry;", "hostingRuntimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "getHostingRuntimeContext", "()Lexpo/modules/kotlin/RuntimeContext;", "reactLifecycleDelegate", "Lexpo/modules/kotlin/ReactLifecycleDelegate;", "hostWasDestroyed", "", "modulesQueueDispatcher", "Lkotlinx/coroutines/android/HandlerDispatcher;", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getBackgroundCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "modulesQueue", "getModulesQueue", "mainQueue", "getMainQueue", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "legacyModulesProxyHolder", "Lexpo/modules/adapters/react/NativeModulesProxy;", "getLegacyModulesProxyHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "setLegacyModulesProxyHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "activityResultsManager", "Lexpo/modules/kotlin/activityresult/ActivityResultsManager;", "appContextActivityResultCaller", "Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "getAppContextActivityResultCaller$expo_modules_core_release", "()Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "onCreate", "", "installJSIInterop", "legacyModule", "Module", "()Ljava/lang/Object;", "constants", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "getConstants", "()Lexpo/modules/interfaces/constants/ConstantsInterface;", "filePermission", "Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "getFilePermission", "()Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "appDirectories", "Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "getAppDirectories", "()Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "persistentFilesDirectory", "Ljava/io/File;", "getPersistentFilesDirectory", "()Ljava/io/File;", "cacheDirectory", "getCacheDirectory", "permissions", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissions", "()Lexpo/modules/interfaces/permissions/Permissions;", "imageLoader", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "getImageLoader", "()Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "camera", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "getCamera", "()Lexpo/modules/interfaces/camera/CameraViewInterface;", "font", "Lexpo/modules/interfaces/font/FontManagerInterface;", "getFont", "()Lexpo/modules/interfaces/font/FontManagerInterface;", "taskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "getActivityProvider", "()Lexpo/modules/core/interfaces/ActivityProvider;", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "hasActiveReactInstance", "getHasActiveReactInstance", "()Z", "eventEmitter", "Lexpo/modules/kotlin/events/EventEmitter;", "module", "Lexpo/modules/kotlin/modules/Module;", "callbackInvoker", "getCallbackInvoker$expo_modules_core_release", "()Lexpo/modules/kotlin/events/EventEmitter;", "errorManager", "Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "Lexpo/modules/kotlin/defaultmodules/ErrorManagerModule;", "getErrorManager$annotations", "()V", "getErrorManager", "()Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "errorManager$delegate", "Lkotlin/Lazy;", "jsLogger", "Lexpo/modules/core/logging/Logger;", "getJsLogger", "()Lexpo/modules/core/logging/Logger;", "jsLogger$delegate", "onDestroy", "onDestroy$expo_modules_core_release", "onHostResume", "onHostResume$expo_modules_core_release", "onHostPause", "onHostPause$expo_modules_core_release", "onUserLeaveHint", "onUserLeaveHint$expo_modules_core_release", "onHostDestroy", "onHostDestroy$expo_modules_core_release", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", UriUtil.DATA_SCHEME, "Landroid/content/Intent;", "onActivityResult$expo_modules_core_release", "onNewIntent", "intent", "onNewIntent$expo_modules_core_release", "findView", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "viewTag", "(I)Landroid/view/View;", "dispatchOnMainUsingUIManager", "block", "Lkotlin/Function0;", "dispatchOnMainUsingUIManager$expo_modules_core_release", "assertMainThread", "assertMainThread$expo_modules_core_release", "executeOnJavaScriptThread", "runnable", "Ljava/lang/Runnable;", "currentActivity", "getCurrentActivity", "()Landroid/app/Activity;", "throwingActivity", "getThrowingActivity", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppContext implements CurrentActivityProvider {
    private final ActivityResultsManager activityResultsManager;
    private final DefaultAppContextActivityResultCaller appContextActivityResultCaller;
    private final CoroutineScope backgroundCoroutineScope;

    /* JADX INFO: renamed from: errorManager$delegate, reason: from kotlin metadata */
    private final Lazy errorManager;
    private boolean hostWasDestroyed;
    private final RuntimeContext hostingRuntimeContext;

    /* JADX INFO: renamed from: jsLogger$delegate, reason: from kotlin metadata */
    private final Lazy jsLogger;
    private final expo.modules.core.ModuleRegistry legacyModuleRegistry;
    private WeakReference<NativeModulesProxy> legacyModulesProxyHolder;
    private final CoroutineScope mainQueue;
    private final CoroutineScope modulesQueue;
    private final HandlerDispatcher modulesQueueDispatcher;
    private final ReactLifecycleDelegate reactLifecycleDelegate;

    @Deprecated(message = "Use AppContext.jsLogger instead")
    public static /* synthetic */ void getErrorManager$annotations() {
    }

    public AppContext(ModulesProvider modulesProvider, expo.modules.core.ModuleRegistry legacyModuleRegistry, WeakReference<ReactApplicationContext> reactContextHolder) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(legacyModuleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.legacyModuleRegistry = legacyModuleRegistry;
        this.hostingRuntimeContext = new RuntimeContext(this, reactContextHolder);
        ReactLifecycleDelegate reactLifecycleDelegate = new ReactLifecycleDelegate(this);
        this.reactLifecycleDelegate = reactLifecycleDelegate;
        HandlerThread handlerThread = new HandlerThread("expo.modules.AsyncFunctionQueue");
        handlerThread.start();
        HandlerDispatcher handlerDispatcherFrom$default = HandlerDispatcherKt.from$default(new Handler(handlerThread.getLooper()), null, 1, null);
        this.modulesQueueDispatcher = handlerDispatcherFrom$default;
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.BackgroundCoroutineScope")));
        this.modulesQueue = CoroutineScopeKt.CoroutineScope(handlerDispatcherFrom$default.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.AsyncFunctionQueue")));
        this.mainQueue = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.MainQueue")));
        ActivityResultsManager activityResultsManager = new ActivityResultsManager(this);
        this.activityResultsManager = activityResultsManager;
        this.appContextActivityResultCaller = new DefaultAppContextActivityResultCaller(activityResultsManager);
        ReactApplicationContext reactApplicationContext = reactContextHolder.get();
        if (reactApplicationContext == null) {
            throw new IllegalArgumentException("The app context should be created with valid react context.".toString());
        }
        ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
        reactApplicationContext2.addLifecycleEventListener(reactLifecycleDelegate);
        reactApplicationContext2.addActivityEventListener(reactLifecycleDelegate);
        getRegistry().register(new NativeModulesProxyModule());
        getRegistry().register(new JSLoggerModule());
        legacyModuleRegistry.registerInternalModule(new FilePermissionModule());
        legacyModuleRegistry.registerInternalModule(new AppDirectoriesModule(reactApplicationContext2));
        getRegistry().register(modulesProvider);
        CoreLoggerKt.getLogger().info("✅ AppContext was initialized");
        this.errorManager = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.errorManager_delegate$lambda$6(this.f$0);
            }
        });
        this.jsLogger = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.jsLogger_delegate$lambda$7(this.f$0);
            }
        });
    }

    public final expo.modules.core.ModuleRegistry getLegacyModuleRegistry() {
        return this.legacyModuleRegistry;
    }

    public final RuntimeContext getHostingRuntimeContext() {
        return this.hostingRuntimeContext;
    }

    public final CoroutineScope getBackgroundCoroutineScope() {
        return this.backgroundCoroutineScope;
    }

    public final CoroutineScope getModulesQueue() {
        return this.modulesQueue;
    }

    public final CoroutineScope getMainQueue() {
        return this.mainQueue;
    }

    public final ModuleRegistry getRegistry() {
        return this.hostingRuntimeContext.getRegistry();
    }

    public final WeakReference<NativeModulesProxy> getLegacyModulesProxyHolder$expo_modules_core_release() {
        return this.legacyModulesProxyHolder;
    }

    public final void setLegacyModulesProxyHolder$expo_modules_core_release(WeakReference<NativeModulesProxy> weakReference) {
        this.legacyModulesProxyHolder = weakReference;
    }

    /* JADX INFO: renamed from: getAppContextActivityResultCaller$expo_modules_core_release, reason: from getter */
    public final DefaultAppContextActivityResultCaller getAppContextActivityResultCaller() {
        return this.appContextActivityResultCaller;
    }

    public final void installJSIInterop() {
        this.hostingRuntimeContext.installJSIContext();
    }

    public final /* synthetic */ <Module> Module legacyModule() {
        try {
            expo.modules.core.ModuleRegistry legacyModuleRegistry = getLegacyModuleRegistry();
            Intrinsics.reifiedOperationMarker(4, "Module");
            return (Module) legacyModuleRegistry.getModule(Object.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final File getPersistentFilesDirectory() throws ModuleNotFoundException {
        File persistentFilesDirectory;
        AppDirectoriesModuleInterface appDirectories = getAppDirectories();
        if (appDirectories == null || (persistentFilesDirectory = appDirectories.getPersistentFilesDirectory()) == null) {
            throw new ModuleNotFoundException("expo.modules.interfaces.filesystem.AppDirectories");
        }
        return persistentFilesDirectory;
    }

    public final File getCacheDirectory() throws ModuleNotFoundException {
        File cacheDirectory;
        AppDirectoriesModuleInterface appDirectories = getAppDirectories();
        if (appDirectories == null || (cacheDirectory = appDirectories.getCacheDirectory()) == null) {
            throw new ModuleNotFoundException("expo.modules.interfaces.filesystem.AppDirectories");
        }
        return cacheDirectory;
    }

    public final Context getReactContext() {
        return this.hostingRuntimeContext.getReactContextHolder().get();
    }

    public final boolean getHasActiveReactInstance() {
        ReactApplicationContext reactApplicationContext = this.hostingRuntimeContext.getReactContextHolder().get();
        if (reactApplicationContext != null) {
            return reactApplicationContext.hasActiveReactInstance();
        }
        return false;
    }

    public final JSLoggerModule getErrorManager() {
        return (JSLoggerModule) this.errorManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSLoggerModule errorManager_delegate$lambda$6(AppContext appContext) {
        Object next;
        Module module;
        Iterator<T> it = appContext.hostingRuntimeContext.getRegistry().getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            module = ((ModuleHolder) next).getModule();
        } while (!(module != null ? module instanceof JSLoggerModule : true));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module2 = moduleHolder != null ? moduleHolder.getModule() : null;
        return (JSLoggerModule) (module2 instanceof JSLoggerModule ? module2 : null);
    }

    public final Logger getJsLogger() {
        return (Logger) this.jsLogger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger jsLogger_delegate$lambda$7(AppContext appContext) {
        Object next;
        Iterator<T> it = appContext.hostingRuntimeContext.getRegistry().getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ModuleHolder) next).getModule() instanceof JSLoggerModule));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module = moduleHolder != null ? moduleHolder.getModule() : null;
        if (!(module instanceof JSLoggerModule)) {
            module = null;
        }
        JSLoggerModule jSLoggerModule = (JSLoggerModule) module;
        if (jSLoggerModule != null) {
            return jSLoggerModule.getLogger();
        }
        return null;
    }

    public final void onHostResume$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (!(currentActivity instanceof AppCompatActivity)) {
            Activity currentActivity2 = getCurrentActivity();
            throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
        }
        if (this.hostWasDestroyed) {
            this.hostWasDestroyed = false;
            this.hostingRuntimeContext.getRegistry().registerActivityContracts$expo_modules_core_release();
        }
        this.activityResultsManager.onHostResume((AppCompatActivity) currentActivity);
        this.hostingRuntimeContext.getRegistry().post(EventName.ACTIVITY_ENTERS_FOREGROUND);
    }

    public final void onHostPause$expo_modules_core_release() {
        this.hostingRuntimeContext.getRegistry().post(EventName.ACTIVITY_ENTERS_BACKGROUND);
    }

    public final void onUserLeaveHint$expo_modules_core_release() {
        this.hostingRuntimeContext.getRegistry().post(EventName.ON_USER_LEAVES_ACTIVITY);
    }

    public final void onHostDestroy$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (!(currentActivity instanceof AppCompatActivity)) {
                Activity currentActivity2 = getCurrentActivity();
                throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
            }
            this.activityResultsManager.onHostDestroy((AppCompatActivity) currentActivity);
        }
        this.hostingRuntimeContext.getRegistry().post(EventName.ACTIVITY_DESTROYS);
        this.hostWasDestroyed = true;
    }

    public final void onActivityResult$expo_modules_core_release(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityResultsManager.onActivityResult(requestCode, resultCode, data);
        this.hostingRuntimeContext.getRegistry().post(EventName.ON_ACTIVITY_RESULT, activity, new OnActivityResultPayload(requestCode, resultCode, data));
    }

    public final void onNewIntent$expo_modules_core_release(Intent intent) {
        this.hostingRuntimeContext.getRegistry().post(EventName.ON_NEW_INTENT, intent);
    }

    public final <T extends View> T findView(int viewTag) {
        ReactApplicationContext reactApplicationContext = this.hostingRuntimeContext.getReactContextHolder().get();
        if (reactApplicationContext == null) {
            return null;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, viewTag);
        T t = uIManagerForReactTag != null ? (T) uIManagerForReactTag.resolveView(viewTag) : null;
        if (t instanceof View) {
            return t;
        }
        return null;
    }

    public final void dispatchOnMainUsingUIManager$expo_modules_core_release(final Function0<Unit> block) throws Exceptions.ReactContextLost {
        Intrinsics.checkNotNullParameter(block, "block");
        ReactApplicationContext reactApplicationContext = this.hostingRuntimeContext.getReactContextHolder().get();
        if (reactApplicationContext == null) {
            throw new Exceptions.ReactContextLost();
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, 1);
        Intrinsics.checkNotNull(uIManagerForReactTag, "null cannot be cast to non-null type com.facebook.react.uimanager.UIManagerModule");
        ((UIManagerModule) uIManagerForReactTag).addUIBlock(new UIBlock() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda2
            @Override // com.facebook.react.uimanager.UIBlock
            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                AppContext.dispatchOnMainUsingUIManager$lambda$12(block, nativeViewHierarchyManager);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchOnMainUsingUIManager$lambda$12(Function0 function0, NativeViewHierarchyManager it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
    }

    public final void assertMainThread$expo_modules_core_release() throws Exceptions.IncorrectThreadException {
        Utils utils = Utils.INSTANCE;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return;
        }
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = Looper.getMainLooper().getThread().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        throw new Exceptions.IncorrectThreadException(name, name2);
    }

    public final void executeOnJavaScriptThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ReactApplicationContext reactApplicationContext = this.hostingRuntimeContext.getReactContextHolder().get();
        if (reactApplicationContext != null) {
            reactApplicationContext.runOnJSQueueThread(runnable);
        }
    }

    @Override // expo.modules.kotlin.providers.CurrentActivityProvider
    public Activity getCurrentActivity() {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null) {
            return currentActivity;
        }
        Context reactContext = getReactContext();
        ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
        if (reactApplicationContext != null) {
            return reactApplicationContext.getCurrentActivity();
        }
        return null;
    }

    public final Activity getThrowingActivity() throws Exceptions.MissingActivity {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null) {
            Context reactContext = getReactContext();
            ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
            currentActivity = reactApplicationContext != null ? reactApplicationContext.getCurrentActivity() : null;
        }
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    public final void onCreate() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onCreate");
        try {
            getHostingRuntimeContext().getRegistry().postOnCreate();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final ConstantsInterface getConstants() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(ConstantsInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        return (ConstantsInterface) module;
    }

    public final FilePermissionModuleInterface getFilePermission() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(FilePermissionModuleInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        return (FilePermissionModuleInterface) module;
    }

    private final AppDirectoriesModuleInterface getAppDirectories() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(AppDirectoriesModuleInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        return (AppDirectoriesModuleInterface) module;
    }

    public final Permissions getPermissions() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(Permissions.class);
        } catch (Exception unused) {
            module = null;
        }
        return (Permissions) module;
    }

    public final ImageLoaderInterface getImageLoader() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(ImageLoaderInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        return (ImageLoaderInterface) module;
    }

    public final CameraViewInterface getCamera() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(CameraViewInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        return (CameraViewInterface) module;
    }

    public final FontManagerInterface getFont() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(FontManagerInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        return (FontManagerInterface) module;
    }

    public final TaskManagerInterface getTaskManager() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
        } catch (Exception unused) {
            module = null;
        }
        return (TaskManagerInterface) module;
    }

    public final ActivityProvider getActivityProvider() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(ActivityProvider.class);
        } catch (Exception unused) {
            module = null;
        }
        return (ActivityProvider) module;
    }

    public final EventEmitter eventEmitter(Module module) {
        Object module2;
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            module2 = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module2 = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module2;
        if (eventEmitter == null) {
            return null;
        }
        ModuleHolder moduleHolder = this.hostingRuntimeContext.getRegistry().getModuleHolder(module);
        if (moduleHolder != null) {
            return new KModuleEventEmitterWrapper(moduleHolder, eventEmitter, this.hostingRuntimeContext.getReactContextHolder());
        }
        throw new IllegalArgumentException("Cannot create an event emitter for the module that isn't present in the module registry.".toString());
    }

    public final EventEmitter getCallbackInvoker$expo_modules_core_release() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module;
        if (eventEmitter == null) {
            return null;
        }
        return new KEventEmitterWrapper(eventEmitter, this.hostingRuntimeContext.getReactContextHolder());
    }

    public final void onDestroy$expo_modules_core_release() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onDestroy");
        try {
            ReactApplicationContext reactApplicationContext = getHostingRuntimeContext().getReactContextHolder().get();
            if (reactApplicationContext != null) {
                reactApplicationContext.removeLifecycleEventListener(this.reactLifecycleDelegate);
            }
            getHostingRuntimeContext().getRegistry().post(EventName.MODULE_DESTROY);
            getHostingRuntimeContext().getRegistry().cleanUp();
            CoroutineScopeKt.cancel(getModulesQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getMainQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getBackgroundCoroutineScope(), new ContextDestroyedException(null, 1, null));
            getHostingRuntimeContext().deallocate();
            CoreLoggerKt.getLogger().info("✅ AppContext was destroyed");
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
