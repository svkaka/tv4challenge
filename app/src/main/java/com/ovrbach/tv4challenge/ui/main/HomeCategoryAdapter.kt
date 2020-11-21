package com.ovrbach.tv4challenge.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ovrbach.tv4challenge.data.ui.CategoryItem
import com.ovrbach.tv4challenge.databinding.HomeAdapterCategoryItemBinding

class HomeCategoryAdapter(private val sharedViewPool: RecyclerView.RecycledViewPool) : ListAdapter<CategoryItem, HomeCategoryAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<CategoryItem>() {
            override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean =
                    oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean =
                    oldItem == newItem

        }
) {

    inner class ViewHolder(
            private val binding: HomeAdapterCategoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val adapter = HomeCategoryShowAdapter(sharedViewPool)

        init {
            with(binding) {
                shows.layoutManager = LinearLayoutManager(
                        binding.root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )

                shows.setRecycledViewPool(sharedViewPool)
                shows.adapter = adapter
            }

        }

        fun bind(item: CategoryItem) {
            binding.name.text = item.name
            adapter.submitList(item.shows)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent.context).let { inflater ->
                HomeAdapterCategoryItemBinding.inflate(inflater, parent, false)
            }
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}