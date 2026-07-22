package expo.modules.asset;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import expo.modules.core.errors.InvalidArgumentException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: ResourceAsset.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"ANDROID_EMBEDDED_URL_BASE_RESOURCE", "", "openAssetResourceStream", "Ljava/io/InputStream;", "context", "Landroid/content/Context;", "assetName", "openAndroidResStream", "resourceFilePath", "findResourceId", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "findResourceIdForAndroidResPath", "expo-asset_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ResourceAssetKt {
    public static final String ANDROID_EMBEDDED_URL_BASE_RESOURCE = "file:///android_res/";

    public static final InputStream openAssetResourceStream(Context context, String assetName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Integer numFindResourceId = findResourceId(context, assetName);
        if (numFindResourceId == null) {
            throw new Resources.NotFoundException(assetName);
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(numFindResourceId.intValue());
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        return inputStreamOpenRawResource;
    }

    public static final InputStream openAndroidResStream(Context context, String resourceFilePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceFilePath, "resourceFilePath");
        Integer numFindResourceIdForAndroidResPath = findResourceIdForAndroidResPath(context, resourceFilePath);
        if (numFindResourceIdForAndroidResPath == null) {
            throw new Resources.NotFoundException(resourceFilePath);
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(numFindResourceIdForAndroidResPath.intValue());
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        return inputStreamOpenRawResource;
    }

    private static final Integer findResourceId(Context context, String str) {
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        Integer numValueOf = Integer.valueOf(resources.getIdentifier(str, "raw", packageName));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf;
        }
        Integer numValueOf2 = Integer.valueOf(resources.getIdentifier(str, "drawable", packageName));
        if (numValueOf2.intValue() != 0) {
            return numValueOf2;
        }
        return null;
    }

    private static final Integer findResourceIdForAndroidResPath(Context context, String str) {
        if (!StringsKt.startsWith$default(str, ANDROID_EMBEDDED_URL_BASE_RESOURCE, false, 2, (Object) null)) {
            throw new InvalidArgumentException("Invalid resource file path: " + str);
        }
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() < 3) {
            throw new InvalidArgumentException("Invalid resource file path: " + str);
        }
        String str2 = pathSegments.get(1);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String strSubstringBefore$default = StringsKt.substringBefore$default(str2, '-', (String) null, 2, (Object) null);
        String str3 = pathSegments.get(2);
        Intrinsics.checkNotNull(str3);
        Integer numValueOf = Integer.valueOf(context.getResources().getIdentifier(StringsKt.substringBeforeLast(str3, FilenameUtils.EXTENSION_SEPARATOR, str3), strSubstringBefore$default, context.getPackageName()));
        if (numValueOf.intValue() != 0) {
            return numValueOf;
        }
        return null;
    }
}
