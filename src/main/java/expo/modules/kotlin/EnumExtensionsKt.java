package expo.modules.kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: EnumExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0012\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u00020\u0004*\u0002H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"convertToString", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lexpo/modules/kotlin/types/Enumerable;", "(Ljava/lang/Enum;)Ljava/lang/String;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EnumExtensionsKt {
    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;)Ljava/lang/String; */
    public static final String convertToString(Enum r4) {
        List<KParameter> parameters;
        Object next;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(r4.getClass());
        KFunction fastPrimaryConstructor = KClassExtensionsKt.getFastPrimaryConstructor(orCreateKotlinClass);
        if (fastPrimaryConstructor != null && (parameters = fastPrimaryConstructor.getParameters()) != null && parameters.size() == 1) {
            String name = ((KParameter) CollectionsKt.first((List) fastPrimaryConstructor.getParameters())).getName();
            Iterator it = KClasses.getDeclaredMemberProperties(orCreateKotlinClass).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((KProperty1) next).getName(), name));
            KProperty1 kProperty1 = (KProperty1) next;
            if (kProperty1 == null) {
                throw new IllegalArgumentException(("Cannot find a property for " + name + " parameter").toString());
            }
            if (!Intrinsics.areEqual(kProperty1.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(String.class))) {
                throw new IllegalArgumentException("The enum parameter has to be a string.".toString());
            }
            return (String) kProperty1.get(r4);
        }
        return r4.name();
    }
}
