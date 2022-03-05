package com.zlsp.android.ppsphb.domain.osnov

class EditOsnovItemUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(osnovItem: OsnovItem) {
        olr.editOsnovItem(osnovItem)
    }

}