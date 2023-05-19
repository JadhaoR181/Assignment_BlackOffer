package com.example.blackoffferassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreFrags_merchants : Fragment() {
    
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: switchMerchantAdapter
    private val merchant = listOf(
        switchMerchantModel("Ravindra Jadhav", "RJ","Mumbai, within 1-3Km", "Hi community! We have a great deals for you check this out!",
             60),
        switchMerchantModel("Ritesh Gupta", "RG","Thane, within 4-5Km", "Hi community! We have a great deals for you check this out!",
             60),
        switchMerchantModel("Ayesh Bramsi", "AB", "Bangalore, within 5-6Km","Hi community! We have a great deals for you check this out!",
             70),
        switchMerchantModel("Sahil Kirloskar", "SK", "Nashik, within 6-7Km", "Hi community! We have a great deals for you check this out!",
             20),
        switchMerchantModel("Palak Jha", "PJ", "Navi Mumbai, within 2-3Km", "Hi community! We have a great deals for you check this out!",
             20),
        switchMerchantModel("Ritesh Gupta", "RG", "Navi Mumbai, within 5-7Km", "Hi community! We have a great deals for you check this out!",
             60),
        switchMerchantModel("Ayesh Bramsi", "AB", "Andheri, within 5-7Km", "Hi community! We have a great deals for you check this out!",
             70),
        switchMerchantModel("Sahil Kirloskar", "SK", "Andheri, within 6-9Km", "Hi community! We have a great deals for you check this out!",
             20),
        switchMerchantModel("Palak Jha", "PJ", "Dadar, within 4-8Km", "Hi community! We have a great deals for you check this out!",
             20),
        switchMerchantModel("Johny Singh", "JS", "Dadar, within 2-5Km", "Hi community! We have a great deals for you check this out!",
             50)
        ,

        // Add more user data as needed
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview =  inflater.inflate(R.layout.fragment_explore_frags_merchants, container, false)

        recyclerView = rootview.findViewById(R.id.recyclermerchant)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = switchMerchantAdapter(merchant)
        recyclerView.adapter = adapter
        return rootview;
    }
}