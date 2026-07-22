package expo.modules.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import expo.modules.image.records.ImageLoadOptions;
import expo.modules.image.records.SourceMap;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ImageLoadTask.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/image/ImageLoadTask;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "source", "Lexpo/modules/image/records/SourceMap;", "options", "Lexpo/modules/image/records/ImageLoadOptions;", "<init>", "(Lexpo/modules/kotlin/AppContext;Lexpo/modules/image/records/SourceMap;Lexpo/modules/image/records/ImageLoadOptions;)V", "load", "Lexpo/modules/image/Image;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ImageLoadTask {
    private final AppContext appContext;
    private final ImageLoadOptions options;
    private final SourceMap source;

    /* JADX INFO: renamed from: expo.modules.image.ImageLoadTask$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageLoadTask.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.image.ImageLoadTask", f = "ImageLoadTask.kt", i = {}, l = {24}, m = "load", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageLoadTask.this.load(this);
        }
    }

    public ImageLoadTask(AppContext appContext, SourceMap source, ImageLoadOptions options) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        this.appContext = appContext;
        this.source = source;
        this.options = options;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object load(Continuation<? super Image> continuation) throws ImageLoadFailed, Exceptions.ReactContextLost {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                Context reactContext = this.appContext.getReactContext();
                if (reactContext == null) {
                    throw new Exceptions.ReactContextLost();
                }
                GlideModelProvider glideModelProviderCreateGlideModelProvider = this.source.createGlideModelProvider(reactContext);
                Object glideModel = glideModelProviderCreateGlideModelProvider != null ? glideModelProviderCreateGlideModelProvider.getGlideModel() : null;
                CoroutineDispatcher io = Dispatchers.getIO();
                ImageLoadTask$load$bitmap$1 imageLoadTask$load$bitmap$1 = new ImageLoadTask$load$bitmap$1(reactContext, glideModel, this, null);
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(io, imageLoadTask$load$bitmap$1, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithContext);
            }
            Drawable drawable = (Drawable) objWithContext;
            Intrinsics.checkNotNull(drawable);
            return new Image(drawable);
        } catch (Exception e) {
            throw new ImageLoadFailed(e);
        }
    }
}
