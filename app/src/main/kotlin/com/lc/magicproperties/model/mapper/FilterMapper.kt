package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.properties.FilterDTO
import com.lc.magicproperties.model.daos.properties.FilterDAO

interface FilterMapper : PriceMapper {

    fun fromFilterDtoToDao(dto: FilterDTO): FilterDAO
}