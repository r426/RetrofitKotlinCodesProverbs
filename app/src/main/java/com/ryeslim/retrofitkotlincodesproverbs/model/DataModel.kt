package com.ryeslim.retrofitkotlincodesproverbs.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataModel(

    @Expose
    @SerializedName("id")
    val theID: Short,
    @Expose
    @SerializedName("text")
    val proverb: String
)