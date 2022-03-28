package com.zlsp.android.ppsphb.present.fragments.osnov

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.lists.OsnovListRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.osnov.*
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsShowInterstitialUseCase

class OsnovViewModel: ViewModel() {

    private val repository = OsnovListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryFB = FBAnalyticsRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl

    private val getOsnovListUseCase = GetOsnovListUseCase(repository)
    private val editOsnovItemUseCase = EditOsnovItemUseCase(repository)
    private val setOsnovListUseCase = SetOsnovListUseCase(repository)

    private val yandexAdsShowInterstitialUseCase = YandexAdsShowInterstitialUseCase(repositoryYandex)

    val osnovList = getOsnovListUseCase()

    fun setOsnovList(list: MutableList<OsnovItem>) {
        setOsnovListUseCase(list)
    }

    fun changeOpenState(osnovItem: OsnovItem) {
        val newItem = osnovItem.copy(open = !osnovItem.open)
        editOsnovItemUseCase(newItem)
    }

    fun clickCounter(): Boolean {
        return repositoryPref.clickCounter()
    }

    fun showInterstitial() {
        yandexAdsShowInterstitialUseCase()
    }

}