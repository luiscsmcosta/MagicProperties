package com.lc.magicproperties.network.httpclient

import com.lc.magicproperties.network.endpoint.IApiRetrofitServiceDefinition
import com.lc.magicproperties.network.paths.PathConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class HttpClientFactory : IHttpClientFactory<IApiRetrofitServiceDefinition> {

    override fun create(): IApiRetrofitServiceDefinition {

        val httpClient = OkHttpClient.Builder()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(PathConstants.BASE_URL)
                .client(httpClient.build()).build()

        return retrofit.create(IApiRetrofitServiceDefinition::class.java)
    }

}
