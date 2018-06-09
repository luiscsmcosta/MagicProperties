package com.lc.magicproperties.model.daos.properties.propertyinfo

import android.os.Parcel
import android.os.Parcelable

data class OverallRatingDAO(val overall: Int,
                            val numberOfRatings: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(overall)
        writeString(numberOfRatings)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OverallRatingDAO> = object : Parcelable.Creator<OverallRatingDAO> {
            override fun createFromParcel(source: Parcel): OverallRatingDAO = OverallRatingDAO(source)
            override fun newArray(size: Int): Array<OverallRatingDAO?> = arrayOfNulls(size)
        }
    }
}