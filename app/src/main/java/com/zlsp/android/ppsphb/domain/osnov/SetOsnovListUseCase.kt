package com.zlsp.android.ppsphb.domain.osnov

class SetOsnovListUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(list: MutableList<OsnovItem>) {
        olr.setOsnovList(list)
    }

}