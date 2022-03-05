package com.zlsp.android.ppsphb.domain.menu

class AddMenuItemUseCase(private val mlr: MenuListRepository) {

    operator fun invoke(menuItem: MenuItem) {
        mlr.addMenuItem(menuItem)
    }

}