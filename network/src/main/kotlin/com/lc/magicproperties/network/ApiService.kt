package com.lc.magicproperties.network

import com.lc.magicproperties.network.dtos.PropertiesDTO
import com.lc.magicproperties.network.endpoint.IApiRetrofitServiceDefinition
import com.lc.magicproperties.network.httpclient.IHttpClientFactory
import io.reactivex.Single
import retrofit2.Response

class ApiService(httpClientFactory: IHttpClientFactory<IApiRetrofitServiceDefinition>) : IApiService {

    private val api: IApiRetrofitServiceDefinition by lazy { httpClientFactory.create() }

    override fun getProperties(): Single<Response<PropertiesDTO>> {
        return api.getProperties()
    }

    override fun getStats(action: String, duration: Long): Single<Response<Int>> {
        return api.getStats(action, duration)
    }

}