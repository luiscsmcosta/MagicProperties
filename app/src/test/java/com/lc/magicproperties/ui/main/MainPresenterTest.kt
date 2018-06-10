package com.lc.magicproperties.ui.main

import android.support.test.InstrumentationRegistry
import com.google.gson.Gson
import com.lc.magicproperties.model.daos.PropertiesDAO
import junit.framework.TestCase
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

class MainPresenterTest: TestCase() {

    @Mock
    lateinit var mainPresenter: MainPresenter

    override fun setUp() {
        super.setUp()

        MockitoAnnotations.initMocks(this)
    }


    @Test
    fun testProperties() {
        val inputStream : InputStream = InstrumentationRegistry.getContext().assets.open("properties.json")

        val reader : Reader = InputStreamReader(inputStream, "UTF-8")

        mainPresenter.onGetProperties(Gson().fromJson(reader, PropertiesDAO::class.java))
    }
}