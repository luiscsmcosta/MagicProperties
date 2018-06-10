package com.lc.magicproperties.model.daos.properties.propertyinfo

import android.os.Parcel
import android.os.Parcelable

data class ImageDAO(var prefix: String, var suffix: String) : Parcelable {
    constructor() : this("","")

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(prefix)
        writeString(suffix)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ImageDAO> = object : Parcelable.Creator<ImageDAO> {
            override fun createFromParcel(source: Parcel): ImageDAO = ImageDAO(source)
            override fun newArray(size: Int): Array<ImageDAO?> = arrayOfNulls(size)
        }
    }
}