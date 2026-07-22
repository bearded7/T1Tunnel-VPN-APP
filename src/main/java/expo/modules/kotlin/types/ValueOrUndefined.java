package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValueOrUndefined.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\t\n\u000bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/ValueOrUndefined;", ExifInterface.GPS_DIRECTION_TRUE, "", "isUndefined", "", "()Z", "optional", "getOptional", "()Ljava/lang/Object;", "Value", "Undefined", "Companion", "Lexpo/modules/kotlin/types/ValueOrUndefined$Undefined;", "Lexpo/modules/kotlin/types/ValueOrUndefined$Value;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ValueOrUndefined<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static Object getUndefined() {
        return INSTANCE.getUndefined();
    }

    T getOptional();

    boolean isUndefined();

    /* JADX INFO: compiled from: ValueOrUndefined.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> boolean isUndefined(ValueOrUndefined<T> valueOrUndefined) {
            return valueOrUndefined instanceof Undefined;
        }

        public static <T> T getOptional(ValueOrUndefined<T> valueOrUndefined) {
            if (valueOrUndefined instanceof Value) {
                return (T) ((Value) valueOrUndefined).getValue();
            }
            if (valueOrUndefined instanceof Undefined) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: ValueOrUndefined.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/types/ValueOrUndefined$Value;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/types/ValueOrUndefined;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lexpo/modules/kotlin/types/ValueOrUndefined$Value;", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Value<T> implements ValueOrUndefined<T> {
        private final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Value copy$default(Value value, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = value.value;
            }
            return value.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Value<T> copy(T value) {
            return new Value<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Value) && Intrinsics.areEqual(this.value, ((Value) other).value);
        }

        public int hashCode() {
            T t = this.value;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Value(value=" + this.value + ")";
        }

        public Value(T t) {
            this.value = t;
        }

        @Override // expo.modules.kotlin.types.ValueOrUndefined
        public T getOptional() {
            return (T) DefaultImpls.getOptional(this);
        }

        public final T getValue() {
            return this.value;
        }

        @Override // expo.modules.kotlin.types.ValueOrUndefined
        public boolean isUndefined() {
            return DefaultImpls.isUndefined(this);
        }
    }

    /* JADX INFO: compiled from: ValueOrUndefined.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/types/ValueOrUndefined$Undefined;", "Lexpo/modules/kotlin/types/ValueOrUndefined;", "", "<init>", "()V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Undefined implements ValueOrUndefined {
        public static final Undefined INSTANCE = new Undefined();

        private Undefined() {
        }

        @Override // expo.modules.kotlin.types.ValueOrUndefined
        public Void getOptional() {
            return (Void) DefaultImpls.getOptional(this);
        }

        @Override // expo.modules.kotlin.types.ValueOrUndefined
        public boolean isUndefined() {
            return DefaultImpls.isUndefined(this);
        }
    }

    /* JADX INFO: compiled from: ValueOrUndefined.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0001H\u0007¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/types/ValueOrUndefined$Companion;", "", "<init>", "()V", "getUndefined", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final Object getUndefined() {
            return Undefined.INSTANCE;
        }
    }
}
