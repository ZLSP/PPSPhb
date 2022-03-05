package com.zlsp.android.ppsphb.present.fragments.osnov

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.zlsp.android.ppsphb.R
import com.zlsp.android.ppsphb.domain.osnovania.OsnovItem

class OsnovListAdapter: ListAdapter<OsnovItem, OsnovItemViewHolder>(OsnovItemDiffCallback()) {

    var onOsnovItemClickListener: ((OsnovItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OsnovItemViewHolder {
        val layout = when(viewType) {
            VIEW_LOCKED -> R.layout.item_osnov_locked
            VIEW_OPEN -> R.layout.item_osnov_open
            else -> throw RuntimeException("Error")
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return OsnovItemViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: OsnovItemViewHolder, position: Int) {
        val osnovItem = getItem(position)
        holder.tvName.text = osnovItem.name
        holder.tvArticle.text = osnovItem.article
        holder.tvText.text = osnovItem.text
        holder.view.setOnClickListener {
            onOsnovItemClickListener?.invoke(osnovItem)
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