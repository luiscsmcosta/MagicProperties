package com.lc.magicproperties.model.daos.properties.location

import android.os.Parcel
import android.os.Parcelable

data class LocationDAO(val city: CityDAO,
                       val region: String?) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<CityDAO>(CityDAO::class.java.classLoader),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(city, 0)
        writeString(region)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LocationDAO> = object : Parcelable.Creator<LocationDAO> {
            override fun createFromParcel(source: Parcel): LocationDAO = LocationDAO(source)
            override fun newArray(size: Int): Array<LocationDAO?> = arrayOfNulls(size)
        }
    }
}