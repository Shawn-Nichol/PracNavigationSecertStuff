package com.example.pracnavigationsecertstuff

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentEnterPasswordBinding
import kotlinx.android.synthetic.main.fragment_enter_password.*


class FragmentEnterPassword : Fragment() {

    private lateinit var binding: FragmentEnterPasswordBinding
    private lateinit var mContext: Context

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
            R.layout.fragment_enter_password,
            container,
            false
        )

        binding.binding = this


        Log.i("Prac", "onCreateView")
        return binding.root
    }

    fun enterPassword() {
        val password = editText_password.text.toString().toInt()

        Log.i("Prac", "password: $password")

        if (password == 1234) {
            findNavController().navigate(R.id.action_fragmentEnterPassword_to_fragmentSecretStuff)
        } else {

            val action = FragmentEnterPasswordDirections.actionFragmentEnterPasswordToFragmentFailedLogin(
                password
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
                R.id.contextual_one -> {
                    displayCAB("One")
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                R.id.contextual_two -> {
                    displayCAB("Two")
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                R.id.contextual_three -> {
                    displayCAB("Three")
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                else -> false
            }
        }

        // Called when the user exits the action mode
        override fun onDestroyActionMode(mode: ActionMode) {
            mActionMode = null
        }

        fun displayCAB(item: String) {
            Toast.makeText(context, "CAB item: $item", Toast.LENGTH_LONG).show()
        }
    }






}


