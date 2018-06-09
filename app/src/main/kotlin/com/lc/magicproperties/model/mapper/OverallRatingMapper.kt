package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.properties.propertyinfo.OverallRatingDTO
import com.lc.magicproperties.model.daos.properties.propertyinfo.OverallRatingDAO
import org.mapstruct.Mapper

@Mapper
interface OverallRatingMapper {

    fun fromOverallRatingDtoToDao(dto: OverallRatingDTO): OverallRatingDAO
}