package com.example.pracnavigationsecertstuff.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.pracnavigationsecertstuff.MainActivity
import com.example.pracnavigationsecertstuff.R
import com.example.pracnavigationsecertstuff.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class FragmentLogin : Fragment(), PopupMenu.OnMenuItemClickListener {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var mContext: Context
    private lateinit var navController: NavController

    val TAG = "PracFragmentLogin"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.binding = this

        // Register view for floating menu.
        registerForContextMenu(binding.btnFloatingMenu)

        navController = requireActivity().findNavController(R.id.nav_host_fragment)

        Log.i(TAG, "onCreateView")

        return binding.root
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = MenuInflater(context)
        inflater.inflate(R.menu.contextual_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val navController = requireActivity().findNavController(R.id.nav_host_fragment)

        return when (item.itemId) {
            R.id.dest_contextual_one -> {
                displayToast("Floating menu Item One")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }
            R.id.dest_contextual_two -> {
                displayToast("Floating menu Item Two")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }
            R.id.dest_contextual_three -> {
                displayToast("Floating menu Item Three")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }
            else -> false
        }

    }


    fun enterPassword() {
        val password: Int? = editText_password.text.toString().toInt()

        Log.i("Prac", "password: $password")

        if (password == 1234) {
            findNavController().navigate(R.id.action_login_to_dest_one)
        } else {

            // Pass data to FragmentLoginFailed with type safety.
            val action =
                FragmentLoginDirections.actionLoginToFailed(
                    password ?: -1
                )
            findNavController().navigate(action)
        }
    }


    private var mActionMode: ActionMode? = null


    fun myCAB() {
        if (mActionMode != null) return

        // as will cast to the type if is successful or return null.
        mActionMode = (activity as MainActivity?)!!.startSupportActionMode(actionModeCallback)
    }

    private val actionModeCallback = object : ActionMode.Callback {
        // Called when the action mode is created; startActionMode() was called
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            // Inflate a menu resource providing context menu items

            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.contextual_menu, menu)
            return true
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {


            return when (item.itemId) {
                R.id.dest_contextual_one -> {
                    displayToast("CAB One")
                    mode.finish() // Action picked, so close the CAB
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                R.id.dest_contextual_two -> {
                    displayToast("CAB Two")
                    mode.finish() // Action picked, so close the CAB
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                R.id.dest_contextual_three -> {
                    displayToast("CAB Three")
                    mode.finish() // Action picked, so close the CAB
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                else -> false
            }
        }

        // Called when the user exits the action mode
        override fun onDestroyActionMode(mode: ActionMode) {
            mActionMode = null
        }
    }

    private fun displayToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    fun myPopMenu(v: View) {
        PopupMenu(mContext, v).apply {
            //
            setOnMenuItemClickListener(this@FragmentLogin)
            //setOnMenuItemClickListener()
            inflate(R.menu.main_menu)
            show()
        }
    }

    /**
     * Handles Pop Menu clicks
     */
    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.dest_menu_constraint_practice -> {
                displayToast("Pop Menu One")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }
            R.id.dest_menu_two -> {
                displayToast("Pop Menu Two")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }

            R.id.dest_menu_three -> {
                displayToast("Pop Menu Three")
                NavigationUI.onNavDestinationSelected(item, navController)
                true
            }
            else -> false
        }
    }


}




