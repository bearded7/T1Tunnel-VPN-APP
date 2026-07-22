package expo.modules;

import android.util.Log;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import expo.modules.adapters.react.ModuleRegistryAdapter;
import expo.modules.core.ModulePriorities;
import expo.modules.core.interfaces.Package;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ExpoModulesPackage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lexpo/modules/ExpoModulesPackage;", "Lcom/facebook/react/ReactPackage;", "<init>", "()V", "moduleRegistryAdapter", "Lexpo/modules/adapters/react/ModuleRegistryAdapter;", "getModuleRegistryAdapter", "()Lexpo/modules/adapters/react/ModuleRegistryAdapter;", "createNativeModules", "", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "Companion", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoModulesPackage implements ReactPackage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<List<Package>> packageList$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.ExpoModulesPackage$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ExpoModulesPackage.packageList_delegate$lambda$1();
        }
    });
    private final ModuleRegistryAdapter moduleRegistryAdapter = new ModuleRegistryAdapter(INSTANCE.getPackageList());

    public final ModuleRegistryAdapter getModuleRegistryAdapter() {
        return this.moduleRegistryAdapter;
    }

    /* JADX INFO: compiled from: ExpoModulesPackage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lexpo/modules/ExpoModulesPackage$Companion;", "", "<init>", "()V", "packageList", "", "Lexpo/modules/core/interfaces/Package;", "getPackageList$annotations", "getPackageList", "()Ljava/util/List;", "packageList$delegate", "Lkotlin/Lazy;", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPackageList$annotations() {
        }

        private Companion() {
        }

        public final List<Package> getPackageList() {
            return (List) ExpoModulesPackage.packageList$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List packageList_delegate$lambda$1() {
        try {
            Object objInvoke = Class.forName("expo.modules.ExpoModulesPackageList").getMethod("getPackageList", new Class[0]).invoke(null, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<expo.modules.core.interfaces.Package>");
            return CollectionsKt.sortedWith((List) objInvoke, new Comparator() { // from class: expo.modules.ExpoModulesPackage$packageList_delegate$lambda$1$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(ModulePriorities.INSTANCE.get(Reflection.getOrCreateKotlinClass(((Package) t2).getClass()).getQualifiedName())), Integer.valueOf(ModulePriorities.INSTANCE.get(Reflection.getOrCreateKotlinClass(((Package) t).getClass()).getQualifiedName())));
                }
            });
        } catch (Exception e) {
            Log.e("ExpoModulesPackage", "Couldn't get expo package list.", e);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<NativeModule> listCreateNativeModules = this.moduleRegistryAdapter.createNativeModules(reactContext);
        Intrinsics.checkNotNullExpressionValue(listCreateNativeModules, "createNativeModules(...)");
        return listCreateNativeModules;
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<ViewManager<?, ?>> listCreateViewManagers = this.moduleRegistryAdapter.createViewManagers(reactContext);
        Intrinsics.checkNotNullExpressionValue(listCreateViewManagers, "createViewManagers(...)");
        return listCreateViewManagers;
    }
}
