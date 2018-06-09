package com.lc.magicproperties.application

import com.lc.magicproperties.api.ApiCalls
import com.lc.magicproperties.api.ApiModule
import com.lc.magicproperties.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApiModule::class])
interface ApplicationComponent {

    fun inject(application: MagicPropertiesApplication): MagicPropertiesApplication

    fun inject(activity: MainActivity): MainActivity

    fun inject(apiCalls: ApiCalls)
}