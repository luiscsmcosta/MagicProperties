package com.lc.magicproperties.ui.main

import android.os.Bundle
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.ui.base.BaseContract

class MainContract {
    interface View : BaseContract.BaseView {
        fun showInfo(propertiesDAO: PropertiesDAO)
        fun setProgressViewVisibility(progressViewVisibility: Int)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onGetProperties(propertiesDAO: PropertiesDAO)

        fun getProperties(progress: android.view.View)

        fun saveInstance(outState: Bundle?, propertiesDAO: PropertiesDAO?, progressViewVisibility: Int)
    }
}