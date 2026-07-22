package com.reactnativekeyboardcontroller.extensions;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.textinput.ReactEditText;
import com.google.android.gms.common.internal.ImagesContract;
import com.reactnativekeyboardcontroller.log.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: EditText.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u001a\f\u0010\u000b\u001a\u00020\u0006*\u0004\u0018\u00010\u0002\u001a\u009e\u0001\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010*\u00020\u00022\u008b\u0001\u0010\u0003\u001a\u0086\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0011\"\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0017\u0010\f\u001a\u00020\u0005*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"addOnTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/EditText;", "action", "Lkotlin/Function1;", "", "", "parentScrollViewTarget", "", "getParentScrollViewTarget", "(Landroid/widget/EditText;)I", "focus", "keyboardType", "getKeyboardType", "(Landroid/widget/EditText;)Ljava/lang/String;", "addOnSelectionChangedListener", "Lkotlin/Function0;", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", ViewProps.START, ViewProps.END, "", "startX", "startY", "endX", "endY", "react-native-keyboard-controller_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EditTextKt {
    public static final TextWatcher addOnTextChangedListener(EditText editText, final Function1<? super String, Unit> action) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TextWatcher textWatcher = new TextWatcher() { // from class: com.reactnativekeyboardcontroller.extensions.EditTextKt$addOnTextChangedListener$listener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.lang.String] */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ?? ValueOf = String.valueOf(s);
                if (Intrinsics.areEqual((Object) ValueOf, objectRef.element)) {
                    return;
                }
                objectRef.element = ValueOf;
                action.invoke(ValueOf);
            }
        };
        try {
            Field declaredField = ReactEditText.class.getDeclaredField("mListeners");
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(editText);
            ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
            if (arrayList != null) {
                ArrayList arrayList2 = arrayList;
                if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!(it.next() instanceof TextWatcher)) {
                                Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because `fieldValue` does not belong to `ArrayList<TextWatcher>`", null, 4, null);
                            }
                        }
                    }
                }
                arrayList.add(0, textWatcher);
            } else {
                Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because `fieldValue` does not belong to `ArrayList<TextWatcher>`", null, 4, null);
            }
        } catch (ClassCastException e) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because casting failed: " + e.getMessage(), null, 4, null);
        } catch (IllegalArgumentException e2) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener to be the first in the list: " + e2.getMessage() + ". Attaching to the end...", null, 4, null);
            editText.addTextChangedListener(textWatcher);
        } catch (NoSuchFieldException e3) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because field `mListeners` not found: " + e3.getMessage(), null, 4, null);
        }
        return textWatcher;
    }

    public static final int getParentScrollViewTarget(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        EditText editText2 = editText;
        while (editText2 != null) {
            Object parent = editText2.getParent();
            editText2 = parent instanceof View ? (View) parent : null;
            if (editText2 instanceof ReactScrollView) {
                ReactScrollView reactScrollView = (ReactScrollView) editText2;
                if (reactScrollView.getScrollEnabled()) {
                    return reactScrollView.getId();
                }
            }
        }
        return -1;
    }

    public static final void focus(EditText editText) {
        if (editText instanceof ReactEditText) {
            ((ReactEditText) editText).requestFocusFromJS();
        } else if (editText != null) {
            editText.requestFocus();
        }
    }

    public static final String getKeyboardType(EditText editText) {
        if (editText == null) {
            return Constants.COLLATION_DEFAULT;
        }
        int inputType = editText.getInputType() & 15;
        int inputType2 = editText.getInputType() & 4080;
        if (inputType2 == 32) {
            return "email-address";
        }
        if (inputType2 == 16) {
            return ImagesContract.URL;
        }
        if (inputType2 == 144) {
            return "visible-password";
        }
        if (inputType != 2) {
            if (inputType != 3) {
                return Constants.COLLATION_DEFAULT;
            }
            return "phone-pad";
        }
        if ((editText.getInputType() & 8192) == 0 || (editText.getInputType() & 4096) != 0) {
            return (editText.getInputType() & 4096) != 0 ? Constants.COLLATION_OPTION_NUMERIC : "number-pad";
        }
        return "decimal-pad";
    }

    public static final Function0<Unit> addOnSelectionChangedListener(EditText editText, Function6<? super Integer, ? super Integer, ? super Double, ? super Double, ? super Double, ? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final KeyboardControllerSelectionWatcher keyboardControllerSelectionWatcher = new KeyboardControllerSelectionWatcher(editText, action);
        keyboardControllerSelectionWatcher.setup();
        return new Function0() { // from class: com.reactnativekeyboardcontroller.extensions.EditTextKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditTextKt.addOnSelectionChangedListener$lambda$1(keyboardControllerSelectionWatcher);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addOnSelectionChangedListener$lambda$1(KeyboardControllerSelectionWatcher keyboardControllerSelectionWatcher) {
        keyboardControllerSelectionWatcher.destroy();
        return Unit.INSTANCE;
    }
}
