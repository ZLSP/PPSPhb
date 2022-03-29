package com.zlsp.android.ppsphb.present.fragments.redaction

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.RedactionListRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.tools.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.data.ads.YandexAdsRepositoryImpl
import com.zlsp.android.ppsphb.domain.pref.PreferencesClickCounterUseCase
import com.zlsp.android.ppsphb.domain.redaction.*
import com.zlsp.android.ppsphb.domain.yandex.YandexAdsShowInterstitialUseCase

class RedactionViewModel: ViewModel() {

    private val repository = RedactionListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryYandex = YandexAdsRepositoryImpl
    private val repositoryFB = FBAnalyticsRepositoryImpl

    private val getRedactionListUseCase = GetRedactionListUseCase(repository)
    private val editRedactionItemUseCase = EditRedactionItemUseCase(repository)
    private val setRedactionListUseCase = SetRedactionListUseCase(repository)

    private val yandexAdsShowInterstitialUseCase = YandexAdsShowInterstitialUseCase(repositoryYandex)
    private val preferencesClickCounterUseCase = PreferencesClickCounterUseCase(repositoryPref)

    val redactionList = getRedactionListUseCase()

    fun setRedactionList(list: MutableList<RedactionItem>) {
        setRedactionListUseCase(list)
    }

    fun changeOpenState(RedactionItem: RedactionItem) {
        val newItem = RedactionItem.copy(open = !RedactionItem.open)
        editRedactionItemUseCase(newItem)
    }
    fun clickCounter(): Boolean {
        return preferencesClickCounterUseCase()
    }

    fun showInterstitial(ctx: Context) {
        yandexAdsShowInterstitialUseCase(ctx)
    }

}