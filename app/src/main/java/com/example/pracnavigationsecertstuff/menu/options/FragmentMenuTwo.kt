package com.example.pracnavigationsecertstuff.menu.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pracnavigationsecertstuff.R
import com.example.pracnavigationsecertstuff.databinding.FragmentMenuTwoBinding


class FragmentMenuTwo : Fragment() {

    private lateinit var binding: FragmentMenuTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu_two, container, false)

        return binding.root
    }
}