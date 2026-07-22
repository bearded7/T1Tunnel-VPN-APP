package kotlin.collections;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UArraySorting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", ViewProps.LEFT, ViewProps.RIGHT, "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UArraySortingKt {
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m1234partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte bM850getw2LRezQ = UByteArray.m850getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = bM850getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m850getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m850getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte bM850getw2LRezQ2 = UByteArray.m850getw2LRezQ(bArr, i);
                UByteArray.m855setVurrAj0(bArr, i, UByteArray.m850getw2LRezQ(bArr, i2));
                UByteArray.m855setVurrAj0(bArr, i2, bM850getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m1238quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int iM1234partition4UcCI2c = m1234partition4UcCI2c(bArr, i, i2);
        int i3 = iM1234partition4UcCI2c - 1;
        if (i < i3) {
            m1238quickSort4UcCI2c(bArr, i, i3);
        }
        if (iM1234partition4UcCI2c < i2) {
            m1238quickSort4UcCI2c(bArr, iM1234partition4UcCI2c, i2);
        }
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m1235partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short sM1113getMh2AYeg = UShortArray.m1113getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int iM1113getMh2AYeg = UShortArray.m1113getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = sM1113getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM1113getMh2AYeg, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m1113getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short sM1113getMh2AYeg2 = UShortArray.m1113getMh2AYeg(sArr, i);
                UShortArray.m1118set01HTLdE(sArr, i, UShortArray.m1113getMh2AYeg(sArr, i2));
                UShortArray.m1118set01HTLdE(sArr, i2, sM1113getMh2AYeg2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m1239quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int iM1235partitionAa5vz7o = m1235partitionAa5vz7o(sArr, i, i2);
        int i3 = iM1235partitionAa5vz7o - 1;
        if (i < i3) {
            m1239quickSortAa5vz7o(sArr, i, i3);
        }
        if (iM1235partitionAa5vz7o < i2) {
            m1239quickSortAa5vz7o(sArr, iM1235partitionAa5vz7o, i2);
        }
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m1236partitionoBK06Vg(int[] iArr, int i, int i2) {
        int iM929getpVg5ArA = UIntArray.m929getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compare(UIntArray.m929getpVg5ArA(iArr, i) ^ Integer.MIN_VALUE, iM929getpVg5ArA ^ Integer.MIN_VALUE) < 0) {
                i++;
            }
            while (Integer.compare(UIntArray.m929getpVg5ArA(iArr, i2) ^ Integer.MIN_VALUE, iM929getpVg5ArA ^ Integer.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                int iM929getpVg5ArA2 = UIntArray.m929getpVg5ArA(iArr, i);
                UIntArray.m934setVXSXFK8(iArr, i, UIntArray.m929getpVg5ArA(iArr, i2));
                UIntArray.m934setVXSXFK8(iArr, i2, iM929getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m1240quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int iM1236partitionoBK06Vg = m1236partitionoBK06Vg(iArr, i, i2);
        int i3 = iM1236partitionoBK06Vg - 1;
        if (i < i3) {
            m1240quickSortoBK06Vg(iArr, i, i3);
        }
        if (iM1236partitionoBK06Vg < i2) {
            m1240quickSortoBK06Vg(iArr, iM1236partitionoBK06Vg, i2);
        }
    }

    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m1233partitionnroSd4(long[] jArr, int i, int i2) {
        long jM1008getsVKNKU = ULongArray.m1008getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compare(ULongArray.m1008getsVKNKU(jArr, i) ^ Long.MIN_VALUE, jM1008getsVKNKU ^ Long.MIN_VALUE) < 0) {
                i++;
            }
            while (Long.compare(ULongArray.m1008getsVKNKU(jArr, i2) ^ Long.MIN_VALUE, jM1008getsVKNKU ^ Long.MIN_VALUE) > 0) {
                i2--;
            }
            if (i <= i2) {
                long jM1008getsVKNKU2 = ULongArray.m1008getsVKNKU(jArr, i);
                ULongArray.m1013setk8EXiF4(jArr, i, ULongArray.m1008getsVKNKU(jArr, i2));
                ULongArray.m1013setk8EXiF4(jArr, i2, jM1008getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m1237quickSortnroSd4(long[] jArr, int i, int i2) {
        int iM1233partitionnroSd4 = m1233partitionnroSd4(jArr, i, i2);
        int i3 = iM1233partitionnroSd4 - 1;
        if (i < i3) {
            m1237quickSortnroSd4(jArr, i, i3);
        }
        if (iM1233partitionnroSd4 < i2) {
            m1237quickSortnroSd4(jArr, iM1233partitionnroSd4, i2);
        }
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m1242sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1238quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m1243sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1239quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m1244sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1240quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m1241sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1237quickSortnroSd4(array, i, i2 - 1);
    }
}
