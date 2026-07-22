package expo.modules.filesystem;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileSystemPath.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"validateFileSystemChildName", "", "name", "", "isContentUri", "", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "isAssetUri", "slashifyFilePath", "path", "expo-file-system_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FileSystemPathKt {
    public static final void validateFileSystemChildName(String name) throws UnableToCreateException {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = name;
        if (str.length() != 0 && !Intrinsics.areEqual(name, ".") && !Intrinsics.areEqual(name, "..")) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '/' && cCharAt != '\\') {
                }
            }
            return;
        }
        throw new UnableToCreateException("child name must be a single path segment");
    }

    public static final boolean isContentUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_CONTENT_SCHEME);
    }

    public static final boolean isAssetUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_ASSET_SCHEME);
    }

    public static final String slashifyFilePath(String str) {
        if (str == null) {
            return null;
        }
        return StringsKt.startsWith$default(str, "file:///", false, 2, (Object) null) ? str : Pattern.compile("^file:/*").matcher(str).replaceAll("file:///");
    }
}
