package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.ClassFinder;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.TimingModule;
import com.facebook.react.modules.debug.DevMenuModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerResolver;
import com.facebook.systrace.Systrace;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoreModulesPackage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/CoreModulesPackage;", "Lcom/facebook/react/BaseReactPackage;", "Lcom/facebook/react/ReactPackageLogger;", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "hardwareBackBtnHandler", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "lazyViewManagersEnabled", "", "minTimeLeftInFrameForNonBatchedOperationMs", "", "<init>", "(Lcom/facebook/react/ReactInstanceManager;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;ZI)V", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "fallbackForMissingClass", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "name", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createUIManager", "Lcom/facebook/react/uimanager/UIManagerModule;", "startProcessPackage", "", "endProcessPackage", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoreModulesPackage extends BaseReactPackage implements ReactPackageLogger {
    private static final Companion Companion = new Companion(null);
    private final DefaultHardwareBackBtnHandler hardwareBackBtnHandler;
    private final boolean lazyViewManagersEnabled;
    private final int minTimeLeftInFrameForNonBatchedOperationMs;
    private final ReactInstanceManager reactInstanceManager;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map fallbackForMissingClass$lambda$0(Map map) {
        return map;
    }

    public CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler hardwareBackBtnHandler, boolean z, int i) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        Intrinsics.checkNotNullParameter(hardwareBackBtnHandler, "hardwareBackBtnHandler");
        this.reactInstanceManager = reactInstanceManager;
        this.hardwareBackBtnHandler = hardwareBackBtnHandler;
        this.lazyViewManagersEnabled = z;
        this.minTimeLeftInFrameForNonBatchedOperationMs = i;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        Constructor<?> declaredConstructor;
        if (!ClassFinder.canLoadClassesFromAnnotationProcessors()) {
            return fallbackForMissingClass();
        }
        try {
            Class<?> clsFindClass = ClassFinder.findClass("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider");
            Object objNewInstance = (clsFindClass == null || (declaredConstructor = clsFindClass.getDeclaredConstructor(new Class[0])) == null) ? null : declaredConstructor.newInstance(new Object[0]);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.react.module.model.ReactModuleInfoProvider");
            return (ReactModuleInfoProvider) objNewInstance;
        } catch (ClassNotFoundException unused) {
            return fallbackForMissingClass();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        }
    }

    private final ReactModuleInfoProvider fallbackForMissingClass() {
        Class<?>[] clsArr = {AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevMenuModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, LogBoxModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, TimingModule.class, UIManagerModule.class};
        final HashMap map = new HashMap();
        for (int i = 0; i < 11; i++) {
            Class<?> cls = clsArr[i];
            ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
            if (reactModule != null) {
                String strName = reactModule.name();
                String strName2 = reactModule.name();
                String name = cls.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                map.put(strName, new ReactModuleInfo(strName2, name, reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), ReactModuleInfo.INSTANCE.classIsTurboModule(cls)));
            }
        }
        return new ReactModuleInfoProvider() { // from class: com.facebook.react.CoreModulesPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return CoreModulesPackage.fallbackForMissingClass$lambda$0(map);
            }
        };
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        switch (name.hashCode()) {
            case -2013505529:
                if (name.equals("LogBox")) {
                    DevSupportManager devSupportManager = this.reactInstanceManager.getDevSupportManager();
                    Intrinsics.checkNotNullExpressionValue(devSupportManager, "getDevSupportManager(...)");
                    return new LogBoxModule(reactContext, devSupportManager);
                }
                break;
            case -1789797270:
                if (name.equals("Timing")) {
                    DevSupportManager devSupportManager2 = this.reactInstanceManager.getDevSupportManager();
                    Intrinsics.checkNotNullExpressionValue(devSupportManager2, "getDevSupportManager(...)");
                    return new TimingModule(reactContext, devSupportManager2);
                }
                break;
            case -1633589448:
                if (name.equals("DevSettings")) {
                    DevSupportManager devSupportManager3 = this.reactInstanceManager.getDevSupportManager();
                    Intrinsics.checkNotNullExpressionValue(devSupportManager3, "getDevSupportManager(...)");
                    return new DevSettingsModule(reactContext, devSupportManager3);
                }
                break;
            case -1520650172:
                if (name.equals("DeviceInfo")) {
                    return new DeviceInfoModule(reactContext);
                }
                break;
            case -1071344908:
                if (name.equals("DevMenu")) {
                    DevSupportManager devSupportManager4 = this.reactInstanceManager.getDevSupportManager();
                    Intrinsics.checkNotNullExpressionValue(devSupportManager4, "getDevSupportManager(...)");
                    return new DevMenuModule(reactContext, devSupportManager4);
                }
                break;
            case -1037217463:
                if (name.equals("DeviceEventManager")) {
                    return new DeviceEventManagerModule(reactContext, this.hardwareBackBtnHandler);
                }
                break;
            case -790603268:
                if (name.equals("PlatformConstants")) {
                    return new AndroidInfoModule(reactContext);
                }
                break;
            case 512434409:
                if (name.equals("ExceptionsManager")) {
                    DevSupportManager devSupportManager5 = this.reactInstanceManager.getDevSupportManager();
                    Intrinsics.checkNotNullExpressionValue(devSupportManager5, "getDevSupportManager(...)");
                    return new ExceptionsManagerModule(devSupportManager5);
                }
                break;
            case 881516744:
                if (name.equals("SourceCode")) {
                    return new SourceCodeModule(reactContext);
                }
                break;
            case 1256514152:
                if (name.equals("HeadlessJsTaskSupport")) {
                    return new HeadlessJsTaskSupportModule(reactContext);
                }
                break;
            case 1861242489:
                if (name.equals(UIManagerModule.NAME)) {
                    return createUIManager(reactContext);
                }
                break;
        }
        throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for " + name);
    }

    private final UIManagerModule createUIManager(ReactApplicationContext reactContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        Systrace.beginSection(0L, "createUIManagerModule");
        try {
            if (this.lazyViewManagersEnabled) {
                return new UIManagerModule(reactContext, new ViewManagerResolver() { // from class: com.facebook.react.CoreModulesPackage$createUIManager$resolver$1
                    @Override // com.facebook.react.uimanager.ViewManagerResolver
                    public ViewManager<?, ?> getViewManager(String viewManagerName) {
                        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
                        return this.this$0.reactInstanceManager.createViewManager(viewManagerName);
                    }

                    @Override // com.facebook.react.uimanager.ViewManagerResolver
                    public Collection<String> getViewManagerNames() {
                        Collection<String> viewManagerNames = this.this$0.reactInstanceManager.getViewManagerNames();
                        Intrinsics.checkNotNullExpressionValue(viewManagerNames, "getViewManagerNames(...)");
                        return viewManagerNames;
                    }
                }, this.minTimeLeftInFrameForNonBatchedOperationMs);
            }
            return new UIManagerModule(reactContext, this.reactInstanceManager.getOrCreateViewManagers(reactContext), this.minTimeLeftInFrameForNonBatchedOperationMs);
        } finally {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    @Override // com.facebook.react.ReactPackageLogger
    public void startProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }

    @Override // com.facebook.react.ReactPackageLogger
    public void endProcessPackage() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }

    /* JADX INFO: compiled from: CoreModulesPackage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/facebook/react/CoreModulesPackage$Companion;", "", "<init>", "()V", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("CoreModulesPackage", LegacyArchitectureLogLevel.ERROR);
    }
}
