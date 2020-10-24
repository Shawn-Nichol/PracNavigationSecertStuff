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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.fragmentMenuOne -> {
                displayMenuItemSelection("Fragment secret one")

                val navController = findNavController(R.id.nav_host_fragment)
                return NavigationUI.onNavDestinationSelected(item!!, navController) || super.onOptionsItemSelected(item)
            }
            R.id.main_menu_item_two -> {
                displayMenuItemSelection("Two")
                return true
            }
            R.id.main_menu_three -> {
                displayMenuItemSelection("Three")
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    fun displayMenuItemSelection(item: String) {
        Toast.makeText(applicationContext, "MenuItem $item selected", Toast.LENGTH_LONG).show()

    }



}

