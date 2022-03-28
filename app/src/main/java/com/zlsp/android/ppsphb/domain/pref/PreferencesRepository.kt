package com.zlsp.android.ppsphb.domain.pref

import android.app.Activity

interface PreferencesRepository {

    fun initPref(activity: Activity)
    fun clickCounter() : Boolean
}