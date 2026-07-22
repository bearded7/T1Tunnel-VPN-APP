package expo.modules.kotlin.events;

import android.content.Intent;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnActivityResultPayload.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/events/OnActivityResultPayload;", "", "requestCode", "", "resultCode", UriUtil.DATA_SCHEME, "Landroid/content/Intent;", "<init>", "(IILandroid/content/Intent;)V", "getRequestCode", "()I", "getResultCode", "getData", "()Landroid/content/Intent;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class OnActivityResultPayload {
    private final Intent data;
    private final int requestCode;
    private final int resultCode;

    public static /* synthetic */ OnActivityResultPayload copy$default(OnActivityResultPayload onActivityResultPayload, int i, int i2, Intent intent, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = onActivityResultPayload.requestCode;
        }
        if ((i3 & 2) != 0) {
            i2 = onActivityResultPayload.resultCode;
        }
        if ((i3 & 4) != 0) {
            intent = onActivityResultPayload.data;
        }
        return onActivityResultPayload.copy(i, i2, intent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRequestCode() {
        return this.requestCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Intent getData() {
        return this.data;
    }

    public final OnActivityResultPayload copy(int requestCode, int resultCode, Intent data) {
        return new OnActivityResultPayload(requestCode, resultCode, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnActivityResultPayload)) {
            return false;
        }
        OnActivityResultPayload onActivityResultPayload = (OnActivityResultPayload) other;
        return this.requestCode == onActivityResultPayload.requestCode && this.resultCode == onActivityResultPayload.resultCode && Intrinsics.areEqual(this.data, onActivityResultPayload.data);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.requestCode) * 31) + Integer.hashCode(this.resultCode)) * 31;
        Intent intent = this.data;
        return iHashCode + (intent == null ? 0 : intent.hashCode());
    }

    public String toString() {
        return "OnActivityResultPayload(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + ")";
    }

    public OnActivityResultPayload(int i, int i2, Intent intent) {
        this.requestCode = i;
        this.resultCode = i2;
        this.data = intent;
    }

    public final Intent getData() {
        return this.data;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final int getResultCode() {
        return this.resultCode;
    }
}
