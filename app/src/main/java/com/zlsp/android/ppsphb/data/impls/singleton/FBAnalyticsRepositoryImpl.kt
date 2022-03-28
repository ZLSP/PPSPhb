package com.zlsp.android.ppsphb.data.impls.singleton

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.zlsp.android.ppsphb.domain.fb.FBAnalyticsRepository


object FBAnalyticsRepositoryImpl: FBAnalyticsRepository {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun initFB() {
        firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN) {}
    }

    override fun fbLog(log: String) {
        firebaseAnalytics.logEvent(log) {}
    }

}