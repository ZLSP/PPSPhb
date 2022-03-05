package com.zlsp.android.ppsphb.domain.osnovania

class AddOsnovItemUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(osnovItem: OsnovItem) {
        olr.addOsnovItem(osnovItem)
    }

}