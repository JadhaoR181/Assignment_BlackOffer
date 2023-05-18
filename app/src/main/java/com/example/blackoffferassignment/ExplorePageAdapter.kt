package com.example.blackoffferassignment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

public class ExplorePageAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        // Return the corresponding fragment for each tab position
        return when (position) {
            0 -> ExploreFrag_network()
            1 -> ExploreFrag_professional()
            2 -> ExploreFrags_merchants()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }

    override fun getCount(): Int {
        // Return the total number of tabs
        return 3
    }
}
