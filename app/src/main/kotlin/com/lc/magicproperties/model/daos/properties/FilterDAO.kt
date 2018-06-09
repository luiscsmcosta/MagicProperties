package com.lc.magicproperties.model.daos.properties

import android.os.Parcel
import android.os.Parcelable

data class FilterDAO(var lowestPricePerNight: PriceDAO,
                     var highestPricePerNight: PriceDAO) : Parcelable {

    constructor() : this(PriceDAO(), PriceDAO())

    constructor(source: Parcel) : this(
            source.readParcelable<PriceDAO>(PriceDAO::class.java.classLoader),
            source.readParcelable<PriceDAO>(PriceDAO::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(lowestPricePerNight, 0)
        writeParcelable(highestPricePerNight, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<FilterDAO> = object : Parcelable.Creator<FilterDAO> {
            override fun createFromParcel(source: Parcel): FilterDAO = FilterDAO(source)
            override fun newArray(size: Int): Array<FilterDAO?> = arrayOfNulls(size)
        }
    }
}