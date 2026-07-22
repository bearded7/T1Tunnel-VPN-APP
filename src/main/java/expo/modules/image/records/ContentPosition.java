package expo.modules.image.records;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.image.ImageUtilsKt;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContentPosition.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J®\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182y\u0010\u001a\u001au\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140\u001bj\u0002` H\u0002¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0002\b(R$\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\tR$\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\t¨\u0006*"}, d2 = {"Lexpo/modules/image/records/ContentPosition;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", ViewProps.TOP, "", "Lexpo/modules/image/records/ContentPositionValue;", "getTop$annotations", "getTop", "()Ljava/lang/Object;", ViewProps.BOTTOM, "getBottom$annotations", "getBottom", ViewProps.RIGHT, "getRight$annotations", "getRight", ViewProps.LEFT, "getLeft$annotations", "getLeft", "calcOffset", "", "isReverse", "", "imageRect", "Landroid/graphics/RectF;", "viewRect", "calcAxisOffset", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "value", "isPercentage", "Lexpo/modules/image/records/CalcAxisOffset;", "(Ljava/lang/Object;ZLandroid/graphics/RectF;Landroid/graphics/RectF;Lkotlin/jvm/functions/Function5;)Ljava/lang/Float;", "offsetX", "offsetY", "apply", "", "to", "Landroid/graphics/Matrix;", "apply$expo_image_release", "Companion", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentPosition implements Record {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ContentPosition center = new ContentPosition();
    private final Object bottom;
    private final Object left;
    private final Object right;
    private final Object top;

    @Field
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Field
    public static /* synthetic */ void getLeft$annotations() {
    }

    @Field
    public static /* synthetic */ void getRight$annotations() {
    }

    @Field
    public static /* synthetic */ void getTop$annotations() {
    }

    public final Object getTop() {
        return this.top;
    }

    public final Object getBottom() {
        return this.bottom;
    }

    public final Object getRight() {
        return this.right;
    }

    public final Object getLeft() {
        return this.left;
    }

    private final Float calcOffset(Object obj, boolean z, RectF rectF, RectF rectF2, Function5<? super Float, ? super RectF, ? super RectF, ? super Boolean, ? super Boolean, Float> function5) {
        float fFloatValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return function5.invoke(Float.valueOf((float) ((Number) obj).doubleValue()), rectF, rectF2, false, Boolean.valueOf(z));
        }
        String str = (String) obj;
        if (Intrinsics.areEqual(str, "center")) {
            fFloatValue = function5.invoke(Float.valueOf(50.0f), rectF, rectF2, true, Boolean.valueOf(z)).floatValue();
        } else {
            fFloatValue = function5.invoke(Float.valueOf(Float.parseFloat(StringsKt.removeSuffix(str, (CharSequence) "%"))), rectF, rectF2, true, Boolean.valueOf(z)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetX$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContentPosition.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function5<Float, RectF, RectF, Boolean, Boolean, Float> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(5, ImageUtilsKt.class, "calcXTranslation", "calcXTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcXTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Float invoke(Float f, RectF rectF, RectF rectF2, Boolean bool, Boolean bool2) {
            return invoke(f.floatValue(), rectF, rectF2, bool.booleanValue(), bool2.booleanValue());
        }
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetX$2, reason: invalid class name */
    /* JADX INFO: compiled from: ContentPosition.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function5<Float, RectF, RectF, Boolean, Boolean, Float> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(5, ImageUtilsKt.class, "calcXTranslation", "calcXTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcXTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Float invoke(Float f, RectF rectF, RectF rectF2, Boolean bool, Boolean bool2) {
            return invoke(f.floatValue(), rectF, rectF2, bool.booleanValue(), bool2.booleanValue());
        }
    }

    private final float offsetX(RectF imageRect, RectF viewRect) {
        Float fCalcOffset = calcOffset(this.left, false, imageRect, viewRect, AnonymousClass1.INSTANCE);
        if (fCalcOffset != null) {
            return fCalcOffset.floatValue();
        }
        Float fCalcOffset2 = calcOffset(this.right, true, imageRect, viewRect, AnonymousClass2.INSTANCE);
        if (fCalcOffset2 != null) {
            return fCalcOffset2.floatValue();
        }
        return ImageUtilsKt.calcXTranslation$default(50.0f, imageRect, viewRect, true, false, 16, null);
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetY$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentPosition.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class C01291 extends FunctionReferenceImpl implements Function5<Float, RectF, RectF, Boolean, Boolean, Float> {
        public static final C01291 INSTANCE = new C01291();

        C01291() {
            super(5, ImageUtilsKt.class, "calcYTranslation", "calcYTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcYTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Float invoke(Float f, RectF rectF, RectF rectF2, Boolean bool, Boolean bool2) {
            return invoke(f.floatValue(), rectF, rectF2, bool.booleanValue(), bool2.booleanValue());
        }
    }

    /* JADX INFO: renamed from: expo.modules.image.records.ContentPosition$offsetY$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContentPosition.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class C01302 extends FunctionReferenceImpl implements Function5<Float, RectF, RectF, Boolean, Boolean, Float> {
        public static final C01302 INSTANCE = new C01302();

        C01302() {
            super(5, ImageUtilsKt.class, "calcYTranslation", "calcYTranslation(FLandroid/graphics/RectF;Landroid/graphics/RectF;ZZ)F", 1);
        }

        public final Float invoke(float f, RectF p1, RectF p2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return Float.valueOf(ImageUtilsKt.calcYTranslation(f, p1, p2, z, z2));
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Float invoke(Float f, RectF rectF, RectF rectF2, Boolean bool, Boolean bool2) {
            return invoke(f.floatValue(), rectF, rectF2, bool.booleanValue(), bool2.booleanValue());
        }
    }

    private final float offsetY(RectF imageRect, RectF viewRect) {
        Float fCalcOffset = calcOffset(this.top, false, imageRect, viewRect, C01291.INSTANCE);
        if (fCalcOffset != null) {
            return fCalcOffset.floatValue();
        }
        Float fCalcOffset2 = calcOffset(this.bottom, true, imageRect, viewRect, C01302.INSTANCE);
        if (fCalcOffset2 != null) {
            return fCalcOffset2.floatValue();
        }
        return ImageUtilsKt.calcYTranslation$default(50.0f, imageRect, viewRect, true, false, 16, null);
    }

    public final void apply$expo_image_release(Matrix to, RectF imageRect, RectF viewRect) {
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(imageRect, "imageRect");
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        to.postTranslate(offsetX(imageRect, viewRect), offsetY(imageRect, viewRect));
    }

    /* JADX INFO: compiled from: ContentPosition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/image/records/ContentPosition$Companion;", "", "<init>", "()V", "center", "Lexpo/modules/image/records/ContentPosition;", "getCenter", "()Lexpo/modules/image/records/ContentPosition;", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentPosition getCenter() {
            return ContentPosition.center;
        }
    }
}
