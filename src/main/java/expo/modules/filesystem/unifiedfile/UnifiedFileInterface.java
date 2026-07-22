package expo.modules.filesystem.unifiedfile;

import android.net.Uri;
import com.caverock.androidsvg.SVGParser;
import expo.modules.kotlin.AppContext;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: UnifiedFileInterface.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H&J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0002\u0010\u001bJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020&H&J\b\u0010'\u001a\u00020\u001aH&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00000)H&R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018¨\u0006*"}, d2 = {"Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "", "exists", "", "isDirectory", "isFile", "parentFile", "getParentFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "createFile", "mimeType", "", "displayName", "createDirectory", "delete", "deleteRecursively", "listFilesAsUnified", "", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", SVGParser.XML_STYLESHEET_ATTR_TYPE, "getType", "()Ljava/lang/String;", "lastModified", "", "()Ljava/lang/Long;", "creationTime", "getCreationTime", "fileName", "getFileName", "getContentUri", "appContext", "Lexpo/modules/kotlin/AppContext;", "outputStream", "Ljava/io/OutputStream;", "inputStream", "Ljava/io/InputStream;", "length", "walkTopDown", "Lkotlin/sequences/Sequence;", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UnifiedFileInterface {
    UnifiedFileInterface createDirectory(String displayName);

    UnifiedFileInterface createFile(String mimeType, String displayName);

    boolean delete();

    boolean deleteRecursively();

    boolean exists();

    Uri getContentUri(AppContext appContext);

    Long getCreationTime();

    String getFileName();

    UnifiedFileInterface getParentFile();

    String getType();

    Uri getUri();

    InputStream inputStream();

    boolean isDirectory();

    boolean isFile();

    Long lastModified();

    long length();

    List<UnifiedFileInterface> listFilesAsUnified();

    OutputStream outputStream();

    Sequence<UnifiedFileInterface> walkTopDown();
}
