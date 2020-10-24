package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.pracnavigationsecertstuff.databinding.FragmentDestOneBinding
import kotlinx.android.synthetic.main.fragment_dest_one.*


class FragmentDestOne : Fragment() {
    private lateinit var binding: FragmentDestOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dest_one, container, false)

        binding.binding = this

        return binding.root
    }

    fun logout() {
        findNavController().navigate(R.id.action_logout)
    }

    fun superSecretStuff() {
        val extras = FragmentNavigatorExtras(tv_destination_two to "secret_transition")
        findNavController().navigate(R.id.action_fragmentSecertStuff_to_fragmentSuperSecret, null, null, extras)
    }


}