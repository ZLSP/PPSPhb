package com.zlsp.android.ppsphb.present.fragments.redaction

import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.RedactionListRepositoryImpl
import com.zlsp.android.ppsphb.domain.redaction.*

class RedactionViewModel: ViewModel() {

    private val repository = RedactionListRepositoryImpl

    private val getRedactionListUseCase = GetRedactionListUseCase(repository)
    private val editRedactionItemUseCase = EditRedactionItemUseCase(repository)
    private val setRedactionListUseCase = SetRedactionListUseCase(repository)

    val redactionList = getRedactionListUseCase()

    fun setRedactionList(list: MutableList<RedactionItem>) {
        setRedactionListUseCase(list)
    }

    fun changeOpenState(RedactionItem: RedactionItem) {
        val newItem = RedactionItem.copy(open = !RedactionItem.open)
        editRedactionItemUseCase(newItem)
    }

}