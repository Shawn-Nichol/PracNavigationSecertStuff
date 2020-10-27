package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sets the Toolbar.
        setSupportActionBar(findViewById(R.id.my_toolbar))

        // Because the view is yet to load the fragment view cannot be found, for the nav controller
        // to be properly set, the fragment view needs to be created an onViewCreated() needs to be
        // dispatched, which does not happen until the ACTIVITY_CREATED State.

        // Retrieve the navController directly from the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

        // Post the call to the findNavController method on a handler and execute all action needed.
        val navController = navHostFragment!!.findNavController()


        /**
         * Setup up the actionBar returned by AppCompatActivity.getSupportActionBar() for use with a
         * NavController. By calling this the title of the action bar will be automatically updated
         * when the destination changes.
         *
         * The start destination of your navigation graph is considered teh ony top level destination.
         * On all other destinations, the Actionbar will show the Up button. Call NavController.navigateUP
         * to handle the up button.
         *
         * activity: AppCompatActivity: The activity hosting the action bar that should be kept in sync
         * with changes to the NavController.
         *
         * navController: The NavController that supplies the secondary menu. navigation actions on
         * this NavController will be reflected in teh title of the action bar.
         */
        NavigationUI.setupActionBarWithNavController(this, navController)


    }


    /**
     * This method is called when ever the user choose to navigate up within the applications hierarchy.
     *
     * return: true if Up navigation completed successfully and this Activity was finished, false otherwise.
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Option menu selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)

        return when(item.itemId) {
            R.id.fragmentMenuOne -> {
                displayMenuItemSelection("Fragment secret one")


                return NavigationUI.onNavDestinationSelected(item, navController)
            }
            R.id.fragmentMenuTwo -> {
                displayMenuItemSelection("Two")
                return NavigationUI.onNavDestinationSelected(item, navController)
            }
            R.id.fragmentMenuThree -> {
                displayMenuItemSelection("Three")
                return NavigationUI.onNavDestinationSelected(item, navController)
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    fun displayMenuItemSelection(item: String) {
        Toast.makeText(applicationContext, "MenuItem $item selected", Toast.LENGTH_LONG).show()

    }


}

