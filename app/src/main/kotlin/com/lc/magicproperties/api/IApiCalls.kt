package com.lc.magicproperties.api

import com.lc.magicproperties.ui.main.MainPresenter

interface IApiCalls {

    fun getProperties(presenter: MainPresenter)

    fun getStats(action: String, duration: Int)
}