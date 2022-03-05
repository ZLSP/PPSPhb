package com.zlsp.android.ppsphb.present.fragments.zakon

import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.ZakonListRepositoryImpl
import com.zlsp.android.ppsphb.domain.zakon.*

class ZakonViewModel: ViewModel() {

    private val repository = ZakonListRepositoryImpl

    private val getZakonListUseCase = GetZakonListUseCase(repository)
    private val getZakonItemUseCase = GetZakonItemUseCase(repository)
    private val addZakonItemUseCase = AddZakonItemUseCase(repository)
    private val editZakonItemUseCase = EditZakonItemUseCase(repository)
    private val setZakonListUseCase = SetZakonListUseCase(repository)

    val zakonList = getZakonListUseCase()

    fun setZakonList(list: MutableList<ZakonItem>) {
        setZakonListUseCase(list)
    }

    fun changeActiveState(zakonItem: ZakonItem) {
        val newItem = zakonItem.copy(active = true)
        editZakonItemUseCase(newItem)
    }

}