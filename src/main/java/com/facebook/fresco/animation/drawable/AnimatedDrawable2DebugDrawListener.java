package com.facebook.fresco.animation.drawable;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.FrameScheduler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedDrawable2DebugDrawListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jh\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2DebugDrawListener;", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2$DrawListener;", "<init>", "()V", "lastFrameNumber", "", "skippedFrames", "duplicateFrames", "drawCalls", "onDraw", "", "animatedDrawable", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "frameScheduler", "Lcom/facebook/fresco/animation/frame/FrameScheduler;", "frameNumberToDraw", "frameDrawn", "", "isAnimationRunning", "animationStartTimeMs", "", "animationTimeMs", "lastFrameAnimationTimeMs", "actualRenderTimeStartMs", "actualRenderTimeEndMs", "startRenderTimeForNextFrameMs", "scheduledRenderTimeForNextFrameMs", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimatedDrawable2DebugDrawListener implements AnimatedDrawable2.DrawListener {
    private static final Class<?> TAG = AnimatedDrawable2DebugDrawListener.class;
    private int drawCalls;
    private int duplicateFrames;
    private int lastFrameNumber = -1;
    private int skippedFrames;

    @Override // com.facebook.fresco.animation.drawable.AnimatedDrawable2.DrawListener
    public void onDraw(AnimatedDrawable2 animatedDrawable, FrameScheduler frameScheduler, int frameNumberToDraw, boolean frameDrawn, boolean isAnimationRunning, long animationStartTimeMs, long animationTimeMs, long lastFrameAnimationTimeMs, long actualRenderTimeStartMs, long actualRenderTimeEndMs, long startRenderTimeForNextFrameMs, long scheduledRenderTimeForNextFrameMs) {
        Intrinsics.checkNotNullParameter(animatedDrawable, "animatedDrawable");
        Intrinsics.checkNotNullParameter(frameScheduler, "frameScheduler");
        AnimationBackend animationBackend = animatedDrawable.get_animationBackend();
        if (animationBackend != null) {
            int frameCount = animationBackend.getFrameCount();
            long j = animationTimeMs - lastFrameAnimationTimeMs;
            this.drawCalls++;
            int i = this.lastFrameNumber;
            int i2 = (i + 1) % frameCount;
            if (i2 != frameNumberToDraw) {
                if (i == frameNumberToDraw) {
                    this.duplicateFrames++;
                } else {
                    int i3 = (frameNumberToDraw - i2) % frameCount;
                    if (i3 < 0) {
                        i3 += frameCount;
                    }
                    this.skippedFrames += i3;
                }
            }
            this.lastFrameNumber = frameNumberToDraw;
            FLog.d(TAG, "draw: frame: %2d, drawn: %b, delay: %3d ms, rendering: %3d ms, prev: %3d ms ago, duplicates: %3d, skipped: %3d, draw calls: %4d, anim time: %6d ms, next start: %6d ms, next scheduled: %6d ms", Integer.valueOf(frameNumberToDraw), Boolean.valueOf(frameDrawn), Long.valueOf((animationTimeMs % frameScheduler.getLoopDurationMs()) - frameScheduler.getTargetRenderTimeMs(frameNumberToDraw)), Long.valueOf(actualRenderTimeEndMs - actualRenderTimeStartMs), Long.valueOf(j), Integer.valueOf(this.duplicateFrames), Integer.valueOf(this.skippedFrames), Integer.valueOf(this.drawCalls), Long.valueOf(animationTimeMs), Long.valueOf(startRenderTimeForNextFrameMs), Long.valueOf(scheduledRenderTimeForNextFrameMs));
        }
    }
}
