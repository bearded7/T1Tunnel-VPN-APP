package com.reactnativekeyboardcontroller.interactive.interpolators;

import kotlin.Metadata;

/* JADX INFO: compiled from: IosInterpolator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/reactnativekeyboardcontroller/interactive/interpolators/IosInterpolator;", "Lcom/reactnativekeyboardcontroller/interactive/interpolators/Interpolator;", "<init>", "()V", "interpolate", "", "dy", "absoluteFingerPosition", "keyboardPosition", "offset", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IosInterpolator implements Interpolator {
    @Override // com.reactnativekeyboardcontroller.interactive.interpolators.Interpolator
    public int interpolate(int dy, int absoluteFingerPosition, int keyboardPosition, int offset) {
        if (absoluteFingerPosition <= keyboardPosition + offset || dy <= 0) {
            return dy;
        }
        return 0;
    }
}
