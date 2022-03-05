package com.zlsp.android.ppsphb.domain.raports

class GetRaportsItemUseCase(private val rlr: RaportsListRepository) {

    operator fun invoke(raportsItemId: Int): RaportsItem {
        return rlr.getRaportsItem(raportsItemId)
    }

}