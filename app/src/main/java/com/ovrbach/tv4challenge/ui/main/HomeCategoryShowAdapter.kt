package com.ovrbach.tv4challenge.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ovrbach.tv4challenge.data.ui.ShowItem
import com.ovrbach.tv4challenge.databinding.HomeAdapterCategoryShowItemBinding

class HomeCategoryShowAdapter(sharedViewPool: RecyclerView.RecycledViewPool) : ListAdapter<ShowItem, HomeCategoryShowAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<ShowItem>() {
            override fun areItemsTheSame(oldItem: ShowItem, newItem: ShowItem): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ShowItem, newItem: ShowItem): Boolean =
                    oldItem == newItem

        }
) {

    class ViewHolder(
            private val binding: HomeAdapterCategoryShowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ShowItem) {
            with(binding){
                image.load(item.image)
                title.text = item.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent.context).let { inflater ->
                HomeAdapterCategoryShowItemBinding.inflate(inflater, parent, false)
            }
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}