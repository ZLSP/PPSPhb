package com.zlsp.android.ppsphb.present.fragments.osnov

import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.OsnovListRepositoryImpl
import com.zlsp.android.ppsphb.domain.osnov.*

class OsnovViewModel: ViewModel() {

    private val repository = OsnovListRepositoryImpl

    private val getOsnovListUseCase = GetOsnovListUseCase(repository)
    private val editOsnovItemUseCase = EditOsnovItemUseCase(repository)
    private val setOsnovListUseCase = SetOsnovListUseCase(repository)

    val osnovList = getOsnovListUseCase()

    fun setOsnovList(list: MutableList<OsnovItem>) {
        setOsnovListUseCase(list)
    }

    fun changeOpenState(osnovItem: OsnovItem) {
        val newItem = osnovItem.copy(open = !osnovItem.open)
        editOsnovItemUseCase(newItem)
    }

}