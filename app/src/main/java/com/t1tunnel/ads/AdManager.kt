package com.t1tunnel.ads
import android.app.Activity
import android.view.ViewGroup
import com.google.android.gms.ads.*

object AdManager {
    fun loadBanner(activity: Activity, container: ViewGroup) {
        val adView = AdView(activity)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"
        adView.adSize = AdSize.BANNER
        container.addView(adView)
        adView.loadAd(AdRequest.Builder().build())
    }
}
