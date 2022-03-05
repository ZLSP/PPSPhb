package com.zlsp.android.ppsphb.domain.redaction

class AddRedactionItemUseCase(private val rlr: RedactionListRepository) {

    operator fun invoke(redactionItem: RedactionItem) {
        rlr.addRedactionItem(redactionItem)
    }

}