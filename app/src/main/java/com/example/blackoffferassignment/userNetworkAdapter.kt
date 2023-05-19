package com.example.blackoffferassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class userNetworkAdapter (private val userList: List<userNetworkModel>) :
        RecyclerView.Adapter<userNetworkAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val userNameTextView: TextView = itemView.findViewById(R.id.userName)
            val userShortNameTextView: TextView = itemView.findViewById(R.id.usershortname)
            val userLocationTextView: TextView = itemView.findViewById(R.id.userlocation)
            val userCategoryTextView: TextView = itemView.findViewById(R.id.usercat)
            val userDescriptionTextView: TextView = itemView.findViewById(R.id.userdesc)
            val userProgressBar: ProgressBar = itemView.findViewById(R.id.userProgressBar)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_network, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val user = userList[position]

            holder.userNameTextView.text = user.userName
            holder.userShortNameTextView.text = user.userShortName
            holder.userLocationTextView.text = user.userLocation
            holder.userCategoryTextView.text = user.userCategory
            holder.userDescriptionTextView.text = user.userDescription
            holder.userProgressBar.progress = user.userProgress
        }

        override fun getItemCount(): Int {
            return userList.size
        }
    }
