package expo.modules.kotlin.activityresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.common.util.UriUtil;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppContextActivityResultRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00029:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JC\u0010\u001c\u001a\u00020\u001d\"\b\b\u0000\u0010\u001e*\u00020\u0015\"\u0004\b\u0001\u0010\u001f2\u0006\u0010 \u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\"2\b\b\u0001\u0010#\u001a\u0002H\u001eH\u0007¢\u0006\u0002\u0010$J\\\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0&\"\b\b\u0000\u0010\u001e*\u00020\u0015\"\u0004\b\u0001\u0010\u001f2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\"2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0+H\u0007J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u000bH\u0007J\"\u00101\u001a\u0002022\u0006\u0010 \u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u000105H\u0007JH\u00106\u001a\u00020\u001d\"\b\b\u0000\u0010\u001e*\u00020\u0015\"\u0004\b\u0001\u0010\u001f2\u0006\u0010'\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u0001052\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u0013H\u0002J\b\u00108\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0010j\b\u0012\u0004\u0012\u00020\u000b`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00130\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006;"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry;", "", "currentActivityProvider", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "<init>", "(Lexpo/modules/kotlin/providers/CurrentActivityProvider;)V", "random", "Ljava/util/Random;", "requestCodeToKey", "", "", "", "keyToRequestCode", "keyToLifecycleContainers", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer;", "launchedKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyToCallbacksAndContract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$CallbacksAndContract;", "keyToInputParam", "Ljava/io/Serializable;", "pendingResults", "Landroid/os/Bundle;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "onLaunch", "", "I", "O", "requestCode", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "input", "(ILexpo/modules/kotlin/activityresult/AppContextActivityResultContract;Ljava/io/Serializable;)V", "register", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "key", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "persistInstanceState", "context", "Landroid/content/Context;", "restoreInstanceState", "unregister", "dispatchResult", "", "resultCode", UriUtil.DATA_SCHEME, "Landroid/content/Intent;", "doDispatch", "callbacksAndContract", "generateRandomNumber", "CallbacksAndContract", "LifecycleContainer", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppContextActivityResultRegistry {
    private final CurrentActivityProvider currentActivityProvider;
    private final Map<String, CallbacksAndContract<?, ?>> keyToCallbacksAndContract;
    private final Map<String, Serializable> keyToInputParam;
    private final Map<String, LifecycleContainer> keyToLifecycleContainers;
    private final Map<String, Integer> keyToRequestCode;
    private ArrayList<String> launchedKeys;
    private final Bundle pendingResults;
    private Random random;
    private final Map<Integer, String> requestCodeToKey;

    /* JADX INFO: compiled from: AppContextActivityResultRegistry.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppContextActivityResultRegistry(CurrentActivityProvider currentActivityProvider) {
        Intrinsics.checkNotNullParameter(currentActivityProvider, "currentActivityProvider");
        this.currentActivityProvider = currentActivityProvider;
        this.random = new Random();
        this.requestCodeToKey = new HashMap();
        this.keyToRequestCode = new HashMap();
        this.keyToLifecycleContainers = new HashMap();
        this.launchedKeys = new ArrayList<>();
        this.keyToCallbacksAndContract = new HashMap();
        this.keyToInputParam = new HashMap();
        this.pendingResults = new Bundle();
    }

    private final AppCompatActivity getActivity() {
        Activity currentActivity = this.currentActivityProvider.getCurrentActivity();
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        throw new IllegalArgumentException("Current Activity is not available at the moment".toString());
    }

    public final <I extends Serializable, O> void onLaunch(int requestCode, AppContextActivityResultContract<I, O> contract, I input) {
        Bundle bundleExtra;
        int i;
        Parcelable parcelableExtra;
        final int i2;
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intentCreateIntent = contract.createIntent(getActivity(), input);
        if (intentCreateIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            bundleExtra = intentCreateIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            intentCreateIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        String action = intentCreateIntent.getAction();
        if (action == null) {
            i = requestCode;
        } else {
            int iHashCode = action.hashCode();
            if (iHashCode != -1837081951) {
                if (iHashCode == -591152331 && action.equals(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST)) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelableExtra = (Parcelable) intentCreateIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, IntentSenderRequest.class);
                    } else {
                        parcelableExtra = intentCreateIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
                    }
                    Intrinsics.checkNotNull(parcelableExtra);
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) parcelableExtra;
                    try {
                        i2 = requestCode;
                        try {
                            ActivityCompat.startIntentSenderForResult(getActivity(), intentSenderRequest.getIntentSender(), i2, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
                            Unit unit = Unit.INSTANCE;
                            return;
                        } catch (IntentSender.SendIntentException e) {
                            e = e;
                            final IntentSender.SendIntentException sendIntentException = e;
                            Boolean.valueOf(new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AppContextActivityResultRegistry.onLaunch$lambda$1(this.f$0, i2, sendIntentException);
                                }
                            }));
                            return;
                        }
                    } catch (IntentSender.SendIntentException e2) {
                        e = e2;
                        i2 = requestCode;
                    }
                }
                i = requestCode;
            } else {
                i = requestCode;
                if (action.equals(ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS)) {
                    String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    ActivityCompat.requestPermissions(getActivity(), stringArrayExtra, i);
                    return;
                }
            }
        }
        ActivityCompat.startActivityForResult(getActivity(), intentCreateIntent, i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$1(AppContextActivityResultRegistry appContextActivityResultRegistry, int i, IntentSender.SendIntentException sendIntentException) {
        appContextActivityResultRegistry.dispatchResult(i, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, sendIntentException));
    }

    public final <I extends Serializable, O> AppContextActivityResultLauncher<I, O> register(final String key, LifecycleOwner lifecycleOwner, AppContextActivityResultContract<I, O> contract, AppContextActivityResultFallbackCallback<I, O> fallbackCallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(fallbackCallback, "fallbackCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        this.keyToCallbacksAndContract.put(key, new CallbacksAndContract<>(fallbackCallback, null, contract));
        if (this.keyToRequestCode.get(key) == null) {
            int iGenerateRandomNumber = generateRandomNumber();
            this.requestCodeToKey.put(Integer.valueOf(iGenerateRandomNumber), key);
            this.keyToRequestCode.put(key, Integer.valueOf(iGenerateRandomNumber));
            Unit unit = Unit.INSTANCE;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                AppContextActivityResultRegistry.register$lambda$4(this.f$0, key, lifecycleOwner2, event);
            }
        };
        LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        lifecycleContainer.addObserver(lifecycleEventObserver);
        this.keyToLifecycleContainers.put(key, lifecycleContainer);
        return (AppContextActivityResultLauncher) new AppContextActivityResultLauncher<I, O>(contract, this, key, fallbackCallback) { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.register.2
            final /* synthetic */ AppContextActivityResultContract<I, O> $contract;
            final /* synthetic */ AppContextActivityResultFallbackCallback<I, O> $fallbackCallback;
            final /* synthetic */ String $key;
            private final AppContextActivityResultContract<I, O> contract;
            final /* synthetic */ AppContextActivityResultRegistry this$0;

            {
                this.$contract = contract;
                this.this$0 = this;
                this.$key = key;
                this.$fallbackCallback = fallbackCallback;
                this.contract = contract;
            }

            /* JADX WARN: Incorrect types in method signature: (TI;Landroidx/activity/result/ActivityResultCallback<TO;>;)V */
            @Override // expo.modules.kotlin.activityresult.AppContextActivityResultLauncher
            public void launch(Serializable input, ActivityResultCallback callback) throws Exception {
                Intrinsics.checkNotNullParameter(input, "input");
                Intrinsics.checkNotNullParameter(callback, "callback");
                Integer num = (Integer) this.this$0.keyToRequestCode.get(this.$key);
                if (num != null) {
                    int iIntValue = num.intValue();
                    this.this$0.keyToCallbacksAndContract.put(this.$key, new CallbacksAndContract(this.$fallbackCallback, callback, this.$contract));
                    this.this$0.keyToInputParam.put(this.$key, input);
                    this.this$0.launchedKeys.add(this.$key);
                    try {
                        this.this$0.onLaunch(iIntValue, this.$contract, input);
                        return;
                    } catch (Exception e) {
                        this.this$0.launchedKeys.remove(this.$key);
                        throw e;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.$contract + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch()");
            }

            @Override // expo.modules.kotlin.activityresult.AppContextActivityResultLauncher
            public AppContextActivityResultContract<I, O> getContract() {
                return this.contract;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$4(AppContextActivityResultRegistry appContextActivityResultRegistry, String str, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            appContextActivityResultRegistry.unregister(str);
            return;
        }
        CallbacksAndContract<?, ?> callbacksAndContract = appContextActivityResultRegistry.keyToCallbacksAndContract.get(str);
        if (callbacksAndContract == null) {
            return;
        }
        Bundle bundle = appContextActivityResultRegistry.pendingResults;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundle.getParcelable(str, ActivityResult.class);
        } else {
            parcelable = bundle.getParcelable(str);
        }
        ActivityResult activityResult = (ActivityResult) parcelable;
        if (activityResult != null) {
            appContextActivityResultRegistry.pendingResults.remove(str);
            Serializable serializable = appContextActivityResultRegistry.keyToInputParam.get(str);
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.register");
            Serializable serializable2 = serializable;
            Object result = callbacksAndContract.getContract().parseResult(serializable2, activityResult.getResultCode(), activityResult.getData());
            if (callbacksAndContract.getMainCallback() != null) {
                callbacksAndContract.getMainCallback().onActivityResult(result);
            } else {
                callbacksAndContract.getFallbackCallback().onActivityResult(serializable2, result);
            }
        }
    }

    public final void persistInstanceState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor dataPersistorAddStringToIntMap = new DataPersistor(context).addStringArrayList("launchedKeys", this.launchedKeys).addStringToIntMap("keyToRequestCode", this.keyToRequestCode);
        Map<String, Serializable> map = this.keyToInputParam;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Serializable> entry : map.entrySet()) {
            if (this.launchedKeys.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        dataPersistorAddStringToIntMap.addStringToSerializableMap("keyToParamsForFallbackCallback", linkedHashMap).addBundle("pendingResult", this.pendingResults).addSerializable("random", this.random).persist();
    }

    public final void restoreInstanceState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor dataPersistor = new DataPersistor(context);
        ArrayList<String> arrayListRetrieveStringArrayList = dataPersistor.retrieveStringArrayList("launchedKeys");
        if (arrayListRetrieveStringArrayList != null) {
            this.launchedKeys = arrayListRetrieveStringArrayList;
        }
        Map<String, Serializable> mapRetrieveStringToSerializableMap = dataPersistor.retrieveStringToSerializableMap("keyToParamsForFallbackCallback");
        if (mapRetrieveStringToSerializableMap != null) {
            this.keyToInputParam.putAll(mapRetrieveStringToSerializableMap);
        }
        Bundle bundleRetrieveBundle = dataPersistor.retrieveBundle("pendingResult");
        if (bundleRetrieveBundle != null) {
            this.pendingResults.putAll(bundleRetrieveBundle);
        }
        Serializable serializableRetrieveSerializable = dataPersistor.retrieveSerializable("random");
        if (serializableRetrieveSerializable != null) {
            this.random = (Random) serializableRetrieveSerializable;
        }
        Map<String, Integer> mapRetrieveStringToIntMap = dataPersistor.retrieveStringToIntMap("keyToRequestCode");
        if (mapRetrieveStringToIntMap != null) {
            Iterator<T> it = mapRetrieveStringToIntMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                int iIntValue = ((Number) entry.getValue()).intValue();
                this.keyToRequestCode.put(str, Integer.valueOf(iIntValue));
                this.requestCodeToKey.put(Integer.valueOf(iIntValue), str);
            }
        }
    }

    public final void unregister(String key) {
        Parcelable parcelable;
        Integer numRemove;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.launchedKeys.contains(key) && (numRemove = this.keyToRequestCode.remove(key)) != null) {
            this.requestCodeToKey.remove(Integer.valueOf(numRemove.intValue()));
        }
        this.keyToCallbacksAndContract.remove(key);
        if (this.pendingResults.containsKey(key)) {
            Bundle bundle = this.pendingResults;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) bundle.getParcelable(key, ActivityResult.class);
            } else {
                parcelable = bundle.getParcelable(key);
            }
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + " : " + parcelable);
            this.pendingResults.remove(key);
        }
        LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            this.keyToLifecycleContainers.remove(key);
        }
    }

    public final boolean dispatchResult(int requestCode, int resultCode, Intent data) {
        String str = this.requestCodeToKey.get(Integer.valueOf(requestCode));
        if (str == null) {
            return false;
        }
        doDispatch(str, resultCode, data, this.keyToCallbacksAndContract.get(str));
        return true;
    }

    private final <I extends Serializable, O> void doDispatch(String key, int resultCode, Intent data, CallbacksAndContract<I, O> callbacksAndContract) {
        Lifecycle lifecycle;
        LifecycleContainer lifecycleContainer = this.keyToLifecycleContainers.get(key);
        Lifecycle.State state = (lifecycleContainer == null || (lifecycle = lifecycleContainer.getLifecycle()) == null) ? null : lifecycle.getState();
        if ((callbacksAndContract != null ? callbacksAndContract.getMainCallback() : null) != null && this.launchedKeys.contains(key)) {
            Serializable serializable = this.keyToInputParam.get(key);
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch");
            callbacksAndContract.getMainCallback().onActivityResult(callbacksAndContract.getContract().parseResult(serializable, resultCode, data));
            this.launchedKeys.remove(key);
            return;
        }
        if (state != null && state.isAtLeast(Lifecycle.State.STARTED) && callbacksAndContract != null && this.launchedKeys.contains(key)) {
            Serializable serializable2 = this.keyToInputParam.get(key);
            Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch");
            Serializable serializable3 = serializable2;
            callbacksAndContract.getFallbackCallback().onActivityResult(serializable3, callbacksAndContract.getContract().parseResult(serializable3, resultCode, data));
            this.launchedKeys.remove(key);
            return;
        }
        this.pendingResults.putParcelable(key, new ActivityResult(resultCode, data));
    }

    private final int generateRandomNumber() {
        int iNextInt = this.random.nextInt(2147418112);
        while (true) {
            int i = iNextInt + 65536;
            if (!this.requestCodeToKey.containsKey(Integer.valueOf(i))) {
                return i;
            }
            iNextInt = this.random.nextInt(2147418112);
        }
    }

    /* JADX INFO: compiled from: AppContextActivityResultRegistry.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B?\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bHÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nHÆ\u0003JS\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$CallbacksAndContract;", "I", "Ljava/io/Serializable;", "O", "", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "mainCallback", "Landroidx/activity/result/ActivityResultCallback;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "<init>", "(Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;Landroidx/activity/result/ActivityResultCallback;Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;)V", "getFallbackCallback", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "getMainCallback", "()Landroidx/activity/result/ActivityResultCallback;", "getContract", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class CallbacksAndContract<I extends Serializable, O> {
        private final AppContextActivityResultContract<I, O> contract;
        private final AppContextActivityResultFallbackCallback<I, O> fallbackCallback;
        private final ActivityResultCallback<O> mainCallback;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CallbacksAndContract copy$default(CallbacksAndContract callbacksAndContract, AppContextActivityResultFallbackCallback appContextActivityResultFallbackCallback, ActivityResultCallback activityResultCallback, AppContextActivityResultContract appContextActivityResultContract, int i, Object obj) {
            if ((i & 1) != 0) {
                appContextActivityResultFallbackCallback = callbacksAndContract.fallbackCallback;
            }
            if ((i & 2) != 0) {
                activityResultCallback = callbacksAndContract.mainCallback;
            }
            if ((i & 4) != 0) {
                appContextActivityResultContract = callbacksAndContract.contract;
            }
            return callbacksAndContract.copy(appContextActivityResultFallbackCallback, activityResultCallback, appContextActivityResultContract);
        }

        public final AppContextActivityResultFallbackCallback<I, O> component1() {
            return this.fallbackCallback;
        }

        public final ActivityResultCallback<O> component2() {
            return this.mainCallback;
        }

        public final AppContextActivityResultContract<I, O> component3() {
            return this.contract;
        }

        public final CallbacksAndContract<I, O> copy(AppContextActivityResultFallbackCallback<I, O> fallbackCallback, ActivityResultCallback<O> mainCallback, AppContextActivityResultContract<I, O> contract) {
            Intrinsics.checkNotNullParameter(fallbackCallback, "fallbackCallback");
            Intrinsics.checkNotNullParameter(contract, "contract");
            return new CallbacksAndContract<>(fallbackCallback, mainCallback, contract);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallbacksAndContract)) {
                return false;
            }
            CallbacksAndContract callbacksAndContract = (CallbacksAndContract) other;
            return Intrinsics.areEqual(this.fallbackCallback, callbacksAndContract.fallbackCallback) && Intrinsics.areEqual(this.mainCallback, callbacksAndContract.mainCallback) && Intrinsics.areEqual(this.contract, callbacksAndContract.contract);
        }

        public int hashCode() {
            int iHashCode = this.fallbackCallback.hashCode() * 31;
            ActivityResultCallback<O> activityResultCallback = this.mainCallback;
            return ((iHashCode + (activityResultCallback == null ? 0 : activityResultCallback.hashCode())) * 31) + this.contract.hashCode();
        }

        public String toString() {
            return "CallbacksAndContract(fallbackCallback=" + this.fallbackCallback + ", mainCallback=" + this.mainCallback + ", contract=" + this.contract + ")";
        }

        public CallbacksAndContract(AppContextActivityResultFallbackCallback<I, O> fallbackCallback, ActivityResultCallback<O> activityResultCallback, AppContextActivityResultContract<I, O> contract) {
            Intrinsics.checkNotNullParameter(fallbackCallback, "fallbackCallback");
            Intrinsics.checkNotNullParameter(contract, "contract");
            this.fallbackCallback = fallbackCallback;
            this.mainCallback = activityResultCallback;
            this.contract = contract;
        }

        public final AppContextActivityResultFallbackCallback<I, O> getFallbackCallback() {
            return this.fallbackCallback;
        }

        public final ActivityResultCallback<O> getMainCallback() {
            return this.mainCallback;
        }

        public final AppContextActivityResultContract<I, O> getContract() {
            return this.contract;
        }
    }

    /* JADX INFO: compiled from: AppContextActivityResultRegistry.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "observers", "Ljava/util/ArrayList;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "clearObservers", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LifecycleContainer {
        private final Lifecycle lifecycle;
        private final ArrayList<LifecycleEventObserver> observers;

        public LifecycleContainer(Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
            this.observers = new ArrayList<>();
        }

        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        public final void addObserver(LifecycleEventObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.lifecycle.addObserver(observer);
            this.observers.add(observer);
        }

        public final void clearObservers() {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                this.lifecycle.removeObserver((LifecycleEventObserver) it.next());
            }
            this.observers.clear();
        }
    }
}
