package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurhashEncoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ(\u0010\u000b\u001a\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0002J4\u0010\u0010\u001a\u00020\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00140\u00132\n\u0010\u0015\u001a\u00060\u000ej\u0002`\u000fH\u0002JL\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\"\u0010\u001f\u001a\u00020\n2\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0014H\u0002J*\u0010 \u001a\u00020\n2\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010!\u001a\u00020\u0011H\u0002JJ\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashEncoder;", "", "<init>", "()V", "encode", "", "image", "Landroid/graphics/Bitmap;", "numberOfComponents", "Lkotlin/Pair;", "", "encodeFlag", "", "hashBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "encodeMaximumValue", "", "ac", "", "Lkotlin/Triple;", "hash", "calculateBlurFactors", "pixels", "", "width", "height", "encode83", "value", "length", "ENCODE_CHARACTERS", "encodeDC", "encodeAC", "maximumValue", "multiplyBasisFunction", "x", "y", "normalisation", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlurhashEncoder {
    private static final String ENCODE_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%*+,-.:;=?@[]^_{|}~";
    public static final BlurhashEncoder INSTANCE = new BlurhashEncoder();

    private BlurhashEncoder() {
    }

    public final String encode(Bitmap image, Pair<Integer, Integer> numberOfComponents) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(numberOfComponents, "numberOfComponents");
        int[] iArr = new int[image.getWidth() * image.getHeight()];
        image.getPixels(iArr, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
        List<Triple<Float, Float, Float>> listCalculateBlurFactors = calculateBlurFactors(iArr, image.getWidth(), image.getHeight(), numberOfComponents);
        Triple<Float, Float, Float> triple = (Triple) CollectionsKt.first((List) listCalculateBlurFactors);
        List<Triple<Float, Float, Float>> listDrop = CollectionsKt.drop(listCalculateBlurFactors, 1);
        StringBuilder sb = new StringBuilder();
        encodeFlag(numberOfComponents, sb);
        float fEncodeMaximumValue = encodeMaximumValue(listDrop, sb);
        sb.append(encode83(encodeDC(triple), 4));
        Iterator<Triple<Float, Float, Float>> it = listDrop.iterator();
        while (it.hasNext()) {
            sb.append(encode83(encodeAC(it.next(), fEncodeMaximumValue), 2));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final void encodeFlag(Pair<Integer, Integer> numberOfComponents, StringBuilder hashBuilder) {
        hashBuilder.append(encode83((numberOfComponents.getFirst().intValue() - 1) + ((numberOfComponents.getSecond().intValue() - 1) * 9), 1));
    }

    private final float encodeMaximumValue(List<Triple<Float, Float, Float>> ac, StringBuilder hash) {
        if (!ac.isEmpty()) {
            Iterator<T> it = ac.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Triple triple = (Triple) it.next();
            float fMax = Math.max(Math.max(Math.abs(((Number) triple.getFirst()).floatValue()), Math.abs(((Number) triple.getSecond()).floatValue())), Math.abs(((Number) triple.getThird()).floatValue()));
            while (it.hasNext()) {
                Triple triple2 = (Triple) it.next();
                fMax = Math.max(fMax, Math.max(Math.max(Math.abs(((Number) triple2.getFirst()).floatValue()), Math.abs(((Number) triple2.getSecond()).floatValue())), Math.abs(((Number) triple2.getThird()).floatValue())));
            }
            int iMax = (int) Math.max(0.0f, Math.min(82.0f, (float) Math.floor((fMax * 166.0f) - 0.5f)));
            float f = (iMax + 1) / 166.0f;
            hash.append(encode83(iMax, 1));
            return f;
        }
        hash.append(encode83(0, 1));
        return 1.0f;
    }

    private final List<Triple<Float, Float, Float>> calculateBlurFactors(int[] pixels, int width, int height, Pair<Integer, Integer> numberOfComponents) {
        ArrayList arrayList = new ArrayList();
        int iIntValue = numberOfComponents.getSecond().intValue();
        int i = 0;
        while (i < iIntValue) {
            int iIntValue2 = numberOfComponents.getFirst().intValue();
            int i2 = 0;
            while (i2 < iIntValue2) {
                int[] iArr = pixels;
                int i3 = width;
                int i4 = height;
                arrayList.add(multiplyBasisFunction(iArr, i3, i4, i2, i, (i2 == 0 && i == 0) ? 1.0f : 2.0f));
                i2++;
                pixels = iArr;
                width = i3;
                height = i4;
            }
            i++;
        }
        return arrayList;
    }

    private final String encode83(int value, int length) {
        String str = "";
        int i = 1;
        if (1 <= length) {
            while (true) {
                str = str + ENCODE_CHARACTERS.charAt((int) ((value / ((float) Math.pow(83.0f, length - i))) % 83.0f));
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return str;
    }

    private final int encodeDC(Triple<Float, Float, Float> value) {
        return (BlurhashHelpers.INSTANCE.linearTosRGB(value.getFirst().floatValue()) << 16) + (BlurhashHelpers.INSTANCE.linearTosRGB(value.getSecond().floatValue()) << 8) + BlurhashHelpers.INSTANCE.linearTosRGB(value.getThird().floatValue());
    }

    private final int encodeAC(Triple<Float, Float, Float> value, float maximumValue) {
        return (int) ((Math.max(0.0f, Math.min(18.0f, (float) Math.floor((BlurhashHelpers.INSTANCE.signPow(value.getFirst().floatValue() / maximumValue, 0.5f) * 9.0f) + 9.5f))) * 19.0f * 19.0f) + (Math.max(0.0f, Math.min(18.0f, (float) Math.floor((BlurhashHelpers.INSTANCE.signPow(value.getSecond().floatValue() / maximumValue, 0.5f) * 9.0f) + 9.5f))) * 19.0f) + Math.max(0.0f, Math.min(18.0f, (float) Math.floor((BlurhashHelpers.INSTANCE.signPow(value.getThird().floatValue() / maximumValue, 0.5f) * 9.0f) + 9.5f))));
    }

    private final Triple<Float, Float, Float> multiplyBasisFunction(int[] pixels, int width, int height, int x, int y, float normalisation) {
        float fSrgbToLinear = 0.0f;
        float fSrgbToLinear2 = 0.0f;
        float fSrgbToLinear3 = 0.0f;
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                float fCos = ((float) Math.cos(((x * 3.1415927f) * i2) / width)) * normalisation * ((float) Math.cos(((y * 3.1415927f) * i) / height));
                int i3 = pixels[(i * width) + i2];
                fSrgbToLinear += BlurhashHelpers.INSTANCE.srgbToLinear(Color.red(i3)) * fCos;
                fSrgbToLinear2 += BlurhashHelpers.INSTANCE.srgbToLinear(Color.green(i3)) * fCos;
                fSrgbToLinear3 += fCos * BlurhashHelpers.INSTANCE.srgbToLinear(Color.blue(i3));
            }
        }
        float f = 1.0f / (width * height);
        return new Triple<>(Float.valueOf(fSrgbToLinear * f), Float.valueOf(fSrgbToLinear2 * f), Float.valueOf(fSrgbToLinear3 * f));
    }
}
