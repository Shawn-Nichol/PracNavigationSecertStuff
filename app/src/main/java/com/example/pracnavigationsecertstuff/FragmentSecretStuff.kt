package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentSecretStuffBinding


class FragmentSecretStuff : Fragment() {
    private lateinit var binding: FragmentSecretStuffBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_secret_stuff, container, false)

        binding.binding = this

        return binding.root
    }

    fun logout() {

    }

    fun superSecretStuff() {
        findNavController().navigate(R.id.SuperSecret_dest)
    }
}