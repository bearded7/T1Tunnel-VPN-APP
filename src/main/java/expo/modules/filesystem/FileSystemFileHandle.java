package expo.modules.filesystem;

import com.facebook.common.util.UriUtil;
import expo.modules.kotlin.sharedobjects.SharedRef;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FileSystemFileHandle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Lexpo/modules/filesystem/FileSystemFileHandle;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Ljava/nio/channels/FileChannel;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "file", "Lexpo/modules/filesystem/FileSystemFile;", "<init>", "(Lexpo/modules/filesystem/FileSystemFile;)V", "fileChannel", "ensureIsOpen", "", "sharedObjectDidRelease", "close", "read", "", "length", "", "write", UriUtil.DATA_SCHEME, "value", "", "offset", "getOffset", "()Ljava/lang/Long;", "setOffset", "(Ljava/lang/Long;)V", "size", "getSize", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSystemFileHandle extends SharedRef<FileChannel> implements AutoCloseable {
    private final FileChannel fileChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemFileHandle(FileSystemFile file) {
        super(new RandomAccessFile(file.getJavaFile(), "rw").getChannel(), null, 2, null);
        Intrinsics.checkNotNullParameter(file, "file");
        this.fileChannel = getRef();
    }

    private final void ensureIsOpen() throws UnableToReadHandleException {
        if (!this.fileChannel.isOpen()) {
            throw new UnableToReadHandleException("file handle is closed");
        }
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void sharedObjectDidRelease() {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.fileChannel.close();
    }

    public final byte[] read(int length) throws UnableToReadHandleException {
        ensureIsOpen();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(RangesKt.coerceAtMost(length, (int) (this.fileChannel.size() - this.fileChannel.position())));
            this.fileChannel.read(byteBufferAllocate);
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            return bArrArray;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "unknown error";
            }
            throw new UnableToReadHandleException(message);
        }
    }

    public final void write(byte[] data) throws UnableToReadHandleException, UnableToWriteHandleException {
        Intrinsics.checkNotNullParameter(data, "data");
        ensureIsOpen();
        try {
            this.fileChannel.write(ByteBuffer.wrap(data));
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "unknown error";
            }
            throw new UnableToWriteHandleException(message);
        }
    }

    public final Long getOffset() {
        try {
            return Long.valueOf(this.fileChannel.position());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setOffset(Long l) throws IOException {
        if (l == null) {
            return;
        }
        this.fileChannel.position(l.longValue());
    }

    public final Long getSize() {
        try {
            return Long.valueOf(this.fileChannel.size());
        } catch (Exception unused) {
            return null;
        }
    }
}
