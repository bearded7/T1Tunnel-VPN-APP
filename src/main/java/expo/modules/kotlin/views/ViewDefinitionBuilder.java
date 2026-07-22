package expo.modules.kotlin.views;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.defaultmodules.JSLoggerModule;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.DefinitionMarker;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ViewDefinitionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u0017J1\u0010E\u001a\u00020'2#\b\u0004\u0010F\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020'0&H\u0086\bø\u0001\u0000JB\u0010E\u001a\u00020'\"\n\b\u0001\u0010I\u0018\u0001*\u00028\u00002#\b\b\u0010F\u001a\u001d\u0012\u0013\u0012\u0011HI¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020'0&H\u0087\bø\u0001\u0000¢\u0006\u0002\bJJ1\u0010K\u001a\u00020'2#\b\u0004\u0010F\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020'0&H\u0086\bø\u0001\u0000JB\u0010K\u001a\u00020'\"\n\b\u0001\u0010I\u0018\u0001*\u00028\u00002#\b\b\u0010F\u001a\u001d\u0012\u0013\u0012\u0011HI¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020'0&H\u0087\bø\u0001\u0000¢\u0006\u0002\bLJV\u0010M\u001a\u00020'\"\u0006\b\u0001\u0010N\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u001728\b\b\u0010F\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HN¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020'0OH\u0086\bø\u0001\u0000Jg\u0010M\u001a\u00020'\"\n\b\u0001\u0010I\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010N\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u001728\b\b\u0010F\u001a2\u0012\u0013\u0012\u0011HI¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HN¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020'0OH\u0087\bø\u0001\u0000¢\u0006\u0002\bQJq\u0010M\u001a\u00020'\"\n\b\u0001\u0010I\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010N\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010R\u001a\u0002HN28\b\b\u0010F\u001a2\u0012\u0013\u0012\u0011HI¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HN¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020'0OH\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u0010SJ¨\u0001\u0010T\u001a\u00020'\"\n\b\u0001\u0010I\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010N\u0018\u0001\"\u0006\b\u0003\u0010U\u0018\u00012*\u0010\u001d\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002HU0W0V\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002HU0W2M\b\b\u0010F\u001aG\u0012\u0013\u0012\u0011HI¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HU¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(Y\u0012\u0013\u0012\u0011HN¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020'0XH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010ZJ\u0088\u0001\u0010T\u001a\u00020'\"\n\b\u0001\u0010I\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010N\u0018\u00012\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170V\"\u00020\u00172M\b\b\u0010F\u001aG\u0012\u0013\u0012\u0011HI¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110[¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(Y\u0012\u0013\u0012\u0011HN¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020'0XH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\\J\u001f\u0010]\u001a\u00020'2\u0012\u0010^\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170V\"\u00020\u0017¢\u0006\u0002\u0010_J\u001d\u0010]\u001a\u00020'2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00170VH\u0007¢\u0006\u0004\b`\u0010_J7\u0010a\u001a\u00020'\"\n\b\u0001\u0010b\u0018\u0001*\u00020c2\u001d\u0010F\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hb0d\u0012\u0004\u0012\u00020'0&¢\u0006\u0002\beH\u0086\bø\u0001\u0000J+\u0010f\u001a\u00020;2\u0006\u0010\u0016\u001a\u00020\u00172\u0010\b\u0004\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030gH\u0087\bø\u0001\u0000¢\u0006\u0002\bhJ,\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u000e\b\u0004\u0010F\u001a\b\u0012\u0004\u0012\u0002Hi0gH\u0086\bø\u0001\u0000JI\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172#\b\u0004\u0010F\u001a\u001d\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0004\u0012\u0002Hi0&H\u0086\bø\u0001\u0000Jf\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u001728\b\u0004\u0010F\u001a2\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0004\u0012\u0002Hi0OH\u0086\bø\u0001\u0000Jc\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u001728\b\u0004\u0010F\u001a2\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u00110n¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0004\u0012\u0002Hi0OH\u0087\bø\u0001\u0000¢\u0006\u0002\boJ\u0083\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172M\b\u0004\u0010F\u001aG\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0004\u0012\u0002Hi0XH\u0086\bø\u0001\u0000J\u0080\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172M\b\u0004\u0010F\u001aG\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u00110n¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0004\u0012\u0002Hi0XH\u0087\bø\u0001\u0000¢\u0006\u0002\boJ \u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172b\b\u0004\u0010F\u001a\\\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0004\u0012\u0002Hi0sH\u0086\bø\u0001\u0000J\u009d\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172b\b\u0004\u0010F\u001a\\\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u00110n¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0004\u0012\u0002Hi0sH\u0087\bø\u0001\u0000¢\u0006\u0002\boJ½\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u0001\"\u0006\b\u0006\u0010u\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172w\b\u0004\u0010F\u001aq\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u0011Hu¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0004\u0012\u0002Hi0vH\u0086\bø\u0001\u0000Jº\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172w\b\u0004\u0010F\u001aq\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u00110n¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0004\u0012\u0002Hi0vH\u0087\bø\u0001\u0000¢\u0006\u0002\boJÜ\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u0001\"\u0006\b\u0006\u0010u\u0018\u0001\"\u0006\b\u0007\u0010x\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u008d\u0001\b\u0004\u0010F\u001a\u0086\u0001\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u0011Hu¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0013\u0012\u0011Hx¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(z\u0012\u0004\u0012\u0002Hi0yH\u0086\bø\u0001\u0000JÙ\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u0001\"\u0006\b\u0006\u0010u\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u008d\u0001\b\u0004\u0010F\u001a\u0086\u0001\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u0011Hu¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110n¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(z\u0012\u0004\u0012\u0002Hi0yH\u0087\bø\u0001\u0000¢\u0006\u0002\boJù\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u0001\"\u0006\b\u0006\u0010u\u0018\u0001\"\u0006\b\u0007\u0010x\u0018\u0001\"\u0006\b\b\u0010{\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172¢\u0001\b\u0004\u0010F\u001a\u009b\u0001\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u0011Hu¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0013\u0012\u0011Hx¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(z\u0012\u0013\u0012\u0011H{¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(}\u0012\u0004\u0012\u0002Hi0|H\u0086\bø\u0001\u0000Jö\u0001\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u0001\"\u0006\b\u0006\u0010u\u0018\u0001\"\u0006\b\u0007\u0010x\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172¢\u0001\b\u0004\u0010F\u001a\u009b\u0001\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u0011Hu¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0013\u0012\u0011Hx¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(z\u0012\u0013\u0012\u00110n¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(}\u0012\u0004\u0012\u0002Hi0|H\u0087\bø\u0001\u0000¢\u0006\u0002\boJ\u0097\u0002\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u0001\"\u0006\b\u0006\u0010u\u0018\u0001\"\u0006\b\u0007\u0010x\u0018\u0001\"\u0006\b\b\u0010{\u0018\u0001\"\u0006\b\t\u0010~\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172¸\u0001\b\u0004\u0010F\u001a±\u0001\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u0011Hu¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0013\u0012\u0011Hx¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(z\u0012\u0013\u0012\u0011H{¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(}\u0012\u0014\u0012\u0012H~¢\u0006\r\bG\u0012\t\b\u0016\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hi0\u007fH\u0086\bø\u0001\u0000J\u0094\u0002\u0010f\u001a\u00020;\"\u0006\b\u0001\u0010i\u0018\u0001\"\u0006\b\u0002\u0010j\u0018\u0001\"\u0006\b\u0003\u0010l\u0018\u0001\"\u0006\b\u0004\u0010p\u0018\u0001\"\u0006\b\u0005\u0010r\u0018\u0001\"\u0006\b\u0006\u0010u\u0018\u0001\"\u0006\b\u0007\u0010x\u0018\u0001\"\u0006\b\b\u0010{\u0018\u00012\u0006\u0010\u0016\u001a\u00020\u00172¸\u0001\b\u0004\u0010F\u001a±\u0001\u0012\u0013\u0012\u0011Hj¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(k\u0012\u0013\u0012\u0011Hl¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(m\u0012\u0013\u0012\u0011Hp¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(q\u0012\u0013\u0012\u0011Hr¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(t\u0012\u0013\u0012\u0011Hu¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(w\u0012\u0013\u0012\u0011Hx¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(z\u0012\u0013\u0012\u0011H{¢\u0006\f\bG\u0012\b\b\u0016\u0012\u0004\b\b(}\u0012\u0014\u0012\u00120n¢\u0006\r\bG\u0012\t\b\u0016\u0012\u0005\b\b(\u0080\u0001\u0012\u0004\u0012\u0002Hi0\u007fH\u0087\bø\u0001\u0000¢\u0006\u0002\boJ\u000e\u0010f\u001a\u00020@2\u0006\u0010\u0016\u001a\u00020\u0017J\u001d\u0010\u0081\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0082\u0001\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0004\u0012\u00020\u00020OH\u0002J'\u0010\u0084\u0001\u001a\u00020\u00022\b\u0010\u0085\u0001\u001a\u00030\u0082\u00012\b\u0010\u0086\u0001\u001a\u00030\u0083\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0002R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR0\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001f0\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\r\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R2\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\r\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R2\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\r\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R&\u00101\u001a\u0004\u0018\u0001028\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\r\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020;0\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\r\u001a\u0004\b=\u0010\"\"\u0004\b>\u0010$R\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020@0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0089\u0001"}, d2 = {"Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "viewClass", "Lkotlin/reflect/KClass;", "viewType", "Lkotlin/reflect/KType;", "converters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KType;Lexpo/modules/kotlin/types/TypeConverterProvider;)V", "getViewClass$annotations", "()V", "getViewClass", "()Lkotlin/reflect/KClass;", "getViewType$annotations", "getViewType", "()Lkotlin/reflect/KType;", "getConverters$annotations", "getConverters", "()Lexpo/modules/kotlin/types/TypeConverterProvider;", "name", "", "getName$annotations", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "props", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "getProps$annotations", "getProps", "()Ljava/util/Map;", "setProps", "(Ljava/util/Map;)V", "onViewDestroys", "Lkotlin/Function1;", "", "getOnViewDestroys$annotations", "getOnViewDestroys", "()Lkotlin/jvm/functions/Function1;", "setOnViewDestroys", "(Lkotlin/jvm/functions/Function1;)V", "onViewDidUpdateProps", "getOnViewDidUpdateProps$annotations", "getOnViewDidUpdateProps", "setOnViewDidUpdateProps", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewGroupDefinition$annotations", "getViewGroupDefinition", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "setViewGroupDefinition", "(Lexpo/modules/kotlin/views/ViewGroupDefinition;)V", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "asyncFunctions", "Lexpo/modules/kotlin/functions/AsyncFunctionComponent;", "getAsyncFunctions$annotations", "getAsyncFunctions", "setAsyncFunctions", "functionBuilders", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "Name", "viewName", "OnViewDestroys", "body", "Lkotlin/ParameterName;", "view", "ViewType", "OnViewDestroysGeneric", "OnViewDidUpdateProps", "OnViewDidUpdatePropsGeneric", "Prop", "PropType", "Lkotlin/Function2;", "prop", "PropGeneric", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "PropGroup", "CustomValueType", "", "Lkotlin/Pair;", "Lkotlin/Function3;", "value", "([Lkotlin/Pair;Lkotlin/jvm/functions/Function3;)V", "", "([Ljava/lang/String;Lkotlin/jvm/functions/Function3;)V", "Events", "callbacks", "([Ljava/lang/String;)V", "EventsWithArray", "GroupView", "ParentType", "Landroid/view/ViewGroup;", "Lexpo/modules/kotlin/views/ViewGroupDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "AsyncFunction", "Lkotlin/Function0;", "AsyncFunctionWithoutArgs", "R", "P0", "p0", "P1", "p1", "Lexpo/modules/kotlin/Promise;", "AsyncFunctionWithPromise", "P2", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "createViewFactory", "Landroid/content/Context;", "Lexpo/modules/kotlin/AppContext;", "handleFailureDuringViewCreation", "context", "appContext", "error", "", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@DefinitionMarker
public final class ViewDefinitionBuilder<T extends View> {
    private Map<String, AsyncFunctionComponent> asyncFunctions;
    private CallbacksDefinition callbacksDefinition;
    private final TypeConverterProvider converters;
    private Map<String, AsyncFunctionBuilder> functionBuilders;
    private String name;
    private Function1<? super View, Unit> onViewDestroys;
    private Function1<? super View, Unit> onViewDidUpdateProps;
    private Map<String, AnyViewProp> props;
    private final KClass<T> viewClass;
    private ViewGroupDefinition viewGroupDefinition;
    private final KType viewType;

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getConverters$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public static /* synthetic */ void getOnViewDestroys$annotations() {
    }

    public static /* synthetic */ void getOnViewDidUpdateProps$annotations() {
    }

    public static /* synthetic */ void getProps$annotations() {
    }

    public static /* synthetic */ void getViewClass$annotations() {
    }

    public static /* synthetic */ void getViewGroupDefinition$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public ViewDefinitionBuilder(KClass<T> viewClass, KType viewType, TypeConverterProvider typeConverterProvider) {
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.viewClass = viewClass;
        this.viewType = viewType;
        this.converters = typeConverterProvider;
        this.name = viewClass.getSimpleName();
        this.props = new LinkedHashMap();
        this.asyncFunctions = new LinkedHashMap();
        this.functionBuilders = new LinkedHashMap();
    }

    public /* synthetic */ ViewDefinitionBuilder(KClass kClass, KType kType, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, kType, (i & 4) != 0 ? null : typeConverterProvider);
    }

    public final KClass<T> getViewClass() {
        return this.viewClass;
    }

    public final KType getViewType() {
        return this.viewType;
    }

    public final TypeConverterProvider getConverters() {
        return this.converters;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Map<String, AnyViewProp> getProps() {
        return this.props;
    }

    public final void setProps(Map<String, AnyViewProp> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.props = map;
    }

    public final Function1<View, Unit> getOnViewDestroys() {
        return this.onViewDestroys;
    }

    public final void setOnViewDestroys(Function1<? super View, Unit> function1) {
        this.onViewDestroys = function1;
    }

    public final Function1<View, Unit> getOnViewDidUpdateProps() {
        return this.onViewDidUpdateProps;
    }

    public final void setOnViewDidUpdateProps(Function1<? super View, Unit> function1) {
        this.onViewDidUpdateProps = function1;
    }

    public final ViewGroupDefinition getViewGroupDefinition() {
        return this.viewGroupDefinition;
    }

    public final void setViewGroupDefinition(ViewGroupDefinition viewGroupDefinition) {
        this.viewGroupDefinition = viewGroupDefinition;
    }

    public final Map<String, AsyncFunctionComponent> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final void setAsyncFunctions(Map<String, AsyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.asyncFunctions = map;
    }

    public final ViewManagerDefinition build() {
        Map<String, AsyncFunctionComponent> map = this.asyncFunctions;
        Map<String, AsyncFunctionBuilder> map2 = this.functionBuilders;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        Iterator<T> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((AsyncFunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map mapPlus = MapsKt.plus(map, linkedHashMap);
        Iterator it2 = mapPlus.entrySet().iterator();
        while (it2.hasNext()) {
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = (BaseAsyncFunctionComponent) ((Map.Entry) it2.next()).getValue();
            baseAsyncFunctionComponent.runOnQueue(Queues.MAIN);
            baseAsyncFunctionComponent.setOwnerType(this.viewType);
            baseAsyncFunctionComponent.setCanTakeOwner(true);
        }
        return new ViewManagerDefinition(this.name, createViewFactory(), JvmClassMappingKt.getJavaClass((KClass) this.viewClass), this.props, this.onViewDestroys, this.callbacksDefinition, this.viewGroupDefinition, this.onViewDidUpdateProps, CollectionsKt.toList(mapPlus.values()));
    }

    public final void Name(String viewName) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.name = viewName;
    }

    public final void OnViewDestroys(final Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.OnViewDestroys.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                body.invoke(it);
            }
        });
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDestroysGeneric(final Function1<? super ViewType, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.OnViewDestroys.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<ViewType, Unit> function1 = body;
                Intrinsics.reifiedOperationMarker(1, "ViewType");
                function1.invoke((ViewType) it);
            }
        });
    }

    public final void OnViewDidUpdateProps(final Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.OnViewDidUpdateProps.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                body.invoke(it);
            }
        });
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDidUpdatePropsGeneric(final Function1<? super ViewType, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.needClassReification();
        setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.OnViewDidUpdateProps.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<ViewType, Unit> function1 = body;
                Intrinsics.reifiedOperationMarker(1, "ViewType");
                function1.invoke((ViewType) it);
            }
        });
    }

    public final /* synthetic */ <PropType> void Prop(String name, Function2<? super T, ? super PropType, Unit> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Map<String, AnyViewProp> props = getProps();
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "PropType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "PropType");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$Prop$$inlined$toAnyType$default$1 viewDefinitionBuilder$Prop$$inlined$toAnyType$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$Prop$$inlined$toAnyType$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "PropType");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "PropType");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$Prop$$inlined$toAnyType$default$1), null);
        }
        props.put(name, new ConcreteViewProp(name, anyType, body));
    }

    public final /* synthetic */ <ViewType extends View, PropType> void PropGeneric(String name, Function2<? super ViewType, ? super PropType, Unit> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Map<String, AnyViewProp> props = getProps();
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "PropType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "PropType");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$Prop$$inlined$toAnyType$default$2 viewDefinitionBuilder$Prop$$inlined$toAnyType$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$Prop$$inlined$toAnyType$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "PropType");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "PropType");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$Prop$$inlined$toAnyType$default$2), null);
        }
        props.put(name, new ConcreteViewProp(name, anyType, body));
    }

    public final /* synthetic */ <ViewType extends View, PropType> void PropGeneric(String name, PropType defaultValue, Function2<? super ViewType, ? super PropType, Unit> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Map<String, AnyViewProp> props = getProps();
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "PropType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "PropType");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$Prop$$inlined$toAnyType$default$3 viewDefinitionBuilder$Prop$$inlined$toAnyType$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$Prop$$inlined$toAnyType$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "PropType");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "PropType");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "PropType");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$Prop$$inlined$toAnyType$default$3), null);
        }
        props.put(name, new ConcreteViewPropWithDefault(name, anyType, body, defaultValue));
    }

    public final /* synthetic */ <ViewType extends View, PropType, CustomValueType> void PropGroup(Pair<String, ? extends CustomValueType>[] props, final Function3<? super ViewType, ? super CustomValueType, ? super PropType, Unit> body) {
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(body, "body");
        for (Pair<String, ? extends CustomValueType> pair : props) {
            String strComponent1 = pair.component1();
            final CustomValueType customvaluetypeComponent2 = pair.component2();
            Intrinsics.needClassReification();
            Function2 function2 = new Function2<ViewType, PropType, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.PropGroup.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                    invoke((View) obj, obj2);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Incorrect types in method signature: (TViewType;TPropType;)V */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
                    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v1 boolean
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                    	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
                    */
                public final void invoke(android.view.View r3, java.lang.Object r4) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "view"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        kotlin.jvm.functions.Function3<ViewType, CustomValueType, PropType, kotlin.Unit> r0 = r1
                        CustomValueType r1 = r2
                        r0.invoke(r3, r1, r4)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.views.ViewDefinitionBuilder.C01611.invoke(android.view.View, java.lang.Object):void");
                }
            };
            Map<String, AnyViewProp> props2 = getProps();
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "PropType");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "PropType");
            AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
            if (anyType == null) {
                Intrinsics.needClassReification();
                ViewDefinitionBuilder$PropGroup$$inlined$PropGeneric$1 viewDefinitionBuilder$PropGroup$$inlined$PropGeneric$1 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$PropGroup$$inlined$PropGeneric$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, "PropType");
                        return null;
                    }
                };
                Intrinsics.reifiedOperationMarker(4, "PropType");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "PropType");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$PropGroup$$inlined$PropGeneric$1), null);
            }
            props2.put(strComponent1, new ConcreteViewProp(strComponent1, anyType, function2));
        }
    }

    public final void Events(String... callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(callbacks);
    }

    public final void EventsWithArray(String[] callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(callbacks);
    }

    public final /* synthetic */ <ParentType extends ViewGroup> void GroupView(Function1<? super ViewGroupDefinitionBuilder<ParentType>, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        KClass<T> viewClass = getViewClass();
        Intrinsics.reifiedOperationMarker(4, "ParentType");
        Intrinsics.areEqual(viewClass, Reflection.getOrCreateKotlinClass(ViewGroup.class));
        if (getViewGroupDefinition() != null) {
            throw new IllegalArgumentException("The viewManager definition may have exported only one groupView definition.".toString());
        }
        ViewGroupDefinitionBuilder viewGroupDefinitionBuilder = new ViewGroupDefinitionBuilder();
        body.invoke(viewGroupDefinitionBuilder);
        setViewGroupDefinition(viewGroupDefinitionBuilder.build());
    }

    public final AsyncFunctionComponent AsyncFunctionWithoutArgs(String name, final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunctionComponent AsyncFunction(String name, final Function0<? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.3
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunctionComponent AsyncFunction(String name, final Function1<? super P0, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.5
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function1<P0, R> function1 = body;
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    function1.invoke((P0) promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        } else {
            Intrinsics.reifiedOperationMarker(4, "P0");
            AnyType[] anyTypeArr = new AnyType[1];
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
            if (anyType == null) {
                Intrinsics.needClassReification();
                ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        return null;
                    }
                };
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1), null);
            }
            anyTypeArr[0] = anyType;
            Intrinsics.needClassReification();
            Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.6
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.jvm.functions.Function1
                public final R invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return body.invoke((P0) objArr[0]);
                }
            };
            Intrinsics.reifiedOperationMarker(3, "R");
            Intrinsics.reifiedOperationMarker(4, "R");
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, String.class)) {
                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
            } else {
                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
            }
            asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
        }
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunctionComponent AsyncFunction(String name, final Function2<? super P0, ? super P1, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[1] = anyType2;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.8
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunctionComponent AsyncFunctionWithPromise(String name, final Function2<? super P0, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[0] = anyType;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.10
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunctionComponent AsyncFunction(String name, final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[2] = anyType3;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.12
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunctionComponent AsyncFunctionWithPromise(String name, final Function3<? super P0, ? super P1, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[1] = anyType2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.14
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunctionComponent AsyncFunction(String name, final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[3] = anyType4;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.16
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunctionComponent AsyncFunctionWithPromise(String name, final Function4<? super P0, ? super P1, ? super P2, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[2] = anyType3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.18
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunctionComponent AsyncFunction(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[4] = anyType5;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.20
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunctionComponent AsyncFunctionWithPromise(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25), converters);
        }
        anyTypeArr[3] = anyType4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.22
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunctionComponent AsyncFunction(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[5] = anyType6;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.24
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunctionComponent AsyncFunctionWithPromise(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[4] = anyType5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.26
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunctionComponent AsyncFunction(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        int i;
        int i2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43), converters);
        }
        anyTypeArr[6] = anyType7;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.28
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunctionComponent AsyncFunctionWithPromise(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49), converters);
        }
        anyTypeArr[5] = anyType6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.30
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], promise);
            }
        });
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunctionComponent AsyncFunction(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        int i;
        int i2;
        String str;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        Intrinsics.reifiedOperationMarker(4, "P7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57), converters);
        }
        anyTypeArr[7] = anyType8;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.32
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6], (P7) objArr[7]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            str = name;
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(str, anyTypeArr, function1);
        } else {
            str = name;
            if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(str, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(str, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(str, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, String.class)) {
                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(str, anyTypeArr, function1);
            } else {
                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(str, anyTypeArr, function1);
            }
        }
        getAsyncFunctions().put(str, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunctionComponent AsyncFunctionWithPromise(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64 viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, viewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64), converters);
        }
        anyTypeArr[6] = anyType7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder.AsyncFunction.34
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6], promise);
            }
        });
        getAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final AsyncFunctionBuilder AsyncFunction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        AsyncFunctionBuilder asyncFunctionBuilder = new AsyncFunctionBuilder(name, this.converters);
        this.functionBuilders.put(name, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    private final Function2<Context, AppContext, View> createViewFactory() {
        return new Function2() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ViewDefinitionBuilder.createViewFactory$lambda$25(this.f$0, (Context) obj, (AppContext) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View createViewFactory$lambda$25(ViewDefinitionBuilder viewDefinitionBuilder, Context context, AppContext appContext) {
        Constructor constructor;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Constructor constructor2 = null;
        try {
            constructor = JvmClassMappingKt.getJavaClass((KClass) viewDefinitionBuilder.viewClass).getConstructor(Context.class, AppContext.class);
        } catch (NoSuchMethodException unused) {
            constructor = null;
        }
        if (constructor != null) {
            try {
                Object objNewInstance = constructor.newInstance(context, appContext);
                Intrinsics.checkNotNull(objNewInstance);
                return (View) objNewInstance;
            } catch (Throwable th) {
                return viewDefinitionBuilder.handleFailureDuringViewCreation(context, appContext, th);
            }
        }
        try {
            constructor2 = JvmClassMappingKt.getJavaClass((KClass) viewDefinitionBuilder.viewClass).getConstructor(Context.class);
        } catch (NoSuchMethodException unused2) {
        }
        if (constructor2 != null) {
            try {
                Object objNewInstance2 = constructor2.newInstance(context);
                Intrinsics.checkNotNull(objNewInstance2);
                return (View) objNewInstance2;
            } catch (Throwable th2) {
                return viewDefinitionBuilder.handleFailureDuringViewCreation(context, appContext, th2);
            }
        }
        throw new IllegalStateException("Didn't find a correct constructor for " + viewDefinitionBuilder.viewClass);
    }

    private final View handleFailureDuringViewCreation(Context context, AppContext appContext, Throwable error) {
        Log.e("ExpoModulesCore", "Couldn't create view of type " + this.viewClass, error);
        JSLoggerModule errorManager = appContext.getErrorManager();
        if (errorManager != null) {
            UnexpectedException unexpectedException = error instanceof CodedException ? (CodedException) error : null;
            if (unexpectedException == null) {
                unexpectedException = new UnexpectedException(error);
            }
            errorManager.reportExceptionToLogBox(unexpectedException);
        }
        if (ViewGroup.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass) this.viewClass))) {
            return new ErrorGroupView(context);
        }
        return new ErrorView(context);
    }

    public final /* synthetic */ <ViewType extends View, PropType> void PropGroup(String[] props, final Function3<? super ViewType, ? super Integer, ? super PropType, Unit> body) {
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(body, "body");
        int length = props.length;
        int i = 0;
        final int i2 = 0;
        while (i < length) {
            String str = props[i];
            int i3 = i2 + 1;
            Intrinsics.needClassReification();
            Function2 function2 = new Function2<ViewType, PropType, Unit>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$PropGroup$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                    invoke((View) obj, obj2);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Incorrect types in method signature: (TViewType;TPropType;)V */
                public final void invoke(View view, Object obj) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    body.invoke(view, Integer.valueOf(i2), obj);
                }
            };
            Map<String, AnyViewProp> props2 = getProps();
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "PropType");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "PropType");
            AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
            if (anyType == null) {
                Intrinsics.needClassReification();
                Intrinsics.needClassReification();
                ViewDefinitionBuilder$PropGroup$$inlined$forEachIndexed$lambda$1 viewDefinitionBuilder$PropGroup$$inlined$forEachIndexed$lambda$1 = new Function0<KType>() { // from class: expo.modules.kotlin.views.ViewDefinitionBuilder$PropGroup$$inlined$forEachIndexed$lambda$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, "PropType");
                        return null;
                    }
                };
                Intrinsics.reifiedOperationMarker(4, "PropType");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "PropType");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, viewDefinitionBuilder$PropGroup$$inlined$forEachIndexed$lambda$1), null);
            }
            props2.put(str, new ConcreteViewProp(str, anyType, function2));
            i++;
            i2 = i3;
        }
    }
}
