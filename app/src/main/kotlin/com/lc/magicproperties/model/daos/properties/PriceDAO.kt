package com.lc.magicproperties.model.daos.properties

import android.os.Parcel
import android.os.Parcelable

data class PriceDAO(var value: String,
                    var currency: String) : Parcelable {

    constructor() : this("", "")

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(value)
        writeString(currency)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PriceDAO> = object : Parcelable.Creator<PriceDAO> {
            override fun createFromParcel(source: Parcel): PriceDAO = PriceDAO(source)
            override fun newArray(size: Int): Array<PriceDAO?> = arrayOfNulls(size)
        }
    }
}