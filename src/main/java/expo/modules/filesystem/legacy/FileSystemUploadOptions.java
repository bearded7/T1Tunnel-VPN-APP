package expo.modules.filesystem.legacy;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010+\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0004HÖ\u0001R*\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u001fR*\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013¨\u00063"}, d2 = {"Lexpo/modules/filesystem/legacy/FileSystemUploadOptions;", "Lexpo/modules/kotlin/records/Record;", "headers", "", "", "httpMethod", "Lexpo/modules/filesystem/legacy/HttpMethod;", "sessionType", "Lexpo/modules/filesystem/legacy/SessionType;", "uploadType", "Lexpo/modules/filesystem/legacy/FileSystemUploadType;", "fieldName", "mimeType", "parameters", "<init>", "(Ljava/util/Map;Lexpo/modules/filesystem/legacy/HttpMethod;Lexpo/modules/filesystem/legacy/SessionType;Lexpo/modules/filesystem/legacy/FileSystemUploadType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getHeaders$annotations", "()V", "getHeaders", "()Ljava/util/Map;", "getHttpMethod$annotations", "getHttpMethod", "()Lexpo/modules/filesystem/legacy/HttpMethod;", "getSessionType$annotations", "getSessionType", "()Lexpo/modules/filesystem/legacy/SessionType;", "getUploadType$annotations", "getUploadType", "()Lexpo/modules/filesystem/legacy/FileSystemUploadType;", "getFieldName$annotations", "getFieldName", "()Ljava/lang/String;", "getMimeType$annotations", "getMimeType", "getParameters$annotations", "getParameters", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FileSystemUploadOptions implements Record {
    private final String fieldName;
    private final Map<String, String> headers;
    private final HttpMethod httpMethod;
    private final String mimeType;
    private final Map<String, String> parameters;
    private final SessionType sessionType;
    private final FileSystemUploadType uploadType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileSystemUploadOptions copy$default(FileSystemUploadOptions fileSystemUploadOptions, Map map, HttpMethod httpMethod, SessionType sessionType, FileSystemUploadType fileSystemUploadType, String str, String str2, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = fileSystemUploadOptions.headers;
        }
        if ((i & 2) != 0) {
            httpMethod = fileSystemUploadOptions.httpMethod;
        }
        if ((i & 4) != 0) {
            sessionType = fileSystemUploadOptions.sessionType;
        }
        if ((i & 8) != 0) {
            fileSystemUploadType = fileSystemUploadOptions.uploadType;
        }
        if ((i & 16) != 0) {
            str = fileSystemUploadOptions.fieldName;
        }
        if ((i & 32) != 0) {
            str2 = fileSystemUploadOptions.mimeType;
        }
        if ((i & 64) != 0) {
            map2 = fileSystemUploadOptions.parameters;
        }
        String str3 = str2;
        Map map3 = map2;
        String str4 = str;
        SessionType sessionType2 = sessionType;
        return fileSystemUploadOptions.copy(map, httpMethod, sessionType2, fileSystemUploadType, str4, str3, map3);
    }

    @Field
    public static /* synthetic */ void getFieldName$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeaders$annotations() {
    }

    @Field
    public static /* synthetic */ void getHttpMethod$annotations() {
    }

    @Field
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @Field
    public static /* synthetic */ void getParameters$annotations() {
    }

    @Field
    public static /* synthetic */ void getSessionType$annotations() {
    }

    @Field
    public static /* synthetic */ void getUploadType$annotations() {
    }

    public final Map<String, String> component1() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SessionType getSessionType() {
        return this.sessionType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final FileSystemUploadType getUploadType() {
        return this.uploadType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFieldName() {
        return this.fieldName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final Map<String, String> component7() {
        return this.parameters;
    }

    public final FileSystemUploadOptions copy(Map<String, String> headers, HttpMethod httpMethod, SessionType sessionType, FileSystemUploadType uploadType, String fieldName, String mimeType, Map<String, String> parameters) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(uploadType, "uploadType");
        return new FileSystemUploadOptions(headers, httpMethod, sessionType, uploadType, fieldName, mimeType, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileSystemUploadOptions)) {
            return false;
        }
        FileSystemUploadOptions fileSystemUploadOptions = (FileSystemUploadOptions) other;
        return Intrinsics.areEqual(this.headers, fileSystemUploadOptions.headers) && this.httpMethod == fileSystemUploadOptions.httpMethod && this.sessionType == fileSystemUploadOptions.sessionType && this.uploadType == fileSystemUploadOptions.uploadType && Intrinsics.areEqual(this.fieldName, fileSystemUploadOptions.fieldName) && Intrinsics.areEqual(this.mimeType, fileSystemUploadOptions.mimeType) && Intrinsics.areEqual(this.parameters, fileSystemUploadOptions.parameters);
    }

    public int hashCode() {
        Map<String, String> map = this.headers;
        int iHashCode = (((((((map == null ? 0 : map.hashCode()) * 31) + this.httpMethod.hashCode()) * 31) + this.sessionType.hashCode()) * 31) + this.uploadType.hashCode()) * 31;
        String str = this.fieldName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mimeType;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map2 = this.parameters;
        return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "FileSystemUploadOptions(headers=" + this.headers + ", httpMethod=" + this.httpMethod + ", sessionType=" + this.sessionType + ", uploadType=" + this.uploadType + ", fieldName=" + this.fieldName + ", mimeType=" + this.mimeType + ", parameters=" + this.parameters + ")";
    }

    public FileSystemUploadOptions(Map<String, String> map, HttpMethod httpMethod, SessionType sessionType, FileSystemUploadType uploadType, String str, String str2, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(uploadType, "uploadType");
        this.headers = map;
        this.httpMethod = httpMethod;
        this.sessionType = sessionType;
        this.uploadType = uploadType;
        this.fieldName = str;
        this.mimeType = str2;
        this.parameters = map2;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public /* synthetic */ FileSystemUploadOptions(Map map, HttpMethod httpMethod, SessionType sessionType, FileSystemUploadType fileSystemUploadType, String str, String str2, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? HttpMethod.POST : httpMethod, (i & 4) != 0 ? SessionType.BACKGROUND : sessionType, fileSystemUploadType, str, str2, map2);
    }

    public final SessionType getSessionType() {
        return this.sessionType;
    }

    public final FileSystemUploadType getUploadType() {
        return this.uploadType;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }
}
