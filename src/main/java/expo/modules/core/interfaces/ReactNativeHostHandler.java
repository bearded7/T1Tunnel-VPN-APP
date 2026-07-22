package expo.modules.core.interfaces;

import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/* JADX INFO: loaded from: classes2.dex */
public interface ReactNativeHostHandler {
    default String getBundleAssetName(boolean z) {
        return null;
    }

    default Object getDevSupportManagerFactory() {
        return null;
    }

    default String getJSBundleFile(boolean z) {
        return null;
    }

    default JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    default Boolean getUseDeveloperSupport() {
        return null;
    }

    default void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
    }

    default void onDidCreateReactInstance(boolean z, ReactContext reactContext) {
    }

    default void onReactInstanceException(boolean z, Exception exc) {
    }

    default void onWillCreateReactInstance(boolean z) {
    }
}
