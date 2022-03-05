package com.zlsp.android.ppsphb.domain.raports

class SetRaportsListUseCase(private val olr: RaportsListRepository) {

    operator fun invoke(list: MutableList<RaportsItem>) {
        olr.setRaportsList(list)
    }

}