package expo.modules.core.interfaces;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactNativeHost;

/* JADX INFO: loaded from: classes2.dex */
public interface ReactActivityHandler {

    public interface DelayLoadAppHandler {
        void whenReady(Runnable runnable);
    }

    default ViewGroup createReactRootViewContainer(Activity activity) {
        return null;
    }

    default DelayLoadAppHandler getDelayLoadAppHandler(ReactActivity reactActivity, ReactNativeHost reactNativeHost) {
        return null;
    }

    default ReactActivityDelegate onDidCreateReactActivityDelegate(ReactActivity reactActivity, ReactActivityDelegate reactActivityDelegate) {
        return null;
    }

    default boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    default boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    default boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }
}
