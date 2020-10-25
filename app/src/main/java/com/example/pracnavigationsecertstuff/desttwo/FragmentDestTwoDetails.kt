package com.example.pracnavigationsecertstuff.desttwo

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pracnavigationsecertstuff.R
import com.example.pracnavigationsecertstuff.databinding.FragmentDestTwoDetailsBinding


class FragmentDestTwoDetails : Fragment() {

    private lateinit var binding: FragmentDestTwoDetailsBinding

    var name: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = arguments?.getInt("userName") ?: -1
        Toast.makeText(context, "Details rv item $name", Toast.LENGTH_SHORT).show()

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dest_two_details, container, false)

        binding.tvDestTwoItemDetails.text = name.toString()

        return binding.root
    }
}