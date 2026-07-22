package expo.modules.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ImageLoadTask.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.image.ImageLoadTask$load$bitmap$1", f = "ImageLoadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ImageLoadTask$load$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Drawable>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Object $model;
    int label;
    final /* synthetic */ ImageLoadTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageLoadTask$load$bitmap$1(Context context, Object obj, ImageLoadTask imageLoadTask, Continuation<? super ImageLoadTask$load$bitmap$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$model = obj;
        this.this$0 = imageLoadTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageLoadTask$load$bitmap$1(this.$context, this.$model, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Drawable> continuation) {
        return ((ImageLoadTask$load$bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Glide.with(this.$context).asDrawable().load(this.$model).centerInside().submit(this.this$0.options.getMaxWidth(), this.this$0.options.getMaxHeight()).get();
    }
}
