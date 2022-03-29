package com.zlsp.android.ppsphb.present.fragments.zakon

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.ZakonListRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.ads.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.pref.PreferencesClickCounterUseCase
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsShowInterstitialUseCase
import com.zlsp.android.ppsphb.domain.zakon.*

class ZakonViewModel: ViewModel() {

    private val repository = ZakonListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl
    private val repositoryFB = FBAnalyticsRepositoryImpl

    private val getZakonListUseCase = GetZakonListUseCase(repository)
    private val getZakonItemUseCase = GetZakonItemUseCase(repository)
    private val addZakonItemUseCase = AddZakonItemUseCase(repository)
    private val editZakonItemUseCase = EditZakonItemUseCase(repository)
    private val setZakonListUseCase = SetZakonListUseCase(repository)

    private val yandexAdsShowInterstitialUseCase = YandexAdsShowInterstitialUseCase(repositoryYandex)
    private val preferencesClickCounterUseCase = PreferencesClickCounterUseCase(repositoryPref)

    val zakonList = getZakonListUseCase()

    fun setZakonList(list: MutableList<ZakonItem>) {
        setZakonListUseCase(list)
    }

    fun changeActiveState(zakonItem: ZakonItem) {
        val newItem = zakonItem.copy(active = true)
        editZakonItemUseCase(newItem)
    }
    fun clickCounter(): Boolean {
        return preferencesClickCounterUseCase()
    }

    fun showInterstitial(ctx: Context) {
        yandexAdsShowInterstitialUseCase(ctx)
    }


}