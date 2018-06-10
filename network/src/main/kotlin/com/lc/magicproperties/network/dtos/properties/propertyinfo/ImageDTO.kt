package com.lc.magicproperties.network.dtos.properties.propertyinfo

import com.google.gson.annotations.SerializedName

data class ImageDTO (@SerializedName("prefix") val prefix: String,
                     @SerializedName("suffix") val suffix: String)