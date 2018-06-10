package com.lc.magicproperties.network.dtos.properties

import com.google.gson.annotations.SerializedName
import com.lc.magicproperties.network.dtos.properties.propertyinfo.ImageDTO
import com.lc.magicproperties.network.dtos.properties.propertyinfo.OverallRatingDTO

data class PropertyDTO (@SerializedName("id") val id: String,
                        @SerializedName("position") val position: Long,
                        @SerializedName("images") val images: List<ImageDTO>,
                        @SerializedName("name") val name: String,
                        @SerializedName("overallRating") val overallRating: OverallRatingDTO,
                        @SerializedName("overview") val overview: String,
                        @SerializedName("lowestPricePerNight") val lowestPricePerNight: PriceDTO)