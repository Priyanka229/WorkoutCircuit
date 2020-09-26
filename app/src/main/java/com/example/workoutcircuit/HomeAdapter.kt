package com.example.workoutcircuit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutcircuit.databinding.ListItemBinding
import kotlinx.android.synthetic.main.list_item.view.*

class HomeAdapter : ListAdapter<CircuitsData, HomeAdapter.CircuitViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CircuitViewHolder {
        val circuitItemBinding: ListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item, parent, false
        )
        return CircuitViewHolder(circuitItemBinding.root)
    }

    override fun onBindViewHolder(holder: CircuitViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

     inner class CircuitViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView),
        View.OnLongClickListener, View.OnClickListener {

        fun bind(circuitsData: CircuitsData, position: Int) {
            itemView.list_item.text = circuitsData.title
        }

        override fun onLongClick(v: View?): Boolean {
            return true
        }

        override fun onClick(v: View?) {
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CircuitsData>() {
        override fun areContentsTheSame(oldItem: CircuitsData, newItem: CircuitsData) = oldItem == newItem
        override fun areItemsTheSame(oldItem: CircuitsData, newItem: CircuitsData) = oldItem.title == newItem.title
    }
}