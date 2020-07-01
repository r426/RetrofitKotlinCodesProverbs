// From http://www.kotlincodes.com/kotlin/retrofit-with-kotlin/

package com.ryeslim.retrofitkotlincodesproverbs


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryeslim.retrofitkotlincodesproverbs.adapters.DataAdapter
import com.ryeslim.retrofitkotlincodesproverbs.model.DataModel
import com.ryeslim.retrofitkotlincodesproverbs.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity() : AppCompatActivity() {

    var dataList = ArrayList<DataModel>()
    lateinit var recyclerView: RecyclerView

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        //setting up the adapter
        recyclerView.adapter = DataAdapter(dataList, this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        getData()

    }

    private fun getData() {
        val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(
                call: Call<List<DataModel>>?,
                response: Response<List<DataModel>>?
            ) {
                dataList.addAll(response!!.body()!!)
                val l = 1
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
            }
        })
    }
}