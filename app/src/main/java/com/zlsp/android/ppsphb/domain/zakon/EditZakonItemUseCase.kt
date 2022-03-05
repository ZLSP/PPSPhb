package com.zlsp.android.ppsphb.domain.zakon

class EditZakonItemUseCase(private val zlr: ZakonListRepository) {

    operator fun invoke(zakonItem: ZakonItem) {
        zlr.editZakonItem(zakonItem)
    }

}