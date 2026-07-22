package com.swmansion.reanimated;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class DrawPassDetector {
    private final ReactApplicationContext mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mClearRunnable = new Runnable() { // from class: com.swmansion.reanimated.DrawPassDetector$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private boolean mIsInDrawPass = false;

    @Nullable
    private View mDecorView = null;
    private final ViewTreeObserver.OnDrawListener mOnDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: com.swmansion.reanimated.DrawPassDetector$$ExternalSyntheticLambda1
        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            this.f$0.lambda$new$1();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        this.mIsInDrawPass = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        this.mIsInDrawPass = true;
        this.mHandler.postAtFrontOfQueue(this.mClearRunnable);
    }

    DrawPassDetector(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    void initialize() {
        View decorView;
        View view;
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null || (decorView = currentActivity.getWindow().getDecorView()) == (view = this.mDecorView)) {
            return;
        }
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnDrawListener(this.mOnDrawListener);
            }
            this.mDecorView = null;
        }
        ViewTreeObserver viewTreeObserver2 = decorView.getViewTreeObserver();
        if (viewTreeObserver2.isAlive()) {
            this.mDecorView = decorView;
            viewTreeObserver2.addOnDrawListener(this.mOnDrawListener);
        }
    }

    boolean isInDrawPass() {
        return this.mIsInDrawPass;
    }

    void invalidate() {
        if (UiThreadUtil.isOnUiThread()) {
            invalidateOnUiThread();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.swmansion.reanimated.DrawPassDetector$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.invalidateOnUiThread();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateOnUiThread() {
        View view = this.mDecorView;
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnDrawListener(this.mOnDrawListener);
            }
            this.mDecorView = null;
        }
        this.mHandler.removeCallbacks(this.mClearRunnable);
        this.mIsInDrawPass = false;
    }
}
