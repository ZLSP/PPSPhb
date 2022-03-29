package com.zlsp.android.ppsphb.data.impls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.android.ppsphb.domain.redaction.RedactionItem
import com.zlsp.android.ppsphb.domain.redaction.RedactionListRepository
import java.lang.RuntimeException

object RedactionListRepositoryImpl: RedactionListRepository {

    private val redactionListLD = MutableLiveData<List<RedactionItem>>()
    private val redactionList = sortedSetOf<RedactionItem>({ p0, p1 -> p0.id.compareTo(p1.id)})

    override fun getRedactionList(): LiveData<List<RedactionItem>> {
        return redactionListLD
    }

    override fun getRedactionItem(redactionItemId: Int): RedactionItem {
        return redactionList.find {
            it.id == redactionItemId
        } ?: throw RuntimeException("Element with id $redactionItemId not found")
    }

    override fun setRedactionList(list: MutableList<RedactionItem>) {
        for (redactionItem in list) {
            addRedactionItem(redactionItem)
        }
        updateList()
    }

    override fun editRedactionItem(redactionItem: RedactionItem) {
//        for (item in RedactionList) {
//            if (item != RedactionItem)
//                item.open = false
//        }
        val oldElement = getRedactionItem(redactionItem.id)
        deleteRedactionItem(oldElement)
        addRedactionItem(redactionItem)
        updateList()
    }

    override fun deleteRedactionItem(redactionItem: RedactionItem) {
        redactionList.remove(redactionItem)
        updateList()
    }

    override fun addRedactionItem(redactionItem: RedactionItem) {
        redactionList.add(redactionItem)
        updateList()
    }

    private fun updateList() {
        redactionListLD.value = redactionList.toList()
    }
}