package com.lc.magicproperties.model.daos.properties

import android.os.Parcel
import android.os.Parcelable
import com.lc.magicproperties.model.daos.properties.propertyinfo.ImageDAO
import com.lc.magicproperties.model.daos.properties.propertyinfo.OverallRatingDAO

data class PropertyDAO(var id: String,
                       var position: Long,
                       var images: List<ImageDAO>,
                       var name: String,
                       var overallRating: OverallRatingDAO,
                       var overview: String,
                       var lowestPricePerNight: PriceDAO) : Parcelable {
    constructor() : this("", 0, ArrayList<ImageDAO>(), "", OverallRatingDAO(), "", PriceDAO())

    constructor(source: Parcel) : this(
            source.readString(),
            source.readLong(),
            source.createTypedArrayList(ImageDAO.CREATOR),
            source.readString(),
            source.readParcelable<OverallRatingDAO>(OverallRatingDAO::class.java.classLoader),
            source.readString(),
            source.readParcelable<PriceDAO>(PriceDAO::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeLong(position)
        writeTypedList(images)
        writeString(name)
        writeParcelable(overallRating, 0)
        writeString(overview)
        writeParcelable(lowestPricePerNight, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PropertyDAO> = object : Parcelable.Creator<PropertyDAO> {
            override fun createFromParcel(source: Parcel): PropertyDAO = PropertyDAO(source)
            override fun newArray(size: Int): Array<PropertyDAO?> = arrayOfNulls(size)
        }
    }
}