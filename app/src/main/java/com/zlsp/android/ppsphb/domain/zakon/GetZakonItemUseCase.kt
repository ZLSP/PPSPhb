package com.zlsp.android.ppsphb.domain.zakon

class GetZakonItemUseCase(private val zlr: ZakonListRepository) {

    operator fun invoke(zakonItemId: Int): ZakonItem {
        return zlr.getZakonItem(zakonItemId)
    }

}