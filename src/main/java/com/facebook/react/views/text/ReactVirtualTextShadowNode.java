package com.facebook.react.views.text;

import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import kotlin.Metadata;

/* JADX INFO: compiled from: ReactVirtualTextShadowNode.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/views/text/ReactVirtualTextShadowNode;", "Lcom/facebook/react/views/text/ReactBaseTextShadowNode;", "<init>", "()V", "isVirtual", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactVirtualTextShadowNode extends ReactBaseTextShadowNode {
    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return true;
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("ReactVirtualTextShadowNode", LegacyArchitectureLogLevel.ERROR);
    }
}
