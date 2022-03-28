package com.zlsp.android.ppsphb.domain.pref

class PreferencesClickCounterUseCase(private val repository: PreferencesRepository) {
    operator fun invoke(): Boolean {
        return repository.clickCounter()
    }
}