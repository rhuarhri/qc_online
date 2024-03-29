package com.three_squared.qc_online

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    val mainActivityViewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        var drawerLayout: DrawerLayout? = null
        var actionBarDrawerToggle: ActionBarDrawerToggle? = null
        val navView: NavigationView = findViewById(R.id.nav_view)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        appBarConfiguration = AppBarConfiguration(
            navController.graph, drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.bagelsButton -> {
                    Log.d("BottomNav", "Bagels Button Pressed!")
                    true
                }
                R.id.specialsButton -> {
                    Log.d("BottomNav", "Specials Button Pressed!")
                    true
                }
                R.id.drinksButton -> {
                    Log.d("BottomNav", "Drinks Button Pressed!")
                    true
                }
                R.id.crispsButton -> {
                    Log.d("BottomNav", "Cri Button Pressed!")
                    true
                }
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.navigation_menu, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//        R.id.action_basket -> {
//            // User chose the "Settings" item, show the app settings UI...
//            true
//        }
//
//        else -> {
//            // If we got here, the user's action was not recognized.
//            // Invoke the superclass to handle it.
//            super.onOptionsItemSelected(item)
//        }
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println("item pressed was ${item.title}")
        return super.onOptionsItemSelected(item)
    }
}