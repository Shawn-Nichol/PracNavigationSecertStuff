package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentFailedLoginBinding


class FragmentFailedLogin : Fragment() {

    private lateinit var binding: FragmentFailedLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_failed_login, container, false)

        binding.binding = this

        return binding.root
    }

    fun retryPassword() {
        findNavController().popBackStack()
    }
}