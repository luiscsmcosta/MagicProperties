package com.lc.magicproperties.network.httpclient

interface IHttpClientFactory<T> {
    fun create() : T
}
