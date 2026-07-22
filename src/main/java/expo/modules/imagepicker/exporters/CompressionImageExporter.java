package expo.modules.imagepicker.exporters;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.net.UriKt;
import com.facebook.soloader.Elf64;
import expo.modules.imagepicker.FailedToReadFileException;
import expo.modules.imagepicker.FailedToWriteFileException;
import expo.modules.imagepicker.MissingModuleException;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.kotlin.providers.AppContextProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InterruptibleKt;

/* JADX INFO: compiled from: CompressionImageExporter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lexpo/modules/imagepicker/exporters/CompressionImageExporter;", "Lexpo/modules/imagepicker/exporters/ImageExporter;", "appContextProvider", "Lexpo/modules/kotlin/providers/AppContextProvider;", "quality", "", "<init>", "(Lexpo/modules/kotlin/providers/AppContextProvider;D)V", "compressQuality", "", "exportAsync", "Lexpo/modules/imagepicker/exporters/ImageExportResult;", "source", "Landroid/net/Uri;", "output", "Ljava/io/File;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/net/Uri;Ljava/io/File;Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBitmap", "Landroid/graphics/Bitmap;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeImage", "", "bitmap", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "(Landroid/graphics/Bitmap;Ljava/io/File;Landroid/graphics/Bitmap$CompressFormat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompressionImageExporter implements ImageExporter {
    private final AppContextProvider appContextProvider;
    private final int compressQuality;

    /* JADX INFO: renamed from: expo.modules.imagepicker.exporters.CompressionImageExporter$exportAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: CompressionImageExporter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.exporters.CompressionImageExporter", f = "CompressionImageExporter.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {34, 36, 37}, m = "exportAsync", n = {"source", "output", "contentResolver", "source", "output", "contentResolver", "bitmap", "output", "bitmap"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CompressionImageExporter.this.exportAsync(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.exporters.CompressionImageExporter$readBitmap$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CompressionImageExporter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.exporters.CompressionImageExporter", f = "CompressionImageExporter.kt", i = {}, l = {Elf64.Ehdr.E_EHSIZE}, m = "readBitmap", n = {}, s = {})
    static final class C01351 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C01351(Continuation<? super C01351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CompressionImageExporter.this.readBitmap(null, this);
        }
    }

    public CompressionImageExporter(AppContextProvider appContextProvider, double d) {
        Intrinsics.checkNotNullParameter(appContextProvider, "appContextProvider");
        this.appContextProvider = appContextProvider;
        this.compressQuality = (int) (d * ((double) 100));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        if (expo.modules.imagepicker.ImagePickerUtilsKt.copyExifData(r2, r11, r12, r0) == r1) goto L28;
     */
    @Override // expo.modules.imagepicker.exporters.ImageExporter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object exportAsync(android.net.Uri r10, java.io.File r11, android.content.ContentResolver r12, kotlin.coroutines.Continuation<? super expo.modules.imagepicker.exporters.ImageExportResult> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof expo.modules.imagepicker.exporters.CompressionImageExporter.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r13
            expo.modules.imagepicker.exporters.CompressionImageExporter$exportAsync$1 r0 = (expo.modules.imagepicker.exporters.CompressionImageExporter.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            expo.modules.imagepicker.exporters.CompressionImageExporter$exportAsync$1 r0 = new expo.modules.imagepicker.exporters.CompressionImageExporter$exportAsync$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L6c
            if (r2 == r5) goto L5a
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r10 = r0.L$1
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            java.lang.Object r11 = r0.L$0
            java.io.File r11 = (java.io.File) r11
            kotlin.ResultKt.throwOnFailure(r13)
        L37:
            r4 = r10
            r3 = r11
            goto La9
        L3b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            java.lang.Object r10 = r0.L$3
            android.graphics.Bitmap r10 = (android.graphics.Bitmap) r10
            java.lang.Object r11 = r0.L$2
            android.content.ContentResolver r11 = (android.content.ContentResolver) r11
            java.lang.Object r12 = r0.L$1
            java.io.File r12 = (java.io.File) r12
            java.lang.Object r2 = r0.L$0
            android.net.Uri r2 = (android.net.Uri) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r8 = r12
            r12 = r11
            r11 = r8
            goto L97
        L5a:
            java.lang.Object r10 = r0.L$2
            r12 = r10
            android.content.ContentResolver r12 = (android.content.ContentResolver) r12
            java.lang.Object r10 = r0.L$1
            r11 = r10
            java.io.File r11 = (java.io.File) r11
            java.lang.Object r10 = r0.L$0
            android.net.Uri r10 = (android.net.Uri) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L7e
        L6c:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r5
            java.lang.Object r13 = r9.readBitmap(r10, r0)
            if (r13 != r1) goto L7e
            goto La8
        L7e:
            android.graphics.Bitmap r13 = (android.graphics.Bitmap) r13
            android.graphics.Bitmap$CompressFormat r2 = expo.modules.imagepicker.ImagePickerUtilsKt.toBitmapCompressFormat(r11)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.label = r4
            java.lang.Object r2 = r9.writeImage(r13, r11, r2, r0)
            if (r2 != r1) goto L95
            goto La8
        L95:
            r2 = r10
            r10 = r13
        L97:
            r0.L$0 = r11
            r0.L$1 = r10
            r13 = 0
            r0.L$2 = r13
            r0.L$3 = r13
            r0.label = r3
            java.lang.Object r12 = expo.modules.imagepicker.ImagePickerUtilsKt.copyExifData(r2, r11, r12, r0)
            if (r12 != r1) goto L37
        La8:
            return r1
        La9:
            int r6 = r4.getWidth()
            int r7 = r4.getHeight()
            expo.modules.imagepicker.exporters.CompressionImageExporter$exportAsync$2 r2 = new expo.modules.imagepicker.exporters.CompressionImageExporter$exportAsync$2
            r5 = r9
            r2.<init>(r3, r6, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.exporters.CompressionImageExporter.exportAsync(android.net.Uri, java.io.File, android.content.ContentResolver, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readBitmap(final Uri uri, Continuation<? super Bitmap> continuation) {
        C01351 c01351;
        if (continuation instanceof C01351) {
            c01351 = (C01351) continuation;
            if ((c01351.label & Integer.MIN_VALUE) != 0) {
                c01351.label -= Integer.MIN_VALUE;
            } else {
                c01351 = new C01351(continuation);
            }
        } else {
            c01351 = new C01351(continuation);
        }
        Object objRunInterruptible$default = c01351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01351.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRunInterruptible$default);
            Function0 function0 = new Function0() { // from class: expo.modules.imagepicker.exporters.CompressionImageExporter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CompressionImageExporter.readBitmap$lambda$0(this.f$0, uri);
                }
            };
            c01351.label = 1;
            objRunInterruptible$default = InterruptibleKt.runInterruptible$default(null, function0, c01351, 1, null);
            if (objRunInterruptible$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRunInterruptible$default);
        }
        Intrinsics.checkNotNull(objRunInterruptible$default);
        return objRunInterruptible$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap readBitmap$lambda$0(CompressionImageExporter compressionImageExporter, Uri uri) throws MissingModuleException, FailedToReadFileException {
        Future<Bitmap> futureLoadImageForManipulationFromURL;
        ImageLoaderInterface imageLoader = compressionImageExporter.appContextProvider.getAppContext().getImageLoader();
        if (imageLoader == null || (futureLoadImageForManipulationFromURL = imageLoader.loadImageForManipulationFromURL(uri.toString())) == null) {
            throw new MissingModuleException("ImageLoader");
        }
        try {
            return futureLoadImageForManipulationFromURL.get();
        } catch (ExecutionException e) {
            throw new FailedToReadFileException(UriKt.toFile(uri), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeImage(final Bitmap bitmap, final File file, final Bitmap.CompressFormat compressFormat, Continuation<? super Boolean> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0() { // from class: expo.modules.imagepicker.exporters.CompressionImageExporter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CompressionImageExporter.writeImage$lambda$2(file, bitmap, compressFormat, this));
            }
        }, continuation, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean writeImage$lambda$2(File file, Bitmap bitmap, Bitmap.CompressFormat compressFormat, CompressionImageExporter compressionImageExporter) throws FailedToWriteFileException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                boolean zCompress = bitmap.compress(compressFormat, compressionImageExporter.compressQuality, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
                return zCompress;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FailedToWriteFileException(file, e);
        }
    }
}
