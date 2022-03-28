package com.zlsp.android.ppsphb.domain.yandex

import android.content.Context
import com.yandex.mobile.ads.banner.BannerAdView

class YandexAdsInterstitialListenerUseCase(private val repository: YandexAdsRepository) {
    operator fun invoke(ctx: Context) {
        repository.initInterstitial(ctx)
    }
}