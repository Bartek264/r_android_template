package com.example.r_android_template.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.r_android_template.R

class Adapter(
    var context: Context,
    var landList: ArrayList<Model>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var estateNumber: TextView
        var district: TextView
        var land: TextView
        var area: TextView

        init {
            super.itemView

            estateNumber = itemView.findViewById(R.id.estate_number)
            district = itemView.findViewById(R.id.district)
            land = itemView.findViewById(R.id.land)
            area = itemView.findViewById(R.id.area)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.conteiner, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contain = landList[position]

        //Pobieranie wartości stringów
        val txtLand = context.resources.getString(R.string.land)
        val txtArea = context.resources.getString(R.string.area)
        val txtDistrict = context.resources.getString(R.string.district)
        val txtEstateNumber = context.resources.getString(R.string.estate_number)

        //Formatowanie wartości area do 2 miejsc po przecinku
        holder.area.text = txtArea + " " + String.format("%.2f", contain.area) + " ha"

        holder.land.text = txtLand + " " + contain.land
        holder.district.text = txtDistrict + " " + contain.district
        holder.estateNumber.text = txtEstateNumber + " " + contain.estateNo

        holder.itemView.setOnClickListener {
            //zapisanie wartości po naciśnięciu w pamięci podręcznej
            val preferences = context.getSharedPreferences("estate", Context.MODE_PRIVATE)
            val estateSave = preferences.edit()
            estateSave.putString("estateSaved", contain.estateNo)
            estateSave.apply()
        }
    }

    override fun getItemCount(): Int {
        return landList.size
    }
}