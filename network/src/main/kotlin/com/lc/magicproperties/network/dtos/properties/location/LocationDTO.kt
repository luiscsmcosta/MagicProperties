package com.lc.magicproperties.network.dtos.properties.location

import com.google.gson.annotations.SerializedName

data class LocationDTO (@SerializedName("city") val city: CityDTO,
                        @SerializedName("region") val region: String?)