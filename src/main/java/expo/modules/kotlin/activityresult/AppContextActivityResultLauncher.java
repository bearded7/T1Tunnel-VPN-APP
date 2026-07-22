package expo.modules.kotlin.activityresult;

import androidx.activity.result.ActivityResultCallback;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: AppContextActivityResultLauncher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH&¢\u0006\u0002\u0010\fJ\u0016\u0010\u0007\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\rR\u001e\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "I", "Ljava/io/Serializable;", "O", "", "<init>", "()V", "launch", "", "input", "callback", "Landroidx/activity/result/ActivityResultCallback;", "(Ljava/io/Serializable;Landroidx/activity/result/ActivityResultCallback;)V", "(Ljava/io/Serializable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "getContract", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppContextActivityResultLauncher<I extends Serializable, O> {
    public abstract AppContextActivityResultContract<I, O> getContract();

    public abstract void launch(I input, ActivityResultCallback<O> callback);

    public final Object launch(I i, Continuation<? super O> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        launch(i, new ActivityResultCallback() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultLauncher$launch$2$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<O> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m772constructorimpl(o));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
