package com.azimzada.viehiclemvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azimzada.viehiclemvvm.R
import com.azimzada.viehiclemvvm.model.GetModelsForMakeYear

class ManufacturerByYearAdapter(var mContext: Context, private var list: List<GetModelsForMakeYear>) :
    RecyclerView.Adapter<ManufacturerByYearAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var makeIdTextView = itemView.findViewById<TextView>(R.id.makeIdTextView)
        var makeNameTextView = itemView.findViewById<TextView>(R.id.makeNameTextView)
        var modelIdTextView = itemView.findViewById<TextView>(R.id.modelIdTextView)
        var modelNameTextView = itemView.findViewById<TextView>(R.id.modelNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.activity_manufacturer_for_make_year_row, parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val manufacturerByYear = list[position]
        holder.makeIdTextView.text = manufacturerByYear.Make_ID.toString()
        holder.makeNameTextView.text = manufacturerByYear.Make_Name
        holder.modelIdTextView.text = manufacturerByYear.Model_ID.toString()
        holder.modelNameTextView.text = manufacturerByYear.Model_Name
    }
}