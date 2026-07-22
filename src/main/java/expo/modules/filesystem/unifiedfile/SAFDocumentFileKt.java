package expo.modules.filesystem.unifiedfile;

import androidx.documentfile.provider.DocumentFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SAFDocumentFile.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"deleteRecursively", "", "Landroidx/documentfile/provider/DocumentFile;", "expo-file-system_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SAFDocumentFileKt {
    public static final boolean deleteRecursively(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "<this>");
        if (documentFile.isDirectory()) {
            DocumentFile[] documentFileArrListFiles = documentFile.listFiles();
            Intrinsics.checkNotNullExpressionValue(documentFileArrListFiles, "listFiles(...)");
            for (DocumentFile documentFile2 : documentFileArrListFiles) {
                Intrinsics.checkNotNull(documentFile2);
                deleteRecursively(documentFile2);
            }
        }
        return documentFile.delete();
    }
}
