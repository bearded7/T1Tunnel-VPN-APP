package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidInfoHelpers.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0015\u001a\u00020\u0005H\u0007J \u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/modules/systeminfo/AndroidInfoHelpers;", "", "<init>", "()V", "EMULATOR_LOCALHOST", "", "GENYMOTION_LOCALHOST", "DEVICE_LOCALHOST", "METRO_HOST_PROP_NAME", "TAG", "kotlin.jvm.PlatformType", "metroHostPropValue", "isRunningOnGenymotion", "", "isRunningOnStockEmulator", "getServerHost", "port", "", "context", "Landroid/content/Context;", "getAdbReverseTcpCommand", "getFriendlyDeviceName", "getInspectorHostMetadata", "", "applicationContext", "getReactNativeVersionString", "getDevServerPort", "getServerIpAddress", "getDevServerNetworkIpAndPort", "getDevServerNetworkIpAndPort$ReactAndroid_release", "getMetroHostPropValue", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidInfoHelpers {
    public static final String DEVICE_LOCALHOST = "localhost";
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static final String METRO_HOST_PROP_NAME = "metro.host";
    private static String metroHostPropValue;
    public static final AndroidInfoHelpers INSTANCE = new AndroidInfoHelpers();
    private static final String TAG = "AndroidInfoHelpers";

    private AndroidInfoHelpers() {
    }

    private final boolean isRunningOnGenymotion() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        return StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "vbox", false, 2, (Object) null);
    }

    private final boolean isRunningOnStockEmulator() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "generic", false, 2, (Object) null)) {
            return true;
        }
        String FINGERPRINT2 = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
        return StringsKt.startsWith$default(FINGERPRINT2, "google/sdk_gphone", false, 2, (Object) null);
    }

    @JvmStatic
    public static final String getServerHost(int port) {
        return INSTANCE.getServerIpAddress(null, port);
    }

    @JvmStatic
    public static final String getServerHost(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AndroidInfoHelpers androidInfoHelpers = INSTANCE;
        return androidInfoHelpers.getServerIpAddress(context, androidInfoHelpers.getDevServerPort(context));
    }

    @JvmStatic
    public static final String getServerHost(Context context, int port) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getServerIpAddress(context, port);
    }

    @JvmStatic
    public static final String getAdbReverseTcpCommand(int port) {
        return "adb reverse tcp:" + port + " tcp:" + port;
    }

    @JvmStatic
    public static final String getAdbReverseTcpCommand(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getAdbReverseTcpCommand(INSTANCE.getDevServerPort(context));
    }

    @JvmStatic
    public static final String getFriendlyDeviceName() {
        if (INSTANCE.isRunningOnGenymotion()) {
            String str = Build.MODEL;
            Intrinsics.checkNotNull(str);
            return str;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    @JvmStatic
    public static final Map<String, String> getInspectorHostMetadata(Context applicationContext) {
        String packageName;
        String string;
        if (applicationContext != null) {
            ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
            int i = applicationInfo.labelRes;
            packageName = applicationContext.getPackageName();
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = applicationContext.getString(i);
                Intrinsics.checkNotNull(string);
            }
        } else {
            packageName = null;
            string = null;
        }
        return MapsKt.mapOf(TuplesKt.to("appDisplayName", string), TuplesKt.to("appIdentifier", packageName), TuplesKt.to("platform", "android"), TuplesKt.to("deviceName", Build.MODEL), TuplesKt.to("reactNativeVersion", INSTANCE.getReactNativeVersionString()));
    }

    private final String getReactNativeVersionString() {
        String str;
        Map<String, Object> map = ReactNativeVersion.VERSION;
        Object obj = map.get("major");
        Object obj2 = map.get("minor");
        Object obj3 = map.get("patch");
        Object obj4 = map.get("prerelease");
        if (obj4 == null || (str = "-" + obj4) == null) {
            str = "";
        }
        return obj + "." + obj2 + "." + obj3 + str;
    }

    private final int getDevServerPort(Context context) {
        return context.getResources().getInteger(R.integer.react_native_dev_server_port);
    }

    private final String getServerIpAddress(Context context, int port) {
        String metroHostPropValue2;
        if (getMetroHostPropValue().length() > 0) {
            metroHostPropValue2 = getMetroHostPropValue();
        } else if (isRunningOnGenymotion()) {
            metroHostPropValue2 = GENYMOTION_LOCALHOST;
        } else {
            metroHostPropValue2 = isRunningOnStockEmulator() ? EMULATOR_LOCALHOST : DEVICE_LOCALHOST;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s:%d", Arrays.copyOf(new Object[]{metroHostPropValue2, Integer.valueOf(port)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String getDevServerNetworkIpAndPort$ReactAndroid_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getString(R.string.react_native_dev_server_ip) + ":" + getDevServerPort(context);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085 A[Catch: all -> 0x008e, TRY_ENTER, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0005, B:18:0x0047, B:20:0x004c, B:37:0x007a, B:34:0x0074, B:44:0x0085, B:46:0x008a, B:47:0x008d), top: B:54:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x008a A[Catch: all -> 0x008e, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0005, B:18:0x0047, B:20:0x004c, B:37:0x007a, B:34:0x0074, B:44:0x0085, B:46:0x008a, B:47:0x008d), top: B:54:0x0001 }] */
    private final synchronized String getMetroHostPropValue() {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        Exception e;
        String str;
        String str2 = metroHostPropValue;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", METRO_HOST_PROP_NAME});
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), Charset.forName("UTF-8")));
                String str3 = "";
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            str3 = line == null ? "" : line;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (processExec != null) {
                                processExec.destroy();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        FLog.w(TAG, "Failed to query for metro.host prop:", e);
                        metroHostPropValue = "";
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (processExec != null) {
                        }
                        str = metroHostPropValue;
                        if (str == null) {
                            str = "";
                        }
                        return str;
                    }
                }
                metroHostPropValue = str3;
                bufferedReader.close();
                if (processExec != null) {
                    processExec.destroy();
                }
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (processExec != null) {
                    processExec.destroy();
                }
                throw th;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
            processExec = null;
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            processExec = null;
        }
        str = metroHostPropValue;
        if (str == null) {
            str = "";
        }
        return str;
    }
}
