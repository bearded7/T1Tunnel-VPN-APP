package coil3.svg.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: compiled from: utils.jvmCommon.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\b\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080H¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"runInterruptible", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-svg_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Utils_jvmCommonKt {
    public static final <T> Object runInterruptible(CoroutineContext coroutineContext, Function0<? extends T> function0, Continuation<? super T> continuation) {
        return InterruptibleKt.runInterruptible(coroutineContext, function0, continuation);
    }

    public static /* synthetic */ Object runInterruptible$default(CoroutineContext coroutineContext, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return InterruptibleKt.runInterruptible(coroutineContext, function0, continuation);
    }
}
