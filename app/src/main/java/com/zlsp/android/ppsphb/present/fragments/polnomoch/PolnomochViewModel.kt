package com.zlsp.android.ppsphb.present.fragments.polnomoch

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.PolnomochListRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.ads.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.polnomoch.*
import com.zlsp.android.ppsphb.domain.pref.PreferencesClickCounterUseCase
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsShowInterstitialUseCase

class PolnomochViewModel: ViewModel() {

    private val repository = PolnomochListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl

    private val getPolnomochListUseCase = GetPolnomochListUseCase(repository)
    private val editPolnomochItemUseCase = EditPolnomochItemUseCase(repository)
    private val setPolnomochListUseCase = SetPolnomochListUseCase(repository)

    private val yandexAdsShowInterstitialUseCase = YandexAdsShowInterstitialUseCase(repositoryYandex)
    private val preferencesClickCounterUseCase = PreferencesClickCounterUseCase(repositoryPref)

    val polnomochList = getPolnomochListUseCase()

    fun setPolnomochList(list: MutableList<PolnomochItem>) {
        setPolnomochListUseCase(list)
    }

    fun changeOpenState(polnomochItem: PolnomochItem) {
        val newItem = polnomochItem.copy(open = !polnomochItem.open)
        editPolnomochItemUseCase(newItem)
    }
    fun clickCounter(): Boolean {
        return preferencesClickCounterUseCase()
    }

    fun showInterstitial(ctx: Context) {
        yandexAdsShowInterstitialUseCase(ctx)
    }

}