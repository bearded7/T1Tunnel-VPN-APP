package com.facebook.react.uimanager;

import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.yoga.YogaNode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: YogaNodePool.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007R!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/facebook/react/uimanager/YogaNodePool;", "", "<init>", "()V", "pool", "Lcom/facebook/react/common/ClearableSynchronizedPool;", "Lcom/facebook/yoga/YogaNode;", "getPool", "()Lcom/facebook/react/common/ClearableSynchronizedPool;", "pool$delegate", "Lkotlin/Lazy;", "get", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class YogaNodePool {
    public static final YogaNodePool INSTANCE = new YogaNodePool();

    /* JADX INFO: renamed from: pool$delegate, reason: from kotlin metadata */
    private static final Lazy pool;

    private YogaNodePool() {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("YogaNodePool", LegacyArchitectureLogLevel.ERROR);
        pool = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.facebook.react.uimanager.YogaNodePool$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return YogaNodePool.pool_delegate$lambda$0();
            }
        });
    }

    private final ClearableSynchronizedPool<YogaNode> getPool() {
        return (ClearableSynchronizedPool) pool.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClearableSynchronizedPool pool_delegate$lambda$0() {
        return new ClearableSynchronizedPool(1024);
    }

    @JvmStatic
    public static final ClearableSynchronizedPool<YogaNode> get() {
        return INSTANCE.getPool();
    }
}
