package expo.modules.webbrowser;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.core.interfaces.Consumer;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeferredClientActionsQueue.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0006\u0010\u0011\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lexpo/modules/webbrowser/DeferredClientActionsQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "actions", "Ljava/util/Queue;", "Lexpo/modules/core/interfaces/Consumer;", "client", "Ljava/lang/Object;", "setClient", "", "(Ljava/lang/Object;)V", "hasClient", "", "executeOrQueueAction", "action", "clear", "executeQueuedActions", "addActionToQueue", "consumer", "expo-web-browser_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeferredClientActionsQueue<T> {
    private final Queue<Consumer<T>> actions = new LinkedList();
    private T client;

    public final void setClient(T client) {
        this.client = client;
        executeQueuedActions();
    }

    public final boolean hasClient() {
        return this.client != null;
    }

    public final void executeOrQueueAction(Consumer<T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        T t = this.client;
        if (t != null) {
            action.apply(t);
        } else {
            addActionToQueue(action);
        }
    }

    public final void clear() {
        this.client = null;
        this.actions.clear();
    }

    private final void executeQueuedActions() {
        if (this.client == null) {
            return;
        }
        Consumer<T> consumerPoll = this.actions.poll();
        while (consumerPoll != null) {
            consumerPoll.apply(this.client);
            consumerPoll = this.actions.poll();
        }
    }

    private final void addActionToQueue(Consumer<T> consumer) {
        this.actions.add(consumer);
    }
}
