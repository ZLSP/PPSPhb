package com.zlsp.android.ppsphb.domain.zakon

class AddZakonItemUseCase(private val zlr: ZakonListRepository) {

    operator fun invoke(zakonItem: ZakonItem) {
        zlr.addZakonItem(zakonItem)
    }

}