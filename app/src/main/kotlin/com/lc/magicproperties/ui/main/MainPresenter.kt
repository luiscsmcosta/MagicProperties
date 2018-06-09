package com.lc.magicproperties.ui.main

import android.os.Bundle
import com.lc.magicproperties.consts.SaveInstanceConsts
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun saveInstance(outState: Bundle?, propertiesDAO: PropertiesDAO) {
        outState?.putParcelable(SaveInstanceConsts.PROPERTIES_KEY, propertiesDAO)
    }

    override fun restoreInstance(savedInstanceState: Bundle?) {
        val propertiesDAO: PropertiesDAO = savedInstanceState?.get(SaveInstanceConsts.PROPERTIES_KEY) as PropertiesDAO

        getView()?.showProperties(propertiesDAO)
    }

    override fun onGetProprieties(propertiesDAO: PropertiesDAO) {
        getView()?.showProperties(propertiesDAO)
    }
}