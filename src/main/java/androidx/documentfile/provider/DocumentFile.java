package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import androidx.core.provider.DocumentsContractCompat;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String str);

    public abstract DocumentFile createFile(String str, String str2);

    public abstract boolean delete();

    public abstract boolean exists();

    public abstract String getName();

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String str);

    DocumentFile(DocumentFile documentFile) {
        this.mParent = documentFile;
    }

    public static DocumentFile fromFile(File file) {
        return new RawDocumentFile(null, file);
    }

    public static DocumentFile fromSingleUri(Context context, Uri uri) {
        return new SingleDocumentFile(null, context, uri);
    }

    public static DocumentFile fromTreeUri(Context context, Uri uri) {
        String treeDocumentId = DocumentsContractCompat.getTreeDocumentId(uri);
        if (DocumentsContractCompat.isDocumentUri(context, uri)) {
            treeDocumentId = DocumentsContractCompat.getDocumentId(uri);
        }
        if (treeDocumentId == null) {
            throw new IllegalArgumentException("Could not get document ID from Uri: " + uri);
        }
        Uri uriBuildDocumentUriUsingTree = DocumentsContractCompat.buildDocumentUriUsingTree(uri, treeDocumentId);
        if (uriBuildDocumentUriUsingTree == null) {
            throw new NullPointerException("Failed to build documentUri from a tree: " + uri);
        }
        return new TreeDocumentFile(null, context, uriBuildDocumentUriUsingTree);
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContractCompat.isDocumentUri(context, uri);
    }

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public DocumentFile findFile(String str) {
        for (DocumentFile documentFile : listFiles()) {
            if (str.equals(documentFile.getName())) {
                return documentFile;
            }
        }
        return null;
    }
}
