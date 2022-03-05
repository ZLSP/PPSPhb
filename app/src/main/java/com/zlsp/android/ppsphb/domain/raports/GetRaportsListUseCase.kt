package com.zlsp.android.ppsphb.domain.raports

import androidx.lifecycle.LiveData

class GetRaportsListUseCase(private val rlr: RaportsListRepository) {

    operator fun invoke(): LiveData<List<RaportsItem>> {
        return rlr.getRaportsList()
    }

}