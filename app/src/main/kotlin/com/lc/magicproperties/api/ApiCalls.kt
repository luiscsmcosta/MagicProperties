package com.lc.magicproperties.api

import android.util.Log
import com.lc.magicproperties.application.MagicPropertiesApplication
import com.lc.magicproperties.application.applicationComponent
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.model.mapper.PropertiesMapper
import com.lc.magicproperties.network.NetworkLayer
import com.lc.magicproperties.network.dtos.PropertiesDTO
import com.lc.magicproperties.ui.base.BasePresenter
import com.lc.magicproperties.ui.main.MainPresenter
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.mapstruct.factory.Mappers
import retrofit2.Response


class ApiCalls : IApiCalls {

    constructor(aplication: MagicPropertiesApplication) {
        applicationComponent.inject(this)
    }

    private val bgscheduler = Schedulers.io()
    private val mainthreadscheduler = AndroidSchedulers.mainThread()

    override fun getProperties(presenter: MainPresenter) {
        NetworkLayer.getApiService().getProperties().subscribeOn(bgscheduler).observeOn(mainthreadscheduler)
                .subscribeWith(object : DisposableSingleObserver<Response<PropertiesDTO>>() {
                    override fun onError(e: Throwable) {
                        Log.e("Api", "\'getProperties\' error: \n" + e.message)
                    }

                    override fun onSuccess(response: Response<PropertiesDTO>) {
                        if(response.isSuccessful) {
                            Log.d("Api", "\'getProperties\' success")

                            if (response.body() != null) {
                                val propertiesDTO: PropertiesDTO = response.body()!!
                                val propertiesDAO: PropertiesDAO = Mappers.getMapper(PropertiesMapper::class.java).fromPropertiesDtoToDao(propertiesDTO)

                                presenter.onGetProprieties(propertiesDAO)
                            }
                        }
                    }
                })
    }

    override fun getStats(action: String, duration: Int) {
        NetworkLayer.getApiService().getStats(action, duration).subscribeOn(bgscheduler).observeOn(mainthreadscheduler)
                .subscribeWith(object : DisposableSingleObserver<Response<Int>>() {
                    override fun onError(e: Throwable) {
                        Log.e("Api", "\'getStats\' error: \n" + e.message)
                    }

                    override fun onSuccess(response: Response<Int>) {
                        if(response.isSuccessful) {
                            Log.d("Api", "\'getStats\' success")

                            if (response.body() != null) {
                                Log.d("Api", "\'getStats\' response: " + response.body())
                            }
                        }
                    }
                })
    }
}