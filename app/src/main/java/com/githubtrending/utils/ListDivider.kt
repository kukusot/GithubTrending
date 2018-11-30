package com.githubtrending.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.githubtrending.R

class ListDivider(context: Context) : RecyclerView.ItemDecoration() {

    private val itemOffSet = context.resources.getDimensionPixelSize(R.dimen.list_divider_size)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.apply {
            top = itemOffSet
            bottom = itemOffSet
            left = itemOffSet
            right = itemOffSet
        }
    }

}