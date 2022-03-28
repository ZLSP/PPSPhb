package com.zlsp.android.ppsphb.data.impls.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.android.ppsphb.domain.polnomoch.PolnomochItem
import com.zlsp.android.ppsphb.domain.polnomoch.PolnomochListRepository
import java.lang.RuntimeException

object PolnomochListRepositoryImpl: PolnomochListRepository {

    private val polnomochListLD = MutableLiveData<List<PolnomochItem>>()
    private val polnomochList = sortedSetOf<PolnomochItem>({ p0, p1 -> p0.id.compareTo(p1.id)})

    override fun getPolnomochList(): LiveData<List<PolnomochItem>> {
        return polnomochListLD
    }

    override fun getPolnomochItem(polnomochItemId: Int): PolnomochItem {
        return polnomochList.find {
            it.id == polnomochItemId
        } ?: throw RuntimeException("Element with id $polnomochItemId not found")
    }

    override fun setPolnomochList(list: MutableList<PolnomochItem>) {
        for (polnomochItem in list) {
            addPolnomochItem(polnomochItem)
        }
        updateList()
    }

    override fun editPolnomochItem(polnomochItem: PolnomochItem) {
//        for (item in PolnomochList) {
//            if (item != PolnomochItem)
//                item.open = false
//        }
        val oldElement = getPolnomochItem(polnomochItem.id)
        deletePolnomochItem(oldElement)
        addPolnomochItem(polnomochItem)
        updateList()
    }

    override fun deletePolnomochItem(polnomochItem: PolnomochItem) {
        polnomochList.remove(polnomochItem)
        updateList()
    }

    override fun addPolnomochItem(polnomochItem: PolnomochItem) {
        polnomochList.add(polnomochItem)
        updateList()
    }

    private fun updateList() {
        polnomochListLD.value = polnomochList.toList()
    }
}