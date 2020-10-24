package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu

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
            R.id.main_menu_item_one -> {
                displayMenuItemSelection("One")
                return true
            }
            R.id.main_menu_item_two -> {
                displayMenuItemSelection("Two")
                return true
            }
            R.id.main_menu_item_three -> {
                displayMenuItemSelection("Three")
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    fun displayMenuItemSelection(item: String) {
        Toast.makeText(applicationContext, "MenuItem $item selected", Toast.LENGTH_LONG).show()

    }

    fun myPopMenu(v: View) {
        PopupMenu(this, v).apply {
            //
//            setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener)
            //setOnMenuItemClickListener()
            inflate(R.menu.main_menu)
            show()
        }
    }

}

