package com.example.blackoffferassignment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class PurposeAdapter(
    private val mList: List<Model>
) : RecyclerView.Adapter<PurposeAdapter.ViewHolder>() {

    private val selectedItems = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_purpose, parent, false) as MaterialCardView
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = mList[position]
        holder.textView.text = model.name

        if (selectedItems.contains(position)) {
            holder.cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.colorPrimary
                )
            )
            holder.textView.setTextColor(Color.WHITE)
        } else {
            holder.cardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.white
                )
            )
            holder.textView.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.black
                )
            )
        }

        holder.itemView.setOnClickListener {
            if (selectedItems.contains(position)) {
                selectedItems.remove(position)
            } else {
                selectedItems.add(position)
            }
            notifyItemChanged(position)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: MaterialCardView = itemView.findViewById(R.id.cardPurpose)
        val textView: TextView = itemView.findViewById(R.id.txtPurpose)
    }

    fun getSelectedItems(): List<Model> {
        val selectedModels = mutableListOf<Model>()
        for (position in selectedItems) {
            selectedModels.add(mList[position])
        }
        return selectedModels
    }

    fun resetSelectedItems() {
        selectedItems.clear()
        notifyDataSetChanged()
    }
}
