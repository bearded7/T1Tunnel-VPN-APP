package expo.modules.constants;

import androidx.tracing.Trace;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstantsModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/constants/ConstantsModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-constants_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConstantsModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ConstantsModule constantsModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (constantsModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(constantsModule);
            moduleDefinitionBuilder.Name("ExponentConstants");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.constants.ConstantsModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    Map<String, ? extends Object> constants;
                    ConstantsInterface constants2 = this.this$0.getAppContext().getConstants();
                    return (constants2 == null || (constants = constants2.getConstants()) == null) ? MapsKt.emptyMap() : constants;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getWebViewUserAgentAsync", new UntypedAsyncFunctionComponent("getWebViewUserAgentAsync", new AnyType[0], new Function1<Object[], String>() { // from class: expo.modules.constants.ConstantsModule$definition$lambda$1$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return System.getProperty("http.agent");
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
