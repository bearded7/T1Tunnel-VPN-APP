package com.canhub.cropper.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetUriForFile.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"authority", "", "Landroid/content/Context;", "getUriForFile", "Landroid/net/Uri;", "context", "file", "Ljava/io/File;", "cropper_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GetUriForFileKt {
    public static final String authority(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getPackageName() + ".cropper.fileprovider";
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ee A[Catch: Exception -> 0x00f7, TryCatch #4 {Exception -> 0x00f7, blocks: (B:6:0x0022, B:12:0x0066, B:42:0x00ee, B:44:0x00f3, B:45:0x00f6, B:36:0x00e2, B:38:0x00e7), top: B:59:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f3 A[Catch: Exception -> 0x00f7, TryCatch #4 {Exception -> 0x00f7, blocks: (B:6:0x0022, B:12:0x0066, B:42:0x00ee, B:44:0x00f3, B:45:0x00f6, B:36:0x00e2, B:38:0x00e7), top: B:59:0x0022 }] */
    public static final Uri getUriForFile(Context context, File file) throws Throwable {
        File externalCacheDir;
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        String strAuthority = authority(context);
        try {
            Log.i("AIC", "Try get URI for scope storage - content://");
            Uri uriForFile = FileProvider.getUriForFile(context, strAuthority, file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
            return uriForFile;
        } catch (Exception e) {
            try {
                Log.e("AIC", String.valueOf(e.getMessage()));
                Log.w("AIC", "ANR Risk -- Copying the file the location cache to avoid 'external-files-path' bug for N+ devices");
                File file2 = new File(new File(context.getCacheDir(), "CROP_LIB_CACHE"), file.getName());
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            ByteStreamsKt.copyTo$default(fileInputStream2, fileOutputStream, 0, 2, null);
                            Log.i("AIC", "Completed Android N+ file copy. Attempting to return the cached file");
                            Uri uriForFile2 = FileProvider.getUriForFile(context, strAuthority, file2);
                            Intrinsics.checkNotNullExpressionValue(uriForFile2, "getUriForFile(...)");
                            fileInputStream2.close();
                            fileOutputStream.close();
                            return uriForFile2;
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            try {
                                Log.e("AIC", String.valueOf(e.getMessage()));
                                Log.i("AIC", "Trying to provide URI manually");
                                String str = "content://" + strAuthority + "/files/my_images/";
                                if (Build.VERSION.SDK_INT >= 26) {
                                    Files.createDirectories(Paths.get(str, new String[0]), new FileAttribute[0]);
                                } else {
                                    File file3 = new File(str);
                                    if (!file3.exists()) {
                                        file3.mkdirs();
                                    }
                                }
                                Uri uri = Uri.parse(str + file.getName());
                                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return uri;
                            } catch (Throwable th) {
                                th = th;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            } catch (Exception e5) {
                Log.e("AIC", String.valueOf(e5.getMessage()));
                if (Build.VERSION.SDK_INT < 29 && (externalCacheDir = context.getExternalCacheDir()) != null) {
                    try {
                        Log.i("AIC", "Use External storage, do not work for OS 29 and above");
                        Uri uriFromFile = Uri.fromFile(new File(externalCacheDir.getPath(), file.getAbsolutePath()));
                        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(...)");
                        return uriFromFile;
                    } catch (Exception e6) {
                        Log.e("AIC", String.valueOf(e6.getMessage()));
                        Log.i("AIC", "Try get URI using file://");
                        Uri uriFromFile2 = Uri.fromFile(file);
                        Intrinsics.checkNotNullExpressionValue(uriFromFile2, "fromFile(...)");
                        return uriFromFile2;
                    }
                }
                Log.i("AIC", "Try get URI using file://");
                Uri uriFromFile3 = Uri.fromFile(file);
                Intrinsics.checkNotNullExpressionValue(uriFromFile3, "fromFile(...)");
                return uriFromFile3;
            }
        }
    }
}
