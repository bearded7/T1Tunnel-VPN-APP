package expo.modules.systemui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.ViewCompat;
import androidx.tracing.Trace;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: SystemUIModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lexpo/modules/systemui/SystemUIModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "systemBackgroundColor", "", "getSystemBackgroundColor", "()I", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "setBackgroundColor", "", ViewProps.COLOR, "Companion", "expo-system-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemUIModule extends Module {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getPrefs() throws Exceptions.ReactContextLost {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("expo_ui_preferences", 0);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSystemBackgroundColor() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        if (defaultNightMode != -1) {
            if (defaultNightMode == 1 || defaultNightMode != 2) {
                return -1;
            }
            return ViewCompat.MEASURED_STATE_MASK;
        }
        int i = getContext().getResources().getConfiguration().uiMode & 48;
        if (i == 16 || i != 32) {
            return -1;
        }
        return ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        SystemUIModule systemUIModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (systemUIModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(systemUIModule);
            moduleDefinitionBuilder.Name("ExpoSystemUI");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setBackgroundColorAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Integer num = (Integer) promise;
                        this.this$0.getPrefs().edit().putInt(SystemUIModuleKt.PREFERENCE_KEY, num.intValue()).apply();
                        this.this$0.setBackgroundColor(num.intValue());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), true, new Function0<KType>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
                        }
                    }), converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Integer num = (Integer) objArr[0];
                        if (num != null) {
                            this.this$0.getPrefs().edit().putInt(SystemUIModuleKt.PREFERENCE_KEY, num.intValue()).apply();
                        } else {
                            this.this$0.getPrefs().edit().remove(SystemUIModuleKt.PREFERENCE_KEY).apply();
                        }
                        SystemUIModule systemUIModule2 = this.this$0;
                        systemUIModule2.setBackgroundColor(num != null ? num.intValue() : systemUIModule2.getSystemBackgroundColor());
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("setBackgroundColorAsync", asyncFunctionWithPromiseComponent);
            asyncFunctionWithPromiseComponent.runOnQueue(Queues.MAIN);
            moduleDefinitionBuilder.getAsyncFunctions().put("getBackgroundColorAsync", new UntypedAsyncFunctionComponent("getBackgroundColorAsync", new AnyType[0], new Function1<Object[], String>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Drawable background = this.this$0.getAppContext().getThrowingActivity().getWindow().getDecorView().getBackground();
                    if (!(background instanceof ColorDrawable)) {
                        return null;
                    }
                    SystemUIModule.Companion companion = SystemUIModule.INSTANCE;
                    Drawable drawableMutate = ((ColorDrawable) background).mutate();
                    Intrinsics.checkNotNull(drawableMutate, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
                    return companion.colorToHex(((ColorDrawable) drawableMutate).getColor());
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBackgroundColor(int color) {
        Window window = getAppContext().getThrowingActivity().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        int color2 = Color.parseColor(INSTANCE.colorToHex(color));
        if (decorView != null) {
            decorView.setBackgroundColor(color2);
        }
    }

    /* JADX INFO: compiled from: SystemUIModule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/systemui/SystemUIModule$Companion;", "", "<init>", "()V", "colorToHex", "", ViewProps.COLOR, "", "expo-system-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String colorToHex(int color) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.red(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.blue(color))}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }
}
