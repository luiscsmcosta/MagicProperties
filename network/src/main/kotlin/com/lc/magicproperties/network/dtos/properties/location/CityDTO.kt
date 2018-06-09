package com.lc.magicproperties.network.dtos.properties.location

import com.google.gson.annotations.SerializedName

data class CityDTO (@SerializedName("id") val id: String,
                    @SerializedName("name") val name: String,
                    @SerializedName("idCountry") val idCountry: String,
                    @SerializedName("country") val country: String)