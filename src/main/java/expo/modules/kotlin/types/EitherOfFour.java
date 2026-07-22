package expo.modules.kotlin.types;

import com.caverock.androidsvg.SVGParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: Either.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u0002*\b\b\u0003\u0010\u0005*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00030\u0013H\u0007¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00028\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00030\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0018\u001a\u00028\u0003¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lexpo/modules/kotlin/types/EitherOfFour;", "FirstType", "", "SecondType", "ThirdType", "FourthType", "Lexpo/modules/kotlin/types/EitherOfThree;", "bareValue", "deferredValue", "", "Lexpo/modules/kotlin/types/DeferredValue;", "types", "", "Lkotlin/reflect/KType;", "<init>", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "is", "", SVGParser.XML_STYLESHEET_ATTR_TYPE, "Lkotlin/reflect/KClass;", "isFourthType", "get", "getFourthType", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "fourth", "()Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EitherOfFour<FirstType, SecondType, ThirdType, FourthType> extends EitherOfThree<FirstType, SecondType, ThirdType> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EitherOfFour(Object bareValue, List<DeferredValue> deferredValue, List<? extends KType> types) {
        super(bareValue, deferredValue, types);
        Intrinsics.checkNotNullParameter(bareValue, "bareValue");
        Intrinsics.checkNotNullParameter(deferredValue, "deferredValue");
        Intrinsics.checkNotNullParameter(types, "types");
    }

    public final boolean isFourthType(KClass<FourthType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return is$expo_modules_core_release(3);
    }

    public final FourthType getFourthType(KClass<FourthType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        FourthType fourthtype = (FourthType) get$expo_modules_core_release(3);
        Intrinsics.checkNotNull(fourthtype, "null cannot be cast to non-null type FourthType of expo.modules.kotlin.types.EitherOfFour");
        return fourthtype;
    }

    public final FourthType fourth() {
        FourthType fourthtype = (FourthType) get$expo_modules_core_release(3);
        Intrinsics.checkNotNull(fourthtype, "null cannot be cast to non-null type FourthType of expo.modules.kotlin.types.EitherOfFour");
        return fourthtype;
    }
}
