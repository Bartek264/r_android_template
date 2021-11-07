package com.example.r_android_template.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.r_android_template.R

class AdapterList(
    private val data: ArrayList<Model>,
    private val context: Context
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val contain = data[position]
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.conteiner, parent, false)
        }

        val estateNumber = itemView!!.findViewById<TextView>(R.id.estate_number)
        val district = itemView.findViewById<TextView>(R.id.district)
        val land = itemView.findViewById<TextView>(R.id.land)
        val area = itemView.findViewById<TextView>(R.id.area)

        //Pobieranie wartości stringów
        val txtLand = context.resources.getString(R.string.land)
        val txtArea = context.resources.getString(R.string.area)
        val txtDistrict = context.resources.getString(R.string.district)
        val txtEstateNumber = context.resources.getString(R.string.estate_number)

        //Formatowanie wartości area do 2 miejsc po przecinku
        area.text = txtArea + " " + String.format("%.2f", contain.area) + " ha"

        land.text = txtLand + " " + contain.land
        district.text = txtDistrict + " " + contain.district
        estateNumber.text = txtEstateNumber + " " + contain.estateNo

        itemView.setOnClickListener {
            //zapisanie wartości po naciśnięciu w pamięci podręcznej
            val preferences = context.getSharedPreferences("estate", Context.MODE_PRIVATE)
            val estateSave = preferences.edit()
            estateSave.putString("estateSaved", contain.estateNo)
            estateSave.apply()
        }

        return itemView
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}