package com.facebook.react.views.text;

import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: ReactRawTextShadowNode.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/views/text/ReactRawTextShadowNode;", "Lcom/facebook/react/uimanager/ReactShadowNodeImpl;", "<init>", "()V", "value", "", ReactTextInputShadowNode.PROP_TEXT, "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "isVirtual", "", "toString", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactRawTextShadowNode extends ReactShadowNodeImpl {
    private String text;

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return true;
    }

    public final String getText() {
        return this.text;
    }

    @ReactProp(name = ReactTextInputShadowNode.PROP_TEXT)
    public final void setText(String str) {
        this.text = str;
        markUpdated();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl
    public String toString() {
        return getViewClass() + " [text: " + this.text + "]";
    }
}
