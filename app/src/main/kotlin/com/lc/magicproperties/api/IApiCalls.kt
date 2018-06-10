package com.lc.magicproperties.api

import com.lc.magicproperties.ui.main.PropertiesContract

interface IApiCalls {

    fun getProperties(presenter: PropertiesContract.Presenter<*>)

    fun getStats(action: String, duration: Long)
}