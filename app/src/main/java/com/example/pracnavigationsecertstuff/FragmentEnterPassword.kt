package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentEnterPasswordBinding
import kotlinx.android.synthetic.main.fragment_enter_password.*


class FragmentEnterPassword : Fragment() {

    private lateinit var binding: FragmentEnterPasswordBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_enter_password, container, false)

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

            val action = FragmentEnterPasswordDirections.actionFragmentEnterPasswordToFragmentFailedLogin(password)
            findNavController().navigate(action)
        }
    }
}