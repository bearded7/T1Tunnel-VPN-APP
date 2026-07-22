package com.canhub.cropper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.MediaStore;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CropImageIntentChooser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010\u001f\u001a\u00020\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/canhub/cropper/CropImageIntentChooser;", "", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lcom/canhub/cropper/CropImageIntentChooser$ResultCallback;", "<init>", "(Landroidx/activity/ComponentActivity;Lcom/canhub/cropper/CropImageIntentChooser$ResultCallback;)V", AlertFragment.ARG_TITLE, "", "priorityIntentList", "", "cameraImgUri", "Landroid/net/Uri;", "intentChooser", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "showChooserIntent", "", "includeCamera", "", "includeGallery", "getCameraIntents", "context", "Landroid/content/Context;", "packageManager", "Landroid/content/pm/PackageManager;", "getGalleryIntents", "action", "isExplicitCameraPermissionRequired", "hasCameraPermissionInManifest", "setupPriorityAppsList", "appsList", "setIntentChooserTitle", "ResultCallback", "Companion", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CropImageIntentChooser {
    public static final String GOOGLE_PHOTOS = "com.google.android.apps.photos";
    public static final String GOOGLE_PHOTOS_GO = "com.google.android.apps.photosgo";
    public static final String MIUI_GALLERY = "com.miui.gallery";
    public static final String ONEPLUS_GALLERY = "com.oneplus.gallery";
    public static final String SAMSUNG_GALLERY = "com.sec.android.gallery3d";
    private final ComponentActivity activity;
    private final ResultCallback callback;
    private Uri cameraImgUri;
    private final ActivityResultLauncher<Intent> intentChooser;
    private List<String> priorityIntentList;
    private String title;

    /* JADX INFO: compiled from: CropImageIntentChooser.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/canhub/cropper/CropImageIntentChooser$ResultCallback;", "", "onSuccess", "", "uri", "Landroid/net/Uri;", "onCancelled", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ResultCallback {
        void onCancelled();

        void onSuccess(Uri uri);
    }

    public CropImageIntentChooser(ComponentActivity activity, ResultCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.activity = activity;
        this.callback = callback;
        String string = activity.getString(R.string.pick_image_chooser_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.title = string;
        this.priorityIntentList = CollectionsKt.listOf((Object[]) new String[]{GOOGLE_PHOTOS, GOOGLE_PHOTOS_GO, SAMSUNG_GALLERY, ONEPLUS_GALLERY, MIUI_GALLERY});
        this.intentChooser = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.canhub.cropper.CropImageIntentChooser$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CropImageIntentChooser.intentChooser$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intentChooser$lambda$1(CropImageIntentChooser this$0, ActivityResult activityRes) {
        Uri data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activityRes, "activityRes");
        if (activityRes.getResultCode() == -1) {
            Intent data2 = activityRes.getData();
            if (data2 == null || (data = data2.getData()) == null) {
                data = this$0.cameraImgUri;
            }
            this$0.callback.onSuccess(data);
            return;
        }
        this$0.callback.onCancelled();
    }

    public static /* synthetic */ void showChooserIntent$default(CropImageIntentChooser cropImageIntentChooser, boolean z, boolean z2, Uri uri, int i, Object obj) {
        if ((i & 4) != 0) {
            uri = null;
        }
        cropImageIntentChooser.showChooserIntent(z, z2, uri);
    }

    public final void showChooserIntent(boolean includeCamera, boolean includeGallery, Uri cameraImgUri) {
        Intent intent;
        this.cameraImgUri = cameraImgUri;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.activity.getPackageManager();
        if (!isExplicitCameraPermissionRequired(this.activity) && includeCamera) {
            ComponentActivity componentActivity = this.activity;
            Intrinsics.checkNotNull(packageManager);
            arrayList.addAll(getCameraIntents(componentActivity, packageManager));
        }
        if (includeGallery) {
            Intrinsics.checkNotNull(packageManager);
            List<Intent> galleryIntents = getGalleryIntents(packageManager, "android.intent.action.GET_CONTENT");
            if (galleryIntents.isEmpty()) {
                galleryIntents = getGalleryIntents(packageManager, "android.intent.action.PICK");
            }
            arrayList.addAll(galleryIntents);
        }
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            Intent intent2 = new Intent("android.intent.action.CHOOSER", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (includeGallery) {
                intent2.setAction("android.intent.action.PICK");
                intent2.setType("image/*");
            }
            intent = intent2;
        }
        Intent intentCreateChooser = Intent.createChooser(intent, this.title);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        ActivityResultLauncher<Intent> activityResultLauncher = this.intentChooser;
        Intrinsics.checkNotNull(intentCreateChooser);
        activityResultLauncher.launch(intentCreateChooser);
    }

    private final List<Intent> getCameraIntents(Context context, PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0)) : packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNull(listQueryIntentActivities);
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (context instanceof Activity) {
                ((Activity) context).grantUriPermission(resolveInfo.activityInfo.packageName, this.cameraImgUri, 3);
            }
            intent2.putExtra("output", this.cameraImgUri);
            arrayList.add(intent2);
        }
        return arrayList;
    }

    private final List<Intent> getGalleryIntents(PackageManager packageManager, String action) {
        Intent intent;
        Object next;
        ArrayList arrayList = new ArrayList();
        if (Intrinsics.areEqual(action, "android.intent.action.GET_CONTENT")) {
            intent = new Intent(action);
        } else {
            intent = new Intent(action, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        intent.setType("image/*");
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0)) : packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNull(listQueryIntentActivities);
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.priorityIntentList) {
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((Intent) next).getPackage(), str));
            Intent intent3 = (Intent) next;
            if (intent3 != null) {
                arrayList.remove(intent3);
                arrayList2.add(intent3);
            }
        }
        arrayList.addAll(0, arrayList2);
        return arrayList;
    }

    private final boolean isExplicitCameraPermissionRequired(Context context) {
        return hasCameraPermissionInManifest(context) && context.checkSelfPermission("android.permission.CAMERA") != 0;
    }

    private final boolean hasCameraPermissionInManifest(Context context) {
        String packageName = context.getPackageName();
        try {
            String[] strArr = (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096)) : context.getPackageManager().getPackageInfo(packageName, 4096)).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (str != null && StringsKt.equals(str, "android.permission.CAMERA", true)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final CropImageIntentChooser setupPriorityAppsList(List<String> appsList) {
        Intrinsics.checkNotNullParameter(appsList, "appsList");
        this.priorityIntentList = appsList;
        return this;
    }

    public final CropImageIntentChooser setIntentChooserTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        return this;
    }
}
