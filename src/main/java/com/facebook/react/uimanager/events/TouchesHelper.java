package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.systrace.Systrace;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchesHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0007J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0002¢\u0006\u0002\u0010#R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/react/uimanager/events/TouchesHelper;", "", "<init>", "()V", "TARGET_KEY", "", "getTARGET_KEY$annotations", "TARGET_SURFACE_KEY", "CHANGED_TOUCHES_KEY", "TOUCHES_KEY", "PAGE_X_KEY", "PAGE_Y_KEY", "TIMESTAMP_KEY", "POINTER_IDENTIFIER_KEY", "LOCATION_X_KEY", "LOCATION_Y_KEY", "createPointersArray", "", "Lcom/facebook/react/bridge/WritableMap;", NotificationCompat.CATEGORY_EVENT, "Lcom/facebook/react/uimanager/events/TouchEvent;", "(Lcom/facebook/react/uimanager/events/TouchEvent;)[Lcom/facebook/react/bridge/WritableMap;", "sendTouchesLegacy", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "touchEvent", "sendTouchEvent", "eventEmitter", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "getWritableArray", "Lcom/facebook/react/bridge/WritableArray;", "copyObjects", "", "objects", "(Z[Lcom/facebook/react/bridge/WritableMap;)Lcom/facebook/react/bridge/WritableArray;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchesHelper {
    private static final String CHANGED_TOUCHES_KEY = "changedTouches";
    private static final String LOCATION_X_KEY = "locationX";
    private static final String LOCATION_Y_KEY = "locationY";
    private static final String PAGE_X_KEY = "pageX";
    private static final String PAGE_Y_KEY = "pageY";
    private static final String POINTER_IDENTIFIER_KEY = "identifier";
    private static final String TARGET_SURFACE_KEY = "targetSurface";
    private static final String TIMESTAMP_KEY = "timestamp";
    private static final String TOUCHES_KEY = "touches";
    public static final TouchesHelper INSTANCE = new TouchesHelper();
    public static final String TARGET_KEY = "target";

    /* JADX INFO: compiled from: TouchesHelper.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TouchEventType.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TouchEventType.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Not used in New Architecture")
    public static /* synthetic */ void getTARGET_KEY$annotations() {
    }

    private TouchesHelper() {
    }

    private final WritableMap[] createPointersArray(TouchEvent event) {
        MotionEvent motionEvent = event.getMotionEvent();
        WritableMap[] writableMapArr = new WritableMap[motionEvent.getPointerCount()];
        float x = motionEvent.getX() - event.getViewX();
        float y = motionEvent.getY() - event.getViewY();
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            writableMapCreateMap.putDouble(PAGE_X_KEY, PixelUtil.INSTANCE.pxToDp(motionEvent.getX(i)));
            writableMapCreateMap.putDouble(PAGE_Y_KEY, PixelUtil.INSTANCE.pxToDp(motionEvent.getY(i)));
            float x2 = motionEvent.getX(i) - x;
            float y2 = motionEvent.getY(i) - y;
            writableMapCreateMap.putDouble(LOCATION_X_KEY, PixelUtil.INSTANCE.pxToDp(x2));
            writableMapCreateMap.putDouble(LOCATION_Y_KEY, PixelUtil.INSTANCE.pxToDp(y2));
            writableMapCreateMap.putInt(TARGET_SURFACE_KEY, event.getSurfaceId());
            writableMapCreateMap.putInt(TARGET_KEY, event.getViewTag());
            writableMapCreateMap.putDouble(TIMESTAMP_KEY, event.getTimestampMs());
            writableMapCreateMap.putDouble(POINTER_IDENTIFIER_KEY, motionEvent.getPointerId(i));
            writableMapArr[i] = writableMapCreateMap;
        }
        return writableMapArr;
    }

    @JvmStatic
    public static final void sendTouchesLegacy(RCTEventEmitter rctEventEmitter, TouchEvent touchEvent) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
        TouchEventType touchEventType = touchEvent.getTouchEventType();
        TouchesHelper touchesHelper = INSTANCE;
        WritableArray writableArray = touchesHelper.getWritableArray(false, touchesHelper.createPointersArray(touchEvent));
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "createArray(...)");
        if (touchEventType == TouchEventType.MOVE || touchEventType == TouchEventType.CANCEL) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                writableArrayCreateArray.pushInt(i);
            }
        } else if (touchEventType == TouchEventType.START || touchEventType == TouchEventType.END) {
            writableArrayCreateArray.pushInt(motionEvent.getActionIndex());
        } else {
            throw new RuntimeException("Unknown touch type: " + touchEventType);
        }
        rctEventEmitter.receiveTouches(TouchEventType.INSTANCE.getJSEventName(touchEventType), writableArray, writableArrayCreateArray);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a5 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x002c, B:11:0x0050, B:29:0x0098, B:30:0x009f, B:32:0x00a5, B:34:0x00ad, B:36:0x00cd, B:12:0x0055, B:13:0x005a, B:14:0x005b, B:15:0x0061, B:17:0x0067, B:19:0x006b, B:21:0x0071, B:22:0x0076, B:24:0x0084, B:26:0x008e, B:28:0x0094), top: B:43:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ad A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x002c, B:11:0x0050, B:29:0x0098, B:30:0x009f, B:32:0x00a5, B:34:0x00ad, B:36:0x00cd, B:12:0x0055, B:13:0x005a, B:14:0x005b, B:15:0x0061, B:17:0x0067, B:19:0x006b, B:21:0x0071, B:22:0x0076, B:24:0x0084, B:26:0x008e, B:28:0x0094), top: B:43:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    @JvmStatic
    public static final void sendTouchEvent(RCTModernEventEmitter eventEmitter, TouchEvent event) {
        WritableMap[] writableMapArr;
        WritableMap[] writableMapArr2;
        Iterator it;
        WritableMap writableMap;
        WritableMap writableMap2;
        RCTModernEventEmitter eventEmitter2 = eventEmitter;
        Intrinsics.checkNotNullParameter(eventEmitter2, "eventEmitter");
        Intrinsics.checkNotNullParameter(event, "event");
        Systrace.beginSection(0L, "TouchesHelper.sentTouchEventModern(" + event.getEventName() + ")");
        try {
            TouchEventType touchEventType = event.getTouchEventType();
            MotionEvent motionEvent = event.getMotionEvent();
            WritableMap[] writableMapArrCreatePointersArray = INSTANCE.createPointersArray(event);
            int i = WhenMappings.$EnumSwitchMapping$0[touchEventType.ordinal()];
            if (i == 1) {
                int actionIndex = motionEvent.getActionIndex();
                WritableMap[] writableMapArr3 = new WritableMap[1];
                WritableMap writableMap3 = writableMapArrCreatePointersArray[actionIndex];
                writableMapArr3[0] = writableMap3 != null ? writableMap3.copy() : null;
                writableMapArr = writableMapArr3;
            } else if (i == 2) {
                int actionIndex2 = motionEvent.getActionIndex();
                WritableMap writableMap4 = writableMapArrCreatePointersArray[actionIndex2];
                writableMapArrCreatePointersArray[actionIndex2] = null;
                writableMapArr = new WritableMap[]{writableMap4};
            } else {
                if (i == 3) {
                    writableMapArr = new WritableMap[writableMapArrCreatePointersArray.length];
                    for (int i2 = 0; i2 < writableMapArrCreatePointersArray.length; i2++) {
                        WritableMap writableMap5 = writableMapArrCreatePointersArray[i2];
                        writableMapArr[i2] = writableMap5 != null ? writableMap5.copy() : null;
                    }
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    writableMapArr2 = new WritableMap[0];
                    writableMapArr = writableMapArrCreatePointersArray;
                }
                it = ArrayIteratorKt.iterator(writableMapArr);
                while (it.hasNext()) {
                    writableMap = (WritableMap) it.next();
                    if (writableMap != null) {
                        WritableMap writableMapCopy = writableMap.copy();
                        TouchesHelper touchesHelper = INSTANCE;
                        WritableArray writableArray = touchesHelper.getWritableArray(true, writableMapArr);
                        WritableArray writableArray2 = touchesHelper.getWritableArray(true, writableMapArr2);
                        writableMapCopy.putArray(CHANGED_TOUCHES_KEY, writableArray);
                        writableMapCopy.putArray(TOUCHES_KEY, writableArray2);
                        writableMap2 = writableMapCopy;
                    } else {
                        writableMap2 = null;
                    }
                    eventEmitter2.receiveEvent(event.getSurfaceId(), event.getViewTag(), event.getEventName(), event.canCoalesce(), 0, writableMap2, event.getEventCategory());
                    eventEmitter2 = eventEmitter;
                }
                Systrace.endSection(0L);
            }
            writableMapArr2 = writableMapArrCreatePointersArray;
            it = ArrayIteratorKt.iterator(writableMapArr);
            while (it.hasNext()) {
                writableMap = (WritableMap) it.next();
                if (writableMap != null) {
                    WritableMap writableMapCopy2 = writableMap.copy();
                    TouchesHelper touchesHelper2 = INSTANCE;
                    WritableArray writableArray3 = touchesHelper2.getWritableArray(true, writableMapArr);
                    WritableArray writableArray4 = touchesHelper2.getWritableArray(true, writableMapArr2);
                    writableMapCopy2.putArray(CHANGED_TOUCHES_KEY, writableArray3);
                    writableMapCopy2.putArray(TOUCHES_KEY, writableArray4);
                    writableMap2 = writableMapCopy2;
                } else {
                    writableMap2 = null;
                }
                eventEmitter2.receiveEvent(event.getSurfaceId(), event.getViewTag(), event.getEventName(), event.canCoalesce(), 0, writableMap2, event.getEventCategory());
                eventEmitter2 = eventEmitter;
            }
            Systrace.endSection(0L);
        } catch (Throwable th) {
            Systrace.endSection(0L);
            throw th;
        }
    }

    private final WritableArray getWritableArray(boolean copyObjects, WritableMap[] objects) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "createArray(...)");
        for (WritableMap writableMapCopy : objects) {
            if (writableMapCopy != null) {
                if (copyObjects) {
                    writableMapCopy = writableMapCopy.copy();
                }
                writableArrayCreateArray.pushMap(writableMapCopy);
            }
        }
        return writableArrayCreateArray;
    }
}
