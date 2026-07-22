package expo.modules.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.tracing.Trace;
import com.facebook.react.common.assets.ReactFontManager;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FontLoaderModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lexpo/modules/font/FontLoaderModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "queryCustomNativeFonts", "", "", "expo-font_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FontLoaderModule extends Module {
    private final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.List] */
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        FontLoaderModule fontLoaderModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fontLoaderModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fontLoaderModule);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = queryCustomNativeFonts();
            moduleDefinitionBuilder.Name("ExpoFontLoader");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("getLoadedFonts", new SyncFunctionComponent("getLoadedFonts", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$4$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return objectRef.element;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$4$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr2[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$4$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr2[1] = anyType2;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.font.FontLoaderModule$definition$lambda$4$$inlined$AsyncFunction$3
                /* JADX WARN: Type inference failed for: r0v11, types: [T, java.util.List] */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws CodedException {
                    Typeface typefaceCreateFromFile;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    String str2 = (String) obj;
                    Context reactContext = this.this$0.getAppContext().getReactContext();
                    if (reactContext == null) {
                        throw new Exceptions.ReactContextLost();
                    }
                    if (StringsKt.startsWith$default(str, "asset://", false, 2, (Object) null)) {
                        AssetManager assets = reactContext.getAssets();
                        String strSubstring = str.substring(9);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        typefaceCreateFromFile = Typeface.createFromAsset(assets, strSubstring);
                        Intrinsics.checkNotNull(typefaceCreateFromFile);
                    } else {
                        String path = Uri.parse(str).getPath();
                        if (path == null) {
                            throw new FileNotFoundException(str);
                        }
                        File file = new File(path);
                        if (file.length() == 0) {
                            throw new CodedException("Font file for " + str2 + " is empty. Make sure the local file path is correctly populated.", null, 2, null);
                        }
                        typefaceCreateFromFile = Typeface.createFromFile(file);
                        Intrinsics.checkNotNull(typefaceCreateFromFile);
                    }
                    ReactFontManager.INSTANCE.getInstance().setTypeface(str2, 0, typefaceCreateFromFile);
                    Ref.ObjectRef objectRef2 = objectRef;
                    Set mutableSet = CollectionsKt.toMutableSet((Iterable) objectRef2.element);
                    mutableSet.add(str2);
                    objectRef2.element = CollectionsKt.toList(mutableSet);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("loadAsync", anyTypeArr2, function1);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("loadAsync", untypedAsyncFunctionComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> queryCustomNativeFonts() throws IOException {
        List<String> groupValues;
        AssetManager assets = getContext().getAssets();
        Regex regex = new Regex("^(.+?)(_bold|_italic|_bold_italic)?\\.(ttf|otf)$");
        String[] list = assets.list("fonts/");
        ArrayList arrayList = null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (String str : list) {
                Intrinsics.checkNotNull(str);
                MatchResult matchResultFind$default = Regex.find$default(regex, str, 0, 2, null);
                String str2 = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : groupValues.get(1);
                if (str2 != null) {
                    arrayList2.add(str2);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList3.add(obj);
                }
            }
            arrayList = arrayList3;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
