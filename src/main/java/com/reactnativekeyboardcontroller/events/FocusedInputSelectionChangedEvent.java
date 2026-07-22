package com.reactnativekeyboardcontroller.events;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusedInputSelectionChangedEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reactnativekeyboardcontroller/events/FocusedInputSelectionChangedEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewId", NotificationCompat.CATEGORY_EVENT, "Lcom/reactnativekeyboardcontroller/events/FocusedInputSelectionChangedEventData;", "<init>", "(IILcom/reactnativekeyboardcontroller/events/FocusedInputSelectionChangedEventData;)V", "getEventName", "", "getCoalescingKey", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusedInputSelectionChangedEvent extends Event<FocusedInputSelectionChangedEvent> {
    public static final String EVENT_NAME = "topFocusedInputSelectionChanged";
    private final FocusedInputSelectionChangedEventData event;

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusedInputSelectionChangedEvent(int i, int i2, FocusedInputSelectionChangedEventData event) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("target", this.event.getTarget());
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        WritableMap writableMapCreateMap3 = Arguments.createMap();
        writableMapCreateMap3.putDouble("x", this.event.getStartX());
        writableMapCreateMap3.putDouble("y", this.event.getStartY());
        writableMapCreateMap3.putInt(ViewProps.POSITION, this.event.getStart());
        Unit unit = Unit.INSTANCE;
        writableMapCreateMap2.putMap(ViewProps.START, writableMapCreateMap3);
        WritableMap writableMapCreateMap4 = Arguments.createMap();
        writableMapCreateMap4.putDouble("x", this.event.getEndX());
        writableMapCreateMap4.putDouble("y", this.event.getEndY());
        writableMapCreateMap4.putInt(ViewProps.POSITION, this.event.getEnd());
        Unit unit2 = Unit.INSTANCE;
        writableMapCreateMap2.putMap(ViewProps.END, writableMapCreateMap4);
        Unit unit3 = Unit.INSTANCE;
        writableMapCreateMap.putMap("selection", writableMapCreateMap2);
        return writableMapCreateMap;
    }
}
