package expo.modules.imagepicker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.core.text.HtmlCompat;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.soloader.Elf64;
import com.google.android.material.internal.ViewUtils;
import expo.modules.imagepicker.exporters.CompressionImageExporter;
import expo.modules.imagepicker.exporters.ImageExportResult;
import expo.modules.imagepicker.exporters.RawImageExporter;
import expo.modules.kotlin.providers.AppContextProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: MediaHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\n\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0010H\u0002J\u0016\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lexpo/modules/imagepicker/MediaHandler;", "", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "<init>", "(Lexpo/modules/kotlin/providers/AppContextProvider;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "readExtras", "Lexpo/modules/imagepicker/ImagePickerResponse;", "bareResult", "", "Lkotlin/Pair;", "Lexpo/modules/imagepicker/MediaType;", "Landroid/net/Uri;", "Lexpo/modules/imagepicker/contracts/MediaList;", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "readExtras$expo_image_picker_release", "(Ljava/util/List;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "handleImage", "Lexpo/modules/imagepicker/ImagePickerAsset;", "sourceUri", "(Landroid/net/Uri;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdditionalFileData", "Lexpo/modules/imagepicker/AdditionalFileData;", "uri", "handleVideo", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaHandler {
    private final AppContextProvider appContextProvider;

    /* JADX INFO: compiled from: MediaHandler.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.MediaHandler$handleImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaHandler.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.MediaHandler", f = "MediaHandler.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {Elf64.Ehdr.E_SHENTSIZE, 60, HtmlCompat.FROM_HTML_MODE_COMPACT}, m = "handleImage", n = {"sourceUri", "options", "mimeType", "outputFile", "sourceUri", "options", "mimeType", "outputFile", "exportedImage", "sourceUri", "mimeType", "outputFile", "exportedImage", "base64"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaHandler.this.handleImage(null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.MediaHandler$handleVideo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaHandler.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.MediaHandler", f = "MediaHandler.kt", i = {0, 0}, l = {102}, m = "handleVideo", n = {"sourceUri", "outputFile"}, s = {"L$0", "L$1"})
    static final class C01341 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01341(Continuation<? super C01341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MediaHandler.this.handleVideo(null, this);
        }
    }

    public MediaHandler(AppContextProvider appContextProvider) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
    }

    private final Context getContext() {
        Context reactContext = this.appContextProvider.getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0080  */
    /* JADX WARN: Code duplicated, block: B:21:0x0095  */
    /* JADX WARN: Code duplicated, block: B:22:0x0097  */
    /* JADX WARN: Code duplicated, block: B:24:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b6 -> B:30:0x00b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d9 -> B:39:0x0100). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:24:0x00a1
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object readExtras$expo_image_picker_release(java.util.List<? extends kotlin.Pair<? extends expo.modules.imagepicker.MediaType, ? extends android.net.Uri>> r26, expo.modules.imagepicker.ImagePickerOptions r27, kotlin.coroutines.Continuation<? super expo.modules.imagepicker.ImagePickerResponse> r28) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.MediaHandler.readExtras$expo_image_picker_release(java.util.List, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final File getCacheDirectory() {
        return this.appContextProvider.getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x0124  */
    /* JADX WARN: Code duplicated, block: B:40:0x0132  */
    /* JADX WARN: Code duplicated, block: B:45:0x0147  */
    /* JADX WARN: Code duplicated, block: B:47:0x014a  */
    /* JADX WARN: Code duplicated, block: B:50:0x016b  */
    /* JADX WARN: Code duplicated, block: B:53:0x017b  */
    /* JADX WARN: Code duplicated, block: B:56:0x019b  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object handleImage(Uri uri, ImagePickerOptions imagePickerOptions, Continuation<? super ImagePickerAsset> continuation) throws IOException, FailedToCreateFileException {
        AnonymousClass1 anonymousClass1;
        CompressionImageExporter compressionImageExporter;
        ImagePickerOptions imagePickerOptions2;
        String str;
        File file;
        ImageExportResult imageExportResult;
        Uri uri2;
        ImageExportResult imageExportResult2;
        ImagePickerOptions imagePickerOptions3;
        String str2;
        Boolean boolBoxBoolean;
        String str3;
        Object objExif;
        ImageExportResult imageExportResult3;
        String str4;
        Uri uri3;
        ByteArrayOutputStream byteArrayOutputStream;
        AdditionalFileData additionalFileData;
        String name;
        long length;
        Long fileSize;
        Uri uri4 = uri;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objExportAsync = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        Bundle bundle = null;
        if (i == 0) {
            ResultKt.throwOnFailure(objExportAsync);
            if (imagePickerOptions.getQuality() == 1.0d) {
                compressionImageExporter = new RawImageExporter();
            } else {
                compressionImageExporter = new CompressionImageExporter(this.appContextProvider, imagePickerOptions.getQuality());
            }
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            String type = ImagePickerUtilsKt.getType(contentResolver, uri4);
            if (type == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            File fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(getCacheDirectory(), ImagePickerUtilsKt.toImageFileExtension(type));
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver2, "getContentResolver(...)");
            anonymousClass1.L$0 = uri4;
            imagePickerOptions2 = imagePickerOptions;
            anonymousClass1.L$1 = imagePickerOptions2;
            anonymousClass1.L$2 = type;
            anonymousClass1.L$3 = fileCreateOutputFile;
            anonymousClass1.label = 1;
            objExportAsync = compressionImageExporter.exportAsync(uri4, fileCreateOutputFile, contentResolver2, anonymousClass1);
            if (objExportAsync != coroutine_suspended) {
                str = type;
                file = fileCreateOutputFile;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            File file2 = (File) anonymousClass1.L$3;
            String str5 = (String) anonymousClass1.L$2;
            ImagePickerOptions imagePickerOptions4 = (ImagePickerOptions) anonymousClass1.L$1;
            Uri uri5 = (Uri) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objExportAsync);
            imagePickerOptions2 = imagePickerOptions4;
            str = str5;
            file = file2;
            uri4 = uri5;
        } else {
            if (i == 2) {
                imageExportResult2 = (ImageExportResult) anonymousClass1.L$4;
                file = (File) anonymousClass1.L$3;
                str = (String) anonymousClass1.L$2;
                imagePickerOptions3 = (ImagePickerOptions) anonymousClass1.L$1;
                uri2 = (Uri) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objExportAsync);
                byteArrayOutputStream = (ByteArrayOutputStream) objExportAsync;
                if (byteArrayOutputStream != null) {
                    String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    imageExportResult = imageExportResult2;
                    str2 = strEncodeToString;
                } else {
                    imageExportResult = imageExportResult2;
                    imagePickerOptions2 = imagePickerOptions3;
                    uri4 = uri2;
                    uri2 = uri4;
                    str2 = null;
                    imagePickerOptions3 = imagePickerOptions2;
                }
                boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions3.getExif());
                if (!boolBoxBoolean.booleanValue()) {
                    boolBoxBoolean = null;
                }
                if (boolBoxBoolean != null) {
                    boolBoxBoolean.booleanValue();
                    ContentResolver contentResolver3 = getContext().getContentResolver();
                    Intrinsics.checkNotNullExpressionValue(contentResolver3, "getContentResolver(...)");
                    anonymousClass1.L$0 = uri2;
                    anonymousClass1.L$1 = str;
                    anonymousClass1.L$2 = file;
                    anonymousClass1.L$3 = imageExportResult;
                    anonymousClass1.L$4 = str2;
                    anonymousClass1.label = 3;
                    objExif = imageExportResult.exif(contentResolver3, anonymousClass1);
                    if (objExif != coroutine_suspended) {
                        imageExportResult3 = imageExportResult;
                        objExportAsync = objExif;
                        str4 = str;
                        uri3 = uri2;
                    }
                    return coroutine_suspended;
                }
                str3 = str;
                String str6 = str2;
                Bundle bundle2 = bundle;
                additionalFileData = getAdditionalFileData(uri2);
                MediaType mediaType = MediaType.IMAGE;
                String string = Uri.fromFile(file).toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                int width = imageExportResult.getWidth();
                int height = imageExportResult.getHeight();
                if (additionalFileData != null || (name = additionalFileData.getFileName()) == null) {
                    name = file.getName();
                }
                String str7 = name;
                if (additionalFileData != null || (fileSize = additionalFileData.getFileSize()) == null) {
                    length = file.length();
                } else {
                    length = fileSize.longValue();
                }
                return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType, string, width, height, str7, Boxing.boxLong(length), str3, str6, bundle2, null, null, 3072, null);
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) anonymousClass1.L$4;
            imageExportResult3 = (ImageExportResult) anonymousClass1.L$3;
            file = (File) anonymousClass1.L$2;
            str4 = (String) anonymousClass1.L$1;
            uri3 = (Uri) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objExportAsync);
        }
        bundle = (Bundle) objExportAsync;
        uri2 = uri3;
        imageExportResult = imageExportResult3;
        str3 = str4;
        String str8 = str2;
        Bundle bundle3 = bundle;
        additionalFileData = getAdditionalFileData(uri2);
        MediaType mediaType2 = MediaType.IMAGE;
        String string2 = Uri.fromFile(file).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        int width2 = imageExportResult.getWidth();
        int height2 = imageExportResult.getHeight();
        if (additionalFileData != null) {
            name = file.getName();
        } else {
            name = file.getName();
        }
        String str9 = name;
        if (additionalFileData != null) {
            length = file.length();
        } else {
            length = file.length();
        }
        return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType2, string2, width2, height2, str9, Boxing.boxLong(length), str3, str8, bundle3, null, null, 3072, null);
        imageExportResult = (ImageExportResult) objExportAsync;
        Boolean boolBoxBoolean2 = Boxing.boxBoolean(imagePickerOptions2.getBase64());
        if (!boolBoxBoolean2.booleanValue()) {
            boolBoxBoolean2 = null;
        }
        if (boolBoxBoolean2 != null) {
            boolBoxBoolean2.booleanValue();
            ContentResolver contentResolver4 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver4, "getContentResolver(...)");
            anonymousClass1.L$0 = uri4;
            anonymousClass1.L$1 = imagePickerOptions2;
            anonymousClass1.L$2 = str;
            anonymousClass1.L$3 = file;
            anonymousClass1.L$4 = imageExportResult;
            anonymousClass1.label = 2;
            Object objData = imageExportResult.data(contentResolver4, anonymousClass1);
            if (objData != coroutine_suspended) {
                uri2 = uri4;
                imageExportResult2 = imageExportResult;
                objExportAsync = objData;
                imagePickerOptions3 = imagePickerOptions2;
                byteArrayOutputStream = (ByteArrayOutputStream) objExportAsync;
                if (byteArrayOutputStream != null) {
                    String strEncodeToString2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    imageExportResult = imageExportResult2;
                    str2 = strEncodeToString2;
                } else {
                    imageExportResult = imageExportResult2;
                    imagePickerOptions2 = imagePickerOptions3;
                    uri4 = uri2;
                    uri2 = uri4;
                    str2 = null;
                    imagePickerOptions3 = imagePickerOptions2;
                }
                boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions3.getExif());
                if (!boolBoxBoolean.booleanValue()) {
                    boolBoxBoolean = null;
                }
                if (boolBoxBoolean != null) {
                    boolBoxBoolean.booleanValue();
                    ContentResolver contentResolver5 = getContext().getContentResolver();
                    Intrinsics.checkNotNullExpressionValue(contentResolver5, "getContentResolver(...)");
                    anonymousClass1.L$0 = uri2;
                    anonymousClass1.L$1 = str;
                    anonymousClass1.L$2 = file;
                    anonymousClass1.L$3 = imageExportResult;
                    anonymousClass1.L$4 = str2;
                    anonymousClass1.label = 3;
                    objExif = imageExportResult.exif(contentResolver5, anonymousClass1);
                    if (objExif != coroutine_suspended) {
                        imageExportResult3 = imageExportResult;
                        objExportAsync = objExif;
                        str4 = str;
                        uri3 = uri2;
                        bundle = (Bundle) objExportAsync;
                        uri2 = uri3;
                        imageExportResult = imageExportResult3;
                        str3 = str4;
                    }
                } else {
                    str3 = str;
                }
                String str10 = str2;
                Bundle bundle4 = bundle;
                additionalFileData = getAdditionalFileData(uri2);
                MediaType mediaType3 = MediaType.IMAGE;
                String string3 = Uri.fromFile(file).toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                int width3 = imageExportResult.getWidth();
                int height3 = imageExportResult.getHeight();
                if (additionalFileData != null) {
                    name = file.getName();
                } else {
                    name = file.getName();
                }
                String str11 = name;
                if (additionalFileData != null) {
                    length = file.length();
                } else {
                    length = file.length();
                }
                return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType3, string3, width3, height3, str11, Boxing.boxLong(length), str3, str10, bundle4, null, null, 3072, null);
            }
        } else {
            uri2 = uri4;
            str2 = null;
            imagePickerOptions3 = imagePickerOptions2;
            boolBoxBoolean = Boxing.boxBoolean(imagePickerOptions3.getExif());
            if (!boolBoxBoolean.booleanValue()) {
                boolBoxBoolean = null;
            }
            if (boolBoxBoolean != null) {
                boolBoxBoolean.booleanValue();
                ContentResolver contentResolver6 = getContext().getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver6, "getContentResolver(...)");
                anonymousClass1.L$0 = uri2;
                anonymousClass1.L$1 = str;
                anonymousClass1.L$2 = file;
                anonymousClass1.L$3 = imageExportResult;
                anonymousClass1.L$4 = str2;
                anonymousClass1.label = 3;
                objExif = imageExportResult.exif(contentResolver6, anonymousClass1);
                if (objExif != coroutine_suspended) {
                    imageExportResult3 = imageExportResult;
                    objExportAsync = objExif;
                    str4 = str;
                    uri3 = uri2;
                    bundle = (Bundle) objExportAsync;
                    uri2 = uri3;
                    imageExportResult = imageExportResult3;
                    str3 = str4;
                }
            } else {
                str3 = str;
            }
            String str12 = str2;
            Bundle bundle5 = bundle;
            additionalFileData = getAdditionalFileData(uri2);
            MediaType mediaType4 = MediaType.IMAGE;
            String string4 = Uri.fromFile(file).toString();
            Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
            int width4 = imageExportResult.getWidth();
            int height4 = imageExportResult.getHeight();
            if (additionalFileData != null) {
                name = file.getName();
            } else {
                name = file.getName();
            }
            String str13 = name;
            if (additionalFileData != null) {
                length = file.length();
            } else {
                length = file.length();
            }
            return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType4, string4, width4, height4, str13, Boxing.boxLong(length), str3, str12, bundle5, null, null, 3072, null);
        }
        return coroutine_suspended;
    }

    private final AdditionalFileData getAdditionalFileData(Uri uri) {
        Object objM772constructorimpl;
        Cursor cursorQuery = getContext().getContentResolver().query(uri, (String[]) CollectionsKt.listOf((Object[]) new String[]{"_display_name", "_size"}).toArray(new String[0]), null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        Cursor cursor = cursorQuery;
        try {
            Cursor cursor2 = cursor;
            if (!cursor2.moveToFirst()) {
                CloseableKt.closeFinally(cursor, null);
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                MediaHandler mediaHandler = this;
                Integer numValueOf = Integer.valueOf(cursor2.getColumnIndex("_display_name"));
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                String string = numValueOf != null ? cursor2.getString(numValueOf.intValue()) : null;
                Integer numValueOf2 = Integer.valueOf(cursor2.getColumnIndex("_size"));
                if (numValueOf2.intValue() == -1) {
                    numValueOf2 = null;
                }
                objM772constructorimpl = Result.m772constructorimpl(new AdditionalFileData(string, numValueOf2 != null ? Long.valueOf(cursor2.getLong(numValueOf2.intValue())) : null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM772constructorimpl = Result.m772constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m778isFailureimpl(objM772constructorimpl)) {
                objM772constructorimpl = null;
            }
            AdditionalFileData additionalFileData = (AdditionalFileData) objM772constructorimpl;
            CloseableKt.closeFinally(cursor, null);
            return additionalFileData;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(cursor, th2);
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object handleVideo(Uri uri, Continuation<? super ImagePickerAsset> continuation) throws IOException, FailedToCreateFileException, FailedToExtractVideoMetadataException {
        C01341 c01341;
        File fileCreateOutputFile;
        Uri uri2 = uri;
        if (continuation instanceof C01341) {
            c01341 = (C01341) continuation;
            if ((c01341.label & Integer.MIN_VALUE) != 0) {
                c01341.label -= Integer.MIN_VALUE;
            } else {
                c01341 = new C01341(continuation);
            }
        } else {
            c01341 = new C01341(continuation);
        }
        Object obj = c01341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01341.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            fileCreateOutputFile = ImagePickerUtilsKt.createOutputFile(getCacheDirectory(), ".mp4");
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            c01341.L$0 = uri2;
            c01341.L$1 = fileCreateOutputFile;
            c01341.label = 1;
            if (ImagePickerUtilsKt.copyFile(uri2, fileCreateOutputFile, contentResolver, c01341) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            File file = (File) c01341.L$1;
            Uri uri3 = (Uri) c01341.L$0;
            ResultKt.throwOnFailure(obj);
            fileCreateOutputFile = file;
            uri2 = uri3;
        }
        Uri uriFromFile = Uri.fromFile(fileCreateOutputFile);
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(getContext(), uriFromFile);
            AdditionalFileData additionalFileData = getAdditionalFileData(uri2);
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver2, "getContentResolver(...)");
            String type = ImagePickerUtilsKt.getType(contentResolver2, uri2);
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 18);
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 19);
            int iExtractInt = ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 24);
            if (iExtractInt % RotationOptions.ROTATE_180 != 0) {
                int i2 = intRef2.element;
                intRef2.element = intRef.element;
                intRef.element = i2;
            }
            MediaType mediaType = MediaType.VIDEO;
            String string = uriFromFile.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return new ImagePickerAsset(ImagePickerUtilsKt.getMediaStoreAssetId(uri2), mediaType, string, intRef.element, intRef2.element, additionalFileData != null ? additionalFileData.getFileName() : null, additionalFileData != null ? additionalFileData.getFileSize() : null, type, null, null, Boxing.boxInt(ImagePickerUtilsKt.extractInt(mediaMetadataRetriever, 9)), Boxing.boxInt(iExtractInt), ViewUtils.EDGE_TO_EDGE_FLAGS, null);
        } catch (FailedToExtractVideoMetadataException e) {
            throw new FailedToExtractVideoMetadataException(fileCreateOutputFile, e);
        }
    }
}
