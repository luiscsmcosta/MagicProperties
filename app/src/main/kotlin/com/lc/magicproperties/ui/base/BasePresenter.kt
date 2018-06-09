package com.lc.magicproperties.ui.base

import android.os.Bundle
import com.lc.magicproperties.model.daos.PropertiesDAO

open class BasePresenter<V : BaseContract.BaseView> : BaseContract.Presenter<V> {
    private lateinit var view: V
    private var isAttached: Boolean = false

    override fun attachView(view: V) {
        this.view = view
        isAttached = true
    }

    override fun detachView() {
        isAttached = false
    }

    fun getView(): V? {
        if (isAttached) {
            return view
        }
        return null
    }

    override fun saveInstance(outState: Bundle?, propertiesDAO: PropertiesDAO) {
        // do nothing. Override if you need to store data on configuration changes.
    }

    override fun restoreInstance(savedInstanceState: Bundle?) {
        // do nothing. Override if you want to restore state after a configuration change.
    }
}