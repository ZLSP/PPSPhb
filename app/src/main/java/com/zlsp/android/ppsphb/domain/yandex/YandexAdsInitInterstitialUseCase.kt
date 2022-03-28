package com.zlsp.android.ppsphb.domain.yandex

import android.content.Context
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.interstitial.InterstitialAd

class YandexAdsInitInterstitialUseCase(private val repository: YandexAdsRepository) {
    operator fun invoke(interstitialAd: InterstitialAd) {
        repository.interstitialListener(interstitialAd)
    }
}