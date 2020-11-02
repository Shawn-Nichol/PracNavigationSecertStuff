package com.example.pracnavigationsecertstuff.menu.options

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pracnavigationsecertstuff.R
import com.example.pracnavigationsecertstuff.databinding.FragmentMenuPlaceholderBinding
import kotlinx.android.synthetic.main.fragment_menu_placeholder.*


class FragmentMenuPlaceHolder : Fragment() {

    private lateinit var binding: FragmentMenuPlaceholderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu_placeholder, container, false)
        binding.binding = this


        return binding.root
    }

    fun swapViews(view: View) {
        TransitionManager.beginDelayedTransition(binding.constraint)
        place_holder.setContentId(view.id)
    }
}