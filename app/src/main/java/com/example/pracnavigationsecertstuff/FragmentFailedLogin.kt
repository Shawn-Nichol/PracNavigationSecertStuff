package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentFailedLoginBinding


class FragmentFailedLogin : Fragment() {

    private lateinit var binding: FragmentFailedLoginBinding

    private var password: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val args = FragmentFailedLoginArgs.fromBundle(requireArguments())

        password = args.argumentFailedLogin
        Log.i("Prac", "Failed password is $password")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_failed_login, container, false)

        binding.binding = this

        binding.tvFailedPassword.text = "Password: $password is incorrect."

        return binding.root
    }

    fun retryPassword() {
        findNavController().popBackStack()
    }
}