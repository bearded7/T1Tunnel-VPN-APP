package expo.modules.filesystem.legacy;

import android.content.Context;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FilePermissionModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0016J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0012"}, d2 = {"Lexpo/modules/filesystem/legacy/FilePermissionModule;", "Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "Lexpo/modules/core/interfaces/InternalModule;", "<init>", "()V", "getExportedInterfaces", "", "Ljava/lang/Class;", "getPathPermissions", "Ljava/util/EnumSet;", "Lexpo/modules/interfaces/filesystem/Permission;", "context", "Landroid/content/Context;", "path", "", "getInternalPathPermissions", "getExternalPathPermissions", "getInternalPaths", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FilePermissionModule implements FilePermissionModuleInterface, InternalModule {
    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(FilePermissionModuleInterface.class);
    }

    @Override // expo.modules.interfaces.filesystem.FilePermissionModuleInterface
    public EnumSet<Permission> getPathPermissions(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        EnumSet<Permission> internalPathPermissions = getInternalPathPermissions(path, context);
        return internalPathPermissions == null ? getExternalPathPermissions(path) : internalPathPermissions;
    }

    private final EnumSet<Permission> getInternalPathPermissions(String path, Context context) {
        Object next;
        String str;
        try {
            String canonicalPath = new File(path).getCanonicalPath();
            Iterator<T> it = getInternalPaths(context).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                str = (String) next;
                Intrinsics.checkNotNull(canonicalPath);
                if (StringsKt.startsWith$default(canonicalPath, str + "/", false, 2, (Object) null)) {
                    break;
                }
            } while (!Intrinsics.areEqual(str, canonicalPath));
            if (((String) next) != null) {
                return EnumSet.of(Permission.READ, Permission.WRITE);
            }
            return null;
        } catch (IOException unused) {
            return EnumSet.noneOf(Permission.class);
        }
    }

    protected EnumSet<Permission> getExternalPathPermissions(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        EnumSet<Permission> enumSetNoneOf = EnumSet.noneOf(Permission.class);
        if (file.canRead()) {
            enumSetNoneOf.add(Permission.READ);
        }
        if (file.canWrite()) {
            enumSetNoneOf.add(Permission.WRITE);
        }
        Intrinsics.checkNotNullExpressionValue(enumSetNoneOf, "apply(...)");
        return enumSetNoneOf;
    }

    private final List<String> getInternalPaths(Context context) throws IOException {
        return CollectionsKt.listOf((Object[]) new String[]{context.getFilesDir().getCanonicalPath(), context.getCacheDir().getCanonicalPath()});
    }
}
