package com.zlsp.android.ppsphb.domain.redaction

class EditRedactionItemUseCase(private val rlr: RedactionListRepository) {

    operator fun invoke(redactionItem: RedactionItem) {
        rlr.editRedactionItem(redactionItem)
    }

}