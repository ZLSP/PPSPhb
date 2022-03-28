package com.zlsp.android.ppsphb.domain.yandex

import android.content.Context

class YandexAdsInitUseCase(private val repository: YandexAdsRepository) {
    operator fun invoke(ctx: Context) {
        repository.initYandex(ctx)
    }
}