package com.reactnativekeyboardcontroller.listeners;

import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEventData;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEventData;
import com.reactnativekeyboardcontroller.events.FocusedInputTextChangedEvent;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ViewKt;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.reactnativekeyboardcontroller.traversal.ViewHierarchyNavigator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FocusedInputObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010)\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u0016J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00160\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0093\u0001\u0010\u001c\u001a\u0086\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00160\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/reactnativekeyboardcontroller/listeners/FocusedInputObserver;", "", "view", "Landroid/view/View;", "eventPropagationView", "Lcom/facebook/react/views/view/ReactViewGroup;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Landroid/view/View;Lcom/facebook/react/views/view/ReactViewGroup;Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getView", "()Landroid/view/View;", "surfaceId", "", "lastFocusedInput", "Landroid/widget/EditText;", "lastEventDispatched", "Lcom/reactnativekeyboardcontroller/events/FocusedInputLayoutChangedEventData;", "textWatcher", "Landroid/text/TextWatcher;", "selectionSubscription", "Lkotlin/Function0;", "", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "textListener", "Lkotlin/Function1;", "", "selectionListener", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", ViewProps.START, ViewProps.END, "", "startX", "startY", "endX", "endY", "focusListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "syncUpLayout", "destroy", "dispatchEventToJS", NotificationCompat.CATEGORY_EVENT, "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusedInputObserver {
    private final ThemedReactContext context;
    private final ReactViewGroup eventPropagationView;
    private final ViewTreeObserver.OnGlobalFocusChangeListener focusListener;
    private FocusedInputLayoutChangedEventData lastEventDispatched;
    private EditText lastFocusedInput;
    private final View.OnLayoutChangeListener layoutListener;
    private final Function6<Integer, Integer, Double, Double, Double, Double, Unit> selectionListener;
    private Function0<Unit> selectionSubscription;
    private final int surfaceId;
    private final Function1<String, Unit> textListener;
    private TextWatcher textWatcher;
    private final View view;

    public FocusedInputObserver(View view, ReactViewGroup eventPropagationView, ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventPropagationView, "eventPropagationView");
        this.view = view;
        this.eventPropagationView = eventPropagationView;
        this.context = themedReactContext;
        this.surfaceId = UIManagerHelper.getSurfaceId(view);
        this.lastEventDispatched = FocusedInputObserverKt.getNoFocusedInputEvent();
        this.layoutListener = new View.OnLayoutChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.syncUpLayout();
            }
        };
        this.textListener = new Function1() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FocusedInputObserver.textListener$lambda$1(this.f$0, (String) obj);
            }
        };
        this.selectionListener = new Function6() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return FocusedInputObserver.selectionListener$lambda$2(this.f$0, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Double) obj3).doubleValue(), ((Double) obj4).doubleValue(), ((Double) obj5).doubleValue(), ((Double) obj6).doubleValue());
            }
        };
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                FocusedInputObserver.focusListener$lambda$6(this.f$0, view2, view3);
            }
        };
        this.focusListener = onGlobalFocusChangeListener;
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    public final View getView() {
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit textListener$lambda$1(FocusedInputObserver focusedInputObserver, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        focusedInputObserver.syncUpLayout();
        ThemedReactContextKt.dispatchEvent(focusedInputObserver.context, focusedInputObserver.eventPropagationView.getId(), new FocusedInputTextChangedEvent(focusedInputObserver.surfaceId, focusedInputObserver.eventPropagationView.getId(), text));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit selectionListener$lambda$2(FocusedInputObserver focusedInputObserver, int i, int i2, double d, double d2, double d3, double d4) {
        EditText editText = focusedInputObserver.lastFocusedInput;
        if (editText == null) {
            return Unit.INSTANCE;
        }
        focusedInputObserver.syncUpLayout();
        ThemedReactContextKt.dispatchEvent(focusedInputObserver.context, focusedInputObserver.eventPropagationView.getId(), new FocusedInputSelectionChangedEvent(focusedInputObserver.surfaceId, focusedInputObserver.eventPropagationView.getId(), new FocusedInputSelectionChangedEventData(editText.getId(), d, d2, d3, d4, i, i2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void focusListener$lambda$6(FocusedInputObserver focusedInputObserver, View view, View view2) {
        if (view2 == null || view != null) {
            EditText editText = focusedInputObserver.lastFocusedInput;
            if (editText != null) {
                editText.removeOnLayoutChangeListener(focusedInputObserver.layoutListener);
            }
            final EditText editText2 = focusedInputObserver.lastFocusedInput;
            if (editText2 != null) {
                final TextWatcher textWatcher = focusedInputObserver.textWatcher;
                editText2.post(new Runnable() { // from class: com.reactnativekeyboardcontroller.listeners.FocusedInputObserver$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        editText2.removeTextChangedListener(textWatcher);
                    }
                });
            }
            Function0<Unit> function0 = focusedInputObserver.selectionSubscription;
            if (function0 != null) {
                function0.invoke();
            }
            focusedInputObserver.lastFocusedInput = null;
        }
        if (view2 instanceof EditText) {
            EditText editText3 = (EditText) view2;
            focusedInputObserver.lastFocusedInput = editText3;
            editText3.addOnLayoutChangeListener(focusedInputObserver.layoutListener);
            focusedInputObserver.syncUpLayout();
            focusedInputObserver.textWatcher = EditTextKt.addOnTextChangedListener(editText3, focusedInputObserver.textListener);
            focusedInputObserver.selectionSubscription = EditTextKt.addOnSelectionChangedListener(editText3, focusedInputObserver.selectionListener);
            FocusedInputHolder.INSTANCE.set(editText3);
            ViewHierarchyNavigator viewHierarchyNavigator = ViewHierarchyNavigator.INSTANCE;
            ThemedReactContext themedReactContext = focusedInputObserver.context;
            List<EditText> allInputFields = viewHierarchyNavigator.getAllInputFields(themedReactContext != null ? ReactContextKt.getRootView(themedReactContext) : null);
            int iIndexOf = allInputFields.indexOf(view2);
            ThemedReactContext themedReactContext2 = focusedInputObserver.context;
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("current", iIndexOf);
            writableMapCreateMap.putInt("count", allInputFields.size());
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
            ThemedReactContextKt.emitEvent(themedReactContext2, "KeyboardController::focusDidSet", writableMapCreateMap);
        }
        if (view2 == null) {
            focusedInputObserver.dispatchEventToJS(FocusedInputObserverKt.getNoFocusedInputEvent());
        }
    }

    public final void syncUpLayout() {
        EditText editText = this.lastFocusedInput;
        if (editText == null) {
            return;
        }
        int[] screenLocation = ViewKt.getScreenLocation(editText);
        dispatchEventToJS(new FocusedInputLayoutChangedEventData(FloatKt.getDp(editText.getX()), FloatKt.getDp(editText.getY()), FloatKt.getDp(editText.getWidth()), FloatKt.getDp(editText.getHeight()), FloatKt.getDp(screenLocation[0]), FloatKt.getDp(screenLocation[1]), editText.getId(), EditTextKt.getParentScrollViewTarget(editText)));
    }

    public final void destroy() {
        this.view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.focusListener);
    }

    private final void dispatchEventToJS(FocusedInputLayoutChangedEventData event) {
        if (Intrinsics.areEqual(event, this.lastEventDispatched)) {
            return;
        }
        this.lastEventDispatched = event;
        ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new FocusedInputLayoutChangedEvent(this.surfaceId, this.eventPropagationView.getId(), event));
    }
}
