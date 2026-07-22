package expo.modules.kotlin.objects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropertyComponentBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
public final class PropertyComponentBuilderWithThis$get$1$1 implements Function1<Object[], Object> {
    final /* synthetic */ Function1<ThisType, R> $body;

    /* JADX WARN: Multi-variable type inference failed */
    public PropertyComponentBuilderWithThis$get$1$1(Function1<? super ThisType, ? extends R> function1) {
        this.$body = function1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this.$body.invoke((ThisType) it[0]);
    }
}
