package com.lc.magicproperties.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lc.magicproperties.R
import com.lc.magicproperties.model.daos.properties.PropertyDAO
import kotlinx.android.synthetic.main.adapter_properties_rv.view.*

class PropertiesRecyclerViewAdapter (val context: Context, var items: List<PropertyDAO>?): RecyclerView.Adapter<PropertiesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_properties_rv, parent, false))
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val property = items?.get(position)
        if(property != null) {
            holder?.propertyNameTv?.text = property.name
            holder?.propertyLowestPriceTv?.text = String.format(context.getString(R.string.lowestPriceString), property.lowestPricePerNight.value, property.lowestPricePerNight.currency)
            holder?.propertyRatingTv?.text = String.format(context.getString(R.string.ratingString), property.overallRating.overall, property.overallRating.numberOfRatings)
            holder?.propertyDescriptionTv?.text = String.format(context.getString(R.string.descriptionString), property.overview)
        }
    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val propertyNameTv = view.propertyNameTv
        val propertyLowestPriceTv = view.propertyLowestPriceTv
        val propertyRatingTv = view.propertyRatingTv
        val propertyDescriptionTv = view.propertyDescriptionTv
    }

    fun setProperties(items: List<PropertyDAO>) {
        this.items = items

        notifyDataSetChanged()
    }
}