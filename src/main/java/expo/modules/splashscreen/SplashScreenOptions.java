package expo.modules.splashscreen;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: SplashScreenModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "duration", "", "getDuration$annotations", "getDuration", "()J", "fade", "", "getFade$annotations", "getFade", "()Z", "setFade", "(Z)V", "expo-splash-screen_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SplashScreenOptions implements Record {
    private final long duration = 400;
    private boolean fade = true;

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getFade$annotations() {
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getFade() {
        return this.fade;
    }

    public final void setFade(boolean z) {
        this.fade = z;
    }
}
