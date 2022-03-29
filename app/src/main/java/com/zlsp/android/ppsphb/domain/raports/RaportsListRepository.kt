package com.zlsp.android.ppsphb.domain.raports

import android.content.Context
import androidx.lifecycle.LiveData

interface RaportsListRepository {

    fun getRaportsList() : LiveData<List<RaportsItem>>
    fun getRaportsItem(raportsItemId: Int) : RaportsItem
    fun setRaportsList(list: MutableList<RaportsItem>)
    fun addRaportsItem(raportsItem: RaportsItem)
    fun openLink(ctx: Context, link: String)
    
}