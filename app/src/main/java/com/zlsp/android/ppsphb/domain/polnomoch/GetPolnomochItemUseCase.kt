package com.zlsp.android.ppsphb.domain.polnomoch

class GetPolnomochItemUseCase(private val olr: PolnomochListRepository) {

    operator fun invoke(polnomochItemId: Int): PolnomochItem {
        return olr.getPolnomochItem(polnomochItemId)
    }

}