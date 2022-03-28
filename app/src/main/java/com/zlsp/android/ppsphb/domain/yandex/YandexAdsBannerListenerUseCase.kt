package com.zlsp.android.ppsphb.domain.yandex

import android.content.Context
import com.yandex.mobile.ads.banner.BannerAdView

class YandexAdsBannerListenerUseCase(private val repository: YandexAdsRepository) {
    operator fun invoke(banner: BannerAdView) {
        repository.bannerListener(banner)
    }
}