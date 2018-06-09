package com.lc.magicproperties.application

import android.app.Application
import com.lc.magicproperties.api.ApiModule

lateinit var applicationComponent : ApplicationComponent

class MagicPropertiesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        applicationComponent = createApplicationComponent()
    }

    @Synchronized
    private fun createApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder().apiModule(ApiModule(this)).build()
    }
}