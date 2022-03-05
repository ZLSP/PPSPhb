package com.zlsp.android.ppsphb.domain.osnovania

class EditOsnovItemUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(osnovItem: OsnovItem) {
        olr.editOsnovItem(osnovItem)
    }

}