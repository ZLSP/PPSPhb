package com.zlsp.android.ppsphb.domain.zakon

import androidx.lifecycle.LiveData

class GetZakonListUseCase(private val zlr: ZakonListRepository) {

    operator fun invoke(): LiveData<List<ZakonItem>> {
        return zlr.getZakonList()
    }

}