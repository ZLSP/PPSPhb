package com.zlsp.android.ppsphb.data.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.android.ppsphb.domain.osnovania.OsnovItem
import com.zlsp.android.ppsphb.domain.osnovania.OsnovListRepository
import com.zlsp.android.ppsphb.domain.zakon.ZakonItem
import com.zlsp.android.ppsphb.domain.zakon.ZakonListRepository
import java.lang.RuntimeException

object OsnovListRepositoryImpl: OsnovListRepository {

    private val osnovListLD = MutableLiveData<List<OsnovItem>>()
    private val osnovList = sortedSetOf<OsnovItem>({p0,p1 -> p0.id.compareTo(p1.id)})

    override fun getOsnovList(): LiveData<List<OsnovItem>> {
        return osnovListLD
    }

    override fun getOsnovItem(osnovItemId: Int): OsnovItem {
        return osnovList.find {
            it.id == osnovItemId
        } ?: throw RuntimeException("Element with id $osnovItemId not found")
    }

    override fun setOsnovList(list: MutableList<OsnovItem>) {
        for (osnovItem in list) {
            addOsnovItem(osnovItem)
        }
        updateList()
    }

    override fun editOsnovItem(osnovItem: OsnovItem) {
//        for (item in osnovList) {
//            if (item != osnovItem)
//                item.open = false
//        }
        val oldElement = getOsnovItem(osnovItem.id)
        deleteOsnovItem(oldElement)
        addOsnovItem(osnovItem)
        updateList()
    }

    override fun deleteOsnovItem(osnovItem: OsnovItem) {
        osnovList.remove(osnovItem)
        updateList()
    }

    override fun addOsnovItem(osnovItem: OsnovItem) {
        osnovList.add(osnovItem)
        updateList()
    }

    private fun updateList() {
        osnovListLD.value = osnovList.toList()
    }
}