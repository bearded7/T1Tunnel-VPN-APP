package expo.modules.lineargradient;

import androidx.tracing.Trace;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: compiled from: LinearGradientModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/lineargradient/LinearGradientModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-linear-gradient_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinearGradientModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        LinearGradientModule linearGradientModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (linearGradientModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(linearGradientModule);
            moduleDefinitionBuilder.Name("ExpoLinearGradient");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(LinearGradientView.class), new LazyKType(Reflection.getOrCreateKotlinClass(LinearGradientView.class), false, new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LinearGradientView.class);
                }
            }, 2, null), moduleDefinitionBuilder2.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            LinearGradientModule$definition$1$1$1 linearGradientModule$definition$1$1$1 = new Function2<LinearGradientView, int[], Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, int[] iArr) {
                    invoke2(linearGradientView, iArr);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, int[] colors) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(colors, "colors");
                    view.setColors(colors);
                }
            };
            Map<String, AnyViewProp> props = viewDefinitionBuilder.getProps();
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(int[].class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(int[].class), false, new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(int[].class);
                    }
                }), null);
            }
            props.put("colors", new ConcreteViewProp("colors", anyType, linearGradientModule$definition$1$1$1));
            LinearGradientModule$definition$1$1$2 linearGradientModule$definition$1$1$2 = new Function2<LinearGradientView, float[], Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, float[] fArr) {
                    invoke2(linearGradientView, fArr);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, float[] fArr) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (fArr != null) {
                        view.setLocations(fArr);
                    }
                }
            };
            Map<String, AnyViewProp> props2 = viewDefinitionBuilder.getProps();
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(float[].class), true));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(float[].class), true, new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(float[].class);
                    }
                }), null);
            }
            props2.put("locations", new ConcreteViewProp("locations", anyType2, linearGradientModule$definition$1$1$2));
            LinearGradientModule$definition$1$1$3 linearGradientModule$definition$1$1$3 = new Function2<LinearGradientView, Pair<? extends Float, ? extends Float>, Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, Pair<? extends Float, ? extends Float> pair) {
                    invoke2(linearGradientView, (Pair<Float, Float>) pair);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, Pair<Float, Float> pair) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setStartPosition(pair != null ? pair.getFirst().floatValue() : 0.5f, pair != null ? pair.getSecond().floatValue() : 0.0f);
                }
            };
            Map<String, AnyViewProp> props3 = viewDefinitionBuilder.getProps();
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Pair.class), true));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Pair.class), true, new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Pair.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)));
                    }
                }), null);
            }
            props3.put("startPoint", new ConcreteViewProp("startPoint", anyType3, linearGradientModule$definition$1$1$3));
            LinearGradientModule$definition$1$1$4 linearGradientModule$definition$1$1$4 = new Function2<LinearGradientView, Pair<? extends Float, ? extends Float>, Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, Pair<? extends Float, ? extends Float> pair) {
                    invoke2(linearGradientView, (Pair<Float, Float>) pair);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, Pair<Float, Float> pair) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setEndPosition(pair != null ? pair.getFirst().floatValue() : 0.5f, pair != null ? pair.getSecond().floatValue() : 1.0f);
                }
            };
            Map<String, AnyViewProp> props4 = viewDefinitionBuilder.getProps();
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Pair.class), true));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Pair.class), true, new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Pair.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Float.TYPE)));
                    }
                }), null);
            }
            props4.put("endPoint", new ConcreteViewProp("endPoint", anyType4, linearGradientModule$definition$1$1$4));
            LinearGradientModule$definition$1$1$5 linearGradientModule$definition$1$1$5 = new Function2<LinearGradientView, float[], Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, float[] fArr) {
                    invoke2(linearGradientView, fArr);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, float[] fArr) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (fArr == null) {
                        float[] fArr2 = new float[8];
                        for (int i = 0; i < 8; i++) {
                            fArr2[i] = 0.0f;
                        }
                        fArr = fArr2;
                    }
                    view.setBorderRadii(fArr);
                }
            };
            Map<String, AnyViewProp> props5 = viewDefinitionBuilder.getProps();
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(float[].class), true));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(float[].class), true, new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(float[].class);
                    }
                }), null);
            }
            props5.put("borderRadii", new ConcreteViewProp("borderRadii", anyType5, linearGradientModule$definition$1$1$5));
            LinearGradientModule$definition$1$1$6 linearGradientModule$definition$1$1$6 = new Function2<LinearGradientView, Boolean, Unit>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$1$1$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(LinearGradientView linearGradientView, Boolean bool) {
                    invoke2(linearGradientView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearGradientView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDither(bool != null ? bool.booleanValue() : true);
                }
            };
            Map<String, AnyViewProp> props6 = viewDefinitionBuilder.getProps();
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.lineargradient.LinearGradientModule$definition$lambda$1$lambda$0$$inlined$Prop$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Boolean.class);
                    }
                }), null);
            }
            props6.put("dither", new ConcreteViewProp("dither", anyType6, linearGradientModule$definition$1$1$6));
            moduleDefinitionBuilder2.registerViewDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
