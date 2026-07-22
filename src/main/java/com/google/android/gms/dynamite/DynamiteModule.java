package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy zza = new zzl();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface VersionPolicy {

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ef A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TRY_ENTER, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01f8 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0201 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:107:0x020a A[Catch: all -> 0x0213, TRY_ENTER, TryCatch #0 {, blocks: (B:34:0x00ac, B:36:0x00b2, B:37:0x00b4, B:107:0x020a, B:108:0x0212), top: B:156:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0288 A[Catch: all -> 0x02c7, TryCatch #3 {all -> 0x02c7, blocks: (B:7:0x0046, B:11:0x0078, B:16:0x0080, B:19:0x0086, B:31:0x00a7, B:113:0x0217, B:114:0x0222, B:116:0x0224, B:118:0x0226, B:119:0x022e, B:121:0x0230, B:123:0x024e, B:125:0x025b, B:135:0x027f, B:136:0x0287, B:137:0x0288, B:138:0x029a, B:139:0x029b, B:140:0x02c6), top: B:158:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x0086 A[Catch: all -> 0x02c7, TRY_LEAVE, TryCatch #3 {all -> 0x02c7, blocks: (B:7:0x0046, B:11:0x0078, B:16:0x0080, B:19:0x0086, B:31:0x00a7, B:113:0x0217, B:114:0x0222, B:116:0x0224, B:118:0x0226, B:119:0x022e, B:121:0x0230, B:123:0x024e, B:125:0x025b, B:135:0x027f, B:136:0x0287, B:137:0x0288, B:138:0x029a, B:139:0x029b, B:140:0x02c6), top: B:158:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x008e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0092  */
    /* JADX WARN: Code duplicated, block: B:26:0x009d  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2 A[Catch: all -> 0x0213, TryCatch #0 {, blocks: (B:34:0x00ac, B:36:0x00b2, B:37:0x00b4, B:107:0x020a, B:108:0x0212), top: B:156:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b7 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TRY_ENTER, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00be A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00df A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TRY_ENTER, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0155 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0161 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0180 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0187 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:83:0x018f A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:84:0x019e A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x01a9 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01b9 A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01ce A[Catch: all -> 0x0216, LoadingException -> 0x0223, RemoteException -> 0x0225, TRY_LEAVE, TryCatch #9 {RemoteException -> 0x0225, LoadingException -> 0x0223, all -> 0x0216, blocks: (B:33:0x00ab, B:39:0x00b7, B:41:0x00be, B:42:0x00d9, B:46:0x00df, B:48:0x00e7, B:50:0x00eb, B:51:0x00f6, B:58:0x0103, B:60:0x0109, B:62:0x0130, B:64:0x0138, B:65:0x013f, B:66:0x0148, B:61:0x011d, B:69:0x014b, B:70:0x014c, B:71:0x0154, B:72:0x0155, B:73:0x015d, B:76:0x0160, B:77:0x0161, B:79:0x0180, B:81:0x0187, B:83:0x018f, B:89:0x01c8, B:91:0x01ce, B:101:0x01ef, B:102:0x01f7, B:84:0x019e, B:85:0x01a6, B:87:0x01a9, B:88:0x01b9, B:103:0x01f8, B:104:0x0200, B:105:0x0201, B:106:0x0209, B:111:0x0215), top: B:167:0x00ab }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:95:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e8  */
    /* JADX WARN: Instruction removed from duplicated block: B:137:0x0288, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:41:0x00be, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x0161, please report this as an issue */
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws Throwable {
        long j;
        long j2;
        int i;
        Boolean bool;
        zzq zzqVarZzg;
        int iZze;
        IObjectWrapper iObjectWrapperZzh;
        Object objUnwrap;
        DynamiteModule dynamiteModule;
        zzn zznVar;
        Cursor cursor;
        zzr zzrVar;
        zzn zznVar2;
        Boolean boolValueOf;
        IObjectWrapper iObjectWrapperZze;
        Cursor cursor2;
        ThreadLocal threadLocal = zzg;
        zzn zznVar3 = (zzn) threadLocal.get();
        zzp zzpVar = null;
        zzn zznVar4 = new zzn(null);
        threadLocal.set(zznVar4);
        ThreadLocal threadLocal2 = zzh;
        long jLongValue = ((Long) threadLocal2.get()).longValue();
        try {
            j2 = 0;
            try {
                threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
                VersionPolicy.SelectionResult selectionResultSelectModule = versionPolicy.selectModule(context, str, zzi);
                int i2 = selectionResultSelectModule.localVersion;
                j = jLongValue;
                try {
                    Log.i("DynamiteModule", "Considering local module " + str + ":" + i2 + " and remote module " + str + ":" + selectionResultSelectModule.remoteVersion);
                    int i3 = selectionResultSelectModule.selection;
                    if (i3 != 0) {
                        if (i3 != -1) {
                            if (i3 == 1 || selectionResultSelectModule.remoteVersion != 0) {
                                if (i3 == -1) {
                                    DynamiteModule dynamiteModuleZzc = zzc(context, str);
                                    if (j == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(Long.valueOf(j));
                                    }
                                    cursor2 = zznVar4.zza;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    threadLocal.set(zznVar3);
                                    return dynamiteModuleZzc;
                                }
                                if (i3 == 1) {
                                    throw new LoadingException("VersionPolicy returned invalid code:" + i3, null);
                                }
                                try {
                                    i = selectionResultSelectModule.remoteVersion;
                                    try {
                                        synchronized (DynamiteModule.class) {
                                            if (zzf(context)) {
                                                throw new LoadingException("Remote loading disabled", null);
                                            }
                                            bool = zzb;
                                        }
                                        if (bool != null) {
                                            throw new LoadingException("Failed to determine which loading route to use.", null);
                                        }
                                        if (bool.booleanValue()) {
                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                            synchronized (DynamiteModule.class) {
                                                zzrVar = zzl;
                                            }
                                            if (zzrVar != null) {
                                                throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                            }
                                            zznVar2 = (zzn) threadLocal.get();
                                            if (zznVar2 != null || zznVar2.zza == null) {
                                                throw new LoadingException("No result cursor", null);
                                            }
                                            Context applicationContext = context.getApplicationContext();
                                            Cursor cursor3 = zznVar2.zza;
                                            ObjectWrapper.wrap(null);
                                            synchronized (DynamiteModule.class) {
                                                boolValueOf = Boolean.valueOf(zze >= 2);
                                            }
                                            if (boolValueOf.booleanValue()) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                iObjectWrapperZze = zzrVar.zzf(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor3));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                iObjectWrapperZze = zzrVar.zze(ObjectWrapper.wrap(applicationContext), str, i, ObjectWrapper.wrap(cursor3));
                                            }
                                            Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapperZze);
                                            if (context2 == null) {
                                                throw new LoadingException("Failed to get module context", zzpVar);
                                            }
                                            dynamiteModule = new DynamiteModule(context2);
                                        } else {
                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                            zzqVarZzg = zzg(context);
                                            if (zzqVarZzg != null) {
                                                throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                            }
                                            iZze = zzqVarZzg.zze();
                                            if (iZze >= 3) {
                                                zznVar = (zzn) threadLocal.get();
                                                if (zznVar != null) {
                                                    throw new LoadingException("No cached result cursor holder", null);
                                                }
                                                iObjectWrapperZzh = zzqVarZzg.zzi(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(zznVar.zza));
                                            } else if (iZze == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                iObjectWrapperZzh = zzqVarZzg.zzj(ObjectWrapper.wrap(context), str, i);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                iObjectWrapperZzh = zzqVarZzg.zzh(ObjectWrapper.wrap(context), str, i);
                                            }
                                            objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                            if (objUnwrap != null) {
                                                throw new LoadingException("Failed to load remote module.", null);
                                            }
                                            dynamiteModule = new DynamiteModule((Context) objUnwrap);
                                        }
                                        if (j == 0) {
                                            threadLocal2.remove();
                                        } else {
                                            threadLocal2.set(Long.valueOf(j));
                                        }
                                        cursor = zznVar4.zza;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        threadLocal.set(zznVar3);
                                        return dynamiteModule;
                                    } catch (RemoteException e) {
                                        throw new LoadingException("Failed to load remote module.", e, null);
                                    } catch (LoadingException e2) {
                                        throw e2;
                                    } catch (Throwable th) {
                                        CrashUtils.addDynamiteErrorToDropBox(context, th);
                                        throw new LoadingException("Failed to load remote module.", th, null);
                                    }
                                } catch (LoadingException e3) {
                                    Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                                    int i4 = selectionResultSelectModule.localVersion;
                                    if (i4 == 0 || versionPolicy.selectModule(context, str, new zzo(i4, 0)).selection != -1) {
                                        throw new LoadingException("Remote load failed. No local fallback found.", e3, null);
                                    }
                                    DynamiteModule dynamiteModuleZzc2 = zzc(context, str);
                                    if (j == 0) {
                                        zzh.remove();
                                    } else {
                                        zzh.set(Long.valueOf(j));
                                    }
                                    Cursor cursor4 = zznVar4.zza;
                                    if (cursor4 != null) {
                                        cursor4.close();
                                    }
                                    zzg.set(zznVar3);
                                    return dynamiteModuleZzc2;
                                }
                            }
                        } else if (selectionResultSelectModule.localVersion != 0) {
                            i3 = -1;
                            if (i3 == 1) {
                            }
                            if (i3 == -1) {
                                DynamiteModule dynamiteModuleZzc3 = zzc(context, str);
                                if (j == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(Long.valueOf(j));
                                }
                                cursor2 = zznVar4.zza;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                threadLocal.set(zznVar3);
                                return dynamiteModuleZzc3;
                            }
                            if (i3 == 1) {
                                throw new LoadingException("VersionPolicy returned invalid code:" + i3, null);
                            }
                            i = selectionResultSelectModule.remoteVersion;
                            synchronized (DynamiteModule.class) {
                                if (zzf(context)) {
                                    throw new LoadingException("Remote loading disabled", null);
                                }
                                bool = zzb;
                                if (bool != null) {
                                    throw new LoadingException("Failed to determine which loading route to use.", null);
                                }
                                if (bool.booleanValue()) {
                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                    synchronized (DynamiteModule.class) {
                                        zzrVar = zzl;
                                        if (zzrVar != null) {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                        zznVar2 = (zzn) threadLocal.get();
                                        if (zznVar2 != null) {
                                        }
                                        throw new LoadingException("No result cursor", null);
                                    }
                                }
                                Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                zzqVarZzg = zzg(context);
                                if (zzqVarZzg != null) {
                                    throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                }
                                iZze = zzqVarZzg.zze();
                                if (iZze >= 3) {
                                    zznVar = (zzn) threadLocal.get();
                                    if (zznVar != null) {
                                        throw new LoadingException("No cached result cursor holder", null);
                                    }
                                    iObjectWrapperZzh = zzqVarZzg.zzi(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(zznVar.zza));
                                } else if (iZze == 2) {
                                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                                    iObjectWrapperZzh = zzqVarZzg.zzj(ObjectWrapper.wrap(context), str, i);
                                } else {
                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                    iObjectWrapperZzh = zzqVarZzg.zzh(ObjectWrapper.wrap(context), str, i);
                                }
                                objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                if (objUnwrap != null) {
                                    throw new LoadingException("Failed to load remote module.", null);
                                }
                                dynamiteModule = new DynamiteModule((Context) objUnwrap);
                                if (j == 0) {
                                    threadLocal2.remove();
                                } else {
                                    threadLocal2.set(Long.valueOf(j));
                                }
                                cursor = zznVar4.zza;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                threadLocal.set(zznVar3);
                                return dynamiteModule;
                            }
                        }
                    }
                    throw new LoadingException("No acceptable module " + str + " found. Local version is " + selectionResultSelectModule.localVersion + " and remote version is " + selectionResultSelectModule.remoteVersion + ".", null);
                } catch (Throwable th2) {
                    th = th2;
                    if (j == j2) {
                        zzh.remove();
                    } else {
                        zzh.set(Long.valueOf(j));
                    }
                    Cursor cursor5 = zznVar4.zza;
                    if (cursor5 != null) {
                        cursor5.close();
                    }
                    zzg.set(zznVar3);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                j = jLongValue;
            }
        } catch (Throwable th4) {
            th = th4;
            j = jLongValue;
            j2 = 0;
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:131:0x01bf */
    /* JADX WARN: Code duplicated, block: B:95:0x016a A[Catch: all -> 0x01cd, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x01cd, blocks: (B:3:0x0002, B:61:0x00db, B:63:0x00e1, B:69:0x0103, B:91:0x015b, B:95:0x016a, B:116:0x01c5, B:117:0x01c8, B:111:0x01bc, B:67:0x00e8, B:121:0x01cc, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:59:0x00d8, B:19:0x0046, B:41:0x009a, B:44:0x009d, B:52:0x00b6, B:60:0x00da, B:58:0x00bc), top: B:137:0x0002, inners: #4, #12 }] */
    public static int zza(Context context, String str, boolean z) {
        Throwable th;
        RemoteException remoteException;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                Cursor cursor2 = null;
                int iZzf = 0;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else if (classLoader != null) {
                                    try {
                                        zzd(classLoader);
                                    } catch (LoadingException unused) {
                                    }
                                    bool = Boolean.TRUE;
                                } else {
                                    if (!zzf(context)) {
                                        return 0;
                                    }
                                    if (zzd || Boolean.TRUE.equals(null)) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            int iZzb = zzb(context, str, z, true);
                                            String str2 = zzc;
                                            if (str2 != null && !str2.isEmpty()) {
                                                ClassLoader classLoaderZza = zzb.zza();
                                                if (classLoaderZza == null) {
                                                    if (Build.VERSION.SDK_INT >= 29) {
                                                        String str3 = zzc;
                                                        Preconditions.checkNotNull(str3);
                                                        classLoaderZza = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                    } else {
                                                        String str4 = zzc;
                                                        Preconditions.checkNotNull(str4);
                                                        classLoaderZza = new zzc(str4, ClassLoader.getSystemClassLoader());
                                                    }
                                                }
                                                zzd(classLoaderZza);
                                                declaredField.set(null, classLoaderZza);
                                                zzb = Boolean.TRUE;
                                                return iZzb;
                                            }
                                            return iZzb;
                                        } catch (LoadingException unused2) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        }
                                    }
                                }
                                zzb = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzb(context, str, z, false);
                    } catch (LoadingException e2) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e2.getMessage());
                        return 0;
                    }
                }
                zzq zzqVarZzg = zzg(context);
                try {
                    if (zzqVarZzg != null) {
                        try {
                            int iZze = zzqVarZzg.zze();
                            if (iZze >= 3) {
                                zzn zznVar = (zzn) zzg.get();
                                if (zznVar == null || (cursor = zznVar.zza) == null) {
                                    Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzqVarZzg.zzk(ObjectWrapper.wrap(context), str, z, ((Long) zzh.get()).longValue()));
                                    if (cursor3 != null) {
                                        try {
                                            if (cursor3.moveToFirst()) {
                                                int i = cursor3.getInt(0);
                                                cursor2 = (i <= 0 || !zze(cursor3)) ? cursor3 : null;
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                                iZzf = i;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                            }
                                        } catch (RemoteException e3) {
                                            remoteException = e3;
                                            cursor2 = cursor3;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + remoteException.getMessage());
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            cursor2 = cursor3;
                                            if (cursor2 == null) {
                                                throw th;
                                            }
                                            cursor2.close();
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                    }
                                } else {
                                    iZzf = cursor.getInt(0);
                                }
                            } else if (iZze == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iZzf = zzqVarZzg.zzg(ObjectWrapper.wrap(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iZzf = zzqVarZzg.zzf(ObjectWrapper.wrap(context), str, z);
                            }
                        } catch (RemoteException e4) {
                            remoteException = e4;
                        }
                    }
                    return iZzf;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            CrashUtils.addDynamiteErrorToDropBox(context, th5);
            throw th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:64:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    private static int zzb(Context context, String str, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception exc;
        ?? r1 = 0;
        ?? r2 = 0;
        ?? r3 = 0;
        ?? r4 = 0;
        try {
            try {
                boolean z3 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme(UriUtil.LOCAL_CONTENT_SCHEME).authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) zzh.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z4 = false;
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    zzc = cursorQuery.getString(2);
                                    int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        zze = cursorQuery.getInt(columnIndex);
                                    }
                                    int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                    if (columnIndex2 >= 0) {
                                        if (cursorQuery.getInt(columnIndex2) == 0) {
                                            z3 = false;
                                        }
                                        zzd = z3;
                                        z4 = z3;
                                    }
                                }
                                if (zze(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z2 && z4) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", r3 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i;
                        }
                    } catch (Exception e) {
                        exc = e;
                        if (exc instanceof LoadingException) {
                            throw exc;
                        }
                        throw new LoadingException("V2 version check failed", exc, r2 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r4 == true ? 1 : 0);
            } catch (Exception e2) {
                exc = e2;
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    throw th;
                }
                r1.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r1 = context;
            if (r1 != 0) {
                throw th;
            }
            r1.close();
            throw th;
        }
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder);
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zznVar = (zzn) zzg.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean zBooleanValue = false;
        if (zzf == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                zBooleanValue = true;
            }
            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
            zzf = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
            if (zBooleanValue && providerInfoResolveContentProvider != null && providerInfoResolveContentProvider.applicationInfo != null && (providerInfoResolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!zBooleanValue) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return zBooleanValue;
    }

    private static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
