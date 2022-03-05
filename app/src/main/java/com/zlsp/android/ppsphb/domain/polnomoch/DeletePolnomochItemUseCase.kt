package com.zlsp.android.ppsphb.domain.polnomoch

class DeletePolnomochItemUseCase(private val olr: PolnomochListRepository) {

    operator fun invoke(polnomochItem: PolnomochItem) {
        olr.deletePolnomochItem(polnomochItem)
    }

}