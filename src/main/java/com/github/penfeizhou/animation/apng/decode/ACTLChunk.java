package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class ACTLChunk extends Chunk {
    static final int ID = Chunk.fourCCToInt("acTL");
    int num_frames;
    int num_plays;

    ACTLChunk() {
    }

    @Override // com.github.penfeizhou.animation.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) throws IOException {
        this.num_frames = aPNGReader.readInt();
        this.num_plays = aPNGReader.readInt();
    }
}
