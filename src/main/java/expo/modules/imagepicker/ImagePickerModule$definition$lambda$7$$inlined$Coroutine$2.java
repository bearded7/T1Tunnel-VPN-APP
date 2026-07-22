package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.CameraContractOptions;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2", f = "ImagePickerModule.kt", i = {0, 1}, l = {272, 280}, m = "invokeSuspend", n = {"options", "tempFile"}, s = {"L$0", "L$0"})
public final class ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(Continuation continuation, ImagePickerModule imagePickerModule) {
        super(3, continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2 imagePickerModule$definition$lambda$7$$inlined$Coroutine$2 = new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(continuation, this.this$0);
        imagePickerModule$definition$lambda$7$$inlined$Coroutine$2.L$0 = objArr;
        return imagePickerModule$definition$lambda$7$$inlined$Coroutine$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ImagePickerOptions imagePickerOptions;
        File fileCreateOutputFile;
        File file;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                imagePickerOptions = (ImagePickerOptions) ((Object[]) this.L$0)[0];
                this.this$0.ensureTargetActivityIsAvailable(imagePickerOptions);
                ImagePickerModule imagePickerModule = this.this$0;
                this.L$0 = imagePickerOptions;
                this.label = 1;
                if (imagePickerModule.ensureCameraPermissionsAreGranted(this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file = (File) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    file.delete();
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    file.delete();
                    throw th;
                }
            }
            imagePickerOptions = (ImagePickerOptions) this.L$0;
            ResultKt.throwOnFailure(obj);
            String string = ImagePickerUtilsKt.toContentUri(fileCreateOutputFile, this.this$0.getContext()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            CameraContractOptions cameraContractOptions = imagePickerOptions.toCameraContractOptions(string);
            ImagePickerModule imagePickerModule2 = this.this$0;
            ImagePickerModule$definition$1$5$1 imagePickerModule$definition$1$5$1 = new ImagePickerModule$definition$1$5$1(this.this$0, cameraContractOptions, null);
            this.L$0 = fileCreateOutputFile;
            this.label = 2;
            Object objLaunchContract = imagePickerModule2.launchContract(imagePickerModule$definition$1$5$1, imagePickerOptions, this);
            if (objLaunchContract != coroutine_suspended) {
                file = fileCreateOutputFile;
                obj = objLaunchContract;
                file.delete();
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            file = fileCreateOutputFile;
            th = th3;
            file.delete();
            throw th;
        }
        fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(this.this$0.getCacheDirectory(), imagePickerOptions.getNativeMediaTypes().toFileExtension());
    }
}
