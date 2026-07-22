package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerDelegate;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebuggingOverlayManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = DebuggingOverlayManager.REACT_CLASS)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0016B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlayManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/facebook/react/views/debuggingoverlay/DebuggingOverlay;", "Lcom/facebook/react/viewmanagers/DebuggingOverlayManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "highlightTraceUpdates", "", "view", "providedTraceUpdates", "Lcom/facebook/react/bridge/ReadableArray;", "highlightElements", "providedElements", "clearElementsHighlights", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebuggingOverlayManager extends SimpleViewManager<DebuggingOverlay> implements DebuggingOverlayManagerInterface<DebuggingOverlay> {
    public static final String REACT_CLASS = "DebuggingOverlay";
    private final ViewManagerDelegate<DebuggingOverlay> delegate = new DebuggingOverlayManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<DebuggingOverlay> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void highlightTraceUpdates(DebuggingOverlay view, ReadableArray providedTraceUpdates) throws Exception {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(providedTraceUpdates, "providedTraceUpdates");
        ArrayList arrayList = new ArrayList();
        int size = providedTraceUpdates.size();
        boolean z2 = true;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = z2;
                break;
            }
            ReadableMap map = providedTraceUpdates.getMap(i);
            if (map != null) {
                ReadableMap map2 = map.getMap("rectangle");
                if (map2 == null) {
                    ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field is null"));
                    z = false;
                    break;
                }
                int i2 = map.getInt("id");
                int i3 = map.getInt(ViewProps.COLOR);
                try {
                    float f = (float) map2.getDouble("x");
                    float f2 = (float) map2.getDouble("y");
                    Boolean.valueOf(arrayList.add(new TraceUpdate(i2, new RectF(PixelUtil.INSTANCE.dpToPx(f), PixelUtil.INSTANCE.dpToPx(f2), PixelUtil.INSTANCE.dpToPx((float) (((double) f) + map2.getDouble("width"))), PixelUtil.INSTANCE.dpToPx((float) (((double) f2) + map2.getDouble("height")))), i3)));
                } catch (Exception e) {
                    if ((e instanceof NoSuchKeyException) || (e instanceof UnexpectedNativeTypeException)) {
                        ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"));
                        Unit unit = Unit.INSTANCE;
                        z2 = false;
                    } else {
                        throw e;
                    }
                }
            }
            i++;
        }
        if (z) {
            view.setTraceUpdates(arrayList);
        }
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void highlightElements(DebuggingOverlay view, ReadableArray providedElements) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(providedElements, "providedElements");
        ArrayList arrayList = new ArrayList();
        int size = providedElements.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            ReadableMap map = providedElements.getMap(i);
            if (map != null) {
                try {
                    float f = (float) map.getDouble("x");
                    float f2 = (float) map.getDouble("y");
                    Boolean.valueOf(arrayList.add(new RectF(PixelUtil.INSTANCE.dpToPx(f), PixelUtil.INSTANCE.dpToPx(f2), PixelUtil.INSTANCE.dpToPx((float) (((double) f) + map.getDouble("width"))), PixelUtil.INSTANCE.dpToPx((float) (((double) f2) + map.getDouble("height"))))));
                } catch (Exception e) {
                    if ((e instanceof NoSuchKeyException) || (e instanceof UnexpectedNativeTypeException)) {
                        ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting elements: every element should have x, y, width, height fields"));
                        Unit unit = Unit.INSTANCE;
                        z = false;
                    } else {
                        throw e;
                    }
                }
            }
        }
        if (z) {
            view.setHighlightedElementsRectangles(arrayList);
        }
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void clearElementsHighlights(DebuggingOverlay view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.clearElementsHighlights();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public DebuggingOverlay createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DebuggingOverlay(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }
}
