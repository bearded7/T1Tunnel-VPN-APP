package expo.modules.kotlin.types;

import android.net.Uri;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.typedarray.BigInt64Array;
import expo.modules.kotlin.typedarray.BigUint64Array;
import expo.modules.kotlin.typedarray.Float32Array;
import expo.modules.kotlin.typedarray.Float64Array;
import expo.modules.kotlin.typedarray.Int16Array;
import expo.modules.kotlin.typedarray.Int32Array;
import expo.modules.kotlin.typedarray.Int8Array;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import expo.modules.kotlin.typedarray.Uint32Array;
import expo.modules.kotlin.typedarray.Uint8Array;
import expo.modules.kotlin.typedarray.Uint8ClampedArray;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AnyType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R<\u0010\u0004\u001a\"\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\t0\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lexpo/modules/kotlin/types/AnyTypeProvider;", "", "<init>", "()V", "typesMap", "", "Lkotlin/Pair;", "Lkotlin/reflect/KClass;", "", "Lexpo/modules/kotlin/types/AnyType;", "getTypesMap$annotations", "getTypesMap", "()Ljava/util/Map;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnyTypeProvider {
    public static final AnyTypeProvider INSTANCE = new AnyTypeProvider();
    private static final Map<Pair<KClass<? extends Object>, Boolean>, AnyType> typesMap;

    public static /* synthetic */ void getTypesMap$annotations() {
    }

    private AnyTypeProvider() {
    }

    public final Map<Pair<KClass<? extends Object>, Boolean>, AnyType> getTypesMap() {
        return typesMap;
    }

    static {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (KClass kClass : CollectionsKt.listOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(long[].class), Reflection.getOrCreateKotlinClass(int[].class), Reflection.getOrCreateKotlinClass(boolean[].class), Reflection.getOrCreateKotlinClass(float[].class), Reflection.getOrCreateKotlinClass(double[].class), Reflection.getOrCreateKotlinClass(JavaScriptValue.class), Reflection.getOrCreateKotlinClass(JavaScriptObject.class), Reflection.getOrCreateKotlinClass(TypedArray.class), Reflection.getOrCreateKotlinClass(Int8Array.class), Reflection.getOrCreateKotlinClass(Int16Array.class), Reflection.getOrCreateKotlinClass(Int32Array.class), Reflection.getOrCreateKotlinClass(Uint8Array.class), Reflection.getOrCreateKotlinClass(Uint8ClampedArray.class), Reflection.getOrCreateKotlinClass(Uint16Array.class), Reflection.getOrCreateKotlinClass(Uint32Array.class), Reflection.getOrCreateKotlinClass(Float32Array.class), Reflection.getOrCreateKotlinClass(Float64Array.class), Reflection.getOrCreateKotlinClass(BigInt64Array.class), Reflection.getOrCreateKotlinClass(BigUint64Array.class), Reflection.getOrCreateKotlinClass(ReadableArray.class), Reflection.getOrCreateKotlinClass(ReadableMap.class), Reflection.getOrCreateKotlinClass(URL.class), Reflection.getOrCreateKotlinClass(Uri.class), Reflection.getOrCreateKotlinClass(URI.class), Reflection.getOrCreateKotlinClass(File.class), Reflection.getOrCreateKotlinClass(Object.class), Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(ReadableArguments.class)})) {
            mapCreateMapBuilder.put(TuplesKt.to(kClass, false), new AnyType(new EmptyKType(kClass, false), null, 2, null));
            mapCreateMapBuilder.put(TuplesKt.to(kClass, true), new AnyType(new EmptyKType(kClass, true), null, 2, null));
        }
        typesMap = MapsKt.build(mapCreateMapBuilder);
    }
}
