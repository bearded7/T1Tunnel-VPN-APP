package expo.modules.imagepicker;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import androidx.core.net.UriKt;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.modules.dialog.AlertFragment;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.core.utilities.FileUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: compiled from: ImagePickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\f\u001a\u00020\t*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0001H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0004*\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0004*\u00020\u0004H\u0000\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0004H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0015H\u0000\u001a\u0012\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001f*\u00020 H\u0000\u001a&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0080@¢\u0006\u0002\u0010%\u001a&\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0080@¢\u0006\u0002\u0010%\u001a\u000e\u0010,\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0000\"\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0018\u0010'\u001a\u00020(*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010)\"\u0018\u0010*\u001a\u00020(*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010)\"\u0018\u0010+\u001a\u00020(*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)¨\u0006-"}, d2 = {"createOutputFile", "Ljava/io/File;", "cacheDir", "extension", "", "getType", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "getTypeFromFileUrl", ImagesContract.URL, "toContentUri", "context", "Landroid/content/Context;", "toBitmapCompressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "toImageFileExtension", "toMediaType", "Lexpo/modules/imagepicker/MediaType;", "extractInt", "", "Landroid/media/MediaMetadataRetriever;", "key", AlertFragment.ARG_ITEMS, "", "Landroid/content/ClipData$Item;", "Landroid/content/ClipData;", "getItems", "(Landroid/content/ClipData;)Ljava/lang/Iterable;", "getAllDataUris", "", "Landroid/content/Intent;", "copyFile", "", "sourceUri", "targetFile", "(Landroid/net/Uri;Ljava/io/File;Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyExifData", "isMediaProviderUri", "", "(Landroid/net/Uri;)Z", "isDownloadsProviderUri", "isMediaStoreAssetUri", "getMediaStoreAssetId", "expo-image-picker_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ImagePickerUtilsKt {

    /* JADX INFO: compiled from: ImagePickerUtils.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.CompressFormat.JPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final File createOutputFile(File cacheDir, String extension) throws IOException, FailedToCreateFileException {
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(extension, "extension");
        String strGenerateOutputPath = FileUtilities.generateOutputPath(cacheDir, ImagePickerConstants.CACHE_DIR_NAME, extension);
        try {
            File file = new File(strGenerateOutputPath);
            file.createNewFile();
            return file;
        } catch (IOException e) {
            Intrinsics.checkNotNull(strGenerateOutputPath);
            throw new FailedToCreateFileException(strGenerateOutputPath, e);
        }
    }

    public static final String getType(final ContentResolver contentResolver, final Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Function0 function0 = new Function0() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImagePickerUtilsKt.getType$lambda$2(contentResolver, uri);
            }
        };
        String type = contentResolver.getType(uri);
        if (type != null) {
            return type;
        }
        String str = (String) function0.invoke();
        if (str != null) {
            return str;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return getTypeFromFileUrl(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getType$lambda$2(ContentResolver contentResolver, Uri uri) {
        int columnIndex;
        Cursor cursorQuery = contentResolver.query(uri, (String[]) CollectionsKt.listOf("mime_type").toArray(new String[0]), null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            String string = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("mime_type")) == -1 || cursor2.isNull(columnIndex)) ? null : cursor2.getString(columnIndex);
            CloseableKt.closeFinally(cursor, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    private static final String getTypeFromFileUrl(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static final Uri toContentUri(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".ImagePickerFileProvider", file);
            Intrinsics.checkNotNull(uriForFile);
            return uriForFile;
        } catch (Exception unused) {
            Uri uriFromFile = Uri.fromFile(file);
            Intrinsics.checkNotNull(uriFromFile);
            return uriFromFile;
        }
    }

    public static final Bitmap.CompressFormat toBitmapCompressFormat(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return StringsKt.endsWith(FilesKt.getExtension(file), "png", true) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    public static final String toImageFileExtension(Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(compressFormat, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[compressFormat.ordinal()];
        if (i == 1) {
            return ".png";
        }
        if (i == 2) {
            return ".jpeg";
        }
        throw new RuntimeException("Compress format not supported '" + compressFormat.name() + "'");
    }

    public static final String toImageFileExtension(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.endsWith(str, "png", true)) {
            return ".png";
        }
        if (StringsKt.endsWith(str, "gif", true)) {
            return ".gif";
        }
        if (StringsKt.endsWith(str, "bmp", true)) {
            return ".bmp";
        }
        if (StringsKt.endsWith(str, "webp", true)) {
            return ".webp";
        }
        if (!StringsKt.endsWith(str, "jpeg", true)) {
            Log.w(ImagePickerConstants.TAG, "Image file " + str + " is of unsupported type. Falling back to JPEG instead.");
        }
        return ".jpeg";
    }

    public static final MediaType toMediaType(Uri uri, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        String type = getType(contentResolver, uri);
        if (type != null && StringsKt.contains$default((CharSequence) type, (CharSequence) "image/", false, 2, (Object) null)) {
            return MediaType.IMAGE;
        }
        if (type == null || !StringsKt.contains$default((CharSequence) type, (CharSequence) "video/", false, 2, (Object) null)) {
            return null;
        }
        return MediaType.VIDEO;
    }

    public static final Bitmap.CompressFormat toBitmapCompressFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.endsWith(str, "png", true) || StringsKt.endsWith(str, "gif", true) || StringsKt.endsWith(str, "bmp", true) || StringsKt.endsWith(str, "webp", true)) {
            return Bitmap.CompressFormat.PNG;
        }
        if (!StringsKt.endsWith(str, "jpeg", true)) {
            Log.w(ImagePickerConstants.TAG, "Image file " + str + " is of unsupported type. Falling back to JPEG instead.");
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static final int extractInt(MediaMetadataRetriever mediaMetadataRetriever, int i) throws FailedToExtractVideoMetadataException {
        Intrinsics.checkNotNullParameter(mediaMetadataRetriever, "<this>");
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(i);
        if (strExtractMetadata != null) {
            return Integer.parseInt(strExtractMetadata);
        }
        throw new FailedToExtractVideoMetadataException(null, null, 3, null);
    }

    public static final Iterable<ClipData.Item> getItems(ClipData clipData) {
        Intrinsics.checkNotNullParameter(clipData, "<this>");
        return new ImagePickerUtilsKt$items$1(clipData);
    }

    public static final List<Uri> getAllDataUris(Intent intent) {
        Iterable<ClipData.Item> items;
        Intrinsics.checkNotNullParameter(intent, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Uri data = intent.getData();
        if (data != null) {
            linkedHashSet.add(data);
        }
        ClipData clipData = intent.getClipData();
        if (clipData != null && (items = getItems(clipData)) != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<ClipData.Item> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getUri());
            }
            linkedHashSet.addAll(arrayList);
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    public static final Object copyFile(final Uri uri, final File file, final ContentResolver contentResolver, Continuation<? super Unit> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImagePickerUtilsKt.copyFile$lambda$9(file, uri, contentResolver);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyFile$lambda$9(File file, Uri uri, ContentResolver contentResolver) throws FailedToWriteFileException, FailedToReadFileException {
        if (uri.compareTo(Uri.fromFile(file)) == 0) {
            return Unit.INSTANCE;
        }
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                InputStream inputStream = inputStreamOpenInputStream;
                try {
                    InputStream inputStream2 = inputStream;
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(inputStream, null);
                        return unit;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(inputStream, th3);
                        throw th4;
                    }
                }
            }
            throw new FailedToReadFileException(UriKt.toFile(uri), null, 2, null);
        } catch (FileNotFoundException e) {
            throw new FailedToWriteFileException(file, e);
        }
    }

    public static final Object copyExifData(final Uri uri, final File file, final ContentResolver contentResolver, Continuation<? super Unit> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.ImagePickerUtilsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImagePickerUtilsKt.copyExifData$lambda$15(file, uri, contentResolver);
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyExifData$lambda$15(File file, Uri uri, ContentResolver contentResolver) throws FailedToWriteFileException, FailedToReadFileException {
        if (uri.compareTo(Uri.fromFile(file)) == 0) {
            return Unit.INSTANCE;
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.TAG_IMAGE_LENGTH, ExifInterface.TAG_IMAGE_WIDTH, ExifInterface.TAG_PIXEL_X_DIMENSION, ExifInterface.TAG_PIXEL_Y_DIMENSION, ExifInterface.TAG_ORIENTATION});
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                InputStream inputStream = inputStreamOpenInputStream;
                try {
                    ExifInterface exifInterface = new ExifInterface(inputStream);
                    ExifInterface exifInterface2 = new ExifInterface(file);
                    Iterable<Pair<String, String>> exif_tags = ImagePickerConstants.INSTANCE.getEXIF_TAGS();
                    ArrayList arrayList = new ArrayList();
                    for (Pair<String, String> pair : exif_tags) {
                        if (!listListOf.contains(pair.component2())) {
                            arrayList.add(pair);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        String str = (String) ((Pair) it.next()).component2();
                        arrayList3.add(TuplesKt.to(str, exifInterface.getAttribute(str)));
                    }
                    ArrayList<Pair> arrayList4 = new ArrayList();
                    for (Object obj : arrayList3) {
                        if (((String) ((Pair) obj).component2()) != null) {
                            arrayList4.add(obj);
                        }
                    }
                    for (Pair pair2 : arrayList4) {
                        exifInterface2.setAttribute((String) pair2.component1(), (String) pair2.component2());
                    }
                    try {
                        exifInterface2.saveAttributes();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream, null);
                        return Unit.INSTANCE;
                    } catch (IOException e) {
                        throw new FailedToWriteExifDataToFileException(file, e);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStream, th);
                        throw th2;
                    }
                }
            }
            throw new FailedToReadFileException(UriKt.toFile(uri), null, 2, null);
        } catch (FileNotFoundException e2) {
            throw new FailedToWriteFileException(file, e2);
        }
    }

    public static final boolean isMediaProviderUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.providers.media.documents");
    }

    public static final boolean isDownloadsProviderUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.providers.downloads.documents");
    }

    public static final boolean isMediaStoreAssetUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (isMediaProviderUri(uri)) {
            return true;
        }
        if (isDownloadsProviderUri(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            Intrinsics.checkNotNullExpressionValue(documentId, "getDocumentId(...)");
            if (StringsKt.startsWith$default(documentId, "msf:", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static final String getMediaStoreAssetId(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (!isMediaStoreAssetUri(uri)) {
            return null;
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        Intrinsics.checkNotNull(documentId);
        String str = documentId;
        return StringsKt.contains$default((CharSequence) str, ':', false, 2, (Object) null) ? (String) StringsKt.split$default((CharSequence) str, new char[]{':'}, false, 0, 6, (Object) null).get(1) : documentId;
    }
}
