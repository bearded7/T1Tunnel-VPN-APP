package com.facebook.react.internal.featureflags;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeFeatureFlagsLocalAccessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\u0006\n\u0002\bM\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010J\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020\nH\u0016J\b\u0010L\u001a\u00020\nH\u0016J\b\u0010M\u001a\u00020\nH\u0016J\b\u0010N\u001a\u00020\nH\u0016J\b\u0010O\u001a\u00020\nH\u0016J\b\u0010P\u001a\u00020\nH\u0016J\b\u0010Q\u001a\u00020\nH\u0016J\b\u0010R\u001a\u00020\nH\u0016J\b\u0010S\u001a\u00020\nH\u0016J\b\u0010T\u001a\u00020\nH\u0016J\b\u0010U\u001a\u00020\nH\u0016J\b\u0010V\u001a\u00020\nH\u0016J\b\u0010W\u001a\u00020\nH\u0016J\b\u0010X\u001a\u00020\nH\u0016J\b\u0010Y\u001a\u00020\nH\u0016J\b\u0010Z\u001a\u00020\nH\u0016J\b\u0010[\u001a\u00020\nH\u0016J\b\u0010\\\u001a\u00020\nH\u0016J\b\u0010]\u001a\u00020\nH\u0016J\b\u0010^\u001a\u00020\nH\u0016J\b\u0010_\u001a\u00020\nH\u0016J\b\u0010`\u001a\u00020\nH\u0016J\b\u0010a\u001a\u00020\nH\u0016J\b\u0010b\u001a\u00020\nH\u0016J\b\u0010c\u001a\u00020\nH\u0016J\b\u0010d\u001a\u00020\nH\u0016J\b\u0010e\u001a\u00020\nH\u0016J\b\u0010f\u001a\u00020\nH\u0016J\b\u0010g\u001a\u00020\nH\u0016J\b\u0010h\u001a\u00020\nH\u0016J\b\u0010i\u001a\u00020\nH\u0016J\b\u0010j\u001a\u00020\nH\u0016J\b\u0010k\u001a\u00020\nH\u0016J\b\u0010l\u001a\u00020\nH\u0016J\b\u0010m\u001a\u00020\nH\u0016J\b\u0010n\u001a\u00020\nH\u0016J\b\u0010o\u001a\u00020\nH\u0016J\b\u0010p\u001a\u00020\nH\u0016J\b\u0010q\u001a\u00020\nH\u0016J\b\u0010r\u001a\u00020\nH\u0016J\b\u0010s\u001a\u00020\nH\u0016J\b\u0010t\u001a\u00020\nH\u0016J\b\u0010u\u001a\u00020\nH\u0016J\b\u0010v\u001a\u00020\nH\u0016J\b\u0010w\u001a\u00020\nH\u0016J\b\u0010x\u001a\u00020:H\u0016J\b\u0010y\u001a\u00020\nH\u0016J\b\u0010z\u001a\u00020\nH\u0016J\b\u0010{\u001a\u00020\nH\u0016J\b\u0010|\u001a\u00020\nH\u0016J\b\u0010}\u001a\u00020\nH\u0016J\b\u0010~\u001a\u00020\nH\u0016J\b\u0010\u007f\u001a\u00020\nH\u0016J\t\u0010\u0080\u0001\u001a\u00020\nH\u0016J\t\u0010\u0081\u0001\u001a\u00020\nH\u0016J\t\u0010\u0082\u0001\u001a\u00020\nH\u0016J\t\u0010\u0083\u0001\u001a\u00020\nH\u0016J\t\u0010\u0084\u0001\u001a\u00020\nH\u0016J\t\u0010\u0085\u0001\u001a\u00020\nH\u0016J\t\u0010\u0086\u0001\u001a\u00020:H\u0016J\u0013\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0005H\u0016J\n\u0010\u008a\u0001\u001a\u00030\u0088\u0001H\u0016J\u0014\u0010\u008b\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010\u0089\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0003\b\u008d\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0017\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010 \u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010!\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\"\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010#\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010%\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010&\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010'\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010(\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010)\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010*\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010+\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010,\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010-\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010.\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010/\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00100\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00101\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00102\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00103\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00104\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00105\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00106\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00107\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00108\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010;R\u0012\u0010<\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010=\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010>\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010?\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010@\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010A\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010B\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010C\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010D\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010E\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010F\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010G\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010H\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010I\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0004\n\u0002\u0010;¨\u0006\u008e\u0001"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsLocalAccessor;", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsAccessor;", "<init>", "()V", "currentProvider", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsProvider;", "accessedFeatureFlags", "", "", "commonTestFlagCache", "", "Ljava/lang/Boolean;", "animatedShouldSignalBatchCache", "cxxNativeAnimatedEnabledCache", "cxxNativeAnimatedRemoveJsSyncCache", "disableMainQueueSyncDispatchIOSCache", "disableMountItemReorderingAndroidCache", "disableTextLayoutManagerCacheAndroidCache", "enableAccessibilityOrderCache", "enableAccumulatedUpdatesInRawPropsAndroidCache", "enableAndroidTextMeasurementOptimizationsCache", "enableBridgelessArchitectureCache", "enableCppPropsIteratorSetterCache", "enableCustomFocusSearchOnClippedElementsAndroidCache", "enableDestroyShadowTreeRevisionAsyncCache", "enableDoubleMeasurementFixAndroidCache", "enableEagerRootViewAttachmentCache", "enableFabricLogsCache", "enableFabricRendererCache", "enableFixForParentTagDuringReparentingCache", "enableFontScaleChangesUpdatingLayoutCache", "enableIOSTextBaselineOffsetPerLineCache", "enableIOSViewClipToPaddingBoxCache", "enableInteropViewManagerClassLookUpOptimizationIOSCache", "enableLayoutAnimationsOnAndroidCache", "enableLayoutAnimationsOnIOSCache", "enableMainQueueCoordinatorOnIOSCache", "enableMainQueueModulesOnIOSCache", "enableModuleArgumentNSNullConversionIOSCache", "enableNativeCSSParsingCache", "enableNetworkEventReportingCache", "enableNewBackgroundAndBorderDrawablesCache", "enablePreparedTextLayoutCache", "enablePropsUpdateReconciliationAndroidCache", "enableResourceTimingAPICache", "enableSynchronousStateUpdatesCache", "enableViewCullingCache", "enableViewRecyclingCache", "enableViewRecyclingForTextCache", "enableViewRecyclingForViewCache", "enableVirtualViewDebugFeaturesCache", "enableVirtualViewRenderStateCache", "enableVirtualViewWindowFocusDetectionCache", "fixMappingOfEventPrioritiesBetweenFabricAndReactCache", "fuseboxEnabledReleaseCache", "fuseboxNetworkInspectionEnabledCache", "hideOffscreenVirtualViewsOnIOSCache", "preparedTextCacheSizeCache", "", "Ljava/lang/Double;", "preventShadowTreeCommitExhaustionCache", "traceTurboModulePromiseRejectionsOnAndroidCache", "updateRuntimeShadowNodeReferencesOnCommitCache", "useAlwaysAvailableJSErrorHandlingCache", "useFabricInteropCache", "useNativeEqualsInNativeReadableArrayAndroidCache", "useNativeTransformHelperAndroidCache", "useNativeViewConfigsInBridgelessModeCache", "useOptimizedEventBatchingOnAndroidCache", "useRawPropsJsiValueCache", "useShadowNodeStateOnCloneCache", "useTurboModuleInteropCache", "useTurboModulesCache", "virtualViewPrerenderRatioCache", "commonTestFlag", "animatedShouldSignalBatch", "cxxNativeAnimatedEnabled", "cxxNativeAnimatedRemoveJsSync", "disableMainQueueSyncDispatchIOS", "disableMountItemReorderingAndroid", "disableTextLayoutManagerCacheAndroid", "enableAccessibilityOrder", "enableAccumulatedUpdatesInRawPropsAndroid", "enableAndroidTextMeasurementOptimizations", "enableBridgelessArchitecture", "enableCppPropsIteratorSetter", "enableCustomFocusSearchOnClippedElementsAndroid", "enableDestroyShadowTreeRevisionAsync", "enableDoubleMeasurementFixAndroid", "enableEagerRootViewAttachment", "enableFabricLogs", "enableFabricRenderer", "enableFixForParentTagDuringReparenting", "enableFontScaleChangesUpdatingLayout", "enableIOSTextBaselineOffsetPerLine", "enableIOSViewClipToPaddingBox", "enableInteropViewManagerClassLookUpOptimizationIOS", "enableLayoutAnimationsOnAndroid", "enableLayoutAnimationsOnIOS", "enableMainQueueCoordinatorOnIOS", "enableMainQueueModulesOnIOS", "enableModuleArgumentNSNullConversionIOS", "enableNativeCSSParsing", "enableNetworkEventReporting", "enableNewBackgroundAndBorderDrawables", "enablePreparedTextLayout", "enablePropsUpdateReconciliationAndroid", "enableResourceTimingAPI", "enableSynchronousStateUpdates", "enableViewCulling", "enableViewRecycling", "enableViewRecyclingForText", "enableViewRecyclingForView", "enableVirtualViewDebugFeatures", "enableVirtualViewRenderState", "enableVirtualViewWindowFocusDetection", "fixMappingOfEventPrioritiesBetweenFabricAndReact", "fuseboxEnabledRelease", "fuseboxNetworkInspectionEnabled", "hideOffscreenVirtualViewsOnIOS", "preparedTextCacheSize", "preventShadowTreeCommitExhaustion", "traceTurboModulePromiseRejectionsOnAndroid", "updateRuntimeShadowNodeReferencesOnCommit", "useAlwaysAvailableJSErrorHandling", "useFabricInterop", "useNativeEqualsInNativeReadableArrayAndroid", "useNativeTransformHelperAndroid", "useNativeViewConfigsInBridgelessMode", "useOptimizedEventBatchingOnAndroid", "useRawPropsJsiValue", "useShadowNodeStateOnClone", "useTurboModuleInterop", "useTurboModules", "virtualViewPrerenderRatio", "override", "", "provider", "dangerouslyReset", "dangerouslyForceOverride", "getAccessedFeatureFlags", "getAccessedFeatureFlags$ReactAndroid_release", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeFeatureFlagsLocalAccessor implements ReactNativeFeatureFlagsAccessor {
    private Boolean animatedShouldSignalBatchCache;
    private Boolean commonTestFlagCache;
    private Boolean cxxNativeAnimatedEnabledCache;
    private Boolean cxxNativeAnimatedRemoveJsSyncCache;
    private Boolean disableMainQueueSyncDispatchIOSCache;
    private Boolean disableMountItemReorderingAndroidCache;
    private Boolean disableTextLayoutManagerCacheAndroidCache;
    private Boolean enableAccessibilityOrderCache;
    private Boolean enableAccumulatedUpdatesInRawPropsAndroidCache;
    private Boolean enableAndroidTextMeasurementOptimizationsCache;
    private Boolean enableBridgelessArchitectureCache;
    private Boolean enableCppPropsIteratorSetterCache;
    private Boolean enableCustomFocusSearchOnClippedElementsAndroidCache;
    private Boolean enableDestroyShadowTreeRevisionAsyncCache;
    private Boolean enableDoubleMeasurementFixAndroidCache;
    private Boolean enableEagerRootViewAttachmentCache;
    private Boolean enableFabricLogsCache;
    private Boolean enableFabricRendererCache;
    private Boolean enableFixForParentTagDuringReparentingCache;
    private Boolean enableFontScaleChangesUpdatingLayoutCache;
    private Boolean enableIOSTextBaselineOffsetPerLineCache;
    private Boolean enableIOSViewClipToPaddingBoxCache;
    private Boolean enableInteropViewManagerClassLookUpOptimizationIOSCache;
    private Boolean enableLayoutAnimationsOnAndroidCache;
    private Boolean enableLayoutAnimationsOnIOSCache;
    private Boolean enableMainQueueCoordinatorOnIOSCache;
    private Boolean enableMainQueueModulesOnIOSCache;
    private Boolean enableModuleArgumentNSNullConversionIOSCache;
    private Boolean enableNativeCSSParsingCache;
    private Boolean enableNetworkEventReportingCache;
    private Boolean enableNewBackgroundAndBorderDrawablesCache;
    private Boolean enablePreparedTextLayoutCache;
    private Boolean enablePropsUpdateReconciliationAndroidCache;
    private Boolean enableResourceTimingAPICache;
    private Boolean enableSynchronousStateUpdatesCache;
    private Boolean enableViewCullingCache;
    private Boolean enableViewRecyclingCache;
    private Boolean enableViewRecyclingForTextCache;
    private Boolean enableViewRecyclingForViewCache;
    private Boolean enableVirtualViewDebugFeaturesCache;
    private Boolean enableVirtualViewRenderStateCache;
    private Boolean enableVirtualViewWindowFocusDetectionCache;
    private Boolean fixMappingOfEventPrioritiesBetweenFabricAndReactCache;
    private Boolean fuseboxEnabledReleaseCache;
    private Boolean fuseboxNetworkInspectionEnabledCache;
    private Boolean hideOffscreenVirtualViewsOnIOSCache;
    private Double preparedTextCacheSizeCache;
    private Boolean preventShadowTreeCommitExhaustionCache;
    private Boolean traceTurboModulePromiseRejectionsOnAndroidCache;
    private Boolean updateRuntimeShadowNodeReferencesOnCommitCache;
    private Boolean useAlwaysAvailableJSErrorHandlingCache;
    private Boolean useFabricInteropCache;
    private Boolean useNativeEqualsInNativeReadableArrayAndroidCache;
    private Boolean useNativeTransformHelperAndroidCache;
    private Boolean useNativeViewConfigsInBridgelessModeCache;
    private Boolean useOptimizedEventBatchingOnAndroidCache;
    private Boolean useRawPropsJsiValueCache;
    private Boolean useShadowNodeStateOnCloneCache;
    private Boolean useTurboModuleInteropCache;
    private Boolean useTurboModulesCache;
    private Double virtualViewPrerenderRatioCache;
    private ReactNativeFeatureFlagsProvider currentProvider = new ReactNativeFeatureFlagsDefaults();
    private final Set<String> accessedFeatureFlags = new LinkedHashSet();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor
    public void dangerouslyReset() {
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean commonTestFlag() {
        Boolean boolValueOf = this.commonTestFlagCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.commonTestFlag());
            this.accessedFeatureFlags.add("commonTestFlag");
            this.commonTestFlagCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean animatedShouldSignalBatch() {
        Boolean boolValueOf = this.animatedShouldSignalBatchCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.animatedShouldSignalBatch());
            this.accessedFeatureFlags.add("animatedShouldSignalBatch");
            this.animatedShouldSignalBatchCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cxxNativeAnimatedEnabled() {
        Boolean boolValueOf = this.cxxNativeAnimatedEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.cxxNativeAnimatedEnabled());
            this.accessedFeatureFlags.add("cxxNativeAnimatedEnabled");
            this.cxxNativeAnimatedEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean cxxNativeAnimatedRemoveJsSync() {
        Boolean boolValueOf = this.cxxNativeAnimatedRemoveJsSyncCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.cxxNativeAnimatedRemoveJsSync());
            this.accessedFeatureFlags.add("cxxNativeAnimatedRemoveJsSync");
            this.cxxNativeAnimatedRemoveJsSyncCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableMainQueueSyncDispatchIOS() {
        Boolean boolValueOf = this.disableMainQueueSyncDispatchIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.disableMainQueueSyncDispatchIOS());
            this.accessedFeatureFlags.add("disableMainQueueSyncDispatchIOS");
            this.disableMainQueueSyncDispatchIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableMountItemReorderingAndroid() {
        Boolean boolValueOf = this.disableMountItemReorderingAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.disableMountItemReorderingAndroid());
            this.accessedFeatureFlags.add("disableMountItemReorderingAndroid");
            this.disableMountItemReorderingAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean disableTextLayoutManagerCacheAndroid() {
        Boolean boolValueOf = this.disableTextLayoutManagerCacheAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.disableTextLayoutManagerCacheAndroid());
            this.accessedFeatureFlags.add("disableTextLayoutManagerCacheAndroid");
            this.disableTextLayoutManagerCacheAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAccessibilityOrder() {
        Boolean boolValueOf = this.enableAccessibilityOrderCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableAccessibilityOrder());
            this.accessedFeatureFlags.add("enableAccessibilityOrder");
            this.enableAccessibilityOrderCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAccumulatedUpdatesInRawPropsAndroid() {
        Boolean boolValueOf = this.enableAccumulatedUpdatesInRawPropsAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableAccumulatedUpdatesInRawPropsAndroid());
            this.accessedFeatureFlags.add("enableAccumulatedUpdatesInRawPropsAndroid");
            this.enableAccumulatedUpdatesInRawPropsAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableAndroidTextMeasurementOptimizations() {
        Boolean boolValueOf = this.enableAndroidTextMeasurementOptimizationsCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableAndroidTextMeasurementOptimizations());
            this.accessedFeatureFlags.add("enableAndroidTextMeasurementOptimizations");
            this.enableAndroidTextMeasurementOptimizationsCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    /* JADX INFO: renamed from: enableBridgelessArchitecture */
    public boolean getNewArchitectureEnabled() {
        Boolean boolValueOf = this.enableBridgelessArchitectureCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.getNewArchitectureEnabled());
            this.accessedFeatureFlags.add("enableBridgelessArchitecture");
            this.enableBridgelessArchitectureCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableCppPropsIteratorSetter() {
        Boolean boolValueOf = this.enableCppPropsIteratorSetterCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableCppPropsIteratorSetter());
            this.accessedFeatureFlags.add("enableCppPropsIteratorSetter");
            this.enableCppPropsIteratorSetterCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableCustomFocusSearchOnClippedElementsAndroid() {
        Boolean boolValueOf = this.enableCustomFocusSearchOnClippedElementsAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableCustomFocusSearchOnClippedElementsAndroid());
            this.accessedFeatureFlags.add("enableCustomFocusSearchOnClippedElementsAndroid");
            this.enableCustomFocusSearchOnClippedElementsAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableDestroyShadowTreeRevisionAsync() {
        Boolean boolValueOf = this.enableDestroyShadowTreeRevisionAsyncCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableDestroyShadowTreeRevisionAsync());
            this.accessedFeatureFlags.add("enableDestroyShadowTreeRevisionAsync");
            this.enableDestroyShadowTreeRevisionAsyncCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableDoubleMeasurementFixAndroid() {
        Boolean boolValueOf = this.enableDoubleMeasurementFixAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableDoubleMeasurementFixAndroid());
            this.accessedFeatureFlags.add("enableDoubleMeasurementFixAndroid");
            this.enableDoubleMeasurementFixAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableEagerRootViewAttachment() {
        Boolean boolValueOf = this.enableEagerRootViewAttachmentCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableEagerRootViewAttachment());
            this.accessedFeatureFlags.add("enableEagerRootViewAttachment");
            this.enableEagerRootViewAttachmentCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricLogs() {
        Boolean boolValueOf = this.enableFabricLogsCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableFabricLogs());
            this.accessedFeatureFlags.add("enableFabricLogs");
            this.enableFabricLogsCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricRenderer() {
        Boolean boolValueOf = this.enableFabricRendererCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableFabricRenderer());
            this.accessedFeatureFlags.add("enableFabricRenderer");
            this.enableFabricRendererCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFixForParentTagDuringReparenting() {
        Boolean boolValueOf = this.enableFixForParentTagDuringReparentingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableFixForParentTagDuringReparenting());
            this.accessedFeatureFlags.add("enableFixForParentTagDuringReparenting");
            this.enableFixForParentTagDuringReparentingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFontScaleChangesUpdatingLayout() {
        Boolean boolValueOf = this.enableFontScaleChangesUpdatingLayoutCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableFontScaleChangesUpdatingLayout());
            this.accessedFeatureFlags.add("enableFontScaleChangesUpdatingLayout");
            this.enableFontScaleChangesUpdatingLayoutCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIOSTextBaselineOffsetPerLine() {
        Boolean boolValueOf = this.enableIOSTextBaselineOffsetPerLineCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableIOSTextBaselineOffsetPerLine());
            this.accessedFeatureFlags.add("enableIOSTextBaselineOffsetPerLine");
            this.enableIOSTextBaselineOffsetPerLineCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableIOSViewClipToPaddingBox() {
        Boolean boolValueOf = this.enableIOSViewClipToPaddingBoxCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableIOSViewClipToPaddingBox());
            this.accessedFeatureFlags.add("enableIOSViewClipToPaddingBox");
            this.enableIOSViewClipToPaddingBoxCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableInteropViewManagerClassLookUpOptimizationIOS() {
        Boolean boolValueOf = this.enableInteropViewManagerClassLookUpOptimizationIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableInteropViewManagerClassLookUpOptimizationIOS());
            this.accessedFeatureFlags.add("enableInteropViewManagerClassLookUpOptimizationIOS");
            this.enableInteropViewManagerClassLookUpOptimizationIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableLayoutAnimationsOnAndroid() {
        Boolean boolValueOf = this.enableLayoutAnimationsOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableLayoutAnimationsOnAndroid());
            this.accessedFeatureFlags.add("enableLayoutAnimationsOnAndroid");
            this.enableLayoutAnimationsOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableLayoutAnimationsOnIOS() {
        Boolean boolValueOf = this.enableLayoutAnimationsOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableLayoutAnimationsOnIOS());
            this.accessedFeatureFlags.add("enableLayoutAnimationsOnIOS");
            this.enableLayoutAnimationsOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMainQueueCoordinatorOnIOS() {
        Boolean boolValueOf = this.enableMainQueueCoordinatorOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableMainQueueCoordinatorOnIOS());
            this.accessedFeatureFlags.add("enableMainQueueCoordinatorOnIOS");
            this.enableMainQueueCoordinatorOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableMainQueueModulesOnIOS() {
        Boolean boolValueOf = this.enableMainQueueModulesOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableMainQueueModulesOnIOS());
            this.accessedFeatureFlags.add("enableMainQueueModulesOnIOS");
            this.enableMainQueueModulesOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableModuleArgumentNSNullConversionIOS() {
        Boolean boolValueOf = this.enableModuleArgumentNSNullConversionIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableModuleArgumentNSNullConversionIOS());
            this.accessedFeatureFlags.add("enableModuleArgumentNSNullConversionIOS");
            this.enableModuleArgumentNSNullConversionIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableNativeCSSParsing() {
        Boolean boolValueOf = this.enableNativeCSSParsingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableNativeCSSParsing());
            this.accessedFeatureFlags.add("enableNativeCSSParsing");
            this.enableNativeCSSParsingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableNetworkEventReporting() {
        Boolean boolValueOf = this.enableNetworkEventReportingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableNetworkEventReporting());
            this.accessedFeatureFlags.add("enableNetworkEventReporting");
            this.enableNetworkEventReportingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableNewBackgroundAndBorderDrawables() {
        Boolean boolValueOf = this.enableNewBackgroundAndBorderDrawablesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableNewBackgroundAndBorderDrawables());
            this.accessedFeatureFlags.add("enableNewBackgroundAndBorderDrawables");
            this.enableNewBackgroundAndBorderDrawablesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enablePreparedTextLayout() {
        Boolean boolValueOf = this.enablePreparedTextLayoutCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enablePreparedTextLayout());
            this.accessedFeatureFlags.add("enablePreparedTextLayout");
            this.enablePreparedTextLayoutCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enablePropsUpdateReconciliationAndroid() {
        Boolean boolValueOf = this.enablePropsUpdateReconciliationAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enablePropsUpdateReconciliationAndroid());
            this.accessedFeatureFlags.add("enablePropsUpdateReconciliationAndroid");
            this.enablePropsUpdateReconciliationAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableResourceTimingAPI() {
        Boolean boolValueOf = this.enableResourceTimingAPICache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableResourceTimingAPI());
            this.accessedFeatureFlags.add("enableResourceTimingAPI");
            this.enableResourceTimingAPICache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableSynchronousStateUpdates() {
        Boolean boolValueOf = this.enableSynchronousStateUpdatesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableSynchronousStateUpdates());
            this.accessedFeatureFlags.add("enableSynchronousStateUpdates");
            this.enableSynchronousStateUpdatesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewCulling() {
        Boolean boolValueOf = this.enableViewCullingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableViewCulling());
            this.accessedFeatureFlags.add("enableViewCulling");
            this.enableViewCullingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecycling() {
        Boolean boolValueOf = this.enableViewRecyclingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableViewRecycling());
            this.accessedFeatureFlags.add("enableViewRecycling");
            this.enableViewRecyclingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForText() {
        Boolean boolValueOf = this.enableViewRecyclingForTextCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableViewRecyclingForText());
            this.accessedFeatureFlags.add("enableViewRecyclingForText");
            this.enableViewRecyclingForTextCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableViewRecyclingForView() {
        Boolean boolValueOf = this.enableViewRecyclingForViewCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableViewRecyclingForView());
            this.accessedFeatureFlags.add("enableViewRecyclingForView");
            this.enableViewRecyclingForViewCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewDebugFeatures() {
        Boolean boolValueOf = this.enableVirtualViewDebugFeaturesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableVirtualViewDebugFeatures());
            this.accessedFeatureFlags.add("enableVirtualViewDebugFeatures");
            this.enableVirtualViewDebugFeaturesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewRenderState() {
        Boolean boolValueOf = this.enableVirtualViewRenderStateCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableVirtualViewRenderState());
            this.accessedFeatureFlags.add("enableVirtualViewRenderState");
            this.enableVirtualViewRenderStateCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableVirtualViewWindowFocusDetection() {
        Boolean boolValueOf = this.enableVirtualViewWindowFocusDetectionCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.enableVirtualViewWindowFocusDetection());
            this.accessedFeatureFlags.add("enableVirtualViewWindowFocusDetection");
            this.enableVirtualViewWindowFocusDetectionCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fixMappingOfEventPrioritiesBetweenFabricAndReact() {
        Boolean boolValueOf = this.fixMappingOfEventPrioritiesBetweenFabricAndReactCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.fixMappingOfEventPrioritiesBetweenFabricAndReact());
            this.accessedFeatureFlags.add("fixMappingOfEventPrioritiesBetweenFabricAndReact");
            this.fixMappingOfEventPrioritiesBetweenFabricAndReactCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxEnabledRelease() {
        Boolean boolValueOf = this.fuseboxEnabledReleaseCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.fuseboxEnabledRelease());
            this.accessedFeatureFlags.add("fuseboxEnabledRelease");
            this.fuseboxEnabledReleaseCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean fuseboxNetworkInspectionEnabled() {
        Boolean boolValueOf = this.fuseboxNetworkInspectionEnabledCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.fuseboxNetworkInspectionEnabled());
            this.accessedFeatureFlags.add("fuseboxNetworkInspectionEnabled");
            this.fuseboxNetworkInspectionEnabledCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean hideOffscreenVirtualViewsOnIOS() {
        Boolean boolValueOf = this.hideOffscreenVirtualViewsOnIOSCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.hideOffscreenVirtualViewsOnIOS());
            this.accessedFeatureFlags.add("hideOffscreenVirtualViewsOnIOS");
            this.hideOffscreenVirtualViewsOnIOSCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double preparedTextCacheSize() {
        Double dValueOf = this.preparedTextCacheSizeCache;
        if (dValueOf == null) {
            dValueOf = Double.valueOf(this.currentProvider.preparedTextCacheSize());
            this.accessedFeatureFlags.add("preparedTextCacheSize");
            this.preparedTextCacheSizeCache = dValueOf;
        }
        return dValueOf.doubleValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean preventShadowTreeCommitExhaustion() {
        Boolean boolValueOf = this.preventShadowTreeCommitExhaustionCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.preventShadowTreeCommitExhaustion());
            this.accessedFeatureFlags.add("preventShadowTreeCommitExhaustion");
            this.preventShadowTreeCommitExhaustionCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean traceTurboModulePromiseRejectionsOnAndroid() {
        Boolean boolValueOf = this.traceTurboModulePromiseRejectionsOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.traceTurboModulePromiseRejectionsOnAndroid());
            this.accessedFeatureFlags.add("traceTurboModulePromiseRejectionsOnAndroid");
            this.traceTurboModulePromiseRejectionsOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean updateRuntimeShadowNodeReferencesOnCommit() {
        Boolean boolValueOf = this.updateRuntimeShadowNodeReferencesOnCommitCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.updateRuntimeShadowNodeReferencesOnCommit());
            this.accessedFeatureFlags.add("updateRuntimeShadowNodeReferencesOnCommit");
            this.updateRuntimeShadowNodeReferencesOnCommitCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useAlwaysAvailableJSErrorHandling() {
        Boolean boolValueOf = this.useAlwaysAvailableJSErrorHandlingCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useAlwaysAvailableJSErrorHandling());
            this.accessedFeatureFlags.add("useAlwaysAvailableJSErrorHandling");
            this.useAlwaysAvailableJSErrorHandlingCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useFabricInterop() {
        Boolean boolValueOf = this.useFabricInteropCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useFabricInterop());
            this.accessedFeatureFlags.add("useFabricInterop");
            this.useFabricInteropCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeEqualsInNativeReadableArrayAndroid() {
        Boolean boolValueOf = this.useNativeEqualsInNativeReadableArrayAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useNativeEqualsInNativeReadableArrayAndroid());
            this.accessedFeatureFlags.add("useNativeEqualsInNativeReadableArrayAndroid");
            this.useNativeEqualsInNativeReadableArrayAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeTransformHelperAndroid() {
        Boolean boolValueOf = this.useNativeTransformHelperAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useNativeTransformHelperAndroid());
            this.accessedFeatureFlags.add("useNativeTransformHelperAndroid");
            this.useNativeTransformHelperAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useNativeViewConfigsInBridgelessMode() {
        Boolean boolValueOf = this.useNativeViewConfigsInBridgelessModeCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useNativeViewConfigsInBridgelessMode());
            this.accessedFeatureFlags.add("useNativeViewConfigsInBridgelessMode");
            this.useNativeViewConfigsInBridgelessModeCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useOptimizedEventBatchingOnAndroid() {
        Boolean boolValueOf = this.useOptimizedEventBatchingOnAndroidCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useOptimizedEventBatchingOnAndroid());
            this.accessedFeatureFlags.add("useOptimizedEventBatchingOnAndroid");
            this.useOptimizedEventBatchingOnAndroidCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useRawPropsJsiValue() {
        Boolean boolValueOf = this.useRawPropsJsiValueCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useRawPropsJsiValue());
            this.accessedFeatureFlags.add("useRawPropsJsiValue");
            this.useRawPropsJsiValueCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useShadowNodeStateOnClone() {
        Boolean boolValueOf = this.useShadowNodeStateOnCloneCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useShadowNodeStateOnClone());
            this.accessedFeatureFlags.add("useShadowNodeStateOnClone");
            this.useShadowNodeStateOnCloneCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModuleInterop() {
        Boolean boolValueOf = this.useTurboModuleInteropCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useTurboModuleInterop());
            this.accessedFeatureFlags.add("useTurboModuleInterop");
            this.useTurboModuleInteropCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModules() {
        Boolean boolValueOf = this.useTurboModulesCache;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(this.currentProvider.useTurboModules());
            this.accessedFeatureFlags.add("useTurboModules");
            this.useTurboModulesCache = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public double virtualViewPrerenderRatio() {
        Double dValueOf = this.virtualViewPrerenderRatioCache;
        if (dValueOf == null) {
            dValueOf = Double.valueOf(this.currentProvider.virtualViewPrerenderRatio());
            this.accessedFeatureFlags.add("virtualViewPrerenderRatio");
            this.virtualViewPrerenderRatioCache = dValueOf;
        }
        return dValueOf.doubleValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor
    public void override(ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (!this.accessedFeatureFlags.isEmpty()) {
            throw new IllegalStateException("Feature flags were accessed before being overridden: " + CollectionsKt.joinToString$default(this.accessedFeatureFlags, ", ", null, null, 0, null, new Function1() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsLocalAccessor$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ReactNativeFeatureFlagsLocalAccessor.override$lambda$0((String) obj);
                }
            }, 30, null));
        }
        this.currentProvider = provider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence override$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor
    public String dangerouslyForceOverride(ReactNativeFeatureFlagsProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        String accessedFeatureFlags$ReactAndroid_release = getAccessedFeatureFlags$ReactAndroid_release();
        this.currentProvider = provider;
        return accessedFeatureFlags$ReactAndroid_release;
    }

    public final String getAccessedFeatureFlags$ReactAndroid_release() {
        if (this.accessedFeatureFlags.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(this.accessedFeatureFlags, ", ", null, null, 0, null, new Function1() { // from class: com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsLocalAccessor$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactNativeFeatureFlagsLocalAccessor.getAccessedFeatureFlags$lambda$1((String) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getAccessedFeatureFlags$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }
}
