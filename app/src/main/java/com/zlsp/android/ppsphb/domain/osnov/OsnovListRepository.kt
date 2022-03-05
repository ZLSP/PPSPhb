package com.zlsp.android.ppsphb.domain.osnov

import androidx.lifecycle.LiveData

interface OsnovListRepository {

    fun getOsnovList() : LiveData<List<OsnovItem>>
    fun getOsnovItem(osnovItemId: Int) : OsnovItem
    fun setOsnovList(list: MutableList<OsnovItem>)
    fun editOsnovItem(osnovItem: OsnovItem)
    fun deleteOsnovItem(osnovItem: OsnovItem)
    fun addOsnovItem(osnovItem: OsnovItem)
    
}