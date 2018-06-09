package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.properties.location.CityDTO
import com.lc.magicproperties.model.daos.properties.location.CityDAO
import org.mapstruct.Mapper

@Mapper
interface CityMapper {

    fun fromCityDtoToDao(dto: CityDTO): CityDAO
}