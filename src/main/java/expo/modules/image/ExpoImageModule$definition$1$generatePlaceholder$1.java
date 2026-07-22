package expo.modules.image;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ExpoImageModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.image.ExpoImageModule", f = "ExpoImageModule.kt", i = {0}, l = {131, 134}, m = "definition$lambda$30$generatePlaceholder", n = {"encoder"}, s = {"L$0"})
final class ExpoImageModule$definition$1$generatePlaceholder$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ExpoImageModule$definition$1$generatePlaceholder$1(Continuation<? super ExpoImageModule$definition$1$generatePlaceholder$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExpoImageModule.definition$lambda$30$generatePlaceholder(null, null, null, this);
    }
}
