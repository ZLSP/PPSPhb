package com.zlsp.android.ppsphb.domain.polnomoch

class AddPolnomochItemUseCase(private val olr: PolnomochListRepository) {

    operator fun invoke(polnomochItem: PolnomochItem) {
        olr.addPolnomochItem(polnomochItem)
    }

}