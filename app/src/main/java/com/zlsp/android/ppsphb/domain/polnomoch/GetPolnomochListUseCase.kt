package com.zlsp.android.ppsphb.domain.polnomoch

import androidx.lifecycle.LiveData

class GetPolnomochListUseCase(private val olr: PolnomochListRepository) {

    operator fun invoke(): LiveData<List<PolnomochItem>> {
        return olr.getPolnomochList()
    }

}