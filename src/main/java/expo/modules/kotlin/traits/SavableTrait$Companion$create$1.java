package expo.modules.kotlin.traits;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: SavableTrait.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
public final class SavableTrait$Companion$create$1 implements Function1<AppContext, ObjectDefinitionData> {
    public static final SavableTrait$Companion$create$1 INSTANCE = new SavableTrait$Companion$create$1();

    @Override // kotlin.jvm.functions.Function1
    public final ObjectDefinitionData invoke(AppContext appContext) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        SavableTrait.Companion companion = SavableTrait.INSTANCE;
        final WeakReference weakReferenceWeak = UtilsKt.weak(appContext);
        ObjectDefinitionBuilder objectDefinitionBuilder = new ObjectDefinitionBuilder(null, 1, null);
        TypeConverterProvider converters = objectDefinitionBuilder.getConverters();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            SavableTrait$Companion$create$1$invoke$$inlined$createImplementation$1 savableTrait$Companion$create$1$invoke$$inlined$createImplementation$1 = new Function0<KType>() { // from class: expo.modules.kotlin.traits.SavableTrait$Companion$create$1$invoke$$inlined$createImplementation$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, savableTrait$Companion$create$1$invoke$$inlined$createImplementation$1), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SavableTrait.Companion.SavableBitmapOptions.class), false));
        if (anyType2 == null) {
            anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SavableTrait.Companion.SavableBitmapOptions.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.traits.SavableTrait$Companion$create$1$invoke$$inlined$createImplementation$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SavableTrait.Companion.SavableBitmapOptions.class);
                }
            }), converters);
        }
        anyTypeArr[1] = anyType2;
        Intrinsics.needClassReification();
        Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.traits.SavableTrait$Companion$create$1$invoke$$inlined$createImplementation$3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object[] objArr) throws IOException, Exceptions.AppContextLost {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Object obj = objArr[0];
                Object obj2 = objArr[1];
                AppContext appContext2 = (AppContext) weakReferenceWeak.get();
                if (appContext2 == null) {
                    throw new Exceptions.AppContextLost();
                }
                File file = new File(appContext2.getCacheDirectory(), UUID.randomUUID().toString());
                file.createNewFile();
                SharedRef sharedRef = (SharedRef) obj;
                sharedRef.getAppContext();
                ((Bitmap) sharedRef.getRef()).compress(Bitmap.CompressFormat.PNG, ((SavableTrait.Companion.SavableBitmapOptions) obj2).getCompression(), new FileOutputStream(file));
                return Unit.INSTANCE;
            }
        };
        if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
            if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                        if (Intrinsics.areEqual(Unit.class, String.class)) {
                            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                        } else {
                            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
            }
        } else {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("saveAsync", anyTypeArr, function1);
        }
        objectDefinitionBuilder.getAsyncFunctions().put("saveAsync", untypedAsyncFunctionComponent);
        return objectDefinitionBuilder.buildObject();
    }
}
