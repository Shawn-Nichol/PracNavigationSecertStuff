package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

