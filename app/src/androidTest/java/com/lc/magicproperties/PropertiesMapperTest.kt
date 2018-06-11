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
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PropertiesMapperTest {

    @Test
    fun testPropertiesMapper() {
        val inputStream: InputStream = InstrumentationRegistry.getContext().resources.assets.open("properties.json")

        val reader: Reader = InputStreamReader(inputStream, "UTF-8")

        val propertiesDTO: PropertiesDTO = Gson().fromJson(reader, PropertiesDTO::class.java)

        val propertiesDAO: PropertiesDAO = Mappers.getMapper(PropertiesMapper::class.java).fromPropertiesDtoToDao(propertiesDTO)

        assertEquals(propertiesDTO.filterData.lowestPricePerNight.value, propertiesDAO.filterData.lowestPricePerNight.value)
        assertEquals(propertiesDTO.properties.size, propertiesDAO.properties.size) //passes
        assertEquals(propertiesDTO.properties.size, propertiesDAO.properties.size + 1) //fails
    }
}