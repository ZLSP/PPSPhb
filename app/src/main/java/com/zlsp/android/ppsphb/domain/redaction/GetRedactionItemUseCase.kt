package com.zlsp.android.ppsphb.domain.redaction

class GetRedactionItemUseCase(private val rlr: RedactionListRepository) {

    operator fun invoke(redactionItemId: Int): RedactionItem {
        return rlr.getRedactionItem(redactionItemId)
    }

}