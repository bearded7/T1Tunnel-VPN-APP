package expo.modules.filesystem.unifiedfile;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.caverock.androidsvg.SVGParser;
import expo.modules.kotlin.AppContext;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: SAFDocumentFile.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0016J\u000f\u0010!\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\"H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u000001H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010 R\u0016\u0010)\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010#¨\u00062"}, d2 = {"Lexpo/modules/filesystem/unifiedfile/SAFDocumentFile;", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "documentFile", "Landroidx/documentfile/provider/DocumentFile;", "getDocumentFile", "()Landroidx/documentfile/provider/DocumentFile;", "exists", "", "isDirectory", "isFile", "parentFile", "getParentFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "createFile", "mimeType", "", "displayName", "createDirectory", "delete", "deleteRecursively", "listFilesAsUnified", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "getType", "()Ljava/lang/String;", "lastModified", "", "()Ljava/lang/Long;", "fileName", "getFileName", "getContentUri", "appContext", "Lexpo/modules/kotlin/AppContext;", "creationTime", "getCreationTime", "outputStream", "Ljava/io/OutputStream;", "inputStream", "Ljava/io/InputStream;", "length", "walkTopDown", "Lkotlin/sequences/Sequence;", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SAFDocumentFile implements UnifiedFileInterface {
    private final Context context;
    private final Uri uri;

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long getCreationTime() {
        return null;
    }

    public SAFDocumentFile(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.uri = uri;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getUri() {
        return this.uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DocumentFile getDocumentFile() {
        List<String> pathSegments = getUri().getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        String str = (String) CollectionsKt.getOrNull(pathSegments, 0);
        if (str == null) {
            str = "tree";
        }
        if (Intrinsics.areEqual(str, "document")) {
            return DocumentFile.fromSingleUri(this.context, getUri());
        }
        return DocumentFile.fromTreeUri(this.context, getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean exists() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.exists();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isDirectory() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.isDirectory();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isFile() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.isFile();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface getParentFile() {
        DocumentFile parentFile;
        Uri uri;
        DocumentFile documentFile = getDocumentFile();
        return (documentFile == null || (parentFile = documentFile.getParentFile()) == null || (uri = parentFile.getUri()) == null) ? null : new SAFDocumentFile(this.context, uri);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createFile(String mimeType, String displayName) {
        Uri uri;
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        DocumentFile documentFile = getDocumentFile();
        SAFDocumentFile sAFDocumentFile = null;
        DocumentFile documentFileCreateFile = documentFile != null ? documentFile.createFile(mimeType, displayName) : null;
        if (documentFileCreateFile != null && (uri = documentFileCreateFile.getUri()) != null) {
            sAFDocumentFile = new SAFDocumentFile(this.context, uri);
        }
        return sAFDocumentFile;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createDirectory(String displayName) {
        Uri uri;
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        DocumentFile documentFile = getDocumentFile();
        SAFDocumentFile sAFDocumentFile = null;
        DocumentFile documentFileCreateDirectory = documentFile != null ? documentFile.createDirectory(displayName) : null;
        if (documentFileCreateDirectory != null && (uri = documentFileCreateDirectory.getUri()) != null) {
            sAFDocumentFile = new SAFDocumentFile(this.context, uri);
        }
        return sAFDocumentFile;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean delete() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && documentFile.delete();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean deleteRecursively() {
        DocumentFile documentFile = getDocumentFile();
        return documentFile != null && SAFDocumentFileKt.deleteRecursively(documentFile);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public List<UnifiedFileInterface> listFilesAsUnified() {
        DocumentFile[] documentFileArrListFiles;
        DocumentFile documentFile = getDocumentFile();
        if (documentFile == null || (documentFileArrListFiles = documentFile.listFiles()) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(documentFileArrListFiles.length);
        for (DocumentFile documentFile2 : documentFileArrListFiles) {
            Context context = this.context;
            Uri uri = documentFile2.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
            arrayList.add(new SAFDocumentFile(context, uri));
        }
        return arrayList;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getType() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.getType();
        }
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long lastModified() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return Long.valueOf(documentFile.lastModified());
        }
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getFileName() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.getName();
        }
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getContentUri(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return getUri();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public OutputStream outputStream() throws FileNotFoundException {
        OutputStream outputStreamOpenOutputStream = this.context.getContentResolver().openOutputStream(getUri());
        if (outputStreamOpenOutputStream != null) {
            return outputStreamOpenOutputStream;
        }
        throw new IllegalStateException("Unable to open output stream for URI: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public InputStream inputStream() throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(getUri());
        if (inputStreamOpenInputStream != null) {
            return inputStreamOpenInputStream;
        }
        throw new IllegalStateException("Unable to open output stream for URI: " + getUri());
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public long length() {
        DocumentFile documentFile = getDocumentFile();
        if (documentFile != null) {
            return documentFile.length();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.unifiedfile.SAFDocumentFile$walkTopDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: SAFDocumentFile.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lexpo/modules/filesystem/unifiedfile/SAFDocumentFile;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.unifiedfile.SAFDocumentFile$walkTopDown$1", f = "SAFDocumentFile.kt", i = {0, 1, 1}, l = {89, 92}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "$this$forEach$iv"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super SAFDocumentFile>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SAFDocumentFile.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super SAFDocumentFile> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x006c  */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
        
            if (r1.yield(r11.this$0, r11) == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0094, code lost:
        
            if (r7.yieldAll(r12, r11) == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0096, code lost:
        
            return r0;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0094 -> B:24:0x0097). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L33
                if (r1 == r3) goto L2b
                if (r1 != r2) goto L23
                int r1 = r11.I$1
                int r4 = r11.I$0
                java.lang.Object r5 = r11.L$2
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r5 = (expo.modules.filesystem.unifiedfile.SAFDocumentFile) r5
                java.lang.Object r6 = r11.L$1
                androidx.documentfile.provider.DocumentFile[] r6 = (androidx.documentfile.provider.DocumentFile[]) r6
                java.lang.Object r7 = r11.L$0
                kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
                kotlin.ResultKt.throwOnFailure(r12)
                goto L97
            L23:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L2b:
                java.lang.Object r1 = r11.L$0
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                kotlin.ResultKt.throwOnFailure(r12)
                goto L4b
            L33:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                r1 = r12
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r12 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                r4 = r11
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r11.L$0 = r1
                r11.label = r3
                java.lang.Object r12 = r1.yield(r12, r4)
                if (r12 != r0) goto L4b
                goto L96
            L4b:
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r12 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                boolean r12 = r12.isDirectory()
                if (r12 == 0) goto L99
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r12 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                androidx.documentfile.provider.DocumentFile r12 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.access$getDocumentFile(r12)
                if (r12 == 0) goto L99
                androidx.documentfile.provider.DocumentFile[] r12 = r12.listFiles()
                if (r12 == 0) goto L99
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r4 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.this
                int r5 = r12.length
                r6 = 0
                r7 = r1
                r1 = r5
                r5 = r4
                r4 = r6
                r6 = r12
            L6a:
                if (r4 >= r1) goto L99
                r12 = r6[r4]
                expo.modules.filesystem.unifiedfile.SAFDocumentFile r8 = new expo.modules.filesystem.unifiedfile.SAFDocumentFile
                android.content.Context r9 = expo.modules.filesystem.unifiedfile.SAFDocumentFile.access$getContext$p(r5)
                android.net.Uri r12 = r12.getUri()
                java.lang.String r10 = "getUri(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r10)
                r8.<init>(r9, r12)
                kotlin.sequences.Sequence r12 = r8.walkTopDown()
                r11.L$0 = r7
                r11.L$1 = r6
                r11.L$2 = r5
                r11.I$0 = r4
                r11.I$1 = r1
                r11.label = r2
                java.lang.Object r12 = r7.yieldAll(r12, r11)
                if (r12 != r0) goto L97
            L96:
                return r0
            L97:
                int r4 = r4 + r3
                goto L6a
            L99:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.unifiedfile.SAFDocumentFile.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Sequence<SAFDocumentFile> walkTopDown() {
        return SequencesKt.sequence(new AnonymousClass1(null));
    }
}
