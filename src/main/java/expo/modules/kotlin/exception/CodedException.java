package expo.modules.kotlin.exception;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: CodedException.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\b\u0017\u0018\u0000 \u00102\u00060\u0001j\u0002`\u0002:\u0001\u0010B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB%\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u000bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/exception/CodedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "()V", "providedCode", "getCode", "()Ljava/lang/String;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CodedException extends Exception {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String providedCode;

    public /* synthetic */ CodedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    public CodedException(String str, Throwable th) {
        super(str, th);
    }

    public final String getCode() {
        String str = this.providedCode;
        return str == null ? INSTANCE.inferCode(getClass()) : str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CodedException(String code, String str, Throwable th) {
        this(str, th);
        Intrinsics.checkNotNullParameter(code, "code");
        this.providedCode = code;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CodedException(Throwable cause) {
        this(cause.getLocalizedMessage(), cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    public CodedException() {
        this(null, null);
    }

    /* JADX INFO: compiled from: CodedException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0001¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/exception/CodedException$Companion;", "", "<init>", "()V", "inferCode", "", "clazz", "Ljava/lang/Class;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String inferCode(Class<?> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            String simpleName = clazz.getSimpleName();
            if (simpleName == null) {
                throw new IllegalArgumentException("Cannot infer code name from class name. We don't support anonymous classes.".toString());
            }
            String strReplace = new Regex("(.)([A-Z])").replace(new Regex("(Exception)$").replace(simpleName, ""), "$1_$2");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String upperCase = strReplace.toUpperCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return "ERR_" + upperCase;
        }
    }
}
