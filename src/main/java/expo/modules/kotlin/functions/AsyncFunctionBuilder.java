package expo.modules.kotlin.functions;

import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u0016\u001a\u00020\u0010\"\u0006\b\u0000\u0010\u0017\u0018\u00012\u001e\b\u0004\u0010\u0018\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001bJV\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u000123\b\u0004\u0010\u0018\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010!Js\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u00012H\b\u0004\u0010\u0018\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010#H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010%J\u0090\u0001\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u00012]\b\u0004\u0010\u0018\u001aW\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010)J\u00ad\u0001\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u00012r\b\u0004\u0010\u0018\u001al\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010+H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010-JÌ\u0001\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u00012\u0088\u0001\b\u0004\u0010\u0018\u001a\u0081\u0001\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010/H\u0086\bø\u0001\u0000¢\u0006\u0002\u00101Jé\u0001\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u00012\u009d\u0001\b\u0004\u0010\u0018\u001a\u0096\u0001\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000103H\u0086\bø\u0001\u0000¢\u0006\u0002\u00105J\u0086\u0002\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00106\u0018\u00012²\u0001\b\u0004\u0010\u0018\u001a«\u0001\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H6¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(8\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000107H\u0086\bø\u0001\u0000¢\u0006\u0002\u00109J£\u0002\u0010\u0016\u001a\u00020\u001c\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00106\u0018\u0001\"\u0006\b\b\u0010:\u0018\u00012Ç\u0001\b\u0004\u0010\u0018\u001aÀ\u0001\b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H6¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H:¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(<\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010;H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010=J#\u0010>\u001a\u00020?2\u0010\b\u0004\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010AH\u0087\bø\u0001\u0000¢\u0006\u0002\bBJ$\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u00012\u000e\b\u0004\u0010@\u001a\b\u0012\u0004\u0012\u0002H\u00170AH\u0086\bø\u0001\u0000JA\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u00012#\b\u0004\u0010@\u001a\u001d\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\bø\u0001\u0000J^\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u000128\b\u0004\u0010@\u001a2\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u00170\u001eH\u0086\bø\u0001\u0000J[\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u000128\b\u0004\u0010@\u001a2\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u00110C¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u00170\u001eH\u0087\bø\u0001\u0000¢\u0006\u0002\bDJ{\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u00012M\b\u0004\u0010@\u001aG\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00170#H\u0086\bø\u0001\u0000Jx\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u00012M\b\u0004\u0010@\u001aG\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u00110C¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00170#H\u0087\bø\u0001\u0000¢\u0006\u0002\bDJ\u0098\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u00012b\b\u0004\u0010@\u001a\\\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H\u00170'H\u0086\bø\u0001\u0000J\u0095\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u00012b\b\u0004\u0010@\u001a\\\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u00110C¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H\u00170'H\u0087\bø\u0001\u0000¢\u0006\u0002\bDJµ\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u00012w\b\u0004\u0010@\u001aq\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002H\u00170+H\u0086\bø\u0001\u0000J²\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u00012w\b\u0004\u0010@\u001aq\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110C¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002H\u00170+H\u0087\bø\u0001\u0000¢\u0006\u0002\bDJÔ\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u00012\u008d\u0001\b\u0004\u0010@\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H\u00170/H\u0086\bø\u0001\u0000JÑ\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u00012\u008d\u0001\b\u0004\u0010@\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110C¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H\u00170/H\u0087\bø\u0001\u0000¢\u0006\u0002\bDJñ\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00106\u0018\u00012¢\u0001\b\u0004\u0010@\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H6¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H\u001703H\u0086\bø\u0001\u0000Jî\u0001\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u00012¢\u0001\b\u0004\u0010@\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110C¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H\u001703H\u0087\bø\u0001\u0000¢\u0006\u0002\bDJ\u008e\u0002\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00106\u0018\u0001\"\u0006\b\b\u0010:\u0018\u00012·\u0001\b\u0004\u0010@\u001a°\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H6¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H:¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(<\u0012\u0004\u0012\u0002H\u001707H\u0086\bø\u0001\u0000J\u008b\u0002\u0010>\u001a\u00020?\"\u0006\b\u0000\u0010\u0017\u0018\u0001\"\u0006\b\u0001\u0010\u001d\u0018\u0001\"\u0006\b\u0002\u0010\"\u0018\u0001\"\u0006\b\u0003\u0010&\u0018\u0001\"\u0006\b\u0004\u0010*\u0018\u0001\"\u0006\b\u0005\u0010.\u0018\u0001\"\u0006\b\u0006\u00102\u0018\u0001\"\u0006\b\u0007\u00106\u0018\u00012·\u0001\b\u0004\u0010@\u001a°\u0001\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(0\u0012\u0013\u0012\u0011H2¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(4\u0012\u0013\u0012\u0011H6¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110C¢\u0006\f\b\u001f\u0012\b\b\u0002\u0012\u0004\b\b(<\u0012\u0004\u0012\u0002H\u001707H\u0087\bø\u0001\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020\u0010H\u0000¢\u0006\u0002\bFR\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006G"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "", "name", "", "converters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/types/TypeConverterProvider;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getConverters$annotations", "getConverters", "()Lexpo/modules/kotlin/types/TypeConverterProvider;", "asyncFunctionComponent", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "getAsyncFunctionComponent$annotations", "getAsyncFunctionComponent", "()Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "setAsyncFunctionComponent", "(Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;)V", "SuspendBody", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P0", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "p0", "(Lkotlin/jvm/functions/Function2;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P1", "Lkotlin/Function3;", "p1", "(Lkotlin/jvm/functions/Function3;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P2", "Lkotlin/Function4;", "p2", "(Lkotlin/jvm/functions/Function4;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P3", "Lkotlin/Function5;", "p3", "(Lkotlin/jvm/functions/Function5;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P4", "Lkotlin/Function6;", "p4", "(Lkotlin/jvm/functions/Function6;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P5", "Lkotlin/Function7;", "p5", "(Lkotlin/jvm/functions/Function7;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P6", "Lkotlin/Function8;", "p6", "(Lkotlin/jvm/functions/Function8;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P7", "Lkotlin/Function9;", "p7", "(Lkotlin/jvm/functions/Function9;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "AsyncBody", "Lexpo/modules/kotlin/functions/AsyncFunctionComponent;", "body", "Lkotlin/Function0;", "AsyncBodyWithoutArgs", "Lexpo/modules/kotlin/Promise;", "AsyncFunctionWithPromise", "build", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsyncFunctionBuilder {
    private BaseAsyncFunctionComponent asyncFunctionComponent;
    private final TypeConverterProvider converters;
    private final String name;

    public static /* synthetic */ void getAsyncFunctionComponent$annotations() {
    }

    public static /* synthetic */ void getConverters$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public AsyncFunctionBuilder(String name, TypeConverterProvider typeConverterProvider) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.converters = typeConverterProvider;
    }

    public /* synthetic */ AsyncFunctionBuilder(String str, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : typeConverterProvider);
    }

    public final String getName() {
        return this.name;
    }

    public final TypeConverterProvider getConverters() {
        return this.converters;
    }

    public final BaseAsyncFunctionComponent getAsyncFunctionComponent() {
        return this.asyncFunctionComponent;
    }

    public final void setAsyncFunctionComponent(BaseAsyncFunctionComponent baseAsyncFunctionComponent) {
        this.asyncFunctionComponent = baseAsyncFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$1", f = "AsyncFunctionBuilder.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01381 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01381(Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C01381> continuation) {
            super(3, continuation);
            this.$block = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            return new C01381(this.$block, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$1 for r3v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                return r4
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r3.$block
                r3.label = r2
                java.lang.Object r4 = r4.invoke(r3)
                if (r4 != r0) goto L25
                return r0
            L25:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.C01381.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$1 for r0v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r1) {
            /*
                r0 = this;
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r0.$block
                java.lang.Object r1 = r1.invoke(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.C01381.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R> BaseAsyncFunctionComponent SuspendBody(Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(getName(), new AnyType[0], new C01381(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$3", f = "AsyncFunctionBuilder.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01393 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function2<P0, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01393(Function2<? super P0, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C01393> continuation) {
            super(3, continuation);
            this.$block = function2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            C01393 c01393 = new C01393(this.$block, continuation);
            c01393.L$0 = objArr;
            return c01393.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$3 for r3v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                return r4
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
                java.lang.Object r4 = r3.L$0
                java.lang.Object[] r4 = (java.lang.Object[]) r4
                r1 = 0
                r4 = r4[r1]
                kotlin.jvm.functions.Function2<P0, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r3.$block
                r3.label = r2
                java.lang.Object r4 = r1.invoke(r4, r3)
                if (r4 != r0) goto L2c
                return r0
            L2c:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.C01393.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$3 for r1v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.Object r2 = r1.L$0
                java.lang.Object[] r2 = (java.lang.Object[]) r2
                r0 = 0
                r2 = r2[r0]
                kotlin.jvm.functions.Function2<P0, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r1.$block
                java.lang.Object r2 = r0.invoke(r2, r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.C01393.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0> SuspendFunctionComponent SuspendBody(Function2<? super P0, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1), converters);
        }
        anyTypeArr[0] = anyType;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new C01393(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$5", f = "AsyncFunctionBuilder.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01405 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function3<P0, P1, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C01405(Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super C01405> continuation) {
            super(3, continuation);
            this.$block = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            C01405 c01405 = new C01405(this.$block, continuation);
            c01405.L$0 = objArr;
            return c01405.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$5 for r4v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r5)
                return r5
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.throwOnFailure(r5)
                java.lang.Object r5 = r4.L$0
                java.lang.Object[] r5 = (java.lang.Object[]) r5
                r1 = 0
                r1 = r5[r1]
                r5 = r5[r2]
                kotlin.jvm.functions.Function3<P0, P1, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r3 = r4.$block
                r4.label = r2
                java.lang.Object r5 = r3.invoke(r1, r5, r4)
                if (r5 != r0) goto L2e
                return r0
            L2e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.C01405.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$5 for r2v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.Object r3 = r2.L$0
                java.lang.Object[] r3 = (java.lang.Object[]) r3
                r0 = 0
                r0 = r3[r0]
                r1 = 1
                r3 = r3[r1]
                kotlin.jvm.functions.Function3<P0, P1, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r2.$block
                java.lang.Object r3 = r1.invoke(r0, r3, r2)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.C01405.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0, P1> SuspendFunctionComponent SuspendBody(Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[1] = anyType2;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new C01405(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$7, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$7", f = "AsyncFunctionBuilder.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function4<P0, P1, P2, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> function4, Continuation<? super AnonymousClass7> continuation) {
            super(3, continuation);
            this.$block = function4;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass7 anonymousClass7 = new AnonymousClass7(this.$block, continuation);
            anonymousClass7.L$0 = objArr;
            return anonymousClass7.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$7 for r5v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r6)
                return r6
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                kotlin.ResultKt.throwOnFailure(r6)
                java.lang.Object r6 = r5.L$0
                java.lang.Object[] r6 = (java.lang.Object[]) r6
                r1 = 0
                r1 = r6[r1]
                r3 = r6[r2]
                r4 = 2
                r6 = r6[r4]
                kotlin.jvm.functions.Function4<P0, P1, P2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r5.$block
                r5.label = r2
                java.lang.Object r6 = r4.invoke(r1, r3, r6, r5)
                if (r6 != r0) goto L31
                return r0
            L31:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass7.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$7 for r3v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r4 = r3.L$0
                java.lang.Object[] r4 = (java.lang.Object[]) r4
                r0 = 0
                r0 = r4[r0]
                r1 = 1
                r1 = r4[r1]
                r2 = 2
                r4 = r4[r2]
                kotlin.jvm.functions.Function4<P0, P1, P2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r2 = r3.$block
                java.lang.Object r4 = r2.invoke(r0, r1, r4, r3)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass7.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0, P1, P2> SuspendFunctionComponent SuspendBody(Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[2] = anyType3;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass7(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$9, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$9", f = "AsyncFunctionBuilder.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function5<P0, P1, P2, P3, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass9(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> function5, Continuation<? super AnonymousClass9> continuation) {
            super(3, continuation);
            this.$block = function5;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$block, continuation);
            anonymousClass9.L$0 = objArr;
            return anonymousClass9.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$9 for r9v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r10)
                return r10
            Lf:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L17:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                java.lang.Object[] r10 = (java.lang.Object[]) r10
                r1 = 0
                r4 = r10[r1]
                r5 = r10[r2]
                r1 = 2
                r6 = r10[r1]
                r1 = 3
                r7 = r10[r1]
                kotlin.jvm.functions.Function5<P0, P1, P2, P3, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r3 = r9.$block
                r9.label = r2
                r8 = r9
                java.lang.Object r10 = r3.invoke(r4, r5, r6, r7, r8)
                if (r10 != r0) goto L35
                return r0
            L35:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass9.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$9 for r7v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r8 = r7.L$0
                java.lang.Object[] r8 = (java.lang.Object[]) r8
                r0 = 0
                r2 = r8[r0]
                r0 = 1
                r3 = r8[r0]
                r0 = 2
                r4 = r8[r0]
                r0 = 3
                r5 = r8[r0]
                kotlin.jvm.functions.Function5<P0, P1, P2, P3, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r7.$block
                r6 = r7
                java.lang.Object r8 = r1.invoke(r2, r3, r4, r5, r6)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass9.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SuspendFunctionComponent SuspendBody(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[3] = anyType4;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass9(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11", f = "AsyncFunctionBuilder.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass11 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function6<P0, P1, P2, P3, P4, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass11(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> function6, Continuation<? super AnonymousClass11> continuation) {
            super(3, continuation);
            this.$block = function6;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass11 anonymousClass11 = new AnonymousClass11(this.$block, continuation);
            anonymousClass11.L$0 = objArr;
            return anonymousClass11.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11 for r10v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r11)
                return r11
            Lf:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L17:
                kotlin.ResultKt.throwOnFailure(r11)
                java.lang.Object r11 = r10.L$0
                java.lang.Object[] r11 = (java.lang.Object[]) r11
                r1 = 0
                r4 = r11[r1]
                r5 = r11[r2]
                r1 = 2
                r6 = r11[r1]
                r1 = 3
                r7 = r11[r1]
                r1 = 4
                r8 = r11[r1]
                kotlin.jvm.functions.Function6<P0, P1, P2, P3, P4, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r3 = r10.$block
                r10.label = r2
                r9 = r10
                java.lang.Object r11 = r3.invoke(r4, r5, r6, r7, r8, r9)
                if (r11 != r0) goto L38
                return r0
            L38:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass11.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$11 for r8v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r9 = r8.L$0
                java.lang.Object[] r9 = (java.lang.Object[]) r9
                r0 = 0
                r2 = r9[r0]
                r0 = 1
                r3 = r9[r0]
                r0 = 2
                r4 = r9[r0]
                r0 = 3
                r5 = r9[r0]
                r0 = 4
                r6 = r9[r0]
                kotlin.jvm.functions.Function6<P0, P1, P2, P3, P4, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r8.$block
                r7 = r8
                java.lang.Object r9 = r1.invoke(r2, r3, r4, r5, r6, r7)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass11.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SuspendFunctionComponent SuspendBody(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[4] = anyType5;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass11(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$13, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$13", f = "AsyncFunctionBuilder.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass13 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function7<P0, P1, P2, P3, P4, P5, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass13(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> function7, Continuation<? super AnonymousClass13> continuation) {
            super(3, continuation);
            this.$block = function7;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass13 anonymousClass13 = new AnonymousClass13(this.$block, continuation);
            anonymousClass13.L$0 = objArr;
            return anonymousClass13.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$13 for r11v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r12)
                return r12
            Lf:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L17:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                java.lang.Object[] r12 = (java.lang.Object[]) r12
                r1 = 0
                r4 = r12[r1]
                r5 = r12[r2]
                r1 = 2
                r6 = r12[r1]
                r1 = 3
                r7 = r12[r1]
                r1 = 4
                r8 = r12[r1]
                r1 = 5
                r9 = r12[r1]
                kotlin.jvm.functions.Function7<P0, P1, P2, P3, P4, P5, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r3 = r11.$block
                r11.label = r2
                r10 = r11
                java.lang.Object r12 = r3.invoke(r4, r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L3b
                return r0
            L3b:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass13.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$13 for r9v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r10 = r9.L$0
                java.lang.Object[] r10 = (java.lang.Object[]) r10
                r0 = 0
                r2 = r10[r0]
                r0 = 1
                r3 = r10[r0]
                r0 = 2
                r4 = r10[r0]
                r0 = 3
                r5 = r10[r0]
                r0 = 4
                r6 = r10[r0]
                r0 = 5
                r7 = r10[r0]
                kotlin.jvm.functions.Function7<P0, P1, P2, P3, P4, P5, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r9.$block
                r8 = r9
                java.lang.Object r10 = r1.invoke(r2, r3, r4, r5, r6, r7, r8)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass13.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SuspendFunctionComponent SuspendBody(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> block) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19), converters);
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20), converters);
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[5] = anyType6;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass13(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$15, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$15", f = "AsyncFunctionBuilder.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass15 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function8<P0, P1, P2, P3, P4, P5, P6, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass15(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> function8, Continuation<? super AnonymousClass15> continuation) {
            super(3, continuation);
            this.$block = function8;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass15 anonymousClass15 = new AnonymousClass15(this.$block, continuation);
            anonymousClass15.L$0 = objArr;
            return anonymousClass15.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$15 for r12v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r13)
                return r13
            Lf:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L17:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                java.lang.Object[] r13 = (java.lang.Object[]) r13
                r1 = 0
                r4 = r13[r1]
                r5 = r13[r2]
                r1 = 2
                r6 = r13[r1]
                r1 = 3
                r7 = r13[r1]
                r1 = 4
                r8 = r13[r1]
                r1 = 5
                r9 = r13[r1]
                r1 = 6
                r10 = r13[r1]
                kotlin.jvm.functions.Function8<P0, P1, P2, P3, P4, P5, P6, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r3 = r12.$block
                r12.label = r2
                r11 = r12
                java.lang.Object r13 = r3.invoke(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L3e
                return r0
            L3e:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass15.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$15 for r10v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r11 = r10.L$0
                java.lang.Object[] r11 = (java.lang.Object[]) r11
                r0 = 0
                r2 = r11[r0]
                r0 = 1
                r3 = r11[r0]
                r0 = 2
                r4 = r11[r0]
                r0 = 3
                r5 = r11[r0]
                r0 = 4
                r6 = r11[r0]
                r0 = 5
                r7 = r11[r0]
                r0 = 6
                r8 = r11[r0]
                kotlin.jvm.functions.Function8<P0, P1, P2, P3, P4, P5, P6, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r10.$block
                r9 = r10
                java.lang.Object r11 = r1.invoke(r2, r3, r4, r5, r6, r7, r8, r9)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass15.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SuspendFunctionComponent SuspendBody(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> block) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$22 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$23 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$24 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$25 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$25
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$25), converters);
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$26 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$26
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$26), converters);
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$27 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$28 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[6] = anyType7;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass15(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$17, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncFunctionBuilder.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "<destruct>", ""}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$17", f = "AsyncFunctionBuilder.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass17 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
        final /* synthetic */ Function9<P0, P1, P2, P3, P4, P5, P6, P7, Continuation<? super R>, Object> $block;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass17(Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> function9, Continuation<? super AnonymousClass17> continuation) {
            super(3, continuation);
            this.$block = function9;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
            AnonymousClass17 anonymousClass17 = new AnonymousClass17(this.$block, continuation);
            anonymousClass17.L$0 = objArr;
            return anonymousClass17.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$17 for r13v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r14)
                return r14
            Lf:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L17:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.L$0
                java.lang.Object[] r14 = (java.lang.Object[]) r14
                r1 = 0
                r4 = r14[r1]
                r5 = r14[r2]
                r1 = 2
                r6 = r14[r1]
                r1 = 3
                r7 = r14[r1]
                r1 = 4
                r8 = r14[r1]
                r1 = 5
                r9 = r14[r1]
                r1 = 6
                r10 = r14[r1]
                r1 = 7
                r11 = r14[r1]
                kotlin.jvm.functions.Function9<P0, P1, P2, P3, P4, P5, P6, P7, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r3 = r13.$block
                r13.label = r2
                r12 = r13
                java.lang.Object r14 = r3.invoke(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                if (r14 != r0) goto L41
                return r0
            L41:
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass17.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$17 for r11v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r12 = r11.L$0
                java.lang.Object[] r12 = (java.lang.Object[]) r12
                r0 = 0
                r2 = r12[r0]
                r0 = 1
                r3 = r12[r0]
                r0 = 2
                r4 = r12[r0]
                r0 = 3
                r5 = r12[r0]
                r0 = 4
                r6 = r12[r0]
                r0 = 5
                r7 = r12[r0]
                r0 = 6
                r8 = r12[r0]
                r0 = 7
                r9 = r12[r0]
                kotlin.jvm.functions.Function9<P0, P1, P2, P3, P4, P5, P6, P7, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r11.$block
                r10 = r11
                java.lang.Object r12 = r1.invoke(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.functions.AsyncFunctionBuilder.AnonymousClass17.invokeSuspend$$forInline(java.lang.Object):java.lang.Object");
        }
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SuspendFunctionComponent SuspendBody(Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> block) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(block, "block");
        String name = getName();
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32), converters);
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33), converters);
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
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36 asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, asyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[7] = anyType8;
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AnonymousClass17(block, null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final AsyncFunctionComponent AsyncBodyWithoutArgs(final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(getName(), new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunctionComponent AsyncBody(final Function0<? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
        AnyType[] anyTypeArr = new AnyType[0];
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.3
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunctionComponent AsyncBody(final Function1<? super P0, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Object.class != Promise.class) {
            String name = getName();
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
                AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        return null;
                    }
                };
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1), converters);
            }
            anyTypeArr[0] = anyType;
            Intrinsics.needClassReification();
            Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.6
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
            asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(getName(), new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.5
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunctionComponent AsyncBody(final Function2<? super P0, ? super P1, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[1] = anyType2;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.8
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunctionComponent AsyncFunctionWithPromise(final Function2<? super P0, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[0] = anyType;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.10
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunctionComponent AsyncBody(final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[2] = anyType3;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.12
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunctionComponent AsyncFunctionWithPromise(final Function3<? super P0, ? super P1, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[1] = anyType2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.14
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunctionComponent AsyncBody(final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[3] = anyType4;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.16
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunctionComponent AsyncFunctionWithPromise(final Function4<? super P0, ? super P1, ? super P2, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[2] = anyType3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.18
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunctionComponent AsyncBody(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[4] = anyType5;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.20
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunctionComponent AsyncFunctionWithPromise(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25), converters);
        }
        anyTypeArr[3] = anyType4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.22
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunctionComponent AsyncBody(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[5] = anyType6;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.24
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunctionComponent AsyncFunctionWithPromise(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[4] = anyType5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.26
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunctionComponent AsyncBody(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        int i;
        int i2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43), converters);
        }
        anyTypeArr[6] = anyType7;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.28
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunctionComponent AsyncFunctionWithPromise(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49), converters);
        }
        anyTypeArr[5] = anyType6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.30
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunctionComponent AsyncBody(final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        int i;
        int i2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57), converters);
        }
        anyTypeArr[7] = anyType8;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.32
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
        setAsyncFunctionComponent(untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunctionComponent AsyncFunctionWithPromise(final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(body, "body");
        String name = getName();
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$58 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$58 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$58
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$58), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$59 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$59 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$59), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$60 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$60 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$60), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$61 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$61 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$61
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
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$61), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$62 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$62 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$62
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
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$62), converters);
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
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$63 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$63 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$63
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$63), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$64 asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$64 = new Function0<KType>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, asyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$64), converters);
        }
        anyTypeArr[6] = anyType7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.functions.AsyncFunctionBuilder.AsyncBody.34
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
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final BaseAsyncFunctionComponent build$expo_modules_core_release() {
        BaseAsyncFunctionComponent baseAsyncFunctionComponent = this.asyncFunctionComponent;
        if (baseAsyncFunctionComponent != null) {
            return baseAsyncFunctionComponent;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
