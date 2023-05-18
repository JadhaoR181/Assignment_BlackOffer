package com.example.blackoffferassignment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private val RefineFragment = FragmentRefine()
    private val ExploreFragment = FragmentExplore()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar) // Assuming your activity_main.xml has a Toolbar with id "toolbar"
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val btmNavigation = findViewById<BottomNavigationView>(R.id.btm_navigation)
        btmNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_refine -> {
                    btmNavigation.menu.findItem(R.id.nav_refine).setIcon(R.drawable.ic_refine_checked)
                    btmNavigation.menu.findItem(R.id.nav_explore).setIcon(R.drawable.ic_explore_unchecked)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, RefineFragment).commit()
                    true
                }

                R.id.nav_explore -> {
                    btmNavigation.menu.findItem(R.id.nav_refine).setIcon(R.drawable.ic_refine_unchecked)
                    btmNavigation.menu.findItem(R.id.nav_explore).setIcon(R.drawable.ic_explore_checked)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, ExploreFragment).commit()
                    true
                }

                else -> false
            }
        }
        // Set the default fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, RefineFragment).commit()

        val leftButton: ImageButton = findViewById(R.id.navBtn)
        leftButton.setOnClickListener {
            openLeftDrawer()
        }

        val rightButton: ImageButton = findViewById(R.id.notifyBtn)
        rightButton.setOnClickListener {
            openRightDrawer()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val left_navigationView: NavigationView = findViewById(R.id.left_drawer)
        val right_navigationView: NavigationView = findViewById(R.id.right_drawer)
        val leftheaderView = left_navigationView.getHeaderView(0)
        val rightheaderView = right_navigationView.getHeaderView(0)
        val profileImage: ImageView = leftheaderView.findViewById(R.id.profile_image)
        val userName: TextView = leftheaderView.findViewById(R.id.user_name)
        val rightDrawerClose : ImageButton = rightheaderView.findViewById(R.id.closeBtn)
        rightDrawerClose.setOnClickListener {
           drawerLayout.closeDrawer(GravityCompat.END)
        }


        // Set the profile image and user name
        profileImage.setImageResource(R.drawable.profile_image)
        userName.text = "Ravindra Jadhav"

        left_navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle left drawer item clicks here

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun openLeftDrawer() {
        drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun openRightDrawer() {
        drawerLayout.openDrawer(GravityCompat.END)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}