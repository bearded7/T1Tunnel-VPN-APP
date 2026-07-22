package com.facebook.react.modules.websocket;

import com.caverock.androidsvg.SVGParser;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.CustomClientBuilder;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: compiled from: WebSocketModule.kt */
/* JADX INFO: loaded from: classes.dex */
@ReactModule(name = "WebSocketModule")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 02\u00020\u0001:\u0002/0B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ,\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010$\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010)\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00122\u0006\u0010+\u001a\u00020\u0012H\u0002J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u001eH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/react/modules/websocket/WebSocketModule;", "Lcom/facebook/fbreact/specs/NativeWebSocketModuleSpec;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "webSocketConnections", "", "", "Lokhttp3/WebSocket;", "contentHandlers", "Lcom/facebook/react/modules/websocket/WebSocketModule$ContentHandler;", "cookieHandler", "Lcom/facebook/react/modules/network/ForwardingCookieHandler;", "invalidate", "", "sendEvent", "eventName", "", "params", "Lcom/facebook/react/bridge/ReadableMap;", "setContentHandler", "id", "contentHandler", "connect", ImagesContract.URL, "protocols", "Lcom/facebook/react/bridge/ReadableArray;", "options", "socketID", "", "close", "code", "reason", "send", "message", "sendBinary", "base64String", "byteString", "Lokio/ByteString;", "ping", "notifyWebSocketFailed", "getCookie", "uri", "addListener", "removeListeners", "count", "ContentHandler", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebSocketModule extends NativeWebSocketModuleSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "WebSocketModule";
    private static CustomClientBuilder customClientBuilder;
    private final Map<Integer, ContentHandler> contentHandlers;
    private final ForwardingCookieHandler cookieHandler;
    private final Map<Integer, WebSocket> webSocketConnections;

    /* JADX INFO: compiled from: WebSocketModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/websocket/WebSocketModule$ContentHandler;", "", "onMessage", "", ReactTextInputShadowNode.PROP_TEXT, "", "params", "Lcom/facebook/react/bridge/WritableMap;", "byteString", "Lokio/ByteString;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ContentHandler {
        void onMessage(String text, WritableMap params);

        void onMessage(ByteString byteString, WritableMap params);
    }

    @JvmStatic
    public static final void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        INSTANCE.setCustomClientBuilder(customClientBuilder2);
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketModule(ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.webSocketConnections = new ConcurrentHashMap();
        this.contentHandlers = new ConcurrentHashMap();
        this.cookieHandler = new ForwardingCookieHandler();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        Iterator<WebSocket> it = this.webSocketConnections.values().iterator();
        while (it.hasNext()) {
            it.next().close(1001, null);
        }
        this.webSocketConnections.clear();
        this.contentHandlers.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEvent(String eventName, ReadableMap params) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        if (reactApplicationContext.hasActiveReactInstance()) {
            reactApplicationContext.emitDeviceEvent(eventName, params);
        }
    }

    public final void setContentHandler(int id, ContentHandler contentHandler) {
        if (contentHandler != null) {
            this.contentHandlers.put(Integer.valueOf(id), contentHandler);
        } else {
            this.contentHandlers.remove(Integer.valueOf(id));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void connect(String url, ReadableArray protocols, ReadableMap options, double socketID) {
        boolean z;
        Intrinsics.checkNotNullParameter(url, "url");
        final int i = (int) socketID;
        OkHttpClient.Builder timeout = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES);
        INSTANCE.applyCustomBuilder(timeout);
        OkHttpClient okHttpClientBuild = timeout.build();
        Request.Builder builderUrl = new Request.Builder().tag(Integer.valueOf(i)).url(url);
        String cookie = getCookie(url);
        if (cookie != null) {
            builderUrl.addHeader(HttpHeaders.COOKIE, cookie);
        }
        if (options != null && options.hasKey("headers") && options.getType("headers") == ReadableType.Map) {
            ReadableMap map = options.getMap("headers");
            if (map == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            z = false;
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                if (ReadableType.String == map.getType(strNextKey)) {
                    if (StringsKt.equals(strNextKey, "origin", true)) {
                        z = true;
                    }
                    String string = map.getString(strNextKey);
                    if (string != null) {
                        builderUrl.addHeader(strNextKey, string);
                    } else {
                        throw new IllegalStateException(("value for name " + strNextKey + " == null").toString());
                    }
                } else {
                    FLog.w(ReactConstants.TAG, "Ignoring: requested " + strNextKey + ", value not a string");
                }
            }
        } else {
            z = false;
        }
        if (!z) {
            builderUrl.addHeader("origin", INSTANCE.getDefaultOrigin(url));
        }
        if (protocols != null && protocols.size() > 0) {
            StringBuilder sb = new StringBuilder("");
            int size = protocols.size();
            for (int i2 = 0; i2 < size; i2++) {
                String string2 = protocols.getString(i2);
                String string3 = string2 != null ? StringsKt.trim((CharSequence) string2).toString() : null;
                String str = string3;
                if (!(str == null || str.length() == 0) && !StringsKt.contains$default((CharSequence) str, (CharSequence) ",", false, 2, (Object) null)) {
                    sb.append(string3);
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
                String string4 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                builderUrl.addHeader(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, string4);
            }
        }
        okHttpClientBuild.newWebSocket(builderUrl.build(), new WebSocketListener() { // from class: com.facebook.react.modules.websocket.WebSocketModule.connect.2
            @Override // okhttp3.WebSocketListener
            public void onOpen(WebSocket webSocket, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(response, "response");
                WebSocketModule.this.webSocketConnections.put(Integer.valueOf(i), webSocket);
                int i3 = i;
                WritableMap writableMapCreateMap = Arguments.createMap();
                Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
                ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                readableMapBuilder.put("id", i3);
                readableMapBuilder.put("protocol", response.header(HttpHeaders.SEC_WEBSOCKET_PROTOCOL, ""));
                WebSocketModule.this.sendEvent("websocketOpen", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public void onClosing(WebSocket websocket, int code, String reason) {
                Intrinsics.checkNotNullParameter(websocket, "websocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                websocket.close(code, reason);
            }

            @Override // okhttp3.WebSocketListener
            public void onClosed(WebSocket webSocket, int code, String reason) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(reason, "reason");
                int i3 = i;
                WritableMap writableMapCreateMap = Arguments.createMap();
                Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
                ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
                readableMapBuilder.put("id", i3);
                readableMapBuilder.put("code", code);
                readableMapBuilder.put("reason", reason);
                WebSocketModule.this.sendEvent("websocketClosed", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(t, "t");
                WebSocketModule.this.notifyWebSocketFailed(i, t.getMessage());
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, String text) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(text, "text");
                WritableMap writableMapCreateMap = Arguments.createMap();
                Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
                writableMapCreateMap.putInt("id", i);
                writableMapCreateMap.putString(SVGParser.XML_STYLESHEET_ATTR_TYPE, ReactTextInputShadowNode.PROP_TEXT);
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.contentHandlers.get(Integer.valueOf(i));
                if (contentHandler != null) {
                    contentHandler.onMessage(text, writableMapCreateMap);
                } else {
                    writableMapCreateMap.putString(UriUtil.DATA_SCHEME, text);
                }
                WebSocketModule.this.sendEvent("websocketMessage", writableMapCreateMap);
            }

            @Override // okhttp3.WebSocketListener
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                Intrinsics.checkNotNullParameter(webSocket, "webSocket");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                WritableMap writableMapCreateMap = Arguments.createMap();
                Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
                writableMapCreateMap.putInt("id", i);
                writableMapCreateMap.putString(SVGParser.XML_STYLESHEET_ATTR_TYPE, "binary");
                ContentHandler contentHandler = (ContentHandler) WebSocketModule.this.contentHandlers.get(Integer.valueOf(i));
                if (contentHandler != null) {
                    contentHandler.onMessage(bytes, writableMapCreateMap);
                } else {
                    writableMapCreateMap.putString(UriUtil.DATA_SCHEME, bytes.base64());
                }
                WebSocketModule.this.sendEvent("websocketMessage", writableMapCreateMap);
            }
        });
        okHttpClientBuild.getDispatcher().m2412deprecated_executorService().shutdown();
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void close(double code, String reason, double socketID) {
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket == null) {
            return;
        }
        try {
            webSocket.close((int) code, reason);
            this.webSocketConnections.remove(Integer.valueOf(i));
            this.contentHandlers.remove(Integer.valueOf(i));
        } catch (Exception e) {
            FLog.e(ReactConstants.TAG, "Could not close WebSocket connection for id " + i, e);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void send(String message, double socketID) {
        Intrinsics.checkNotNullParameter(message, "message");
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket != null) {
            try {
                webSocket.send(message);
                return;
            } catch (Exception e) {
                notifyWebSocketFailed(i, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", i);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap2, "createMap(...)");
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", i);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i));
        this.contentHandlers.remove(Integer.valueOf(i));
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void sendBinary(String base64String, double socketID) {
        Intrinsics.checkNotNullParameter(base64String, "base64String");
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket != null) {
            try {
                ByteString byteStringM2512deprecated_decodeBase64 = ByteString.INSTANCE.m2512deprecated_decodeBase64(base64String);
                if (byteStringM2512deprecated_decodeBase64 == null) {
                    throw new IllegalStateException("bytes == null".toString());
                }
                webSocket.send(byteStringM2512deprecated_decodeBase64);
                return;
            } catch (Exception e) {
                notifyWebSocketFailed(i, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", i);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap2, "createMap(...)");
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", i);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i));
        this.contentHandlers.remove(Integer.valueOf(i));
    }

    public final void sendBinary(ByteString byteString, int id) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(id));
        if (webSocket != null) {
            try {
                webSocket.send(byteString);
                return;
            } catch (Exception e) {
                notifyWebSocketFailed(id, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", id);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap2, "createMap(...)");
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", id);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(id));
        this.contentHandlers.remove(Integer.valueOf(id));
    }

    @Override // com.facebook.fbreact.specs.NativeWebSocketModuleSpec
    public void ping(double socketID) {
        int i = (int) socketID;
        WebSocket webSocket = this.webSocketConnections.get(Integer.valueOf(i));
        if (webSocket != null) {
            try {
                webSocket.send(ByteString.EMPTY);
                return;
            } catch (Exception e) {
                notifyWebSocketFailed(i, e.getMessage());
                return;
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", i);
        readableMapBuilder.put("message", "client is null");
        sendEvent("websocketFailed", writableMapCreateMap);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap2, "createMap(...)");
        ReadableMapBuilder readableMapBuilder2 = new ReadableMapBuilder(writableMapCreateMap2);
        readableMapBuilder2.put("id", i);
        readableMapBuilder2.put("code", 0);
        readableMapBuilder2.put("reason", "client is null");
        sendEvent("websocketClosed", writableMapCreateMap2);
        this.webSocketConnections.remove(Integer.valueOf(i));
        this.contentHandlers.remove(Integer.valueOf(i));
    }

    private final String getCookie(String uri) {
        try {
            List<String> list = this.cookieHandler.get(new URI(INSTANCE.getDefaultOrigin(uri)), new HashMap()).get(HttpHeaders.COOKIE);
            List<String> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                return list.get(0);
            }
            return null;
        } catch (IOException unused) {
            throw new IllegalArgumentException("Unable to get cookie from " + uri);
        } catch (URISyntaxException unused2) {
            throw new IllegalArgumentException("Unable to get cookie from " + uri);
        }
    }

    /* JADX INFO: compiled from: WebSocketModule.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/modules/websocket/WebSocketModule$Companion;", "", "<init>", "()V", "NAME", "", "customClientBuilder", "Lcom/facebook/react/modules/network/CustomClientBuilder;", "setCustomClientBuilder", "", "ccb", "applyCustomBuilder", "builder", "Lokhttp3/OkHttpClient$Builder;", "getDefaultOrigin", "uri", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setCustomClientBuilder(CustomClientBuilder ccb) {
            WebSocketModule.customClientBuilder = ccb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void applyCustomBuilder(OkHttpClient.Builder builder) {
            CustomClientBuilder customClientBuilder = WebSocketModule.customClientBuilder;
            if (customClientBuilder != null) {
                customClientBuilder.apply(builder);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:20:0x0035 A[Catch: URISyntaxException -> 0x0094, TryCatch #0 {URISyntaxException -> 0x0094, blocks: (B:2:0x0000, B:4:0x000b, B:14:0x0027, B:20:0x0035, B:28:0x0051, B:31:0x005a, B:33:0x007b, B:17:0x002e, B:21:0x003a, B:25:0x0046), top: B:37:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x004f  */
        public final String getDefaultOrigin(String uri) {
            String scheme;
            try {
                URI uri2 = new URI(uri);
                String scheme2 = uri2.getScheme();
                if (scheme2 != null) {
                    int iHashCode = scheme2.hashCode();
                    scheme = UriUtil.HTTP_SCHEME;
                    if (iHashCode != 3804) {
                        if (iHashCode != 118039) {
                            if (iHashCode != 3213448) {
                                if (iHashCode == 99617003 && scheme2.equals(UriUtil.HTTPS_SCHEME)) {
                                    scheme = uri2.getScheme();
                                } else {
                                    scheme = "";
                                }
                            } else if (scheme2.equals(UriUtil.HTTP_SCHEME)) {
                                scheme = uri2.getScheme();
                            } else {
                                scheme = "";
                            }
                        } else if (scheme2.equals("wss")) {
                            scheme = UriUtil.HTTPS_SCHEME;
                        } else {
                            scheme = "";
                        }
                    } else if (!scheme2.equals("ws")) {
                        scheme = "";
                    }
                } else {
                    scheme = "";
                }
                if (uri2.getPort() != -1) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("%s://%s:%s", Arrays.copyOf(new Object[]{scheme, uri2.getHost(), Integer.valueOf(uri2.getPort())}, 3));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format("%s://%s", Arrays.copyOf(new Object[]{scheme, uri2.getHost()}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return str2;
            } catch (URISyntaxException unused) {
                throw new IllegalArgumentException("Unable to set " + uri + " as default origin header");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyWebSocketFailed(int id, String message) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        readableMapBuilder.put("id", id);
        readableMapBuilder.put("message", message);
        sendEvent("websocketFailed", writableMapCreateMap);
    }
}
