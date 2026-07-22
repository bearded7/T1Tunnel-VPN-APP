package expo.modules.image;

import expo.modules.image.records.ImageLoadOptions;
import expo.modules.image.records.SourceMap;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$5"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.image.ExpoImageModule$definition$lambda$30$$inlined$Coroutine$3", f = "ExpoImageModule.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
public final class ExpoImageModule$definition$lambda$30$$inlined$Coroutine$3 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ExpoImageModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoImageModule$definition$lambda$30$$inlined$Coroutine$3(Continuation continuation, ExpoImageModule expoImageModule) {
        super(3, continuation);
        this.this$0 = expoImageModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ExpoImageModule$definition$lambda$30$$inlined$Coroutine$3 expoImageModule$definition$lambda$30$$inlined$Coroutine$3 = new ExpoImageModule$definition$lambda$30$$inlined$Coroutine$3(continuation, this.this$0);
        expoImageModule$definition$lambda$30$$inlined$Coroutine$3.L$0 = objArr;
        return expoImageModule$definition$lambda$30$$inlined$Coroutine$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws ImageLoadFailed, Exceptions.ReactContextLost {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Object[] objArr = (Object[]) this.L$0;
        Object obj2 = objArr[0];
        ImageLoadOptions imageLoadOptions = (ImageLoadOptions) objArr[1];
        SourceMap sourceMap = (SourceMap) obj2;
        AppContext appContext = this.this$0.getAppContext();
        if (imageLoadOptions == null) {
            imageLoadOptions = new ImageLoadOptions(0, 0, 3, null);
        }
        ImageLoadTask imageLoadTask = new ImageLoadTask(appContext, sourceMap, imageLoadOptions);
        this.label = 1;
        Object objLoad = imageLoadTask.load(this);
        return objLoad == coroutine_suspended ? coroutine_suspended : objLoad;
    }
}
