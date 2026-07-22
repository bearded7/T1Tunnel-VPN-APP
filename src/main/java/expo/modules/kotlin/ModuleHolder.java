package expo.modules.kotlin;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.classcomponent.ClassDefinitionData;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithPayload;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.MethodNotFoundException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilderKt;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponent;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.objects.PropertyComponent;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: ModuleHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J+\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000f2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&2\u0006\u0010'\u001a\u00020(¢\u0006\u0002\u0010)J%\u0010*\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u000f2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.J!\u0010,\u001a\u00020\u001d\"\u0004\b\u0001\u0010/2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002H/¢\u0006\u0002\u00101J/\u0010,\u001a\u00020\u001d\"\u0004\b\u0001\u00102\"\u0004\b\u0002\u0010/2\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u0002H22\u0006\u00100\u001a\u0002H/¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020\u001dR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0017¨\u00066"}, d2 = {"Lexpo/modules/kotlin/ModuleHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/modules/Module;", "", "module", "<init>", "(Lexpo/modules/kotlin/modules/Module;)V", "getModule", "()Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/kotlin/modules/Module;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getDefinition", "()Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "name", "", "getName", "()Ljava/lang/String;", "wasInitialized", "", "safeJSObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "getSafeJSObject", "()Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "jsObject", "getJsObject", "jsObject$delegate", "Lkotlin/Lazy;", "attachPrimitives", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "moduleDecorator", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", NotificationCompat.CATEGORY_CALL, "methodName", "args", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Ljava/lang/String;[Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "callSync", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "post", "eventName", "Lexpo/modules/kotlin/events/EventName;", "Payload", "payload", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;)V", "Sender", "sender", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "registerContracts", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModuleHolder<T extends Module> {
    private final ModuleDefinitionData definition;

    /* JADX INFO: renamed from: jsObject$delegate, reason: from kotlin metadata */
    private final Lazy jsObject;
    private final T module;
    private boolean wasInitialized;

    public ModuleHolder(T module) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.module = module;
        this.definition = module.definition();
        this.jsObject = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.ModuleHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModuleHolder.jsObject_delegate$lambda$4(this.f$0);
            }
        });
    }

    public final T getModule() {
        return this.module;
    }

    public final ModuleDefinitionData getDefinition() {
        return this.definition;
    }

    public final String getName() {
        return this.definition.getName();
    }

    public final JavaScriptModuleObject getSafeJSObject() {
        if (this.wasInitialized) {
            return getJsObject();
        }
        return null;
    }

    public final JavaScriptModuleObject getJsObject() {
        return (JavaScriptModuleObject) this.jsObject.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JavaScriptModuleObject jsObject_delegate$lambda$4(final ModuleHolder moduleHolder) {
        moduleHolder.wasInitialized = true;
        Trace.beginSection("[ExpoModulesCore] " + (moduleHolder.getName() + ".jsObject"));
        try {
            final AppContext appContext = moduleHolder.getModule().getAppContext();
            final JNIDeallocator jniDeallocator = moduleHolder.getModule().getRuntimeContext().getJniDeallocator();
            JSDecoratorsBridgingObject jSDecoratorsBridgingObject = new JSDecoratorsBridgingObject(jniDeallocator);
            moduleHolder.attachPrimitives(appContext, moduleHolder.getDefinition().getObjectDefinition(), jSDecoratorsBridgingObject, moduleHolder.getName());
            jSDecoratorsBridgingObject.registerProperty("__expo_module_name__", false, new ExpectedType[0], new JNIFunctionBody(moduleHolder) { // from class: expo.modules.kotlin.ModuleHolder$jsObject$2$1$1
                final /* synthetic */ ModuleHolder<T> this$0;

                {
                    this.this$0 = moduleHolder;
                }

                @Override // expo.modules.kotlin.jni.JNIFunctionBody
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.getName();
                }
            }, false, new ExpectedType[0], null);
            final JSDecoratorsBridgingObject jSDecoratorsBridgingObject2 = new JSDecoratorsBridgingObject(jniDeallocator);
            Map<String, ViewManagerDefinition> viewManagerDefinitions = moduleHolder.getDefinition().getViewManagerDefinitions();
            final Function2<String, ViewManagerDefinition, Unit> function2 = new Function2<String, ViewManagerDefinition, Unit>() { // from class: expo.modules.kotlin.ModuleHolder$jsObject$2$1$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, ViewManagerDefinition viewManagerDefinition) {
                    invoke2(str, viewManagerDefinition);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String key, ViewManagerDefinition definition) {
                    String name;
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(definition, "definition");
                    List<BaseAsyncFunctionComponent> asyncFunctions = definition.getAsyncFunctions();
                    if (asyncFunctions.isEmpty()) {
                        return;
                    }
                    JNIDeallocator jNIDeallocator = jniDeallocator;
                    JSDecoratorsBridgingObject jSDecoratorsBridgingObject3 = jSDecoratorsBridgingObject2;
                    ModuleHolder<T> moduleHolder2 = moduleHolder;
                    AppContext appContext2 = appContext;
                    Trace.beginSection("[ExpoModulesCore] Attaching view prototype");
                    try {
                        JSDecoratorsBridgingObject jSDecoratorsBridgingObject4 = new JSDecoratorsBridgingObject(jNIDeallocator);
                        Iterator<T> it = asyncFunctions.iterator();
                        while (it.hasNext()) {
                            ((BaseAsyncFunctionComponent) it.next()).attachToJSObject(appContext2, jSDecoratorsBridgingObject4, moduleHolder2.getName());
                        }
                        if (key.hashCode() == 764185466 && key.equals(ModuleDefinitionBuilderKt.DEFAULT_MODULE_VIEW)) {
                            name = moduleHolder2.getName();
                        } else {
                            name = moduleHolder2.getName() + "_" + definition.getName();
                        }
                        jSDecoratorsBridgingObject3.registerObject(name, jSDecoratorsBridgingObject4);
                        Unit unit = Unit.INSTANCE;
                    } finally {
                        Trace.endSection();
                    }
                }
            };
            viewManagerDefinitions.forEach(new BiConsumer(function2) { // from class: expo.modules.kotlin.ModuleHolder$sam$java_util_function_BiConsumer$0
                private final /* synthetic */ Function2 function;

                {
                    Intrinsics.checkNotNullParameter(function2, "function");
                    this.function = function2;
                }

                @Override // java.util.function.BiConsumer
                public final /* synthetic */ void accept(Object obj, Object obj2) {
                    this.function.invoke(obj, obj2);
                }
            });
            jSDecoratorsBridgingObject.registerObject("ViewPrototypes", jSDecoratorsBridgingObject2);
            Trace.beginSection("[ExpoModulesCore] Attaching classes");
            try {
                for (ClassDefinitionData classDefinitionData : moduleHolder.getDefinition().getClassData()) {
                    JSDecoratorsBridgingObject jSDecoratorsBridgingObject3 = new JSDecoratorsBridgingObject(jniDeallocator);
                    moduleHolder.attachPrimitives(appContext, classDefinitionData.getObjectDefinition(), jSDecoratorsBridgingObject3, classDefinitionData.getName());
                    SyncFunctionComponent constructor = classDefinitionData.getConstructor();
                    KType ownerType = constructor.getOwnerType();
                    Class<?> javaClass = null;
                    KClassifier classifier = ownerType != null ? ownerType.getClassifier() : null;
                    KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
                    if (kClass != null) {
                        javaClass = JvmClassMappingKt.getJavaClass(kClass);
                    }
                    jSDecoratorsBridgingObject.registerClass(classDefinitionData.getName(), jSDecoratorsBridgingObject3, constructor.getTakesOwner$expo_modules_core_release(), javaClass, classDefinitionData.getIsSharedRef(), (ExpectedType[]) constructor.getCppRequiredTypes$expo_modules_core_release().toArray(new ExpectedType[0]), constructor.getJNIFunctionBody$expo_modules_core_release(classDefinitionData.getName(), appContext));
                }
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                JavaScriptModuleObject javaScriptModuleObject = new JavaScriptModuleObject(jniDeallocator, moduleHolder.getName());
                javaScriptModuleObject.decorate(jSDecoratorsBridgingObject);
                return javaScriptModuleObject;
            } finally {
                Trace.endSection();
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void call(String methodName, Object[] args, Promise promise) throws FunctionCallException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = this.definition.getAsyncFunctions().get(methodName);
            if (baseAsyncFunctionComponent == null) {
                throw new MethodNotFoundException();
            }
            if (!(baseAsyncFunctionComponent instanceof AsyncFunctionComponent)) {
                throw new IllegalStateException("Cannot call a " + baseAsyncFunctionComponent + " method in test context");
            }
            ((AsyncFunctionComponent) baseAsyncFunctionComponent).callUserImplementation$expo_modules_core_release(args, promise, this.module.getAppContext());
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
            throw new FunctionCallException(methodName, this.definition.getName(), unexpectedException);
        }
    }

    public final Object callSync(String methodName, Object[] args) throws MethodNotFoundException {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        SyncFunctionComponent syncFunctionComponent = this.definition.getSyncFunctions().get(methodName);
        if (syncFunctionComponent == null) {
            throw new MethodNotFoundException();
        }
        return SyncFunctionComponent.callUserImplementation$default(syncFunctionComponent, args, null, 2, null);
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        BasicEventListener basicEventListener = eventListener instanceof BasicEventListener ? (BasicEventListener) eventListener : null;
        if (basicEventListener != null) {
            basicEventListener.call();
        }
    }

    public final <Payload> void post(EventName eventName, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        EventListenerWithPayload eventListenerWithPayload = eventListener instanceof EventListenerWithPayload ? (EventListenerWithPayload) eventListener : null;
        if (eventListenerWithPayload != null) {
            eventListenerWithPayload.call(payload);
        }
    }

    public final <Sender, Payload> void post(EventName eventName, Sender sender, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        EventListenerWithSenderAndPayload eventListenerWithSenderAndPayload = eventListener instanceof EventListenerWithSenderAndPayload ? (EventListenerWithSenderAndPayload) eventListener : null;
        if (eventListenerWithSenderAndPayload != null) {
            eventListenerWithSenderAndPayload.call(sender, payload);
        }
    }

    public final void registerContracts() {
        Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> registerContracts = this.definition.getRegisterContracts();
        if (registerContracts != null) {
            BuildersKt__Builders_commonKt.launch$default(this.module.getAppContext().getMainQueue(), null, null, new ModuleHolder$registerContracts$1$1(registerContracts, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attachPrimitives(AppContext appContext, ObjectDefinitionData definition, JSDecoratorsBridgingObject moduleDecorator, String name) {
        Trace.beginSection("[ExpoModulesCore] Exporting constants");
        try {
            WritableNativeMap writableNativeMapMakeNativeMap = Arguments.makeNativeMap(definition.getLegacyConstantsProvider().invoke());
            Intrinsics.checkNotNullExpressionValue(writableNativeMapMakeNativeMap, "makeNativeMap(...)");
            moduleDecorator.registerConstants(writableNativeMapMakeNativeMap);
            Iterator<Map.Entry<String, ConstantComponent>> it = definition.getConstants().entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().attachToJSObject(moduleDecorator);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("[ExpoModulesCore] Attaching functions");
            try {
                ConcatIterator<AnyFunction> functions = definition.getFunctions();
                while (functions.hasNext()) {
                    functions.next().attachToJSObject(appContext, moduleDecorator, name);
                }
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("[ExpoModulesCore] Attaching properties");
                try {
                    Iterator<Map.Entry<String, PropertyComponent>> it2 = definition.getProperties().entrySet().iterator();
                    while (it2.hasNext()) {
                        it2.next().getValue().attachToJSObject(appContext, moduleDecorator);
                    }
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }
}
