package com.zlsp.android.ppsphb.data.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.android.ppsphb.domain.zakon.ZakonItem
import com.zlsp.android.ppsphb.domain.zakon.ZakonListRepository
import java.lang.RuntimeException

object ZakonListRepositoryImpl: ZakonListRepository {

    private val zakonListLD = MutableLiveData<List<ZakonItem>>()
    private val zakonList = sortedSetOf<ZakonItem>({p0,p1 -> p0.id.compareTo(p1.id)})

    override fun getZakonList(): LiveData<List<ZakonItem>> {
        return zakonListLD
    }

    override fun getZakonItem(zakonItemId: Int): ZakonItem {
        return zakonList.find {
            it.id == zakonItemId
        } ?: throw RuntimeException("Element with id $zakonItemId not found")
    }

    override fun setZakonList(list: MutableList<ZakonItem>) {
        for (zakonItem in list) {
            addZakonItem(zakonItem)
        }
        updateList()
    }

    override fun editZakonItem(zakonItem: ZakonItem) {
        for (item in zakonList) {
            if (item != zakonItem)
                item.active = false
        }
        val oldElement = getZakonItem(zakonItem.id)
        deleteZakonItem(oldElement)
        addZakonItem(zakonItem)
        updateList()
    }

    override fun deleteZakonItem(zakonItem: ZakonItem) {
        zakonList.remove(zakonItem)
        updateList()
    }

    override fun addZakonItem(zakonItem: ZakonItem) {
        zakonList.add(zakonItem)
        updateList()
    }

    private fun updateList() {
        zakonListLD.value = zakonList.toList()
    }
}