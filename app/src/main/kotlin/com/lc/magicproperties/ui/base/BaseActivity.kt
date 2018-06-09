package com.lc.magicproperties.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<V : BaseContract.BaseView, P: BaseContract.Presenter<V>> : AppCompatActivity() {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this as V)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.restoreInstance(savedInstanceState)
    }

    abstract fun injectPresenter()
}