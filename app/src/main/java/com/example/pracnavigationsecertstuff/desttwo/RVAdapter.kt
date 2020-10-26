package com.example.pracnavigationsecertstuff.desttwo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.pracnavigationsecertstuff.R

class RVAdapter(private var dataSet: MutableList<Int>) :
    RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val tv: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.tv.text = item.toString()
        holder.tv.transitionName = item.toString()

        holder.tv.setOnClickListener {
            val bundle = bundleOf("userName" to dataSet[position])
            val extras = FragmentNavigatorExtras(holder.tv to "rv_transition")
            Navigation.findNavController(holder.tv).navigate(R.id.action_desttwo_to_desttwo_details, bundle, null, extras)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}


