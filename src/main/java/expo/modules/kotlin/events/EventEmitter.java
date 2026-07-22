package expo.modules.kotlin.events;

import android.view.View;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventEmitter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\bH&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\tH&J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000eJ3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/events/EventEmitter;", "Lexpo/modules/core/interfaces/services/EventEmitter;", "emit", "", "eventName", "", "eventBody", "Lcom/facebook/react/bridge/WritableMap;", "Lexpo/modules/kotlin/records/Record;", "", "viewId", "", "coalescingKey", "", "(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface EventEmitter extends expo.modules.core.interfaces.services.EventEmitter {
    void emit(int viewId, String eventName, WritableMap eventBody, Short coalescingKey);

    void emit(View view, String eventName, WritableMap eventBody, Short coalescingKey);

    void emit(String eventName, WritableMap eventBody);

    void emit(String eventName, Record eventBody);

    void emit(String eventName, Map<?, ?> eventBody);

    /* JADX INFO: compiled from: EventEmitter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void emit$default(EventEmitter eventEmitter, int i, String str, WritableMap writableMap, Short sh, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emit");
            }
            if ((i2 & 8) != 0) {
                sh = null;
            }
            eventEmitter.emit(i, str, writableMap, sh);
        }

        public static /* synthetic */ void emit$default(EventEmitter eventEmitter, View view, String str, WritableMap writableMap, Short sh, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emit");
            }
            if ((i & 8) != 0) {
                sh = null;
            }
            eventEmitter.emit(view, str, writableMap, sh);
        }
    }
}
