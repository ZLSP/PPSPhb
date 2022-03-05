package com.zlsp.android.ppsphb.domain.raports

import androidx.lifecycle.LiveData

interface RaportsListRepository {

    fun getRaportsList() : LiveData<List<RaportsItem>>
    fun getRaportsItem(raportsItemId: Int) : RaportsItem
    fun setRaportsList(list: MutableList<RaportsItem>)
    fun editRaportsItem(raportsItem: RaportsItem)
    fun deleteRaportsItem(raportsItem: RaportsItem)
    fun addRaportsItem(raportsItem: RaportsItem)
    
}