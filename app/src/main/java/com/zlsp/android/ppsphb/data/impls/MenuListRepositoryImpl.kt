package com.zlsp.android.ppsphb.data.impls

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zlsp.android.ppsphb.domain.menu.MenuItem
import com.zlsp.android.ppsphb.domain.menu.MenuListRepository
import java.lang.RuntimeException

object MenuListRepositoryImpl: MenuListRepository {

    private val menuListLD = MutableLiveData<List<MenuItem>>()

    private val menuList = mutableListOf<MenuItem>()

    override fun setMenuList(list: MutableList<MenuItem>) {
        for (menuItem in list) {
            addMenuItem(menuItem)
        }
        updateList()
    }

    override fun getMenuList(): LiveData<List<MenuItem>> {
        return menuListLD
    }

    override fun getMenuItemFragment(menuItemId: Int): Fragment {
        val menuItem = menuList.find {
            it.id == menuItemId
        } ?: throw RuntimeException("Element with id $menuItemId not found")
        return menuItem.fragment
    }

    override fun addMenuItem(menuItem: MenuItem) {
        menuList.add(menuItem)
    }

    private fun updateList() {
        menuListLD.value = menuList
    }

}