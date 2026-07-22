package expo.modules.kotlin.types;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: AnyType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/types/LazyKType;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClass;", "isMarkedNullable", "", "kTypeProvider", "Lkotlin/Function0;", "<init>", "(Lkotlin/reflect/KClass;ZLkotlin/jvm/functions/Function0;)V", "getClassifier", "()Lkotlin/reflect/KClass;", "()Z", "getKTypeProvider", "()Lkotlin/jvm/functions/Function0;", "_kType", "kType", "getKType", "()Lkotlin/reflect/KType;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "equals", "other", "", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LazyKType implements KType {
    private KType _kType;
    private final KClass<?> classifier;
    private final boolean isMarkedNullable;
    private final Function0<KType> kTypeProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyKType(KClass<?> classifier, boolean z, Function0<? extends KType> kTypeProvider) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(kTypeProvider, "kTypeProvider");
        this.classifier = classifier;
        this.isMarkedNullable = z;
        this.kTypeProvider = kTypeProvider;
    }

    public /* synthetic */ LazyKType(KClass kClass, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? false : z, function0);
    }

    @Override // kotlin.reflect.KType
    public KClass<?> getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    /* JADX INFO: renamed from: isMarkedNullable, reason: from getter */
    public boolean getIsMarkedNullable() {
        return this.isMarkedNullable;
    }

    public final Function0<KType> getKTypeProvider() {
        return this.kTypeProvider;
    }

    private final KType getKType() {
        if (this._kType == null) {
            this._kType = this.kTypeProvider.invoke();
        }
        KType kType = this._kType;
        Intrinsics.checkNotNull(kType);
        return kType;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return getKType().getAnnotations();
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return getKType().getArguments();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LazyKType)) {
            return Intrinsics.areEqual(getKType(), other);
        }
        LazyKType lazyKType = (LazyKType) other;
        return Intrinsics.areEqual(getClassifier(), lazyKType.getClassifier()) && getIsMarkedNullable() == lazyKType.getIsMarkedNullable();
    }

    public int hashCode() {
        return (getClassifier().hashCode() * 31) + Boolean.hashCode(getIsMarkedNullable());
    }

    public String toString() {
        return getKType().toString();
    }
}
