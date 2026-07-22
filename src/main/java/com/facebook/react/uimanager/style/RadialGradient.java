package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Shader;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RadialGradient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0004&'()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J<\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0018H\u0002J<\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J4\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient;", "Lcom/facebook/react/uimanager/style/Gradient;", "shape", "Lcom/facebook/react/uimanager/style/RadialGradient$Shape;", "size", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize;", ViewProps.POSITION, "Lcom/facebook/react/uimanager/style/RadialGradient$Position;", "colorStops", "", "Lcom/facebook/react/uimanager/style/ColorStop;", "<init>", "(Lcom/facebook/react/uimanager/style/RadialGradient$Shape;Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize;Lcom/facebook/react/uimanager/style/RadialGradient$Position;Ljava/util/List;)V", "getShape", "()Lcom/facebook/react/uimanager/style/RadialGradient$Shape;", "getSize", "()Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize;", "getPosition", "()Lcom/facebook/react/uimanager/style/RadialGradient$Position;", "getColorStops", "()Ljava/util/List;", "getShader", "Landroid/graphics/Shader;", "width", "", "height", "radiusToSide", "Lkotlin/Pair;", "centerX", "centerY", "sizeKeyword", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$KeywordType;", "calculateEllipseRadius", "offsetX", "offsetY", ViewProps.ASPECT_RATIO, "radiusToCorner", "calculateRadius", "Companion", "Shape", "GradientSize", "Position", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RadialGradient implements Gradient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ColorStop> colorStops;
    private final Position position;
    private final Shape shape;
    private final GradientSize size;

    /* JADX INFO: compiled from: RadialGradient.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GradientSize.KeywordType.values().length];
            try {
                iArr[GradientSize.KeywordType.CLOSEST_SIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GradientSize.KeywordType.FARTHEST_SIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GradientSize.KeywordType.CLOSEST_CORNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GradientSize.KeywordType.FARTHEST_CORNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RadialGradient(Shape shape, GradientSize size, Position position, List<ColorStop> colorStops) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        this.shape = shape;
        this.size = size;
        this.position = position;
        this.colorStops = colorStops;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final GradientSize getSize() {
        return this.size;
    }

    public final Position getPosition() {
        return this.position;
    }

    public final List<ColorStop> getColorStops() {
        return this.colorStops;
    }

    /* JADX INFO: compiled from: RadialGradient.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$Companion;", "", "<init>", "()V", "parse", "Lcom/facebook/react/uimanager/style/Gradient;", "gradientMap", "Lcom/facebook/react/bridge/ReadableMap;", "context", "Landroid/content/Context;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: RadialGradient.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.String.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0080  */
        /* JADX WARN: Code duplicated, block: B:41:0x009b  */
        public final Gradient parse(ReadableMap gradientMap, Context context) {
            GradientSize.Keyword keyword;
            Position position;
            ArrayList arrayList;
            Integer numValueOf;
            LengthPercentage fromDynamic;
            LengthPercentage fromDynamic2;
            LengthPercentage fromDynamic3;
            LengthPercentage fromDynamic4;
            GradientSize.Dimensions dimensions;
            String string;
            Intrinsics.checkNotNullParameter(gradientMap, "gradientMap");
            Intrinsics.checkNotNullParameter(context, "context");
            ReadableMap readableMap = gradientMap.hasKey("shape") ? gradientMap : null;
            Shape shapeFromString = (readableMap == null || (string = readableMap.getString("shape")) == null) ? null : Shape.INSTANCE.fromString(string);
            ReadableMap readableMap2 = gradientMap.hasKey("size") ? gradientMap : null;
            if (readableMap2 != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[readableMap2.getType("size").ordinal()];
                if (i == 1) {
                    GradientSize.KeywordType keywordTypeFromString = GradientSize.KeywordType.INSTANCE.fromString(readableMap2.getString("size"));
                    keyword = keywordTypeFromString != null ? new GradientSize.Keyword(keywordTypeFromString) : null;
                } else if (i != 2) {
                    keyword = null;
                } else {
                    ReadableMap map = readableMap2.getMap("size");
                    if (map == null) {
                        dimensions = null;
                    } else {
                        if (!map.hasKey("x") || !map.hasKey("y")) {
                            map = null;
                        }
                        if (map != null) {
                            LengthPercentage fromDynamic5 = LengthPercentage.INSTANCE.setFromDynamic(map.getDynamic("x"));
                            LengthPercentage fromDynamic6 = LengthPercentage.INSTANCE.setFromDynamic(map.getDynamic("y"));
                            if (fromDynamic5 == null || fromDynamic6 == null) {
                                dimensions = null;
                            } else {
                                dimensions = new GradientSize.Dimensions(fromDynamic5, fromDynamic6);
                            }
                        } else {
                            dimensions = null;
                        }
                    }
                    keyword = dimensions;
                }
            } else {
                keyword = null;
            }
            ReadableMap readableMap3 = gradientMap.hasKey(ViewProps.POSITION) ? gradientMap : null;
            if (readableMap3 != null) {
                ReadableMap map2 = readableMap3.getMap(ViewProps.POSITION);
                if (map2 == null) {
                    return null;
                }
                if (map2.hasKey(ViewProps.TOP)) {
                    fromDynamic2 = LengthPercentage.INSTANCE.setFromDynamic(map2.getDynamic(ViewProps.TOP));
                    fromDynamic = null;
                } else {
                    if (map2.hasKey(ViewProps.BOTTOM)) {
                        fromDynamic = LengthPercentage.INSTANCE.setFromDynamic(map2.getDynamic(ViewProps.BOTTOM));
                        fromDynamic2 = null;
                    }
                    return null;
                }
                if (map2.hasKey(ViewProps.LEFT)) {
                    fromDynamic4 = LengthPercentage.INSTANCE.setFromDynamic(map2.getDynamic(ViewProps.LEFT));
                    fromDynamic3 = null;
                } else {
                    if (map2.hasKey(ViewProps.RIGHT)) {
                        fromDynamic3 = LengthPercentage.INSTANCE.setFromDynamic(map2.getDynamic(ViewProps.RIGHT));
                        fromDynamic4 = null;
                    }
                    return null;
                }
                position = new Position(fromDynamic2, fromDynamic4, fromDynamic3, fromDynamic);
            } else {
                position = null;
            }
            if (!gradientMap.hasKey("colorStops")) {
                gradientMap = null;
            }
            if (gradientMap != null) {
                ReadableArray array = gradientMap.getArray("colorStops");
                if (array == null) {
                    return null;
                }
                arrayList = new ArrayList(array.size());
                int size = array.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ReadableMap map3 = array.getMap(i2);
                    if (map3 != null) {
                        if (!map3.hasKey(ViewProps.COLOR) || map3.isNull(ViewProps.COLOR)) {
                            numValueOf = null;
                        } else if (map3.getType(ViewProps.COLOR) == ReadableType.Map) {
                            numValueOf = ColorPropConverter.getColor(map3.getMap(ViewProps.COLOR), context);
                        } else {
                            numValueOf = Integer.valueOf(map3.getInt(ViewProps.COLOR));
                        }
                        arrayList.add(new ColorStop(numValueOf, LengthPercentage.INSTANCE.setFromDynamic(map3.getDynamic(ViewProps.POSITION))));
                    }
                }
            } else {
                arrayList = null;
            }
            if (shapeFromString == null || keyword == null || position == null || arrayList == null) {
                return null;
            }
            return new RadialGradient(shapeFromString, keyword, position, arrayList);
        }
    }

    /* JADX INFO: compiled from: RadialGradient.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$Shape;", "", "<init>", "(Ljava/lang/String;I)V", "CIRCLE", "ELLIPSE", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Shape {
        CIRCLE,
        ELLIPSE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public static EnumEntries<Shape> getEntries() {
            return $ENTRIES;
        }

        /* JADX INFO: compiled from: RadialGradient.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$Shape$Companion;", "", "<init>", "()V", "fromString", "Lcom/facebook/react/uimanager/style/RadialGradient$Shape;", "value", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Shape fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (Intrinsics.areEqual(value, "circle")) {
                    return Shape.CIRCLE;
                }
                if (Intrinsics.areEqual(value, "ellipse")) {
                    return Shape.ELLIPSE;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: RadialGradient.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize;", "", "<init>", "()V", "Keyword", "Dimensions", "KeywordType", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$Dimensions;", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$Keyword;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class GradientSize {
        public /* synthetic */ GradientSize(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: RadialGradient.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$Keyword;", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize;", "keyword", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$KeywordType;", "<init>", "(Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$KeywordType;)V", "getKeyword", "()Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$KeywordType;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Keyword extends GradientSize {
            private final KeywordType keyword;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Keyword(KeywordType keyword) {
                super(null);
                Intrinsics.checkNotNullParameter(keyword, "keyword");
                this.keyword = keyword;
            }

            public final KeywordType getKeyword() {
                return this.keyword;
            }
        }

        private GradientSize() {
        }

        /* JADX INFO: compiled from: RadialGradient.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$Dimensions;", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize;", "x", "Lcom/facebook/react/uimanager/LengthPercentage;", "y", "<init>", "(Lcom/facebook/react/uimanager/LengthPercentage;Lcom/facebook/react/uimanager/LengthPercentage;)V", "getX", "()Lcom/facebook/react/uimanager/LengthPercentage;", "getY", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Dimensions extends GradientSize {
            private final LengthPercentage x;
            private final LengthPercentage y;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Dimensions(LengthPercentage x, LengthPercentage y) {
                super(null);
                Intrinsics.checkNotNullParameter(x, "x");
                Intrinsics.checkNotNullParameter(y, "y");
                this.x = x;
                this.y = y;
            }

            public final LengthPercentage getX() {
                return this.x;
            }

            public final LengthPercentage getY() {
                return this.y;
            }
        }

        /* JADX INFO: compiled from: RadialGradient.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$KeywordType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLOSEST_SIDE", "FARTHEST_SIDE", "CLOSEST_CORNER", "FARTHEST_CORNER", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public enum KeywordType {
            CLOSEST_SIDE("closest-side"),
            FARTHEST_SIDE("farthest-side"),
            CLOSEST_CORNER("closest-corner"),
            FARTHEST_CORNER("farthest-corner");

            private final String value;
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            public static EnumEntries<KeywordType> getEntries() {
                return $ENTRIES;
            }

            KeywordType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: compiled from: RadialGradient.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$KeywordType$Companion;", "", "<init>", "()V", "fromString", "Lcom/facebook/react/uimanager/style/RadialGradient$GradientSize$KeywordType;", "value", "", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KeywordType fromString(String value) {
                    for (KeywordType keywordType : KeywordType.values()) {
                        if (Intrinsics.areEqual(keywordType.getValue(), value)) {
                            return keywordType;
                        }
                    }
                    return null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: RadialGradient.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/uimanager/style/RadialGradient$Position;", "", ViewProps.TOP, "Lcom/facebook/react/uimanager/LengthPercentage;", ViewProps.LEFT, ViewProps.RIGHT, ViewProps.BOTTOM, "<init>", "(Lcom/facebook/react/uimanager/LengthPercentage;Lcom/facebook/react/uimanager/LengthPercentage;Lcom/facebook/react/uimanager/LengthPercentage;Lcom/facebook/react/uimanager/LengthPercentage;)V", "getTop", "()Lcom/facebook/react/uimanager/LengthPercentage;", "getLeft", "getRight", "getBottom", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Position {
        private final LengthPercentage bottom;
        private final LengthPercentage left;
        private final LengthPercentage right;
        private final LengthPercentage top;

        public Position() {
            this(null, null, null, null, 15, null);
        }

        public Position(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2, LengthPercentage lengthPercentage3, LengthPercentage lengthPercentage4) {
            this.top = lengthPercentage;
            this.left = lengthPercentage2;
            this.right = lengthPercentage3;
            this.bottom = lengthPercentage4;
        }

        public /* synthetic */ Position(LengthPercentage lengthPercentage, LengthPercentage lengthPercentage2, LengthPercentage lengthPercentage3, LengthPercentage lengthPercentage4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : lengthPercentage, (i & 2) != 0 ? null : lengthPercentage2, (i & 4) != 0 ? null : lengthPercentage3, (i & 8) != 0 ? null : lengthPercentage4);
        }

        public final LengthPercentage getTop() {
            return this.top;
        }

        public final LengthPercentage getLeft() {
            return this.left;
        }

        public final LengthPercentage getRight() {
            return this.right;
        }

        public final LengthPercentage getBottom() {
            return this.bottom;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0111  */
    /* JADX WARN: Code duplicated, block: B:34:0x0119  */
    @Override // com.facebook.react.uimanager.style.Gradient
    public Shader getShader(float width, float height) {
        float fDpToPx;
        float fDpToPx2;
        float fResolve;
        float f;
        float fFloatValue;
        float fFloatValue2;
        int i;
        android.graphics.RadialGradient radialGradient;
        Integer color;
        float f2 = width / 2.0f;
        float fResolve2 = height / 2.0f;
        if (this.position.getTop() != null) {
            fResolve2 = this.position.getTop().getType() == LengthPercentageType.PERCENT ? this.position.getTop().resolve(height) : PixelUtil.INSTANCE.dpToPx(this.position.getTop().resolve(height));
        } else if (this.position.getBottom() != null) {
            if (this.position.getBottom().getType() == LengthPercentageType.PERCENT) {
                fDpToPx = this.position.getBottom().resolve(height);
            } else {
                fDpToPx = PixelUtil.INSTANCE.dpToPx(this.position.getBottom().resolve(height));
            }
            fResolve2 = height - fDpToPx;
        }
        float f3 = fResolve2;
        if (this.position.getLeft() != null) {
            fResolve = this.position.getLeft().getType() == LengthPercentageType.PERCENT ? this.position.getLeft().resolve(width) : PixelUtil.INSTANCE.dpToPx(this.position.getLeft().resolve(width));
        } else {
            if (this.position.getRight() != null) {
                if (this.position.getRight().getType() == LengthPercentageType.PERCENT) {
                    fDpToPx2 = this.position.getRight().resolve(width);
                } else {
                    fDpToPx2 = PixelUtil.INSTANCE.dpToPx(this.position.getRight().resolve(width));
                }
                fResolve = width - fDpToPx2;
            }
            f = f2;
            Pair<Float, Float> pairCalculateRadius = calculateRadius(f, f3, width, height);
            fFloatValue = pairCalculateRadius.component1().floatValue();
            fFloatValue2 = pairCalculateRadius.component2().floatValue();
            List<ProcessedColorStop> fixedColorStops = ColorStopUtils.INSTANCE.getFixedColorStops(this.colorStops, Math.max(fFloatValue, fFloatValue2));
            int[] iArr = new int[fixedColorStops.size()];
            float[] fArr = new float[fixedColorStops.size()];
            i = 0;
            for (Object obj : fixedColorStops) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ProcessedColorStop processedColorStop = (ProcessedColorStop) obj;
                color = processedColorStop.getColor();
                if (color == null && processedColorStop.getPosition() != null) {
                    iArr[i] = color.intValue();
                    fArr[i] = processedColorStop.getPosition().floatValue();
                }
                i = i2;
            }
            radialGradient = new android.graphics.RadialGradient(f, f3, Math.max(fFloatValue, 1.0E-5f), iArr, fArr, Shader.TileMode.CLAMP);
            if (this.shape != Shape.CIRCLE && !FloatUtil.floatsEqual(fFloatValue, fFloatValue2)) {
                Matrix matrix = new Matrix();
                matrix.setScale(1.0f, fFloatValue2 / fFloatValue, f, f3);
                radialGradient.setLocalMatrix(matrix);
            }
            return radialGradient;
        }
        f2 = fResolve;
        f = f2;
        Pair<Float, Float> pairCalculateRadius2 = calculateRadius(f, f3, width, height);
        fFloatValue = pairCalculateRadius2.component1().floatValue();
        fFloatValue2 = pairCalculateRadius2.component2().floatValue();
        List<ProcessedColorStop> fixedColorStops2 = ColorStopUtils.INSTANCE.getFixedColorStops(this.colorStops, Math.max(fFloatValue, fFloatValue2));
        int[] iArr2 = new int[fixedColorStops2.size()];
        float[] fArr2 = new float[fixedColorStops2.size()];
        i = 0;
        while (r0.hasNext()) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProcessedColorStop processedColorStop2 = (ProcessedColorStop) obj;
            color = processedColorStop2.getColor();
            if (color == null) {
            }
            i = i3;
        }
        radialGradient = new android.graphics.RadialGradient(f, f3, Math.max(fFloatValue, 1.0E-5f), iArr2, fArr2, Shader.TileMode.CLAMP);
        if (this.shape != Shape.CIRCLE) {
            Matrix matrix2 = new Matrix();
            matrix2.setScale(1.0f, fFloatValue2 / fFloatValue, f, f3);
            radialGradient.setLocalMatrix(matrix2);
        }
        return radialGradient;
    }

    private final Pair<Float, Float> radiusToSide(float centerX, float centerY, float width, float height, GradientSize.KeywordType sizeKeyword) {
        float fMax;
        float fMax2;
        float fMax3;
        float f = width - centerX;
        float f2 = height - centerY;
        if (sizeKeyword == GradientSize.KeywordType.CLOSEST_SIDE) {
            fMax = Math.min(centerX, f);
            fMax2 = Math.min(centerY, f2);
        } else {
            fMax = Math.max(centerX, f);
            fMax2 = Math.max(centerY, f2);
        }
        if (this.shape == Shape.CIRCLE) {
            if (sizeKeyword == GradientSize.KeywordType.CLOSEST_SIDE) {
                fMax3 = Math.min(fMax, fMax2);
            } else {
                fMax3 = Math.max(fMax, fMax2);
            }
            return new Pair<>(Float.valueOf(fMax3), Float.valueOf(fMax3));
        }
        return new Pair<>(Float.valueOf(fMax), Float.valueOf(fMax2));
    }

    private final Pair<Float, Float> calculateEllipseRadius(float offsetX, float offsetY, float aspectRatio) {
        Float fValueOf = Float.valueOf(0.0f);
        if (aspectRatio == 0.0f || Math.abs(aspectRatio) > Float.MAX_VALUE) {
            return new Pair<>(fValueOf, fValueOf);
        }
        float fSqrt = (float) Math.sqrt((offsetX * offsetX) + (offsetY * offsetY * aspectRatio * aspectRatio));
        return new Pair<>(Float.valueOf(fSqrt), Float.valueOf(fSqrt / aspectRatio));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x00ad  */
    private final Pair<Float, Float> radiusToCorner(float centerX, float centerY, float width, float height, GradientSize.KeywordType sizeKeyword) {
        GradientSize.KeywordType keywordType;
        Float fValueOf = Float.valueOf(0.0f);
        int i = 0;
        Pair[] pairArr = {new Pair(fValueOf, fValueOf), new Pair(Float.valueOf(width), fValueOf), new Pair(Float.valueOf(width), Float.valueOf(height)), new Pair(fValueOf, Float.valueOf(height))};
        double d = 2;
        float fSqrt = (float) Math.sqrt(((float) Math.pow(centerX - ((Number) pairArr[0].getFirst()).floatValue(), d)) + ((float) Math.pow(centerY - ((Number) pairArr[0].getSecond()).floatValue(), d)));
        boolean z = sizeKeyword == GradientSize.KeywordType.CLOSEST_CORNER;
        for (int i2 = 1; i2 < 4; i2++) {
            float fSqrt2 = (float) Math.sqrt(((float) Math.pow(centerX - ((Number) pairArr[i2].getFirst()).floatValue(), d)) + ((float) Math.pow(centerY - ((Number) pairArr[i2].getSecond()).floatValue(), d)));
            if (z) {
                if (fSqrt2 < fSqrt) {
                    i = i2;
                    fSqrt = fSqrt2;
                }
            } else if (fSqrt2 > fSqrt) {
                i = i2;
                fSqrt = fSqrt2;
            }
        }
        if (this.shape == Shape.CIRCLE) {
            return new Pair<>(Float.valueOf(fSqrt), Float.valueOf(fSqrt));
        }
        if (z) {
            keywordType = GradientSize.KeywordType.CLOSEST_SIDE;
        } else {
            keywordType = GradientSize.KeywordType.FARTHEST_SIDE;
        }
        Pair<Float, Float> pairRadiusToSide = radiusToSide(centerX, centerY, width, height, keywordType);
        return calculateEllipseRadius(((Number) pairArr[i].getFirst()).floatValue() - centerX, ((Number) pairArr[i].getSecond()).floatValue() - centerY, pairRadiusToSide.getFirst().floatValue() / pairRadiusToSide.getSecond().floatValue());
    }

    private final Pair<Float, Float> calculateRadius(float centerX, float centerY, float width, float height) {
        GradientSize gradientSize = this.size;
        if (gradientSize instanceof GradientSize.Keyword) {
            GradientSize.KeywordType keyword = ((GradientSize.Keyword) gradientSize).getKeyword();
            int i = WhenMappings.$EnumSwitchMapping$0[keyword.ordinal()];
            if (i == 1 || i == 2) {
                return radiusToSide(centerX, centerY, width, height, keyword);
            }
            if (i == 3 || i == 4) {
                return radiusToCorner(centerX, centerY, width, height, keyword);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (gradientSize instanceof GradientSize.Dimensions) {
            float fResolve = ((GradientSize.Dimensions) gradientSize).getX().getType() == LengthPercentageType.PERCENT ? ((GradientSize.Dimensions) this.size).getX().resolve(width) : PixelUtil.INSTANCE.dpToPx(((GradientSize.Dimensions) this.size).getX().resolve(width));
            float fResolve2 = ((GradientSize.Dimensions) this.size).getY().getType() == LengthPercentageType.PERCENT ? ((GradientSize.Dimensions) this.size).getY().resolve(height) : PixelUtil.INSTANCE.dpToPx(((GradientSize.Dimensions) this.size).getY().resolve(height));
            if (this.shape == Shape.CIRCLE) {
                float fMax = Math.max(fResolve, fResolve2);
                return new Pair<>(Float.valueOf(fMax), Float.valueOf(fMax));
            }
            return new Pair<>(Float.valueOf(fResolve), Float.valueOf(fResolve2));
        }
        return radiusToCorner(centerX, centerY, width, height, GradientSize.KeywordType.FARTHEST_CORNER);
    }
}
