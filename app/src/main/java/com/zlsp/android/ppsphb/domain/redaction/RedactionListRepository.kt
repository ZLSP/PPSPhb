package com.zlsp.android.ppsphb.domain.redaction

import androidx.lifecycle.LiveData

interface RedactionListRepository {

    fun getRedactionList() : LiveData<List<RedactionItem>>
    fun getRedactionItem(redactionItemId: Int) : RedactionItem
    fun setRedactionList(list: MutableList<RedactionItem>)
    fun editRedactionItem(redactionItem: RedactionItem)
    fun deleteRedactionItem(redactionItem: RedactionItem)
    fun addRedactionItem(redactionItem: RedactionItem)
    
}