package com.example.pracnavigationsecertstuff.menu.contextual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pracnavigationsecertstuff.R
import com.example.pracnavigationsecertstuff.databinding.FragmentContextualThreeBinding


class FragmentContextualThree : Fragment() {

    private lateinit var binding: FragmentContextualThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_contextual_three, container, false)

        return binding.root
    }
}