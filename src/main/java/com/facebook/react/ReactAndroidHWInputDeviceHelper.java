package com.facebook.react;

import android.view.KeyEvent;
import android.view.View;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactAndroidHWInputDeviceHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\tJ$\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/ReactAndroidHWInputDeviceHelper;", "", "reactRootView", "Lcom/facebook/react/ReactRootView;", "<init>", "(Lcom/facebook/react/ReactRootView;)V", "lastFocusedViewId", "", "handleKeyEvent", "", "ev", "Landroid/view/KeyEvent;", "onFocusChanged", "newFocusedView", "Landroid/view/View;", "clearFocus", "dispatchEvent", "eventType", "", "targetViewId", "eventKeyAction", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactAndroidHWInputDeviceHelper {
    private static final Companion Companion = new Companion(null);
    private static final Map<Integer, String> KEY_EVENTS_ACTIONS = MapsKt.mapOf(TuplesKt.to(23, "select"), TuplesKt.to(66, "select"), TuplesKt.to(62, "select"), TuplesKt.to(85, "playPause"), TuplesKt.to(89, "rewind"), TuplesKt.to(90, "fastForward"), TuplesKt.to(86, "stop"), TuplesKt.to(87, "next"), TuplesKt.to(88, "previous"), TuplesKt.to(19, "up"), TuplesKt.to(22, ViewProps.RIGHT), TuplesKt.to(20, "down"), TuplesKt.to(21, ViewProps.LEFT), TuplesKt.to(165, "info"), TuplesKt.to(82, "menu"));
    private int lastFocusedViewId;
    private final ReactRootView reactRootView;

    public ReactAndroidHWInputDeviceHelper(ReactRootView reactRootView) {
        Intrinsics.checkNotNullParameter(reactRootView, "reactRootView");
        this.reactRootView = reactRootView;
        this.lastFocusedViewId = -1;
    }

    public final void handleKeyEvent(KeyEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int keyCode = ev.getKeyCode();
        int action = ev.getAction();
        if (action == 1 || action == 0) {
            Map<Integer, String> map = KEY_EVENTS_ACTIONS;
            if (map.containsKey(Integer.valueOf(keyCode))) {
                dispatchEvent(map.get(Integer.valueOf(keyCode)), this.lastFocusedViewId, action);
            }
        }
    }

    public final void onFocusChanged(View newFocusedView) {
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper;
        Intrinsics.checkNotNullParameter(newFocusedView, "newFocusedView");
        if (this.lastFocusedViewId == newFocusedView.getId()) {
            return;
        }
        int i = this.lastFocusedViewId;
        if (i != -1) {
            reactAndroidHWInputDeviceHelper = this;
            dispatchEvent$default(reactAndroidHWInputDeviceHelper, "blur", i, 0, 4, null);
        } else {
            reactAndroidHWInputDeviceHelper = this;
        }
        reactAndroidHWInputDeviceHelper.lastFocusedViewId = newFocusedView.getId();
        dispatchEvent$default(reactAndroidHWInputDeviceHelper, "focus", newFocusedView.getId(), 0, 4, null);
    }

    public final void clearFocus() {
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper;
        int i = this.lastFocusedViewId;
        if (i != -1) {
            reactAndroidHWInputDeviceHelper = this;
            dispatchEvent$default(reactAndroidHWInputDeviceHelper, "blur", i, 0, 4, null);
        } else {
            reactAndroidHWInputDeviceHelper = this;
        }
        reactAndroidHWInputDeviceHelper.lastFocusedViewId = -1;
    }

    static /* synthetic */ void dispatchEvent$default(ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        reactAndroidHWInputDeviceHelper.dispatchEvent(str, i, i2);
    }

    private final void dispatchEvent(String eventType, int targetViewId, int eventKeyAction) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("eventType", eventType);
        writableNativeMap.putInt("eventKeyAction", eventKeyAction);
        if (targetViewId != -1) {
            writableNativeMap.putInt("tag", targetViewId);
        }
        this.reactRootView.sendEvent("onHWKeyEvent", writableNativeMap);
    }

    /* JADX INFO: compiled from: ReactAndroidHWInputDeviceHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/react/ReactAndroidHWInputDeviceHelper$Companion;", "", "<init>", "()V", "KEY_EVENTS_ACTIONS", "", "", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
