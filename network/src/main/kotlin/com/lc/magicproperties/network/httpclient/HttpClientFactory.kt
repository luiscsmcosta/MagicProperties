package com.lc.magicproperties.network.httpclient

import android.util.Log
import com.lc.magicproperties.network.endpoint.IApiRetrofitServiceDefinition
import com.lc.magicproperties.network.paths.PathConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class HttpClientFactory : IHttpClientFactory<IApiRetrofitServiceDefinition> {

    override fun create(): IApiRetrofitServiceDefinition {

        val httpClient = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d(this.javaClass.name, message) })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(loggingInterceptor)


        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(PathConstants.BASE_URL)
                .client(httpClient.build()).build()

        return retrofit.create(IApiRetrofitServiceDefinition::class.java)
    }

}
