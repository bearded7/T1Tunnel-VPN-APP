package com.canhub.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.soloader.Elf64;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: BitmapLoadingWorkerJob.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001fB!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00050\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/canhub/cropper/BitmapLoadingWorkerJob;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "cropImageView", "Lcom/canhub/cropper/CropImageView;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Lcom/canhub/cropper/CropImageView;Landroid/net/Uri;)V", "getUri$cropper_release", "()Landroid/net/Uri;", "width", "", "height", "cropImageViewReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "job", "Lkotlinx/coroutines/Job;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", ViewProps.START, "", "onPostExecute", "result", "Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;", "(Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "Result", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapLoadingWorkerJob implements CoroutineScope {
    private final Context context;
    private final WeakReference<CropImageView> cropImageViewReference;
    private final int height;
    private Job job;
    private final Uri uri;
    private final int width;

    public BitmapLoadingWorkerJob(Context context, CropImageView cropImageView, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cropImageView, "cropImageView");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.uri = uri;
        this.cropImageViewReference = new WeakReference<>(cropImageView);
        this.job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        double d = displayMetrics.density > 1.0f ? 1.0d / ((double) displayMetrics.density) : 1.0d;
        this.width = (int) (((double) displayMetrics.widthPixels) * d);
        this.height = (int) (((double) displayMetrics.heightPixels) * d);
    }

    /* JADX INFO: renamed from: getUri$cropper_release, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job);
    }

    /* JADX INFO: renamed from: com.canhub.cropper.BitmapLoadingWorkerJob$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: BitmapLoadingWorkerJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.canhub.cropper.BitmapLoadingWorkerJob$start$1", f = "BitmapLoadingWorkerJob.kt", i = {}, l = {Elf64.Ehdr.E_EHSIZE, 66}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BitmapLoadingWorkerJob.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0096, code lost:
        
            if (r13.this$0.onPostExecute(new com.canhub.cropper.BitmapLoadingWorkerJob.Result(r13.this$0.getUri(), r14.getBitmap(), r0.getSampleSize(), r14.getDegrees(), r14.getFlipHorizontally(), r14.getFlipVertically(), null), r13) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00b4, code lost:
        
            if (r13.this$0.onPostExecute(new com.canhub.cropper.BitmapLoadingWorkerJob.Result(r13.this$0.getUri(), null, 0, 0, false, false, r0), r13) == r1) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b6, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r13.label
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L24
                if (r0 == r3) goto L1b
                if (r0 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r14)
                goto Lb7
            L13:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1b:
                kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L20
                goto Lb7
            L20:
                r0 = move-exception
                r14 = r0
                r10 = r14
                goto L99
            L24:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.L$0
                kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r14)     // Catch: java.lang.Exception -> L20
                if (r0 == 0) goto Lb7
                com.canhub.cropper.BitmapUtils r0 = com.canhub.cropper.BitmapUtils.INSTANCE     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r4 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                android.content.Context r4 = com.canhub.cropper.BitmapLoadingWorkerJob.access$getContext$p(r4)     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r5 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                android.net.Uri r5 = r5.getUri()     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r6 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                int r6 = com.canhub.cropper.BitmapLoadingWorkerJob.access$getWidth$p(r6)     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r7 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                int r7 = com.canhub.cropper.BitmapLoadingWorkerJob.access$getHeight$p(r7)     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapUtils$BitmapSampled r0 = r0.decodeSampledBitmap(r4, r5, r6, r7)     // Catch: java.lang.Exception -> L20
                boolean r14 = kotlinx.coroutines.CoroutineScopeKt.isActive(r14)     // Catch: java.lang.Exception -> L20
                if (r14 == 0) goto Lb7
                com.canhub.cropper.BitmapUtils r14 = com.canhub.cropper.BitmapUtils.INSTANCE     // Catch: java.lang.Exception -> L20
                android.graphics.Bitmap r4 = r0.getBitmap()     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r5 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                android.content.Context r5 = com.canhub.cropper.BitmapLoadingWorkerJob.access$getContext$p(r5)     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r6 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                android.net.Uri r6 = r6.getUri()     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapUtils$RotateBitmapResult r14 = r14.orientateBitmapByExif(r4, r5, r6)     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r4 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob$Result r5 = new com.canhub.cropper.BitmapLoadingWorkerJob$Result     // Catch: java.lang.Exception -> L20
                com.canhub.cropper.BitmapLoadingWorkerJob r6 = com.canhub.cropper.BitmapLoadingWorkerJob.this     // Catch: java.lang.Exception -> L20
                android.net.Uri r6 = r6.getUri()     // Catch: java.lang.Exception -> L20
                android.graphics.Bitmap r7 = r14.getBitmap()     // Catch: java.lang.Exception -> L20
                int r8 = r0.getSampleSize()     // Catch: java.lang.Exception -> L20
                int r9 = r14.getDegrees()     // Catch: java.lang.Exception -> L20
                boolean r10 = r14.getFlipHorizontally()     // Catch: java.lang.Exception -> L20
                boolean r11 = r14.getFlipVertically()     // Catch: java.lang.Exception -> L20
                r12 = 0
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L20
                r14 = r13
                kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14     // Catch: java.lang.Exception -> L20
                r13.label = r3     // Catch: java.lang.Exception -> L20
                java.lang.Object r14 = com.canhub.cropper.BitmapLoadingWorkerJob.access$onPostExecute(r4, r5, r14)     // Catch: java.lang.Exception -> L20
                if (r14 != r1) goto Lb7
                goto Lb6
            L99:
                com.canhub.cropper.BitmapLoadingWorkerJob r14 = com.canhub.cropper.BitmapLoadingWorkerJob.this
                com.canhub.cropper.BitmapLoadingWorkerJob$Result r3 = new com.canhub.cropper.BitmapLoadingWorkerJob$Result
                com.canhub.cropper.BitmapLoadingWorkerJob r0 = com.canhub.cropper.BitmapLoadingWorkerJob.this
                android.net.Uri r4 = r0.getUri()
                r8 = 0
                r9 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                r0 = r13
                kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                r13.label = r2
                java.lang.Object r14 = com.canhub.cropper.BitmapLoadingWorkerJob.access$onPostExecute(r14, r3, r0)
                if (r14 != r1) goto Lb7
            Lb6:
                return r1
            Lb7:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.BitmapLoadingWorkerJob.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void start() {
        this.job = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getDefault(), null, new AnonymousClass1(null), 2, null);
    }

    /* JADX INFO: renamed from: com.canhub.cropper.BitmapLoadingWorkerJob$onPostExecute$2, reason: invalid class name */
    /* JADX INFO: compiled from: BitmapLoadingWorkerJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.canhub.cropper.BitmapLoadingWorkerJob$onPostExecute$2", f = "BitmapLoadingWorkerJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Result $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Result result, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$result = result;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = BitmapLoadingWorkerJob.this.new AnonymousClass2(this.$result, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CropImageView cropImageView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (CoroutineScopeKt.isActive(coroutineScope) && (cropImageView = (CropImageView) BitmapLoadingWorkerJob.this.cropImageViewReference.get()) != null) {
                Result result = this.$result;
                booleanRef.element = true;
                cropImageView.onSetImageUriAsyncComplete$cropper_release(result);
            }
            if (!booleanRef.element && this.$result.getBitmap() != null) {
                this.$result.getBitmap().recycle();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onPostExecute(Result result, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(result, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void cancel() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    /* JADX INFO: compiled from: BitmapLoadingWorkerJob.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u000e\u0010\f\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u0016\u0010$\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ^\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001b\u0010\f\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;", "", "uri", "Landroid/net/Uri;", "bitmap", "Landroid/graphics/Bitmap;", "loadSampleSize", "", "degreesRotated", "flipHorizontally", "", "flipVertically", "error", "Lkotlin/Exception;", "Ljava/lang/Exception;", "<init>", "(Landroid/net/Uri;Landroid/graphics/Bitmap;IIZZLjava/lang/Exception;)V", "getUri", "()Landroid/net/Uri;", "getBitmap", "()Landroid/graphics/Bitmap;", "getLoadSampleSize", "()I", "getDegreesRotated", "getFlipHorizontally", "()Z", "getFlipVertically", "getError", "()Ljava/lang/Exception;", "Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Landroid/net/Uri;Landroid/graphics/Bitmap;IIZZLjava/lang/Exception;)Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;", "equals", "other", "hashCode", "toString", "", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Result {
        private final Bitmap bitmap;
        private final int degreesRotated;
        private final Exception error;
        private final boolean flipHorizontally;
        private final boolean flipVertically;
        private final int loadSampleSize;
        private final Uri uri;

        public static /* synthetic */ Result copy$default(Result result, Uri uri, Bitmap bitmap, int i, int i2, boolean z, boolean z2, Exception exc, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = result.uri;
            }
            if ((i3 & 2) != 0) {
                bitmap = result.bitmap;
            }
            if ((i3 & 4) != 0) {
                i = result.loadSampleSize;
            }
            if ((i3 & 8) != 0) {
                i2 = result.degreesRotated;
            }
            if ((i3 & 16) != 0) {
                z = result.flipHorizontally;
            }
            if ((i3 & 32) != 0) {
                z2 = result.flipVertically;
            }
            if ((i3 & 64) != 0) {
                exc = result.error;
            }
            boolean z3 = z2;
            Exception exc2 = exc;
            boolean z4 = z;
            int i4 = i;
            return result.copy(uri, bitmap, i4, i2, z4, z3, exc2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getLoadSampleSize() {
            return this.loadSampleSize;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getDegreesRotated() {
            return this.degreesRotated;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getFlipHorizontally() {
            return this.flipHorizontally;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getFlipVertically() {
            return this.flipVertically;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Exception getError() {
            return this.error;
        }

        public final Result copy(Uri uri, Bitmap bitmap, int loadSampleSize, int degreesRotated, boolean flipHorizontally, boolean flipVertically, Exception error) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new Result(uri, bitmap, loadSampleSize, degreesRotated, flipHorizontally, flipVertically, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.uri, result.uri) && Intrinsics.areEqual(this.bitmap, result.bitmap) && this.loadSampleSize == result.loadSampleSize && this.degreesRotated == result.degreesRotated && this.flipHorizontally == result.flipHorizontally && this.flipVertically == result.flipVertically && Intrinsics.areEqual(this.error, result.error);
        }

        public int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            Bitmap bitmap = this.bitmap;
            int iHashCode2 = (((((((((iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31) + Integer.hashCode(this.loadSampleSize)) * 31) + Integer.hashCode(this.degreesRotated)) * 31) + Boolean.hashCode(this.flipHorizontally)) * 31) + Boolean.hashCode(this.flipVertically)) * 31;
            Exception exc = this.error;
            return iHashCode2 + (exc != null ? exc.hashCode() : 0);
        }

        public String toString() {
            return "Result(uri=" + this.uri + ", bitmap=" + this.bitmap + ", loadSampleSize=" + this.loadSampleSize + ", degreesRotated=" + this.degreesRotated + ", flipHorizontally=" + this.flipHorizontally + ", flipVertically=" + this.flipVertically + ", error=" + this.error + ")";
        }

        public Result(Uri uri, Bitmap bitmap, int i, int i2, boolean z, boolean z2, Exception exc) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.bitmap = bitmap;
            this.loadSampleSize = i;
            this.degreesRotated = i2;
            this.flipHorizontally = z;
            this.flipVertically = z2;
            this.error = exc;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getLoadSampleSize() {
            return this.loadSampleSize;
        }

        public final int getDegreesRotated() {
            return this.degreesRotated;
        }

        public final boolean getFlipHorizontally() {
            return this.flipHorizontally;
        }

        public final boolean getFlipVertically() {
            return this.flipVertically;
        }

        public final Exception getError() {
            return this.error;
        }
    }
}
