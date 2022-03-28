package com.zlsp.android.ppsphb.domain.pref

import android.app.Activity

class PreferencesInitUseCase(private val repository: PreferencesRepository) {
    operator fun invoke(activity: Activity) {
        repository.initPref(activity)
    }
}