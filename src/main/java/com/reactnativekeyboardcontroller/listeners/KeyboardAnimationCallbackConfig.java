package com.reactnativekeyboardcontroller.listeners;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: KeyboardAnimationCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/reactnativekeyboardcontroller/listeners/KeyboardAnimationCallbackConfig;", "", "persistentInsetTypes", "", "deferredInsetTypes", "dispatchMode", "hasTranslucentNavigationBar", "", "<init>", "(IIIZ)V", "getPersistentInsetTypes", "()I", "getDeferredInsetTypes", "getDispatchMode", "getHasTranslucentNavigationBar", "()Z", "setHasTranslucentNavigationBar", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class KeyboardAnimationCallbackConfig {
    private final int deferredInsetTypes;
    private final int dispatchMode;
    private boolean hasTranslucentNavigationBar;
    private final int persistentInsetTypes;

    public static /* synthetic */ KeyboardAnimationCallbackConfig copy$default(KeyboardAnimationCallbackConfig keyboardAnimationCallbackConfig, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardAnimationCallbackConfig.persistentInsetTypes;
        }
        if ((i4 & 2) != 0) {
            i2 = keyboardAnimationCallbackConfig.deferredInsetTypes;
        }
        if ((i4 & 4) != 0) {
            i3 = keyboardAnimationCallbackConfig.dispatchMode;
        }
        if ((i4 & 8) != 0) {
            z = keyboardAnimationCallbackConfig.hasTranslucentNavigationBar;
        }
        return keyboardAnimationCallbackConfig.copy(i, i2, i3, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPersistentInsetTypes() {
        return this.persistentInsetTypes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDeferredInsetTypes() {
        return this.deferredInsetTypes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDispatchMode() {
        return this.dispatchMode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasTranslucentNavigationBar() {
        return this.hasTranslucentNavigationBar;
    }

    public final KeyboardAnimationCallbackConfig copy(int persistentInsetTypes, int deferredInsetTypes, int dispatchMode, boolean hasTranslucentNavigationBar) {
        return new KeyboardAnimationCallbackConfig(persistentInsetTypes, deferredInsetTypes, dispatchMode, hasTranslucentNavigationBar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardAnimationCallbackConfig)) {
            return false;
        }
        KeyboardAnimationCallbackConfig keyboardAnimationCallbackConfig = (KeyboardAnimationCallbackConfig) other;
        return this.persistentInsetTypes == keyboardAnimationCallbackConfig.persistentInsetTypes && this.deferredInsetTypes == keyboardAnimationCallbackConfig.deferredInsetTypes && this.dispatchMode == keyboardAnimationCallbackConfig.dispatchMode && this.hasTranslucentNavigationBar == keyboardAnimationCallbackConfig.hasTranslucentNavigationBar;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.persistentInsetTypes) * 31) + Integer.hashCode(this.deferredInsetTypes)) * 31) + Integer.hashCode(this.dispatchMode)) * 31) + Boolean.hashCode(this.hasTranslucentNavigationBar);
    }

    public String toString() {
        return "KeyboardAnimationCallbackConfig(persistentInsetTypes=" + this.persistentInsetTypes + ", deferredInsetTypes=" + this.deferredInsetTypes + ", dispatchMode=" + this.dispatchMode + ", hasTranslucentNavigationBar=" + this.hasTranslucentNavigationBar + ")";
    }

    public KeyboardAnimationCallbackConfig(int i, int i2, int i3, boolean z) {
        this.persistentInsetTypes = i;
        this.deferredInsetTypes = i2;
        this.dispatchMode = i3;
        this.hasTranslucentNavigationBar = z;
    }

    public /* synthetic */ KeyboardAnimationCallbackConfig(int i, int i2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 0 : i3, z);
    }

    public final int getPersistentInsetTypes() {
        return this.persistentInsetTypes;
    }

    public final int getDeferredInsetTypes() {
        return this.deferredInsetTypes;
    }

    public final int getDispatchMode() {
        return this.dispatchMode;
    }

    public final boolean getHasTranslucentNavigationBar() {
        return this.hasTranslucentNavigationBar;
    }

    public final void setHasTranslucentNavigationBar(boolean z) {
        this.hasTranslucentNavigationBar = z;
    }
}
