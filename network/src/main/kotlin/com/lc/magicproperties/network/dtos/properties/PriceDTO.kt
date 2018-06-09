package com.lc.magicproperties.network.dtos.properties

import com.google.gson.annotations.SerializedName

data class PriceDTO (@SerializedName("value") val value: String,
                     @SerializedName("currency") val currency: String)