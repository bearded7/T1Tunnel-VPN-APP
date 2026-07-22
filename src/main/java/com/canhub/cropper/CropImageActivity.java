package com.canhub.cropper;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.canhub.cropper.databinding.CropImageActivityBinding;
import com.canhub.cropper.utils.GetUriForFileKt;
import com.facebook.react.uimanager.ViewProps;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CropImageActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Deprecated(message = "\n  Create your own Activity and use the CropImageView directly.\n  This way you can customize everything and have utter control of everything.\n  Feel free to use this Activity Code to create your own Activity.\n")
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002GHB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\u001c\u0010\u001e\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140\u001fH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0016H\u0014J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u0007H\u0014J-\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00072\u000e\u00100\u001a\n\u0018\u000102j\u0004\u0018\u0001`1H\u0016¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0014H\u0016J\u0010\u00108\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;H\u0016J/\u0010<\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u00010\u00072\u000e\u00100\u001a\n\u0018\u000102j\u0004\u0018\u0001`12\u0006\u0010=\u001a\u00020;H\u0016¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\u0014H\u0016J/\u0010@\u001a\u00020A2\b\u0010/\u001a\u0004\u0018\u00010\u00072\u000e\u00100\u001a\n\u0018\u000102j\u0004\u0018\u0001`12\u0006\u0010=\u001a\u00020;H\u0016¢\u0006\u0002\u0010BJ \u0010C\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020;H\u0016J \u0010F\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020;H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/canhub/cropper/CropImageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/canhub/cropper/CropImageView$OnSetImageUriCompleteListener;", "Lcom/canhub/cropper/CropImageView$OnCropImageCompleteListener;", "<init>", "()V", "cropImageUri", "Landroid/net/Uri;", "cropImageOptions", "Lcom/canhub/cropper/CropImageOptions;", "cropImageView", "Lcom/canhub/cropper/CropImageView;", "binding", "Lcom/canhub/cropper/databinding/CropImageActivityBinding;", "latestTmpUri", "pickImageGallery", "Landroidx/activity/result/ActivityResultLauncher;", "", "takePicture", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setCustomizations", "showIntentChooser", "openSource", "source", "Lcom/canhub/cropper/CropImageActivity$Source;", "openCamera", "getTmpFileUri", "showImageSourceDialog", "Lkotlin/Function1;", "onStart", "onStop", "onSaveInstanceState", "outState", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPickImageResult", "resultUri", "onSetImageUriComplete", "view", "uri", "error", "Lkotlin/Exception;", "Ljava/lang/Exception;", "(Lcom/canhub/cropper/CropImageView;Landroid/net/Uri;Ljava/lang/Exception;)V", "onCropImageComplete", "result", "Lcom/canhub/cropper/CropImageView$CropResult;", "cropImage", "setCropImageView", "rotateImage", "degrees", "", "setResult", "sampleSize", "(Landroid/net/Uri;Ljava/lang/Exception;I)V", "setResultCancel", "getResultIntent", "Landroid/content/Intent;", "(Landroid/net/Uri;Ljava/lang/Exception;I)Landroid/content/Intent;", "updateMenuItemIconColor", "itemId", ViewProps.COLOR, "updateMenuItemTextColor", "Source", "Companion", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class CropImageActivity extends AppCompatActivity implements CropImageView.OnSetImageUriCompleteListener, CropImageView.OnCropImageCompleteListener {

    @Deprecated
    public static final String BUNDLE_KEY_TMP_URI = "bundle_key_tmp_uri";
    private static final Companion Companion = new Companion(null);
    private CropImageActivityBinding binding;
    private CropImageOptions cropImageOptions;
    private Uri cropImageUri;
    private CropImageView cropImageView;
    private Uri latestTmpUri;
    private final ActivityResultLauncher<String> pickImageGallery = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda0
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            CropImageActivity.pickImageGallery$lambda$0(this.f$0, (Uri) obj);
        }
    });
    private final ActivityResultLauncher<Uri> takePicture = registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            CropImageActivity.takePicture$lambda$1(this.f$0, ((Boolean) obj).booleanValue());
        }
    });

    /* JADX INFO: compiled from: CropImageActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/canhub/cropper/CropImageActivity$Source;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "GALLERY", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public enum Source {
        CAMERA,
        GALLERY;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Source> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: CropImageActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Source.values().length];
            try {
                iArr[Source.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Source.GALLERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pickImageGallery$lambda$0(CropImageActivity this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onPickImageResult(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takePicture$lambda$1(CropImageActivity this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.onPickImageResult(this$0.latestTmpUri);
        } else {
            this$0.onPickImageResult(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006b  */
    /* JADX WARN: Code duplicated, block: B:50:0x014c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0150  */
    /* JADX WARN: Code duplicated, block: B:55:0x0158  */
    /* JADX WARN: Code duplicated, block: B:56:0x0160  */
    /* JADX WARN: Code duplicated, block: B:58:0x0164  */
    /* JADX WARN: Code duplicated, block: B:59:0x0168  */
    /* JADX WARN: Code duplicated, block: B:62:0x016d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0171  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws IOException {
        Uri uri;
        CropImageOptions cropImageOptions;
        CropImageOptions cropImageOptions2;
        CropImageOptions cropImageOptions3;
        super.onCreate(savedInstanceState);
        CropImageActivityBinding cropImageActivityBindingInflate = CropImageActivityBinding.inflate(getLayoutInflater());
        this.binding = cropImageActivityBindingInflate;
        CropImageOptions cropImageOptions4 = null;
        if (cropImageActivityBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cropImageActivityBindingInflate = null;
        }
        setContentView(cropImageActivityBindingInflate.getRoot());
        CropImageActivityBinding cropImageActivityBinding = this.binding;
        if (cropImageActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cropImageActivityBinding = null;
        }
        CropImageView cropImageView = cropImageActivityBinding.cropImageView;
        Intrinsics.checkNotNullExpressionValue(cropImageView, "cropImageView");
        setCropImageView(cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra(CropImage.CROP_IMAGE_EXTRA_BUNDLE);
        if (bundleExtra != null) {
            Parcelable parcelable = bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_SOURCE);
            if (!(parcelable instanceof Uri)) {
                parcelable = null;
            }
            uri = (Uri) parcelable;
        } else {
            uri = null;
        }
        this.cropImageUri = uri;
        if (bundleExtra != null) {
            Parcelable parcelable2 = bundleExtra.getParcelable(CropImage.CROP_IMAGE_EXTRA_OPTIONS);
            if (!(parcelable2 instanceof CropImageOptions)) {
                parcelable2 = null;
            }
            cropImageOptions = (CropImageOptions) parcelable2;
            if (cropImageOptions == null) {
                cropImageOptions = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
            }
        } else {
            cropImageOptions = new CropImageOptions(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
        }
        this.cropImageOptions = cropImageOptions;
        if (savedInstanceState == null) {
            Uri uri2 = this.cropImageUri;
            if (uri2 == null || Intrinsics.areEqual(uri2, Uri.EMPTY)) {
                CropImageOptions cropImageOptions5 = this.cropImageOptions;
                if (cropImageOptions5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                    cropImageOptions5 = null;
                }
                if (cropImageOptions5.showIntentChooser) {
                    showIntentChooser();
                } else {
                    CropImageOptions cropImageOptions6 = this.cropImageOptions;
                    if (cropImageOptions6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                        cropImageOptions6 = null;
                    }
                    if (cropImageOptions6.imageSourceIncludeGallery) {
                        CropImageOptions cropImageOptions7 = this.cropImageOptions;
                        if (cropImageOptions7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                            cropImageOptions7 = null;
                        }
                        if (cropImageOptions7.imageSourceIncludeCamera) {
                            showImageSourceDialog(new AnonymousClass1(this));
                        } else {
                            cropImageOptions2 = this.cropImageOptions;
                            if (cropImageOptions2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                                cropImageOptions2 = null;
                            }
                            if (cropImageOptions2.imageSourceIncludeGallery) {
                                this.pickImageGallery.launch("image/*");
                            } else {
                                cropImageOptions3 = this.cropImageOptions;
                                if (cropImageOptions3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                                } else {
                                    cropImageOptions4 = cropImageOptions3;
                                }
                                if (cropImageOptions4.imageSourceIncludeCamera) {
                                    openCamera();
                                } else {
                                    finish();
                                }
                            }
                        }
                    } else {
                        cropImageOptions2 = this.cropImageOptions;
                        if (cropImageOptions2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                            cropImageOptions2 = null;
                        }
                        if (cropImageOptions2.imageSourceIncludeGallery) {
                            this.pickImageGallery.launch("image/*");
                        } else {
                            cropImageOptions3 = this.cropImageOptions;
                            if (cropImageOptions3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                            } else {
                                cropImageOptions4 = cropImageOptions3;
                            }
                            if (cropImageOptions4.imageSourceIncludeCamera) {
                                openCamera();
                            } else {
                                finish();
                            }
                        }
                    }
                }
            } else {
                CropImageView cropImageView2 = this.cropImageView;
                if (cropImageView2 != null) {
                    cropImageView2.setImageUriAsync(this.cropImageUri);
                }
            }
        } else {
            String string = savedInstanceState.getString(BUNDLE_KEY_TMP_URI);
            this.latestTmpUri = string != null ? Uri.parse(string) : null;
        }
        setCustomizations();
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), null, false, new Function1() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CropImageActivity.onCreate$lambda$2(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 3, null);
    }

    /* JADX INFO: renamed from: com.canhub.cropper.CropImageActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: CropImageActivity.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Source, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, CropImageActivity.class, "openSource", "openSource(Lcom/canhub/cropper/CropImageActivity$Source;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Source source) throws IOException {
            invoke2(source);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Source p0) throws IOException {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((CropImageActivity) this.receiver).openSource(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(CropImageActivity this$0, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        this$0.setResultCancel();
        return Unit.INSTANCE;
    }

    private final void setCustomizations() {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        int i = cropImageOptions.activityBackgroundColor;
        CropImageActivityBinding cropImageActivityBinding = this.binding;
        if (cropImageActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cropImageActivityBinding = null;
        }
        cropImageActivityBinding.getRoot().setBackgroundColor(i);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions3 = null;
            }
            CharSequence charSequence = cropImageOptions3.activityTitle;
            if (charSequence.length() == 0) {
            }
            setTitle(charSequence);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            CropImageOptions cropImageOptions4 = this.cropImageOptions;
            if (cropImageOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions4 = null;
            }
            Integer num = cropImageOptions4.toolbarColor;
            if (num != null) {
                supportActionBar.setBackgroundDrawable(new ColorDrawable(num.intValue()));
            }
            CropImageOptions cropImageOptions5 = this.cropImageOptions;
            if (cropImageOptions5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions5 = null;
            }
            Integer num2 = cropImageOptions5.toolbarTitleColor;
            if (num2 != null) {
                int iIntValue = num2.intValue();
                SpannableString spannableString = new SpannableString(getTitle());
                spannableString.setSpan(new ForegroundColorSpan(iIntValue), 0, spannableString.length(), 33);
                setTitle(spannableString);
            }
            CropImageOptions cropImageOptions6 = this.cropImageOptions;
            if (cropImageOptions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions2 = cropImageOptions6;
            }
            Integer num3 = cropImageOptions2.toolbarBackButtonColor;
            if (num3 != null) {
                int iIntValue2 = num3.intValue();
                try {
                    Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_24);
                    if (drawable != null) {
                        drawable.setColorFilter(new PorterDuffColorFilter(iIntValue2, PorterDuff.Mode.SRC_ATOP));
                    }
                    supportActionBar.setHomeAsUpIndicator(drawable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final void showIntentChooser() {
        CropImageIntentChooser cropImageIntentChooser = new CropImageIntentChooser(this, new CropImageIntentChooser.ResultCallback() { // from class: com.canhub.cropper.CropImageActivity$showIntentChooser$ciIntentChooser$1
            @Override // com.canhub.cropper.CropImageIntentChooser.ResultCallback
            public void onSuccess(Uri uri) {
                this.this$0.onPickImageResult(uri);
            }

            @Override // com.canhub.cropper.CropImageIntentChooser.ResultCallback
            public void onCancelled() {
                this.this$0.setResultCancel();
            }
        });
        CropImageOptions cropImageOptions = this.cropImageOptions;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        String str = cropImageOptions.intentChooserTitle;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                cropImageIntentChooser.setIntentChooserTitle(str);
            }
        }
        List<String> list = cropImageOptions.intentChooserPriorityList;
        if (list != null) {
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null) {
                cropImageIntentChooser.setupPriorityAppsList(list);
            }
        }
        cropImageIntentChooser.showChooserIntent(cropImageOptions.imageSourceIncludeCamera, cropImageOptions.imageSourceIncludeGallery, cropImageOptions.imageSourceIncludeCamera ? getTmpFileUri() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSource(Source source) throws IOException {
        int i = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
        if (i == 1) {
            openCamera();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.pickImageGallery.launch("image/*");
        }
    }

    private final void openCamera() throws IOException {
        Uri tmpFileUri = getTmpFileUri();
        this.latestTmpUri = tmpFileUri;
        this.takePicture.launch(tmpFileUri);
    }

    private final Uri getTmpFileUri() throws IOException {
        File fileCreateTempFile = File.createTempFile("tmp_image_file", ".png", getCacheDir());
        fileCreateTempFile.createNewFile();
        fileCreateTempFile.deleteOnExit();
        Intrinsics.checkNotNull(fileCreateTempFile);
        return GetUriForFileKt.getUriForFile(this, fileCreateTempFile);
    }

    public void showImageSourceDialog(final Function1<? super Source, Unit> openSource) {
        Intrinsics.checkNotNullParameter(openSource, "openSource");
        new AlertDialog.Builder(this).setCancelable(false).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return CropImageActivity.showImageSourceDialog$lambda$16(this.f$0, dialogInterface, i, keyEvent);
            }
        }).setTitle(R.string.pick_image_chooser_title).setItems(new String[]{getString(R.string.pick_image_camera), getString(R.string.pick_image_gallery)}, new DialogInterface.OnClickListener() { // from class: com.canhub.cropper.CropImageActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CropImageActivity.showImageSourceDialog$lambda$17(openSource, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showImageSourceDialog$lambda$16(CropImageActivity this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 4 && keyEvent.getAction() == 1) {
            this$0.setResultCancel();
            this$0.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showImageSourceDialog$lambda$17(Function1 openSource, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(openSource, "$openSource");
        openSource.invoke(i == 0 ? Source.CAMERA : Source.GALLERY);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(this);
        }
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(null);
        }
        CropImageView cropImageView2 = this.cropImageView;
        if (cropImageView2 != null) {
            cropImageView2.setOnCropImageCompleteListener(null);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_KEY_TMP_URI, String.valueOf(this.latestTmpUri));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Drawable drawable;
        Drawable drawable2;
        Intrinsics.checkNotNullParameter(menu, "menu");
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        if (cropImageOptions.skipEditing) {
            return true;
        }
        getMenuInflater().inflate(R.menu.crop_image_menu, menu);
        CropImageOptions cropImageOptions3 = this.cropImageOptions;
        if (cropImageOptions3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions3 = null;
        }
        if (!cropImageOptions3.allowRotation) {
            menu.removeItem(R.id.ic_rotate_left_24);
            menu.removeItem(R.id.ic_rotate_right_24);
        } else {
            CropImageOptions cropImageOptions4 = this.cropImageOptions;
            if (cropImageOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions4 = null;
            }
            if (cropImageOptions4.allowCounterRotation) {
                menu.findItem(R.id.ic_rotate_left_24).setVisible(true);
            }
        }
        CropImageOptions cropImageOptions5 = this.cropImageOptions;
        if (cropImageOptions5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions5 = null;
        }
        if (!cropImageOptions5.allowFlipping) {
            menu.removeItem(R.id.ic_flip_24);
        }
        CropImageOptions cropImageOptions6 = this.cropImageOptions;
        if (cropImageOptions6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions6 = null;
        }
        if (cropImageOptions6.cropMenuCropButtonTitle != null) {
            MenuItem menuItemFindItem = menu.findItem(R.id.crop_image_menu_crop);
            CropImageOptions cropImageOptions7 = this.cropImageOptions;
            if (cropImageOptions7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions7 = null;
            }
            menuItemFindItem.setTitle(cropImageOptions7.cropMenuCropButtonTitle);
        }
        try {
            CropImageOptions cropImageOptions8 = this.cropImageOptions;
            if (cropImageOptions8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions8 = null;
            }
            if (cropImageOptions8.cropMenuCropButtonIcon != 0) {
                CropImageActivity cropImageActivity = this;
                CropImageOptions cropImageOptions9 = this.cropImageOptions;
                if (cropImageOptions9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                    cropImageOptions9 = null;
                }
                drawable2 = ContextCompat.getDrawable(cropImageActivity, cropImageOptions9.cropMenuCropButtonIcon);
                try {
                    menu.findItem(R.id.crop_image_menu_crop).setIcon(drawable2);
                } catch (Exception e) {
                    drawable = drawable2;
                    e = e;
                    Log.w("AIC", "Failed to read menu crop drawable", e);
                    drawable2 = drawable;
                }
            } else {
                drawable2 = null;
            }
        } catch (Exception e2) {
            e = e2;
            drawable = null;
        }
        CropImageOptions cropImageOptions10 = this.cropImageOptions;
        if (cropImageOptions10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions10 = null;
        }
        if (cropImageOptions10.activityMenuIconColor != 0) {
            int i = R.id.ic_rotate_left_24;
            CropImageOptions cropImageOptions11 = this.cropImageOptions;
            if (cropImageOptions11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions11 = null;
            }
            updateMenuItemIconColor(menu, i, cropImageOptions11.activityMenuIconColor);
            int i2 = R.id.ic_rotate_right_24;
            CropImageOptions cropImageOptions12 = this.cropImageOptions;
            if (cropImageOptions12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions12 = null;
            }
            updateMenuItemIconColor(menu, i2, cropImageOptions12.activityMenuIconColor);
            int i3 = R.id.ic_flip_24;
            CropImageOptions cropImageOptions13 = this.cropImageOptions;
            if (cropImageOptions13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions13 = null;
            }
            updateMenuItemIconColor(menu, i3, cropImageOptions13.activityMenuIconColor);
            if (drawable2 != null) {
                int i4 = R.id.crop_image_menu_crop;
                CropImageOptions cropImageOptions14 = this.cropImageOptions;
                if (cropImageOptions14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                    cropImageOptions14 = null;
                }
                updateMenuItemIconColor(menu, i4, cropImageOptions14.activityMenuIconColor);
            }
        }
        CropImageOptions cropImageOptions15 = this.cropImageOptions;
        if (cropImageOptions15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
        } else {
            cropImageOptions2 = cropImageOptions15;
        }
        Integer num = cropImageOptions2.activityMenuTextColor;
        if (num != null) {
            int iIntValue = num.intValue();
            Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.ic_rotate_left_24), Integer.valueOf(R.id.ic_rotate_right_24), Integer.valueOf(R.id.ic_flip_24), Integer.valueOf(R.id.ic_flip_24_horizontally), Integer.valueOf(R.id.ic_flip_24_vertically), Integer.valueOf(R.id.crop_image_menu_crop)}).iterator();
            while (it.hasNext()) {
                updateMenuItemTextColor(menu, ((Number) it.next()).intValue(), iIntValue);
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.crop_image_menu_crop) {
            cropImage();
            return true;
        }
        CropImageOptions cropImageOptions = null;
        if (itemId == R.id.ic_rotate_left_24) {
            CropImageOptions cropImageOptions2 = this.cropImageOptions;
            if (cropImageOptions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions2;
            }
            rotateImage(-cropImageOptions.rotationDegrees);
            return true;
        }
        if (itemId == R.id.ic_rotate_right_24) {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions3;
            }
            rotateImage(cropImageOptions.rotationDegrees);
            return true;
        }
        if (itemId == R.id.ic_flip_24_horizontally) {
            CropImageView cropImageView = this.cropImageView;
            if (cropImageView != null) {
                cropImageView.flipImageHorizontally();
            }
            return true;
        }
        if (itemId == R.id.ic_flip_24_vertically) {
            CropImageView cropImageView2 = this.cropImageView;
            if (cropImageView2 != null) {
                cropImageView2.flipImageVertically();
            }
            return true;
        }
        if (itemId == 16908332) {
            setResultCancel();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onPickImageResult(Uri resultUri) {
        if (resultUri == null) {
            setResultCancel();
            return;
        }
        this.cropImageUri = resultUri;
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setImageUriAsync(resultUri);
        }
    }

    @Override // com.canhub.cropper.CropImageView.OnSetImageUriCompleteListener
    public void onSetImageUriComplete(CropImageView view, Uri uri, Exception error) {
        CropImageView cropImageView;
        CropImageView cropImageView2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uri, "uri");
        CropImageOptions cropImageOptions = null;
        if (error == null) {
            CropImageOptions cropImageOptions2 = this.cropImageOptions;
            if (cropImageOptions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions2 = null;
            }
            if (cropImageOptions2.initialCropWindowRectangle != null && (cropImageView2 = this.cropImageView) != null) {
                CropImageOptions cropImageOptions3 = this.cropImageOptions;
                if (cropImageOptions3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                    cropImageOptions3 = null;
                }
                cropImageView2.setCropRect(cropImageOptions3.initialCropWindowRectangle);
            }
            CropImageOptions cropImageOptions4 = this.cropImageOptions;
            if (cropImageOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions4 = null;
            }
            if (cropImageOptions4.initialRotation > 0 && (cropImageView = this.cropImageView) != null) {
                CropImageOptions cropImageOptions5 = this.cropImageOptions;
                if (cropImageOptions5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                    cropImageOptions5 = null;
                }
                cropImageView.setRotatedDegrees(cropImageOptions5.initialRotation);
            }
            CropImageOptions cropImageOptions6 = this.cropImageOptions;
            if (cropImageOptions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions = cropImageOptions6;
            }
            if (cropImageOptions.skipEditing) {
                cropImage();
                return;
            }
            return;
        }
        setResult(null, error, 1);
    }

    @Override // com.canhub.cropper.CropImageView.OnCropImageCompleteListener
    public void onCropImageComplete(CropImageView view, CropImageView.CropResult result) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(result, "result");
        setResult(result.getUriContent(), result.getError(), result.getSampleSize());
    }

    public void cropImage() {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        CropImageOptions cropImageOptions2 = null;
        if (cropImageOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            cropImageOptions = null;
        }
        if (cropImageOptions.noOutputImage) {
            setResult(null, null, 1);
            return;
        }
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            CropImageOptions cropImageOptions3 = this.cropImageOptions;
            if (cropImageOptions3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions3 = null;
            }
            Bitmap.CompressFormat compressFormat = cropImageOptions3.outputCompressFormat;
            CropImageOptions cropImageOptions4 = this.cropImageOptions;
            if (cropImageOptions4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions4 = null;
            }
            int i = cropImageOptions4.outputCompressQuality;
            CropImageOptions cropImageOptions5 = this.cropImageOptions;
            if (cropImageOptions5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions5 = null;
            }
            int i2 = cropImageOptions5.outputRequestWidth;
            CropImageOptions cropImageOptions6 = this.cropImageOptions;
            if (cropImageOptions6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions6 = null;
            }
            int i3 = cropImageOptions6.outputRequestHeight;
            CropImageOptions cropImageOptions7 = this.cropImageOptions;
            if (cropImageOptions7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
                cropImageOptions7 = null;
            }
            CropImageView.RequestSizeOptions requestSizeOptions = cropImageOptions7.outputRequestSizeOptions;
            CropImageOptions cropImageOptions8 = this.cropImageOptions;
            if (cropImageOptions8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageOptions");
            } else {
                cropImageOptions2 = cropImageOptions8;
            }
            cropImageView.croppedImageAsync(compressFormat, i, i2, i3, requestSizeOptions, cropImageOptions2.customOutputUri);
        }
    }

    public void setCropImageView(CropImageView cropImageView) {
        Intrinsics.checkNotNullParameter(cropImageView, "cropImageView");
        this.cropImageView = cropImageView;
    }

    public void rotateImage(int degrees) {
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.rotateImage(degrees);
        }
    }

    public void setResult(Uri uri, Exception error, int sampleSize) {
        setResult(error != null ? CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE : -1, getResultIntent(uri, error, sampleSize));
        finish();
    }

    public void setResultCancel() {
        setResult(0);
        finish();
    }

    public Intent getResultIntent(Uri uri, Exception error, int sampleSize) {
        CropImageView cropImageView = this.cropImageView;
        Uri imageUri = cropImageView != null ? cropImageView.getImageUri() : null;
        CropImageView cropImageView2 = this.cropImageView;
        float[] cropPoints = cropImageView2 != null ? cropImageView2.getCropPoints() : null;
        CropImageView cropImageView3 = this.cropImageView;
        Rect cropRect = cropImageView3 != null ? cropImageView3.getCropRect() : null;
        CropImageView cropImageView4 = this.cropImageView;
        int rotatedDegrees = cropImageView4 != null ? cropImageView4.getRotatedDegrees() : 0;
        CropImageView cropImageView5 = this.cropImageView;
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(imageUri, uri, error, cropPoints, cropRect, rotatedDegrees, cropImageView5 != null ? cropImageView5.getWholeImageRect() : null, sampleSize);
        Intent intent = new Intent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra(CropImage.CROP_IMAGE_EXTRA_RESULT, activityResult);
        return intent;
    }

    public void updateMenuItemIconColor(Menu menu, int itemId, int color) {
        Drawable icon;
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuItem menuItemFindItem = menu.findItem(itemId);
        if (menuItemFindItem == null || (icon = menuItemFindItem.getIcon()) == null) {
            return;
        }
        try {
            icon.mutate();
            icon.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, BlendModeCompat.SRC_ATOP));
            menuItemFindItem.setIcon(icon);
        } catch (Exception e) {
            Log.w("AIC", "Failed to update menu item color", e);
        }
    }

    public void updateMenuItemTextColor(Menu menu, int itemId, int color) {
        CharSequence title;
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuItem menuItemFindItem = menu.findItem(itemId);
        if (menuItemFindItem == null || (title = menuItemFindItem.getTitle()) == null || !(!StringsKt.isBlank(title))) {
            return;
        }
        try {
            SpannableString spannableString = new SpannableString(title);
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            menuItemFindItem.setTitle(spannableString);
        } catch (Exception e) {
            Log.w("AIC", "Failed to update menu item color", e);
        }
    }

    /* JADX INFO: compiled from: CropImageActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/canhub/cropper/CropImageActivity$Companion;", "", "<init>", "()V", "BUNDLE_KEY_TMP_URI", "", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
