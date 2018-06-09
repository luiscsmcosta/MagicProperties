package com.lc.magicproperties.ui.main

import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.ui.base.BaseContract

class MainContract {
    interface View : BaseContract.BaseView {
        fun showProperties(propertiesDAO: PropertiesDAO)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onGetProprieties(propertiesDAO: PropertiesDAO)

        fun getProprieties()
    }
}