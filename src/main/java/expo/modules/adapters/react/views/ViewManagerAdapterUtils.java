package expo.modules.adapters.react.views;

import com.facebook.react.uimanager.ViewProps;

/* JADX INFO: loaded from: classes2.dex */
public class ViewManagerAdapterUtils {
    public static String normalizeEventName(String str) {
        return str.startsWith("on") ? ViewProps.TOP + str.substring(2) : str;
    }
}
