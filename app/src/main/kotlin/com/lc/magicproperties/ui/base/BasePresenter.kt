package com.lc.magicproperties.ui.base

import android.os.Bundle
import android.view.View
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

    override fun saveInstance(outState: Bundle?) {
        // do nothing.
    }

    override fun restoreInstance(savedInstanceState: Bundle?) {
        // do nothing.
    }
}