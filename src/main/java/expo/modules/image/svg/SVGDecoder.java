package expo.modules.image.svg;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SVGDecoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J0\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lexpo/modules/image/svg/SVGDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Ljava/io/InputStream;", "Lcom/caverock/androidsvg/SVG;", "<init>", "()V", "handles", "", "source", "options", "Lcom/bumptech/glide/load/Options;", "decode", "Lcom/bumptech/glide/load/engine/Resource;", "width", "", "height", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SVGDecoder implements ResourceDecoder<InputStream, SVG> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream source, Options options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<SVG> decode(InputStream source, int width, int height, Options options) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            SVG fromInputStream = SVG.getFromInputStream(source);
            Intrinsics.checkNotNullExpressionValue(fromInputStream, "getFromInputStream(...)");
            if (fromInputStream.getDocumentViewBox() == null) {
                float documentWidth = fromInputStream.getDocumentWidth();
                float documentHeight = fromInputStream.getDocumentHeight();
                if (documentWidth != -1.0f && documentHeight != -1.0f) {
                    fromInputStream.setDocumentViewBox(0.0f, 0.0f, documentWidth, documentHeight);
                }
            }
            fromInputStream.setDocumentWidth(width);
            fromInputStream.setDocumentHeight(height);
            return new SimpleResource(fromInputStream);
        } catch (SVGParseException e) {
            throw new IOException("Cannot load SVG from stream", e);
        }
    }
}
