package com.lc.magicproperties.ui.base

import android.os.Bundle
import com.lc.magicproperties.model.daos.PropertiesDAO

class BaseContract {
    interface Presenter<in V> {
        fun attachView(view : V)
        fun detachView()

        fun saveInstance(outState: Bundle?, propertiesDAO: PropertiesDAO)
        fun restoreInstance(savedInstanceState: Bundle?)
    }

    interface BaseView
}