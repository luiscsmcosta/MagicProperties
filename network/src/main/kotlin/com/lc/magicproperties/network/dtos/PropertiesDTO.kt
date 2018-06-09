package com.lc.magicproperties.network.dtos

import com.google.gson.annotations.SerializedName
import com.lc.magicproperties.network.dtos.properties.FilterDTO
import com.lc.magicproperties.network.dtos.properties.PropertyDTO
import com.lc.magicproperties.network.dtos.properties.location.LocationDTO

data class PropertiesDTO(@SerializedName("properties") val properties: List<PropertyDTO>,
                         @SerializedName("location") val location: LocationDTO,
                         @SerializedName("filterData") val filterData: FilterDTO)