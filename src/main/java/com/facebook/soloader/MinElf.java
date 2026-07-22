package com.facebook.soloader;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedByInterruptException;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    private static final String TAG = "MinElf";

    public interface ISA {
        public static final String AARCH64 = "arm64-v8a";
        public static final String ARM = "armeabi-v7a";
        public static final String X86 = "x86";
        public static final String X86_64 = "x86_64";
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        ElfFileChannel elfFileChannel = new ElfFileChannel(file);
        try {
            String[] strArrExtract_DT_NEEDED = extract_DT_NEEDED(elfFileChannel);
            elfFileChannel.close();
            return strArrExtract_DT_NEEDED;
        } catch (Throwable th) {
            try {
                elfFileChannel.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String[] extract_DT_NEEDED_with_retries(ElfFileChannel elfFileChannel) throws IOException {
        int i = 0;
        while (true) {
            try {
                return extract_DT_NEEDED_no_retries(elfFileChannel);
            } catch (ClosedByInterruptException e) {
                i++;
                if (i > 4) {
                    throw e;
                }
                Thread.interrupted();
                LogUtil.e(TAG, "retrying extract_DT_NEEDED due to ClosedByInterruptException", e);
                elfFileChannel.openChannel();
            }
        }
    }

    public static String[] extract_DT_NEEDED(ElfByteChannel elfByteChannel) throws IOException {
        if (elfByteChannel instanceof ElfFileChannel) {
            return extract_DT_NEEDED_with_retries((ElfFileChannel) elfByteChannel);
        }
        return extract_DT_NEEDED_no_retries(elfByteChannel);
    }

    private static String[] extract_DT_NEEDED_no_retries(ElfByteChannel elfByteChannel) throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long j10 = getu32(elfByteChannel, byteBufferAllocate, 0L);
        if (j10 != 1179403647) {
            throw new ElfError("file is not ELF: magic is 0x" + Long.toHexString(j10) + ", it should be " + Long.toHexString(1179403647L));
        }
        boolean z = getu8(elfByteChannel, byteBufferAllocate, 4L) == 1;
        long j11 = 5;
        if (getu8(elfByteChannel, byteBufferAllocate, 5L) == 2) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        }
        long j12 = z ? getu32(elfByteChannel, byteBufferAllocate, 28L) : get64(elfByteChannel, byteBufferAllocate, 32L);
        long j13 = z ? getu16(elfByteChannel, byteBufferAllocate, 44L) : getu16(elfByteChannel, byteBufferAllocate, 56L);
        int i = getu16(elfByteChannel, byteBufferAllocate, z ? 42L : 54L);
        boolean z2 = z;
        long j14 = 40;
        if (j13 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            long j15 = z2 ? getu32(elfByteChannel, byteBufferAllocate, 32L) : get64(elfByteChannel, byteBufferAllocate, 40L);
            if (z2) {
                j13 = getu32(elfByteChannel, byteBufferAllocate, j15 + 28);
            } else {
                j13 = getu32(elfByteChannel, byteBufferAllocate, j15 + 44);
            }
        }
        long j16 = j12;
        long j17 = 0;
        while (true) {
            if (j17 >= j13) {
                j = 0;
                break;
            }
            if (z2) {
                j9 = getu32(elfByteChannel, byteBufferAllocate, j16);
            } else {
                j9 = getu32(elfByteChannel, byteBufferAllocate, j16);
            }
            if (j9 == 2) {
                if (z2) {
                    j = getu32(elfByteChannel, byteBufferAllocate, j16 + 4);
                    break;
                }
                j = get64(elfByteChannel, byteBufferAllocate, j16 + 8);
                break;
            }
            j16 += (long) i;
            j17++;
            j14 = j14;
        }
        long j18 = j14;
        if (j == 0) {
            throw new ElfError("ELF file does not contain dynamic linking information");
        }
        long j19 = j;
        long j20 = 0;
        int i2 = 0;
        while (true) {
            long j21 = z2 ? getu32(elfByteChannel, byteBufferAllocate, j19) : get64(elfByteChannel, byteBufferAllocate, j19);
            long j22 = j11;
            if (j21 == 1) {
                if (i2 == Integer.MAX_VALUE) {
                    throw new ElfError("malformed DT_NEEDED section");
                }
                i2++;
            } else if (j21 == j22) {
                j20 = z2 ? getu32(elfByteChannel, byteBufferAllocate, j19 + 4) : get64(elfByteChannel, byteBufferAllocate, j19 + 8);
            }
            j19 += z2 ? 8L : 16L;
            if (j21 == 0) {
                if (j20 == 0) {
                    throw new ElfError("Dynamic section string-table not found");
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= j13) {
                        j2 = 0;
                        break;
                    }
                    if (z2) {
                        j4 = j12;
                        j5 = getu32(elfByteChannel, byteBufferAllocate, j4);
                    } else {
                        j4 = j12;
                        j5 = getu32(elfByteChannel, byteBufferAllocate, j4);
                    }
                    if (j5 == 1) {
                        if (z2) {
                            j6 = getu32(elfByteChannel, byteBufferAllocate, j4 + 8);
                        } else {
                            j6 = get64(elfByteChannel, byteBufferAllocate, j4 + 16);
                        }
                        if (z2) {
                            j7 = getu32(elfByteChannel, byteBufferAllocate, j4 + 20);
                        } else {
                            j7 = get64(elfByteChannel, byteBufferAllocate, j4 + j18);
                        }
                        if (j6 <= j20 && j20 < j6 + j7) {
                            if (z2) {
                                j8 = getu32(elfByteChannel, byteBufferAllocate, j4 + 4);
                            } else {
                                j8 = get64(elfByteChannel, byteBufferAllocate, j4 + 8);
                            }
                            j2 = j8 + (j20 - j6);
                            break;
                        }
                    } else {
                        j13 = j13;
                    }
                    j12 = j4 + ((long) i);
                    i3++;
                    j13 = j13;
                }
                if (j2 == 0) {
                    throw new ElfError("did not find file offset of DT_STRTAB table");
                }
                String[] strArr = new String[i2];
                int i4 = 0;
                do {
                    j3 = z2 ? getu32(elfByteChannel, byteBufferAllocate, j) : get64(elfByteChannel, byteBufferAllocate, j);
                    if (j3 == 1) {
                        strArr[i4] = getSz(elfByteChannel, byteBufferAllocate, (z2 ? getu32(elfByteChannel, byteBufferAllocate, j + 4) : get64(elfByteChannel, byteBufferAllocate, j + 8)) + j2);
                        if (i4 == Integer.MAX_VALUE) {
                            throw new ElfError("malformed DT_NEEDED section");
                        }
                        i4++;
                    }
                    j += z2 ? 8L : 16L;
                } while (j3 != 0);
                if (i4 == i2) {
                    return strArr;
                }
                throw new ElfError("malformed DT_NEEDED section");
            }
            j11 = j22;
        }
    }

    private static String getSz(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(elfByteChannel, byteBuffer, j);
            if (u8Var != 0) {
                sb.append((char) u8Var);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }

    private static void read(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int i2;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (i2 = elfByteChannel.read(byteBuffer, j)) != -1) {
            j += (long) i2;
        }
        if (byteBuffer.remaining() > 0) {
            throw new ElfError("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    private static long get64(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static long getu32(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static int getu16(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    private static short getu8(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    protected static class ElfError extends UnsatisfiedLinkError {
        ElfError(String str) {
            super(str);
        }
    }
}
