package expo.modules.kotlin.edgeToEdge;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgeToEdgePackage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0003\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0002\u001aX\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0006\b\u0000\u0010\u0006\u0018\u00012\u0006\u0010\u0007\u001a\u00020\b26\u0010\t\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b0\n\"\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0082\b¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getEnforceContrastFromTheme", "", "Landroid/app/Activity;", "enforceNavigationBarContrastFromTheme", "", "invokeWindowUtilKtMethod", ExifInterface.GPS_DIRECTION_TRUE, "methodName", "", "args", "", "Lkotlin/Pair;", "Ljava/lang/Class;", "", "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EdgeToEdgePackageKt {
    private static final boolean getEnforceContrastFromTheme(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.enforceNavigationBarContrast});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return typedArrayObtainStyledAttributes.getBoolean(0, true);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enforceNavigationBarContrastFromTheme(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            activity.getWindow().setNavigationBarContrastEnforced(getEnforceContrastFromTheme(activity));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T invokeWindowUtilKtMethod(String str, Pair<? extends Class<?>, ? extends Object>... pairArr) {
        Object objM772constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName("com.facebook.react.views.view.WindowUtilKt");
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair<? extends Class<?>, ? extends Object> pair : pairArr) {
                arrayList.add(pair.getFirst());
            }
            ArrayList arrayList2 = arrayList;
            Class[] clsArr = (Class[]) arrayList2.toArray(new Class[0]);
            ArrayList arrayList3 = new ArrayList(pairArr.length);
            for (Pair<? extends Class<?>, ? extends Object> pair2 : pairArr) {
                arrayList3.add(pair2.getSecond());
            }
            ArrayList arrayList4 = arrayList3;
            Object[] array = arrayList4.toArray(new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, Arrays.copyOf(array, array.length));
            Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
            Object obj = objInvoke;
            objM772constructorimpl = Result.m772constructorimpl(objInvoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM772constructorimpl = Result.m772constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM775exceptionOrNullimpl = Result.m775exceptionOrNullimpl(objM772constructorimpl);
        if (thM775exceptionOrNullimpl != null) {
            Log.e("EdgeToEdgePackage", "Failed to invoke '" + str + "' on com.facebook.react.views.view.WindowUtilKt", thM775exceptionOrNullimpl);
        }
        if (Result.m778isFailureimpl(objM772constructorimpl)) {
            return null;
        }
        return (T) objM772constructorimpl;
    }
}
