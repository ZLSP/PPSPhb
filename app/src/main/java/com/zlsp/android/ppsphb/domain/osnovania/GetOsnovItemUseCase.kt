package com.zlsp.android.ppsphb.domain.osnovania

class GetOsnovItemUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(osnovItemId: Int): OsnovItem {
        return olr.getOsnovItem(osnovItemId)
    }

}