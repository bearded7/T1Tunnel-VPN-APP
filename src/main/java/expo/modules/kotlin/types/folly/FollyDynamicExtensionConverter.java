package expo.modules.kotlin.types.folly;

import android.util.ArrayMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.bm.Languages;

/* JADX INFO: compiled from: FollyDynamicExtensionConverter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/types/folly/FollyDynamicExtensionConverter;", "", "<init>", "()V", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FollyDynamicExtensionConverter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArrayMap<Integer, Object> instanceMap = new ArrayMap<>();
    private static int nextId;

    /* JADX INFO: compiled from: FollyDynamicExtensionConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\tH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/kotlin/types/folly/FollyDynamicExtensionConverter$Companion;", "", "<init>", "()V", "instanceMap", "Landroid/util/ArrayMap;", "", "nextId", "put", "", Languages.ANY, "get", "payload", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final synchronized String put(Object any) {
            int i;
            Intrinsics.checkNotNullParameter(any, "any");
            i = FollyDynamicExtensionConverter.nextId;
            FollyDynamicExtensionConverter.nextId = i + 1;
            FollyDynamicExtensionConverter.instanceMap.put(Integer.valueOf(i), any);
            return FollyDynamicExtensionConverterKt.DYNAMIC_EXTENSION_PREFIX + i;
        }

        @JvmStatic
        public final synchronized Object get(String payload) {
            String strSubstring;
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!StringsKt.startsWith$default(payload, FollyDynamicExtensionConverterKt.DYNAMIC_EXTENSION_PREFIX, false, 2, (Object) null)) {
                throw new InvalidDynamicExtensionFormatException();
            }
            strSubstring = payload.substring(27);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return FollyDynamicExtensionConverter.instanceMap.remove(Integer.valueOf(Integer.parseInt(strSubstring)));
        }
    }

    @JvmStatic
    public static final synchronized String put(Object obj) {
        return INSTANCE.put(obj);
    }

    @JvmStatic
    public static final synchronized Object get(String str) {
        return INSTANCE.get(str);
    }
}
