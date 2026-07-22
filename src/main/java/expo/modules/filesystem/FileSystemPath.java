package expo.modules.filesystem;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import expo.modules.filesystem.unifiedfile.AssetFile;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.SAFDocumentFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: FileSystemPath.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H&J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b+\u0010)¨\u0006,"}, d2 = {"Lexpo/modules/filesystem/FileSystemPath;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "setUri", "fileAdapter", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "file", "getFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "javaFile", "Ljava/io/File;", "getJavaFile", "()Ljava/io/File;", "delete", "", "validateType", "getMoveOrCopyPath", "destination", "validatePermission", "permission", "Lexpo/modules/interfaces/filesystem/Permission;", "checkPermission", "", "validateCanCreate", "options", "Lexpo/modules/filesystem/CreateOptions;", "copy", "to", "move", "rename", "newName", "", "renamedUri", "modificationTime", "", "getModificationTime", "()Ljava/lang/Long;", "creationTime", "getCreationTime", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FileSystemPath extends SharedObject {
    private UnifiedFileInterface fileAdapter;
    private Uri uri;

    public abstract void validateType();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemPath(Uri uri) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.uri = uri;
    }

    public final UnifiedFileInterface getFile() throws Exception {
        JavaFile javaFile;
        Context reactContext;
        Context reactContext2;
        UnifiedFileInterface unifiedFileInterface = this.fileAdapter;
        if (Intrinsics.areEqual(unifiedFileInterface != null ? unifiedFileInterface.getUri() : null, this.uri)) {
            return unifiedFileInterface;
        }
        if (FileSystemPathKt.isContentUri(this.uri)) {
            AppContext appContext = getAppContext();
            if (appContext == null || (reactContext2 = appContext.getReactContext()) == null) {
                throw new Exception("No context");
            }
            javaFile = new SAFDocumentFile(reactContext2, this.uri);
        } else if (FileSystemPathKt.isAssetUri(this.uri)) {
            AppContext appContext2 = getAppContext();
            if (appContext2 == null || (reactContext = appContext2.getReactContext()) == null) {
                throw new Exception("No context");
            }
            javaFile = new AssetFile(reactContext, this.uri);
        } else {
            javaFile = new JavaFile(this.uri);
        }
        this.fileAdapter = javaFile;
        return javaFile;
    }

    public final File getJavaFile() throws Exception {
        if (FileSystemPathKt.isContentUri(this.uri)) {
            throw new Exception("This method cannot be used with content URIs: " + this.uri);
        }
        Object file = getFile();
        Intrinsics.checkNotNull(file, "null cannot be cast to non-null type java.io.File");
        return (File) file;
    }

    public final void delete() throws UnableToDeleteException, InvalidPermissionException {
        validatePermission(Permission.WRITE);
        if (!getFile().exists()) {
            throw new UnableToDeleteException("uri '" + getFile().getUri() + "' does not exist");
        }
        if (getFile().isDirectory()) {
            if (getFile().deleteRecursively()) {
                return;
            }
            throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
        }
        if (getFile().delete()) {
            return;
        }
        throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
    }

    public final File getMoveOrCopyPath(FileSystemPath destination) throws CopyOrMoveDirectoryToFileException, DestinationDoesNotExistException {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof FileSystemDirectory) {
            if (this instanceof FileSystemFile) {
                if (!((FileSystemDirectory) destination).getExists()) {
                    throw new DestinationDoesNotExistException();
                }
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            if (((FileSystemDirectory) destination).getExists()) {
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            File parentFile = destination.getJavaFile().getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                throw new DestinationDoesNotExistException();
            }
            return destination.getJavaFile();
        }
        if (!(this instanceof FileSystemFile)) {
            throw new CopyOrMoveDirectoryToFileException();
        }
        File parentFile2 = destination.getJavaFile().getParentFile();
        if (parentFile2 == null || !parentFile2.exists()) {
            throw new DestinationDoesNotExistException();
        }
        return destination.getJavaFile();
    }

    public final void validatePermission(Permission permission) throws InvalidPermissionException {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (!checkPermission(permission)) {
            throw new InvalidPermissionException(permission);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    public final boolean checkPermission(Permission permission) {
        EnumSet<Permission> enumSetNoneOf;
        FilePermissionModuleInterface filePermission;
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (FileSystemPathKt.isContentUri(this.uri) || FileSystemPathKt.isAssetUri(this.uri)) {
            return true;
        }
        AppContext appContext = getAppContext();
        if (appContext == null || (filePermission = appContext.getFilePermission()) == null) {
            enumSetNoneOf = EnumSet.noneOf(Permission.class);
        } else {
            AppContext appContext2 = getAppContext();
            enumSetNoneOf = filePermission.getPathPermissions(appContext2 != null ? appContext2.getReactContext() : null, getJavaFile().getPath());
            if (enumSetNoneOf == null) {
                enumSetNoneOf = EnumSet.noneOf(Permission.class);
            }
        }
        return enumSetNoneOf.contains(permission);
    }

    public final void validateCanCreate(CreateOptions options) throws UnableToCreateException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!options.getOverwrite() && getFile().exists()) {
            throw new UnableToCreateException("it already exists");
        }
    }

    public final void copy(FileSystemPath to) throws InvalidPermissionException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(Permission.READ);
        to.validatePermission(Permission.WRITE);
        FilesKt.copyRecursively$default(getJavaFile(), getMoveOrCopyPath(to), false, null, 6, null);
    }

    public final void move(FileSystemPath to) throws CopyOrMoveDirectoryToFileException, DestinationDoesNotExistException, InvalidPermissionException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(Permission.WRITE);
        to.validatePermission(Permission.WRITE);
        if (Build.VERSION.SDK_INT >= 26) {
            File moveOrCopyPath = getMoveOrCopyPath(to);
            Path path = getJavaFile().toPath();
            Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
            Path path2 = moveOrCopyPath.toPath();
            Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
            Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
            this.uri = Uri.fromFile(moveOrCopyPath);
            return;
        }
        FilesKt.copyTo$default(getJavaFile(), getMoveOrCopyPath(to), false, 0, 6, null);
        getJavaFile().delete();
        this.uri = Uri.fromFile(getMoveOrCopyPath(to));
    }

    public final void rename(String newName) throws IOException, UnableToCreateException, InvalidPermissionException {
        Intrinsics.checkNotNullParameter(newName, "newName");
        validateType();
        validatePermission(Permission.WRITE);
        FileSystemPathKt.validateFileSystemChildName(newName);
        File parentFile = getJavaFile().getParentFile();
        if (parentFile == null) {
            throw new UnableToCreateException("parent directory does not exist");
        }
        String canonicalPath = parentFile.getCanonicalPath();
        File file = new File(parentFile, newName);
        File parentFile2 = file.getCanonicalFile().getParentFile();
        if (!Intrinsics.areEqual(parentFile2 != null ? parentFile2.getCanonicalPath() : null, canonicalPath)) {
            throw new UnableToCreateException("child path escapes parent directory");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Path path = getJavaFile().toPath();
            Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
            Path path2 = file.toPath();
            Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
            Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
        } else {
            FilesKt.copyTo$default(getJavaFile(), file, false, 0, 6, null);
            Boolean.valueOf(getJavaFile().delete());
        }
        this.uri = renamedUri(newName);
    }

    private final Uri renamedUri(String newName) {
        String string = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strSubstring = string.substring(0, StringsKt.lastIndexOf$default((CharSequence) StringsKt.trimEnd(string, IOUtils.DIR_SEPARATOR_UNIX), IOUtils.DIR_SEPARATOR_UNIX, 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String string2 = Uri.withAppendedPath(Uri.parse(strSubstring), newName).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        if (this instanceof FileSystemDirectory) {
            string2 = string2 + "/";
        }
        Uri uri = Uri.parse(string2);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    public final Long getModificationTime() {
        validateType();
        return getFile().lastModified();
    }

    public final Long getCreationTime() {
        return getFile().getCreationTime();
    }
}
