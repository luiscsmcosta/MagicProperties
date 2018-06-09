package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.properties.location.LocationDTO
import com.lc.magicproperties.model.daos.properties.location.LocationDAO
import org.mapstruct.Mapper

@Mapper
interface LocationMapper : CityMapper {
    fun fromLocationDtoToDao(dto: LocationDTO): LocationDAO
}