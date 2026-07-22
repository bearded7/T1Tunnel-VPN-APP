package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.PromiseImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: SuspendFunctionComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.kotlin.functions.SuspendFunctionComponent$attachToJSObject$2$1", f = "SuspendFunctionComponent.kt", i = {0}, l = {47}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class SuspendFunctionComponent$attachToJSObject$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppContext $appContext;
    final /* synthetic */ Object[] $args;
    final /* synthetic */ String $moduleName;
    final /* synthetic */ PromiseImpl $promiseImpl;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ SuspendFunctionComponent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendFunctionComponent$attachToJSObject$2$1(PromiseImpl promiseImpl, SuspendFunctionComponent suspendFunctionComponent, String str, Object[] objArr, AppContext appContext, Continuation<? super SuspendFunctionComponent$attachToJSObject$2$1> continuation) {
        super(2, continuation);
        this.$promiseImpl = promiseImpl;
        this.this$0 = suspendFunctionComponent;
        this.$moduleName = str;
        this.$args = objArr;
        this.$appContext = appContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuspendFunctionComponent$attachToJSObject$2$1 suspendFunctionComponent$attachToJSObject$2$1 = new SuspendFunctionComponent$attachToJSObject$2$1(this.$promiseImpl, this.this$0, this.$moduleName, this.$args, this.$appContext, continuation);
        suspendFunctionComponent$attachToJSObject$2$1.L$0 = obj;
        return suspendFunctionComponent$attachToJSObject$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendFunctionComponent$attachToJSObject$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:25:0x0071, B:27:0x0075, B:29:0x0079, B:32:0x00a1, B:33:0x00ac, B:30:0x0096, B:31:0x009e, B:13:0x0034), top: B:50:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0079 A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:25:0x0071, B:27:0x0075, B:29:0x0079, B:32:0x00a1, B:33:0x00ac, B:30:0x0096, B:31:0x009e, B:13:0x0034), top: B:50:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0096 A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:25:0x0071, B:27:0x0075, B:29:0x0079, B:32:0x00a1, B:33:0x00ac, B:30:0x0096, B:31:0x009e, B:13:0x0034), top: B:50:0x0034 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x009e A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:25:0x0071, B:27:0x0075, B:29:0x0079, B:32:0x00a1, B:33:0x00ac, B:30:0x0096, B:31:0x009e, B:13:0x0034), top: B:50:0x0034 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        String str;
        SuspendFunctionComponent suspendFunctionComponent;
        PromiseImpl promiseImpl;
        UnexpectedException unexpectedException;
        Throwable th;
        UnexpectedException unexpectedException2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                SuspendFunctionComponent suspendFunctionComponent2 = this.this$0;
                str = this.$moduleName;
                Object[] objArr = this.$args;
                AppContext appContext = this.$appContext;
                PromiseImpl promiseImpl2 = this.$promiseImpl;
                try {
                    Function3 function3 = suspendFunctionComponent2.body;
                    Object[] objArrConvertArgs$default = AnyFunction.convertArgs$default(suspendFunctionComponent2, objArr, appContext, false, 4, null);
                    this.L$0 = coroutineScope;
                    this.L$1 = suspendFunctionComponent2;
                    this.L$2 = str;
                    this.L$3 = promiseImpl2;
                    this.label = 1;
                    Object objInvoke = function3.invoke(coroutineScope, objArrConvertArgs$default, this);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    suspendFunctionComponent = suspendFunctionComponent2;
                    obj = objInvoke;
                    promiseImpl = promiseImpl2;
                } catch (Throwable th2) {
                    th = th2;
                    suspendFunctionComponent = suspendFunctionComponent2;
                    th = th;
                    if (!(th instanceof CodedException)) {
                        unexpectedException2 = (CodedException) th;
                    } else if (th instanceof expo.modules.core.errors.CodedException) {
                        String code = ((expo.modules.core.errors.CodedException) th).getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        unexpectedException2 = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                    } else {
                        unexpectedException2 = new UnexpectedException(th);
                    }
                    throw new FunctionCallException(suspendFunctionComponent.getName(), str, unexpectedException2);
                }
            } catch (Throwable th3) {
                if (this.$promiseImpl.getWasSettled()) {
                    throw th3;
                }
                PromiseImpl promiseImpl3 = this.$promiseImpl;
                if (th3 instanceof CodedException) {
                    unexpectedException = (CodedException) th3;
                } else if (th3 instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th3;
                    String code2 = codedException.getCode();
                    Intrinsics.checkNotNullExpressionValue(code2, "getCode(...)");
                    unexpectedException = new CodedException(code2, codedException.getMessage(), codedException.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th3);
                }
                promiseImpl3.reject(unexpectedException);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            promiseImpl = (PromiseImpl) this.L$3;
            str = (String) this.L$2;
            suspendFunctionComponent = (SuspendFunctionComponent) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (!(th instanceof CodedException)) {
                    unexpectedException2 = (CodedException) th;
                } else if (th instanceof expo.modules.core.errors.CodedException) {
                    String code3 = ((expo.modules.core.errors.CodedException) th).getCode();
                    Intrinsics.checkNotNullExpressionValue(code3, "getCode(...)");
                    unexpectedException2 = new CodedException(code3, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                } else {
                    unexpectedException2 = new UnexpectedException(th);
                }
                throw new FunctionCallException(suspendFunctionComponent.getName(), str, unexpectedException2);
            }
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            promiseImpl.resolve(obj);
        }
        Unit unit = Unit.INSTANCE;
        return Unit.INSTANCE;
    }
}
