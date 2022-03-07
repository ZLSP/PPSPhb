package com.zlsp.android.ppsphb.present.fragments.redaction

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.domain.redaction.RedactionItem

class RedactionListAdapter: ListAdapter<RedactionItem, RedactionItemViewHolder>(RedactionDiffCallback()) {

    var onRedactionItemClickListener: ((RedactionItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedactionItemViewHolder {
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
        return RedactionItemViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: RedactionItemViewHolder, position: Int) {
        val redactionItem = getItem(position)
        holder.tvName.text = redactionItem.name
        holder.tvText.text = redactionItem.text
        holder.view.setOnClickListener {
            onRedactionItemClickListener?.invoke(redactionItem)
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