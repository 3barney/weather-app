package com.copia.barneydev.weatherapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class ForecastListAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewGroup: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

//    override fun getItemCount(): Int {
          // return items.size
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

}
