package com.zlsp.android.ppsphb.domain.zakon

import androidx.lifecycle.LiveData

interface ZakonListRepository {

    fun getZakonList() : LiveData<List<ZakonItem>>
    fun getZakonItem(zakonItemId: Int) : ZakonItem
    fun setZakonList(list: MutableList<ZakonItem>)
    fun editZakonItem(zakonItem: ZakonItem)
    fun deleteZakonItem(zakonItem: ZakonItem)
    fun addZakonItem(zakonItem: ZakonItem)

}