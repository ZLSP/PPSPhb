package com.zlsp.android.ppsphb.domain.yandex

import android.content.Context

class YandexAdsShowInterstitialUseCase(private val repository: YandexAdsRepository) {
    operator fun invoke() {
        repository.showInterstitial()
    }
}