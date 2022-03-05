package com.zlsp.android.ppsphb.domain.zakon

class SetZakonListUseCase(private val zlr: ZakonListRepository) {

    operator fun invoke(list: MutableList<ZakonItem>) {
        zlr.setZakonList(list)
    }

}