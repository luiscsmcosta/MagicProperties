package com.lc.magicproperties.api

interface IApiCalls {

    fun getProperties(apiListener: IApiListener)

    fun getStats(action: String, duration: Long)
}