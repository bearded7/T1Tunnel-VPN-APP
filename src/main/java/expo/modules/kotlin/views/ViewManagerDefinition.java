package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ReactExtensionsKt;
import expo.modules.kotlin.defaultmodules.JSLoggerModule;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewManagerDefinition.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B«\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010/\u001a\u000200J\u0016\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u000204R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001f\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)¨\u00065"}, d2 = {"Lexpo/modules/kotlin/views/ViewManagerDefinition;", "", "name", "", "viewFactory", "Lkotlin/Function2;", "Landroid/content/Context;", "Lexpo/modules/kotlin/AppContext;", "Landroid/view/View;", "viewType", "Ljava/lang/Class;", "props", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "onViewDestroys", "Lkotlin/Function1;", "", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "onViewDidUpdateProps", "asyncFunctions", "", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/Class;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lexpo/modules/kotlin/views/CallbacksDefinition;Lexpo/modules/kotlin/views/ViewGroupDefinition;Lkotlin/jvm/functions/Function1;Ljava/util/List;)V", "getName$expo_modules_core_release", "()Ljava/lang/String;", "getViewType$expo_modules_core_release", "()Ljava/lang/Class;", "getProps$expo_modules_core_release", "()Ljava/util/Map;", "getOnViewDestroys", "()Lkotlin/jvm/functions/Function1;", "getCallbacksDefinition", "()Lexpo/modules/kotlin/views/CallbacksDefinition;", "getViewGroupDefinition", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getOnViewDidUpdateProps", "getAsyncFunctions", "()Ljava/util/List;", "createView", "context", "appContext", "propsNames", "getPropsNames", "getViewManagerType", "Lexpo/modules/kotlin/views/ViewManagerType;", "handleException", "view", "exception", "Lexpo/modules/kotlin/exception/CodedException;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewManagerDefinition {
    private final List<BaseAsyncFunctionComponent> asyncFunctions;
    private final CallbacksDefinition callbacksDefinition;
    private final String name;
    private final Function1<View, Unit> onViewDestroys;
    private final Function1<View, Unit> onViewDidUpdateProps;
    private final Map<String, AnyViewProp> props;
    private final List<String> propsNames;
    private final Function2<Context, AppContext, View> viewFactory;
    private final ViewGroupDefinition viewGroupDefinition;
    private final Class<? extends View> viewType;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewManagerDefinition(String str, Function2<? super Context, ? super AppContext, ? extends View> viewFactory, Class<? extends View> viewType, Map<String, ? extends AnyViewProp> props, Function1<? super View, Unit> function1, CallbacksDefinition callbacksDefinition, ViewGroupDefinition viewGroupDefinition, Function1<? super View, Unit> function2, List<? extends BaseAsyncFunctionComponent> asyncFunctions) {
        Intrinsics.checkNotNullParameter(viewFactory, "viewFactory");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(asyncFunctions, "asyncFunctions");
        this.name = str;
        this.viewFactory = viewFactory;
        this.viewType = viewType;
        this.props = props;
        this.onViewDestroys = function1;
        this.callbacksDefinition = callbacksDefinition;
        this.viewGroupDefinition = viewGroupDefinition;
        this.onViewDidUpdateProps = function2;
        this.asyncFunctions = asyncFunctions;
        this.propsNames = CollectionsKt.toList(props.keySet());
    }

    /* JADX INFO: renamed from: getName$expo_modules_core_release, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Class<? extends View> getViewType$expo_modules_core_release() {
        return this.viewType;
    }

    public /* synthetic */ ViewManagerDefinition(String str, Function2 function2, Class cls, Map map, Function1 function1, CallbacksDefinition callbacksDefinition, ViewGroupDefinition viewGroupDefinition, Function1 function3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, function2, cls, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? null : function1, (i & 32) != 0 ? null : callbacksDefinition, (i & 64) != 0 ? null : viewGroupDefinition, (i & 128) != 0 ? null : function3, (i & 256) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Map<String, AnyViewProp> getProps$expo_modules_core_release() {
        return this.props;
    }

    public final Function1<View, Unit> getOnViewDestroys() {
        return this.onViewDestroys;
    }

    public final CallbacksDefinition getCallbacksDefinition() {
        return this.callbacksDefinition;
    }

    public final ViewGroupDefinition getViewGroupDefinition() {
        return this.viewGroupDefinition;
    }

    public final Function1<View, Unit> getOnViewDidUpdateProps() {
        return this.onViewDidUpdateProps;
    }

    public final List<BaseAsyncFunctionComponent> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final View createView(Context context, AppContext appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return this.viewFactory.invoke(context, appContext);
    }

    public final List<String> getPropsNames() {
        return this.propsNames;
    }

    public final ViewManagerType getViewManagerType() {
        if (ViewGroup.class.isAssignableFrom(this.viewType)) {
            return ViewManagerType.GROUP;
        }
        return ViewManagerType.SIMPLE;
    }

    public final void handleException(View view, CodedException exception) {
        NativeModulesProxy unimoduleProxy;
        JSLoggerModule errorManager;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Context context = view.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null || (unimoduleProxy = ReactExtensionsKt.getUnimoduleProxy(reactContext)) == null || (errorManager = unimoduleProxy.getKotlinInteropModuleRegistry().getAppContext().getErrorManager()) == null) {
            return;
        }
        errorManager.reportExceptionToLogBox(exception);
    }
}
