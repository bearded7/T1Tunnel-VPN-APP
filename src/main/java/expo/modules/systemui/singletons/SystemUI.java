package expo.modules.systemui.singletons;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemUI.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\fH\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/systemui/singletons/SystemUI;", "", "<init>", "()V", "TAG", "", "setUserInterfaceStyle", "", "style", "successCallback", "Lkotlin/Function0;", "failureCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "reason", "expo-system-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemUI {
    public static final SystemUI INSTANCE = new SystemUI();
    private static final String TAG = "SystemUI";

    private SystemUI() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r4.equals("light") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r4.equals("") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
    
        r0 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setUserInterfaceStyle(java.lang.String r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r6) {
        /*
            r3 = this;
            r0 = -1
            if (r4 != 0) goto L4
            goto L60
        L4:
            int r1 = r4.hashCode()
            if (r1 == 0) goto L3e
            r2 = 3075958(0x2eef76, float:4.310335E-39)
            if (r1 == r2) goto L33
            r2 = 102970646(0x6233516, float:3.0695894E-35)
            if (r1 == r2) goto L2a
            r2 = 1673671211(0x63c2322b, float:7.1645667E21)
            if (r1 == r2) goto L1a
            goto L46
        L1a:
            java.lang.String r1 = "automatic"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L46
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r4 >= r6) goto L60
            r0 = 3
            goto L60
        L2a:
            java.lang.String r0 = "light"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L5f
            goto L46
        L33:
            java.lang.String r0 = "dark"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L3c
            goto L46
        L3c:
            r0 = 2
            goto L60
        L3e:
            java.lang.String r0 = ""
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L5f
        L46:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid user interface style: \""
            r5.<init>(r0)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = "\""
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r6.invoke(r4)
            return
        L5f:
            r0 = 1
        L60:
            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(r0)
            r5.invoke()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.systemui.singletons.SystemUI.setUserInterfaceStyle(java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1):void");
    }

    @JvmStatic
    public static final void setUserInterfaceStyle(String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        INSTANCE.setUserInterfaceStyle(style, new Function0() { // from class: expo.modules.systemui.singletons.SystemUI$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: expo.modules.systemui.singletons.SystemUI$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SystemUI.setUserInterfaceStyle$lambda$1((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setUserInterfaceStyle$lambda$1(String m) {
        Intrinsics.checkNotNullParameter(m, "m");
        Log.e(TAG, m);
        return Unit.INSTANCE;
    }
}
