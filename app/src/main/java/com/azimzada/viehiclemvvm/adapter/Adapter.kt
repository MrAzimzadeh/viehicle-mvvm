package com.azimzada.viehiclemvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azimzada.viehiclemvvm.R
import com.azimzada.viehiclemvvm.model.DTO

class Adapter (private var list: List<DTO>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryTextView = itemView.findViewById<TextView>(R.id.countryTextView)
        var commonNameTextView = itemView.findViewById<TextView>(R.id.commonNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = list[position]
        holder.countryTextView.text = car.Country
        holder.commonNameTextView.text = car.Mfr_CommonName
    }
}