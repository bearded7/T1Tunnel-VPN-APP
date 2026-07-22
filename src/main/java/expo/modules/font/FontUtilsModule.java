package expo.modules.font;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.tracing.Trace;
import com.facebook.react.common.assets.ReactFontManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: FontUtilsModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lexpo/modules/font/FontUtilsModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-font_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FontUtilsModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        FontUtilsModule fontUtilsModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (fontUtilsModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(fontUtilsModule);
            moduleDefinitionBuilder.Name("ExpoFontUtils");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.font.FontUtilsModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RenderToImageOptions.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(RenderToImageOptions.class), false, new Function0<KType>() { // from class: expo.modules.font.FontUtilsModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(RenderToImageOptions.class);
                    }
                }), converters);
            }
            anyTypeArr[1] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("renderToImageAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.font.FontUtilsModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    RenderToImageOptions renderToImageOptions = (RenderToImageOptions) objArr[1];
                    String str = (String) obj;
                    Typeface typeface = ReactFontManager.INSTANCE.getInstance().getTypeface(renderToImageOptions.getFontFamily(), 0, this.this$0.getContext().getAssets());
                    float f = this.this$0.getContext().getResources().getDisplayMetrics().density;
                    float size = renderToImageOptions.getSize() * f;
                    Paint paint = new Paint();
                    paint.setTypeface(typeface);
                    paint.setColor(renderToImageOptions.getColor());
                    paint.setTextSize(size);
                    paint.setAntiAlias(true);
                    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) Math.ceil(paint.measureText(str)), (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent), Bitmap.Config.ARGB_8888);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                    new Canvas(bitmapCreateBitmap).drawText(str, 0.0f, -fontMetrics.ascent, paint);
                    File file = new File(this.this$0.getContext().getCacheDir(), UUID.randomUUID() + ".png");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            CloseableKt.closeFinally(fileOutputStream, null);
                            promise.resolve(MapsKt.mapOf(TuplesKt.to("uri", Uri.fromFile(file).toString()), TuplesKt.to("width", Float.valueOf(bitmapCreateBitmap.getWidth() / f)), TuplesKt.to("height", Float.valueOf(bitmapCreateBitmap.getHeight() / f)), TuplesKt.to("scale", Float.valueOf(f))));
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(fileOutputStream, th);
                                throw th2;
                            }
                        }
                    } catch (IOException e) {
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        promise.reject(new SaveImageException(absolutePath, e));
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("renderToImageAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
