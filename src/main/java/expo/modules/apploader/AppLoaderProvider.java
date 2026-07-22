package expo.modules.apploader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppLoaderProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/apploader/AppLoaderProvider;", "", "<init>", "()V", "loaders", "", "", "Lexpo/modules/apploader/HeadlessAppLoader;", "getLoader", "name", "context", "Landroid/content/Context;", "createLoader", "", "Callback", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLoaderProvider {
    public static final AppLoaderProvider INSTANCE = new AppLoaderProvider();
    private static final Map<String, HeadlessAppLoader> loaders = new HashMap();

    /* JADX INFO: compiled from: AppLoaderProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&¨\u0006\t"}, d2 = {"Lexpo/modules/apploader/AppLoaderProvider$Callback;", "", "onComplete", "", "success", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Callback {
        void onComplete(boolean success, Exception exception);
    }

    private AppLoaderProvider() {
    }

    @JvmStatic
    public static final HeadlessAppLoader getLoader(String name, Context context) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Map<String, HeadlessAppLoader> map = loaders;
        if (!map.containsKey(name)) {
            try {
                INSTANCE.createLoader(name, context);
            } catch (Exception e) {
                Log.e("Expo", "Cannot initialize app loader. " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
        return map.get(name);
    }

    private final void createLoader(String name, Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("org.unimodules.core.AppLoader#" + name);
            if (string == null) {
                throw new IllegalStateException("Unable to instantiate AppLoader!");
            }
            Class<?> cls = Class.forName(string);
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<out expo.modules.apploader.HeadlessAppLoader>");
            Map<String, HeadlessAppLoader> map = loaders;
            Object objNewInstance = cls.getDeclaredConstructor(Context.class).newInstance(context);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type expo.modules.apploader.HeadlessAppLoader");
            map.put(name, (HeadlessAppLoader) objNewInstance);
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("Unable to instantiate AppLoader!", e);
        }
    }
}
