package com.ryeslim.retrofitkotlincodesproverbs.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ryeslim.retrofitkotlincodesproverbs.R
import com.ryeslim.retrofitkotlincodesproverbs.model.DataModel

class DataAdapter(private var dataList: List<DataModel>, private val context: Context) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        holder.titleTextView.text = dataModel.proverb
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var titleTextView: TextView

        init {
            titleTextView = itemLayoutView.findViewById(R.id.title)

        }

    }

}
