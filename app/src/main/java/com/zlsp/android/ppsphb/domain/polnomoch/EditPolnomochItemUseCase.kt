package com.zlsp.android.ppsphb.domain.polnomoch

class EditPolnomochItemUseCase(private val olr: PolnomochListRepository) {

    operator fun invoke(polnomochItem: PolnomochItem) {
        olr.editPolnomochItem(polnomochItem)
    }

}