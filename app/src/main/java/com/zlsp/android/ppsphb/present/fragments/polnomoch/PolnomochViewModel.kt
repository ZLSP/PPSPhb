package com.zlsp.android.ppsphb.present.fragments.polnomoch

import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.lists.PolnomochListRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.polnomoch.*

class PolnomochViewModel: ViewModel() {

    private val repository = PolnomochListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl

    private val getPolnomochListUseCase = GetPolnomochListUseCase(repository)
    private val editPolnomochItemUseCase = EditPolnomochItemUseCase(repository)
    private val setPolnomochListUseCase = SetPolnomochListUseCase(repository)

    val polnomochList = getPolnomochListUseCase()

    fun setPolnomochList(list: MutableList<PolnomochItem>) {
        setPolnomochListUseCase(list)
    }

    fun changeOpenState(polnomochItem: PolnomochItem) {
        val newItem = polnomochItem.copy(open = !polnomochItem.open)
        editPolnomochItemUseCase(newItem)
    }
    fun clickCounter(): Boolean {
        return repositoryPref.clickCounter()
    }

    fun showInterstitial() {
        repositoryYandex.showInterstitial()
    }

}