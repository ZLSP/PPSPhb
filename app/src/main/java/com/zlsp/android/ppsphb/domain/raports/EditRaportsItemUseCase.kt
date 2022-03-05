package com.zlsp.android.ppsphb.domain.raports

class EditRaportsItemUseCase(private val olr: RaportsListRepository) {

    operator fun invoke(raportsItem: RaportsItem) {
        olr.editRaportsItem(raportsItem)
    }

}