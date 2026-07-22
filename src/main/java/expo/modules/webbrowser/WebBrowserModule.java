package expo.modules.webbrowser;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.caverock.androidsvg.SVGParser;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: WebBrowserModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lexpo/modules/webbrowser/WebBrowserModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "customTabsResolver", "Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;", "getCustomTabsResolver$expo_web_browser_release", "()Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;", "setCustomTabsResolver$expo_web_browser_release", "(Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;)V", "connectionHelper", "Lexpo/modules/webbrowser/CustomTabsConnectionHelper;", "getConnectionHelper$expo_web_browser_release", "()Lexpo/modules/webbrowser/CustomTabsConnectionHelper;", "setConnectionHelper$expo_web_browser_release", "(Lexpo/modules/webbrowser/CustomTabsConnectionHelper;)V", "createCustomTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "options", "Lexpo/modules/webbrowser/OpenBrowserOptions;", "givenOrPreferredPackageName", "", "packageName", "expo-web-browser_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebBrowserModule extends Module {
    public CustomTabsConnectionHelper connectionHelper;
    public CustomTabsActivitiesHelper customTabsResolver;

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
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent5;
        WebBrowserModule webBrowserModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (webBrowserModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(webBrowserModule);
            moduleDefinitionBuilder.Name("ExpoWebBrowser");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.setCustomTabsResolver$expo_web_browser_release(new CustomTabsActivitiesHelper(this.this$0.getAppContext()));
                    this.this$0.setConnectionHelper$expo_web_browser_release(new CustomTabsConnectionHelper(this.this$0.getContext()));
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new Function0<Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$OnActivityDestroys$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.getConnectionHelper$expo_web_browser_release().destroy();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("warmUpAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) promise);
                        this.this$0.getConnectionHelper$expo_web_browser_release().warmUp(strGivenOrPreferredPackageName);
                        BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }), converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Bundle> function1 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Bundle invoke(Object[] objArr) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) objArr[0]);
                        this.this$0.getConnectionHelper$expo_web_browser_release().warmUp(strGivenOrPreferredPackageName);
                        return BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                    }
                };
                if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("warmUpAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("coolDownAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) promise);
                        if (this.this$0.getConnectionHelper$expo_web_browser_release().coolDown(strGivenOrPreferredPackageName)) {
                            BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                        } else {
                            new Bundle();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }), converters2);
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Bundle> function2 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Bundle invoke(Object[] objArr) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) objArr[0]);
                        if (this.this$0.getConnectionHelper$expo_web_browser_release().coolDown(strGivenOrPreferredPackageName)) {
                            return BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                        }
                        return new Bundle();
                    }
                };
                if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("coolDownAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            TypeConverterProvider converters3 = moduleDefinitionBuilder4.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters3);
            }
            anyTypeArr3[0] = anyType3;
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }), converters3);
            }
            anyTypeArr3[1] = anyType4;
            Function1<Object[], Bundle> function3 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] objArr) throws NoPreferredPackageFound {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) objArr[1]);
                    CustomTabsConnectionHelper connectionHelper$expo_web_browser_release = this.this$0.getConnectionHelper$expo_web_browser_release();
                    Uri uri = Uri.parse((String) obj);
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                    connectionHelper$expo_web_browser_release.mayInitWithUrl(strGivenOrPreferredPackageName, uri);
                    return BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                }
            };
            if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function3);
                            } else {
                                untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function3);
                }
            } else {
                untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("mayInitWithUrlAsync", untypedAsyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], Bundle> function4 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ArrayList<String> customTabsResolvingActivities = this.this$0.getCustomTabsResolver$expo_web_browser_release().getCustomTabsResolvingActivities();
                    ArrayList<String> customTabsResolvingServices = this.this$0.getCustomTabsResolver$expo_web_browser_release().getCustomTabsResolvingServices();
                    String preferredCustomTabsResolvingActivity = this.this$0.getCustomTabsResolver$expo_web_browser_release().getPreferredCustomTabsResolvingActivity(customTabsResolvingActivities);
                    String defaultCustomTabsResolvingActivity = this.this$0.getCustomTabsResolver$expo_web_browser_release().getDefaultCustomTabsResolvingActivity();
                    if (!CollectionsKt.contains(customTabsResolvingActivities, defaultCustomTabsResolvingActivity)) {
                        defaultCustomTabsResolvingActivity = null;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("browserPackages", customTabsResolvingActivities);
                    bundle.putStringArrayList("servicePackages", customTabsResolvingServices);
                    bundle.putString("preferredBrowserPackage", preferredCustomTabsResolvingActivity);
                    bundle.putString("defaultBrowserPackage", defaultCustomTabsResolvingActivity);
                    return bundle;
                }
            };
            if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function4);
                            } else {
                                untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function4);
                }
            } else {
                untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function4);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getCustomTabsSupportingBrowsersAsync", untypedAsyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            TypeConverterProvider converters4 = moduleDefinitionBuilder6.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters4);
            }
            anyTypeArr5[0] = anyType5;
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(OpenBrowserOptions.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OpenBrowserOptions.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(OpenBrowserOptions.class);
                    }
                }), converters4);
            }
            anyTypeArr5[1] = anyType6;
            Function1<Object[], Bundle> function5 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$10$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] objArr) throws NoMatchingActivityException, NoUrlProvidedException {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    CustomTabsIntent customTabsIntentCreateCustomTabsIntent = this.this$0.createCustomTabsIntent((OpenBrowserOptions) objArr[1]);
                    customTabsIntentCreateCustomTabsIntent.intent.setData(Uri.parse((String) obj));
                    if (!this.this$0.getCustomTabsResolver$expo_web_browser_release().canResolveIntent(customTabsIntentCreateCustomTabsIntent)) {
                        throw new NoMatchingActivityException();
                    }
                    this.this$0.getCustomTabsResolver$expo_web_browser_release().startCustomTabs(customTabsIntentCreateCustomTabsIntent);
                    return BundleKt.bundleOf(TuplesKt.to(SVGParser.XML_STYLESHEET_ATTR_TYPE, "opened"));
                }
            };
            if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                untypedAsyncFunctionComponent5 = new StringAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function5);
                            } else {
                                untypedAsyncFunctionComponent5 = new UntypedAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function5);
                            }
                        } else {
                            untypedAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function5);
                        }
                    } else {
                        untypedAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function5);
                    }
                } else {
                    untypedAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function5);
                }
            } else {
                untypedAsyncFunctionComponent5 = new IntAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function5);
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("openBrowserAsync", untypedAsyncFunctionComponent5);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public final CustomTabsActivitiesHelper getCustomTabsResolver$expo_web_browser_release() {
        CustomTabsActivitiesHelper customTabsActivitiesHelper = this.customTabsResolver;
        if (customTabsActivitiesHelper != null) {
            return customTabsActivitiesHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customTabsResolver");
        return null;
    }

    public final void setCustomTabsResolver$expo_web_browser_release(CustomTabsActivitiesHelper customTabsActivitiesHelper) {
        Intrinsics.checkNotNullParameter(customTabsActivitiesHelper, "<set-?>");
        this.customTabsResolver = customTabsActivitiesHelper;
    }

    public final CustomTabsConnectionHelper getConnectionHelper$expo_web_browser_release() {
        CustomTabsConnectionHelper customTabsConnectionHelper = this.connectionHelper;
        if (customTabsConnectionHelper != null) {
            return customTabsConnectionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectionHelper");
        return null;
    }

    public final void setConnectionHelper$expo_web_browser_release(CustomTabsConnectionHelper customTabsConnectionHelper) {
        Intrinsics.checkNotNullParameter(customTabsConnectionHelper, "<set-?>");
        this.connectionHelper = customTabsConnectionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CustomTabsIntent createCustomTabsIntent(OpenBrowserOptions options) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        Integer toolbarColor = options.getToolbarColor();
        if (toolbarColor != null) {
            CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setSecondaryToolbarColor(toolbarColor.intValue()).build();
            Intrinsics.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "build(...)");
            builder.setDefaultColorSchemeParams(customTabColorSchemeParamsBuild);
        }
        Integer secondaryToolbarColor = options.getSecondaryToolbarColor();
        if (secondaryToolbarColor != null) {
            CustomTabColorSchemeParams customTabColorSchemeParamsBuild2 = new CustomTabColorSchemeParams.Builder().setSecondaryToolbarColor(secondaryToolbarColor.intValue()).build();
            Intrinsics.checkNotNullExpressionValue(customTabColorSchemeParamsBuild2, "build(...)");
            builder.setDefaultColorSchemeParams(customTabColorSchemeParamsBuild2);
        }
        builder.setShowTitle(options.getShowTitle());
        if (options.getEnableDefaultShareMenuItem()) {
            builder.setShareState(1);
        }
        CustomTabsIntent customTabsIntentBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        customTabsIntentBuild.intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, options.getEnableBarCollapsing());
        String browserPackage = options.getBrowserPackage();
        if (!TextUtils.isEmpty(browserPackage)) {
            customTabsIntentBuild.intent.setPackage(browserPackage);
        }
        if (options.getShouldCreateTask()) {
            customTabsIntentBuild.intent.addFlags(268435456);
            if (!options.getShowInRecents()) {
                customTabsIntentBuild.intent.addFlags(8388608);
                customTabsIntentBuild.intent.addFlags(1073741824);
            }
        }
        return customTabsIntentBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    public final String givenOrPreferredPackageName(String packageName) throws NoPreferredPackageFound {
        if (packageName != null) {
            try {
                if (packageName.length() <= 0) {
                    packageName = null;
                }
            } catch (CurrentActivityNotFoundException unused) {
                throw new NoPreferredPackageFound();
            } catch (PackageManagerNotFoundException unused2) {
                throw new NoPreferredPackageFound();
            }
        } else {
            packageName = null;
        }
        if (packageName == null) {
            packageName = getCustomTabsResolver$expo_web_browser_release().getPreferredCustomTabsResolvingActivity(null);
        }
        if (packageName != null) {
            String str = packageName.length() > 0 ? packageName : null;
            if (str != null) {
                return str;
            }
        }
        throw new NoPreferredPackageFound();
    }
}
