package com.canhub.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CropImageOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\bW\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0005\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\n\u0012\b\b\u0003\u0010\u000b\u001a\u00020\n\u0012\b\b\u0003\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u001f\u001a\u00020\n\u0012\b\b\u0003\u0010 \u001a\u00020\u0015\u0012\b\b\u0003\u0010!\u001a\u00020\n\u0012\b\b\u0003\u0010\"\u001a\u00020\n\u0012\b\b\u0003\u0010#\u001a\u00020\n\u0012\b\b\u0003\u0010$\u001a\u00020\u0015\u0012\b\b\u0003\u0010%\u001a\u00020\u0015\u0012\b\b\u0003\u0010&\u001a\u00020\n\u0012\b\b\u0003\u0010'\u001a\u00020\u0015\u0012\b\b\u0003\u0010(\u001a\u00020\u0015\u0012\b\b\u0003\u0010)\u001a\u00020\u0015\u0012\b\b\u0003\u0010*\u001a\u00020\u0015\u0012\b\b\u0003\u0010+\u001a\u00020\u0015\u0012\b\b\u0003\u0010,\u001a\u00020\u0015\u0012\b\b\u0003\u0010-\u001a\u00020\u0015\u0012\b\b\u0003\u0010.\u001a\u00020\u0015\u0012\b\b\u0002\u0010/\u001a\u000200\u0012\b\b\u0003\u00101\u001a\u00020\u0015\u0012\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00105\u001a\u000206\u0012\b\b\u0002\u00107\u001a\u00020\u0015\u0012\b\b\u0003\u00108\u001a\u00020\u0015\u0012\b\b\u0003\u00109\u001a\u00020\u0015\u0012\b\b\u0002\u0010:\u001a\u00020;\u0012\b\b\u0002\u0010<\u001a\u00020\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010?\u001a\u00020\u0015\u0012\b\b\u0002\u0010@\u001a\u00020\u0003\u0012\b\b\u0002\u0010A\u001a\u00020\u0003\u0012\b\b\u0002\u0010B\u001a\u00020\u0003\u0012\b\b\u0002\u0010C\u001a\u00020\u0015\u0012\b\b\u0002\u0010D\u001a\u00020\u0003\u0012\b\b\u0002\u0010E\u001a\u00020\u0003\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u000100\u0012\b\b\u0003\u0010G\u001a\u00020\u0015\u0012\b\b\u0002\u0010H\u001a\u00020\u0003\u0012\b\b\u0002\u0010I\u001a\u00020\u0003\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K\u0012\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010M\u0012\b\b\u0003\u0010N\u001a\u00020\n\u0012\b\b\u0003\u0010O\u001a\u00020\u0015\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010K\u0012\b\b\u0003\u0010Q\u001a\u00020\u0015\u0012\n\b\u0003\u0010R\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010S\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010T\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010U\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\bV\u0010WJ\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\bHÆ\u0003J\t\u0010]\u001a\u00020\nHÆ\u0003J\t\u0010^\u001a\u00020\nHÆ\u0003J\t\u0010_\u001a\u00020\nHÆ\u0003J\t\u0010`\u001a\u00020\u000eHÆ\u0003J\t\u0010a\u001a\u00020\u0010HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0015HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0015HÆ\u0003J\t\u0010k\u001a\u00020\nHÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0015HÆ\u0003J\t\u0010n\u001a\u00020\u0015HÆ\u0003J\t\u0010o\u001a\u00020\nHÆ\u0003J\t\u0010p\u001a\u00020\u0015HÆ\u0003J\t\u0010q\u001a\u00020\nHÆ\u0003J\t\u0010r\u001a\u00020\nHÆ\u0003J\t\u0010s\u001a\u00020\nHÆ\u0003J\t\u0010t\u001a\u00020\u0015HÆ\u0003J\t\u0010u\u001a\u00020\u0015HÆ\u0003J\t\u0010v\u001a\u00020\nHÆ\u0003J\t\u0010w\u001a\u00020\u0015HÆ\u0003J\t\u0010x\u001a\u00020\u0015HÆ\u0003J\t\u0010y\u001a\u00020\u0015HÆ\u0003J\t\u0010z\u001a\u00020\u0015HÆ\u0003J\t\u0010{\u001a\u00020\u0015HÆ\u0003J\t\u0010|\u001a\u00020\u0015HÆ\u0003J\t\u0010}\u001a\u00020\u0015HÆ\u0003J\t\u0010~\u001a\u00020\u0015HÆ\u0003J\t\u0010\u007f\u001a\u000200HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0015HÆ\u0003J\u0012\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\f\u0010\u0083\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\n\u0010\u0084\u0001\u001a\u000206HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020;HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010>HÆ\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010KHÆ\u0003J\u0012\u0010\u0097\u0001\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010MHÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010KHÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0015HÆ\u0003J\u0012\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001J\u0012\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0003\u0010\u0082\u0001Jè\u0005\u0010 \u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0003\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00152\b\b\u0003\u0010\u001f\u001a\u00020\n2\b\b\u0003\u0010 \u001a\u00020\u00152\b\b\u0003\u0010!\u001a\u00020\n2\b\b\u0003\u0010\"\u001a\u00020\n2\b\b\u0003\u0010#\u001a\u00020\n2\b\b\u0003\u0010$\u001a\u00020\u00152\b\b\u0003\u0010%\u001a\u00020\u00152\b\b\u0003\u0010&\u001a\u00020\n2\b\b\u0003\u0010'\u001a\u00020\u00152\b\b\u0003\u0010(\u001a\u00020\u00152\b\b\u0003\u0010)\u001a\u00020\u00152\b\b\u0003\u0010*\u001a\u00020\u00152\b\b\u0003\u0010+\u001a\u00020\u00152\b\b\u0003\u0010,\u001a\u00020\u00152\b\b\u0003\u0010-\u001a\u00020\u00152\b\b\u0003\u0010.\u001a\u00020\u00152\b\b\u0002\u0010/\u001a\u0002002\b\b\u0003\u00101\u001a\u00020\u00152\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00152\b\b\u0003\u00108\u001a\u00020\u00152\b\b\u0003\u00109\u001a\u00020\u00152\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010?\u001a\u00020\u00152\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u00152\b\b\u0002\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020\u00032\n\b\u0002\u0010F\u001a\u0004\u0018\u0001002\b\b\u0003\u0010G\u001a\u00020\u00152\b\b\u0002\u0010H\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u00032\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010M2\b\b\u0003\u0010N\u001a\u00020\n2\b\b\u0003\u0010O\u001a\u00020\u00152\n\b\u0002\u0010P\u001a\u0004\u0018\u00010K2\b\b\u0003\u0010Q\u001a\u00020\u00152\n\b\u0003\u0010R\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010S\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010T\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010U\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0003\u0010¡\u0001J\u0007\u0010¢\u0001\u001a\u00020\u0015J\u0016\u0010£\u0001\u001a\u00020\u00032\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001HÖ\u0003J\n\u0010¦\u0001\u001a\u00020\u0015HÖ\u0001J\n\u0010§\u0001\u001a\u00020KHÖ\u0001J\u001b\u0010¨\u0001\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010¬\u0001\u001a\u00020\u0015R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0014\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020;8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010E\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010G\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010I\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010N\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010O\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Q\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0016\u0010S\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0016\u0010T\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010XR\u0016\u0010U\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010X¨\u0006\u00ad\u0001"}, d2 = {"Lcom/canhub/cropper/CropImageOptions;", "Landroid/os/Parcelable;", "imageSourceIncludeGallery", "", "imageSourceIncludeCamera", "cropShape", "Lcom/canhub/cropper/CropImageView$CropShape;", "cornerShape", "Lcom/canhub/cropper/CropImageView$CropCornerShape;", "cropCornerRadius", "", "snapRadius", "touchRadius", "guidelines", "Lcom/canhub/cropper/CropImageView$Guidelines;", "scaleType", "Lcom/canhub/cropper/CropImageView$ScaleType;", "showCropOverlay", "showCropLabel", "showProgressBar", "progressBarColor", "", "autoZoomEnabled", "multiTouchEnabled", "centerMoveEnabled", "canChangeCropWindow", "maxZoom", "initialCropWindowPaddingRatio", "fixAspectRatio", "aspectRatioX", "aspectRatioY", "borderLineThickness", "borderLineColor", "borderCornerThickness", "borderCornerOffset", "borderCornerLength", "borderCornerColor", "circleCornerFillColorHexValue", "guidelinesThickness", "guidelinesColor", ViewProps.BACKGROUND_COLOR, "minCropWindowWidth", "minCropWindowHeight", "minCropResultWidth", "minCropResultHeight", "maxCropResultWidth", "maxCropResultHeight", "activityTitle", "", "activityMenuIconColor", "activityMenuTextColor", "customOutputUri", "Landroid/net/Uri;", "outputCompressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "outputCompressQuality", "outputRequestWidth", "outputRequestHeight", "outputRequestSizeOptions", "Lcom/canhub/cropper/CropImageView$RequestSizeOptions;", "noOutputImage", "initialCropWindowRectangle", "Landroid/graphics/Rect;", "initialRotation", "allowRotation", "allowFlipping", "allowCounterRotation", "rotationDegrees", "flipHorizontally", "flipVertically", "cropMenuCropButtonTitle", "cropMenuCropButtonIcon", "skipEditing", "showIntentChooser", "intentChooserTitle", "", "intentChooserPriorityList", "", "cropperLabelTextSize", "cropperLabelTextColor", "cropperLabelText", "activityBackgroundColor", "toolbarColor", "toolbarTitleColor", "toolbarBackButtonColor", "toolbarTintColor", "<init>", "(ZZLcom/canhub/cropper/CropImageView$CropShape;Lcom/canhub/cropper/CropImageView$CropCornerShape;FFFLcom/canhub/cropper/CropImageView$Guidelines;Lcom/canhub/cropper/CropImageView$ScaleType;ZZZIZZZZIFZIIFIFFFIIFIIIIIIIILjava/lang/CharSequence;ILjava/lang/Integer;Landroid/net/Uri;Landroid/graphics/Bitmap$CompressFormat;IIILcom/canhub/cropper/CropImageView$RequestSizeOptions;ZLandroid/graphics/Rect;IZZZIZZLjava/lang/CharSequence;IZZLjava/lang/String;Ljava/util/List;FILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "()Ljava/lang/Integer;", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "copy", "(ZZLcom/canhub/cropper/CropImageView$CropShape;Lcom/canhub/cropper/CropImageView$CropCornerShape;FFFLcom/canhub/cropper/CropImageView$Guidelines;Lcom/canhub/cropper/CropImageView$ScaleType;ZZZIZZZZIFZIIFIFFFIIFIIIIIIIILjava/lang/CharSequence;ILjava/lang/Integer;Landroid/net/Uri;Landroid/graphics/Bitmap$CompressFormat;IIILcom/canhub/cropper/CropImageView$RequestSizeOptions;ZLandroid/graphics/Rect;IZZZIZZLjava/lang/CharSequence;IZZLjava/lang/String;Ljava/util/List;FILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/canhub/cropper/CropImageOptions;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "cropper_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new Creator();
    public int activityBackgroundColor;
    public int activityMenuIconColor;
    public Integer activityMenuTextColor;
    public CharSequence activityTitle;
    public boolean allowCounterRotation;
    public boolean allowFlipping;
    public boolean allowRotation;
    public int aspectRatioX;
    public int aspectRatioY;
    public boolean autoZoomEnabled;
    public int backgroundColor;
    public int borderCornerColor;
    public float borderCornerLength;
    public float borderCornerOffset;
    public float borderCornerThickness;
    public int borderLineColor;
    public float borderLineThickness;
    public boolean canChangeCropWindow;
    public boolean centerMoveEnabled;
    public int circleCornerFillColorHexValue;
    public CropImageView.CropCornerShape cornerShape;
    public float cropCornerRadius;
    public int cropMenuCropButtonIcon;
    public CharSequence cropMenuCropButtonTitle;
    public CropImageView.CropShape cropShape;
    public String cropperLabelText;
    public int cropperLabelTextColor;
    public float cropperLabelTextSize;
    public Uri customOutputUri;
    public boolean fixAspectRatio;
    public boolean flipHorizontally;
    public boolean flipVertically;
    public CropImageView.Guidelines guidelines;
    public int guidelinesColor;
    public float guidelinesThickness;
    public boolean imageSourceIncludeCamera;
    public boolean imageSourceIncludeGallery;
    public float initialCropWindowPaddingRatio;
    public Rect initialCropWindowRectangle;
    public int initialRotation;
    public List<String> intentChooserPriorityList;
    public String intentChooserTitle;
    public int maxCropResultHeight;
    public int maxCropResultWidth;
    public int maxZoom;
    public int minCropResultHeight;
    public int minCropResultWidth;
    public int minCropWindowHeight;
    public int minCropWindowWidth;
    public boolean multiTouchEnabled;
    public boolean noOutputImage;
    public Bitmap.CompressFormat outputCompressFormat;
    public int outputCompressQuality;
    public int outputRequestHeight;
    public CropImageView.RequestSizeOptions outputRequestSizeOptions;
    public int outputRequestWidth;
    public int progressBarColor;
    public int rotationDegrees;
    public CropImageView.ScaleType scaleType;
    public boolean showCropLabel;
    public boolean showCropOverlay;
    public boolean showIntentChooser;
    public boolean showProgressBar;
    public boolean skipEditing;
    public float snapRadius;
    public Integer toolbarBackButtonColor;
    public Integer toolbarColor;
    public Integer toolbarTintColor;
    public Integer toolbarTitleColor;
    public float touchRadius;

    /* JADX INFO: compiled from: CropImageOptions.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CropImageOptions> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CropImageOptions createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z11 = true;
            boolean z12 = false;
            if (parcel.readInt() == 0) {
                z11 = false;
            }
            if (parcel.readInt() != 0) {
                z12 = true;
            }
            CropImageView.CropShape cropShapeValueOf = CropImageView.CropShape.valueOf(parcel.readString());
            CropImageView.CropCornerShape cropCornerShapeValueOf = CropImageView.CropCornerShape.valueOf(parcel.readString());
            float f = parcel.readFloat();
            float f2 = parcel.readFloat();
            float f3 = parcel.readFloat();
            CropImageView.Guidelines guidelinesValueOf = CropImageView.Guidelines.valueOf(parcel.readString());
            CropImageView.ScaleType scaleTypeValueOf = CropImageView.ScaleType.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                z = false;
                z2 = z11;
            } else {
                z = false;
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z = z11;
            }
            if (parcel.readInt() != 0) {
                z = z11;
            }
            int i = parcel.readInt();
            if (parcel.readInt() != 0) {
                z3 = z;
                z4 = z11;
            } else {
                z3 = z;
                z4 = z3;
            }
            if (parcel.readInt() != 0) {
                z3 = z11;
            }
            if (parcel.readInt() != 0) {
                z3 = z11;
            }
            if (parcel.readInt() != 0) {
                z3 = z11;
            }
            int i2 = parcel.readInt();
            boolean z13 = z3;
            float f4 = parcel.readFloat();
            if (parcel.readInt() != 0) {
                z13 = z11;
            }
            int i3 = parcel.readInt();
            int i4 = parcel.readInt();
            float f5 = parcel.readFloat();
            int i5 = parcel.readInt();
            float f6 = parcel.readFloat();
            float f7 = parcel.readFloat();
            float f8 = parcel.readFloat();
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            float f9 = parcel.readFloat();
            int i8 = parcel.readInt();
            int i9 = parcel.readInt();
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            int i15 = parcel.readInt();
            CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            int i16 = parcel.readInt();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Uri uri = (Uri) parcel.readParcelable(CropImageOptions.class.getClassLoader());
            Bitmap.CompressFormat compressFormatValueOf = Bitmap.CompressFormat.valueOf(parcel.readString());
            int i17 = parcel.readInt();
            int i18 = parcel.readInt();
            int i19 = parcel.readInt();
            CropImageView.RequestSizeOptions requestSizeOptionsValueOf = CropImageView.RequestSizeOptions.valueOf(parcel.readString());
            boolean z14 = parcel.readInt() != 0 ? true : z13;
            Rect rect = (Rect) parcel.readParcelable(CropImageOptions.class.getClassLoader());
            int i20 = parcel.readInt();
            boolean z15 = parcel.readInt() != 0 ? true : z13;
            if (parcel.readInt() != 0) {
                z5 = true;
                z6 = true;
            } else {
                z5 = true;
                z6 = z13;
            }
            if (parcel.readInt() != 0) {
                z8 = z5;
                z7 = z8;
            } else {
                z7 = z5;
                z8 = z13;
            }
            int i21 = parcel.readInt();
            boolean z16 = parcel.readInt() != 0 ? z7 : z13;
            if (parcel.readInt() == 0) {
                z7 = z13;
            }
            CharSequence charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            boolean z17 = z7;
            int i22 = parcel.readInt();
            if (parcel.readInt() != 0) {
                z9 = z13;
                z10 = z17;
            } else {
                z9 = z13;
                z10 = z9;
            }
            if (parcel.readInt() == 0) {
                z17 = z9;
            }
            return new CropImageOptions(z11, z12, cropShapeValueOf, cropCornerShapeValueOf, f, f2, f3, guidelinesValueOf, scaleTypeValueOf, z2, z, z, i, z4, z3, z3, z3, i2, f4, z13, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, charSequence, i16, numValueOf, uri, compressFormatValueOf, i17, i18, i19, requestSizeOptionsValueOf, z14, rect, i20, z15, z6, z8, i21, z16, z7, charSequence2, i22, z10, z17, parcel.readString(), parcel.createStringArrayList(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x029c: RETURN 
                  (wrap com.canhub.cropper.CropImageOptions:0x0299: CONSTRUCTOR 
                  (r3v2 'z11' boolean)
                  (r4v1 'z12' boolean)
                  (r6v1 'cropShapeValueOf' com.canhub.cropper.CropImageView$CropShape)
                  (r7v1 'cropCornerShapeValueOf' com.canhub.cropper.CropImageView$CropCornerShape)
                  (r7v2 'f' float)
                  (r8v1 'f2' float)
                  (r9v1 'f3' float)
                  (r11v1 'guidelinesValueOf' com.canhub.cropper.CropImageView$Guidelines)
                  (r12v1 'scaleTypeValueOf' com.canhub.cropper.CropImageView$ScaleType)
                  (r12v3 'z2' boolean)
                  (r13v3 'z' boolean)
                  (r14v3 'z' boolean)
                  (r16v0 'i' int)
                  (r16v2 'z4' boolean)
                  (r17v3 'z3' boolean)
                  (r18v3 'z3' boolean)
                  (r19v3 'z3' boolean)
                  (r21v0 'i2' int)
                  (r21v1 'f4' float)
                  (r22v1 'z13' boolean)
                  (r24v0 'i3' int)
                  (r24v1 'i4' int)
                  (r25v1 'f5' float)
                  (r26v1 'i5' int)
                  (r27v1 'f6' float)
                  (r28v1 'f7' float)
                  (r29v1 'f8' float)
                  (r30v1 'i6' int)
                  (r31v1 'i7' int)
                  (r32v1 'f9' float)
                  (r33v1 'i8' int)
                  (r34v1 'i9' int)
                  (r35v1 'i10' int)
                  (r36v1 'i11' int)
                  (r37v1 'i12' int)
                  (r38v1 'i13' int)
                  (r39v1 'i14' int)
                  (r40v1 'i15' int)
                  (r1v6 'charSequence' java.lang.CharSequence)
                  (r42v0 'i16' int)
                  (r44v3 'numValueOf' java.lang.Integer)
                  (r1v9 'uri' android.net.Uri)
                  (r46v2 'compressFormatValueOf' android.graphics.Bitmap$CompressFormat)
                  (r46v3 'i17' int)
                  (r47v1 'i18' int)
                  (r48v1 'i19' int)
                  (r51v1 'requestSizeOptionsValueOf' com.canhub.cropper.CropImageView$RequestSizeOptions)
                  (r50v2 'z14' boolean)
                  (r1v12 'rect' android.graphics.Rect)
                  (r52v3 'i20' int)
                  (r53v3 'z15' boolean)
                  (r54v2 'z6' boolean)
                  (r55v4 'z8' boolean)
                  (r56v3 'i21' int)
                  (r57v4 'z16' boolean)
                  (r58v3 'z7' boolean)
                  (r1v15 'charSequence2' java.lang.CharSequence)
                  (r60v3 'i22' int)
                  (r61v2 'z10' boolean)
                  (r62v1 'z17' boolean)
                  (wrap java.lang.String:0x0237: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readString():java.lang.String A[MD:():java.lang.String (c), WRAPPED])
                  (wrap java.util.ArrayList<java.lang.String>:0x023f: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.createStringArrayList():java.util.ArrayList A[MD:():java.util.ArrayList<java.lang.String> (c), WRAPPED])
                  (wrap float:0x0241: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readFloat():float A[MD:():float (c), WRAPPED])
                  (wrap int:0x0245: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED])
                  (wrap java.lang.String:0x0249: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readString():java.lang.String A[MD:():java.lang.String (c), WRAPPED])
                  (wrap int:0x024d: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED])
                  (wrap java.lang.Integer:?: TERNARY null = ((wrap int:0x0251: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED]) == (0 int)) ? (null java.lang.Integer) : (wrap ??:0x025e: INVOKE 
                  (wrap int:0x025a: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED])
                 STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED]))
                  (wrap java.lang.Integer:?: TERNARY null = ((wrap int:0x0262: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED]) == (0 int)) ? (r53v1 java.lang.Integer) : (wrap ??:0x026f: INVOKE 
                  (wrap int:0x026b: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED])
                 STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED]))
                  (wrap java.lang.Integer:?: TERNARY null = ((wrap int:0x0273: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED]) == (0 int)) ? (r53v1 java.lang.Integer) : (wrap ??:0x0280: INVOKE 
                  (wrap int:0x027c: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED])
                 STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED]))
                  (wrap java.lang.Integer:?: TERNARY null = ((wrap int:0x0284: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED]) == (0 int)) ? (r53v1 java.lang.Integer) : (wrap ??:0x0295: INVOKE 
                  (wrap int:0x028d: INVOKE (r74v0 'parcel' android.os.Parcel) VIRTUAL call: android.os.Parcel.readInt():int A[MD:():int (c), WRAPPED])
                 STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer A[MD:(int):java.lang.Integer (c), WRAPPED]))
                 A[MD:(boolean, boolean, com.canhub.cropper.CropImageView$CropShape, com.canhub.cropper.CropImageView$CropCornerShape, float, float, float, com.canhub.cropper.CropImageView$Guidelines, com.canhub.cropper.CropImageView$ScaleType, boolean, boolean, boolean, int, boolean, boolean, boolean, boolean, int, float, boolean, int, int, float, int, float, float, float, int, int, float, int, int, int, int, int, int, int, int, java.lang.CharSequence, int, java.lang.Integer, android.net.Uri, android.graphics.Bitmap$CompressFormat, int, int, int, com.canhub.cropper.CropImageView$RequestSizeOptions, boolean, android.graphics.Rect, int, boolean, boolean, boolean, int, boolean, boolean, java.lang.CharSequence, int, boolean, boolean, java.lang.String, java.util.List<java.lang.String>, float, int, java.lang.String, int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer):void (m), WRAPPED] call: com.canhub.cropper.CropImageOptions.<init>(boolean, boolean, com.canhub.cropper.CropImageView$CropShape, com.canhub.cropper.CropImageView$CropCornerShape, float, float, float, com.canhub.cropper.CropImageView$Guidelines, com.canhub.cropper.CropImageView$ScaleType, boolean, boolean, boolean, int, boolean, boolean, boolean, boolean, int, float, boolean, int, int, float, int, float, float, float, int, int, float, int, int, int, int, int, int, int, int, java.lang.CharSequence, int, java.lang.Integer, android.net.Uri, android.graphics.Bitmap$CompressFormat, int, int, int, com.canhub.cropper.CropImageView$RequestSizeOptions, boolean, android.graphics.Rect, int, boolean, boolean, boolean, int, boolean, boolean, java.lang.CharSequence, int, boolean, boolean, java.lang.String, java.util.List, float, int, java.lang.String, int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer):void type: CONSTRUCTOR)
                 in method: com.canhub.cropper.CropImageOptions.Creator.createFromParcel(android.os.Parcel):com.canhub.cropper.CropImageOptions, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r53v1 java.lang.Integer
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                */
            /*
                Method dump skipped, instruction units count: 669
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.CropImageOptions.Creator.createFromParcel(android.os.Parcel):com.canhub.cropper.CropImageOptions");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CropImageOptions[] newArray(int i) {
            return new CropImageOptions[i];
        }
    }

    public CropImageOptions() {
        this(false, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1, -1, 63, null);
    }

    public CropImageOptions(boolean z) {
        this(z, false, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -2, -1, 63, null);
    }

    public CropImageOptions(boolean z, boolean z2) {
        this(z, z2, null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -4, -1, 63, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape) {
        this(z, z2, cropShape, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -8, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape) {
        this(z, z2, cropShape, cornerShape, 0.0f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -16, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f) {
        this(z, z2, cropShape, cornerShape, f, 0.0f, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -32, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2) {
        this(z, z2, cropShape, cornerShape, f, f2, 0.0f, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -64, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, null, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -128, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, null, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, InputDeviceCompat.SOURCE_ANY, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, false, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -512, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, false, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1024, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, false, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -2048, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, 0, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -4096, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -8192, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -16384, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -32768, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, SupportMenu.CATEGORY_MASK, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -131072, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -262144, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -524288, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1048576, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -2097152, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -4194304, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -8388608, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, ViewCompat.MEASURED_STATE_MASK, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -33554432, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -67108864, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -134217728, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -268435456, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -536870912, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, -1073741824, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, 0, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, Integer.MIN_VALUE, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, 0, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -1, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, 0, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -2, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, 0, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -4, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, 0, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -8, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, 0, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -16, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, 0, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -32, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, null, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -64, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, 0, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -128, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, null, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, InputDeviceCompat.SOURCE_ANY, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, null, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -512, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, null, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -1024, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, 0, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -2048, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, 0, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -4096, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, 0, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -8192, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, null, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -16384, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, false, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -32768, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, null, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, SupportMenu.CATEGORY_MASK, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, 0, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -131072, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, false, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -262144, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, false, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -524288, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, false, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -1048576, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, 0, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -2097152, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, false, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -4194304, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, false, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -8388608, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, null, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, ViewCompat.MEASURED_STATE_MASK, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, 0, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -33554432, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, false, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -67108864, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, false, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -134217728, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, null, null, 0.0f, 0, null, 0, null, null, null, null, 0, -268435456, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, null, 0.0f, 0, null, 0, null, null, null, null, 0, -536870912, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, 0.0f, 0, null, 0, null, null, null, null, 0, -1073741824, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f10, 0, null, 0, null, null, null, null, 0, Integer.MIN_VALUE, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10, int i23) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f10, i23, null, 0, null, null, null, null, 0, 0, 63, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10, int i23, String str2) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f10, i23, str2, 0, null, null, null, null, 0, 0, 62, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10, int i23, String str2, int i24) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f10, i23, str2, i24, null, null, null, null, 0, 0, 60, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10, int i23, String str2, int i24, Integer num2) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f10, i23, str2, i24, num2, null, null, null, 0, 0, 56, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10, int i23, String str2, int i24, Integer num2, Integer num3) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f10, i23, str2, i24, num2, num3, null, null, 0, 0, 48, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4) {
        this(z, z2, cropShape, cornerShape, f, f2, f3, guidelines, scaleType, z3, z4, z5, i, z6, z7, z8, z9, i2, f4, z10, i3, i4, f5, i5, f6, f7, f8, i6, i7, f9, i8, i9, i10, i11, i12, i13, i14, i15, activityTitle, i16, num, uri, outputCompressFormat, i17, i18, i19, outputRequestSizeOptions, z11, rect, i20, z12, z13, z14, i21, z15, z16, charSequence, i22, z17, z18, str, list, f10, i23, str2, i24, num2, num3, num4, null, 0, 0, 32, null);
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CropImageOptions copy$default(CropImageOptions cropImageOptions, boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cropCornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, Integer num, Uri uri, Bitmap.CompressFormat compressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions requestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence2, int i22, boolean z17, boolean z18, String str, List list, float f10, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5, int i25, int i26, int i27, Object obj) {
        Integer num6;
        Integer num7;
        boolean z19 = (i25 & 1) != 0 ? cropImageOptions.imageSourceIncludeGallery : z;
        boolean z20 = (i25 & 2) != 0 ? cropImageOptions.imageSourceIncludeCamera : z2;
        CropImageView.CropShape cropShape2 = (i25 & 4) != 0 ? cropImageOptions.cropShape : cropShape;
        CropImageView.CropCornerShape cropCornerShape2 = (i25 & 8) != 0 ? cropImageOptions.cornerShape : cropCornerShape;
        float f11 = (i25 & 16) != 0 ? cropImageOptions.cropCornerRadius : f;
        float f12 = (i25 & 32) != 0 ? cropImageOptions.snapRadius : f2;
        float f13 = (i25 & 64) != 0 ? cropImageOptions.touchRadius : f3;
        CropImageView.Guidelines guidelines2 = (i25 & 128) != 0 ? cropImageOptions.guidelines : guidelines;
        CropImageView.ScaleType scaleType2 = (i25 & 256) != 0 ? cropImageOptions.scaleType : scaleType;
        boolean z21 = (i25 & 512) != 0 ? cropImageOptions.showCropOverlay : z3;
        boolean z22 = (i25 & 1024) != 0 ? cropImageOptions.showCropLabel : z4;
        boolean z23 = (i25 & 2048) != 0 ? cropImageOptions.showProgressBar : z5;
        int i28 = (i25 & 4096) != 0 ? cropImageOptions.progressBarColor : i;
        boolean z24 = z19;
        boolean z25 = (i25 & 8192) != 0 ? cropImageOptions.autoZoomEnabled : z6;
        boolean z26 = (i25 & 16384) != 0 ? cropImageOptions.multiTouchEnabled : z7;
        boolean z27 = (i25 & 32768) != 0 ? cropImageOptions.centerMoveEnabled : z8;
        boolean z28 = (i25 & 65536) != 0 ? cropImageOptions.canChangeCropWindow : z9;
        int i29 = (i25 & 131072) != 0 ? cropImageOptions.maxZoom : i2;
        float f14 = (i25 & 262144) != 0 ? cropImageOptions.initialCropWindowPaddingRatio : f4;
        boolean z29 = (i25 & 524288) != 0 ? cropImageOptions.fixAspectRatio : z10;
        int i30 = (i25 & 1048576) != 0 ? cropImageOptions.aspectRatioX : i3;
        int i31 = (i25 & 2097152) != 0 ? cropImageOptions.aspectRatioY : i4;
        float f15 = (i25 & 4194304) != 0 ? cropImageOptions.borderLineThickness : f5;
        int i32 = (i25 & 8388608) != 0 ? cropImageOptions.borderLineColor : i5;
        float f16 = (i25 & 16777216) != 0 ? cropImageOptions.borderCornerThickness : f6;
        float f17 = (i25 & 33554432) != 0 ? cropImageOptions.borderCornerOffset : f7;
        float f18 = (i25 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? cropImageOptions.borderCornerLength : f8;
        int i33 = (i25 & 134217728) != 0 ? cropImageOptions.borderCornerColor : i6;
        int i34 = (i25 & 268435456) != 0 ? cropImageOptions.circleCornerFillColorHexValue : i7;
        float f19 = (i25 & 536870912) != 0 ? cropImageOptions.guidelinesThickness : f9;
        int i35 = (i25 & 1073741824) != 0 ? cropImageOptions.guidelinesColor : i8;
        int i36 = (i25 & Integer.MIN_VALUE) != 0 ? cropImageOptions.backgroundColor : i9;
        int i37 = (i26 & 1) != 0 ? cropImageOptions.minCropWindowWidth : i10;
        int i38 = (i26 & 2) != 0 ? cropImageOptions.minCropWindowHeight : i11;
        int i39 = (i26 & 4) != 0 ? cropImageOptions.minCropResultWidth : i12;
        int i40 = (i26 & 8) != 0 ? cropImageOptions.minCropResultHeight : i13;
        int i41 = (i26 & 16) != 0 ? cropImageOptions.maxCropResultWidth : i14;
        int i42 = (i26 & 32) != 0 ? cropImageOptions.maxCropResultHeight : i15;
        CharSequence charSequence3 = (i26 & 64) != 0 ? cropImageOptions.activityTitle : charSequence;
        int i43 = (i26 & 128) != 0 ? cropImageOptions.activityMenuIconColor : i16;
        Integer num8 = (i26 & 256) != 0 ? cropImageOptions.activityMenuTextColor : num;
        Uri uri2 = (i26 & 512) != 0 ? cropImageOptions.customOutputUri : uri;
        Bitmap.CompressFormat compressFormat2 = (i26 & 1024) != 0 ? cropImageOptions.outputCompressFormat : compressFormat;
        int i44 = (i26 & 2048) != 0 ? cropImageOptions.outputCompressQuality : i17;
        int i45 = (i26 & 4096) != 0 ? cropImageOptions.outputRequestWidth : i18;
        int i46 = (i26 & 8192) != 0 ? cropImageOptions.outputRequestHeight : i19;
        CropImageView.RequestSizeOptions requestSizeOptions2 = (i26 & 16384) != 0 ? cropImageOptions.outputRequestSizeOptions : requestSizeOptions;
        boolean z30 = (i26 & 32768) != 0 ? cropImageOptions.noOutputImage : z11;
        Rect rect2 = (i26 & 65536) != 0 ? cropImageOptions.initialCropWindowRectangle : rect;
        int i47 = (i26 & 131072) != 0 ? cropImageOptions.initialRotation : i20;
        boolean z31 = (i26 & 262144) != 0 ? cropImageOptions.allowRotation : z12;
        boolean z32 = (i26 & 524288) != 0 ? cropImageOptions.allowFlipping : z13;
        boolean z33 = (i26 & 1048576) != 0 ? cropImageOptions.allowCounterRotation : z14;
        int i48 = (i26 & 2097152) != 0 ? cropImageOptions.rotationDegrees : i21;
        boolean z34 = (i26 & 4194304) != 0 ? cropImageOptions.flipHorizontally : z15;
        boolean z35 = (i26 & 8388608) != 0 ? cropImageOptions.flipVertically : z16;
        CharSequence charSequence4 = (i26 & 16777216) != 0 ? cropImageOptions.cropMenuCropButtonTitle : charSequence2;
        int i49 = (i26 & 33554432) != 0 ? cropImageOptions.cropMenuCropButtonIcon : i22;
        boolean z36 = (i26 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? cropImageOptions.skipEditing : z17;
        boolean z37 = (i26 & 134217728) != 0 ? cropImageOptions.showIntentChooser : z18;
        String str3 = (i26 & 268435456) != 0 ? cropImageOptions.intentChooserTitle : str;
        List list2 = (i26 & 536870912) != 0 ? cropImageOptions.intentChooserPriorityList : list;
        float f20 = (i26 & 1073741824) != 0 ? cropImageOptions.cropperLabelTextSize : f10;
        int i50 = (i26 & Integer.MIN_VALUE) != 0 ? cropImageOptions.cropperLabelTextColor : i23;
        float f21 = f20;
        String str4 = (i27 & 1) != 0 ? cropImageOptions.cropperLabelText : str2;
        int i51 = (i27 & 2) != 0 ? cropImageOptions.activityBackgroundColor : i24;
        Integer num9 = (i27 & 4) != 0 ? cropImageOptions.toolbarColor : num2;
        Integer num10 = (i27 & 8) != 0 ? cropImageOptions.toolbarTitleColor : num3;
        Integer num11 = (i27 & 16) != 0 ? cropImageOptions.toolbarBackButtonColor : num4;
        if ((i27 & 32) != 0) {
            num7 = num11;
            num6 = cropImageOptions.toolbarTintColor;
        } else {
            num6 = num5;
            num7 = num11;
        }
        return cropImageOptions.copy(z24, z20, cropShape2, cropCornerShape2, f11, f12, f13, guidelines2, scaleType2, z21, z22, z23, i28, z25, z26, z27, z28, i29, f14, z29, i30, i31, f15, i32, f16, f17, f18, i33, i34, f19, i35, i36, i37, i38, i39, i40, i41, i42, charSequence3, i43, num8, uri2, compressFormat2, i44, i45, i46, requestSizeOptions2, z30, rect2, i47, z31, z32, z33, i48, z34, z35, charSequence4, i49, z36, z37, str3, list2, f21, i50, str4, i51, num9, num10, num7, num6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getImageSourceIncludeGallery() {
        return this.imageSourceIncludeGallery;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getShowCropOverlay() {
        return this.showCropOverlay;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getShowCropLabel() {
        return this.showCropLabel;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getProgressBarColor() {
        return this.progressBarColor;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getAutoZoomEnabled() {
        return this.autoZoomEnabled;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getMultiTouchEnabled() {
        return this.multiTouchEnabled;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getCenterMoveEnabled() {
        return this.centerMoveEnabled;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getCanChangeCropWindow() {
        return this.canChangeCropWindow;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getMaxZoom() {
        return this.maxZoom;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final float getInitialCropWindowPaddingRatio() {
        return this.initialCropWindowPaddingRatio;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getImageSourceIncludeCamera() {
        return this.imageSourceIncludeCamera;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getFixAspectRatio() {
        return this.fixAspectRatio;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getAspectRatioX() {
        return this.aspectRatioX;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getAspectRatioY() {
        return this.aspectRatioY;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final float getBorderLineThickness() {
        return this.borderLineThickness;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final int getBorderLineColor() {
        return this.borderLineColor;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final float getBorderCornerThickness() {
        return this.borderCornerThickness;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final float getBorderCornerOffset() {
        return this.borderCornerOffset;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final float getBorderCornerLength() {
        return this.borderCornerLength;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final int getBorderCornerColor() {
        return this.borderCornerColor;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final int getCircleCornerFillColorHexValue() {
        return this.circleCornerFillColorHexValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CropImageView.CropShape getCropShape() {
        return this.cropShape;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final float getGuidelinesThickness() {
        return this.guidelinesThickness;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final int getGuidelinesColor() {
        return this.guidelinesColor;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final int getMinCropWindowWidth() {
        return this.minCropWindowWidth;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final int getMinCropWindowHeight() {
        return this.minCropWindowHeight;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final int getMinCropResultWidth() {
        return this.minCropResultWidth;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final int getMinCropResultHeight() {
        return this.minCropResultHeight;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final int getMaxCropResultWidth() {
        return this.maxCropResultWidth;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final int getMaxCropResultHeight() {
        return this.maxCropResultHeight;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final CharSequence getActivityTitle() {
        return this.activityTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CropImageView.CropCornerShape getCornerShape() {
        return this.cornerShape;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final int getActivityMenuIconColor() {
        return this.activityMenuIconColor;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Integer getActivityMenuTextColor() {
        return this.activityMenuTextColor;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Uri getCustomOutputUri() {
        return this.customOutputUri;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Bitmap.CompressFormat getOutputCompressFormat() {
        return this.outputCompressFormat;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final int getOutputCompressQuality() {
        return this.outputCompressQuality;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final int getOutputRequestWidth() {
        return this.outputRequestWidth;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final int getOutputRequestHeight() {
        return this.outputRequestHeight;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final CropImageView.RequestSizeOptions getOutputRequestSizeOptions() {
        return this.outputRequestSizeOptions;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final boolean getNoOutputImage() {
        return this.noOutputImage;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final Rect getInitialCropWindowRectangle() {
        return this.initialCropWindowRectangle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getCropCornerRadius() {
        return this.cropCornerRadius;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final int getInitialRotation() {
        return this.initialRotation;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final boolean getAllowRotation() {
        return this.allowRotation;
    }

    /* JADX INFO: renamed from: component52, reason: from getter */
    public final boolean getAllowFlipping() {
        return this.allowFlipping;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final boolean getAllowCounterRotation() {
        return this.allowCounterRotation;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final int getRotationDegrees() {
        return this.rotationDegrees;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final boolean getFlipHorizontally() {
        return this.flipHorizontally;
    }

    /* JADX INFO: renamed from: component56, reason: from getter */
    public final boolean getFlipVertically() {
        return this.flipVertically;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final CharSequence getCropMenuCropButtonTitle() {
        return this.cropMenuCropButtonTitle;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final int getCropMenuCropButtonIcon() {
        return this.cropMenuCropButtonIcon;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final boolean getSkipEditing() {
        return this.skipEditing;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getSnapRadius() {
        return this.snapRadius;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final boolean getShowIntentChooser() {
        return this.showIntentChooser;
    }

    /* JADX INFO: renamed from: component61, reason: from getter */
    public final String getIntentChooserTitle() {
        return this.intentChooserTitle;
    }

    public final List<String> component62() {
        return this.intentChooserPriorityList;
    }

    /* JADX INFO: renamed from: component63, reason: from getter */
    public final float getCropperLabelTextSize() {
        return this.cropperLabelTextSize;
    }

    /* JADX INFO: renamed from: component64, reason: from getter */
    public final int getCropperLabelTextColor() {
        return this.cropperLabelTextColor;
    }

    /* JADX INFO: renamed from: component65, reason: from getter */
    public final String getCropperLabelText() {
        return this.cropperLabelText;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final int getActivityBackgroundColor() {
        return this.activityBackgroundColor;
    }

    /* JADX INFO: renamed from: component67, reason: from getter */
    public final Integer getToolbarColor() {
        return this.toolbarColor;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final Integer getToolbarTitleColor() {
        return this.toolbarTitleColor;
    }

    /* JADX INFO: renamed from: component69, reason: from getter */
    public final Integer getToolbarBackButtonColor() {
        return this.toolbarBackButtonColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getTouchRadius() {
        return this.touchRadius;
    }

    /* JADX INFO: renamed from: component70, reason: from getter */
    public final Integer getToolbarTintColor() {
        return this.toolbarTintColor;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CropImageView.Guidelines getGuidelines() {
        return this.guidelines;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CropImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final CropImageOptions copy(boolean imageSourceIncludeGallery, boolean imageSourceIncludeCamera, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float cropCornerRadius, float snapRadius, float touchRadius, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean showCropOverlay, boolean showCropLabel, boolean showProgressBar, int progressBarColor, boolean autoZoomEnabled, boolean multiTouchEnabled, boolean centerMoveEnabled, boolean canChangeCropWindow, int maxZoom, float initialCropWindowPaddingRatio, boolean fixAspectRatio, int aspectRatioX, int aspectRatioY, float borderLineThickness, int borderLineColor, float borderCornerThickness, float borderCornerOffset, float borderCornerLength, int borderCornerColor, int circleCornerFillColorHexValue, float guidelinesThickness, int guidelinesColor, int backgroundColor, int minCropWindowWidth, int minCropWindowHeight, int minCropResultWidth, int minCropResultHeight, int maxCropResultWidth, int maxCropResultHeight, CharSequence activityTitle, int activityMenuIconColor, Integer activityMenuTextColor, Uri customOutputUri, Bitmap.CompressFormat outputCompressFormat, int outputCompressQuality, int outputRequestWidth, int outputRequestHeight, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean noOutputImage, Rect initialCropWindowRectangle, int initialRotation, boolean allowRotation, boolean allowFlipping, boolean allowCounterRotation, int rotationDegrees, boolean flipHorizontally, boolean flipVertically, CharSequence cropMenuCropButtonTitle, int cropMenuCropButtonIcon, boolean skipEditing, boolean showIntentChooser, String intentChooserTitle, List<String> intentChooserPriorityList, float cropperLabelTextSize, int cropperLabelTextColor, String cropperLabelText, int activityBackgroundColor, Integer toolbarColor, Integer toolbarTitleColor, Integer toolbarBackButtonColor, Integer toolbarTintColor) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
        return new CropImageOptions(imageSourceIncludeGallery, imageSourceIncludeCamera, cropShape, cornerShape, cropCornerRadius, snapRadius, touchRadius, guidelines, scaleType, showCropOverlay, showCropLabel, showProgressBar, progressBarColor, autoZoomEnabled, multiTouchEnabled, centerMoveEnabled, canChangeCropWindow, maxZoom, initialCropWindowPaddingRatio, fixAspectRatio, aspectRatioX, aspectRatioY, borderLineThickness, borderLineColor, borderCornerThickness, borderCornerOffset, borderCornerLength, borderCornerColor, circleCornerFillColorHexValue, guidelinesThickness, guidelinesColor, backgroundColor, minCropWindowWidth, minCropWindowHeight, minCropResultWidth, minCropResultHeight, maxCropResultWidth, maxCropResultHeight, activityTitle, activityMenuIconColor, activityMenuTextColor, customOutputUri, outputCompressFormat, outputCompressQuality, outputRequestWidth, outputRequestHeight, outputRequestSizeOptions, noOutputImage, initialCropWindowRectangle, initialRotation, allowRotation, allowFlipping, allowCounterRotation, rotationDegrees, flipHorizontally, flipVertically, cropMenuCropButtonTitle, cropMenuCropButtonIcon, skipEditing, showIntentChooser, intentChooserTitle, intentChooserPriorityList, cropperLabelTextSize, cropperLabelTextColor, cropperLabelText, activityBackgroundColor, toolbarColor, toolbarTitleColor, toolbarBackButtonColor, toolbarTintColor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropImageOptions)) {
            return false;
        }
        CropImageOptions cropImageOptions = (CropImageOptions) other;
        return this.imageSourceIncludeGallery == cropImageOptions.imageSourceIncludeGallery && this.imageSourceIncludeCamera == cropImageOptions.imageSourceIncludeCamera && this.cropShape == cropImageOptions.cropShape && this.cornerShape == cropImageOptions.cornerShape && Float.compare(this.cropCornerRadius, cropImageOptions.cropCornerRadius) == 0 && Float.compare(this.snapRadius, cropImageOptions.snapRadius) == 0 && Float.compare(this.touchRadius, cropImageOptions.touchRadius) == 0 && this.guidelines == cropImageOptions.guidelines && this.scaleType == cropImageOptions.scaleType && this.showCropOverlay == cropImageOptions.showCropOverlay && this.showCropLabel == cropImageOptions.showCropLabel && this.showProgressBar == cropImageOptions.showProgressBar && this.progressBarColor == cropImageOptions.progressBarColor && this.autoZoomEnabled == cropImageOptions.autoZoomEnabled && this.multiTouchEnabled == cropImageOptions.multiTouchEnabled && this.centerMoveEnabled == cropImageOptions.centerMoveEnabled && this.canChangeCropWindow == cropImageOptions.canChangeCropWindow && this.maxZoom == cropImageOptions.maxZoom && Float.compare(this.initialCropWindowPaddingRatio, cropImageOptions.initialCropWindowPaddingRatio) == 0 && this.fixAspectRatio == cropImageOptions.fixAspectRatio && this.aspectRatioX == cropImageOptions.aspectRatioX && this.aspectRatioY == cropImageOptions.aspectRatioY && Float.compare(this.borderLineThickness, cropImageOptions.borderLineThickness) == 0 && this.borderLineColor == cropImageOptions.borderLineColor && Float.compare(this.borderCornerThickness, cropImageOptions.borderCornerThickness) == 0 && Float.compare(this.borderCornerOffset, cropImageOptions.borderCornerOffset) == 0 && Float.compare(this.borderCornerLength, cropImageOptions.borderCornerLength) == 0 && this.borderCornerColor == cropImageOptions.borderCornerColor && this.circleCornerFillColorHexValue == cropImageOptions.circleCornerFillColorHexValue && Float.compare(this.guidelinesThickness, cropImageOptions.guidelinesThickness) == 0 && this.guidelinesColor == cropImageOptions.guidelinesColor && this.backgroundColor == cropImageOptions.backgroundColor && this.minCropWindowWidth == cropImageOptions.minCropWindowWidth && this.minCropWindowHeight == cropImageOptions.minCropWindowHeight && this.minCropResultWidth == cropImageOptions.minCropResultWidth && this.minCropResultHeight == cropImageOptions.minCropResultHeight && this.maxCropResultWidth == cropImageOptions.maxCropResultWidth && this.maxCropResultHeight == cropImageOptions.maxCropResultHeight && Intrinsics.areEqual(this.activityTitle, cropImageOptions.activityTitle) && this.activityMenuIconColor == cropImageOptions.activityMenuIconColor && Intrinsics.areEqual(this.activityMenuTextColor, cropImageOptions.activityMenuTextColor) && Intrinsics.areEqual(this.customOutputUri, cropImageOptions.customOutputUri) && this.outputCompressFormat == cropImageOptions.outputCompressFormat && this.outputCompressQuality == cropImageOptions.outputCompressQuality && this.outputRequestWidth == cropImageOptions.outputRequestWidth && this.outputRequestHeight == cropImageOptions.outputRequestHeight && this.outputRequestSizeOptions == cropImageOptions.outputRequestSizeOptions && this.noOutputImage == cropImageOptions.noOutputImage && Intrinsics.areEqual(this.initialCropWindowRectangle, cropImageOptions.initialCropWindowRectangle) && this.initialRotation == cropImageOptions.initialRotation && this.allowRotation == cropImageOptions.allowRotation && this.allowFlipping == cropImageOptions.allowFlipping && this.allowCounterRotation == cropImageOptions.allowCounterRotation && this.rotationDegrees == cropImageOptions.rotationDegrees && this.flipHorizontally == cropImageOptions.flipHorizontally && this.flipVertically == cropImageOptions.flipVertically && Intrinsics.areEqual(this.cropMenuCropButtonTitle, cropImageOptions.cropMenuCropButtonTitle) && this.cropMenuCropButtonIcon == cropImageOptions.cropMenuCropButtonIcon && this.skipEditing == cropImageOptions.skipEditing && this.showIntentChooser == cropImageOptions.showIntentChooser && Intrinsics.areEqual(this.intentChooserTitle, cropImageOptions.intentChooserTitle) && Intrinsics.areEqual(this.intentChooserPriorityList, cropImageOptions.intentChooserPriorityList) && Float.compare(this.cropperLabelTextSize, cropImageOptions.cropperLabelTextSize) == 0 && this.cropperLabelTextColor == cropImageOptions.cropperLabelTextColor && Intrinsics.areEqual(this.cropperLabelText, cropImageOptions.cropperLabelText) && this.activityBackgroundColor == cropImageOptions.activityBackgroundColor && Intrinsics.areEqual(this.toolbarColor, cropImageOptions.toolbarColor) && Intrinsics.areEqual(this.toolbarTitleColor, cropImageOptions.toolbarTitleColor) && Intrinsics.areEqual(this.toolbarBackButtonColor, cropImageOptions.toolbarBackButtonColor) && Intrinsics.areEqual(this.toolbarTintColor, cropImageOptions.toolbarTintColor);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Boolean.hashCode(this.imageSourceIncludeGallery) * 31) + Boolean.hashCode(this.imageSourceIncludeCamera)) * 31) + this.cropShape.hashCode()) * 31) + this.cornerShape.hashCode()) * 31) + Float.hashCode(this.cropCornerRadius)) * 31) + Float.hashCode(this.snapRadius)) * 31) + Float.hashCode(this.touchRadius)) * 31) + this.guidelines.hashCode()) * 31) + this.scaleType.hashCode()) * 31) + Boolean.hashCode(this.showCropOverlay)) * 31) + Boolean.hashCode(this.showCropLabel)) * 31) + Boolean.hashCode(this.showProgressBar)) * 31) + Integer.hashCode(this.progressBarColor)) * 31) + Boolean.hashCode(this.autoZoomEnabled)) * 31) + Boolean.hashCode(this.multiTouchEnabled)) * 31) + Boolean.hashCode(this.centerMoveEnabled)) * 31) + Boolean.hashCode(this.canChangeCropWindow)) * 31) + Integer.hashCode(this.maxZoom)) * 31) + Float.hashCode(this.initialCropWindowPaddingRatio)) * 31) + Boolean.hashCode(this.fixAspectRatio)) * 31) + Integer.hashCode(this.aspectRatioX)) * 31) + Integer.hashCode(this.aspectRatioY)) * 31) + Float.hashCode(this.borderLineThickness)) * 31) + Integer.hashCode(this.borderLineColor)) * 31) + Float.hashCode(this.borderCornerThickness)) * 31) + Float.hashCode(this.borderCornerOffset)) * 31) + Float.hashCode(this.borderCornerLength)) * 31) + Integer.hashCode(this.borderCornerColor)) * 31) + Integer.hashCode(this.circleCornerFillColorHexValue)) * 31) + Float.hashCode(this.guidelinesThickness)) * 31) + Integer.hashCode(this.guidelinesColor)) * 31) + Integer.hashCode(this.backgroundColor)) * 31) + Integer.hashCode(this.minCropWindowWidth)) * 31) + Integer.hashCode(this.minCropWindowHeight)) * 31) + Integer.hashCode(this.minCropResultWidth)) * 31) + Integer.hashCode(this.minCropResultHeight)) * 31) + Integer.hashCode(this.maxCropResultWidth)) * 31) + Integer.hashCode(this.maxCropResultHeight)) * 31) + this.activityTitle.hashCode()) * 31) + Integer.hashCode(this.activityMenuIconColor)) * 31;
        Integer num = this.activityMenuTextColor;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Uri uri = this.customOutputUri;
        int iHashCode3 = (((((((((((((iHashCode2 + (uri == null ? 0 : uri.hashCode())) * 31) + this.outputCompressFormat.hashCode()) * 31) + Integer.hashCode(this.outputCompressQuality)) * 31) + Integer.hashCode(this.outputRequestWidth)) * 31) + Integer.hashCode(this.outputRequestHeight)) * 31) + this.outputRequestSizeOptions.hashCode()) * 31) + Boolean.hashCode(this.noOutputImage)) * 31;
        Rect rect = this.initialCropWindowRectangle;
        int iHashCode4 = (((((((((((((((iHashCode3 + (rect == null ? 0 : rect.hashCode())) * 31) + Integer.hashCode(this.initialRotation)) * 31) + Boolean.hashCode(this.allowRotation)) * 31) + Boolean.hashCode(this.allowFlipping)) * 31) + Boolean.hashCode(this.allowCounterRotation)) * 31) + Integer.hashCode(this.rotationDegrees)) * 31) + Boolean.hashCode(this.flipHorizontally)) * 31) + Boolean.hashCode(this.flipVertically)) * 31;
        CharSequence charSequence = this.cropMenuCropButtonTitle;
        int iHashCode5 = (((((((iHashCode4 + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + Integer.hashCode(this.cropMenuCropButtonIcon)) * 31) + Boolean.hashCode(this.skipEditing)) * 31) + Boolean.hashCode(this.showIntentChooser)) * 31;
        String str = this.intentChooserTitle;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.intentChooserPriorityList;
        int iHashCode7 = (((((iHashCode6 + (list == null ? 0 : list.hashCode())) * 31) + Float.hashCode(this.cropperLabelTextSize)) * 31) + Integer.hashCode(this.cropperLabelTextColor)) * 31;
        String str2 = this.cropperLabelText;
        int iHashCode8 = (((iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.activityBackgroundColor)) * 31;
        Integer num2 = this.toolbarColor;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.toolbarTitleColor;
        int iHashCode10 = (iHashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.toolbarBackButtonColor;
        int iHashCode11 = (iHashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.toolbarTintColor;
        return iHashCode11 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.imageSourceIncludeGallery;
        boolean z2 = this.imageSourceIncludeCamera;
        CropImageView.CropShape cropShape = this.cropShape;
        CropImageView.CropCornerShape cropCornerShape = this.cornerShape;
        float f = this.cropCornerRadius;
        float f2 = this.snapRadius;
        float f3 = this.touchRadius;
        CropImageView.Guidelines guidelines = this.guidelines;
        CropImageView.ScaleType scaleType = this.scaleType;
        boolean z3 = this.showCropOverlay;
        boolean z4 = this.showCropLabel;
        boolean z5 = this.showProgressBar;
        int i = this.progressBarColor;
        boolean z6 = this.autoZoomEnabled;
        boolean z7 = this.multiTouchEnabled;
        boolean z8 = this.centerMoveEnabled;
        boolean z9 = this.canChangeCropWindow;
        int i2 = this.maxZoom;
        float f4 = this.initialCropWindowPaddingRatio;
        boolean z10 = this.fixAspectRatio;
        int i3 = this.aspectRatioX;
        int i4 = this.aspectRatioY;
        float f5 = this.borderLineThickness;
        int i5 = this.borderLineColor;
        float f6 = this.borderCornerThickness;
        float f7 = this.borderCornerOffset;
        float f8 = this.borderCornerLength;
        int i6 = this.borderCornerColor;
        int i7 = this.circleCornerFillColorHexValue;
        float f9 = this.guidelinesThickness;
        int i8 = this.guidelinesColor;
        int i9 = this.backgroundColor;
        int i10 = this.minCropWindowWidth;
        int i11 = this.minCropWindowHeight;
        int i12 = this.minCropResultWidth;
        int i13 = this.minCropResultHeight;
        int i14 = this.maxCropResultWidth;
        int i15 = this.maxCropResultHeight;
        CharSequence charSequence = this.activityTitle;
        int i16 = this.activityMenuIconColor;
        Integer num = this.activityMenuTextColor;
        Uri uri = this.customOutputUri;
        Bitmap.CompressFormat compressFormat = this.outputCompressFormat;
        int i17 = this.outputCompressQuality;
        int i18 = this.outputRequestWidth;
        int i19 = this.outputRequestHeight;
        CropImageView.RequestSizeOptions requestSizeOptions = this.outputRequestSizeOptions;
        boolean z11 = this.noOutputImage;
        Rect rect = this.initialCropWindowRectangle;
        int i20 = this.initialRotation;
        boolean z12 = this.allowRotation;
        boolean z13 = this.allowFlipping;
        boolean z14 = this.allowCounterRotation;
        int i21 = this.rotationDegrees;
        boolean z15 = this.flipHorizontally;
        boolean z16 = this.flipVertically;
        CharSequence charSequence2 = this.cropMenuCropButtonTitle;
        return "CropImageOptions(imageSourceIncludeGallery=" + z + ", imageSourceIncludeCamera=" + z2 + ", cropShape=" + cropShape + ", cornerShape=" + cropCornerShape + ", cropCornerRadius=" + f + ", snapRadius=" + f2 + ", touchRadius=" + f3 + ", guidelines=" + guidelines + ", scaleType=" + scaleType + ", showCropOverlay=" + z3 + ", showCropLabel=" + z4 + ", showProgressBar=" + z5 + ", progressBarColor=" + i + ", autoZoomEnabled=" + z6 + ", multiTouchEnabled=" + z7 + ", centerMoveEnabled=" + z8 + ", canChangeCropWindow=" + z9 + ", maxZoom=" + i2 + ", initialCropWindowPaddingRatio=" + f4 + ", fixAspectRatio=" + z10 + ", aspectRatioX=" + i3 + ", aspectRatioY=" + i4 + ", borderLineThickness=" + f5 + ", borderLineColor=" + i5 + ", borderCornerThickness=" + f6 + ", borderCornerOffset=" + f7 + ", borderCornerLength=" + f8 + ", borderCornerColor=" + i6 + ", circleCornerFillColorHexValue=" + i7 + ", guidelinesThickness=" + f9 + ", guidelinesColor=" + i8 + ", backgroundColor=" + i9 + ", minCropWindowWidth=" + i10 + ", minCropWindowHeight=" + i11 + ", minCropResultWidth=" + i12 + ", minCropResultHeight=" + i13 + ", maxCropResultWidth=" + i14 + ", maxCropResultHeight=" + i15 + ", activityTitle=" + ((Object) charSequence) + ", activityMenuIconColor=" + i16 + ", activityMenuTextColor=" + num + ", customOutputUri=" + uri + ", outputCompressFormat=" + compressFormat + ", outputCompressQuality=" + i17 + ", outputRequestWidth=" + i18 + ", outputRequestHeight=" + i19 + ", outputRequestSizeOptions=" + requestSizeOptions + ", noOutputImage=" + z11 + ", initialCropWindowRectangle=" + rect + ", initialRotation=" + i20 + ", allowRotation=" + z12 + ", allowFlipping=" + z13 + ", allowCounterRotation=" + z14 + ", rotationDegrees=" + i21 + ", flipHorizontally=" + z15 + ", flipVertically=" + z16 + ", cropMenuCropButtonTitle=" + ((Object) charSequence2) + ", cropMenuCropButtonIcon=" + this.cropMenuCropButtonIcon + ", skipEditing=" + this.skipEditing + ", showIntentChooser=" + this.showIntentChooser + ", intentChooserTitle=" + this.intentChooserTitle + ", intentChooserPriorityList=" + this.intentChooserPriorityList + ", cropperLabelTextSize=" + this.cropperLabelTextSize + ", cropperLabelTextColor=" + this.cropperLabelTextColor + ", cropperLabelText=" + this.cropperLabelText + ", activityBackgroundColor=" + this.activityBackgroundColor + ", toolbarColor=" + this.toolbarColor + ", toolbarTitleColor=" + this.toolbarTitleColor + ", toolbarBackButtonColor=" + this.toolbarBackButtonColor + ", toolbarTintColor=" + this.toolbarTintColor + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.imageSourceIncludeGallery ? 1 : 0);
        dest.writeInt(this.imageSourceIncludeCamera ? 1 : 0);
        dest.writeString(this.cropShape.name());
        dest.writeString(this.cornerShape.name());
        dest.writeFloat(this.cropCornerRadius);
        dest.writeFloat(this.snapRadius);
        dest.writeFloat(this.touchRadius);
        dest.writeString(this.guidelines.name());
        dest.writeString(this.scaleType.name());
        dest.writeInt(this.showCropOverlay ? 1 : 0);
        dest.writeInt(this.showCropLabel ? 1 : 0);
        dest.writeInt(this.showProgressBar ? 1 : 0);
        dest.writeInt(this.progressBarColor);
        dest.writeInt(this.autoZoomEnabled ? 1 : 0);
        dest.writeInt(this.multiTouchEnabled ? 1 : 0);
        dest.writeInt(this.centerMoveEnabled ? 1 : 0);
        dest.writeInt(this.canChangeCropWindow ? 1 : 0);
        dest.writeInt(this.maxZoom);
        dest.writeFloat(this.initialCropWindowPaddingRatio);
        dest.writeInt(this.fixAspectRatio ? 1 : 0);
        dest.writeInt(this.aspectRatioX);
        dest.writeInt(this.aspectRatioY);
        dest.writeFloat(this.borderLineThickness);
        dest.writeInt(this.borderLineColor);
        dest.writeFloat(this.borderCornerThickness);
        dest.writeFloat(this.borderCornerOffset);
        dest.writeFloat(this.borderCornerLength);
        dest.writeInt(this.borderCornerColor);
        dest.writeInt(this.circleCornerFillColorHexValue);
        dest.writeFloat(this.guidelinesThickness);
        dest.writeInt(this.guidelinesColor);
        dest.writeInt(this.backgroundColor);
        dest.writeInt(this.minCropWindowWidth);
        dest.writeInt(this.minCropWindowHeight);
        dest.writeInt(this.minCropResultWidth);
        dest.writeInt(this.minCropResultHeight);
        dest.writeInt(this.maxCropResultWidth);
        dest.writeInt(this.maxCropResultHeight);
        TextUtils.writeToParcel(this.activityTitle, dest, flags);
        dest.writeInt(this.activityMenuIconColor);
        Integer num = this.activityMenuTextColor;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        dest.writeParcelable(this.customOutputUri, flags);
        dest.writeString(this.outputCompressFormat.name());
        dest.writeInt(this.outputCompressQuality);
        dest.writeInt(this.outputRequestWidth);
        dest.writeInt(this.outputRequestHeight);
        dest.writeString(this.outputRequestSizeOptions.name());
        dest.writeInt(this.noOutputImage ? 1 : 0);
        dest.writeParcelable(this.initialCropWindowRectangle, flags);
        dest.writeInt(this.initialRotation);
        dest.writeInt(this.allowRotation ? 1 : 0);
        dest.writeInt(this.allowFlipping ? 1 : 0);
        dest.writeInt(this.allowCounterRotation ? 1 : 0);
        dest.writeInt(this.rotationDegrees);
        dest.writeInt(this.flipHorizontally ? 1 : 0);
        dest.writeInt(this.flipVertically ? 1 : 0);
        TextUtils.writeToParcel(this.cropMenuCropButtonTitle, dest, flags);
        dest.writeInt(this.cropMenuCropButtonIcon);
        dest.writeInt(this.skipEditing ? 1 : 0);
        dest.writeInt(this.showIntentChooser ? 1 : 0);
        dest.writeString(this.intentChooserTitle);
        dest.writeStringList(this.intentChooserPriorityList);
        dest.writeFloat(this.cropperLabelTextSize);
        dest.writeInt(this.cropperLabelTextColor);
        dest.writeString(this.cropperLabelText);
        dest.writeInt(this.activityBackgroundColor);
        Integer num2 = this.toolbarColor;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        Integer num3 = this.toolbarTitleColor;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        Integer num4 = this.toolbarBackButtonColor;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        Integer num5 = this.toolbarTintColor;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
    }

    public CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence activityTitle, int i16, Integer num, Uri uri, Bitmap.CompressFormat outputCompressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions outputRequestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence, int i22, boolean z17, boolean z18, String str, List<String> list, float f10, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        Intrinsics.checkNotNullParameter(outputRequestSizeOptions, "outputRequestSizeOptions");
        this.imageSourceIncludeGallery = z;
        this.imageSourceIncludeCamera = z2;
        this.cropShape = cropShape;
        this.cornerShape = cornerShape;
        this.cropCornerRadius = f;
        this.snapRadius = f2;
        this.touchRadius = f3;
        this.guidelines = guidelines;
        this.scaleType = scaleType;
        this.showCropOverlay = z3;
        this.showCropLabel = z4;
        this.showProgressBar = z5;
        this.progressBarColor = i;
        this.autoZoomEnabled = z6;
        this.multiTouchEnabled = z7;
        this.centerMoveEnabled = z8;
        this.canChangeCropWindow = z9;
        this.maxZoom = i2;
        this.initialCropWindowPaddingRatio = f4;
        this.fixAspectRatio = z10;
        this.aspectRatioX = i3;
        this.aspectRatioY = i4;
        this.borderLineThickness = f5;
        this.borderLineColor = i5;
        this.borderCornerThickness = f6;
        this.borderCornerOffset = f7;
        this.borderCornerLength = f8;
        this.borderCornerColor = i6;
        this.circleCornerFillColorHexValue = i7;
        this.guidelinesThickness = f9;
        this.guidelinesColor = i8;
        this.backgroundColor = i9;
        this.minCropWindowWidth = i10;
        this.minCropWindowHeight = i11;
        this.minCropResultWidth = i12;
        this.minCropResultHeight = i13;
        this.maxCropResultWidth = i14;
        this.maxCropResultHeight = i15;
        this.activityTitle = activityTitle;
        this.activityMenuIconColor = i16;
        this.activityMenuTextColor = num;
        this.customOutputUri = uri;
        this.outputCompressFormat = outputCompressFormat;
        this.outputCompressQuality = i17;
        this.outputRequestWidth = i18;
        this.outputRequestHeight = i19;
        this.outputRequestSizeOptions = outputRequestSizeOptions;
        this.noOutputImage = z11;
        this.initialCropWindowRectangle = rect;
        this.initialRotation = i20;
        this.allowRotation = z12;
        this.allowFlipping = z13;
        this.allowCounterRotation = z14;
        this.rotationDegrees = i21;
        this.flipHorizontally = z15;
        this.flipVertically = z16;
        this.cropMenuCropButtonTitle = charSequence;
        this.cropMenuCropButtonIcon = i22;
        this.skipEditing = z17;
        this.showIntentChooser = z18;
        this.intentChooserTitle = str;
        this.intentChooserPriorityList = list;
        this.cropperLabelTextSize = f10;
        this.cropperLabelTextColor = i23;
        this.cropperLabelText = str2;
        this.activityBackgroundColor = i24;
        this.toolbarColor = num2;
        this.toolbarTitleColor = num3;
        this.toolbarBackButtonColor = num4;
        this.toolbarTintColor = num5;
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1".toString());
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ".toString());
        }
        if (f4 < 0.0f || f4 >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5".toString());
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.".toString());
        }
        if (i4 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.".toString());
        }
        if (f5 < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.".toString());
        }
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.".toString());
        }
        if (f9 < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.".toString());
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ".toString());
        }
        if (i12 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ".toString());
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ".toString());
        }
        if (i14 < i12) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width".toString());
        }
        if (i15 < i13) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height".toString());
        }
        if (i18 < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ".toString());
        }
        if (i19 < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ".toString());
        }
        if (i21 < 0 || i21 > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360".toString());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CropImageOptions(boolean z, boolean z2, CropImageView.CropShape cropShape, CropImageView.CropCornerShape cropCornerShape, float f, float f2, float f3, CropImageView.Guidelines guidelines, CropImageView.ScaleType scaleType, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, Integer num, Uri uri, Bitmap.CompressFormat compressFormat, int i17, int i18, int i19, CropImageView.RequestSizeOptions requestSizeOptions, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence2, int i22, boolean z17, boolean z18, String str, List list, float f10, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5, int i25, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        int i28;
        float fApplyDimension;
        int i29;
        int iApplyDimension;
        boolean z19 = (i25 & 1) != 0 ? true : z;
        boolean z20 = (i25 & 2) != 0 ? true : z2;
        CropImageView.CropShape cropShape2 = (i25 & 4) != 0 ? CropImageView.CropShape.RECTANGLE : cropShape;
        CropImageView.CropCornerShape cropCornerShape2 = (i25 & 8) != 0 ? CropImageView.CropCornerShape.RECTANGLE : cropCornerShape;
        float fApplyDimension2 = (i25 & 16) != 0 ? TypedValue.applyDimension(1, 10.0f, Resources.getSystem().getDisplayMetrics()) : f;
        float fApplyDimension3 = (i25 & 32) != 0 ? TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics()) : f2;
        float fApplyDimension4 = (i25 & 64) != 0 ? TypedValue.applyDimension(1, 24.0f, Resources.getSystem().getDisplayMetrics()) : f3;
        CropImageView.Guidelines guidelines2 = (i25 & 128) != 0 ? CropImageView.Guidelines.ON : guidelines;
        CropImageView.ScaleType scaleType2 = (i25 & 256) != 0 ? CropImageView.ScaleType.FIT_CENTER : scaleType;
        boolean z21 = (i25 & 512) != 0 ? true : z3;
        boolean z22 = (i25 & 1024) != 0 ? false : z4;
        boolean z23 = (i25 & 2048) != 0 ? true : z5;
        int iRgb = (i25 & 4096) != 0 ? Color.rgb(153, 51, 153) : i;
        boolean z24 = (i25 & 8192) != 0 ? true : z6;
        boolean z25 = z19;
        boolean z26 = (i25 & 16384) != 0 ? false : z7;
        boolean z27 = (i25 & 32768) != 0 ? true : z8;
        boolean z28 = (i25 & 65536) != 0 ? true : z9;
        int i30 = (i25 & 131072) != 0 ? 4 : i2;
        float f11 = (i25 & 262144) != 0 ? 0.0f : f4;
        boolean z29 = (i25 & 524288) != 0 ? false : z10;
        int i31 = (i25 & 1048576) != 0 ? 1 : i3;
        int i32 = (i25 & 2097152) != 0 ? 1 : i4;
        float fApplyDimension5 = (i25 & 4194304) != 0 ? TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics()) : f5;
        int iArgb = (i25 & 8388608) != 0 ? Color.argb(170, 255, 255, 255) : i5;
        if ((i25 & 16777216) != 0) {
            i28 = 1;
            fApplyDimension = TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            i28 = 1;
            fApplyDimension = f6;
        }
        float fApplyDimension6 = (i25 & 33554432) != 0 ? TypedValue.applyDimension(i28, 5.0f, Resources.getSystem().getDisplayMetrics()) : f7;
        float fApplyDimension7 = (i25 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? TypedValue.applyDimension(i28, 14.0f, Resources.getSystem().getDisplayMetrics()) : f8;
        int i33 = (i25 & 134217728) != 0 ? -1 : i6;
        int i34 = (i25 & 268435456) != 0 ? -1 : i7;
        float fApplyDimension8 = (i25 & 536870912) != 0 ? TypedValue.applyDimension(1, 1.0f, Resources.getSystem().getDisplayMetrics()) : f9;
        int iArgb2 = (i25 & 1073741824) != 0 ? Color.argb(170, 255, 255, 255) : i8;
        int iArgb3 = (i25 & Integer.MIN_VALUE) != 0 ? Color.argb(119, 0, 0, 0) : i9;
        if ((i26 & 1) != 0) {
            i29 = 1;
            iApplyDimension = (int) TypedValue.applyDimension(1, 42.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            i29 = 1;
            iApplyDimension = i10;
        }
        int iApplyDimension2 = (i26 & 2) != 0 ? (int) TypedValue.applyDimension(i29, 42.0f, Resources.getSystem().getDisplayMetrics()) : i11;
        int i35 = (i26 & 4) != 0 ? 40 : i12;
        int i36 = (i26 & 8) != 0 ? 40 : i13;
        int i37 = (i26 & 16) != 0 ? 99999 : i14;
        int i38 = (i26 & 32) != 0 ? 99999 : i15;
        CharSequence charSequence3 = (i26 & 64) != 0 ? "" : charSequence;
        int i39 = (i26 & 128) != 0 ? 0 : i16;
        CropImageView.CropShape cropShape3 = cropShape2;
        CropImageView.CropCornerShape cropCornerShape3 = cropCornerShape2;
        float f12 = fApplyDimension2;
        float f13 = fApplyDimension3;
        boolean z30 = z24;
        float f14 = fApplyDimension4;
        CropImageView.Guidelines guidelines3 = guidelines2;
        CropImageView.ScaleType scaleType3 = scaleType2;
        boolean z31 = z21;
        boolean z32 = z22;
        boolean z33 = z23;
        boolean z34 = z27;
        boolean z35 = z28;
        int i40 = i30;
        float f15 = f11;
        boolean z36 = z29;
        int i41 = i31;
        int i42 = i32;
        int i43 = iRgb;
        boolean z37 = z26;
        boolean z38 = z20;
        this(z25, z38, cropShape3, cropCornerShape3, f12, f13, f14, guidelines3, scaleType3, z31, z32, z33, i43, z30, z37, z34, z35, i40, f15, z36, i41, i42, fApplyDimension5, iArgb, fApplyDimension, fApplyDimension6, fApplyDimension7, i33, i34, fApplyDimension8, iArgb2, iArgb3, iApplyDimension, iApplyDimension2, i35, i36, i37, i38, charSequence3, i39, (i26 & 256) != 0 ? null : num, (i26 & 512) != 0 ? null : uri, (i26 & 1024) != 0 ? Bitmap.CompressFormat.JPEG : compressFormat, (i26 & 2048) != 0 ? 90 : i17, (i26 & 4096) != 0 ? 0 : i18, (i26 & 8192) != 0 ? 0 : i19, (i26 & 16384) != 0 ? CropImageView.RequestSizeOptions.NONE : requestSizeOptions, (i26 & 32768) != 0 ? false : z11, (i26 & 65536) != 0 ? null : rect, (i26 & 131072) != 0 ? -1 : i20, (i26 & 262144) != 0 ? true : z12, (i26 & 524288) != 0 ? true : z13, (i26 & 1048576) != 0 ? false : z14, (i26 & 2097152) != 0 ? 90 : i21, (i26 & 4194304) != 0 ? false : z15, (i26 & 8388608) != 0 ? false : z16, (i26 & 16777216) != 0 ? null : charSequence2, (i26 & 33554432) != 0 ? 0 : i22, (i26 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? false : z17, (i26 & 134217728) != 0 ? false : z18, (i26 & 268435456) != 0 ? null : str, (i26 & 536870912) != 0 ? CollectionsKt.emptyList() : list, (i26 & 1073741824) != 0 ? TypedValue.applyDimension(2, 20.0f, Resources.getSystem().getDisplayMetrics()) : f10, (i26 & Integer.MIN_VALUE) != 0 ? -1 : i23, (i27 & 1) != 0 ? "" : str2, (i27 & 2) != 0 ? -1 : i24, (i27 & 4) != 0 ? null : num2, (i27 & 8) != 0 ? null : num3, (i27 & 16) != 0 ? null : num4, (i27 & 32) != 0 ? null : num5);
    }
}
