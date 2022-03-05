package com.zlsp.android.ppsphb.domain.osnovania

import androidx.lifecycle.LiveData

class GetOsnovListUseCase(private val olr: OsnovListRepository) {

    operator fun invoke(): LiveData<List<OsnovItem>> {
        return olr.getOsnovList()
    }

}