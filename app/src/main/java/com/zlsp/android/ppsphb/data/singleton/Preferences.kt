package com.zlsp.android.ppsphb.data.singleton

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

object Preferences {
    private const val TAG_CLICK_COUNTER = "CLICK_COUNTER"
    private lateinit var sharedPreferences : SharedPreferences

    fun initSharedPreferences(activity: Activity) {
        sharedPreferences = activity.getSharedPreferences(
            "sharedPrefs",
            Context.MODE_PRIVATE
        )
    }

    fun clickCounter(): Boolean {
        var show = false
        val count = sharedPreferences.getInt(TAG_CLICK_COUNTER, 0)
        if (count > 5) {
            show = true
            sharedPreferences.edit().putInt(TAG_CLICK_COUNTER, 0).apply()
        } else {
            sharedPreferences.edit().putInt(TAG_CLICK_COUNTER, count + 1).apply()
        }
        println(count)
        return show

    }
}