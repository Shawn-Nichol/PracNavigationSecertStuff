package com.example.pracnavigationsecertstuff.menu.options

import android.content.Context
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pracnavigationsecertstuff.R
import com.example.pracnavigationsecertstuff.databinding.FragmentKeyframeBinding


class FragmentKeyFrame : Fragment() {

    private var TAG = "PracFragmentKey"
    private lateinit var binding: FragmentKeyframeBinding
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_keyframe, container, false)

        binding.binding = this



        return binding.root
    }

    fun animate() {
        Log.i(TAG, "animate()")

       var constraintLayout: ConstraintLayout = binding.constraintKeyframeOne
        Log.i(TAG, "animate: keyFrame one id: $constraintLayout")

        val constraintSet = ConstraintSet()
        constraintSet.load(activity, R.layout.fragment_keyframe_2)


        Log.i(TAG, "animate: keyframe two id: ${R.layout.fragment_keyframe_2}")

        // This class manages the set of transitions that fire when there is a change of Scene. Tl use the manager
        // add scenes along with transition objects with calls to setTranition.
        TransitionManager.beginDelayedTransition(constraintLayout)
        constraintSet.applyTo(constraintLayout)
    }
}