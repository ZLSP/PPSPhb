package com.zlsp.android.ppsphb.domain.redaction

class DeleteRedactionItemUseCase(private val rlr: RedactionListRepository) {

    operator fun invoke(redactionItem: RedactionItem) {
        rlr.deleteRedactionItem(redactionItem)
    }

}