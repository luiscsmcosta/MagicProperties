package com.lc.magicproperties.ui.main

import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.ui.base.BaseContract

class PropertiesContract {

    interface View : BaseContract.BaseView

    interface Presenter<in View> : BaseContract.Presenter<View> {
        fun onGetProperties(propertiesDAO: PropertiesDAO)
        fun getProperties(progress: android.view.View)
    }
}