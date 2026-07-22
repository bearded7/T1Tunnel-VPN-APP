package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Inspector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082 ¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/bridge/Inspector;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "getPagesNative", "", "Lcom/facebook/react/bridge/Inspector$Page;", "()[Lcom/facebook/react/bridge/Inspector$Page;", "connectNative", "Lcom/facebook/react/bridge/Inspector$LocalConnection;", "pageId", "", "remote", "Lcom/facebook/react/bridge/Inspector$RemoteConnection;", "Page", "RemoteConnection", "LocalConnection", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Inspector {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HybridData mHybridData;

    /* JADX INFO: compiled from: Inspector.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/facebook/react/bridge/Inspector$RemoteConnection;", "", "onMessage", "", "message", "", "onDisconnect", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RemoteConnection {
        void onDisconnect();

        void onMessage(String message);
    }

    @JvmStatic
    public static final LocalConnection connect(int i, RemoteConnection remoteConnection) {
        return INSTANCE.connect(i, remoteConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native LocalConnection connectNative(int pageId, RemoteConnection remote);

    @JvmStatic
    public static final List<Page> getPages() {
        return INSTANCE.getPages();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native Page[] getPagesNative();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Inspector instance();

    private Inspector(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    /* JADX INFO: compiled from: Inspector.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/react/bridge/Inspector$Page;", "", "id", "", AlertFragment.ARG_TITLE, "", "vm", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "getTitle", "getVM", "toString", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Page {
        private final int id;
        private final String title;
        private final String vm;

        private Page(int i, String str, String str2) {
            this.id = i;
            this.title = str;
            this.vm = str2;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: getVM, reason: from getter */
        public final String getVm() {
            return this.vm;
        }

        public String toString() {
            return "Page{id=" + this.id + ", title='" + this.title + "'}";
        }
    }

    /* JADX INFO: compiled from: Inspector.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086 J\t\u0010\n\u001a\u00020\u0007H\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/bridge/Inspector$LocalConnection;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "sendMessage", "", "message", "", "disconnect", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LocalConnection {
        private final HybridData mHybridData;

        public final native void disconnect();

        public final native void sendMessage(String message);

        private LocalConnection(HybridData hybridData) {
            this.mHybridData = hybridData;
        }
    }

    /* JADX INFO: compiled from: Inspector.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\t\u0010\r\u001a\u00020\u000eH\u0083 ¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/bridge/Inspector$Companion;", "", "<init>", "()V", "getPages", "", "Lcom/facebook/react/bridge/Inspector$Page;", "connect", "Lcom/facebook/react/bridge/Inspector$LocalConnection;", "pageId", "", "remote", "Lcom/facebook/react/bridge/Inspector$RemoteConnection;", "instance", "Lcom/facebook/react/bridge/Inspector;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final Inspector instance() {
            return Inspector.instance();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<Page> getPages() {
            try {
                return ArraysKt.toList(instance().getPagesNative());
            } catch (UnsatisfiedLinkError e) {
                FLog.e(ReactConstants.TAG, "Inspector doesn't work in open source yet", e);
                return CollectionsKt.emptyList();
            }
        }

        @JvmStatic
        public final LocalConnection connect(int pageId, RemoteConnection remote) {
            Intrinsics.checkNotNullParameter(remote, "remote");
            try {
                LocalConnection localConnectionConnectNative = instance().connectNative(pageId, remote);
                if (localConnectionConnectNative != null) {
                    return localConnectionConnectNative;
                }
                throw new IllegalStateException("Can't open failed connection");
            } catch (UnsatisfiedLinkError e) {
                UnsatisfiedLinkError unsatisfiedLinkError = e;
                FLog.e(ReactConstants.TAG, "Inspector doesn't work in open source yet", unsatisfiedLinkError);
                throw new RuntimeException(unsatisfiedLinkError);
            }
        }
    }

    static {
        BridgeSoLoader.staticInit();
    }
}
