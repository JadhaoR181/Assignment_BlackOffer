package com.example.blackoffferassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class switchproffessionalAdapter (private val professionalList: List<switchprofressionalModel>) :
    RecyclerView.Adapter<switchproffessionalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val professionalNameTextView: TextView = itemView.findViewById(R.id.professionalName)
        val professionalShortNameTextView: TextView = itemView.findViewById(R.id.professionalshortname)
        val professionalLocationTextView: TextView = itemView.findViewById(R.id.professionallocation)
        val professionalCategoryTextView: TextView = itemView.findViewById(R.id.professionalcat)
        val professionalDescriptionTextView: TextView = itemView.findViewById(R.id.professionaldesc)
        val professionalProgressBar: ProgressBar = itemView.findViewById(R.id.professionalProgressBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_professional, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val professional = professionalList[position]

        holder.professionalNameTextView.text = professional.professionalName
        holder.professionalShortNameTextView.text = professional.professionalShortName
        holder.professionalLocationTextView.text = professional.professionalLocation
        holder.professionalCategoryTextView.text = professional.professionalCategory
        holder.professionalDescriptionTextView.text = professional.professionalDescription
        holder.professionalProgressBar.progress = professional.professionalProgress
    }

    override fun getItemCount(): Int {
        return professionalList.size
    }
}