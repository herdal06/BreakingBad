package com.herdal.breakingbad.presentation.characters.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.herdal.breakingbad.utils.extensions.dpToPx

private const val ITEM_VERTICAL_MARGIN = 8
private const val ITEM_HORIZONTAL_MARGIN = 8

class CharacterItemDecorator(context: Context) : RecyclerView.ItemDecoration() {

    private val marginVertical by lazy {
        ITEM_VERTICAL_MARGIN.dpToPx(context)
    }

    private val marginHorizontal by lazy {
        ITEM_HORIZONTAL_MARGIN.dpToPx(context)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = marginHorizontal
        outRect.top = marginVertical
        outRect.bottom = marginVertical
        outRect.right = marginHorizontal
    }
}