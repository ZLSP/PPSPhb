package com.zlsp.android.ppsphb.domain.menu

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment

data class MenuItem (
    val id : Int,
    val icon : Int,
    val name : String,
    val fragment: Fragment = Fragment()
    )