package com.zlsp.android.ppsphb.domain.osnov

import androidx.lifecycle.LiveData

class GetOsnovListUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(): LiveData<List<OsnovItem>> {
        return olr.getOsnovList()
    }

}