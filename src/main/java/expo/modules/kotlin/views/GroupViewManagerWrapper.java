package expo.modules.kotlin.views;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ReactStylesDiffMapHelperKt;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupViewManagerWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001eH\u0016J \u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\u0002H\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010\"2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\"H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006)"}, d2 = {"Lexpo/modules/kotlin/views/GroupViewManagerWrapper;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Landroid/view/ViewGroup;", "Lexpo/modules/kotlin/views/ViewWrapperDelegateHolder;", "viewWrapperDelegate", "Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "<init>", "(Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;)V", "getViewWrapperDelegate", "()Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "updateProperties", "", "viewToUpdate", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "onAfterUpdateTransaction", "view", "updateState", "", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getNativeProps", "", "onDropViewInstance", "getExportedCustomDirectEventTypeConstants", "", "addView", "parent", "child", "Landroid/view/View;", "index", "", "getChildCount", "getChildAt", "removeViewAt", "removeView", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupViewManagerWrapper extends ViewGroupManager<ViewGroup> implements ViewWrapperDelegateHolder {
    private final ViewManagerWrapperDelegate viewWrapperDelegate;

    @Override // expo.modules.kotlin.views.ViewWrapperDelegateHolder
    public ViewManagerWrapperDelegate getViewWrapperDelegate() {
        return this.viewWrapperDelegate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupViewManagerWrapper(ViewManagerWrapperDelegate viewWrapperDelegate) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(viewWrapperDelegate, "viewWrapperDelegate");
        this.viewWrapperDelegate = viewWrapperDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ViewManagerAdapter_" + getViewWrapperDelegate().getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        View viewCreateView = getViewWrapperDelegate().createView(reactContext);
        Intrinsics.checkNotNull(viewCreateView, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) viewCreateView;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateProperties(ViewGroup viewToUpdate, ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(viewToUpdate, "viewToUpdate");
        Intrinsics.checkNotNullParameter(props, "props");
        ReadableMap backingMap = ReactStylesDiffMapHelperKt.getBackingMap(props);
        ViewGroup viewGroup = viewToUpdate;
        super.updateProperties(viewGroup, new ReactStylesDiffMap(new FilteredReadableMap(backingMap, getViewWrapperDelegate().updateProperties(viewGroup, backingMap))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup viewGroup = view;
        super.onAfterUpdateTransaction(viewGroup);
        getViewWrapperDelegate().onViewDidUpdateProps(viewGroup);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ViewGroup view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        ExpoView expoView = view instanceof ExpoView ? (ExpoView) view : null;
        if (expoView == null) {
            return null;
        }
        expoView.setStateWrapper(stateWrapper);
        return super.updateState(expoView, props, stateWrapper);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, String> getNativeProps() {
        Map<String, String> nativeProps = super.getNativeProps();
        for (Map.Entry<String, AnyViewProp> entry : getViewWrapperDelegate().getProps().entrySet()) {
            String key = entry.getKey();
            AnyViewProp value = entry.getValue();
            Intrinsics.checkNotNull(nativeProps);
            nativeProps.put(key, String.valueOf(value.getType().getKType().getClassifier()));
        }
        Intrinsics.checkNotNull(nativeProps);
        return nativeProps;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup viewGroup = view;
        super.onDropViewInstance(viewGroup);
        getViewWrapperDelegate().onDestroy(viewGroup);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> mapPlus;
        Map<String, Object> exportedCustomDirectEventTypeConstants = getViewWrapperDelegate().getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = MapsKt.emptyMap();
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants2 = super.getExportedCustomDirectEventTypeConstants();
        return (exportedCustomDirectEventTypeConstants2 == null || (mapPlus = MapsKt.plus(exportedCustomDirectEventTypeConstants2, exportedCustomDirectEventTypeConstants)) == null) ? exportedCustomDirectEventTypeConstants : mapPlus;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public void addView(ViewGroup parent, View child, int index) {
        Unit unit;
        Function3<ViewGroup, View, Integer, Unit> addViewAction;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release == null || (addViewAction = viewGroupDefinition$expo_modules_core_release.getAddViewAction()) == null) {
            unit = null;
        } else {
            addViewAction.invoke(parent, child, Integer.valueOf(index));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.addView(parent, child, index);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public int getChildCount(ViewGroup parent) {
        Function1<ViewGroup, Integer> getChildCountAction;
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        Integer numInvoke = (viewGroupDefinition$expo_modules_core_release == null || (getChildCountAction = viewGroupDefinition$expo_modules_core_release.getGetChildCountAction()) == null) ? null : getChildCountAction.invoke(parent);
        if (numInvoke == null) {
            numInvoke = Integer.valueOf(super.getChildCount(parent));
        }
        return numInvoke.intValue();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public View getChildAt(ViewGroup parent, int index) {
        Function2<ViewGroup, Integer, View> getChildAtAction;
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release != null && (getChildAtAction = viewGroupDefinition$expo_modules_core_release.getGetChildAtAction()) != null) {
            return getChildAtAction.invoke(parent, Integer.valueOf(index));
        }
        return super.getChildAt(parent, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public void removeViewAt(ViewGroup parent, int index) {
        Unit unit;
        Function2<ViewGroup, Integer, Unit> removeViewAtAction;
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release == null || (removeViewAtAction = viewGroupDefinition$expo_modules_core_release.getRemoveViewAtAction()) == null) {
            unit = null;
        } else {
            removeViewAtAction.invoke(parent, Integer.valueOf(index));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.removeViewAt(parent, index);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(ViewGroup parent, View view) {
        Unit unit;
        Function2<ViewGroup, View, Unit> removeViewAction;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroupDefinition viewGroupDefinition$expo_modules_core_release = getViewWrapperDelegate().getViewGroupDefinition$expo_modules_core_release();
        if (viewGroupDefinition$expo_modules_core_release == null || (removeViewAction = viewGroupDefinition$expo_modules_core_release.getRemoveViewAction()) == null) {
            unit = null;
        } else {
            removeViewAction.invoke(parent, view);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.removeView(parent, view);
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
