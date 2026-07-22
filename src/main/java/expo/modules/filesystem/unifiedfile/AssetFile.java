package expo.modules.filesystem.unifiedfile;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.caverock.androidsvg.SVGParser;
import expo.modules.kotlin.AppContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: AssetFile.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\"H\u0016J\u000f\u0010%\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020&H\u0016J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u000002H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010#\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\rR\u0016\u0010(\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0016\u0010*\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'¨\u00063"}, d2 = {"Lexpo/modules/filesystem/unifiedfile/AssetFile;", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "path", "", "getPath", "()Ljava/lang/String;", "exists", "", "isDirectory", "isFile", "contentUri", "getContentUri", "setContentUri", "(Landroid/net/Uri;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "parentFile", "getParentFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "createFile", "mimeType", "displayName", "createDirectory", "delete", "deleteRecursively", "listFilesAsUnified", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "getType", "lastModified", "", "()Ljava/lang/Long;", "fileName", "getFileName", "creationTime", "getCreationTime", "outputStream", "Ljava/io/OutputStream;", "inputStream", "Ljava/io/InputStream;", "length", "walkTopDown", "Lkotlin/sequences/Sequence;", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssetFile implements UnifiedFileInterface {
    private Uri contentUri;
    private final Context context;
    private final String path;
    private final Uri uri;

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long getCreationTime() {
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long lastModified() {
        return null;
    }

    public AssetFile(Context context, Uri uri) {
        String strTrimStart;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.uri = uri;
        String path = getUri().getPath();
        if (path == null || (strTrimStart = StringsKt.trimStart(path, IOUtils.DIR_SEPARATOR_UNIX)) == null) {
            throw new IllegalArgumentException("Invalid asset URI: " + getUri());
        }
        this.path = strTrimStart;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getUri() {
        return this.uri;
    }

    public final String getPath() {
        return this.path;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean exists() {
        return isDirectory() || isFile();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isDirectory() throws IOException {
        String[] list = this.context.getAssets().list(this.path);
        if (list != null) {
            if (!(list.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isFile() {
        Object objM772constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AssetFile assetFile = this;
            InputStream inputStreamOpen = this.context.getAssets().open(this.path);
            try {
                InputStream inputStream = inputStreamOpen;
                CloseableKt.closeFinally(inputStreamOpen, null);
                objM772constructorimpl = Result.m772constructorimpl(true);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM772constructorimpl = Result.m772constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m775exceptionOrNullimpl(objM772constructorimpl) != null) {
            objM772constructorimpl = false;
        }
        return ((Boolean) objM772constructorimpl).booleanValue();
    }

    public final Uri getContentUri() {
        return this.contentUri;
    }

    public final void setContentUri(Uri uri) {
        this.contentUri = uri;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getContentUri(AppContext appContext) throws IOException {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        InputStream inputStream = inputStream();
        try {
            InputStream inputStream2 = inputStream;
            File file = new File(this.context.getCacheDir(), "expo_shared_assets/" + getFileName());
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                Uri contentUri = new JavaFile(Uri.fromFile(file)).getContentUri(appContext);
                this.contentUri = contentUri;
                CloseableKt.closeFinally(inputStream, null);
                return contentUri;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStream, th3);
                throw th4;
            }
        }
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface getParentFile() {
        String path = getUri().getPath();
        if (path == null) {
            path = "";
        }
        if (path.length() == 0) {
            return null;
        }
        return new AssetFile(this.context, Uri.parse("asset://" + StringsKt.substringBeforeLast$default(path, IOUtils.DIR_SEPARATOR_UNIX, (String) null, 2, (Object) null)));
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createFile(String mimeType, String displayName) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        throw new UnsupportedOperationException("Asset files are not writable and cannot be created");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createDirectory(String displayName) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        throw new UnsupportedOperationException("Asset directories are not writable and cannot be created");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean delete() {
        throw new UnsupportedOperationException("Asset files are not writable and cannot be deleted");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean deleteRecursively() {
        throw new UnsupportedOperationException("Asset files are not writable and cannot be deleted");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public List<UnifiedFileInterface> listFilesAsUnified() throws IOException {
        String[] list = this.context.getAssets().list(this.path);
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.length);
        for (String str : list) {
            arrayList.add(new AssetFile(this.context, Uri.fromFile(new File(this.path, str))));
        }
        return arrayList;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getType() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(getUri().toString());
        Intrinsics.checkNotNull(fileExtensionFromUrl);
        if (fileExtensionFromUrl.length() <= 0) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = fileExtensionFromUrl.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getFileName() {
        return getUri().getLastPathSegment();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public OutputStream outputStream() {
        throw new UnsupportedOperationException("Asset files are not writable");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public InputStream inputStream() throws IOException {
        InputStream inputStreamOpen = this.context.getAssets().open(this.path);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        return inputStreamOpen;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[Catch: all -> 0x006c, LOOP:0: B:21:0x005c->B:23:0x0063, LOOP_END, TryCatch #4 {all -> 0x006c, blocks: (B:20:0x0054, B:21:0x005c, B:23:0x0063, B:24:0x0066), top: B:41:0x0054, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0066 A[SYNTHETIC] */
    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public long length() {
        InputStream inputStreamOpen;
        InputStream inputStream;
        byte[] bArr;
        long j;
        int i;
        try {
            Result.Companion companion = Result.INSTANCE;
            AssetFile assetFile = this;
            AssetFileDescriptor assetFileDescriptorOpenFd = this.context.getAssets().openFd(this.path);
            try {
                long length = assetFileDescriptorOpenFd.getLength();
                try {
                    try {
                        if (length > 0) {
                            CloseableKt.closeFinally(assetFileDescriptorOpenFd, null);
                            return length;
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(assetFileDescriptorOpenFd, null);
                        Result.m772constructorimpl(Unit.INSTANCE);
                        Result.Companion companion2 = Result.INSTANCE;
                        AssetFile assetFile2 = this;
                        inputStreamOpen = this.context.getAssets().open(this.path);
                        inputStream = inputStreamOpen;
                        bArr = new byte[8192];
                        j = 0;
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i != -1) {
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStreamOpen, null);
                                return j;
                            }
                            j += (long) i;
                        }
                        inputStream = inputStreamOpen;
                        bArr = new byte[8192];
                        j = 0;
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i != -1) {
                                Unit unit3 = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStreamOpen, null);
                                return j;
                            }
                            j += (long) i;
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m772constructorimpl(ResultKt.createFailure(th));
                            return 0L;
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamOpen, th);
                            throw th2;
                        }
                    }
                    Result.Companion companion4 = Result.INSTANCE;
                    AssetFile assetFile3 = this;
                    inputStreamOpen = this.context.getAssets().open(this.path);
                } catch (Throwable th3) {
                    Result.Companion companion5 = Result.INSTANCE;
                    Result.m772constructorimpl(ResultKt.createFailure(th3));
                    return 0L;
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.closeFinally(assetFileDescriptorOpenFd, th4);
                    throw th5;
                }
            }
        } catch (Throwable th6) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m772constructorimpl(ResultKt.createFailure(th6));
        }
        Result.Companion companion7 = Result.INSTANCE;
        Result.m772constructorimpl(ResultKt.createFailure(th6));
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.unifiedfile.AssetFile$walkTopDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetFile.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lexpo/modules/filesystem/unifiedfile/AssetFile;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.unifiedfile.AssetFile$walkTopDown$1", f = "AssetFile.kt", i = {0, 1, 1}, l = {130, 136}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "$this$forEach$iv"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super AssetFile>, Continuation<? super Unit>, Object> {
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
            AnonymousClass1 anonymousClass1 = AssetFile.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super AssetFile> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0075  */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
        
            if (r1.yield(r14.this$0, r14) == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00be, code lost:
        
            if (r7.yieldAll(r15, r14) == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x00c0, code lost:
        
            return r0;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00be -> B:22:0x00c1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r14.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L33
                if (r1 == r3) goto L2b
                if (r1 != r2) goto L23
                int r1 = r14.I$1
                int r4 = r14.I$0
                java.lang.Object r5 = r14.L$2
                expo.modules.filesystem.unifiedfile.AssetFile r5 = (expo.modules.filesystem.unifiedfile.AssetFile) r5
                java.lang.Object r6 = r14.L$1
                java.lang.String[] r6 = (java.lang.String[]) r6
                java.lang.Object r7 = r14.L$0
                kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
                kotlin.ResultKt.throwOnFailure(r15)
                goto Lc1
            L23:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L2b:
                java.lang.Object r1 = r14.L$0
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                kotlin.ResultKt.throwOnFailure(r15)
                goto L4c
            L33:
                kotlin.ResultKt.throwOnFailure(r15)
                java.lang.Object r15 = r14.L$0
                r1 = r15
                kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
                expo.modules.filesystem.unifiedfile.AssetFile r15 = expo.modules.filesystem.unifiedfile.AssetFile.this
                r4 = r14
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r14.L$0 = r1
                r14.label = r3
                java.lang.Object r15 = r1.yield(r15, r4)
                if (r15 != r0) goto L4c
                goto Lc0
            L4c:
                expo.modules.filesystem.unifiedfile.AssetFile r15 = expo.modules.filesystem.unifiedfile.AssetFile.this
                boolean r15 = r15.isDirectory()
                if (r15 == 0) goto Lc3
                expo.modules.filesystem.unifiedfile.AssetFile r15 = expo.modules.filesystem.unifiedfile.AssetFile.this
                android.content.Context r15 = expo.modules.filesystem.unifiedfile.AssetFile.access$getContext$p(r15)
                android.content.res.AssetManager r15 = r15.getAssets()
                expo.modules.filesystem.unifiedfile.AssetFile r4 = expo.modules.filesystem.unifiedfile.AssetFile.this
                java.lang.String r4 = r4.getPath()
                java.lang.String[] r15 = r15.list(r4)
                if (r15 == 0) goto Lc3
                expo.modules.filesystem.unifiedfile.AssetFile r4 = expo.modules.filesystem.unifiedfile.AssetFile.this
                int r5 = r15.length
                r6 = 0
                r7 = r1
                r1 = r5
                r5 = r4
                r4 = r6
                r6 = r15
            L73:
                if (r4 >= r1) goto Lc3
                r15 = r6[r4]
                android.net.Uri r8 = r5.getUri()
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.StringBuilder r8 = r9.append(r8)
                java.lang.String r9 = "/"
                java.lang.StringBuilder r8 = r8.append(r9)
                java.lang.StringBuilder r15 = r8.append(r15)
                java.lang.String r8 = r15.toString()
                r12 = 4
                r13 = 0
                java.lang.String r9 = "//"
                java.lang.String r10 = "/"
                r11 = 0
                java.lang.String r15 = kotlin.text.StringsKt.replace$default(r8, r9, r10, r11, r12, r13)
                android.net.Uri r15 = android.net.Uri.parse(r15)
                expo.modules.filesystem.unifiedfile.AssetFile r8 = new expo.modules.filesystem.unifiedfile.AssetFile
                android.content.Context r9 = expo.modules.filesystem.unifiedfile.AssetFile.access$getContext$p(r5)
                r8.<init>(r9, r15)
                kotlin.sequences.Sequence r15 = r8.walkTopDown()
                r14.L$0 = r7
                r14.L$1 = r6
                r14.L$2 = r5
                r14.I$0 = r4
                r14.I$1 = r1
                r14.label = r2
                java.lang.Object r15 = r7.yieldAll(r15, r14)
                if (r15 != r0) goto Lc1
            Lc0:
                return r0
            Lc1:
                int r4 = r4 + r3
                goto L73
            Lc3:
                kotlin.Unit r15 = kotlin.Unit.INSTANCE
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.unifiedfile.AssetFile.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Sequence<AssetFile> walkTopDown() {
        return SequencesKt.sequence(new AnonymousClass1(null));
    }
}
