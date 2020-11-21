package com.ovrbach.tv4challenge.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ovrbach.tv4challenge.model.ui.ShowItem
import com.ovrbach.tv4challenge.databinding.HomeAdapterShowItemBinding

class HomeShowAdapter() : ListAdapter<ShowItem, HomeShowAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<ShowItem>() {
            override fun areItemsTheSame(oldItem: ShowItem, newItem: ShowItem): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ShowItem, newItem: ShowItem): Boolean =
                    oldItem == newItem
        }
) {

    class ViewHolder(
            private val binding: HomeAdapterShowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShowItem) {
            with(binding){
                image.load(item.image)
                title.text = item.title
                description.text = item.description
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent.context).let { inflater ->
                HomeAdapterShowItemBinding.inflate(inflater, parent, false)
            }
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}