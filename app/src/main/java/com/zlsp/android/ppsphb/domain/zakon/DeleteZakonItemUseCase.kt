package com.zlsp.android.ppsphb.domain.zakon

class DeleteZakonItemUseCase(private val zlr: ZakonListRepository) {

    operator fun invoke(zakonItem: ZakonItem) {
        zlr.deleteZakonItem(zakonItem)
    }

}