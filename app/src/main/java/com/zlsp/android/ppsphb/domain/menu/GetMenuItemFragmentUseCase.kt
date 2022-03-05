package com.zlsp.android.ppsphb.domain.menu

import androidx.fragment.app.Fragment

class GetMenuItemFragmentUseCase(private val mlr: MenuListRepository) {

    operator fun invoke(menuItemId: Int): Fragment {
        return mlr.getMenuItemFragment(menuItemId)
    }

}