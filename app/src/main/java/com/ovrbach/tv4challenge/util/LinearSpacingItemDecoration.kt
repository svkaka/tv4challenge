package com.ovrbach.tv4challenge.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class LinearSpacingItemDecoration(private val spacing: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildViewHolder(view).adapterPosition
        val itemCount = state.itemCount
        outRect.left = spacing
        outRect.right = spacing
        outRect.top = spacing
        outRect.bottom = if (position == itemCount - 1) spacing else 0
    }
}