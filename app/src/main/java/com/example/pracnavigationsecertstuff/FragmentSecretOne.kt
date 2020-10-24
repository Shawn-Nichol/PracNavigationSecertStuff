package com.example.pracnavigationsecertstuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pracnavigationsecertstuff.databinding.FragmentSecretOneBinding


class FragmentSecretOne : Fragment() {

    lateinit var binding: FragmentSecretOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_secret_one, container, false)

        return binding.root
    }
}