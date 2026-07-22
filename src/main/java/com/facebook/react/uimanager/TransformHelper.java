package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TransformHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0007J:\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\bH\u0002J,\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J3\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u001dH\u0083 R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/react/uimanager/TransformHelper;", "", "<init>", "()V", "helperMatrix", "Ljava/lang/ThreadLocal;", "", "convertToRadians", "", "transformMap", "Lcom/facebook/react/bridge/ReadableMap;", "key", "", "processTransform", "", "transforms", "Lcom/facebook/react/bridge/ReadableArray;", "result", "viewWidth", "", "viewHeight", ViewProps.TRANSFORM_ORIGIN, "allowPercentageResolution", "", "parseTranslateValue", "stringValue", "dimension", "getTranslateForTransformOrigin", "nativeProcessTransform", "Lcom/facebook/react/bridge/NativeArray;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransformHelper {
    public static final TransformHelper INSTANCE = new TransformHelper();
    private static final ThreadLocal<double[]> helperMatrix = new ThreadLocal<double[]>() { // from class: com.facebook.react.uimanager.TransformHelper$helperMatrix$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public double[] initialValue() {
            return new double[16];
        }
    };

    /* JADX INFO: compiled from: TransformHelper.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    private static final native void nativeProcessTransform(NativeArray transforms, double[] result, float viewWidth, float viewHeight, NativeArray transformOrigin);

    private TransformHelper() {
    }

    private final double convertToRadians(ReadableMap transformMap, String key) {
        double d;
        boolean z = true;
        if (transformMap.getType(key) == ReadableType.String) {
            String string = transformMap.getString(key);
            Intrinsics.checkNotNull(string);
            if (StringsKt.endsWith$default(string, "rad", false, 2, (Object) null)) {
                string = StringsKt.dropLast(string, 3);
            } else if (StringsKt.endsWith$default(string, "deg", false, 2, (Object) null)) {
                string = StringsKt.dropLast(string, 3);
                z = false;
            }
            d = Double.parseDouble(string);
        } else {
            d = transformMap.getDouble(key);
        }
        return z ? d : MatrixMathHelper.degreesToRadians(d);
    }

    @Deprecated(message = "Use processTransform(ReadableArray, DoubleArray, Float, Float, ReadableArray, Boolean) instead", replaceWith = @ReplaceWith(expression = "processTransform(...)", imports = {}))
    @JvmStatic
    public static final void processTransform(ReadableArray transforms, double[] result) {
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        Intrinsics.checkNotNullParameter(result, "result");
        processTransform(transforms, result, 0.0f, 0.0f, null, false);
    }

    @Deprecated(message = "Use processTransform(ReadableArray, DoubleArray, Float, Float, ReadableArray, Boolean) instead", replaceWith = @ReplaceWith(expression = "processTransform(...)", imports = {}))
    @JvmStatic
    public static final void processTransform(ReadableArray transforms, double[] result, float viewWidth, float viewHeight, ReadableArray transformOrigin) {
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        Intrinsics.checkNotNullParameter(result, "result");
        processTransform(transforms, result, viewWidth, viewHeight, transformOrigin, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:113:0x0297 A[PHI: r6 r7 r18
  0x0297: PHI (r6v20 char) = 
  (r6v4 char)
  (r6v5 char)
  (r6v6 char)
  (r6v7 char)
  (r6v8 char)
  (r6v9 char)
  (r6v10 char)
  (r6v11 char)
  (r6v12 char)
  (r6v13 char)
  (r6v21 char)
 binds: [B:105:0x0271, B:96:0x023f, B:90:0x021c, B:86:0x0202, B:82:0x01ea, B:78:0x01d2, B:74:0x01b7, B:70:0x019d, B:66:0x0183, B:62:0x016b, B:29:0x00a6] A[DONT_GENERATE, DONT_INLINE]
  0x0297: PHI (r7v26 int) = 
  (r7v4 int)
  (r7v5 int)
  (r7v6 int)
  (r7v7 int)
  (r7v8 int)
  (r7v9 int)
  (r7v10 int)
  (r7v11 int)
  (r7v12 int)
  (r7v13 int)
  (r7v27 int)
 binds: [B:105:0x0271, B:96:0x023f, B:90:0x021c, B:86:0x0202, B:82:0x01ea, B:78:0x01d2, B:74:0x01b7, B:70:0x019d, B:66:0x0183, B:62:0x016b, B:29:0x00a6] A[DONT_GENERATE, DONT_INLINE]
  0x0297: PHI (r18v18 int) = 
  (r18v0 int)
  (r18v1 int)
  (r18v2 int)
  (r18v3 int)
  (r18v4 int)
  (r18v5 int)
  (r18v6 int)
  (r18v7 int)
  (r18v8 int)
  (r18v9 int)
  (r18v19 int)
 binds: [B:105:0x0271, B:96:0x023f, B:90:0x021c, B:86:0x0202, B:82:0x01ea, B:78:0x01d2, B:74:0x01b7, B:70:0x019d, B:66:0x0183, B:62:0x016b, B:29:0x00a6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void processTransform(ReadableArray transforms, double[] result, float viewWidth, float viewHeight, ReadableArray transformOrigin, boolean allowPercentageResolution) {
        int i;
        char c;
        double translateValue;
        double translateValue2;
        double translateValue3;
        double translateValue4;
        double d;
        double d2;
        Intrinsics.checkNotNullParameter(transforms, "transforms");
        Intrinsics.checkNotNullParameter(result, "result");
        int i2 = 1;
        if (allowPercentageResolution && ReactNativeFeatureFlags.useNativeTransformHelperAndroid() && (transforms instanceof NativeArray)) {
            if (transformOrigin == 0 ? true : transformOrigin instanceof NativeArray) {
                nativeProcessTransform((NativeArray) transforms, result, viewWidth, viewHeight, (NativeArray) transformOrigin);
                return;
            }
        }
        double[] dArr = helperMatrix.get();
        Intrinsics.checkNotNull(dArr);
        double[] dArr2 = dArr;
        MatrixMathHelper.resetIdentityMatrix(result);
        double[] translateForTransformOrigin = INSTANCE.getTranslateForTransformOrigin(viewWidth, viewHeight, transformOrigin, allowPercentageResolution);
        if (translateForTransformOrigin != null) {
            MatrixMathHelper.resetIdentityMatrix(dArr2);
            MatrixMathHelper.applyTranslate3D(dArr2, translateForTransformOrigin[0], translateForTransformOrigin[1], translateForTransformOrigin[2]);
            MatrixMathHelper.multiplyInto(result, result, dArr2);
        }
        if (transforms.size() == 16 && transforms.getType(0) == ReadableType.Number) {
            MatrixMathHelper.resetIdentityMatrix(dArr2);
            int size = transforms.size();
            for (int i3 = 0; i3 < size; i3++) {
                dArr2[i3] = transforms.getDouble(i3);
            }
            MatrixMathHelper.multiplyInto(result, result, dArr2);
        } else {
            int size2 = transforms.size();
            int i4 = 0;
            while (i4 < size2) {
                ReadableMap map = transforms.getMap(i4);
                Intrinsics.checkNotNull(map);
                String strNextKey = map.keySetIterator().nextKey();
                MatrixMathHelper.resetIdentityMatrix(dArr2);
                int i5 = i4;
                switch (strNextKey.hashCode()) {
                    case -1721943862:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals(ViewProps.TRANSLATE_X)) {
                            if (map.getType(strNextKey) == ReadableType.String && allowPercentageResolution) {
                                TransformHelper transformHelper = INSTANCE;
                                String string = map.getString(strNextKey);
                                Intrinsics.checkNotNull(string);
                                translateValue = transformHelper.parseTranslateValue(string, viewWidth);
                            } else {
                                translateValue = map.getDouble(strNextKey);
                            }
                            MatrixMathHelper.applyTranslate2D(dArr2, translateValue, 0.0d);
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -1721943861:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals(ViewProps.TRANSLATE_Y)) {
                            if (map.getType(strNextKey) == ReadableType.String && allowPercentageResolution) {
                                TransformHelper transformHelper2 = INSTANCE;
                                String string2 = map.getString(strNextKey);
                                Intrinsics.checkNotNull(string2);
                                translateValue2 = transformHelper2.parseTranslateValue(string2, viewHeight);
                            } else {
                                translateValue2 = map.getDouble(strNextKey);
                            }
                            MatrixMathHelper.applyTranslate2D(dArr2, 0.0d, translateValue2);
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -1081239615:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals("matrix")) {
                            ReadableArray array = map.getArray(strNextKey);
                            Intrinsics.checkNotNull(array);
                            for (int i6 = 0; i6 < 16; i6++) {
                                dArr2[i6] = array.getDouble(i6);
                            }
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -925180581:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals("rotate")) {
                            MatrixMathHelper.applyRotateZ(dArr2, INSTANCE.convertToRadians(map, strNextKey));
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -908189618:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals(ViewProps.SCALE_X)) {
                            MatrixMathHelper.applyScaleX(dArr2, map.getDouble(strNextKey));
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case -908189617:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals(ViewProps.SCALE_Y)) {
                            MatrixMathHelper.applyScaleY(dArr2, map.getDouble(strNextKey));
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 109250890:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals("scale")) {
                            double d3 = map.getDouble(strNextKey);
                            MatrixMathHelper.applyScaleX(dArr2, d3);
                            MatrixMathHelper.applyScaleY(dArr2, d3);
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 109493390:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals("skewX")) {
                            MatrixMathHelper.applySkewX(dArr2, INSTANCE.convertToRadians(map, strNextKey));
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 109493391:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals("skewY")) {
                            MatrixMathHelper.applySkewY(dArr2, INSTANCE.convertToRadians(map, strNextKey));
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 207960636:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        if (strNextKey.equals("perspective")) {
                            MatrixMathHelper.applyPerspective(dArr2, map.getDouble(strNextKey));
                        } else {
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 1052832078:
                        if (strNextKey.equals("translate")) {
                            ReadableArray array2 = map.getArray(strNextKey);
                            Intrinsics.checkNotNull(array2);
                            if (array2.getType(0) == ReadableType.String && allowPercentageResolution) {
                                TransformHelper transformHelper3 = INSTANCE;
                                String string3 = array2.getString(0);
                                Intrinsics.checkNotNull(string3);
                                translateValue3 = transformHelper3.parseTranslateValue(string3, viewWidth);
                            } else {
                                translateValue3 = array2.getDouble(0);
                            }
                            if (array2.getType(i2) == ReadableType.String && allowPercentageResolution) {
                                TransformHelper transformHelper4 = INSTANCE;
                                String string4 = array2.getString(i2);
                                Intrinsics.checkNotNull(string4);
                                translateValue4 = transformHelper4.parseTranslateValue(string4, viewHeight);
                            } else {
                                translateValue4 = array2.getDouble(i2);
                            }
                            if (array2.size() > 2) {
                                d2 = array2.getDouble(2);
                                dArr2 = dArr2;
                                d = translateValue4;
                            } else {
                                d = translateValue4;
                                dArr2 = dArr2;
                                d2 = 0.0d;
                            }
                            i = i2;
                            c = 16;
                            MatrixMathHelper.applyTranslate3D(dArr2, translateValue3, d, d2);
                        } else {
                            i = i2;
                            size2 = size2;
                            c = 16;
                            FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        }
                        break;
                    case 1384173149:
                        if (strNextKey.equals("rotateX")) {
                            MatrixMathHelper.applyRotateX(dArr2, INSTANCE.convertToRadians(map, strNextKey));
                            i = i2;
                            size2 = size2;
                            c = 16;
                        }
                        i = i2;
                        size2 = size2;
                        c = 16;
                        FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        break;
                    case 1384173150:
                        if (strNextKey.equals("rotateY")) {
                            MatrixMathHelper.applyRotateY(dArr2, INSTANCE.convertToRadians(map, strNextKey));
                            i = i2;
                            size2 = size2;
                            c = 16;
                        }
                        i = i2;
                        size2 = size2;
                        c = 16;
                        FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        break;
                    case 1384173151:
                        if (strNextKey.equals("rotateZ")) {
                            i = i2;
                            size2 = size2;
                            c = 16;
                            MatrixMathHelper.applyRotateZ(dArr2, INSTANCE.convertToRadians(map, strNextKey));
                        }
                        i = i2;
                        size2 = size2;
                        c = 16;
                        FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        break;
                    default:
                        i = i2;
                        size2 = size2;
                        c = 16;
                        FLog.w(ReactConstants.TAG, "Unsupported transform type: " + strNextKey);
                        break;
                }
                MatrixMathHelper.multiplyInto(result, result, dArr2);
                i4 = i5 + 1;
                size2 = size2;
                i2 = i;
            }
        }
        int i7 = i2;
        if (translateForTransformOrigin != null) {
            MatrixMathHelper.resetIdentityMatrix(dArr2);
            MatrixMathHelper.applyTranslate3D(dArr2, -translateForTransformOrigin[0], -translateForTransformOrigin[i7], -translateForTransformOrigin[2]);
            MatrixMathHelper.multiplyInto(result, result, dArr2);
        }
    }

    private final double parseTranslateValue(String stringValue, double dimension) {
        try {
            if (StringsKt.endsWith$default(stringValue, "%", false, 2, (Object) null)) {
                return (Double.parseDouble(StringsKt.dropLast(stringValue, 1)) * dimension) / 100.0d;
            }
            return Double.parseDouble(stringValue);
        } catch (NumberFormatException unused) {
            FLog.w(ReactConstants.TAG, "Invalid translate value: " + stringValue);
            return 0.0d;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0043  */
    private final double[] getTranslateForTransformOrigin(float viewWidth, float viewHeight, ReadableArray transformOrigin, boolean allowPercentageResolution) {
        if (transformOrigin == null || (viewHeight == 0.0f && viewWidth == 0.0f)) {
            return null;
        }
        double d = ((double) viewWidth) / 2.0d;
        double d2 = ((double) viewHeight) / 2.0d;
        double[] dArr = new double[3];
        boolean z = false;
        dArr[0] = d;
        int i = 1;
        dArr[1] = d2;
        dArr[2] = 0.0d;
        int iMin = Math.min(transformOrigin.size(), 3);
        int i2 = 0;
        while (i2 < iMin) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[transformOrigin.getType(i2).ordinal()];
            if (i3 == i) {
                dArr[i2] = transformOrigin.getDouble(i2);
            } else if (i3 == 2 && allowPercentageResolution) {
                String string = transformOrigin.getString(i2);
                Intrinsics.checkNotNull(string);
                if (StringsKt.endsWith$default(string, "%", z, 2, (Object) null)) {
                    dArr[i2] = (((double) (i2 == 0 ? viewWidth : viewHeight)) * Double.parseDouble(StringsKt.dropLast(string, i))) / 100.0d;
                }
            }
            i2++;
            z = z;
            i = i;
        }
        boolean z2 = z;
        int i4 = i;
        double d3 = (-d) + dArr[z2 ? 1 : 0];
        double d4 = (-d2) + dArr[i4];
        double d5 = dArr[2];
        double[] dArr2 = new double[3];
        dArr2[z2 ? 1 : 0] = d3;
        dArr2[i4] = d4;
        dArr2[2] = d5;
        return dArr2;
    }
}
