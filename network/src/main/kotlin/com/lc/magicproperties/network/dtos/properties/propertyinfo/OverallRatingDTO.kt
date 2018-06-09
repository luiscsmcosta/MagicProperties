package com.lc.magicproperties.network.dtos.properties.propertyinfo

import com.google.gson.annotations.SerializedName

data class OverallRatingDTO(@SerializedName("overall") val overall: Int,
                            @SerializedName("numberOfRatings") val numberOfRatings: String)