package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.model.daos.properties.propertyinfo.ImageDAO
import com.lc.magicproperties.network.dtos.properties.propertyinfo.ImageDTO

interface ImageMapper {

    fun fromFilterDtoToDao(dto: ImageDTO): ImageDAO
}