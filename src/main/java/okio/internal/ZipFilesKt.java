package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;

/* JADX INFO: compiled from: ZipFiles.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0002\u001a\u001f\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0000\u001a.\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0%H\u0000\u001a\f\u0010'\u001a\u00020\u0016*\u00020(H\u0000\u001a\f\u0010)\u001a\u00020**\u00020(H\u0002\u001a.\u0010+\u001a\u00020,*\u00020(2\u0006\u0010-\u001a\u00020\u00012\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020,0/H\u0002\u001a\u0014\u00100\u001a\u00020\u0016*\u00020(2\u0006\u00101\u001a\u00020\u0016H\u0000\u001a\u0018\u00102\u001a\u0004\u0018\u00010\u0016*\u00020(2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0002\u001a\u0014\u00103\u001a\u00020**\u00020(2\u0006\u00104\u001a\u00020*H\u0002\u001a\f\u00105\u001a\u00020,*\u00020(H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u00066"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "filetimeToEpochMillis", "filetime", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readCentralDirectoryZipEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "centralDirectoryZipEntry", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = new Function1<ZipEntry, Boolean>() { // from class: okio.internal.ZipFilesKt.openZip.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ZipEntry it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public static final ZipFileSystem openZip(Path zipPath, FileSystem fileSystem, Function1<? super ZipEntry, Boolean> predicate) throws IOException {
        ?? r3;
        Throwable th;
        Unit unit;
        Throwable th2;
        Unit unit2;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle fileHandleOpenReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            FileHandle fileHandle = fileHandleOpenReadOnly;
            long size = fileHandle.size() - ((long) 22);
            long j = 0;
            if (size < 0) {
                throw new IOException("not a zip: size=" + fileHandle.size());
            }
            long jMax = Math.max(size - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0L);
            while (true) {
                BufferedSource bufferedSourceBuffer = Okio.buffer(fileHandle.source(size));
                try {
                    if (bufferedSourceBuffer.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        EocdRecord eocdRecord = readEocdRecord(bufferedSourceBuffer);
                        String utf8 = bufferedSourceBuffer.readUtf8(eocdRecord.getCommentByteCount());
                        bufferedSourceBuffer.close();
                        long j2 = size - ((long) 20);
                        Unit unit3 = null;
                        if (j2 > j) {
                            BufferedSource bufferedSourceBuffer2 = Okio.buffer(fileHandle.source(j2));
                            try {
                                BufferedSource bufferedSource = bufferedSourceBuffer2;
                                if (bufferedSource.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                    int intLe = bufferedSource.readIntLe();
                                    long longLe = bufferedSource.readLongLe();
                                    if (bufferedSource.readIntLe() != 1 || intLe != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    BufferedSource bufferedSourceBuffer3 = Okio.buffer(fileHandle.source(longLe));
                                    try {
                                        BufferedSource bufferedSource2 = bufferedSourceBuffer3;
                                        int intLe2 = bufferedSource2.readIntLe();
                                        if (intLe2 != ZIP64_EOCD_RECORD_SIGNATURE) {
                                            throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(intLe2));
                                        }
                                        eocdRecord = readZip64EocdRecord(bufferedSource2, eocdRecord);
                                        unit2 = Unit.INSTANCE;
                                        if (bufferedSourceBuffer3 != null) {
                                            try {
                                                bufferedSourceBuffer3.close();
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                            }
                                        }
                                        th2 = null;
                                        if (th2 != null) {
                                            throw th2;
                                        }
                                    } catch (Throwable th4) {
                                        if (bufferedSourceBuffer3 != null) {
                                            try {
                                                bufferedSourceBuffer3.close();
                                            } catch (Throwable th5) {
                                                ExceptionsKt.addSuppressed(th4, th5);
                                            }
                                        }
                                        th2 = th4;
                                        unit2 = null;
                                    }
                                }
                                unit = Unit.INSTANCE;
                                if (bufferedSourceBuffer2 != null) {
                                    try {
                                        bufferedSourceBuffer2.close();
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                }
                                th = null;
                            } catch (Throwable th7) {
                                if (bufferedSourceBuffer2 != null) {
                                    try {
                                        bufferedSourceBuffer2.close();
                                    } catch (Throwable th8) {
                                        ExceptionsKt.addSuppressed(th7, th8);
                                    }
                                }
                                th = th7;
                                unit = null;
                            }
                            if (th != null) {
                                throw th;
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        BufferedSource bufferedSourceBuffer4 = Okio.buffer(fileHandle.source(eocdRecord.getCentralDirectoryOffset()));
                        try {
                            BufferedSource bufferedSource3 = bufferedSourceBuffer4;
                            long entryCount = eocdRecord.getEntryCount();
                            for (long j3 = 0; j3 < entryCount; j3++) {
                                ZipEntry centralDirectoryZipEntry = readCentralDirectoryZipEntry(bufferedSource3);
                                if (centralDirectoryZipEntry.getOffset() >= eocdRecord.getCentralDirectoryOffset()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (predicate.invoke(centralDirectoryZipEntry).booleanValue()) {
                                    arrayList.add(centralDirectoryZipEntry);
                                }
                            }
                            Unit unit4 = Unit.INSTANCE;
                            if (bufferedSourceBuffer4 != null) {
                                try {
                                    bufferedSourceBuffer4.close();
                                } catch (Throwable th9) {
                                    unit3 = th9;
                                }
                            }
                            Unit unit5 = unit3;
                            unit3 = unit4;
                            r3 = unit5;
                        } catch (Throwable th10) {
                            Throwable th11 = th10;
                            r3 = th11;
                            if (bufferedSourceBuffer4 != null) {
                                try {
                                    bufferedSourceBuffer4.close();
                                    r3 = th11;
                                } catch (Throwable th12) {
                                    ExceptionsKt.addSuppressed(th11, th12);
                                    r3 = th11;
                                }
                            }
                        }
                        if (r3 != 0) {
                            throw r3;
                        }
                        ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, buildIndex(arrayList), utf8);
                        if (fileHandleOpenReadOnly != null) {
                            try {
                                fileHandleOpenReadOnly.close();
                            } catch (Throwable unused) {
                            }
                        }
                        return zipFileSystem;
                    }
                    bufferedSourceBuffer.close();
                    size--;
                    if (size < jMax) {
                        throw new IOException("not a zip: end of central directory signature not found");
                    }
                    j = 0;
                } catch (Throwable th13) {
                    bufferedSourceBuffer.close();
                    throw th13;
                }
            }
        } catch (Throwable th14) {
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                    throw th14;
                } catch (Throwable th15) {
                    ExceptionsKt.addSuppressed(th14, th15);
                    throw th14;
                }
            }
            throw th14;
        }
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null)));
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            if (mapMutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path pathParent = zipEntry.getCanonicalPath().parent();
                    if (pathParent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = mapMutableMapOf.get(pathParent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    ZipEntry zipEntry3 = new ZipEntry(pathParent, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null);
                    mapMutableMapOf.put(pathParent, zipEntry3);
                    zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry3;
                }
            }
        }
        return mapMutableMapOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ZipEntry readCentralDirectoryZipEntry(final BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        int intLe = bufferedSource.readIntLe();
        if (intLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(4L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & UShort.MAX_VALUE;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        int shortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int shortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int shortLe4 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long intLe2 = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int shortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int shortLe6 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int shortLe7 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        bufferedSource.skip(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String utf8 = bufferedSource.readUtf8(shortLe5);
        if (StringsKt.contains$default((CharSequence) utf8, (char) 0, false, 2, (Object) null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j = longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? 8 : 0L;
        long j2 = longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? j + ((long) 8) : j;
        if (longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j2 += (long) 8;
        }
        final long j3 = j2;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        readExtra(bufferedSource, shortLe6, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt.readCentralDirectoryZipEntry.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) throws IOException {
                invoke(num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, long j4) throws IOException {
                if (i2 != 1) {
                    if (i2 != 10) {
                        return;
                    }
                    if (j4 < 4) {
                        throw new IOException("bad zip: NTFS extra too short");
                    }
                    bufferedSource.skip(4L);
                    final Ref.ObjectRef<Long> objectRef4 = objectRef;
                    final BufferedSource bufferedSource2 = bufferedSource;
                    final Ref.ObjectRef<Long> objectRef5 = objectRef2;
                    final Ref.ObjectRef<Long> objectRef6 = objectRef3;
                    ZipFilesKt.readExtra(bufferedSource, (int) (j4 - 4), new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt.readCentralDirectoryZipEntry.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) throws IOException {
                            invoke(num.intValue(), l.longValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.Long] */
                        /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Long] */
                        /* JADX WARN: Type inference failed for: r4v8, types: [T, java.lang.Long] */
                        public final void invoke(int i3, long j5) throws IOException {
                            if (i3 == 1) {
                                if (objectRef4.element != null) {
                                    throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                                }
                                if (j5 != 24) {
                                    throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                                }
                                objectRef4.element = Long.valueOf(bufferedSource2.readLongLe());
                                objectRef5.element = Long.valueOf(bufferedSource2.readLongLe());
                                objectRef6.element = Long.valueOf(bufferedSource2.readLongLe());
                            }
                        }
                    });
                    return;
                }
                if (booleanRef.element) {
                    throw new IOException("bad zip: zip64 extra repeated");
                }
                booleanRef.element = true;
                if (j4 < j3) {
                    throw new IOException("bad zip: zip64 extra too short");
                }
                Ref.LongRef longRef4 = longRef2;
                longRef4.element = longRef4.element == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : longRef2.element;
                Ref.LongRef longRef5 = longRef;
                longRef5.element = longRef5.element == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : 0L;
                Ref.LongRef longRef6 = longRef3;
                longRef6.element = longRef6.element == ZipFilesKt.MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : 0L;
            }
        });
        if (j3 > 0 && !booleanRef.element) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        return new ZipEntry(Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null).resolve(utf8), StringsKt.endsWith$default(utf8, "/", false, 2, (Object) null), bufferedSource.readUtf8(shortLe7), intLe2, longRef.element, longRef2.element, shortLe2, longRef3.element, shortLe4, shortLe3, (Long) objectRef.element, (Long) objectRef2.element, (Long) objectRef3.element, null, null, null, 57344, null);
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int shortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int shortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long shortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        if (shortLe3 != (bufferedSource.readShortLe() & UShort.MAX_VALUE) || shortLe != 0 || shortLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(4L);
        return new EocdRecord(shortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & UShort.MAX_VALUE);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int intLe = bufferedSource.readIntLe();
        int intLe2 = bufferedSource.readIntLe();
        long longLe = bufferedSource.readLongLe();
        if (longLe != bufferedSource.readLongLe() || intLe != 0 || intLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(longLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) throws IOException {
        long j = i;
        while (j != 0) {
            if (j < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int shortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            long shortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j2 = j - ((long) 4);
            if (j2 < shortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(shortLe2);
            long size = bufferedSource.getBuffer().size();
            function2.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long size2 = (bufferedSource.getBuffer().size() + shortLe2) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + shortLe);
            }
            if (size2 > 0) {
                bufferedSource.getBuffer().skip(size2);
            }
            j = j2 - shortLe2;
        }
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }

    public static final ZipEntry readLocalHeader(BufferedSource bufferedSource, ZipEntry centralDirectoryZipEntry) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(centralDirectoryZipEntry, "centralDirectoryZipEntry");
        ZipEntry orSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, centralDirectoryZipEntry);
        Intrinsics.checkNotNull(orSkipLocalHeader);
        return orSkipLocalHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final ZipEntry readOrSkipLocalHeader(final BufferedSource bufferedSource, ZipEntry zipEntry) throws IOException {
        int intLe = bufferedSource.readIntLe();
        if (intLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(2L);
        short shortLe = bufferedSource.readShortLe();
        int i = shortLe & UShort.MAX_VALUE;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        bufferedSource.skip(18L);
        long shortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int shortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        bufferedSource.skip(shortLe2);
        if (zipEntry == null) {
            bufferedSource.skip(shortLe3);
            return null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        readExtra(bufferedSource, shortLe3, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt.readOrSkipLocalHeader.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l) throws IOException {
                invoke(num.intValue(), l.longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r10v11, types: [T, java.lang.Integer] */
            /* JADX WARN: Type inference failed for: r11v4, types: [T, java.lang.Integer] */
            /* JADX WARN: Type inference failed for: r11v7, types: [T, java.lang.Integer] */
            public final void invoke(int i2, long j) throws IOException {
                if (i2 == ZipFilesKt.HEADER_ID_EXTENDED_TIMESTAMP) {
                    if (j < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    byte b = bufferedSource.readByte();
                    boolean z = (b & 1) == 1;
                    boolean z2 = (b & 2) == 2;
                    boolean z3 = (b & 4) == 4;
                    BufferedSource bufferedSource2 = bufferedSource;
                    long j2 = z ? 5L : 1L;
                    if (z2) {
                        j2 += 4;
                    }
                    if (z3) {
                        j2 += 4;
                    }
                    if (j < j2) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z) {
                        objectRef.element = Integer.valueOf(bufferedSource2.readIntLe());
                    }
                    if (z2) {
                        objectRef2.element = Integer.valueOf(bufferedSource.readIntLe());
                    }
                    if (z3) {
                        objectRef3.element = Integer.valueOf(bufferedSource.readIntLe());
                    }
                }
            }
        });
        return zipEntry.copy$okio((Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element);
    }

    public static final long filetimeToEpochMillis(long j) {
        return (j / ((long) 10000)) - 11644473600000L;
    }

    public static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((i >> 9) & 127) + 1980, (i >> 5) & 15, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1));
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String string = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return sb.append(string).toString();
    }
}
