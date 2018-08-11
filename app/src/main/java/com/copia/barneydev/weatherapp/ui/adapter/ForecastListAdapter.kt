package com.copia.barneydev.weatherapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.copia.barneydev.weatherapp.R
import com.copia.barneydev.weatherapp.domain.model.Forecast
import com.copia.barneydev.weatherapp.domain.model.ForecastList
import com.copia.barneydev.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import org.jetbrains.anko.find

class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewGroup: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

//    override fun getItemCount(): Int {
//        return items.size
//    }

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit): RecyclerView.ViewHolder(view) {
//        private val iconView = view.find<ImageView>(R.id.icon)
//        private val dateView = view.find<TextView>(R.id.date)
//        private val descriptionView = view.find<TextView>(R.id.description)
//        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
//        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        // IDEA: Remove find by ID and we use KotlinAndroidExtensions now
        // Not GOOD when we have a complex layout since it doesnt cache the views, so in viewHolder
        // better stick to find
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

    /**
     * With Invoke listener can be called in two ways
     * itemClick.invoke(forecast)
       itemClick(forecast)
     */
}
