package com.lc.magicproperties.network

import com.lc.magicproperties.network.httpclient.HttpClientFactory

object NetworkLayer {

    private var apiService: IApiService? = null

    @JvmStatic
    fun getApiService(): IApiService {
        synchronized(this) {
            if (apiService == null) {
                apiService = ApiService(HttpClientFactory())
            }
            return apiService!!
        }
    }
}