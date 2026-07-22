package expo.modules.haptics;

import android.view.HapticFeedbackConstants;
import expo.modules.haptics.arguments.HapticTypeNotSupportedException;
import expo.modules.haptics.arguments.HapticsNotSupportedException;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: HapticsRecord.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001e"}, d2 = {"Lexpo/modules/haptics/HapticType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONFIRM", "REJECT", "GESTURE_START", "GESTURE_END", "TOGGLE_ON", "TOGGLE_OFF", "CLOCK_TICK", "CONTEXT_CLICK", "DRAG_START", "KEYBOARD_TAP", "KEYBOARD_PRESS", "KEYBOARD_RELEASE", "LONG_PRESS", "VIRTUAL_KEY", "NO_HAPTICS", "SEGMENT_TICK", "SEGMENT_FREQUENT_TICK", "TEXT_HANDLE_MOVE", "VIRTUAL_KEY_RELEASE", "toHapticFeedbackType", "", "expo-haptics_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum HapticType implements Enumerable {
    CONFIRM("confirm"),
    REJECT("reject"),
    GESTURE_START("gesture-start"),
    GESTURE_END("gesture-end"),
    TOGGLE_ON("toggle-on"),
    TOGGLE_OFF("toggle-off"),
    CLOCK_TICK("clock-tick"),
    CONTEXT_CLICK("context-click"),
    DRAG_START("drag-start"),
    KEYBOARD_TAP("keyboard-tap"),
    KEYBOARD_PRESS("keyboard-press"),
    KEYBOARD_RELEASE("keyboard-release"),
    LONG_PRESS("long-press"),
    VIRTUAL_KEY("virtual-key"),
    NO_HAPTICS("no-haptics"),
    SEGMENT_TICK("segment-tick"),
    SEGMENT_FREQUENT_TICK("segment-frequent-tick"),
    TEXT_HANDLE_MOVE("text-handle-move"),
    VIRTUAL_KEY_RELEASE("virtual-key-release");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: HapticsRecord.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HapticType.values().length];
            try {
                iArr[HapticType.CLOCK_TICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HapticType.CONTEXT_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HapticType.KEYBOARD_TAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HapticType.LONG_PRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HapticType.VIRTUAL_KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<HapticType> getEntries() {
        return $ENTRIES;
    }

    HapticType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final int toHapticFeedbackType() throws HapticTypeNotSupportedException, HapticsNotSupportedException {
        try {
            return HapticFeedbackConstants.class.getDeclaredField(name()).getInt(null);
        } catch (IllegalAccessException unused) {
            throw new HapticTypeNotSupportedException(this.value);
        } catch (NoSuchFieldException unused2) {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return 4;
            }
            if (i == 2) {
                return 6;
            }
            if (i == 3) {
                return 3;
            }
            if (i == 4) {
                return 0;
            }
            if (i == 5) {
                return 1;
            }
            throw new HapticsNotSupportedException();
        }
    }
}
