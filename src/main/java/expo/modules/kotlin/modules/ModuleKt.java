package expo.modules.kotlin.modules;

import androidx.tracing.Trace;
import expo.modules.kotlin.types.TypeConverterProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Module.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0019\b\u0004\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a+\u0010\b\u001a\u00020\t*\u00020\u00022\u0019\b\u0004\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"ModuleDefinition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Lexpo/modules/kotlin/modules/Module;", "block", "Lkotlin/Function1;", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "", "Lkotlin/ExtensionFunctionType;", "ModuleConverters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "Lexpo/modules/kotlin/modules/ModuleConvertersBuilder;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ModuleKt {
    public static final ModuleDefinitionData ModuleDefinition(Module module, Function1<? super ModuleDefinitionBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            block.invoke(moduleDefinitionBuilder);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public static final TypeConverterProvider ModuleConverters(Module module, Function1<? super ModuleConvertersBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".TypeConverters"));
        try {
            ModuleConvertersBuilder moduleConvertersBuilder = new ModuleConvertersBuilder();
            block.invoke(moduleConvertersBuilder);
            return moduleConvertersBuilder.buildTypeConverterProvider();
        } finally {
            Trace.endSection();
        }
    }
}
