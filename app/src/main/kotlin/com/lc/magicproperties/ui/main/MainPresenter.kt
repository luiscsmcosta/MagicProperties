package com.lc.magicproperties.ui.main

import android.os.Bundle
import com.lc.magicproperties.api.IApiCalls
import com.lc.magicproperties.consts.SaveInstanceConsts
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.model.daos.properties.PropertyDAO
import com.lc.magicproperties.ui.base.BasePresenter
import java.util.*
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(), MainContract.Presenter {

    @Inject
    lateinit var apiCalls: IApiCalls

    lateinit var progressView: android.view.View

    override fun saveInstance(outState: Bundle?, propertiesDAO: PropertiesDAO?, progressViewVisibility: Int) {
        outState?.putParcelable(SaveInstanceConsts.PROPERTIES_KEY, propertiesDAO)
        outState?.putInt(SaveInstanceConsts.PROGRESS_VISIBILITY_KEY, progressViewVisibility)
    }

    override fun restoreInstance(savedInstanceState: Bundle?) {
        val propertiesDAO: PropertiesDAO = savedInstanceState?.getParcelable(SaveInstanceConsts.PROPERTIES_KEY) as PropertiesDAO

        getView()?.showInfo(propertiesDAO)
        getView()?.setProgressViewVisibility(savedInstanceState.getInt(SaveInstanceConsts.PROGRESS_VISIBILITY_KEY))
    }

    override fun onGetProperties(propertiesDAO: PropertiesDAO) {
        // This sorts the list by position then by lowest price then by highest rating
        propertiesDAO.properties = propertiesDAO.properties.sortedWith(compareBy<PropertyDAO>{ it.position  }.thenBy{ it.lowestPricePerNight.value }.thenByDescending { it.overallRating.overall })

        getView()?.showInfo(propertiesDAO)

        progressView.visibility = android.view.View.GONE
    }

    override fun getProperties(progress: android.view.View) {
        progressView = progress

        progressView.visibility = android.view.View.VISIBLE

        apiCalls.getProperties(this)
    }
}