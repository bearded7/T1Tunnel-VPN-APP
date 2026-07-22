package expo.modules.linking;

import android.net.Uri;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: ExpoLinkingModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lexpo/modules/linking/ExpoLinkingModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "onURLReceivedObserver", "Lkotlin/Function1;", "Landroid/net/Uri;", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "expo-linking_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoLinkingModule extends Module {
    private static Uri initialURL;
    private Function1<? super Uri, Unit> onURLReceivedObserver;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Set<Function1<Uri, Unit>> onURLReceivedObservers = new LinkedHashSet();

    /* JADX INFO: compiled from: ExpoLinkingModule.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/linking/ExpoLinkingModule$Companion;", "", "<init>", "()V", "initialURL", "Landroid/net/Uri;", "getInitialURL", "()Landroid/net/Uri;", "setInitialURL", "(Landroid/net/Uri;)V", "onURLReceivedObservers", "", "Lkotlin/Function1;", "", "getOnURLReceivedObservers", "()Ljava/util/Set;", "setOnURLReceivedObservers", "(Ljava/util/Set;)V", "expo-linking_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uri getInitialURL() {
            return ExpoLinkingModule.initialURL;
        }

        public final void setInitialURL(Uri uri) {
            ExpoLinkingModule.initialURL = uri;
        }

        public final Set<Function1<Uri, Unit>> getOnURLReceivedObservers() {
            return ExpoLinkingModule.onURLReceivedObservers;
        }

        public final void setOnURLReceivedObservers(Set<Function1<Uri, Unit>> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            ExpoLinkingModule.onURLReceivedObservers = set;
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ExpoLinkingModule expoLinkingModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoLinkingModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoLinkingModule);
            moduleDefinitionBuilder.Name("ExpoLinking");
            moduleDefinitionBuilder.Events("onURLReceived");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
            ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("getLinkingURL", new SyncFunctionComponent("getLinkingURL", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.linking.ExpoLinkingModule$definition$lambda$1$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Uri uri = ExpoLinkingModule.initialURL;
                    if (uri != null) {
                        return uri.toString();
                    }
                    return null;
                }
            }));
            moduleDefinitionBuilder.OnStartObserving("onURLReceived", new Function0<Unit>() { // from class: expo.modules.linking.ExpoLinkingModule$definition$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    final WeakReference weakReference = new WeakReference(this.this$0);
                    Function1<Uri, Unit> function1 = new Function1<Uri, Unit>() { // from class: expo.modules.linking.ExpoLinkingModule$definition$1$2$observer$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Uri uri) {
                            invoke2(uri);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Uri uri) {
                            ExpoLinkingModule expoLinkingModule2 = weakReference.get();
                            if (expoLinkingModule2 != null) {
                                Pair[] pairArr = new Pair[1];
                                pairArr[0] = TuplesKt.to(ImagesContract.URL, uri != null ? uri.toString() : null);
                                expoLinkingModule2.sendEvent("onURLReceived", BundleKt.bundleOf(pairArr));
                            }
                        }
                    };
                    ExpoLinkingModule.INSTANCE.getOnURLReceivedObservers().add(function1);
                    this.this$0.onURLReceivedObserver = function1;
                }
            });
            moduleDefinitionBuilder.OnStopObserving("onURLReceived", new Function0<Unit>() { // from class: expo.modules.linking.ExpoLinkingModule$definition$1$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Set<Function1<Uri, Unit>> onURLReceivedObservers2 = ExpoLinkingModule.INSTANCE.getOnURLReceivedObservers();
                    TypeIntrinsics.asMutableCollection(onURLReceivedObservers2).remove(this.this$0.onURLReceivedObserver);
                }
            });
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
