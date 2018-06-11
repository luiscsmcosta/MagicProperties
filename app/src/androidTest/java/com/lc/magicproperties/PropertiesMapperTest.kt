package com.lc.magicproperties

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.google.gson.Gson
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.model.mapper.PropertiesMapper
import com.lc.magicproperties.network.dtos.PropertiesDTO
import org.junit.Test
import org.mapstruct.factory.Mappers
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PropertiesMapperTest {

    lateinit var inputStream: InputStream
    lateinit var reader: Reader
    lateinit var propertiesDTO: PropertiesDTO
    lateinit var propertiesDAO: PropertiesDAO

    @Before
    fun init() {
        inputStream = InstrumentationRegistry.getContext().resources.assets.open("properties.json")

        reader = InputStreamReader(inputStream, "UTF-8")

        propertiesDTO = Gson().fromJson(reader, PropertiesDTO::class.java)

        propertiesDAO = Mappers.getMapper(PropertiesMapper::class.java).fromPropertiesDtoToDao(propertiesDTO)
    }

    @Test
    fun testFilterDataMapper() {
        assertEquals(propertiesDTO.filterData.lowestPricePerNight.value, propertiesDAO.filterData.lowestPricePerNight.value)
        assertEquals(propertiesDTO.filterData.lowestPricePerNight.currency, propertiesDAO.filterData.lowestPricePerNight.currency)
        assertEquals(propertiesDTO.filterData.highestPricePerNight.value, propertiesDAO.filterData.highestPricePerNight.value)
        assertEquals(propertiesDTO.filterData.highestPricePerNight.currency, propertiesDAO.filterData.highestPricePerNight.currency)
    }

    @Test
    fun testLocationMapper() {
        assertEquals(propertiesDTO.location.city.country, propertiesDAO.location.city.country)
        assertEquals(propertiesDTO.location.city.id, propertiesDAO.location.city.id)
        assertEquals(propertiesDTO.location.city.idCountry, propertiesDAO.location.city.idCountry)
        assertEquals(propertiesDTO.location.city.name, propertiesDAO.location.city.name)
        assertEquals(propertiesDTO.location.region, propertiesDAO.location.region)
    }

    @Test
    fun testPropertiesList() {
        assertEquals(propertiesDTO.properties.size, propertiesDAO.properties.size) //passes
        assertEquals(propertiesDTO.properties.size, propertiesDAO.properties.size + 1) //fails
    }
}