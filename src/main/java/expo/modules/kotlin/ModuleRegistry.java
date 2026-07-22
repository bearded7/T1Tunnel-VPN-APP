package expo.modules.kotlin;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.providers.AppContextProvider;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: ModuleRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001>B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\u0015\"\b\b\u0000\u0010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u0016¢\u0006\u0002\u0010\u0019J\u001f\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u001b\"\u00020\u0017¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\nJ\u0018\u0010!\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\nJ%\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\u0002\"\b\b\u0000\u0010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u0016¢\u0006\u0002\u0010$J$\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002\"\b\b\u0000\u0010\u0016*\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00160'J,\u0010(\u001a\u0004\u0018\u00010)\"\b\b\u0000\u0010\u0016*\u00020%2\n\u0010*\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00160'J\u0006\u0010+\u001a\u00020\u0015J\u000e\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.J!\u0010,\u001a\u00020\u0015\"\u0004\b\u0000\u0010/2\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002H/¢\u0006\u0002\u00101J/\u0010,\u001a\u00020\u0015\"\u0004\b\u0000\u0010/\"\u0004\b\u0001\u001022\u0006\u0010-\u001a\u00020.2\u0006\u00100\u001a\u0002H/2\u0006\u00103\u001a\u0002H2¢\u0006\u0002\u00104J\u0013\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000206H\u0096\u0002J\u0006\u00107\u001a\u00020\u0015J\r\u00108\u001a\u00020\u0015H\u0000¢\u0006\u0002\b9J\b\u0010:\u001a\u00020\u0015H\u0002J\b\u0010;\u001a\u00020\u0015H\u0002J(\u0010<\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.2\n\b\u0002\u00100\u001a\u0004\u0018\u00010=2\n\b\u0002\u00103\u001a\u0004\u0018\u00010=H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lexpo/modules/kotlin/ModuleRegistry;", "", "Lexpo/modules/kotlin/ModuleHolder;", "runtimeContext", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/RuntimeContext;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "registry", "", "", "getRegistry$annotations", "()V", "getRegistry", "()Ljava/util/Map;", "eventQueue", "", "Lexpo/modules/kotlin/ModuleRegistry$PostponedEvent;", "isReadyForPostingEvents", "", "register", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/modules/Module;", "module", "(Lexpo/modules/kotlin/modules/Module;)V", "modules", "", "([Lexpo/modules/kotlin/modules/Module;)V", "provider", "Lexpo/modules/kotlin/ModulesProvider;", "hasModule", "name", "getModule", "()Ljava/lang/Object;", "getModuleHolder", "(Lexpo/modules/kotlin/modules/Module;)Lexpo/modules/kotlin/ModuleHolder;", "Landroid/view/View;", "viewClass", "Ljava/lang/Class;", "getViewDefinition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "holder", "postOnCreate", "post", "eventName", "Lexpo/modules/kotlin/events/EventName;", "Sender", "sender", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;)V", "Payload", "payload", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "iterator", "", "cleanUp", "registerActivityContracts", "registerActivityContracts$expo_modules_core_release", "readyForPostingEvents", "flushTheEventQueue", "addToQueueIfNeeded", "", "PostponedEvent", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModuleRegistry implements Iterable<ModuleHolder<?>>, KMappedMarker {
    private final List<PostponedEvent> eventQueue;
    private boolean isReadyForPostingEvents;
    private final Map<String, ModuleHolder<?>> registry;
    private final WeakReference<RuntimeContext> runtimeContext;

    public static /* synthetic */ void getRegistry$annotations() {
    }

    public ModuleRegistry(WeakReference<RuntimeContext> runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        this.runtimeContext = runtimeContext;
        this.registry = new LinkedHashMap();
        this.eventQueue = new ArrayList();
    }

    public final Map<String, ModuleHolder<?>> getRegistry() {
        return this.registry;
    }

    public final <T extends Module> void register(T module) {
        Intrinsics.checkNotNullParameter(module, "module");
        Trace.beginSection("[ExpoModulesCore] " + ("ModuleRegistry.register(" + module.getClass() + ")"));
        try {
            Object obj = this.runtimeContext.get();
            if (obj == null) {
                throw new IllegalArgumentException("Cannot create a module for invalid runtime context.".toString());
            }
            module.set_runtimeContext$expo_modules_core_release((RuntimeContext) obj);
            final ModuleHolder<?> moduleHolder = new ModuleHolder<>(module);
            module.setCoroutineScopeDelegate(LazyKt.lazy(new Function0<CoroutineScope>() { // from class: expo.modules.kotlin.ModuleRegistry$register$1$2
                @Override // kotlin.jvm.functions.Function0
                public final CoroutineScope invoke() {
                    return CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName(moduleHolder.getDefinition().getName())));
                }
            }));
            getRegistry().put(moduleHolder.getName(), moduleHolder);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final ModuleRegistry register(ModulesProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Iterator<T> it = provider.getModulesList().iterator();
        while (it.hasNext()) {
            Module module = (Module) ((Class) it.next()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(module);
            register(module);
        }
        return this;
    }

    public final boolean hasModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.registry.containsKey(name);
    }

    public final Module getModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ModuleHolder<?> moduleHolder = this.registry.get(name);
        if (moduleHolder != null) {
            return moduleHolder.getModule();
        }
        return null;
    }

    public final /* synthetic */ <T> T getModule() {
        T next;
        Module module;
        Iterator<T> it = getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            module = ((ModuleHolder) next).getModule();
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        } while (!(module instanceof Object));
        ModuleHolder moduleHolder = next;
        AppContextProvider module2 = moduleHolder != null ? moduleHolder.getModule() : null;
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) module2;
    }

    public final ModuleHolder<?> getModuleHolder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.registry.get(name);
    }

    public final <T extends Module> ModuleHolder<T> getModuleHolder(T module) {
        Object next;
        Intrinsics.checkNotNullParameter(module, "module");
        Iterator<T> it = this.registry.values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((ModuleHolder) next).getModule() != module);
        if (next instanceof ModuleHolder) {
            return (ModuleHolder) next;
        }
        return null;
    }

    public final <T extends View> ModuleHolder<?> getModuleHolder(Class<T> viewClass) {
        ModuleHolder<?> moduleHolder;
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Iterator<Map.Entry<String, ModuleHolder<?>>> it = this.registry.entrySet().iterator();
        do {
            moduleHolder = null;
            if (!it.hasNext()) {
                break;
            }
            ModuleHolder<?> value = it.next().getValue();
            if (getViewDefinition(value, viewClass) != null) {
                moduleHolder = value;
            }
        } while (moduleHolder == null);
        return moduleHolder;
    }

    public final <T extends View> ViewManagerDefinition getViewDefinition(ModuleHolder<?> holder, Class<T> viewClass) {
        Object next;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Iterator<T> it = holder.getDefinition().getViewManagerDefinitions().values().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((ViewManagerDefinition) next).getViewType$expo_modules_core_release(), viewClass)) {
                return (ViewManagerDefinition) next;
            }
        }
        next = null;
        return (ViewManagerDefinition) next;
    }

    public final void postOnCreate() {
        Iterator<ModuleHolder<?>> it = iterator();
        while (it.hasNext()) {
            it.next().post(EventName.MODULE_CREATE);
        }
        registerActivityContracts$expo_modules_core_release();
        readyForPostingEvents();
        flushTheEventQueue();
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (addToQueueIfNeeded$default(this, eventName, null, null, 6, null)) {
            return;
        }
        Iterator<ModuleHolder<?>> it = iterator();
        while (it.hasNext()) {
            it.next().post(eventName);
        }
    }

    public final <Sender> void post(EventName eventName, Sender sender) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (addToQueueIfNeeded$default(this, eventName, sender, null, 4, null)) {
            return;
        }
        Iterator<ModuleHolder<?>> it = iterator();
        while (it.hasNext()) {
            it.next().post(eventName, sender);
        }
    }

    public final <Sender, Payload> void post(EventName eventName, Sender sender, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (addToQueueIfNeeded(eventName, sender, payload)) {
            return;
        }
        Iterator<ModuleHolder<?>> it = iterator();
        while (it.hasNext()) {
            it.next().post(eventName, sender, payload);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<ModuleHolder<?>> iterator() {
        return this.registry.values().iterator();
    }

    public final void cleanUp() {
        this.registry.clear();
        CoreLoggerKt.getLogger().info("✅ ModuleRegistry was destroyed");
    }

    public final void registerActivityContracts$expo_modules_core_release() {
        Iterator<ModuleHolder<?>> it = iterator();
        while (it.hasNext()) {
            it.next().registerContracts();
        }
    }

    private final void readyForPostingEvents() {
        synchronized (this) {
            this.isReadyForPostingEvents = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void flushTheEventQueue() {
        synchronized (this) {
            for (PostponedEvent postponedEvent : this.eventQueue) {
                Iterator<ModuleHolder<?>> it = iterator();
                while (it.hasNext()) {
                    postponedEvent.post(it.next());
                }
            }
            this.eventQueue.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ boolean addToQueueIfNeeded$default(ModuleRegistry moduleRegistry, EventName eventName, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            obj2 = null;
        }
        return moduleRegistry.addToQueueIfNeeded(eventName, obj, obj2);
    }

    private final boolean addToQueueIfNeeded(EventName eventName, Object sender, Object payload) {
        synchronized (this) {
            if (this.isReadyForPostingEvents) {
                return false;
            }
            this.eventQueue.add(new PostponedEvent(eventName, sender, payload));
            return true;
        }
    }

    /* JADX INFO: compiled from: ModuleRegistry.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/ModuleRegistry$PostponedEvent;", "", "eventName", "Lexpo/modules/kotlin/events/EventName;", "sender", "payload", "<init>", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "getEventName", "()Lexpo/modules/kotlin/events/EventName;", "getSender", "()Ljava/lang/Object;", "getPayload", "post", "", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class PostponedEvent {
        private final EventName eventName;
        private final Object payload;
        private final Object sender;

        public static /* synthetic */ PostponedEvent copy$default(PostponedEvent postponedEvent, EventName eventName, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                eventName = postponedEvent.eventName;
            }
            if ((i & 2) != 0) {
                obj = postponedEvent.sender;
            }
            if ((i & 4) != 0) {
                obj2 = postponedEvent.payload;
            }
            return postponedEvent.copy(eventName, obj, obj2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EventName getEventName() {
            return this.eventName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getSender() {
            return this.sender;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Object getPayload() {
            return this.payload;
        }

        public final PostponedEvent copy(EventName eventName, Object sender, Object payload) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            return new PostponedEvent(eventName, sender, payload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PostponedEvent)) {
                return false;
            }
            PostponedEvent postponedEvent = (PostponedEvent) other;
            return this.eventName == postponedEvent.eventName && Intrinsics.areEqual(this.sender, postponedEvent.sender) && Intrinsics.areEqual(this.payload, postponedEvent.payload);
        }

        public int hashCode() {
            int iHashCode = this.eventName.hashCode() * 31;
            Object obj = this.sender;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.payload;
            return iHashCode2 + (obj2 != null ? obj2.hashCode() : 0);
        }

        public String toString() {
            return "PostponedEvent(eventName=" + this.eventName + ", sender=" + this.sender + ", payload=" + this.payload + ")";
        }

        public PostponedEvent(EventName eventName, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.eventName = eventName;
            this.sender = obj;
            this.payload = obj2;
        }

        public /* synthetic */ PostponedEvent(EventName eventName, Object obj, Object obj2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(eventName, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : obj2);
        }

        public final EventName getEventName() {
            return this.eventName;
        }

        public final Object getSender() {
            return this.sender;
        }

        public final Object getPayload() {
            return this.payload;
        }

        public final void post(ModuleHolder<?> moduleHolder) {
            Object obj;
            Intrinsics.checkNotNullParameter(moduleHolder, "moduleHolder");
            Object obj2 = this.sender;
            if (obj2 != null && (obj = this.payload) != null) {
                moduleHolder.post(this.eventName, obj2, obj);
            } else if (obj2 != null) {
                moduleHolder.post(this.eventName, obj2);
            } else {
                moduleHolder.post(this.eventName);
            }
        }
    }

    public final void register(Module... modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        for (Module module : modules) {
            register(module);
        }
    }
}
