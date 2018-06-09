package com.lc.magicproperties.model.daos

import android.os.Parcel
import android.os.Parcelable
import com.lc.magicproperties.model.daos.properties.FilterDAO
import com.lc.magicproperties.model.daos.properties.PropertyDAO
import com.lc.magicproperties.model.daos.properties.location.LocationDAO

data class PropertiesDAO(val properties: List<PropertyDAO>,
                         val location: LocationDAO,
                         val filterData: FilterDAO) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(PropertyDAO.CREATOR),
            source.readParcelable<LocationDAO>(LocationDAO::class.java.classLoader),
            source.readParcelable<FilterDAO>(FilterDAO::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(properties)
        writeParcelable(location, 0)
        writeParcelable(filterData, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PropertiesDAO> = object : Parcelable.Creator<PropertiesDAO> {
            override fun createFromParcel(source: Parcel): PropertiesDAO = PropertiesDAO(source)
            override fun newArray(size: Int): Array<PropertiesDAO?> = arrayOfNulls(size)
        }
    }
}