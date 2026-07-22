package expo.modules.blur;

import android.view.View;
import androidx.tracing.Trace;
import expo.modules.blur.enums.BlurMethod;
import expo.modules.blur.enums.TintStyle;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.views.AnyViewProp;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: BlurModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/blur/BlurModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-blur_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlurModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        BlurModule blurModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (blurModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(blurModule);
            moduleDefinitionBuilder.Name("ExpoBlurView");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(ExpoBlurView.class), new LazyKType(Reflection.getOrCreateKotlinClass(ExpoBlurView.class), false, new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$2$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ExpoBlurView.class);
                }
            }, 2, null), moduleDefinitionBuilder2.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            BlurModule$definition$1$1$1 blurModule$definition$1$1$1 = new Function2<ExpoBlurView, Float, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, Float f) {
                    invoke(expoBlurView, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoBlurView view, float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setBlurRadius(f);
                }
            };
            Map<String, AnyViewProp> props = viewDefinitionBuilder.getProps();
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$2$lambda$1$$inlined$Prop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Float.TYPE);
                    }
                }), null);
            }
            props.put("intensity", new ConcreteViewProp("intensity", anyType, blurModule$definition$1$1$1));
            BlurModule$definition$1$1$2 blurModule$definition$1$1$2 = new Function2<ExpoBlurView, TintStyle, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, TintStyle tintStyle) {
                    invoke2(expoBlurView, tintStyle);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoBlurView view, TintStyle tint) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(tint, "tint");
                    view.setTint$expo_blur_release(tint);
                }
            };
            Map<String, AnyViewProp> props2 = viewDefinitionBuilder.getProps();
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(TintStyle.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TintStyle.class), false, new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$2$lambda$1$$inlined$Prop$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(TintStyle.class);
                    }
                }), null);
            }
            props2.put("tint", new ConcreteViewProp("tint", anyType2, blurModule$definition$1$1$2));
            BlurModule$definition$1$1$3 blurModule$definition$1$1$3 = new Function2<ExpoBlurView, Float, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, Float f) {
                    invoke(expoBlurView, f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ExpoBlurView view, float f) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.applyBlurReduction(f);
                }
            };
            Map<String, AnyViewProp> props3 = viewDefinitionBuilder.getProps();
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$2$lambda$1$$inlined$Prop$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Float.TYPE);
                    }
                }), null);
            }
            props3.put("blurReductionFactor", new ConcreteViewProp("blurReductionFactor", anyType3, blurModule$definition$1$1$3));
            BlurModule$definition$1$1$4 blurModule$definition$1$1$4 = new Function2<ExpoBlurView, BlurMethod, Unit>() { // from class: expo.modules.blur.BlurModule$definition$1$1$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoBlurView expoBlurView, BlurMethod blurMethod) {
                    invoke2(expoBlurView, blurMethod);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoBlurView view, BlurMethod experimentalBlurMethod) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(experimentalBlurMethod, "experimentalBlurMethod");
                    view.setBlurMethod(experimentalBlurMethod);
                }
            };
            Map<String, AnyViewProp> props4 = viewDefinitionBuilder.getProps();
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(BlurMethod.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(BlurMethod.class), false, new Function0<KType>() { // from class: expo.modules.blur.BlurModule$definition$lambda$2$lambda$1$$inlined$Prop$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(BlurMethod.class);
                    }
                }), null);
            }
            props4.put("experimentalBlurMethod", new ConcreteViewProp("experimentalBlurMethod", anyType4, blurModule$definition$1$1$4));
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.blur.BlurModule$definition$lambda$2$lambda$1$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((ExpoBlurView) it).applyTint();
                }
            });
            moduleDefinitionBuilder2.registerViewDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
