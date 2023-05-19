package com.example.blackoffferassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class switchMerchantAdapter (private val merchantList: List<switchMerchantModel>) :
    RecyclerView.Adapter<switchMerchantAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val merchantNameTextView: TextView = itemView.findViewById(R.id.merchantName)
        val merchantShortNameTextView: TextView = itemView.findViewById(R.id.merchantshortname)
        val merchantLocationTextView: TextView = itemView.findViewById(R.id.merchantlocation)
        val merchantDescriptionTextView: TextView = itemView.findViewById(R.id.merchantdesc)
        val merchantProgressBar: ProgressBar = itemView.findViewById(R.id.merchantProgressBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_merchant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val merchant = merchantList[position]

        holder.merchantNameTextView.text = merchant.merchantName
        holder.merchantShortNameTextView.text = merchant.merchantShortName
        holder.merchantLocationTextView.text = merchant.merchantLocation
        holder.merchantDescriptionTextView.text = merchant.merchantDescription
        holder.merchantProgressBar.progress = merchant.merchantProgress
    }

    override fun getItemCount(): Int {
        return merchantList.size
    }
}