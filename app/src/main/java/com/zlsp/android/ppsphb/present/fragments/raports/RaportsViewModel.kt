package com.zlsp.android.ppsphb.present.fragments.raports

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import com.zlsp.android.ppsphb.data.impls.RaportsListRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.ads.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.fb.FBAnalyticsLogUseCase
import com.zlsp.android.ppsphb.domain.raports.*
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsShowRewardedUseCase

class RaportsViewModel: ViewModel() {

    private val repository = RaportsListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryFB = FBAnalyticsRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl

    private val getRaportsListUseCase = GetRaportsListUseCase(repository)
    private val setRaportsListUseCase = SetRaportsListUseCase(repository)

    private val yandexAdsShowRewardedUseCase = YandexAdsShowRewardedUseCase(repositoryYandex)
    private val fbAnalyticsLogUseCase = FBAnalyticsLogUseCase(repositoryFB)

    val raportsList = getRaportsListUseCase()

    fun setRaportsList(list: MutableList<RaportsItem>) {
        setRaportsListUseCase(list)
    }

    fun logFB() {
        fbAnalyticsLogUseCase(FB_LOG)
    }

    fun showReward(ctx: Context, openLink: ()-> Unit) {
        yandexAdsShowRewardedUseCase(ctx, openLink)
    }

    companion object {
        const val FB_LOG = FirebaseAnalytics.Event.ADD_TO_CART
    }
}