package com.zlsp.android.ppsphb.data.tools

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.zlsp.android.ppsphb.domain.pref.PreferencesRepository

object PreferencesRepositoryImpl: PreferencesRepository {
    private const val TAG_CLICK_COUNTER = "CLICK_COUNTER"
    private lateinit var sharedPreferences : SharedPreferences

    override fun initPref(activity: Activity) {
        sharedPreferences = activity.getSharedPreferences(
            "sharedPrefs",
            Context.MODE_PRIVATE
        )
    }

    override fun clickCounter(): Boolean {
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