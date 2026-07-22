package com.canhub.cropper;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: CropException.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00060\u0002j\u0002`\u0001:\u0004\u0007\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/canhub/cropper/CropException;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "Cancellation", "FailedToLoadBitmap", "FailedToDecodeImage", "Companion", "Lcom/canhub/cropper/CropException$Cancellation;", "Lcom/canhub/cropper/CropException$FailedToDecodeImage;", "Lcom/canhub/cropper/CropException$FailedToLoadBitmap;", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CropException extends Exception {
    public static final String EXCEPTION_PREFIX = "crop:";
    private static final long serialVersionUID = 4933890872862969613L;

    public /* synthetic */ CropException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX INFO: compiled from: CropException.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/canhub/cropper/CropException$Cancellation;", "Lcom/canhub/cropper/CropException;", "<init>", "()V", "Companion", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Cancellation extends CropException {
        private static final long serialVersionUID = -6896269134508601990L;

        public Cancellation() {
            super("crop: cropping has been cancelled by the user", null);
        }
    }

    private CropException(String str) {
        super(str);
    }

    /* JADX INFO: compiled from: CropException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/canhub/cropper/CropException$FailedToLoadBitmap;", "Lcom/canhub/cropper/CropException;", "uri", "Landroid/net/Uri;", "message", "", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "Companion", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FailedToLoadBitmap extends CropException {
        private static final long serialVersionUID = 7791142932960927332L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToLoadBitmap(Uri uri, String str) {
            super("crop: Failed to load sampled bitmap: " + uri + IOUtils.LINE_SEPARATOR_WINDOWS + str, null);
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }

    /* JADX INFO: compiled from: CropException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/canhub/cropper/CropException$FailedToDecodeImage;", "Lcom/canhub/cropper/CropException;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "Companion", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FailedToDecodeImage extends CropException {
        private static final long serialVersionUID = 3516154387706407275L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToDecodeImage(Uri uri) {
            super("crop: Failed to decode image: " + uri, null);
            Intrinsics.checkNotNullParameter(uri, "uri");
        }
    }
}
