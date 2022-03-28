package com.zlsp.android.ppsphb.domain.fb

interface FBAnalyticsRepository {

    fun initFB()
    fun fbLog(log: String)

}