package com.example.blackoffferassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreFrag_professional : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: switchproffessionalAdapter
    private val professional = listOf(
        switchprofressionalModel("Ravindra Jadhav", "RJ","Mumbai, within 1-3Km", "Android Developer | 1 year of experience",
            "Hi community, I am available at your service !", 60),
        switchprofressionalModel("Ritesh Gupta", "RG","Thane, within 4-5Km", "Data Entry Specialist | 2 years of experience",
            "Hi community, I am available at your service !", 60),
        switchprofressionalModel("Ayesh Bramsi", "AB", "Bangalore, within 5-6Km","Trainee Engineer | 8 years of experience",
            "Hi community, I am available at your service !", 70),
        switchprofressionalModel("Sahil Kirloskar", "SK", "Nashik, within 6-7Km", "Software Developer | 4 years of experience",
            "Hi community, I am available at your service !", 20),
        switchprofressionalModel("Palak Jha", "PJ", "Navi Mumbai, within 2-3Km", "Site Engineer | 3 years of experience",
            "Hi community, I am available at your service !", 20),
        switchprofressionalModel("Ritesh Gupta", "RG", "Navi Mumbai, within 5-7Km", "Civil Engineer | 10 years of experience",
            "Hi community, I am available at your service !", 60),
        switchprofressionalModel("Ayesh Bramsi", "AB", "Andheri, within 5-7Km", "Hardwaer Engineer | 1 years of experience",
            "Hi community, I am available at your service !", 70),
        switchprofressionalModel("Sahil Kirloskar", "SK", "Andheri, within 6-9Km", "Automation Engineer | 4 years of experience",
            "Hi community, I am available at your service !", 20),
        switchprofressionalModel("Palak Jha", "PJ", "Dadar, within 4-8Km", "Web Developer | 2 years of experience",
            "Hi community, I am available at your service !", 20),
        switchprofressionalModel("Johny Singh", "JS", "Dadar, within 2-5Km", "Software Testing Engineer | 10 years of experience",
            "Hi community, I am available at your service !", 50)
,
    
        // Add more user data as needed
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview =  inflater.inflate(R.layout.fragment_explore_frag_professional, container, false)

        recyclerView = rootview.findViewById(R.id.recyclerprofessional)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = switchproffessionalAdapter(professional)
        recyclerView.adapter = adapter
        
        return rootview;
    }
}