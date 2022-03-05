package com.zlsp.android.ppsphb.domain.redaction

class SetRedactionListUseCase(private val olr: RedactionListRepository) {

    operator fun invoke(list: MutableList<RedactionItem>) {
        olr.setRedactionList(list)
    }

}