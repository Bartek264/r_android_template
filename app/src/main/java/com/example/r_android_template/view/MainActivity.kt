package com.example.r_android_template.view

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.r_android_template.R
import com.example.r_android_template.service.Service
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var list: ArrayList<Model>
    lateinit var adapting: Adapter

    lateinit var showEstateBtn: Button
    lateinit var myToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        showEstateBtn = findViewById(R.id.showNumberBtn)

        list = ArrayList()

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapting = Adapter(context = this, list)
        recyclerView.adapter = adapting

        showEstateBtn.setOnClickListener {
            showToast()
        }
        readJson()
    }

    private fun readJson() {
        val json = Service.getJson()
        val jsonArray = JSONArray(json)

        for (i in 0 until jsonArray.length()) {
            val jsonObj: JSONObject = jsonArray.getJSONObject(i)
            val id = jsonObj.getString("id").toInt()
            val land = jsonObj.getString("land")
            val area = jsonObj.getString("area")
            val district = jsonObj.getString("district")
            val estateNo = jsonObj.getString("estateNo")

            val lands = Model(area.toDouble(), district, estateNo, id, land)
            list.add(lands)
        }
    }

    //Sprawdza czy toast nie jest już aktywny, jeżeli tak to zastępuję tekst
    private fun showToast(){
        val toastEr = resources.getString(R.string.toast_error)
        val preferences = getSharedPreferences("estate", Context.MODE_PRIVATE)
        val estateSave = preferences.getString("estateSaved", toastEr)
        myToast = Toast(this)
        myToast.setText(estateSave)
        myToast.show()
    }

}