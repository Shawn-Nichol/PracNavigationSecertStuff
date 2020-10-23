package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentSecretStuffBinding
import kotlinx.android.synthetic.main.fragment_secret_stuff.*


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
        findNavController().navigate(R.id.action_logout)
    }

    fun superSecretStuff() {
        val extras = FragmentNavigatorExtras(tv_super_secret_stuff to "secret_transition")
        findNavController().navigate(R.id.action_fragmentSecertStuff_to_fragmentSuperSecret, null, null, extras)
    }
}