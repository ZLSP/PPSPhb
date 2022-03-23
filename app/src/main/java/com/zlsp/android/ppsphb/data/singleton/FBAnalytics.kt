package com.zlsp.android.ppsphb.data.singleton

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

object FBAnalytics {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    fun initFirebase() {
        firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN) {}
    }

    fun firebaseLog(log: String) {
        firebaseAnalytics.logEvent(log) {}
    }
}