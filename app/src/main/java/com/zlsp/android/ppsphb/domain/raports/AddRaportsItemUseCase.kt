package com.zlsp.android.ppsphb.domain.raports

class AddRaportsItemUseCase(private val rlr: RaportsListRepository) {

    operator fun invoke(raportsItem: RaportsItem) {
        rlr.addRaportsItem(raportsItem)
    }

}