package com.swmansion.rnscreens.gamma.tabs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import coil3.ComponentRegistry;
import coil3.Image;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.SuccessResult;
import coil3.svg.SvgDecoder;
import coil3.target.Target;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.dialog.AlertFragment;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface;
import com.swmansion.rnscreens.gamma.helpers.EventHelpersKt;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabScreenWillDisappearEvent;
import com.swmansion.rnscreens.utils.RNSLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TabScreenViewManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0002DEB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H\u0014J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0002H\u0014J\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0016J\u001f\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010$H\u0017¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010'\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010(H\u0016J\u001c\u0010)\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010*\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010(H\u0016J\u001c\u0010+\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020-H\u0017J\u001a\u0010.\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0017J\u001a\u0010/\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0017J\u001a\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0017J\u001a\u00101\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010(H\u0016J\u0018\u00102\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010 \u001a\u00020-H\u0016J\u001f\u00103\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010$H\u0017¢\u0006\u0002\u0010%J\u001a\u00104\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0017J\u001a\u00105\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u001a\u00106\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u001a\u00107\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010(H\u0017J;\u00108\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u0002092\u0006\u0010:\u001a\u00020;2!\u0010<\u001a\u001d\u0012\u0013\u0012\u00110>¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u001d0=H\u0002J\u001a\u0010B\u001a\u0004\u0018\u00010;2\u0006\u0010\u0010\u001a\u0002092\u0006\u0010C\u001a\u00020\tH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006F"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;", "Lcom/facebook/react/viewmanagers/RNSBottomTabsScreenManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "imageLoader", "Lcoil3/ImageLoader;", "getImageLoader", "()Lcoil3/ImageLoader;", "setImageLoader", "(Lcoil3/ImageLoader;)V", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "setContext", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "createViewInstance", "reactContext", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "addEventEmitters", "", "view", "setStandardAppearance", "value", "Lcom/facebook/react/bridge/Dynamic;", "setScrollEdgeAppearance", "setTabBarItemBadgeBackgroundColor", "", "(Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;Ljava/lang/Integer;)V", "setIconType", "setIconImageSource", "Lcom/facebook/react/bridge/ReadableMap;", "setIconSfSymbolName", "setSelectedIconImageSource", "setSelectedIconSfSymbolName", "setIsFocused", "", "setTabKey", "setBadgeValue", "setTitle", "setSpecialEffects", "setOverrideScrollViewContentInsetAdjustmentBehavior", "setTabBarItemBadgeTextColor", "setIconResourceName", "setOrientation", "setSystemItem", "setIconResource", "loadUsingCoil", "Landroid/content/Context;", "source", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource;", "onLoad", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "img", "resolveSource", "uri", "RNSImageSource", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ReactModule(name = TabScreenViewManager.REACT_CLASS)
public final class TabScreenViewManager extends ViewGroupManager<TabScreen> implements RNSBottomTabsScreenManagerInterface<TabScreen> {
    public static final String REACT_CLASS = "RNSBottomTabsScreen";
    private ThemedReactContext context;
    private final ViewManagerDelegate<TabScreen> delegate;
    private ImageLoader imageLoader;

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setIconImageSource(TabScreen view, ReadableMap value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setIconSfSymbolName(TabScreen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setIconType(TabScreen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setOrientation(TabScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setOverrideScrollViewContentInsetAdjustmentBehavior(TabScreen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setScrollEdgeAppearance(TabScreen view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setSelectedIconImageSource(TabScreen view, ReadableMap value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setSelectedIconSfSymbolName(TabScreen view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setSpecialEffects(TabScreen view, ReadableMap value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setStandardAppearance(TabScreen view, Dynamic value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    public void setSystemItem(TabScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public TabScreenViewManager() {
        super(null, 1, null);
        this.delegate = new RNSBottomTabsScreenManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    public final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public final ThemedReactContext getContext() {
        return this.context;
    }

    public final void setContext(ThemedReactContext themedReactContext) {
        this.context = themedReactContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public TabScreen createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ImageLoader.Builder builder = new ImageLoader.Builder(reactContext);
        ComponentRegistry.Builder builder2 = new ComponentRegistry.Builder();
        builder2.add(new SvgDecoder.Factory(false, false, false, 7, null));
        Unit unit = Unit.INSTANCE;
        this.imageLoader = builder.components(builder2.build()).build();
        this.context = reactContext;
        RNSLog.INSTANCE.d(REACT_CLASS, "createViewInstance");
        return new TabScreen(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<TabScreen> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(EventHelpersKt.makeEventRegistrationInfo(TabScreenWillAppearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(TabScreenDidAppearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(TabScreenWillDisappearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(TabScreenDidDisappearEvent.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext reactContext, TabScreen view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.onViewManagerAddEventEmitters$react_native_screens_release();
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(customType = "Color", name = "tabBarItemBadgeBackgroundColor")
    public void setTabBarItemBadgeBackgroundColor(TabScreen view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemBadgeBackgroundColor(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "isFocused")
    public void setIsFocused(TabScreen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        RNSLog.INSTANCE.d(REACT_CLASS, "TabScreen [" + view.getId() + "] setIsFocused " + value);
        view.setFocusedTab(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "tabKey")
    public void setTabKey(TabScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabKey(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "badgeValue")
    public void setBadgeValue(TabScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBadgeValue(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = AlertFragment.ARG_TITLE)
    public void setTitle(TabScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabTitle(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(customType = "Color", name = "tabBarItemBadgeTextColor")
    public void setTabBarItemBadgeTextColor(TabScreen view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarItemBadgeTextColor(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "iconResourceName")
    public void setIconResourceName(TabScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIconResourceName(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSBottomTabsScreenManagerInterface
    @ReactProp(name = "iconResource")
    public void setIconResource(final TabScreen view, ReadableMap value) {
        Intrinsics.checkNotNullParameter(view, "view");
        String string = value != null ? value.getString("uri") : null;
        if (string != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNull(context);
            RNSImageSource rNSImageSourceResolveSource = resolveSource(context, string);
            if (rNSImageSourceResolveSource != null) {
                loadUsingCoil(context, rNSImageSourceResolveSource, new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreenViewManager$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TabScreenViewManager.setIconResource$lambda$1(view, (Drawable) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setIconResource$lambda$1(TabScreen tabScreen, Drawable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        tabScreen.setIcon(it);
        return Unit.INSTANCE;
    }

    private final void loadUsingCoil(final Context context, RNSImageSource source, final Function1<? super Drawable, Unit> onLoad) {
        final Object uri;
        if (source instanceof RNSImageSource.DrawableRes) {
            uri = Integer.valueOf(((RNSImageSource.DrawableRes) source).getResId());
        } else {
            if (!(source instanceof RNSImageSource.UriString)) {
                throw new NoWhenBranchMatchedException();
            }
            uri = ((RNSImageSource.UriString) source).getUri();
        }
        ImageRequest imageRequestBuild = new ImageRequest.Builder(context).data(uri).target(new Target() { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreenViewManager$loadUsingCoil$$inlined$target$default$1
            @Override // coil3.target.Target
            public void onError(Image error) {
            }

            @Override // coil3.target.Target
            public void onStart(Image placeholder) {
            }

            @Override // coil3.target.Target
            public void onSuccess(Image result) {
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                onLoad.invoke(Image_androidKt.asDrawable(result, resources));
            }
        }).listener(new ImageRequest.Listener() { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreenViewManager$loadUsingCoil$$inlined$listener$default$1
            @Override // coil3.request.ImageRequest.Listener
            public void onStart(ImageRequest request) {
            }

            @Override // coil3.request.ImageRequest.Listener
            public void onSuccess(ImageRequest request, SuccessResult result) {
            }

            @Override // coil3.request.ImageRequest.Listener
            public void onCancel(ImageRequest request) {
                Log.w("[RNScreens]", "Image loading request cancelled: " + uri);
            }

            @Override // coil3.request.ImageRequest.Listener
            public void onError(ImageRequest request, ErrorResult result) {
                Log.e("[RNScreens]", "Error loading image: " + uri, result.getThrowable());
            }
        }).build();
        ImageLoader imageLoader = this.imageLoader;
        if (imageLoader != null) {
            imageLoader.enqueue(imageRequestBuild);
        }
    }

    private final RNSImageSource resolveSource(Context context, String uri) {
        if (StringsKt.startsWith$default(uri, "_", false, 2, (Object) null)) {
            int identifier = context.getResources().getIdentifier(uri, "drawable", context.getPackageName());
            if (identifier != 0) {
                return new RNSImageSource.DrawableRes(identifier);
            }
            int identifier2 = context.getResources().getIdentifier(uri, "raw", context.getPackageName());
            if (identifier2 != 0) {
                return new RNSImageSource.DrawableRes(identifier2);
            }
            Log.e("[RNScreens]", "Resource not found in drawable or raw: " + uri);
            return null;
        }
        return new RNSImageSource.UriString(uri);
    }

    /* JADX INFO: compiled from: TabScreenViewManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource;", "", "<init>", "()V", "DrawableRes", "UriString", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource$DrawableRes;", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource$UriString;", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static abstract class RNSImageSource {
        public /* synthetic */ RNSImageSource(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private RNSImageSource() {
        }

        /* JADX INFO: compiled from: TabScreenViewManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource$DrawableRes;", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource;", "resId", "", "<init>", "(I)V", "getResId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class DrawableRes extends RNSImageSource {
            private final int resId;

            public static /* synthetic */ DrawableRes copy$default(DrawableRes drawableRes, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = drawableRes.resId;
                }
                return drawableRes.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getResId() {
                return this.resId;
            }

            public final DrawableRes copy(int resId) {
                return new DrawableRes(resId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DrawableRes) && this.resId == ((DrawableRes) other).resId;
            }

            public int hashCode() {
                return Integer.hashCode(this.resId);
            }

            public String toString() {
                return "DrawableRes(resId=" + this.resId + ")";
            }

            public final int getResId() {
                return this.resId;
            }

            public DrawableRes(int i) {
                super(null);
                this.resId = i;
            }
        }

        /* JADX INFO: compiled from: TabScreenViewManager.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource$UriString;", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreenViewManager$RNSImageSource;", "uri", "", "<init>", "(Ljava/lang/String;)V", "getUri", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class UriString extends RNSImageSource {
            private final String uri;

            public static /* synthetic */ UriString copy$default(UriString uriString, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = uriString.uri;
                }
                return uriString.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUri() {
                return this.uri;
            }

            public final UriString copy(String uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new UriString(uri);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UriString) && Intrinsics.areEqual(this.uri, ((UriString) other).uri);
            }

            public int hashCode() {
                return this.uri.hashCode();
            }

            public String toString() {
                return "UriString(uri=" + this.uri + ")";
            }

            public final String getUri() {
                return this.uri;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UriString(String uri) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.uri = uri;
            }
        }
    }
}
