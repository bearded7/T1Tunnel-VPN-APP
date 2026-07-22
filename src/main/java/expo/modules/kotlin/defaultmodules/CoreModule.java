package expo.modules.kotlin.defaultmodules;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.tracing.Trace;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactDelegate;
import expo.modules.BuildConfig;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.KModuleEventEmitterWrapperKt;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionBuilderKt;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.uuidv5.InvalidNamespaceException;
import expo.modules.kotlin.uuidv5.Uuidv5Kt;
import expo.modules.kotlin.views.CallbacksDefinition;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CoreModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/CoreModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoreModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.AppContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.AppContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        CoreModule coreModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (coreModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(coreModule);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder("expoModulesCoreVersion");
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Map.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Map.class));
                returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Map.class), returnType);
            }
            propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    List listSplit$default = StringsKt.split$default((CharSequence) CollectionsKt.first(StringsKt.split$default((CharSequence) BuildConfig.EXPO_MODULES_CORE_VERSION, new String[]{"-"}, false, 0, 6, (Object) null)), new String[]{"."}, false, 0, 6, (Object) null);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                    Iterator it2 = listSplit$default.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
                    }
                    ArrayList arrayList2 = arrayList;
                    return MapsKt.mapOf(TuplesKt.to("version", BuildConfig.EXPO_MODULES_CORE_VERSION), TuplesKt.to("major", Integer.valueOf(((Number) arrayList2.get(0)).intValue())), TuplesKt.to("minor", Integer.valueOf(((Number) arrayList2.get(1)).intValue())), TuplesKt.to("patch", Integer.valueOf(((Number) arrayList2.get(2)).intValue())));
                }
            }));
            moduleDefinitionBuilder2.getProperties().put("expoModulesCoreVersion", propertyComponentBuilder);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder2 = new PropertyComponentBuilder("cacheDir");
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType2 = returnTypeProvider2.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider2.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType2);
            }
            propertyComponentBuilder2.setGetter(new SyncFunctionComponent("get", anyTypeArr2, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Uri.fromFile(this.this$0.getContext().getCacheDir()) + "/";
                }
            }));
            moduleDefinitionBuilder3.getProperties().put("cacheDir", propertyComponentBuilder2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder3 = new PropertyComponentBuilder("documentsDir");
            AnyType[] anyTypeArr3 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider3.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType3 == null) {
                returnType3 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider3.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType3);
            }
            propertyComponentBuilder3.setGetter(new SyncFunctionComponent("get", anyTypeArr3, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Uri.fromFile(this.this$0.getContext().getFilesDir()) + "/";
                }
            }));
            moduleDefinitionBuilder4.getProperties().put("documentsDir", propertyComponentBuilder3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType4 = returnTypeProvider4.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType4 == null) {
                returnType4 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                returnTypeProvider4.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType4);
            }
            moduleDefinitionBuilder5.getSyncFunctions().put("uuidv4", new SyncFunctionComponent("uuidv4", anyTypeArr4, returnType4, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return UUID.randomUUID().toString();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder6.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr5[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Function$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr5[1] = anyType2;
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider5.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType5 == null) {
                returnType5 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider5.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType5);
            }
            moduleDefinitionBuilder6.getSyncFunctions().put("uuidv5", new SyncFunctionComponent("uuidv5", anyTypeArr5, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidNamespaceException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    String str2 = (String) obj;
                    try {
                        UUID uuidFromString = UUID.fromString(str);
                        Intrinsics.checkNotNull(uuidFromString);
                        return Uuidv5Kt.uuidv5(uuidFromString, str2).toString();
                    } catch (IllegalArgumentException unused) {
                        throw new InvalidNamespaceException(str);
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            TypeConverterProvider converters2 = moduleDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Function$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters2);
            }
            anyTypeArr6[0] = anyType3;
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Function$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }), converters2);
            }
            anyTypeArr6[1] = anyType4;
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType6 = returnTypeProvider6.getTypes().get(Reflection.getOrCreateKotlinClass(Map.class));
            if (returnType6 == null) {
                returnType6 = new ReturnType(Reflection.getOrCreateKotlinClass(Map.class));
                returnTypeProvider6.getTypes().put(Reflection.getOrCreateKotlinClass(Map.class), returnType6);
            }
            moduleDefinitionBuilder7.getSyncFunctions().put("getViewConfig", new SyncFunctionComponent("getViewConfig", anyTypeArr6, returnType6, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$Function$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    String[] names;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    ModuleHolder<?> moduleHolder = this.this$0.getRuntimeContext().getRegistry().getModuleHolder((String) obj);
                    LinkedHashMap linkedHashMap = null;
                    if (moduleHolder == null) {
                        return null;
                    }
                    Map<String, ViewManagerDefinition> viewManagerDefinitions = moduleHolder.getDefinition().getViewManagerDefinitions();
                    if (str == null) {
                        str = ModuleDefinitionBuilderKt.DEFAULT_MODULE_VIEW;
                    }
                    ViewManagerDefinition viewManagerDefinition = viewManagerDefinitions.get(str);
                    if (viewManagerDefinition == null) {
                        return null;
                    }
                    Set<String> setKeySet = viewManagerDefinition.getProps$expo_modules_core_release().keySet();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setKeySet, 10)), 16));
                    for (Object obj2 : setKeySet) {
                        linkedHashMap2.put(obj2, true);
                    }
                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                    CallbacksDefinition callbacksDefinition = viewManagerDefinition.getCallbacksDefinition();
                    if (callbacksDefinition != null && (names = callbacksDefinition.getNames()) != null) {
                        linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(names.length), 16));
                        for (String str2 : names) {
                            Pair pair = TuplesKt.to(KModuleEventEmitterWrapperKt.normalizeEventName(str2), MapsKt.mapOf(TuplesKt.to("registrationName", str2)));
                            linkedHashMap.put(pair.getFirst(), pair.getSecond());
                        }
                    }
                    return MapsKt.mapOf(TuplesKt.to("validAttributes", linkedHashMap3), TuplesKt.to("directEventTypes", linkedHashMap));
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("reloadAppAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.MissingActivity {
                        ReactDelegate reactDelegate;
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Activity throwingActivity = this.this$0.getAppContext().getThrowingActivity();
                        ReactActivity reactActivity = throwingActivity instanceof ReactActivity ? (ReactActivity) throwingActivity : null;
                        if (reactActivity == null || (reactDelegate = reactActivity.getReactDelegate()) == null) {
                            return;
                        }
                        reactDelegate.reload();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.MissingActivity {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters3 = moduleDefinitionBuilder8.getConverters();
                AnyType[] anyTypeArr7 = new AnyType[1];
                AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType5 == null) {
                    anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters3);
                }
                anyTypeArr7[0] = anyType5;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$10$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exceptions.MissingActivity {
                        ReactDelegate reactDelegate;
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Activity throwingActivity = this.this$0.getAppContext().getThrowingActivity();
                        ReactActivity reactActivity = throwingActivity instanceof ReactActivity ? (ReactActivity) throwingActivity : null;
                        if (reactActivity != null && (reactDelegate = reactActivity.getReactDelegate()) != null) {
                            reactDelegate.reload();
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("reloadAppAsync", anyTypeArr7, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("reloadAppAsync", anyTypeArr7, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("reloadAppAsync", anyTypeArr7, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("reloadAppAsync", anyTypeArr7, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("reloadAppAsync", anyTypeArr7, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("reloadAppAsync", anyTypeArr7, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("reloadAppAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
