package expo.modules.kotlin.activityresult;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppContextActivityResultCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JR\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0007\"\b\b\u0000\u0010\b*\u00020\n\"\u0004\b\u0001\u0010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "activityResultsManager", "Lexpo/modules/kotlin/activityresult/ActivityResultsManager;", "<init>", "(Lexpo/modules/kotlin/activityresult/ActivityResultsManager;)V", "registerForActivityResult", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "I", "O", "Ljava/io/Serializable;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "(Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultAppContextActivityResultCaller implements AppContextActivityResultCaller {
    private final ActivityResultsManager activityResultsManager;

    public DefaultAppContextActivityResultCaller(ActivityResultsManager activityResultsManager) {
        Intrinsics.checkNotNullParameter(activityResultsManager, "activityResultsManager");
        this.activityResultsManager = activityResultsManager;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultCaller
    public <I extends Serializable, O> Object registerForActivityResult(AppContextActivityResultContract<I, O> appContextActivityResultContract, AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback, Continuation<? super AppContextActivityResultLauncher<I, O>> continuation) {
        return this.activityResultsManager.registerForActivityResult(appContextActivityResultContract, appContextActivityResultFallbackCallback, continuation);
    }
}
