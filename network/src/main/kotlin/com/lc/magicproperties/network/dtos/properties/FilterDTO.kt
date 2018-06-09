package com.lc.magicproperties.network.dtos.properties

import com.google.gson.annotations.SerializedName

data class FilterDTO(@SerializedName("lowestPricePerNight") val lowestPricePerNight: PriceDTO,
                     @SerializedName("highestPricePerNight") val highestPricePerNight: PriceDTO)