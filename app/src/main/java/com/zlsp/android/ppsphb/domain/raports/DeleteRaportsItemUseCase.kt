package com.zlsp.android.ppsphb.domain.raports

class DeleteRaportsItemUseCase(private val rlr: RaportsListRepository) {

    operator fun invoke(raportsItem: RaportsItem) {
        rlr.deleteRaportsItem(raportsItem)
    }

}