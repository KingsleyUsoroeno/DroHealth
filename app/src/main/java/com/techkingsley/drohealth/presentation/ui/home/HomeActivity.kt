package com.techkingsley.drohealth.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.techkingsley.drohealth.R
import com.techkingsley.drohealth.databinding.ActivityHomeActiivityBinding
import com.techkingsley.drohealth.presentation.utils.setupWithNavController

class HomeActivity : AppCompatActivity() {

    private var navController: NavController? = null
    private var currentNavController: LiveData<NavController>? = null
    private lateinit var viewBinding: ActivityHomeActiivityBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_home_actiivity)
        bottomNavigationView = viewBinding.bottomNavigation
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        } // Else, need to wait for onRestoreInstanceState

        currentNavController?.observe(this, Observer {
            navController?.addOnDestinationChangedListener { controller, destination, arguments ->

            }
        })
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds =
            listOf(
                R.navigation.home,
                R.navigation.appointments,
                R.navigation.doctors,
                R.navigation.profile
            )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )
        // if the app uses a toolbar or action bar
        // Whenever the selected controller changes, setup the action bar.
        /*controller.observe(this, Observer { navController ->
            setupActionBarWithNavController(navController)
        })*/
        currentNavController = controller
        navController = currentNavController?.value
    }
}