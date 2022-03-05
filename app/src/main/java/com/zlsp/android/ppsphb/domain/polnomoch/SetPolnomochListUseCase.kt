package com.zlsp.android.ppsphb.domain.polnomoch

class SetPolnomochListUseCase(private val olr: PolnomochListRepository) {

    operator fun invoke(list: MutableList<PolnomochItem>) {
        olr.setPolnomochList(list)
    }

}