package expo.modules.filesystem;

import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FileSystemModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.FileSystemModule$definition$1$7", f = "FileSystemModule.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
final class FileSystemModule$definition$1$7 extends SuspendLambda implements Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<AppContextActivityResultLauncher<FilePickerContractOptions, FilePickerContractResult>> $filePickerLauncher;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FileSystemModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystemModule$definition$1$7(Ref.ObjectRef<AppContextActivityResultLauncher<FilePickerContractOptions, FilePickerContractResult>> objectRef, FileSystemModule fileSystemModule, Continuation<? super FileSystemModule$definition$1$7> continuation) {
        super(2, continuation);
        this.$filePickerLauncher = objectRef;
        this.this$0 = fileSystemModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FileSystemModule$definition$1$7 fileSystemModule$definition$1$7 = new FileSystemModule$definition$1$7(this.$filePickerLauncher, this.this$0, continuation);
        fileSystemModule$definition$1$7.L$0 = obj;
        return fileSystemModule$definition$1$7;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AppContextActivityResultCaller appContextActivityResultCaller, Continuation<? super Unit> continuation) {
        return ((FileSystemModule$definition$1$7) create(appContextActivityResultCaller, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef<AppContextActivityResultLauncher<FilePickerContractOptions, FilePickerContractResult>> objectRef;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppContextActivityResultCaller appContextActivityResultCaller = (AppContextActivityResultCaller) this.L$0;
            Ref.ObjectRef<AppContextActivityResultLauncher<FilePickerContractOptions, FilePickerContractResult>> objectRef2 = this.$filePickerLauncher;
            this.L$0 = objectRef2;
            this.label = 1;
            Object objRegisterForActivityResult$default = AppContextActivityResultCaller.DefaultImpls.registerForActivityResult$default(appContextActivityResultCaller, new FilePickerContract(this.this$0), null, this, 2, null);
            if (objRegisterForActivityResult$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            t = objRegisterForActivityResult$default;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
            t = obj;
        }
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}
