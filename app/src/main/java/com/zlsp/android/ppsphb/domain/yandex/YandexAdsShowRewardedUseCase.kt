package com.zlsp.android.ppsphb.domain.yandex

import android.content.Context

class YandexAdsShowRewardedUseCase(private val repository: YandexAdsRepository)  {
    operator fun invoke(ctx: Context, openLink: () -> Unit) {
        repository.showRewarded(ctx, openLink)
    }
}