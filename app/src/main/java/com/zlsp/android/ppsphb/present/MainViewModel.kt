package com.zlsp.android.ppsphb.present

import androidx.lifecycle.ViewModel
import com.zlsp.android.ppsphb.data.impls.MenuListRepositoryImpl
import com.zlsp.android.ppsphb.domain.menu.*

class MainViewModel: ViewModel() {

    private val repository = MenuListRepositoryImpl

    private val setMenuListUseCase = SetMenuListUseCase(repository)
    private val getMenuListUseCase = GetMenuListUseCase(repository)
    private val getMenuItemFragmentUseCase = GetMenuItemFragmentUseCase(repository)

    val menuList = getMenuListUseCase()

    fun setMenuList(list: MutableList<MenuItem>) {
        setMenuListUseCase(list)
    }



}