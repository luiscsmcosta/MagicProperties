package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.properties.PropertyDTO
import com.lc.magicproperties.model.daos.properties.PropertyDAO
import org.mapstruct.Mapper

@Mapper
interface PropertyMapper : OverallRatingMapper, FilterMapper, ImageMapper {

    fun fromPropertyDtoToDao(dto: PropertyDTO): PropertyDAO
}