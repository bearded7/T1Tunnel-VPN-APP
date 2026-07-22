package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactStylesDiffMapHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\"\u001b\u0010\u0000\u001a\u00020\u00018CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"backingMapField", "Ljava/lang/reflect/Field;", "getBackingMapField", "()Ljava/lang/reflect/Field;", "backingMapField$delegate", "Lkotlin/Lazy;", "getBackingMap", "Lcom/facebook/react/bridge/ReadableMap;", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ReactStylesDiffMapHelperKt {
    private static final Lazy backingMapField$delegate = LazyKt.lazy(new Function0() { // from class: com.facebook.react.uimanager.ReactStylesDiffMapHelperKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ReactStylesDiffMapHelperKt.backingMapField_delegate$lambda$1();
        }
    });

    private static final Field getBackingMapField() {
        Object value = backingMapField$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Field) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Field backingMapField_delegate$lambda$1() throws NoSuchFieldException {
        Field declaredField = ReactStylesDiffMap.class.getDeclaredField("backingMap");
        declaredField.setAccessible(true);
        return declaredField;
    }

    public static final ReadableMap getBackingMap(ReactStylesDiffMap reactStylesDiffMap) {
        Intrinsics.checkNotNullParameter(reactStylesDiffMap, "<this>");
        try {
            Object obj = getBackingMapField().get(reactStylesDiffMap);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
            return (ReadableMap) obj;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Unable to access internal_backingMap via reflection", e);
        }
    }
}
