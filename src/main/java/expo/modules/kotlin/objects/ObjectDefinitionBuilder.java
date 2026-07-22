package expo.modules.kotlin.objects;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.EnumExtensionsKt;
import expo.modules.kotlin.KClassExtensionsKt;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.FunctionBuilder;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.Enumerable;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ObjectDefinitionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00106\u001a\u000207J$\u00108\u001a\u0002092\u001a\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f0\u000bH\u0007J=\u00108\u001a\u0002092.\u0010.\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010;0:\"\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010;H\u0007¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\rJ+\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\r2\u0010\b\u0004\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b@J,\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u00012\u0006\u0010>\u001a\u00020\r2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u0002HA0\u000bH\u0086\bø\u0001\u0000JI\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u00012\u0006\u0010>\u001a\u00020\r2#\b\u0004\u0010?\u001a\u001d\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0004\u0012\u0002HA0CH\u0086\bø\u0001\u0000Jf\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u00012\u0006\u0010>\u001a\u00020\r28\b\u0004\u0010?\u001a2\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002HA0GH\u0086\bø\u0001\u0000J\u0083\u0001\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u00012\u0006\u0010>\u001a\u00020\r2M\b\u0004\u0010?\u001aG\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002HA0JH\u0086\bø\u0001\u0000J \u0001\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u00012\u0006\u0010>\u001a\u00020\r2b\b\u0004\u0010?\u001a\\\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HA0MH\u0086\bø\u0001\u0000J½\u0001\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u00012\u0006\u0010>\u001a\u00020\r2w\b\u0004\u0010?\u001aq\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0004\u0012\u0002HA0PH\u0086\bø\u0001\u0000JÜ\u0001\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u00012\u0006\u0010>\u001a\u00020\r2\u008d\u0001\b\u0004\u0010?\u001a\u0086\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0004\u0012\u0002HA0SH\u0086\bø\u0001\u0000Jù\u0001\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u0001\"\u0006\b\u0007\u0010U\u0018\u00012\u0006\u0010>\u001a\u00020\r2¢\u0001\b\u0004\u0010?\u001a\u009b\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0013\u0012\u0011HU¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0004\u0012\u0002HA0VH\u0086\bø\u0001\u0000J\u0096\u0002\u0010=\u001a\u00020\u0017\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u0001\"\u0006\b\u0007\u0010U\u0018\u0001\"\u0006\b\b\u0010X\u0018\u00012\u0006\u0010>\u001a\u00020\r2·\u0001\b\u0004\u0010?\u001a°\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0013\u0012\u0011HU¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0013\u0012\u0011HX¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002HA0YH\u0086\bø\u0001\u0000J+\u0010[\u001a\u00020#2\u0006\u0010>\u001a\u00020\r2\u0010\b\u0004\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\\J,\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u00012\u0006\u0010>\u001a\u00020\r2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u0002HA0\u000bH\u0086\bø\u0001\u0000JI\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u00012\u0006\u0010>\u001a\u00020\r2#\b\u0004\u0010?\u001a\u001d\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0004\u0012\u0002HA0CH\u0086\bø\u0001\u0000Jf\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u00012\u0006\u0010>\u001a\u00020\r28\b\u0004\u0010?\u001a2\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002HA0GH\u0086\bø\u0001\u0000Jc\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u00012\u0006\u0010>\u001a\u00020\r28\b\u0004\u0010?\u001a2\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110]¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002HA0GH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J\u0083\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u00012\u0006\u0010>\u001a\u00020\r2M\b\u0004\u0010?\u001aG\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002HA0JH\u0086\bø\u0001\u0000J\u0080\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u00012\u0006\u0010>\u001a\u00020\r2M\b\u0004\u0010?\u001aG\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u00110]¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002HA0JH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J \u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u00012\u0006\u0010>\u001a\u00020\r2b\b\u0004\u0010?\u001a\\\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HA0MH\u0086\bø\u0001\u0000J\u009d\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u00012\u0006\u0010>\u001a\u00020\r2b\b\u0004\u0010?\u001a\\\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110]¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HA0MH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J½\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u00012\u0006\u0010>\u001a\u00020\r2w\b\u0004\u0010?\u001aq\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0004\u0012\u0002HA0PH\u0086\bø\u0001\u0000Jº\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u00012\u0006\u0010>\u001a\u00020\r2w\b\u0004\u0010?\u001aq\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110]¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0004\u0012\u0002HA0PH\u0087\bø\u0001\u0000¢\u0006\u0002\b^JÜ\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u00012\u0006\u0010>\u001a\u00020\r2\u008d\u0001\b\u0004\u0010?\u001a\u0086\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0004\u0012\u0002HA0SH\u0086\bø\u0001\u0000JÙ\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u00012\u0006\u0010>\u001a\u00020\r2\u008d\u0001\b\u0004\u0010?\u001a\u0086\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u00110]¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0004\u0012\u0002HA0SH\u0087\bø\u0001\u0000¢\u0006\u0002\b^Jù\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u0001\"\u0006\b\u0007\u0010U\u0018\u00012\u0006\u0010>\u001a\u00020\r2¢\u0001\b\u0004\u0010?\u001a\u009b\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0013\u0012\u0011HU¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0004\u0012\u0002HA0VH\u0086\bø\u0001\u0000Jö\u0001\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u00012\u0006\u0010>\u001a\u00020\r2¢\u0001\b\u0004\u0010?\u001a\u009b\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0013\u0012\u00110]¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0004\u0012\u0002HA0VH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J\u0096\u0002\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u0001\"\u0006\b\u0007\u0010U\u0018\u0001\"\u0006\b\b\u0010X\u0018\u00012\u0006\u0010>\u001a\u00020\r2·\u0001\b\u0004\u0010?\u001a°\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0013\u0012\u0011HU¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0013\u0012\u0011HX¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002HA0YH\u0086\bø\u0001\u0000J\u0093\u0002\u0010[\u001a\u00020#\"\u0006\b\u0000\u0010A\u0018\u0001\"\u0006\b\u0001\u0010B\u0018\u0001\"\u0006\b\u0002\u0010F\u0018\u0001\"\u0006\b\u0003\u0010I\u0018\u0001\"\u0006\b\u0004\u0010L\u0018\u0001\"\u0006\b\u0005\u0010O\u0018\u0001\"\u0006\b\u0006\u0010R\u0018\u0001\"\u0006\b\u0007\u0010U\u0018\u00012\u0006\u0010>\u001a\u00020\r2·\u0001\b\u0004\u0010?\u001a°\u0001\u0012\u0013\u0012\u0011HB¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(E\u0012\u0013\u0012\u0011HF¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(H\u0012\u0013\u0012\u0011HI¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(K\u0012\u0013\u0012\u0011HL¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(N\u0012\u0013\u0012\u0011HO¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Q\u0012\u0013\u0012\u0011HR¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(T\u0012\u0013\u0012\u0011HU¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0013\u0012\u00110]¢\u0006\f\bD\u0012\b\b>\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002HA0YH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J\u000e\u0010[\u001a\u00020(2\u0006\u0010>\u001a\u00020\rJ\u001f\u0010_\u001a\u0002092\u0012\u0010`\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0:\"\u00020\r¢\u0006\u0002\u0010aJ\u001d\u0010_\u001a\u0002092\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\r0:H\u0007¢\u0006\u0004\bb\u0010aJ\u001f\u0010_\u001a\u000209\"\u0014\b\u0000\u0010c\u0018\u0001*\u00020d*\b\u0012\u0004\u0012\u0002Hc0eH\u0086\bJ\u001c\u0010f\u001a\u0002092\u0006\u0010g\u001a\u00020\r2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090\u000bJ5\u0010f\u001a\u000209\"\u0012\b\u0000\u0010c*\u00020d*\b\u0012\u0004\u0012\u0002Hc0e2\u0006\u0010h\u001a\u0002Hc2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090\u000b¢\u0006\u0002\u0010iJ\u0014\u0010f\u001a\u0002092\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090\u000bJ\u001c\u0010j\u001a\u0002092\u0006\u0010g\u001a\u00020\r2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090\u000bJ5\u0010j\u001a\u000209\"\u0012\b\u0000\u0010c*\u00020d*\b\u0012\u0004\u0012\u0002Hc0e2\u0006\u0010h\u001a\u0002Hc2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090\u000b¢\u0006\u0002\u0010iJ\u0014\u0010j\u001a\u0002092\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090\u000bJ\u0010\u0010k\u001a\u00020*2\u0006\u0010>\u001a\u00020\rH\u0016J,\u0010k\u001a\u00020*\"\u0006\b\u0000\u0010c\u0018\u00012\u0006\u0010>\u001a\u00020\r2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u0002Hc0\u000bH\u0086\bø\u0001\u0000J\u0010\u0010l\u001a\u00020/2\u0006\u0010>\u001a\u00020\rH\u0016J,\u0010l\u001a\u00020/\"\u0006\b\u0000\u0010c\u0018\u00012\u0006\u0010>\u001a\u00020\r2\u000e\b\u0004\u0010?\u001a\b\u0012\u0004\u0012\u0002Hc0\u000bH\u0086\bø\u0001\u0000R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00170\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR0\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR0\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020#0\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0007\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020(0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020*0\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u0007\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR0\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/0\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0007\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006m"}, d2 = {"Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "", "converters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;)V", "getConverters$annotations", "()V", "getConverters", "()Lexpo/modules/kotlin/types/TypeConverterProvider;", "legacyConstantsProvider", "Lkotlin/Function0;", "", "", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "getEventsDefinition$annotations", "getEventsDefinition", "()Lexpo/modules/kotlin/events/EventsDefinition;", "setEventsDefinition", "(Lexpo/modules/kotlin/events/EventsDefinition;)V", "syncFunctions", "", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getSyncFunctions$annotations", "getSyncFunctions", "()Ljava/util/Map;", "setSyncFunctions", "(Ljava/util/Map;)V", "syncFunctionBuilder", "Lexpo/modules/kotlin/functions/FunctionBuilder;", "getSyncFunctionBuilder$annotations", "getSyncFunctionBuilder", "setSyncFunctionBuilder", "asyncFunctions", "Lexpo/modules/kotlin/functions/AsyncFunctionComponent;", "getAsyncFunctions$annotations", "getAsyncFunctions", "setAsyncFunctions", "asyncFunctionBuilders", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "properties", "Lexpo/modules/kotlin/objects/PropertyComponentBuilder;", "getProperties$annotations", "getProperties", "setProperties", "constants", "Lexpo/modules/kotlin/objects/ConstantComponentBuilder;", "getConstants$annotations", "getConstants", "setConstants", "eventObservers", "", "Lexpo/modules/kotlin/objects/EventObservingDefinition;", "buildObject", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "Constants", "", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "Function", "name", "body", "FunctionWithoutArgs", "R", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "AsyncFunction", "AsyncFunctionWithoutArgs", "Lexpo/modules/kotlin/Promise;", "AsyncFunctionWithPromise", "Events", "events", "([Ljava/lang/String;)V", "EventsWithArray", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/types/Enumerable;", "", "OnStartObserving", "eventName", "enum", "(Ljava/lang/Enum;Lkotlin/jvm/functions/Function0;)V", "OnStopObserving", "Property", "Constant", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObjectDefinitionBuilder {
    private Map<String, AsyncFunctionBuilder> asyncFunctionBuilders;
    private Map<String, AsyncFunctionComponent> asyncFunctions;
    private Map<String, ConstantComponentBuilder> constants;
    private final TypeConverterProvider converters;
    private final List<EventObservingDefinition> eventObservers;
    private EventsDefinition eventsDefinition;
    private Function0<? extends Map<String, ? extends Object>> legacyConstantsProvider;
    private Map<String, PropertyComponentBuilder> properties;
    private Map<String, FunctionBuilder> syncFunctionBuilder;
    private Map<String, SyncFunctionComponent> syncFunctions;

    public ObjectDefinitionBuilder() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getConstants$annotations() {
    }

    public static /* synthetic */ void getConverters$annotations() {
    }

    public static /* synthetic */ void getEventsDefinition$annotations() {
    }

    public static /* synthetic */ void getProperties$annotations() {
    }

    public static /* synthetic */ void getSyncFunctionBuilder$annotations() {
    }

    public static /* synthetic */ void getSyncFunctions$annotations() {
    }

    public ObjectDefinitionBuilder(TypeConverterProvider typeConverterProvider) {
        this.converters = typeConverterProvider;
        this.legacyConstantsProvider = new Function0() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MapsKt.emptyMap();
            }
        };
        this.syncFunctions = new LinkedHashMap();
        this.syncFunctionBuilder = new LinkedHashMap();
        this.asyncFunctions = new LinkedHashMap();
        this.asyncFunctionBuilders = new LinkedHashMap();
        this.properties = new LinkedHashMap();
        this.constants = new LinkedHashMap();
        this.eventObservers = new ArrayList();
    }

    public /* synthetic */ ObjectDefinitionBuilder(TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeConverterProvider);
    }

    public final TypeConverterProvider getConverters() {
        return this.converters;
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }

    public final void setEventsDefinition(EventsDefinition eventsDefinition) {
        this.eventsDefinition = eventsDefinition;
    }

    public final Map<String, SyncFunctionComponent> getSyncFunctions() {
        return this.syncFunctions;
    }

    public final void setSyncFunctions(Map<String, SyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncFunctions = map;
    }

    public final Map<String, FunctionBuilder> getSyncFunctionBuilder() {
        return this.syncFunctionBuilder;
    }

    public final void setSyncFunctionBuilder(Map<String, FunctionBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncFunctionBuilder = map;
    }

    public final Map<String, AsyncFunctionComponent> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final void setAsyncFunctions(Map<String, AsyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.asyncFunctions = map;
    }

    public final Map<String, PropertyComponentBuilder> getProperties() {
        return this.properties;
    }

    public final void setProperties(Map<String, PropertyComponentBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.properties = map;
    }

    public final Map<String, ConstantComponentBuilder> getConstants() {
        return this.constants;
    }

    public final void setConstants(Map<String, ConstantComponentBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.constants = map;
    }

    public final ObjectDefinitionData buildObject() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        for (final EventObservingDefinition.Type type : EventObservingDefinition.Type.getEntries()) {
            if (!this.asyncFunctions.containsKey(type.getValue())) {
                String value = type.getValue();
                if (Intrinsics.areEqual(String.class, Promise.class)) {
                    asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(value, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$3$$inlined$AsyncFunction$1
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object[] objArr, Promise promise) {
                            Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                            Intrinsics.checkNotNullParameter(promise, "promise");
                            String str = (String) promise;
                            Iterator it = this.this$0.eventObservers.iterator();
                            while (it.hasNext()) {
                                ((EventObservingDefinition) it.next()).invokedIfNeed(type, str);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                            invoke2(objArr, promise);
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    TypeConverterProvider converters = getConverters();
                    AnyType[] anyTypeArr = new AnyType[1];
                    AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
                    AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                    if (anyType == null) {
                        anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$3$$inlined$AsyncFunction$2
                            @Override // kotlin.jvm.functions.Function0
                            public final KType invoke() {
                                return Reflection.typeOf(String.class);
                            }
                        }), converters);
                    }
                    anyTypeArr[0] = anyType;
                    Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$buildObject$lambda$3$$inlined$AsyncFunction$3
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object[] objArr) {
                            Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                            String str = (String) objArr[0];
                            Iterator it = this.this$0.eventObservers.iterator();
                            while (it.hasNext()) {
                                ((EventObservingDefinition) it.next()).invokedIfNeed(type, str);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                                if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                    if (Intrinsics.areEqual(Unit.class, String.class)) {
                                        untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(value, anyTypeArr, function1);
                                    } else {
                                        untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(value, anyTypeArr, function1);
                                    }
                                } else {
                                    untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(value, anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(value, anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(value, anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(value, anyTypeArr, function1);
                    }
                    asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
                }
                getAsyncFunctions().put(value, asyncFunctionWithPromiseComponent);
            }
        }
        Map<String, AsyncFunctionComponent> map = this.asyncFunctions;
        Map<String, AsyncFunctionBuilder> map2 = this.asyncFunctionBuilders;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        Iterator<T> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((AsyncFunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map mutableMap = MapsKt.toMutableMap(MapsKt.plus(map, linkedHashMap));
        Function0<? extends Map<String, ? extends Object>> function0 = this.legacyConstantsProvider;
        Map<String, SyncFunctionComponent> map3 = this.syncFunctions;
        Map<String, FunctionBuilder> map4 = this.syncFunctionBuilder;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
        Iterator<T> it2 = map4.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(entry2.getKey(), ((FunctionBuilder) entry2.getValue()).build$expo_modules_core_release());
        }
        Map mapPlus = MapsKt.plus(map3, linkedHashMap2);
        EventsDefinition eventsDefinition = this.eventsDefinition;
        Map<String, PropertyComponentBuilder> map5 = this.properties;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map5.size()));
        Iterator<T> it3 = map5.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            linkedHashMap3.put(entry3.getKey(), ((PropertyComponentBuilder) entry3.getValue()).build());
        }
        Map<String, ConstantComponentBuilder> map6 = this.constants;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(map6.size()));
        Iterator<T> it4 = map6.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry entry4 = (Map.Entry) it4.next();
            linkedHashMap4.put(entry4.getKey(), ((ConstantComponentBuilder) entry4.getValue()).build());
        }
        return new ObjectDefinitionData(function0, mapPlus, mutableMap, eventsDefinition, linkedHashMap3, linkedHashMap4);
    }

    @Deprecated(message = "Use `Constant` or `Property` instead")
    public final void Constants(Function0<? extends Map<String, ? extends Object>> legacyConstantsProvider) {
        Intrinsics.checkNotNullParameter(legacyConstantsProvider, "legacyConstantsProvider");
        this.legacyConstantsProvider = legacyConstantsProvider;
    }

    @Deprecated(message = "Use `Constant` or `Property` instead")
    public final void Constants(final Pair<String, ? extends Object>... constants) {
        Intrinsics.checkNotNullParameter(constants, "constants");
        this.legacyConstantsProvider = new Function0() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MapsKt.toMap(constants);
            }
        };
    }

    public final FunctionBuilder Function(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        FunctionBuilder functionBuilder = new FunctionBuilder(name);
        this.syncFunctionBuilder.put(name, functionBuilder);
        return functionBuilder;
    }

    public final SyncFunctionComponent FunctionWithoutArgs(String name, final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R> SyncFunctionComponent Function(String name, final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SyncFunctionComponent Function(String name, final Function1<? super P0, ? extends R> body) {
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$3 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[0] = anyType;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.6
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SyncFunctionComponent Function(String name, final Function2<? super P0, ? super P1, ? extends R> body) {
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$1 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$1), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$2 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[1] = anyType2;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.8
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SyncFunctionComponent Function(String name, final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$4 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$5 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$6 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[2] = anyType3;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.10
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SyncFunctionComponent Function(String name, final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$7 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$8 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$9 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$10 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[3] = anyType4;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.12
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SyncFunctionComponent Function(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$11 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$12 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$13 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$14 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$15 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[4] = anyType5;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.14
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SyncFunctionComponent Function(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$16 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$17 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$18 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$19 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$19
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$19), converters);
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$20 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$20
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$20), converters);
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$21 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[5] = anyType6;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.16
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Function(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$22 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$23 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$24 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$25 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$25
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$25), converters);
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$26 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$26
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$26), converters);
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$27 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$28 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[6] = anyType7;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.18
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Function(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
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
        Intrinsics.reifiedOperationMarker(4, "P7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$29 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$30 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$31 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$32 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$32
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$32), converters);
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$33 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$33
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$33), converters);
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
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$34 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$35 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$36 objectDefinitionBuilder$Function$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, objectDefinitionBuilder$Function$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[7] = anyType8;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.Function.20
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6], (P7) objArr[7]);
            }
        });
        getSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final AsyncFunctionComponent AsyncFunctionWithoutArgs(String name, final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.1
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
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.3
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
        if (!Intrinsics.areEqual(Object.class, Promise.class)) {
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
                ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        return null;
                    }
                };
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1), converters);
            }
            anyTypeArr[0] = anyType;
            Intrinsics.needClassReification();
            Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.6
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
        } else {
            Intrinsics.needClassReification();
            asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.5
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function1<P0, R> function2 = body;
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    function2.invoke((P0) promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[1] = anyType2;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.8
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[0] = anyType;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.10
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[2] = anyType3;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.12
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[1] = anyType2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.14
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[3] = anyType4;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.16
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[2] = anyType3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.18
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[4] = anyType5;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.20
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25), converters);
        }
        anyTypeArr[3] = anyType4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.22
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[5] = anyType6;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.24
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[4] = anyType5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.26
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43), converters);
        }
        anyTypeArr[6] = anyType7;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.28
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49), converters);
        }
        anyTypeArr[5] = anyType6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.30
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57), converters);
        }
        anyTypeArr[7] = anyType8;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.32
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62), converters);
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
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64 objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, objectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64), converters);
        }
        anyTypeArr[6] = anyType7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder.AsyncFunction.34
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
        this.asyncFunctionBuilders.put(name, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    public final void Events(String... events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.eventsDefinition = new EventsDefinition((String[]) ArraysKt.asList(events).toArray(new String[0]));
    }

    public final void EventsWithArray(String[] events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.eventsDefinition = new EventsDefinition(events);
    }

    public final /* synthetic */ <T extends Enum<T> & Enumerable> void Events() {
        ArrayList arrayList;
        List<KParameter> parameters;
        Object next;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KFunction fastPrimaryConstructor = KClassExtensionsKt.getFastPrimaryConstructor(Reflection.getOrCreateKotlinClass(Enum.class));
        if (fastPrimaryConstructor != null && (parameters = fastPrimaryConstructor.getParameters()) != null && parameters.size() == 1) {
            String name = ((KParameter) CollectionsKt.first((List) fastPrimaryConstructor.getParameters())).getName();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            Iterator it = KClasses.getDeclaredMemberProperties(Reflection.getOrCreateKotlinClass(Enum.class)).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((KProperty1) next).getName(), name));
            KProperty1 kProperty1 = (KProperty1) next;
            if (kProperty1 == null) {
                throw new IllegalArgumentException(("Cannot find a property for " + name + " parameter").toString());
            }
            if (!Intrinsics.areEqual(kProperty1.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(String.class))) {
                throw new IllegalArgumentException("The enum parameter has to be a string.".toString());
            }
            Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
            Enum[] enumArr = new Enum[0];
            arrayList = new ArrayList(0);
        } else {
            Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
            Enum[] enumArr2 = new Enum[0];
            arrayList = new ArrayList(0);
        }
        setEventsDefinition(new EventsDefinition((String[]) arrayList.toArray(new String[0])));
    }

    public final void OnStartObserving(String eventName, Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(body, "body");
        this.eventObservers.add(new EventObservingDefinition(EventObservingDefinition.Type.StartObserving, new EventObservingDefinition.SelectedEventFiler(eventName), body));
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Lkotlin/jvm/functions/Function0<Lkotlin/Unit;>;)V */
    public final void OnStartObserving(Enum r2, Function0 body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        Intrinsics.checkNotNullParameter(body, "body");
        OnStartObserving(EnumExtensionsKt.convertToString(r2), (Function0<Unit>) body);
    }

    public final void OnStartObserving(Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.eventObservers.add(new EventObservingDefinition(EventObservingDefinition.Type.StartObserving, EventObservingDefinition.AllEventsFilter.INSTANCE, body));
    }

    public final void OnStopObserving(String eventName, Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(body, "body");
        this.eventObservers.add(new EventObservingDefinition(EventObservingDefinition.Type.StopObserving, new EventObservingDefinition.SelectedEventFiler(eventName), body));
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Lkotlin/jvm/functions/Function0<Lkotlin/Unit;>;)V */
    public final void OnStopObserving(Enum r2, Function0 body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        Intrinsics.checkNotNullParameter(body, "body");
        OnStopObserving(EnumExtensionsKt.convertToString(r2), (Function0<Unit>) body);
    }

    public final void OnStopObserving(Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.eventObservers.add(new EventObservingDefinition(EventObservingDefinition.Type.StopObserving, EventObservingDefinition.AllEventsFilter.INSTANCE, body));
    }

    public PropertyComponentBuilder Property(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(name);
        this.properties.put(name, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public final /* synthetic */ <T> PropertyComponentBuilder Property(String name, Function0<? extends T> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(name);
        AnyType[] anyTypeArr = new AnyType[0];
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", anyTypeArr, returnType, new PropertyComponentBuilder$get$1$1(body)));
        getProperties().put(name, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public ConstantComponentBuilder Constant(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder(name);
        this.constants.put(name, constantComponentBuilder);
        return constantComponentBuilder;
    }

    public final /* synthetic */ <T> ConstantComponentBuilder Constant(String name, final Function0<? extends T> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder(name);
        Intrinsics.needClassReification();
        constantComponentBuilder.setGetter(new Function0<T>() { // from class: expo.modules.kotlin.objects.ObjectDefinitionBuilder$Constant$lambda$50$$inlined$get$1
            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return (T) body.invoke();
            }
        });
        getConstants().put(name, constantComponentBuilder);
        return constantComponentBuilder;
    }
}
