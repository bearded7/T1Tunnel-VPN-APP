package expo.modules.filesystem;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import androidx.tracing.Trace;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponentBuilder;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.objects.PropertyComponentBuilder;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.io.File;
import java.net.URI;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: FileSystemModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0017R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/filesystem/FileSystemModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "filesDirectory", "Ljava/io/File;", "getFilesDirectory", "()Ljava/io/File;", "cacheDirectory", "getCacheDirectory", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSystemModule extends Module {
    private final Context getContext() throws Exceptions.AppContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.AppContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFilesDirectory() {
        return getAppContext().getPersistentFilesDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        FileSystemModule fileSystemModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fileSystemModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fileSystemModule);
            moduleDefinitionBuilder.Name("FileSystem");
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("documentDirectory");
            constantComponentBuilder.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Uri.fromFile(this.this$0.getFilesDirectory()) + "/";
                }
            });
            moduleDefinitionBuilder.getConstants().put("documentDirectory", constantComponentBuilder);
            ConstantComponentBuilder constantComponentBuilder2 = new ConstantComponentBuilder("cacheDirectory");
            constantComponentBuilder2.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Constant$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return Uri.fromFile(this.this$0.getCacheDirectory()) + "/";
                }
            });
            moduleDefinitionBuilder.getConstants().put("cacheDirectory", constantComponentBuilder2);
            ConstantComponentBuilder constantComponentBuilder3 = new ConstantComponentBuilder("bundleDirectory");
            constantComponentBuilder3.setGetter(new Function0<String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Constant$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "asset://";
                }
            });
            moduleDefinitionBuilder.getConstants().put("bundleDirectory", constantComponentBuilder3);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder("totalDiskSpace");
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType);
            }
            propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(this.this$0.getFilesDirectory().getTotalSpace());
                }
            }));
            moduleDefinitionBuilder2.getProperties().put("totalDiskSpace", propertyComponentBuilder);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder2 = new PropertyComponentBuilder("availableDiskSpace");
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType2 = returnTypeProvider2.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                returnTypeProvider2.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType2);
            }
            propertyComponentBuilder2.setGetter(new SyncFunctionComponent("get", anyTypeArr2, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(this.this$0.getFilesDirectory().getFreeSpace());
                }
            }));
            moduleDefinitionBuilder3.getProperties().put("availableDiskSpace", propertyComponentBuilder2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("downloadFileAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[3];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(URI.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(URI.class);
                    }
                }), converters);
            }
            anyTypeArr3[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }), converters);
            }
            anyTypeArr3[1] = anyType2;
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DownloadOptions.class), true));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DownloadOptions.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(DownloadOptions.class);
                    }
                }), converters);
            }
            anyTypeArr3[2] = anyType3;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr3, new FileSystemModule$definition$lambda$62$$inlined$Coroutine$4(null)));
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            moduleDefinitionBuilder.RegisterActivityContracts(new FileSystemModule$definition$1$7(objectRef, this, null));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("pickDirectoryAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters2 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), true));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Uri.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Uri.class);
                    }
                }), converters2);
            }
            anyTypeArr4[0] = anyType4;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr4, new FileSystemModule$definition$lambda$62$$inlined$Coroutine$6(null, objectRef)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("pickFileAsync");
            String name3 = asyncFunctionBuilderAsyncFunction3.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction3.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), true));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Uri.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Uri.class);
                    }
                }), converters3);
            }
            anyTypeArr5[0] = anyType5;
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Coroutine$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }), converters3);
            }
            anyTypeArr5[1] = anyType6;
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(name3, anyTypeArr5, new FileSystemModule$definition$lambda$62$$inlined$Coroutine$9(null, objectRef)));
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[1];
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URI.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(URI.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(URI.class);
                    }
                }), converters4);
            }
            anyTypeArr6[0] = anyType7;
            ReturnTypeProvider returnTypeProvider3 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType3 = returnTypeProvider3.getTypes().get(Reflection.getOrCreateKotlinClass(PathInfo.class));
            if (returnType3 == null) {
                returnType3 = new ReturnType(Reflection.getOrCreateKotlinClass(PathInfo.class));
                returnTypeProvider3.getTypes().put(Reflection.getOrCreateKotlinClass(PathInfo.class), returnType3);
            }
            moduleDefinitionBuilder4.getSyncFunctions().put("info", new SyncFunctionComponent("info", anyTypeArr6, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    EnumSet<Permission> enumSetNoneOf;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    File file = new File((URI) objArr[0]);
                    FilePermissionModuleInterface filePermission = this.this$0.getAppContext().getFilePermission();
                    if (filePermission == null || (enumSetNoneOf = filePermission.getPathPermissions(this.this$0.getAppContext().getReactContext(), file.getPath())) == null) {
                        enumSetNoneOf = EnumSet.noneOf(Permission.class);
                    }
                    if (enumSetNoneOf.contains(Permission.READ) && file.exists()) {
                        return new PathInfo(file.exists(), Boolean.valueOf(file.isDirectory()));
                    }
                    return new PathInfo(false, null);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FileSystemFile.class);
            Module module = moduleDefinitionBuilder5.getModule();
            if (module == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            AppContext appContext = module.getAppContext();
            String simpleName = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(appContext, simpleName, orCreateKotlinClass, anyType8 == null ? new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Class$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FileSystemFile.class);
                }
            }), null) : anyType8, moduleDefinitionBuilder5.getConverters());
            TypeConverterProvider converters5 = classComponentBuilder.getConverters();
            AnyType[] anyTypeArr7 = new AnyType[1];
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Uri.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Uri.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Constructor$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Uri.class);
                    }
                }), converters5);
            }
            anyTypeArr7[0] = anyType9;
            ReturnTypeProvider returnTypeProvider4 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType4 = returnTypeProvider4.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType4 == null) {
                returnType4 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                returnTypeProvider4.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType4);
            }
            classComponentBuilder.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr7, returnType4, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return new FileSystemFile((Uri) objArr[0]);
                }
            }));
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            TypeConverterProvider converters6 = classComponentBuilder2.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[1];
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters6);
            }
            anyTypeArr8[0] = anyType10;
            ReturnTypeProvider returnTypeProvider5 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType5 = returnTypeProvider5.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType5 == null) {
                returnType5 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider5.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType5);
            }
            classComponentBuilder2.getSyncFunctions().put("delete", new SyncFunctionComponent("delete", anyTypeArr8, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).delete();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder3 = classComponentBuilder;
            TypeConverterProvider converters7 = classComponentBuilder3.getConverters();
            AnyType[] anyTypeArr9 = new AnyType[1];
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters7);
            }
            anyTypeArr9[0] = anyType11;
            ReturnTypeProvider returnTypeProvider6 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType6 = returnTypeProvider6.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType6 == null) {
                returnType6 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider6.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType6);
            }
            classComponentBuilder3.getSyncFunctions().put("validatePath", new SyncFunctionComponent("validatePath", anyTypeArr9, returnType6, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).validatePath();
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder4 = classComponentBuilder;
            TypeConverterProvider converters8 = classComponentBuilder4.getConverters();
            AnyType[] anyTypeArr10 = new AnyType[2];
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters8);
            }
            anyTypeArr10[0] = anyType12;
            AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CreateOptions.class), true));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(CreateOptions.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(CreateOptions.class);
                    }
                }), converters8);
            }
            anyTypeArr10[1] = anyType13;
            ReturnTypeProvider returnTypeProvider7 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType7 = returnTypeProvider7.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType7 == null) {
                returnType7 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider7.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType7);
            }
            classComponentBuilder4.getSyncFunctions().put("create", new SyncFunctionComponent("create", anyTypeArr10, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFileException, UnableToCreateException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    CreateOptions createOptions = (CreateOptions) objArr[1];
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    if (createOptions == null) {
                        createOptions = new CreateOptions(false, false, false, 7, null);
                    }
                    fileSystemFile.create(createOptions);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder;
            TypeConverterProvider converters9 = classComponentBuilder5.getConverters();
            AnyType[] anyTypeArr11 = new AnyType[3];
            AnyType anyType14 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType14 == null) {
                anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters9);
            }
            anyTypeArr11[0] = anyType14;
            AnyType anyType15 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Either.class), false));
            if (anyType15 == null) {
                anyType15 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Either.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Either.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(TypedArray.class)));
                    }
                }), converters9);
            }
            anyTypeArr11[1] = anyType15;
            AnyType anyType16 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(WriteOptions.class), true));
            if (anyType16 == null) {
                anyType16 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(WriteOptions.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(WriteOptions.class);
                    }
                }), converters9);
            }
            anyTypeArr11[2] = anyType16;
            ReturnTypeProvider returnTypeProvider8 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType8 = returnTypeProvider8.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType8 == null) {
                returnType8 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider8.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType8);
            }
            classComponentBuilder5.getSyncFunctions().put("write", new SyncFunctionComponent("write", anyTypeArr11, returnType8, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidTypeFileException, UnableToCreateException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    WriteOptions writeOptions = (WriteOptions) objArr[2];
                    Either either = (Either) obj2;
                    FileSystemFile fileSystemFile = (FileSystemFile) obj;
                    if (either.isFirstType(Reflection.getOrCreateKotlinClass(String.class))) {
                        String str = (String) either.getFirstType(Reflection.getOrCreateKotlinClass(String.class));
                        if ((writeOptions != null ? writeOptions.getEncoding() : null) == EncodingType.BASE64) {
                            byte[] bArrDecode = Base64.decode(str, 0);
                            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                            fileSystemFile.write(bArrDecode);
                        } else {
                            fileSystemFile.write(str);
                        }
                    }
                    if (either.isSecondType(Reflection.getOrCreateKotlinClass(TypedArray.class))) {
                        fileSystemFile.write((TypedArray) either.getSecondType(Reflection.getOrCreateKotlinClass(TypedArray.class)));
                    }
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder6 = classComponentBuilder;
            if (Intrinsics.areEqual(FileSystemFile.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(ReactTextInputShadowNode.PROP_TEXT, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws InvalidTypeFileException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((FileSystemFile) promise).text();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws InvalidTypeFileException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters10 = classComponentBuilder6.getConverters();
                AnyType[] anyTypeArr12 = new AnyType[1];
                AnyType anyType17 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
                if (anyType17 == null) {
                    anyType17 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }), converters10);
                }
                anyTypeArr12[0] = anyType17;
                Function1<Object[], String> function1 = new Function1<Object[], String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return ((FileSystemFile) objArr[0]).text();
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(ReactTextInputShadowNode.PROP_TEXT, anyTypeArr12, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(ReactTextInputShadowNode.PROP_TEXT, anyTypeArr12, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(ReactTextInputShadowNode.PROP_TEXT, anyTypeArr12, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(ReactTextInputShadowNode.PROP_TEXT, anyTypeArr12, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(ReactTextInputShadowNode.PROP_TEXT, anyTypeArr12, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(ReactTextInputShadowNode.PROP_TEXT, anyTypeArr12, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            classComponentBuilder6.getAsyncFunctions().put(ReactTextInputShadowNode.PROP_TEXT, asyncFunctionWithPromiseComponent);
            ClassComponentBuilder classComponentBuilder7 = classComponentBuilder;
            TypeConverterProvider converters11 = classComponentBuilder7.getConverters();
            AnyType[] anyTypeArr13 = new AnyType[1];
            AnyType anyType18 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType18 == null) {
                anyType18 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters11);
            }
            anyTypeArr13[0] = anyType18;
            ReturnTypeProvider returnTypeProvider9 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType9 = returnTypeProvider9.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType9 == null) {
                returnType9 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider9.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType9);
            }
            classComponentBuilder7.getSyncFunctions().put("textSync", new SyncFunctionComponent("textSync", anyTypeArr13, returnType9, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).text();
                }
            }));
            ClassComponentBuilder classComponentBuilder8 = classComponentBuilder;
            if (Intrinsics.areEqual(FileSystemFile.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("base64", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws InvalidTypeFileException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((FileSystemFile) promise).base64();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws InvalidTypeFileException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters12 = classComponentBuilder8.getConverters();
                AnyType[] anyTypeArr14 = new AnyType[1];
                AnyType anyType19 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
                if (anyType19 == null) {
                    anyType19 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }), converters12);
                }
                anyTypeArr14[0] = anyType19;
                Function1<Object[], String> function2 = new Function1<Object[], String>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return ((FileSystemFile) objArr[0]).base64();
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("base64", anyTypeArr14, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("base64", anyTypeArr14, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("base64", anyTypeArr14, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("base64", anyTypeArr14, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("base64", anyTypeArr14, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("base64", anyTypeArr14, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            classComponentBuilder8.getAsyncFunctions().put("base64", asyncFunctionWithPromiseComponent2);
            ClassComponentBuilder classComponentBuilder9 = classComponentBuilder;
            TypeConverterProvider converters13 = classComponentBuilder9.getConverters();
            AnyType[] anyTypeArr15 = new AnyType[1];
            AnyType anyType20 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType20 == null) {
                anyType20 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$14
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters13);
            }
            anyTypeArr15[0] = anyType20;
            ReturnTypeProvider returnTypeProvider10 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType10 = returnTypeProvider10.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType10 == null) {
                returnType10 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider10.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType10);
            }
            classComponentBuilder9.getSyncFunctions().put("base64Sync", new SyncFunctionComponent("base64Sync", anyTypeArr15, returnType10, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).base64();
                }
            }));
            ClassComponentBuilder classComponentBuilder10 = classComponentBuilder;
            if (Intrinsics.areEqual(FileSystemFile.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("bytes", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws InvalidTypeFileException {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((FileSystemFile) promise).bytes();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws InvalidTypeFileException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
                classComponentBuilder10 = classComponentBuilder10;
            } else {
                TypeConverterProvider converters14 = classComponentBuilder10.getConverters();
                AnyType[] anyTypeArr16 = new AnyType[1];
                AnyType anyType21 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
                if (anyType21 == null) {
                    anyType21 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(FileSystemFile.class);
                        }
                    }), converters14);
                }
                anyTypeArr16[0] = anyType21;
                Function1<Object[], byte[]> function3 = new Function1<Object[], byte[]>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final byte[] invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return ((FileSystemFile) objArr[0]).bytes();
                    }
                };
                if (Intrinsics.areEqual(byte[].class, Integer.TYPE)) {
                    untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("bytes", anyTypeArr16, function3);
                } else if (Intrinsics.areEqual(byte[].class, Boolean.TYPE)) {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("bytes", anyTypeArr16, function3);
                } else if (Intrinsics.areEqual(byte[].class, Double.TYPE)) {
                    untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("bytes", anyTypeArr16, function3);
                } else if (Intrinsics.areEqual(byte[].class, Float.TYPE)) {
                    untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("bytes", anyTypeArr16, function3);
                } else if (Intrinsics.areEqual(byte[].class, String.class)) {
                    untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("bytes", anyTypeArr16, function3);
                } else {
                    untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("bytes", anyTypeArr16, function3);
                }
                asyncFunctionWithPromiseComponent3 = untypedAsyncFunctionComponent3;
            }
            classComponentBuilder10.getAsyncFunctions().put("bytes", asyncFunctionWithPromiseComponent3);
            ClassComponentBuilder classComponentBuilder11 = classComponentBuilder;
            TypeConverterProvider converters15 = classComponentBuilder11.getConverters();
            AnyType[] anyTypeArr17 = new AnyType[1];
            AnyType anyType22 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType22 == null) {
                anyType22 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$16
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters15);
            }
            anyTypeArr17[0] = anyType22;
            ReturnTypeProvider returnTypeProvider11 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType11 = returnTypeProvider11.getTypes().get(Reflection.getOrCreateKotlinClass(byte[].class));
            if (returnType11 == null) {
                returnType11 = new ReturnType(Reflection.getOrCreateKotlinClass(byte[].class));
                returnTypeProvider11.getTypes().put(Reflection.getOrCreateKotlinClass(byte[].class), returnType11);
            }
            classComponentBuilder11.getSyncFunctions().put("bytesSync", new SyncFunctionComponent("bytesSync", anyTypeArr17, returnType11, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).bytes();
                }
            }));
            ClassComponentBuilder classComponentBuilder12 = classComponentBuilder;
            TypeConverterProvider converters16 = classComponentBuilder12.getConverters();
            AnyType[] anyTypeArr18 = new AnyType[2];
            AnyType anyType23 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType23 == null) {
                anyType23 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$18
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters16);
            }
            anyTypeArr18[0] = anyType23;
            AnyType anyType24 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(InfoOptions.class), true));
            if (anyType24 == null) {
                anyType24 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(InfoOptions.class), true, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$19
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(InfoOptions.class);
                    }
                }), converters16);
            }
            anyTypeArr18[1] = anyType24;
            ReturnTypeProvider returnTypeProvider12 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType12 = returnTypeProvider12.getTypes().get(Reflection.getOrCreateKotlinClass(FileInfo.class));
            if (returnType12 == null) {
                returnType12 = new ReturnType(Reflection.getOrCreateKotlinClass(FileInfo.class));
                returnTypeProvider12.getTypes().put(Reflection.getOrCreateKotlinClass(FileInfo.class), returnType12);
            }
            classComponentBuilder12.getSyncFunctions().put("info", new SyncFunctionComponent("info", anyTypeArr18, returnType12, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFile) objArr[0]).info((InfoOptions) objArr[1]);
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "exists");
            AnyType[] anyTypeArr19 = {new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider13 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType13 = returnTypeProvider13.getTypes().get(Reflection.getOrCreateKotlinClass(Boolean.class));
            if (returnType13 == null) {
                returnType13 = new ReturnType(Reflection.getOrCreateKotlinClass(Boolean.class));
                returnTypeProvider13.getTypes().put(Reflection.getOrCreateKotlinClass(Boolean.class), returnType13);
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr19, returnType13, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(((FileSystemFile) it[0]).getExists());
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder.getProperties().put("exists", propertyComponentBuilderWithThis);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "modificationTime");
            AnyType[] anyTypeArr20 = {new AnyType(propertyComponentBuilderWithThis2.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider14 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType14 = returnTypeProvider14.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType14 == null) {
                returnType14 = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                returnTypeProvider14.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType14);
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr20, returnType14, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getModificationTime();
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder.getProperties().put("modificationTime", propertyComponentBuilderWithThis2);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis3 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "creationTime");
            AnyType[] anyTypeArr21 = {new AnyType(propertyComponentBuilderWithThis3.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider15 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType15 = returnTypeProvider15.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType15 == null) {
                returnType15 = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                returnTypeProvider15.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType15);
            }
            SyncFunctionComponent syncFunctionComponent3 = new SyncFunctionComponent("get", anyTypeArr21, returnType15, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getCreationTime();
                }
            });
            syncFunctionComponent3.setOwnerType(propertyComponentBuilderWithThis3.getThisType());
            syncFunctionComponent3.setCanTakeOwner(true);
            propertyComponentBuilderWithThis3.setGetter(syncFunctionComponent3);
            classComponentBuilder.getProperties().put("creationTime", propertyComponentBuilderWithThis3);
            ClassComponentBuilder classComponentBuilder13 = classComponentBuilder;
            TypeConverterProvider converters17 = classComponentBuilder13.getConverters();
            AnyType[] anyTypeArr22 = new AnyType[2];
            AnyType anyType25 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType25 == null) {
                anyType25 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$21
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters17);
            }
            anyTypeArr22[0] = anyType25;
            AnyType anyType26 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType26 == null) {
                anyType26 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$22
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }), converters17);
            }
            anyTypeArr22[1] = anyType26;
            ReturnTypeProvider returnTypeProvider16 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType16 = returnTypeProvider16.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType16 == null) {
                returnType16 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider16.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType16);
            }
            classComponentBuilder13.getSyncFunctions().put("copy", new SyncFunctionComponent("copy", anyTypeArr22, returnType16, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).copy((FileSystemPath) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder14 = classComponentBuilder;
            TypeConverterProvider converters18 = classComponentBuilder14.getConverters();
            AnyType[] anyTypeArr23 = new AnyType[2];
            AnyType anyType27 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType27 == null) {
                anyType27 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$24
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters18);
            }
            anyTypeArr23[0] = anyType27;
            AnyType anyType28 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false));
            if (anyType28 == null) {
                anyType28 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemPath.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$25
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemPath.class);
                    }
                }), converters18);
            }
            anyTypeArr23[1] = anyType28;
            ReturnTypeProvider returnTypeProvider17 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType17 = returnTypeProvider17.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType17 == null) {
                returnType17 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider17.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType17);
            }
            classComponentBuilder14.getSyncFunctions().put("move", new SyncFunctionComponent("move", anyTypeArr23, returnType17, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$26
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).move((FileSystemPath) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            ClassComponentBuilder classComponentBuilder15 = classComponentBuilder;
            TypeConverterProvider converters19 = classComponentBuilder15.getConverters();
            AnyType[] anyTypeArr24 = new AnyType[2];
            AnyType anyType29 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType29 == null) {
                anyType29 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$27
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters19);
            }
            anyTypeArr24[0] = anyType29;
            AnyType anyType30 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType30 == null) {
                anyType30 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$28
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters19);
            }
            anyTypeArr24[1] = anyType30;
            ReturnTypeProvider returnTypeProvider18 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType18 = returnTypeProvider18.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType18 == null) {
                returnType18 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider18.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType18);
            }
            classComponentBuilder15.getSyncFunctions().put("rename", new SyncFunctionComponent("rename", anyTypeArr24, returnType18, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$29
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((FileSystemFile) objArr[0]).rename((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            }));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis4 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "uri");
            AnyType[] anyTypeArr25 = {new AnyType(propertyComponentBuilderWithThis4.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider19 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType19 = returnTypeProvider19.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType19 == null) {
                returnType19 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider19.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType19);
            }
            SyncFunctionComponent syncFunctionComponent4 = new SyncFunctionComponent("get", anyTypeArr25, returnType19, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).asString();
                }
            });
            syncFunctionComponent4.setOwnerType(propertyComponentBuilderWithThis4.getThisType());
            syncFunctionComponent4.setCanTakeOwner(true);
            propertyComponentBuilderWithThis4.setGetter(syncFunctionComponent4);
            classComponentBuilder.getProperties().put("uri", propertyComponentBuilderWithThis4);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis5 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "contentUri");
            AnyType[] anyTypeArr26 = {new AnyType(propertyComponentBuilderWithThis5.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider20 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType20 = returnTypeProvider20.getTypes().get(Reflection.getOrCreateKotlinClass(Uri.class));
            if (returnType20 == null) {
                returnType20 = new ReturnType(Reflection.getOrCreateKotlinClass(Uri.class));
                returnTypeProvider20.getTypes().put(Reflection.getOrCreateKotlinClass(Uri.class), returnType20);
            }
            SyncFunctionComponent syncFunctionComponent5 = new SyncFunctionComponent("get", anyTypeArr26, returnType20, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).asContentUri();
                }
            });
            syncFunctionComponent5.setOwnerType(propertyComponentBuilderWithThis5.getThisType());
            syncFunctionComponent5.setCanTakeOwner(true);
            propertyComponentBuilderWithThis5.setGetter(syncFunctionComponent5);
            classComponentBuilder.getProperties().put("contentUri", propertyComponentBuilderWithThis5);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis6 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "md5");
            AnyType[] anyTypeArr27 = {new AnyType(propertyComponentBuilderWithThis6.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider21 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType21 = returnTypeProvider21.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType21 == null) {
                returnType21 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider21.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType21);
            }
            SyncFunctionComponent syncFunctionComponent6 = new SyncFunctionComponent("get", anyTypeArr27, returnType21, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        return ((FileSystemFile) it[0]).getMd5();
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            syncFunctionComponent6.setOwnerType(propertyComponentBuilderWithThis6.getThisType());
            syncFunctionComponent6.setCanTakeOwner(true);
            propertyComponentBuilderWithThis6.setGetter(syncFunctionComponent6);
            classComponentBuilder.getProperties().put("md5", propertyComponentBuilderWithThis6);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis7 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "size");
            AnyType[] anyTypeArr28 = {new AnyType(propertyComponentBuilderWithThis7.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider22 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType22 = returnTypeProvider22.getTypes().get(Reflection.getOrCreateKotlinClass(Long.class));
            if (returnType22 == null) {
                returnType22 = new ReturnType(Reflection.getOrCreateKotlinClass(Long.class));
                returnTypeProvider22.getTypes().put(Reflection.getOrCreateKotlinClass(Long.class), returnType22);
            }
            SyncFunctionComponent syncFunctionComponent7 = new SyncFunctionComponent("get", anyTypeArr28, returnType22, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        return ((FileSystemFile) it[0]).getSize();
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            syncFunctionComponent7.setOwnerType(propertyComponentBuilderWithThis7.getThisType());
            syncFunctionComponent7.setCanTakeOwner(true);
            propertyComponentBuilderWithThis7.setGetter(syncFunctionComponent7);
            classComponentBuilder.getProperties().put("size", propertyComponentBuilderWithThis7);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis8 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), SVGParser.XML_STYLESHEET_ATTR_TYPE);
            AnyType[] anyTypeArr29 = {new AnyType(propertyComponentBuilderWithThis8.getThisType(), null, 2, null)};
            ReturnTypeProvider returnTypeProvider23 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType23 = returnTypeProvider23.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType23 == null) {
                returnType23 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                returnTypeProvider23.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType23);
            }
            SyncFunctionComponent syncFunctionComponent8 = new SyncFunctionComponent("get", anyTypeArr29, returnType23, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Property$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((FileSystemFile) it[0]).getType();
                }
            });
            syncFunctionComponent8.setOwnerType(propertyComponentBuilderWithThis8.getThisType());
            syncFunctionComponent8.setCanTakeOwner(true);
            propertyComponentBuilderWithThis8.setGetter(syncFunctionComponent8);
            classComponentBuilder.getProperties().put(SVGParser.XML_STYLESHEET_ATTR_TYPE, propertyComponentBuilderWithThis8);
            ClassComponentBuilder classComponentBuilder16 = classComponentBuilder;
            TypeConverterProvider converters20 = classComponentBuilder16.getConverters();
            AnyType[] anyTypeArr30 = new AnyType[1];
            AnyType anyType31 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType31 == null) {
                anyType31 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$30
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters20);
            }
            anyTypeArr30[0] = anyType31;
            ReturnTypeProvider returnTypeProvider24 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType24 = returnTypeProvider24.getTypes().get(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class));
            if (returnType24 == null) {
                returnType24 = new ReturnType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class));
                returnTypeProvider24.getTypes().put(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), returnType24);
            }
            classComponentBuilder16.getSyncFunctions().put("open", new SyncFunctionComponent("open", anyTypeArr30, returnType24, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$38$$inlined$Function$31
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return new FileSystemFileHandle((FileSystemFile) objArr[0]);
                }
            }));
            moduleDefinitionBuilder5.getClassData().add(classComponentBuilder.buildClass());
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class);
            Module module2 = moduleDefinitionBuilder6.getModule();
            if (module2 == null) {
                throw new IllegalArgumentException(r13.toString());
            }
            AppContext appContext2 = module2.getAppContext();
            String simpleName2 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass2).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            AnyType anyType32 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            ClassComponentBuilder classComponentBuilder17 = new ClassComponentBuilder(appContext2, simpleName2, orCreateKotlinClass2, anyType32 == null ? new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$$inlined$Class$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(FileSystemFileHandle.class);
                }
            }), null) : anyType32, moduleDefinitionBuilder6.getConverters());
            TypeConverterProvider converters21 = classComponentBuilder17.getConverters();
            AnyType[] anyTypeArr31 = new AnyType[1];
            AnyType anyType33 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false));
            if (anyType33 == null) {
                anyType33 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFile.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$46$$inlined$Constructor$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFile.class);
                    }
                }), converters21);
            }
            anyTypeArr31[0] = anyType33;
            ReturnTypeProvider returnTypeProvider25 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType25 = returnTypeProvider25.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType25 == null) {
                returnType25 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                returnTypeProvider25.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType25);
            }
            classComponentBuilder17.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr31, returnType25, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$46$$inlined$Constructor$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return new FileSystemFileHandle((FileSystemFile) objArr[0]);
                }
            }));
            ClassComponentBuilder classComponentBuilder18 = classComponentBuilder17;
            TypeConverterProvider converters22 = classComponentBuilder18.getConverters();
            AnyType[] anyTypeArr32 = new AnyType[2];
            AnyType anyType34 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false));
            if (anyType34 == null) {
                anyType34 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FileSystemFileHandle.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$46$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(FileSystemFileHandle.class);
                    }
                }), converters22);
            }
            anyTypeArr32[0] = anyType34;
            AnyType anyType35 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType35 == null) {
                anyType35 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$46$$inlined$Function$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), converters22);
            }
            anyTypeArr32[1] = anyType35;
            ReturnTypeProvider returnTypeProvider26 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType26 = returnTypeProvider26.getTypes().get(Reflection.getOrCreateKotlinClass(byte[].class));
            if (returnType26 == null) {
                returnType26 = new ReturnType(Reflection.getOrCreateKotlinClass(byte[].class));
                returnTypeProvider26.getTypes().put(Reflection.getOrCreateKotlinClass(byte[].class), returnType26);
            }
            classComponentBuilder18.getSyncFunctions().put("readBytes", new SyncFunctionComponent("readBytes", anyTypeArr32, returnType26, new Function1<Object[], Object>() { // from class: expo.modules.filesystem.FileSystemModule$definition$lambda$62$lambda$46$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return ((FileSystemFileHandle) objArr[0]).read(((Number) objArr[1]).intValue());
                }
            }));
            ObjectDefinitionBuilder objectDefinitionBuilder = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x14a5: MOVE (r32v4 'objectDefinitionBuilder' expo.modules.kotlin.objects.ObjectDefinitionBuilder) = (r1v89 expo.modules.kotlin.objects.ObjectDefinitionBuilder) A[Catch: all -> 0x20b7, DECLARE_VAR] (LINE:260) in method: expo.modules.filesystem.FileSystemModule.definition():expo.modules.kotlin.modules.ModuleDefinitionData, file: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v89 expo.modules.kotlin.objects.ObjectDefinitionBuilder
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                */
            /*
                Method dump skipped, instruction units count: 8380
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule.definition():expo.modules.kotlin.modules.ModuleDefinitionData");
        }
    }
