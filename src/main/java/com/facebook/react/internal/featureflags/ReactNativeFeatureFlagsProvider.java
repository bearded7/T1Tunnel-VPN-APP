package com.facebook.react.internal.featureflags;

import kotlin.Metadata;

/* JADX INFO: compiled from: ReactNativeFeatureFlagsProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\u0006\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\b\u0010\u0005\u001a\u00020\u0003H'J\b\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\u0003H'J\b\u0010\b\u001a\u00020\u0003H'J\b\u0010\t\u001a\u00020\u0003H'J\b\u0010\n\u001a\u00020\u0003H'J\b\u0010\u000b\u001a\u00020\u0003H'J\b\u0010\f\u001a\u00020\u0003H'J\b\u0010\r\u001a\u00020\u0003H'J\b\u0010\u000e\u001a\u00020\u0003H'J\b\u0010\u000f\u001a\u00020\u0003H'J\b\u0010\u0010\u001a\u00020\u0003H'J\b\u0010\u0011\u001a\u00020\u0003H'J\b\u0010\u0012\u001a\u00020\u0003H'J\b\u0010\u0013\u001a\u00020\u0003H'J\b\u0010\u0014\u001a\u00020\u0003H'J\b\u0010\u0015\u001a\u00020\u0003H'J\b\u0010\u0016\u001a\u00020\u0003H'J\b\u0010\u0017\u001a\u00020\u0003H'J\b\u0010\u0018\u001a\u00020\u0003H'J\b\u0010\u0019\u001a\u00020\u0003H'J\b\u0010\u001a\u001a\u00020\u0003H'J\b\u0010\u001b\u001a\u00020\u0003H'J\b\u0010\u001c\u001a\u00020\u0003H'J\b\u0010\u001d\u001a\u00020\u0003H'J\b\u0010\u001e\u001a\u00020\u0003H'J\b\u0010\u001f\u001a\u00020\u0003H'J\b\u0010 \u001a\u00020\u0003H'J\b\u0010!\u001a\u00020\u0003H'J\b\u0010\"\u001a\u00020\u0003H'J\b\u0010#\u001a\u00020\u0003H'J\b\u0010$\u001a\u00020\u0003H'J\b\u0010%\u001a\u00020\u0003H'J\b\u0010&\u001a\u00020\u0003H'J\b\u0010'\u001a\u00020\u0003H'J\b\u0010(\u001a\u00020\u0003H'J\b\u0010)\u001a\u00020\u0003H'J\b\u0010*\u001a\u00020\u0003H'J\b\u0010+\u001a\u00020\u0003H'J\b\u0010,\u001a\u00020\u0003H'J\b\u0010-\u001a\u00020\u0003H'J\b\u0010.\u001a\u00020\u0003H'J\b\u0010/\u001a\u00020\u0003H'J\b\u00100\u001a\u00020\u0003H'J\b\u00101\u001a\u000202H'J\b\u00103\u001a\u00020\u0003H'J\b\u00104\u001a\u00020\u0003H'J\b\u00105\u001a\u00020\u0003H'J\b\u00106\u001a\u00020\u0003H'J\b\u00107\u001a\u00020\u0003H'J\b\u00108\u001a\u00020\u0003H'J\b\u00109\u001a\u00020\u0003H'J\b\u0010:\u001a\u00020\u0003H'J\b\u0010;\u001a\u00020\u0003H'J\b\u0010<\u001a\u00020\u0003H'J\b\u0010=\u001a\u00020\u0003H'J\b\u0010>\u001a\u00020\u0003H'J\b\u0010?\u001a\u00020\u0003H'J\b\u0010@\u001a\u000202H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006AÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsProvider;", "", "commonTestFlag", "", "animatedShouldSignalBatch", "cxxNativeAnimatedEnabled", "cxxNativeAnimatedRemoveJsSync", "disableMainQueueSyncDispatchIOS", "disableMountItemReorderingAndroid", "disableTextLayoutManagerCacheAndroid", "enableAccessibilityOrder", "enableAccumulatedUpdatesInRawPropsAndroid", "enableAndroidTextMeasurementOptimizations", "enableBridgelessArchitecture", "enableCppPropsIteratorSetter", "enableCustomFocusSearchOnClippedElementsAndroid", "enableDestroyShadowTreeRevisionAsync", "enableDoubleMeasurementFixAndroid", "enableEagerRootViewAttachment", "enableFabricLogs", "enableFabricRenderer", "enableFixForParentTagDuringReparenting", "enableFontScaleChangesUpdatingLayout", "enableIOSTextBaselineOffsetPerLine", "enableIOSViewClipToPaddingBox", "enableInteropViewManagerClassLookUpOptimizationIOS", "enableLayoutAnimationsOnAndroid", "enableLayoutAnimationsOnIOS", "enableMainQueueCoordinatorOnIOS", "enableMainQueueModulesOnIOS", "enableModuleArgumentNSNullConversionIOS", "enableNativeCSSParsing", "enableNetworkEventReporting", "enableNewBackgroundAndBorderDrawables", "enablePreparedTextLayout", "enablePropsUpdateReconciliationAndroid", "enableResourceTimingAPI", "enableSynchronousStateUpdates", "enableViewCulling", "enableViewRecycling", "enableViewRecyclingForText", "enableViewRecyclingForView", "enableVirtualViewDebugFeatures", "enableVirtualViewRenderState", "enableVirtualViewWindowFocusDetection", "fixMappingOfEventPrioritiesBetweenFabricAndReact", "fuseboxEnabledRelease", "fuseboxNetworkInspectionEnabled", "hideOffscreenVirtualViewsOnIOS", "preparedTextCacheSize", "", "preventShadowTreeCommitExhaustion", "traceTurboModulePromiseRejectionsOnAndroid", "updateRuntimeShadowNodeReferencesOnCommit", "useAlwaysAvailableJSErrorHandling", "useFabricInterop", "useNativeEqualsInNativeReadableArrayAndroid", "useNativeTransformHelperAndroid", "useNativeViewConfigsInBridgelessMode", "useOptimizedEventBatchingOnAndroid", "useRawPropsJsiValue", "useShadowNodeStateOnClone", "useTurboModuleInterop", "useTurboModules", "virtualViewPrerenderRatio", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReactNativeFeatureFlagsProvider {
    boolean animatedShouldSignalBatch();

    boolean commonTestFlag();

    boolean cxxNativeAnimatedEnabled();

    boolean cxxNativeAnimatedRemoveJsSync();

    boolean disableMainQueueSyncDispatchIOS();

    boolean disableMountItemReorderingAndroid();

    boolean disableTextLayoutManagerCacheAndroid();

    boolean enableAccessibilityOrder();

    boolean enableAccumulatedUpdatesInRawPropsAndroid();

    boolean enableAndroidTextMeasurementOptimizations();

    boolean enableBridgelessArchitecture();

    boolean enableCppPropsIteratorSetter();

    boolean enableCustomFocusSearchOnClippedElementsAndroid();

    boolean enableDestroyShadowTreeRevisionAsync();

    boolean enableDoubleMeasurementFixAndroid();

    boolean enableEagerRootViewAttachment();

    boolean enableFabricLogs();

    boolean enableFabricRenderer();

    boolean enableFixForParentTagDuringReparenting();

    boolean enableFontScaleChangesUpdatingLayout();

    boolean enableIOSTextBaselineOffsetPerLine();

    boolean enableIOSViewClipToPaddingBox();

    boolean enableInteropViewManagerClassLookUpOptimizationIOS();

    boolean enableLayoutAnimationsOnAndroid();

    boolean enableLayoutAnimationsOnIOS();

    boolean enableMainQueueCoordinatorOnIOS();

    boolean enableMainQueueModulesOnIOS();

    boolean enableModuleArgumentNSNullConversionIOS();

    boolean enableNativeCSSParsing();

    boolean enableNetworkEventReporting();

    boolean enableNewBackgroundAndBorderDrawables();

    boolean enablePreparedTextLayout();

    boolean enablePropsUpdateReconciliationAndroid();

    boolean enableResourceTimingAPI();

    boolean enableSynchronousStateUpdates();

    boolean enableViewCulling();

    boolean enableViewRecycling();

    boolean enableViewRecyclingForText();

    boolean enableViewRecyclingForView();

    boolean enableVirtualViewDebugFeatures();

    boolean enableVirtualViewRenderState();

    boolean enableVirtualViewWindowFocusDetection();

    boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    boolean fuseboxEnabledRelease();

    boolean fuseboxNetworkInspectionEnabled();

    boolean hideOffscreenVirtualViewsOnIOS();

    double preparedTextCacheSize();

    boolean preventShadowTreeCommitExhaustion();

    boolean traceTurboModulePromiseRejectionsOnAndroid();

    boolean updateRuntimeShadowNodeReferencesOnCommit();

    boolean useAlwaysAvailableJSErrorHandling();

    boolean useFabricInterop();

    boolean useNativeEqualsInNativeReadableArrayAndroid();

    boolean useNativeTransformHelperAndroid();

    boolean useNativeViewConfigsInBridgelessMode();

    boolean useOptimizedEventBatchingOnAndroid();

    boolean useRawPropsJsiValue();

    boolean useShadowNodeStateOnClone();

    boolean useTurboModuleInterop();

    boolean useTurboModules();

    double virtualViewPrerenderRatio();
}
