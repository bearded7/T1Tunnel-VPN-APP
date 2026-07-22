package expo.modules.imagepicker.contracts;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.core.net.UriKt;
import androidx.core.os.BundleKt;
import com.canhub.cropper.CropImage;
import com.canhub.cropper.CropImageOptions;
import com.canhub.cropper.CropImageView;
import expo.modules.imagepicker.CropShape;
import expo.modules.imagepicker.ExpoCropImageActivity;
import expo.modules.imagepicker.ImagePickerUtilsKt;
import expo.modules.imagepicker.MediaType;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import expo.modules.kotlin.providers.AppContextProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CropImageContract.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/imagepicker/contracts/CropImageContract;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "Lexpo/modules/imagepicker/contracts/CropImageContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "<init>", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CropImageContract implements AppContextActivityResultContract<CropImageContractOptions, ImagePickerContractResult> {
    private final AppContextProvider appContextProvider;

    /* JADX INFO: compiled from: CropImageContract.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CropShape.values().length];
            try {
                iArr[CropShape.RECTANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CropShape.OVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CropImageContract(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, CropImageContractOptions input) {
        Bitmap.CompressFormat bitmapCompressFormat;
        CropImageView.CropShape cropShape;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intent = new Intent(context, (Class<?>) ExpoCropImageActivity.class);
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        String type = ImagePickerUtilsKt.getType(contentResolver, Uri.parse(input.getSourceUri()));
        if (type == null || (bitmapCompressFormat = ImagePickerUtilsKt.toBitmapCompressFormat(type)) == null) {
            bitmapCompressFormat = Bitmap.CompressFormat.JPEG;
        }
        Uri uriFromFile = Uri.fromFile(ImagePickerUtilsKt.createOutputFile(this.appContextProvider.getAppContext().getCacheDirectory(), ImagePickerUtilsKt.toImageFileExtension(bitmapCompressFormat)));
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(CropImage.CROP_IMAGE_EXTRA_SOURCE, Uri.parse(input.getSourceUri()));
        CropImageOptions cropImageOptions = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
        cropImageOptions.outputCompressFormat = bitmapCompressFormat;
        cropImageOptions.outputCompressQuality = (int) (input.getOptions().getQuality() * ((double) 100));
        cropImageOptions.customOutputUri = uriFromFile;
        Pair<Integer, Integer> aspect = input.getOptions().getAspect();
        if (aspect != null) {
            int iIntValue = aspect.component1().intValue();
            int iIntValue2 = aspect.component2().intValue();
            cropImageOptions.aspectRatioX = iIntValue;
            cropImageOptions.aspectRatioY = iIntValue2;
            cropImageOptions.fixAspectRatio = true;
            cropImageOptions.initialCropWindowPaddingRatio = 0.0f;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[input.getOptions().getShape().ordinal()];
        if (i == 1) {
            cropShape = CropImageView.CropShape.RECTANGLE;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            cropShape = CropImageView.CropShape.OVAL;
        }
        cropImageOptions.cropShape = cropShape;
        Unit unit = Unit.INSTANCE;
        pairArr[1] = TuplesKt.to(CropImage.CROP_IMAGE_EXTRA_OPTIONS, cropImageOptions);
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE, BundleKt.bundleOf(pairArr));
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0022  */
    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public ImagePickerContractResult parseResult(CropImageContractOptions input, int resultCode, Intent intent) throws InterruptedException {
        CropImage.ActivityResult activityResult;
        Intrinsics.checkNotNullParameter(input, "input");
        if (Build.VERSION.SDK_INT >= 33) {
            if (intent != null) {
                activityResult = (CropImage.ActivityResult) intent.getParcelableExtra(CropImage.CROP_IMAGE_EXTRA_RESULT, CropImage.ActivityResult.class);
            } else {
                activityResult = null;
            }
        } else if (intent != null) {
            activityResult = (CropImage.ActivityResult) intent.getParcelableExtra(CropImage.CROP_IMAGE_EXTRA_RESULT);
        } else {
            activityResult = null;
        }
        if (resultCode == 0 || activityResult == null) {
            return ImagePickerContractResult.Cancelled.INSTANCE;
        }
        Uri uriContent = activityResult.getUriContent();
        if (uriContent == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext != null) {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(input, uriContent, reactContext.getContentResolver(), null), 1, null);
            return new ImagePickerContractResult.Success(CollectionsKt.listOf(TuplesKt.to(MediaType.IMAGE, uriContent)));
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.contracts.CropImageContract$parseResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: CropImageContract.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.contracts.CropImageContract$parseResult$1", f = "CropImageContract.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ CropImageContractOptions $input;
        final /* synthetic */ Uri $targetUri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CropImageContractOptions cropImageContractOptions, Uri uri, ContentResolver contentResolver, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = cropImageContractOptions;
            this.$targetUri = uri;
            this.$contentResolver = contentResolver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$input, this.$targetUri, this.$contentResolver, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Uri uri = Uri.parse(this.$input.getSourceUri());
                File file = UriKt.toFile(this.$targetUri);
                ContentResolver contentResolver = this.$contentResolver;
                Intrinsics.checkNotNull(contentResolver);
                this.label = 1;
                if (ImagePickerUtilsKt.copyExifData(uri, file, contentResolver, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
