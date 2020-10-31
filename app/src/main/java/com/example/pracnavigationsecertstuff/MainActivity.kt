package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var myAppBar: AppBarConfiguration

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavDrawer()
        initDrawerClickListener()

    }


    /**
     * This method is called when ever the user choose to navigate up within the applications hierarchy.
     *
     * return: true if Up navigation completed successfully and this Activity was finished, false otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(myAppBar)
    }

    override fun onBackPressed() {
        if(this.myDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.myDrawerLayout.closeDrawer(GravityCompat.START)
        } else super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Option menu selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return when(item.itemId) {
            R.id.dest_menu_constraint_practice -> {
                displayMenuItemSelection("Fragment secret one")
                return NavigationUI.onNavDestinationSelected(item, navController)
            }
            R.id.dest_menu_two -> {
                displayMenuItemSelection("Two")
                return NavigationUI.onNavDestinationSelected(item, navController)
            }
            R.id.dest_menu_three -> {
                displayMenuItemSelection("Three")
                return NavigationUI.onNavDestinationSelected(item, navController)
            }

            else -> super.onOptionsItemSelected(item)

        }
    }

    fun displayMenuItemSelection(item: String) {
        Toast.makeText(applicationContext, "MenuItem $item selected", Toast.LENGTH_SHORT).show()

    }

    fun initNavDrawer() {
        // Because the view is yet to load the fragment view cannot be found, for the nav controller
        // to be properly set, the fragment view needs to be created an onViewCreated() needs to be
        // dispatched, which does not happen until the ACTIVITY_CREATED State.

        // Retrieve the navController directly from the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Post the call to the findNavController method on a handler and execute all action needed.
        navController = navHostFragment.navController

        // Sets a Toolbar for use with a NavController
        // navController: the NavController whose navigation action will be called.
        // drawerLayout: The DrawerLayout that should be toggled from the Navigation button
        myToolbar.setupWithNavController(navController, myDrawerLayout)

        // Sets the ToolBar as the action bar.
        setSupportActionBar(myToolbar)



        // AppBarConfiguration passes in top level destination.
        myAppBar = AppBarConfiguration(setOf(R.id.dest_login,
            R.id.dest_menu_constraint_practice, R.id.dest_menu_two, R.id.dest_menu_three,
            R.id.dest_contextual_one, R.id.dest_contextual_two, R.id.dest_contextual_three), myDrawerLayout)

        // Sets up the ActionBar returned by AppCompatActivity.getSupportActionbar() for use with a
        // navController.
        //
        setupActionBarWithNavController(navController, myAppBar)
    }


    fun initDrawerClickListener() {
        myNavView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.nav_first -> {
                    displayMenuItemSelection("Nav One")
                    navController.navigate(R.id.dest_menu_constraint_practice)
                    myDrawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_second -> {
                    displayMenuItemSelection("Nav Two")
                    navController.navigate(R.id.dest_menu_two)
                    myDrawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_three -> {
                    displayMenuItemSelection("Nav Three")
                    navController.navigate(R.id.dest_menu_three)
                    myDrawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> {false}


            }

        }



    }
}

