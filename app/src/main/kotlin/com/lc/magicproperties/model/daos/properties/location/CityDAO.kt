package com.lc.magicproperties.model.daos.properties.location

import android.os.Parcel
import android.os.Parcelable

data class CityDAO(var id: String,
                   var name: String,
                   var idCountry: String,
                   var country: String) : Parcelable {

    constructor() : this("", "", "", "")

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(name)
        writeString(idCountry)
        writeString(country)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CityDAO> = object : Parcelable.Creator<CityDAO> {
            override fun createFromParcel(source: Parcel): CityDAO = CityDAO(source)
            override fun newArray(size: Int): Array<CityDAO?> = arrayOfNulls(size)
        }
    }
}