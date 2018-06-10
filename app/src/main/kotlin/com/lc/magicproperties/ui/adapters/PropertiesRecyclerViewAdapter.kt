package com.lc.magicproperties.ui.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.lc.magicproperties.R
import com.lc.magicproperties.consts.CurrencyConsts
import com.lc.magicproperties.consts.RatingConsts
import com.lc.magicproperties.model.daos.properties.PropertyDAO
import com.lc.magicproperties.ui.utils.GlideApp
import kotlinx.android.synthetic.main.adapter_properties_rv.view.*
import java.text.DecimalFormat


class PropertiesRecyclerViewAdapter(private val context: Context, private var items: List<PropertyDAO>?) : RecyclerView.Adapter<PropertiesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_properties_rv, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = items?.get(position)

        if (property != null) {
            holder.bind(context, property)
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val propertyNameTv = view.propertyNameTv
        val propertyLowestPriceTv = view.propertyLowestPriceTv
        val propertyRatingTv = view.propertyRatingTv
        val propertyDescriptionTv = view.propertyDescriptionTv
        val propertyImageIv = view.propertyImageIv

        fun bind(context: Context, property: PropertyDAO) {
            val priceInEur = property.lowestPricePerNight.value.toFloat() / CurrencyConsts.VEF_TO_EUR

            val overallInDecimal = property.overallRating.overall.toFloat() / 10

            propertyNameTv?.text = property.name
            propertyLowestPriceTv?.text = String.format(context.getString(R.string.lowestPriceString), DecimalFormat(CurrencyConsts.DECIMAL_FORMAT).format(priceInEur))
            propertyRatingTv?.text = String.format(context.getString(R.string.ratingString), DecimalFormat(RatingConsts.DECIMAL_FORMAT).format(overallInDecimal), property.overallRating.numberOfRatings)
            propertyDescriptionTv?.text = String.format(context.getString(R.string.descriptionString), property.overview)

            val imageUrl = String.format(context.getString(R.string.imageUrlString), property.images.get(0).prefix, property.images.get(0).suffix)

            GlideApp.with(context)
                    .load(imageUrl)
                    .apply(RequestOptions.circleCropTransform()
                            .downsample(DownsampleStrategy.NONE))
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: com.bumptech.glide.load.DataSource?, isFirstResource: Boolean): Boolean {
                            return false
                        }

                    })
                    .into(propertyImageIv)
        }
    }

    fun setProperties(items: List<PropertyDAO>) {
        this.items = items

        notifyDataSetChanged()
    }
}