package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationBackendDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 ,*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001,B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0002H\u0003R\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010&\u001a\u0004\u0018\u00018\u00002\b\u0010&\u001a\u0004\u0018\u00018\u00008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0005¨\u0006-"}, d2 = {"Lcom/facebook/fresco/animation/backend/AnimationBackendDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "_animationBackend", "<init>", "(Lcom/facebook/fresco/animation/backend/AnimationBackend;)V", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "alpha", "", "colorFilter", "Landroid/graphics/ColorFilter;", "bounds", "Landroid/graphics/Rect;", "getFrameCount", "getFrameDurationMs", "frameNumber", "getLoopDurationMs", "width", "height", "getLoopCount", "drawFrame", "", "parent", "Landroid/graphics/drawable/Drawable;", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "", "setColorFilter", "setBounds", "getSizeInBytes", "clear", "preloadAnimation", "setAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/fresco/animation/backend/AnimationBackend$Listener;", "getIntrinsicWidth", "getIntrinsicHeight", "animationBackend", "getAnimationBackend", "()Lcom/facebook/fresco/animation/backend/AnimationBackend;", "setAnimationBackend", "applyBackendProperties", "backend", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    private static final int ALPHA_UNSET = -1;
    private T _animationBackend;
    private int alpha = -1;
    private Rect bounds;
    private ColorFilter colorFilter;

    public AnimationBackendDelegate(T t) {
        this._animationBackend = t;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int frameNumber) {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getFrameDurationMs(frameNumber);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getLoopDurationMs();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable parent, Canvas canvas, int frameNumber) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        T t = this._animationBackend;
        return t != null && t.drawFrame(parent, canvas, frameNumber);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int alpha) {
        T t = this._animationBackend;
        if (t != null) {
            t.setAlpha(alpha);
        }
        this.alpha = alpha;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        T t = this._animationBackend;
        if (t != null) {
            t.setColorFilter(colorFilter);
        }
        this.colorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        T t = this._animationBackend;
        if (t != null) {
            t.setBounds(bounds);
        }
        this.bounds = bounds;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        T t = this._animationBackend;
        if (t == null) {
            return 0;
        }
        Intrinsics.checkNotNull(t);
        return t.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T t = this._animationBackend;
        if (t != null) {
            t.clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
        T t = this._animationBackend;
        if (t != null) {
            t.preloadAnimation();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(AnimationBackend.Listener listener) {
        T t = this._animationBackend;
        if (t != null) {
            t.setAnimationListener(listener);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        T t = this._animationBackend;
        if (t == null) {
            return -1;
        }
        Intrinsics.checkNotNull(t);
        return t.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        T t = this._animationBackend;
        if (t == null) {
            return -1;
        }
        Intrinsics.checkNotNull(t);
        return t.getIntrinsicHeight();
    }

    public final T getAnimationBackend() {
        return this._animationBackend;
    }

    public final void setAnimationBackend(T t) {
        this._animationBackend = t;
        if (t != null) {
            Intrinsics.checkNotNull(t);
            applyBackendProperties(t);
        }
    }

    private final void applyBackendProperties(AnimationBackend backend) {
        Rect rect = this.bounds;
        if (rect != null) {
            backend.setBounds(rect);
        }
        int i = this.alpha;
        if (i >= 0 && i <= 255) {
            backend.setAlpha(i);
        }
        ColorFilter colorFilter = this.colorFilter;
        if (colorFilter != null) {
            backend.setColorFilter(colorFilter);
        }
    }
}
