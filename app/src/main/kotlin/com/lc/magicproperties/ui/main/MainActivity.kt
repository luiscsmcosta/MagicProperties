package com.lc.magicproperties.ui.main

import android.os.Bundle
import android.util.Log
import com.lc.magicproperties.R
import com.lc.magicproperties.application.applicationComponent
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.ui.base.BaseActivity

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View {

    private var propertiesDAO: PropertiesDAO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getProperties()
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

        Log.d(MainActivity::class.java.name, "properties lowest price: " + propertiesDAO.filterData.lowestPricePerNight.value + " " + propertiesDAO.filterData.lowestPricePerNight.currency)
    }
}