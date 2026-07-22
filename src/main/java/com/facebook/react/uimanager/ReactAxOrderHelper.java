package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactAxOrderHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fJ/\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000e2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/uimanager/ReactAxOrderHelper;", "", "<init>", "()V", "cleanUpAxOrder", "", "host", "Landroid/view/ViewGroup;", "restoreFocusability", "disableFocusForSubtree", "view", "axOrderList", "", "buildAxOrderList", "Landroid/view/View;", "result", "", "(Landroid/view/View;Ljava/util/List;[Landroid/view/View;)V", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactAxOrderHelper {
    public static final ReactAxOrderHelper INSTANCE = new ReactAxOrderHelper();

    private ReactAxOrderHelper() {
    }

    private static final void cleanUpAxOrder$traverse(View view) {
        Boolean bool = (Boolean) view.getTag(R.id.original_focusability);
        if (bool != null) {
            view.setFocusable(bool.booleanValue());
        }
        if (((View) view.getTag(R.id.accessibility_order_parent)) != null) {
            view.setTag(R.id.accessibility_order_parent, null);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                cleanUpAxOrder$traverse(childAt);
            }
        }
    }

    @JvmStatic
    public static final void cleanUpAxOrder(ViewGroup host) {
        Intrinsics.checkNotNullParameter(host, "host");
        int childCount = host.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = host.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            cleanUpAxOrder$traverse(childAt);
        }
    }

    private static final void restoreFocusability$traverse$0(View view) {
        Boolean bool = (Boolean) view.getTag(R.id.original_focusability);
        if (bool != null) {
            view.setFocusable(bool.booleanValue());
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                restoreFocusability$traverse$0(childAt);
            }
        }
    }

    @JvmStatic
    public static final void restoreFocusability(ViewGroup host) {
        Intrinsics.checkNotNullParameter(host, "host");
        int childCount = host.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = host.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            restoreFocusability$traverse$0(childAt);
        }
    }

    private static final void disableFocusForSubtree$traverse$1(List<?> list, View view) {
        if (!CollectionsKt.contains(list, view.getTag(R.id.view_tag_native_id))) {
            if (view.getTag(R.id.original_focusability) == null) {
                view.setTag(R.id.original_focusability, Boolean.valueOf(view.isFocusable()));
            }
            view.setFocusable(false);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                disableFocusForSubtree$traverse$1(list, childAt);
            }
        }
    }

    public final void disableFocusForSubtree(ViewGroup view, List<?> axOrderList) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(axOrderList, "axOrderList");
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = view.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            disableFocusForSubtree$traverse$1(axOrderList, childAt);
        }
    }

    public final void buildAxOrderList(View view, List<?> axOrderList, View[] result) {
        int iIndexOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(axOrderList, "axOrderList");
        Intrinsics.checkNotNullParameter(result, "result");
        Object tag = view.getTag(R.id.view_tag_native_id);
        view.setTag(R.id.accessibility_order_parent, this);
        if (CollectionsKt.contains(axOrderList, tag) && (iIndexOf = CollectionsKt.indexOf((List<? extends Object>) axOrderList, tag)) != -1) {
            result[iIndexOf] = view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                buildAxOrderList(childAt, axOrderList, result);
            }
        }
    }
}
