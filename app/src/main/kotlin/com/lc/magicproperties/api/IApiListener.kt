package com.lc.magicproperties.api

import com.lc.magicproperties.model.daos.PropertiesDAO

interface IApiListener {
    fun onGetPropertiesSuccess(propertiesDAO: PropertiesDAO)
    fun onGetPropertiesError()
}