package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: Either.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, d2 = {"toKClass", "Lkotlin/reflect/KClass;", ExifInterface.GPS_DIRECTION_TRUE, "", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EitherKt {
    public static final /* synthetic */ <T> KClass<T> toKClass() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Reflection.getOrCreateKotlinClass(Object.class);
    }
}
