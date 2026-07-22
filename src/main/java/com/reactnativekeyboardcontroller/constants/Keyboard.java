package com.reactnativekeyboardcontroller.constants;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: Keyboard.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/reactnativekeyboardcontroller/constants/Keyboard;", "", "<init>", "()V", "IS_ANIMATION_EMULATED", "", "getIS_ANIMATION_EMULATED", "()Z", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Keyboard {
    public static final Keyboard INSTANCE = new Keyboard();
    private static final boolean IS_ANIMATION_EMULATED;

    private Keyboard() {
    }

    static {
        IS_ANIMATION_EMULATED = Build.VERSION.SDK_INT < 30;
    }

    public final boolean getIS_ANIMATION_EMULATED() {
        return IS_ANIMATION_EMULATED;
    }
}
