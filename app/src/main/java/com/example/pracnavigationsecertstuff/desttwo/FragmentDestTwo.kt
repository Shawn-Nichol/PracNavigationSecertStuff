package com.example.pracnavigationsecertstuff.desttwo

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pracnavigationsecertstuff.R
import com.example.pracnavigationsecertstuff.databinding.FragmentDestTwoBinding


class FragmentDestTwo : Fragment() {

    private lateinit var binding: FragmentDestTwoBinding

    var mAdapter = RVAdapter(dummyData())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dest_two, container, false)
        binding.binding = this




        val recyclerView = binding.rvContainer
        recyclerView.apply{
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }

        return binding.root
    }

    /**
     * Handles clicks in recyclerView.
     */
//    override fun onItemClick(position: Int, binding: FragmentDestTwoBinding) {
//        Toast.makeText(context, "RV Item $position", Toast.LENGTH_SHORT).show()
//
//        findNavController().navigate(R.id.fragmentDestTwoDetails)
//
//    }

    fun dummyData() : MutableList<Int> {
        val list: MutableList<Int> = mutableListOf()
        for(i in 0..100) list.add(i)

        return list
    }


}