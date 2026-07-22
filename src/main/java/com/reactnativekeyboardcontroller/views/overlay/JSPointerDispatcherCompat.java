package com.reactnativekeyboardcontroller.views.overlay;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSPointerDispatcherCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/overlay/JSPointerDispatcherCompat;", "Lcom/facebook/react/uimanager/JSPointerDispatcher;", "viewGroup", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "handleMotionEventMethod", "Ljava/lang/reflect/Method;", "getHandleMotionEventMethod", "()Ljava/lang/reflect/Method;", "handleMotionEventMethod$delegate", "Lkotlin/Lazy;", "handleMotionEventCompat", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "isCapture", "", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSPointerDispatcherCompat extends JSPointerDispatcher {
    private static final String HANDLE_MOTION_EVENT = "handleMotionEvent";
    private static final int RN_72_PARAMS_COUNT = 3;

    /* JADX INFO: renamed from: handleMotionEventMethod$delegate, reason: from kotlin metadata */
    private final Lazy handleMotionEventMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSPointerDispatcherCompat(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.handleMotionEventMethod = LazyKt.lazy(new Function0() { // from class: com.reactnativekeyboardcontroller.views.overlay.JSPointerDispatcherCompat$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JSPointerDispatcherCompat.handleMotionEventMethod_delegate$lambda$0();
            }
        });
    }

    private final Method getHandleMotionEventMethod() {
        return (Method) this.handleMotionEventMethod.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method handleMotionEventMethod_delegate$lambda$0() {
        try {
            try {
                return JSPointerDispatcher.class.getMethod(HANDLE_MOTION_EVENT, MotionEvent.class, EventDispatcher.class, Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (NoSuchMethodException unused2) {
            return JSPointerDispatcher.class.getMethod(HANDLE_MOTION_EVENT, MotionEvent.class, EventDispatcher.class);
        }
    }

    public final void handleMotionEventCompat(MotionEvent event, EventDispatcher eventDispatcher, boolean isCapture) {
        Method handleMotionEventMethod = getHandleMotionEventMethod();
        if (handleMotionEventMethod != null) {
            if (JSPointerDispatcherCompat$$ExternalSyntheticBackport0.m(handleMotionEventMethod) == 3) {
                handleMotionEventMethod.invoke(this, event, eventDispatcher, Boolean.valueOf(isCapture));
            } else {
                handleMotionEventMethod.invoke(this, event, eventDispatcher);
            }
        }
    }
}
