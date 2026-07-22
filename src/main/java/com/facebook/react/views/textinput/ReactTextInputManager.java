package com.facebook.react.views.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import com.caverock.androidsvg.SVGParser;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewDefaults;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.BlurEvent;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.FocusEvent;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.TextAttributeProps;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: ReactTextInputManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 ¥\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002¥\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0014H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001a0\u0016H\u0016J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0017H\u0016J\u0018\u0010(\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u001aH\u0007J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,H\u0007J\u001a\u0010-\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010/\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u00100\u001a\u00020,H\u0007J\u001a\u00101\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u00103\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u00105\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u00010 H\u0007J\u0018\u00107\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u00108\u001a\u000209H\u0007J\u001a\u0010:\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010:\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u001aH\u0002J)\u0010=\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0?\"\u00020\rH\u0002¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010B\u001a\u000209H\u0007J\u001a\u0010C\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010E\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010F\u001a\u000209H\u0007J\u0018\u0010G\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010H\u001a\u000209H\u0007J\u0018\u0010I\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010J\u001a\u000209H\u0007J\u0018\u0010K\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010L\u001a\u00020,H\u0007J\u0018\u0010M\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010N\u001a\u000209H\u0007J\u001a\u0010O\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010P\u001a\u0004\u0018\u00010\rH\u0007J\u001f\u0010Q\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010SJ\u001f\u0010T\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010SJ\u001f\u0010U\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010SJ\u001f\u0010V\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010SJ\u0018\u0010W\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010X\u001a\u000209H\u0007J\u0018\u0010Y\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010Z\u001a\u000209H\u0007J\u0018\u0010[\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\\\u001a\u000209H\u0007J\u001f\u0010]\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010SJ\u001f\u0010^\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010_\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010SJ\u001a\u0010`\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010a\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010b\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010c\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010d\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010e\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010f\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\u001aH\u0007J\u0018\u0010h\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010i\u001a\u000209H\u0007J\u0018\u0010j\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010k\u001a\u00020\u001aH\u0007J\u001f\u0010l\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010m\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0002\u0010SJ\u001a\u0010n\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010o\u001a\u0004\u0018\u00010\rH\u0007J\u001f\u0010p\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010q\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010rJ\u0018\u0010s\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010t\u001a\u000209H\u0007J\u0018\u0010u\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010v\u001a\u000209H\u0007J\u0018\u0010w\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010x\u001a\u00020yH\u0007J\u001a\u0010z\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010{\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010|\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010}\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010~\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\b\u0010\u007f\u001a\u0004\u0018\u00010 H\u0007J\u001a\u0010\u0080\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0007\u0010\u0081\u0001\u001a\u000209H\u0007J\u001c\u0010\u0082\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\rH\u0007J#\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0007\u0010\u0085\u0001\u001a\u00020\u001a2\u0007\u0010\u0086\u0001\u001a\u00020,H\u0007J\u001c\u0010\u0087\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u0089\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0007\u0010\u0089\u0001\u001a\u000209H\u0007J\u001a\u0010\u008a\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0007\u0010\u008b\u0001\u001a\u000209H\u0007J\u001c\u0010\u008c\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\rH\u0007J#\u0010\u008e\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0007\u0010\u0085\u0001\u001a\u00020\u001a2\u0007\u0010\u008f\u0001\u001a\u00020,H\u0007J*\u0010\u0090\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0007\u0010\u0085\u0001\u001a\u00020\u001a2\b\u0010R\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0003\u0010\u0091\u0001J\u001c\u0010\u0092\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\rH\u0007J\u0011\u0010\u0094\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0002H\u0014J\u001b\u0010\u0095\u0001\u001a\u00020\u001c2\u0007\u0010\u0096\u0001\u001a\u00020\u00102\u0007\u0010\u0097\u0001\u001a\u00020\u0002H\u0014J\u0015\u0010\u0098\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J5\u0010\u0099\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00022\u0007\u0010\u009a\u0001\u001a\u00020\u001a2\u0007\u0010\u009b\u0001\u001a\u00020\u001a2\u0007\u0010\u009c\u0001\u001a\u00020\u001a2\u0007\u0010\u009d\u0001\u001a\u00020\u001aH\u0016J'\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u00022\b\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0016J$\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u00022\b\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010£\u0001\u001a\u00030¤\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006¦\u0001"}, d2 = {"Lcom/facebook/react/views/textinput/ReactTextInputManager;", "Lcom/facebook/react/uimanager/BaseViewManager;", "Lcom/facebook/react/views/textinput/ReactEditText;", "Lcom/facebook/react/uimanager/LayoutShadowNode;", "<init>", "()V", "reactTextViewManagerCallback", "Lcom/facebook/react/views/text/ReactTextViewManagerCallback;", "getReactTextViewManagerCallback", "()Lcom/facebook/react/views/text/ReactTextViewManagerCallback;", "setReactTextViewManagerCallback", "(Lcom/facebook/react/views/text/ReactTextViewManagerCallback;)V", "getName", "", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "createShadowNodeInstance", "Lcom/facebook/react/views/text/ReactBaseTextShadowNode;", "getShadowNodeClass", "Ljava/lang/Class;", "getExportedCustomBubblingEventTypeConstants", "", "", "getExportedCustomDirectEventTypeConstants", "getCommandsMap", "", "receiveCommand", "", "reactEditText", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "getReactTextUpdate", "Lcom/facebook/react/views/text/ReactTextUpdate;", ReactTextInputShadowNode.PROP_TEXT, "mostRecentEventCount", "updateExtraData", "view", "extraData", "setLineHeight", ViewProps.LINE_HEIGHT, "setFontSize", ViewProps.FONT_SIZE, "", "setFontFamily", ViewProps.FONT_FAMILY, "setMaxFontSizeMultiplier", ViewProps.MAX_FONT_SIZE_MULTIPLIER, "setFontWeight", ViewProps.FONT_WEIGHT, "setFontStyle", ViewProps.FONT_STYLE, "setFontVariant", ViewProps.FONT_VARIANT, "setIncludeFontPadding", "includepad", "", "setImportantForAutofill", "value", "mode", "setAutofillHints", "hints", "", "(Lcom/facebook/react/views/textinput/ReactEditText;[Ljava/lang/String;)V", "setOnSelectionChange", "onSelectionChange", "setSubmitBehavior", "submitBehavior", "setOnContentSizeChange", "onContentSizeChange", "setOnScroll", "onScroll", "setOnKeyPress", "onKeyPress", "setLetterSpacing", ViewProps.LETTER_SPACING, "setAllowFontScaling", ViewProps.ALLOW_FONT_SCALING, "setPlaceholder", ReactTextInputShadowNode.PROP_PLACEHOLDER, "setPlaceholderTextColor", ViewProps.COLOR, "(Lcom/facebook/react/views/textinput/ReactEditText;Ljava/lang/Integer;)V", "setSelectionColor", "setSelectionHandleColor", "setCursorColor", "setCaretHidden", "caretHidden", "setContextMenuHidden", "contextMenuHidden", "setSelectTextOnFocus", "selectTextOnFocus", "setColor", "setUnderlineColor", "underlineColor", "setTextAlign", ViewProps.TEXT_ALIGN, "setTextAlignVertical", ViewProps.TEXT_ALIGN_VERTICAL, "setInlineImageLeft", "resource", "setInlineImagePadding", ViewProps.PADDING, "setEditable", "editable", "setNumLines", "numLines", "setMaxLength", "maxLength", "setTextContentType", "autoComplete", "setAutoCorrect", "autoCorrect", "(Lcom/facebook/react/views/textinput/ReactEditText;Ljava/lang/Boolean;)V", "setMultiline", "multiline", "setSecureTextEntry", HintConstants.AUTOFILL_HINT_PASSWORD, "setAutoCapitalize", "autoCapitalize", "Lcom/facebook/react/bridge/Dynamic;", "setKeyboardType", "keyboardType", "setReturnKeyType", "returnKeyType", "setAcceptDragAndDropTypes", "acceptDragAndDropTypes", "setDisableFullscreenUI", "disableFullscreenUI", "setReturnKeyLabel", "returnKeyLabel", "setBorderRadius", "index", ViewProps.BORDER_RADIUS, "setBorderStyle", "borderStyle", "showKeyboardOnFocus", "setAutoFocus", "autoFocus", "setTextDecorationLine", "textDecorationLineString", "setBorderWidth", "width", "setBorderColor", "(Lcom/facebook/react/views/textinput/ReactEditText;ILjava/lang/Integer;)V", "setOverflow", ViewProps.OVERFLOW, "onAfterUpdateTransaction", "addEventEmitters", "reactContext", "editText", "getExportedViewConstants", "setPadding", ViewProps.LEFT, ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "updateState", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "state", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ReactModule(name = ReactTextInputManager.REACT_CLASS)
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    private static final int AUTOCAPITALIZE_FLAGS = 28672;
    private static final int BLUR_TEXT_INPUT = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] DRAWABLE_HANDLE_FIELDS;
    private static final String[] DRAWABLE_HANDLE_RESOURCES;
    private static final InputFilter[] EMPTY_FILTERS;
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_URI = "url";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    public static final String REACT_CLASS = "AndroidTextInput";
    private static final Map<String, String> REACT_PROPS_AUTOFILL_HINTS_MAP;
    private static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    private static final int SET_TEXT_AND_SELECTION = 4;
    private static final String TAG;
    private static final short TX_STATE_KEY_ATTRIBUTED_STRING = 0;
    private static final short TX_STATE_KEY_MOST_RECENT_EVENT_COUNT = 3;
    private static final short TX_STATE_KEY_PARAGRAPH_ATTRIBUTES = 1;
    private static final int UNSET = -1;
    private ReactTextViewManagerCallback reactTextViewManagerCallback;

    protected final ReactTextViewManagerCallback getReactTextViewManagerCallback() {
        return this.reactTextViewManagerCallback;
    }

    protected final void setReactTextViewManagerCallback(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.reactTextViewManagerCallback = reactTextViewManagerCallback;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactEditText createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ReactEditText reactEditText = new ReactEditText(context);
        reactEditText.setInputType(reactEditText.getInputType() & (-131073));
        reactEditText.setReturnKeyType("done");
        reactEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return reactEditText;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactBaseTextShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode(null, 1, null);
    }

    public final ReactBaseTextShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextInputShadowNode(reactTextViewManagerCallback);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        LinkedHashMap exportedCustomBubblingEventTypeConstants = super.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants == null) {
            exportedCustomBubblingEventTypeConstants = new LinkedHashMap();
        }
        exportedCustomBubblingEventTypeConstants.putAll(MapsKt.mapOf(TuplesKt.to("topSubmitEditing", MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onSubmitEditing"), TuplesKt.to("captured", "onSubmitEditingCapture"))))), TuplesKt.to("topEndEditing", MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onEndEditing"), TuplesKt.to("captured", "onEndEditingCapture"))))), TuplesKt.to(ReactTextInputKeyPressEvent.EVENT_NAME, MapsKt.mapOf(TuplesKt.to("phasedRegistrationNames", MapsKt.mapOf(TuplesKt.to("bubbled", "onKeyPress"), TuplesKt.to("captured", "onKeyPressCapture")))))));
        return exportedCustomBubblingEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        LinkedHashMap exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new LinkedHashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapsKt.mapOf(TuplesKt.to(ScrollEventType.INSTANCE.getJSEventName(ScrollEventType.SCROLL), MapsKt.mapOf(TuplesKt.to("registrationName", "onScroll")))));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapsKt.mapOf(TuplesKt.to("focusTextInput", 1), TuplesKt.to("blurTextInput", 2));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Deprecated(message = "Deprecated in Java")
    public void receiveCommand(ReactEditText reactEditText, int commandId, ReadableArray args) {
        Intrinsics.checkNotNullParameter(reactEditText, "reactEditText");
        if (commandId == 1) {
            receiveCommand(reactEditText, "focus", args);
        } else if (commandId == 2) {
            receiveCommand(reactEditText, "blur", args);
        } else {
            if (commandId != 4) {
                return;
            }
            receiveCommand(reactEditText, "setTextAndSelection", args);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactEditText reactEditText, String commandId, ReadableArray args) {
        Intrinsics.checkNotNullParameter(reactEditText, "reactEditText");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        switch (commandId.hashCode()) {
            case -1699362314:
                if (!commandId.equals("blurTextInput")) {
                    return;
                }
                break;
            case 3027047:
                if (!commandId.equals("blur")) {
                    return;
                }
                break;
            case 97604824:
                if (!commandId.equals("focus")) {
                    return;
                }
                reactEditText.requestFocusFromJS();
                return;
            case 1427010500:
                if (commandId.equals("setTextAndSelection")) {
                    if (args != null) {
                        int i = args.getInt(0);
                        if (i == -1) {
                            return;
                        }
                        int i2 = args.getInt(2);
                        int i3 = args.getInt(3);
                        if (i3 == -1) {
                            i3 = i2;
                        }
                        if (!args.isNull(1)) {
                            reactEditText.maybeSetTextFromJS(getReactTextUpdate(args.getString(1), i));
                        }
                        reactEditText.maybeSetSelection(i, i2, i3);
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                return;
            case 1690703013:
                if (!commandId.equals("focusTextInput")) {
                    return;
                }
                reactEditText.requestFocusFromJS();
                return;
            default:
                return;
        }
        reactEditText.clearFocusFromJS$ReactAndroid_release();
    }

    private final ReactTextUpdate getReactTextUpdate(String text, int mostRecentEventCount) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) text);
        return new ReactTextUpdate(spannableStringBuilder, mostRecentEventCount, false, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ReactEditText view, Object extraData) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        if (extraData instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) extraData;
            int paddingLeft = (int) reactTextUpdate.getPaddingLeft();
            int paddingTop = (int) reactTextUpdate.getPaddingTop();
            int paddingRight = (int) reactTextUpdate.getPaddingRight();
            int paddingBottom = (int) reactTextUpdate.getPaddingBottom();
            int length = -1;
            if (paddingLeft != -1 || paddingTop != -1 || paddingRight != -1 || paddingBottom != -1) {
                if (paddingLeft == -1) {
                    paddingLeft = view.getPaddingLeft();
                }
                if (paddingTop == -1) {
                    paddingTop = view.getPaddingTop();
                }
                if (paddingRight == -1) {
                    paddingRight = view.getPaddingRight();
                }
                if (paddingBottom == -1) {
                    paddingBottom = view.getPaddingBottom();
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            if (reactTextUpdate.getContainsImages()) {
                TextInlineImageSpan.INSTANCE.possiblyUpdateInlineImageSpans(reactTextUpdate.getText(), view);
            }
            if (view.getSelectionStart() == view.getSelectionEnd()) {
                Editable text = view.getText();
                length = reactTextUpdate.getText().length() - ((text != null ? text.length() : 0) - view.getSelectionStart());
            }
            view.maybeSetTextFromState(reactTextUpdate);
            view.maybeSetSelection(reactTextUpdate.getJsEventCounter(), length, length);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = ViewProps.LINE_HEIGHT)
    public final void setLineHeight(ReactEditText view, int lineHeight) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLineHeight(lineHeight);
    }

    @ReactProp(defaultFloat = ViewDefaults.FONT_SIZE_SP, name = ViewProps.FONT_SIZE)
    public final void setFontSize(ReactEditText view, float fontSize) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFontSize(fontSize);
    }

    @ReactProp(name = ViewProps.FONT_FAMILY)
    public final void setFontFamily(ReactEditText view, String fontFamily) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFontFamily(fontFamily);
    }

    @ReactProp(defaultFloat = Float.NaN, name = ViewProps.MAX_FONT_SIZE_MULTIPLIER)
    public final void setMaxFontSizeMultiplier(ReactEditText view, float maxFontSizeMultiplier) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMaxFontSizeMultiplier(maxFontSizeMultiplier);
    }

    @ReactProp(name = ViewProps.FONT_WEIGHT)
    public final void setFontWeight(ReactEditText view, String fontWeight) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFontWeight(fontWeight);
    }

    @ReactProp(name = ViewProps.FONT_STYLE)
    public final void setFontStyle(ReactEditText view, String fontStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFontStyle(fontStyle);
    }

    @ReactProp(name = ViewProps.FONT_VARIANT)
    public final void setFontVariant(ReactEditText view, ReadableArray fontVariant) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFontFeatureSettings(ReactTypefaceUtils.parseFontVariant(fontVariant));
    }

    @ReactProp(defaultBoolean = true, name = ViewProps.INCLUDE_FONT_PADDING)
    public final void setIncludeFontPadding(ReactEditText view, boolean includepad) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIncludeFontPadding(includepad);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    @ReactProp(name = "importantForAutofill")
    public final void setImportantForAutofill(ReactEditText view, String value) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        if (value == null) {
            i = 0;
        } else {
            int iHashCode = value.hashCode();
            if (iHashCode != 3521) {
                if (iHashCode != 119527) {
                    if (iHashCode != 1723649149) {
                        if (iHashCode == 1828836387 && value.equals("yesExcludeDescendants")) {
                            i = 4;
                        } else {
                            i = 0;
                        }
                    } else if (value.equals("noExcludeDescendants")) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                } else if (value.equals("yes")) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (value.equals(SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO)) {
                i = 2;
            } else {
                i = 0;
            }
        }
        setImportantForAutofill(view, i);
    }

    private final void setImportantForAutofill(ReactEditText view, int mode) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setImportantForAutofill(mode);
    }

    private final void setAutofillHints(ReactEditText view, String... hints) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        view.setAutofillHints((String[]) Arrays.copyOf(hints, hints.length));
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public final void setOnSelectionChange(ReactEditText view, boolean onSelectionChange) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (onSelectionChange) {
            view.setSelectionWatcher$ReactAndroid_release(new ReactTextSelectionWatcher(view));
        } else {
            view.setSelectionWatcher$ReactAndroid_release(null);
        }
    }

    @ReactProp(name = "submitBehavior")
    public final void setSubmitBehavior(ReactEditText view, String submitBehavior) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSubmitBehavior(submitBehavior);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public final void setOnContentSizeChange(ReactEditText view, boolean onContentSizeChange) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (onContentSizeChange) {
            view.setContentSizeWatcher(new ReactTextContentSizeWatcher(view));
        } else {
            view.setContentSizeWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public final void setOnScroll(ReactEditText view, boolean onScroll) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (onScroll) {
            view.setScrollWatcher(new ReactTextScrollWatcher(view));
        } else {
            view.setScrollWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public final void setOnKeyPress(ReactEditText view, boolean onKeyPress) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnKeyPress(onKeyPress);
    }

    @ReactProp(defaultFloat = 0.0f, name = ViewProps.LETTER_SPACING)
    public final void setLetterSpacing(ReactEditText view, float letterSpacing) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLetterSpacingPt(letterSpacing);
    }

    @ReactProp(defaultBoolean = true, name = ViewProps.ALLOW_FONT_SCALING)
    public final void setAllowFontScaling(ReactEditText view, boolean allowFontScaling) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAllowFontScaling(allowFontScaling);
    }

    @ReactProp(name = ReactTextInputShadowNode.PROP_PLACEHOLDER)
    public final void setPlaceholder(ReactEditText view, String placeholder) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPlaceholder(placeholder);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public final void setPlaceholderTextColor(ReactEditText view, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (color == null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            view.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(context));
            return;
        }
        view.setHintTextColor(color.intValue());
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public final void setSelectionColor(ReactEditText view, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (color == null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            view.setHighlightColor(DefaultStyleValuesUtil.getDefaultTextColorHighlight(context));
            return;
        }
        view.setHighlightColor(color.intValue());
    }

    @ReactProp(customType = "Color", name = "selectionHandleColor")
    public final void setSelectionHandleColor(ReactEditText view, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 29) {
            Drawable textSelectHandle = view.getTextSelectHandle();
            Drawable drawableMutate = textSelectHandle != null ? textSelectHandle.mutate() : null;
            if (drawableMutate == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Drawable textSelectHandleLeft = view.getTextSelectHandleLeft();
            Drawable drawableMutate2 = textSelectHandleLeft != null ? textSelectHandleLeft.mutate() : null;
            if (drawableMutate2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Drawable textSelectHandleRight = view.getTextSelectHandleRight();
            Drawable drawableMutate3 = textSelectHandleRight != null ? textSelectHandleRight.mutate() : null;
            if (drawableMutate3 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (color != null) {
                BlendModeColorFilter blendModeColorFilter = new BlendModeColorFilter(color.intValue(), BlendMode.SRC_IN);
                drawableMutate.setColorFilter(blendModeColorFilter);
                drawableMutate2.setColorFilter(blendModeColorFilter);
                drawableMutate3.setColorFilter(blendModeColorFilter);
            } else {
                drawableMutate.clearColorFilter();
                drawableMutate2.clearColorFilter();
                drawableMutate3.clearColorFilter();
            }
            view.setTextSelectHandle(drawableMutate);
            view.setTextSelectHandleLeft(drawableMutate2);
            view.setTextSelectHandleRight(drawableMutate3);
            return;
        }
        if (Build.VERSION.SDK_INT == 28) {
            return;
        }
        int length = DRAWABLE_HANDLE_RESOURCES.length;
        for (int i = 0; i < length; i++) {
            try {
                Field declaredField = view.getClass().getDeclaredField(DRAWABLE_HANDLE_RESOURCES[i]);
                declaredField.setAccessible(true);
                int i2 = declaredField.getInt(view);
                if (i2 == 0) {
                    return;
                }
                Drawable drawable = ContextCompat.getDrawable(view.getContext(), i2);
                Drawable drawableMutate4 = drawable != null ? drawable.mutate() : null;
                if (drawableMutate4 == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                if (color != null) {
                    drawableMutate4.setColorFilter(color.intValue(), PorterDuff.Mode.SRC_IN);
                } else {
                    drawableMutate4.clearColorFilter();
                }
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(view);
                if (obj == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                Field declaredField3 = obj.getClass().getDeclaredField(DRAWABLE_HANDLE_FIELDS[i]);
                declaredField3.setAccessible(true);
                declaredField3.set(obj, drawableMutate4);
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
    }

    @ReactProp(customType = "Color", name = "cursorColor")
    public final void setCursorColor(ReactEditText view, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Build.VERSION.SDK_INT >= 29) {
            Drawable textCursorDrawable = view.getTextCursorDrawable();
            if (textCursorDrawable != null) {
                if (color != null) {
                    textCursorDrawable.setColorFilter(new BlendModeColorFilter(color.intValue(), BlendMode.SRC_IN));
                } else {
                    textCursorDrawable.clearColorFilter();
                }
                view.setTextCursorDrawable(textCursorDrawable);
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT == 28) {
            return;
        }
        try {
            Field declaredField = view.getClass().getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(view);
            if (i == 0) {
                return;
            }
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), i);
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            if (drawableMutate == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (color != null) {
                drawableMutate.setColorFilter(color.intValue(), PorterDuff.Mode.SRC_IN);
            } else {
                drawableMutate.clearColorFilter();
            }
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(view);
            if (obj == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            declaredField3.set(obj, new Drawable[]{drawableMutate, drawableMutate});
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public final void setCaretHidden(ReactEditText view, boolean caretHidden) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getStagedInputType() == 32 && INSTANCE.shouldHideCursorForEmailTextInput()) {
            return;
        }
        view.setCursorVisible(!caretHidden);
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public final void setContextMenuHidden(ReactEditText view, boolean contextMenuHidden) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setContextMenuHidden(contextMenuHidden);
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public final void setSelectTextOnFocus(ReactEditText view, boolean selectTextOnFocus) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSelectTextOnFocus(selectTextOnFocus);
    }

    @ReactProp(customType = "Color", name = ViewProps.COLOR)
    public final void setColor(ReactEditText view, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (color == null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ColorStateList defaultTextColor = DefaultStyleValuesUtil.getDefaultTextColor(context);
            if (defaultTextColor != null) {
                view.setTextColor(defaultTextColor);
                return;
            } else {
                Context context2 = view.getContext();
                ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Could not get default text color from View Context: " + (context2 != null ? context2.getClass().getCanonicalName() : "null")));
                return;
            }
        }
        view.setTextColor(color.intValue());
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public final void setUnderlineColor(ReactEditText view, Integer underlineColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable background = view.getBackground();
        if (background == null) {
            return;
        }
        if (background.getConstantState() != null) {
            try {
                Drawable drawableMutate = background.mutate();
                if (drawableMutate == null) {
                    throw new IllegalStateException("Required value was null.".toString());
                }
                background = drawableMutate;
            } catch (NullPointerException e) {
                FLog.e(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", e);
            }
        }
        if (underlineColor == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(underlineColor.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
    
        if (r7.equals("auto") == false) goto L34;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @com.facebook.react.uimanager.annotations.ReactProp(name = com.facebook.react.uimanager.ViewProps.TEXT_ALIGN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setTextAlign(com.facebook.react.views.textinput.ReactEditText r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "justify"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
            r1 = 1
            r2 = 3
            r3 = 26
            if (r0 == 0) goto L1c
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r3) goto L18
            r6.setJustificationMode(r1)
        L18:
            r6.setGravityHorizontal$ReactAndroid_release(r2)
            return
        L1c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            if (r0 < r3) goto L24
            r6.setJustificationMode(r4)
        L24:
            if (r7 == 0) goto L77
            int r0 = r7.hashCode()
            switch(r0) {
                case -1364013995: goto L52;
                case 3005871: goto L49;
                case 3317767: goto L3c;
                case 108511772: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L5f
        L2e:
            java.lang.String r0 = "right"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L37
            goto L5f
        L37:
            r7 = 5
            r6.setGravityHorizontal$ReactAndroid_release(r7)
            return
        L3c:
            java.lang.String r0 = "left"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L45
            goto L5f
        L45:
            r6.setGravityHorizontal$ReactAndroid_release(r2)
            return
        L49:
            java.lang.String r0 = "auto"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L77
            goto L5f
        L52:
            java.lang.String r0 = "center"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L5b
            goto L5f
        L5b:
            r6.setGravityHorizontal$ReactAndroid_release(r1)
            return
        L5f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid textAlign: "
            r0.<init>(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            java.lang.String r0 = "ReactNative"
            com.facebook.common.logging.FLog.w(r0, r7)
            r6.setGravityHorizontal$ReactAndroid_release(r4)
            return
        L77:
            r6.setGravityHorizontal$ReactAndroid_release(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.setTextAlign(com.facebook.react.views.textinput.ReactEditText, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        if (r5.equals("auto") == false) goto L25;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @com.facebook.react.uimanager.annotations.ReactProp(name = com.facebook.react.uimanager.ViewProps.TEXT_ALIGN_VERTICAL)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setTextAlignVertical(com.facebook.react.views.textinput.ReactEditText r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            if (r5 == 0) goto L5e
            int r1 = r5.hashCode()
            switch(r1) {
                case -1383228885: goto L37;
                case -1364013995: goto L28;
                case 115029: goto L19;
                case 3005871: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L46
        L10:
            java.lang.String r1 = "auto"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L5e
            goto L46
        L19:
            java.lang.String r1 = "top"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L22
            goto L46
        L22:
            r5 = 48
            r4.setGravityVertical$ReactAndroid_release(r5)
            return
        L28:
            java.lang.String r1 = "center"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L31
            goto L46
        L31:
            r5 = 16
            r4.setGravityVertical$ReactAndroid_release(r5)
            return
        L37:
            java.lang.String r1 = "bottom"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L40
            goto L46
        L40:
            r5 = 80
            r4.setGravityVertical$ReactAndroid_release(r5)
            return
        L46:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid textAlignVertical: "
            r1.<init>(r2)
            java.lang.StringBuilder r5 = r1.append(r5)
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = "ReactNative"
            com.facebook.common.logging.FLog.w(r1, r5)
            r4.setGravityVertical$ReactAndroid_release(r0)
            return
        L5e:
            r4.setGravityVertical$ReactAndroid_release(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.setTextAlignVertical(com.facebook.react.views.textinput.ReactEditText, java.lang.String):void");
    }

    @ReactProp(name = "inlineImageLeft")
    public final void setInlineImageLeft(ReactEditText view, String resource) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        view.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.getResourceDrawableId(context, resource), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public final void setInlineImagePadding(ReactEditText view, int padding) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setCompoundDrawablePadding(padding);
    }

    @ReactProp(defaultBoolean = true, name = "editable")
    public final void setEditable(ReactEditText view, boolean editable) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(editable);
    }

    @ReactProp(defaultInt = 1, name = ViewProps.NUMBER_OF_LINES)
    public final void setNumLines(ReactEditText view, int numLines) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLines(numLines);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0048 A[PHI: r1
  0x0048: PHI (r1v10 android.text.InputFilter[]) = (r1v8 android.text.InputFilter[]), (r1v0 android.text.InputFilter[]), (r1v0 android.text.InputFilter[]) binds: [B:31:0x0071, B:8:0x0017, B:16:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    @ReactProp(name = "maxLength")
    public final void setMaxLength(ReactEditText view, Integer maxLength) {
        Intrinsics.checkNotNullParameter(view, "view");
        InputFilter[] filters = view.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (maxLength == null) {
            Intrinsics.checkNotNull(filters);
            if (filters.length == 0) {
                filters = inputFilterArr;
            } else {
                LinkedList linkedList = new LinkedList();
                Iterator it = ArrayIteratorKt.iterator(filters);
                while (it.hasNext()) {
                    InputFilter inputFilter = (InputFilter) it.next();
                    if (!(inputFilter instanceof InputFilter.LengthFilter)) {
                        linkedList.add(inputFilter);
                    }
                }
                if (linkedList.isEmpty()) {
                    filters = inputFilterArr;
                } else {
                    filters = (InputFilter[]) linkedList.toArray(new InputFilter[0]);
                }
            }
        } else {
            Intrinsics.checkNotNull(filters);
            if (!(filters.length == 0)) {
                int length = filters.length;
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    if (filters[i] instanceof InputFilter.LengthFilter) {
                        filters[i] = new InputFilter.LengthFilter(maxLength.intValue());
                        z = true;
                    }
                }
                if (!z) {
                    inputFilterArr = new InputFilter[filters.length + 1];
                    System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                    filters[filters.length] = new InputFilter.LengthFilter(maxLength.intValue());
                    filters = inputFilterArr;
                }
            } else {
                filters = new InputFilter[]{new InputFilter.LengthFilter(maxLength.intValue())};
            }
        }
        view.setFilters(filters);
    }

    @ReactProp(name = "autoComplete")
    public final void setTextContentType(ReactEditText view, String autoComplete) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (autoComplete == null) {
            setImportantForAutofill(view, 2);
            return;
        }
        if (Intrinsics.areEqual(DebugKt.DEBUG_PROPERTY_VALUE_OFF, autoComplete)) {
            setImportantForAutofill(view, 2);
            return;
        }
        Map<String, String> map = REACT_PROPS_AUTOFILL_HINTS_MAP;
        if (map.containsKey(autoComplete)) {
            String[] strArr = new String[1];
            String str = map.get(autoComplete);
            if (str == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            strArr[0] = str;
            setAutofillHints(view, strArr);
            return;
        }
        FLog.w(ReactConstants.TAG, "Invalid autoComplete: " + autoComplete);
        setImportantForAutofill(view, 2);
    }

    @ReactProp(name = "autoCorrect")
    public final void setAutoCorrect(ReactEditText view, Boolean autoCorrect) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        Companion companion = INSTANCE;
        if (Intrinsics.areEqual((Object) autoCorrect, (Object) true)) {
            i = 32768;
        } else {
            i = Intrinsics.areEqual((Object) autoCorrect, (Object) false) ? 524288 : 0;
        }
        companion.updateStagedInputTypeFlag(view, 557056, i);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public final void setMultiline(ReactEditText view, boolean multiline) {
        Intrinsics.checkNotNullParameter(view, "view");
        INSTANCE.updateStagedInputTypeFlag(view, multiline ? 0 : 131072, multiline ? 131072 : 0);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public final void setSecureTextEntry(ReactEditText view, boolean password) {
        Intrinsics.checkNotNullParameter(view, "view");
        Companion companion = INSTANCE;
        companion.updateStagedInputTypeFlag(view, 144, password ? 128 : 0);
        companion.checkPasswordType(view);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x0058  */
    @ReactProp(name = "autoCapitalize")
    public final void setAutoCapitalize(ReactEditText view, Dynamic autoCapitalize) {
        int iAsInt;
        String strAsString;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(autoCapitalize, "autoCapitalize");
        if (autoCapitalize.getType() == ReadableType.Number) {
            iAsInt = autoCapitalize.asInt();
        } else if (autoCapitalize.getType() == ReadableType.String && (strAsString = autoCapitalize.asString()) != null) {
            switch (strAsString.hashCode()) {
                case 3387192:
                    if (!strAsString.equals("none")) {
                        iAsInt = 16384;
                    } else {
                        iAsInt = 0;
                    }
                    break;
                case 113318569:
                    if (!strAsString.equals("words")) {
                        iAsInt = 16384;
                    } else {
                        iAsInt = 8192;
                    }
                    break;
                case 490141296:
                    strAsString.equals("sentences");
                    iAsInt = 16384;
                    break;
                case 1245424234:
                    if (!strAsString.equals("characters")) {
                        iAsInt = 16384;
                    } else {
                        iAsInt = 4096;
                    }
                    break;
                default:
                    iAsInt = 16384;
                    break;
            }
        } else {
            iAsInt = 16384;
        }
        INSTANCE.updateStagedInputTypeFlag(view, AUTOCAPITALIZE_FLAGS, iAsInt);
    }

    @ReactProp(name = "keyboardType")
    public final void setKeyboardType(ReactEditText view, String keyboardType) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i = 1;
        if (StringsKt.equals("numeric", keyboardType, true)) {
            i = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (StringsKt.equals(KEYBOARD_TYPE_NUMBER_PAD, keyboardType, true)) {
            i = 2;
        } else if (StringsKt.equals(KEYBOARD_TYPE_DECIMAL_PAD, keyboardType, true)) {
            i = 8194;
        } else if (!StringsKt.equals(KEYBOARD_TYPE_EMAIL_ADDRESS, keyboardType, true)) {
            if (StringsKt.equals(KEYBOARD_TYPE_PHONE_PAD, keyboardType, true)) {
                i = 3;
            } else if (StringsKt.equals(KEYBOARD_TYPE_VISIBLE_PASSWORD, keyboardType, true)) {
                i = 144;
            } else if (StringsKt.equals("url", keyboardType, true)) {
                i = 16;
            }
        } else {
            if (INSTANCE.shouldHideCursorForEmailTextInput()) {
                view.setCursorVisible(false);
            }
            i = 33;
        }
        Companion companion = INSTANCE;
        companion.updateStagedInputTypeFlag(view, 15, i);
        companion.checkPasswordType(view);
    }

    @ReactProp(name = "returnKeyType")
    public final void setReturnKeyType(ReactEditText view, String returnKeyType) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setReturnKeyType(returnKeyType);
    }

    @ReactProp(name = "acceptDragAndDropTypes")
    public final void setAcceptDragAndDropTypes(ReactEditText view, ReadableArray acceptDragAndDropTypes) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (acceptDragAndDropTypes == null) {
            view.setDragAndDropFilter(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = acceptDragAndDropTypes.size();
        for (int i = 0; i < size; i++) {
            String string = acceptDragAndDropTypes.getString(i);
            if (string != null) {
                arrayList.add(string);
            }
        }
        view.setDragAndDropFilter(arrayList);
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public final void setDisableFullscreenUI(ReactEditText view, boolean disableFullscreenUI) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDisableFullscreenUI(disableFullscreenUI);
    }

    @ReactProp(name = "returnKeyLabel")
    public final void setReturnKeyLabel(ReactEditText view, String returnKeyLabel) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setImeActionLabel(returnKeyLabel, IME_ACTION_ID);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {ViewProps.BORDER_RADIUS, ViewProps.BORDER_TOP_LEFT_RADIUS, ViewProps.BORDER_TOP_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_RIGHT_RADIUS, ViewProps.BORDER_BOTTOM_LEFT_RADIUS})
    public final void setBorderRadius(ReactEditText view, int index, float borderRadius) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderRadius(view, BorderRadiusProp.getEntries().get(index), Float.isNaN(borderRadius) ? null : new LengthPercentage(borderRadius, LengthPercentageType.POINT));
    }

    @ReactProp(name = "borderStyle")
    public final void setBorderStyle(ReactEditText view, String borderStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderStyle(view, borderStyle != null ? BorderStyle.INSTANCE.fromString(borderStyle) : null);
    }

    @ReactProp(defaultBoolean = true, name = "showSoftInputOnFocus")
    public final void showKeyboardOnFocus(ReactEditText view, boolean showKeyboardOnFocus) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setShowSoftInputOnFocus(showKeyboardOnFocus);
    }

    @ReactProp(defaultBoolean = false, name = "autoFocus")
    public final void setAutoFocus(ReactEditText view, boolean autoFocus) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAutoFocus(autoFocus);
    }

    @ReactProp(name = ViewProps.TEXT_DECORATION_LINE)
    public final void setTextDecorationLine(ReactEditText view, String textDecorationLineString) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPaintFlags(view.getPaintFlags() & (-25));
        if (textDecorationLineString == null) {
            return;
        }
        List<String> listSplit = new Regex(" ").split(textDecorationLineString, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                    break;
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
            break;
        }
        for (String str : (String[]) listEmptyList.toArray(new String[0])) {
            if (Intrinsics.areEqual(str, "underline")) {
                view.setPaintFlags(view.getPaintFlags() | 8);
            } else if (Intrinsics.areEqual(str, "line-through")) {
                view.setPaintFlags(view.getPaintFlags() | 16);
            }
        }
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {ViewProps.BORDER_WIDTH, ViewProps.BORDER_LEFT_WIDTH, ViewProps.BORDER_RIGHT_WIDTH, ViewProps.BORDER_TOP_WIDTH, ViewProps.BORDER_BOTTOM_WIDTH})
    public final void setBorderWidth(ReactEditText view, int index, float width) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderWidth(view, LogicalEdge.getEntries().get(index), Float.valueOf(width));
    }

    @ReactPropGroup(customType = "Color", names = {ViewProps.BORDER_COLOR, ViewProps.BORDER_LEFT_COLOR, ViewProps.BORDER_RIGHT_COLOR, ViewProps.BORDER_TOP_COLOR, ViewProps.BORDER_BOTTOM_COLOR})
    public final void setBorderColor(ReactEditText view, int index, Integer color) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.setBorderColor(view, LogicalEdge.ALL, color);
    }

    @ReactProp(name = ViewProps.OVERFLOW)
    public final void setOverflow(ReactEditText view, String overflow) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOverflow(overflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactEditText view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.maybeUpdateTypeface();
        view.commitStagedInputType$ReactAndroid_release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(final ThemedReactContext reactContext, final ReactEditText editText) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(editText, "editText");
        ThemedReactContext themedReactContext = reactContext;
        editText.setEventDispatcher(INSTANCE.getEventDispatcher(themedReactContext, editText));
        editText.addTextChangedListener(new ReactTextInputTextWatcher(themedReactContext, editText));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.facebook.react.views.textinput.ReactTextInputManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ReactTextInputManager.addEventEmitters$lambda$2(reactContext, editText, view, z);
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.facebook.react.views.textinput.ReactTextInputManager$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ReactTextInputManager.addEventEmitters$lambda$3(editText, reactContext, textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventEmitters$lambda$2(ThemedReactContext themedReactContext, ReactEditText reactEditText, View view, boolean z) {
        int surfaceId = themedReactContext.getSurfaceId();
        EventDispatcher eventDispatcher = INSTANCE.getEventDispatcher(themedReactContext, reactEditText);
        if (z) {
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(new FocusEvent(surfaceId, reactEditText.getId()));
            }
        } else {
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(new BlurEvent(surfaceId, reactEditText.getId()));
            }
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent(new ReactTextInputEndEditingEvent(surfaceId, reactEditText.getId(), String.valueOf(reactEditText.getText())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addEventEmitters$lambda$3(ReactEditText reactEditText, ThemedReactContext themedReactContext, TextView textView, int i, KeyEvent keyEvent) {
        EventDispatcher eventDispatcher;
        if ((i & 255) == 0 && i != 0) {
            return true;
        }
        boolean zIsMultiline$ReactAndroid_release = reactEditText.isMultiline$ReactAndroid_release();
        boolean zShouldSubmitOnReturn = reactEditText.shouldSubmitOnReturn();
        boolean zShouldBlurOnReturn = reactEditText.shouldBlurOnReturn();
        if (zShouldSubmitOnReturn && (eventDispatcher = INSTANCE.getEventDispatcher(themedReactContext, reactEditText)) != null) {
            eventDispatcher.dispatchEvent(new ReactTextInputSubmitEditingEvent(themedReactContext.getSurfaceId(), reactEditText.getId(), String.valueOf(reactEditText.getText())));
        }
        if (zShouldBlurOnReturn) {
            reactEditText.clearFocusAndMaybeRefocus$ReactAndroid_release();
        }
        return zShouldBlurOnReturn || zShouldSubmitOnReturn || !zIsMultiline$ReactAndroid_release || i == 5 || i == 7;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedViewConstants() {
        return MapsKt.mapOf(TuplesKt.to("AutoCapitalizationType", MapsKt.mapOf(TuplesKt.to("none", 0), TuplesKt.to("characters", 4096), TuplesKt.to("words", 8192), TuplesKt.to("sentences", 16384))));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(ReactEditText view, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPadding(left, top, right, bottom);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactEditText view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        if (ReactEditText.INSTANCE.getDEBUG_MODE()) {
            FLog.e(TAG, "updateState: [" + view.getId() + "]");
        }
        if (view.getStateWrapper() == null) {
            view.setPadding(0, 0, 0, 0);
        }
        view.setStateWrapper(stateWrapper);
        ReadableMapBuffer stateDataMapBuffer = stateWrapper.getStateDataMapBuffer();
        if (stateDataMapBuffer != null) {
            return getReactTextUpdate(view, props, stateDataMapBuffer);
        }
        return null;
    }

    public final Object getReactTextUpdate(ReactEditText view, ReactStylesDiffMap props, MapBuffer state) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.getCount() == 0) {
            return null;
        }
        MapBuffer mapBuffer = state.getMapBuffer(0);
        MapBuffer mapBuffer2 = state.getMapBuffer(1);
        TextLayoutManager textLayoutManager = TextLayoutManager.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ReactTextUpdate.INSTANCE.buildReactTextUpdateFromState(textLayoutManager.getOrCreateSpannableForText(context, mapBuffer, this.reactTextViewManagerCallback), state.getInt(3), TextAttributeProps.getTextAlignment(props, TextLayoutManager.INSTANCE.isRTL(mapBuffer), view.getGravityHorizontal$ReactAndroid_release()), TextAttributeProps.getTextBreakStrategy(mapBuffer2.getString(2)), TextAttributeProps.getJustificationMode(props, Build.VERSION.SDK_INT >= 26 ? view.getJustificationMode() : 0));
    }

    /* JADX INFO: compiled from: ReactTextInputManager.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J \u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002J\u001a\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020-H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010)\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/facebook/react/views/textinput/ReactTextInputManager$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "REACT_CLASS", "TX_STATE_KEY_ATTRIBUTED_STRING", "", "TX_STATE_KEY_PARAGRAPH_ATTRIBUTES", "TX_STATE_KEY_MOST_RECENT_EVENT_COUNT", "REACT_PROPS_AUTOFILL_HINTS_MAP", "", "FOCUS_TEXT_INPUT", "", "BLUR_TEXT_INPUT", "SET_MOST_RECENT_EVENT_COUNT", "SET_TEXT_AND_SELECTION", "INPUT_TYPE_KEYBOARD_NUMBER_PAD", "INPUT_TYPE_KEYBOARD_DECIMAL_PAD", "INPUT_TYPE_KEYBOARD_NUMBERED", "AUTOCAPITALIZE_FLAGS", "KEYBOARD_TYPE_EMAIL_ADDRESS", "KEYBOARD_TYPE_NUMERIC", "KEYBOARD_TYPE_DECIMAL_PAD", "KEYBOARD_TYPE_NUMBER_PAD", "KEYBOARD_TYPE_PHONE_PAD", "KEYBOARD_TYPE_VISIBLE_PASSWORD", "KEYBOARD_TYPE_URI", "EMPTY_FILTERS", "", "Landroid/text/InputFilter;", "[Landroid/text/InputFilter;", "UNSET", "DRAWABLE_HANDLE_RESOURCES", "[Ljava/lang/String;", "DRAWABLE_HANDLE_FIELDS", "shouldHideCursorForEmailTextInput", "", "IME_ACTION_ID", "checkPasswordType", "", "view", "Lcom/facebook/react/views/textinput/ReactEditText;", "updateStagedInputTypeFlag", "flagsToUnset", "flagsToSet", "getEventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "editText", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return ReactTextInputManager.TAG;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHideCursorForEmailTextInput() {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            String lowerCase = MANUFACTURER.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return Build.VERSION.SDK_INT == 29 && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "xiaomi", false, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkPasswordType(ReactEditText view) {
            if ((view.getStagedInputType() & ReactTextInputManager.INPUT_TYPE_KEYBOARD_NUMBERED) == 0 || (view.getStagedInputType() & 128) == 0) {
                return;
            }
            updateStagedInputTypeFlag(view, 128, 16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateStagedInputTypeFlag(ReactEditText view, int flagsToUnset, int flagsToSet) {
            view.setStagedInputType(((~flagsToUnset) & view.getStagedInputType()) | flagsToSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final EventDispatcher getEventDispatcher(ReactContext reactContext, ReactEditText editText) {
            return UIManagerHelper.getEventDispatcherForReactTag(reactContext, editText.getId());
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ReactTextInputManager", "getSimpleName(...)");
        TAG = "ReactTextInputManager";
        REACT_PROPS_AUTOFILL_HINTS_MAP = MapsKt.mapOf(TuplesKt.to("birthdate-day", HintConstants.AUTOFILL_HINT_BIRTH_DATE_DAY), TuplesKt.to("birthdate-full", HintConstants.AUTOFILL_HINT_BIRTH_DATE_FULL), TuplesKt.to("birthdate-month", HintConstants.AUTOFILL_HINT_BIRTH_DATE_MONTH), TuplesKt.to("birthdate-year", HintConstants.AUTOFILL_HINT_BIRTH_DATE_YEAR), TuplesKt.to("cc-csc", HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE), TuplesKt.to("cc-exp", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE), TuplesKt.to("cc-exp-day", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY), TuplesKt.to("cc-exp-month", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH), TuplesKt.to("cc-exp-year", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR), TuplesKt.to("cc-number", HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER), TuplesKt.to("email", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS), TuplesKt.to(HintConstants.AUTOFILL_HINT_GENDER, HintConstants.AUTOFILL_HINT_GENDER), TuplesKt.to("name", HintConstants.AUTOFILL_HINT_PERSON_NAME), TuplesKt.to("name-family", HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY), TuplesKt.to("name-given", HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN), TuplesKt.to("name-middle", HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE), TuplesKt.to("name-middle-initial", HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE_INITIAL), TuplesKt.to("name-prefix", HintConstants.AUTOFILL_HINT_PERSON_NAME_PREFIX), TuplesKt.to("name-suffix", HintConstants.AUTOFILL_HINT_PERSON_NAME_SUFFIX), TuplesKt.to(HintConstants.AUTOFILL_HINT_PASSWORD, HintConstants.AUTOFILL_HINT_PASSWORD), TuplesKt.to("password-new", HintConstants.AUTOFILL_HINT_NEW_PASSWORD), TuplesKt.to("postal-address", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS), TuplesKt.to("postal-address-country", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY), TuplesKt.to("postal-address-extended", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS), TuplesKt.to("postal-address-extended-postal-code", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE), TuplesKt.to("postal-address-locality", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY), TuplesKt.to("postal-address-region", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION), TuplesKt.to("postal-code", HintConstants.AUTOFILL_HINT_POSTAL_CODE), TuplesKt.to("street-address", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS), TuplesKt.to("sms-otp", HintConstants.AUTOFILL_HINT_SMS_OTP), TuplesKt.to("tel", HintConstants.AUTOFILL_HINT_PHONE_NUMBER), TuplesKt.to("tel-country-code", HintConstants.AUTOFILL_HINT_PHONE_COUNTRY_CODE), TuplesKt.to("tel-national", HintConstants.AUTOFILL_HINT_PHONE_NATIONAL), TuplesKt.to("tel-device", HintConstants.AUTOFILL_HINT_PHONE_NUMBER_DEVICE), TuplesKt.to(HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_USERNAME), TuplesKt.to("username-new", HintConstants.AUTOFILL_HINT_NEW_USERNAME));
        EMPTY_FILTERS = new InputFilter[0];
        DRAWABLE_HANDLE_RESOURCES = new String[]{"mTextSelectHandleLeftRes", "mTextSelectHandleRightRes", "mTextSelectHandleRes"};
        DRAWABLE_HANDLE_FIELDS = new String[]{"mSelectHandleLeft", "mSelectHandleRight", "mSelectHandleCenter"};
    }
}
