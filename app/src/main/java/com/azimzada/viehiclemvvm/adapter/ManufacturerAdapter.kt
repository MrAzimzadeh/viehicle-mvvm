package com.azimzada.viehiclemvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azimzada.viehiclemvvm.R
import com.azimzada.viehiclemvvm.model.Manufacturer


class ManufacturerAdapter(var mContext: Context, private var list: List<Manufacturer>) :
    RecyclerView.Adapter<ManufacturerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var idTextView = itemView.findViewById<TextView>(R.id.idTextView)
        var nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        var manufacturerNameTextView =
            itemView.findViewById<TextView>(R.id.manufacturerNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.activity_manufacturer_row, parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val manufacturer = list[position]
        holder.idTextView.text = manufacturer.Make_ID
        holder.nameTextView.text = manufacturer.Make_Name
        holder.manufacturerNameTextView.text = manufacturer.Mfr_Name
    }
}