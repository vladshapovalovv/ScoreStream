package com.example.scorestream

import android.app.Application
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import dagger.hilt.android.HiltAndroidApp

const val ONESIGNAL_APP_ID = "d1fa293b-a79d-4eaa-8cdd-f1b977930940"

@HiltAndroidApp
class ScoreStreamApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        OneSignal.Debug.logLevel = LogLevel.VERBOSE

        OneSignal.initWithContext(this, ONESIGNAL_APP_ID)

        OneSignal.User.pushSubscription.optIn()
    }
}