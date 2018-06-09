package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.PropertiesDTO
import com.lc.magicproperties.model.daos.PropertiesDAO
import org.mapstruct.Mapper
import org.mapstruct.NullValueCheckStrategy

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
interface PropertiesMapper : PropertyMapper, LocationMapper {

    fun fromPropertiesDtoToDao(dto: PropertiesDTO): PropertiesDAO
}