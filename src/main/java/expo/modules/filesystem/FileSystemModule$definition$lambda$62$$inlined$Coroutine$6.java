package expo.modules.filesystem;

import android.net.Uri;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$6", f = "FileSystemModule.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
public final class FileSystemModule$definition$lambda$62$$inlined$Coroutine$6 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    final /* synthetic */ Ref.ObjectRef $filePickerLauncher$inlined;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$62$$inlined$Coroutine$6(Continuation continuation, Ref.ObjectRef objectRef) {
        super(3, continuation);
        this.$filePickerLauncher$inlined = objectRef;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        FileSystemModule$definition$lambda$62$$inlined$Coroutine$6 fileSystemModule$definition$lambda$62$$inlined$Coroutine$6 = new FileSystemModule$definition$lambda$62$$inlined$Coroutine$6(continuation, this.$filePickerLauncher$inlined);
        fileSystemModule$definition$lambda$62$$inlined$Coroutine$6.L$0 = objArr;
        return fileSystemModule$definition$lambda$62$$inlined$Coroutine$6.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PickerCancelledException {
        AppContextActivityResultLauncher appContextActivityResultLauncher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Uri uri = (Uri) ((Object[]) this.L$0)[0];
            if (this.$filePickerLauncher$inlined.element == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("filePickerLauncher");
                appContextActivityResultLauncher = null;
            } else {
                appContextActivityResultLauncher = (AppContextActivityResultLauncher) this.$filePickerLauncher$inlined.element;
            }
            FilePickerContractOptions filePickerContractOptions = new FilePickerContractOptions(uri, null, PickerType.DIRECTORY);
            this.label = 1;
            obj = appContextActivityResultLauncher.launch(filePickerContractOptions, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        FilePickerContractResult filePickerContractResult = (FilePickerContractResult) obj;
        if (filePickerContractResult instanceof FilePickerContractResult.Success) {
            FileSystemPath path = ((FilePickerContractResult.Success) filePickerContractResult).getPath();
            Intrinsics.checkNotNull(path, "null cannot be cast to non-null type expo.modules.filesystem.FileSystemDirectory");
            return (FileSystemDirectory) path;
        }
        if (filePickerContractResult instanceof FilePickerContractResult.Cancelled) {
            throw new PickerCancelledException();
        }
        throw new NoWhenBranchMatchedException();
    }
}
