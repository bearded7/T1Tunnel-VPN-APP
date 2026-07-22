package expo.modules.kotlin.objects;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.JSTypeConverter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropertyComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/objects/PropertyComponent;", "", "name", "", "getter", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setter", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/functions/SyncFunctionComponent;Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName", "()Ljava/lang/String;", "getGetter", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getSetter", "attachToJSObject", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "jsObject", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PropertyComponent {
    private final SyncFunctionComponent getter;
    private final String name;
    private final SyncFunctionComponent setter;

    public PropertyComponent(String name, SyncFunctionComponent syncFunctionComponent, SyncFunctionComponent syncFunctionComponent2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.getter = syncFunctionComponent;
        this.setter = syncFunctionComponent2;
    }

    public /* synthetic */ PropertyComponent(String str, SyncFunctionComponent syncFunctionComponent, SyncFunctionComponent syncFunctionComponent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : syncFunctionComponent, (i & 4) != 0 ? null : syncFunctionComponent2);
    }

    public final String getName() {
        return this.name;
    }

    public final SyncFunctionComponent getGetter() {
        return this.getter;
    }

    public final SyncFunctionComponent getSetter() {
        return this.setter;
    }

    public final void attachToJSObject(final AppContext appContext, JSDecoratorsBridgingObject jsObject) {
        ExpectedType[] expectedTypeArr;
        ExpectedType[] expectedTypeArr2;
        List<ExpectedType> cppRequiredTypes$expo_modules_core_release;
        List<ExpectedType> cppRequiredTypes$expo_modules_core_release2;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        JNIFunctionBody jNIFunctionBody = this.getter != null ? new JNIFunctionBody() { // from class: expo.modules.kotlin.objects.PropertyComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNIFunctionBody
            public final Object invoke(Object[] objArr) {
                return PropertyComponent.attachToJSObject$lambda$0(this.f$0, appContext, objArr);
            }
        } : null;
        JNIFunctionBody jNIFunctionBody2 = this.setter != null ? new JNIFunctionBody() { // from class: expo.modules.kotlin.objects.PropertyComponent$$ExternalSyntheticLambda1
            @Override // expo.modules.kotlin.jni.JNIFunctionBody
            public final Object invoke(Object[] objArr) {
                return PropertyComponent.attachToJSObject$lambda$1(this.f$0, appContext, objArr);
            }
        } : null;
        String str = this.name;
        SyncFunctionComponent syncFunctionComponent = this.getter;
        boolean z = syncFunctionComponent != null && syncFunctionComponent.getTakesOwner$expo_modules_core_release();
        SyncFunctionComponent syncFunctionComponent2 = this.getter;
        if (syncFunctionComponent2 == null || (cppRequiredTypes$expo_modules_core_release2 = syncFunctionComponent2.getCppRequiredTypes$expo_modules_core_release()) == null || (expectedTypeArr = (ExpectedType[]) cppRequiredTypes$expo_modules_core_release2.toArray(new ExpectedType[0])) == null) {
            expectedTypeArr = new ExpectedType[0];
        }
        ExpectedType[] expectedTypeArr3 = expectedTypeArr;
        SyncFunctionComponent syncFunctionComponent3 = this.setter;
        boolean z2 = syncFunctionComponent3 != null && syncFunctionComponent3.getTakesOwner$expo_modules_core_release();
        SyncFunctionComponent syncFunctionComponent4 = this.setter;
        if (syncFunctionComponent4 == null || (cppRequiredTypes$expo_modules_core_release = syncFunctionComponent4.getCppRequiredTypes$expo_modules_core_release()) == null || (expectedTypeArr2 = (ExpectedType[]) cppRequiredTypes$expo_modules_core_release.toArray(new ExpectedType[0])) == null) {
            expectedTypeArr2 = new ExpectedType[0];
        }
        jsObject.registerProperty(str, z, expectedTypeArr3, jNIFunctionBody, z2, expectedTypeArr2, jNIFunctionBody2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object attachToJSObject$lambda$0(PropertyComponent propertyComponent, AppContext appContext, Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, propertyComponent.getter.callUserImplementation(args, appContext), null, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object attachToJSObject$lambda$1(PropertyComponent propertyComponent, AppContext appContext, Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        propertyComponent.setter.callUserImplementation(args, appContext);
        return null;
    }
}
