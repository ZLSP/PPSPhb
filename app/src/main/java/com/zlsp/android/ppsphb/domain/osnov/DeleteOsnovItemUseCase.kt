package com.zlsp.android.ppsphb.domain.osnov

class DeleteOsnovItemUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(osnovItem: OsnovItem) {
        olr.deleteOsnovItem(osnovItem)
    }

}