package expo.modules.imagepicker.contracts;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import expo.modules.imagepicker.ImagePickerOptions;
import expo.modules.imagepicker.ImagePickerUtilsKt;
import expo.modules.imagepicker.MediaTypes;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.providers.AppContextProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLibraryContract.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImageLibraryContract;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "<init>", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "contentResolver", "Landroid/content/ContentResolver;", "getContentResolver", "()Landroid/content/ContentResolver;", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "createLegacyIntent", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageLibraryContract implements AppContextActivityResultContract<ImageLibraryContractOptions, ImagePickerContractResult> {
    private final AppContextProvider appContextProvider;

    /* JADX INFO: compiled from: ImageLibraryContract.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaTypes.values().length];
            try {
                iArr[MediaTypes.VIDEOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaTypes.IMAGES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ImageLibraryContract(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final ContentResolver getContentResolver() throws Exceptions.ReactContextLost {
        ContentResolver contentResolver;
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext == null || (contentResolver = reactContext.getContentResolver()) == null) {
            throw new Exceptions.ReactContextLost();
        }
        return contentResolver;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public Intent createIntent(Context context, ImageLibraryContractOptions input) {
        ActivityResultContracts.PickVisualMedia.VideoOnly videoOnly;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input.getOptions().getLegacy()) {
            return createLegacyIntent(input.getOptions());
        }
        PickVisualMediaRequest.Builder builder = new PickVisualMediaRequest.Builder();
        int i = WhenMappings.$EnumSwitchMapping$0[input.getOptions().getNativeMediaTypes().ordinal()];
        if (i == 1) {
            videoOnly = ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE;
        } else if (i == 2) {
            videoOnly = ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE;
        } else {
            videoOnly = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        PickVisualMediaRequest pickVisualMediaRequestBuild = builder.setMediaType(videoOnly).setOrderedSelection(input.getOptions().getOrderedSelection()).setDefaultTab(input.getOptions().getDefaultTab().toDefaultTab()).build();
        if (input.getOptions().getAllowsMultipleSelection()) {
            int selectionLimit = input.getOptions().getSelectionLimit();
            if (selectionLimit == 1) {
                return new ActivityResultContracts.PickVisualMedia().createIntent(context, pickVisualMediaRequestBuild);
            }
            if (selectionLimit > 1) {
                return new ActivityResultContracts.PickMultipleVisualMedia(selectionLimit).createIntent(context, pickVisualMediaRequestBuild);
            }
            if (selectionLimit == 0) {
                return new ActivityResultContracts.PickMultipleVisualMedia(0, 1, null).createIntent(context, pickVisualMediaRequestBuild);
            }
        }
        return new ActivityResultContracts.PickVisualMedia().createIntent(context, pickVisualMediaRequestBuild);
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultContract
    public ImagePickerContractResult parseResult(ImageLibraryContractOptions input, int resultCode, Intent intent) {
        List<Uri> allDataUris;
        ImagePickerContractResult.Error success;
        Intrinsics.checkNotNullParameter(input, "input");
        if (resultCode == 0) {
            return ImagePickerContractResult.Cancelled.INSTANCE;
        }
        if (intent != null) {
            Intent intent2 = resultCode == -1 ? intent : null;
            if (intent2 != null && (allDataUris = ImagePickerUtilsKt.getAllDataUris(intent2)) != null) {
                if (input.getOptions().getAllowsMultipleSelection()) {
                    List<Uri> list = allDataUris;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (Uri uri : list) {
                        arrayList.add(TuplesKt.to(ImagePickerUtilsKt.toMediaType(uri, getContentResolver()), uri));
                    }
                    ArrayList arrayListTake = arrayList;
                    if (input.getOptions().getSelectionLimit() > 0) {
                        arrayListTake = CollectionsKt.take(arrayListTake, input.getOptions().getSelectionLimit());
                    }
                    success = new ImagePickerContractResult.Success(arrayListTake);
                } else if (intent.getData() != null) {
                    Uri data = intent.getData();
                    success = data != null ? new ImagePickerContractResult.Success(CollectionsKt.listOf(TuplesKt.to(ImagePickerUtilsKt.toMediaType(data, getContentResolver()), data))) : null;
                } else {
                    Uri uri2 = (Uri) CollectionsKt.firstOrNull((List) allDataUris);
                    if (uri2 != null) {
                        success = new ImagePickerContractResult.Success(CollectionsKt.listOf(TuplesKt.to(ImagePickerUtilsKt.toMediaType(uri2, getContentResolver()), uri2)));
                    } else {
                        success = ImagePickerContractResult.Error.INSTANCE;
                    }
                }
                if (success != null) {
                    return success;
                }
            }
        }
        return ImagePickerContractResult.Error.INSTANCE;
    }

    private final Intent createLegacyIntent(ImagePickerOptions options) {
        String[] strArr;
        Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType("*/*");
        int i = WhenMappings.$EnumSwitchMapping$0[options.getNativeMediaTypes().ordinal()];
        if (i == 1) {
            strArr = new String[]{"video/*"};
        } else if (i == 2) {
            strArr = new String[]{"image/*"};
        } else {
            strArr = new String[]{"image/*", "video/*"};
        }
        Intent intentPutExtra = type.putExtra("android.intent.extra.MIME_TYPES", strArr);
        if (options.getAllowsMultipleSelection()) {
            intentPutExtra.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "apply(...)");
        return intentPutExtra;
    }
}
