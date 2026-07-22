package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.ArgumentCastException;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.InvalidArgsNumberException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: AnyFunction.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ=\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00052\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010(\u001a\u00020\u000fH\u0004¢\u0006\u0002\u0010)J \u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0003H&J\u0013\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0000¢\u0006\u0002\b2J\u0010\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lexpo/modules/kotlin/functions/AnyFunction;", "", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "<init>", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "getName", "()Ljava/lang/String;", "getDesiredArgsTypes", "()[Lexpo/modules/kotlin/types/AnyType;", "[Lexpo/modules/kotlin/types/AnyType;", "canTakeOwner", "", "getCanTakeOwner$annotations", "()V", "getCanTakeOwner", "()Z", "setCanTakeOwner", "(Z)V", "ownerType", "Lkotlin/reflect/KType;", "getOwnerType$annotations", "getOwnerType", "()Lkotlin/reflect/KType;", "setOwnerType", "(Lkotlin/reflect/KType;)V", "isEnumerable", "isEnumerable$expo_modules_core_release", "setEnumerable$expo_modules_core_release", "takesOwner", "getTakesOwner$expo_modules_core_release", "requiredArgumentsCount", "", "convertArgs", "args", "appContext", "Lexpo/modules/kotlin/AppContext;", "forceConversion", "([Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;Z)[Ljava/lang/Object;", "attachToJSObject", "", "jsObject", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "moduleName", "getCppRequiredTypes", "", "Lexpo/modules/kotlin/jni/ExpectedType;", "getCppRequiredTypes$expo_modules_core_release", "enumerable", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AnyFunction {
    private boolean canTakeOwner;
    private final AnyType[] desiredArgsTypes;
    private boolean isEnumerable;
    private final String name;
    private KType ownerType;
    private final int requiredArgumentsCount;

    public static /* synthetic */ void getCanTakeOwner$annotations() {
    }

    public static /* synthetic */ void getOwnerType$annotations() {
    }

    public abstract void attachToJSObject(AppContext appContext, JSDecoratorsBridgingObject jsObject, String moduleName);

    public AnyFunction(String name, AnyType[] desiredArgsTypes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        this.name = name;
        this.desiredArgsTypes = desiredArgsTypes;
        this.isEnumerable = true;
        Iterator it = ArraysKt.reversed(this.desiredArgsTypes).iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (!((AnyType) it.next()).getKType().getIsMarkedNullable()) {
                break;
            } else {
                i++;
            }
        }
        this.requiredArgumentsCount = i >= 0 ? this.desiredArgsTypes.length - i : 0;
    }

    protected final String getName() {
        return this.name;
    }

    protected final AnyType[] getDesiredArgsTypes() {
        return this.desiredArgsTypes;
    }

    public final boolean getCanTakeOwner() {
        return this.canTakeOwner;
    }

    public final void setCanTakeOwner(boolean z) {
        this.canTakeOwner = z;
    }

    public final KType getOwnerType() {
        return this.ownerType;
    }

    public final void setOwnerType(KType kType) {
        this.ownerType = kType;
    }

    /* JADX INFO: renamed from: isEnumerable$expo_modules_core_release, reason: from getter */
    public final boolean getIsEnumerable() {
        return this.isEnumerable;
    }

    public final void setEnumerable$expo_modules_core_release(boolean z) {
        this.isEnumerable = z;
    }

    public final boolean getTakesOwner$expo_modules_core_release() {
        KType kType;
        if (!this.canTakeOwner) {
            return false;
        }
        AnyType anyType = (AnyType) ArraysKt.firstOrNull(this.desiredArgsTypes);
        KClassifier classifier = (anyType == null || (kType = anyType.getKType()) == null) ? null : kType.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            return false;
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(JavaScriptObject.class))) {
            return true;
        }
        KType kType2 = this.ownerType;
        KClassifier classifier2 = kType2 != null ? kType2.getClassifier() : null;
        KClass kClass2 = classifier2 instanceof KClass ? (KClass) classifier2 : null;
        if (kClass2 == null) {
            return false;
        }
        return Intrinsics.areEqual(kClass, kClass2);
    }

    public static /* synthetic */ Object[] convertArgs$default(AnyFunction anyFunction, Object[] objArr, AppContext appContext, boolean z, int i, Object obj) throws CodedException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertArgs");
        }
        if ((i & 2) != 0) {
            appContext = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return anyFunction.convertArgs(objArr, appContext, z);
    }

    protected final Object[] convertArgs(Object[] args, AppContext appContext, boolean forceConversion) throws CodedException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(args, "args");
        if (this.requiredArgumentsCount <= args.length) {
            int length = args.length;
            AnyType[] anyTypeArr = this.desiredArgsTypes;
            if (length <= anyTypeArr.length) {
                Object[] objArr = anyTypeArr.length == args.length ? args : new Object[anyTypeArr.length];
                int length2 = args.length;
                for (int i = 0; i < length2; i++) {
                    Object obj = args[i];
                    AnyType anyType = this.desiredArgsTypes[i];
                    try {
                        objArr[i] = anyType.convert(obj, appContext, forceConversion);
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        if (th instanceof CodedException) {
                            unexpectedException = (CodedException) th;
                        } else if (th instanceof expo.modules.core.errors.CodedException) {
                            expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                            String code = codedException.getCode();
                            Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                            unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
                        } else {
                            unexpectedException = new UnexpectedException(th);
                        }
                        throw new ArgumentCastException(anyType.getKType(), i, String.valueOf(obj != null ? obj.getClass() : null), unexpectedException);
                    }
                }
                return objArr;
            }
        }
        throw new InvalidArgsNumberException(args.length, this.desiredArgsTypes.length, this.requiredArgumentsCount);
    }

    public final List<ExpectedType> getCppRequiredTypes$expo_modules_core_release() {
        AnyType[] anyTypeArr = this.desiredArgsTypes;
        ArrayList arrayList = new ArrayList(anyTypeArr.length);
        for (AnyType anyType : anyTypeArr) {
            arrayList.add(anyType.getCppRequiredTypes());
        }
        return arrayList;
    }

    public static /* synthetic */ AnyFunction enumerable$default(AnyFunction anyFunction, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enumerable");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return anyFunction.enumerable(z);
    }

    public final AnyFunction enumerable(boolean isEnumerable) {
        this.isEnumerable = isEnumerable;
        return this;
    }
}
