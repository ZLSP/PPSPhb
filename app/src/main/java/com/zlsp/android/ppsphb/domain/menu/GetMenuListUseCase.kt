package com.zlsp.android.ppsphb.domain.menu

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

class GetMenuListUseCase(private val mlr: MenuListRepository) {

    operator fun invoke(): LiveData<List<MenuItem>> {
        return mlr.getMenuList()
    }

}