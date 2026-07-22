package com.facebook.react.devsupport;

import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: MultipartStreamReader.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J8\u0010\u0016\u001a\u00020\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/devsupport/MultipartStreamReader;", "", "source", "Lokio/BufferedSource;", "boundary", "", "<init>", "(Lokio/BufferedSource;Ljava/lang/String;)V", "lastProgressEvent", "", "readAllParts", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkListener;", "parseHeaders", "", UriUtil.DATA_SCHEME, "Lokio/Buffer;", "emitChunk", "", "chunk", "done", "emitProgress", "headers", "contentLength", "isFinal", "ChunkListener", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultipartStreamReader {
    private static final String CRLF = "\r\n";
    private final String boundary;
    private long lastProgressEvent;
    private final BufferedSource source;

    /* JADX INFO: compiled from: MultipartStreamReader.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J,\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/MultipartStreamReader$ChunkListener;", "", "onChunkComplete", "", "headers", "", "", "body", "Lokio/Buffer;", "isLastChunk", "", "onChunkProgress", "loaded", "", "total", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ChunkListener {
        void onChunkComplete(Map<String, String> headers, Buffer body, boolean isLastChunk) throws IOException;

        void onChunkProgress(Map<String, String> headers, long loaded, long total) throws IOException;
    }

    public MultipartStreamReader(BufferedSource source, String boundary) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:29:0x00cc A[SYNTHETIC] */
    public final boolean readAllParts(ChunkListener listener) throws IOException {
        boolean z;
        Map<String, String> map;
        ChunkListener listener2 = listener;
        Intrinsics.checkNotNullParameter(listener2, "listener");
        ByteString byteStringM2515deprecated_encodeUtf8 = ByteString.INSTANCE.m2515deprecated_encodeUtf8("\r\n--" + this.boundary + "\r\n");
        ByteString byteStringM2515deprecated_encodeUtf9 = ByteString.INSTANCE.m2515deprecated_encodeUtf8("\r\n--" + this.boundary + "--\r\n");
        ByteString byteStringM2515deprecated_encodeUtf10 = ByteString.INSTANCE.m2515deprecated_encodeUtf8("\r\n\r\n");
        Buffer buffer = new Buffer();
        Map<String, String> headers = null;
        long j = 0;
        long jM2511deprecated_size = 0;
        long jM2511deprecated_size2 = 0;
        while (true) {
            long jMax = (long) Math.max(j - ((long) byteStringM2515deprecated_encodeUtf9.m2511deprecated_size()), jM2511deprecated_size);
            long jIndexOf = buffer.indexOf(byteStringM2515deprecated_encodeUtf8, jMax);
            if (jIndexOf == -1) {
                jIndexOf = buffer.indexOf(byteStringM2515deprecated_encodeUtf9, jMax);
                z = true;
            } else {
                z = false;
            }
            if (jIndexOf == -1) {
                long size = buffer.getSize();
                if (headers == null) {
                    long jIndexOf2 = buffer.indexOf(byteStringM2515deprecated_encodeUtf10, jMax);
                    if (jIndexOf2 >= 0) {
                        this.source.read(buffer, jIndexOf2);
                        Buffer buffer2 = new Buffer();
                        buffer.copyTo(buffer2, jMax, jIndexOf2 - jMax);
                        jM2511deprecated_size2 = ((long) byteStringM2515deprecated_encodeUtf10.m2511deprecated_size()) + buffer2.getSize();
                        headers = parseHeaders(buffer2);
                        jM2511deprecated_size = jM2511deprecated_size;
                    } else {
                        map = headers;
                    }
                    if (this.source.read(buffer, 4096) <= 0) {
                        return false;
                    }
                    listener2 = listener;
                    jM2511deprecated_size = jM2511deprecated_size;
                    j = size;
                } else {
                    map = headers;
                    emitProgress(map, buffer.getSize() - jM2511deprecated_size2, false, listener2);
                }
                headers = map;
                if (this.source.read(buffer, 4096) <= 0) {
                    return false;
                }
                listener2 = listener;
                jM2511deprecated_size = jM2511deprecated_size;
                j = size;
            } else {
                long j2 = jM2511deprecated_size;
                Map<String, String> map2 = headers;
                long j3 = jIndexOf - j2;
                if (j2 > 0) {
                    Buffer buffer3 = new Buffer();
                    buffer.skip(j2);
                    buffer.read(buffer3, j3);
                    listener2 = listener;
                    emitProgress(map2, buffer3.getSize() - jM2511deprecated_size2, true, listener2);
                    emitChunk(buffer3, z, listener2);
                    headers = null;
                    jM2511deprecated_size2 = 0;
                } else {
                    listener2 = listener;
                    buffer.skip(jIndexOf);
                    headers = map2;
                }
                if (z) {
                    return true;
                }
                jM2511deprecated_size = byteStringM2515deprecated_encodeUtf8.m2511deprecated_size();
                j = jM2511deprecated_size;
            }
        }
    }

    private final Map<String, String> parseHeaders(Buffer data) {
        List listEmptyList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<String> listSplit = new Regex("\r\n").split(data.readUtf8(), 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
            break;
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ":", 0, false, 6, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = str.substring(0, iIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String str2 = strSubstring;
                int length = str2.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                String string = str2.subSequence(i, length + 1).toString();
                String strSubstring2 = str.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                String str3 = strSubstring2;
                int length2 = str3.length() - 1;
                int i2 = 0;
                boolean z3 = false;
                while (i2 <= length2) {
                    boolean z4 = Intrinsics.compare((int) str3.charAt(!z3 ? i2 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length2--;
                    } else if (z4) {
                        i2++;
                    } else {
                        z3 = true;
                    }
                }
                linkedHashMap.put(string, str3.subSequence(i2, length2 + 1).toString());
            }
        }
        return linkedHashMap;
    }

    private final void emitChunk(Buffer chunk, boolean done, ChunkListener listener) throws IOException {
        ByteString byteStringM2515deprecated_encodeUtf8 = ByteString.INSTANCE.m2515deprecated_encodeUtf8("\r\n\r\n");
        long jIndexOf = chunk.indexOf(byteStringM2515deprecated_encodeUtf8);
        if (jIndexOf == -1) {
            listener.onChunkComplete(MapsKt.emptyMap(), chunk, done);
            return;
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = new Buffer();
        chunk.read(buffer, jIndexOf);
        chunk.skip(byteStringM2515deprecated_encodeUtf8.m2511deprecated_size());
        chunk.readAll(buffer2);
        listener.onChunkComplete(parseHeaders(buffer), buffer2, done);
    }

    private final void emitProgress(Map<String, String> headers, long contentLength, boolean isFinal, ChunkListener listener) throws IOException {
        if (listener == null || headers == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastProgressEvent > 16 || isFinal) {
            this.lastProgressEvent = jCurrentTimeMillis;
            listener.onChunkProgress(headers, contentLength, Long.parseLong(headers.getOrDefault(HttpHeaders.CONTENT_LENGTH, "0")));
        }
    }
}
