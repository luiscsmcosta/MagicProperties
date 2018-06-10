package com.lc.magicproperties.network.endpoint

import com.lc.magicproperties.network.dtos.PropertiesDTO
import com.lc.magicproperties.network.paths.PathConstants
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiRetrofitServiceDefinition {

    @GET(PathConstants.PROPERTIES)
    fun getProperties() : Single<Response<PropertiesDTO>>

    @GET(PathConstants.STATS)
    fun getStats(@Query("action") action: String,
                 @Query("duration") duration: Long) : Single<Response<Int>>
}