package com.facebook.react.views.virtualview;

import android.graphics.Rect;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactVirtualViewManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/views/virtualview/VirtualViewEventEmitter;", "Lcom/facebook/react/views/virtualview/ModeChangeEmitter;", "viewId", "", "surfaceId", "dispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "<init>", "(IILcom/facebook/react/uimanager/events/EventDispatcher;)V", "emitModeChange", "", "mode", "Lcom/facebook/react/views/virtualview/VirtualViewMode;", "targetRect", "Landroid/graphics/Rect;", "thresholdRect", "synchronous", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VirtualViewEventEmitter implements ModeChangeEmitter {
    private final EventDispatcher dispatcher;
    private final int surfaceId;
    private final int viewId;

    public VirtualViewEventEmitter(int i, int i2, EventDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.viewId = i;
        this.surfaceId = i2;
        this.dispatcher = dispatcher;
    }

    @Override // com.facebook.react.views.virtualview.ModeChangeEmitter
    public void emitModeChange(VirtualViewMode mode, Rect targetRect, Rect thresholdRect, boolean synchronous) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(targetRect, "targetRect");
        Intrinsics.checkNotNullParameter(thresholdRect, "thresholdRect");
        this.dispatcher.dispatchEvent(new VirtualViewModeChangeEvent(this.surfaceId, this.viewId, mode, targetRect, thresholdRect, synchronous));
    }
}
