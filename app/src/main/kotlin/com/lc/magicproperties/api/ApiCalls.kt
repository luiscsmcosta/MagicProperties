package com.lc.magicproperties.api

import android.util.Log
import com.lc.magicproperties.application.applicationComponent
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.model.mapper.PropertiesMapper
import com.lc.magicproperties.network.NetworkLayer
import com.lc.magicproperties.network.dtos.PropertiesDTO
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.mapstruct.factory.Mappers
import retrofit2.Response


class ApiCalls : IApiCalls {

    constructor() {
        applicationComponent.inject(this)
    }

    private val bgscheduler = Schedulers.io()
    private val mainthreadscheduler = AndroidSchedulers.mainThread()

    override fun getProperties(apiListener: IApiListener) {
        NetworkLayer.getApiService().getProperties().subscribeOn(bgscheduler).observeOn(mainthreadscheduler)
                .subscribeWith(object : DisposableSingleObserver<Response<PropertiesDTO>>() {
                    override fun onError(e: Throwable) {
                        Log.e(ApiCalls::class.java.name, "\'getProperties\' error: \n" + e.message)
                        apiListener.onGetPropertiesError()
                    }

                    override fun onSuccess(response: Response<PropertiesDTO>) {
                        if(response.isSuccessful) {
                            Log.d(ApiCalls::class.java.name, "\'getProperties\' success")

                            if (response.body() != null) {
                                val propertiesDTO: PropertiesDTO = response.body()!!
                                val propertiesDAO: PropertiesDAO = Mappers.getMapper(PropertiesMapper::class.java).fromPropertiesDtoToDao(propertiesDTO)

                                apiListener.onGetPropertiesSuccess(propertiesDAO)
                            } else {
                                apiListener.onGetPropertiesError()
                            }
                        } else {
                            Log.e(ApiCalls::class.java.name, "\'getProperties\' error: " + response.code())
                            apiListener.onGetPropertiesError()
                        }

                        getStats("load-details", response.raw().receivedResponseAtMillis() - response.raw().sentRequestAtMillis())
                    }
                })
    }

    override fun getStats(action: String, duration: Long) {
        NetworkLayer.getApiService().getStats(action, duration).subscribeOn(bgscheduler).observeOn(mainthreadscheduler)
                .subscribeWith(object : DisposableSingleObserver<Response<Int>>() {
                    override fun onError(e: Throwable) {
                        Log.e(ApiCalls::class.java.name, "\'getStats\' error: \n" + e.message)
                    }

                    override fun onSuccess(response: Response<Int>) {
                        if(response.isSuccessful) {
                            Log.d(ApiCalls::class.java.name, "\'getStats\' success")

                            if (response.body() != null) {
                                Log.d(ApiCalls::class.java.name, "\'getStats\' response: " + response.body())
                            }
                        } else {
                            Log.e(ApiCalls::class.java.name, "\'getStats\' error: " + response.code())
                        }
                    }
                })
    }
}