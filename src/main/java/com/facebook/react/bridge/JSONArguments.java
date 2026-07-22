package com.facebook.react.bridge;

import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JSONArguments.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nH\u0007¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/bridge/JSONArguments;", "", "<init>", "()V", "fromJSONObject", "Lcom/facebook/react/bridge/ReadableMap;", "obj", "Lorg/json/JSONObject;", "fromJSONObjectString", "objStr", "", "fromJSONArray", "Lcom/facebook/react/bridge/ReadableArray;", "arr", "Lorg/json/JSONArray;", "fromJSONArrayString", "arrStr", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSONArguments {
    public static final JSONArguments INSTANCE = new JSONArguments();

    private JSONArguments() {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("JSONArguments", LegacyArchitectureLogLevel.ERROR);
    }

    @JvmStatic
    public static final ReadableMap fromJSONObject(JSONObject obj) throws JSONException {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Iterator<String> itKeys = obj.keys();
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj2 = obj.get(next);
            if (obj2 instanceof JSONObject) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.put(next, fromJSONObject((JSONObject) obj2));
            } else if (obj2 instanceof JSONArray) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.put(next, fromJSONArray((JSONArray) obj2));
            } else if (obj2 instanceof String) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.put(next, (String) obj2);
            } else if (obj2 instanceof Boolean) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.put(next, ((Boolean) obj2).booleanValue());
            } else if (obj2 instanceof Integer) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.put(next, ((Number) obj2).intValue());
            } else if (obj2 instanceof Double) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.put(next, ((Number) obj2).doubleValue());
            } else if (obj2 instanceof Long) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.put(next, (int) ((Number) obj2).longValue());
            } else if (obj.isNull(next)) {
                Intrinsics.checkNotNull(next);
                readableMapBuilder.putNull(next);
            } else {
                throw new JSONException("Unexpected value when parsing JSON object. key: " + next);
            }
        }
        return writableMapCreateMap;
    }

    @JvmStatic
    public static final ReadableMap fromJSONObjectString(String objStr) throws JSONException {
        Intrinsics.checkNotNullParameter(objStr, "objStr");
        return fromJSONObject(new JSONObject(objStr));
    }

    @JvmStatic
    public static final ReadableArray fromJSONArrayString(String arrStr) throws JSONException {
        Intrinsics.checkNotNullParameter(arrStr, "arrStr");
        return fromJSONArray(new JSONArray(arrStr));
    }

    @JvmStatic
    public static final ReadableArray fromJSONArray(JSONArray arr) throws JSONException {
        Intrinsics.checkNotNullParameter(arr, "arr");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "createArray(...)");
        ReadableArrayBuilder readableArrayBuilder = new ReadableArrayBuilder(writableArrayCreateArray);
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            Object obj = arr.get(i);
            if (obj instanceof JSONObject) {
                readableArrayBuilder.add(fromJSONObject((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                readableArrayBuilder.add(fromJSONArray((JSONArray) obj));
            } else if (obj instanceof String) {
                readableArrayBuilder.add((String) obj);
            } else if (obj instanceof Boolean) {
                readableArrayBuilder.add(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                readableArrayBuilder.add(((Number) obj).intValue());
            } else if (obj instanceof Double) {
                readableArrayBuilder.add(((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                readableArrayBuilder.add((int) ((Number) obj).longValue());
            } else if (arr.isNull(i)) {
                readableArrayBuilder.addNull();
            } else {
                throw new JSONException("Unexpected value when parsing JSON array. index: " + i);
            }
        }
        return writableArrayCreateArray;
    }
}
