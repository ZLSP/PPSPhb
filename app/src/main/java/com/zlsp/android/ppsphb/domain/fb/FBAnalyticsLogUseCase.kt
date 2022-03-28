package com.zlsp.android.ppsphb.domain.fb

class FBAnalyticsLogUseCase(private val repository: FBAnalyticsRepository) {
    operator fun invoke(log: String) {
        repository.fbLog(log)
    }
}