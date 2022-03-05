package com.zlsp.android.ppsphb.domain.redaction

import androidx.lifecycle.LiveData

class GetRedactionListUseCase(private val rlr: RedactionListRepository) {

    operator fun invoke(): LiveData<List<RedactionItem>> {
        return rlr.getRedactionList()
    }

}