package expo.modules;

import android.content.Context;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.defaults.DefaultComponentsRegistry;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostDelegate;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.hermes.HermesInstance;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExpoReactHostFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/ExpoReactHostFactory;", "", "<init>", "()V", "reactHost", "Lcom/facebook/react/ReactHost;", "createFromReactNativeHost", "context", "Landroid/content/Context;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "ExpoReactHostDelegate", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoReactHostFactory {
    public static final ExpoReactHostFactory INSTANCE = new ExpoReactHostFactory();
    private static ReactHost reactHost;

    private ExpoReactHostFactory() {
    }

    /* JADX INFO: compiled from: ExpoReactHostFactory.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010#\u001a\u00020$2\n\u0010%\u001a\u00060&j\u0002`'H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lexpo/modules/ExpoReactHostFactory$ExpoReactHostDelegate;", "Lcom/facebook/react/runtime/ReactHostDelegate;", "weakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "reactNativeHostWrapper", "Lexpo/modules/ReactNativeHostWrapper;", "bindingsInstaller", "Lcom/facebook/react/runtime/BindingsInstaller;", "turboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "<init>", "(Ljava/lang/ref/WeakReference;Lexpo/modules/ReactNativeHostWrapper;Lcom/facebook/react/runtime/BindingsInstaller;Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;)V", "getBindingsInstaller", "()Lcom/facebook/react/runtime/BindingsInstaller;", "getTurboModuleManagerDelegateBuilder", "()Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "_jsBundleLoader", "Lcom/facebook/react/bridge/JSBundleLoader;", "jsBundleLoader", "getJsBundleLoader", "()Lcom/facebook/react/bridge/JSBundleLoader;", "jsMainModulePath", "", "getJsMainModulePath", "()Ljava/lang/String;", "jsRuntimeFactory", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "getJsRuntimeFactory", "()Lcom/facebook/react/runtime/JSRuntimeFactory;", "reactPackages", "", "Lcom/facebook/react/ReactPackage;", "getReactPackages", "()Ljava/util/List;", "handleInstanceException", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @UnstableReactNativeAPI
    private static final class ExpoReactHostDelegate implements ReactHostDelegate {
        private JSBundleLoader _jsBundleLoader;
        private final BindingsInstaller bindingsInstaller;
        private final ReactNativeHostWrapper reactNativeHostWrapper;
        private final ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder;
        private final WeakReference<Context> weakContext;

        public ExpoReactHostDelegate(WeakReference<Context> weakContext, ReactNativeHostWrapper reactNativeHostWrapper, BindingsInstaller bindingsInstaller, ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder) {
            Intrinsics.checkNotNullParameter(weakContext, "weakContext");
            Intrinsics.checkNotNullParameter(reactNativeHostWrapper, "reactNativeHostWrapper");
            Intrinsics.checkNotNullParameter(turboModuleManagerDelegateBuilder, "turboModuleManagerDelegateBuilder");
            this.weakContext = weakContext;
            this.reactNativeHostWrapper = reactNativeHostWrapper;
            this.bindingsInstaller = bindingsInstaller;
            this.turboModuleManagerDelegateBuilder = turboModuleManagerDelegateBuilder;
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public BindingsInstaller getBindingsInstaller() {
            return this.bindingsInstaller;
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public ReactPackageTurboModuleManagerDelegate.Builder getTurboModuleManagerDelegateBuilder() {
            return this.turboModuleManagerDelegateBuilder;
        }

        public /* synthetic */ ExpoReactHostDelegate(WeakReference weakReference, ReactNativeHostWrapper reactNativeHostWrapper, BindingsInstaller bindingsInstaller, DefaultTurboModuleManagerDelegate.Builder builder, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(weakReference, reactNativeHostWrapper, (i & 4) != 0 ? null : bindingsInstaller, (i & 8) != 0 ? new DefaultTurboModuleManagerDelegate.Builder() : builder);
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public JSBundleLoader getJsBundleLoader() {
            JSBundleLoader jSBundleLoader = this._jsBundleLoader;
            if (jSBundleLoader != null) {
                return jSBundleLoader;
            }
            Context context = this.weakContext.get();
            if (context == null) {
                throw new IllegalStateException("Unable to get concrete Context");
            }
            String jSBundleFile = this.reactNativeHostWrapper.getJSBundleFile();
            if (jSBundleFile != null) {
                if (StringsKt.startsWith$default(jSBundleFile, "assets://", false, 2, (Object) null)) {
                    return JSBundleLoader.INSTANCE.createAssetLoader(context, jSBundleFile, true);
                }
                return JSBundleLoader.INSTANCE.createFileLoader(jSBundleFile);
            }
            return JSBundleLoader.INSTANCE.createAssetLoader(context, "assets://" + this.reactNativeHostWrapper.getBundleAssetName(), true);
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public String getJsMainModulePath() {
            return this.reactNativeHostWrapper.getJSMainModuleName();
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public JSRuntimeFactory getJsRuntimeFactory() {
            return new HermesInstance();
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public List<ReactPackage> getReactPackages() {
            return this.reactNativeHostWrapper.getPackages();
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public void handleInstanceException(Exception error) throws Exception {
            Intrinsics.checkNotNullParameter(error, "error");
            List<ReactNativeHostHandler> reactNativeHostHandlers = this.reactNativeHostWrapper.getReactNativeHostHandlers();
            if (reactNativeHostHandlers.isEmpty()) {
                throw error;
            }
            boolean useDeveloperSupport = this.reactNativeHostWrapper.getUseDeveloperSupport();
            Iterator<T> it = reactNativeHostHandlers.iterator();
            while (it.hasNext()) {
                ((ReactNativeHostHandler) it.next()).onReactInstanceException(useDeveloperSupport, error);
            }
        }
    }

    @JvmStatic
    public static final ReactHost createFromReactNativeHost(Context context, final ReactNativeHost reactNativeHost) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reactNativeHost, "reactNativeHost");
        if (!(reactNativeHost instanceof ReactNativeHostWrapper)) {
            throw new IllegalArgumentException("You can call createFromReactNativeHost only with instances of ReactNativeHostWrapper".toString());
        }
        if (reactHost == null) {
            ReactNativeHostWrapper reactNativeHostWrapper = (ReactNativeHostWrapper) reactNativeHost;
            final boolean useDeveloperSupport = reactNativeHostWrapper.getUseDeveloperSupport();
            ExpoReactHostDelegate expoReactHostDelegate = new ExpoReactHostDelegate(new WeakReference(context), reactNativeHostWrapper, null, null, 12, null);
            ComponentFactory componentFactory = new ComponentFactory();
            DefaultComponentsRegistry.register(componentFactory);
            Iterator<T> it = reactNativeHostWrapper.getReactNativeHostHandlers().iterator();
            while (it.hasNext()) {
                ((ReactNativeHostHandler) it.next()).onWillCreateReactInstance(useDeveloperSupport);
            }
            ReactHostImpl reactHostImpl = new ReactHostImpl(context, expoReactHostDelegate, componentFactory, true, useDeveloperSupport);
            Iterator<T> it2 = reactNativeHostWrapper.getReactNativeHostHandlers().iterator();
            while (it2.hasNext()) {
                ((ReactNativeHostHandler) it2.next()).onDidCreateDevSupportManager(reactHostImpl.getDevSupportManager());
            }
            reactHostImpl.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: expo.modules.ExpoReactHostFactory.createFromReactNativeHost.4
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext context2) {
                    Intrinsics.checkNotNullParameter(context2, "context");
                    List<ReactNativeHostHandler> reactNativeHostHandlers = ((ReactNativeHostWrapper) reactNativeHost).getReactNativeHostHandlers();
                    boolean z = useDeveloperSupport;
                    Iterator<T> it3 = reactNativeHostHandlers.iterator();
                    while (it3.hasNext()) {
                        ((ReactNativeHostHandler) it3.next()).onDidCreateReactInstance(z, context2);
                    }
                }
            });
            reactHost = reactHostImpl;
        }
        ReactHost reactHost2 = reactHost;
        Intrinsics.checkNotNull(reactHost2, "null cannot be cast to non-null type com.facebook.react.ReactHost");
        return reactHost2;
    }
}
