package com.lc.magicproperties.ui.main

import android.os.Bundle
import com.lc.magicproperties.R
import com.lc.magicproperties.application.applicationComponent
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.ui.base.BaseActivity

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View {

    private lateinit var propertiesDAO: PropertiesDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getProprieties()
    }

    override fun injectPresenter() {
        applicationComponent.inject(this)
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter.saveInstance(outState, propertiesDAO)
    }

    override fun showProperties(propertiesDAO: PropertiesDAO) {
        this.propertiesDAO = propertiesDAO

        //TODO put info on Vieww
    }
}