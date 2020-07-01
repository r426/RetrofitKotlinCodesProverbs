package com.ryeslim.retrofitkotlincodesproverbs.retrofit

import com.ryeslim.retrofitkotlincodesproverbs.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("d98f6ae8641988b97604")
    fun getPhotos(): Call<List<DataModel>>

}
