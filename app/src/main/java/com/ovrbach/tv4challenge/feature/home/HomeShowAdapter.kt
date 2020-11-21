package com.ovrbach.tv4challenge.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.memory.MemoryCache
import com.ovrbach.tv4challenge.R
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
            with(binding) {
                image.load(item.image) {
                    placeholderMemoryCacheKey(MemoryCache.Key.invoke(item.id.toString()))
                }
                title.text = item.title
                caption.text = item.caption
                body.text = item.body

                caption.isVisible = item.caption != null
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