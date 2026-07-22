package expo.modules.kotlin.objects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropertyComponentBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
public final class PropertyComponentBuilder$get$1$1 implements Function1<Object[], Object> {
    final /* synthetic */ Function0<R> $body;

    /* JADX WARN: Multi-variable type inference failed */
    public PropertyComponentBuilder$get$1$1(Function0<? extends R> function0) {
        this.$body = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this.$body.invoke();
    }
}
