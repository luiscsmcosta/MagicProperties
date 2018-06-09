package com.lc.magicproperties.api

import com.lc.magicproperties.application.MagicPropertiesApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule(private val application: MagicPropertiesApplication) {

    @Provides
    @Singleton
    fun provideApiCalls(): IApiCalls {
        return ApiCalls()
    }
}