package com.lc.magicproperties.model.mapper

import com.lc.magicproperties.network.dtos.properties.PriceDTO
import com.lc.magicproperties.model.daos.properties.PriceDAO
import org.mapstruct.Mapper

@Mapper
interface PriceMapper {

    fun fromPriceDtoToDao(dto: PriceDTO): PriceDAO
}