package com.example.blackoffferassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExploreFrag_network : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: userNetworkAdapter
    private val userList = listOf(
        userNetworkModel("Ravindra Jadhav", "RJ", "Mumbai, within 1-2Km", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 60),
        userNetworkModel("Johny Singh", "JS", "Thane, within 300-400m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 50),
        userNetworkModel("Ayesh Bramsi", "AB", "Navi Mumbai, within 5-7km", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 70),
        userNetworkModel("Sahil Kirloskar", "SK", "Mumbai, within 600-700m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 20),
        userNetworkModel("Ritesh Gupta", "RG", "Mumbai, within 600-700m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 60),
        userNetworkModel("Palak Jha", "PJ", "Mumbai, within 600-700m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 70),
        userNetworkModel("Raj Dey", "RD", "Mumbai, within 600-700m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 40),
        userNetworkModel("Jyoti Vishwakarma", "JV", "Mumbai, within 600-700m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 60),
        userNetworkModel("Diksha Bhandare", "DB", "Mumbai, within 600-700m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 80),
        userNetworkModel("Sankte Dhage", "SD", "Mumbai, within 600-700m", "Coffee | Business | Friendship",
            "Hi community, I am open to new connections \uD83D\uDE42", 30)
        // Add more user data as needed
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview =  inflater.inflate(R.layout.fragment_explore_frag_network, container, false)
        recyclerView = rootview.findViewById(R.id.recyclernetwork)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = userNetworkAdapter(userList)
        recyclerView.adapter = adapter

        return rootview;
    }
}