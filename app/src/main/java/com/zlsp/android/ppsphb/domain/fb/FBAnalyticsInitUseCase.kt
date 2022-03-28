package com.zlsp.android.ppsphb.domain.fb

class FBAnalyticsInitUseCase(private val repository: FBAnalyticsRepository) {
    operator fun invoke() {
        repository.initFB()
    }
}