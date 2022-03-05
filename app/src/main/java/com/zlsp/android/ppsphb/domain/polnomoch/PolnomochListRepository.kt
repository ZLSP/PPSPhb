package com.zlsp.android.ppsphb.domain.polnomoch

import androidx.lifecycle.LiveData

interface PolnomochListRepository {

    fun getPolnomochList() : LiveData<List<PolnomochItem>>
    fun getPolnomochItem(polnomochItemId: Int) : PolnomochItem
    fun setPolnomochList(list: MutableList<PolnomochItem>)
    fun editPolnomochItem(polnomochItem: PolnomochItem)
    fun deletePolnomochItem(polnomochItem: PolnomochItem)
    fun addPolnomochItem(polnomochItem: PolnomochItem)
    
}