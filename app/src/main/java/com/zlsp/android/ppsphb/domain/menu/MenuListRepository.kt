package com.zlsp.android.ppsphb.domain.menu

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

interface MenuListRepository {

    fun setMenuList(list: MutableList<MenuItem>)

    fun getMenuList() : LiveData<List<MenuItem>>

    fun getMenuItemFragment(menuItemId: Int) : Fragment

    fun addMenuItem(menuItem: MenuItem)

}