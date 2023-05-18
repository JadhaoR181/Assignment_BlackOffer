package com.example.blackoffferassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class FragmentExplore : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_explore, container, false)

        viewPager = rootView.findViewById(R.id.viewPager)
        tabLayout = rootView.findViewById(R.id.tabLayout)

        // Set up the ViewPager with the sections adapter
        viewPager.adapter = ExplorePageAdapter(childFragmentManager)

        // Connect the TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager)

        // Set icons for each tab
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_people)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_breifcase)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_switch_merchant)

        // Set listener to customize tab colors
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val colorWhite = ContextCompat.getColor(requireContext(), R.color.white)
                tab.icon?.setTint(colorWhite)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val colorGrey = ContextCompat.getColor(requireContext(), R.color.grey)
                tab.icon?.setTint(colorGrey)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Do nothing
            }
        })

        // Set the initial colors
        val colorWhite = ContextCompat.getColor(requireContext(), R.color.white)
        tabLayout.getTabAt(0)?.icon?.setTint(colorWhite)
        for (i in 1 until tabLayout.tabCount) {
            val colorGrey = ContextCompat.getColor(requireContext(), R.color.grey)
            tabLayout.getTabAt(i)?.icon?.setTint(colorGrey)
        }

            return rootView
    }
}
