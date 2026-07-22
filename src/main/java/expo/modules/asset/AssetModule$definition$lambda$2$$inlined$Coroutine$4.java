package expo.modules.asset;

import android.net.Uri;
import expo.modules.kotlin.AppContext;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$7"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.asset.AssetModule$definition$lambda$2$$inlined$Coroutine$4", f = "AssetModule.kt", i = {}, l = {281, 288}, m = "invokeSuspend", n = {}, s = {})
public final class AssetModule$definition$lambda$2$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AssetModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssetModule$definition$lambda$2$$inlined$Coroutine$4(Continuation continuation, AssetModule assetModule) {
        super(3, continuation);
        this.this$0 = assetModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        AssetModule$definition$lambda$2$$inlined$Coroutine$4 assetModule$definition$lambda$2$$inlined$Coroutine$4 = new AssetModule$definition$lambda$2$$inlined$Coroutine$4(continuation, this.this$0);
        assetModule$definition$lambda$2$$inlined$Coroutine$4.L$0 = objArr;
        return assetModule$definition$lambda$2$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws UnableToDownloadAssetException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Object[] objArr = (Object[]) this.L$0;
        Object obj2 = objArr[0];
        Object obj3 = objArr[1];
        String str = (String) objArr[2];
        String str2 = (String) obj3;
        URI uri = (URI) obj2;
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (!StringsKt.startsWith$default(string, ResourceAssetKt.ANDROID_EMBEDDED_URL_BASE_RESOURCE, false, 2, (Object) null)) {
                return uri;
            }
        }
        File file = new File(this.this$0.getAppContext().getCacheDirectory() + "/ExponentAsset-" + (str2 == null ? this.this$0.getMD5HashOfFilePath(uri) : str2) + "." + str);
        if (!file.exists()) {
            AssetModule assetModule = this.this$0;
            AppContext appContext = assetModule.getAppContext();
            this.label = 1;
            Object objDownloadAsset = assetModule.downloadAsset(appContext, uri, file, this);
            if (objDownloadAsset != coroutine_suspended) {
                return objDownloadAsset;
            }
        } else {
            if (str2 == null || Intrinsics.areEqual(str2, FileUtilsKt.getMD5HashOfFileContent(file))) {
                return Uri.fromFile(file);
            }
            AssetModule assetModule2 = this.this$0;
            AppContext appContext2 = assetModule2.getAppContext();
            this.label = 2;
            Object objDownloadAsset2 = assetModule2.downloadAsset(appContext2, uri, file, this);
            if (objDownloadAsset2 != coroutine_suspended) {
                return objDownloadAsset2;
            }
        }
        return coroutine_suspended;
    }
}
