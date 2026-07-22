package expo.modules.image;

import android.graphics.Bitmap;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ExpoImageModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.image.ExpoImageModule$definition$1$generatePlaceholder$2", f = "ExpoImageModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ExpoImageModule$definition$1$generatePlaceholder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Function1<Bitmap, String> $encoder;
    final /* synthetic */ Image $image;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ExpoImageModule$definition$1$generatePlaceholder$2(Function1<? super Bitmap, String> function1, Image image, Continuation<? super ExpoImageModule$definition$1$generatePlaceholder$2> continuation) {
        super(2, continuation);
        this.$encoder = function1;
        this.$image = image;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpoImageModule$definition$1$generatePlaceholder$2(this.$encoder, this.$image, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ExpoImageModule$definition$1$generatePlaceholder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$encoder.invoke(DrawableKt.toBitmap$default(this.$image.getRef(), 0, 0, null, 7, null));
    }
}
