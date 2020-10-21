package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentSuperSecretBinding


class FragmentSuperSecret : Fragment() {
    private lateinit var binding: FragmentSuperSecretBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_super_secret, container, false)
        binding.binding = this

        return binding.root
    }

    fun logout() {
        // Uses global action in nav_graph
        findNavController().navigate(R.id.action_logout)
    }
}