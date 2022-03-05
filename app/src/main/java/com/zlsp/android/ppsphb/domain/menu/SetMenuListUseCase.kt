package com.zlsp.android.ppsphb.domain.menu

class SetMenuListUseCase(private val mlr: MenuListRepository) {

    operator fun invoke(list: MutableList<MenuItem>) {
        mlr.setMenuList(list)
    }

}