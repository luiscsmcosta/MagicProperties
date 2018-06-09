package com.lc.magicproperties.application

import android.app.Application

lateinit var applicationComponent : ApplicationComponent

object MagicPropertiesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        applicationComponent = createApplicationComponent()
    }

    @Synchronized
    private fun createApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.create()
    }
}