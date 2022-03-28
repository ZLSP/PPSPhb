package com.zlsp.android.ppsphb.data.impls.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.android.ppsphb.domain.raports.RaportsItem
import com.zlsp.android.ppsphb.domain.raports.RaportsListRepository
import java.lang.RuntimeException

object RaportsListRepositoryImpl: RaportsListRepository {

    private val raportsListLD = MutableLiveData<List<RaportsItem>>()
    private val raportsList = sortedSetOf<RaportsItem>({ p0, p1 -> p0.id.compareTo(p1.id)})

    override fun getRaportsList(): LiveData<List<RaportsItem>> {
        return raportsListLD
    }

    override fun getRaportsItem(raportsItemId: Int): RaportsItem {
        return raportsList.find {
            it.id == raportsItemId
        } ?: throw RuntimeException("Element with id $raportsItemId not found")
    }

    override fun setRaportsList(list: MutableList<RaportsItem>) {
        for (raportsItem in list) {
            addRaportsItem(raportsItem)
        }
        updateList()
    }

    override fun addRaportsItem(raportsItem: RaportsItem) {
        raportsList.add(raportsItem)
        updateList()
    }

    private fun updateList() {
        raportsListLD.value = raportsList.toList()
    }
}