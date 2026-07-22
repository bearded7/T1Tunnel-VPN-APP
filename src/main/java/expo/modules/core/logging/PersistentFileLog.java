package expo.modules.core.logging;

import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersistentFileLog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tJ;\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032+\b\u0002\u0010\r\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\u000fj\u0004\u0018\u0001`\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000eJT\u0010\u0014\u001a\u00020\u000b2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00160\u000e2)\u0010\r\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000eJ1\u0010\u0019\u001a\u00020\u000b2)\u0010\r\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\u000fj\u0004\u0018\u0001`\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000eJ\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002J\u0016\u0010!\u001a\u00020\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lexpo/modules/core/logging/PersistentFileLog;", "", "category", "", "filesDirectory", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/io/File;)V", "readEntries", "", "appendEntry", "", "entry", "completionHandler", "Lkotlin/Function1;", "Ljava/lang/Error;", "Lkotlin/ParameterName;", "name", "_", "Lkotlin/Error;", "purgeEntriesNotMatchingFilter", ViewProps.FILTER, "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "clearEntries", "filePath", "ensureFileExists", "getFileSize", "", "appendTextToFile", ReactTextInputShadowNode.PROP_TEXT, "readFileLinesSync", "writeFileLinesSync", "entries", "deleteFileSync", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersistentFileLog {
    private static final String FILE_NAME_PREFIX = "dev.expo.modules.core.logging";
    private final String filePath;
    private static final PersistentFileLogSerialDispatchQueue queue = new PersistentFileLogSerialDispatchQueue();

    public PersistentFileLog(String category, File filesDirectory) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(filesDirectory, "filesDirectory");
        this.filePath = filesDirectory.getPath() + "/dev.expo.modules.core.logging." + category;
    }

    public final List<String> readEntries() {
        if (0 == getFileSize()) {
            return CollectionsKt.emptyList();
        }
        return readFileLinesSync();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void appendEntry$default(PersistentFileLog persistentFileLog, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: expo.modules.core.logging.PersistentFileLog$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PersistentFileLog.appendEntry$lambda$0((Error) obj2);
                }
            };
        }
        persistentFileLog.appendEntry(str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendEntry$lambda$0(Error error) {
        return Unit.INSTANCE;
    }

    public final void appendEntry(final String entry, final Function1<? super Error, Unit> completionHandler) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
        queue.add(new Function0() { // from class: expo.modules.core.logging.PersistentFileLog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PersistentFileLog.appendEntry$lambda$1(this.f$0, entry, completionHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendEntry$lambda$1(PersistentFileLog persistentFileLog, String str, Function1 function1) {
        try {
            persistentFileLog.ensureFileExists();
            if (persistentFileLog.getFileSize() != 0) {
                str = "\n" + str;
            }
            persistentFileLog.appendTextToFile(str);
            function1.invoke(null);
        } catch (IOException e) {
            function1.invoke(new Error(e));
        } catch (Error e2) {
            function1.invoke(e2);
        }
        return Unit.INSTANCE;
    }

    public final void purgeEntriesNotMatchingFilter(final Function1<? super String, Boolean> filter, final Function1<? super Exception, Unit> completionHandler) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
        queue.add(new Function0() { // from class: expo.modules.core.logging.PersistentFileLog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PersistentFileLog.purgeEntriesNotMatchingFilter$lambda$2(this.f$0, filter, completionHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purgeEntriesNotMatchingFilter$lambda$2(PersistentFileLog persistentFileLog, Function1 function1, Function1 function2) {
        try {
            persistentFileLog.ensureFileExists();
            List<String> fileLinesSync = persistentFileLog.readFileLinesSync();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fileLinesSync) {
                if (((Boolean) function1.invoke(obj)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            persistentFileLog.writeFileLinesSync(arrayList);
            function2.invoke(null);
        } catch (Throwable th) {
            function2.invoke(new Exception(th));
        }
        return Unit.INSTANCE;
    }

    public final void clearEntries(final Function1<? super Error, Unit> completionHandler) {
        Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
        queue.add(new Function0() { // from class: expo.modules.core.logging.PersistentFileLog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PersistentFileLog.clearEntries$lambda$3(this.f$0, completionHandler);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearEntries$lambda$3(PersistentFileLog persistentFileLog, Function1 function1) {
        try {
            persistentFileLog.deleteFileSync();
            function1.invoke(null);
        } catch (Error e) {
            function1.invoke(e);
        }
        return Unit.INSTANCE;
    }

    private final void ensureFileExists() throws IOException {
        File file = new File(this.filePath);
        if (file.exists() || file.createNewFile()) {
            return;
        }
        throw new IOException("Unable to create file at path " + this.filePath);
    }

    private final long getFileSize() {
        File file = new File(this.filePath);
        if (!file.exists()) {
            return 0L;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                long size = fileInputStream.getChannel().size();
                CloseableKt.closeFinally(fileInputStream, null);
                return size;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return 0L;
        }
    }

    private final void appendTextToFile(String text) {
        File file = new File(this.filePath);
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        FilesKt.appendText(file, text, charsetDefaultCharset);
    }

    private final List<String> readFileLinesSync() {
        File file = new File(this.filePath);
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        List<String> lines = FilesKt.readLines(file, charsetDefaultCharset);
        ArrayList arrayList = new ArrayList();
        for (Object obj : lines) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void writeFileLinesSync(List<String> entries) {
        File file = new File(this.filePath);
        String strJoinToString$default = CollectionsKt.joinToString$default(entries, "\n", null, null, 0, null, null, 62, null);
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        FilesKt.writeText(file, strJoinToString$default, charsetDefaultCharset);
    }

    private final void deleteFileSync() {
        File file = new File(this.filePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
