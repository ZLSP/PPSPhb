package com.zlsp.android.ppsphb.present.fragments.raports

import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.lists.RaportsListRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.FBAnalyticsRepositoryImpl
import com.zlsp.android.ppsphb.data.impls.singleton.PreferencesRepositoryImpl
import com.zlsp.android.ppsphb.domain.raports.*

class RaportsViewModel: ViewModel() {

    private val repository = RaportsListRepositoryImpl
    private val repositoryPref = PreferencesRepositoryImpl
    private val repositoryFB = FBAnalyticsRepositoryImpl

    private val getRaportsListUseCase = GetRaportsListUseCase(repository)
    private val setRaportsListUseCase = SetRaportsListUseCase(repository)

    val raportsList = getRaportsListUseCase()

    fun setRaportsList(list: MutableList<RaportsItem>) {
        setRaportsListUseCase(list)
    }
    fun clickCounter(): Boolean {
        return repositoryPref.clickCounter()
    }

}