package expo.modules.blur;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.LinearLayout;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderEffectBlur;
import eightbitlab.com.blurview.RenderScriptBlur;
import expo.modules.blur.enums.BlurMethod;
import expo.modules.blur.enums.TintStyle;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.views.ExpoView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoBlurView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u0018J\b\u0010\u001f\u001a\u00020\u0018H\u0014J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\n\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020#H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lexpo/modules/blur/ExpoBlurView;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "blurMethod", "Lexpo/modules/blur/enums/BlurMethod;", "blurReduction", "", "blurRadius", "tint", "Lexpo/modules/blur/enums/TintStyle;", "getTint$expo_blur_release", "()Lexpo/modules/blur/enums/TintStyle;", "setTint$expo_blur_release", "(Lexpo/modules/blur/enums/TintStyle;)V", "isBlurViewConfigured", "", "blurView", "Leightbitlab/com/blurview/BlurView;", "setBlurRadius", "", "radius", "setBlurMethod", "method", "applyBlurReduction", "reductionFactor", "applyTint", "onAttachedToWindow", "configureBlurView", "applyCurrentBlurSettings", "findOptimalBlurRoot", "Landroid/view/ViewGroup;", "findNearestScreenAncestor", "isReactNativeScreen", "view", "", "getAppRootFallback", "expo-blur_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoBlurView extends ExpoView {
    private BlurMethod blurMethod;
    private float blurRadius;
    private float blurReduction;
    private final BlurView blurView;
    private boolean isBlurViewConfigured;
    private TintStyle tint;

    /* JADX INFO: compiled from: ExpoBlurView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlurMethod.values().length];
            try {
                iArr[BlurMethod.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlurMethod.DIMEZIS_BLUR_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoBlurView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.blurMethod = BlurMethod.NONE;
        this.blurReduction = 4.0f;
        this.blurRadius = 50.0f;
        this.tint = TintStyle.DEFAULT;
        BlurView blurView = new BlurView(context);
        blurView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(blurView);
        this.blurView = blurView;
    }

    /* JADX INFO: renamed from: getTint$expo_blur_release, reason: from getter */
    public final TintStyle getTint() {
        return this.tint;
    }

    public final void setTint$expo_blur_release(TintStyle tintStyle) {
        Intrinsics.checkNotNullParameter(tintStyle, "<set-?>");
        this.tint = tintStyle;
    }

    public final void setBlurRadius(float radius) {
        this.blurRadius = radius;
        if (this.isBlurViewConfigured) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.blurMethod.ordinal()];
            if (i == 1) {
                setBackgroundColor(this.tint.toBlurEffect(radius));
                return;
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.blurView.setBlurEnabled(true ^ (radius == 0.0f));
            if (radius > 0.0f) {
                this.blurView.setBlurRadius(radius / this.blurReduction);
                this.blurView.invalidate();
            }
        }
    }

    public final void setBlurMethod(BlurMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        this.blurMethod = method;
        if (this.isBlurViewConfigured) {
            int i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
            if (i == 1) {
                this.blurView.setBlurEnabled(false);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                this.blurView.setBlurEnabled(true);
                setBackgroundColor(0);
            }
            setBlurRadius(this.blurRadius);
        }
    }

    public final void applyBlurReduction(float reductionFactor) {
        this.blurReduction = reductionFactor;
        setBlurRadius(this.blurRadius);
    }

    public final void applyTint() {
        if (this.isBlurViewConfigured) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.blurMethod.ordinal()];
            if (i == 1) {
                setBackgroundColor(this.tint.toBlurEffect(this.blurRadius));
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                this.blurView.setOverlayColor(this.tint.toBlurEffect(this.blurRadius));
            }
            this.blurView.invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isBlurViewConfigured) {
            return;
        }
        this.isBlurViewConfigured = true;
        configureBlurView();
    }

    private final void configureBlurView() {
        ViewGroup viewGroupFindOptimalBlurRoot = findOptimalBlurRoot();
        Window window = getAppContext().getThrowingActivity().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (Build.VERSION.SDK_INT >= 31) {
            this.blurView.setupWith(viewGroupFindOptimalBlurRoot, new RenderEffectBlur()).setFrameClearDrawable(decorView != null ? decorView.getBackground() : null);
        } else {
            this.blurView.setupWith(viewGroupFindOptimalBlurRoot, new RenderScriptBlur(getContext())).setFrameClearDrawable(decorView != null ? decorView.getBackground() : null);
        }
        applyCurrentBlurSettings();
    }

    private final void applyCurrentBlurSettings() {
        setBlurRadius(this.blurRadius);
        setBlurMethod(this.blurMethod);
        applyTint();
    }

    private final ViewGroup findOptimalBlurRoot() {
        ViewGroup viewGroupFindNearestScreenAncestor = findNearestScreenAncestor();
        return viewGroupFindNearestScreenAncestor == null ? getAppRootFallback() : viewGroupFindNearestScreenAncestor;
    }

    private final ViewGroup findNearestScreenAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (isReactNativeScreen(parent)) {
                if (parent instanceof ViewGroup) {
                    return (ViewGroup) parent;
                }
                return null;
            }
        }
        return null;
    }

    private final boolean isReactNativeScreen(Object view) {
        return Intrinsics.areEqual(view.getClass().getName(), "com.swmansion.rnscreens.Screen");
    }

    private final ViewGroup getAppRootFallback() throws Exceptions.MissingRootView {
        ViewGroup viewGroup;
        Window window = getAppContext().getThrowingActivity().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView == null || (viewGroup = (ViewGroup) decorView.findViewById(android.R.id.content)) == null) {
            throw new Exceptions.MissingRootView();
        }
        return viewGroup;
    }
}
