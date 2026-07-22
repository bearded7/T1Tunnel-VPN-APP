package expo.modules.image.events;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import expo.modules.image.ExpoImageViewWrapper;
import expo.modules.image.enums.ImageCacheType;
import expo.modules.image.records.ImageErrorEvent;
import expo.modules.image.records.ImageLoadEvent;
import expo.modules.image.records.ImageSource;
import expo.modules.image.svg.SVGPictureDrawable;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlideRequestListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J6\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/image/events/GlideRequestListener;", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "expoImageViewWrapper", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/image/ExpoImageViewWrapper;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideRequestListener implements RequestListener<Drawable> {
    private final WeakReference<ExpoImageViewWrapper> expoImageViewWrapper;

    public GlideRequestListener(WeakReference<ExpoImageViewWrapper> expoImageViewWrapper) {
        Intrinsics.checkNotNullParameter(expoImageViewWrapper, "expoImageViewWrapper");
        this.expoImageViewWrapper = expoImageViewWrapper;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
        String strRemoveSuffix;
        ViewEventCallback<ImageErrorEvent> onError$expo_image_release;
        String message;
        Intrinsics.checkNotNullParameter(target, "target");
        if (e == null || (message = e.getMessage()) == null || (strRemoveSuffix = StringsKt.removeSuffix(message, (CharSequence) "\n call GlideException#logRootCauses(String) for more detail")) == null) {
            strRemoveSuffix = "Unknown error";
        }
        ExpoImageViewWrapper expoImageViewWrapper = this.expoImageViewWrapper.get();
        if (expoImageViewWrapper != null && (onError$expo_image_release = expoImageViewWrapper.getOnError$expo_image_release()) != null) {
            onError$expo_image_release.invoke(new ImageErrorEvent(strRemoveSuffix));
        }
        Log.e("ExpoImage", strRemoveSuffix);
        if (e == null) {
            return false;
        }
        e.logRootCauses("ExpoImage");
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        boolean z = resource instanceof SVGPictureDrawable;
        SVGPictureDrawable sVGPictureDrawable = z ? (SVGPictureDrawable) resource : null;
        int svgIntrinsicWidth = sVGPictureDrawable != null ? sVGPictureDrawable.getSvgIntrinsicWidth() : resource.getIntrinsicWidth();
        SVGPictureDrawable sVGPictureDrawable2 = z ? (SVGPictureDrawable) resource : null;
        int svgIntrinsicHeight = sVGPictureDrawable2 != null ? sVGPictureDrawable2.getSvgIntrinsicHeight() : resource.getIntrinsicHeight();
        ExpoImageViewWrapper expoImageViewWrapper = this.expoImageViewWrapper.get();
        if (expoImageViewWrapper == null) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(expoImageViewWrapper.getAppContext().getMainQueue(), null, null, new AnonymousClass1(expoImageViewWrapper, dataSource, model, svgIntrinsicWidth, svgIntrinsicHeight, resource, null), 3, null);
        return false;
    }

    /* JADX INFO: renamed from: expo.modules.image.events.GlideRequestListener$onResourceReady$1, reason: invalid class name */
    /* JADX INFO: compiled from: GlideRequestListener.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.image.events.GlideRequestListener$onResourceReady$1", f = "GlideRequestListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataSource $dataSource;
        final /* synthetic */ ExpoImageViewWrapper $imageWrapper;
        final /* synthetic */ int $intrinsicHeight;
        final /* synthetic */ int $intrinsicWidth;
        final /* synthetic */ Object $model;
        final /* synthetic */ Drawable $resource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ExpoImageViewWrapper expoImageViewWrapper, DataSource dataSource, Object obj, int i, int i2, Drawable drawable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$imageWrapper = expoImageViewWrapper;
            this.$dataSource = dataSource;
            this.$model = obj;
            this.$intrinsicWidth = i;
            this.$intrinsicHeight = i2;
            this.$resource = drawable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$imageWrapper, this.$dataSource, this.$model, this.$intrinsicWidth, this.$intrinsicHeight, this.$resource, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ViewEventCallback<ImageLoadEvent> onLoad$expo_image_release = this.$imageWrapper.getOnLoad$expo_image_release();
            String strName = ImageCacheType.INSTANCE.fromNativeValue(this.$dataSource).name();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            onLoad$expo_image_release.invoke(new ImageLoadEvent(lowerCase, new ImageSource(this.$model.toString(), this.$intrinsicWidth, this.$intrinsicHeight, null, this.$resource instanceof Animatable)));
            return Unit.INSTANCE;
        }
    }
}
