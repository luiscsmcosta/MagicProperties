package com.lc.magicproperties.network

import com.lc.magicproperties.network.dtos.PropertiesDTO
import io.reactivex.Single
import retrofit2.Response

interface IApiService {

    fun getProperties(): Single<Response<PropertiesDTO>>

    fun getStats(action: String, duration: Long): Single<Response<Int>>
}