package com.zlsp.android.ppsphb.present.fragments.polnomoch

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.domain.polnomoch.PolnomochItem

class PolnomochListAdapter: ListAdapter<PolnomochItem, PolnomochItemViewHolder>(PolnomochItemDiffCallback()) {

    var onPolnomochItemClickListener: ((PolnomochItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PolnomochItemViewHolder {
        val layout = when(viewType) {
            VIEW_LOCKED -> R.layout.item_pr_locked
            VIEW_OPEN -> R.layout.item_pr_open
            else -> throw RuntimeException("Error")
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return PolnomochItemViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: PolnomochItemViewHolder, position: Int) {
        val polnomochItem = getItem(position)
        holder.tvName.text = polnomochItem.name
        holder.tvText.text = polnomochItem.text
        holder.view.setOnClickListener {
            onPolnomochItemClickListener?.invoke(polnomochItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (!getItem(position).open)
            VIEW_LOCKED
        else
            VIEW_OPEN
    }

    companion object {
        const val VIEW_LOCKED = 100
        const val VIEW_OPEN = 101

        const val MAX_POOL_SIZE = 30
    }
}