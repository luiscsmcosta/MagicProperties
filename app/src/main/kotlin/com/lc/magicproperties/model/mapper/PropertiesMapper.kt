package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.PropertiesDTO
import com.lc.magicproperties.model.daos.PropertiesDAO
import org.mapstruct.Mapper

@Mapper
interface PropertiesMapper : PropertyMapper, LocationMapper, FilterMapper {

    fun fromPropertiesDtoToDao(dto: PropertiesDTO): PropertiesDAO
}