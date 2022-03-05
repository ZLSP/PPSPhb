package com.zlsp.android.ppsphb.domain.osnovania

class DeleteOsnovItemUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(osnovItem: OsnovItem) {
        olr.deleteOsnovItem(osnovItem)
    }

}